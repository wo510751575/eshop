package com.lj.business.member.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class FindPmWxBpInfoReturn.
 */
public class FindPmWxInfoReturn implements Serializable {
	 
 	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7365085229024151476L;
	
	/**
    * 客户编号  .
    */
   private String memberNo;
    /**
     * 微信号 .
     */
    private String noWx;
    
    /**
     * 朋友圈ID .
     */
    private String idWx;
    
    /**
     * 昵称备注_微信 .
     */
    private String nickNameRemarkWx;
    
    /** 昵称备注_本地. */
    private String nickNameRemarkLocal;
    
    /**
     * 昵称_微信 .
     */
    private String nickNameWx;
    
    /**
     * 头像地址 .
     */
    private String headAddress;
    
    /** The mobile. */
    private String mobile;

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
	 * Gets the 朋友圈ID .
	 *
	 * @return the 朋友圈ID 
	 */
	public String getIdWx() {
		return idWx;
	}

	/**
	 * Sets the 朋友圈ID .
	 *
	 * @param idWx the new 朋友圈ID 
	 */
	public void setIdWx(String idWx) {
		this.idWx = idWx;
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
	 * Gets the mobile.
	 *
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Sets the mobile.
	 *
	 * @param mobile the new mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * Gets the nick name remark local.
	 *
	 * @return the nick name remark local
	 */
	public String getNickNameRemarkLocal() {
		return nickNameRemarkLocal;
	}

	/**
	 * Sets the nick name remark local.
	 *
	 * @param nickNameRemarkLocal the new nick name remark local
	 */
	public void setNickNameRemarkLocal(String nickNameRemarkLocal) {
		this.nickNameRemarkLocal = nickNameRemarkLocal;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindPmWxInfoReturn [memberNo=").append(memberNo)
				.append(", noWx=").append(noWx).append(", idWx=").append(idWx)
				.append(", nickNameRemarkWx=").append(nickNameRemarkWx)
				.append(", nickNameRemarkLocal=").append(nickNameRemarkLocal)
				.append(", nickNameWx=").append(nickNameWx)
				.append(", headAddress=").append(headAddress)
				.append(", mobile=").append(mobile).append("]");
		return builder.toString();
	}

}
