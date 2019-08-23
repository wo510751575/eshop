package com.lj.business.cf.dto.comTask;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindComTask.
 */
public class FindComTask implements Serializable { 

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1420484077654436124L;
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
     * 导购编号 .
     */
    private String memberNoGm;
    
    /**
     * 查询时间
     */
    private Date date;
    
    /**
     * 完成状态
     */
    private String finish;

	/**
	 * Gets the cODE .
	 *
	 * @return the cODE 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the cODE .
	 *
	 * @param code the new cODE 
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the 商户编号 .
	 *
	 * @return the 商户编号 
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户编号 .
	 *
	 * @param merchantNo the new 商户编号 
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the 客户编号 .
	 *
	 * @return the 客户编号 
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 客户编号 .
	 *
	 * @param memberNo the new 客户编号 
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberNoGm() {
		return memberNoGm;
	}

	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	@Override
	public String toString() {
		return "FindComTask [code=" + code + ", merchantNo=" + merchantNo
				+ ", memberNo=" + memberNo + ", memberNoGm=" + memberNoGm
				+ ", date=" + date + ", finish=" + finish + "]";
	}
    
}
