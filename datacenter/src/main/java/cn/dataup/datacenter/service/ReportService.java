package cn.dataup.datacenter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dataup.datacenter.dao.PageDao;
import cn.dataup.datacenter.dao.ReportDao;
import cn.dataup.datacenter.entity.ReportDayUserRegs;
import cn.dataup.datacenter.entity.ReportSubmitTask;
import cn.dataup.datacenter.entity.ReportSubmitTasksClass;
import cn.dataup.datacenter.entity.ReportUserCollectTasks;

/**
 * 
 * @ClassName: ReportService 
 * @Description: 报表-服务 
 * @author zhanqiao.huang
 * @date 2015年7月17日 下午5:53:11
 */
@Service
public class ReportService {

	// private Logger logger = LogManager.getLogger(getClass());
	
	@Autowired
	private ReportDao reportDao;
	@Autowired
	private PageDao pageDao;
	
	/**
	 * 
	 * @Title: queryReportDayUserRegs 
	 * @Description: 统计日用户数-service
	 * @param @return 设定文件 
	 * @return List<ReportDayUserRegs> 返回类型 
	 * @throws
	 */
	
	public Map<Object, Object> queryReportDayUserRegs(int start, int size) {
		Map<Object, Object> m=new HashMap<Object, Object>();
		m.put("list", reportDao.queryReportDayUserRegs(start,size));
		m.put("pageCount", reportDao.queryReportUserRegsCount());
		return m;
	}
	
	public  Map<Object, Object> queryReportMonthUserRegs(int start, int size) {
		Map<Object, Object> m=new HashMap<Object, Object>();
		m.put("list", reportDao.queryReportMonthUserRegs(start,size));
		m.put("pageCount", reportDao.queryReportMonthUserRegsCount());
		return m;
	}
	
	public Map<Object, Object> queryReportAllUserRegs() {
		Map<Object, Object> m=new HashMap<Object, Object>();
		m.put("list", reportDao.queryReportAllUserRegs());
		m.put("pageCount", 1);
		return m;
	}
	
	public Map<Object, Object> queryReportWhereUserRegs(int start, int size,String userName) {
		Map<Object, Object> m = new HashMap<Object,Object>();
		m.put("list", reportDao.queryReportWhereUserRegs(start, size,userName));
		m.put("pageCount", reportDao.queryUserRegsPageCount(userName));
		return m;
	}
	public Map<Object, Object> queryReportUserWhereCity(int start, int size) {
		Map<Object, Object> m = new HashMap<Object,Object>();
		m.put("list", reportDao.queryReportUserWhereCity(start, size));
		m.put("pageCount", pageDao.queryReportUserWhereCityCount());
		return m;
	}
	
	public List<ReportDayUserRegs> queryReportDayUserRegsExcel() {
		List<ReportDayUserRegs> listDayUserRegs = reportDao.queryReportDayUserRegsExcel();
		return listDayUserRegs;
	}
	
	public int queryReportUserRegsTotal() {
		return reportDao.queryReportUserRegsTotal();
	}
	

	
	/**
	 * 
	 * @Title: queryReportUserCollectTasks 
	 * @Description: 日采集用户数 
	 * @param @param start
	 * @param @param size
	 * @param @return 设定文件 
	 * @return List<ReportUserCollectTasks> 返回类型 
	 * @throws
	 */
	public Map<Object, Object> queryReportDayUserCollectTasks(int start, int size,String userName,String systemtype) {
		Map<Object, Object> m = new HashMap<Object,Object>();
		m.put("list", reportDao.queryReportDayUserCollectTasks(start,size,userName,systemtype));
		m.put("pageCount", pageDao.queryReportDayUserCollectTasksCount(userName,systemtype));
		return m;
	}
	public Map<Object, Object> queryReportDayUserDefindCollectTasks(int start, int size,String startDate,String endDate,String userName,String systemtype) {
		Map<Object, Object> m = new HashMap<Object,Object>();
		m.put("list", reportDao.queryReportDayUserDefindCollectTasks(start,size,startDate,endDate,userName,systemtype));
		m.put("pageCount", pageDao.queryReportDayUserDefindCollectTasksCount(startDate, endDate, userName,systemtype));
		return m;
	}
	
	//excel
	public List<ReportUserCollectTasks> queryReportDayUserCollectTasksExcel(String qDate) {
		List<ReportUserCollectTasks> listCollectTasks = reportDao.queryReportDayUserCollectTasksExcel(qDate);
		return listCollectTasks;
	}
	
	public List<ReportUserCollectTasks> queryReportUserCollectTasks(int start, int size,String qDate) {
		List<ReportUserCollectTasks> listCollectTasks = reportDao.queryReportUserCollectTasks(start,size,qDate);
		return listCollectTasks;
	}
	
	public List<ReportUserCollectTasks> queryReportUserCollectTasksExcel(String qDate) {
		List<ReportUserCollectTasks> listCollectTasks = reportDao.queryReportUserCollectTasksExcel(qDate);
		return listCollectTasks;
	}
	
	//审核明细-data-day
	public Map<Object, Object> queryReportDayCollectTasks(int start, int size,String systemtype) {
		Map<Object, Object> m = new HashMap<Object,Object>();
		m.put("list", reportDao.queryReportDayCollectTasks(start,size,systemtype));
		m.put("pageCount", pageDao.queryReportDayCollectTasksCount(systemtype));
		return m;
	}
	//审核明细-data-dayself
	public Map<Object, Object> queryReportDaySelfCollectTasks(int start, int size,String startDate,String endDate,String systemtype) {
		Map<Object, Object> m = new HashMap<Object,Object>();
		m.put("list", reportDao.queryReportDaySelfCollectTasks(start, size, startDate, endDate,systemtype));
		m.put("pageCount", pageDao.queryReportDaySelfCollectTasksCount(startDate, endDate,systemtype));
		return m;
	}
	
	//excel
	public List<ReportUserCollectTasks> queryReportDayCollectTasksExcel(String qDate) {
		List<ReportUserCollectTasks> listCollectTasks = reportDao.queryReportDayCollectTasksExcel(qDate);
		return listCollectTasks;
	}
	
	public List<ReportUserCollectTasks> queryReportCollectTasks(int start, int size) {
		List<ReportUserCollectTasks> listCollectTasks = reportDao.queryReportCollectTasks(start,size);
		return listCollectTasks;
	}
	public List<ReportUserCollectTasks> queryReportDefinedCollectTasks(int start, int size,String startDate,String endDate) {
		List<ReportUserCollectTasks> listCollectTasks = reportDao.queryReportDefinedCollectTasks(start,size,startDate,endDate);
		return listCollectTasks;
	}
	//excel
	public List<ReportUserCollectTasks> queryReportCollectTasksExcel(String qDate) {
		List<ReportUserCollectTasks> listCollectTasks = reportDao.queryReportCollectTasksExcel(qDate);
		return listCollectTasks;
	}
	
	public List<ReportSubmitTasksClass> queryReportSubmitTasksClassExcel(String qDate) {
		List<ReportSubmitTasksClass> listCollectTasks = reportDao.queryReportSubmitTasksClassExcel(qDate);
		return listCollectTasks;
	}
	
	//dim-data-task-all
	public Map<Object, Object> queryReportSubmitTasksClass(int start, int size) {
		Map<Object, Object> m = new HashMap<Object,Object>();
		m.put("list", reportDao.queryReportSubmitTasksClass(start, size));
		m.put("pageCount",1);// pageDao.queryReportSubmitTasksClassCount());
		return m;
	}
	
	//dim-data-task-class
	public Map<Object, Object> queryReportDaySubmitTasksClass(int start, int size) {
		Map<Object, Object> m = new HashMap<Object,Object>();
		m.put("list", reportDao.queryReportDaySubmitTasksClass(start, size));
		m.put("pageCount", pageDao.queryReportDaySubmitTasksClassCount());
		return m;
	}
	
	//dim-data-task-month
	public Map<Object, Object> queryReportMonthSubmitTasksClass(int start, int size) {
		Map<Object, Object> m = new HashMap<Object,Object>();
		m.put("list", reportDao.queryReportMonthSubmitTasksClass(start, size));
		m.put("pageCount", pageDao.queryReportMonthSubmitTasksClassCount());
		return m;
	}
	//dim-data-task-self
	public Map<Object, Object> queryReportDaySelfSubmitTasksClass(int start, int size,String startDate,String endDate) {
		Map<Object, Object> m = new HashMap<Object,Object>();
		m.put("list", reportDao.queryReportDaySelfSubmitTasksClass(start, size,startDate,endDate));
		m.put("pageCount", pageDao.queryReportDaySelfSubmitTasksClassCount(startDate, endDate));
		return m;
	}
	public List<ReportSubmitTasksClass> queryReportDaySubmitTasksClassExcel(String qDate) {
		List<ReportSubmitTasksClass> listCollectTasks = reportDao.queryReportDaySubmitTasksClassExcel(qDate);
		return listCollectTasks;
	}
	
	/**
	 * 
	 * @Title: queryReportDayUserSubmitTasks 
	 * @Description: 用户提交任务
	 * @param @param start
	 * @param @param size
	 * @param @return 设定文件 
	 * @return List<ReportSubmitTask> 返回类型 
	 * @throws
	 */
	public Map<Object, Object> queryReportDayUserSubmitTasks(int start, int size,String userName,String systemtype) {
		Map<Object,Object> map = new HashMap<Object,Object>();
		List<ReportSubmitTask> listSubmitTasks = reportDao.queryReportDayUserSubmitTasks(start, size,userName,systemtype);
		int pageCount=pageDao.queryReportDayUserSubmitTasksCount(userName,systemtype);
		map.put("list", listSubmitTasks);
		map.put("pageCount", pageCount);
		return map;
	}
	public Map<Object, Object> queryReportDayALLUserSubmitTasks(int start, int size,String userName,String systemtype) {
		
		Map<Object,Object> map = new HashMap<Object,Object>();
		List<ReportSubmitTask> listSubmitTasks = reportDao.queryReportDayALLUserSubmitTasks(start, size,userName,systemtype);
		int pageCount=pageDao.queryReportDayALLUserSubmitTasksCount(userName,systemtype);
		map.put("list", listSubmitTasks);
		map.put("pageCount", pageCount);
		return map;
	}
	public Map<Object, Object> queryReportMonthUserSubmitTasks(int start, int size,String userName,String systemtype) {
		Map<Object,Object> map = new HashMap<Object,Object>();
		List<ReportSubmitTask> listSubmitTasks = reportDao.queryReportMonthUserSubmitTasks(start, size,userName,systemtype);
		int pageCount=pageDao.queryReportMonthUserSubmitTasksCount(userName,systemtype);
		map.put("list", listSubmitTasks);
		map.put("pageCount", pageCount);
		return map;
	}
	public Map<Object, Object> queryReportDefineSelfUserSubmitTasks(int start, int size,String startDate,String endDate,String userName,String systemtype) {
		
		Map<Object,Object> map = new HashMap<Object,Object>();
		List<ReportSubmitTask> listSubmitTasks = reportDao.queryReportDefineSelfUserSubmitTasks(start, size,startDate,endDate,userName,systemtype);
		int pageCount=pageDao.queryReportDefineSelfUserSubmitTasksCount(startDate,endDate,userName,systemtype);
		map.put("list", listSubmitTasks);
		map.put("pageCount", pageCount);
		return map;
	}
	
	//dim-data-submit_task
	public Map<Object, Object> queryReportDayDataSubmitTasks(int start, int size,String systemtype) {
		List<ReportSubmitTask> listSubmitTasks = reportDao.queryReportDayDataSubmitTasks(start, size,systemtype);
		Map<Object,Object> map = new HashMap<Object,Object>();
		int pageCount=pageDao.queryReportDayDataSubmitTasksCount(systemtype);
		map.put("list", listSubmitTasks);
		map.put("pageCount", pageCount);
		return map;
	}
	public Map<Object, Object> queryReportDayALLDataSubmitTasks(String systemtype) {
		List<ReportSubmitTask> listSubmitTasks = reportDao.queryReportDayALLDataSubmitTasks(systemtype);
		Map<Object,Object> map = new HashMap<Object,Object>();
		int pageCount=1;//pageDao.queryReportDayALLDataSubmitTasksCount();
		map.put("list", listSubmitTasks);
		map.put("pageCount", pageCount);
		return map;
	}
	public Map<Object, Object> queryReportMonthDataSubmitTasks(int start, int size,String systemtype) {
		List<ReportSubmitTask> listSubmitTasks = reportDao.queryReportMonthDataSubmitTasks(start, size,systemtype);
		Map<Object,Object> map = new HashMap<Object,Object>();
		int pageCount=pageDao.queryReportMonthDataSubmitTasksCount(systemtype);
		map.put("list", listSubmitTasks);
		map.put("pageCount", pageCount);
		return map;
	}
	public Map<Object, Object> queryReportSelfDataSubmitTasks(int start, int size,String startDate,String endDate,String systemtype) {
		List<ReportSubmitTask> listSubmitTasks = reportDao.queryReportSelfDataSubmitTasks(start, size,startDate,endDate,systemtype);
		Map<Object,Object> map = new HashMap<Object,Object>();
		int pageCount=pageDao.queryReportSelfDataSubmitTasksCount(startDate, endDate,systemtype);
		map.put("list", listSubmitTasks);
		map.put("pageCount", pageCount);
		return map;
	}
}
