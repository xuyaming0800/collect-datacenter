package com.dataup.dc.web.base.security.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.dataup.dc.web.base.security.entity.LoginDTO;
import com.dataup.dc.web.base.security.service.SecurityService;


/**
 * 用于进行用户登入登出
 * 
 * @author jia.miao
 * 
 */
@Service
public class SecurityServiceImpl implements SecurityService {
	private Logger log = LogManager.getLogger(getClass());

	private Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	/**
	 * 登录
	 */
	public boolean login(LoginDTO loginDTO)
			throws Exception {
		// 创建用户名和密码的令牌
		UsernamePasswordToken token = new UsernamePasswordToken(
				loginDTO.getUsername(), loginDTO.getPassword());
		// 记录该令牌，如果不记录则类似购物车功能不能使用。
		token.setRememberMe(loginDTO.isRemember());
		// subject理解成权限对象。类似user
		Subject subject = this.getSubject();
		if (!subject.isAuthenticated()) {// 如果没有登录
			try {
				subject.login(token);// 进行登录操作
			} catch (UnknownAccountException e) {// 用户名没有找到。
				log.error("用户名没有找到", e);
				throw new UnknownAccountException("用户名没有找到");
			} catch (IncorrectCredentialsException e) {// 用户名密码不匹配。
				log.error("用户名密码不匹配", e);
				throw new IncorrectCredentialsException("用户名密码不匹配");
			} catch (AuthenticationException e) {// 其他的登录错误
				log.error("登录失败", e);
				throw new AuthenticationException("登录失败");
			}
			// 验证是否成功登录的方法
			if (subject.isAuthenticated()) {
				Session session = subject.getSession();// 获取session
				session.setAttribute("userName", loginDTO.getUsername());// 用户名
				return true;
			}
		} else
			return true;
		return false;
	}

	/**
	 * 登出
	 */
	public void logout() throws Exception {
		this.getSubject().logout();
	}

}
