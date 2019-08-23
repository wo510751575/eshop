package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindShopPageReturn.
 * 
 *  OMS专用
 * 
 */
public class FindShopPageReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4855088860687929389L; 
	/**
     * CODE .
     */
    private String code;

    /**
     * 分店编号 .
     */
    private String shopNo;

    /**
     * 分店名称 .
     */
    private String shopName;
   
   /** 门店类型. */
   private String shopType;
   
    /**
     * 商户编号 .
     */
    private String memberNoMerchant;

    /**
     * 商户名称 .
     */
    private String memberNameMerchant;

    /**
     * 会员状态 
             NORMAL正常、
             CANCEL注销。
              .
     */
    private String status;

    /**
     * 联系电话 .
     */
    private String telephone;

    /**
     * 手机号 .
     */
    private String mobile;

    /**
     * 邮箱 .
     */
    private String email;

    /**
     * 住址 .
     */
    private String address;

    /**
     * 区域CODE .
     */
    private String areaCode;
    
    /**
     * 区域名称 .
     */
    private String areaName;

    /**
     * 省CODE .
     */
    private String provinceCode;

    /**
     * 市CODE .
     */
    private String cityCode;

    /**
     * 市区CODE .
     */
    private String cityAreaCode;

    /**
     * 地址信息 .
     */
    private String addrInfo;

    /**
     * LOGO图片 .
     */
    private String logoAddr;

    /**
     * 经度 .
     */
    private String longitude;

    /**
     * 纬度 .
     */
    private String latitude;

    /**
     * 经营范围 .
     */
    private String bizScope;

    /**
     * 门店二维码地址 .
     */
    private String qcord;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;

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
    private String remark;

    /**
     * 备注 .
     */
    private String remark2;
    
    /** 导购数量. */
    private Integer guidNum;
    
    /** 客户数量. */
    private Integer personNum;
    
    /** 店员数量. */
    private Integer clerkNum;
    
    /** 店长名称. */
    private String memberNameShop;
    
    /** 
     * 开店时间.
     * */
    private Date openDate;
    
    /** 成单金额. */
    private String orderAmount;
    
    /** 门店代码. */
    private String shopNoMerchant;
    
    
    
	/**
	 * Gets the 门店类型.
	 *
	 * @return the 门店类型
	 */
	public String getShopType() {
		return shopType;
	}

	/**
	 * Sets the 门店类型.
	 *
	 * @param shopType the new 门店类型
	 */
	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

	/**
	 * Gets the 门店代码.
	 *
	 * @return the shopNoMerchant
	 */
	public String getShopNoMerchant() {
		return shopNoMerchant;
	}

	/**
	 * Sets the 门店代码.
	 *
	 * @param shopNoMerchant the shopNoMerchant to set
	 */
	public void setShopNoMerchant(String shopNoMerchant) {
		this.shopNoMerchant = shopNoMerchant;
	}

	/**
	 * Gets the 成单金额.
	 *
	 * @return the orderAmount
	 */
	public String getOrderAmount() {
		return orderAmount;
	}

	/**
	 * Sets the 成单金额.
	 *
	 * @param orderAmount the orderAmount to set
	 */
	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	/**
	 * Gets the 店员数量.
	 *
	 * @return the clerkNum
	 */
	public Integer getClerkNum() {
		return clerkNum;
	}

	/**
	 * Sets the 店员数量.
	 *
	 * @param clerkNum the clerkNum to set
	 */
	public void setClerkNum(Integer clerkNum) {
		this.clerkNum = clerkNum;
	}

	/**
	 * Gets the 客户数量.
	 *
	 * @return the personNum
	 */
	public Integer getPersonNum() {
		return personNum;
	}

	/**
	 * Sets the 客户数量.
	 *
	 * @param personNum the personNum to set
	 */
	public void setPersonNum(Integer personNum) {
		this.personNum = personNum;
	}

	/**
	 * Gets the 开店时间.
	 *
	 * @return the openDate
	 */
	public Date getOpenDate() {
		return openDate;
	}

	/**
	 * Sets the 开店时间.
	 *
	 * @param openDate the openDate to set
	 */
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	/**
	 * Gets the 店长名称.
	 *
	 * @return the memberNameShop
	 */
	public String getMemberNameShop() {
		return memberNameShop;
	}

	/**
	 * Sets the 店长名称.
	 *
	 * @param memberNameShop the memberNameShop to set
	 */
	public void setMemberNameShop(String memberNameShop) {
		this.memberNameShop = memberNameShop;
	}

	/**
	 * Gets the 导购数量.
	 *
	 * @return the guidNum
	 */
	public Integer getGuidNum() {
		return guidNum;
	}

	/**
	 * Sets the 导购数量.
	 *
	 * @param guidNum the guidNum to set
	 */
	public void setGuidNum(Integer guidNum) {
		this.guidNum = guidNum;
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
	 * @param code the new cODE 
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * Gets the 商户名称 .
	 *
	 * @return the 商户名称 
	 */
	public String getMemberNameMerchant() {
		return memberNameMerchant;
	}

	/**
	 * Sets the 商户名称 .
	 *
	 * @param memberNameMerchant the new 商户名称 
	 */
	public void setMemberNameMerchant(String memberNameMerchant) {
		this.memberNameMerchant = memberNameMerchant;
	}

	/**
	 * Gets the 会员状态 NORMAL正常、 CANCEL注销。 .
	 *
	 * @return the 会员状态 NORMAL正常、 CANCEL注销。 
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the 会员状态 NORMAL正常、 CANCEL注销。 .
	 *
	 * @param status the new 会员状态 NORMAL正常、 CANCEL注销。 
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the 联系电话 .
	 *
	 * @return the 联系电话 
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Sets the 联系电话 .
	 *
	 * @param telephone the new 联系电话 
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Gets the 手机号 .
	 *
	 * @return the 手机号 
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Sets the 手机号 .
	 *
	 * @param mobile the new 手机号 
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * Gets the 邮箱 .
	 *
	 * @return the 邮箱 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the 邮箱 .
	 *
	 * @param email the new 邮箱 
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the 住址 .
	 *
	 * @return the 住址 
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the 住址 .
	 *
	 * @param address the new 住址 
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the 区域CODE .
	 *
	 * @return the 区域CODE 
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * Sets the 区域CODE .
	 *
	 * @param areaCode the new 区域CODE 
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * Gets the 省CODE .
	 *
	 * @return the 省CODE 
	 */
	public String getProvinceCode() {
		return provinceCode;
	}

	/**
	 * Sets the 省CODE .
	 *
	 * @param provinceCode the new 省CODE 
	 */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	/**
	 * Gets the 市CODE .
	 *
	 * @return the 市CODE 
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * Sets the 市CODE .
	 *
	 * @param cityCode the new 市CODE 
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	/**
	 * Gets the 市区CODE .
	 *
	 * @return the 市区CODE 
	 */
	public String getCityAreaCode() {
		return cityAreaCode;
	}

	/**
	 * Sets the 市区CODE .
	 *
	 * @param cityAreaCode the new 市区CODE 
	 */
	public void setCityAreaCode(String cityAreaCode) {
		this.cityAreaCode = cityAreaCode;
	}

	/**
	 * Gets the 地址信息 .
	 *
	 * @return the 地址信息 
	 */
	public String getAddrInfo() {
		return addrInfo;
	}

	/**
	 * Sets the 地址信息 .
	 *
	 * @param addrInfo the new 地址信息 
	 */
	public void setAddrInfo(String addrInfo) {
		this.addrInfo = addrInfo;
	}

	/**
	 * Gets the lOGO图片 .
	 *
	 * @return the lOGO图片 
	 */
	public String getLogoAddr() {
		return logoAddr;
	}

	/**
	 * Sets the lOGO图片 .
	 *
	 * @param logoAddr the new lOGO图片 
	 */
	public void setLogoAddr(String logoAddr) {
		this.logoAddr = logoAddr;
	}

	/**
	 * Gets the 经度 .
	 *
	 * @return the 经度 
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * Sets the 经度 .
	 *
	 * @param longitude the new 经度 
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * Gets the 纬度 .
	 *
	 * @return the 纬度 
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * Sets the 纬度 .
	 *
	 * @param latitude the new 纬度 
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * Gets the 经营范围 .
	 *
	 * @return the 经营范围 
	 */
	public String getBizScope() {
		return bizScope;
	}

	/**
	 * Sets the 经营范围 .
	 *
	 * @param bizScope the new 经营范围 
	 */
	public void setBizScope(String bizScope) {
		this.bizScope = bizScope;
	}

	/**
	 * Gets the 门店二维码地址 .
	 *
	 * @return the 门店二维码地址 
	 */
	public String getQcord() {
		return qcord;
	}

	/**
	 * Sets the 门店二维码地址 .
	 *
	 * @param qcord the new 门店二维码地址 
	 */
	public void setQcord(String qcord) {
		this.qcord = qcord;
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
	 * @param updateId the new 更新人 
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
	 * @param updateDate the new 更新时间 
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
		builder.append("FindShopPageReturn [code=").append(code)
				.append(", shopNo=").append(shopNo).append(", shopName=")
				.append(shopName).append(", shopType=").append(shopType)
				.append(", memberNoMerchant=").append(memberNoMerchant)
				.append(", memberNameMerchant=").append(memberNameMerchant)
				.append(", status=").append(status).append(", telephone=")
				.append(telephone).append(", mobile=").append(mobile)
				.append(", email=").append(email).append(", address=")
				.append(address).append(", areaCode=").append(areaCode)
				.append(", areaName=").append(areaName)
				.append(", provinceCode=").append(provinceCode)
				.append(", cityCode=").append(cityCode)
				.append(", cityAreaCode=").append(cityAreaCode)
				.append(", addrInfo=").append(addrInfo).append(", logoAddr=")
				.append(logoAddr).append(", longitude=").append(longitude)
				.append(", latitude=").append(latitude).append(", bizScope=")
				.append(bizScope).append(", qcord=").append(qcord)
				.append(", createId=").append(createId).append(", createDate=")
				.append(createDate).append(", updateId=").append(updateId)
				.append(", updateDate=").append(updateDate)
				.append(", remark4=").append(remark4).append(", remark3=")
				.append(remark3).append(", remark=").append(remark)
				.append(", remark2=").append(remark2).append(", guidNum=")
				.append(guidNum).append(", personNum=").append(personNum)
				.append(", clerkNum=").append(clerkNum)
				.append(", memberNameShop=").append(memberNameShop)
				.append(", openDate=").append(openDate)
				.append(", orderAmount=").append(orderAmount)
				.append(", shopNoMerchant=").append(shopNoMerchant).append("]");
		return builder.toString();
	}

	/**
	 * Gets the 区域名称 .
	 *
	 * @return the 区域名称 
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * Sets the 区域名称 .
	 *
	 * @param areaName the new 区域名称 
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

}
