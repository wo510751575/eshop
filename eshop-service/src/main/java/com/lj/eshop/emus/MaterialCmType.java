package com.lj.eshop.emus;

/**
 * 素材类型
 * 类说明：
 * 
 * <p>
 * 
 * @Company: 领居科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年9月17日
 */
public enum MaterialCmType {
	/** 卖家素材*/
	SALE("0", "卖家素材"),

	/** 官方素材. */
	PUBLIC("1", "官方素材"),
	/** 精选素材. */
	CHOICE("2", "精选素材"),  //虚拟提示
	/** 个人素材. */
	PRIVATE("6", "个人素材");
	
	MaterialCmType(String value, String chName) {
		this.value = value;
		this.chName = chName;
	}

	private String value;// DB 存贮值
	private String chName;// 值对应的中文描述
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	
	
}
