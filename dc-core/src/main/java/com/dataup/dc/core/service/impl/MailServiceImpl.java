package com.dataup.dc.core.service.impl;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataup.dc.api.exception.ExceptionCode;
import com.dataup.dc.api.exception.support.BaseSupportException;
import com.dataup.dc.api.service.MailService;
import com.dataup.dc.api.util.OpenApiConstant;
import com.dataup.dc.core.exception.ExceptionUtils;
import com.dataup.dc.core.mail.SimpleMailSender;
import com.dataup.dc.core.util.RandomStringUtils;
import com.dataup.dc.core.util.cache.CacheConstant;
import com.dataup.dc.core.util.cache.NodeCacheServer;

import autonavi.online.framework.property.PropertiesConfig;
import autonavi.online.framework.property.PropertiesConfigUtil;
 
/**
 * 
 * @ClassName: MailServiceImpl 
 * @Description:  邮箱验证码发送
 * @author zhanqiao.huang
 * @date 2015年9月10日 下午5:52:19
 */
@Service("mailService")
public class MailServiceImpl implements MailService {

	private  final Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	private NodeCacheServer nodeCacheServer;
	@Autowired
	private SimpleMailSender simpleMailSender;
	
	/**
	 * 发送验证码
	 * @param mailAddress 邮件
	 * @param validtype 验证类型
	 * @return
	 */
	public Map<String, String> sendMailCode(String mailAddress, String validtype) {
		logger.entry(mailAddress, validtype);
		
		try {
			PropertiesConfig pc = PropertiesConfigUtil.getPropertiesConfigInstance();
			String mailContent = "";
			String mailSubject = "";
			int[] arr = new int[] { 2 };
			if(validtype.equals(OpenApiConstant.MAIL_VALIDCODE)){
				mailContent = (String)pc.getProperty(OpenApiConstant.SYSTEM_MAIL_VALIDATE_CONTENT);
				mailSubject = (String)pc.getProperty(OpenApiConstant.SYSTEM_MAIL_VALIDATE_SUBJECT);
			}
			String random = RandomStringUtils.getRandomString(4, arr);
			Map<String, String> resultMap = new HashMap<String, String>();
			mailContent = MessageFormat.format(mailContent, random);
			// 这个类主要来发送邮件
			
			if (!simpleMailSender.sendMail(mailAddress, mailSubject, mailContent, 0)) {
				String code = ExceptionCode.MAIL_SENDCODE_FALSE+"";
				String message = ExceptionUtils.getInstance().getMessage(code);
				BaseSupportException bse = new BaseSupportException(message, code);
				throw bse;
			}
			
			resultMap.put("VALIDCODE", random);
			
			// 将邮箱验证码加入缓存
			if(validtype.equals(OpenApiConstant.MAIL_VALIDCODE)){
				String key = CacheConstant.MAIL_CODE_CACHE + "!" + OpenApiConstant.MAIL_VALIDCODE + "_" + mailAddress;
				String secondStr = (String)pc.getProperty(CacheConstant.MAIL_CODE_EXPIRE_TIME);
				int second = Integer.parseInt(secondStr);
				nodeCacheServer.putCacheValue(key, random, second);
			}
			
			
			return resultMap;
		}catch(Exception e) {
			if(e instanceof BaseSupportException) {
				throw (BaseSupportException)e;
			}
			
			logger.error("sendMailCode error: ", e);
			String code = ExceptionCode.SYSTEM_INNER_ERROR + "";
			String desc = ExceptionUtils.getInstance().getMessage(code);
			BaseSupportException bse = new BaseSupportException(desc, code);
			throw bse;
		}
	}
	
	
	
	/**
	 * 验证邮箱验证啊
	 * @param mail
	 * @param validcode
	 * @param validtype
	 */
	public void validateMailCode(String mailAddress, String validcode, String validtype) {
		logger.entry(mailAddress, validcode, validtype);
		try {
			String key = validtype + "_" + mailAddress;
			if (OpenApiConstant.MAIL_VALIDCODE.equals(validtype)){
				key = CacheConstant.MAIL_CODE_CACHE + "!" + key;
			} else if (OpenApiConstant.MAIL_VALIDURL_TYPE_RESPWD.equals(validtype)){
				key = CacheConstant.MAIL_URL_CACHE + "!" + key;
			}else {
				String code = ExceptionCode.PARAM_VALUE_ERROR + "";
				String desc = ExceptionUtils.getInstance().getMessage(code);
				BaseSupportException bse = new BaseSupportException(desc, code);
				throw bse;
			}
			
			String value = nodeCacheServer.getCacheValue(key);
			if(null == value) {
				String code = ExceptionCode.MOBIL_SMSCODE_NOT_EXISTORINVALID + "";
				String desc = ExceptionUtils.getInstance().getMessage(code);
				BaseSupportException bse = new BaseSupportException(desc, code);
				throw bse;
			}
			
			if(!validcode.equals(value)){
				String code = ExceptionCode.MOBIL_SMSCODE_ERROR + "";
				String desc = ExceptionUtils.getInstance().getMessage(code);
				BaseSupportException bse = new BaseSupportException(desc, code);
				throw bse;
			}
			
			//删除异常
			nodeCacheServer.removeCacheValue(key);
			
		}catch(Exception e) {
			if(e instanceof BaseSupportException) {
				throw (BaseSupportException)e;
			}
			
			logger.error("validateMailCode error: ", e);
			String code = ExceptionCode.SYSTEM_INNER_ERROR + "";
			String desc = ExceptionUtils.getInstance().getMessage(code);
			BaseSupportException bse = new BaseSupportException(desc, code);
			throw bse;
		}
		
	}
	
	
	
	/**
	 * 发送邮件修改密码
	 * @param username 用户名
	 * @param url url
	 * @param mail 邮箱地址
	 */
	public void sendModifyPwdMail(String username, String url, String mail) {
		
		try {
			PropertiesConfig pc = PropertiesConfigUtil.getPropertiesConfigInstance();
			
			String validcode = RandomStringUtils.getRandomString(8, new int[] {0, 1, 2});
			
			String mailContent = (String)pc.getProperty(OpenApiConstant.SYSTEM_MAIL_RESPWDURL_CONTENT);
			String mailSubject = (String)pc.getProperty(OpenApiConstant.SYSTEM_MAIL_RESPWDURL_SUBJECT);
			String href = null;
			if(url.indexOf("?") == -1){
				href = url + "?validcode=" + validcode + "&username=" + username +"&email="+mail;
			} else {
				href = url + "&validcode=" + validcode + "&username=" + username +"&email="+mail;
			}
			
			mailContent = MessageFormat.format(mailContent, username, href, href);
			
			if (!simpleMailSender.sendMail(mail, mailSubject, mailContent, 0)) {
				String code = ExceptionCode.MAIL_SENDCODE_FALSE + "";
				String desc = ExceptionUtils.getInstance().getMessage(code);
				BaseSupportException bse = new BaseSupportException(desc, code);
				throw bse;
			}
			
			String key = CacheConstant.MAIL_URL_CACHE + "!" + OpenApiConstant.MAIL_VALIDURL_TYPE_RESPWD + "_" + username;
			String secondStr = (String)pc.getProperty(CacheConstant.MAIL_VALIDURL_TYPE_RESPWD_EXPIRE_TIME);
			int second = Integer.parseInt(secondStr);
			nodeCacheServer.putCacheValue(key, validcode, second);
			
		}catch(Exception e) {
			if(e instanceof BaseSupportException) {
				throw (BaseSupportException)e;
			}
			
			logger.error("sendModifyPwdMail error: ", e);
			String code = ExceptionCode.SYSTEM_INNER_ERROR + "";
			String desc = ExceptionUtils.getInstance().getMessage(code);
			BaseSupportException bse = new BaseSupportException(desc, code);
			throw bse;
		}
	
		
	}
	
	/**
	 * 同步文件次数预警邮件
	 * @param usernames
	 * @param content
	 */
	public void sendSynFileCountMessage(String usernames, String content){
		try {
			simpleMailSender.sendMail(usernames, "金额同步文件上传次数过多", content, 1);
		} catch (Exception e) {
			logger.error("同步文件次数预警邮件发送异常 ", e);
		}
		
	}


	/**
	 * @Description: 发送邮箱激活码
	 * @author xudsheng.liu
	 * @date 2015年9月11日 下午4:13:08 
	 * @version V1.0 
	 * @param mailAddress
	 * @param validtype
	 */
	public void sendMailActivateCode(String username, String url, String mail,
			String validtype) {
		logger.entry(username, validtype,url,mail);
		try {
			PropertiesConfig pc = PropertiesConfigUtil.getPropertiesConfigInstance();
			
			String validcode = RandomStringUtils.getRandomString(16, new int[] {0, 1, 2, 3});
			
			String mailContent="";
			String mailSubject="";
			if(validtype.equals(OpenApiConstant.MAIL_ACTIVATECODE)){
				mailContent = (String)pc.getProperty(OpenApiConstant.SYSTEM_MAIL_ACTIVATE_CONTENT);
				mailSubject = (String)pc.getProperty(OpenApiConstant.SYSTEM_MAIL_ACTIVATE_SUBJECT);
			}
			String href = null;
			if(url.indexOf("?") == -1){
				href = url + "?activateCode=" + validcode + "&username=" + username +"&email="+mail;
			} else {
				href = url + "&activateCode=" + validcode + "&username=" + username +"&email="+mail;
			}
			
			mailContent = MessageFormat.format(mailContent, username, href, href);
			
			if (!simpleMailSender.sendMail(mail, mailSubject, mailContent, 0)) {
				String code = ExceptionCode.MAIL_SENDCODE_FALSE + "";
				String desc = ExceptionUtils.getInstance().getMessage(code);
				BaseSupportException bse = new BaseSupportException(desc, code);
				throw bse;
			}
			
			String key = CacheConstant.MAIL_URL_CACHE + "!" + OpenApiConstant.MAIL_ACTIVATECODE + "_" + username;
			String secondStr = (String)pc.getProperty(CacheConstant.MAIL_ACTIVATE_EXPIRE_TIME);
			int second = Integer.parseInt(secondStr);
			//删除异常
			nodeCacheServer.removeCacheValue(key);
			nodeCacheServer.putCacheValue(key, validcode, second);
			
		}catch(Exception e) {
			if(e instanceof BaseSupportException) {
				throw (BaseSupportException)e;
			}
			logger.error("sendModifyPwdMail error: ", e);
			String code = ExceptionCode.SYSTEM_INNER_ERROR + "";
			String desc = ExceptionUtils.getInstance().getMessage(code);
			BaseSupportException bse = new BaseSupportException(desc, code);
			throw bse;
		}
	}
	/**
	 * @Description: 验证邮箱激活码
	 * @author xusheng.liu
	 * @date 2015年9月14日 下午1:56:09 
	 * @version V1.0 
	 * @param mailAddress
	 * @param validcode
	 */
	public void activateEmail(String username, String activateCode ) {
		logger.entry(username, activateCode );
		try {
			String key = CacheConstant.MAIL_URL_CACHE + "!" + OpenApiConstant.MAIL_ACTIVATECODE + "_" + username;
			
			String value = nodeCacheServer.getCacheValue(key);
			if(null == value) {
				String code = ExceptionCode.EMAIL_ACTIVATECODE_NOT_EXISTORINVALID + "";
				String desc = ExceptionUtils.getInstance().getMessage(code);
				BaseSupportException bse = new BaseSupportException(desc, code);
				throw bse;
			}
			
			if(!activateCode.equals(value)){
				String code = ExceptionCode.EMAIL_ACTIVATECODE_ERROR + "";
				String desc = ExceptionUtils.getInstance().getMessage(code);
				BaseSupportException bse = new BaseSupportException(desc, code);
				throw bse;
			}
			
			//删除异常
			nodeCacheServer.removeCacheValue(key);
			
		}catch(Exception e) {
			if(e instanceof BaseSupportException) {
				throw (BaseSupportException)e;
			}
			
			logger.error("email activatecode error: ", e);
			String code = ExceptionCode.SYSTEM_INNER_ERROR + "";
			String desc = ExceptionUtils.getInstance().getMessage(code);
			BaseSupportException bse = new BaseSupportException(desc, code);
			throw bse;
		}
		
	}
}
