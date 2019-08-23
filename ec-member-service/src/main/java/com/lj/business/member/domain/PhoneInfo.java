package com.lj.business.member.domain;

import java.util.Date;
// TODO: Auto-generated Javadoc

/**
 * 类说明：设备信息表
 *  
 * 
 * <p>
 * 详细描述：
 *   
 *
 * @author 邹磊
 *   
 * CreateDate: 2017年7月12日
 * @Company: 领居科技有限公司
 */
public class PhoneInfo {
    /**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String memberNoMerchant;

    /**
     * 分店编号 .
     */
    private String shopNo;

    /**
     * 分店名称 .
     */
    private String shopName;

    /**
     * 设备状态             NORMAL正常             CANCEL注销 .
     */
    private String status;

    /**
     * 手机串号 .
     */
    private String imei;

    /**
     * 会员编号 .
     */
    private String memberNo;

    /**
     * 会员姓名 .
     */
    private String memberName;

    /**
     * 会员类型             店长：SHOP             导购：GUID .
     */
    private String memberType;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;

    /**
     * 备注 .
     */
    private String remark4;

    /**
     * 备注 .
     */
    private String remark3;

    /**
     * 备注 .
     */
    private String remark;

    /**
     * 备注 .
     */
    private String remark2;

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
     * 商户编号 .
     *
     * @return the member no merchant
     */
    public String getMemberNoMerchant() {
        return memberNoMerchant;
    }

    /**
     * 商户编号 .
     *
     * @param memberNoMerchant the new member no merchant
     */
    public void setMemberNoMerchant(String memberNoMerchant) {
        this.memberNoMerchant = memberNoMerchant == null ? null : memberNoMerchant.trim();
    }

    /**
     * 分店编号 .
     *
     * @return the shop no
     */
    public String getShopNo() {
        return shopNo;
    }

    /**
     * 分店编号 .
     *
     * @param shopNo the new shop no
     */
    public void setShopNo(String shopNo) {
        this.shopNo = shopNo == null ? null : shopNo.trim();
    }

    /**
     * 分店名称 .
     *
     * @return the shop name
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 分店名称 .
     *
     * @param shopName the new shop name
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 设备状态
     *              NORMAL正常
     *              CANCEL注销 .
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设备状态
     *              NORMAL正常
     *              CANCEL注销 .
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 手机串号 .
     *
     * @return the imei
     */
    public String getImei() {
        return imei;
    }

    /**
     * 手机串号 .
     *
     * @param imei the new imei
     */
    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    /**
     * 会员编号 .
     *
     * @return the member no
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * 会员编号 .
     *
     * @param memberNo the new member no
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     * 会员姓名 .
     *
     * @return the member name
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * 会员姓名 .
     *
     * @param memberName the new member name
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * 会员类型
     *              店长：SHOP
     *              导购：GUID .
     *
     * @return the member type
     */
    public String getMemberType() {
        return memberType;
    }

    /**
     * 会员类型
     *              店长：SHOP
     *              导购：GUID .
     *
     * @param memberType the new member type
     */
    public void setMemberType(String memberType) {
        this.memberType = memberType == null ? null : memberType.trim();
    }

    /**
     * 创建人 .
     *
     * @return the creates the id
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人 .
     *
     * @param createId the new creates the id
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
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
     * 备注 .
     *
     * @return the remark 4
     */
    public String getRemark4() {
        return remark4;
    }

    /**
     * 备注 .
     *
     * @param remark4 the new remark 4
     */
    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
    }

    /**
     * 备注 .
     *
     * @return the remark 3
     */
    public String getRemark3() {
        return remark3;
    }

    /**
     * 备注 .
     *
     * @param remark3 the new remark 3
     */
    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    /**
     * 备注 .
     *
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注 .
     *
     * @param remark the new remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 备注 .
     *
     * @return the remark 2
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * 备注 .
     *
     * @param remark2 the new remark 2
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }
    
    /**
     * 输出BEAN数据信息.
     *
     * @author LeoPeng
     * @return the string
     */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PhoneInfo [code=").append(code)
				.append(", memberNoMerchant=").append(memberNoMerchant)
				.append(", shopNo=").append(shopNo).append(", shopName=")
				.append(shopName).append(", status=").append(status)
				.append(", imei=").append(imei).append(", memberNo=")
				.append(memberNo).append(", memberName=").append(memberName)
				.append(", memberType=").append(memberType)
				.append(", createId=").append(createId).append(", createDate=")
				.append(createDate).append(", remark4=").append(remark4)
				.append(", remark3=").append(remark3).append(", remark=")
				.append(remark).append(", remark2=").append(remark2)
				.append("]");
		return builder.toString();
	}
}