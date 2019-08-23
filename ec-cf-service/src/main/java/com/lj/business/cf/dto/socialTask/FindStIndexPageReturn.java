package com.lj.business.cf.dto.socialTask;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class FindStIndexPageReturn.
 */
public class FindStIndexPageReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8051251562118031667L;
	
	/**
     * CODE .
     */
    private String code;
	
	 /**
     * 客户编号  .
     */
    private String memberNo;

    /**
     * 客户名称 .
     */
    private String memberName;
    

    /**
     * 工作是否完成
             是：Y
             否：N .
     */
    private String finish;
    
    /**
     * 任务动作 （作废，使用finish）
		去评论：COMMENTING
		已评论：COMMENTED
		去回复：REPLY.
     */
    private String actionTask;

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
     * 动态描述 .
     */
    private String behaviorDesc;
    /**
     * 行为时间 .
     */
    private Date behaviorDate;
    
    /**
     * 朋友圈更新时间 .
     */
    private Date friendUpdateDate;
	
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
	 * Gets the 动态描述 .
	 *
	 * @return the 动态描述 
	 */
	public String getBehaviorDesc() {
		return behaviorDesc;
	}
	
	/**
	 * Sets the 动态描述 .
	 *
	 * @param behaviorDesc the new 动态描述 
	 */
	public void setBehaviorDesc(String behaviorDesc) {
		this.behaviorDesc = behaviorDesc;
	}
	
	/**
	 * Gets the 行为时间 .
	 *
	 * @return the 行为时间 
	 */
	public Date getBehaviorDate() {
		return behaviorDate;
	}
	
	/**
	 * Sets the 行为时间 .
	 *
	 * @param behaviorDate the new 行为时间 
	 */
	public void setBehaviorDate(Date behaviorDate) {
		this.behaviorDate = behaviorDate;
	}
	
	/**
	 * Gets the 工作是否完成 是：Y 否：N .
	 *
	 * @return the 工作是否完成 是：Y 否：N 
	 */
	public String getFinish() {
		return finish;
	}

	/**
	 * Sets the 工作是否完成 是：Y 否：N .
	 *
	 * @param finish the new 工作是否完成 是：Y 否：N 
	 */
	public void setFinish(String finish) {
		this.finish = finish;
	}

	/**
	 * Gets the 任务动作 去评论：COMMENTING 已评论：COMMENTED 去回复：REPLY.
	 *
	 * @return the 任务动作 去评论：COMMENTING 已评论：COMMENTED 去回复：REPLY
	 */
	public String getActionTask() {
		return actionTask;
	}

	/**
	 * Sets the 任务动作 去评论：COMMENTING 已评论：COMMENTED 去回复：REPLY.
	 *
	 * @param actionTask the new 任务动作 去评论：COMMENTING 已评论：COMMENTED 去回复：REPLY
	 */
	public void setActionTask(String actionTask) {
		this.actionTask = actionTask;
	}

	/**
	 * Gets the 朋友圈更新时间 .
	 *
	 * @return the 朋友圈更新时间 
	 */
	public Date getFriendUpdateDate() {
		return friendUpdateDate;
	}

	/**
	 * Sets the 朋友圈更新时间 .
	 *
	 * @param friendUpdateDate the new 朋友圈更新时间 
	 */
	public void setFriendUpdateDate(Date friendUpdateDate) {
		this.friendUpdateDate = friendUpdateDate;
	}

	/**
	 * Gets the cODE .
	 *
	 * @return the cODE 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the cODE .
	 *
	 * @param code the new cODE 
	 */
	public void setCode(String code) {
		this.code = code;
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
		builder.append("FindStIndexPageReturn [code=").append(code)
				.append(", memberNo=").append(memberNo).append(", memberName=")
				.append(memberName).append(", finish=").append(finish)
				.append(", actionTask=").append(actionTask).append(", noWx=")
				.append(noWx).append(", idWx=").append(idWx)
				.append(", nickNameRemarkWx=").append(nickNameRemarkWx)
				.append(", nickNameRemarkLocal=").append(nickNameRemarkLocal)
				.append(", nickNameWx=").append(nickNameWx)
				.append(", headAddress=").append(headAddress)
				.append(", behaviorDesc=").append(behaviorDesc)
				.append(", behaviorDate=").append(behaviorDate)
				.append(", friendUpdateDate=").append(friendUpdateDate)
				.append("]");
		return builder.toString();
	}
	
}
