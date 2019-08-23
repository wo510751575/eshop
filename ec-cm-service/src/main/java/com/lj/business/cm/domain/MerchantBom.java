package com.lj.business.cm.domain;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class MerchantBom.
 */
/**
 * 
 * 
 * 类说明：商户产品表
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年7月12日
 */
public class MerchantBom {
    /**
     * CODE .
     */
    private String code;

    /**
     * 会员号  .
     */
    private String merchantNo;

    /**
     * 会员名称 .
     */
    private String merchantName;

    /**
     *  .
     */
    private String bomCode;

    /**
     * 客户分类名称 .
     */
    private String bomName;

    /**
     *  .
     */
    private String imgAddr;

    /**
     * 创建人 .
     */
    private String createId;

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
     * 会员号  .
     *
     * @return the merchant no
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 会员号  .
     *
     * @param merchantNo the new merchant no
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 会员名称 .
     *
     * @return the merchant name
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * 会员名称 .
     *
     * @param merchantName the new merchant name
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    /**
     *  .
     *
     * @return the bom code
     */
    public String getBomCode() {
        return bomCode;
    }

    /**
     *  .
     *
     * @param bomCode the new bom code
     */
    public void setBomCode(String bomCode) {
        this.bomCode = bomCode == null ? null : bomCode.trim();
    }

    /**
     * 客户分类名称 .
     *
     * @return the bom name
     */
    public String getBomName() {
        return bomName;
    }

    /**
     * 客户分类名称 .
     *
     * @param bomName the new bom name
     */
    public void setBomName(String bomName) {
        this.bomName = bomName == null ? null : bomName.trim();
    }

    /**
     *  .
     *
     * @return the img addr
     */
    public String getImgAddr() {
        return imgAddr;
    }

    /**
     *  .
     *
     * @param imgAddr the new img addr
     */
    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr == null ? null : imgAddr.trim();
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
     * 输出BEAN数据信息.
     *
     * @author LeoPeng
     * @return the string
     */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MerchantBom [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", merchantName=").append(merchantName)
				.append(", bomCode=").append(bomCode).append(", bomName=")
				.append(bomName).append(", imgAddr=").append(imgAddr)
				.append(", createId=").append(createId).append(", createDate=")
				.append(createDate).append("]");
		return builder.toString();
	}
}