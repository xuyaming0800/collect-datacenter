package com.dataup.dc.api.entity;
 
public class DefaultInfoBean implements java.io.Serializable{
 
	private static final long serialVersionUID = -1497494843567192095L;
	private Integer start=0;
	private Integer limit=0;
	private Boolean success=true;
	private Long totalCount=0L;
	private Object list;
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Object getList() {
		return list;
	}
	public void setList(Object list) {
		this.list = list;
	}
	
	

}
