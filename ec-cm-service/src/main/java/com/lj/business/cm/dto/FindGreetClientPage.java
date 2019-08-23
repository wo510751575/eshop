package com.lj.business.cm.dto;

import java.util.Date;

import com.lj.base.core.pagination.PageParamEntity; 
import com.lj.business.cm.emus.SendType;

// TODO: Auto-generated Javadoc
/**
 * The Class FindGreetClientPage.
 */
public class FindGreetClientPage extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 918639379193278361L; 
    /**
     * CODE .
     */
    private String code;

    /**
     * 会员号  .
     */
    private String merchantNo;

    /**
     * 导购编号  .
     */
    private String memberNoGm;

    /**
     * 导购姓名 .
     */
    private String memberNameGm;

    /**
     * 消息标题 .
     */
    private String title;

    /**
     * 消息内容 .
     */
    private String content;

    /**
     * 发送类型
             SINGLE：单人
             MULTI：多人 暂作废
             ALL：所有人 .
     */
    private SendType sendType;

    /**
     * 接收人会员编号 .
     */
    private String memberNo;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;
    
    /**
     * 备注 .
     */
    private String remark;
    /**
     * 备注2.
     */
    private String remark2;
    /**
     * 备注3 .
     */
    private String remark3;
    /**
     * 备注4 .
     */
    private String remark4;
    
    /** 开始时间. */
    private String  startTime;
    
    /** 结束时间. */
    private String  endTime;
    
    
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
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title.
	 *
	 * @param title the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * Sets the content.
	 *
	 * @param content the content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Gets the send type.
	 *
	 * @return the send type
	 */
	public SendType getSendType() {
		return sendType;
	}
	
	/**
	 * Sets the send type.
	 *
	 * @param sendType the send type
	 */
	public void setSendType(SendType sendType) {
		this.sendType = sendType;
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
	 * Gets the create id.
	 *
	 * @return the creates the id
	 */
	public String getCreateId() {
		return createId;
	}
	
	/**
	 * Sets the create id.
	 *
	 * @param createId the creates the id
	 */
	public void setCreateId(String createId) {
		this.createId = createId;
	}
	
	/**
	 * Gets the create date.
	 *
	 * @return the creates the date
	 */
	public Date getCreateDate() {
		return createDate;
	}
	
	/**
	 * Sets the create date.
	 *
	 * @param createDate the creates the date
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	/**
	 * Gets the remark.
	 *
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	
	/**
	 * Sets the remark.
	 *
	 * @param remark the remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FindGreetClientPage [code=" + code + ", merchantNo="
				+ merchantNo + ", memberNoGm=" + memberNoGm + ", memberNameGm="
				+ memberNameGm + ", title=" + title + ", content=" + content
				+ ", sendType=" + sendType + ", memberNo=" + memberNo
				+ ", createId=" + createId + ", createDate=" + createDate
				+ ", remark=" + remark + ", remark2=" + remark2 + ", remark3="
				+ remark3 + ", remark4=" + remark4 + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
    
}
