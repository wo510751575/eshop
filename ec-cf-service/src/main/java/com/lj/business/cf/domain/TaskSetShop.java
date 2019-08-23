package com.lj.business.cf.domain;

import java.util.Date;

/**
 * 
 * 
 * 类说明：店长任务设置表
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 冯辉
 *   
 * CreateDate: 2017年7月19日
 */
public class TaskSetShop {
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
     * 任务单位             个：GE             元：YUAN .
     */
    private String taskUnit;

    /**
     * 任务类型             销售目标：XIAO_SHOU             新增客户：XIN_ZENG             其他任务：OTHER .
     */
    private String taskType;

    /**
     * 维度             店长：SHOP             商户：MERCHANT              .
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
    
    /**
     * 月数量
     */
    private Long numMonth;
    
    /**
     * 分店编号
     */
    private String shopNo;
    
    /**
     * 分店姓名
     */
    private String shopName;

    /**
     * CODE .
     *
     */
    public String getCode() {
        return code;
    }

    /**
     * CODE .
     *
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 商户编号 .
     *
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 商户编号 .
     *
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 店长编号 .
     *
     */
    public String getMemberNoSp() {
        return memberNoSp;
    }

    /**
     * 店长编号 .
     *
     */
    public void setMemberNoSp(String memberNoSp) {
        this.memberNoSp = memberNoSp == null ? null : memberNoSp.trim();
    }

    /**
     * 店长姓名 .
     *
     */
    public String getMemberNameSp() {
        return memberNameSp;
    }

    /**
     * 店长姓名 .
     *
     */
    public void setMemberNameSp(String memberNameSp) {
        this.memberNameSp = memberNameSp == null ? null : memberNameSp.trim();
    }

    /**
     * 任务开始时间 .
     *
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 任务开始时间 .
     *
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 任务结束时间 .
     *
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 任务结束时间 .
     *
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 任务名称 .
     *
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 任务名称 .
     *
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * 任务单位             个：GE             元：YUAN .
     *
     */
    public String getTaskUnit() {
        return taskUnit;
    }

    /**
     * 任务单位             个：GE             元：YUAN .
     *
     */
    public void setTaskUnit(String taskUnit) {
        this.taskUnit = taskUnit == null ? null : taskUnit.trim();
    }

    /**
     * 任务类型             销售目标：XIAO_SHOU             新增客户：XIN_ZENG             其他任务：OTHER .
     *
     */
    public String getTaskType() {
        return taskType;
    }

    /**
     * 任务类型             销售目标：XIAO_SHOU             新增客户：XIN_ZENG             其他任务：OTHER .
     *
     */
    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    /**
     * 维度             店长：SHOP             商户：MERCHANT              .
     *
     */
    public String getDimension() {
        return dimension;
    }

    /**
     * 维度             店长：SHOP             商户：MERCHANT              .
     *
     */
    public void setDimension(String dimension) {
        this.dimension = dimension == null ? null : dimension.trim();
    }

    /**
     * 项目CODE .
     *
     */
    public String getCodeList() {
        return codeList;
    }

    /**
     * 项目CODE .
     *
     */
    public void setCodeList(String codeList) {
        this.codeList = codeList == null ? null : codeList.trim();
    }

    /**
     * 创建人 .
     *
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人 .
     *
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * 创建时间 .
     *
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间 .
     *
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 备注 .
     *
     */
    public String getRemark4() {
        return remark4;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
    }

    /**
     * 备注 .
     *
     */
    public String getRemark3() {
        return remark3;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    /**
     * 备注 .
     *
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    /**
     * 备注 .
     *
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getNumMonth() {
		return numMonth;
	}

	public void setNumMonth(Long numMonth) {
		this.numMonth = numMonth;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TaskSetShop [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", memberNoSp=").append(memberNoSp)
				.append(", memberNameSp=").append(memberNameSp)
				.append(", startDate=").append(startDate).append(", endDate=")
				.append(endDate).append(", taskName=").append(taskName)
				.append(", taskUnit=").append(taskUnit).append(", taskType=")
				.append(taskType).append(", dimension=").append(dimension)
				.append(", codeList=").append(codeList).append(", createId=")
				.append(createId).append(", createDate=").append(createDate)
				.append(", remark4=").append(remark4).append(", remark3=")
				.append(remark3).append(", remark2=").append(remark2)
				.append(", remark=").append(remark).append(", numMonth=")
				.append(numMonth).append(", shopNo=").append(shopNo)
				.append(", shopName=").append(shopName).append("]");
		return builder.toString();
	}

}