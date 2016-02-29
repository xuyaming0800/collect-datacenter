package cn.dataup.datacenter.service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dataup.datacenter.dao.UserTaskDao;
import cn.dataup.datacenter.entity.RegsUserDateUp;
import cn.dataup.datacenter.entity.RegsUserInfo;
import cn.dataup.datacenter.entity.UserTaskDetail;

/**
 * 
 * @ClassName: UserTaskService
 * @Description: 用户维度-服务层
 * @author zhanqiao.huang huangzhanqiao@dataup.cn
 * @date 2015年6月25日 上午11:24:24
 */

@Service
public class UserTaskService {

	public List<UserTaskDetail> fecthUserCollectQty() {
		List<UserTaskDetail> collectUsers = userTaskDao.fecthUserCollectQty();
		return collectUsers;
	}

	/**
	 * @Description: 查询时间段内的注册用户信息
	 * @author 刘旭升
	 * @date 2015年7月9日 下午1:13:51
	 * @version V1.0
	 * @param beforeDateInteger
	 *            开始时间
	 * @param nowDateInteger
	 *            结束时间
	 * @return
	 * @throws ParseException
	 */
	public Map<String, Object> findUserRegsIdsByYearMonthDate(
			String beforeDateInteger, String nowDateInteger) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 1.构建查询条件
		Integer before = Integer.parseInt(beforeDateInteger);
		Integer now = Integer.parseInt(nowDateInteger);
		// 2.查询时间段的信息
		List<RegsUserDateUp> regsUserDateUpList = this.userTaskDao
				.findUserRegsIdByTime(before, now);
		/*
		 * // 4.查询明细 if (regsUserDateUpList != null && regsUserDateUpList.size()
		 * > 0) { for (RegsUserDateUp rud : regsUserDateUpList) { // 封装明细集合进对象
		 * List<RegsUserInfo> regsUserInfoList = this.userTaskDao
		 * .findRegsUserInfoListByKey(rud.getUserRegsKye());
		 * rud.setUserRegsList(regsUserInfoList); } }
		 */
		map.put("regsUserDateUpList", regsUserDateUpList);// 时间+当时的注册用户对象
		return map;
	}
	
	/**
	 * @Description: 查询指定的用户集合
	 * @author 刘旭升
	 * @date 2015年7月9日 下午7:03:21 
	 * @version V1.0 
	 * @param dcUserRegsKey key值
	 * @return
	 */
	public List<RegsUserInfo> findRegsUserInfoByKey(Integer dcUserRegsKey) {
		return this.userTaskDao.findRegsUserInfoListByKey(dcUserRegsKey);
	}

	@Autowired
	private UserTaskDao userTaskDao;

	// private Logger logger = LogManager.getLogger(getClass());
}
