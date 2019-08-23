package com.lj.business.member.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class CheckPmTypeReturn.
 */
public class CheckPmTypeReturn implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1641595219213916001L;
	
	/** The intention. */
	//客户是否意向(到店)或者意向(非到店)
	private Boolean intention;
	
	/** The other. */
	//客户是否非意向
	private Boolean other;
	
	/** The ungroup. */
	//客户是否未分组
	private Boolean ungroup;

	/**
	 * Gets the intention.
	 *
	 * @return the intention
	 */
	public Boolean getIntention() {
		return intention;
	}

	/**
	 * Sets the intention.
	 *
	 * @param intention the new intention
	 */
	public void setIntention(Boolean intention) {
		this.intention = intention;
	}

	/**
	 * Gets the other.
	 *
	 * @return the other
	 */
	public Boolean getOther() {
		return other;
	}

	/**
	 * Sets the other.
	 *
	 * @param other the new other
	 */
	public void setOther(Boolean other) {
		this.other = other;
	}

	/**
	 * Gets the ungroup.
	 *
	 * @return the ungroup
	 */
	public Boolean getUngroup() {
		return ungroup;
	}

	/**
	 * Sets the ungroup.
	 *
	 * @param ungroup the new ungroup
	 */
	public void setUngroup(Boolean ungroup) {
		this.ungroup = ungroup;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CheckPmTypeReturn [intention=").append(intention)
				.append(", other=").append(other).append(", ungroup=")
				.append(ungroup).append("]");
		return builder.toString();
	}

}
