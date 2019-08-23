package com.lj.business.cf.dto.comTaskChoose;

import java.io.Serializable;

/**
 * The Class FindComTaskChooseIndexReturn.
 */
public class FindComTaskChooseIndexReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2765314118641952398L;
	
    /**
     * 项目CODE .
     */
    private String codeList;

    /**
     * 项目名称 .
     */
    private String nameList;
    
    /**
     * 沟通任务类型
		完善资料：IMPROVE（作废）
		分组任务：GROUP
		初次介绍：FIRST_INTR
		沟通任务：COM_TASK
		邀约任务：INVITE
		提醒任务：REMIND
		到店体验：CLIENT_EXP
		引导客户：GUID_PM
     */
    private String comTaskType;
    
    /**
     * 客户数量 .
     */
    private Long numClient;
    

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindComTaskChooseIndexReturn [codeList=")
				.append(codeList).append(", nameList=").append(nameList)
				.append(", comTaskType=").append(comTaskType)
				.append(", numClient=").append(numClient).append("]");
		return builder.toString();
	}

	/**
	 * Gets the 客户数量 .
	 *
	 * @return the 客户数量 
	 */
	public Long getNumClient() {
		return numClient;
	}

	/**
	 * Sets the 客户数量 .
	 *
	 * @param numClient the new 客户数量 
	 */
	public void setNumClient(Long numClient) {
		this.numClient = numClient;
	}

	/**
	 * Gets the 沟通任务类型 完善资料：IMPROVE 其他：OTHER.
	 *
	 * @return the 沟通任务类型 完善资料：IMPROVE 其他：OTHER
	 */
	public String getComTaskType() {
		return comTaskType;
	}

	/**
	 * Sets the 沟通任务类型 完善资料：IMPROVE 其他：OTHER.
	 *
	 * @param comTaskType the new 沟通任务类型 完善资料：IMPROVE 其他：OTHER
	 */
	public void setComTaskType(String comTaskType) {
		this.comTaskType = comTaskType;
	}


	

}
