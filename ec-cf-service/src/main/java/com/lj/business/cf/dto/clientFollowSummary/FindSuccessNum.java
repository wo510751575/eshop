package com.lj.business.cf.dto.clientFollowSummary;

import java.io.Serializable;

public class FindSuccessNum implements Serializable{

	 /**
	     * Generate cron.
	     *
	     * @param
	     * @param
	     * @throws 
	     */
	private static final long serialVersionUID = -8722255090649585553L;

	
	private String memberName;
  
	private String status;
   
	private String memberNoGm;
	
	
	public String getMemberNoGm() {
		return memberNoGm;
	}

	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "FindSuccessNum [memberName=" + memberName + ", status="
				+ status + ", memberNoGm=" + memberNoGm + "]";
	}


	
}
