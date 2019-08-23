package com.lj.business.cf.emus;

/**
 * 
 * 
 * 类说明：跟踪类型
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 冯辉
 *   
 * CreateDate: 2017年7月14日
 */
public enum FollowType {
	
	PHONE("电话沟通"),
	WECHAT("微信互动"),
	SMS("短信通知"),
	SHOP("门店接待"),
	SYSTEM("系统")
	;
	
	FollowType(String name){
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
