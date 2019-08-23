package com.lj.business.cf.dto.comTask;

import java.io.Serializable;

import com.lj.business.cf.emus.ComTaskFinish;

/**
 * The Class UpdateComTaskGroup.
 */
public class UpdateComTaskGroup implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -797689030588921145L;
	
	

	/**
	 * 客户会员号  .
	 */
	private String memberNo;


	/**
	 * 导购编号 .
	 */
	private String memberNoGm;


	/**
	 * 任务完成情况
		进行中：NORMAL
		完成：FINISH
		系统关闭：CLOSE_SYS.
	 */
	private ComTaskFinish finish;


	/**
	 * Gets the 客户会员号  .
	 *
	 * @return the 客户会员号  
	 */
	public String getMemberNo() {
		return memberNo;
	}


	/**
	 * Sets the 客户会员号  .
	 *
	 * @param memberNo the new 客户会员号  
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
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
	 * @param memberNoGm the new 导购编号 
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}


	/**
	 * Gets the 任务完成情况 进行中：NORMAL 完成：FINISH 系统关闭：CLOSE_SYS.
	 *
	 * @return the 任务完成情况 进行中：NORMAL 完成：FINISH 系统关闭：CLOSE_SYS
	 */
	public ComTaskFinish getFinish() {
		return finish;
	}


	/**
	 * Sets the 任务完成情况 进行中：NORMAL 完成：FINISH 系统关闭：CLOSE_SYS.
	 *
	 * @param finish the new 任务完成情况 进行中：NORMAL 完成：FINISH 系统关闭：CLOSE_SYS
	 */
	public void setFinish(ComTaskFinish finish) {
		this.finish = finish;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateComTaskGroup [memberNo=").append(memberNo)
				.append(", memberNoGm=").append(memberNoGm).append(", finish=")
				.append(finish).append("]");
		return builder.toString();
	}


}
