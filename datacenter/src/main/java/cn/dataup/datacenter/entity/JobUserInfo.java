package cn.dataup.datacenter.entity;

import java.io.Serializable;

public class JobUserInfo implements Serializable {

	private static final long serialVersionUID = -2115467725159915009L;

	private String name;
	private String idcard;
	private String age;
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	private String mobile;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
 
}
