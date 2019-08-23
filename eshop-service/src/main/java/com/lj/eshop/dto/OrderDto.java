package com.lj.eshop.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrderDto implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = -6020394681031102759L;

	/** */
    private String code;

    /** 订单金额*/
    private BigDecimal amt;

    /** 下单人代码*/
    private String mbrCode;

    /** 下单人姓名*/
    private String mbrName;

    /** 冗余（订单根据手机号查询）*/
    private String mbrPhone;

    /** 订单状态 0:待付款 1:待发货 2:待收货 3:待评价 4:申请退货 5:申请换货 6:完成 7:退货成功 8:换货成功*/
    private String status;

    /** 订单说明*/
    private String remarks;

    /** 是否需要发票 0:开发票 1:不开发票*/
    private String isInvoice;

    /** 发票抬头*/
    private String invoiceTitle;

    /** 发票明细*/
    private String invoiceInfo;

    /** 创建时间*/
    private Date createTime;

    /** 修改时间*/
    private Date updateTime;

    /** 订单编号*/
    private String orderNo;

    /** 店铺code*/
    private String shopCode;
    
    /** 快递单号*/
    private String expressNo;

    /** 快递公司*/
    private String expressName;
    /** 支付方式：0：支付宝 1:微信 2：网银 3：积分 4：优惠券 5:现金*/
    private String payType;
    
    /** 商户编号(fk:t_merchant.code)*/
    private String merchantCode;
    /** 店铺名称冗余*/
    private String shopName;
    /**
     * 开始时间条件
     */
    private String startTime;
    /**
     * 结束时间条件
     */
    private String endTime;
    /** 支付时间*/
    private Date payTime;
    /** 发货时间*/
    private Date shippingTime;
    /**
     * 门店logo
     */
    private String shopLogo;
    
    /** 收货人姓名*/
    private String revicerName;
    /** 收货人电话*/
    private String revicePhone;
    /**详细地址**/
    private String addrInfo;
    /**区域全称（省市区）**/
    private String areaName;
    /**收货人邮编**/
    private String reciverZip;
    
    
    /**
	 * @return the addrInfo
	 */
	public String getAddrInfo() {
		return addrInfo;
	}

	/**
	 * @param addrInfo the addrInfo to set
	 */
	public void setAddrInfo(String addrInfo) {
		this.addrInfo = addrInfo;
	}

	/**
	 * @return the areaName
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * @param areaName the areaName to set
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * @return the reciverZip
	 */
	public String getReciverZip() {
		return reciverZip;
	}

	/**
	 * @param reciverZip the reciverZip to set
	 */
	public void setReciverZip(String reciverZip) {
		this.reciverZip = reciverZip;
	}

	/**
	 * @return the shopLogo
	 */
	public String getShopLogo() {
		return shopLogo;
	}

	/**
	 * @param shopLogo the shopLogo to set
	 */
	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}

	/**
	 * @return the payTime
	 */
	public Date getPayTime() {
		return payTime;
	}

	/**
	 * @param payTime the payTime to set
	 */
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	/**
	 * @return the shippingTime
	 */
	public Date getShippingTime() {
		return shippingTime;
	}

	/**
	 * @param shippingTime the shippingTime to set
	 */
	public void setShippingTime(Date shippingTime) {
		this.shippingTime = shippingTime;
	}

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	private List<OrderDetailDto> detailDtos;
    
    /**
	 * @return the detailDtos
	 */
	public List<OrderDetailDto> getDetailDtos() {
		return detailDtos;
	}

	/**
	 * @param detailDtos the detailDtos to set
	 */
	public void setDetailDtos(List<OrderDetailDto> detailDtos) {
		this.detailDtos = detailDtos;
	}

	/**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * @return the merchantCode
	 */
	public String getMerchantCode() {
		return merchantCode;
	}

	/**
	 * @param merchantCode the merchantCode to set
	 */
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	/**
	 * @return the payType
	 */
	public String getPayType() {
		return payType;
	}

	/**
	 * @param payType the payType to set
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}

	/**
	 * @return the expressNo
	 */
	public String getExpressNo() {
		return expressNo;
	}

	/**
	 * @param expressNo the expressNo to set
	 */
	public void setExpressNo(String expressNo) {
		this.expressNo = expressNo;
	}

	/**
	 * @return the expressName
	 */
	public String getExpressName() {
		return expressName;
	}

	/**
	 * @param expressName the expressName to set
	 */
	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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

    public String getMbrCode() {
        return mbrCode;
    }

    public void setMbrCode(String mbrCode) {
        this.mbrCode = mbrCode == null ? null : mbrCode.trim();
    }

    public String getMbrName() {
        return mbrName;
    }

    public void setMbrName(String mbrName) {
        this.mbrName = mbrName == null ? null : mbrName.trim();
    }

    public String getMbrPhone() {
        return mbrPhone;
    }

    public void setMbrPhone(String mbrPhone) {
        this.mbrPhone = mbrPhone == null ? null : mbrPhone.trim();
    }

    public String getRevicerName() {
        return revicerName;
    }

    public void setRevicerName(String revicerName) {
        this.revicerName = revicerName == null ? null : revicerName.trim();
    }

    public String getRevicePhone() {
        return revicePhone;
    }

    public void setRevicePhone(String revicePhone) {
        this.revicePhone = revicePhone == null ? null : revicePhone.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(String isInvoice) {
        this.isInvoice = isInvoice == null ? null : isInvoice.trim();
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    public String getInvoiceInfo() {
        return invoiceInfo;
    }

    public void setInvoiceInfo(String invoiceInfo) {
        this.invoiceInfo = invoiceInfo == null ? null : invoiceInfo.trim();
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }
    
    
    
	/**
     * 
     *
     * 方法说明：计算总提成价格（前端需要）
     *
     *
     * @author 段志鹏 CreateDate: 2017年9月19日
     *
     */
	public BigDecimal getGapPrice() {
    	BigDecimal gapPrice = new BigDecimal(0);
    	if (getDetailDtos()!=null && getDetailDtos().size()>0) {
			Iterator<OrderDetailDto> localIterator = getDetailDtos().iterator();
			while (localIterator.hasNext()) {
				OrderDetailDto item = localIterator.next();
				/*计算提成*/
				if ((item != null) && (item.getGapPrice() != null)&& (item.getCnt() != null)) {
					gapPrice = gapPrice.add(item.getGapPrice().multiply(new BigDecimal(item.getCnt())));
				}
			}
		}
    	return gapPrice;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderDto [code=" + code + ", amt=" + amt + ", mbrCode="
				+ mbrCode + ", mbrName=" + mbrName + ", mbrPhone=" + mbrPhone
				+ ", status=" + status + ", remarks=" + remarks
				+ ", isInvoice=" + isInvoice + ", invoiceTitle=" + invoiceTitle
				+ ", invoiceInfo=" + invoiceInfo + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", orderNo=" + orderNo
				+ ", shopCode=" + shopCode + ", expressNo=" + expressNo
				+ ", expressName=" + expressName + ", payType=" + payType
				+ ", merchantCode=" + merchantCode + ", shopName=" + shopName
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", payTime=" + payTime + ", shippingTime=" + shippingTime
				+ ", shopLogo=" + shopLogo + ", revicerName=" + revicerName
				+ ", revicePhone=" + revicePhone + ", addrInfo=" + addrInfo
				+ ", areaName=" + areaName + ", reciverZip=" + reciverZip
				+ ", detailDtos=" + detailDtos + "]";
	}
}
