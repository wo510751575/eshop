package com.lj.business.cf.dto.comTaskWorkflow;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindComTaskWorkflow.
 */
public class FindComTaskWorkflow implements Serializable { 

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8053267754476813882L;
	   /**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 项目CODE .
     */
    private String codeList;

    /**
     * 项目名称 .
     */
    private String nameList;

    /**
     * 下个项目CODE .
     */
    private String nextCodeList;

    /**
     * 下个项目名称 .
     */
    private String nextNameList;

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
     * 商户编号 .
     *
     * @return the merchant no
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 商户编号 .
     *
     * @param merchantNo the new merchant no
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 项目CODE .
     *
     * @return the code list
     */
    public String getCodeList() {
        return codeList;
    }

    /**
     * 项目CODE .
     *
     * @param codeList the new code list
     */
    public void setCodeList(String codeList) {
        this.codeList = codeList == null ? null : codeList.trim();
    }

    /**
     * 项目名称 .
     *
     * @return the name list
     */
    public String getNameList() {
        return nameList;
    }

    /**
     * 项目名称 .
     *
     * @param nameList the new name list
     */
    public void setNameList(String nameList) {
        this.nameList = nameList == null ? null : nameList.trim();
    }

    /**
     * 下个项目CODE .
     *
     * @return the next code list
     */
    public String getNextCodeList() {
        return nextCodeList;
    }

    /**
     * 下个项目CODE .
     *
     * @param nextCodeList the new next code list
     */
    public void setNextCodeList(String nextCodeList) {
        this.nextCodeList = nextCodeList == null ? null : nextCodeList.trim();
    }

    /**
     * 下个项目名称 .
     *
     * @return the next name list
     */
    public String getNextNameList() {
        return nextNameList;
    }

    /**
     * 下个项目名称 .
     *
     * @param nextNameList the new next name list
     */
    public void setNextNameList(String nextNameList) {
        this.nextNameList = nextNameList == null ? null : nextNameList.trim();
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

    /**
     * 备注 .
     *
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注 .
     *
     * @param remark the new remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ComTaskWorkflow [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", codeList=").append(codeList).append(", nameList=")
				.append(nameList).append(", nextCodeList=")
				.append(nextCodeList).append(", nextNameList=")
				.append(nextNameList).append(", createId=").append(createId)
				.append(", createDate=").append(createDate).append(", remark=")
				.append(remark).append("]");
		return builder.toString();
	}
    
}
