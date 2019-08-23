package com.lj.business.cf.dto.comTaskChoose;

import java.io.Serializable;

import com.lj.business.cf.emus.ComTaskType;

/**
 * The Class AddComTaskChooseDto.
 */
public class AddComTaskChooseDto implements Serializable{

	 /** Generate cron. */
	private static final long serialVersionUID = 2557620488660018494L;

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
    private ComTaskType comTaskType;

    /**
     * 跟进频率值 .
     */
    private String freValue;

    /**
     * 排序 .
     */
    private Integer seq;

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
	 * Gets the 分店编号 .
	 *
	 * @return the 分店编号 
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * Sets the 分店编号 .
	 *
	 * @param shopNo the new 分店编号 
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/**
	 * Gets the 分店名称 .
	 *
	 * @return the 分店名称 
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * Sets the 分店名称 .
	 *
	 * @param shopName the new 分店名称 
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * Gets the 导购编号  .
	 *
	 * @return the 导购编号  
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the 导购编号  .
	 *
	 * @param memberNoGm the new 导购编号  
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	/**
	 * Gets the 导购姓名 .
	 *
	 * @return the 导购姓名 
	 */
	public String getMemberNameGm() {
		return memberNameGm;
	}

	/**
	 * Sets the 导购姓名 .
	 *
	 * @param memberNameGm the new 导购姓名 
	 */
	public void setMemberNameGm(String memberNameGm) {
		this.memberNameGm = memberNameGm;
	}

	/**
	 * Gets the 项目CODE .
	 *
	 * @return the 项目CODE 
	 */
	public String getCodeList() {
		return codeList;
	}

	/**
	 * Sets the 项目CODE .
	 *
	 * @param codeList the new 项目CODE 
	 */
	public void setCodeList(String codeList) {
		this.codeList = codeList;
	}

	/**
	 * Gets the 项目名称 .
	 *
	 * @return the 项目名称 
	 */
	public String getNameList() {
		return nameList;
	}

	/**
	 * Sets the 项目名称 .
	 *
	 * @param nameList the new 项目名称 
	 */
	public void setNameList(String nameList) {
		this.nameList = nameList;
	}

	/**
	 * Gets the 状态 启用：Y 停用：N .
	 *
	 * @return the 状态 启用：Y 停用：N 
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the 状态 启用：Y 停用：N .
	 *
	 * @param status the new 状态 启用：Y 停用：N 
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the 沟通任务类型 完善资料：IMPROVE  其他：OTHER .
	 *
	 * @return the 沟通任务类型 完善资料：IMPROVE  其他：OTHER 
	 */
	public ComTaskType getComTaskType() {
		return comTaskType;
	}

	/**
	 * Sets the 沟通任务类型 完善资料：IMPROVE  其他：OTHER .
	 *
	 * @param comTaskType the new 沟通任务类型 完善资料：IMPROVE  其他：OTHER 
	 */
	public void setComTaskType(ComTaskType comTaskType) {
		this.comTaskType = comTaskType;
	}

	/**
	 * Gets the 跟进频率值 .
	 *
	 * @return the 跟进频率值 
	 */
	public String getFreValue() {
		return freValue;
	}

	/**
	 * Sets the 跟进频率值 .
	 *
	 * @param freValue the new 跟进频率值 
	 */
	public void setFreValue(String freValue) {
		this.freValue = freValue;
	}

	/**
	 * Gets the 排序 .
	 *
	 * @return the 排序 
	 */
	public Integer getSeq() {
		return seq;
	}

	/**
	 * Sets the 排序 .
	 *
	 * @param seq the new 排序 
	 */
	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	/**
	 * Gets the 备注 .
	 *
	 * @return the 备注 
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the 备注 .
	 *
	 * @param remark the new 备注 
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * Gets the 备注 .
	 *
	 * @return the 备注 
	 */
	public String getRemark4() {
		return remark4;
	}

	/**
	 * Sets the 备注 .
	 *
	 * @param remark4 the new 备注 
	 */
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	/**
	 * Gets the 备注 .
	 *
	 * @return the 备注 
	 */
	public String getRemark3() {
		return remark3;
	}

	/**
	 * Sets the 备注 .
	 *
	 * @param remark3 the new 备注 
	 */
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	/**
	 * Gets the 备注 .
	 *
	 * @return the 备注 
	 */
	public String getRemark2() {
		return remark2;
	}

	/**
	 * Sets the 备注 .
	 *
	 * @param remark2 the new 备注 
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
		builder.append("AddComTaskChooseDto [merchantNo=").append(merchantNo)
				.append(", shopNo=").append(shopNo).append(", shopName=")
				.append(shopName).append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", codeList=").append(codeList).append(", nameList=")
				.append(nameList).append(", status=").append(status)
				.append(", comTaskType=").append(comTaskType)
				.append(", freValue=").append(freValue).append(", seq=")
				.append(seq).append(", remark=").append(remark)
				.append(", remark4=").append(remark4).append(", remark3=")
				.append(remark3).append(", remark2=").append(remark2)
				.append("]");
		return builder.toString();
	}

}
