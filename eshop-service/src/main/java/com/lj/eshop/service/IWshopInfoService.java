package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.dto.FindWshopInfoPage;
import com.lj.eshop.dto.WshopInfoDto;


/**
 * 
 * 
 * 类说明：微信加油站Service接口
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
public interface IWshopInfoService {
	
	/**
	 * 
	 *
	 * 方法说明：添加文章
	 *
	 * @param wshopInfoDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月22日
	 *
	 */
	public WshopInfoDto addWshopInfo(WshopInfoDto wshopInfoDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：修改文章
	 *
	 * @param wshopInfoDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月22日
	 *
	 */
	public WshopInfoDto updateWshopInfo(WshopInfoDto wshopInfoDto)throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：获取文章
	 *
	 * @param findWshopInfoPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月22日
	 *
	 */
	public WshopInfoDto findWshopInfo(FindWshopInfoPage findWshopInfoPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：获取文章列表分页
	 *
	 * @param findWshopInfoPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月22日
	 *
	 */
	public Page<FindWshopInfoPage> findWshopInfoPage(FindWshopInfoPage findWshopInfoPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：获取文章列表不分页
	 *
	 * @param findWshopInfoPage
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月22日
	 *
	 */
	public List<FindWshopInfoPage> findWshopInfos(FindWshopInfoPage findWshopInfoPage);

}
