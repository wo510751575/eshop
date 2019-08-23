package com.lj.business.cf.dto.clientFollowSummary;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * 类说明：产生跟进总表和第一条跟进明细记录dto
 *  
 * 
 * <p>
 * 详细描述：
 *   
 *
 * @author 冯辉
 *   
 * CreateDate: 2017年7月10日
 * @Company: 领居科技有限公司
 */
public class AddPmClientFollowFirstDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2794779212263195236L; 
	
    /**
     * 商户号  .
     */
    private String merchantNo;

    /**
     * 会员号  .
     */
    private String memberNo;

    /**
     * 会员名称 .
     */
    private String memberName;
    
    /**
     * 导购编码.
     */
    private String memberNoGm;
    
    /**
     * 导购名称.
     */
    private String memberNameGm;
    
    /** 客户分类code. */
    private String pmTypeCode;
    
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
	 * Gets the pm type code.
	 *
	 * @return the pm type code
	 */
	public String getPmTypeCode() {
		return pmTypeCode;
	}

	/**
	 * Sets the pm type code.
	 *
	 * @param pmTypeCode the new pm type code
	 */
	public void setPmTypeCode(String pmTypeCode) {
		this.pmTypeCode = pmTypeCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddPmClientFollowFirstDto [merchantNo=")
				.append(merchantNo).append(", memberNo=").append(memberNo)
				.append(", memberName=").append(memberName)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", pmTypeCode=").append(pmTypeCode).append("]");
		return builder.toString();
	}
	
}
