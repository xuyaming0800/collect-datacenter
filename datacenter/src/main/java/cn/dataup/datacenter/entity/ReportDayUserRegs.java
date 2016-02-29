package cn.dataup.datacenter.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: ReportDayUserRegs
 * @Description: 日用户注册量-实体
 * @author zhanqiao.huang
 * @date 2015年7月17日 下午5:34:25
 */

public class ReportDayUserRegs implements Serializable {

	private static final long serialVersionUID = -6109194521720781014L;

	private Date regDate;
	
	private int dayTotal;
	public String getsRegDate() {
		return sRegDate;
	}

	public void setsRegDate(String sRegDate) {
		this.sRegDate = sRegDate;
	}

	private String sRegDate;
	
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	private int tatal;

	public int getDayTotal() {
		return dayTotal;
	}

	public void setDayTotal(int dayTotal) {
		this.dayTotal = dayTotal;
	}

	public int getTatal() {
		return tatal;
	}

	public void setTatal(int tatal) {
		this.tatal = tatal;
	}

	

}
