package com.dataup.dc.api.entity;

import java.io.Serializable;

public class CCChargeHisEntity implements Serializable{

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 */ 
	private static final long serialVersionUID = 4628575269172958064L;
	private String applyId;
	private String auditId;
	private String customId;
	private String ownerId;
	private Double money;
	private Long auditTime;
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getAuditId() {
		return auditId;
	}
	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}
	public String getCustomId() {
		return customId;
	}
	public void setCustomId(String customId) {
		this.customId = customId;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Long getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Long auditTime) {
		this.auditTime = auditTime;
	}
}
