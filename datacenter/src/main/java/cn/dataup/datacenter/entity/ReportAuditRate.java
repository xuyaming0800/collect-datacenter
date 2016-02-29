package cn.dataup.datacenter.entity;

import java.io.Serializable;

public class ReportAuditRate implements Serializable {

	private static final long serialVersionUID = -6659775163048931448L;
	
	private String _date;
	
	private String system_type;
	
	
	public String getSystem_type() {
		return system_type;
	}
	public void setSystem_type(String system_type) {
		this.system_type = system_type;
	}
	private int task_num;
	private int first_audit_num;//初审总数
	private int first_audit_pass_num;//初审通过
	private int inspection_num;//抽检总数
	private int inspection_pass_num;//抽检通过
	private int auto_inspection_num;//抽检自动流过(程序自动进入冻结期)
	private int appeal_num;//申诉数
	private int appeal_pass_num;//申诉通过
	private int audit_fail_num;//审核失败
	
	
	
	
	
	
	
//	
//	private int taskNum;//任务总数
//	private int inspectionNum;//抽检总数
//	private int firstTaskNum;//初审总数
//	private int firstTaskPassNum;//初审通过
//	private int autoInspectionNum;//抽检自动流过(程序自动进入冻结期)
	
	/*
	 初审通过率=初审成功/初审总数
	抽检率=抽检总数-自动流过/抽检总数
	
	抽检通过率=抽检通过数/抽检数
	申斥率=申诉数/审核失败(初审失败+抽检失败)
	*/
	
	public String get_date() {
		return _date;
	}
	public void set_date(String _date) {
		this._date = _date;
	}
//	public int getTaskNum() {
//		return taskNum;
//	}
//	public void setTaskNum(int taskNum) {
//		this.taskNum = taskNum;
//	}
//	public int getInspectionNum() {
//		return inspectionNum;
//	}
//	public void setInspectionNum(int inspectionNum) {
//		this.inspectionNum = inspectionNum;
//	}
//	public int getAutoInspectionNum() {
//		return autoInspectionNum;
//	}
//	public int getFirstTaskNum() {
//		return firstTaskNum;
//	}
//	public void setFirstTaskNum(int firstTaskNum) {
//		this.firstTaskNum = firstTaskNum;
//	}
//	public int getFirstTaskPassNum() {
//		return firstTaskPassNum;
//	}
//	public void setFirstTaskPassNum(int firstTaskPassNum) {
//		this.firstTaskPassNum = firstTaskPassNum;
//	}
//	public void setAutoInspectionNum(int autoInspectionNum) {
//		this.autoInspectionNum = autoInspectionNum;
//	}
//	public int getInspectionPassNum() {
//		return inspectionPassNum;
//	}
//	public void setInspectionPassNum(int inspectionPassNum) {
//		this.inspectionPassNum = inspectionPassNum;
//	}
//	public int getAppealNum() {
//		return appealNum;
//	}
//	public void setAppealNum(int appealNum) {
//		this.appealNum = appealNum;
//	}
//	public int getAuditFail() {
//		return auditFail;
//	}
//	public void setAuditFail(int auditFail) {
//		this.auditFail = auditFail;
//	}
//	public int getAppealPassNum() {
//		return appealPassNum;
//	}
//	public void setAppealPassNum(int appealPassNum) {
//		this.appealPassNum = appealPassNum;
//	}
//	private int inspectionPassNum;//抽检通过
//	private int appealNum;//申斥数
//	private int auditFail;//审核失败
//	private int appealPassNum;//申斥成功
	public int getTask_num() {
		return task_num;
	}
	public void setTask_num(int task_num) {
		this.task_num = task_num;
	}
	public int getFirst_audit_num() {
		return first_audit_num;
	}
	public void setFirst_audit_num(int first_audit_num) {
		this.first_audit_num = first_audit_num;
	}
	public int getFirst_audit_pass_num() {
		return first_audit_pass_num;
	}
	public void setFirst_audit_pass_num(int first_audit_pass_num) {
		this.first_audit_pass_num = first_audit_pass_num;
	}
	public int getInspection_num() {
		return inspection_num;
	}
	public void setInspection_num(int inspection_num) {
		this.inspection_num = inspection_num;
	}
	public int getInspection_pass_num() {
		return inspection_pass_num;
	}
	public void setInspection_pass_num(int inspection_pass_num) {
		this.inspection_pass_num = inspection_pass_num;
	}
	public int getAuto_inspection_num() {
		return auto_inspection_num;
	}
	public void setAuto_inspection_num(int auto_inspection_num) {
		this.auto_inspection_num = auto_inspection_num;
	}
	public int getAppeal_num() {
		return appeal_num;
	}
	public void setAppeal_num(int appeal_num) {
		this.appeal_num = appeal_num;
	}
	public int getAppeal_pass_num() {
		return appeal_pass_num;
	}
	public void setAppeal_pass_num(int appeal_pass_num) {
		this.appeal_pass_num = appeal_pass_num;
	}
	public int getAudit_fail_num() {
		return audit_fail_num;
	}
	public void setAudit_fail_num(int audit_fail_num) {
		this.audit_fail_num = audit_fail_num;
	}

}
