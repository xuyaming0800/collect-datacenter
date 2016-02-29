package cn.dataup.datacenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dataup.datacenter.dao.MapTaskDao;
import cn.dataup.datacenter.entity.MapTask;

/**
 * 
 * @ClassName: RateService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author zhanqiao.huang
 * @date 2015年8月12日 上午10:18:32
 */
@Service("mapTaskService")
public class MapTaskService {

	// private Logger logger = LogManager.getLogger(getClass());
	@Autowired
	private MapTaskDao mapTaskDao;
	
	public List<MapTask> queryAudited(int status,int system) {
		List<MapTask> list = mapTaskDao.queryAudited(status,system);
		return list;
	}

	public List<MapTask> queryAuditing(int status,int system) {
		List<MapTask> list = mapTaskDao.queryAuditing(status,system);
		return list;
	}
	
	public List<MapTask> queryAudit(int status,int system) {
		List<MapTask> list = null;
		if(status==1){
			list= queryAuditing(status,system);
		}else{
			list= queryAudited(status,system);
		}
		return list;
	}
}
