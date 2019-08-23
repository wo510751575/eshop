package com.lj.business.cm.dto;

import java.io.Serializable;

public class FindGreetClientForDayDto implements Serializable{

	 /**
	     * Generate cron.
	     *
	     * @param
	     * @param
	     * @throws 
	     */
	private static final long serialVersionUID = -4725621915817700196L;
	
    /**
     * 导购编号 (必填)
     */
    private String memberNoGm;
    /**
     * 创建时间 (必填)
     */
    private String createDate;
    
    /**
     * 结束时间
     */
    private String createDateEnd;

	public String getMemberNoGm() {
		return memberNoGm;
	}

	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateDateEnd() {
		return createDateEnd;
	}

	public void setCreateDateEnd(String createDateEnd) {
		this.createDateEnd = createDateEnd;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindGreetClientForDayDto [memberNoGm=")
				.append(memberNoGm).append(", createDate=").append(createDate)
				.append(", createDateEnd=").append(createDateEnd).append("]");
		return builder.toString();
	}
    
	
}
