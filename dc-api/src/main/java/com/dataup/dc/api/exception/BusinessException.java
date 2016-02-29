package com.dataup.dc.api.exception;

/**
 * 客户中心-异常处理
 * 
 * @author wenpeng.jin
 * 
 */
public class BusinessException extends Exception {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 817184270769503822L;
	
	private String errorCode;
	private String errorMessage;

	public BusinessException() {
		super();
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String errorMessage) {
		super(errorMessage);
	}
	
	public BusinessException(String errorMessage, Throwable cause) {
		super(errorMessage,cause);
	}

	public BusinessException(String errorMessage, String errorCode) {
		super(errorMessage);
		this.errorCode = errorCode;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


}
