package com.lj.business.member.dto.phoneInfo;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindPhoneInfoPageReturn.
 */
public class FindPhoneInfoPageReturn implements Serializable { 

	 /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1225138057344790971L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String memberNoMerchant;

    /**
     * 分店编号 .
     */
    private String shopNo;

    /**
     * 分店名称 .
     */
    private String shopName;

    /**
     * 设备状态
             NORMAL正常
             CANCEL注销 .
     */
    private String status;

    /**
     * 手机串号 .
     */
    private String imei;

    /**
     * 会员编号 .
     */
    private String memberNo;

    /**
     * 会员姓名 .
     */
    private String memberName;

    /**
     * 会员类型
             店长：SHOP
             导购：GUID .
     */
    private String memberType;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;

    /**
     * 备注 .
     */
    private String remark4;

    /**
     * 备注 .
     */
    private String remark3;

    /**
     * 备注 .
     */
    private String remark;

    /**
     * 备注 .
     */
    private String remark2;

	/**
	 * Gets the cODE .
	 *
	 * @return the cODE 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the cODE .
	 *
	 * @param code the new cODE 
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the 商户编号 .
	 *
	 * @return the 商户编号 
	 */
	public String getMemberNoMerchant() {
		return memberNoMerchant;
	}

	/**
	 * Sets the 商户编号 .
	 *
	 * @param memberNoMerchant the new 商户编号 
	 */
	public void setMemberNoMerchant(String memberNoMerchant) {
		this.memberNoMerchant = memberNoMerchant;
	}

	/**
	 * Gets the 分店编号 .
	 *
	 * @return the 分店编号 
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * Sets the 分店编号 .
	 *
	 * @param shopNo the new 分店编号 
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/**
	 * Gets the 分店名称 .
	 *
	 * @return the 分店名称 
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * Sets the 分店名称 .
	 *
	 * @param shopName the new 分店名称 
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * Gets the 设备状态 NORMAL正常 CANCEL注销 .
	 *
	 * @return the 设备状态 NORMAL正常 CANCEL注销 
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the 设备状态 NORMAL正常 CANCEL注销 .
	 *
	 * @param status the new 设备状态 NORMAL正常 CANCEL注销 
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the 手机串号 .
	 *
	 * @return the 手机串号 
	 */
	public String getImei() {
		return imei;
	}

	/**
	 * Sets the 手机串号 .
	 *
	 * @param imei the new 手机串号 
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}

	/**
	 * Gets the 会员编号 .
	 *
	 * @return the 会员编号 
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 会员编号 .
	 *
	 * @param memberNo the new 会员编号 
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the 会员姓名 .
	 *
	 * @return the 会员姓名 
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * Sets the 会员姓名 .
	 *
	 * @param memberName the new 会员姓名 
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * Gets the 会员类型 店长：SHOP 导购：GUID .
	 *
	 * @return the 会员类型 店长：SHOP 导购：GUID 
	 */
	public String getMemberType() {
		return memberType;
	}

	/**
	 * Sets the 会员类型 店长：SHOP 导购：GUID .
	 *
	 * @param memberType the new 会员类型 店长：SHOP 导购：GUID 
	 */
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	/**
	 * Gets the 创建人 .
	 *
	 * @return the 创建人 
	 */
	public String getCreateId() {
		return createId;
	}

	/**
	 * Sets the 创建人 .
	 *
	 * @param createId the new 创建人 
	 */
	public void setCreateId(String createId) {
		this.createId = createId;
	}

	/**
	 * Gets the 创建时间 .
	 *
	 * @return the 创建时间 
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the 创建时间 .
	 *
	 * @param createDate the new 创建时间 
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * Gets the 备注 .
	 *
	 * @return the 备注 
	 */
	public String getRemark4() {
		return remark4;
	}

	/**
	 * Sets the 备注 .
	 *
	 * @param remark4 the new 备注 
	 */
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	/**
	 * Gets the 备注 .
	 *
	 * @return the 备注 
	 */
	public String getRemark3() {
		return remark3;
	}

	/**
	 * Sets the 备注 .
	 *
	 * @param remark3 the new 备注 
	 */
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	/**
	 * Gets the 备注 .
	 *
	 * @return the 备注 
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the 备注 .
	 *
	 * @param remark the new 备注 
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * Gets the 备注 .
	 *
	 * @return the 备注 
	 */
	public String getRemark2() {
		return remark2;
	}

	/**
	 * Sets the 备注 .
	 *
	 * @param remark2 the new 备注 
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindPhoneInfoPageReturn [code=").append(code)
				.append(", memberNoMerchant=").append(memberNoMerchant)
				.append(", shopNo=").append(shopNo).append(", shopName=")
				.append(shopName).append(", status=").append(status)
				.append(", imei=").append(imei).append(", memberNo=")
				.append(memberNo).append(", memberName=").append(memberName)
				.append(", memberType=").append(memberType)
				.append(", createId=").append(createId).append(", remark4=")
				.append(remark4).append(", remark3=").append(remark3)
				.append(", remark=").append(remark).append(", remark2=")
				.append(remark2).append("]");
		return builder.toString();
	}
    
}
