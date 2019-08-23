package com.lj.eshop.domain;

import java.util.Date;

/**
 * 
 * 
 * 类说明：意见与建议
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
public class Suggestion {
    /**
     *  .
     */
    private String code;

    /**
     *  .
     */
    private String suggestion;

    /**
     *  .
     */
    private String mbrCode;

    /**
     *  .
     */
    private String mbrName;

    /**
     *  .
     */
    private Date createTime;

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
     *  .
     *
     */
    public String getSuggestion() {
        return suggestion;
    }

    /**
     *  .
     *
     */
    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion == null ? null : suggestion.trim();
    }

    /**
     *  .
     *
     */
    public String getMbrCode() {
        return mbrCode;
    }

    /**
     *  .
     *
     */
    public void setMbrCode(String mbrCode) {
        this.mbrCode = mbrCode == null ? null : mbrCode.trim();
    }

    /**
     *  .
     *
     */
    public String getMbrName() {
        return mbrName;
    }

    /**
     *  .
     *
     */
    public void setMbrName(String mbrName) {
        this.mbrName = mbrName == null ? null : mbrName.trim();
    }

    /**
     *  .
     *
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *  .
     *
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 输出BEAN数据信息
     * @author LeoPeng
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Suggestion [code=").append(code);
        builder.append(",suggestion=").append(suggestion); 
        builder.append(",mbrCode=").append(mbrCode); 
        builder.append(",mbrName=").append(mbrName); 
        builder.append(",createTime=").append(createTime); 
        builder.append("]");
        return builder.toString();
    }
}