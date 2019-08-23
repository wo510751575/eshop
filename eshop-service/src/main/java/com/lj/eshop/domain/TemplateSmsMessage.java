package com.lj.eshop.domain;

import java.util.Map;

import com.lj.base.core.BaseEntity;

/**
 * 
 * 
 * 类说明：短信发送器
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月15日
 */
public class TemplateSmsMessage extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** * 手机号码. */
	private String telphoneNo;
	
	/** * 模版编号. */
    private String templateId;
    
    /** 邮件内容替换信息. */
	private Map<String, String> contentMap;
	
	/**
	 * Gets the * 手机号码.
	 *
	 * @return the * 手机号码
	 */
	public String getTelphoneNo() {
		return telphoneNo;
	}
	
	/**
	 * Sets the * 手机号码.
	 *
	 * @param telphoneNo the new * 手机号码
	 */
	public void setTelphoneNo(String telphoneNo) {
		this.telphoneNo = telphoneNo;
	}
	
	/**
	 * Gets the * 模版编号.
	 *
	 * @return the * 模版编号
	 */
	public String getTemplateId() {
		return templateId;
	}
	
	/**
	 * Sets the * 模版编号.
	 *
	 * @param templateId the new * 模版编号
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	
	/**
	 * Gets the 邮件内容替换信息.
	 *
	 * @return the 邮件内容替换信息
	 */
	public Map<String, String> getContentMap() {
		return contentMap;
	}
	
	/**
	 * Sets the 邮件内容替换信息.
	 *
	 * @param contentMap the new 邮件内容替换信息
	 */
	public void setContentMap(Map<String, String> contentMap) {
		this.contentMap = contentMap;
	}

}
