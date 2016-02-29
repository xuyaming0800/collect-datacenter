package com.dataup.dc.api.service;

import java.util.Map;

public interface MailService {

	/**
	 * 发送验证码
	 * @param mailAddress 邮件
	 * @param validtype 验证类型
	 * @return
	 */
	public Map<String, String> sendMailCode(String mailAddress, String validtype);
	
	
	/**
	 * 验证邮箱验证啊
	 * @param mail 邮箱
	 * @param validcode 验证码
	 * @param validtype 验证类型
	 */
	public void validateMailCode(String mail, String validcode, String validtype);
	
	
	/**
	 * 发送邮件修改密码
	 * @param username 用户名
	 * @param url url
	 * @param mail 邮箱地址
	 */
	public void sendModifyPwdMail(String username, String url, String mail);
	
	/**
	 * 同步文件次数预警邮件
	 * @param usernames
	 * @param content
	 */
	public void sendSynFileCountMessage(String usernames, String content);
	
	/**
	 * @Description: 发送邮箱激活码
	 * @author xudsheng.liu
	 * @date 2015年9月11日 下午4:13:08 
	 * @version V1.0 
	 * @param url
	 * @param validtype
	 * @param mail
	 * @return
	 */
	public void sendMailActivateCode(String username, String url, String mail,
			String validtype);
	
	/**
	 * @Description: 验证邮箱激活码
	 * @author xusheng.liu
	 * @date 2015年9月14日 下午2:08:22 
	 * @version V1.0 
	 * @param username
	 * @param mail
	 */
	public void activateEmail(String username,String mail);
}
