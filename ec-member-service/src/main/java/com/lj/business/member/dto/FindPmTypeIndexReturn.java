package com.lj.business.member.dto;

import java.io.Serializable;

/**
 * The Class FindPmTypeIndexReturn.
 */
public class FindPmTypeIndexReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8306597066084677971L;
	
	
	/**
     * 客户分类CODE .
     */
    private String code;

    /**
     * 客户分类名称 .
     */
    private String typeName;
    
    /**
     * 客户分类类型
 成单客户：SUCCESS
 已放弃客户：GIVE_UP
 紧急客户：URGENCY
 交叉客户：REPEAT
 意向客户：INTENTION
 其他：OTHER .
     */
    private String pmTypeType;

	/**
     * 客户数量 .
     */
    private Long numClient;

	/**
	 * Gets the 客户分类CODE .
	 *
	 * @return the 客户分类CODE 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the 客户分类CODE .
	 *
	 * @param code the new 客户分类CODE 
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the 客户分类名称 .
	 *
	 * @return the 客户分类名称 
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * Sets the 客户分类名称 .
	 *
	 * @param typeName the new 客户分类名称 
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * Gets the 客户分类类型 成单客户：SUCCESS 已放弃客户：GIVE_UP 紧急客户：URGENCY 交叉客户：REPEAT 意向客户：INTENTION 其他：OTHER .
	 *
	 * @return the 客户分类类型 成单客户：SUCCESS 已放弃客户：GIVE_UP 紧急客户：URGENCY 交叉客户：REPEAT 意向客户：INTENTION 其他：OTHER 
	 */
	public String getPmTypeType() {
		return pmTypeType;
	}

	/**
	 * Sets the 客户分类类型 成单客户：SUCCESS 已放弃客户：GIVE_UP 紧急客户：URGENCY 交叉客户：REPEAT 意向客户：INTENTION 其他：OTHER .
	 *
	 * @param pmTypeType the new 客户分类类型 成单客户：SUCCESS 已放弃客户：GIVE_UP 紧急客户：URGENCY 交叉客户：REPEAT 意向客户：INTENTION 其他：OTHER 
	 */
	public void setPmTypeType(String pmTypeType) {
		this.pmTypeType = pmTypeType;
	}

	/**
	 * Gets the 客户数量 .
	 *
	 * @return the 客户数量 
	 */
	public Long getNumClient() {
		return numClient;
	}

	/**
	 * Sets the 客户数量 .
	 *
	 * @param numClient the new 客户数量 
	 */
	public void setNumClient(Long numClient) {
		this.numClient = numClient;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindPmTypeIndexReturn [code=").append(code)
				.append(", typeName=").append(typeName).append(", pmTypeType=")
				.append(pmTypeType).append(", numClient=").append(numClient)
				.append("]");
		return builder.toString();
	}

    
	
	

}
