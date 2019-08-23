package com.lj.business.member.emus;

/**
 * 
 * 
 * 类说明：是否关注
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月12日
 */
public enum KeepEye {

	Y("是"),
	N("否")
	;
	
	KeepEye(String name){
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
