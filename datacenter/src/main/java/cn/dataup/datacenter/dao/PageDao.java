package cn.dataup.datacenter.dao;


import org.apache.ibatis.annotations.Param;
import cn.dataup.datacenter.base.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface PageDao {

	int queryPageCount(@Param("tableName") String tableName,@Param("sWhere") String sWhere);

	//用户维度-提交状态-（天、用户）
	int queryReportDayUserSubmitTasksCount(@Param("userName") String userName,@Param("systemtype") String systemtype);
	//用户维度-提交状态-（月、用户）
	int queryReportMonthUserSubmitTasksCount(@Param("userName") String userName,@Param("systemtype") String systemtype);
	//用户维度-提交状态-（所有、用户）
	int queryReportDayALLUserSubmitTasksCount(@Param("userName") String userName,@Param("systemtype") String systemtype);
	int queryReportDefineSelfUserSubmitTasksCount(@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("userName") String userName,@Param("systemtype") String systemtype);
	int queryReportUserWhereCityCount();
	//用户维度-审核明细-每天
	int queryReportDayUserCollectTasksCount(@Param("userName") String userName,@Param("systemtype") String systemtype);
	//用户维度-审核明细-自定
	int queryReportDayUserDefindCollectTasksCount(@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("userName") String userName,@Param("systemtype") String systemtype);

	//审核明细-data-day
	int queryReportDayCollectTasksCount(@Param("systemtype") String systemtype);
	//审核明细-data-dayself
	int queryReportDaySelfCollectTasksCount(@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("systemtype") String systemtype);
	//数据维度-任务类别-day
	int queryReportDaySubmitTasksClassCount();
	//数据维度-任务类别-dayall
//	int queryReportSubmitTasksClassCount();
	//数据维度-任务类别-month
	int queryReportMonthSubmitTasksClassCount();
	//数据维度-任务类别-self
	int queryReportDaySelfSubmitTasksClassCount(@Param("startDate") String startDate,@Param("endDate") String endDate);
	
	
	//数据维度-提交状态-(天、数据)
	int  queryReportDayDataSubmitTasksCount(@Param("systemtype") String systemtype);
	int queryReportMonthDataSubmitTasksCount(@Param("systemtype") String systemtype);
	int queryReportSelfDataSubmitTasksCount(@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("systemtype") String systemtype);
	
}
