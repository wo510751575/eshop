package com.lj.business.member.dto;

import java.io.Serializable;

/**
 * The Class FindManagerMember.
 */
public class FindManagerMember implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1038196249068477966L; 
	
	/** The code. */
	private String code;

	/** The phone. */
	private String phone;

	/** The name. */
	private String name;
	
	/** The wx no. */
	private String wxNo;
	
	/** The memeber no. */
	private String memeberNo;

	
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
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the wx no.
	 *
	 * @return the wx no
	 */
	public String getWxNo() {
		return wxNo;
	}

	/**
	 * Sets the wx no.
	 *
	 * @param wxNo the wx no
	 */
	public void setWxNo(String wxNo) {
		this.wxNo = wxNo;
	}

	/**
	 * Gets the memeber no.
	 *
	 * @return the memeber no
	 */
	public String getMemeberNo() {
		return memeberNo;
	}

	/**
	 * Sets the memeber no.
	 *
	 * @param memeberNo the memeber no
	 */
	public void setMemeberNo(String memeberNo) {
		this.memeberNo = memeberNo;
	}
	
	
}
