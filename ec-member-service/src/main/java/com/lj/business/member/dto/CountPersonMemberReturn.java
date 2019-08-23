package com.lj.business.member.dto;

import java.io.Serializable;

public class CountPersonMemberReturn implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4064578099043974294L;
	
	/**
	 * 新增时间
	 */
	private String createDate;
	
	/**
	 * 新增数量
	 */
	private String numAdd;

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getNumAdd() {
		return numAdd;
	}

	public void setNumAdd(String numAdd) {
		this.numAdd = numAdd;
	}

	@Override
	public String toString() {
		return "CountPersonMemberReturn [createDate=" + createDate
				+ ", numAdd=" + numAdd + "]";
	}

}
