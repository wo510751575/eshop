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
public class FindMaterial implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1353523325490069999L;

	  /** The code. */
  	private String code;
      
      /** The member no gm. */
      private String memberNoGm;
      
      /** The title. */
      private String title;
      
      
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the member no gm.
	 *
	 * @return the member no gm
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the member no gm.
	 *
	 * @param memberNoGm the member no gm
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

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
		return "FindMaterial [code=" + code + ", memberNoGm=" + memberNoGm
				+ ", title=" + title + "]";
	}


	  
}
