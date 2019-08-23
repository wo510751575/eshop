package com.lj.business.member.emus;

public enum GuidmemberActionType {
	
	NEW("新增客户"),
	BUY("成单")
	;
	
	GuidmemberActionType(String name){
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
