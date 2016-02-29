package cn.dataup.datacenter.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UserTaskDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7161553254726133151L;
	@NotNull
	@NotEmpty
	private String taskSubId;
	@NotNull
	@NotEmpty
	private String taskId;
	@NotNull
	@NotEmpty
	private String userId;
	@NotNull
	@NotEmpty
	private String userName;
	@NotNull
	@NotEmpty
	private String trueName;
	@NotNull
	@NotEmpty
	private String bigName;
	public String getBigName() {
		return bigName;
	}
	public void setBigName(String bigName) {
		this.bigName = bigName;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	@NotNull
	@NotEmpty
	private int collectNum;
	public String getTaskSubId() {
		return taskSubId;
	}
	public void setTaskSubId(String taskSubId) {
		this.taskSubId = taskSubId;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getCollectNum() {
		return collectNum;
	}
	public void setCollectNum(int collectNum) {
		this.collectNum = collectNum;
	}

}
