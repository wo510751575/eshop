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
public class FindPersonMemberBaseReturnList implements Serializable{

	 /** Generate cron. */
	private static final long serialVersionUID = 4672538697797450010L;
	
	/** CODE. */
    private String code;
	
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
  
    /** 客户数量. */ 
    private Integer memberNo;
    
    /** 区域名称. */
    private  String areaName;
    
    
    
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the member no.
	 *
	 * @return the member no
	 */
	public Integer getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the member no.
	 *
	 * @param memberNo the member no
	 */
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FindPersonMemberBaseReturnList [mobile=" + mobile + ", sex="
				+ sex + ", nickNameWx=" + nickNameWx + ", cityWx=" + cityWx
				+ ", countryWx=" + countryWx + ", provinceWx=" + provinceWx
				+ ", headAddress=" + headAddress + ", memberNo=" + memberNo
				+ ", areaName=" + areaName + "]";
	}

    
}
