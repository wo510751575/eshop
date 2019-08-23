package com.lj.business.cm.dto;

import java.io.Serializable;

/**
 * 类说明：
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @Company: 领居科技有限公司
 * @author 罗书明
 * 
 * CreateDate: 2017年6月21日
 */
public class FindMaterialCommen implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3647014816237749207L;
    
    /** The code. */
    private String code;
	
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
	 * @param code the code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FindMaterialCommen [code=" + code + "]";
	}
    

}
