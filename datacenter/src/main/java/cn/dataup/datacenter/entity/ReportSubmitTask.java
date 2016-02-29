package cn.dataup.datacenter.entity;

import java.io.Serializable;

public class ReportSubmitTask implements Serializable {

	private static final long serialVersionUID = 5679261395441036037L;
	
	private String _date;
	private String username;
	private String truename;
	private int collectnum;
	private int s2;
	private int s3;
	private int s4;
	private int s8;
	private int sall;
	private int systemtype;
	public int getSystemtype() {
		return systemtype;
	}
	public void setSystemtype(int systemtype) {
		this.systemtype = systemtype;
	}
	public String get_date() {
		return _date;
	}
	public void set_date(String _date) {
		this._date = _date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public int getCollectnum() {
		return collectnum;
	}
	public void setCollectnum(int collectnum) {
		this.collectnum = collectnum;
	}
	public int getS2() {
		return s2;
	}
	public void setS2(int s2) {
		this.s2 = s2;
	}
	public int getS3() {
		return s3;
	}
	public void setS3(int s3) {
		this.s3 = s3;
	}
	public int getS4() {
		return s4;
	}
	public void setS4(int s4) {
		this.s4 = s4;
	}
	public int getS8() {
		return s8;
	}
	public void setS8(int s8) {
		this.s8 = s8;
	}
	public int getSall() {
		return sall;
	}
	public void setSall(int sall) {
		this.sall = sall;
	}
	 
	 

}
