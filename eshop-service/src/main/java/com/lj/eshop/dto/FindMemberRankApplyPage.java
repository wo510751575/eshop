package com.lj.eshop.dto;

import com.lj.base.core.pagination.PageParamEntity; 

public class FindMemberRankApplyPage extends PageParamEntity { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 查询条件
	private MemberRankApplyDto param;
	
	//不等于某个状态 
	private String neStatus;
	

	// 动态排序条件 根据需要可自行补充
	// private .... sort;
	private String approveTimeDesc;
	
	
	
	
	
	
	public String getApproveTimeDesc() {
		return approveTimeDesc;
	}
	public void setApproveTimeDesc(String approveTimeDesc) {
		this.approveTimeDesc = approveTimeDesc;
	}
	public MemberRankApplyDto getParam() {
		return param;
	}
	public void setParam(MemberRankApplyDto param) {
		this.param = param;
	}
	public String getNeStatus() {
		return neStatus;
	}
	public void setNeStatus(String neStatus) {
		this.neStatus = neStatus;
	}
	
	
}
