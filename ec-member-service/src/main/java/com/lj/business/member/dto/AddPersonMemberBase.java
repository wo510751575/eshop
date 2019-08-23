package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

import com.lj.business.member.emus.MemberStatus;
import com.lj.business.member.emus.NameAuthFlag;

// TODO: Auto-generated Javadoc
/**
 * The Class AddPersonMemberBase.
 */
public class AddPersonMemberBase implements Serializable { 

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5837002956185542324L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 会员号  .
     */
    private String memberNo;

    /**
     * 会员名称 .(必填)
     */
    private String memberName;

    /**
     * 会员状态 
             NORMAL正常
             CANCEL注销
             FREEZE冻结
              .
     */
    private MemberStatus status;

    /**
     * 证件类型 .
     */
    private String certTypeCode;

    /**
     * 证件号码 .
     */
    private String certNo;

    /**
     * 手机号 .(必填)
     */
    private String mobile;

    /**
     * 邮箱 .
     */
    private String email;

    /**
     * 职业 .
     */
    private String job;

    /**
     * 住址 .
     */
    private String address;

    /**
     * 年龄 .
     */
    private Integer age;

    /**
     * 性别:(必填)
             男：male
             女：female
             未知：unknown .
     */
    private String sex;

    /**
     * 实名认证标识 N未实名认证  Y实名认证 .
     */
    private NameAuthFlag nameAuthFlag;

    /**
     * 登录密码 .
     */
    private String pwd;

    /**
     * 加密机CODE .
     */
    private String encryptionCode;

    /**
     * 会员来源 ：微博营销 等 .(必填)
     */
    private String memberSrc;

    /**
     * 微信公众号OPENID .
     */
    private String openIdGzhWx;

    /**
     * 微信小程序OPENID .
     */
    private String openIdXcxWx;

    /**
     * 昵称_微信 .
     */
    private String nickNameWx;

    /**
     * 城市_微信 .
     */
    private String cityWx;

    /**
     * 国家 .
     */
    private String countryWx;

    /**
     * 省_微信 .
     */
    private String provinceWx;

    /**
     * 头像地址 .
     */
    private String headAddress;

    /**
     * 关注时间 .
     */
    private Date subsribeTime;
    
    /**
     * 市区CODE .
     */
    private String cityAreaCode;

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
     * 紧急标记.
     */
    private String urgencyPm;

    /**
     * 装修进度.
     */
    private String spruceUp;
    
    /**
     * 导购编码.(必填)
     */
    private String memberNoGm;
    
    
    /**
     * 导购名称.
     */
    private String memberNameGm;
    
    /**
     * 门店编码.
     */
    private String shopNo;
    
    
    /**
     * 门店名称.
     */
    private String shopName;
    
    /**
     * 客户类型编码.(必填)
     */
    private String pmTypeCode;
    
    
    /**
     * 客户类型名称.
     */
    private String pmTypeName;
    
    /** 所需产品. */
    private String bomName;
    
    
    /** 房子. */
    private String houses;
    
    
    /**
     * 商户号  .(必填)
     */
    private String merchantNo;
    /**
     * 商户名称 .
     */
    private String merchantName;
    
    /**
     * 手机串号 .
     */
    private String imei;
    
    /**
     * 微信号 .
     */
    private String noWx;
    
    /**
     * 家庭组CODE .
     */
    private String familyCode;

    /**
     * 客户家庭组名称 .
     */
    private String familyName;

    /**
     * 兴趣 .
     */
    private String interest;

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
    
    /** 出生日期. */
    private Date birthday;
    
    /** 客户特质. */
    private String clientSpecial;
    
    /*
     * 对比品牌
     */
    private String brandCompare;

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
	 * Gets the 会员号  .
	 *
	 * @return the 会员号  
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 会员号  .
	 *
	 * @param memberNo the new 会员号  
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
	 * @param memberName the new 会员名称 
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * Gets the 会员状态 NORMAL正常 CANCEL注销 FREEZE冻结 .
	 *
	 * @return the 会员状态 NORMAL正常 CANCEL注销 FREEZE冻结 
	 */
	public MemberStatus getStatus() {
		return status;
	}

	/**
	 * Sets the 会员状态 NORMAL正常 CANCEL注销 FREEZE冻结 .
	 *
	 * @param status the new 会员状态 NORMAL正常 CANCEL注销 FREEZE冻结 
	 */
	public void setStatus(MemberStatus status) {
		this.status = status;
	}

	/**
	 * Gets the 证件类型 .
	 *
	 * @return the 证件类型 
	 */
	public String getCertTypeCode() {
		return certTypeCode;
	}

	/**
	 * Sets the 证件类型 .
	 *
	 * @param certTypeCode the new 证件类型 
	 */
	public void setCertTypeCode(String certTypeCode) {
		this.certTypeCode = certTypeCode;
	}

	/**
	 * Gets the 证件号码 .
	 *
	 * @return the 证件号码 
	 */
	public String getCertNo() {
		return certNo;
	}

	/**
	 * Sets the 证件号码 .
	 *
	 * @param certNo the new 证件号码 
	 */
	public void setCertNo(String certNo) {
		this.certNo = certNo;
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
	 * Gets the 职业 .
	 *
	 * @return the 职业 
	 */
	public String getJob() {
		return job;
	}

	/**
	 * Sets the 职业 .
	 *
	 * @param job the new 职业 
	 */
	public void setJob(String job) {
		this.job = job;
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
	 * Gets the 年龄 .
	 *
	 * @return the 年龄 
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Sets the 年龄 .
	 *
	 * @param age the new 年龄 
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * Gets the 性别:(必填) 男：male 女：female 未知：unknown .
	 *
	 * @return the 性别:(必填) 男：male 女：female 未知：unknown 
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * Sets the 性别:(必填) 男：male 女：female 未知：unknown .
	 *
	 * @param sex the new 性别:(必填) 男：male 女：female 未知：unknown 
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * Gets the 实名认证标识 N未实名认证  Y实名认证 .
	 *
	 * @return the 实名认证标识 N未实名认证  Y实名认证 
	 */
	public NameAuthFlag getNameAuthFlag() {
		return nameAuthFlag;
	}

	/**
	 * Sets the 实名认证标识 N未实名认证  Y实名认证 .
	 *
	 * @param nameAuthFlag the new 实名认证标识 N未实名认证  Y实名认证 
	 */
	public void setNameAuthFlag(NameAuthFlag nameAuthFlag) {
		this.nameAuthFlag = nameAuthFlag;
	}

	/**
	 * Gets the 登录密码 .
	 *
	 * @return the 登录密码 
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * Sets the 登录密码 .
	 *
	 * @param pwd the new 登录密码 
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * Gets the 加密机CODE .
	 *
	 * @return the 加密机CODE 
	 */
	public String getEncryptionCode() {
		return encryptionCode;
	}

	/**
	 * Sets the 加密机CODE .
	 *
	 * @param encryptionCode the new 加密机CODE 
	 */
	public void setEncryptionCode(String encryptionCode) {
		this.encryptionCode = encryptionCode;
	}

	/**
	 * Gets the 会员来源 ：微博营销 等 .
	 *
	 * @return the 会员来源 ：微博营销 等 
	 */
	public String getMemberSrc() {
		return memberSrc;
	}

	/**
	 * Sets the 会员来源 ：微博营销 等 .
	 *
	 * @param memberSrc the new 会员来源 ：微博营销 等 
	 */
	public void setMemberSrc(String memberSrc) {
		this.memberSrc = memberSrc;
	}

	/**
	 * Gets the 微信公众号OPENID .
	 *
	 * @return the 微信公众号OPENID 
	 */
	public String getOpenIdGzhWx() {
		return openIdGzhWx;
	}

	/**
	 * Sets the 微信公众号OPENID .
	 *
	 * @param openIdGzhWx the new 微信公众号OPENID 
	 */
	public void setOpenIdGzhWx(String openIdGzhWx) {
		this.openIdGzhWx = openIdGzhWx;
	}

	/**
	 * Gets the 微信小程序OPENID .
	 *
	 * @return the 微信小程序OPENID 
	 */
	public String getOpenIdXcxWx() {
		return openIdXcxWx;
	}

	/**
	 * Sets the 微信小程序OPENID .
	 *
	 * @param openIdXcxWx the new 微信小程序OPENID 
	 */
	public void setOpenIdXcxWx(String openIdXcxWx) {
		this.openIdXcxWx = openIdXcxWx;
	}

	/**
	 * Gets the 昵称_微信 .
	 *
	 * @return the 昵称_微信 
	 */
	public String getNickNameWx() {
		return nickNameWx;
	}

	/**
	 * Sets the 昵称_微信 .
	 *
	 * @param nickNameWx the new 昵称_微信 
	 */
	public void setNickNameWx(String nickNameWx) {
		this.nickNameWx = nickNameWx;
	}

	/**
	 * Gets the 城市_微信 .
	 *
	 * @return the 城市_微信 
	 */
	public String getCityWx() {
		return cityWx;
	}

	/**
	 * Sets the 城市_微信 .
	 *
	 * @param cityWx the new 城市_微信 
	 */
	public void setCityWx(String cityWx) {
		this.cityWx = cityWx;
	}

	/**
	 * Gets the 国家 .
	 *
	 * @return the 国家 
	 */
	public String getCountryWx() {
		return countryWx;
	}

	/**
	 * Sets the 国家 .
	 *
	 * @param countryWx the new 国家 
	 */
	public void setCountryWx(String countryWx) {
		this.countryWx = countryWx;
	}

	/**
	 * Gets the 省_微信 .
	 *
	 * @return the 省_微信 
	 */
	public String getProvinceWx() {
		return provinceWx;
	}

	/**
	 * Sets the 省_微信 .
	 *
	 * @param provinceWx the new 省_微信 
	 */
	public void setProvinceWx(String provinceWx) {
		this.provinceWx = provinceWx;
	}

	/**
	 * Gets the 头像地址 .
	 *
	 * @return the 头像地址 
	 */
	public String getHeadAddress() {
		return headAddress;
	}

	/**
	 * Sets the 头像地址 .
	 *
	 * @param headAddress the new 头像地址 
	 */
	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}

	/**
	 * Gets the 关注时间 .
	 *
	 * @return the 关注时间 
	 */
	public Date getSubsribeTime() {
		return subsribeTime;
	}

	/**
	 * Sets the 关注时间 .
	 *
	 * @param subsribeTime the new 关注时间 
	 */
	public void setSubsribeTime(Date subsribeTime) {
		this.subsribeTime = subsribeTime;
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
	 * Gets the 装修进度.
	 *
	 * @return the 装修进度
	 */
	public String getSpruceUp() {
		return spruceUp;
	}

	/**
	 * Sets the 装修进度.
	 *
	 * @param spruceUp the new 装修进度
	 */
	public void setSpruceUp(String spruceUp) {
		this.spruceUp = spruceUp;
	}

	/**
	 * Gets the 导购编码.
	 *
	 * @return the 导购编码
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the 导购编码.
	 *
	 * @param memberNoGm the new 导购编码
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	/**
	 * Gets the 导购名称.
	 *
	 * @return the 导购名称
	 */
	public String getMemberNameGm() {
		return memberNameGm;
	}

	/**
	 * Sets the 导购名称.
	 *
	 * @param memberNameGm the new 导购名称
	 */
	public void setMemberNameGm(String memberNameGm) {
		this.memberNameGm = memberNameGm;
	}

	/**
	 * Gets the 门店编码.
	 *
	 * @return the 门店编码
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * Sets the 门店编码.
	 *
	 * @param shopNo the new 门店编码
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/**
	 * Gets the 门店名称.
	 *
	 * @return the 门店名称
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * Sets the 门店名称.
	 *
	 * @param shopName the new 门店名称
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * Gets the 客户类型编码.
	 *
	 * @return the 客户类型编码
	 */
	public String getPmTypeCode() {
		return pmTypeCode;
	}

	/**
	 * Sets the 客户类型编码.
	 *
	 * @param pmTypeCode the new 客户类型编码
	 */
	public void setPmTypeCode(String pmTypeCode) {
		this.pmTypeCode = pmTypeCode;
	}

	/**
	 * Gets the 客户类型名称.
	 *
	 * @return the 客户类型名称
	 */
	public String getPmTypeName() {
		return pmTypeName;
	}

	/**
	 * Sets the 客户类型名称.
	 *
	 * @param pmTypeName the new 客户类型名称
	 */
	public void setPmTypeName(String pmTypeName) {
		this.pmTypeName = pmTypeName;
	}

	/**
	 * Gets the 所需产品.
	 *
	 * @return the 所需产品
	 */
	public String getBomName() {
		return bomName;
	}

	/**
	 * Sets the 所需产品.
	 *
	 * @param bomName the new 所需产品
	 */
	public void setBomName(String bomName) {
		this.bomName = bomName;
	}

	/**
	 * Gets the 房子.
	 *
	 * @return the 房子
	 */
	public String getHouses() {
		return houses;
	}

	/**
	 * Sets the 房子.
	 *
	 * @param houses the new 房子
	 */
	public void setHouses(String houses) {
		this.houses = houses;
	}

	/**
	 * Gets the 商户号  .
	 *
	 * @return the 商户号  
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户号  .
	 *
	 * @param merchantNo the new 商户号  
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
	 * @param merchantName the new 商户名称 
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
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
	 * Gets the 微信号 .
	 *
	 * @return the 微信号 
	 */
	public String getNoWx() {
		return noWx;
	}

	/**
	 * Sets the 微信号 .
	 *
	 * @param noWx the new 微信号 
	 */
	public void setNoWx(String noWx) {
		this.noWx = noWx;
	}

	/**
	 * Gets the 家庭组CODE .
	 *
	 * @return the 家庭组CODE 
	 */
	public String getFamilyCode() {
		return familyCode;
	}

	/**
	 * Sets the 家庭组CODE .
	 *
	 * @param familyCode the new 家庭组CODE 
	 */
	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}

	/**
	 * Gets the 客户家庭组名称 .
	 *
	 * @return the 客户家庭组名称 
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * Sets the 客户家庭组名称 .
	 *
	 * @param familyName the new 客户家庭组名称 
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	/**
	 * Gets the 兴趣 .
	 *
	 * @return the 兴趣 
	 */
	public String getInterest() {
		return interest;
	}

	/**
	 * Sets the 兴趣 .
	 *
	 * @param interest the new 兴趣 
	 */
	public void setInterest(String interest) {
		this.interest = interest;
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
	 * Gets the 出生日期.
	 *
	 * @return the 出生日期
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * Sets the 出生日期.
	 *
	 * @param birthday the new 出生日期
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	/**
	 * Gets the client special.
	 *
	 * @return the client special
	 */
	public String getClientSpecial() {
		return clientSpecial;
	}

	/**
	 * Sets the client special.
	 *
	 * @param clientSpecial the new client special
	 */
	public void setClientSpecial(String clientSpecial) {
		this.clientSpecial = clientSpecial;
	}

	/**
	 * Gets the 紧急标记.
	 *
	 * @return the 紧急标记
	 */
	public String getUrgencyPm() {
		return urgencyPm;
	}

	/**
	 * Sets the 紧急标记.
	 *
	 * @param urgencyPm the new 紧急标记
	 */
	public void setUrgencyPm(String urgencyPm) {
		this.urgencyPm = urgencyPm;
	}

	public String getBrandCompare() {
		return brandCompare;
	}

	public void setBrandCompare(String brandCompare) {
		this.brandCompare = brandCompare;
	}

	@Override
	public String toString() {
		return "AddPersonMemberBase [code=" + code + ", memberNo=" + memberNo
				+ ", memberName=" + memberName + ", status=" + status
				+ ", certTypeCode=" + certTypeCode + ", certNo=" + certNo
				+ ", mobile=" + mobile + ", email=" + email + ", job=" + job
				+ ", address=" + address + ", age=" + age + ", sex=" + sex
				+ ", nameAuthFlag=" + nameAuthFlag + ", pwd=" + pwd
				+ ", encryptionCode=" + encryptionCode + ", memberSrc="
				+ memberSrc + ", openIdGzhWx=" + openIdGzhWx + ", openIdXcxWx="
				+ openIdXcxWx + ", nickNameWx=" + nickNameWx + ", cityWx="
				+ cityWx + ", countryWx=" + countryWx + ", provinceWx="
				+ provinceWx + ", headAddress=" + headAddress
				+ ", subsribeTime=" + subsribeTime + ", cityAreaCode="
				+ cityAreaCode + ", createId=" + createId + ", createDate="
				+ createDate + ", updateId=" + updateId + ", updateDate="
				+ updateDate + ", urgencyPm=" + urgencyPm + ", spruceUp="
				+ spruceUp + ", memberNoGm=" + memberNoGm + ", memberNameGm="
				+ memberNameGm + ", shopNo=" + shopNo + ", shopName="
				+ shopName + ", pmTypeCode=" + pmTypeCode + ", pmTypeName="
				+ pmTypeName + ", bomName=" + bomName + ", houses=" + houses
				+ ", merchantNo=" + merchantNo + ", merchantName="
				+ merchantName + ", imei=" + imei + ", noWx=" + noWx
				+ ", familyCode=" + familyCode + ", familyName=" + familyName
				+ ", interest=" + interest + ", areaCode=" + areaCode
				+ ", areaName=" + areaName + ", provinceCode=" + provinceCode
				+ ", cityCode=" + cityCode + ", birthday=" + birthday
				+ ", clientSpecial=" + clientSpecial + ", brandCompare="
				+ brandCompare + "]";
	}
	
}
