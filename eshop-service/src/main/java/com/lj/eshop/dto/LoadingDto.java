package com.lj.eshop.dto;

import java.io.Serializable;

public class LoadingDto implements Serializable { 

    /** */
    private String code;

    /** 图片地址*/
    private String imgUrl;

    /** 位置 */
    private Integer indexSeq;

    /** 状态*/
    private String status;

    /** 0：首页广告栏 1:商品集散广告栏*/
    private String biz;
    
    /** 跳转到活动页面或商品详情页面*/
    private String jumpUrl;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Integer getIndexSeq() {
        return indexSeq;
    }

    public void setIndexSeq(Integer indexSeq) {
        this.indexSeq = indexSeq ;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getBiz() {
        return biz;
    }

    public void setBiz(String biz) {
        this.biz = biz == null ? null : biz.trim();
    }

	public String getJumpUrl() {
		return jumpUrl;
	}

	public void setJumpUrl(String jumpUrl) {
		this.jumpUrl = jumpUrl;
	}
    
    
    
}
