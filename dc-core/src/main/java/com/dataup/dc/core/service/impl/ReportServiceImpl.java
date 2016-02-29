package com.dataup.dc.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataup.dc.api.bean.Pagination;
import com.dataup.dc.api.entity.AuditTaskDetailsEntity;
import com.dataup.dc.api.entity.AuditTaskEntity;
import com.dataup.dc.api.entity.AuditTasksPaysEntity;
import com.dataup.dc.api.entity.BillingDetails;
import com.dataup.dc.api.entity.CCChargeHisEntity;
import com.dataup.dc.api.entity.MapAuditTaskEntity;
import com.dataup.dc.api.entity.MapOfCity;
import com.dataup.dc.api.service.CccReportService;
import com.dataup.dc.core.dao.CccReportDao;

@Service("cccReportService")
public class ReportServiceImpl implements CccReportService {

	@Autowired
	private CccReportDao cccReportDao;

	@Override
	public Pagination queryAuditTaskTotalByZone(
			AuditTaskEntity auditTaskEntity, int start, int limit,
			String sortName, String sortOrder) throws Exception {
		Pagination page = new Pagination(start,limit);
		@SuppressWarnings("unchecked")
		List<AuditTaskEntity> list = (List<AuditTaskEntity>) cccReportDao
				.queryAuditTaskTotalByZone(auditTaskEntity, sortName,
						sortOrder, page.getStart(), page.getLimit());
		Long count = (Long) cccReportDao
				.queryAuditTaskTotalByZoneCount(auditTaskEntity);
		page.setObjectList(list);
		page.setTotalCount(count);
		return page;
	}

	@Override
	public Pagination queryAuditTaskTotalByClassis(
			AuditTaskEntity auditTaskEntity, int start, int limit,
			String sortName, String sortOrder) throws Exception {
		Pagination page = new Pagination(start,limit);
		@SuppressWarnings("unchecked")
		List<AuditTaskEntity> list = (List<AuditTaskEntity>) cccReportDao
				.queryAuditTaskTotalByClassis(auditTaskEntity, sortName,
						sortOrder, page.getStart(), page.getLimit());
		Long count = (Long) cccReportDao
				.queryAuditTaskTotalByClassisCount(auditTaskEntity);
		page.setObjectList(list);
		page.setTotalCount(count);
		return page;
	}

	@Override
	public AuditTaskEntity queryAuditTaskTotal(AuditTaskEntity auditTaskEntity) throws Exception {
		return (AuditTaskEntity) cccReportDao.queryAuditTaskTotal(auditTaskEntity);
	}

	@Override
	public Pagination queryAuditTaskDetails(
			AuditTaskDetailsEntity auditTaskDetailsEntity, int start,
			int limit, String sortName, String sortOrder) throws Exception {
		Pagination page = new Pagination(start,limit);
		@SuppressWarnings("unchecked")
		List<AuditTaskDetailsEntity> list = (List<AuditTaskDetailsEntity>) cccReportDao
				.queryAuditTaskDetails(auditTaskDetailsEntity, sortName,
						sortOrder, page.getStart(), page.getLimit());
		Long count = (Long) cccReportDao
				.queryAuditTaskDetailsCount(auditTaskDetailsEntity);
		page.setObjectList(list);
		page.setTotalCount(count);
		return page;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MapAuditTaskEntity> showMapAuditTasks(
			MapAuditTaskEntity mapAuditTaskEntity) throws Exception {
		return (List<MapAuditTaskEntity>) cccReportDao.showMapAuditTasks(mapAuditTaskEntity);
	}

	@Override
	public Pagination queryTasksPays(AuditTasksPaysEntity auditTasksPaysEntity,
			int start, int limit, String sortName, String sortOrder,String queryType)
			throws Exception {
		Pagination page = new Pagination(start,limit);
		@SuppressWarnings("unchecked")
		List<AuditTasksPaysEntity> list = (List<AuditTasksPaysEntity>) cccReportDao
				.queryTasksPays(auditTasksPaysEntity, sortName,
						sortOrder,queryType, page.getStart(), page.getLimit());
		Long count = (Long) cccReportDao.queryTasksPaysCount(auditTasksPaysEntity,queryType);
		page.setObjectList(list);
		page.setPayTotal((String)cccReportDao.queryTasksPaysPayTotal(auditTasksPaysEntity, "payamt",queryType));
		page.setAmountTotal((String)cccReportDao.queryTasksPaysPayTotal(auditTasksPaysEntity, "amount",queryType));
		page.setTotalCount(count);
		return page;
	}

	@Override
	public Pagination queryChargeHis(CCChargeHisEntity cCChargeHisEntity,
			int start, int limit, String sortName, String sortOrder)
			throws Exception {
		Pagination page = new Pagination(start,limit);
		@SuppressWarnings("unchecked")
		List<CCChargeHisEntity> list = (List<CCChargeHisEntity>) cccReportDao
				.queryChargeHis(cCChargeHisEntity, sortName,
						sortOrder, page.getStart(), page.getLimit());
		Long count = (Long) cccReportDao.queryChargeHisCount(cCChargeHisEntity);
		page.setObjectList(list);
		page.setTotalCount(count);
		return page;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MapOfCity> queryMapProvincialOrCity(MapOfCity mapOfCity)
			throws Exception {
		return (List<MapOfCity>)cccReportDao.queryMapProvincialOrCity(mapOfCity);
	}

	@Override
	public Pagination queryProjectBillingDetails(
			BillingDetails billingDetails, int start, int limit,
			String sortName, String sortOrder) throws Exception {
		Pagination page = new Pagination(start,limit);
		@SuppressWarnings("unchecked")
		List<BillingDetails> list = (List<BillingDetails>) cccReportDao
				.queryProjectBillingDetails(billingDetails, sortName,
						sortOrder, page.getStart(), page.getLimit());
		Long count = (Long) cccReportDao
				.queryProjectBillingDetailsCount(billingDetails);
		page.setObjectList(list);
		page.setTotalCount(count);
		page.setPayTotal((String)cccReportDao.queryProjectBillingDetailsTotal(billingDetails, "pay"));
		page.setAmountTotal((String)cccReportDao.queryProjectBillingDetailsTotal(billingDetails, "withhold"));
		page.setRechargeTotal((String)cccReportDao.queryProjectBillingDetailsTotal(billingDetails, "recharge"));
		page.setPayforsbTotal((String)cccReportDao.queryProjectBillingDetailsTotal(billingDetails, "payforsb"));
		return page;
	}

 

 
}
