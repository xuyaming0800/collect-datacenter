package com.dataup.dc.web.util;



import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

/**
 * 获取系统配置参数
 * @author liumk
 *
 */
public class Config {
	private static Logger log = LogManager.getLogger(Config.class);
	private static final String configFile = "system.properties";
    private static Properties properties = new Properties();
    
    public static String getConfig(String key) {
    	try {
    	    if (properties.isEmpty()) {
    		    InputStream is = Config.class.getClassLoader().getResourceAsStream(configFile);
    	        properties.load(is);
    	    }
    	}
    	catch (Exception e) {
    		log.error("读取配置文件出错", e);
//    		throw new BaseSupportException(ExceptionCode.SYSTEM_INNER_ERROR, "读取配置文件出错");
    	}
    	return properties.getProperty(key);
    }
    
    public static String getConfig(String key, String defaultValue) {
    	String result = getConfig(key);
    	if (StringUtils.isEmpty(result)) result = defaultValue;
    	return result;
    }
    
    public static String getTomcatPath(){
    	String path=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		path=path+"../../";
		path=path+"../../";
		return path;
	}
    
}
