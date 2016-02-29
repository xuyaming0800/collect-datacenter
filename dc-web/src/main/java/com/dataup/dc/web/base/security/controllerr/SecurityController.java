package com.dataup.dc.web.base.security.controllerr;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dataup.dc.api.exception.BusinessRunException;
import com.dataup.dc.api.exception.ExceptionCode;
import com.dataup.dc.api.service.ApiToolsService;
import com.dataup.dc.web.base.security.entity.AjaxEntity;
import com.dataup.dc.web.base.security.entity.LoginDTO;
import com.dataup.dc.web.base.security.service.SecurityService;
import com.dataup.dc.web.base.security.service.UsersService;

/**
 * 
 * @ClassName: SecurityController 
 * @Description: 用户登录、退出、校验用户是否注册 
 * @author zhanqiao.huang
 * @date 2015年9月10日 下午5:11:50
 */
@Controller
@RequestMapping("/security")
public class SecurityController {
	// private Logger log = LogManager.getLogger(getClass());

	@Autowired
	private SecurityService securityService = null;
	@Autowired
	private ApiToolsService apiToolsService = null;
	@Autowired
	private UsersService usersService = null;

	/**
	 * 登录
	 * 
	 * @param loginName
	 * @param password
	 * @param strRememberMe
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/doLogin")
	public @ResponseBody AjaxEntity doLogin(@RequestBody LoginDTO loginDTO)
			throws Exception {
		AjaxEntity ajaxEntity = new AjaxEntity();
		String check = checkNull(new String[] { loginDTO.getUsername(),
				loginDTO.getPassword() },
				new String[] { "username", "password" });
		try {
			if (!check.equals("")) {
				ajaxEntity.setCode(ExceptionCode.MISS_REQUEST_PARAMS + "");
				ajaxEntity.setDesc(apiToolsService
						.getExceptionMessage(ajaxEntity.getCode()));
				return ajaxEntity;
			}
			if (securityService.login(loginDTO))
				ajaxEntity.setSuccess(true);
		} catch (UnknownAccountException e) {// 用户名没有找到。
			ajaxEntity.setErrors(e.getMessage());
		} catch (IncorrectCredentialsException e) {// 用户名密码不匹配。
			ajaxEntity.setErrors(e.getMessage());
		} catch (AuthenticationException e) {// 其他的登录错误
			ajaxEntity.setErrors(e.getMessage());
		}
		return ajaxEntity;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/doAccountIsExists")
	public @ResponseBody AjaxEntity doAccountIsExists(@RequestParam("account") String account) throws Exception {
		AjaxEntity<Object []> ajaxEntity = new AjaxEntity<Object []>();
		String check=checkNull(new String[]{account},new String[]{"username"});
		try {
			if(!check.equals("")){
				ajaxEntity.setCode(ExceptionCode.MISS_REQUEST_PARAMS+"");
				ajaxEntity.setDesc(apiToolsService.getExceptionMessage(ajaxEntity.getCode()));
				return ajaxEntity;
			}
			Map<String, Object> m=usersService.queryInfoByUserName(account);
			String str=m.toString().trim();
			if("{}".equals(str)){
				ajaxEntity.setSuccess(false);
				ajaxEntity.setErrors("此账号不存在！");
			}else{
				String email=(String)m.get("mail");
				if(StringUtils.isNotBlank(email)){
					Object [] info = new Object[]{m};
					ajaxEntity.setInfo(info);
					ajaxEntity.setSuccess(true);
				}else{
					ajaxEntity.setSuccess(false);
					ajaxEntity.setErrors("此账号没有绑定邮箱！");
				}
			}
		} catch (BusinessRunException e) {//
			ajaxEntity.setErrors(e.getMessage());
		}  
		return ajaxEntity;
	}

 

	@RequestMapping("/login")
	public String login() throws Exception {
		if (SecurityUtils.getSubject().isAuthenticated()) {
			return "index";
		}
		return "login";
	}

	@RequestMapping("/logout")
	public String logout() throws Exception {
		securityService.logout();
		return "login";
	}

	@RequestMapping("/main")
	public String main() throws Exception {
		return "index/main";
	}
	@RequestMapping("/test")
	public String test() throws Exception {
		return "test/report_area";
	}

	@RequestMapping("/unauthorized")
	public String unauthorized() throws Exception {
		return "security/unauthorized";
	}

	@RequestMapping("/unauthenticated")
	public String unauthenticated() throws Exception {
		return "security/unauthenticated";
	}

	private String checkNull(String[] values, String[] desc) {
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
