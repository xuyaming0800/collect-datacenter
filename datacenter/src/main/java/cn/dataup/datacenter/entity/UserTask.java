package cn.dataup.datacenter.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UserTask implements Serializable {

	private static final long serialVersionUID = -2999233025307330176L;
	@NotNull
	@NotEmpty
	private String taskId;
	@NotNull
	@NotEmpty
	private Date taskTime;
	
	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Date getTaskTime() {
		return taskTime;
	}

	public void setTaskTime(Date taskTime) {
		this.taskTime = taskTime;
	}

	public List<UserTaskDetail> getuTaskSubList() {
		return uTaskSubList;
	}

	public void setuTaskSubList(List<UserTaskDetail> uTaskSubList) {
		this.uTaskSubList = uTaskSubList;
	}

	private List<UserTaskDetail> uTaskSubList;

	 

}
