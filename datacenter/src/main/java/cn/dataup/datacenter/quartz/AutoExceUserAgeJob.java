package cn.dataup.datacenter.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import cn.dataup.datacenter.holder.ContextHolder;
import cn.dataup.datacenter.service.DCJobService;


/**
 * 
 * @ClassName: AutoExceUserAgeJob 
 * @Description: 用户年龄job 
 * @author zhanqiao.huang
 * @date 2015年8月5日 上午11:49:13
 */
public class AutoExceUserAgeJob extends QuartzJobBean {
	
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		try {
			DCJobService dcJobService=ContextHolder.getApplicationContext().getBean(DCJobService.class);
			dcJobService.updateUserAgeByIdCard();
		} catch (Exception e) {
		}
		
	}
 

}
