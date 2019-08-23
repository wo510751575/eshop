package com.lj.business.cf.dto;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class FindAddGuidInfoRecordDto.
 */
public class FindAddGuidInfoRecordDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1140541558101722212L;
	
	 /**
     * 商户编号(必填) .
     */
    private String merchantNo;

    /**
     * 客户编号(必填)  .
     */
    private String memberNo;

    /**
     * 客户名称 .
     */
    private String memberName;

    /**
     * 导购编号(必填)  .
     */
    private String memberNoGm;

    /**
     * 导购姓名 .
     */
    private String memberNameGm;

    /**
     * 门店编号(必填)  .
     */
    private String shopNo;

    /**
     * 门店名称 .
     */
    private String shopName;

    /**
     * 素材发送时间  .
     */
    private Date sendTime;
    
    /** 素材code(必填) . */
    private String materialCode;
    
    /** 素材公私类型(必填) . */
    private String materialCommenType;
    
    /**
     * 客户沟通任务Code .
     */
    private String comTaskCode;
    
    /**
     * 是否累计任务，默认false .
     */
    private Boolean dis = false;
    
    /**
     * 是否FINISH原沟通任务，默认true .
     */
    private Boolean finishOrgComTask = true;
    
    /** 跟进编号. */
    private String cfNo;

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
	 * @param merchantNo the new merchant no
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
	 * @param memberNo the new member no
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
	 * @param memberName the new member name
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
	 * @param memberNoGm the new member no gm
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
	 * @param memberNameGm the new member name gm
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
	 * @param shopNo the new shop no
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
	 * @param shopName the new shop name
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * Gets the send time.
	 *
	 * @return the send time
	 */
	public Date getSendTime() {
		return sendTime;
	}

	/**
	 * Sets the send time.
	 *
	 * @param sendTime the new send time
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	/**
	 * Gets the material code.
	 *
	 * @return the material code
	 */
	public String getMaterialCode() {
		return materialCode;
	}

	/**
	 * Sets the material code.
	 *
	 * @param materialCode the new material code
	 */
	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	/**
	 * Gets the material commen type.
	 *
	 * @return the material commen type
	 */
	public String getMaterialCommenType() {
		return materialCommenType;
	}

	/**
	 * Sets the material commen type.
	 *
	 * @param materialCommenType the new material commen type
	 */
	public void setMaterialCommenType(String materialCommenType) {
		this.materialCommenType = materialCommenType;
	}
	
	/**
	 * Gets the com task code.
	 *
	 * @return the com task code
	 */
	public String getComTaskCode() {
		return comTaskCode;
	}

	/**
	 * Sets the com task code.
	 *
	 * @param comTaskCode the new com task code
	 */
	public void setComTaskCode(String comTaskCode) {
		this.comTaskCode = comTaskCode;
	}

	/**
	 * Gets the dis.
	 *
	 * @return the dis
	 */
	public Boolean getDis() {
		return dis;
	}

	/**
	 * Sets the dis.
	 *
	 * @param dis the new dis
	 */
	public void setDis(Boolean dis) {
		this.dis = dis;
	}
	
	/**
	 * Gets the finish org com task.
	 *
	 * @return the finish org com task
	 */
	public Boolean getFinishOrgComTask() {
		return finishOrgComTask;
	}

	/**
	 * Sets the finish org com task.
	 *
	 * @param finishOrgComTask the new finish org com task
	 */
	public void setFinishOrgComTask(Boolean finishOrgComTask) {
		this.finishOrgComTask = finishOrgComTask;
	}
	
	/**
	 * Gets the cf no.
	 *
	 * @return the cf no
	 */
	public String getCfNo() {
		return cfNo;
	}

	/**
	 * Sets the cf no.
	 *
	 * @param cfNo the new cf no
	 */
	public void setCfNo(String cfNo) {
		this.cfNo = cfNo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindAddGuidInfoRecordDto [merchantNo=")
				.append(merchantNo).append(", memberNo=").append(memberNo)
				.append(", memberName=").append(memberName)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", shopNo=").append(shopNo).append(", shopName=")
				.append(shopName).append(", sendTime=").append(sendTime)
				.append(", materialCode=").append(materialCode)
				.append(", materialCommenType=").append(materialCommenType)
				.append(", comTaskCode=").append(comTaskCode).append(", dis=")
				.append(dis).append(", finishOrgComTask=")
				.append(finishOrgComTask).append(", cfNo=").append(cfNo)
				.append("]");
		return builder.toString();
	}

}
