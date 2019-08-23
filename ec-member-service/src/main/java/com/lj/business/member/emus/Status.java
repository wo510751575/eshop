package com.lj.business.member.emus;
/**
 * 
 * 
 * 类说明：商户状态
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年7月18日
 */
public enum Status {
	/**
	 * 正常
	 */
	NORMAL("正常"),
	/**
	 * 注销
	 */
	CANCEL("注销");
	
	private String name;

	Status(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
}
