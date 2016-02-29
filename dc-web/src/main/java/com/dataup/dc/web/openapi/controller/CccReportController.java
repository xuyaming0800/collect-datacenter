package com.dataup.dc.web.openapi.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dataup.dc.api.bean.Pagination;
import com.dataup.dc.api.entity.AuditTaskDetailsEntity;
import com.dataup.dc.api.entity.AuditTaskEntity;
import com.dataup.dc.api.entity.AuditTasksPaysEntity;
import com.dataup.dc.api.entity.BillingDetails;
import com.dataup.dc.api.entity.CCChargeHisEntity;
import com.dataup.dc.api.entity.DefaultReturnBean;
import com.dataup.dc.api.entity.MapAuditTaskEntity;
import com.dataup.dc.api.entity.MapOfCity;
import com.dataup.dc.api.exception.ExceptionCode;
import com.dataup.dc.api.exception.support.BaseSupportException;
import com.dataup.dc.api.service.ApiToolsService;
import com.dataup.dc.api.service.CccReportService;
import com.dataup.dc.api.util.SysConstant;
import com.dataup.dc.web.openapi.util.RequestParams;
import com.dataup.dc.web.openapi.util.RequestParamsHandler;

 
/**
 * 
 * @ClassName: CccReportController 
 * @Description: 报表-客户中心 
 * @author zhanqiao.huang
 * @date 2015年9月22日 上午11:49:42
 */
@Controller
public class CccReportController {
	private Logger logger = LogManager.getLogger(getClass());

	@Autowired
	private CccReportService cccReportService;

	@Autowired
	private ApiToolsService apiToolsService;

 
	@RequestMapping(value = "/openapi", params = { "serviceid=ccc10001" })
	public @ResponseBody DefaultReturnBean<Pagination> queryAuditTaskTotalByZone(HttpServletRequest request) {
		logger.info("查询区域统计-queryAuditTaskTotalByZone-start");
		DefaultReturnBean<Pagination> bean=new DefaultReturnBean<Pagination>();
		try {
			RequestParams params = RequestParamsHandler.handleRequest(request);
			logger.entry(params);
			String zone = (String) params.getValue("zone");
			if("1".equals(zone)){
				zone="北京市";
			}
			String system_type = (String) params.getValue("system_type");
			String sortName = (String) params.getValue("sortName");
			String start = (String) params.getValue("start");
			String limit = (String) params.getValue("limit");
			String sortOrder = (String) params.getValue("sortOrder");
			String check=checkNull(new String[]{system_type,sortName,start,limit,sortOrder},new String[]{"system_type","sortName","start","limit","sortOrder"});
			if(!check.equals("")){
				bean.setCode(ExceptionCode.MISS_REQUIRED_PARAMS+"");
				bean.setDesc(apiToolsService.getExceptionMessage(bean.getCode()));
				return bean;
			}
			AuditTaskEntity auditTaskEntity=new AuditTaskEntity();
			auditTaskEntity.setArea(zone);
			auditTaskEntity.setSystem_type(system_type);
			Pagination pagination=cccReportService.queryAuditTaskTotalByZone(auditTaskEntity, Integer.valueOf(start), Integer.valueOf(limit), sortName, sortOrder);
			bean.setInfo(pagination);
			bean.setSuccess(true);
			bean.setCode(SysConstant.SUCCESS_CODE);
			bean.setDesc("成功");
			logger.info("查询区域统计-queryAuditTaskTotalByZone-end");
			return bean;
		} catch (BaseSupportException b) {
			bean.setSuccess(false);
			bean.setCode(b.getErrorCode());
			bean.setDesc(b.getMessage());
			return bean;
		} catch (Exception e) {
			bean.setSuccess(false);
			bean.setCode(ExceptionCode.SYSTEM_INNER_ERROR + "");
			String desc = apiToolsService.getExceptionMessage(ExceptionCode.SYSTEM_INNER_ERROR + "");
			bean.setDesc(desc);
			return bean;
		}
	}
	
	
	@RequestMapping(value = "/openapi", params = { "serviceid=ccc10002" })
	public @ResponseBody DefaultReturnBean<Pagination> queryAuditTaskTotalByClassis(HttpServletRequest request) {
		logger.info("查询分类统计-queryAuditTaskTotalByClassis-start");
		DefaultReturnBean<Pagination> bean=new DefaultReturnBean<Pagination>();
		try {
			RequestParams params = RequestParamsHandler.handleRequest(request);
			logger.entry(params);
			String classis = (String) params.getValue("classis");
			//测试用
			if("14".equals(classis)){
				classis="小区";
			}
			String system_type = (String) params.getValue("system_type");
			String sortName = (String) params.getValue("sortName");
			String start = (String) params.getValue("start");
			String limit = (String) params.getValue("limit");
			String sortOrder = (String) params.getValue("sortOrder");
			String check=checkNull(new String[]{system_type,sortName,start,limit,sortOrder},new String[]{"system_type","sortName","start","limit","sortOrder"});
			if(!check.equals("")){
				bean.setCode(ExceptionCode.MISS_REQUIRED_PARAMS+"");
				bean.setDesc(apiToolsService.getExceptionMessage(bean.getCode()));
				return bean;
			}
			AuditTaskEntity auditTaskEntity=new AuditTaskEntity();
			auditTaskEntity.setClassis(classis);
			auditTaskEntity.setSystem_type(system_type);
			Pagination pagination=cccReportService.queryAuditTaskTotalByClassis(auditTaskEntity, Integer.valueOf(start), Integer.valueOf(limit), sortName, sortOrder);
			bean.setInfo(pagination);
			bean.setSuccess(true);
			bean.setCode(SysConstant.SUCCESS_CODE);
			bean.setDesc("成功");
			logger.info("查询分类统计-queryAuditTaskTotalByClassis-end");
			return bean;
		} catch (BaseSupportException b) {
			bean.setSuccess(false);
			bean.setCode(b.getErrorCode());
			bean.setDesc(b.getMessage());
			return bean;
		} catch (Exception e) {
			bean.setSuccess(false);
			bean.setCode(ExceptionCode.SYSTEM_INNER_ERROR + "");
			String desc = apiToolsService.getExceptionMessage(ExceptionCode.SYSTEM_INNER_ERROR + "");
			bean.setDesc(desc);
			return bean;
		}
	}
	
	@RequestMapping(value = "/openapi", params = { "serviceid=ccc10003" })
	public @ResponseBody DefaultReturnBean<AuditTaskEntity> queryAuditTaskTotal(HttpServletRequest request) {
		logger.info("查询统计总计-queryAuditTaskTotal-start");
		DefaultReturnBean<AuditTaskEntity> bean=new DefaultReturnBean<AuditTaskEntity>();
		try {
			RequestParams params = RequestParamsHandler.handleRequest(request);
			logger.entry(params);
			String system_type = (String) params.getValue("system_type");
			String check=checkNull(new String[]{system_type},new String[]{"system_type"});
			if(!check.equals("")){
				bean.setCode(ExceptionCode.MISS_REQUIRED_PARAMS+"");
				bean.setDesc(apiToolsService.getExceptionMessage(bean.getCode()));
				return bean;
			}
			AuditTaskEntity auditTaskEntity=new AuditTaskEntity();
			auditTaskEntity.setSystem_type(system_type);
			bean.setInfo(cccReportService.queryAuditTaskTotal(auditTaskEntity));
			bean.setSuccess(true);
			bean.setCode(SysConstant.SUCCESS_CODE);
			bean.setDesc("成功");
			logger.info("查询统计总计-queryAuditTaskTotal-end");
			return bean;
		} catch (BaseSupportException b) {
			bean.setSuccess(false);
			bean.setCode(b.getErrorCode());
			bean.setDesc(b.getMessage());
			return bean;
		} catch (Exception e) {
			bean.setSuccess(false);
			bean.setCode(ExceptionCode.SYSTEM_INNER_ERROR + "");
			String desc = apiToolsService.getExceptionMessage(ExceptionCode.SYSTEM_INNER_ERROR + "");
			bean.setDesc(desc);
			return bean;
		}
	}
	
	
	@RequestMapping(value = "/openapi", params = { "serviceid=ccc10004" })
	public @ResponseBody DefaultReturnBean<Pagination> queryAuditTaskDetails(HttpServletRequest request) {
		logger.info("查询任务明细-queryAuditTaskDetails-start");
		DefaultReturnBean<Pagination> bean=new DefaultReturnBean<Pagination>();
		try {
			RequestParams params = RequestParamsHandler.handleRequest(request);
			logger.entry(params);
			String zone = (String) params.getValue("zone");
			String classis = (String) params.getValue("classis");
			String system_type = (String) params.getValue("system_type");
			String auditDate = (String) params.getValue("auditDate");
			String sortName = (String) params.getValue("sortName");
			String start = (String) params.getValue("start");
			String limit = (String) params.getValue("limit");
			String sortOrder = (String) params.getValue("sortOrder");
			String check=checkNull(new String[]{system_type,sortName,start,limit,sortOrder},new String[]{"system_type","sortName","start","limit","sortOrder"});
			if(!check.equals("")){
				bean.setCode(ExceptionCode.MISS_REQUIRED_PARAMS+"");
				bean.setDesc(apiToolsService.getExceptionMessage(bean.getCode()));
				return bean;
			}
			AuditTaskDetailsEntity auditTaskDetailsEntity=new AuditTaskDetailsEntity();
			auditTaskDetailsEntity.setArea(zone);
			auditTaskDetailsEntity.setSystem_type(system_type);
			auditTaskDetailsEntity.setClassis(classis);
			auditTaskDetailsEntity.setAudit_time(auditDate);
			Pagination pagination=cccReportService.queryAuditTaskDetails(auditTaskDetailsEntity, Integer.valueOf(start), Integer.valueOf(limit), sortName, sortOrder);
			bean.setInfo(pagination);
			bean.setSuccess(true);
			bean.setCode(SysConstant.SUCCESS_CODE);
			bean.setDesc("成功");
			logger.info("查询任务明细-queryAuditTaskDetails-end");
			return bean;
		} catch (BaseSupportException b) {
			bean.setSuccess(false);
			bean.setCode(b.getErrorCode());
			bean.setDesc(b.getMessage());
			return bean;
		} catch (Exception e) {
			bean.setSuccess(false);
			bean.setCode(ExceptionCode.SYSTEM_INNER_ERROR + "");
			String desc = apiToolsService.getExceptionMessage(ExceptionCode.SYSTEM_INNER_ERROR + "");
			bean.setDesc(desc);
			return bean;
		}
	}
	
	
	@RequestMapping(value = "/openapi", params = { "serviceid=ccc10005" })
	public @ResponseBody DefaultReturnBean<List<MapAuditTaskEntity>> showMapAuditTasks(HttpServletRequest request) {
		logger.info("查询任务明细-queryAuditTaskDetails-start");
		DefaultReturnBean<List<MapAuditTaskEntity>> bean=new DefaultReturnBean<List<MapAuditTaskEntity>>();
		try {
			RequestParams params = RequestParamsHandler.handleRequest(request);
			logger.entry(params);
			String zone = (String) params.getValue("zone");
			String status = (String) params.getValue("status");
			String system_type = (String) params.getValue("system_type");
			String check=checkNull(new String[]{system_type,zone},new String[]{"system_type","zone"});
			if(!check.equals("")){
				bean.setCode(ExceptionCode.MISS_REQUIRED_PARAMS+"");
				bean.setDesc(apiToolsService.getExceptionMessage(bean.getCode()));
				return bean;
			}
			MapAuditTaskEntity mapAuditTaskEntity=new MapAuditTaskEntity();
			mapAuditTaskEntity.setSystem_type(system_type);
			mapAuditTaskEntity.setZone(zone);
			mapAuditTaskEntity.setStatus(status);
			List<MapAuditTaskEntity> list=cccReportService.showMapAuditTasks(mapAuditTaskEntity);
			bean.setInfo(list);
			bean.setSuccess(true);
			bean.setCode(SysConstant.SUCCESS_CODE);
			bean.setDesc("成功");
			logger.info("查询任务明细-queryAuditTaskDetails-end");
			return bean;
		} catch (BaseSupportException b) {
			bean.setSuccess(false);
			bean.setCode(b.getErrorCode());
			bean.setDesc(b.getMessage());
			return bean;
		} catch (Exception e) {
			bean.setSuccess(false);
			bean.setCode(ExceptionCode.SYSTEM_INNER_ERROR + "");
			String desc = apiToolsService.getExceptionMessage(ExceptionCode.SYSTEM_INNER_ERROR + "");
			bean.setDesc(desc);
			return bean;
		}
	}

	
	@RequestMapping(value = "/openapi", params = { "serviceid=ccc10006" })
	public @ResponseBody DefaultReturnBean<Pagination> queryTasksPays(HttpServletRequest request) {
		logger.info("查询费用支出-queryAuditTaskDetails-start");
		DefaultReturnBean<Pagination> bean=new DefaultReturnBean<Pagination>();
		try {
			RequestParams params = RequestParamsHandler.handleRequest(request);
			logger.entry(params);
			String queryType = (String) params.getValue("queryType");
			String system_type = (String) params.getValue("system_type");
			String sortName = (String) params.getValue("sortName");
			String start = (String) params.getValue("start");
			String limit = (String) params.getValue("limit");
			String sortOrder = (String) params.getValue("sortOrder");
			String check=checkNull(new String[]{system_type,sortName,start,limit,sortOrder},new String[]{"system_type","sortName","start","limit","sortOrder"});
			if(!check.equals("")){
				bean.setCode(ExceptionCode.MISS_REQUIRED_PARAMS+"");
				bean.setDesc(apiToolsService.getExceptionMessage(bean.getCode()));
				return bean;
			}
			AuditTasksPaysEntity auditTasksPaysEntity=new AuditTasksPaysEntity();
			auditTasksPaysEntity.setSystem_type(system_type);
			Pagination pagination=cccReportService.queryTasksPays(auditTasksPaysEntity, Integer.valueOf(start), Integer.valueOf(limit), sortName, sortOrder,queryType);
			bean.setInfo(pagination);
			bean.setSuccess(true);
			bean.setCode(SysConstant.SUCCESS_CODE);
			bean.setDesc("成功");
			logger.info("查询任务明细-queryAuditTaskDetails-end");
			return bean;
		} catch (BaseSupportException b) {
			bean.setSuccess(false);
			bean.setCode(b.getErrorCode());
			bean.setDesc(b.getMessage());
			return bean;
		} catch (Exception e) {
			bean.setSuccess(false);
			bean.setCode(ExceptionCode.SYSTEM_INNER_ERROR + "");
			String desc = apiToolsService.getExceptionMessage(ExceptionCode.SYSTEM_INNER_ERROR + "");
			bean.setDesc(desc);
			return bean;
		}
	}
	
	@RequestMapping(value = "/openapi", params = { "serviceid=ccc10007" })
	public @ResponseBody DefaultReturnBean<Pagination> queryChargeHis(HttpServletRequest request) {
		logger.info("查询充值记录-queryChargeHis-start");
		DefaultReturnBean<Pagination> bean=new DefaultReturnBean<Pagination>();
		try {
			RequestParams params = RequestParamsHandler.handleRequest(request);
			logger.entry(params);
			String system_type = (String) params.getValue("system_type");
			String sortName = (String) params.getValue("sortName");
			String start = (String) params.getValue("start");
			String limit = (String) params.getValue("limit");
			String sortOrder = (String) params.getValue("sortOrder");
			String check=checkNull(new String[]{system_type,sortName,start,limit,sortOrder},new String[]{"system_type","sortName","start","limit","sortOrder"});
			if(!check.equals("")){
				bean.setCode(ExceptionCode.MISS_REQUIRED_PARAMS+"");
				bean.setDesc(apiToolsService.getExceptionMessage(bean.getCode()));
				return bean;
			}
			CCChargeHisEntity cCChargeHisEntity=new CCChargeHisEntity();
			cCChargeHisEntity.setOwnerId(system_type);
			Pagination pagination=cccReportService.queryChargeHis(cCChargeHisEntity, Integer.valueOf(start), Integer.valueOf(limit), sortName, sortOrder);
			bean.setInfo(pagination);
			bean.setSuccess(true);
			bean.setCode(SysConstant.SUCCESS_CODE);
			bean.setDesc("成功");
			logger.info("查询充值记录-queryChargeHis-end");
			return bean;
		} catch (BaseSupportException b) {
			bean.setSuccess(false);
			bean.setCode(b.getErrorCode());
			bean.setDesc(b.getMessage());
			return bean;
		} catch (Exception e) {
			bean.setSuccess(false);
			bean.setCode(ExceptionCode.SYSTEM_INNER_ERROR + "");
			String desc = apiToolsService.getExceptionMessage(ExceptionCode.SYSTEM_INNER_ERROR + "");
			bean.setDesc(desc);
			return bean;
		}
	}
	
	
	
	@RequestMapping(value = "/openapi", params = { "serviceid=ccc10008" })
	public @ResponseBody DefaultReturnBean<List<MapOfCity>> queryMapProvincialOrCity(HttpServletRequest request) {
		logger.info("查询地图展示任务所属那个【城市】-queryMapProvincialOrCity-start");
		DefaultReturnBean<List<MapOfCity>> bean=new DefaultReturnBean<List<MapOfCity>>();
		try {
			RequestParams params = RequestParamsHandler.handleRequest(request);
			logger.entry(params);
			String system_type = (String) params.getValue("system_type");
			String provincial = (String) params.getValue("provincial");
			String city = (String) params.getValue("city");
			String check=checkNull(new String[]{system_type},new String[]{"system_type"});
			if(!check.equals("")){
				bean.setCode(ExceptionCode.MISS_REQUIRED_PARAMS+"");
				bean.setDesc(apiToolsService.getExceptionMessage(bean.getCode()));
				return bean;
			}
			MapOfCity mapOfCity = new MapOfCity();
			mapOfCity.setCity(city);
			mapOfCity.setProvincial(provincial);
			mapOfCity.setSystem_type(system_type);
			List<MapOfCity> list=cccReportService.queryMapProvincialOrCity(mapOfCity);
			bean.setInfo(list);
			bean.setSuccess(true);
			bean.setCode(SysConstant.SUCCESS_CODE);
			bean.setDesc("成功");
			logger.info("查询地图展示任务所属那个【城市】-queryMapProvincialOrCity-end");
			return bean;
		} catch (BaseSupportException b) {
			bean.setSuccess(false);
			bean.setCode(b.getErrorCode());
			bean.setDesc(b.getMessage());
			return bean;
		} catch (Exception e) {
			bean.setSuccess(false);
			bean.setCode(ExceptionCode.SYSTEM_INNER_ERROR + "");
			String desc = apiToolsService.getExceptionMessage(ExceptionCode.SYSTEM_INNER_ERROR + "");
			bean.setDesc(desc);
			return bean;
		}
	}
	/**
	 * 
	 * @Title: queryProjectBillingDetails 
	 * @Description: 项目账单详情
	 * @param @param request
	 * @param @return 设定文件 
	 * @return DefaultReturnBean<List<MapOfCity>> 返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/openapi", params = { "serviceid=ccc10009" })
	public @ResponseBody DefaultReturnBean<Pagination> queryProjectBillingDetails(HttpServletRequest request) {
		logger.info("查询项目账单详情-queryProjectBillingDetails-start");
		DefaultReturnBean<Pagination> bean=new DefaultReturnBean<Pagination>();
		try {
			RequestParams params = RequestParamsHandler.handleRequest(request);
			logger.entry(params);
			String system_type = (String) params.getValue("system_type");
			String sortName = (String) params.getValue("sortName");
			String start = (String) params.getValue("start");
			String limit = (String) params.getValue("limit");
			String sortOrder = (String) params.getValue("sortOrder");
			String check=checkNull(new String[]{system_type,sortName,start,limit,sortOrder},new String[]{"system_type","sortName","start","limit","sortOrder"});
			if(!check.equals("")){
				bean.setCode(ExceptionCode.MISS_REQUIRED_PARAMS+"");
				bean.setDesc(apiToolsService.getExceptionMessage(bean.getCode()));
				return bean;
			}
			BillingDetails billingDetails = new BillingDetails();
			billingDetails.setSystem_type(system_type);
			Pagination pagination=cccReportService.queryProjectBillingDetails(billingDetails,Integer.valueOf(start), Integer.valueOf(limit), sortName, sortOrder);
			bean.setInfo(pagination);
			bean.setSuccess(true);
			bean.setCode(SysConstant.SUCCESS_CODE);
			bean.setDesc("成功");
			logger.info("查询项目账单详情-queryProjectBillingDetails-end");
			return bean;
		} catch (BaseSupportException b) {
			bean.setSuccess(false);
			bean.setCode(b.getErrorCode());
			bean.setDesc(b.getMessage());
			return bean;
		} catch (Exception e) {
			bean.setSuccess(false);
			bean.setCode(ExceptionCode.SYSTEM_INNER_ERROR + "");
			String desc = apiToolsService.getExceptionMessage(ExceptionCode.SYSTEM_INNER_ERROR + "");
			bean.setDesc(desc);
			return bean;
		}
	}
	
	
	private String checkNull(Object[] values, String[] desc) {
		if (values == null || desc == null) {
			return "校验的值和要校验的数据不符";
		} else if (values.length != desc.length) {
			return "校验的值和要校验的数据不符";
		} else {
			for (int i = 0; i < values.length; i++) {
				if (values[i] == null || values[i].equals("")) {
					return desc[i] + "不能为空";
				}
			}
		}
		return "";
	}
}
