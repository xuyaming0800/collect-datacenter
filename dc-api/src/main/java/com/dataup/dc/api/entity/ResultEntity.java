package com.dataup.dc.api.entity;

public class ResultEntity implements java.io.Serializable {

	private static final long serialVersionUID = 883511084525128741L;

	public ResultEntity() {

	}

	/**
	 * 是否成功
	 */
	private boolean success;

	/**
	 * 代码
	 */
	private String code;

	/**
	 * 描述
	 */
	private String desc;

	/**
	 * 返回信息
	 */
	private Object info;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
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

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "ResultEntity [success=" + success + ", code=" + code
				+ ", desc=" + desc + ", info=" + info + "]";
	}

}
