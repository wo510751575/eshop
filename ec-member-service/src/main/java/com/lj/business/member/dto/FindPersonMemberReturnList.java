package com.lj.business.member.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * 类说明：OMS专用返回
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @Company: 领居科技有限公司
 * @author 罗书明
 * 
 * CreateDate: 2017年7月22日
 */
public class FindPersonMemberReturnList implements Serializable{

	 /** Generate cron. */
	private static final long serialVersionUID = 4672538697797450010L;
	
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
    
    /** 区域CODE. */
    private String areaCode;
    
    /** 区域名称. */
    private String areaName;
    
    /** 分组类型. */
    private String pmTypeType;
    
    /** 客户数量. */
    private String memberNo;
    
    /** 分店编号. */
    private String shopNo;
    
    /** 分店名称. */
    private String shopName;
    
    /** 导购编号. */
    private String memberNoGm;
    
    /** 导购姓名. */
    private String memberNameGm;
    
    /** 分类客户数量. */
    private Integer count;
    
    /**商户编号*/
    private String merchantNo;
    
    /**分类类型code*/
    private String code;
    
    /**分类名称*/
    private String typeName;
    
    /**分类客户总数*/
    private String countSum;
    
    
    
	public String getCountSum() {
		return countSum;
	}

	public void setCountSum(String countSum) {
		this.countSum = countSum;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the shop no.
	 *
	 * @return the shop no
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * Sets the shop no.
	 *
	 * @param shopNo the shop no
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/**
	 * Gets the shop name.
	 *
	 * @return the shop name
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * Sets the shop name.
	 *
	 * @param shopName the shop name
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * Gets the member no gm.
	 *
	 * @return the member no gm
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the member no gm.
	 *
	 * @param memberNoGm the member no gm
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	/**
	 * Gets the member name gm.
	 *
	 * @return the member name gm
	 */
	public String getMemberNameGm() {
		return memberNameGm;
	}

	/**
	 * Sets the member name gm.
	 *
	 * @param memberNameGm the member name gm
	 */
	public void setMemberNameGm(String memberNameGm) {
		this.memberNameGm = memberNameGm;
	}

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * Sets the count.
	 *
	 * @param count the count
	 */
	public void setCount(Integer count) {
		this.count = count;
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
	 * @param areaCode the area code
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * Gets the area name.
	 *
	 * @return the area name
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * Sets the area name.
	 *
	 * @param areaName the area name
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * Gets the pm type type.
	 *
	 * @return the pm type type
	 */
	public String getPmTypeType() {
		return pmTypeType;
	}

	/**
	 * Sets the pm type type.
	 *
	 * @param pmTypeType the pm type type
	 */
	public void setPmTypeType(String pmTypeType) {
		this.pmTypeType = pmTypeType;
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
	 * @param memberNo the member no
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
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
	 * @param mobile the mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	 * @param sex the sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
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
	 * @param nickNameWx the nick name wx
	 */
	public void setNickNameWx(String nickNameWx) {
		this.nickNameWx = nickNameWx;
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
	 * @param cityWx the city wx
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
	 * @param countryWx the country wx
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
	 * @param provinceWx the province wx
	 */
	public void setProvinceWx(String provinceWx) {
		this.provinceWx = provinceWx;
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
	 * @param headAddress the head address
	 */
	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}
	
	@Override
	public String toString() {
		return "FindPersonMemberReturnList [mobile=" + mobile + ", sex=" + sex
				+ ", nickNameWx=" + nickNameWx + ", cityWx=" + cityWx
				+ ", countryWx=" + countryWx + ", provinceWx=" + provinceWx
				+ ", headAddress=" + headAddress + ", areaCode=" + areaCode
				+ ", areaName=" + areaName + ", pmTypeType=" + pmTypeType
				+ ", memberNo=" + memberNo + ", shopNo=" + shopNo
				+ ", shopName=" + shopName + ", memberNoGm=" + memberNoGm
				+ ", memberNameGm=" + memberNameGm + ", count=" + count
				+ ", merchantNo=" + merchantNo + ", code=" + code
				+ ", typeName=" + typeName + ", countSum=" + countSum + "]";
	}

    
}
