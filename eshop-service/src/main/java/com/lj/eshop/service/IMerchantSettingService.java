package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.MerchantSettingDto;
import com.lj.eshop.dto.FindMerchantSettingPage;
import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;

import java.util.List;
/**
 * 类说明：接口类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author lhy
 * 
 * 
 * CreateDate: 2017-08-22
 */
public interface IMerchantSettingService {
	
	/**
	 * 
	 *
	 * 方法说明：添加商户配置信息
	 *
	 * @param merchantSettingDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addMerchantSetting(MerchantSettingDto merchantSettingDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找商户配置信息
	 *
	 * @param findMerchantSetting
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public MerchantSettingDto findMerchantSetting(MerchantSettingDto merchantSettingDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询商户配置信息
	 *
	 * @param findMerchantSettingPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<MerchantSettingDto>  findMerchantSettings(FindMerchantSettingPage findMerchantSettingPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改商户配置信息
	 *
	 * @param updateMerchantSetting
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateMerchantSetting(MerchantSettingDto merchantSettingDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询商户配置信息
	 *
	 * @param findMerchantSettingPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<MerchantSettingDto> findMerchantSettingPage(FindMerchantSettingPage findMerchantSettingPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：根据name获取
	 *
	 * @param name
	 * @param merchantCode
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年9月21日
	 *
	 */
	public MerchantSettingDto findSettingsByName(String name,String merchantCode)throws TsfaServiceException;
}
