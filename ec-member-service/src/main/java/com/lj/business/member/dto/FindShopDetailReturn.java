package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.List;

/**
 * The Class FindShopDetailReturn.
 */
public class FindShopDetailReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7266490521743485590L;
	

	
	 /**
    * 区域经理姓名 .
    */
   private String memberNameArea;
   
	
	 /**
     * 店长姓名 .
     */
    private String memberNameSp;
    
    /**
     * LOGO图片 .
     */
    private String logoAddr;
    
    /**
     * 店员信息 .
     */
    private List<GuidInfoShop> memberInfoGuid;

	/**
	 * Gets the 区域经理姓名 .
	 *
	 * @return the 区域经理姓名 
	 */
	public String getMemberNameArea() {
		return memberNameArea;
	}

	/**
	 * Sets the 区域经理姓名 .
	 *
	 * @param memberNameArea the new 区域经理姓名 
	 */
	public void setMemberNameArea(String memberNameArea) {
		this.memberNameArea = memberNameArea;
	}

	/**
	 * Gets the 店长姓名 .
	 *
	 * @return the 店长姓名 
	 */
	public String getMemberNameSp() {
		return memberNameSp;
	}

	/**
	 * Sets the 店长姓名 .
	 *
	 * @param memberNameSp the new 店长姓名 
	 */
	public void setMemberNameSp(String memberNameSp) {
		this.memberNameSp = memberNameSp;
	}

	/**
	 * Gets the 店员信息 .
	 *
	 * @return the 店员信息 
	 */
	public List<GuidInfoShop> getMemberInfoGuid() {
		return memberInfoGuid;
	}

	/**
	 * Sets the 店员信息 .
	 *
	 * @param memberInfoGuid the new 店员信息 
	 */
	public void setMemberInfoGuid(List<GuidInfoShop> memberInfoGuid) {
		this.memberInfoGuid = memberInfoGuid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindShopDetailReturn [memberNameArea=")
				.append(memberNameArea).append(", memberNameSp=")
				.append(memberNameSp).append(", logoAddr=").append(logoAddr)
				.append(", memberInfoGuid=").append(memberInfoGuid).append("]");
		return builder.toString();
	}

	/**
	 * Gets the lOGO图片 .
	 *
	 * @return the lOGO图片 
	 */
	public String getLogoAddr() {
		return logoAddr;
	}

	/**
	 * Sets the lOGO图片 .
	 *
	 * @param logoAddr the new lOGO图片 
	 */
	public void setLogoAddr(String logoAddr) {
		this.logoAddr = logoAddr;
	}
    
    
  
    
    

}
