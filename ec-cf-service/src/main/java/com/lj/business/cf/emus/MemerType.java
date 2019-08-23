package com.lj.business.cf.emus;

/**
 * 
 * 
 * 类说明：用户类型
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
public enum MemerType {

	SHOP("店长"),
	BOSS("老板")
	;
	
	MemerType(String name){
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
