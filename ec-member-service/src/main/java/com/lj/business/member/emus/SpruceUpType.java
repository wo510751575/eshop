package com.lj.business.member.emus;

public enum SpruceUpType {
	
	NODO("未交房/未装修"),
	HASDO("已装好/添置"),
	DOING("装修中"),
	CHANGE("换产品"),
	OTHER("其他")
	;
	
	SpruceUpType(String name){
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
