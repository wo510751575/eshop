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
public class SmsCodeVerifyRequest {
	/***
	 * 发送手机号
	 */
	private String mobile;
	/***
	 * smsCode
	 */
	private String smsCode;
	
	/**
	 * 是否返回处理码
	 */
	private boolean processFlag;
	
	/**
	 * 如果返回处理码，则设置处理码的过期时间，单位为秒，默认10分钟
	 */
	private int processExpired = 600;
	
	/**
	 * 业务类型
	 */
	private String bizType;
	
	/**
	 * 
	 */
	public SmsCodeVerifyRequest() {
		super();
	}
	
	/**
	 * @param mobile
	 * @param smsCode
	 * @param processFlag
	 * @param processExpired
	 * @param bizType
	 */
	public SmsCodeVerifyRequest(String mobile, String smsCode,
			boolean processFlag, int processExpired, String bizType) {
		super();
		this.mobile = mobile;
		this.smsCode = smsCode;
		this.processFlag = processFlag;
		this.processExpired = processExpired;
		this.bizType = bizType;
	}
 
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSmsCode() {
		return smsCode;
	}
	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
	/**
	 * @return the processFlag
	 */
	public boolean isProcessFlag() {
		return processFlag;
	}
	/**
	 * @param processFlag the processFlag to set
	 */
	public void setProcessFlag(boolean processFlag) {
		this.processFlag = processFlag;
	}
	/**
	 * @return the processExpired
	 */
	public int getProcessExpired() {
		return processExpired;
	}
	/**
	 * @param processExpired the processExpired to set
	 */
	public void setProcessExpired(int processExpired) {
		this.processExpired = processExpired;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SmsCodeVerifyRequest [mobile=");
		builder.append(mobile);
		builder.append(", smsCode=");
		builder.append(smsCode);
		builder.append(", processFlag=");
		builder.append(processFlag);
		builder.append(", processExpired=");
		builder.append(processExpired);
		builder.append("]");
		return builder.toString();
	}
	
}
