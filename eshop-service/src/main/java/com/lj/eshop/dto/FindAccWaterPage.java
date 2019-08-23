package com.lj.eshop.dto;

import java.util.Date;

import com.lj.base.core.pagination.PageParamEntity;

public class FindAccWaterPage extends PageParamEntity {

	private static final long serialVersionUID = 1L;
	// 查询条件
	private AccWaterDto param;

	/** 开始时间. */
	private Date startTime;

	/** 结束时间. */
	private Date endTime;
	
	// 动态排序条件 根据需要可自行补充
	// private .... sort;
	/**
	 * @return the param
	 */
	public AccWaterDto getParam() {
		return param;
	}

	/**
	 * @param param
	 */
	public void setParam(AccWaterDto param) {
		this.param = param;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
	

}
