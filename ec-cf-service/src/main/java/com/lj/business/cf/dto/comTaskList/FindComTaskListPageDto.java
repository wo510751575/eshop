package com.lj.business.cf.dto.comTaskList;

import java.util.Date;

import com.lj.base.core.pagination.PageParamEntity;

/**
 * The Class FindComTaskListPageDto.
 */
public class FindComTaskListPageDto extends PageParamEntity{
     
     /** Generate cron. */
	private static final long serialVersionUID = -8122729571746154882L;

	/**
     * CODE .
     */
    private String code;
    
    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 项目名称 .
     */
    private String nameList;

    /**
     * 项目描述 .
     */
    private String desList;
    
    /**
     * 沟通任务类型 完善资料：IMPROVE 其他：OTHER .
     */
    private String comTaskType;

    /**
     * 状态 
             启用：Y
             停用：N
              .
     */
    private String status;

    /**
     * 创建时间 .
     */
    private Date createDate;

    /**
     * CODE .
     *
     * @return the cODE 
     */
    public String getCode() {
        return code;
    }

    /**
     * CODE .
     *
     * @param code the new cODE 
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 项目名称 .
     *
     * @return the 项目名称 
     */
    public String getNameList() {
        return nameList;
    }

    /**
     * 项目名称 .
     *
     * @param nameList the new 项目名称 
     */
    public void setNameList(String nameList) {
        this.nameList = nameList == null ? null : nameList.trim();
    }

    /**
     * 项目描述 .
     *
     * @return the 项目描述 
     */
    public String getDesList() {
        return desList;
    }

    /**
     * 项目描述 .
     *
     * @param desList the new 项目描述 
     */
    public void setDesList(String desList) {
        this.desList = desList == null ? null : desList.trim();
    }

    /**
     * 状态
     * 启用：Y
     * 停用：N
     * .
     *
     * @return the 状态 启用：Y 停用：N 
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态
     * 启用：Y
     * 停用：N
     * .
     *
     * @param status the new 状态 启用：Y 停用：N 
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 创建时间 .
     *
     * @return the 创建时间 
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间 .
     *
     * @param createDate the new 创建时间 
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindComTaskListPageDto [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", nameList=").append(nameList).append(", desList=")
				.append(desList).append(", comTaskType=").append(comTaskType)
				.append(", status=").append(status).append(", createDate=")
				.append(createDate).append("]");
		return builder.toString();
	}

	/**
	 * Gets the 沟通任务类型 完善资料：IMPROVE 其他：OTHER .
	 *
	 * @return the 沟通任务类型 完善资料：IMPROVE 其他：OTHER 
	 */
	public String getComTaskType() {
		return comTaskType;
	}

	/**
	 * Sets the 沟通任务类型 完善资料：IMPROVE 其他：OTHER .
	 *
	 * @param comTaskType the new 沟通任务类型 完善资料：IMPROVE 其他：OTHER 
	 */
	public void setComTaskType(String comTaskType) {
		this.comTaskType = comTaskType;
	}

	/**
	 * Gets the 商户编号 .
	 *
	 * @return the 商户编号 
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户编号 .
	 *
	 * @param merchantNo the new 商户编号 
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	
}
