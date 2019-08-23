package com.lj.business.cf.emus;

/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：店长设置任务唯度
 *   
 * @Company: 领居科技有限公司
 * @author 冯辉
 *   
 * CreateDate: 2017年7月20日
 */
public enum ShopTaskDimensionType {
	
	SHOP("店长"),
	MERCHANT("商户")
	;
	
	ShopTaskDimensionType(String name){
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
