package com.lj.business.member.dto;

/**
 * 
 * 
 * 类说明：根据导购编号和商户号查询客户信息返回实体类
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 领居科技有限公司
 * @author 杨杰
 * 
 *         CreateDate: 2017年9月5日
 */
public class FindMemberInfoReturn implements java.io.Serializable {
	private static final long serialVersionUID = 1953649725709404273L;

	/**
	 * 头像地址 .
	 */
	private String headAddress;

	/**
	 * 微信号 .
	 */
	private String noWx;

	/**
	 * 昵称_微信 .
	 */
	private String nickNameWx;

	/**
	 * 昵称备注_微信 .
	 */
	private String nickNameRemarkWx;
	/**
	 * 昵称备注_本地 .
	 */
	private String nickNameRemarkLocal;

	public String getHeadAddress() {
		return headAddress;
	}

	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}

	public String getNoWx() {
		return noWx;
	}

	public void setNoWx(String noWx) {
		this.noWx = noWx;
	}

	public String getNickNameWx() {
		return nickNameWx;
	}

	public void setNickNameWx(String nickNameWx) {
		this.nickNameWx = nickNameWx;
	}

	public String getNickNameRemarkWx() {
		return nickNameRemarkWx;
	}

	public void setNickNameRemarkWx(String nickNameRemarkWx) {
		this.nickNameRemarkWx = nickNameRemarkWx;
	}

	public String getNickNameRemarkLocal() {
		return nickNameRemarkLocal;
	}

	public void setNickNameRemarkLocal(String nickNameRemarkLocal) {
		this.nickNameRemarkLocal = nickNameRemarkLocal;
	}

}
