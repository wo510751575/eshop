package com.lj.business.cf.dto.pmAbandon;

import com.lj.base.core.pagination.PageParamEntity;

/**
 * The Class FindPmAbandonPage.
 */
public class FindPmAbandonPage extends PageParamEntity {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7185975303163800919L;

    
    /** 商户编号. */
    private String merchantNo;
    
    /**
     * 导购编号 .
     */
    private String memberNoGm;
    
    /** 客户编号. */
    private String memberNo;


    /**
     * 审批结果
             等待审批：WAIT
             同意：Y
             拒绝：N
              .
     */
    private String checkResult;


	/**
	 * Gets the 商户编号.
	 *
	 * @return the 商户编号
	 */
	public String getMerchantNo() {
		return merchantNo;
	}


	/**
	 * Sets the 商户编号.
	 *
	 * @param merchantNo the new 商户编号
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}


	/**
	 * Gets the 导购编号 .
	 *
	 * @return the 导购编号 
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}


	/**
	 * Sets the 导购编号 .
	 *
	 * @param memberNoGm the new 导购编号 
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}


	/**
	 * Gets the 客户编号.
	 *
	 * @return the 客户编号
	 */
	public String getMemberNo() {
		return memberNo;
	}


	/**
	 * Sets the 客户编号.
	 *
	 * @param memberNo the new 客户编号
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}


	/**
	 * Gets the 审批结果 等待审批：WAIT 同意：Y 拒绝：N .
	 *
	 * @return the 审批结果 等待审批：WAIT 同意：Y 拒绝：N 
	 */
	public String getCheckResult() {
		return checkResult;
	}


	/**
	 * Sets the 审批结果 等待审批：WAIT 同意：Y 拒绝：N .
	 *
	 * @param checkResult the new 审批结果 等待审批：WAIT 同意：Y 拒绝：N 
	 */
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindPmAbandonPage [merchantNo=").append(merchantNo)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", memberNo=").append(memberNo)
				.append(", checkResult=").append(checkResult).append("]");
		return builder.toString();
	}
    


}


