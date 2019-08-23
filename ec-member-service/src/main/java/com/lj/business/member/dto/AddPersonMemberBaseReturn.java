package com.lj.business.member.dto;

import java.io.Serializable;

import com.lj.business.member.domain.PersonMemberBase;

/**
 * The Class AddPersonMemberBaseReturn.
 */
public class AddPersonMemberBaseReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9080199812578568737L;
	
	/** The person member base. */
	PersonMemberBase personMemberBase;

	/**
	 * Gets the person member base.
	 *
	 * @return the person member base
	 */
	public PersonMemberBase getPersonMemberBase() {
		return personMemberBase;
	}

	/**
	 * Sets the person member base.
	 *
	 * @param personMemberBase the person member base
	 */
	public void setPersonMemberBase(PersonMemberBase personMemberBase) {
		this.personMemberBase = personMemberBase;
	}
	

}
