package com.lj.business.cf.dto.clientExp;

import java.util.Date;

import com.lj.base.core.pagination.PageParamEntity;

// TODO: Auto-generated Javadoc
/**
 * 类说明：OMS专用查询返回
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
public class FindClientExpOmsPage extends PageParamEntity {

	 /** Generate cron. */
	private static final long serialVersionUID = -360344806198804921L;
	
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
     * 门店姓名 .
     */
    private String shopName;
    /**
     *  上传图片1.
     */
    private Integer img1;

    /**
     * 上传图片2 .
     */
    private String img2;

    /** 上传图片3. */
    private String img3;

    /** 上传图片4. */
    private String img4;
  
    /**
     *体验时间 .
     */
    private Date expTime;

    /** 体验反馈. */
    private String expFb;

    /**
     * 备注1 .
     */
    private String remark1;
    /**
     * 备注 .
     */
    private String remark2;
    /**
     * 备注 .
     */
    private String remark3;
    /**
     * 备注 .
     */
    private String remark4;
     
    /** 结束时间. */
    private String endTime;
    
    /** 开始时间. */
    private String startTime;
    
    /** 头像. */
    private String headAddress;
    
    /** 手机号. */
    private String mobile;
    
    /** 性别. */
    private String sex;
    
    /** 城市_微信. */
    private  String cityWx;
    
    /** 省_微信. */
    private String provinceWx;
	
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
	 * @param code the code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Gets the merchant no.
	 *
	 * @return the merchant no
	 */
	public String getMerchantNo() {
		return merchantNo;
	}
	
	/**
	 * Sets the merchant no.
	 *
	 * @param merchantNo the merchant no
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
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
	 * @param memberName the member name
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	 * Gets the img1.
	 *
	 * @return the img1
	 */
	public Integer getImg1() {
		return img1;
	}
	
	/**
	 * Sets the img1.
	 *
	 * @param img1 the img1
	 */
	public void setImg1(Integer img1) {
		this.img1 = img1;
	}
	
	/**
	 * Gets the img2.
	 *
	 * @return the img2
	 */
	public String getImg2() {
		return img2;
	}
	
	/**
	 * Sets the img2.
	 *
	 * @param img2 the img2
	 */
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	
	/**
	 * Gets the img3.
	 *
	 * @return the img3
	 */
	public String getImg3() {
		return img3;
	}
	
	/**
	 * Sets the img3.
	 *
	 * @param img3 the img3
	 */
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	
	/**
	 * Gets the img4.
	 *
	 * @return the img4
	 */
	public String getImg4() {
		return img4;
	}
	
	/**
	 * Sets the img4.
	 *
	 * @param img4 the img4
	 */
	public void setImg4(String img4) {
		this.img4 = img4;
	}
	
	/**
	 * Gets the exp time.
	 *
	 * @return the exp time
	 */
	public Date getExpTime() {
		return expTime;
	}
	
	/**
	 * Sets the exp time.
	 *
	 * @param expTime the exp time
	 */
	public void setExpTime(Date expTime) {
		this.expTime = expTime;
	}
	
	/**
	 * Gets the exp fb.
	 *
	 * @return the exp fb
	 */
	public String getExpFb() {
		return expFb;
	}
	
	/**
	 * Sets the exp fb.
	 *
	 * @param expFb the exp fb
	 */
	public void setExpFb(String expFb) {
		this.expFb = expFb;
	}
	
	/**
	 * Gets the remark1.
	 *
	 * @return the remark1
	 */
	public String getRemark1() {
		return remark1;
	}
	
	/**
	 * Sets the remark1.
	 *
	 * @param remark1 the remark1
	 */
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	
	/**
	 * Gets the remark2.
	 *
	 * @return the remark2
	 */
	public String getRemark2() {
		return remark2;
	}
	
	/**
	 * Sets the remark2.
	 *
	 * @param remark2 the remark2
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	
	/**
	 * Gets the remark3.
	 *
	 * @return the remark3
	 */
	public String getRemark3() {
		return remark3;
	}
	
	/**
	 * Sets the remark3.
	 *
	 * @param remark3 the remark3
	 */
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
	
	/**
	 * Gets the remark4.
	 *
	 * @return the remark4
	 */
	public String getRemark4() {
		return remark4;
	}
	
	/**
	 * Sets the remark4.
	 *
	 * @param remark4 the remark4
	 */
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}
	
	/**
	 * Gets the end time.
	 *
	 * @return the end time
	 */
	public String getEndTime() {
		return endTime;
	}
	
	/**
	 * Sets the end time.
	 *
	 * @param endTime the end time
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * Gets the start time.
	 *
	 * @return the start time
	 */
	public String getStartTime() {
		return startTime;
	}
	
	/**
	 * Sets the start time.
	 *
	 * @param startTime the start time
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
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
	

    
}
