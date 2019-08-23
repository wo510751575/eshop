package com.lj.business.member.domain;

import java.io.Serializable;
// TODO: Auto-generated Javadoc

/**
 * 类说明：行业信息表（基础表）
 *  
 * 
 * <p>
 * 详细描述：
 *   
 *
 * @author 邹磊
 *   
 * CreateDate: 2017年7月12日
 * @Company: 领居科技有限公司
 */
public class MemLine implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -367216503857908278L;

	/**
     * CODE .
     */
    private String code;

    /**
     * 行业名称  .
     */
    private String name;

    /**
     * 行业备注 .
     */
    private String remark;

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

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

	/**
	 * Gets the remark.
	 *
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the remark.
	 *
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemLine [code=").append(code).append(", name=")
				.append(name).append(", remark=").append(remark).append("]");
		return builder.toString();
	}

}