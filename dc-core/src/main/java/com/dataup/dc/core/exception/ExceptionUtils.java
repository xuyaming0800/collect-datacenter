package com.dataup.dc.core.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dataup.dc.api.exception.BusinessRunException;

import autonavi.online.framework.property.PropertiesConfig;
import autonavi.online.framework.property.PropertiesConfigUtil;


public class ExceptionUtils {
	private static Logger logger = LogManager.getLogger(ExceptionUtils.class);
	private static ExceptionUtils dCExceptionUtils;
	private PropertiesConfig pc=null;
	
	private ExceptionUtils()throws Exception{
		pc=PropertiesConfigUtil.getPropertiesConfigInstance();
	}
	
	public static ExceptionUtils getInstance(){
		try {
			if(dCExceptionUtils==null){
				dCExceptionUtils=new ExceptionUtils();
			}
			return dCExceptionUtils;
		} catch (Exception e) {
			logger.error("初始化异常工具失败", e);
			throw new BusinessRunException("初始化异常工具失败，请检查");
		}
	}
	
	public String getMessage(String errorCode){
		String message="";
		message=(String)pc.getProperty(errorCode);
		return message;
	}

}
