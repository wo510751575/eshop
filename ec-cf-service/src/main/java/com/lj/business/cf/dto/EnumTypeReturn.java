package com.lj.business.cf.dto;

import java.io.Serializable;
import java.util.List;

import com.lj.base.core.util.EnumKv;

/**
 * The Class EnumTypeReturn.
 */
public class EnumTypeReturn implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8163614131608249210L;
	
	/** 装修进度. */
	private List<EnumKv> st;
	
	/** 客户来源. */
	private List<EnumKv> mst;
	
	/** 跟踪类型. */
	private List<EnumKv> follow;
	
	/** 维护类型. */
	private List<EnumKv> keep;
	
	/** 放弃理由. */
	private List<EnumKv> abreason;

	/**
	 * Gets the 装修进度.
	 *
	 * @return the 装修进度
	 */
	public List<EnumKv> getSt() {
		return st;
	}

	/**
	 * Sets the 装修进度.
	 *
	 * @param st the new 装修进度
	 */
	public void setSt(List<EnumKv> st) {
		this.st = st;
	}

	/**
	 * Gets the 客户来源.
	 *
	 * @return the 客户来源
	 */
	public List<EnumKv> getMst() {
		return mst;
	}

	/**
	 * Sets the 客户来源.
	 *
	 * @param mst the new 客户来源
	 */
	public void setMst(List<EnumKv> mst) {
		this.mst = mst;
	}

	/**
	 * Gets the 跟踪类型.
	 *
	 * @return the 跟踪类型
	 */
	public List<EnumKv> getFollow() {
		return follow;
	}

	/**
	 * Sets the 跟踪类型.
	 *
	 * @param follow the new 跟踪类型
	 */
	public void setFollow(List<EnumKv> follow) {
		this.follow = follow;
	}

	/**
	 * Gets the 维护类型.
	 *
	 * @return the 维护类型
	 */
	public List<EnumKv> getKeep() {
		return keep;
	}

	/**
	 * Sets the 维护类型.
	 *
	 * @param keep the new 维护类型
	 */
	public void setKeep(List<EnumKv> keep) {
		this.keep = keep;
	}

	/**
	 * Gets the 放弃理由.
	 *
	 * @return the 放弃理由
	 */
	public List<EnumKv> getAbreason() {
		return abreason;
	}

	/**
	 * Sets the 放弃理由.
	 *
	 * @param abreason the new 放弃理由
	 */
	public void setAbreason(List<EnumKv> abreason) {
		this.abreason = abreason;
	}
	
}
