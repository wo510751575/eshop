package com.lj.business.member.domain;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * 类说明：会员登录记录
 *  
 * 
 * <p>
 * 详细描述：
 *   
 *
 * @author 段志鹏
 *   
 * CreateDate: 2017年7月3日
 * @Company: 领居科技有限公司
 */
public class MemberLoginInfo {
    /**
     * CODE .
     */
    private String code;

    /**
     * 会员类型             导购：GUID             店长：SHOP             老板：BOSS .
     */
    private String memberType;

    /**
     * 会员号 .
     */
    private String memberNo;

    /**
     *  .
     */
    private String ipAddress;

    /**
     *  .
     */
    private String mac;

    /**
     *  .
     */
    private String netType;

    /**
     * PC             ANDROID PAD             ANDROID PHONE             IPAD             IPHONE             PHONE             PAD .
     */
    private String equipment;

    /**
     * 区域信息（经纬度） .
     */
    private String areaInfo;

    /**
     *  .
     */
    private String loginArea;

    /**
     * 创建时间 .
     */
    private Date createDate;

    /**
     * CODE .
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * CODE .
     *
     * @param code the new code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 会员类型
     *              导购：GUID
     *              店长：SHOP
     *              老板：BOSS .
     *
     * @return the member type
     */
    public String getMemberType() {
        return memberType;
    }

    /**
     * 会员类型
     *              导购：GUID
     *              店长：SHOP
     *              老板：BOSS .
     *
     * @param memberType the new member type
     */
    public void setMemberType(String memberType) {
        this.memberType = memberType == null ? null : memberType.trim();
    }

    /**
     * 会员号 .
     *
     * @return the member no
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * 会员号 .
     *
     * @param memberNo the new member no
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     *  .
     *
     * @return the ip address
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     *  .
     *
     * @param ipAddress the new ip address
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    /**
     *  .
     *
     * @return the mac
     */
    public String getMac() {
        return mac;
    }

    /**
     *  .
     *
     * @param mac the new mac
     */
    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    /**
     *  .
     *
     * @return the net type
     */
    public String getNetType() {
        return netType;
    }

    /**
     *  .
     *
     * @param netType the new net type
     */
    public void setNetType(String netType) {
        this.netType = netType == null ? null : netType.trim();
    }

    /**
     * PC
     *              ANDROID PAD
     *              ANDROID PHONE
     *              IPAD
     *              IPHONE
     *              PHONE
     *              PAD .
     *
     * @return the equipment
     */
    public String getEquipment() {
        return equipment;
    }

    /**
     * PC
     *              ANDROID PAD
     *              ANDROID PHONE
     *              IPAD
     *              IPHONE
     *              PHONE
     *              PAD .
     *
     * @param equipment the new equipment
     */
    public void setEquipment(String equipment) {
        this.equipment = equipment == null ? null : equipment.trim();
    }

    /**
     * 区域信息（经纬度） .
     *
     * @return the area info
     */
    public String getAreaInfo() {
        return areaInfo;
    }

    /**
     * 区域信息（经纬度） .
     *
     * @param areaInfo the new area info
     */
    public void setAreaInfo(String areaInfo) {
        this.areaInfo = areaInfo == null ? null : areaInfo.trim();
    }

    /**
     *  .
     *
     * @return the login area
     */
    public String getLoginArea() {
        return loginArea;
    }

    /**
     *  .
     *
     * @param loginArea the new login area
     */
    public void setLoginArea(String loginArea) {
        this.loginArea = loginArea == null ? null : loginArea.trim();
    }

    /**
     * 创建时间 .
     *
     * @return the creates the date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间 .
     *
     * @param createDate the new creates the date
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 输出BEAN数据信息.
     *
     * @author LeoPeng
     * @return the string
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MemberLoginInfo [code=").append(code);
        builder.append(",memberType=").append(memberType); 
        builder.append(",memberNo=").append(memberNo); 
        builder.append(",ipAddress=").append(ipAddress); 
        builder.append(",mac=").append(mac); 
        builder.append(",netType=").append(netType); 
        builder.append(",equipment=").append(equipment); 
        builder.append(",areaInfo=").append(areaInfo); 
        builder.append(",loginArea=").append(loginArea); 
        builder.append(",createDate=").append(createDate); 
        builder.append("]");
        return builder.toString();
    }
}