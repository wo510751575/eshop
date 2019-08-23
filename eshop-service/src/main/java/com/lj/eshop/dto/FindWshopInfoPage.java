package com.lj.eshop.dto;

import java.util.Date;

import com.lj.base.core.pagination.PageParamEntity;

/**
 * The Class FindShopPage.
 */
public class FindWshopInfoPage extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8772369606274410476L;


	/** 开始时间. */
	private Date startTime;

	/** 结束时间. */
	private Date endTime;
	/**
     *  .
     */
    private String code;

    /**
     * 微商加油标题 .
     */
    private String title;

    /**
     * 微商加油概要 .
     */
    private String flagInfo;

    /**
     * 微商加油详细文章 .
     */
    private String detail;

    /**
     * 图片1 .
     */
    private String img1;

    /**
     * 图片2 .
     */
    private String img2;

    /**
     * 图片3 .
     */
    private String img3;

    /**
     * 图片4 .
     */
    private String img4;

    /**
     * 图片5 .
     */
    private String img5;

    /**
     * 阅读量 .
     */
    private String readCnt;
    /**
     * 分享量 .
     */
    private String shareCnt;

    /**
     *  .
     */
    private Date createTime;

    /**
     *  .
     */
    private Date updateTime;

    /**
     *  .
     */
    private String creater;

    /**
     * 状态: 0:启用1:停用 .
     */
    private String status;
    
    /**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
     *  .
     *
     */
    public String getCode() {
        return code;
    }

    /**
     *  .
     *
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 微商加油标题 .
     *
     */
    public String getTitle() {
        return title;
    }

    /**
     * 微商加油标题 .
     *
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 微商加油概要 .
     *
     */
    public String getFlagInfo() {
        return flagInfo;
    }

    /**
     * 微商加油概要 .
     *
     */
    public void setFlagInfo(String flagInfo) {
        this.flagInfo = flagInfo == null ? null : flagInfo.trim();
    }

    /**
     * 微商加油详细文章 .
     *
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 微商加油详细文章 .
     *
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * 图片1 .
     *
     */
    public String getImg1() {
        return img1;
    }

    /**
     * 图片1 .
     *
     */
    public void setImg1(String img1) {
        this.img1 = img1 == null ? null : img1.trim();
    }

    /**
     * 图片2 .
     *
     */
    public String getImg2() {
        return img2;
    }

    /**
     * 图片2 .
     *
     */
    public void setImg2(String img2) {
        this.img2 = img2 == null ? null : img2.trim();
    }

    /**
     * 图片3 .
     *
     */
    public String getImg3() {
        return img3;
    }

    /**
     * 图片3 .
     *
     */
    public void setImg3(String img3) {
        this.img3 = img3 == null ? null : img3.trim();
    }

    /**
     * 图片4 .
     *
     */
    public String getImg4() {
        return img4;
    }

    /**
     * 图片4 .
     *
     */
    public void setImg4(String img4) {
        this.img4 = img4 == null ? null : img4.trim();
    }

    /**
     * 图片5 .
     *
     */
    public String getImg5() {
        return img5;
    }

    /**
     * 图片5 .
     *
     */
    public void setImg5(String img5) {
        this.img5 = img5 == null ? null : img5.trim();
    }

    /**
     * 阅读量 .
     *
     */
    public String getReadCnt() {
        return readCnt;
    }

    /**
     * 阅读量 .
     *
     */
    public void setReadCnt(String readCnt) {
        this.readCnt = readCnt == null ? null : readCnt.trim();
    }

    /**
     *  .
     *
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *  .
     *
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *  .
     *
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *  .
     *
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *  .
     *
     */
    public String getCreater() {
        return creater;
    }

    /**
     *  .
     *
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * 状态: 0:启用1:停用 .
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态: 0:启用1:停用 .
     *
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	public String getShareCnt() {
		return shareCnt;
	}

	public void setShareCnt(String shareCnt) {
		this.shareCnt = shareCnt;
	}

	@Override
	public String toString() {
		return "FindWshopInfoPage [startTime=" + startTime + ", endTime=" + endTime + ", code=" + code + ", title="
				+ title + ", flagInfo=" + flagInfo + ", detail=" + detail + ", img1=" + img1 + ", img2=" + img2
				+ ", img3=" + img3 + ", img4=" + img4 + ", img5=" + img5 + ", readCnt=" + readCnt + ", shareCnt="
				+ shareCnt + ", createTime=" + createTime + ", updateTime=" + updateTime + ", creater=" + creater
				+ ", status=" + status + "]";
	}
    
	
    
}
