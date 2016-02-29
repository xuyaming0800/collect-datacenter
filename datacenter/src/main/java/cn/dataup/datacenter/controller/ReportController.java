package cn.dataup.datacenter.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dataup.datacenter.entity.ReportAuditRate;
import cn.dataup.datacenter.entity.ReportDayUserRegs;
import cn.dataup.datacenter.entity.ReportSubmitTasksClass;
import cn.dataup.datacenter.entity.ReportUserCollectTasks;
import cn.dataup.datacenter.service.RateService;
import cn.dataup.datacenter.service.ReportService;
import cn.dataup.datacenter.util.DateUtils;
import cn.dataup.datacenter.util.ExcelUtil;
import cn.dataup.datacenter.util.ExcelUtils;

/**
 * 
 * @ClassName: ReportController
 * @Description: 报表-控制器
 * @author zhanqiao.huang
 * @date 2015年7月17日 下午5:56:07
 */
@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	ReportService reportService = null;
	@Autowired
	RateService rateService =null;
	private Logger logger = LogManager.getLogger(getClass());

	/**
	 * 主页
	 * 
	 * @return
	 */
	@RequestMapping("/report_day_user_regs/list")
	public String list() {
		return "inner/report_day_user_regs";
	}

	/**
	 * 获取统计日用户注册量
	 * 
	 * @return
	 */
	@RequestMapping("/report_day_user_regs/query")
	public @ResponseBody Map<?,?> queryReportDayUserRegs(
			@RequestParam("page") Integer page,
			@RequestParam("qDate") String qDate) {
		page = (null == page ? 1 : page);
		// 每页10个
		int start = (page - 1) * 10;
		Map<?,?> list = null;
		if (!StringUtils.isEmpty(qDate)) {
			if ("1".equals(qDate)) {
				list = reportService.queryReportDayUserRegs(start, 10);// day
			} else if ("2".equals(qDate)) {
				list = reportService.queryReportMonthUserRegs(start, 10);// month
			} else {
				list = reportService.queryReportAllUserRegs();// all
			}
		}
		return logger.exit(list);
	}
	
	

	@RequestMapping("/report_where_user_regs/list")
	public String regsWhereList() {
		return "dimuser/report_where_user_regs";
	}

	@RequestMapping("/report_where_user_regs/query")
	public @ResponseBody Map<?, ?> queryReportWhereUserRegs(
			@RequestParam("page") Integer page,
			@RequestParam("username") String username) {
		page = (null == page ? 1 : page);
		// 每页10个
		int start = (page - 1) * 10;
		return logger.exit(reportService.queryReportWhereUserRegs(start, 10,username));
	}

	/**
	 * 
	 * @Title: regsWhereCityList 
	 * @Description: 用户分布
	 * @param @return 设定文件 
	 * @return String 返回类型 
	 * @throws
	 */
	@RequestMapping("/report_city_user_regs/list")
	public String regsWhereCityList() {
		return "dimuser/report_city_user_regs";
	}

	@RequestMapping("/report_city_user_regs/query")
	public @ResponseBody Map<?, ?> queryReportUserWhereCity(
			@RequestParam("page") Integer page) {
		page = (null == page ? 1 : page);
		// 每页10个
		int start = (page - 1) * 10;
		return logger.exit(reportService.queryReportUserWhereCity(start, 10));
	}

	
	/**
	 * 主页
	 * 
	 * @return
	 */
	@RequestMapping("/report_user_collect_tasks/list")
	public String taskList() {
		return "inner/report_user_collect_tasks";
	}

	/**
	 * 审核明细-user
	 * 
	 * @return
	 */
	@RequestMapping("/report_user_collect_tasks/query")
	public @ResponseBody Map<?, ?> queryReportUserCollectTasks(
			@RequestParam("page") Integer page,
			@RequestParam("qTimeRange") String qTimeRange,
			@RequestParam("qStartDate") String qStartDate,
			@RequestParam("username") String username,
			@RequestParam("systemtype") String systemtype,
			@RequestParam("qEndDate") String qEndDate) {
		page = (null == page ? 1 : page);
		// 每页10个
		int start = (page - 1) * 10;
		Map<?,?> map = null;
		if(StringUtils.isNotBlank(qTimeRange)){
			if("1".equals(qTimeRange)){
				//每天
				map = reportService.queryReportDayUserCollectTasks(start, 10,username,systemtype);
			}else if("4".equals(qTimeRange)){
				//自定义
				map = reportService.queryReportDayUserDefindCollectTasks(start, 10,qStartDate,qEndDate,username,systemtype);
			}
		}
		return logger.exit(map);
	}
	/**
	 * 主页
	 * 
	 * @return
	 */
	@RequestMapping("/report_data_collect_tasks/list")
	public String dataTaskList() {
		return "inner/report_data_collect_tasks";
	}

	/**
	 * 审核明细-data
	 * 
	 * @return
	 */
	@RequestMapping("/report_data_collect_tasks/query")
	public @ResponseBody Map<?, ?> queryReporCollectTasks(
			@RequestParam("page") Integer page,
			@RequestParam("qTimeRange") String qTimeRange,
			@RequestParam("qStartDate") String qStartDate,
			@RequestParam("systemtype") String systemtype,
			@RequestParam("qEndDate") String qEndDate) {
		page = (null == page ? 1 : page);
		// 每页10个
		int start = (page - 1) * 10;
		Map<?, ?> m = null;
		if(StringUtils.isNotBlank(qTimeRange)){
			if("1".equals(qTimeRange)){
				//每天
				m = reportService.queryReportDayCollectTasks(start, 10,systemtype);
			}else if("4".equals(qTimeRange)){
				m = reportService.queryReportDaySelfCollectTasks(start, 10,qStartDate,qEndDate,systemtype);
			}
		}
		return logger.exit(m);
	}

	/**
	 * 主页
	 * 
	 * @return
	 */
	@RequestMapping("/report_submit_tasks_class/list")
	public String submitTaskClassList() {
		return "inner/report_submit_tasks_class";
	}

	/**
	 * 任务采集量-任务类型
	 * 
	 * @return
	 */
	@RequestMapping("/report_submit_tasks_class/query")
	public @ResponseBody Map<?, ?> queryReportSubmitTasksClass(
			@RequestParam("page") Integer page,
			@RequestParam("qTimeRange") String qTimeRange,
			@RequestParam("qStartDate") String qStartDate,
			@RequestParam("qEndDate") String qEndDate) {
		page = (null == page ? 1 : page);
		// 每页10个
		int start = (page - 1) * 10;

		Map<?, ?> m = null;
		if(StringUtils.isNotBlank(qTimeRange)){
			//1、日 2、月 3、所有 4、自定
			if("1".equals(qTimeRange)){
				m = reportService.queryReportDaySubmitTasksClass(start, 10);
			}else if("2".equals(qTimeRange)){
				m = reportService.queryReportMonthSubmitTasksClass(start, 10);
			}else if("3".equals(qTimeRange)){
				m = reportService.queryReportSubmitTasksClass(start, 10);
			}else if("4".equals(qTimeRange)){
				m = reportService.queryReportDaySelfSubmitTasksClass(start, 10,qStartDate,qEndDate);
			}
		}
		return logger.exit(m);
	}

	/**
	 * 用户注册数
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/report_day_user_regs/exprotExcel")
	public @ResponseBody String exprotExcel(HttpServletResponse response)
			throws Exception {
		ExcelUtil<ReportDayUserRegs> excelUtil = new ExcelUtil<ReportDayUserRegs>();
		OutputStream out = null;
		try {
			out = response.getOutputStream();// 取得输出流
			response.reset();// 清空输出流
			response.setHeader("Content-disposition", "attachment; filename="
					+ new String("每日注册用户数量".getBytes("GB2312"), "8859_1")
					+ ".xls");// 设定输出文件头
			response.setContentType("application/msexcel");// 定义输出类型
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] headers = { "日期", "注册数" };
		String[] columns = { "regDate", "dayTotal" };

		List<ReportDayUserRegs> list = reportService
				.queryReportDayUserRegsExcel();
		int total = reportService.queryReportUserRegsTotal();
		try {
			excelUtil.exportExcel("截止当日共" + total + "人注册!", "每日注册用户数量",
					headers, columns, list, out, "yyyy-MM-dd");
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
		return null;
	}

	/**
	 * 
	 * @Title: downloadUserCollectTasksExcel
	 * @Description: 任务统计-用户
	 * @param @param response
	 * @param @param status
	 * @param @param qDate 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@RequestMapping("/report_user_collect_tasks/exprotExcel")
	public void downloadUserCollectTasksExcel(HttpServletResponse response,
			@RequestParam("status") Integer status,
			@RequestParam("qDate") String qDate) {
		List<ReportUserCollectTasks> list = null;
		String sheetName = null;
		if (StringUtils.isEmpty(qDate))
			qDate = DateUtils.formatDate(new Date(), "yyyy-MM-dd");
		if (status == 0) {
			sheetName = "任务提交数量-用户-每日";
			list = reportService.queryReportDayUserCollectTasksExcel(qDate);
		}
		if (status == 1) {
			sheetName = "任务提交数量-用户-截止日总量";
			list = reportService.queryReportUserCollectTasksExcel(qDate);
		}

		// 标题数组
		List<String> titleList = new ArrayList<String>();
		titleList.add("日期");
		titleList.add("名称");
		titleList.add("昵称");
		titleList.add("采集任务总数量");
		titleList.add("审核中数量");
		titleList.add("审核成功数量");
		titleList.add("审核失败数量");
		titleList.add("申诉数量");
		List<List<String>> bodyList = new ArrayList<List<String>>();
		for (ReportUserCollectTasks task : list) {
			List<String> rowList = new ArrayList<String>();
			rowList.add(task.get_date());
			rowList.add(task.getUserName());
			rowList.add(task.getTrueName());
			rowList.add(task.getsAll());
			rowList.add(task.getS2());
			rowList.add(task.getS3());
			rowList.add(task.getS4());
			rowList.add(task.getS8());
			bodyList.add(rowList);
		}
		// 调用Excel生成工具
		ExcelUtils excelUtil = new ExcelUtils();
		excelUtil.setHaveTitle(true);// 是否有标题
		OutputStream out = null;
		try {
			// 输出
			if (bodyList != null) {
				HSSFWorkbook wb = excelUtil.createExcel(sheetName, titleList,
						bodyList);// 生成excel
				out = response.getOutputStream();// 取得输出流
				response.reset();// 清空输出流
				response.setHeader(
						"Content-disposition",
						"attachment; filename="
								+ new String(sheetName.getBytes("GB2312"),
										"8859_1") + ".xls");// 设定输出文件头
				response.setContentType("application/msexcel");// 定义输出类型
				wb.write(out);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

	/**
	 * 
	 * @Title: downloadDataCollectTasksExcel
	 * @Description: 任务统计-数据
	 * @param @param response
	 * @param @param status
	 * @param @param qDate 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@RequestMapping("/report_data_collect_tasks/exprotExcel")
	public void downloadDataCollectTasksExcel(HttpServletResponse response,
			@RequestParam("status") Integer status,
			@RequestParam("qDate") String qDate) {
		List<ReportUserCollectTasks> list = null;
		String sheetName = null;
		if (StringUtils.isEmpty(qDate))
			qDate = DateUtils.formatDate(new Date(), "yyyy-MM-dd");
		if (status == 0) {
			sheetName = "任务提交数量-数据-每日";
			list = reportService.queryReportDayCollectTasksExcel(qDate);
		}
		if (status == 1) {
			sheetName = "任务提交数量-数据-截止日总量";
			list = reportService.queryReportCollectTasksExcel(qDate);
		}

		// 标题数组
		List<String> titleList = new ArrayList<String>();
		titleList.add("日期");
		titleList.add("采集任务总数量");
		titleList.add("审核中数量");
		titleList.add("审核成功数量");
		titleList.add("审核失败数量");
		titleList.add("申诉数量");
		List<List<String>> bodyList = new ArrayList<List<String>>();
		for (ReportUserCollectTasks task : list) {
			List<String> rowList = new ArrayList<String>();
			rowList.add(task.get_date());
			rowList.add(task.getsAll());
			rowList.add(task.getS2());
			rowList.add(task.getS3());
			rowList.add(task.getS4());
			rowList.add(task.getS8());
			bodyList.add(rowList);
		}
		// 调用Excel生成工具
		ExcelUtils excelUtil = new ExcelUtils();
		excelUtil.setHaveTitle(true);// 是否有标题
		OutputStream out = null;
		try {
			// 输出
			if (bodyList != null) {
				HSSFWorkbook wb = excelUtil.createExcel(sheetName, titleList,
						bodyList);// 生成excel
				out = response.getOutputStream();// 取得输出流
				response.reset();// 清空输出流
				response.setHeader(
						"Content-disposition",
						"attachment; filename="
								+ new String(sheetName.getBytes("GB2312"),
										"8859_1") + ".xls");// 设定输出文件头
				response.setContentType("application/msexcel");// 定义输出类型
				wb.write(out);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

	@RequestMapping("/report_class_collect_tasks/exprotExcel")
	public void downloadSubmitTasksClassExcel(HttpServletResponse response,
			@RequestParam("status") Integer status,
			@RequestParam("qDate") String qDate) {
		List<ReportSubmitTasksClass> list = null;
		String sheetName = null;
		if (StringUtils.isEmpty(qDate))
			qDate = DateUtils.formatDate(new Date(), "yyyy-MM-dd");
		if (status == 0) {
			sheetName = "任务提交数量-类别-每日";
			list = reportService.queryReportDaySubmitTasksClassExcel(qDate);
		}
		if (status == 1) {
			sheetName = "任务提交数量-类别-截止日总量";
			list = reportService.queryReportSubmitTasksClassExcel(qDate);
		}
		// 标题数组
		List<String> titleList = new ArrayList<String>();
		titleList.add("日期");
		titleList.add("交通标志牌");
		titleList.add("楼顶广告");
		titleList.add("两面立柱");
		titleList.add("LED");
		titleList.add("绿化带灯箱");
		titleList.add("公交站亭");
		titleList.add("墙体广告位");
		titleList.add("过路天桥");
		titleList.add("三面立柱");
		titleList.add("侧牌");
		titleList.add("公共自行车亭");
		titleList.add("灯箱");
		titleList.add("指路牌灯箱");
		List<List<String>> bodyList = new ArrayList<List<String>>();
		for (ReportSubmitTasksClass task : list) {
			List<String> rowList = new ArrayList<String>();
			rowList.add(task.get_date());//DateUtils.formatDate(task.getAuditDate(), "yyyy-MM-dd"));
			rowList.add(task.getS1());
			rowList.add(task.getS2());
			rowList.add(task.getS3());
			rowList.add(task.getS4());
			rowList.add(task.getS5());
			rowList.add(task.getS6());
			rowList.add(task.getS7());
			rowList.add(task.getS8());
			rowList.add(task.getS9());
			rowList.add(task.getS10());
			rowList.add(task.getS11());
			rowList.add(task.getS12());
			rowList.add(task.getS13());
			bodyList.add(rowList);
		}
		// 调用Excel生成工具
		ExcelUtils excelUtil = new ExcelUtils();
		excelUtil.setHaveTitle(true);// 是否有标题
		OutputStream out = null;
		try {
			// 输出
			if (bodyList != null) {
				HSSFWorkbook wb = excelUtil.createExcel(sheetName, titleList,
						bodyList);// 生成excel
				out = response.getOutputStream();// 取得输出流
				response.reset();// 清空输出流
				response.setHeader(
						"Content-disposition",
						"attachment; filename="
								+ new String(sheetName.getBytes("GB2312"),
										"8859_1") + ".xls");// 设定输出文件头
				response.setContentType("application/msexcel");// 定义输出类型
				wb.write(out);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}
	
	
	
	//----------------------------------------------------------------用户任务提交报表统计-----------------------------------------------------------------
 
	@RequestMapping("/report_user_submit_tasks/list")
	public String submitTaskList() {
		return "dimuser/report_user_submit_tasks";
	}
	@RequestMapping("/report_user_submit_tasks/query")
	public @ResponseBody Map<?, ?> queryReportUserSubmitTasks(
			@RequestParam("page") Integer page,@RequestParam("qTimeRange") String qTimeRange,
			@RequestParam("qDateStart") String qDateStart,
			@RequestParam("qDateEnd") String qDateEnd,
			@RequestParam("username") String username,
			@RequestParam("systemtype") String systemtype
			) {
		page = (null == page ? 1 : page);
		// 每页10个
		int start = (page - 1) * 10;
		Map<?,?> map = null;
		if(StringUtils.isNotBlank(qTimeRange)){
			//1、日 2、月 3、所有 4、自定
			if("1".equals(qTimeRange)){
				map = reportService.queryReportDayUserSubmitTasks(start, 10,username,systemtype);
			}else if("2".equals(qTimeRange)){
				map = reportService.queryReportMonthUserSubmitTasks(start, 10,username,systemtype);
			}else if("3".equals(qTimeRange)){
				map = reportService.queryReportDayALLUserSubmitTasks(start, 10,username,systemtype);
			}else if("4".equals(qTimeRange)){
				map = reportService.queryReportDefineSelfUserSubmitTasks(start, 10,qDateStart,qDateEnd,username,systemtype);
			}
		}
		return logger.exit(map);
	}
	
	
	
	//----------------------------------------------------------------任务提交数据报表统计-----------------------------------------------------------------
	@RequestMapping("/report_data_submit_tasks/list")
	public String submitDataTaskList() {
		return "dimdata/report_data_submit_tasks";
	}
	@RequestMapping("/report_data_submit_tasks/query")
	public @ResponseBody Map<?, ?> queryReportDataSubmitTasks(
			@RequestParam("page") Integer page,@RequestParam("qTimeRange") String qTimeRange,
			@RequestParam("qStartDate") String qDateStart,
			@RequestParam("systemtype") String systemtype,
			@RequestParam("qEndDate") String qDateEnd
			) {
		page = (null == page ? 1 : page);
		// 每页10个
		int start = (page - 1) * 10;
		Map<?, ?> m = null;
		if(StringUtils.isNotBlank(qTimeRange)){
			//1、日 2、月 3、所有 4、自定
			if("1".equals(qTimeRange)){
				m = reportService.queryReportDayDataSubmitTasks(start, 10,systemtype);
			}else if("2".equals(qTimeRange)){
				m = reportService.queryReportMonthDataSubmitTasks(start, 10,systemtype);
			}else if("3".equals(qTimeRange)){
				m = reportService.queryReportDayALLDataSubmitTasks(systemtype);
			}else if("4".equals(qTimeRange)){
				m = reportService.queryReportSelfDataSubmitTasks(start, 10,qDateStart,qDateEnd,systemtype);
			}
		}
		return logger.exit(m);
	}
	
	//-------------------------------------------------------------------------------审核-----------------------------------------------
	@RequestMapping("/report_rate_audit_tasks/list")
	public String auditRateList() {
		return "percent/report_rate_audit_tasks";
	}
	
	@RequestMapping("/report_rate_audit_tasks/query")
	public @ResponseBody List<ReportAuditRate> queryReportRateAuditTasks(
			@RequestParam("page") Integer page,@RequestParam("qTimeRange") String qTimeRange,
			@RequestParam("qDateStart") String qDateStart,
			@RequestParam("qDateEnd") String qDateEnd,@RequestParam("systemtype") String systemtype
			) {
		page = (null == page ? 1 : page);
		// 每页10个
		int start = (page - 1) * 10;
		List<ReportAuditRate> list = null;
		if(StringUtils.isNotBlank(qTimeRange)){
			
			//1、日 2、月 3、所有 4、自定
			if("1".equals(qTimeRange)){
//				list = rateService.queryAuditRate();//(start, 10);
			}else if("2".equals(qTimeRange)){
				list = rateService.queryMonthAuditRate(systemtype);//(start, 10);
			}else if("3".equals(qTimeRange)){
				list = rateService.queryAuditRate(systemtype);
			}else if("4".equals(qTimeRange)){
//				list = reportService.queryReportSelfDataSubmitTasks(start, 10,qDateStart,qDateEnd);
			}
		}
		return logger.exit(list);
	}
	
}
