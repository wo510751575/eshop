package com.lj.business.cf.domain;

import java.util.Date;
/**
 * 
 * 
 * 类说明：客户沟通任务流程表
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
public class ComTaskWorkflow {
    /**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 项目CODE .
     */
    private String codeList;

    /**
     * 项目名称 .
     */
    private String nameList;

    /**
     * 下个项目CODE .
     */
    private String nextCodeList;

    /**
     * 下个项目名称 .
     */
    private String nextNameList;

    /**
     * 是否首节点  是：Y 否：N .
     */
    private String first;

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
    private String remark;

    /**
     * CODE .
     *
     */
    public String getCode() {
        return code;
    }

    /**
     * CODE .
     *
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 商户编号 .
     *
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 商户编号 .
     *
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 项目CODE .
     *
     */
    public String getCodeList() {
        return codeList;
    }

    /**
     * 项目CODE .
     *
     */
    public void setCodeList(String codeList) {
        this.codeList = codeList == null ? null : codeList.trim();
    }

    /**
     * 项目名称 .
     *
     */
    public String getNameList() {
        return nameList;
    }

    /**
     * 项目名称 .
     *
     */
    public void setNameList(String nameList) {
        this.nameList = nameList == null ? null : nameList.trim();
    }

    /**
     * 下个项目CODE .
     *
     */
    public String getNextCodeList() {
        return nextCodeList;
    }

    /**
     * 下个项目CODE .
     *
     */
    public void setNextCodeList(String nextCodeList) {
        this.nextCodeList = nextCodeList == null ? null : nextCodeList.trim();
    }

    /**
     * 下个项目名称 .
     *
     */
    public String getNextNameList() {
        return nextNameList;
    }

    /**
     * 下个项目名称 .
     *
     */
    public void setNextNameList(String nextNameList) {
        this.nextNameList = nextNameList == null ? null : nextNameList.trim();
    }

    /**
     * 是否首节点  是：Y 否：N .
     *
     */
    public String getFirst() {
        return first;
    }

    /**
     * 是否首节点  是：Y 否：N .
     *
     */
    public void setFirst(String first) {
        this.first = first == null ? null : first.trim();
    }

    /**
     * 创建人 .
     *
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人 .
     *
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * 创建时间 .
     *
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间 .
     *
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 备注 .
     *
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注 .
     *
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    /**
     * 输出BEAN数据信息
     * @author LeoPeng
     */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ComTaskWorkflow [code=").append(code)
				.append(", merchantNo=").append(merchantNo)
				.append(", codeList=").append(codeList).append(", nameList=")
				.append(nameList).append(", nextCodeList=")
				.append(nextCodeList).append(", nextNameList=")
				.append(nextNameList).append(", first=").append(first)
				.append(", createId=").append(createId).append(", createDate=")
				.append(createDate).append(", remark=").append(remark)
				.append("]");
		return builder.toString();
	}


    
}