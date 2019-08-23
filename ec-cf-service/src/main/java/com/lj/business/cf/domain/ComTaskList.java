package com.lj.business.cf.domain;

import java.util.Date;

public class ComTaskList {
    /**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 项目名称 .
     */
    private String nameList;

    /**
     * 项目描述 .
     */
    private String desList;

    /**
     * 沟通任务类型 完善资料：IMPROVE 其他：OTHER .
     */
    private String comTaskType;

    /**
     * 状态              启用：Y             停用：N              .
     */
    private String status;

    /**
     * 创建时间 .
     */
    private Date createDate;

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
     * 项目描述 .
     *
     */
    public String getDesList() {
        return desList;
    }

    /**
     * 项目描述 .
     *
     */
    public void setDesList(String desList) {
        this.desList = desList == null ? null : desList.trim();
    }

    /**
     * 沟通任务类型 完善资料：IMPROVE 其他：OTHER .
     *
     */
    public String getComTaskType() {
        return comTaskType;
    }

    /**
     * 沟通任务类型 完善资料：IMPROVE 其他：OTHER .
     *
     */
    public void setComTaskType(String comTaskType) {
        this.comTaskType = comTaskType == null ? null : comTaskType.trim();
    }

    /**
     * 状态              启用：Y             停用：N              .
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态              启用：Y             停用：N              .
     *
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
     * 输出BEAN数据信息
     * @author LeoPeng
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ComTaskList [code=").append(code);
        builder.append(",merchantNo=").append(merchantNo); 
        builder.append(",nameList=").append(nameList); 
        builder.append(",desList=").append(desList); 
        builder.append(",comTaskType=").append(comTaskType); 
        builder.append(",status=").append(status); 
        builder.append(",createDate=").append(createDate); 
        builder.append("]");
        return builder.toString();
    }
}