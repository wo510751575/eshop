package com.lj.eshop.dto;

import java.io.Serializable;
import java.util.Date;

public class SuggestionDto implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = -3486487414032969319L;

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
