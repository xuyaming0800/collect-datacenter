package cn.dataup.datacenter.entity;

import java.io.Serializable;

public class ReportUserCollectTasks implements Serializable {
	private static final long serialVersionUID = -6476546363398882022L;
	private String _date;
	private String userName;
	private String trueName;
	private String collectNum;
	private String s2;//审核中数量
	private String s3;//审核成功数量
	private String s4;//审核失败数量
	private String s8;//申诉数量
	private String sAll;//采集任务总数量
	private String systemtype;
 
	public String getSystemtype() {
		return systemtype;
	}
	public void setSystemtype(String systemtype) {
		this.systemtype = systemtype;
	}
	public String getsAll() {
		return sAll;
	}
	public void setsAll(String sAll) {
		this.sAll = sAll;
	}
	public String get_date() {
		return _date;
	}
	public void set_date(String _date) {
		this._date = _date;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getCollectNum() {
		return collectNum;
	}
	public void setCollectNum(String collectNum) {
		this.collectNum = collectNum;
	}
	public String getS2() {
		return s2;
	}
	public void setS2(String s2) {
		this.s2 = s2;
	}
	public String getS3() {
		return s3;
	}
	public void setS3(String s3) {
		this.s3 = s3;
	}
	public String getS4() {
		return s4;
	}
	public void setS4(String s4) {
		this.s4 = s4;
	}
	public String getS8() {
		return s8;
	}
	public void setS8(String s8) {
		this.s8 = s8;
	}
 
	 

}
