package com.lj.business.cm.emus;
/**
 * The Enum SendType.
 */
/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：发送类型
 *   
 * @Company: 领居科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年6月22日
 */
public enum SendType {
	
	/** The single. */
	SINGLE("单人"),
	
	/** The multi. */
	MULTI("多人"),
	
	/** The all. */
	ALL("所有人");
	
	/**
	 * Instantiates a new send type.
	 *
	 * @param name the name
	 */
	SendType(String name){
		this.name = name;
	}
	
	/** The name. */
	private String name;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
