package com.dataup.dc.api.service;


import java.util.List;

import com.dataup.dc.api.bean.Pagination;
import com.dataup.dc.api.entity.AuditTaskDetailsEntity;
import com.dataup.dc.api.entity.AuditTaskEntity;
import com.dataup.dc.api.entity.AuditTasksPaysEntity;
import com.dataup.dc.api.entity.BillingDetails;
import com.dataup.dc.api.entity.CCChargeHisEntity;
import com.dataup.dc.api.entity.MapAuditTaskEntity;
import com.dataup.dc.api.entity.MapOfCity;

 

/**
 * 
 * @ClassName: CccReportService 
 * @Description: 客户中心-我的项目 -报表统计
 * @author zhanqiao.huang
 * @date 2015年9月21日 下午1:44:23
 */
public interface CccReportService {

 
	/**
	 * 
	 * @Title: queryAuditTaskTotalByZone 
	 * @Description: 按区域统计-不同任务状态的任务总数
	 * @param @param pageNo
	 * @param @param pageSize
	 * @param @return
	 * @param @throws Exception 设定文件 
	 * @return Pagination 返回类型 
	 * @throws
	 */
	public Pagination queryAuditTaskTotalByZone(AuditTaskEntity auditTaskEntity, int start,int limit, String sortName, String sortOrder) throws Exception;
	
	
	/**
	 * 
	 * @Title: queryAuditTaskTotalByClassis 
	 * @Description: 按任务类别-不同任务状态的任务总数
	 * @param @param pageNo
	 * @param @param pageSize
	 * @param @return
	 * @param @throws Exception 设定文件 
	 * @return Pagination 返回类型 
	 * @throws
	 */
	public Pagination queryAuditTaskTotalByClassis(AuditTaskEntity auditTaskEntity, int start,int limit, String sortName, String sortOrder) throws Exception;
	
	
	/**
	 * 
	 * @Title: queryBaseTaskCount 
	 * @Description: 查询所有的任务数
	 * @param @param baseTaskEntity
	 * @param @return
	 * @param @throws Exception 设定文件 
	 * @return BaseTaskEntity 返回类型 
	 * @throws
	 */
	public AuditTaskEntity queryAuditTaskTotal(AuditTaskEntity baseTaskEntity) throws Exception;
	
	/**
	 * 
	 * @Title: queryAuditTaskDetails 
	 * @Description: 某一类任务详情（eg:区域、任务类别）
	 * @param @param auditTaskDetailsEntity
	 * @param @param start
	 * @param @param limit
	 * @param @param sortName
	 * @param @param sortOrder
	 * @param @return
	 * @param @throws Exception 设定文件 
	 * @return Pagination 返回类型 
	 * @throws
	 */
	public Pagination queryAuditTaskDetails(AuditTaskDetailsEntity auditTaskDetailsEntity, int start,int limit, String sortName, String sortOrder) throws Exception;
	 
	/**
	 * 
	 * @Title: showMapAuditTasks 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param mapAuditTaskEntity
	 * @param @return
	 * @param @throws Exception 设定文件 
	 * @return List<MapAuditTaskEntity> 返回类型 
	 * @throws
	 */
	public List<MapAuditTaskEntity> showMapAuditTasks(MapAuditTaskEntity mapAuditTaskEntity) throws Exception;
	
	
 
	/**
	 * 
	 * @Title: queryTasksPays 
	 * @Description: 支出记录
	 * @param @param auditTasksPaysEntity
	 * @param @return
	 * @param @throws Exception 设定文件 
	 * @return List<AuditTasksPaysEntity> 返回类型 
	 * @throws
	 */
	public Pagination queryTasksPays(AuditTasksPaysEntity auditTasksPaysEntity, int start,int limit, String sortName, String sortOrder,String queryType) throws Exception;
	
	
	
	/**
	 * 
	 * @Title: queryChargeHis 
	 * @Description: 充值记录
	 * @param @param cCChargeHisEntity
	 * @param @param start
	 * @param @param limit
	 * @param @param sortName
	 * @param @param sortOrder
	 * @param @return
	 * @param @throws Exception 设定文件 
	 * @return Pagination 返回类型 
	 * @throws
	 */
	public Pagination queryChargeHis(CCChargeHisEntity cCChargeHisEntity, int start,int limit, String sortName, String sortOrder) throws Exception;
	
	/**
	 * 
	 * @Title: queryMapProvincialOrCity 
	 * @Description: 查询项目任务地图所有的省或者城市
	 * @param @param mapOfCity
	 * @param @return
	 * @param @throws Exception 设定文件 
	 * @return List<MapOfCity> 返回类型 
	 * @throws
	 */
	public List<MapOfCity> queryMapProvincialOrCity(MapOfCity mapOfCity) throws Exception;
	
	/**
	 * 
	 * @Title: queryProjectBillingDetails 
	 * @Description: 查询项目账单详情
	 * @param @param billingDetails
	 * @param @return
	 * @param @throws Exception 设定文件 
	 * @return List<BillingDetails> 返回类型 
	 * @throws
	 */
	public Pagination queryProjectBillingDetails(BillingDetails billingDetails, int start,int limit, String sortName, String sortOrder) throws Exception;
	
	 
}
