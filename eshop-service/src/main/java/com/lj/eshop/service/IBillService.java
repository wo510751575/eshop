package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.BillDto;
import com.lj.eshop.dto.FindBillPage;


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
public interface IBillService {
	
	/**
	 * 
	 *
	 * 方法说明：添加大B账单信息
	 *
	 * @param billDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addBill(BillDto billDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找大B账单信息
	 *
	 * @param findBill
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public BillDto findBill(BillDto billDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询大B账单信息
	 *
	 * @param findBillPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<BillDto>  findBills(FindBillPage findBillPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改大B账单信息
	 *
	 * @param updateBill
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateBill(BillDto billDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询大B账单信息
	 *
	 * @param findBillPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<BillDto> findBillPage(FindBillPage findBillPage) throws TsfaServiceException;
	

}
