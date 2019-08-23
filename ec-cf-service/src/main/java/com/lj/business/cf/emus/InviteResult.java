package com.lj.business.cf.emus;

/**
 * 
 * 
 * 类说明：是否邀约成功
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月9日
 */
public enum InviteResult {
	Y("邀约成功"),
	N("邀约失败")
	;
	
	InviteResult(String name){
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
