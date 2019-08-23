package com.lj.business.member.dto;

import java.io.Serializable;

public class UpdateManagerOrGuidPwdDto implements Serializable{

	 /**
	     * Generate cron.
	     *
	     * @param
	     * @param
	     * @throws 
	     */
	private static final long serialVersionUID = 8200802489867896667L;
	
    /**
     * 会员类型
             店长：SHOP
             老板：BOSS .
     */
    private String memberType;

    /**
     * 手机号 .
     */
    private String mobile;
    
    /**
     * 登录密码 .
     */
    private String pwd;
    
    /**
     * 加密机CODE .
     */
    private String encryptionCode;

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEncryptionCode() {
		return encryptionCode;
	}

	public void setEncryptionCode(String encryptionCode) {
		this.encryptionCode = encryptionCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateManagerOrGuidPwdDto [memberType=")
				.append(memberType).append(", mobile=").append(mobile)
				.append(", pwd=").append(pwd).append(", encryptionCode=")
				.append(encryptionCode).append("]");
		return builder.toString();
	}
}
