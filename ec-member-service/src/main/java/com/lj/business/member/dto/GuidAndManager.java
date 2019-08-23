package com.lj.business.member.dto;

import java.io.Serializable;

/**
 * The Class GuidAndManager.
 */
public class GuidAndManager implements Serializable{

	 /** Generate cron. */
	private static final long serialVersionUID = 6156966059066666499L;
	
	/** 导购. */
    private GuidMemberReturnDto guidMember;
    
    /** 店长. */
    private ManagerMemberReturnDto managermember;
    
    private UpdateGuidMemberDto updateGuidMemberDto;
    
    private UpdateManagerMemberDto updateManagerMemberDto;
    
	public GuidMemberReturnDto getGuidMember() {
		return guidMember;
	}
	public void setGuidMember(GuidMemberReturnDto guidMember) {
		this.guidMember = guidMember;
	}
	public ManagerMemberReturnDto getManagermember() {
		return managermember;
	}
	public void setManagermember(ManagerMemberReturnDto managermember) {
		this.managermember = managermember;
	}
	public UpdateGuidMemberDto getUpdateGuidMemberDto() {
		return updateGuidMemberDto;
	}
	public void setUpdateGuidMemberDto(UpdateGuidMemberDto updateGuidMemberDto) {
		this.updateGuidMemberDto = updateGuidMemberDto;
	}
	public UpdateManagerMemberDto getUpdateManagerMemberDto() {
		return updateManagerMemberDto;
	}
	public void setUpdateManagerMemberDto(
			UpdateManagerMemberDto updateManagerMemberDto) {
		this.updateManagerMemberDto = updateManagerMemberDto;
	}

}
