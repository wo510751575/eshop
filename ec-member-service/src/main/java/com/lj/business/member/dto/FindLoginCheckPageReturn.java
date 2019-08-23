package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class FindLoginCheckPageReturn.
 */
public class FindLoginCheckPageReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1791643619248015296L; 
	 /**
     * CODE .
     */
    private String code;

    /**
     * 登录编号 .
     */
    private String memberNo;

    /**
     * 登录类型
             店长：SHOP
             老板：BOSS
             导购：GUID
             客户：PM .
     */
    private String memberType;

    /**
     * 锁定状态:
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
     * 登录编号 .
     *
     * @return the 登录编号 
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * 登录编号 .
     *
     * @param memberNo the new 登录编号 
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     * 登录类型
     * 店长：SHOP
     * 老板：BOSS
     * 导购：GUID
     * 客户：PM .
     *
     * @return the 登录类型 店长：SHOP 老板：BOSS 导购：GUID 客户：PM 
     */
    public String getMemberType() {
        return memberType;
    }

    /**
     * 登录类型
     * 店长：SHOP
     * 老板：BOSS
     * 导购：GUID
     * 客户：PM .
     *
     * @param memberType the new 登录类型 店长：SHOP 老板：BOSS 导购：GUID 客户：PM 
     */
    public void setMemberType(String memberType) {
        this.memberType = memberType == null ? null : memberType.trim();
    }

    /**
     * 锁定状态:
     * NORMAL 正常,未锁定;
     * AUTOLOCK密码输入错误超过次数,自动锁定会员;
     * MANUALLOCK人工锁定
     * .
     *
     * @return the 锁定状态: NORMAL 正常,未锁定; AUTOLOCK密码输入错误超过次数,自动锁定会员; MANUALLOCK人工锁定 
     */
    public String getLockStatus() {
        return lockStatus;
    }

    /**
     * 锁定状态:
     * NORMAL 正常,未锁定;
     * AUTOLOCK密码输入错误超过次数,自动锁定会员;
     * MANUALLOCK人工锁定
     * .
     *
     * @param lockStatus the new 锁定状态: NORMAL 正常,未锁定; AUTOLOCK密码输入错误超过次数,自动锁定会员; MANUALLOCK人工锁定 
     */
    public void setLockStatus(String lockStatus) {
        this.lockStatus = lockStatus == null ? null : lockStatus.trim();
    }

    /**
     * 上次登录成功时间 .
     *
     * @return the 上次登录成功时间 
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * 上次登录成功时间 .
     *
     * @param lastLoginDate the new 上次登录成功时间 
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * 周期内登录失败次数 .
     *
     * @return the 周期内登录失败次数 
     */
    public Integer getCycleLoginFailTimes() {
        return cycleLoginFailTimes;
    }

    /**
     * 周期内登录失败次数 .
     *
     * @param cycleLoginFailTimes the new 周期内登录失败次数 
     */
    public void setCycleLoginFailTimes(Integer cycleLoginFailTimes) {
        this.cycleLoginFailTimes = cycleLoginFailTimes;
    }

    /**
     * 最近一次密码错误时间 .
     *
     * @return the 最近一次密码错误时间 
     */
    public Date getLastLoginErrorDate() {
        return lastLoginErrorDate;
    }

    /**
     * 最近一次密码错误时间 .
     *
     * @param lastLoginErrorDate the new 最近一次密码错误时间 
     */
    public void setLastLoginErrorDate(Date lastLoginErrorDate) {
        this.lastLoginErrorDate = lastLoginErrorDate;
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
     * 输出BEAN数据信息.
     *
     * @return the string
     * @author LeoPeng
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LoginCheck [code=").append(code);
        builder.append(",memberNo=").append(memberNo); 
        builder.append(",memberType=").append(memberType); 
        builder.append(",lockStatus=").append(lockStatus); 
        builder.append(",lastLoginDate=").append(lastLoginDate); 
        builder.append(",cycleLoginFailTimes=").append(cycleLoginFailTimes); 
        builder.append(",lastLoginErrorDate=").append(lastLoginErrorDate); 
        builder.append(",updateId=").append(updateId); 
        builder.append(",updateDate=").append(updateDate); 
        builder.append("]");
        return builder.toString();
    }
}
