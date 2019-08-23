package com.lj.business.cf.dto.clientFollow;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class FindClientFollow.
 */
public class FindClientFollowMap implements Serializable {

	



     /** Generate cron. */
	private static final long serialVersionUID = -2283111672495562142L;


	/**
     * 商户号  .
     */
    private String merchantNo;
    
    /**
     * 门店号  .
     */
    private String shopNo;
    
    /**
     * 导购号  .
     */
    private String memberNoGm;

    /**
     * 跟踪次数 .
     */
    private Integer followNum;

    /**
     * 跟踪类型 .
     */
    private String followType;

    /** 开始次数. */
   private Integer followNumFrom;
   
   /** 结束次数. */
    private Integer followNumTo;
    
    /** 创建时间. */
    private Date createDate;

/**
 * Gets the merchant no.
 *
 * @return the merchant no
 */
public String getMerchantNo() {
	return merchantNo;
}

/**
 * Sets the merchant no.
 *
 * @param merchantNo the merchant no
 */
public void setMerchantNo(String merchantNo) {
	this.merchantNo = merchantNo;
}

public String getShopNo() {
	return shopNo;
}

public void setShopNo(String shopNo) {
	this.shopNo = shopNo;
}

public String getMemberNoGm() {
	return memberNoGm;
}

public void setMemberNoGm(String memberNoGm) {
	this.memberNoGm = memberNoGm;
}

/**
 * Gets the follow num.
 *
 * @return the follow num
 */
public Integer getFollowNum() {
	return followNum;
}

/**
 * Sets the follow num.
 *
 * @param followNum the follow num
 */
public void setFollowNum(Integer followNum) {
	this.followNum = followNum;
}

/**
 * Gets the follow type.
 *
 * @return the follow type
 */
public String getFollowType() {
	return followType;
}

/**
 * Sets the follow type.
 *
 * @param followType the follow type
 */
public void setFollowType(String followType) {
	this.followType = followType;
}

/**
 * Gets the follow num from.
 *
 * @return the follow num from
 */
public Integer getFollowNumFrom() {
	return followNumFrom;
}

/**
 * Sets the follow num from.
 *
 * @param followNumFrom the follow num from
 */
public void setFollowNumFrom(Integer followNumFrom) {
	this.followNumFrom = followNumFrom;
}

/**
 * Gets the follow num to.
 *
 * @return the follow num to
 */
public Integer getFollowNumTo() {
	return followNumTo;
}

/**
 * Sets the follow num to.
 *
 * @param followNumTo the follow num to
 */
public void setFollowNumTo(Integer followNumTo) {
	this.followNumTo = followNumTo;
}

public Date getCreateDate() {
	return createDate;
}

public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}

@Override
public String toString() {
	return "FindClientFollowMap [merchantNo=" + merchantNo + ", shopNo="
			+ shopNo + ", memberNoGm=" + memberNoGm + ", followNum="
			+ followNum + ", followType=" + followType + ", followNumFrom="
			+ followNumFrom + ", followNumTo=" + followNumTo + ", createDate="
			+ createDate + "]";
}



}
