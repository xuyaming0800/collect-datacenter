package cn.dataup.datacenter.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import cn.dataup.datacenter.holder.ContextHolder;
import cn.dataup.datacenter.service.DCJobService;


/**
 * 
 * @ClassName: AutoExceUserWhereJob 
 * @Description: 用户所有地-用户分布
 * @author zhanqiao.huang
 * @date 2015年8月3日 下午5:59:50
 */
public class AutoExceUserWhereJob extends QuartzJobBean {
	
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		try {
			DCJobService dcJobService=ContextHolder.getApplicationContext().getBean(DCJobService.class);
			dcJobService.updateUserWhereCity();
		} catch (Exception e) {
		}
		
	}

}
