package com.dataup.dc.api.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @ClassName: Pagination 
 * @Description: 分布-组件单元bean
 * @author zhanqiao.huang
 * @date 2015年9月21日 下午1:42:19
 */
public class Pagination implements Serializable {

 
	private static final long serialVersionUID = -4235758307077026318L;
	public List<?> objectList;// 查询对象
	public long totalCount;// 总记录数
	public int pageNo;// 当前页码
	public int limit;// 每页记录数
	public int start;// 开始记录

	public String payTotal;//充值
	public String amountTotal;//垫付
	public String rechargeTotal;//扣款
	public String payforsbTotal;//支付
	public String getRechargeTotal() {
		return rechargeTotal;
	}

	public void setRechargeTotal(String rechargeTotal) {
		this.rechargeTotal = rechargeTotal;
	}

 
	public String getPayforsbTotal() {
		return payforsbTotal;
	}

	public void setPayforsbTotal(String payforsbTotal) {
		this.payforsbTotal = payforsbTotal;
	}



	
	public String getPayTotal() {
		return payTotal;
	}

	public void setPayTotal(String payTotal) {
		this.payTotal = payTotal;
	}

	public String getAmountTotal() {
		return amountTotal;
	}

	public void setAmountTotal(String amountTotal) {
		this.amountTotal = amountTotal;
	}

	public Pagination() {
	}

	public Pagination(int pageNo, int limit) throws Exception {
		if (pageNo < 1 || limit < 0)
			throw new Exception("页码参数类型不正确");
		this.start = (pageNo - 1) * limit;
		this.limit = limit;
	}

	public Pagination(String pageNo, String limit) throws Exception {
		try {
			int pNumber = Integer.valueOf(pageNo);
			int pSize = Integer.valueOf(limit);
			if (pNumber < 1 || pSize < 0)
				throw new Exception("页码参数类型不正确");
			this.start = (pNumber - 1) * pSize;
			this.limit = pSize;
		} catch (NumberFormatException e) {
			throw new Exception("页码参数类型不正确");
		}
	}

	public List<?> getObjectList() {
		return objectList;
	}

	public void setObjectList(List<?> objectList) {
		this.objectList = objectList;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

}
