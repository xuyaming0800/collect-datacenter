package com.dataup.dc.api.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName: AuditTaskDetailsEntity 
 * @Description: 审核任务详情-实体 
 * @author zhanqiao.huang
 * @date 2015年9月21日 下午1:39:13
 */
public class AuditTaskDetailsEntity implements Serializable{

 
	private static final long serialVersionUID = 948522549132810570L;
	private Double amount;//金额
	private String task_name;//任务名称
	private String area;//区域
	private String submit_time;//提交时间
	private String type;//类型
	private String task_status_key;//审核状态
	private String classis;
	private String system_type;
	private String audit_time;
//	private Double custom_total_money;
	private Double payamt;//金额
	public Double getPayamt() {
		return payamt;
	}
	public void setPayamt(Double payamt) {
		this.payamt = payamt;
	}
//	public Double getCustom_total_money() {
//		return custom_total_money;
//	}
//	public void setCustom_total_money(Double custom_total_money) {
//		this.custom_total_money = custom_total_money;
//	}
	public String getAudit_time() {
		return audit_time;
	}
	public void setAudit_time(String audit_time) {
		this.audit_time = audit_time;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getSubmit_time() {
		return submit_time;
	}
	public void setSubmit_time(String submit_time) {
		this.submit_time = submit_time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTask_status_key() {
		return task_status_key;
	}
	public void setTask_status_key(String task_status_key) {
		this.task_status_key = task_status_key;
	}
	public String getClassis() {
		return classis;
	}
	public void setClassis(String classis) {
		this.classis = classis;
	}
	public String getSystem_type() {
		return system_type;
	}
	public void setSystem_type(String system_type) {
		this.system_type = system_type;
	} 
}
