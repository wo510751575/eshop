package com.lj.eshop.domain;

import java.util.Date;

public class MemberRankApply {
    /**
     *  .
     */
    private String code;

    /**
     * 商户code(fk:t_shop.code) .
     */
    private String shopCode;
    
    /**
     * 商户名称
     */
    private String shopName;

    /**
     * 会员特权code(fk: t_member_rank.code) .
     */
    private String memberRankCode;
    /**
     * 会员特权名称
     */
    private String memberRankName;
    /**
     * 申请时间 .
     */
    private Date applyTime;

    /**
     * 审核时间 .
     */
    private Date approveTime;

    /**
     * 审核状态：0审核中，1审核通过，2审核不通过 .
     */
    private String status;

    /**
     * 是否删除（0未删除 1删除） .
     */
    private String delFlag;

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
     * 商户code(fk:t_shop.code) .
     *
     */
    public String getShopCode() {
        return shopCode;
    }

    /**
     * 商户code(fk:t_shop.code) .
     *
     */
    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }

    /**
     * 会员特权code(fk: t_member_rank.code) .
     *
     */
    public String getMemberRankCode() {
        return memberRankCode;
    }

    /**
     * 会员特权code(fk: t_member_rank.code) .
     *
     */
    public void setMemberRankCode(String memberRankCode) {
        this.memberRankCode = memberRankCode == null ? null : memberRankCode.trim();
    }

    /**
     * 申请时间 .
     *
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * 申请时间 .
     *
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 审核时间 .
     *
     */
    public Date getApproveTime() {
        return approveTime;
    }

    /**
     * 审核时间 .
     *
     */
    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    /**
     * 审核状态：0审核中，1审核通过，2审核不通过 .
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * 审核状态：0审核中，1审核通过，2审核不通过 .
     *
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 是否删除（0未删除 1删除） .
     *
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 是否删除（0未删除 1删除） .
     *
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
    
    

    public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getMemberRankName() {
		return memberRankName;
	}

	public void setMemberRankName(String memberRankName) {
		this.memberRankName = memberRankName;
	}

	@Override
	public String toString() {
		return "MemberRankApply [code=" + code + ", shopCode=" + shopCode + ", shopName=" + shopName
				+ ", memberRankCode=" + memberRankCode + ", memberRankName=" + memberRankName + ", applyTime="
				+ applyTime + ", approveTime=" + approveTime + ", status=" + status + ", delFlag=" + delFlag + "]";
	}

	
}