package com.lj.business.cf.dto.comTask;

import java.io.Serializable;
import java.util.Date;

import com.lj.business.cf.emus.ComTaskFinish;

/**
 * The Class UpdateComTaskFi.
 */
public class UpdateComTaskFi implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4792520354354853743L;


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
     * 任务完成时间 .
     */
    private Date finishDate;

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
		builder.append("UpdateComTaskFi [memberNo=").append(memberNo)
				.append(", memberNoGm=").append(memberNoGm).append(", finish=")
				.append(finish).append(", finishDate=").append(finishDate)
				.append("]");
		return builder.toString();
	}


	/**
	 * Gets the 任务完成时间 .
	 *
	 * @return the 任务完成时间 
	 */
	public Date getFinishDate() {
		return finishDate;
	}


	/**
	 * Sets the 任务完成时间 .
	 *
	 * @param finishDate the new 任务完成时间 
	 */
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

}
