package com.lj.eshop.domain;

/**
 * 
 * 
 * 类说明：统计维度
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月21日
 */
public class SumDimension {
    /**
     *  .
     */
    private String code;

    /**
     * 统计维度名称 .
     */
    private String name;

    /**
     * 说明 .
     */
    private String remarks;

    /**
     * 0:启用 1：停用 .
     */
    private String status;

    /**
     *  .
     *
     */
    public String getCode() {
        return code;
    }

    /**
     *  .
     *
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 统计维度名称 .
     *
     */
    public String getName() {
        return name;
    }

    /**
     * 统计维度名称 .
     *
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 说明 .
     *
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 说明 .
     *
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 0:启用 1：停用 .
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * 0:启用 1：停用 .
     *
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 输出BEAN数据信息
     * @author LeoPeng
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SumDimension [code=").append(code);
        builder.append(",name=").append(name); 
        builder.append(",remarks=").append(remarks); 
        builder.append(",status=").append(status); 
        builder.append("]");
        return builder.toString();
    }
}