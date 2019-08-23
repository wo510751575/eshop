package com.lj.business.cf.dto.clientExp;

import java.util.Date;

import com.lj.base.core.pagination.PageParamEntity;

/**
 * The Class FindClientExpPage.
 */
public class FindClientExpPage extends PageParamEntity {

	
	 /** Generate cron. */
	private static final long serialVersionUID = 416032623464444964L; 
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
    private Date expTime;

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
     * 结束时间
     */
    private String endTime;
    
    /**
     * 开始时间
     */
    private String startTime;
    
    /**
     * 开始时间
     */
    private String cfCode;

    /**
	 * @return the cfCode
	 */
	public String getCfCode() {
		return cfCode;
	}

	/**
	 * @param cfCode the cfCode to set
	 */
	public void setCfCode(String cfCode) {
		this.cfCode = cfCode;
	}

	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
     * CODE .
     *
     */
    public String getCode() {
        return code;
    }

    /**
     * CODE .
     *
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 商户编号 .
     *
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 商户编号 .
     *
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 客户编号 .
     *
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * 客户编号 .
     *
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     * 客户名称 .
     *
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 客户名称 .
     *
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 导购编号 .
     *
     */
    public String getMemberNoGm() {
        return memberNoGm;
    }

    /**
     * 导购编号 .
     *
     */
    public void setMemberNoGm(String memberNoGm) {
        this.memberNoGm = memberNoGm == null ? null : memberNoGm.trim();
    }

    /**
     * 导购姓名 .
     *
     */
    public String getMemberNameGm() {
        return memberNameGm;
    }

    /**
     * 导购姓名 .
     *
     */
    public void setMemberNameGm(String memberNameGm) {
        this.memberNameGm = memberNameGm == null ? null : memberNameGm.trim();
    }

    /**
     * 门店编号 .
     *
     */
    public String getShopNo() {
        return shopNo;
    }

    /**
     * 门店编号 .
     *
     */
    public void setShopNo(String shopNo) {
        this.shopNo = shopNo == null ? null : shopNo.trim();
    }

    /**
     * 门店名称 .
     *
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 门店名称 .
     *
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 体验时间 .
     *
     */
    public Date getExpTime() {
        return expTime;
    }

    /**
     * 体验时间 .
     *
     */
    public void setExpTime(Date expTime) {
        this.expTime = expTime;
    }

    /**
     * 体验反馈 .
     *
     */
    public String getExpFb() {
        return expFb;
    }

    /**
     * 体验反馈 .
     *
     */
    public void setExpFb(String expFb) {
        this.expFb = expFb == null ? null : expFb.trim();
    }

    /**
     * 看中款项图片列表以,分隔 .
     *
     */
    public String getImgs() {
        return imgs;
    }

    /**
     * 看中款项图片列表以,分隔 .
     *
     */
    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

    /**
     * 语音资源文件存放路径列表以,分隔 .
     *
     */
    public String getResourcesUrl() {
        return resourcesUrl;
    }

    /**
     * 语音资源文件存放路径列表以,分隔 .
     *
     */
    public void setResourcesUrl(String resourcesUrl) {
        this.resourcesUrl = resourcesUrl == null ? null : resourcesUrl.trim();
    }

    /**
     * 备注 .
     *
     */
    public String getRemark4() {
        return remark4;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
    }

    /**
     * 备注 .
     *
     */
    public String getRemark3() {
        return remark3;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    /**
     * 备注 .
     *
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    /**
     *  .
     *
     */
    public String getRemark1() {
        return remark1;
    }

    /**
     *  .
     *
     */
    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    /**
     * 输出BEAN数据信息
     * @author LeoPeng
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ClientExp [code=").append(code);
        builder.append(",merchantNo=").append(merchantNo); 
        builder.append(",memberNo=").append(memberNo); 
        builder.append(",memberName=").append(memberName); 
        builder.append(",memberNoGm=").append(memberNoGm); 
        builder.append(",memberNameGm=").append(memberNameGm); 
        builder.append(",shopNo=").append(shopNo); 
        builder.append(",shopName=").append(shopName); 
        builder.append(",expTime=").append(expTime); 
        builder.append(",expFb=").append(expFb); 
        builder.append(",imgs=").append(imgs); 
        builder.append(",resourcesUrl=").append(resourcesUrl); 
        builder.append(",remark4=").append(remark4); 
        builder.append(",remark3=").append(remark3); 
        builder.append(",remark2=").append(remark2); 
        builder.append(",remark1=").append(remark1); 
        builder.append("]");
        return builder.toString();
    }
}