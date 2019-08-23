package com.lj.business.cf.dto;

import java.io.Serializable;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class MangerWorkReturn.
 */
public class MangerWorkReturn implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6301013541358086872L;
	
	/**  导购编号. */
    private String memberNoGm;
    
    /**  导购名称. */
    private String memberNameGm;
    
    /**  平均工作得分   还未设计. */
    private int avgWorkScore;
    
    /**  异常数量. */
    private Long errorNum;
    
    /** 主要工作列表. */
    private List<MainWorkTaskList> workTaskList;
    
    /** 其他工作. */
    private List<OtherTaskList> otherWorkTaskList;
    
    /** 异常跟进列表. */
    private List<UnfinishTaskList> onfinishTaskList;

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
	 * Gets the avg work score.
	 *
	 * @return the avg work score
	 */
	public int getAvgWorkScore() {
		return avgWorkScore;
	}

	/**
	 * Sets the avg work score.
	 *
	 * @param avgWorkScore the new avg work score
	 */
	public void setAvgWorkScore(int avgWorkScore) {
		this.avgWorkScore = avgWorkScore;
	}

	/**
	 * Gets the error num.
	 *
	 * @return the error num
	 */
	public Long getErrorNum() {
		return errorNum;
	}

	/**
	 * Sets the error num.
	 *
	 * @param errorNum the new error num
	 */
	public void setErrorNum(Long errorNum) {
		this.errorNum = errorNum;
	}

	/**
	 * Gets the work task list.
	 *
	 * @return the work task list
	 */
	public List<MainWorkTaskList> getWorkTaskList() {
		return workTaskList;
	}

	/**
	 * Sets the work task list.
	 *
	 * @param workTaskList the new work task list
	 */
	public void setWorkTaskList(List<MainWorkTaskList> workTaskList) {
		this.workTaskList = workTaskList;
	}

	/**
	 * Gets the other work task list.
	 *
	 * @return the other work task list
	 */
	public List<OtherTaskList> getOtherWorkTaskList() {
		return otherWorkTaskList;
	}

	/**
	 * Sets the other work task list.
	 *
	 * @param otherWorkTaskList the new other work task list
	 */
	public void setOtherWorkTaskList(List<OtherTaskList> otherWorkTaskList) {
		this.otherWorkTaskList = otherWorkTaskList;
	}

	/**
	 * Gets the onfinish task list.
	 *
	 * @return the onfinish task list
	 */
	public List<UnfinishTaskList> getOnfinishTaskList() {
		return onfinishTaskList;
	}

	/**
	 * Sets the onfinish task list.
	 *
	 * @param onfinishTaskList the new onfinish task list
	 */
	public void setOnfinishTaskList(List<UnfinishTaskList> onfinishTaskList) {
		this.onfinishTaskList = onfinishTaskList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MangerWorkReturn [memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", avgWorkScore=").append(avgWorkScore)
				.append(", errorNum=").append(errorNum)
				.append(", workTaskList=").append(workTaskList)
				.append(", otherWorkTaskList=").append(otherWorkTaskList)
				.append(", onfinishTaskList=").append(onfinishTaskList)
				.append("]");
		return builder.toString();
	}

}
