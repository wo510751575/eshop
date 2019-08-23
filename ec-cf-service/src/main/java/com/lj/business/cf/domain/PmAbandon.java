package com.lj.business.cf.domain;

import java.util.Date;


// TODO: Auto-generated Javadoc
/**
 * The Class PmAbandon.
 */
/**
 * 
 * 
 * 类说明：客户放弃表
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年7月12日
 */
public class PmAbandon {
    /**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
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
     * 审批人编号 .
     */
    private String memberNoCheck;

    /**
     * 审批人姓名 .
     */
    private String checker;

    /**
     * 审批说明 .
     */
    private String checkDes;

    /**
     * 审批结果             等待审批：WAIT             同意：Y             拒绝：N              .
     */
    private String checkResult;
    
    /** 跟踪总表编号. */
    private String cfNo;

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
    
    /** 产品code. */
    private String bomCode;
    
    /** 产品名称. */
    private String bomName;
    

    /**
     * CODE .
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * CODE .
     *
     * @param code the new code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 商户编号 .
     *
     * @return the merchant no
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 商户编号 .
     *
     * @param merchantNo the new merchant no
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 导购编号 .
     *
     * @return the member no gm
     */
    public String getMemberNoGm() {
        return memberNoGm;
    }

    /**
     * 导购编号 .
     *
     * @param memberNoGm the new member no gm
     */
    public void setMemberNoGm(String memberNoGm) {
        this.memberNoGm = memberNoGm == null ? null : memberNoGm.trim();
    }

    /**
     * 导购姓名 .
     *
     * @return the member name gm
     */
    public String getMemberNameGm() {
        return memberNameGm;
    }

    /**
     * 导购姓名 .
     *
     * @param memberNameGm the new member name gm
     */
    public void setMemberNameGm(String memberNameGm) {
        this.memberNameGm = memberNameGm == null ? null : memberNameGm.trim();
    }

    /**
     * 放弃原因 .
     *
     * @return the resean
     */
    public String getResean() {
        return resean;
    }

    /**
     * 放弃原因 .
     *
     * @param resean the new resean
     */
    public void setResean(String resean) {
        this.resean = resean == null ? null : resean.trim();
    }

    /**
     * 回访时间 .
     *
     * @return the follow date
     */
    public Date getFollowDate() {
        return followDate;
    }

    /**
     * 回访时间 .
     *
     * @param followDate the new follow date
     */
    public void setFollowDate(Date followDate) {
        this.followDate = followDate;
    }

    /**
     * 审批时间 .
     *
     * @return the check date
     */
    public Date getCheckDate() {
        return checkDate;
    }

    /**
     * 审批时间 .
     *
     * @param checkDate the new check date
     */
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * 审批人编号 .
     *
     * @return the member no check
     */
    public String getMemberNoCheck() {
        return memberNoCheck;
    }

    /**
     * 审批人编号 .
     *
     * @param memberNoCheck the new member no check
     */
    public void setMemberNoCheck(String memberNoCheck) {
        this.memberNoCheck = memberNoCheck == null ? null : memberNoCheck.trim();
    }

    /**
     * 审批人姓名 .
     *
     * @return the checker
     */
    public String getChecker() {
        return checker;
    }

    /**
     * 审批人姓名 .
     *
     * @param checker the new checker
     */
    public void setChecker(String checker) {
        this.checker = checker == null ? null : checker.trim();
    }

    /**
     * 审批说明 .
     *
     * @return the check des
     */
    public String getCheckDes() {
        return checkDes;
    }

    /**
     * 审批说明 .
     *
     * @param checkDes the new check des
     */
    public void setCheckDes(String checkDes) {
        this.checkDes = checkDes == null ? null : checkDes.trim();
    }

    /**
     * 是否成单
     *              等待审批：WAIT
     *              同意：Y
     *              拒绝：N
     *               .
     *
     * @return the check result
     */
    public String getCheckResult() {
        return checkResult;
    }

    /**
     * 是否成单
     *              等待审批：WAIT
     *              同意：Y
     *              拒绝：N
     *               .
     *
     * @param checkResult the new check result
     */
    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult == null ? null : checkResult.trim();
    }

    /**
     * 备注 .
     *
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注 .
     *
     * @param remark the new remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 创建人 .
     *
     * @return the creates the id
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人 .
     *
     * @param createId the new creates the id
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * 创建时间 .
     *
     * @return the creates the date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间 .
     *
     * @param createDate the new creates the date
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 更新人 .
     *
     * @return the update id
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     * 更新人 .
     *
     * @param updateId the new update id
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    /**
     * 更新时间 .
     *
     * @return the update date
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 更新时间 .
     *
     * @param updateDate the new update date
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 备注 .
     *
     * @return the remark 4
     */
    public String getRemark4() {
        return remark4;
    }

    /**
     * 备注 .
     *
     * @param remark4 the new remark 4
     */
    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
    }

    /**
     * 备注 .
     *
     * @return the remark 3
     */
    public String getRemark3() {
        return remark3;
    }

    /**
     * 备注 .
     *
     * @param remark3 the new remark 3
     */
    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    /**
     * 备注 .
     *
     * @return the remark 2
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * 备注 .
     *
     * @param remark2 the new remark 2
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }
	
	/**
	 * Gets the cf no.
	 *
	 * @return the cf no
	 */
	public String getCfNo() {
		return cfNo;
	}

	/**
	 * Sets the cf no.
	 *
	 * @param cfNo the new cf no
	 */
	public void setCfNo(String cfNo) {
		this.cfNo = cfNo;
	}
	
	/**
	 * Gets the member no.
	 *
	 * @return the member no
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the member no.
	 *
	 * @param memberNo the new member no
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the member name.
	 *
	 * @return the member name
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * Sets the member name.
	 *
	 * @param memberName the new member name
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	/**
	 * Gets the bom code.
	 *
	 * @return the bom code
	 */
	public String getBomCode() {
		return bomCode;
	}

	/**
	 * Sets the bom code.
	 *
	 * @param bomCode the new bom code
	 */
	public void setBomCode(String bomCode) {
		this.bomCode = bomCode;
	}

	/**
	 * Gets the bom name.
	 *
	 * @return the bom name
	 */
	public String getBomName() {
		return bomName;
	}

	/**
	 * Sets the bom name.
	 *
	 * @param bomName the new bom name
	 */
	public void setBomName(String bomName) {
		this.bomName = bomName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PmAbandon [code=").append(code).append(", merchantNo=")
				.append(merchantNo).append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", memberNo=").append(memberNo).append(", memberName=")
				.append(memberName).append(", resean=").append(resean)
				.append(", followDate=").append(followDate)
				.append(", checkDate=").append(checkDate)
				.append(", memberNoCheck=").append(memberNoCheck)
				.append(", checker=").append(checker).append(", checkDes=")
				.append(checkDes).append(", checkResult=").append(checkResult)
				.append(", cfNo=").append(cfNo).append(", remark=")
				.append(remark).append(", createId=").append(createId)
				.append(", createDate=").append(createDate)
				.append(", updateId=").append(updateId).append(", updateDate=")
				.append(updateDate).append(", remark4=").append(remark4)
				.append(", remark3=").append(remark3).append(", remark2=")
				.append(remark2).append(", bomCode=").append(bomCode)
				.append(", bomName=").append(bomName).append("]");
		return builder.toString();
	}

}