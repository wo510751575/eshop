package com.lj.business.cf.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class NoticeSendMetGenClientFollowDto.
 */
public class NoticeSendMetGenClientFollowDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6773511258703842537L;
	
	/**
     * 商户编号 .
     */
    private String merchantNo;
    
    /** 跟踪编号. */
    private String cfNo;

    /**
     * 客户编号 .
     */
    private String memberNo;
    
    /** 导购编号. */
    private String memberNoGm;
    
    /** 素材类型名称. */
    private String materialTypeName;

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
	 * Gets the material type name.
	 *
	 * @return the material type name
	 */
	public String getMaterialTypeName() {
		return materialTypeName;
	}

	/**
	 * Sets the material type name.
	 *
	 * @param materialTypeName the new material type name
	 */
	public void setMaterialTypeName(String materialTypeName) {
		this.materialTypeName = materialTypeName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NoticeSendMetGenClientFollowDto [merchantNo=")
				.append(merchantNo).append(", cfNo=").append(cfNo)
				.append(", memberNo=").append(memberNo).append(", memberNoGm=")
				.append(memberNoGm).append(", materialTypeName=")
				.append(materialTypeName).append("]");
		return builder.toString();
	}
    
}
