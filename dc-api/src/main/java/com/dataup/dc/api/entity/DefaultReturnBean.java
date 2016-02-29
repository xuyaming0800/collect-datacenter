package com.dataup.dc.api.entity;

import com.dataup.dc.api.util.SysConstant;


 
public class DefaultReturnBean<T> implements java.io.Serializable{

 
	private static final long serialVersionUID = -7870758499941551643L;
	private Boolean success=false;
	private String code=SysConstant.FAULT_CODE;
	private String desc="失败";
	private T info;
	
	public DefaultReturnBean(){
		
	}
    public DefaultReturnBean(boolean initStatus){
		if(initStatus){
			this.success=true;
			this.code=SysConstant.SUCCESS_CODE;
			this.desc="成功";
		}
	}
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	
	
	

}
