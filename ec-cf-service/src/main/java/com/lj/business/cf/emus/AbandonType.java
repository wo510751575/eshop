package com.lj.business.cf.emus;

/**
 * 
 * 
 * 类说明：放弃类型
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
public enum AbandonType {
	
	BUY("客户已买"),
	NOWANTBUY("客户不想买了"),
	LOSE("客户失联"),
	OTHER("其他")
	;
	
	AbandonType(String name){
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
