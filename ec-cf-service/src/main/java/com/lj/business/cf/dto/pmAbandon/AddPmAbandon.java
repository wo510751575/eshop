package com.lj.business.cf.dto.pmAbandon;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class AddPmAbandon.
 */
public class AddPmAbandon implements Serializable{
	   
   	/** Generate cron. */
	private static final long serialVersionUID = -6342088807094601043L;


	/**
     * CODE .
     */
    private String code;

    
    /** 商户编号. */
    private String merchantNo;
    
    /**
     * 导购编号 .
     */
    private String memberNoGm;

	/**
     * 导购姓名 .
     */
    private String memberNameGm;
    
    
    /**
     * 客户编号 .
     */
    private String memberNo;

    /**
     * 客户名称 .
     */
    private String memberName;
    
    
    /** 审批人会员编号. */
    private String memberNoCheck;

    
    /**
     * 跟踪总表编号
     */
    private String cfNo;

    /**
     * 放弃原因 .
     */
    private String resean;

    /**
     * 回访时间 .
     */
    private Date followDate;

    /**
     * 审批时间 .
     */
    private Date checkDate;

    /**
     * 审批人 .
     */
    private String checker;

    /**
     * 审批说明 .
     */
    private String checkDes;

    /**
     * 备注 .
     */
    private String remark;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;

    /**
     * 更新人 .
     */
    private String updateId;

    /**
     * 更新时间 .
     */
    private Date updateDate;
    
    /**
     * 审批结果
     */
    private String checkResult;
    
    /**
     * 产品code
     */
    private String bomCode;
    
    /**
     * 产品名称
     */
    private String bomName;

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
     * 导购编号 .
     *
     * @return the 导购编号 
     */
    public String getMemberNoGm() {
        return memberNoGm;
    }

    /**
     * 导购编号 .
     *
     * @param memberNoGm the new 导购编号 
     */
    public void setMemberNoGm(String memberNoGm) {
        this.memberNoGm = memberNoGm == null ? null : memberNoGm.trim();
    }

    /**
     * 导购姓名 .
     *
     * @return the 导购姓名 
     */
    public String getMemberNameGm() {
        return memberNameGm;
    }

    /**
     * 导购姓名 .
     *
     * @param memberNameGm the new 导购姓名 
     */
    public void setMemberNameGm(String memberNameGm) {
        this.memberNameGm = memberNameGm == null ? null : memberNameGm.trim();
    }

    /**
     * 放弃原因 .
     *
     * @return the 放弃原因 
     */
    public String getResean() {
        return resean;
    }

    /**
     * 放弃原因 .
     *
     * @param resean the new 放弃原因 
     */
    public void setResean(String resean) {
        this.resean = resean == null ? null : resean.trim();
    }

    /**
     * 回访时间 .
     *
     * @return the 回访时间 
     */
    public Date getFollowDate() {
        return followDate;
    }

    /**
     * 回访时间 .
     *
     * @param followDate the new 回访时间 
     */
    public void setFollowDate(Date followDate) {
        this.followDate = followDate;
    }

    /**
     * 审批时间 .
     *
     * @return the 审批时间 
     */
    public Date getCheckDate() {
        return checkDate;
    }

    /**
     * 审批时间 .
     *
     * @param checkDate the new 审批时间 
     */
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * 审批人 .
     *
     * @return the 审批人 
     */
    public String getChecker() {
        return checker;
    }

    /**
     * 审批人 .
     *
     * @param checker the new 审批人 
     */
    public void setChecker(String checker) {
        this.checker = checker == null ? null : checker.trim();
    }

    /**
     * 审批说明 .
     *
     * @return the 审批说明 
     */
    public String getCheckDes() {
        return checkDes;
    }

    /**
     * 审批说明 .
     *
     * @param checkDes the new 审批说明 
     */
    public void setCheckDes(String checkDes) {
        this.checkDes = checkDes == null ? null : checkDes.trim();
    }

    /**
     * 备注 .
     *
     * @return the 备注 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注 .
     *
     * @param remark the new 备注 
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 创建人 .
     *
     * @return the 创建人 
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人 .
     *
     * @param createId the new 创建人 
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
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

    /**
     * 更新人 .
     *
     * @return the 更新人 
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     * 更新人 .
     *
     * @param updateId the new 更新人 
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    /**
     * 更新时间 .
     *
     * @return the 更新时间 
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 更新时间 .
     *
     * @param updateDate the new 更新时间 
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    
    /**
     * Gets the 商户编号.
     *
     * @return the 商户编号
     */
    public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户编号.
	 *
	 * @param merchantNo the new 商户编号
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the 审批人会员编号.
	 *
	 * @return the 审批人会员编号
	 */
	public String getMemberNoCheck() {
		return memberNoCheck;
	}

	/**
	 * Sets the 审批人会员编号.
	 *
	 * @param memberNoCheck the new 审批人会员编号
	 */
	public void setMemberNoCheck(String memberNoCheck) {
		this.memberNoCheck = memberNoCheck;
	}

	
    public String getCfNo() {
		return cfNo;
	}

	public void setCfNo(String cfNo) {
		this.cfNo = cfNo;
	}
	
    public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}
	
	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String getBomCode() {
		return bomCode;
	}

	public void setBomCode(String bomCode) {
		this.bomCode = bomCode;
	}

	public String getBomName() {
		return bomName;
	}

	public void setBomName(String bomName) {
		this.bomName = bomName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddPmAbandon [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", memberNo=").append(memberNo).append(", memberName=")
				.append(memberName).append(", memberNoCheck=")
				.append(memberNoCheck).append(", cfNo=").append(cfNo)
				.append(", resean=").append(resean).append(", followDate=")
				.append(followDate).append(", checkDate=").append(checkDate)
				.append(", checker=").append(checker).append(", checkDes=")
				.append(checkDes).append(", remark=").append(remark)
				.append(", createId=").append(createId).append(", createDate=")
				.append(createDate).append(", updateId=").append(updateId)
				.append(", updateDate=").append(updateDate)
				.append(", checkResult=").append(checkResult)
				.append(", bomCode=").append(bomCode).append(", bomName=")
				.append(bomName).append("]");
		return builder.toString();
	}

}
