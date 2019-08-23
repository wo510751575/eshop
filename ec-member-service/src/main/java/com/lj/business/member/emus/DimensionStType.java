package com.lj.business.member.emus;

public enum DimensionStType {
	
	MERCHANT("商户"),
	AREA("区域"),
	SHOP("门店"),
	PROVINCE("省份"),
	GUID("导购")
	;
	
	DimensionStType(String name){
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
