package com.lj.business.member.emus;

/**
 * 
 * 
 * 类说明：客户分类维度 
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年7月11日
 */
public enum PmTypeDim {
	
	MERCHANT("商户"),
	GUID("导购"),
	;
	
	private String name;

	PmTypeDim(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
