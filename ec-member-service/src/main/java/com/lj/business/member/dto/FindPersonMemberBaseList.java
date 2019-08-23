package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * 类说明：OMS专用返回
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @Company: 领居科技有限公司
 * @author 罗书明
 * 
 * CreateDate: 2017年7月22日
 */
public class FindPersonMemberBaseList implements Serializable{

	 /** Generate cron. */
	private static final long serialVersionUID = -398434467700224613L;

	/** 客户编号. */
	private String memberNo;
	/***
	 *  门店编号
	 */
	private String shopNo;
	/**
	 * 导购编号
	 */
	private String memberNoGm;
	
	/** 客户名称. */
	private String memberName;
	
	/** 商户编号. */
	private String merchantNo;
	
	/** 区域CODE. */
	private String areaCode;
	
	/** 省code. */
	private String provinceCode;
	
	/**区域名称*/
	private String areaName;
	
	/**客户数量*/
	private String count;
	/**手机号码*/
	private String mobile;
	
	/**创建时间*/
	private String  createDate;
	
	/***
	 *性别
	 */
	private String sex;
	
	
	
	public String getShopNo() {
		return shopNo;
	}

	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	public String getMemberNoGm() {
		return memberNoGm;
	}

	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	/**
	 * Gets the area code.
	 *
	 * @return the area code
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * Sets the area code.
	 *
	 * @param areaCode the area code
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * Gets the province code.
	 *
	 * @return the province code
	 */
	public String getProvinceCode() {
		return provinceCode;
	}

	/**
	 * Sets the province code.
	 *
	 * @param provinceCode the province code
	 */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	/**
	 * Gets the merchant no.
	 *
	 * @return the merchant no
	 */
	public String getMerchantNo() {
		return merchantNo;
	}
	
	/**
	 * Sets the merchant no.
	 *
	 * @param merchantNo the merchant no
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	
	/**
	 * Gets the member no.
	 *
	 * @return the member no
	 */
	public String getMemberNo() {
		return memberNo;
	}
	
	/**
	 * Sets the member no.
	 *
	 * @param memberNo the member no
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	
	/**
	 * Gets the member name.
	 *
	 * @return the member name
	 */
	public String getMemberName() {
		return memberName;
	}
	
	/**
	 * Sets the member name.
	 *
	 * @param memberName the member name
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	@Override
	public String toString() {
		return "FindPersonMemberBaseList [memberNo=" + memberNo + ", shopNo="
				+ shopNo + ", memberNoGm=" + memberNoGm + ", memberName="
				+ memberName + ", merchantNo=" + merchantNo + ", areaCode="
				+ areaCode + ", provinceCode=" + provinceCode + ", areaName="
				+ areaName + ", count=" + count + ", mobile=" + mobile
				+ ", createDate=" + createDate + ", sex=" + sex + "]";
	}
	
}
