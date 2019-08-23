package com.lj.business.member.domain;

import java.util.Date;
// TODO: Auto-generated Javadoc

/**
 * 类说明：管理人员表
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 邹磊
 * 
 * CreateDate: 2017年7月12日
 * @Company: 领居科技有限公司
 */
public class ManagerMember {
    /**
     * CODE .
     */
    private String code;

    /**
     * 会员类型             店长：SHOP             老板：BOSS .
     */
    private String memberType;

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
     * 会员状态              NORMAL正常、             CANCEL注销。             FREEZE冻结              .
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
     * 手机串号 .
     */
    private String imei;

    /**
     * 邮箱 .
     */
    private String email;
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
     * 入职时间 .
     */
    private Date workDate;
    
    /**
     * 微信号 .
     */
    private String noWx;

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
     * 更新时间 .
     */
    private Date updateDate;

    /**
     * 备注 .
     */
    private String remark;
    
	/**
	 * Gets the 微信号 .
	 *
	 * @return the noWx
	 */
	public String getNoWx() {
		return noWx;
	}

	/**
	 * Sets the 微信号 .
	 *
	 * @param noWx the noWx to set
	 */
	public void setNoWx(String noWx) {
		this.noWx = noWx;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the member type.
	 *
	 * @return the member type
	 */
	public String getMemberType() {
		return memberType;
	}

	/**
	 * Sets the member type.
	 *
	 * @param memberType the new member type
	 */
	public void setMemberType(String memberType) {
		this.memberType = memberType;
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
	 * @param memberNo the new member no
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
	 * @param memberName the new member name
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * Gets the member no shop.
	 *
	 * @return the member no shop
	 */
	public String getMemberNoShop() {
		return memberNoShop;
	}

	/**
	 * Sets the member no shop.
	 *
	 * @param memberNoShop the new member no shop
	 */
	public void setMemberNoShop(String memberNoShop) {
		this.memberNoShop = memberNoShop;
	}

	/**
	 * Gets the member name shop.
	 *
	 * @return the member name shop
	 */
	public String getMemberNameShop() {
		return memberNameShop;
	}

	/**
	 * Sets the member name shop.
	 *
	 * @param memberNameShop the new member name shop
	 */
	public void setMemberNameShop(String memberNameShop) {
		this.memberNameShop = memberNameShop;
	}

	/**
	 * Gets the member no merchant.
	 *
	 * @return the member no merchant
	 */
	public String getMemberNoMerchant() {
		return memberNoMerchant;
	}

	/**
	 * Sets the member no merchant.
	 *
	 * @param memberNoMerchant the new member no merchant
	 */
	public void setMemberNoMerchant(String memberNoMerchant) {
		this.memberNoMerchant = memberNoMerchant;
	}

	/**
	 * Gets the member name merchant.
	 *
	 * @return the member name merchant
	 */
	public String getMemberNameMerchant() {
		return memberNameMerchant;
	}

	/**
	 * Sets the member name merchant.
	 *
	 * @param memberNameMerchant the new member name merchant
	 */
	public void setMemberNameMerchant(String memberNameMerchant) {
		this.memberNameMerchant = memberNameMerchant;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the job num.
	 *
	 * @return the job num
	 */
	public String getJobNum() {
		return jobNum;
	}

	/**
	 * Sets the job num.
	 *
	 * @param jobNum the new job num
	 */
	public void setJobNum(String jobNum) {
		this.jobNum = jobNum;
	}

	/**
	 * Gets the telephone.
	 *
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Sets the telephone.
	 *
	 * @param telephone the new telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Gets the mobile.
	 *
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Sets the mobile.
	 *
	 * @param mobile the new mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * Gets the imei.
	 *
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}

	/**
	 * Sets the imei.
	 *
	 * @param imei the new imei
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @param areaCode the new area code
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
	 * @param provinceCode the new province code
	 */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	/**
	 * Gets the city code.
	 *
	 * @return the city code
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * Sets the city code.
	 *
	 * @param cityCode the new city code
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	/**
	 * Gets the city area code.
	 *
	 * @return the city area code
	 */
	public String getCityAreaCode() {
		return cityAreaCode;
	}

	/**
	 * Sets the city area code.
	 *
	 * @param cityAreaCode the new city area code
	 */
	public void setCityAreaCode(String cityAreaCode) {
		this.cityAreaCode = cityAreaCode;
	}

	/**
	 * Gets the nick name.
	 *
	 * @return the nick name
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * Sets the nick name.
	 *
	 * @param nickName the new nick name
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * Gets the pwd.
	 *
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * Sets the pwd.
	 *
	 * @param pwd the new pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * Gets the encryption code.
	 *
	 * @return the encryption code
	 */
	public String getEncryptionCode() {
		return encryptionCode;
	}

	/**
	 * Sets the encryption code.
	 *
	 * @param encryptionCode the new encryption code
	 */
	public void setEncryptionCode(String encryptionCode) {
		this.encryptionCode = encryptionCode;
	}

	/**
	 * Gets the head address.
	 *
	 * @return the head address
	 */
	public String getHeadAddress() {
		return headAddress;
	}

	/**
	 * Sets the head address.
	 *
	 * @param headAddress the new head address
	 */
	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}

	/**
	 * Gets the open id gzh wx.
	 *
	 * @return the open id gzh wx
	 */
	public String getOpenIdGzhWx() {
		return openIdGzhWx;
	}

	/**
	 * Sets the open id gzh wx.
	 *
	 * @param openIdGzhWx the new open id gzh wx
	 */
	public void setOpenIdGzhWx(String openIdGzhWx) {
		this.openIdGzhWx = openIdGzhWx;
	}

	/**
	 * Gets the open id xcx wx.
	 *
	 * @return the open id xcx wx
	 */
	public String getOpenIdXcxWx() {
		return openIdXcxWx;
	}

	/**
	 * Sets the open id xcx wx.
	 *
	 * @param openIdXcxWx the new open id xcx wx
	 */
	public void setOpenIdXcxWx(String openIdXcxWx) {
		this.openIdXcxWx = openIdXcxWx;
	}

	/**
	 * Gets the nick name wx.
	 *
	 * @return the nick name wx
	 */
	public String getNickNameWx() {
		return nickNameWx;
	}

	/**
	 * Sets the nick name wx.
	 *
	 * @param nickNameWx the new nick name wx
	 */
	public void setNickNameWx(String nickNameWx) {
		this.nickNameWx = nickNameWx;
	}

	/**
	 * Gets the sex.
	 *
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * Sets the sex.
	 *
	 * @param sex the new sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * Gets the city wx.
	 *
	 * @return the city wx
	 */
	public String getCityWx() {
		return cityWx;
	}

	/**
	 * Sets the city wx.
	 *
	 * @param cityWx the new city wx
	 */
	public void setCityWx(String cityWx) {
		this.cityWx = cityWx;
	}

	/**
	 * Gets the country wx.
	 *
	 * @return the country wx
	 */
	public String getCountryWx() {
		return countryWx;
	}

	/**
	 * Sets the country wx.
	 *
	 * @param countryWx the new country wx
	 */
	public void setCountryWx(String countryWx) {
		this.countryWx = countryWx;
	}

	/**
	 * Gets the province wx.
	 *
	 * @return the province wx
	 */
	public String getProvinceWx() {
		return provinceWx;
	}

	/**
	 * Sets the province wx.
	 *
	 * @param provinceWx the new province wx
	 */
	public void setProvinceWx(String provinceWx) {
		this.provinceWx = provinceWx;
	}

	/**
	 * Gets the subsribe time.
	 *
	 * @return the subsribe time
	 */
	public Date getSubsribeTime() {
		return subsribeTime;
	}

	/**
	 * Sets the subsribe time.
	 *
	 * @param subsribeTime the new subsribe time
	 */
	public void setSubsribeTime(Date subsribeTime) {
		this.subsribeTime = subsribeTime;
	}

	/**
	 * Gets the work date.
	 *
	 * @return the work date
	 */
	public Date getWorkDate() {
		return workDate;
	}

	/**
	 * Sets the work date.
	 *
	 * @param workDate the new work date
	 */
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	/**
	 * Gets the creates the id.
	 *
	 * @return the creates the id
	 */
	public String getCreateId() {
		return createId;
	}

	/**
	 * Sets the creates the id.
	 *
	 * @param createId the new creates the id
	 */
	public void setCreateId(String createId) {
		this.createId = createId;
	}

	/**
	 * Gets the creates the date.
	 *
	 * @return the creates the date
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the creates the date.
	 *
	 * @param createDate the new creates the date
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * Gets the update id.
	 *
	 * @return the update id
	 */
	public String getUpdateId() {
		return updateId;
	}

	/**
	 * Sets the update id.
	 *
	 * @param updateId the new update id
	 */
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	/**
	 * Gets the remark 4.
	 *
	 * @return the remark 4
	 */
	public String getRemark4() {
		return remark4;
	}

	/**
	 * Sets the remark 4.
	 *
	 * @param remark4 the new remark 4
	 */
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	/**
	 * Gets the remark 3.
	 *
	 * @return the remark 3
	 */
	public String getRemark3() {
		return remark3;
	}

	/**
	 * Sets the remark 3.
	 *
	 * @param remark3 the new remark 3
	 */
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	/**
	 * Gets the remark 2.
	 *
	 * @return the remark 2
	 */
	public String getRemark2() {
		return remark2;
	}

	/**
	 * Sets the remark 2.
	 *
	 * @param remark2 the new remark 2
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	/**
	 * Gets the update date.
	 *
	 * @return the update date
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * Sets the update date.
	 *
	 * @param updateDate the new update date
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * Gets the remark.
	 *
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the remark.
	 *
	 * @param remark the new remark
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
		builder.append("ManagerMember [code=").append(code)
				.append(", memberType=").append(memberType)
				.append(", memberNo=").append(memberNo).append(", memberName=")
				.append(memberName).append(", memberNoShop=")
				.append(memberNoShop).append(", memberNameShop=")
				.append(memberNameShop).append(", memberNoMerchant=")
				.append(memberNoMerchant).append(", memberNameMerchant=")
				.append(memberNameMerchant).append(", status=").append(status)
				.append(", jobNum=").append(jobNum).append(", telephone=")
				.append(telephone).append(", mobile=").append(mobile)
				.append(", imei=").append(imei).append(", email=")
				.append(email).append(", areaCode=").append(areaCode)
				.append(", areaName=").append(areaName)
				.append(", provinceCode=").append(provinceCode)
				.append(", cityCode=").append(cityCode)
				.append(", cityAreaCode=").append(cityAreaCode)
				.append(", nickName=").append(nickName).append(", address=")
				.append(address).append(", age=").append(age).append(", pwd=")
				.append(pwd).append(", encryptionCode=").append(encryptionCode)
				.append(", headAddress=").append(headAddress)
				.append(", openIdGzhWx=").append(openIdGzhWx)
				.append(", openIdXcxWx=").append(openIdXcxWx)
				.append(", nickNameWx=").append(nickNameWx).append(", sex=")
				.append(sex).append(", cityWx=").append(cityWx)
				.append(", countryWx=").append(countryWx)
				.append(", provinceWx=").append(provinceWx)
				.append(", subsribeTime=").append(subsribeTime)
				.append(", workDate=").append(workDate).append(", noWx=")
				.append(noWx).append(", createId=").append(createId)
				.append(", createDate=").append(createDate)
				.append(", updateId=").append(updateId).append(", remark4=")
				.append(remark4).append(", remark3=").append(remark3)
				.append(", remark2=").append(remark2).append(", updateDate=")
				.append(updateDate).append(", remark=").append(remark)
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