package com.dataup.dc.api.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName: AuditTaskEntity 
 * @Description: 审核任务-实体 
 * @author zhanqiao.huang
 * @date 2015年9月21日 下午1:39:13
 */
public class AuditTaskEntity implements Serializable{

 
	private static final long serialVersionUID = 9009144895401348154L;
	
	/**
	 * 任务类别
	 */
	private String classis;
	//分类id
	private String classisId;
	/**
	 * 区域
	 */
	private String area;
	/**
	 * 采集开始时间 
	 */
	private String start_time;  
	/**
	 * 项目名称
	 */
	private String system_type; 
	/**
	 * 累计支付费用
	 */
	private String payamt;
	/**
	 * 采集任务总数
	 */
	private String sall;
	/**
	 * 审核中数
	 */
	private String auditing;
	/**
	 * 审核合格数
	 */
	private String auditSuccess;
	/**
	 * 审核不合格数
	 */
	private String auditFall;
	private String total;
	
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getStart_time() {
		return start_time;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getSystem_type() {
		return system_type;
	}
	public String getPayamt() {
		return payamt;
	}
	public String getSall() {
		return sall;
	}
	public String getAuditing() {
		return auditing;
	}
	public String getAuditSuccess() {
		return auditSuccess;
	}
	public String getAuditFall() {
		return auditFall;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public void setSystem_type(String system_type) {
		this.system_type = system_type;
	}
	public void setPayamt(String payamt) {
		this.payamt = payamt;
	}
	public void setSall(String sall) {
		this.sall = sall;
	}
	public void setAuditing(String auditing) {
		this.auditing = auditing;
	}
	public void setAuditSuccess(String auditSuccess) {
		this.auditSuccess = auditSuccess;
	}
	public void setAuditFall(String auditFall) {
		this.auditFall = auditFall;
	}
	public String getClassisId() {
		return classisId;
	}
	public void setClassisId(String classisId) {
		this.classisId = classisId;
	}
	public String getClassis() {
		return classis;
	}
	public void setClassis(String classis) {
		this.classis = classis;
	}
}
