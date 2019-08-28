package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.lj.eshop.dto.BillDto;
import com.lj.eshop.dto.FindBillPage;
import com.lj.eshop.service.IBillService;

/**
 * 类说明：测试类
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
public class BillServiceImplTest extends SpringTestCase{

	@Resource
	IBillService billService;



	/**
	 * 
	 *
	 * 方法说明：添加大B账单信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addBill() throws TsfaServiceException{
		BillDto billDto = new BillDto();
		//add数据录入
		billDto.setCode("Code");
		billDto.setSupplyName("SupplyName");
		billDto.setSupplyCode("SupplyCode");
		billDto.setPhone("Phone");
		billDto.setBillAddr("BillAddr");
		billDto.setPayType("PayType");
		billDto.setAccountDays("AccountDays");
		billDto.setStatus("Status");
		billDto.setBillDate(new Date());
		billDto.setPayDate(new Date());
		billDto.setAmt(new BigDecimal(2));
		billDto.setStartDate(new Date());
		billDto.setEndDate(new Date());
		billDto.setRetireAmt(new BigDecimal(2));
		billDto.setBillFileAddrs("BillFileAddrs");
		billDto.setCnt(1);
		billDto.setRtCnt(1);
		
		billService.addBill(billDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改大B账单信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateBill() throws TsfaServiceException{
		BillDto billDto = new BillDto();
		//update数据录入
		billDto.setCode("Code");
		billDto.setSupplyName("SupplyName");
		billDto.setSupplyCode("SupplyCode");
		billDto.setPhone("Phone");
		billDto.setBillAddr("BillAddr");
		billDto.setPayType("PayType");
		billDto.setAccountDays("AccountDays");
		billDto.setStatus("Status");
		billDto.setBillDate(new Date());
		billDto.setPayDate(new Date());
		billDto.setAmt(new BigDecimal(2));
		billDto.setStartDate(new Date());
		billDto.setEndDate(new Date());
		billDto.setRetireAmt(new BigDecimal(2));
		billDto.setBillFileAddrs("BillFileAddrs");
		billDto.setCnt(1);
		billDto.setRtCnt(1);

		billService.updateBill(billDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找大B账单信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findBill() throws TsfaServiceException{
		BillDto findBill = new BillDto();
		findBill.setCode("111");
		billService.findBill(findBill);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找大B账单信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findBillPage() throws TsfaServiceException{
		FindBillPage findBillPage = new FindBillPage();
		Page<BillDto> page = billService.findBillPage(findBillPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找大B账单信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findBills() throws TsfaServiceException{
		FindBillPage findBillPage = new FindBillPage();
		List<BillDto> page = billService.findBills(findBillPage);
		Assert.assertNotNull(page);
		
	}
	
}
