package com.lj.eshop.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderRetireDto implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = 5318428871412728722L;

	/** */
    private String code;

    /** 订单号*/
    private String orderNo;

    /** 快递号码*/
    private String expressNo;

    /** 快递公司*/
    private String expressName;

    /** 退换说明*/
    private String remarks;

    /** 图片*/
    private String img1;

    /** 图片*/
    private String img2;

    /** 图片*/
    private String img3;

    /** 图片*/
    private String img4;

    /** 0:退货 1:换货*/
    private String type;

    /** */
    private Date createTime;

    /** */
    private Date updateTime;

    /** 退单号*/
    private String retireNo;
    
    /** 退货单金额*/
    private BigDecimal amt;
    
    /** 状态（0待审核，1成功，2失败）*/
    private String auditStatus;
    /** 审核人*/
    private String auditor;
    /**
     * 失败原因
     */
    private String failReason;
    
    /**
     * 没映射数据库：临时变量：订单code
     */
    private String orderCode;
    /**
     * 临时变量：退货明细
     */
    private List<OrderRetireDetailDto> retireDetailDtos;
    /**
     * 临时变量：订单明细
     */
    private List<OrderDetailDto> orderDetailDtos;

    /**
     * 临时变量：规格明细
     */
    private List<ProductSkuDto> productSkuDtos;
    /**
     * 临时变量：明细map
     */
    private List<Map<String, Object>> retireDetails;
    /**
     * 临时变量：明细string
     */
    private String retireDetailJsonStr;
    
    
    /**
	 * @return the auditStatus
	 */
	public String getAuditStatus() {
		return auditStatus;
	}

	/**
	 * @param auditStatus the auditStatus to set
	 */
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	/**
	 * @return the auditor
	 */
	public String getAuditor() {
		return auditor;
	}

	/**
	 * @param auditor the auditor to set
	 */
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	/**
	 * @return the failReason
	 */
	public String getFailReason() {
		return failReason;
	}

	/**
	 * @param failReason the failReason to set
	 */
	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo == null ? null : expressNo.trim();
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName == null ? null : expressName.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1 == null ? null : img1.trim();
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2 == null ? null : img2.trim();
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3 == null ? null : img3.trim();
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4 == null ? null : img4.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRetireNo() {
        return retireNo;
    }

    public void setRetireNo(String retireNo) {
        this.retireNo = retireNo == null ? null : retireNo.trim();
    }

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public List<OrderRetireDetailDto> getRetireDetailDtos() {
		return retireDetailDtos;
	}

	public void setRetireDetailDtos(List<OrderRetireDetailDto> retireDetailDtos) {
		this.retireDetailDtos = retireDetailDtos;
	}

	public List<OrderDetailDto> getOrderDetailDtos() {
		return orderDetailDtos;
	}

	public void setOrderDetailDtos(List<OrderDetailDto> orderDetailDtos) {
		this.orderDetailDtos = orderDetailDtos;
	}

	public List<ProductSkuDto> getProductSkuDtos() {
		return productSkuDtos;
	}

	public void setProductSkuDtos(List<ProductSkuDto> productSkuDtos) {
		this.productSkuDtos = productSkuDtos;
	}

	public List<Map<String, Object>> getRetireDetails() {
		return retireDetails;
	}

	public void setRetireDetails(List<Map<String, Object>> retireDetails) {
		this.retireDetails = retireDetails;
	}

	public String getRetireDetailJsonStr() {
		return retireDetailJsonStr;
	}

	public void setRetireDetailJsonStr(String retireDetailJsonStr) {
		this.retireDetailJsonStr = retireDetailJsonStr;
	}

	public BigDecimal getAmt() {
		if (amt != null) {
			amt= amt.setScale(2, BigDecimal.ROUND_HALF_UP);
		} 
		return amt;
	}

	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}


	
	
	
    
    
}
