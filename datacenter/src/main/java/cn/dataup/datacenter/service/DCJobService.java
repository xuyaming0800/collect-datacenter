package cn.dataup.datacenter.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.QueryOperators;

import cn.dataup.datacenter.dao.JobDao;
import cn.dataup.datacenter.dao.RateDao;
import cn.dataup.datacenter.entity.JobUserInfo;
import cn.dataup.datacenter.util.CalcAgeIDCard;
import cn.dataup.datacenter.util.HttpClientUtil;
import cn.dataup.datacenter.util.IdcardUtils;
import cn.dataup.datacenter.util.PropConstants;
import cn.dataup.datacenter.util.PropertiesConfig;

@Service
public class DCJobService {
	private Logger logger = LogManager.getLogger(getClass());

	@Autowired
	private JobDao jobDao = null;

	@Autowired
	private RateDao rateDao = null;

	@Autowired
	private MongoTemplate mongoTemplate = null;

	public void updateUserWhereCity() {
		List<JobUserInfo> list = jobDao.queryJobMobileUserRegs();
		String taobao_url = PropertiesConfig
				.getProperty(PropConstants.GET_USER_WHERE_CITY_BY_TEL);
		int timer = 0;
		Map<String, String> postMap = new HashMap<String, String>();
		try {
			if (list.size() > 0) {
				for (JobUserInfo u : list) {
					if (timer == 500)
						break;
					if (!StringUtils.isBlank(u.getMobile())) {
						postMap.put("tel", u.getMobile());
						String city = HttpClientUtil.post(taobao_url, postMap,
								"UTF-8");
						if (!StringUtils.isBlank(city)) {
							if (city.indexOf("province") > 0
									&& city.indexOf("catName") > 0) {
								city = city.substring(
										city.lastIndexOf("province") + 9,
										city.indexOf("catName")).split(",")[0];
								city = city.substring(1, city.length() - 1);
								jobDao.updateUserWhereCity(city, u.getMobile(),
										u.getName());
								timer++;
							}
						}
					}
				}
			}
			logger.info("更新" + timer + "个用户所在地。");
			System.out.println("更新" + timer + "个用户所在地。");
		} catch (Exception e) {
		}

	}

	public void updateUserAgeByIdCard() {
		List<JobUserInfo> list = jobDao.queryJobUserIdCard();
		int timer = 0;
		try {
			if (list.size() > 0) {
				for (JobUserInfo u : list) {
					if (timer == 500)
						break;
					String idCard = u.getIdcard();
					if (StringUtils.isNotBlank(idCard)) {
						if (IdcardUtils.validateCard(idCard)) {
							int age = CalcAgeIDCard.getAge(idCard);
							if (StringUtils.isNotBlank(u.getName())) {
								jobDao.updateUserAgeByIdCard(age, u.getName());
								timer++;
							}
						}
					}
				}
			}
			logger.info("更新" + timer + "个用户年龄。");
			System.out.println("更新" + timer + "个用户年龄。");
		} catch (Exception e) {
		}

	}

	public void updateAuditRate() {
		// insertMonth();
		System.out.println("====================================");
		rateDao.updateAuditRate();
		rateDao.updateAuditRate1();
		rateDao.updateAuditRate2();
		rateDao.updateAuditRate3();
		rateDao.updateAuditRate4();
		rateDao.updateAuditRate5();
		rateDao.updateAuditRate6();
	}

	public void getXY() {
		DBCollection dbcoll = mongoTemplate.getDb().getCollection(
				"collect_audit_attr");
		BasicDBObject queryObject = new BasicDBObject().append(
				QueryOperators.OR, new BasicDBObject[] {
						new BasicDBObject("collectClassName", "小区"),
						new BasicDBObject("collectClassName", "广告监测") });
		DBCursor cur = dbcoll.find(queryObject);
		System.out.println(cur.count());
		int i = 0;
		while (cur.hasNext()) {
			i++;
			DBObject dbObject = cur.next();
			String taskId = null;
			if (dbObject.containsField("baseId")) {
				taskId = (String) dbObject.get("baseId");
			}
			System.out.println("任务" + i + "->" + taskId);
			// if (dbObject.containsField("collectClassName")) {
			// String collectClassName = (String) dbObject
			// .get("collectClassName");
			// }
			if (dbObject.containsField("attrList")) {
				List<Map<?, ?>> attrList = (List<Map<?, ?>>) dbObject
						.get("attrList");
				if (dbObject.containsField("attrs")) {
					Map<?, ?> attrs = (Map<?, ?>) dbObject.get("attrs");
					// System.out.println(attrs);
					for (Map<?, ?> attr : attrList) {
						String level = (String) attr.get("level");
						if (level.contains(".")) {
							level = level.split("\\.")[1];
							Object obj = attrs.get(level);
							if (obj instanceof Map<?, ?>) {
								Map<?, ?> levelTwo = (Map<?, ?>) obj;
								if (levelTwo.containsKey("imgs")) {
									Object objLevelTwo = levelTwo.get("imgs");
									if (objLevelTwo instanceof List) {
										List<Map<?, ?>> imgs = (List<Map<?, ?>>) objLevelTwo;
										for (Map<?, ?> img : imgs) {
											String lat = (String) img.get("lat");
											String lon = (String) img.get("lon");
											int num=jobDao.isExistTaskPoints(taskId, lat, lon);
											if(num>0) continue;
											jobDao.insertTaskPoints(taskId, lat, lon);
											System.out.println("任务ID:" + taskId+ ";X=" + lat+ ";Y=" + lon);
										}
									}
								}
							}
						}
					}
				}

			}
		}

		// 查询条件
		// BasicDBObject query = new BasicDBObject();
		// query.put("baseId", bid);
		// int count=(int) dbcoll.getCount();
		// System.out.println(count);
		// // 查询
		// DBObject dbObject = dbcoll.findOne();
		//
		// if(dbObject!=null){
		// // 得到结果
		// Map<?, ?> map = dbObject.toMap();
		// }
	}

	public static void main(String[] args) {
		// System.out.println(DateUtils.yyyy_mm.format(new Date()));
		// try {
		// Map<String, String> pushMap = new HashMap<String, String>();
		// pushMap.put("tel", "17096838311");
		// String str = HttpClientUtil.post(
		// "http://tcc.taobao.com/cc/json/mobile_tel_segment.htm",
		// pushMap, "UTF-8");
		// if (!StringUtils.isBlank(str)) {
		// if (str.indexOf("province") > 0 && str.indexOf("catName") > 0) {
		// str = str.substring(str.lastIndexOf("province") + 9,
		// str.indexOf("catName")).split(",")[0];
		// str = str.substring(1, str.length() - 1);
		// }
		// System.out.println(str);
		// }
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		String str = "attrs.小区入口1";
		String[] le = str.split(".");
		for (int i = 0; i < le.length; i++) {
			System.out.println(le[i]);
		}

	}
}
