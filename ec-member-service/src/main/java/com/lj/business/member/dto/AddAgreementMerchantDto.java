package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * The Class AddAgreementMerchant.
 */
public class AddAgreementMerchantDto implements Serializable{

	 /** Generate cron. */
	private static final long serialVersionUID = 6525303743077837975L;
	/**
     * CODE .
     */
    private String code;

    /**
     * 会员号  .
     */
    private String merchantNo;

    /**
     * 服务协议 .
     */
    private String agreement;
    /**
     * 协议类型
     */
    private String agreementType;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;

    /**
     * 更新人 .
     */
    private String updateId;

    /**
     * 更新时间 .
     */
    private Date updateDate;

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

	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
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

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getAgreementType() {
		return agreementType;
	}

	public void setAgreementType(String agreementType) {
		this.agreementType = agreementType;
	}

	@Override
	public String toString() {
		return "AddAgreementMerchantDto [code=" + code + ", merchantNo="
				+ merchantNo + ", agreement=" + agreement + ", agreementType="
				+ agreementType + ", createId=" + createId + ", createDate="
				+ createDate + ", updateId=" + updateId + ", updateDate="
				+ updateDate + "]";
	}


}
