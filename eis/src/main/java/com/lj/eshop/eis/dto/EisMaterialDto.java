package com.lj.eshop.eis.dto;

import java.util.Date;

/**
 * 素材dto
 * 类说明：
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年9月18日
 */
public class EisMaterialDto {
	// remarks imgs productCode bizType code

	//素材
	private String title;
	
	//内容
	private String remarks;
	
	//图片
	private String imgs;
	
	//产品code
	private String productCode;
	
	//0卖家素材，1官方素材， 2精选素材
	private String bizType;
	
	//素材code
	private String code;
	
	//cm.material.code
	private String materialCmCode;
	private Date createTime;
	
	//t_merchant.code
	private String merchantCode;
	
	//t_merchant.code
	private String materialdimension;

	//t_merchant.code
	private String url;

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getImgs() {
		return imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMaterialCmCode() {
		return materialCmCode;
	}

	public void setMaterialCmCode(String materialCmCode) {
		this.materialCmCode = materialCmCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getMaterialdimension() {
		return materialdimension;
	}

	public void setMaterialdimension(String materialdimension) {
		this.materialdimension = materialdimension;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	

}
