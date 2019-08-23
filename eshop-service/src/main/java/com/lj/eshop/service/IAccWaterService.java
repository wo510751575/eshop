package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.AccWaterDto;
import com.lj.eshop.dto.FindAccWaterPage;
import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;

import java.math.BigDecimal;
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
public interface IAccWaterService {
	
	/**
	 * 
	 *
	 * 方法说明：添加账户流水信息
	 *
	 * @param accWaterDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addAccWater(AccWaterDto accWaterDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找账户流水信息
	 *
	 * @param findAccWater
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public AccWaterDto findAccWater(AccWaterDto accWaterDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询账户流水信息
	 *
	 * @param findAccWaterPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<AccWaterDto>  findAccWaters(FindAccWaterPage findAccWaterPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改账户流水信息
	 *
	 * @param updateAccWater
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateAccWater(AccWaterDto accWaterDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询账户流水信息
	 *
	 * @param findAccWaterPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<AccWaterDto> findAccWaterPage(FindAccWaterPage findAccWaterPage) throws TsfaServiceException;
	
	/**
	 * 方法说明：查找总收入。
	 *
	 * @param findAccWaterPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy  2017年9月5日
	 *
	 */
	public BigDecimal findIncomeAmt(FindAccWaterPage findAccWaterPage) throws TsfaServiceException;

	/**
	 * 方法说明：分页查找收益明细
	 *
	 * @param findAccWaterPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017.09.06
	 *
	 */
	public Page<AccWaterDto> findAcctWaterDetailPage(FindAccWaterPage findAccWaterPage) throws TsfaServiceException;
	
	/**
	 * 方法说明：分页查找收支明细
	 *
	 * @param findAccWaterPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017.09.06
	 *
	 */
	public Page<AccWaterDto> findAllAcctWaterDetailPage(FindAccWaterPage findAccWaterPage) throws TsfaServiceException;
	
}
