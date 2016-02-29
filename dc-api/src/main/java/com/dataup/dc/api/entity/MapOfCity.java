package com.dataup.dc.api.entity;

import java.io.Serializable;

public class MapOfCity implements Serializable {

	private static final long serialVersionUID = 2832587363700637531L;
	private String city;// 城市
	private String system_type;// 系统类型
	private String provincial;// 省

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSystem_type() {
		return system_type;
	}

	public void setSystem_type(String system_type) {
		this.system_type = system_type;
	}

	public String getProvincial() {
		return provincial;
	}

	public void setProvincial(String provincial) {
		this.provincial = provincial;
	}

}
