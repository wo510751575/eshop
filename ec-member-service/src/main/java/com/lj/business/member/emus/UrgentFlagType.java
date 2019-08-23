package com.lj.business.member.emus;

/**
 * 
 * 
 * 类说明：紧急客户标识
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年8月10日
 */
public enum UrgentFlagType {

	Y("是"),
	N("否")
	;
	
	UrgentFlagType(String name){
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
