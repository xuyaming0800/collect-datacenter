package com.dataup.dc.core.dao;

import org.springframework.stereotype.Repository;

import com.dataup.dc.api.entity.AuditTaskDetailsEntity;
import com.dataup.dc.api.entity.AuditTaskEntity;
import com.dataup.dc.api.entity.AuditTasksPaysEntity;
import com.dataup.dc.api.entity.BillingDetails;
import com.dataup.dc.api.entity.CCChargeHisEntity;
import com.dataup.dc.api.entity.MapAuditTaskEntity;
import com.dataup.dc.api.entity.MapOfCity;
import com.dataup.dc.core.util.StringUtil;

import autonavi.online.framework.sharding.entry.aspect.annotation.Author;
import autonavi.online.framework.sharding.entry.aspect.annotation.Select;
import autonavi.online.framework.sharding.entry.aspect.annotation.Shard;
import autonavi.online.framework.sharding.entry.aspect.annotation.SqlParameter;
import autonavi.online.framework.sharding.entry.entity.CollectionType;

/**
 * 
 * @ClassName: CccReportDao
 * @Description: 客户中心-我的项目 -报表统计-dao
 * @author zhanqiao.huang
 * @date 2015年9月21日 下午2:50:23
 */
@Repository
public class CccReportDao {

	@Author("zhanqiao.huang")
	@Shard(indexName = "cc_item_id_index", indexColumn = "auditTaskEntity.system_type")
	@Select(collectionType = CollectionType.beanList, resultType = AuditTaskEntity.class)
	public Object queryAuditTaskTotalByZone(
			@SqlParameter("auditTaskEntity") AuditTaskEntity auditTaskEntity,
			@SqlParameter("sortName") String sortName,
			@SqlParameter("sortOrder") String sortOrder,
			@SqlParameter("skip") int skip, @SqlParameter("size") int size) {
		String sql = "SELECT AREA,start_time_ AS start_time,"
				+ "  system_type,ifnull(payamt,0.00) payamt,sall,"
				+ "  s2 AS auditing,s3 AS auditSuccess,"
				+ "  (%s) AS total,"
				+ "  s4 AS auditFall FROM  ccc_dimzone_task_status a where 1=1";
		String totalSql=queryTaskTotalWhereSqL(auditTaskEntity,"SELECT ifnull(SUM(payamt),0.00) FROM ccc_dimzone_task_status a where 1=1");
		sql=String.format(sql,totalSql);
		sql= queryTaskTotalWhereSqL(auditTaskEntity, sql)
				+ " order by ${sortName} ${sortOrder} limit " + skip + ","
				+ size;
		return  sql;

	}

	@Author("zhanqiao.huang")
	@Shard(indexName = "cc_item_id_index", indexColumn = "auditTaskEntity.system_type")
	@Select(collectionType = CollectionType.beanList, resultType = AuditTaskEntity.class)
	public Object queryAuditTaskTotalByClassis(
			@SqlParameter("auditTaskEntity") AuditTaskEntity auditTaskEntity,
			@SqlParameter("sortName") String sortName,
			@SqlParameter("sortOrder") String sortOrder,
			@SqlParameter("skip") int skip, @SqlParameter("size") int size) {
		String sql = "SELECT b.type AS classis,task_type AS classisId,start_time_ AS start_time,"
				+ "  system_type,ifnull(payamt,0.00) payamt,sall,"
				+ "  s2 AS auditing, s3 AS auditSuccess,"
				+ "  (%s) AS total,"
				+ "  s4 AS auditFall FROM  ccc_dimclass_task_status a INNER join dim_task_class b on a.task_type=b.id ";
		String totalSql=queryTaskTotalWhereSqL(auditTaskEntity,"SELECT ifnull(SUM(payamt),0.00) FROM ccc_dimclass_task_status a INNER join dim_task_class b on a.task_type=b.id ");
		sql= String.format(sql,totalSql);
		System.out.println(totalSql);
		sql= queryTaskTotalWhereSqL(auditTaskEntity, sql)
				+ " order by ${sortName} ${sortOrder} limit " + skip + ","
				+ size;
		System.out.println(sql);
		return sql;

	}

	@Author("zhanqiao.huang")
	@Shard(indexName = "cc_item_id_index", indexColumn = "auditTaskEntity.system_type")
	@Select(collectionType = CollectionType.column, resultType = Long.class)
	public Object queryAuditTaskTotalByZoneCount(
			@SqlParameter("auditTaskEntity") AuditTaskEntity auditTaskEntity) {
		String sql = "select count(id) FROM ccc_dimzone_task_status a where 1=1";
		sql = queryTaskTotalWhereSqL(auditTaskEntity, sql);
		return sql;
	}

	@Author("zhanqiao.huang")
	@Shard(indexName = "cc_item_id_index", indexColumn = "auditTaskEntity.system_type")
	@Select(collectionType = CollectionType.column, resultType = Long.class)
	public Object queryAuditTaskTotalByClassisCount(
			@SqlParameter("auditTaskEntity") AuditTaskEntity auditTaskEntity) {
		String sql = "select count(a.id) FROM ccc_dimclass_task_status a INNER join dim_task_class b on a.task_type=b.id where 1=1";
		sql = queryTaskTotalWhereSqL(auditTaskEntity, sql);
		return sql;
	}

	@Author("zhanqiao.huang")
	@Shard(indexName = "cc_item_id_index", indexColumn = "auditTaskEntity.system_type")
	@Select(collectionType = CollectionType.bean, resultType = AuditTaskEntity.class)
	public Object queryAuditTaskTotal(
			@SqlParameter("auditTaskEntity") AuditTaskEntity auditTaskEntity) {
		String sql = "SELECT system_type,payamt,sall,"
				+ "  s2 AS auditing,s3 AS auditSuccess,"
				+ "  s4 AS auditFall FROM ccc_dimitems_task_status a where 1=1";
		sql = queryTaskTotalWhereSqL(auditTaskEntity, sql);
		return sql;
	}

	@Author("zhanqiao.huang")
	@Shard(indexName = "cc_item_id_index", indexColumn = "auditTaskDetailsEntity.system_type")
	@Select(collectionType = CollectionType.beanList, resultType = AuditTaskDetailsEntity.class)
	public Object queryAuditTaskDetails(
			@SqlParameter("auditTaskDetailsEntity") AuditTaskDetailsEntity auditTaskDetailsEntity,
			@SqlParameter("sortName") String sortName,
			@SqlParameter("sortOrder") String sortOrder,
			@SqlParameter("skip") int skip, @SqlParameter("size") int size) {
		String sql = "SELECT system_type,CUSTOM_TOLAL_MONEY payamt,amount, task_name,area,submit_time,dtc.type as type,task_status_key"
				+ " FROM fack_task_ccc ftc INNER JOIN dim_task_class dtc ON dtc.id = ftc.task_class_type_key ";
		sql=queryTaskDetailsWhereSqL(auditTaskDetailsEntity, sql)
				+ " order by ${sortName} ${sortOrder} limit " + skip + ","
				+ size;
		System.out.println(sql);
		return sql;
	}

	@Author("zhanqiao.huang")
	@Shard(indexName = "cc_item_id_index", indexColumn = "auditTaskDetailsEntity.system_type")
	@Select(collectionType = CollectionType.column, resultType = Long.class)
	public Object queryAuditTaskDetailsCount(
			@SqlParameter("auditTaskDetailsEntity") AuditTaskDetailsEntity auditTaskDetailsEntity) {
		String sql = "SELECT count(bid) FROM fack_task_ccc ftc INNER JOIN dim_task_class dtc ON dtc.id = ftc.task_class_type_key ";
		sql = queryTaskDetailsWhereSqL(auditTaskDetailsEntity, sql);
		return sql;
	}

	@Author("zhanqiao.huang")
	@Shard(indexName = "cc_item_id_index", indexColumn = "mapAuditTaskEntity.system_type")
	@Select(collectionType = CollectionType.beanList, resultType = MapAuditTaskEntity.class)
	public Object showMapAuditTasks(@SqlParameter("mapAuditTaskEntity") MapAuditTaskEntity mapAuditTaskEntity) {
		String sql = "SELECT" + "  a.task_id AS taskId," + "  a.lon,"
				+ "  a.lat," + "  b.task_status_key AS STATUS,"
				+ "  a.system_type,"
				+ "  b.task_class_type_key AS taskClassName,"
				+ "  b.area AS zone" + "  FROM" + "  dw_tasks_point a"
				+ "  INNER JOIN fack_task_ccc b" + "  ON a.task_id = b.bid";
		
		if (StringUtil.notEmpty(mapAuditTaskEntity.getSystem_type())) {
			sql += " and a.system_type=#{mapAuditTaskEntity.system_type}";
		}
		if (StringUtil.notEmpty(mapAuditTaskEntity.getStatus())) {
			sql += " and b.task_status_key=#{mapAuditTaskEntity.status}";
		}
		if (StringUtil.notEmpty(mapAuditTaskEntity.getZone())) {
			sql += " and b.area=#{mapAuditTaskEntity.zone}";
		}
		return sql;
	}

	/**
	 * 
	 * @Title: queryTasksPays 
	 * @Description: 支付记录
	 * @param @param auditTasksPaysEntity
	 * @param @param sortName
	 * @param @param sortOrder
	 * @param @param skip
	 * @param @param size
	 * @param @return 设定文件 
	 * @return Object 返回类型 
	 * @throws
	 */
	@Author("zhanqiao.huang")
	@Shard(indexName = "cc_item_id_index", indexColumn = "auditTasksPaysEntity.system_type")
	@Select(collectionType = CollectionType.beanList, resultType = AuditTasksPaysEntity.class)
	public Object queryTasksPays(
			@SqlParameter("auditTasksPaysEntity") AuditTasksPaysEntity auditTasksPaysEntity,
			@SqlParameter("sortName") String sortName,
			@SqlParameter("sortOrder") String sortOrder,
			@SqlParameter("queryType") String queryType,
			@SqlParameter("skip") int skip, @SqlParameter("size") int size) {
		String tableName = null;
		if ("day".equals(queryType)) {
			tableName = "ccc_dimdate_tasks_pays_day";
		} else if ("month".equals(queryType)) {
			tableName = "ccc_dimdate_tasks_pays_month";
		}
		String sql = "SELECT auditdate,tasknum,payamt,system_type,amount "
//				+ "  (%s) AS paytotal,"
//				+ "  (%s) AS amounttotal"
				+ " FROM "
				+ tableName + " a where 1=1 ";
//		String paytotal=queryTasksPaysWhereSqL(auditTasksPaysEntity,"SELECT ifnull(SUM(payamt),0.00) FROM "+tableName+" a where 1=1");
//		String amounttotal=queryTasksPaysWhereSqL(auditTasksPaysEntity,"SELECT ifnull(SUM(amount),0.00) FROM "+tableName+" a where 1=1");
//		sql=String.format(sql,paytotal,amounttotal);
		sql=queryTasksPaysWhereSqL(auditTasksPaysEntity, sql);
		return sql + " order by ${sortName} ${sortOrder} limit " + skip + ","
				+ size;
	}
	@Author("zhanqiao.huang")
	@Shard(indexName = "cc_item_id_index", indexColumn = "auditTasksPaysEntity.system_type")
	@Select(collectionType = CollectionType.column, resultType = String.class)
	public Object queryTasksPaysPayTotal(
			@SqlParameter("auditTasksPaysEntity") AuditTasksPaysEntity auditTasksPaysEntity,String totalString,String queryType) {
		String tableName = null;
		if ("day".equals(queryType)) {
			tableName = "ccc_dimdate_tasks_pays_day";
		} else if ("month".equals(queryType)) {
			tableName = "ccc_dimdate_tasks_pays_month";
		}
		if("payamt".equals(totalString)){
			return queryTasksPaysWhereSqL(auditTasksPaysEntity,"SELECT ifnull(SUM(payamt),0.00) FROM "+tableName+" a where 1=1");
		}else{
			return queryTasksPaysWhereSqL(auditTasksPaysEntity,"SELECT ifnull(SUM(amount),0.00) FROM "+tableName+" a where 1=1");
		}
	}
	
	private String queryTasksPaysWhereSqL(AuditTasksPaysEntity auditTasksPaysEntity,
			String sql) {
		if (StringUtil.notEmpty(auditTasksPaysEntity.getSystem_type())) {
			sql += " and a.system_type=#{auditTasksPaysEntity.system_type}";
		}
		return sql;
	}
	
	@Author("zhanqiao.huang")
	@Shard(indexName = "cc_item_id_index", indexColumn = "auditTasksPaysEntity.system_type")
	@Select(collectionType = CollectionType.column, resultType = Long.class)
	public Object queryTasksPaysCount(
			@SqlParameter("auditTasksPaysEntity") AuditTasksPaysEntity auditTasksPaysEntity,String queryType) {
		String tableName=null;
		if("day".equals(queryType)){
			tableName="ccc_dimdate_tasks_pays_day";
		}else if("month".equals(queryType)){
			tableName="ccc_dimdate_tasks_pays_month";
		}
		String sql = queryTasksPaysWhereSqL(auditTasksPaysEntity,"SELECT count(id) FROM "+tableName+" a where 1=1 ");
		return sql;
	}
	/**
	 * 
	 * @Title: queryTaskTotalWhereSqL
	 * @Description: 任务统计-条件
	 * @param @param auditTaskEntity
	 * @param @param sql
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	private String queryTaskTotalWhereSqL(AuditTaskEntity auditTaskEntity,
			String sql) {

		if (StringUtil.notEmpty(auditTaskEntity.getArea())) {
			auditTaskEntity.setArea(auditTaskEntity.getArea()+"%");
			sql += " and a.area like #{auditTaskEntity.area}";
		}
		if (StringUtil.notEmpty(auditTaskEntity.getSystem_type())) {
			sql += " and a.system_type = #{auditTaskEntity.system_type}";
		}
		if (StringUtil.notEmpty(auditTaskEntity.getClassisId())) {
			sql += " and a.task_type = #{auditTaskEntity.classisId}";
		}
		if (StringUtil.notEmpty(auditTaskEntity.getClassis())) {
			auditTaskEntity.setClassis(auditTaskEntity.getClassis()+"%");
			sql += " and b.type like #{auditTaskEntity.classis}";
		}
		return sql;
	}

	/**
	 * 
	 * @Title: queryTaskDetailsWhereSqL
	 * @Description: 任务详情-明细
	 * @param @param auditTaskDetailsEntity
	 * @param @param sql
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	private String queryTaskDetailsWhereSqL(
			AuditTaskDetailsEntity auditTaskDetailsEntity, String sql) {

		if (StringUtil.notEmpty(auditTaskDetailsEntity.getArea())) {
			sql += " and ftc.area = #{auditTaskDetailsEntity.area}";
		}
		if (StringUtil.notEmpty(auditTaskDetailsEntity.getSystem_type())) {
			sql += " and ftc.system_type = #{auditTaskDetailsEntity.system_type}";
		}
		if (StringUtil.notEmpty(auditTaskDetailsEntity.getClassis())) {
			sql += " and ftc.task_class_type_key = #{auditTaskDetailsEntity.classis}";
		}
		//2015.10.19 add by hzq
		if (StringUtil.notEmpty(auditTaskDetailsEntity.getAudit_time())) {
//			auditTaskDetailsEntity.setCustom_total_money(0d);
			int len=auditTaskDetailsEntity.getAudit_time().length();
			sql += " and left(ftc.audit_time,"+len+")= #{auditTaskDetailsEntity.audit_time}";
			sql += " and  ftc.CUSTOM_TOLAL_MONEY>0";
		}
		return sql;
	}
	
	
	@Author("zhanqiao.huang")
	@Shard(indexName = "cc_item_id_index", indexColumn = "cCChargeHisEntity.ownerId")
	@Select(collectionType = CollectionType.beanList, resultType = CCChargeHisEntity.class)
	public Object queryChargeHis(
			@SqlParameter("cCChargeHisEntity") CCChargeHisEntity cCChargeHisEntity,
			@SqlParameter("sortName") String sortName,
			@SqlParameter("sortOrder") String sortOrder,
			@SqlParameter("skip") int skip, @SqlParameter("size") int size) {
		String sql = "SELECT" +
						"  APPLY_ID applyId," + 
						"  AUDIT_ID auditId," + 
						"  CUSTOM_ID customId," + 
						"  OWNER_ID ownerId," + 
						"  MONEY money," + 
						"  AUDIT_TIME auditTime" + 
						" FROM " + 
						"  fack_charge_his_cc a where a.TYPE=1 and a.STATUS=1 ";//TYPE 类型(0:未知,1:充值,2:垫付,3:退款 ,4:余额阀值修改,5:单价设置) STATUS状态(0:审核中,1 :审核通过 2:未通过)
		if (StringUtil.notEmpty(cCChargeHisEntity.getOwnerId())) {
			sql += " and a.OWNER_ID=#{cCChargeHisEntity.ownerId}";
		}
		return sql + " order by ${sortName} ${sortOrder} limit " + skip + ","
				+ size;
	}
	
	
	@Author("zhanqiao.huang")
	@Shard(indexName = "cc_item_id_index", indexColumn = "cCChargeHisEntity.ownerId")
	@Select(collectionType = CollectionType.column, resultType = Long.class)
	public Object queryChargeHisCount(@SqlParameter("cCChargeHisEntity") CCChargeHisEntity cCChargeHisEntity) {
		String sql = "SELECT count(id) from fack_charge_his_cc a where a.TYPE=1 and a.STATUS=1";
		if (StringUtil.notEmpty(cCChargeHisEntity.getOwnerId())) {
			sql += " and a.OWNER_ID=#{cCChargeHisEntity.ownerId}";
		}
		return sql;
	}
	
	
	@Author("zhanqiao.huang")
	@Shard(indexName = "cc_item_id_index", indexColumn = "mapOfCity.system_type")
	@Select(collectionType = CollectionType.beanList, resultType = MapOfCity.class)
	public Object queryMapProvincialOrCity(@SqlParameter("mapOfCity") MapOfCity mapOfCity) {
		String sql = "SELECT" +
						"  AREA city" + 
						"  FROM fack_project_city a where 1=1";
		if (StringUtil.notEmpty(mapOfCity.getSystem_type())&&StringUtil.isEmpty(mapOfCity.getProvincial())) {
			sql = "SELECT DISTINCT provincialName provincial FROM fack_project_city a where a.system_type=#{mapOfCity.system_type}";
		}
		if (StringUtil.notEmpty(mapOfCity.getSystem_type())&&StringUtil.notEmpty(mapOfCity.getProvincial())) {
			sql += " and a.system_type=#{mapOfCity.system_type} and a.provincialName=#{mapOfCity.provincial}";
		}
		return sql;
	}
	
	
	
	
	
	
	@Author("zhanqiao.huang")
	@Shard(indexName = "cc_item_id_index", indexColumn = "billingDetails.system_type")
	@Select(collectionType = CollectionType.beanList, resultType = BillingDetails.class)
	public Object queryProjectBillingDetails(@SqlParameter("billingDetails") BillingDetails billingDetails,
			@SqlParameter("sortName") String sortName,
			@SqlParameter("sortOrder") String sortOrder,
			@SqlParameter("skip") int skip, @SqlParameter("size") int size) {
		
		String sql = "SELECT system_type,pay,withhold,recharge,_date,payforsb FROM report_item_billing_details_finance a where 1=1";
		sql=queryProjectBillingDetailsWhereSqL(billingDetails,sql);
		return sql + "  order by ${sortName} ${sortOrder} limit " + skip + ","+ size;
	}
	@Author("zhanqiao.huang")
	@Shard(indexName = "cc_item_id_index", indexColumn = "billingDetails.system_type")
	@Select(collectionType = CollectionType.column, resultType = Long.class)
	public Object queryProjectBillingDetailsCount(@SqlParameter("billingDetails") BillingDetails billingDetails) {
		String sql = "SELECT count(id) from report_item_billing_details_finance a where 1=1";
		return queryProjectBillingDetailsWhereSqL(billingDetails,sql);
	}
	
	@Author("zhanqiao.huang")
	@Shard(indexName = "cc_item_id_index", indexColumn = "billingDetails.system_type")
	@Select(collectionType = CollectionType.column, resultType = String.class)
	public Object queryProjectBillingDetailsTotal(
			@SqlParameter("billingDetails") BillingDetails billingDetails,String totalString) {
		if("pay".equals(totalString)){
			return queryProjectBillingDetailsWhereSqL(billingDetails,"SELECT ifnull(SUM(pay),0.00) FROM report_item_billing_details_finance a where 1=1");
		}else if("withhold".equals(totalString)){
			return queryProjectBillingDetailsWhereSqL(billingDetails,"SELECT ifnull(SUM(withhold),0.00) FROM report_item_billing_details_finance a where 1=1");
		}else if("recharge".equals(totalString)){
			return queryProjectBillingDetailsWhereSqL(billingDetails,"SELECT ifnull(SUM(recharge),0.00) FROM report_item_billing_details_finance a where 1=1");
		}else{
			return queryProjectBillingDetailsWhereSqL(billingDetails,"SELECT ifnull(SUM(payforsb),0.00) FROM report_item_billing_details_finance a where 1=1");
		}
	}
	private String queryProjectBillingDetailsWhereSqL(BillingDetails billingDetails,String sql) {
		if (StringUtil.notEmpty(billingDetails.getSystem_type())) {
			sql += " and a.system_type=#{billingDetails.system_type}";
		}
		return sql;
	}
}
