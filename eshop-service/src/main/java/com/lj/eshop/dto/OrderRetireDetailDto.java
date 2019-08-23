package com.lj.eshop.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

public class OrderRetireDetailDto implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = 6462782875296546150L;


	/** */
    private String code;


    /** 数量*/
    private Integer cnt;

    /** 金额*/
    private BigDecimal amt;

    /** 退单号（fk:t_order_retire.retire_no）*/
    private String retireNo;

    /** 商品sku编号(fk:t_product_code.sku_no)*/
    private String skuNo;
    /**
     * 订单明细Code
     */
    private String orderDetailCode;
    
    /**
     * 临时变量：明细map
     */
    private Map<String, Object> productMap;
    
    /**
	 * @return the orderDetailCode
	 */
	public String getOrderDetailCode() {
		return orderDetailCode;
	}

	/**
	 * @param orderDetailCode the orderDetailCode to set
	 */
	public void setOrderDetailCode(String orderDetailCode) {
		this.orderDetailCode = orderDetailCode;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
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

    public String getRetireNo() {
        return retireNo;
    }

    public void setRetireNo(String retireNo) {
        this.retireNo = retireNo == null ? null : retireNo.trim();
    }

    public String getSkuNo() {
        return skuNo;
    }

    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo == null ? null : skuNo.trim();
    }

	public Map<String, Object> getProductMap() {
		return productMap;
	}

	public void setProductMap(Map<String, Object> productMap) {
		this.productMap = productMap;
	}
    
    
}
