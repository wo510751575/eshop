package com.lj.business.cf.emus;

public enum ShopTaskType {
	
	XIAO_SHOU("销售目标"),
	XIN_ZENG("新增客户"),
	OTHER("其他任务")
	;
	
	ShopTaskType(String name){
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
