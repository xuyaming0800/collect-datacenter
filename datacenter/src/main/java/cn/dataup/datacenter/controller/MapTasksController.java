package cn.dataup.datacenter.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dataup.datacenter.entity.MapTask;
import cn.dataup.datacenter.service.MapTaskService;

@Controller
@RequestMapping("/map")
public class MapTasksController {
	private Logger logger = LogManager.getLogger(getClass());
	@Autowired
	MapTaskService mapTaskService = null;

	@RequestMapping("/map_audit_task/list")
	public String indexPage() {
		return "map/map_audit_task";
	}

	@RequestMapping("/map_audit_task/query")
	public @ResponseBody List<MapTask> queryReportUserWhereCity(
			@RequestParam("status") Integer status,@RequestParam("system") Integer system) {
		return logger.exit(mapTaskService.queryAudit(status,system));
	}
}
