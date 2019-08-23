package com.lj.business.cf.dto.taskSetShop;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdateTaskSetShop.
 */
public class UpdateTaskSetShop implements Serializable { 

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5474220102619532041L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 店长编号 .
     */
    private String memberNoSp;

    /**
     * 店长姓名 .
     */
    private String memberNameSp;
    
    /** 分店编号. */
    private String shopNo;
    
    /** 分店姓名. */
    private String shopName;

    /**
     * 任务开始时间 .
     */
    private Date startDate;

    /**
     * 任务结束时间 .
     */
    private Date endDate;

    /**
     * 任务名称 .
     */
    private String taskName;

    /**
     * 任务单位
             个：GE
             元：YUAN .
     */
    private String taskUnit;

    /**
     * 任务类型
             销售目标：XIAO_SHOU
             新增客户：XIN_ZENG
             其他任务：OTHER .
     */
    private String taskType;

    /**
     * 维度
             店长：SHOP
             商户：MERCHANT
              .
     */
    private String dimension;

    /**
     * 项目CODE .
     */
    private String codeList;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;

    /**
     * 备注 .
     */
    private String remark4;

    /**
     * 备注 .
     */
    private String remark3;

    /**
     * 备注 .
     */
    private String remark2;

    /**
     * 备注 .
     */
    private String remark;

    /** 月数量. */
    private Long numMonth;
    
	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the merchant no.
	 *
	 * @return the merchant no
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the merchant no.
	 *
	 * @param merchantNo the new merchant no
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the member no sp.
	 *
	 * @return the member no sp
	 */
	public String getMemberNoSp() {
		return memberNoSp;
	}

	/**
	 * Sets the member no sp.
	 *
	 * @param memberNoSp the new member no sp
	 */
	public void setMemberNoSp(String memberNoSp) {
		this.memberNoSp = memberNoSp;
	}

	/**
	 * Gets the member name sp.
	 *
	 * @return the member name sp
	 */
	public String getMemberNameSp() {
		return memberNameSp;
	}

	/**
	 * Sets the member name sp.
	 *
	 * @param memberNameSp the new member name sp
	 */
	public void setMemberNameSp(String memberNameSp) {
		this.memberNameSp = memberNameSp;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the task name.
	 *
	 * @return the task name
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * Sets the task name.
	 *
	 * @param taskName the new task name
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * Gets the task unit.
	 *
	 * @return the task unit
	 */
	public String getTaskUnit() {
		return taskUnit;
	}

	/**
	 * Sets the task unit.
	 *
	 * @param taskUnit the new task unit
	 */
	public void setTaskUnit(String taskUnit) {
		this.taskUnit = taskUnit;
	}

	/**
	 * Gets the task type.
	 *
	 * @return the task type
	 */
	public String getTaskType() {
		return taskType;
	}

	/**
	 * Sets the task type.
	 *
	 * @param taskType the new task type
	 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	/**
	 * Gets the dimension.
	 *
	 * @return the dimension
	 */
	public String getDimension() {
		return dimension;
	}

	/**
	 * Sets the dimension.
	 *
	 * @param dimension the new dimension
	 */
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	/**
	 * Gets the code list.
	 *
	 * @return the code list
	 */
	public String getCodeList() {
		return codeList;
	}

	/**
	 * Sets the code list.
	 *
	 * @param codeList the new code list
	 */
	public void setCodeList(String codeList) {
		this.codeList = codeList;
	}

	/**
	 * Gets the creates the id.
	 *
	 * @return the creates the id
	 */
	public String getCreateId() {
		return createId;
	}

	/**
	 * Sets the creates the id.
	 *
	 * @param createId the new creates the id
	 */
	public void setCreateId(String createId) {
		this.createId = createId;
	}

	/**
	 * Gets the creates the date.
	 *
	 * @return the creates the date
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the creates the date.
	 *
	 * @param createDate the new creates the date
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * Gets the remark 4.
	 *
	 * @return the remark 4
	 */
	public String getRemark4() {
		return remark4;
	}

	/**
	 * Sets the remark 4.
	 *
	 * @param remark4 the new remark 4
	 */
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	/**
	 * Gets the remark 3.
	 *
	 * @return the remark 3
	 */
	public String getRemark3() {
		return remark3;
	}

	/**
	 * Sets the remark 3.
	 *
	 * @param remark3 the new remark 3
	 */
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	/**
	 * Gets the remark 2.
	 *
	 * @return the remark 2
	 */
	public String getRemark2() {
		return remark2;
	}

	/**
	 * Sets the remark 2.
	 *
	 * @param remark2 the new remark 2
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	/**
	 * Gets the remark.
	 *
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the remark.
	 *
	 * @param remark the new remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getShopNo() {
		return shopNo;
	}

	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Long getNumMonth() {
		return numMonth;
	}

	public void setNumMonth(Long numMonth) {
		this.numMonth = numMonth;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateTaskSetShop [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", memberNoSp=").append(memberNoSp)
				.append(", memberNameSp=").append(memberNameSp)
				.append(", shopNo=").append(shopNo).append(", shopName=")
				.append(shopName).append(", startDate=").append(startDate)
				.append(", endDate=").append(endDate).append(", taskName=")
				.append(taskName).append(", taskUnit=").append(taskUnit)
				.append(", taskType=").append(taskType).append(", dimension=")
				.append(dimension).append(", codeList=").append(codeList)
				.append(", createId=").append(createId).append(", createDate=")
				.append(createDate).append(", remark4=").append(remark4)
				.append(", remark3=").append(remark3).append(", remark2=")
				.append(remark2).append(", remark=").append(remark)
				.append(", numMonth=").append(numMonth).append("]");
		return builder.toString();
	}

}
