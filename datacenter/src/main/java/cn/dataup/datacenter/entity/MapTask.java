package cn.dataup.datacenter.entity;

import java.io.Serializable;

public class MapTask implements Serializable {
 
	private static final long serialVersionUID = -4149310443506954360L;

	private Integer taskId;// 任务id
	private double lon;// 坐标x
	private double lat;// 坐标y
	private String taskClassName;// 任务类别
	private int status;// 状态
	private int systemType;// 系统类型

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public String getTaskClassName() {
		return taskClassName;
	}

	public void setTaskClassName(String taskClassName) {
		this.taskClassName = taskClassName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSystemType() {
		return systemType;
	}

	public void setSystemType(int systemType) {
		this.systemType = systemType;
	}
}
