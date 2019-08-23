package com.lj.business.cf.emus;

/**
 * 
 * 
 * 类说明：沟通任务类型
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月25日
 */
public enum ComTaskType {
	
	/**
	 * 分组任务
	 */
	GROUP("分组任务"),
	/**
	 * 初次介绍
	 */
	FIRST_INTR("初次介绍"),
	/**
	 * 沟通任务
	 */
	COM_TASK("沟通任务"),
	/**
	 * 邀约任务
	 */
	INVITE("邀约任务"),
	/**
	 * 到店提醒
	 */
	REMIND("到店提醒"),
	/**
	 * 到店体验
	 */
	CLIENT_EXP("到店体验"),
	/**
	 * 引导客户
	 */
	GUID_PM("引导客户"),
	/**
	 * 系统
	 */
	SYSTEM("系统")
	;
	
	ComTaskType(String name){
		this.name = name;
	}
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
