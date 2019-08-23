package com.lj.business.member.domain;

import java.util.Date;
// TODO: Auto-generated Javadoc

/**
 * 类说明：登录判断表
 *  
 * 
 * <p>
 * 详细描述：
 *   
 *
 * @author 邹磊
 *   
 * CreateDate: 2017年7月12日
 * @Company: 领居科技有限公司
 */
public class LoginCheck {
    /**
     * CODE .
     */
    private String code;

    /**
     * 登录编号 .
     */
    private String memberNo;

    /**
     * 登录类型             店长：SHOP             老板：BOSS             导购：GUID             客户：PM .
     */
    private String memberType;

    /**
     * 锁定状态:             NORMAL 正常,未锁定;             AUTOLOCK密码输入错误超过次数,自动锁定会员;             MANUALLOCK人工锁定              .
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
     * 登录编号 .
     *
     * @return the member no
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * 登录编号 .
     *
     * @param memberNo the new member no
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     * 登录类型
     *              店长：SHOP
     *              老板：BOSS
     *              导购：GUID
     *              客户：PM .
     *
     * @return the member type
     */
    public String getMemberType() {
        return memberType;
    }

    /**
     * 登录类型
     *              店长：SHOP
     *              老板：BOSS
     *              导购：GUID
     *              客户：PM .
     *
     * @param memberType the new member type
     */
    public void setMemberType(String memberType) {
        this.memberType = memberType == null ? null : memberType.trim();
    }

    /**
     * 锁定状态:
     *              NORMAL 正常,未锁定;
     *              AUTOLOCK密码输入错误超过次数,自动锁定会员;
     *              MANUALLOCK人工锁定
     *               .
     *
     * @return the lock status
     */
    public String getLockStatus() {
        return lockStatus;
    }

    /**
     * 锁定状态:
     *              NORMAL 正常,未锁定;
     *              AUTOLOCK密码输入错误超过次数,自动锁定会员;
     *              MANUALLOCK人工锁定
     *               .
     *
     * @param lockStatus the new lock status
     */
    public void setLockStatus(String lockStatus) {
        this.lockStatus = lockStatus == null ? null : lockStatus.trim();
    }

    /**
     * 上次登录成功时间 .
     *
     * @return the last login date
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * 上次登录成功时间 .
     *
     * @param lastLoginDate the new last login date
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * 周期内登录失败次数 .
     *
     * @return the cycle login fail times
     */
    public Integer getCycleLoginFailTimes() {
        return cycleLoginFailTimes;
    }

    /**
     * 周期内登录失败次数 .
     *
     * @param cycleLoginFailTimes the new cycle login fail times
     */
    public void setCycleLoginFailTimes(Integer cycleLoginFailTimes) {
        this.cycleLoginFailTimes = cycleLoginFailTimes;
    }

    /**
     * 最近一次密码错误时间 .
     *
     * @return the last login error date
     */
    public Date getLastLoginErrorDate() {
        return lastLoginErrorDate;
    }

    /**
     * 最近一次密码错误时间 .
     *
     * @param lastLoginErrorDate the new last login error date
     */
    public void setLastLoginErrorDate(Date lastLoginErrorDate) {
        this.lastLoginErrorDate = lastLoginErrorDate;
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
     * 输出BEAN数据信息.
     *
     * @author LeoPeng
     * @return the string
     */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginCheck [code=").append(code).append(", memberNo=")
				.append(memberNo).append(", memberType=").append(memberType)
				.append(", lockStatus=").append(lockStatus)
				.append(", lastLoginDate=").append(lastLoginDate)
				.append(", cycleLoginFailTimes=").append(cycleLoginFailTimes)
				.append(", lastLoginErrorDate=").append(lastLoginErrorDate)
				.append(", updateId=").append(updateId).append(", updateDate=")
				.append(updateDate).append("]");
		return builder.toString();
	}
}