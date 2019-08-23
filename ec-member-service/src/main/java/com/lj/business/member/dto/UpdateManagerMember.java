package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

import com.lj.business.member.emus.MemberType;

/**
 * The Class UpdateManagerMember.
 */
public class UpdateManagerMember implements Serializable { 

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7386878043827099625L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 会员类型
             店长：SHOP
             老板：BOSS .
     */
    private MemberType memberType;

    /**
     * 店长编号 .
     */
    private String memberNo;

    /**
     * 会员姓名 .
     */
    private String memberName;

    /**
     * 分店编号 .
     */
    private String memberNoShop;

    /**
     * 分店名称 .
     */
    private String memberNameShop;

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
              INIT初始(未审核) 、
             UNPASS(审核未通过)、
             NORMAL正常、
             CANCEL注销。
             FREEZE冻结
              .
     */
    private String status;

    /**
     * 工号 .
     */
    private String jobNum;

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
     * 昵称 .
     */
    private String nickName;

    /**
     * 住址 .
     */
    private String address;

    /**
     * 年龄 .
     */
    private Integer age;

    /**
     * 登录密码 .
     */
    private String pwd;

    /**
     * 加密机CODE .
     */
    private String encryptionCode;

    /**
     * 头像地址 .
     */
    private String headAddress;

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
     * 性别 .
     */
    private String sex;

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
     * 关注时间 .
     */
    private Date subsribeTime;

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
     * 区域CODE .
     */
    private String areaCode;
    
    /**
     * 区域名称 .
     */
    private String areaName;
    

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
	 * Gets the 会员类型 店长：SHOP 老板：BOSS .
	 *
	 * @return the 会员类型 店长：SHOP 老板：BOSS 
	 */
	public MemberType getMemberType() {
		return memberType;
	}

	/**
	 * Sets the 会员类型 店长：SHOP 老板：BOSS .
	 *
	 * @param memberType the new 会员类型 店长：SHOP 老板：BOSS 
	 */
	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}

	/**
	 * Gets the 店长编号 .
	 *
	 * @return the memberNo
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 店长编号 .
	 *
	 * @param memberNo the memberNo to set
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the 会员姓名 .
	 *
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * Sets the 会员姓名 .
	 *
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * Gets the 分店编号 .
	 *
	 * @return the memberNoShop
	 */
	public String getMemberNoShop() {
		return memberNoShop;
	}

	/**
	 * Sets the 分店编号 .
	 *
	 * @param memberNoShop the memberNoShop to set
	 */
	public void setMemberNoShop(String memberNoShop) {
		this.memberNoShop = memberNoShop;
	}

	/**
	 * Gets the 分店名称 .
	 *
	 * @return the memberNameShop
	 */
	public String getMemberNameShop() {
		return memberNameShop;
	}

	/**
	 * Sets the 分店名称 .
	 *
	 * @param memberNameShop the memberNameShop to set
	 */
	public void setMemberNameShop(String memberNameShop) {
		this.memberNameShop = memberNameShop;
	}

	/**
	 * Gets the 商户编号 .
	 *
	 * @return the memberNoMerchant
	 */
	public String getMemberNoMerchant() {
		return memberNoMerchant;
	}

	/**
	 * Sets the 商户编号 .
	 *
	 * @param memberNoMerchant the memberNoMerchant to set
	 */
	public void setMemberNoMerchant(String memberNoMerchant) {
		this.memberNoMerchant = memberNoMerchant;
	}

	/**
	 * Gets the 商户名称 .
	 *
	 * @return the memberNameMerchant
	 */
	public String getMemberNameMerchant() {
		return memberNameMerchant;
	}

	/**
	 * Sets the 商户名称 .
	 *
	 * @param memberNameMerchant the memberNameMerchant to set
	 */
	public void setMemberNameMerchant(String memberNameMerchant) {
		this.memberNameMerchant = memberNameMerchant;
	}

	/**
	 * Gets the 会员状态 INIT初始(未审核) 、 UNPASS(审核未通过)、 NORMAL正常、 CANCEL注销。 FREEZE冻结 .
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the 会员状态 INIT初始(未审核) 、 UNPASS(审核未通过)、 NORMAL正常、 CANCEL注销。 FREEZE冻结 .
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the 工号 .
	 *
	 * @return the jobNum
	 */
	public String getJobNum() {
		return jobNum;
	}

	/**
	 * Sets the 工号 .
	 *
	 * @param jobNum the jobNum to set
	 */
	public void setJobNum(String jobNum) {
		this.jobNum = jobNum;
	}

	/**
	 * Gets the 联系电话 .
	 *
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Sets the 联系电话 .
	 *
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	 * Gets the 昵称 .
	 *
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * Sets the 昵称 .
	 *
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	 * Gets the 性别 .
	 *
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * Sets the 性别 .
	 *
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateManagerMember [code=").append(code)
				.append(", memberType=").append(memberType)
				.append(", memberNo=").append(memberNo).append(", memberName=")
				.append(memberName).append(", memberNoShop=")
				.append(memberNoShop).append(", memberNameShop=")
				.append(memberNameShop).append(", memberNoMerchant=")
				.append(memberNoMerchant).append(", memberNameMerchant=")
				.append(memberNameMerchant).append(", status=").append(status)
				.append(", jobNum=").append(jobNum).append(", telephone=")
				.append(telephone).append(", mobile=").append(mobile)
				.append(", email=").append(email).append(", nickName=")
				.append(nickName).append(", address=").append(address)
				.append(", age=").append(age).append(", pwd=").append(pwd)
				.append(", encryptionCode=").append(encryptionCode)
				.append(", headAddress=").append(headAddress)
				.append(", openIdGzhWx=").append(openIdGzhWx)
				.append(", openIdXcxWx=").append(openIdXcxWx)
				.append(", nickNameWx=").append(nickNameWx).append(", sex=")
				.append(sex).append(", cityWx=").append(cityWx)
				.append(", countryWx=").append(countryWx)
				.append(", provinceWx=").append(provinceWx)
				.append(", subsribeTime=").append(subsribeTime)
				.append(", createId=").append(createId).append(", createDate=")
				.append(createDate).append(", updateId=").append(updateId)
				.append(", updateDate=").append(updateDate)
				.append(", remark4=").append(remark4).append(", remark3=")
				.append(remark3).append(", remark2=").append(remark2)
				.append(", remark=").append(remark).append(", areaCode=")
				.append(areaCode).append(", areaName=").append(areaName)
				.append("]");
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
