package com.dataup.dc.api.entity;

import java.io.Serializable;

public class AuditTasksPaysEntity implements Serializable {

	public String getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}

	public int getTaskNum() {
		return taskNum;
	}

	public void setTaskNum(int taskNum) {
		this.taskNum = taskNum;
	}

	public Double getPayamt() {
		return payamt;
	}

	public void setPayamt(Double payamt) {
		this.payamt = payamt;
	}

	public String getSystem_type() {
		return system_type;
	}

	public void setSystem_type(String system_type) {
		this.system_type = system_type;
	}

	private static final long serialVersionUID = -8354269935792155377L;

	private String auditDate;
	private int taskNum;
	private Double payamt;
	private String system_type;
//	private String queryType;
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	private String amount;
//	public String getQueryType() {
//		return queryType;
//	}

//	public void setQueryType(String queryType) {
//		this.queryType = queryType;
//	}

}
