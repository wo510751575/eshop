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
import java.util.List;

import com.lj.eshop.dto.WithdrawDto;
import com.lj.eshop.dto.FindWithdrawPage;
import com.lj.eshop.service.IWithdrawService;

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
public class WithdrawServiceImplTest extends SpringTestCase{

	@Resource
	IWithdrawService withdrawService;



	/**
	 * 
	 *
	 * 方法说明：添加提现申请信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addWithdraw() throws TsfaServiceException{
		WithdrawDto withdrawDto = new WithdrawDto();
		//add数据录入
		withdrawDto.setCode("Code");
		withdrawDto.setMbrName("MbrName");
		withdrawDto.setMbrCode("MbrCode");
		withdrawDto.setAmt(new BigDecimal(111));
		withdrawDto.setBankName("BankName");
		withdrawDto.setBankAccNo("BankAccNo");
		withdrawDto.setBranchBank("BranchBank");
		withdrawDto.setStatus("1");
		withdrawDto.setPhone("Phone");
		withdrawDto.setFailReason("FailReason");
		withdrawDto.setWithdrawNo("WithdrawNo");
		
		withdrawService.addWithdraw(withdrawDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改提现申请信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateWithdraw() throws TsfaServiceException{
		WithdrawDto withdrawDto = new WithdrawDto();
		//update数据录入
		withdrawDto.setCode("Code");
		withdrawDto.setMbrName("MbrName");
		withdrawDto.setMbrCode("MbrCode");
		withdrawDto.setAmt(new BigDecimal(111));
		withdrawDto.setBankName("BankName");
		withdrawDto.setBankAccNo("BankAccNo");
		withdrawDto.setBranchBank("BranchBank");
		withdrawDto.setStatus("1");
		withdrawDto.setPhone("Phone");
		withdrawDto.setFailReason("FailReason");
		withdrawDto.setWithdrawNo("WithdrawNo");

		withdrawService.updateWithdraw(withdrawDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找提现申请信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findWithdraw() throws TsfaServiceException{
		WithdrawDto findWithdraw = new WithdrawDto();
		findWithdraw.setCode("111");
		withdrawService.findWithdraw(findWithdraw);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找提现申请信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findWithdrawPage() throws TsfaServiceException{
		FindWithdrawPage findWithdrawPage = new FindWithdrawPage();
		Page<WithdrawDto> page = withdrawService.findWithdrawPage(findWithdrawPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找提现申请信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findWithdraws() throws TsfaServiceException{
		FindWithdrawPage findWithdrawPage = new FindWithdrawPage();
		List<WithdrawDto> page = withdrawService.findWithdraws(findWithdrawPage);
		Assert.assertNotNull(page);
		
	}
	
}
