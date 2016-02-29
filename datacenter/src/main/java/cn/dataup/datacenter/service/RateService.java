package cn.dataup.datacenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dataup.datacenter.dao.RateDao;
import cn.dataup.datacenter.entity.ReportAuditRate;

/**
 * 
 * @ClassName: RateService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author zhanqiao.huang
 * @date 2015年8月12日 上午10:18:32
 */
@Service
public class RateService {

	// private Logger logger = LogManager.getLogger(getClass());
	@Autowired
	private RateDao rateDao;
	
	public List<ReportAuditRate> queryAuditRate(String systemtype) {
		List<ReportAuditRate> listAuditRate = rateDao.queryAuditRate(systemtype);
		return listAuditRate;
	}

	public List<ReportAuditRate> queryMonthAuditRate(String systemtype) {
		List<ReportAuditRate> listMonthAuditRate = rateDao.queryMonthAuditRate(systemtype);
		return listMonthAuditRate;
	}
}
