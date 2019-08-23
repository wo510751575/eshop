package com.lj.business.cf.dto.comTask;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class FindComTaskIndexPageReturn.
 */
public class FindComTaskIndexPageReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7642918575720229613L;

	/** The code. */
	private String code;
	  
    /**
     * 项目CODE.
     */
    private String codeList;
    
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
     * 沟通任务类型
		完善资料：IMPROVE
		其他：OTHER.
     */
    private String comTaskType;

    /**
     * 微信号 .
     */
    private String noWx;
    
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
    
    /**
     * 任务备注 .
     */
    private String remarkCom;
    
    /**
     * 工作是否完成
             是：Y
             否：N .
     */
    private String finish;
    
    /**
     * 创建时间 .
     */
    private Date createDate;
    
    /** 客户跟踪编号. */
    private String cfNo;
    
    /** NO_TYPE. */
    private String noType;
    
    /** 工作时间. */
    private Date workDate;
    
    /**
     * 上次结果时间 .
     */
    private Date lastResultDate;
    
	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * Gets the 沟通任务类型 完善资料：IMPROVE 其他：OTHER.
	 *
	 * @return the 沟通任务类型 完善资料：IMPROVE 其他：OTHER
	 */
	public String getComTaskType() {
		return comTaskType;
	}

	/**
	 * Sets the 沟通任务类型 完善资料：IMPROVE 其他：OTHER.
	 *
	 * @param comTaskType the new 沟通任务类型 完善资料：IMPROVE 其他：OTHER
	 */
	public void setComTaskType(String comTaskType) {
		this.comTaskType = comTaskType;
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
	 * Gets the 项目CODE.
	 *
	 * @return the 项目CODE
	 */
	public String getCodeList() {
		return codeList;
	}

	/**
	 * Sets the 项目CODE.
	 *
	 * @param codeList the new 项目CODE
	 */
	public void setCodeList(String codeList) {
		this.codeList = codeList;
	}

	/**
	 * Gets the cf no.
	 *
	 * @return the cf no
	 */
	public String getCfNo() {
		return cfNo;
	}

	/**
	 * Sets the cf no.
	 *
	 * @param cfNo the new cf no
	 */
	public void setCfNo(String cfNo) {
		this.cfNo = cfNo;
	}

	/**
	 * Gets the no type.
	 *
	 * @return the no type
	 */
	public String getNoType() {
		return noType;
	}

	/**
	 * Sets the no type.
	 *
	 * @param noType the new no type
	 */
	public void setNoType(String noType) {
		this.noType = noType;
	}

	/**
	 * Gets the work date.
	 *
	 * @return the work date
	 */
	public Date getWorkDate() {
		return workDate;
	}

	/**
	 * Sets the work date.
	 *
	 * @param workDate the new work date
	 */
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
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

	/**
	 * Gets the 上次结果时间 .
	 *
	 * @return the 上次结果时间 
	 */
	public Date getLastResultDate() {
		return lastResultDate;
	}

	/**
	 * Sets the 上次结果时间 .
	 *
	 * @param lastResultDate the new 上次结果时间 
	 */
	public void setLastResultDate(Date lastResultDate) {
		this.lastResultDate = lastResultDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FindComTaskIndexPageReturn [code=").append(code)
				.append(", codeList=").append(codeList).append(", memberNo=")
				.append(memberNo).append(", memberName=").append(memberName)
				.append(", mobile=").append(mobile).append(", comTaskType=")
				.append(comTaskType).append(", noWx=").append(noWx)
				.append(", nickNameRemarkWx=").append(nickNameRemarkWx)
				.append(", nickNameRemarkLocal=").append(nickNameRemarkLocal)
				.append(", nickNameWx=").append(nickNameWx)
				.append(", headAddress=").append(headAddress)
				.append(", remarkCom=").append(remarkCom).append(", finish=")
				.append(finish).append(", createDate=").append(createDate)
				.append(", cfNo=").append(cfNo).append(", noType=")
				.append(noType).append(", workDate=").append(workDate)
				.append(", lastResultDate=").append(lastResultDate).append("]");
		return builder.toString();
	}
	
}
