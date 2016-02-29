package cn.dataup.datacenter.entity;

import java.io.Serializable;
/**
 * @Title: RegsUserInfo.java
 * @Package cn.dataup.datacenter.entity
 * @Description: 注册用户的详细信息 对应数据中表：dc_user_regs_detail
 * @author 刘旭升
 * @date 2015年7月8日 下午4:47:59
 * @version V1.0
 */
public class RegsUserInfo implements Serializable {

	private static final long serialVersionUID = 2238869701939230825L;
	private Integer id;

	/**
	 * 主表外键
	 */
	private Integer dcUserRegsKey;
	/**
	 * 登录用户名
	 */
	private String name;
	/**
	 * 真实姓名
	 */
	private String truename;
	/**
	 * 手机号
	 */
	private String telephone;
	
	private String mobile;
	private int total;
	private int age;
	private String verifyIdCardName;
	private double withdrawAccount;
 

	public double getWithdrawAccount() {
		return withdrawAccount;
	}

	public void setWithdrawAccount(double withdrawAccount) {
		this.withdrawAccount = withdrawAccount;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getVerifyIdCardName() {
		return verifyIdCardName;
	}

	public void setVerifyIdCardName(String verifyIdCardName) {
		this.verifyIdCardName = verifyIdCardName;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 创建时间
	 */
	private Long create_date;
	/**
	 * 支付宝帐号
	 */
	private String alipayaccount;
	/**
	 * 支付宝名称
	 */
	private String alipaytruename;
	/**
	 * 腾讯QQ帐号
	 */
	private String qq;
	/**
	 * 城市
	 */
	private String city;

	/**
	 * 
	 */
	public Integer getDcUserRegsKey() {
		return dcUserRegsKey;
	}

	public void setDcUserRegsKey(Integer dcUserRegsKey) {
		this.dcUserRegsKey = dcUserRegsKey;
	}

	public String getName() {
		return name;
	}

	public String getAlipaytruename() {
		return alipaytruename;
	}

	public void setAlipaytruename(String alipaytruename) {
		this.alipaytruename = alipaytruename;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTruename() {
		return truename;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAlipayaccount() {
		return alipayaccount;
	}

	public void setAlipayaccount(String alipayaccount) {
		this.alipayaccount = alipayaccount;
	}

	public String getQq() {
		return qq;
	}

	public Long getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Long create_date) {
		this.create_date = create_date;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
