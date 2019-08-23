package com.lj.business.cf.emus;

/**
 * 
 * 
 * 类说明：是否购买
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
public enum BuyType {
	Y("是"),
	N("否")
	;
	
	BuyType(String name){
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
