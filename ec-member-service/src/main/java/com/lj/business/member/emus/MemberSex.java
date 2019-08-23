package com.lj.business.member.emus;
/**
 * 
 * 
 * 类说明：会员性别
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
public enum MemberSex {
	
	/** 男. */
	MALE("男"),
	
	/** 女. */
	FEMALE("女");
	
	private String name;
	
	MemberSex(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
