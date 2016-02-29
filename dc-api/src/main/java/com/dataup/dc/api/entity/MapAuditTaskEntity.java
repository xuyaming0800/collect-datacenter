package com.dataup.dc.api.entity;

import java.io.Serializable;

public class MapAuditTaskEntity implements Serializable {

	private static final long serialVersionUID = 1195618728732586571L;
	private String taskId;// 任务id
	private double lon;// 坐标x
	private double lat;// 坐标y
	private String taskClassName;// 任务类别
	private String status;// 状态
	private String system_type;// 系统类型
	private String zone;// 区域

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
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

	public String getStatus() {
		return status;
	}

	public String getSystem_type() {
		return system_type;
	}

	public void setSystem_type(String system_type) {
		this.system_type = system_type;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
