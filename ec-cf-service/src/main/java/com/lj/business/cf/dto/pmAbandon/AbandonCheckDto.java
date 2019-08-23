package com.lj.business.cf.dto.pmAbandon;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class AbandonCheckDto.
 */
public class AbandonCheckDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3392035395795360785L;
	
	/** 人员类型  店长：SHOP 老板：BOSS(必填). */
	private String memberType;
	
	/** 跟踪记录放弃表code(必填). */
	private String code;
    
    /** 审批结果 Y-同意  N-拒绝(必填). */
    private String checkResult;
    
    /** 审批说明. */
    private String checkDes;
    
    /**
     * 审批人编号 .(必填)
     */
    private String memberNoCheck;

    /**
     * 审批人姓名 .(必填)
     */
    private String checker;
    
    /** 跟进编号(必填). */
    private String cfNo;
    
    /** 分店编号. */
    private String shopNo;
    
    /** 区域编号. */
    private String areaCode;

	/**
	 * Gets the member type.
	 *
	 * @return the member type
	 */
	public String getMemberType() {
		return memberType;
	}

	/**
	 * Sets the member type.
	 *
	 * @param memberType the new member type
	 */
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

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
	 * Gets the check result.
	 *
	 * @return the check result
	 */
	public String getCheckResult() {
		return checkResult;
	}

	/**
	 * Sets the check result.
	 *
	 * @param checkResult the new check result
	 */
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}
	
	/**
	 * Gets the check des.
	 *
	 * @return the check des
	 */
	public String getCheckDes() {
		return checkDes;
	}

	/**
	 * Sets the check des.
	 *
	 * @param checkDes the new check des
	 */
	public void setCheckDes(String checkDes) {
		this.checkDes = checkDes;
	}

	/**
	 * Gets the member no check.
	 *
	 * @return the member no check
	 */
	public String getMemberNoCheck() {
		return memberNoCheck;
	}

	/**
	 * Sets the member no check.
	 *
	 * @param memberNoCheck the new member no check
	 */
	public void setMemberNoCheck(String memberNoCheck) {
		this.memberNoCheck = memberNoCheck;
	}

	/**
	 * Gets the checker.
	 *
	 * @return the checker
	 */
	public String getChecker() {
		return checker;
	}

	/**
	 * Sets the checker.
	 *
	 * @param checker the new checker
	 */
	public void setChecker(String checker) {
		this.checker = checker;
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
	 * Gets the shop no.
	 *
	 * @return the shop no
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * Sets the shop no.
	 *
	 * @param shopNo the new shop no
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/**
	 * Gets the area code.
	 *
	 * @return the area code
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * Sets the area code.
	 *
	 * @param areaCode the new area code
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbandonCheckDto [memberType=").append(memberType)
				.append(", code=").append(code).append(", checkResult=")
				.append(checkResult).append(", checkDes=").append(checkDes)
				.append(", memberNoCheck=").append(memberNoCheck)
				.append(", checker=").append(checker).append(", cfNo=")
				.append(cfNo).append(", shopNo=").append(shopNo)
				.append(", areaCode=").append(areaCode).append("]");
		return builder.toString();
	}

}
