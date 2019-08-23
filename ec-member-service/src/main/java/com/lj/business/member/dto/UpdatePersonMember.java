package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdatePersonMember.
 */
public class UpdatePersonMember implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2070383305078729740L;

	/**
	 * CODE .
	 */
	private String code;

	/**
	 * 会员号 .
	 */
	private String memberNo;

	/**
	 * 会员名称 .
	 */
	private String memberName;

	/**
	 * 导购编号 .
	 */
	private String memberNoGm;

	/**
	 * 导购姓名 .
	 */
	private String memberNameGm;

	/**
	 * 分店编号 .
	 */
	private String shopNo;

	/**
	 * 分店名称 .
	 */
	private String shopName;

	/**
	 * 商户编号 .
	 */
	private String merchantNo;

	/**
	 * 商户名称 .
	 */
	private String merchantName;

	/**
	 * 装修进度 .
	 */
	private String spruceUp;

	/**
	 * 所在楼盘 .
	 */
	private String houses;

	/**
	 * 是否关注 .
	 */
	private String keepEye;

	/**
	 * 紧急客户 .
	 */
	private String urgencyPm;

	/**
	 * 所需产品CODE .
	 */
	private String bomCode;

	/**
	 * 产品名称 .
	 */
	private String bomName;

	/**
	 * 更新人 .
	 */
	private String updateId;

	/**
	 * 更新时间 .
	 */
	private Date updateDate;

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
	private String remark2;

	/**
	 * 备注 .
	 */
	private String remark;

	/** 最近联系时间. */
	private Date contactDateLast;

	/**
	 * 对比品牌 .
	 */
	private String brandCompare;

	/**
	 * 客户特质 .
	 */
	private String clientSpecial;

	/**
	 * 初次介绍 是：Y 否：N.
	 */
	private String firstIntroduce;
	/**
	 * 扫码地址 .
	 */
	private String scanAddress;

	/**
	 * 纬度 .
	 */
	private String latitude;

	/**
	 * 经度 .
	 */
	private String longitude;
	/**
	 * 昵称备注_微信 .
	 */
	private String nickNameRemarkWx;

	/**
	 * 昵称备注_本地 .
	 */
	private String nickNameRemarkLocal;

	/**
	 * @return the nickNameRemarkWx
	 */
	public String getNickNameRemarkWx() {
		return nickNameRemarkWx;
	}

	/**
	 * @param nickNameRemarkWx
	 *            the nickNameRemarkWx to set
	 */
	public void setNickNameRemarkWx(String nickNameRemarkWx) {
		this.nickNameRemarkWx = nickNameRemarkWx;
	}

	/**
	 * @return the scanAddress
	 */
	public String getScanAddress() {
		return scanAddress;
	}

	/**
	 * @param scanAddress
	 *            the scanAddress to set
	 */
	public void setScanAddress(String scanAddress) {
		this.scanAddress = scanAddress;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

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
	 * @param code
	 *            the new cODE
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the 会员号 .
	 *
	 * @return the 会员号
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 会员号 .
	 *
	 * @param memberNo
	 *            the new 会员号
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the 会员名称 .
	 *
	 * @return the 会员名称
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * Sets the 会员名称 .
	 *
	 * @param memberName
	 *            the new 会员名称
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * Gets the 导购编号 .
	 *
	 * @return the 导购编号
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the 导购编号 .
	 *
	 * @param memberNoGm
	 *            the new 导购编号
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	/**
	 * Gets the 导购姓名 .
	 *
	 * @return the 导购姓名
	 */
	public String getMemberNameGm() {
		return memberNameGm;
	}

	/**
	 * Sets the 导购姓名 .
	 *
	 * @param memberNameGm
	 *            the new 导购姓名
	 */
	public void setMemberNameGm(String memberNameGm) {
		this.memberNameGm = memberNameGm;
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
	 * @param shopNo
	 *            the new 分店编号
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
	 * @param shopName
	 *            the new 分店名称
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * Gets the 商户编号 .
	 *
	 * @return the 商户编号
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户编号 .
	 *
	 * @param merchantNo
	 *            the new 商户编号
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the 商户名称 .
	 *
	 * @return the 商户名称
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * Sets the 商户名称 .
	 *
	 * @param merchantName
	 *            the new 商户名称
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	/**
	 * Gets the 装修进度 .
	 *
	 * @return the 装修进度
	 */
	public String getSpruceUp() {
		return spruceUp;
	}

	/**
	 * Sets the 装修进度 .
	 *
	 * @param spruceUp
	 *            the new 装修进度
	 */
	public void setSpruceUp(String spruceUp) {
		this.spruceUp = spruceUp;
	}

	/**
	 * Gets the 所在楼盘 .
	 *
	 * @return the 所在楼盘
	 */
	public String getHouses() {
		return houses;
	}

	/**
	 * Sets the 所在楼盘 .
	 *
	 * @param houses
	 *            the new 所在楼盘
	 */
	public void setHouses(String houses) {
		this.houses = houses;
	}

	/**
	 * Gets the 是否关注 .
	 *
	 * @return the 是否关注
	 */
	public String getKeepEye() {
		return keepEye;
	}

	/**
	 * Sets the 是否关注 .
	 *
	 * @param keepEye
	 *            the new 是否关注
	 */
	public void setKeepEye(String keepEye) {
		this.keepEye = keepEye;
	}

	/**
	 * Gets the 紧急客户 .
	 *
	 * @return the 紧急客户
	 */
	public String getUrgencyPm() {
		return urgencyPm;
	}

	/**
	 * Sets the 紧急客户 .
	 *
	 * @param urgencyPm
	 *            the new 紧急客户
	 */
	public void setUrgencyPm(String urgencyPm) {
		this.urgencyPm = urgencyPm;
	}

	/**
	 * Gets the 所需产品CODE .
	 *
	 * @return the 所需产品CODE
	 */
	public String getBomCode() {
		return bomCode;
	}

	/**
	 * Sets the 所需产品CODE .
	 *
	 * @param bomCode
	 *            the new 所需产品CODE
	 */
	public void setBomCode(String bomCode) {
		this.bomCode = bomCode;
	}

	/**
	 * Gets the 产品名称 .
	 *
	 * @return the 产品名称
	 */
	public String getBomName() {
		return bomName;
	}

	/**
	 * Sets the 产品名称 .
	 *
	 * @param bomName
	 *            the new 产品名称
	 */
	public void setBomName(String bomName) {
		this.bomName = bomName;
	}

	/**
	 * Gets the 更新人 .
	 *
	 * @return the 更新人
	 */
	public String getUpdateId() {
		return updateId;
	}

	/**
	 * Sets the 更新人 .
	 *
	 * @param updateId
	 *            the new 更新人
	 */
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	/**
	 * Gets the 更新时间 .
	 *
	 * @return the 更新时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * Sets the 更新时间 .
	 *
	 * @param updateDate
	 *            the new 更新时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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
	 * @param remark4
	 *            the new 备注
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
	 * @param remark3
	 *            the new 备注
	 */
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
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
	 * @param remark2
	 *            the new 备注
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
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
	 * @param remark
	 *            the new 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * Gets the contact date last.
	 *
	 * @return the contact date last
	 */
	public Date getContactDateLast() {
		return contactDateLast;
	}

	/**
	 * Sets the contact date last.
	 *
	 * @param contactDateLast
	 *            the new contact date last
	 */
	public void setContactDateLast(Date contactDateLast) {
		this.contactDateLast = contactDateLast;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdatePersonMember [code=").append(code).append(", memberNo=").append(memberNo).append(", memberName=").append(memberName).append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm).append(", shopNo=").append(shopNo).append(", shopName=").append(shopName).append(", merchantNo=").append(merchantNo)
				.append(", merchantName=").append(merchantName).append(", spruceUp=").append(spruceUp).append(", houses=").append(houses).append(", keepEye=").append(keepEye).append(", urgencyPm=")
				.append(urgencyPm).append(", bomCode=").append(bomCode).append(", bomName=").append(bomName).append(", updateId=").append(updateId).append(", updateDate=").append(updateDate)
				.append(", remark4=").append(remark4).append(", remark3=").append(remark3).append(", remark2=").append(remark2).append(", remark=").append(remark).append(", contactDateLast=")
				.append(contactDateLast).append(", brandCompare=").append(brandCompare).append(", clientSpecial=").append(clientSpecial).append(", firstIntroduce=").append(firstIntroduce).append("]");
		return builder.toString();
	}

	/**
	 * Gets the 对比品牌 .
	 *
	 * @return the 对比品牌
	 */
	public String getBrandCompare() {
		return brandCompare;
	}

	/**
	 * Sets the 对比品牌 .
	 *
	 * @param brandCompare
	 *            the new 对比品牌
	 */
	public void setBrandCompare(String brandCompare) {
		this.brandCompare = brandCompare;
	}

	/**
	 * Gets the 客户特质 .
	 *
	 * @return the 客户特质
	 */
	public String getClientSpecial() {
		return clientSpecial;
	}

	/**
	 * Sets the 客户特质 .
	 *
	 * @param clientSpecial
	 *            the new 客户特质
	 */
	public void setClientSpecial(String clientSpecial) {
		this.clientSpecial = clientSpecial;
	}

	/**
	 * Gets the 初次介绍 是：Y 否：N.
	 *
	 * @return the 初次介绍 是：Y 否：N
	 */
	public String getFirstIntroduce() {
		return firstIntroduce;
	}

	/**
	 * Sets the 初次介绍 是：Y 否：N.
	 *
	 * @param firstIntroduce
	 *            the new 初次介绍 是：Y 否：N
	 */
	public void setFirstIntroduce(String firstIntroduce) {
		this.firstIntroduce = firstIntroduce;
	}

	public String getNickNameRemarkLocal() {
		return nickNameRemarkLocal;
	}

	public void setNickNameRemarkLocal(String nickNameRemarkLocal) {
		this.nickNameRemarkLocal = nickNameRemarkLocal;
	}

}
