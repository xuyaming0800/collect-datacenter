package cn.dataup.datacenter.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Title: RegsUserDateUp.java
 * @Package cn.dataup.datacenter.entity
 * @Description: 用于存放指定年月日的注册用户数量的实体
 * @author 刘旭升
 * @date 2015年7月8日 下午4:46:47
 * @version V1.0
 */
public class RegsUserDateUp implements Serializable {

	private static final long serialVersionUID = -2445610760323862209L;
	
	
	private int id;
	/**
	 *  注册用户主表key
	 */
	private int userRegsKye;
	/**
	 * 年数
	 */
	private int year;
	/**
	 * 月数
	 */
	private int month;
	/**
	 * 天数
	 */
	private int day;
	/**
	 * 当日的注册数
	 */
	private int regsCount;
	/**
	 * 当日的注册用户明细信息集合
	 */
	private List<RegsUserInfo> userRegsList;
	
	/**
	 * 日期格式
	 */
	private String daytime;
	
	
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public String getDaytime() {
		return daytime;
	}
	public void setDaytime(String daytime) {
		this.daytime = daytime;
	}
	public int getUserRegsKye() {
		return userRegsKye;
	}
	public void setUserRegsKye(int userRegsKye) {
		this.userRegsKye = userRegsKye;
	}
	public int getDay() {
		return day;
	}
	public int getRegsCount() {
		return regsCount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<RegsUserInfo> getUserRegsList() {
		return userRegsList;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public void setRegsCount(int regsCount) {
		this.regsCount = regsCount;
	}
	public void setUserRegsList(List<RegsUserInfo> userRegsList) {
		this.userRegsList = userRegsList;
	}
}
