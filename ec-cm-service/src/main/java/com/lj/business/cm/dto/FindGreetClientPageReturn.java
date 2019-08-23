package com.lj.business.cm.dto;

import java.io.Serializable;
import java.util.Date;

import com.lj.business.cm.emus.SendType;

/**
 * The Class FindGreetClientPageReturn.
 */
public class FindGreetClientPageReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6788394025855390974L; 
	

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
	public String getMemberNoGm() {
		return memberNoGm;
	}
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}
	public String getMemberNameGm() {
		return memberNameGm;
	}
	public void setMemberNameGm(String memberNameGm) {
		this.memberNameGm = memberNameGm;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public SendType getSendType() {
		return sendType;
	}
	public void setSendType(SendType sendType) {
		this.sendType = sendType;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getCreateId() {
		return createId;
	}
	public void setCreateId(String createId) {
		this.createId = createId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemark2() {
		return remark2;
	}
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	public String getRemark3() {
		return remark3;
	}
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
	public String getRemark4() {
		return remark4;
	}
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GreetClient [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", title=").append(title).append(", content=")
				.append(content).append(", sendType=").append(sendType)
				.append(", memberNo=").append(memberNo).append(", createId=")
				.append(createId).append(", createDate=").append(createDate)
				.append(", remark=").append(remark).append(", remark2=")
				.append(remark2).append(", remark3=").append(remark3)
				.append(", remark4=").append(remark4).append("]");
		return builder.toString();
	}
    
}
