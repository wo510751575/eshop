/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.member.service;

import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.dto.AddMerchant;
import com.lj.business.member.dto.AddMerchantReturn;
import com.lj.business.member.dto.DelMerchant;
import com.lj.business.member.dto.DelMerchantReturn;
import com.lj.business.member.dto.FindMerchant;
import com.lj.business.member.dto.FindMerchantDto;
import com.lj.business.member.dto.FindMerchantPage;
import com.lj.business.member.dto.FindMerchantPageReturn;
import com.lj.business.member.dto.FindMerchantReturn;
import com.lj.business.member.dto.FindMerchantReturnDto;
import com.lj.business.member.dto.UpdateMerchant;
import com.lj.business.member.dto.UpdateMerchantReturn;

/**
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月18日
 */
public interface IEcMerchantService {
	
	/**
	 * 方法说明：电商新增商户。<p>
	 * 1.新增商户
	 * 2.新增店铺
	 * 3.新增店长
	 *
	 * @param addMerchant
	 * @throws TsfaServiceException
	 *
	 * @author lhy  2017年9月18日
	 *
	 */
	public void addEcMerchant(AddMerchant addMerchant) throws TsfaServiceException;

	
	/**
	 * 方法说明：添加商户表信息.
	 *
	 * @param addMerchant the add merchant
	 * @return the adds the merchant return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public AddMerchantReturn addMerchant(AddMerchant addMerchant) throws TsfaServiceException;
	
	/**
	 * 方法说明：通过code或merchantNo查找商户表信息.
	 *
	 * @param findMerchantDto the find merchant dto
	 * @return the find merchant return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public FindMerchantReturnDto selectMerchant(FindMerchantDto findMerchantDto) throws TsfaServiceException;
	
	/**
	 * 方法说明：查找商户表信息.
	 *
	 * @param findMerchant the find merchant
	 * @return the find merchant return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public FindMerchantReturn findMerchant(FindMerchant findMerchant) throws TsfaServiceException;
	
	
	/**
	 * 方法说明：删除商户表信息.
	 *
	 * @param delMerchant the del merchant
	 * @return the del merchant return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public DelMerchantReturn delMerchant(DelMerchant delMerchant) throws TsfaServiceException;

	/**
	 * 方法说明：修改商户表信息.
	 *
	 * @param updateMerchant the update merchant
	 * @return the update merchant return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public UpdateMerchantReturn updateMerchant(UpdateMerchant updateMerchant)throws TsfaServiceException;

	/**
	 * 方法说明：查找商户表信息.
	 *
	 * @param findMerchantPage the find merchant page
	 * @return the page< find merchant page return>
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public Page<FindMerchantPageReturn> findMerchantPage(FindMerchantPage findMerchantPage) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：查找商户列表
	 *
	 * @param findMerchantPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月2日
	 *
	 */
	public List<FindMerchantPageReturn> findMerchants(FindMerchantPage findMerchantPage) throws TsfaServiceException;

}
