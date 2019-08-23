package com.lj.business.cm.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 类说明：
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @Company: 领居科技有限公司
 * @author 罗书明
 * 
 *         CreateDate: 2017年6月21日
 */
public class AddMaterialType implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7190296408674079087L;

	/**
	 * CODE .
	 */
	private String code;

	/**
	 * 商户编号 .（必填）
	 */
	private String merchantNo;

	/**
	 * 导购编号 .（必填）
	 */
	private String memberNoGm;

	/**
	 * 导购姓名 .
	 */
	private String memberNameGm;

	/**
	 * 类型名称 .（必填）
	 */
	private String typeName;

	/**
	 * 创建人 .
	 */
	private String createId;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 创建时间 .
	 */
	private Date createDate;

	/**
	 * 类型总数量
	 */
	private Integer typeCount;

	/**
	 * 图片地址
	 */
	private String imgAddr;

	/**
	 * 客户关注度
	 */
	private Double customerAttentionRate;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

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
	 * @param code
	 *            the new cODE
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
	 * @param merchantNo
	 *            the new 商户编号
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
	 * @param memberNoGm
	 *            the new 导购编号
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
	 * @param memberNameGm
	 *            the new 导购姓名
	 */
	public void setMemberNameGm(String memberNameGm) {
		this.memberNameGm = memberNameGm;
	}

	/**
	 * Gets the 类型名称 .
	 *
	 * @return the 类型名称
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * Sets the 类型名称 .
	 *
	 * @param typeName
	 *            the new 类型名称
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * Gets the 创建人 .
	 *
	 * @return the 创建人
	 */
	public String getCreateId() {
		return createId;
	}

	/**
	 * Sets the 创建人 .
	 *
	 * @param createId
	 *            the new 创建人
	 */
	public void setCreateId(String createId) {
		this.createId = createId;
	}

	/**
	 * Gets the 创建时间 .
	 *
	 * @return the 创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the 创建时间 .
	 *
	 * @param createDate
	 *            the new 创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getTypeCount() {
		return typeCount;
	}

	public void setTypeCount(Integer typeCount) {
		this.typeCount = typeCount;
	}

	public String getImgAddr() {
		return imgAddr;
	}

	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}

	public Double getCustomerAttentionRate() {
		return customerAttentionRate;
	}

	public void setCustomerAttentionRate(Double customerAttentionRate) {
		this.customerAttentionRate = customerAttentionRate;
	}

	@Override
	public String toString() {
		return "AddMaterialType [code=" + code + ", merchantNo=" + merchantNo
				+ ", memberNoGm=" + memberNoGm + ", memberNameGm="
				+ memberNameGm + ", typeName=" + typeName + ", createId="
				+ createId + ", remark=" + remark + ", createDate="
				+ createDate + ",typeCount=" + typeCount + ",imgAddr="
				+ imgAddr + ",customerAttentionRate=" + customerAttentionRate
				+ "]";
	}

}
