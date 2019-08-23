package com.lj.business.cf.emus;

public enum UnitType {
	
	GE("个"),

	YUAN("元");

	UnitType(String name){
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
