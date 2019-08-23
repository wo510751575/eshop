package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

import com.lj.base.core.util.DateUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class FindPmInfoAllReturn.
 */
public class FindPmInfoAllReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9051076504549568855L;

	/**
	 * PM CODE .
	 */
	private String codePm;

	/**
	 * 客户编号 .
	 */
	private String memberNo;

	/**
	 * 客户名称 .
	 */
	private String memberName;

	/**
	 * 导购编号 .
	 */
	private String memberNoGm;

	/**
	 * 导购姓名 .
	 */
	private String memberNameGm;

	/**
	 * 分店编号 .
	 */
	private String shopNo;

	/**
	 * 分店名称 .
	 */
	private String shopName;

	/**
	 * 商户编号 .
	 */
	private String merchantNo;

	/**
	 * 商户名称 .
	 */
	private String merchantName;

	/**
	 * 装修进度 .
	 */
	private String spruceUp;

	/**
	 * 装修进度 .
	 */
	private String spruceUpName;

	/**
	 * 所在楼盘 .
	 */
	private String houses;

	/**
	 * 紧急客户 .
	 */
	private String urgencyPm;

	/**
	 * 所需产品CODE .
	 */
	private String bomCode;

	/**
	 * 产品名称 .
	 */
	private String bomName;

	/**
	 * 昵称备注_微信 .
	 */
	private String nickNameRemarkWx;
	/**
	 * 昵称备注_本地 .
	 */
	private String nickNameRemarkLocal;
	/**
	 * 客户基础表CODE .
	 */
	private String codePmBase;

	/**
	 * 手机号 .
	 */
	private String mobile;

	/**
	 * 职业 .
	 */
	private String job;


	/**
	 * 职业 .
	 */
	private String jobName;

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
	 * 客户来源 .
	 */
	private String memberSrc;


	/**
	 * 客户来源 .
	 */
	private String memberSrcName;

	/**
	 * 微信号 .
	 */
	private String noWx;

	/**
	 * 昵称_微信 .
	 */
	private String nickNameWx;

	/**
	 * 头像地址 .
	 */
	private String headAddress;

	/**
	 * 兴趣 .
	 */
	private String interest;

	/**
	 * 区域CODE .
	 */
	private String areaCode;
	
    /**
     * 区域名称 .
     */
    private String areaName;

	/**
	 * 省CODE .
	 */
	private String provinceCode;

	/**
	 * 市CODE .
	 */
	private String cityCode;

	/**
	 * 市区CODE .
	 */
	private String cityAreaCode;
	
	 /**
     * 动态描述 .
     */
    private String behaviorDesc;

    /**
     * 动态时间 .
     */
    private Date behaviorDate;
    
    /**
     * 分类CODE .
     */
    private String pmTypeCode;

    /**
     * 客户分类名称 .
     */
    private String typeName;

    /**
     * 客户客户分类关联表CODE .
     */
    private String pmTypePmCode;
    
    /** 出生日期. */
    private Date birthday;
    
    /**  出生日期名称. */
    private String birthdayName;
    
    /**
     * 对比品牌 .
     */
    private String brandCompare;

    /**
     * 客户特质 .
     */
    private String clientSpecial;
	

	public String getNickNameRemarkLocal() {
		return nickNameRemarkLocal;
	}

	public void setNickNameRemarkLocal(String nickNameRemarkLocal) {
		this.nickNameRemarkLocal = nickNameRemarkLocal;
	}

	/**
	 * Gets the cODE .
	 *
	 * @return the cODE 
	 */
	public String getCodePm() {
		return codePm;
	}

	/**
	 * Sets the cODE .
	 *
	 * @param codePm the new cODE 
	 */
	public void setCodePm(String codePm) {
		this.codePm = codePm;
	}

	/**
	 * Gets the 客户编号 .
	 *
	 * @return the 客户编号 
	 */
	public String getMemberNo() {
		return memberNo;
	}

	/**
	 * Sets the 客户编号 .
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
	 * Gets the 导购编号 .
	 *
	 * @return the 导购编号 
	 */
	public String getMemberNoGm() {
		return memberNoGm;
	}

	/**
	 * Sets the 导购编号 .
	 *
	 * @param memberNoGm the new 导购编号 
	 */
	public void setMemberNoGm(String memberNoGm) {
		this.memberNoGm = memberNoGm;
	}

	/**
	 * Gets the 导购姓名 .
	 *
	 * @return the 导购姓名 
	 */
	public String getMemberNameGm() {
		return memberNameGm;
	}

	/**
	 * Sets the 导购姓名 .
	 *
	 * @param memberNameGm the new 导购姓名 
	 */
	public void setMemberNameGm(String memberNameGm) {
		this.memberNameGm = memberNameGm;
	}

	/**
	 * Gets the 分店编号 .
	 *
	 * @return the 分店编号 
	 */
	public String getShopNo() {
		return shopNo;
	}

	/**
	 * Sets the 分店编号 .
	 *
	 * @param shopNo the new 分店编号 
	 */
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	/**
	 * Gets the 分店名称 .
	 *
	 * @return the 分店名称 
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * Sets the 分店名称 .
	 *
	 * @param shopName the new 分店名称 
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * Gets the 商户编号 .
	 *
	 * @return the 商户编号 
	 */
	public String getMerchantNo() {
		return merchantNo;
	}

	/**
	 * Sets the 商户编号 .
	 *
	 * @param merchantNo the new 商户编号 
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	/**
	 * Gets the 商户名称 .
	 *
	 * @return the 商户名称 
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * Sets the 商户名称 .
	 *
	 * @param merchantName the new 商户名称 
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	/**
	 * Gets the 装修进度 .
	 *
	 * @return the 装修进度 
	 */
	public String getSpruceUp() {
		return spruceUp;
	}

	/**
	 * Sets the 装修进度 .
	 *
	 * @param spruceUp the new 装修进度 
	 */
	public void setSpruceUp(String spruceUp) {
		this.spruceUp = spruceUp;
	}

	/**
	 * Gets the 装修进度 .
	 *
	 * @return the 装修进度 
	 */
	public String getSpruceUpName() {
		return spruceUpName;
	}

	/**
	 * Sets the 装修进度 .
	 *
	 * @param spruceUpName the new 装修进度 
	 */
	public void setSpruceUpName(String spruceUpName) {
		this.spruceUpName = spruceUpName;
	}

	/**
	 * Gets the 所在楼盘 .
	 *
	 * @return the 所在楼盘 
	 */
	public String getHouses() {
		return houses;
	}

	/**
	 * Sets the 所在楼盘 .
	 *
	 * @param houses the new 所在楼盘 
	 */
	public void setHouses(String houses) {
		this.houses = houses;
	}

	/**
	 * Gets the 紧急客户 .
	 *
	 * @return the 紧急客户 
	 */
	public String getUrgencyPm() {
		return urgencyPm;
	}

	/**
	 * Sets the 紧急客户 .
	 *
	 * @param urgencyPm the new 紧急客户 
	 */
	public void setUrgencyPm(String urgencyPm) {
		this.urgencyPm = urgencyPm;
	}

	/**
	 * Gets the 所需产品CODE .
	 *
	 * @return the 所需产品CODE 
	 */
	public String getBomCode() {
		return bomCode;
	}

	/**
	 * Sets the 所需产品CODE .
	 *
	 * @param bomCode the new 所需产品CODE 
	 */
	public void setBomCode(String bomCode) {
		this.bomCode = bomCode;
	}

	/**
	 * Gets the 产品名称 .
	 *
	 * @return the 产品名称 
	 */
	public String getBomName() {
		return bomName;
	}

	/**
	 * Sets the 产品名称 .
	 *
	 * @param bomName the new 产品名称 
	 */
	public void setBomName(String bomName) {
		this.bomName = bomName;
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
	 * Gets the 客户基础表CODE .
	 *
	 * @return the 客户基础表CODE 
	 */
	public String getCodePmBase() {
		return codePmBase;
	}

	/**
	 * Sets the 客户基础表CODE .
	 *
	 * @param codePmBase the new 客户基础表CODE 
	 */
	public void setCodePmBase(String codePmBase) {
		this.codePmBase = codePmBase;
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
	 * Gets the 职业 .
	 *
	 * @return the 职业 
	 */
	public String getJob() {
		return job;
	}

	/**
	 * Sets the 职业 .
	 *
	 * @param job the new 职业 
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * Gets the 职业 .
	 *
	 * @return the 职业 
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * Sets the 职业 .
	 *
	 * @param jobName the new 职业 
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * Gets the 年龄 .
	 *
	 * @return the 年龄 
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Sets the 年龄 .
	 *
	 * @param age the new 年龄 
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * Gets the 性别: 男：male 女：female 未知：unknown .
	 *
	 * @return the 性别: 男：male 女：female 未知：unknown 
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * Sets the 性别: 男：male 女：female 未知：unknown .
	 *
	 * @param sex the new 性别: 男：male 女：female 未知：unknown 
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * Gets the 客户来源 .
	 *
	 * @return the 客户来源 
	 */
	public String getMemberSrc() {
		return memberSrc;
	}

	/**
	 * Sets the 客户来源 .
	 *
	 * @param memberSrc the new 客户来源 
	 */
	public void setMemberSrc(String memberSrc) {
		this.memberSrc = memberSrc;
	}

	/**
	 * Gets the 客户来源 .
	 *
	 * @return the 客户来源 
	 */
	public String getMemberSrcName() {
		return memberSrcName;
	}

	/**
	 * Sets the 客户来源 .
	 *
	 * @param memberSrcName the new 客户来源 
	 */
	public void setMemberSrcName(String memberSrcName) {
		this.memberSrcName = memberSrcName;
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
	 * Gets the 兴趣 .
	 *
	 * @return the 兴趣 
	 */
	public String getInterest() {
		return interest;
	}

	/**
	 * Sets the 兴趣 .
	 *
	 * @param interest the new 兴趣 
	 */
	public void setInterest(String interest) {
		this.interest = interest;
	}

	/**
	 * Gets the 区域CODE .
	 *
	 * @return the 区域CODE 
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * Sets the 区域CODE .
	 *
	 * @param areaCode the new 区域CODE 
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * Gets the 省CODE .
	 *
	 * @return the 省CODE 
	 */
	public String getProvinceCode() {
		return provinceCode;
	}

	/**
	 * Sets the 省CODE .
	 *
	 * @param provinceCode the new 省CODE 
	 */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	/**
	 * Gets the 市CODE .
	 *
	 * @return the 市CODE 
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * Sets the 市CODE .
	 *
	 * @param cityCode the new 市CODE 
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	/**
	 * Gets the 市区CODE .
	 *
	 * @return the 市区CODE 
	 */
	public String getCityAreaCode() {
		return cityAreaCode;
	}

	/**
	 * Sets the 市区CODE .
	 *
	 * @param cityAreaCode the new 市区CODE 
	 */
	public void setCityAreaCode(String cityAreaCode) {
		this.cityAreaCode = cityAreaCode;
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
	 * Gets the 动态时间 .
	 *
	 * @return the 动态时间 
	 */
	public Date getBehaviorDate() {
		return behaviorDate;
	}

	/**
	 * Sets the 动态时间 .
	 *
	 * @param behaviorDate the new 动态时间 
	 */
	public void setBehaviorDate(Date behaviorDate) {
		this.behaviorDate = behaviorDate;
	}

	/**
	 * Gets the 客户分类名称 .
	 *
	 * @return the 客户分类名称 
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * Sets the 客户分类名称 .
	 *
	 * @param typeName the new 客户分类名称 
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * Gets the 分类CODE .
	 *
	 * @return the 分类CODE 
	 */
	public String getPmTypeCode() {
		return pmTypeCode;
	}

	/**
	 * Sets the 分类CODE .
	 *
	 * @param pmTypeCode the new 分类CODE 
	 */
	public void setPmTypeCode(String pmTypeCode) {
		this.pmTypeCode = pmTypeCode;
	}

	/**
	 * Gets the 客户客户分类关联表CODE .
	 *
	 * @return the 客户客户分类关联表CODE 
	 */
	public String getPmTypePmCode() {
		return pmTypePmCode;
	}

	/**
	 * Sets the 客户客户分类关联表CODE .
	 *
	 * @param pmTypePmCode the new 客户客户分类关联表CODE 
	 */
	public void setPmTypePmCode(String pmTypePmCode) {
		this.pmTypePmCode = pmTypePmCode;
	}
	
	/**
	 * Gets the birthday name.
	 *
	 * @return the birthday name
	 */
	public String getBirthdayName() {
		return birthdayName;
	}

	/**
	 * Sets the birthday name.
	 *
	 * @param birthdayName the new birthday name
	 */
	public void setBirthdayName(String birthdayName) {
		this.birthdayName = birthdayName;
	}

	/**
	 * Gets the 出生日期.
	 *
	 * @return the 出生日期
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * Sets the 出生日期.
	 *
	 * @param birthday the new 出生日期
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
		if(this.birthday != null){
			this.birthdayName = DateUtils.formatDate(this.birthday,DateUtils.PATTERN_yyyy_MM_dd);
		}
	}

	@Override
	public String toString() {
		return "FindPmInfoAllReturn [codePm=" + codePm + ", memberNo="
				+ memberNo + ", memberName=" + memberName + ", memberNoGm="
				+ memberNoGm + ", memberNameGm=" + memberNameGm + ", shopNo="
				+ shopNo + ", shopName=" + shopName + ", merchantNo="
				+ merchantNo + ", merchantName=" + merchantName + ", spruceUp="
				+ spruceUp + ", spruceUpName=" + spruceUpName + ", houses="
				+ houses + ", urgencyPm=" + urgencyPm + ", bomCode=" + bomCode
				+ ", bomName=" + bomName + ", nickNameRemarkWx="
				+ nickNameRemarkWx + ", nickNameRemarkLocal="
				+ nickNameRemarkLocal + ", codePmBase=" + codePmBase
				+ ", mobile=" + mobile + ", job=" + job + ", jobName="
				+ jobName + ", age=" + age + ", sex=" + sex + ", memberSrc="
				+ memberSrc + ", memberSrcName=" + memberSrcName + ", noWx="
				+ noWx + ", nickNameWx=" + nickNameWx + ", headAddress="
				+ headAddress + ", interest=" + interest + ", areaCode="
				+ areaCode + ", areaName=" + areaName + ", provinceCode="
				+ provinceCode + ", cityCode=" + cityCode + ", cityAreaCode="
				+ cityAreaCode + ", behaviorDesc=" + behaviorDesc
				+ ", behaviorDate=" + behaviorDate + ", pmTypeCode="
				+ pmTypeCode + ", typeName=" + typeName + ", pmTypePmCode="
				+ pmTypePmCode + ", birthday=" + birthday + ", birthdayName="
				+ birthdayName + ", brandCompare=" + brandCompare
				+ ", clientSpecial=" + clientSpecial + "]";
	}

	/**
	 * Gets the 对比品牌 .
	 *
	 * @return the 对比品牌 
	 */
	public String getBrandCompare() {
		return brandCompare;
	}

	/**
	 * Sets the 对比品牌 .
	 *
	 * @param brandCompare the new 对比品牌 
	 */
	public void setBrandCompare(String brandCompare) {
		this.brandCompare = brandCompare;
	}

	/**
	 * Gets the 客户特质 .
	 *
	 * @return the 客户特质 
	 */
	public String getClientSpecial() {
		return clientSpecial;
	}

	/**
	 * Sets the 客户特质 .
	 *
	 * @param clientSpecial the new 客户特质 
	 */
	public void setClientSpecial(String clientSpecial) {
		this.clientSpecial = clientSpecial;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	
}
