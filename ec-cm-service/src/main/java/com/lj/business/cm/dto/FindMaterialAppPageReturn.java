package com.lj.business.cm.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindMaterialAppPageReturn.
 */
public class FindMaterialAppPageReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4509960319694034166L;

	
	  /**
     * 素材CODE .
     */
    private String code;


    /**
     * 公共素材标识
     * 公共素材：COMMEN
     * 个人素材：SELF .
     */
    private String commenMaterial;

    /**
     * 标题 .
     */
    private String title;

    /**
     * 简介 .
     */
    private String brief;
    
    /**
     * 简介图片 .
     */
    private String briefImg;

    /**
     * H5链接地址 .
     */
    private String urlH5;
    /**
     * 创建时间 .
     */
    private Date createDate;
    /**
     *网址链接
     */
    private String  linkUrl;
    
    
	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * Gets the 素材CODE .
	 *
	 * @return the 素材CODE 
	 */
	public String getCode() {
		return code;
	}


	/**
	 * Sets the 素材CODE .
	 *
	 * @param code the new 素材CODE 
	 */
	public void setCode(String code) {
		this.code = code;
	}


	/**
	 * Gets the 公共素材标识 公共素材：COMMEN 个人素材：SELF .
	 *
	 * @return the 公共素材标识 公共素材：COMMEN 个人素材：SELF 
	 */
	public String getCommenMaterial() {
		return commenMaterial;
	}


	/**
	 * Sets the 公共素材标识 公共素材：COMMEN 个人素材：SELF .
	 *
	 * @param commenMaterial the new 公共素材标识 公共素材：COMMEN 个人素材：SELF 
	 */
	public void setCommenMaterial(String commenMaterial) {
		this.commenMaterial = commenMaterial;
	}


	/**
	 * Gets the 标题 .
	 *
	 * @return the 标题 
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * Sets the 标题 .
	 *
	 * @param title the new 标题 
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * Gets the h5链接地址 .
	 *
	 * @return the h5链接地址 
	 */
	public String getUrlH5() {
		return urlH5;
	}


	/**
	 * Sets the h5链接地址 .
	 *
	 * @param urlH5 the new h5链接地址 
	 */
	public void setUrlH5(String urlH5) {
		this.urlH5 = urlH5;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindMaterialAppPageReturn [code=").append(code)
				.append(", commenMaterial=").append(commenMaterial)
				.append(", title=").append(title).append(", brief=")
				.append(brief).append(", briefImg=").append(briefImg)
				.append(", urlH5=").append(urlH5).append("]");
		return builder.toString();
	}


	/**
	 * Gets the 简介 .
	 *
	 * @return the 简介 
	 */
	public String getBrief() {
		return brief;
	}


	/**
	 * Sets the 简介 .
	 *
	 * @param brief the new 简介 
	 */
	public void setBrief(String brief) {
		this.brief = brief;
	}


	/**
	 * Gets the 简介图片 .
	 *
	 * @return the 简介图片 
	 */
	public String getBriefImg() {
		return briefImg;
	}


	/**
	 * Sets the 简介图片 .
	 *
	 * @param briefImg the new 简介图片 
	 */
	public void setBriefImg(String briefImg) {
		this.briefImg = briefImg;
	}
    
	
}
