package com.lj.business.cf.dto.clientExp;

import java.io.Serializable;

import com.lj.base.core.pagination.PageParamEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientExpDto.
 */
public class ClientExpDto extends PageParamEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1047693970264459193L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String merchantNo;

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
     * 门店编号 .
     */
    private String shopNo;

    /**
     * 门店名称 .
     */
    private String shopName;

    /**
     * 体验时间 .
     */
    private String expTime;

    /**
     * 体验反馈 .
     */
    private String expFb;

    /**
     * 看中款项图片列表以,分隔 .
     */
    private String imgs;

    /**
     * 语音资源文件存放路径列表以,分隔 .
     */
    private String resourcesUrl;

    /**
     * 是否到店
             是：Y
             否：N
              .
     */
    private String expResult;

    /**
     * 未到店原因 .
     */
    private String failReason;

    /**
     * 跟踪编号 .
     */
    private String cfNo;

    /**
     * 跟踪明细CODE .
     */
    private String cfCode;

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
     *  .
     */
    private String remark1;
    
    /**
     * 客户沟通任务Code .
     */
    private String comTaskCode;
    
    /**
     * 是否累计任务，默认false .
     */
    private Boolean dis = false;
    
    /** 手机号码. */
    private String mobile;
    
    /** 性别. */
    private String sex;
    
    /** 微信名称. */
    private String nickNameWx;
    
    /** 城市微信. */
    private String cityWx;
    
    /** 国家微信. */
    private String countryWx;
    
    /** 省微信. */
    private String provinceWx;
    
    /** 头像地址. */
    private String headAddress;
    
    /** 客户类型id. */
    private String pmTypeType;
    
    /**
     * Gets the 手机号码.
     *
     * @return the mobile
     */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Sets the 手机号码.
	 *
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * Gets the 性别.
	 *
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * Sets the 性别.
	 *
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * Gets the 微信名称.
	 *
	 * @return the nickNameWx
	 */
	public String getNickNameWx() {
		return nickNameWx;
	}

	/**
	 * Sets the 微信名称.
	 *
	 * @param nickNameWx the nickNameWx to set
	 */
	public void setNickNameWx(String nickNameWx) {
		this.nickNameWx = nickNameWx;
	}

	/**
	 * Gets the 城市微信.
	 *
	 * @return the cityWx
	 */
	public String getCityWx() {
		return cityWx;
	}

	/**
	 * Sets the 城市微信.
	 *
	 * @param cityWx the cityWx to set
	 */
	public void setCityWx(String cityWx) {
		this.cityWx = cityWx;
	}

	/**
	 * Gets the 国家微信.
	 *
	 * @return the countryWx
	 */
	public String getCountryWx() {
		return countryWx;
	}

	/**
	 * Sets the 国家微信.
	 *
	 * @param countryWx the countryWx to set
	 */
	public void setCountryWx(String countryWx) {
		this.countryWx = countryWx;
	}

	/**
	 * Gets the 省微信.
	 *
	 * @return the provinceWx
	 */
	public String getProvinceWx() {
		return provinceWx;
	}

	/**
	 * Sets the 省微信.
	 *
	 * @param provinceWx the provinceWx to set
	 */
	public void setProvinceWx(String provinceWx) {
		this.provinceWx = provinceWx;
	}

	/**
	 * Gets the 头像地址.
	 *
	 * @return the headAddress
	 */
	public String getHeadAddress() {
		return headAddress;
	}

	/**
	 * Sets the 头像地址.
	 *
	 * @param headAddress the headAddress to set
	 */
	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}

	/**
	 * Gets the 客户沟通任务Code .
	 *
	 * @return the comTaskCode
	 */
	public String getComTaskCode() {
		return comTaskCode;
	}

	/**
	 * Sets the 客户沟通任务Code .
	 *
	 * @param comTaskCode the comTaskCode to set
	 */
	public void setComTaskCode(String comTaskCode) {
		this.comTaskCode = comTaskCode;
	}

	/**
	 * Gets the 是否累计任务，默认false .
	 *
	 * @return the dis
	 */
	public Boolean getDis() {
		return dis;
	}

	/**
	 * Sets the 是否累计任务，默认false .
	 *
	 * @param dis the dis to set
	 */
	public void setDis(Boolean dis) {
		this.dis = dis;
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
     * 门店编号 .
     *
     * @return the 门店编号 
     */
    public String getShopNo() {
        return shopNo;
    }

    /**
     * 门店编号 .
     *
     * @param shopNo the new 门店编号 
     */
    public void setShopNo(String shopNo) {
        this.shopNo = shopNo == null ? null : shopNo.trim();
    }

    /**
     * 门店名称 .
     *
     * @return the 门店名称 
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 门店名称 .
     *
     * @param shopName the new 门店名称 
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 体验时间 .
     *
     * @return the 体验时间 
     */
    public String getExpTime() {
        return expTime;
    }

    /**
     * 体验时间 .
     *
     * @param expTime the new 体验时间 
     */
    public void setExpTime(String expTime) {
        this.expTime = expTime;
    }

    /**
     * 体验反馈 .
     *
     * @return the 体验反馈 
     */
    public String getExpFb() {
        return expFb;
    }

    /**
     * 体验反馈 .
     *
     * @param expFb the new 体验反馈 
     */
    public void setExpFb(String expFb) {
        this.expFb = expFb == null ? null : expFb.trim();
    }

    /**
     * 看中款项图片列表以,分隔 .
     *
     * @return the 看中款项图片列表以,分隔 
     */
    public String getImgs() {
        return imgs;
    }

    /**
     * 看中款项图片列表以,分隔 .
     *
     * @param imgs the new 看中款项图片列表以,分隔 
     */
    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

    /**
     * 语音资源文件存放路径列表以,分隔 .
     *
     * @return the 语音资源文件存放路径列表以,分隔 
     */
    public String getResourcesUrl() {
        return resourcesUrl;
    }

    /**
     * 语音资源文件存放路径列表以,分隔 .
     *
     * @param resourcesUrl the new 语音资源文件存放路径列表以,分隔 
     */
    public void setResourcesUrl(String resourcesUrl) {
        this.resourcesUrl = resourcesUrl == null ? null : resourcesUrl.trim();
    }

    /**
     * 是否到店
     * 是：Y
     * 否：N
     * .
     *
     * @return the 是否到店 是：Y 否：N 
     */
    public String getExpResult() {
        return expResult;
    }

    /**
     * 是否到店
     * 是：Y
     * 否：N
     * .
     *
     * @param expResult the new 是否到店 是：Y 否：N 
     */
    public void setExpResult(String expResult) {
        this.expResult = expResult == null ? null : expResult.trim();
    }

    /**
     * 未到店原因 .
     *
     * @return the 未到店原因 
     */
    public String getFailReason() {
        return failReason;
    }

    /**
     * 未到店原因 .
     *
     * @param failReason the new 未到店原因 
     */
    public void setFailReason(String failReason) {
        this.failReason = failReason == null ? null : failReason.trim();
    }

    /**
     * 跟踪编号 .
     *
     * @return the 跟踪编号 
     */
    public String getCfNo() {
        return cfNo;
    }

    /**
     * 跟踪编号 .
     *
     * @param cfNo the new 跟踪编号 
     */
    public void setCfNo(String cfNo) {
        this.cfNo = cfNo == null ? null : cfNo.trim();
    }

    /**
     * 跟踪明细CODE .
     *
     * @return the 跟踪明细CODE 
     */
    public String getCfCode() {
        return cfCode;
    }

    /**
     * 跟踪明细CODE .
     *
     * @param cfCode the new 跟踪明细CODE 
     */
    public void setCfCode(String cfCode) {
        this.cfCode = cfCode == null ? null : cfCode.trim();
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
     * .
     *
     * @return the remark1
     */
    public String getRemark1() {
        return remark1;
    }

    /**
     * .
     *
     * @param remark1 the remark1
     */
    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClientExpDto [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", memberNo=").append(memberNo).append(", memberName=")
				.append(memberName).append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", shopNo=").append(shopNo).append(", shopName=")
				.append(shopName).append(", expTime=").append(expTime)
				.append(", expFb=").append(expFb).append(", imgs=")
				.append(imgs).append(", resourcesUrl=").append(resourcesUrl)
				.append(", expResult=").append(expResult)
				.append(", failReason=").append(failReason).append(", cfNo=")
				.append(cfNo).append(", cfCode=").append(cfCode)
				.append(", remark4=").append(remark4).append(", remark3=")
				.append(remark3).append(", remark2=").append(remark2)
				.append(", remark1=").append(remark1).append(", comTaskCode=")
				.append(comTaskCode).append(", dis=").append(dis)
				.append(", mobile=").append(mobile).append(", sex=")
				.append(sex).append(", nickNameWx=").append(nickNameWx)
				.append(", cityWx=").append(cityWx).append(", countryWx=")
				.append(countryWx).append(", provinceWx=").append(provinceWx)
				.append(", headAddress=").append(headAddress)
				.append(", pmTypeType=").append(pmTypeType).append("]");
		return builder.toString();
	}

	/**
	 * Gets the 客户类型id.
	 *
	 * @return the 客户类型id
	 */
	public String getPmTypeType() {
		return pmTypeType;
	}

	/**
	 * Sets the 客户类型id.
	 *
	 * @param pmTypeType the new 客户类型id
	 */
	public void setPmTypeType(String pmTypeType) {
		this.pmTypeType = pmTypeType;
	}
}