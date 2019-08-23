package com.lj.business.cf.dto;

import java.io.Serializable;

/**
 * The Class FindWorkTaskMainListReturn.
 */
public class FindWorkTaskMainListReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1310646454156884471L;

	
	 /**
     * CODE .
     */
    private String code;

    /**
     * 项目CODE .
     */
    private String codeList;

    /**
     * 项目名称 .
     */
    private String nameList;
    
    /**
     * 任务要求数量 .
     */
    private Integer requireNum;

    /**
     * 完成数量 .
     */
    private Integer finishNum;

    /**
     * 未完成数量 .
     */
    private Integer unfinishNum;

    /**
     * 击败数量 .
     */
    private Integer defeatNum;


    /**
     * 工作是否完成
             是：Y
             否：N .
     */
    private String finish;
    
    /**
     *  标题 .
     */
    private String title;
    
    /**
     * 描述 .
     */
    private String desc;
    
    /**
     * 任务类型
		客户沟通：GOU_TONG
		销售目标：XIAO_SHOU
		新增客户：XIN_ZENG
		社交任务：SHE_JIAO
		 .
     */
    private String taskType;
    
    /** 任务单位. */
    private String taskUnit;
    

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
	 * @param code the new cODE 
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * Gets the 任务要求数量 .
	 *
	 * @return the 任务要求数量 
	 */
	public Integer getRequireNum() {
		return requireNum;
	}

	/**
	 * Sets the 任务要求数量 .
	 *
	 * @param requireNum the new 任务要求数量 
	 */
	public void setRequireNum(Integer requireNum) {
		this.requireNum = requireNum;
	}

	/**
	 * Gets the 完成数量 .
	 *
	 * @return the 完成数量 
	 */
	public Integer getFinishNum() {
		return finishNum;
	}

	/**
	 * Sets the 完成数量 .
	 *
	 * @param finishNum the new 完成数量 
	 */
	public void setFinishNum(Integer finishNum) {
		this.finishNum = finishNum;
	}

	/**
	 * Gets the 未完成数量 .
	 *
	 * @return the 未完成数量 
	 */
	public Integer getUnfinishNum() {
		return unfinishNum;
	}

	/**
	 * Sets the 未完成数量 .
	 *
	 * @param unfinishNum the new 未完成数量 
	 */
	public void setUnfinishNum(Integer unfinishNum) {
		this.unfinishNum = unfinishNum;
	}

	/**
	 * Gets the 击败数量 .
	 *
	 * @return the 击败数量 
	 */
	public Integer getDefeatNum() {
		return defeatNum;
	}

	/**
	 * Sets the 击败数量 .
	 *
	 * @param defeatNum the new 击败数量 
	 */
	public void setDefeatNum(Integer defeatNum) {
		this.defeatNum = defeatNum;
	}

	/**
	 * Gets the 工作是否完成 是：Y 否：N .
	 *
	 * @return the 工作是否完成 是：Y 否：N 
	 */
	public String getFinish() {
		return finish;
	}

	/**
	 * Sets the 工作是否完成 是：Y 否：N .
	 *
	 * @param finish the new 工作是否完成 是：Y 否：N 
	 */
	public void setFinish(String finish) {
		this.finish = finish;
	}

	/**
	 * Gets the 标题 .
	 *
	 * @return the 标题 
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the 标题 .
	 *
	 * @param title the new 标题 
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the 描述 .
	 *
	 * @return the 描述 
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Sets the 描述 .
	 *
	 * @param desc the new 描述 
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * Gets the 任务类型 客户沟通：GOU_TONG 销售目标：XIAO_SHOU 新增客户：XIN_ZENG 社交任务：SHE_JIAO .
	 *
	 * @return the 任务类型 客户沟通：GOU_TONG 销售目标：XIAO_SHOU 新增客户：XIN_ZENG 社交任务：SHE_JIAO 
	 */
	public String getTaskType() {
		return taskType;
	}

	/**
	 * Sets the 任务类型 客户沟通：GOU_TONG 销售目标：XIAO_SHOU 新增客户：XIN_ZENG 社交任务：SHE_JIAO .
	 *
	 * @param taskType the new 任务类型 客户沟通：GOU_TONG 销售目标：XIAO_SHOU 新增客户：XIN_ZENG 社交任务：SHE_JIAO 
	 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindWorkTaskMainListReturn [code=").append(code)
				.append(", codeList=").append(codeList).append(", nameList=")
				.append(nameList).append(", requireNum=").append(requireNum)
				.append(", finishNum=").append(finishNum)
				.append(", unfinishNum=").append(unfinishNum)
				.append(", defeatNum=").append(defeatNum).append(", finish=")
				.append(finish).append(", title=").append(title)
				.append(", desc=").append(desc).append(", taskType=")
				.append(taskType).append(", taskUnit=").append(taskUnit)
				.append("]");
		return builder.toString();
	}

	/**
	 * Gets the 任务单位.
	 *
	 * @return the 任务单位
	 */
	public String getTaskUnit() {
		return taskUnit;
	}

	/**
	 * Sets the 任务单位.
	 *
	 * @param taskUnit the new 任务单位
	 */
	public void setTaskUnit(String taskUnit) {
		this.taskUnit = taskUnit;
	}

	
}
