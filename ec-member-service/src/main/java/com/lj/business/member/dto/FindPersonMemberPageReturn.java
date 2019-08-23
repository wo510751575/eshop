package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindPersonMemberPageReturn.
 */
public class FindPersonMemberPageReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8376502091236703728L;
	/**
	 * CODE .
	 */
	private String code;

	/**
	 * 客户编号 .
	 */
	private String memberNo;

	/**
	 * 客户名称 .
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
	private String remark2;

	/**
	 * 备注 .
	 */
	private String remark;
	
	
	/**
     * 会员状态 
             NORMAL正常
             CANCEL注销
             FREEZE冻结
              .
     */
    private String status;

    /**
     * 证件类型 .
     */
    private String certTypeCode;

    /**
     * 证件号码 .
     */
    private String certNo;

    /**
     * 手机号 .
     */
    private String mobile;
    /**
     * 手机串号 .
     */
    private String imei;

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
     * 性别:
             男：male
             女：female
             未知：unknown .
     */
    private String sex;

    /**
     * 实名认证标识 N未实名认证  Y实名认证 .
     */
    private String nameAuthFlag;

    /**
     * 登录密码 .
     */
    private String pwd;

    /**
     * 加密机CODE .
     */
    private String encryptionCode;

    /**
     * 会员来源 ：微博营销 等 .
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
    
    /** 会员分类Code. */
    private String pmTypeCode;		
    
    /** 会员分类名称. */
    private String pmTypeName;		
    
    /** 客户分类类型. */
    private String pmTypeType;
    
    /** 客户分类维度. */
    private String pmTypeDim;
    
    /** 客户分类状态. */
    private String pmTypeStatus;
    
    /** 跟进次数. */
    private Integer followNum;
    
    /** 维护次数. */
    private Integer keepNum;
    
    /** 放弃次数. */
    private Integer giveUpNum;
    
    /** 购买次数. */
    private Integer successNum;
    
    /** 导购头像. */
    private String gmPhoto;
    
    /** 微信号. */
    private String noWx;
    /**职业名称*/
    private String jobName;
    /**
     * 出生日期 .
     */
    private Date birthday;
    
    /**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
     * Gets the 购买次数.
     *
     * @return the successNum
     */
	public Integer getSuccessNum() {
		return successNum;
	}

	/**
	 * Sets the 购买次数.
	 *
	 * @param successNum the successNum to set
	 */
	public void setSuccessNum(Integer successNum) {
		this.successNum = successNum;
	}

	/**
	 * Gets the 放弃次数.
	 *
	 * @return the giveUpNum
	 */
	public Integer getGiveUpNum() {
		return giveUpNum;
	}

	/**
	 * Sets the 放弃次数.
	 *
	 * @param giveUpNum the giveUpNum to set
	 */
	public void setGiveUpNum(Integer giveUpNum) {
		this.giveUpNum = giveUpNum;
	}

	/**
	 * Gets the 微信号.
	 *
	 * @return the noWx
	 */
	public String getNoWx() {
		return noWx;
	}

	/**
	 * Sets the 微信号.
	 *
	 * @param noWx the noWx to set
	 */
	public void setNoWx(String noWx) {
		this.noWx = noWx;
	}
    
    /**
     * Gets the 导购头像.
     *
     * @return the gmPhoto
     */
	public String getGmPhoto() {
		return gmPhoto;
	}

	/**
	 * Sets the 导购头像.
	 *
	 * @param gmPhoto the gmPhoto to set
	 */
	public void setGmPhoto(String gmPhoto) {
		this.gmPhoto = gmPhoto;
	}

	/**
	 * Gets the 跟进次数.
	 *
	 * @return the followNum
	 */
	public Integer getFollowNum() {
		return followNum;
	}

	/**
	 * Sets the 跟进次数.
	 *
	 * @param followNum the followNum to set
	 */
	public void setFollowNum(Integer followNum) {
		this.followNum = followNum;
	}

	/**
	 * Gets the 维护次数.
	 *
	 * @return the keepNum
	 */
	public Integer getKeepNum() {
		return keepNum;
	}

	/**
	 * Sets the 维护次数.
	 *
	 * @param keepNum the keepNum to set
	 */
	public void setKeepNum(Integer keepNum) {
		this.keepNum = keepNum;
	}

	/**
	 * Gets the 放弃次数.
	 *
	 * @return the paNum
	 */
	public Integer getPaNum() {
		return paNum;
	}

	/**
	 * Sets the 放弃次数.
	 *
	 * @param paNum the paNum to set
	 */
	public void setPaNum(Integer paNum) {
		this.paNum = paNum;
	}

	/** 放弃次数. */
    private Integer paNum;
    
    
    
    /**
     * Gets the 客户分类类型.
     *
     * @return the pmTypeType
     */
	public String getPmTypeType() {
		return pmTypeType;
	}

	/**
	 * Sets the 客户分类类型.
	 *
	 * @param pmTypeType the pmTypeType to set
	 */
	public void setPmTypeType(String pmTypeType) {
		this.pmTypeType = pmTypeType;
	}

	/**
	 * Gets the 客户分类维度.
	 *
	 * @return the pmTypeDim
	 */
	public String getPmTypeDim() {
		return pmTypeDim;
	}

	/**
	 * Sets the 客户分类维度.
	 *
	 * @param pmTypeDim the pmTypeDim to set
	 */
	public void setPmTypeDim(String pmTypeDim) {
		this.pmTypeDim = pmTypeDim;
	}

	/**
	 * Gets the 客户分类状态.
	 *
	 * @return the pmTypeStatus
	 */
	public String getPmTypeStatus() {
		return pmTypeStatus;
	}

	/**
	 * Sets the 客户分类状态.
	 *
	 * @param pmTypeStatus the pmTypeStatus to set
	 */
	public void setPmTypeStatus(String pmTypeStatus) {
		this.pmTypeStatus = pmTypeStatus;
	}

	/**
	 * Gets the 手机串号 .
	 *
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}

	/**
	 * Sets the 手机串号 .
	 *
	 * @param imei the imei to set
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}

	/**
	 * Gets the 家庭组CODE .
	 *
	 * @return the familyCode
	 */
	public String getFamilyCode() {
		return familyCode;
	}

	/**
	 * Sets the 家庭组CODE .
	 *
	 * @param familyCode the familyCode to set
	 */
	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}

	/**
	 * Gets the 客户家庭组名称 .
	 *
	 * @return the familyName
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * Sets the 客户家庭组名称 .
	 *
	 * @param familyName the familyName to set
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	/**
	 * Gets the 兴趣 .
	 *
	 * @return the interest
	 */
	public String getInterest() {
		return interest;
	}

	/**
	 * Sets the 兴趣 .
	 *
	 * @param interest the interest to set
	 */
	public void setInterest(String interest) {
		this.interest = interest;
	}

	/**
	 * Gets the 省CODE .
	 *
	 * @return the provinceCode
	 */
	public String getProvinceCode() {
		return provinceCode;
	}

	/**
	 * Sets the 省CODE .
	 *
	 * @param provinceCode the provinceCode to set
	 */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	/**
	 * Gets the 市CODE .
	 *
	 * @return the cityCode
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * Sets the 市CODE .
	 *
	 * @param cityCode the cityCode to set
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	/**
	 * Gets the 市区CODE .
	 *
	 * @return the cityAreaCode
	 */
	public String getCityAreaCode() {
		return cityAreaCode;
	}

	/**
	 * Sets the 市区CODE .
	 *
	 * @param cityAreaCode the cityAreaCode to set
	 */
	public void setCityAreaCode(String cityAreaCode) {
		this.cityAreaCode = cityAreaCode;
	}


	/**
	 * Gets the 会员分类Code.
	 *
	 * @return the pmTypeCode
	 */
	public String getPmTypeCode() {
		return pmTypeCode;
	}

	/**
	 * Sets the 会员分类Code.
	 *
	 * @param pmTypeCode the pmTypeCode to set
	 */
	public void setPmTypeCode(String pmTypeCode) {
		this.pmTypeCode = pmTypeCode;
	}

	/**
	 * Gets the 会员分类名称.
	 *
	 * @return the pmTypeName
	 */
	public String getPmTypeName() {
		return pmTypeName;
	}

	/**
	 * Sets the 会员分类名称.
	 *
	 * @param pmTypeName the pmTypeName to set
	 */
	public void setPmTypeName(String pmTypeName) {
		this.pmTypeName = pmTypeName;
	}

	/**
	 * Gets the 区域CODE .
	 *
	 * @return the areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * Sets the 区域CODE .
	 *
	 * @param areaCode the areaCode to set
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * Gets the 会员状态 NORMAL正常 CANCEL注销 FREEZE冻结 .
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the 会员状态 NORMAL正常 CANCEL注销 FREEZE冻结 .
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the 证件类型 .
	 *
	 * @return the certTypeCode
	 */
	public String getCertTypeCode() {
		return certTypeCode;
	}

	/**
	 * Sets the 证件类型 .
	 *
	 * @param certTypeCode the certTypeCode to set
	 */
	public void setCertTypeCode(String certTypeCode) {
		this.certTypeCode = certTypeCode;
	}

	/**
	 * Gets the 证件号码 .
	 *
	 * @return the certNo
	 */
	public String getCertNo() {
		return certNo;
	}

	/**
	 * Sets the 证件号码 .
	 *
	 * @param certNo the certNo to set
	 */
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	/**
	 * Gets the 手机号 .
	 *
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Sets the 手机号 .
	 *
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * Gets the 邮箱 .
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the 邮箱 .
	 *
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the 职业 .
	 *
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * Sets the 职业 .
	 *
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * Gets the 住址 .
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the 住址 .
	 *
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the 年龄 .
	 *
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Sets the 年龄 .
	 *
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * Gets the 性别: 男：male 女：female 未知：unknown .
	 *
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * Sets the 性别: 男：male 女：female 未知：unknown .
	 *
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * Gets the 实名认证标识 N未实名认证  Y实名认证 .
	 *
	 * @return the nameAuthFlag
	 */
	public String getNameAuthFlag() {
		return nameAuthFlag;
	}

	/**
	 * Sets the 实名认证标识 N未实名认证  Y实名认证 .
	 *
	 * @param nameAuthFlag the nameAuthFlag to set
	 */
	public void setNameAuthFlag(String nameAuthFlag) {
		this.nameAuthFlag = nameAuthFlag;
	}

	/**
	 * Gets the 登录密码 .
	 *
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * Sets the 登录密码 .
	 *
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * Gets the 加密机CODE .
	 *
	 * @return the encryptionCode
	 */
	public String getEncryptionCode() {
		return encryptionCode;
	}

	/**
	 * Sets the 加密机CODE .
	 *
	 * @param encryptionCode the encryptionCode to set
	 */
	public void setEncryptionCode(String encryptionCode) {
		this.encryptionCode = encryptionCode;
	}

	/**
	 * Gets the 会员来源 ：微博营销 等 .
	 *
	 * @return the memberSrc
	 */
	public String getMemberSrc() {
		return memberSrc;
	}

	/**
	 * Sets the 会员来源 ：微博营销 等 .
	 *
	 * @param memberSrc the memberSrc to set
	 */
	public void setMemberSrc(String memberSrc) {
		this.memberSrc = memberSrc;
	}

	/**
	 * Gets the 微信公众号OPENID .
	 *
	 * @return the openIdGzhWx
	 */
	public String getOpenIdGzhWx() {
		return openIdGzhWx;
	}

	/**
	 * Sets the 微信公众号OPENID .
	 *
	 * @param openIdGzhWx the openIdGzhWx to set
	 */
	public void setOpenIdGzhWx(String openIdGzhWx) {
		this.openIdGzhWx = openIdGzhWx;
	}

	/**
	 * Gets the 微信小程序OPENID .
	 *
	 * @return the openIdXcxWx
	 */
	public String getOpenIdXcxWx() {
		return openIdXcxWx;
	}

	/**
	 * Sets the 微信小程序OPENID .
	 *
	 * @param openIdXcxWx the openIdXcxWx to set
	 */
	public void setOpenIdXcxWx(String openIdXcxWx) {
		this.openIdXcxWx = openIdXcxWx;
	}

	/**
	 * Gets the 昵称_微信 .
	 *
	 * @return the nickNameWx
	 */
	public String getNickNameWx() {
		return nickNameWx;
	}

	/**
	 * Sets the 昵称_微信 .
	 *
	 * @param nickNameWx the nickNameWx to set
	 */
	public void setNickNameWx(String nickNameWx) {
		this.nickNameWx = nickNameWx;
	}

	/**
	 * Gets the 城市_微信 .
	 *
	 * @return the cityWx
	 */
	public String getCityWx() {
		return cityWx;
	}

	/**
	 * Sets the 城市_微信 .
	 *
	 * @param cityWx the cityWx to set
	 */
	public void setCityWx(String cityWx) {
		this.cityWx = cityWx;
	}

	/**
	 * Gets the 国家 .
	 *
	 * @return the countryWx
	 */
	public String getCountryWx() {
		return countryWx;
	}

	/**
	 * Sets the 国家 .
	 *
	 * @param countryWx the countryWx to set
	 */
	public void setCountryWx(String countryWx) {
		this.countryWx = countryWx;
	}

	/**
	 * Gets the 省_微信 .
	 *
	 * @return the provinceWx
	 */
	public String getProvinceWx() {
		return provinceWx;
	}

	/**
	 * Sets the 省_微信 .
	 *
	 * @param provinceWx the provinceWx to set
	 */
	public void setProvinceWx(String provinceWx) {
		this.provinceWx = provinceWx;
	}

	/**
	 * Gets the 头像地址 .
	 *
	 * @return the headAddress
	 */
	public String getHeadAddress() {
		return headAddress;
	}

	/**
	 * Sets the 头像地址 .
	 *
	 * @param headAddress the headAddress to set
	 */
	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}

	/**
	 * Gets the 关注时间 .
	 *
	 * @return the subsribeTime
	 */
	public Date getSubsribeTime() {
		return subsribeTime;
	}

	/**
	 * Sets the 关注时间 .
	 *
	 * @param subsribeTime the subsribeTime to set
	 */
	public void setSubsribeTime(Date subsribeTime) {
		this.subsribeTime = subsribeTime;
	}

	/**
	 * CODE .
	 *
	 * @return the cODE 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * CODE .
	 *
	 * @param code the new cODE 
	 */
	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	/**
	 * 客户编号 .
	 *
	 * @return the 客户编号 
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * 客户编号 .
	 *
	 * @param memberNo the new 客户编号 
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo == null ? null : memberNo.trim();
	}

	/**
	 * 客户名称 .
	 *
	 * @return the 客户名称 
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * 客户名称 .
	 *
	 * @param memberName the new 客户名称 
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName == null ? null : memberName.trim();
	}

	/**
	 * 导购编号 .
	 *
	 * @return the 导购编号 
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * 导购编号 .
	 *
	 * @param memberNoGm the new 导购编号 
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm == null ? null : memberNoGm.trim();
	}

	/**
	 * 导购姓名 .
	 *
	 * @return the 导购姓名 
	 */
	public String getMemberNameGm() {
		return memberNameGm;
	}

	/**
	 * 导购姓名 .
	 *
	 * @param memberNameGm the new 导购姓名 
	 */
	public void setMemberNameGm(String memberNameGm) {
		this.memberNameGm = memberNameGm == null ? null : memberNameGm.trim();
	}

	/**
	 * 分店编号 .
	 *
	 * @return the 分店编号 
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * 分店编号 .
	 *
	 * @param shopNo the new 分店编号 
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo == null ? null : shopNo.trim();
	}

	/**
	 * 分店名称 .
	 *
	 * @return the 分店名称 
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * 分店名称 .
	 *
	 * @param shopName the new 分店名称 
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName == null ? null : shopName.trim();
	}

	/**
	 * 商户编号 .
	 *
	 * @return the 商户编号 
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * 商户编号 .
	 *
	 * @param merchantNo the new 商户编号 
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo == null ? null : merchantNo.trim();
	}

	/**
	 * 商户名称 .
	 *
	 * @return the 商户名称 
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * 商户名称 .
	 *
	 * @param merchantName the new 商户名称 
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName == null ? null : merchantName.trim();
	}

	/**
	 * 装修进度 .
	 *
	 * @return the 装修进度 
	 */
	public String getSpruceUp() {
		return spruceUp;
	}

	/**
	 * 装修进度 .
	 *
	 * @param spruceUp the new 装修进度 
	 */
	public void setSpruceUp(String spruceUp) {
		this.spruceUp = spruceUp == null ? null : spruceUp.trim();
	}

	/**
	 * 所在楼盘 .
	 *
	 * @return the 所在楼盘 
	 */
	public String getHouses() {
		return houses;
	}

	/**
	 * 所在楼盘 .
	 *
	 * @param houses the new 所在楼盘 
	 */
	public void setHouses(String houses) {
		this.houses = houses == null ? null : houses.trim();
	}

	/**
	 * 是否关注 .
	 *
	 * @return the 是否关注 
	 */
	public String getKeepEye() {
		return keepEye;
	}

	/**
	 * 是否关注 .
	 *
	 * @param keepEye the new 是否关注 
	 */
	public void setKeepEye(String keepEye) {
		this.keepEye = keepEye == null ? null : keepEye.trim();
	}

	/**
	 * 紧急客户 .
	 *
	 * @return the 紧急客户 
	 */
	public String getUrgencyPm() {
		return urgencyPm;
	}

	/**
	 * 紧急客户 .
	 *
	 * @param urgencyPm the new 紧急客户 
	 */
	public void setUrgencyPm(String urgencyPm) {
		this.urgencyPm = urgencyPm == null ? null : urgencyPm.trim();
	}

	/**
	 * 所需产品CODE .
	 *
	 * @return the 所需产品CODE 
	 */
	public String getBomCode() {
		return bomCode;
	}

	/**
	 * 所需产品CODE .
	 *
	 * @param bomCode the new 所需产品CODE 
	 */
	public void setBomCode(String bomCode) {
		this.bomCode = bomCode == null ? null : bomCode.trim();
	}

	/**
	 * 产品名称 .
	 *
	 * @return the 产品名称 
	 */
	public String getBomName() {
		return bomName;
	}

	/**
	 * 产品名称 .
	 *
	 * @param bomName the new 产品名称 
	 */
	public void setBomName(String bomName) {
		this.bomName = bomName == null ? null : bomName.trim();
	}

	/**
	 * 创建人 .
	 *
	 * @return the 创建人 
	 */
	public String getCreateId() {
		return createId;
	}

	/**
	 * 创建人 .
	 *
	 * @param createId the new 创建人 
	 */
	public void setCreateId(String createId) {
		this.createId = createId == null ? null : createId.trim();
	}

	/**
	 * 创建时间 .
	 *
	 * @return the 创建时间 
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 创建时间 .
	 *
	 * @param createDate the new 创建时间 
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 更新人 .
	 *
	 * @return the 更新人 
	 */
	public String getUpdateId() {
		return updateId;
	}

	/**
	 * 更新人 .
	 *
	 * @param updateId the new 更新人 
	 */
	public void setUpdateId(String updateId) {
		this.updateId = updateId == null ? null : updateId.trim();
	}

	/**
	 * 更新时间 .
	 *
	 * @return the 更新时间 
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 更新时间 .
	 *
	 * @param updateDate the new 更新时间 
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 备注 .
	 *
	 * @return the 备注 
	 */
	public String getRemark4() {
		return remark4;
	}

	/**
	 * 备注 .
	 *
	 * @param remark4 the new 备注 
	 */
	public void setRemark4(String remark4) {
		this.remark4 = remark4 == null ? null : remark4.trim();
	}

	/**
	 * 备注 .
	 *
	 * @return the 备注 
	 */
	public String getRemark3() {
		return remark3;
	}

	/**
	 * 备注 .
	 *
	 * @param remark3 the new 备注 
	 */
	public void setRemark3(String remark3) {
		this.remark3 = remark3 == null ? null : remark3.trim();
	}

	/**
	 * 备注 .
	 *
	 * @return the 备注 
	 */
	public String getRemark2() {
		return remark2;
	}

	/**
	 * 备注 .
	 *
	 * @param remark2 the new 备注 
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2 == null ? null : remark2.trim();
	}

	/**
	 * 备注 .
	 *
	 * @return the 备注 
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 备注 .
	 *
	 * @param remark the new 备注 
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FindPersonMemberPageReturn [code=" + code + ", memberNo="
				+ memberNo + ", memberName=" + memberName + ", memberNoGm="
				+ memberNoGm + ", memberNameGm=" + memberNameGm + ", shopNo="
				+ shopNo + ", shopName=" + shopName + ", merchantNo="
				+ merchantNo + ", merchantName=" + merchantName + ", spruceUp="
				+ spruceUp + ", houses=" + houses + ", keepEye=" + keepEye
				+ ", urgencyPm=" + urgencyPm + ", bomCode=" + bomCode
				+ ", bomName=" + bomName + ", createId=" + createId
				+ ", createDate=" + createDate + ", updateId=" + updateId
				+ ", updateDate=" + updateDate + ", remark4=" + remark4
				+ ", remark3=" + remark3 + ", remark2=" + remark2 + ", remark="
				+ remark + ", status=" + status + ", certTypeCode="
				+ certTypeCode + ", certNo=" + certNo + ", mobile=" + mobile
				+ ", imei=" + imei + ", email=" + email + ", job=" + job
				+ ", address=" + address + ", age=" + age + ", sex=" + sex
				+ ", nameAuthFlag=" + nameAuthFlag + ", pwd=" + pwd
				+ ", encryptionCode=" + encryptionCode + ", memberSrc="
				+ memberSrc + ", openIdGzhWx=" + openIdGzhWx + ", openIdXcxWx="
				+ openIdXcxWx + ", nickNameWx=" + nickNameWx + ", cityWx="
				+ cityWx + ", countryWx=" + countryWx + ", provinceWx="
				+ provinceWx + ", headAddress=" + headAddress
				+ ", subsribeTime=" + subsribeTime + ", familyCode="
				+ familyCode + ", familyName=" + familyName + ", interest="
				+ interest + ", areaCode=" + areaCode + ", provinceCode="
				+ provinceCode + ", cityCode=" + cityCode + ", cityAreaCode="
				+ cityAreaCode + ", pmTypeCode=" + pmTypeCode + ", pmTypeName="
				+ pmTypeName + ", pmTypeType=" + pmTypeType + ", pmTypeDim="
				+ pmTypeDim + ", pmTypeStatus=" + pmTypeStatus + ", followNum="
				+ followNum + ", keepNum=" + keepNum + ", gmPhoto=" + gmPhoto
				+ ", paNum=" + paNum + "]";
	}

}
