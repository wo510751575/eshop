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

import java.util.Date;
import java.util.List;

import com.lj.eshop.dto.SupplyDto;
import com.lj.eshop.dto.FindSupplyPage;
import com.lj.eshop.service.ISupplyService;

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
public class SupplyServiceImplTest extends SpringTestCase{

	@Resource
	ISupplyService supplyService;



	/**
	 * 
	 *
	 * 方法说明：添加供应商信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addSupply() throws TsfaServiceException{
		SupplyDto supplyDto = new SupplyDto();
		//add数据录入
		supplyDto.setCode("Code");
		supplyDto.setSupplyName("SupplyName");
		supplyDto.setSupplyCode("SupplyCode");
		supplyDto.setTel("Tel");
		supplyDto.setEmail("Email");
		supplyDto.setStatus("1");
		supplyDto.setFax("Fax");
		supplyDto.setPayType("1");
		supplyDto.setAccountDays("1");
		supplyDto.setBankNo("BankNo");
		supplyDto.setBankName("BankName");
		supplyDto.setRemarks("Remarks");
		supplyDto.setDiscountOff("1");
		supplyDto.setBillStart(new Date());
		supplyDto.setAddrs("Addrs");
		supplyDto.setMerchantCode("MerchantCode");
		supplyDto.setMerchantName("MerchantName");
		
		supplyService.addSupply(supplyDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改供应商信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateSupply() throws TsfaServiceException{
		SupplyDto supplyDto = new SupplyDto();
		//update数据录入
		supplyDto.setCode("Code");
		supplyDto.setSupplyName("SupplyName");
		supplyDto.setSupplyCode("SupplyCode");
		supplyDto.setTel("Tel");
		supplyDto.setEmail("Email");
		supplyDto.setStatus("1");
		supplyDto.setFax("Fax");
		supplyDto.setPayType("PayType");
		supplyDto.setAccountDays("AccountDays");
		supplyDto.setBankNo("BankNo");
		supplyDto.setBankName("BankName");
		supplyDto.setRemarks("Remarks");
		supplyDto.setDiscountOff("DiscountOff");
		supplyDto.setBillStart(new Date());
		supplyDto.setAddrs("Addrs");
		supplyDto.setMerchantCode("MerchantCode");
		supplyDto.setMerchantName("MerchantName");

		supplyService.updateSupply(supplyDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找供应商信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findSupply() throws TsfaServiceException{
		SupplyDto findSupply = new SupplyDto();
		findSupply.setCode("111");
		supplyService.findSupply(findSupply);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找供应商信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findSupplyPage() throws TsfaServiceException{
		FindSupplyPage findSupplyPage = new FindSupplyPage();
		Page<SupplyDto> page = supplyService.findSupplyPage(findSupplyPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找供应商信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findSupplys() throws TsfaServiceException{
		FindSupplyPage findSupplyPage = new FindSupplyPage();
		List<SupplyDto> page = supplyService.findSupplys(findSupplyPage);
		Assert.assertNotNull(page);
		
	}
	
}
