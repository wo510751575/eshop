package com.lj.business.cm.dto;

import java.io.Serializable;

/**
 * The Class DelMaterialType.
 */
public class DelMaterialType implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6976377059975413052L;
    
    /** The id. */
    private String id;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DelMaterialType [id=" + id + ", getId()=" + getId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	

}
