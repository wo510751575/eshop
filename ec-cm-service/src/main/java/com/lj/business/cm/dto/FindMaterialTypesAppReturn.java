package com.lj.business.cm.dto;

import java.io.Serializable;

/**
 * The Class FindMaterialTypesAppReturn.
 */
public class FindMaterialTypesAppReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5213608189591268353L;

	/**
     * 类型CODE .
     */
    private String code;
    
    /**
     * 素材类型
     *  产品品牌：CHAN_PIN_PING_PAI
     *  产品安全：CHAN_PIN_AN_QUAN
     *  .
     */
    private String materialType;

    /**
     * 类型名称 .
     */
    private String typeName;
    
    /**
     * 素材数量 .
     */
    private Long numMaterial;
    
    /**
     * 客户关注度 .
     */
    private String attention;

	/**
	 * Gets the 类型CODE .
	 *
	 * @return the 类型CODE 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the 类型CODE .
	 *
	 * @param code the new 类型CODE 
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the 类型名称 .
	 *
	 * @return the 类型名称 
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * Sets the 类型名称 .
	 *
	 * @param typeName the new 类型名称 
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * Gets the 素材数量 .
	 *
	 * @return the 素材数量 
	 */
	public Long getNumMaterial() {
		return numMaterial;
	}

	/**
	 * Sets the 素材数量 .
	 *
	 * @param numMaterial the new 素材数量 
	 */
	public void setNumMaterial(Long numMaterial) {
		this.numMaterial = numMaterial;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindMaterialTypesAppReturn [code=").append(code)
				.append(", materialType=").append(materialType)
				.append(", typeName=").append(typeName)
				.append(", numMaterial=").append(numMaterial)
				.append(", attention=").append(attention).append("]");
		return builder.toString();
	}

	/**
	 * Gets the 素材类型 产品品牌：CHAN_PIN_PING_PAI 产品安全：CHAN_PIN_AN_QUAN  .
	 *
	 * @return the 素材类型 产品品牌：CHAN_PIN_PING_PAI 产品安全：CHAN_PIN_AN_QUAN  
	 */
	public String getMaterialType() {
		return materialType;
	}

	/**
	 * Sets the 素材类型 产品品牌：CHAN_PIN_PING_PAI 产品安全：CHAN_PIN_AN_QUAN  .
	 *
	 * @param materialType the new 素材类型 产品品牌：CHAN_PIN_PING_PAI 产品安全：CHAN_PIN_AN_QUAN  
	 */
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	/**
	 * Gets the 客户关注度 .
	 *
	 * @return the 客户关注度 
	 */
	public String getAttention() {
		return attention;
	}

	/**
	 * Sets the 客户关注度 .
	 *
	 * @param attention the new 客户关注度 
	 */
	public void setAttention(String attention) {
		this.attention = attention;
	}
    
    

	
}
