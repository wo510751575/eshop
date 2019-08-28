/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.dto;

import java.io.Serializable;

/**
 * 
 * 
 * 类说明：商品评价Dto
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年9月11日
 */
public class EvlDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3010529693827726665L;
	private Integer grade;
	private String info;
	private String imgs;
	private String skuCode;
	/**
	 * @return the grade
	 */
	public Integer getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * @return the imgs
	 */
	public String getImgs() {
		return imgs;
	}
	/**
	 * @param imgs the imgs to set
	 */
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	/**
	 * @return the skuCode
	 */
	public String getSkuCode() {
		return skuCode;
	}
	/**
	 * @param skuCode the skuCode to set
	 */
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	
	
}
