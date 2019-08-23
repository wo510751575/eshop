package com.lj.eshop.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * 类说明：统计表DTO
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月22日
 */
public class SummaryDto implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = -2872908843426403985L;

	/**
     *  .
     */
    private String code;

    /**
     * 量 .
     */
    private String count;

    /**
     * 统计日期.
     */
    private Date daySt;

    /**
     * 统计维度\r\n            订单状态：0\r\n            商品分类：1\r\n            客户量：2\r\n            销售额：3 .
     */
    private String dimensionSt;

    /**
     * 占比 .
     */
    private BigDecimal ratio;
    
    /**
     * 所属商户code .
     */
    private String merchantCode;
    
    /**
     * 所属商户名称 .
     */
    private String merchantName;
    
    /**
     * 店铺Code .
     */
    private String shopCode;
    
    /**
     * 店铺名称 .
     */
    private String shopName;
    
    /**
     * 订单状态 .
     */
    private String orderStatus;
    
    /**
     * 商品分类code .
     */
    private String catalogCode;
    
    /**
     * 开始时间条件
     */
    private String startTime;
    /**
     * 结束时间条件
     */
    private String endTime;

    public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getCatalogCode() {
		return catalogCode;
	}

	public void setCatalogCode(String catalogCode) {
		this.catalogCode = catalogCode;
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

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Date getDaySt() {
		return daySt;
	}

	public void setDaySt(Date daySt) {
		this.daySt = daySt;
	}

	public String getDimensionSt() {
		return dimensionSt;
	}

	public void setDimensionSt(String dimensionSt) {
		this.dimensionSt = dimensionSt;
	}

	public BigDecimal getRatio() {
		if (ratio != null) {
			ratio= ratio.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		return ratio;
	}

	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	@Override
	public String toString() {
		return "Summary [code=" + code + ", count=" + count + ", daySt="
				+ daySt + ", dimensionSt=" + dimensionSt + ", ratio=" + ratio
				+ ", merchantCode=" + merchantCode + ", merchantName="
				+ merchantName + ", shopCode=" + shopCode + ", shopName="
				+ shopName + ", orderStatus=" + orderStatus + ", catalogCode="
				+ catalogCode + "]";
	}
}
