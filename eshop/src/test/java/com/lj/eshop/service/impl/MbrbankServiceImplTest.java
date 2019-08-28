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

import com.lj.eshop.dto.MbrbankDto;
import com.lj.eshop.domain.MemberRank;
import com.lj.eshop.dto.FindMbrbankPage;
import com.lj.eshop.service.IMbrbankService;

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
public class MbrbankServiceImplTest extends SpringTestCase{

	@Resource
	IMbrbankService mbrbankService;



	/**
	 * 
	 *
	 * 方法说明：添加银行卡信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addMbrbank() throws TsfaServiceException{
		MbrbankDto mbrbankDto = new MbrbankDto();
		//add数据录入
		mbrbankDto.setCode("Code");
		mbrbankDto.setMbrCode("MbrCode");
		mbrbankDto.setBankName("BankName");
		mbrbankDto.setBranchBank("BranchBank");
		mbrbankDto.setBankAccNo("BankAccNo");
		mbrbankDto.setAccName("AccName");
		mbrbankDto.setCreateTime(new Date());
		
		mbrbankService.addMbrbank(mbrbankDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改银行卡信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateMbrbank() throws TsfaServiceException{
		MbrbankDto mbrbankDto = new MbrbankDto();
		//update数据录入
		mbrbankDto.setCode("Code");
		mbrbankDto.setMbrCode("MbrCode");
		mbrbankDto.setBankName("BankName");
		mbrbankDto.setBranchBank("BranchBank");
		mbrbankDto.setBankAccNo("BankAccNo");
		mbrbankDto.setAccName("AccName");
		mbrbankDto.setCreateTime(new Date());

		mbrbankService.updateMbrbank(mbrbankDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找银行卡信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMbrbank() throws TsfaServiceException{
		MbrbankDto findMbrbank = new MbrbankDto();
		findMbrbank.setCode("LJ_64407503b3954acfb07c9ce21fc96838");
		MbrbankDto memberRank = mbrbankService.findMbrbank(findMbrbank);
		System.out.println(memberRank);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找银行卡信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMbrbankPage() throws TsfaServiceException{
		FindMbrbankPage findMbrbankPage = new FindMbrbankPage();
		Page<MbrbankDto> page = mbrbankService.findMbrbankPage(findMbrbankPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找银行卡信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMbrbanks() throws TsfaServiceException{
		FindMbrbankPage findMbrbankPage = new FindMbrbankPage();
		List<MbrbankDto> page = mbrbankService.findMbrbanks(findMbrbankPage);
		Assert.assertNotNull(page);
		
	}
	
}
