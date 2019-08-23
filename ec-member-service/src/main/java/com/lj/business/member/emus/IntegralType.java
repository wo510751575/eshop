package com.lj.business.member.emus;

public enum IntegralType {
	
	COM_TASK("沟通客户"),
	NEW("新增客户"),
	XIAO_SHOU("销售目标"),
	NOTICE("客户提醒"),
	SOCIAL("社交任务"),
	ACTIVE("活动专题"),
	ASK("节假日问候"),
	NEW_MET("新增素材"),
	SEND_MET("发送素材")
	;
	
	IntegralType(String name){
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
