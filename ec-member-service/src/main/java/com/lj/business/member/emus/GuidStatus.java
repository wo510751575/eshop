package com.lj.business.member.emus;
/**
 * 
 * 
 * 类说明：导购状态
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
public enum GuidStatus {
	
	/** 未审核. */
	INIT("未审核")
	,

	/** 审核未通过. */
	UNPASS("审核未通过"),

	/** 正常. */
	NORMAL("正常"),
	
	/** 注销. */
	CANCEL("注销"),
	
	/** 冻结. */
	FREEZE("冻结");
	private String name;
	
	GuidStatus(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
