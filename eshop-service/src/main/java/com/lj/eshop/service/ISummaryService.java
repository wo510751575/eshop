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
import com.lj.eshop.dto.FindSummaryPage;
import com.lj.eshop.dto.SummaryDto;
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
public interface ISummaryService {
	
	/**
	 * 
	 *
	 * 方法说明：添加统计信息信息
	 *
	 * @param summaryDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addSummary(SummaryDto summaryDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找统计信息信息
	 *
	 * @param findSummary
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public SummaryDto findSummary(SummaryDto summaryDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询统计信息信息
	 *
	 * @param findSummaryPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<SummaryDto>  findSummarys(FindSummaryPage findSummaryPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改统计信息信息
	 *
	 * @param updateSummary
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateSummary(SummaryDto summaryDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询统计信息信息
	 *
	 * @param findSummaryPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<SummaryDto> findSummaryPage(FindSummaryPage findSummaryPage) throws TsfaServiceException;
	
	public void orderCount();

	/**
	 * 
	 *
	 * 方法说明：客户量统计
	 *
	 *
	 * @author 段志鹏 CreateDate: 2017年9月11日
	 *
	 */
	public void memberSummary()throws TsfaServiceException;
	/**
	 * 
	 *
	 * 方法说明：销售额统计
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年9月11日
	 *
	 */
	public void amtSummary()throws TsfaServiceException;
	/**
	 * 
	 *
	 * 方法说明：商品分类统计 
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017年9月12日
	 *
	 */
	public void productCatalogSummary()throws TsfaServiceException;
	/**
	 * 
	 *
	 * 方法说明：订单统计
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年9月20日
	 *
	 */
	public void orderSummary()throws TsfaServiceException;
}
