package com.lj.business.member.emus;
/**
 * 
 * 
 * 类说明：服务协议类型
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年7月19日
 */
public enum AgreementType {
	/** APP服务协议. */
	APP_SERVICE("APP服务协议"),

	/** H5服务协议. */
	H5_SERVICE("H5服务协议");
	
	AgreementType(String name){
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
