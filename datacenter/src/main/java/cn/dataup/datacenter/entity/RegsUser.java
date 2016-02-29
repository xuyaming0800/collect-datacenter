package cn.dataup.datacenter.entity;

import java.io.Serializable;
/**
 * @Title: RegsUserDateUp.java
 * @Package cn.dataup.datacenter.entity
 * @Description: 用于存放指定年月日的注册用户数量的实体
 * @author 刘旭升
 * @date 2015年7月8日 下午4:46:47
 * @version V1.0
 */
public class RegsUser implements Serializable {

	private static final long serialVersionUID = -3481946098953531259L;
	/**
	 * 主键
	 */
	private int id;
	/**
	 * 外键关联
	 */
	private int key;
	/**
	 * 注册总量
	 */
	private int total;
	/**
	 * 日注册量
	 */
	private int dayTotal;

	public int getId() {
		return id;
	}

	public int getKey() {
		return key;
	}

	public int getTotal() {
		return total;
	}

	public int getDayTotal() {
		return dayTotal;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setDayTotal(int dayTotal) {
		this.dayTotal = dayTotal;
	}
}
