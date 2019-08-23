package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class FindPersonMemberBaseReturn.
 */
public class FindPersonMemberBaseReturn implements Serializable { 

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 607103413828024199L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 会员号  .
     */
    private String memberNo;

    /**
     * 会员名称 .
     */
    private String memberName;

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
     * 昵称备注_本地
     */
   private String nickNameRemarkLocal;

    /**
     * 客户分类CODE .
     */
    private String pmTypeCode;

    /**
     * 会员分类名称 .
     */
    private String pmTypeName;
    
    /** The spruce up. */
    private String spruceUp;		//装修进度
    
    /** The houses. */
    private String houses;			//所在楼盘
    /**
     * 资料完善度 .
     */
    private Double ratioClientInfo;
    
    /** 生日. */
    private Date birthday;
    
    
    
    
	public String getNickNameRemarkLocal() {
		return nickNameRemarkLocal;
	}

	public void setNickNameRemarkLocal(String nickNameRemarkLocal) {
		this.nickNameRemarkLocal = nickNameRemarkLocal;
	}

	/**
	 * Gets the ratio client info.
	 *
	 * @return the ratioClientInfo
	 */
	public Double getRatioClientInfo() {
		return ratioClientInfo;
	}

	/**
	 * Sets the ratio client info.
	 *
	 * @param ratioClientInfo the ratioClientInfo to set
	 */
	public void setRatioClientInfo(Double ratioClientInfo) {
		this.ratioClientInfo = ratioClientInfo;
	}

	/**
	 * Gets the 导购编号 .
	 *
	 * @return the memberNoGm
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the 导购编号 .
	 *
	 * @param memberNoGm the memberNoGm to set
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	/**
	 * Gets the 导购姓名 .
	 *
	 * @return the memberNameGm
	 */
	public String getMemberNameGm() {
		return memberNameGm;
	}

	/**
	 * Sets the 导购姓名 .
	 *
	 * @param memberNameGm the memberNameGm to set
	 */
	public void setMemberNameGm(String memberNameGm) {
		this.memberNameGm = memberNameGm;
	}

	/**
	 * Gets the 分店编号 .
	 *
	 * @return the shopNo
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * Sets the 分店编号 .
	 *
	 * @param shopNo the shopNo to set
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/**
	 * Gets the 分店名称 .
	 *
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * Sets the 分店名称 .
	 *
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * Gets the 商户编号 .
	 *
	 * @return the merchantNo
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户编号 .
	 *
	 * @param merchantNo the merchantNo to set
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the 商户名称 .
	 *
	 * @return the merchantName
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * Sets the 商户名称 .
	 *
	 * @param merchantName the merchantName to set
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	/**
	 * Gets the 客户分类CODE .
	 *
	 * @return the pmTypeCode
	 */
	public String getPmTypeCode() {
		return pmTypeCode;
	}

	/**
	 * Sets the 客户分类CODE .
	 *
	 * @param pmTypeCode the pmTypeCode to set
	 */
	public void setPmTypeCode(String pmTypeCode) {
		this.pmTypeCode = pmTypeCode;
	}

	/**
	 * Gets the 会员分类名称 .
	 *
	 * @return the pmTypeName
	 */
	public String getPmTypeName() {
		return pmTypeName;
	}

	/**
	 * Sets the 会员分类名称 .
	 *
	 * @param pmTypeName the pmTypeName to set
	 */
	public void setPmTypeName(String pmTypeName) {
		this.pmTypeName = pmTypeName;
	}

	/**
	 * Gets the spruce up.
	 *
	 * @return the spruceUp
	 */
	public String getSpruceUp() {
		return spruceUp;
	}

	/**
	 * Sets the spruce up.
	 *
	 * @param spruceUp the spruceUp to set
	 */
	public void setSpruceUp(String spruceUp) {
		this.spruceUp = spruceUp;
	}

	/**
	 * Gets the houses.
	 *
	 * @return the houses
	 */
	public String getHouses() {
		return houses;
	}

	/**
	 * Sets the houses.
	 *
	 * @param houses the houses to set
	 */
	public void setHouses(String houses) {
		this.houses = houses;
	}

	/**
	 * Gets the cODE .
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the cODE .
	 *
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the 会员号  .
	 *
	 * @return the memberNo
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 会员号  .
	 *
	 * @param memberNo the memberNo to set
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the 会员名称 .
	 *
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * Sets the 会员名称 .
	 *
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	 * Gets the 创建人 .
	 *
	 * @return the createId
	 */
	public String getCreateId() {
		return createId;
	}

	/**
	 * Sets the 创建人 .
	 *
	 * @param createId the createId to set
	 */
	public void setCreateId(String createId) {
		this.createId = createId;
	}

	/**
	 * Gets the 创建时间 .
	 *
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the 创建时间 .
	 *
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * Gets the 更新人 .
	 *
	 * @return the updateId
	 */
	public String getUpdateId() {
		return updateId;
	}

	/**
	 * Sets the 更新人 .
	 *
	 * @param updateId the updateId to set
	 */
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	/**
	 * Gets the 更新时间 .
	 *
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * Sets the 更新时间 .
	 *
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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
	 * Gets the birthday.
	 *
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * Sets the birthday.
	 *
	 * @param birthday the new birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "FindPersonMemberBaseReturn [code=" + code + ", memberNo="
				+ memberNo + ", memberName=" + memberName + ", status="
				+ status + ", certTypeCode=" + certTypeCode + ", certNo="
				+ certNo + ", mobile=" + mobile + ", email=" + email + ", job="
				+ job + ", address=" + address + ", age=" + age + ", sex="
				+ sex + ", nameAuthFlag=" + nameAuthFlag + ", pwd=" + pwd
				+ ", encryptionCode=" + encryptionCode + ", memberSrc="
				+ memberSrc + ", openIdGzhWx=" + openIdGzhWx + ", openIdXcxWx="
				+ openIdXcxWx + ", noWx=" + noWx + ", nickNameWx=" + nickNameWx
				+ ", cityWx=" + cityWx + ", countryWx=" + countryWx
				+ ", provinceWx=" + provinceWx + ", headAddress=" + headAddress
				+ ", subsribeTime=" + subsribeTime + ", cityAreaCode="
				+ cityAreaCode + ", createId=" + createId + ", createDate="
				+ createDate + ", updateId=" + updateId + ", updateDate="
				+ updateDate + ", memberNoGm=" + memberNoGm + ", memberNameGm="
				+ memberNameGm + ", shopNo=" + shopNo + ", shopName="
				+ shopName + ", merchantNo=" + merchantNo + ", merchantName="
				+ merchantName + ", nickNameRemarkLocal=" + nickNameRemarkLocal
				+ ", pmTypeCode=" + pmTypeCode + ", pmTypeName=" + pmTypeName
				+ ", spruceUp=" + spruceUp + ", houses=" + houses
				+ ", ratioClientInfo=" + ratioClientInfo + ", birthday="
				+ birthday + "]";
	}
	
    
}
