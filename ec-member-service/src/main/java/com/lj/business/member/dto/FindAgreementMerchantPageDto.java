package com.lj.business.member.dto;

import java.util.Date;

import com.lj.base.core.pagination.PageParamEntity;

/**
 * The Class FindAgreementMerchantPageDto.
 */
public class FindAgreementMerchantPageDto extends PageParamEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1987350520998787622L;

	/** The code. */
	private String code; // 唯一code
	
	/** The merchant no. */
	private String merchantNo;// 会员号
	
	/** The agreement. */
	private String agreement;// 服务协议
	
	private String agreementType;// 服务协议类型
	
	/** The create id. */
	private String createId;// 创建人
	
	/** The create date. */
	private Date createDate;// 创建时间
	
	/** The update id. */
	private String updateId;// 更新人
	
	/** The update date. */
	private Date updateDate;// 更新时间

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

	public String getAgreementType() {
		return agreementType;
	}

	public void setAgreementType(String agreementType) {
		this.agreementType = agreementType;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindAgreementMerchantPageDto [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", agreement=").append(agreement)
				.append(", agreementType=").append(agreementType)
				.append(", createId=").append(createId).append(", createDate=")
				.append(createDate).append(", updateId=").append(updateId)
				.append(", updateDate=").append(updateDate).append("]");
		return builder.toString();
	}

}
