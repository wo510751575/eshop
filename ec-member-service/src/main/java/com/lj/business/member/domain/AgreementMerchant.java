package com.lj.business.member.domain;

import java.util.Date;


// TODO: Auto-generated Javadoc
/**
 * 类说明：商户服务协议
 *  
 * 
 * <p>
 * 详细描述：
 *   
 *
 * @author 段志鹏
 *   
 * CreateDate: 2017年6月30日
 * @Company: 领居科技有限公司
 */
public class AgreementMerchant{
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
    private String  agreementType;

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
    
    
    
    public String getAgreementType() {
		return agreementType;
	}

	public void setAgreementType(String agreementType) {
		this.agreementType = agreementType;
	}

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

	@Override
	public String toString() {
		return "AgreementMerchant [code=" + code + ", merchantNo=" + merchantNo
				+ ", agreement=" + agreement + ", agreementType="
				+ agreementType + ", createId=" + createId + ", createDate="
				+ createDate + ", updateId=" + updateId + ", updateDate="
				+ updateDate + "]";
	}
    
}