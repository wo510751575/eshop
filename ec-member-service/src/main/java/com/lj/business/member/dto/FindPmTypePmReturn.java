package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class FindPmTypePmReturn.
 */
public class FindPmTypePmReturn implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8471785481187999987L;
	
	/**
     * CODE .
     */
    private String code;

    /**
     * 客户表CODE .
     */
    private String codePm;

    /**
     * 客户分类CODE .
     */
    private String pmTypeCode;

    /**
     * 创建时间 .
     */
    private Date createDate;

    /**
     * 备注 .
     */
    private String remark;

    /**
     * 备注 .
     */
    private String remark2;

    /**
     * 备注 .
     */
    private String remark3;

    /**
     * 备注 .
     */
    private String remark4;

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the code pm.
	 *
	 * @return the code pm
	 */
	public String getCodePm() {
		return codePm;
	}

	/**
	 * Sets the code pm.
	 *
	 * @param codePm the new code pm
	 */
	public void setCodePm(String codePm) {
		this.codePm = codePm;
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

	/**
	 * Gets the creates the date.
	 *
	 * @return the creates the date
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the creates the date.
	 *
	 * @param createDate the new creates the date
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * Gets the remark.
	 *
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the remark.
	 *
	 * @param remark the new remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * Gets the remark 2.
	 *
	 * @return the remark 2
	 */
	public String getRemark2() {
		return remark2;
	}

	/**
	 * Sets the remark 2.
	 *
	 * @param remark2 the new remark 2
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	/**
	 * Gets the remark 3.
	 *
	 * @return the remark 3
	 */
	public String getRemark3() {
		return remark3;
	}

	/**
	 * Sets the remark 3.
	 *
	 * @param remark3 the new remark 3
	 */
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	/**
	 * Gets the remark 4.
	 *
	 * @return the remark 4
	 */
	public String getRemark4() {
		return remark4;
	}

	/**
	 * Sets the remark 4.
	 *
	 * @param remark4 the new remark 4
	 */
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindPmTypePmReturn [code=").append(code)
				.append(", codePm=").append(codePm).append(", pmTypeCode=")
				.append(pmTypeCode).append(", createDate=").append(createDate)
				.append(", remark=").append(remark).append(", remark2=")
				.append(remark2).append(", remark3=").append(remark3)
				.append(", remark4=").append(remark4).append("]");
		return builder.toString();
	}
    
}
