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

import com.lj.eshop.dto.AddrsDto;
import com.lj.eshop.dto.FindAddrsPage;
import com.lj.eshop.service.IAddrsService;

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
public class AddrsServiceImplTest extends SpringTestCase{

	@Resource
	IAddrsService addrsService;



	/**
	 * 
	 *
	 * 方法说明：添加收货地址信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addAddrs() throws TsfaServiceException{
		AddrsDto addrsDto = new AddrsDto();
		//add数据录入
		addrsDto.setCode("Code");
		addrsDto.setReciverName("ReciverName");
		addrsDto.setReciverPhone("13812345678");
		addrsDto.setReciverZip("ReciverZip");
		addrsDto.setMbrCode("MbrCode");
		addrsDto.setAddrInfo("AddrInfo");
		addrsDto.setIsDefault("0");
		addrsDto.setProvinceCode("ProvinceCode");
		addrsDto.setCityCode("CityCode");
		addrsDto.setAreCode("AreCode");
		addrsDto.setAddrDetail("AddrDetail");
		addrsDto.setCreateTime(new Date());
		addrsDto.setDelFlag("0");
		addrsService.addAddrs(addrsDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改收货地址信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateAddrs() throws TsfaServiceException{
		AddrsDto addrsDto = new AddrsDto();
		//update数据录入
		addrsDto.setCode("code");
		addrsDto.setReciverName("ReciverName");
		addrsDto.setReciverPhone("13812345678");
		addrsDto.setReciverZip("ReciverZip");
		addrsDto.setMbrCode("MbrCode");
		addrsDto.setAddrInfo("AddrInfo");
		addrsDto.setIsDefault("0");
		addrsDto.setProvinceCode("ProvinceCode");
		addrsDto.setCityCode("CityCode");
		addrsDto.setAreCode("AreCode");
		addrsDto.setAddrDetail("AddrDetail");
		addrsDto.setCreateTime(new Date());
		addrsDto.setDelFlag("2");
		addrsService.updateAddrs(addrsDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找收货地址信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findAddrs() throws TsfaServiceException{
		AddrsDto findAddrs = new AddrsDto();
		findAddrs.setCode("LJ_4481b3ed3a294bb5b9ff6201b469e908");
		AddrsDto addrsDto = addrsService.findAddrs(findAddrs);
		System.out.println(addrsDto);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找收货地址信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findAddrsPage() throws TsfaServiceException{
		FindAddrsPage findAddrsPage = new FindAddrsPage();
		Page<AddrsDto> page = addrsService.findAddrsPage(findAddrsPage);
		System.out.println(page);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找收货地址信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findAddrss() throws TsfaServiceException{
		FindAddrsPage findAddrsPage = new FindAddrsPage();
		List<AddrsDto> page = addrsService.findAddrss(findAddrsPage);
		System.out.println(page);
		Assert.assertNotNull(page);
		
	}
	
}
