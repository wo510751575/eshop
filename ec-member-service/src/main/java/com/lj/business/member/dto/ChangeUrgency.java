package com.lj.business.member.dto;

import java.io.Serializable;

import com.lj.business.member.emus.UrgentFlagType;

/**
 * The Class ChangeUrgency.
 */
public class ChangeUrgency implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5316023057703710603L;


	/**
	 * 导购编号(必填，（导购编号 && 客户编号） 客户客户分类关联表CODE 2选1) .
	 */
	private String memberNoGm;

	/**
	 * 客户编号(必填，（导购编号 && 客户编号） 客户客户分类关联表CODE 2选1 ) .
	 */
	private String memberNo;


	/**
	 * 客户客户分类关联表CODE（必填，（导购编号 && 客户编号） 客户客户分类关联表CODE 2选1） .
	 */
	private String pmTypePmCode;
	
	/** 添加/删除紧急分类,默认为N（取消紧急）. */
	private UrgentFlagType urgentFlagType = UrgentFlagType.N;

	/**
	 * Gets the 导购编号(必填，（导购编号 && 客户编号） 客户客户分类关联表CODE 2选1) .
	 *
	 * @return the 导购编号(必填，（导购编号 && 客户编号） 客户客户分类关联表CODE 2选1) 
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}


	/**
	 * Sets the 导购编号(必填，（导购编号 && 客户编号） 客户客户分类关联表CODE 2选1) .
	 *
	 * @param memberNoGm the new 导购编号(必填，（导购编号 && 客户编号） 客户客户分类关联表CODE 2选1) 
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}


	/**
	 * Gets the 客户编号(必填，（导购编号 && 客户编号） 客户客户分类关联表CODE 2选1 ) .
	 *
	 * @return the 客户编号(必填，（导购编号 && 客户编号） 客户客户分类关联表CODE 2选1 ) 
	 */
	public String getMemberNo() {
		return memberNo;
	}


	/**
	 * Sets the 客户编号(必填，（导购编号 && 客户编号） 客户客户分类关联表CODE 2选1 ) .
	 *
	 * @param memberNo the new 客户编号(必填，（导购编号 && 客户编号） 客户客户分类关联表CODE 2选1 ) 
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}


	/**
	 * Gets the 客户客户分类关联表CODE（必填，（导购编号 && 客户编号） 客户客户分类关联表CODE 2选1） .
	 *
	 * @return the 客户客户分类关联表CODE（必填，（导购编号 && 客户编号） 客户客户分类关联表CODE 2选1） 
	 */
	public String getPmTypePmCode() {
		return pmTypePmCode;
	}


	/**
	 * Sets the 客户客户分类关联表CODE（必填，（导购编号 && 客户编号） 客户客户分类关联表CODE 2选1） .
	 *
	 * @param pmTypePmCode the new 客户客户分类关联表CODE（必填，（导购编号 && 客户编号） 客户客户分类关联表CODE 2选1） 
	 */
	public void setPmTypePmCode(String pmTypePmCode) {
		this.pmTypePmCode = pmTypePmCode;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChangeUrgency [memberNoGm=").append(memberNoGm)
				.append(", memberNo=").append(memberNo)
				.append(", pmTypePmCode=").append(pmTypePmCode)
				.append(", urgentFlagType=").append(urgentFlagType).append("]");
		return builder.toString();
	}


	/**
	 * Gets the 添加/删除紧急分类,默认为N（取消紧急）.
	 *
	 * @return the 添加/删除紧急分类,默认为N（取消紧急）
	 */
	public UrgentFlagType getUrgentFlagType() {
		return urgentFlagType;
	}


	/**
	 * Sets the 添加/删除紧急分类,默认为N（取消紧急）.
	 *
	 * @param urgentFlagType the new 添加/删除紧急分类,默认为N（取消紧急）
	 */
	public void setUrgentFlagType(UrgentFlagType urgentFlagType) {
		this.urgentFlagType = urgentFlagType;
	}



}
