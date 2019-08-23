package com.lj.business.cf.emus;

public enum TaskType {

	/**
	 * 业务任务
	 */
	GOU_TONG("业务任务"),
	/**
	 * 销售目标
	 */
	XIAO_SHOU("销售目标"),
	/**
	 * 新增客户
	 */
	XIN_ZENG("新增客户"),
	/**
	 * 社交任务
	 */
	SHE_JIAO("社交任务");
	
	private String name;
	
	TaskType(String name){
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
