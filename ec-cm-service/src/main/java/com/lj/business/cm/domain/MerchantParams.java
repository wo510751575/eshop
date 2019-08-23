package com.lj.business.cm.domain;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class MerchantParams.
 */
/**
 * 
 * 
 * 类说明：商户参数配置表
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
public class MerchantParams {
    /**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 商户名称 .
     */
    private String merchantName;

    /**
     * 系统参数名 .
     */
    private String sysParamName;

    /**
     * 分组信息 .
     */
    private String groupName;

    /**
     * 系统参数值 .
     */
    private String sysParamValue;

    /**
     * 参数信息备注 .
     */
    private String remark;

    /**
     * 是否只有运维能修改，0代表业务也能修改，1代表只有运维能修改 .
     */
    private String onlyAdminModify;

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
     * 商户编号 .
     *
     * @return the merchant no
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 商户编号 .
     *
     * @param merchantNo the new merchant no
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 商户名称 .
     *
     * @return the merchant name
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * 商户名称 .
     *
     * @param merchantName the new merchant name
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    /**
     * 系统参数名 .
     *
     * @return the sys param name
     */
    public String getSysParamName() {
        return sysParamName;
    }

    /**
     * 系统参数名 .
     *
     * @param sysParamName the new sys param name
     */
    public void setSysParamName(String sysParamName) {
        this.sysParamName = sysParamName == null ? null : sysParamName.trim();
    }

    /**
     * 分组信息 .
     *
     * @return the group name
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 分组信息 .
     *
     * @param groupName the new group name
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * 系统参数值 .
     *
     * @return the sys param value
     */
    public String getSysParamValue() {
        return sysParamValue;
    }

    /**
     * 系统参数值 .
     *
     * @param sysParamValue the new sys param value
     */
    public void setSysParamValue(String sysParamValue) {
        this.sysParamValue = sysParamValue == null ? null : sysParamValue.trim();
    }

    /**
     * 参数信息备注 .
     *
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 参数信息备注 .
     *
     * @param remark the new remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 是否只有运维能修改，0代表业务也能修改，1代表只有运维能修改 .
     *
     * @return the only admin modify
     */
    public String getOnlyAdminModify() {
        return onlyAdminModify;
    }

    /**
     * 是否只有运维能修改，0代表业务也能修改，1代表只有运维能修改 .
     *
     * @param onlyAdminModify the new only admin modify
     */
    public void setOnlyAdminModify(String onlyAdminModify) {
        this.onlyAdminModify = onlyAdminModify == null ? null : onlyAdminModify.trim();
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
		builder.append("MerchantParams [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", merchantName=").append(merchantName)
				.append(", sysParamName=").append(sysParamName)
				.append(", groupName=").append(groupName)
				.append(", sysParamValue=").append(sysParamValue)
				.append(", remark=").append(remark)
				.append(", onlyAdminModify=").append(onlyAdminModify)
				.append(", createDate=").append(createDate).append("]");
		return builder.toString();
	}
}