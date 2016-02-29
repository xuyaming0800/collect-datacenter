package com.dataup.dc.core.service.impl;

import org.springframework.stereotype.Service;

import com.dataup.dc.api.service.ApiToolsService;
import com.dataup.dc.core.exception.ExceptionUtils;

 
@Service("apiToolsService")
public class ApiToolsServiceImpl implements ApiToolsService {
	
    /**
     * 获取错误信息
     */
	@Override
	public String getExceptionMessage(String code) {
		return ExceptionUtils.getInstance().getMessage(code);
	}
	
	 /**
     * 获取业务信息
     */
	@Override
	public String getMessage(String code) {
		return ExceptionUtils.getInstance().getMessage(code);
	}

}
