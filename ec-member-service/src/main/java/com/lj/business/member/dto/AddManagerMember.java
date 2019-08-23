package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

import com.lj.business.member.emus.MemberType;

// TODO: Auto-generated Javadoc
/**
 * The Class AddManagerMember.
 */
public class AddManagerMember implements Serializable { 

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1988390221850354749L;

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
    
    /** 区域code. */
    private String areaCode;
    
    /**
     * 区域名称 .
     */
    private String areaName;
    
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
    
    /** 微信号. */
    private String noWx;
    /**
     * 加密机CODE .
     */
    private String encryptionCode;

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
	 * Gets the no wx.
	 *
	 * @return the no wx
	 */
	public String getNoWx() {
		return noWx;
	}

	/**
	 * Sets the no wx.
	 *
	 * @param noWx the no wx
	 */
	public void setNoWx(String noWx) {
		this.noWx = noWx;
	}

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
     * 店长编号 .
     *
     * @return the 店长编号 
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * 店长编号 .
     *
     * @param memberNo the new 店长编号 
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     * 会员姓名 .
     *
     * @return the 会员姓名 
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 会员姓名 .
     *
     * @param memberName the new 会员姓名 
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 分店编号 .
     *
     * @return the 分店编号 
     */
    public String getMemberNoShop() {
        return memberNoShop;
    }

    /**
     * 分店编号 .
     *
     * @param memberNoShop the new 分店编号 
     */
    public void setMemberNoShop(String memberNoShop) {
        this.memberNoShop = memberNoShop == null ? null : memberNoShop.trim();
    }

    /**
     * 分店名称 .
     *
     * @return the 分店名称 
     */
    public String getMemberNameShop() {
        return memberNameShop;
    }

    /**
     * 分店名称 .
     *
     * @param memberNameShop the new 分店名称 
     */
    public void setMemberNameShop(String memberNameShop) {
        this.memberNameShop = memberNameShop == null ? null : memberNameShop.trim();
    }

    /**
     * 商户编号 .
     *
     * @return the 商户编号 
     */
    public String getMemberNoMerchant() {
        return memberNoMerchant;
    }

    /**
     * 商户编号 .
     *
     * @param memberNoMerchant the new 商户编号 
     */
    public void setMemberNoMerchant(String memberNoMerchant) {
        this.memberNoMerchant = memberNoMerchant == null ? null : memberNoMerchant.trim();
    }

    /**
     * 商户名称 .
     *
     * @return the 商户名称 
     */
    public String getMemberNameMerchant() {
        return memberNameMerchant;
    }

    /**
     * 商户名称 .
     *
     * @param memberNameMerchant the new 商户名称 
     */
    public void setMemberNameMerchant(String memberNameMerchant) {
        this.memberNameMerchant = memberNameMerchant == null ? null : memberNameMerchant.trim();
    }

    /**
     * 会员状态
     * INIT初始(未审核) 、
     * UNPASS(审核未通过)、
     * NORMAL正常、
     * CANCEL注销。
     * FREEZE冻结
     * .
     *
     * @return the 会员状态 INIT初始(未审核) 、 UNPASS(审核未通过)、 NORMAL正常、 CANCEL注销。 FREEZE冻结 
     */
    public String getStatus() {
        return status;
    }

    /**
     * 会员状态
     * INIT初始(未审核) 、
     * UNPASS(审核未通过)、
     * NORMAL正常、
     * CANCEL注销。
     * FREEZE冻结
     * .
     *
     * @param status the new 会员状态 INIT初始(未审核) 、 UNPASS(审核未通过)、 NORMAL正常、 CANCEL注销。 FREEZE冻结 
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 工号 .
     *
     * @return the 工号 
     */
    public String getJobNum() {
        return jobNum;
    }

    /**
     * 工号 .
     *
     * @param jobNum the new 工号 
     */
    public void setJobNum(String jobNum) {
        this.jobNum = jobNum == null ? null : jobNum.trim();
    }

    /**
     * 联系电话 .
     *
     * @return the 联系电话 
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 联系电话 .
     *
     * @param telephone the new 联系电话 
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 手机号 .
     *
     * @return the 手机号 
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号 .
     *
     * @param mobile the new 手机号 
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 手机串号 .
     *
     * @return the 手机串号 
     */
    public String getImei() {
        return imei;
    }

    /**
     * 手机串号 .
     *
     * @param imei the new 手机串号 
     */
    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    /**
     * 邮箱 .
     *
     * @return the 邮箱 
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱 .
     *
     * @param email the new 邮箱 
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 昵称 .
     *
     * @return the 昵称 
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 昵称 .
     *
     * @param nickName the new 昵称 
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 住址 .
     *
     * @return the 住址 
     */
    public String getAddress() {
        return address;
    }

    /**
     * 住址 .
     *
     * @param address the new 住址 
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 年龄 .
     *
     * @return the 年龄 
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 年龄 .
     *
     * @param age the new 年龄 
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 登录密码 .
     *
     * @return the 登录密码 
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 登录密码 .
     *
     * @param pwd the new 登录密码 
     */
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    /**
     * 加密机CODE .
     *
     * @return the 加密机CODE 
     */
    public String getEncryptionCode() {
        return encryptionCode;
    }

    /**
     * 加密机CODE .
     *
     * @param encryptionCode the new 加密机CODE 
     */
    public void setEncryptionCode(String encryptionCode) {
        this.encryptionCode = encryptionCode == null ? null : encryptionCode.trim();
    }

    /**
     * 头像地址 .
     *
     * @return the 头像地址 
     */
    public String getHeadAddress() {
        return headAddress;
    }

    /**
     * 头像地址 .
     *
     * @param headAddress the new 头像地址 
     */
    public void setHeadAddress(String headAddress) {
        this.headAddress = headAddress == null ? null : headAddress.trim();
    }

    /**
     * 微信公众号OPENID .
     *
     * @return the 微信公众号OPENID 
     */
    public String getOpenIdGzhWx() {
        return openIdGzhWx;
    }

    /**
     * 微信公众号OPENID .
     *
     * @param openIdGzhWx the new 微信公众号OPENID 
     */
    public void setOpenIdGzhWx(String openIdGzhWx) {
        this.openIdGzhWx = openIdGzhWx == null ? null : openIdGzhWx.trim();
    }

    /**
     * 微信小程序OPENID .
     *
     * @return the 微信小程序OPENID 
     */
    public String getOpenIdXcxWx() {
        return openIdXcxWx;
    }

    /**
     * 微信小程序OPENID .
     *
     * @param openIdXcxWx the new 微信小程序OPENID 
     */
    public void setOpenIdXcxWx(String openIdXcxWx) {
        this.openIdXcxWx = openIdXcxWx == null ? null : openIdXcxWx.trim();
    }

    /**
     * 昵称_微信 .
     *
     * @return the 昵称_微信 
     */
    public String getNickNameWx() {
        return nickNameWx;
    }

    /**
     * 昵称_微信 .
     *
     * @param nickNameWx the new 昵称_微信 
     */
    public void setNickNameWx(String nickNameWx) {
        this.nickNameWx = nickNameWx == null ? null : nickNameWx.trim();
    }

    /**
     * 性别 .
     *
     * @return the 性别 
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别 .
     *
     * @param sex the new 性别 
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 城市_微信 .
     *
     * @return the 城市_微信 
     */
    public String getCityWx() {
        return cityWx;
    }

    /**
     * 城市_微信 .
     *
     * @param cityWx the new 城市_微信 
     */
    public void setCityWx(String cityWx) {
        this.cityWx = cityWx == null ? null : cityWx.trim();
    }

    /**
     * 国家 .
     *
     * @return the 国家 
     */
    public String getCountryWx() {
        return countryWx;
    }

    /**
     * 国家 .
     *
     * @param countryWx the new 国家 
     */
    public void setCountryWx(String countryWx) {
        this.countryWx = countryWx == null ? null : countryWx.trim();
    }

    /**
     * 省_微信 .
     *
     * @return the 省_微信 
     */
    public String getProvinceWx() {
        return provinceWx;
    }

    /**
     * 省_微信 .
     *
     * @param provinceWx the new 省_微信 
     */
    public void setProvinceWx(String provinceWx) {
        this.provinceWx = provinceWx == null ? null : provinceWx.trim();
    }

    /**
     * 关注时间 .
     *
     * @return the 关注时间 
     */
    public Date getSubsribeTime() {
        return subsribeTime;
    }

    /**
     * 关注时间 .
     *
     * @param subsribeTime the new 关注时间 
     */
    public void setSubsribeTime(Date subsribeTime) {
        this.subsribeTime = subsribeTime;
    }

    /**
     * 入职时间 .
     *
     * @return the 入职时间 
     */
    public Date getWorkDate() {
        return workDate;
    }

    /**
     * 入职时间 .
     *
     * @param workDate the new 入职时间 
     */
    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
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
		builder.append("AddManagerMember [code=").append(code)
				.append(", memberType=").append(memberType)
				.append(", memberNo=").append(memberNo).append(", memberName=")
				.append(memberName).append(", memberNoShop=")
				.append(memberNoShop).append(", memberNameShop=")
				.append(memberNameShop).append(", memberNoMerchant=")
				.append(memberNoMerchant).append(", memberNameMerchant=")
				.append(memberNameMerchant).append(", status=").append(status)
				.append(", areaCode=").append(areaCode).append(", areaName=")
				.append(areaName).append(", jobNum=").append(jobNum)
				.append(", telephone=").append(telephone).append(", mobile=")
				.append(mobile).append(", imei=").append(imei)
				.append(", email=").append(email).append(", nickName=")
				.append(nickName).append(", address=").append(address)
				.append(", age=").append(age).append(", pwd=").append(pwd)
				.append(", noWx=").append(noWx).append(", encryptionCode=")
				.append(encryptionCode).append(", headAddress=")
				.append(headAddress).append(", openIdGzhWx=")
				.append(openIdGzhWx).append(", openIdXcxWx=")
				.append(openIdXcxWx).append(", nickNameWx=").append(nickNameWx)
				.append(", sex=").append(sex).append(", cityWx=")
				.append(cityWx).append(", countryWx=").append(countryWx)
				.append(", provinceWx=").append(provinceWx)
				.append(", subsribeTime=").append(subsribeTime)
				.append(", workDate=").append(workDate).append(", createId=")
				.append(createId).append(", createDate=").append(createDate)
				.append(", updateId=").append(updateId).append(", updateDate=")
				.append(updateDate).append(", remark4=").append(remark4)
				.append(", remark3=").append(remark3).append(", remark2=")
				.append(remark2).append(", remark=").append(remark).append("]");
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
