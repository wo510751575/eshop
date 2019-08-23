package com.lj.business.member.dto;

import java.util.Date;

import com.lj.base.core.pagination.PageParamEntity; 

/**
 * The Class FindGuidMemberPage.
 */
public class FindGuidMemberPage extends PageParamEntity {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1987333207196298365L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 会员号  .
     */
    private String memberNo;

    /**
     * 导购姓名 .
     */
    private String memberName;

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
     * 状态 
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
     * 区域CODE .
     */
    private String areaCode;
    
    /**
     * 区域NAME .
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
     * 住址 .
     */
    private String address;

    /**
     * 年龄 .
     */
    private Integer age;

    /**
     * 性别:male,female .
     */
    private String gender;

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
    
    /** 微信号. */
    private String noWx;
    
    /** 开始时间. */
	private Date startTime;			
	
	/** 结束时间. */
	private Date endTime;
	/**
	 * 年龄起始
	 */
	private Integer ageFrom;
	/**
	 * 年龄起止
	 */
	private Integer ageTo;
	

    /**
	 * @return the ageFrom
	 */
	public Integer getAgeFrom() {
		return ageFrom;
	}

	/**
	 * @param ageFrom the ageFrom to set
	 */
	public void setAgeFrom(Integer ageFrom) {
		this.ageFrom = ageFrom;
	}

	/**
	 * @return the ageTo
	 */
	public Integer getAgeTo() {
		return ageTo;
	}

	/**
	 * @param ageTo the ageTo to set
	 */
	public void setAgeTo(Integer ageTo) {
		this.ageTo = ageTo;
	}

	/**
     * Gets the 开始时间.
     *
     * @return the startTime
     */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * Sets the 开始时间.
	 *
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * Gets the 结束时间.
	 *
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * Sets the 结束时间.
	 *
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
     * 会员号  .
     *
     * @return the 会员号  
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * 会员号  .
     *
     * @param memberNo the new 会员号  
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     * 导购姓名 .
     *
     * @return the 导购姓名 
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 导购姓名 .
     *
     * @param memberName the new 导购姓名 
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
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
     * 状态
     * INIT初始(未审核) 、
     * UNPASS(审核未通过)、
     * NORMAL正常、
     * CANCEL注销。
     * FREEZE冻结
     * .
     *
     * @return the 状态 INIT初始(未审核) 、 UNPASS(审核未通过)、 NORMAL正常、 CANCEL注销。 FREEZE冻结 
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态
     * INIT初始(未审核) 、
     * UNPASS(审核未通过)、
     * NORMAL正常、
     * CANCEL注销。
     * FREEZE冻结
     * .
     *
     * @param status the new 状态 INIT初始(未审核) 、 UNPASS(审核未通过)、 NORMAL正常、 CANCEL注销。 FREEZE冻结 
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
     * 区域CODE .
     *
     * @return the 区域CODE 
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 区域CODE .
     *
     * @param areaCode the new 区域CODE 
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
     * 省CODE .
     *
     * @return the 省CODE 
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * 省CODE .
     *
     * @param provinceCode the new 省CODE 
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * 市CODE .
     *
     * @return the 市CODE 
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 市CODE .
     *
     * @param cityCode the new 市CODE 
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
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
     * 性别:male,female .
     *
     * @return the 性别:male,female 
     */
    public String getGender() {
        return gender;
    }

    /**
     * 性别:male,female .
     *
     * @param gender the new 性别:male,female 
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
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

    @Override
	public String toString() {
		return "FindGuidMemberPage [code=" + code + ", memberNo=" + memberNo
				+ ", memberName=" + memberName + ", shopNo=" + shopNo
				+ ", shopName=" + shopName + ", merchantNo=" + merchantNo
				+ ", merchantName=" + merchantName + ", status=" + status
				+ ", jobNum=" + jobNum + ", mobile=" + mobile + ", imei="
				+ imei + ", email=" + email + ", nickName=" + nickName
				+ ", areaCode=" + areaCode + ", areaName=" + areaName
				+ ", provinceCode=" + provinceCode + ", cityCode=" + cityCode
				+ ", address=" + address + ", age=" + age + ", gender="
				+ gender + ", pwd=" + pwd + ", encryptionCode="
				+ encryptionCode + ", headAddress=" + headAddress
				+ ", workDate=" + workDate + ", createId=" + createId
				+ ", createDate=" + createDate + ", updateId=" + updateId
				+ ", updateDate=" + updateDate + ", noWx=" + noWx
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", ageFrom=" + ageFrom + ", ageTo=" + ageTo + "]";
	}
}
