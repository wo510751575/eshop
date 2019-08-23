package com.lj.business.cf.dto;

import java.io.Serializable;
import java.util.Date;

import com.lj.business.cf.emus.TaskType;

/**
 * 类说明：更新工作任务数量
 * <p>
 * <p>
 * <p>
 * 详细描述：.
 *
 * @author 武鹏飞
 * <p>
 * CreateDate: 2017年7月25日
 * @Company: 领居科技有限公司
 */
public class UpdateWorkTaskFinishNum implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -2439399110811216769L;

    /**
     * 商户编号(必填)  .
     */
    private String merchantNo;

    /**
     * 分店编号 .
     */
    private String shopNo;

    /**
     * 导购编号(必填)  .
     */
    private String memberNoGm;

    /**
     * 项目CODE .
     */
    private String codeList;

    /**
     * 工作日期 .
     */
    private Date workDate;

    /**
     * 完成数量 .
     */
    private Long finishNum;

    /** 需要的数量. */
    private Long requireNum;
    
    /** 任务类型(必填). */
    private TaskType taskType;

    /**
     * Gets the 商户编号(必填)  .
     *
     * @return the 商户编号(必填)  
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * Sets the 商户编号(必填)  .
     *
     * @param merchantNo the new 商户编号(必填)  
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    /**
     * Gets the 分店编号 .
     *
     * @return the 分店编号 
     */
    public String getShopNo() {
        return shopNo;
    }

    /**
     * Sets the 分店编号 .
     *
     * @param shopNo the new 分店编号 
     */
    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    /**
     * Gets the 导购编号(必填)  .
     *
     * @return the 导购编号(必填)  
     */
    public String getMemberNoGm() {
        return memberNoGm;
    }

    /**
     * Sets the 导购编号(必填)  .
     *
     * @param memberNoGm the new 导购编号(必填)  
     */
    public void setMemberNoGm(String memberNoGm) {
        this.memberNoGm = memberNoGm;
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
     * Gets the 工作日期 .
     *
     * @return the 工作日期 
     */
    public Date getWorkDate() {
        return workDate;
    }

    /**
     * Sets the 工作日期 .
     *
     * @param workDate the new 工作日期 
     */
    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    /**
     * Gets the 完成数量 .
     *
     * @return the 完成数量 
     */
    public Long getFinishNum() {
        return finishNum;
    }

    /**
     * Sets the 完成数量 .
     *
     * @param finishNum the new 完成数量 
     */
    public void setFinishNum(Long finishNum) {
        this.finishNum = finishNum;
    }

    /**
     * Gets the 需要的数量.
     *
     * @return the 需要的数量
     */
    public Long getRequireNum() {
        return requireNum;
    }

    /**
     * Sets the 需要的数量.
     *
     * @param requireNum the new 需要的数量
     */
    public void setRequireNum(Long requireNum) {
        this.requireNum = requireNum;
    }

	/**
	 * Gets the 任务类型(必填).
	 *
	 * @return the 任务类型(必填)
	 */
	public TaskType getTaskType() {
		return taskType;
	}

	/**
	 * Sets the 任务类型(必填).
	 *
	 * @param taskType the new 任务类型(必填)
	 */
	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateWorkTaskFinishNum [merchantNo=")
				.append(merchantNo).append(", shopNo=").append(shopNo)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", codeList=").append(codeList).append(", workDate=")
				.append(workDate).append(", finishNum=").append(finishNum)
				.append(", requireNum=").append(requireNum)
				.append(", taskType=").append(taskType).append("]");
		return builder.toString();
	}
}
