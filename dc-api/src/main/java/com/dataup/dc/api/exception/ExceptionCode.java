package com.dataup.dc.api.exception;

public class ExceptionCode {
	
	/**
	 * 系统异常
	 */
	public static long SYSTEM_ERROR = 100001L;
	/**
	 * 缺少参数
	 */
	public static long MISS_REQUEST_PARAMS = 100002L;
	

	/**
	 * 邮箱发送验证码失败!
	 */
	public static long MAIL_SENDCODE_FALSE = 100080L;
	
	/**
	 * 系统内部异常:
	 */
	public static long SYSTEM_INNER_ERROR = 11000L;
	

	/**
	 * 验证码已过期,请重新获取.
	 */
	public static long MOBIL_SMSCODE_NOT_EXISTORINVALID = 100077L;
	
	/**
	 * 验证码不正确,请重新获取.
	 */
	public static long MOBIL_SMSCODE_ERROR = 100076L;
	/**
	 * 激活码已过期,请重新获取.
	 */
	public static long EMAIL_ACTIVATECODE_NOT_EXISTORINVALID = 100079L;
	
	/**
	 * 激活码不正确,请重新获取.
	 */
	public static long EMAIL_ACTIVATECODE_ERROR = 100081L;
	/**
	 * 参数值不正确
	 */
	public static long PARAM_VALUE_ERROR = 100078L;
	
	/**
	 * 缺少必填参数
	 */
	public static long MISS_REQUIRED_PARAMS = 300004L;
	
	
	/**
	 * 不能有两个同名参数
	 */
	public static long TWO_PARAMS_WITH_SAME_NAME = 300001L;
	
	/**
	 * 加密错误
	 */
	public static long ENCRYPT_ERROR = 300005L;
	/**
	 * 解密错误
	 */
	public static long DECRYPT_ERROR = 300006L;
}
