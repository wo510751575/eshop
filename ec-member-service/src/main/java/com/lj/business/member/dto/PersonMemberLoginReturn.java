package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 类说明：
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author LeoPeng
 * 
 * 
 *         CreateDate: 2017-6-4
 */
public class PersonMemberLoginReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5433655528265823736L;
	
	/**
     * CODE .
     */
    private String code;

    /**
     * 导购编号  .
     */
    private String memberNoGuid;

    /**
     * 导购姓名 .
     */
    private String memberNameGuid;

    /**
     * 店长编号 .
     */
    private String memberNoShop;

    /**
     * 店长名称 .
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
     *  .
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
    
    /** 会员类型. */
    private String memberType;
    
    /** 分店编号/名称. */
    private String shopNo;
    
    /** The shop name. */
    private String shopName;
    
    /** 上传前缀路径. */
    private String uploadUrl;
    
    /** 微信号. */
    private String noWx;
    
    
    /** * 微信更新地址. */
	private String wxUpdateUrl;
	
    /**
     * Gets the 上传前缀路径.
     *
     * @return the uploadUrl
     */
	public String getUploadUrl() {
		return uploadUrl;
	}

	/**
	 * Sets the 上传前缀路径.
	 *
	 * @param uploadUrl the uploadUrl to set
	 */
	public void setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
	}

	/**
     * Gets the 分店编号/名称.
     *
     * @return the shopNo
     */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * Sets the 分店编号/名称.
	 *
	 * @param shopNo the shopNo to set
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/**
	 * Gets the shop name.
	 *
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * Sets the shop name.
	 *
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * Gets the 导购编号  .
	 *
	 * @return the memberNoGuid
	 */
	public String getMemberNoGuid() {
		return memberNoGuid;
	}

	/**
	 * Sets the 导购编号  .
	 *
	 * @param memberNoGuid the memberNoGuid to set
	 */
	public void setMemberNoGuid(String memberNoGuid) {
		this.memberNoGuid = memberNoGuid;
	}

	/**
	 * Gets the 导购姓名 .
	 *
	 * @return the memberNameGuid
	 */
	public String getMemberNameGuid() {
		return memberNameGuid;
	}

	/**
	 * Sets the 导购姓名 .
	 *
	 * @param memberNameGuid the memberNameGuid to set
	 */
	public void setMemberNameGuid(String memberNameGuid) {
		this.memberNameGuid = memberNameGuid;
	}

	/**
	 * Gets the 店长编号 .
	 *
	 * @return the memberNoShop
	 */
	public String getMemberNoShop() {
		return memberNoShop;
	}

	/**
	 * Sets the 店长编号 .
	 *
	 * @param memberNoShop the memberNoShop to set
	 */
	public void setMemberNoShop(String memberNoShop) {
		this.memberNoShop = memberNoShop;
	}

	/**
	 * Gets the 店长名称 .
	 *
	 * @return the memberNameShop
	 */
	public String getMemberNameShop() {
		return memberNameShop;
	}

	/**
	 * Sets the 店长名称 .
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
	 * Gets the 会员类型.
	 *
	 * @return the memberType
	 */
	public String getMemberType() {
		return memberType;
	}

	/**
	 * Sets the 会员类型.
	 *
	 * @param memberType the memberType to set
	 */
	public void setMemberType(String memberType) {
		this.memberType = memberType;
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
     * Gets the 微信号.
     *
     * @return the 微信号
     */
    public String getNoWx() {
		return noWx;
	}

	/**
	 * Sets the 微信号.
	 *
	 * @param noWx the new 微信号
	 */
	public void setNoWx(String noWx) {
		this.noWx = noWx;
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
     * Gets the qcord.
     *
     * @return the qcord
     */
    public String getQcord() {
		return qcord;
	}

	/**
	 * Sets the qcord.
	 *
	 * @param qcord the qcord
	 */
	public void setQcord(String qcord) {
		this.qcord = qcord;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonMemberLoginReturn [code=").append(code)
				.append(", memberNoGuid=").append(memberNoGuid)
				.append(", memberNameGuid=").append(memberNameGuid)
				.append(", memberNoShop=").append(memberNoShop)
				.append(", memberNameShop=").append(memberNameShop)
				.append(", memberNoMerchant=").append(memberNoMerchant)
				.append(", memberNameMerchant=").append(memberNameMerchant)
				.append(", status=").append(status).append(", jobNum=")
				.append(jobNum).append(", mobile=").append(mobile)
				.append(", imei=").append(imei).append(", email=")
				.append(email).append(", nickName=").append(nickName)
				.append(", areaCode=").append(areaCode)
				.append(", provinceCode=").append(provinceCode)
				.append(", cityCode=").append(cityCode).append(", address=")
				.append(address).append(", age=").append(age)
				.append(", gender=").append(gender).append(", pwd=")
				.append(pwd).append(", encryptionCode=").append(encryptionCode)
				.append(", headAddress=").append(headAddress)
				.append(", workDate=").append(workDate).append(", qcord=")
				.append(qcord).append(", createId=").append(createId)
				.append(", createDate=").append(createDate)
				.append(", updateId=").append(updateId).append(", updateDate=")
				.append(updateDate).append(", memberType=").append(memberType)
				.append(", shopNo=").append(shopNo).append(", shopName=")
				.append(shopName).append(", uploadUrl=").append(uploadUrl)
				.append(", noWx=").append(noWx).append(", wxUpdateUrl=")
				.append(wxUpdateUrl).append("]");
		return builder.toString();
	}

	/**
	 * Gets the * 微信更新地址.
	 *
	 * @return the * 微信更新地址
	 */
	public String getWxUpdateUrl() {
		return wxUpdateUrl;
	}

	/**
	 * Sets the * 微信更新地址.
	 *
	 * @param wxUpdateUrl the new * 微信更新地址
	 */
	public void setWxUpdateUrl(String wxUpdateUrl) {
		this.wxUpdateUrl = wxUpdateUrl;
	}

}
