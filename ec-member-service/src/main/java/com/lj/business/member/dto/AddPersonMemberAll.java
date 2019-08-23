package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

import com.lj.business.member.emus.Gender;
import com.lj.business.member.emus.KeepEye;
import com.lj.business.member.emus.MemberStatus;
import com.lj.business.member.emus.MemerSourceType;
import com.lj.business.member.emus.NameAuthFlag;
import com.lj.business.member.emus.SpruceUpType;
import com.lj.business.member.emus.UrgentFlagType;

/**
 * The Class AddPersonMemberAll.
 */
public class AddPersonMemberAll implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7003432389471933915L;
	


    /**
     * 客户名称 .
     */
    private String memberName;

    /**
     * 导购编号（必填） .
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
    private SpruceUpType spruceUp;

    /**
     * 所在楼盘 .
     */
    private String houses;

    /**
     * 是否关注 .
     */
    private KeepEye keepEye;

    /**
     * 紧急客户 .
     */
    private UrgentFlagType urgencyPm;

    /**
     * 所需产品CODE .
     */
    private String bomCode;

    /**
     * 产品名称 .
     */
    private String bomName;

    /**
     * 昵称备注_微信 .
     */
    private String nickNameRemarkWx;

    /**
     * 创建人 .
     */
    private String createId;


    /**
     * 状态 
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
    private Gender sex;

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
     * 客户来源 .
     */
    private MemerSourceType memberSrc;

    /**
     * 微信公众号OPENID .
     */
    private String openIdGzhWx;

    /**
     * 微信小程序OPENID .
     */
    private String openIdXcxWx;

    /**
     * 微信号 .
     */
    private String noWx;

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


	/**
	 * Gets the 客户名称 .
	 *
	 * @return the 客户名称 
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * Sets the 客户名称 .
	 *
	 * @param memberName the new 客户名称 
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
	 * @param memberNoGm the new 导购编号 
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
	 * @param memberNameGm the new 导购姓名 
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
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户编号 .
	 *
	 * @param merchantNo the new 商户编号 
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
	 * Gets the 装修进度 .
	 *
	 * @return the 装修进度 
	 */
	public SpruceUpType getSpruceUp() {
		return spruceUp;
	}

	/**
	 * Sets the 装修进度 .
	 *
	 * @param spruceUp the new 装修进度 
	 */
	public void setSpruceUp(SpruceUpType spruceUp) {
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
	 * @param houses the new 所在楼盘 
	 */
	public void setHouses(String houses) {
		this.houses = houses;
	}

	/**
	 * Gets the 是否关注 .
	 *
	 * @return the 是否关注 
	 */
	public KeepEye getKeepEye() {
		return keepEye;
	}

	/**
	 * Sets the 是否关注 .
	 *
	 * @param keepEye the new 是否关注 
	 */
	public void setKeepEye(KeepEye keepEye) {
		this.keepEye = keepEye;
	}

	/**
	 * Gets the 紧急客户 .
	 *
	 * @return the 紧急客户 
	 */
	public UrgentFlagType getUrgencyPm() {
		return urgencyPm;
	}

	/**
	 * Sets the 紧急客户 .
	 *
	 * @param urgencyPm the new 紧急客户 
	 */
	public void setUrgencyPm(UrgentFlagType urgencyPm) {
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
	 * @param bomCode the new 所需产品CODE 
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
	 * @param bomName the new 产品名称 
	 */
	public void setBomName(String bomName) {
		this.bomName = bomName;
	}

	/**
	 * Gets the 昵称备注_微信 .
	 *
	 * @return the 昵称备注_微信 
	 */
	public String getNickNameRemarkWx() {
		return nickNameRemarkWx;
	}

	/**
	 * Sets the 昵称备注_微信 .
	 *
	 * @param nickNameRemarkWx the new 昵称备注_微信 
	 */
	public void setNickNameRemarkWx(String nickNameRemarkWx) {
		this.nickNameRemarkWx = nickNameRemarkWx;
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
	 * Gets the 状态 NORMAL正常 CANCEL注销 FREEZE冻结 .
	 *
	 * @return the 状态 NORMAL正常 CANCEL注销 FREEZE冻结 
	 */
	public MemberStatus getStatus() {
		return status;
	}

	/**
	 * Sets the 状态 NORMAL正常 CANCEL注销 FREEZE冻结 .
	 *
	 * @param status the new 状态 NORMAL正常 CANCEL注销 FREEZE冻结 
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
	 * Gets the 性别: 男：male 女：female 未知：unknown .
	 *
	 * @return the 性别: 男：male 女：female 未知：unknown 
	 */
	public Gender getSex() {
		return sex;
	}

	/**
	 * Sets the 性别: 男：male 女：female 未知：unknown .
	 *
	 * @param sex the new 性别: 男：male 女：female 未知：unknown 
	 */
	public void setSex(Gender sex) {
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
	 * Gets the 客户来源 .
	 *
	 * @return the 客户来源 
	 */
	public MemerSourceType getMemberSrc() {
		return memberSrc;
	}

	/**
	 * Sets the 客户来源 .
	 *
	 * @param memberSrc the new 客户来源 
	 */
	public void setMemberSrc(MemerSourceType memberSrc) {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddPersonMemberAll [memberName=").append(memberName)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", shopNo=").append(shopNo).append(", shopName=")
				.append(shopName).append(", merchantNo=").append(merchantNo)
				.append(", merchantName=").append(merchantName)
				.append(", spruceUp=").append(spruceUp).append(", houses=")
				.append(houses).append(", keepEye=").append(keepEye)
				.append(", urgencyPm=").append(urgencyPm).append(", bomCode=")
				.append(bomCode).append(", bomName=").append(bomName)
				.append(", nickNameRemarkWx=").append(nickNameRemarkWx)
				.append(", createId=").append(createId).append(", status=")
				.append(status).append(", certTypeCode=").append(certTypeCode)
				.append(", certNo=").append(certNo).append(", mobile=")
				.append(mobile).append(", imei=").append(imei)
				.append(", email=").append(email).append(", job=").append(job)
				.append(", address=").append(address).append(", age=")
				.append(age).append(", sex=").append(sex)
				.append(", nameAuthFlag=").append(nameAuthFlag)
				.append(", pwd=").append(pwd).append(", encryptionCode=")
				.append(encryptionCode).append(", memberSrc=")
				.append(memberSrc).append(", openIdGzhWx=").append(openIdGzhWx)
				.append(", openIdXcxWx=").append(openIdXcxWx).append(", noWx=")
				.append(noWx).append(", nickNameWx=").append(nickNameWx)
				.append(", cityWx=").append(cityWx).append(", countryWx=")
				.append(countryWx).append(", provinceWx=").append(provinceWx)
				.append(", headAddress=").append(headAddress)
				.append(", subsribeTime=").append(subsribeTime)
				.append(", familyCode=").append(familyCode)
				.append(", familyName=").append(familyName)
				.append(", interest=").append(interest).append(", areaCode=")
				.append(areaCode).append(", provinceCode=")
				.append(provinceCode).append(", cityCode=").append(cityCode)
				.append(", cityAreaCode=").append(cityAreaCode).append("]");
		return builder.toString();
	}


    
	

}
