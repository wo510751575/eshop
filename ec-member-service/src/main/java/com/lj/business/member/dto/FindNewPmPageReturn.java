package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class FindNewPmPageReturn.
 */
public class FindNewPmPageReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 846687130859832526L;
	
	 /**
     * 客户编号  .
     */
    private String memberNo;

    /**
     * 客户名称 .
     */
    private String memberName;
    
    /**
     * 手机号 .
     */
    private String mobile;

    /**
     * 微信号 .
     */
    private String noWx;
    
    /**
     * 昵称备注_微信 .
     */
    private String nickNameRemarkWx;
    /**
     * 昵称备注_本地.
     */
    private String nickNameRemarkLocal;
    
    /**
     * 昵称_微信 .
     */
    private String nickNameWx;
    
    /**
     * 头像地址 .
     */
    private String headAddress;
    
    /**
     * 任务备注 .
     */
    private String remarkCom;
    
    /**
     * 创建时间 .
     */
    private Date createDate;
    
    
    /**
     * 是否未分组
             是：Y
             否：N .
     */
    private String unGroup;

    /**
     * 是否已完善
             是：Y
             否：N .
     */
    private String complete;
    
    /** 资料完成度. */
    private Double ratioClientInfo;

    /**
     *初次介绍
		是：Y
		否：N.
     */
    private String firstIntroduce;
    
    
    
    
	public String getNickNameRemarkLocal() {
		return nickNameRemarkLocal;
	}


	public void setNickNameRemarkLocal(String nickNameRemarkLocal) {
		this.nickNameRemarkLocal = nickNameRemarkLocal;
	}


	/**
	 * Gets the 客户编号  .
	 *
	 * @return the 客户编号  
	 */
	public String getMemberNo() {
		return memberNo;
	}


	/**
	 * Sets the 客户编号  .
	 *
	 * @param memberNo the new 客户编号  
	 */
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}


	/**
	 * Gets the 客户名称 .
	 *
	 * @return the 客户名称 
	 */
	public String getMemberName() {
		return memberName;
	}


	/**
	 * Sets the 客户名称 .
	 *
	 * @param memberName the new 客户名称 
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	/**
	 * Gets the 手机号 .
	 *
	 * @return the 手机号 
	 */
	public String getMobile() {
		return mobile;
	}


	/**
	 * Sets the 手机号 .
	 *
	 * @param mobile the new 手机号 
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	/**
	 * Gets the 微信号 .
	 *
	 * @return the 微信号 
	 */
	public String getNoWx() {
		return noWx;
	}


	/**
	 * Sets the 微信号 .
	 *
	 * @param noWx the new 微信号 
	 */
	public void setNoWx(String noWx) {
		this.noWx = noWx;
	}


	/**
	 * Gets the 昵称备注_微信 .
	 *
	 * @return the 昵称备注_微信 
	 */
	public String getNickNameRemarkWx() {
		return nickNameRemarkWx;
	}


	/**
	 * Sets the 昵称备注_微信 .
	 *
	 * @param nickNameRemarkWx the new 昵称备注_微信 
	 */
	public void setNickNameRemarkWx(String nickNameRemarkWx) {
		this.nickNameRemarkWx = nickNameRemarkWx;
	}


	/**
	 * Gets the 昵称_微信 .
	 *
	 * @return the 昵称_微信 
	 */
	public String getNickNameWx() {
		return nickNameWx;
	}


	/**
	 * Sets the 昵称_微信 .
	 *
	 * @param nickNameWx the new 昵称_微信 
	 */
	public void setNickNameWx(String nickNameWx) {
		this.nickNameWx = nickNameWx;
	}


	/**
	 * Gets the 头像地址 .
	 *
	 * @return the 头像地址 
	 */
	public String getHeadAddress() {
		return headAddress;
	}


	/**
	 * Sets the 头像地址 .
	 *
	 * @param headAddress the new 头像地址 
	 */
	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}


	/**
	 * Gets the 任务备注 .
	 *
	 * @return the 任务备注 
	 */
	public String getRemarkCom() {
		return remarkCom;
	}


	/**
	 * Sets the 任务备注 .
	 *
	 * @param remarkCom the new 任务备注 
	 */
	public void setRemarkCom(String remarkCom) {
		this.remarkCom = remarkCom;
	}


	/**
	 * Gets the 创建时间 .
	 *
	 * @return the 创建时间 
	 */
	public Date getCreateDate() {
		return createDate;
	}


	/**
	 * Sets the 创建时间 .
	 *
	 * @param createDate the new 创建时间 
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	/**
	 * Gets the 是否未分组 是：Y 否：N .
	 *
	 * @return the 是否未分组 是：Y 否：N 
	 */
	public String getUnGroup() {
		return unGroup;
	}


	/**
	 * Sets the 是否未分组 是：Y 否：N .
	 *
	 * @param unGroup the new 是否未分组 是：Y 否：N 
	 */
	public void setUnGroup(String unGroup) {
		this.unGroup = unGroup;
	}

	/**
	 * Gets the ratio client info.
	 *
	 * @return the ratio client info
	 */
	public Double getRatioClientInfo() {
		return ratioClientInfo;
	}

	/**
	 * Sets the ratio client info.
	 *
	 * @param ratioClientInfo the new ratio client info
	 */
	public void setRatioClientInfo(Double ratioClientInfo) {
		this.ratioClientInfo = ratioClientInfo;
	}

	/**
	 * Gets the 是否已完善 是：Y 否：N .
	 *
	 * @return the 是否已完善 是：Y 否：N 
	 */
	public String getComplete() {
		return complete;
	}


	/**
	 * Sets the 是否已完善 是：Y 否：N .
	 *
	 * @param complete the new 是否已完善 是：Y 否：N 
	 */
	public void setComplete(String complete) {
		this.complete = complete;
	}


	@Override
	public String toString() {
		return "FindNewPmPageReturn [memberNo=" + memberNo + ", memberName="
				+ memberName + ", mobile=" + mobile + ", noWx=" + noWx
				+ ", nickNameRemarkWx=" + nickNameRemarkWx
				+ ", nickNameRemarkLocal=" + nickNameRemarkLocal
				+ ", nickNameWx=" + nickNameWx + ", headAddress=" + headAddress
				+ ", remarkCom=" + remarkCom + ", createDate=" + createDate
				+ ", unGroup=" + unGroup + ", complete=" + complete
				+ ", ratioClientInfo=" + ratioClientInfo + ", firstIntroduce="
				+ firstIntroduce + "]";
	}


	/**
	 * Gets the 初次介绍 是：Y 否：N.
	 *
	 * @return the 初次介绍 是：Y 否：N
	 */
	public String getFirstIntroduce() {
		return firstIntroduce;
	}


	/**
	 * Sets the 初次介绍 是：Y 否：N.
	 *
	 * @param firstIntroduce the new 初次介绍 是：Y 否：N
	 */
	public void setFirstIntroduce(String firstIntroduce) {
		this.firstIntroduce = firstIntroduce;
	}
	
	

}
