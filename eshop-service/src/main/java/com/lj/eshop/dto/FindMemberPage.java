package com.lj.eshop.dto;

import java.util.Date;
import java.util.List;

import com.lj.base.core.pagination.PageParamEntity;

public class FindMemberPage extends PageParamEntity {

	private static final long serialVersionUID = 1L;
	// 查询条件
	private MemberDto param;
	// 查询会员类型
	private List<String> types;
	/** 开始时间. */
	private Date startTime;
	/** 结束时间. */
	private Date endTime;

	// 动态排序条件 根据需要可自行补充
	// private .... sort;
	/**
	 * @return the param
	 */
	private String eqWxNo;

	public MemberDto getParam() {
		return param;
	}

	/**
	 * @param param
	 */
	public void setParam(MemberDto param) {
		this.param = param;
	}

	/**
	 * @return the types
	 */
	public List<String> getTypes() {
		return types;
	}

	/**
	 * @param types
	 *            the types to set
	 */
	public void setTypes(List<String> types) {
		this.types = types;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getEqWxNo() {
		return eqWxNo;
	}

	public void setEqWxNo(String eqWxNo) {
		this.eqWxNo = eqWxNo;
	}

	@Override
	public String toString() {
		return "FindMemberPage [param=" + param + ", types=" + types + ", startTime=" + startTime + ", endTime="
				+ endTime + ", eqWxNo=" + eqWxNo + "]";
	}

	
}
