package com.lj.business.member.dto;

import java.io.Serializable;

/**
 * 
 * 
 * 类说明：查找客户姓名
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 领居科技有限公司
 * @author 武鹏飞
 * 
 *         CreateDate: 2017年7月22日
 */
public class FindPersonMemberName implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1317250366977353657L;

	/**
	 * 会员编号
	 */
	private String memberNo;

	/**
	 * 会员名称 .
	 */
	private String memberName;

	/**
	 * 昵称备注_微信
	 */
	private String nickNameRemarkWx;

	/**
	 * 昵称_微信
	 */
	private String nickNameWx;
	
	/**
	 * 图像
	 */
	private String headAddress;

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getNickNameRemarkWx() {
		return nickNameRemarkWx;
	}

	public void setNickNameRemarkWx(String nickNameRemarkWx) {
		this.nickNameRemarkWx = nickNameRemarkWx;
	}

	public String getNickNameWx() {
		return nickNameWx;
	}

	public void setNickNameWx(String nickNameWx) {
		this.nickNameWx = nickNameWx;
	}

	public String getHeadAddress() {
		return headAddress;
	}

	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}
	
}
