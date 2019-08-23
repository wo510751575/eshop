package com.lj.business.member.emus;

public enum MemerSourceType {
	
	SHOP_SACN("到店"),
	NO_SHOP_SACN("未到店"),
	OLD("老客户转介绍"),
	NET("网络推广"),
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
