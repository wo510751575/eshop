package com.lj.business.cf.dto;

import java.io.Serializable;
import java.util.List;

import com.lj.business.cf.dto.clientFollow.FindClientFollowReturn;
import com.lj.business.cf.dto.clientKeep.FindClientKeepReturn;

/**
 * The Class FindClientFollowClientKeepReturn.
 */
public class FindClientFollowClientKeepReturn implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8264621454021868323L;
	
	/** 0-无    1-跟进记录    2-维护记录. */
	private String type;
	
	/** 跟进记录list. */
	private List<FindClientFollowReturn> cfList;
	
	/** 维护记录list. */
	private List<FindClientKeepReturn> ckList;

	/**
	 * Gets the 0-无    1-跟进记录    2-维护记录.
	 *
	 * @return the 0-无    1-跟进记录    2-维护记录
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the 0-无    1-跟进记录    2-维护记录.
	 *
	 * @param type the new 0-无    1-跟进记录    2-维护记录
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the 跟进记录list.
	 *
	 * @return the 跟进记录list
	 */
	public List<FindClientFollowReturn> getCfList() {
		return cfList;
	}

	/**
	 * Sets the 跟进记录list.
	 *
	 * @param cfList the new 跟进记录list
	 */
	public void setCfList(List<FindClientFollowReturn> cfList) {
		this.cfList = cfList;
	}

	/**
	 * Gets the 维护记录list.
	 *
	 * @return the 维护记录list
	 */
	public List<FindClientKeepReturn> getCkList() {
		return ckList;
	}

	/**
	 * Sets the 维护记录list.
	 *
	 * @param ckList the new 维护记录list
	 */
	public void setCkList(List<FindClientKeepReturn> ckList) {
		this.ckList = ckList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindClientFollowClientKeepReturn [type=").append(type)
				.append(", cfList=").append(cfList).append(", ckList=")
				.append(ckList).append("]");
		return builder.toString();
	}
	
	
}
