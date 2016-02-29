package cn.dataup.datacenter.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import cn.dataup.datacenter.holder.ContextHolder;
import cn.dataup.datacenter.service.DCJobService;

/**
 * 
 * @ClassName: AutoExceAuditRateJob
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhanqiao.huang
 * @date 2015年8月20日 下午5:19:22
 */
public class AutoExceAuditRateJob extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		try {
			DCJobService dcJobService = ContextHolder.getApplicationContext()
					.getBean(DCJobService.class);
			dcJobService.updateAuditRate();
		} catch (Exception e) {
		}

	}

	public static void main(String[] args) {
		DCJobService dcJobService = ContextHolder.getApplicationContext()
				.getBean(DCJobService.class);
		dcJobService.updateAuditRate();
	}

}
