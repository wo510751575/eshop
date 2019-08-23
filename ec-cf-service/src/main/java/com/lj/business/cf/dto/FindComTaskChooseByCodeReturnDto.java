package com.lj.business.cf.dto;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class FindComTaskChooseByCodeReturnDto.
 */
public class FindComTaskChooseByCodeReturnDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5578175766589373514L;
	
	 /**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 分店编号 .
     */
    private String shopNo;

    /**
     * 分店名称 .
     */
    private String shopName;

    /**
     * 导购编号  .
     */
    private String memberNoGm;

    /**
     * 导购姓名 .
     */
    private String memberNameGm;

    /**
     * 项目CODE .
     */
    private String codeList;

    /**
     * 项目名称 .
     */
    private String nameList;
    /**
     * 状态 
             启用：Y
             停用：N
              .
     */
    private String status;
    

    /**
     * 沟通任务类型 完善资料：IMPROVE  其他：OTHER .
     */
    private String comTaskType;

    /**
     * 跟进频率值 .
     */
    private String freValue;

    /**
     * 排序 .
     */
    private Integer seq;

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
    private String remark4;

    /**
     * 备注 .
     */
    private String remark3;

    /**
     * 备注 .
     */
    private String remark2;

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
	 * Gets the shop no.
	 *
	 * @return the shop no
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * Sets the shop no.
	 *
	 * @param shopNo the new shop no
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/**
	 * Gets the shop name.
	 *
	 * @return the shop name
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * Sets the shop name.
	 *
	 * @param shopName the new shop name
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
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
	 * Gets the code list.
	 *
	 * @return the code list
	 */
	public String getCodeList() {
		return codeList;
	}

	/**
	 * Sets the code list.
	 *
	 * @param codeList the new code list
	 */
	public void setCodeList(String codeList) {
		this.codeList = codeList;
	}

	/**
	 * Gets the name list.
	 *
	 * @return the name list
	 */
	public String getNameList() {
		return nameList;
	}

	/**
	 * Sets the name list.
	 *
	 * @param nameList the new name list
	 */
	public void setNameList(String nameList) {
		this.nameList = nameList;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the com task type.
	 *
	 * @return the com task type
	 */
	public String getComTaskType() {
		return comTaskType;
	}

	/**
	 * Sets the com task type.
	 *
	 * @param comTaskType the new com task type
	 */
	public void setComTaskType(String comTaskType) {
		this.comTaskType = comTaskType;
	}

	/**
	 * Gets the fre value.
	 *
	 * @return the fre value
	 */
	public String getFreValue() {
		return freValue;
	}

	/**
	 * Sets the fre value.
	 *
	 * @param freValue the new fre value
	 */
	public void setFreValue(String freValue) {
		this.freValue = freValue;
	}

	/**
	 * Gets the seq.
	 *
	 * @return the seq
	 */
	public Integer getSeq() {
		return seq;
	}

	/**
	 * Sets the seq.
	 *
	 * @param seq the new seq
	 */
	public void setSeq(Integer seq) {
		this.seq = seq;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindComTaskChooseByCodeReturnDto [code=").append(code)
				.append(", merchantNo=").append(merchantNo).append(", shopNo=")
				.append(shopNo).append(", shopName=").append(shopName)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", codeList=").append(codeList).append(", nameList=")
				.append(nameList).append(", status=").append(status)
				.append(", comTaskType=").append(comTaskType)
				.append(", freValue=").append(freValue).append(", seq=")
				.append(seq).append(", createDate=").append(createDate)
				.append(", remark=").append(remark).append(", remark4=")
				.append(remark4).append(", remark3=").append(remark3)
				.append(", remark2=").append(remark2).append("]");
		return builder.toString();
	}
    
}
