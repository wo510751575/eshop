package com.lj.eshop.dto;

import java.io.Serializable;
import java.util.Date;

public class SysSpeDto implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** */
    private String code;

    /** 规格名*/
    private String speName;

    /** 创建人*/
    private String creater;

    /** 0:启用 1停用*/
    private String status;

    /** */
    private Date createTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getSpeName() {
        return speName;
    }

    public void setSpeName(String speName) {
        this.speName = speName == null ? null : speName.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
