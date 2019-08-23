package com.lj.business.cf.emus;

/**
 * 
 * 
 * 类说明：客户来源
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
public enum MemerSourceType {
	
	/**
	 * "到店扫码
	 */
	SHOP_SACN("到店"),
	/**
	 * 未到店扫码
	 */
	NO_SHOP_SACN("未到店"),
	/**
	 * 老客户转介绍
	 */
	OLD("老客户转介绍"),
	/**
	 * 网络推广
	 */
	NET("网络推广"),
	/**
	 * 其他
	 */
	OTHER("其他")
	;
	
	MemerSourceType(String name){
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
