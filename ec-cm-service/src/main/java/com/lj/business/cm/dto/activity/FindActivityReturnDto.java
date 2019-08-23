package com.lj.business.cm.dto.activity;

import java.io.Serializable;
import java.util.Date;

public class FindActivityReturnDto implements Serializable{

	 /**
	     * Generate cron.
	     *
	     * @param
	     * @param
	     * @throws 
	     */
	private static final long serialVersionUID = 7644438966436511796L;
	
	private String code;
	
	   /**
     * 标题 .
     */
    private String title;

    /**
     * 图片地址 .
     */
    private String imgAddr;
    
    /**
     *  网址链接.
     */
    private String linkUrl;

    /**
     *  阅读量.
     */
    private Long readCount;

    /**
     *  分享量.
     */
    private Long shareCount;
    /**
     * 活动开始时间
     */
    private Date startDate;
    
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}


	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}


	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getImgAddr() {
		return imgAddr;
	}


	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}


	public String getLinkUrl() {
		return linkUrl;
	}


	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}


	public Long getReadCount() {
		return readCount;
	}


	public void setReadCount(Long readCount) {
		this.readCount = readCount;
	}


	public Long getShareCount() {
		return shareCount;
	}


	public void setShareCount(Long shareCount) {
		this.shareCount = shareCount;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FindActivityReturnDto [code=" + code + ", title=" + title
				+ ", imgAddr=" + imgAddr + ", linkUrl=" + linkUrl
				+ ", readCount=" + readCount + ", shareCount=" + shareCount
				+ "]";
	}
}
