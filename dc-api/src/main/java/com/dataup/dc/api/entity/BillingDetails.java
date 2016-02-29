package com.dataup.dc.api.entity;

import java.io.Serializable;

public class BillingDetails implements Serializable {

	private static final long serialVersionUID = 456243663191058768L;

	private String _date;
	private String system_type;
	private String pay;//充值
	private String withhold;//垫付
	private String recharge;//扣款
	private String payforsb;//支付

	public String get_date() {
		return _date;
	}

	public void set_date(String _date) {
		this._date = _date;
	}

	public String getSystem_type() {
		return system_type;
	}

	public void setSystem_type(String system_type) {
		this.system_type = system_type;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getWithhold() {
		return withhold;
	}

	public void setWithhold(String withhold) {
		this.withhold = withhold;
	}

	public String getRecharge() {
		return recharge;
	}

	public void setRecharge(String recharge) {
		this.recharge = recharge;
	}

	public String getPayforsb() {
		return payforsb;
	}

	public void setPayforsb(String payforsb) {
		this.payforsb = payforsb;
	}
}
