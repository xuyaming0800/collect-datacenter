package cn.dataup.datacenter.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dataup.datacenter.entity.RegsUserInfo;
import cn.dataup.datacenter.entity.UserTaskDetail;
import cn.dataup.datacenter.service.UserTaskService;

/**
 * 
 * @ClassName: UserTaskController
 * @Description: 用户维度 -控制层
 * @author zhanqiao.huang huangzhanqiao@dataup.cn
 * @date 2015年6月25日 上午11:23:19
 */

@Controller
@RequestMapping("/dimuser")
public class UserTaskController {

	/**
	 * 主页
	 * 
	 * @return
	 */
	@RequestMapping("/list")
	public String list() {
		System.out
				.println("list================================================");
		return "dimuser/userCollectQty";
	}

	/**
	 * 获取用户采集量
	 * 
	 * @return
	 */
	@RequestMapping("/fecthUserCollectQty")
	public @ResponseBody List<UserTaskDetail> fecthUserCollectQty() {
		return logger.exit(userTaskService.fecthUserCollectQty());
	}

	/**
	 * @Description: 跳转到采集用户数量变化
	 * @author 刘旭升
	 * @date 2015年7月8日 上午11:01:55
	 * @version V1.0
	 * @return
	 */
	@RequestMapping("/userCollectsChange")
	public String userCollectsChange() {
		logger.info("================userCollectsChange跳转==================");
		return "dimuser/userCollectsChange";
	}

	/**
	 * @Description: 按月份分组查询用变化数据
	 * @author 刘旭升
	 * @date 2015年7月8日 下午1:24:17
	 * @version V1.0
	 * @return
	 */
	@RequestMapping("/findUserCollectsChange")
	public @ResponseBody Map<String, Object> findUserCollectsChange(
			@RequestParam("beforeDateInteger") String beforeDateInteger,
			@RequestParam("nowDateInteger") String nowDateInteger) {
		if ("".equals(beforeDateInteger) || "".equals(nowDateInteger)) {
			return null;
		}
		return this.userTaskService.findUserRegsIdsByYearMonthDate(beforeDateInteger, nowDateInteger);
	}

	/**
	 * @Description: 查询指定key的用户集合
	 * @author 刘旭升
	 * @date 2015年7月9日 下午6:58:50
	 * @version V1.0
	 * @param dcUserRegsKey
	 * @return
	 */
	@RequestMapping("/findUserCollectsDetail")
	public @ResponseBody List<RegsUserInfo> findUserCollectsDetail(
			@RequestParam("key") String dcUserRegsKey) {
		Integer key = null;
		try {
			key = Integer.parseInt(dcUserRegsKey);
		} catch (Exception e) {
			logger.error("传入参数不是数字"+e);
			return null;
		}
		return this.userTaskService
				.findRegsUserInfoByKey(key);
	}

	@Autowired
	UserTaskService userTaskService = null;
	private Logger logger = LogManager.getLogger(getClass());
}
