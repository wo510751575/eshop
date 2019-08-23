package com.lj.business.cf.dto.taskSetShop;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class TaskSetShopDetailReturn.
 */
public class TaskSetShopDetailReturn implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9096822388897800113L;
	
	 /**
     * CODE .
     */
    private String code;

    /**
     * 店长任务设置表CODE .
     */
    private String codeTss;

    /**
     * 导购编号 .
     */
    private String memberNoGm;

    /**
     * 导购姓名 .
     */
    private String memberNameGm;

    /**
     * 日均数量 .
     */
    private Long numDay;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeTss() {
		return codeTss;
	}

	public void setCodeTss(String codeTss) {
		this.codeTss = codeTss;
	}

	public String getMemberNoGm() {
		return memberNoGm;
	}

	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	public String getMemberNameGm() {
		return memberNameGm;
	}

	public void setMemberNameGm(String memberNameGm) {
		this.memberNameGm = memberNameGm;
	}

	public Long getNumDay() {
		return numDay;
	}

	public void setNumDay(Long numDay) {
		this.numDay = numDay;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TaskSetShopDetailReturn [code=").append(code)
				.append(", codeTss=").append(codeTss).append(", memberNoGm=")
				.append(memberNoGm).append(", memberNameGm=")
				.append(memberNameGm).append(", numDay=").append(numDay)
				.append("]");
		return builder.toString();
	}

}
