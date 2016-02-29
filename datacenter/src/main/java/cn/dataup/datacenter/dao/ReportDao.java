package cn.dataup.datacenter.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.dataup.datacenter.base.mybatis.annotation.MyBatisRepository;
import cn.dataup.datacenter.entity.RegsUserInfo;
import cn.dataup.datacenter.entity.ReportDayUserRegs;
import cn.dataup.datacenter.entity.ReportSubmitTask;
import cn.dataup.datacenter.entity.ReportSubmitTasksClass;
import cn.dataup.datacenter.entity.ReportUserCollectTasks;

/**
 * 
 * @ClassName: ReportDao 
 * @Description: 报表-dao
 * @author zhanqiao.huang
 * @date 2015年7月17日 下午5:40:22
 */

@MyBatisRepository
public interface ReportDao {

	

	/**
	 * 
	 * @Title: queryReportDayUserRegs 
	 * @Description: 用户注册数（日） 
	 * @param @return 设定文件 
	 * @return List<ReportDayUserRegs> 返回类型 
	 * @throws
	 */
	List<ReportDayUserRegs> queryReportDayUserRegs(@Param("start") int start, @Param("size") int size);
	/**
	 * 
	 * @Title: queryReportMonthUserRegs 
	 * @Description: 用户注册数（月） 
	 * @param @param start
	 * @param @param size
	 * @param @return 设定文件 
	 * @return List<ReportDayUserRegs> 返回类型 
	 * @throws
	 */
	List<ReportDayUserRegs> queryReportMonthUserRegs(@Param("start") int start, @Param("size") int size);
	/**
	 * 
	 * @Title: queryReportAllUserRegs 
	 * @Description: 用户注册数（所有） 
	 * @param @return 设定文件 
	 * @return List<ReportDayUserRegs> 返回类型 
	 * @throws
	 */
	List<ReportDayUserRegs> queryReportAllUserRegs();
	
	/**
	 * 
	 * @Title: queryReportWhereUserRegs 
	 * @Description: 用户所在地 
	 * @param @return 设定文件 
	 * @return List<RegsUserInfo> 返回类型 
	 * @throws
	 */
	List<RegsUserInfo> queryReportWhereUserRegs(@Param("start") int start, @Param("size") int size,@Param("userName") String userName);
	int queryUserRegsPageCount(@Param("userName") String userName);
	List<ReportDayUserRegs> queryReportDayUserRegsExcel();
	int queryReportUserRegsTotal();
	int queryReportUserRegsCount();
	int queryReportMonthUserRegsCount();
	/**
	 * 
	 * @Title: queryReportDayUserCollectTasks 
	 * @Description: 查询
	 * @param @param start
	 * @param @param size
	 * @param @param qDate
	 * @param @return 设定文件 
	 * @return List<ReportUserCollectTasks> 返回类型 
	 * @throws
	 */
	List<ReportUserCollectTasks> queryReportDayUserCollectTasks(@Param("start") int start, @Param("size") int size,@Param("userName") String userName, @Param("systemtype") String systemtype);
	
	List<ReportUserCollectTasks> queryReportDayUserDefindCollectTasks(@Param("start") int start, @Param("size") int size,@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("userName") String userName,@Param("systemtype") String systemtype);
	
	/**
	 * 
	 * @Title: queryReportDayUserCollectTasksExcel 
	 * @Description: excel导出
	 * @param @param qDate
	 * @param @return 设定文件 
	 * @return List<ReportUserCollectTasks> 返回类型 
	 * @throws
	 */
	List<ReportUserCollectTasks> queryReportDayUserCollectTasksExcel(@Param("qDate") String qDate);
	
	List<ReportUserCollectTasks> queryReportUserCollectTasksExcel(@Param("qDate") String qDate);
	List<ReportUserCollectTasks> queryReportUserCollectTasks(@Param("start") int start, @Param("size") int size,@Param("qDate") String qDate);
	
	List<ReportUserCollectTasks> queryReportDayCollectTasks(@Param("start") int start, @Param("size") int size,@Param("systemtype") String systemtype);

	List<ReportUserCollectTasks> queryReportDaySelfCollectTasks(@Param("start") int start, @Param("size") int size,@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("systemtype") String systemtype);
	List<ReportUserCollectTasks> queryReportDayCollectTasksExcel(@Param("qDate") String qDate);
	
	List<ReportUserCollectTasks> queryReportCollectTasks(@Param("start") int start, @Param("size") int size);
	List<ReportUserCollectTasks> queryReportDefinedCollectTasks(@Param("start") int start, @Param("size") int size,@Param("startDate") String startDate,@Param("endDate") String endDate);
	
	List<ReportUserCollectTasks> queryReportCollectTasksExcel(@Param("qDate") String qDate);
	
	List<ReportSubmitTasksClass> queryReportSubmitTasksClass(@Param("start") int start, @Param("size") int size);
	
	
	
	List<ReportSubmitTasksClass> queryReportDaySubmitTasksClass(@Param("start") int start, @Param("size") int size);
	List<ReportSubmitTasksClass> queryReportMonthSubmitTasksClass(@Param("start") int start, @Param("size") int size);
	List<ReportSubmitTasksClass> queryReportDaySelfSubmitTasksClass(@Param("start") int start, @Param("size") int size,@Param("startDate") String startDate,@Param("endDate") String endDate);
	List<ReportSubmitTasksClass> queryReportSubmitTasksClassExcel(@Param("qDate") String qDate);
	List<ReportSubmitTasksClass> queryReportDaySubmitTasksClassExcel(@Param("qDate") String qDate);
	
	
	List<RegsUserInfo> queryReportUserWhereCity(@Param("start") int start, @Param("size") int size);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	List<ReportSubmitTask> queryReportDayUserSubmitTasks(@Param("start") int start, @Param("size") int size,@Param("userName") String userName,@Param("systemtype") String systemtype);
	List<ReportSubmitTask> queryReportDayALLUserSubmitTasks(@Param("start") int start, @Param("size") int size,@Param("userName") String userName,@Param("systemtype") String systemtype);
	List<ReportSubmitTask> queryReportMonthUserSubmitTasks(@Param("start") int start, @Param("size") int size,@Param("userName") String userName,@Param("systemtype") String systemtype);
	List<ReportSubmitTask> queryReportDefineSelfUserSubmitTasks(@Param("start") int start, @Param("size") int size,@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("userName") String userName,@Param("systemtype") String systemtype);
	
	
	
	List<ReportSubmitTask> queryReportDayDataSubmitTasks(@Param("start") int start, @Param("size") int size, @Param("systemtype") String systemtype);
	List<ReportSubmitTask> queryReportDayALLDataSubmitTasks(String systemtype);
	List<ReportSubmitTask> queryReportMonthDataSubmitTasks(@Param("start") int start, @Param("size") int size, @Param("systemtype") String systemtype);
	List<ReportSubmitTask> queryReportSelfDataSubmitTasks(@Param("start") int start, @Param("size") int size,@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("systemtype") String systemtype);
	
}
