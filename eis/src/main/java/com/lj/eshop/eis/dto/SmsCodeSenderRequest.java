package com.lj.eshop.eis.dto;
/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月1日
 */
public class SmsCodeSenderRequest {
	/***
	 * 发送手机号
	 */
	private String mobile;
	
	/**
	 * 发送平台
	 */
	private String senderName;
	
	/***
	 * 过期秒数，默认为180秒，最低60秒
	 */
	private int expireSeconds = 60;
	/**
	 * 业务类型
	 */
	private String bizType;
	
	
	
	/**
	 * 
	 */
	public SmsCodeSenderRequest() {
		super();
	}

	/**
	 * @param mobile
	 * @param senderName
	 * @param expireSeconds
	 * @param bizType
	 */
	public SmsCodeSenderRequest(String mobile, String senderName,
			int expireSeconds, String bizType) {
		super();
		this.mobile = mobile;
		this.senderName = senderName;
		this.expireSeconds = expireSeconds;
		this.bizType = bizType;
	}

	/**
	 * @return the bizType
	 */
	public String getBizType() {
		return bizType;
	}

	/**
	 * @param bizType the bizType to set
	 */
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the senderName
	 */
	public String getSenderName() {
		return senderName;
	}

	/**
	 * @param senderName the senderName to set
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	/**
	 * @return the expireSeconds
	 */
	public int getExpireSeconds() {
		return expireSeconds;
	}

	/**
	 * @param expireSeconds the expireSeconds to set
	 */
	public void setExpireSeconds(int expireSeconds) {
		this.expireSeconds = expireSeconds <= 0 ? 120 : expireSeconds;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SmsCodeSenderRequest [mobile=");
		builder.append(mobile);
		builder.append(", senderName=");
		builder.append(senderName);
		builder.append(", expireSeconds=");
		builder.append(expireSeconds);
		builder.append("]");
		return builder.toString();
	}
	
}
