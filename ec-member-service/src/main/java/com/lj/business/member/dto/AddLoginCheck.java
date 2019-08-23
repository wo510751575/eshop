package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class AddLoginCheck.
 */
public class AddLoginCheck implements Serializable { 

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4924036290293513865L;

	/**
     *  .
     */
    private String code;

    /**
     * 编号 .
     */
    private String memberNo;

    /**
     * 会员类型
             店长：SHOP
             老板：BOSS .
     */
    private String memberType;

    /**
     * 会员锁定状态:
             NORMAL 正常,未锁定;
             AUTOLOCK密码输入错误超过次数,自动锁定会员;
             MANUALLOCK人工锁定
              .
     */
    private String lockStatus;

    /**
     * 上次登录成功时间 .
     */
    private Date lastLoginDate;

    /**
     * 周期内登录失败次数 .
     */
    private Integer cycleLoginFailTimes;

    /**
     * 最近一次密码错误时间 .
     */
    private Date lastLoginErrorDate;

    /**
     * 更新人 .
     */
    private String updateId;

    /**
     * 更新时间 .
     */
    private Date updateDate;


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
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the 编号 .
	 *
	 * @return the memberNo
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 编号 .
	 *
	 * @param memberNo the memberNo to set
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * Gets the 会员类型 店长：SHOP 老板：BOSS .
	 *
	 * @return the memberType
	 */
	public String getMemberType() {
		return memberType;
	}

	/**
	 * Sets the 会员类型 店长：SHOP 老板：BOSS .
	 *
	 * @param memberType the memberType to set
	 */
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	/**
	 * Gets the 会员锁定状态: NORMAL 正常,未锁定; AUTOLOCK密码输入错误超过次数,自动锁定会员; MANUALLOCK人工锁定 .
	 *
	 * @return the lockStatus
	 */
	public String getLockStatus() {
		return lockStatus;
	}

	/**
	 * Sets the 会员锁定状态: NORMAL 正常,未锁定; AUTOLOCK密码输入错误超过次数,自动锁定会员; MANUALLOCK人工锁定 .
	 *
	 * @param lockStatus the lockStatus to set
	 */
	public void setLockStatus(String lockStatus) {
		this.lockStatus = lockStatus;
	}

	/**
	 * Gets the 上次登录成功时间 .
	 *
	 * @return the lastLoginDate
	 */
	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	/**
	 * Sets the 上次登录成功时间 .
	 *
	 * @param lastLoginDate the lastLoginDate to set
	 */
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	/**
	 * Gets the 周期内登录失败次数 .
	 *
	 * @return the cycleLoginFailTimes
	 */
	public Integer getCycleLoginFailTimes() {
		return cycleLoginFailTimes;
	}

	/**
	 * Sets the 周期内登录失败次数 .
	 *
	 * @param cycleLoginFailTimes the cycleLoginFailTimes to set
	 */
	public void setCycleLoginFailTimes(Integer cycleLoginFailTimes) {
		this.cycleLoginFailTimes = cycleLoginFailTimes;
	}

	/**
	 * Gets the 最近一次密码错误时间 .
	 *
	 * @return the lastLoginErrorDate
	 */
	public Date getLastLoginErrorDate() {
		return lastLoginErrorDate;
	}

	/**
	 * Sets the 最近一次密码错误时间 .
	 *
	 * @param lastLoginErrorDate the lastLoginErrorDate to set
	 */
	public void setLastLoginErrorDate(Date lastLoginErrorDate) {
		this.lastLoginErrorDate = lastLoginErrorDate;
	}

	/**
	 * Gets the 更新人 .
	 *
	 * @return the updateId
	 */
	public String getUpdateId() {
		return updateId;
	}

	/**
	 * Sets the 更新人 .
	 *
	 * @param updateId the updateId to set
	 */
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	/**
	 * Gets the 更新时间 .
	 *
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * Sets the 更新时间 .
	 *
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
    
    
}
