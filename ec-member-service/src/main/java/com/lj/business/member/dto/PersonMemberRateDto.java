package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonMemberRateDto.
 */
public class PersonMemberRateDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7306656667492931529L;
	
	/** 手机号. */
	private String mobile;
	
	/** 微信. */
	private String noWx;
	
	/** 微信昵称. */
	private String nickNameWx;
	
	/** 会员名称. */
	private String memberName;
	
	 /**
     * 职业 .
     */
    private String job;
    
    /**
     * 年龄 .
     */
    private Integer age;
    
    /**
     * 性别:
             男：male
             女：female
             未知：unknown .
     */
    private String sex;
	
	 /**
     * 装修进度 .
     */
    private String spruceUp;

    /**
     * 所在楼盘 .
     */
    private String houses;
    
    /**
     * 对比品牌 .
     */
    private String brandCompare;

    /**
     * 客户特质 .
     */
    private String clientSpecial;
    
    /**
     * 产品名称 .
     */
    private String bomName;
    
    /**
     * 客户来源 .
     */
    private String memberSrc;
    
    /**
     * 头像地址 .
     */
    private String headAddress;
    
    /**
     * 出生日期 .
     */
    private Date birthday;


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
	 * Gets the no wx.
	 *
	 * @return the no wx
	 */
	public String getNoWx() {
		return noWx;
	}

	/**
	 * Sets the no wx.
	 *
	 * @param noWx the new no wx
	 */
	public void setNoWx(String noWx) {
		this.noWx = noWx;
	}

	/**
	 * Gets the nick name wx.
	 *
	 * @return the nick name wx
	 */
	public String getNickNameWx() {
		return nickNameWx;
	}

	/**
	 * Sets the nick name wx.
	 *
	 * @param nickNameWx the new nick name wx
	 */
	public void setNickNameWx(String nickNameWx) {
		this.nickNameWx = nickNameWx;
	}

	/**
	 * Gets the member name.
	 *
	 * @return the member name
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * Sets the member name.
	 *
	 * @param memberName the new member name
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	/**
	 * Gets the job.
	 *
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * Sets the job.
	 *
	 * @param job the new job
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * Gets the sex.
	 *
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * Sets the sex.
	 *
	 * @param sex the new sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * Gets the spruce up.
	 *
	 * @return the spruce up
	 */
	public String getSpruceUp() {
		return spruceUp;
	}

	/**
	 * Sets the spruce up.
	 *
	 * @param spruceUp the new spruce up
	 */
	public void setSpruceUp(String spruceUp) {
		this.spruceUp = spruceUp;
	}

	/**
	 * Gets the houses.
	 *
	 * @return the houses
	 */
	public String getHouses() {
		return houses;
	}

	/**
	 * Sets the houses.
	 *
	 * @param houses the new houses
	 */
	public void setHouses(String houses) {
		this.houses = houses;
	}

	/**
	 * Gets the brand compare.
	 *
	 * @return the brand compare
	 */
	public String getBrandCompare() {
		return brandCompare;
	}

	/**
	 * Sets the brand compare.
	 *
	 * @param brandCompare the new brand compare
	 */
	public void setBrandCompare(String brandCompare) {
		this.brandCompare = brandCompare;
	}

	/**
	 * Gets the client special.
	 *
	 * @return the client special
	 */
	public String getClientSpecial() {
		return clientSpecial;
	}

	/**
	 * Sets the client special.
	 *
	 * @param clientSpecial the new client special
	 */
	public void setClientSpecial(String clientSpecial) {
		this.clientSpecial = clientSpecial;
	}

	/**
	 * Gets the bom name.
	 *
	 * @return the bom name
	 */
	public String getBomName() {
		return bomName;
	}

	/**
	 * Sets the bom name.
	 *
	 * @param bomName the new bom name
	 */
	public void setBomName(String bomName) {
		this.bomName = bomName;
	}

	/**
	 * Gets the member src.
	 *
	 * @return the member src
	 */
	public String getMemberSrc() {
		return memberSrc;
	}

	/**
	 * Sets the member src.
	 *
	 * @param memberSrc the new member src
	 */
	public void setMemberSrc(String memberSrc) {
		this.memberSrc = memberSrc;
	}

	/**
	 * Gets the head address.
	 *
	 * @return the head address
	 */
	public String getHeadAddress() {
		return headAddress;
	}

	/**
	 * Sets the head address.
	 *
	 * @param headAddress the new head address
	 */
	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}

	/**
	 * Gets the birthday.
	 *
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * Sets the birthday.
	 *
	 * @param birthday the new birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonMemberRateDto [mobile=").append(mobile)
				.append(", noWx=").append(noWx).append(", nickNameWx=")
				.append(nickNameWx).append(", memberName=").append(memberName)
				.append(", job=").append(job).append(", age=").append(age)
				.append(", sex=").append(sex).append(", spruceUp=")
				.append(spruceUp).append(", houses=").append(houses)
				.append(", brandCompare=").append(brandCompare)
				.append(", clientSpecial=").append(clientSpecial)
				.append(", bomName=").append(bomName).append(", memberSrc=")
				.append(memberSrc).append(", headAddress=").append(headAddress)
				.append(", birthday=").append(birthday).append("]");
		return builder.toString();
	}

}
