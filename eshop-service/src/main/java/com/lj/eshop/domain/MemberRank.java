package com.lj.eshop.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 类说明：会员特权
 * 
 * <p>
 * 
 * @Company: 领居科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年8月30日 
 */
public class MemberRank {
    /**
     *  .
     */
    private String code;

    /**
     *  .
     */
    private Date createDate;

    /**
     *  .
     */
    private Date modifyDate;

    /**
     * 租凭权限（如：5000以下，存储5000） .
     */
    private BigDecimal amount;

    /**
     *  .
     */
    private String remark;

    /**
     * 特权名称 .
     */
    private String name;

    /**
     * 穿戴次数 .
     */
    private Double scale;

    /**
     * 删除标记 .
     */
    private String delFlag;
    /**
     * 顺序号
     */
    private int seq;

    /**
     * 特权图片地址 .
     */
    private String imgSrc;
    
 

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

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
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  .
     *
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     *  .
     *
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     *  .
     *
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * 租凭权限（如：5000以下，存储5000） .
     *
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 租凭权限（如：5000以下，存储5000） .
     *
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     *  .
     *
     */
    public String getRemark() {
        return remark;
    }

    /**
     *  .
     *
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 特权名称 .
     *
     */
    public String getName() {
        return name;
    }

    /**
     * 特权名称 .
     *
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 穿戴次数 .
     *
     */
    public Double getScale() {
        return scale;
    }

    /**
     * 穿戴次数 .
     *
     */
    public void setScale(Double scale) {
        this.scale = scale;
    }

    /**
     * 删除标记 .
     *
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 删除标记 .
     *
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
    
    

    public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	@Override
	public String toString() {
		return "MemberRank [code=" + code + ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", amount="
				+ amount + ", remark=" + remark + ", name=" + name + ", scale=" + scale + ", delFlag=" + delFlag
				+ ", seq=" + seq + ", imgSrc=" + imgSrc + "]";
	}

}