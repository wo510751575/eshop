package com.lj.business.cf.dto.clientFollow;

import java.io.Serializable;

/**
 * 
 * 
 * 类说明：查询会员订单
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 武鹏飞
 *   
 * CreateDate: 2017年7月21日
 */
public class FindClientFollowOrder implements Serializable {

	/** Generate cron. */
	private static final long serialVersionUID = -9084420769578390091L;

	/**
	 * CODE .
	 */
	private String code;

	/**
	 * 会员号 .
	 */
	private String memberNo;

	/**
	 * 会员名称 .
	 */
	private String memberName;

	/**
	 * 订单金额 .
	 */
	private Long orderAmount;

	/**
	 * 订单时间
	 */
	private String createDate;

	/**
	 * 会员图像
	 */
	private String imgAddr;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

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

	public Long getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Long orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getImgAddr() {
		return imgAddr;
	}

	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}

}
