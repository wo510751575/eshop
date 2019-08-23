package com.lj.business.member.domain;

import java.util.Date;
// TODO: Auto-generated Javadoc

/**
 * 类说明：客户标签表
 *  
 * 
 * <p>
 * 详细描述：
 *   
 *
 * @author 邹磊
 *   
 * CreateDate: 2017年7月12日
 * @Company: 领居科技有限公司
 */
public class PmLabel {
    /**
     * CODE .
     */
    private String code;

    /**
     * 会员号  .
     */
    private String merchantNo;

    /**
     * 客户标签名称 .
     */
    private String labelName;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;
    
    /**
     * 备注
     */
    private String remark;
    

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
     * CODE .
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * CODE .
     *
     * @param code the new code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 会员号  .
     *
     * @return the merchant no
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 会员号  .
     *
     * @param merchantNo the new merchant no
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 客户分类名称 .
     *
     * @return the label name
     */
    public String getLabelName() {
        return labelName;
    }

    /**
     * 客户分类名称 .
     *
     * @param labelName the new label name
     */
    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
    }

    /**
     * 创建人 .
     *
     * @return the creates the id
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人 .
     *
     * @param createId the new creates the id
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * 创建时间 .
     *
     * @return the creates the date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间 .
     *
     * @param createDate the new creates the date
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    @Override
	public String toString() {
		return "PmLabel [code=" + code + ", merchantNo=" + merchantNo
				+ ", labelName=" + labelName + ", createId=" + createId
				+ ", createDate=" + createDate + ", remark=" + remark + "]";
	}
}