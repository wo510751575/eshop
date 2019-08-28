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

import com.lj.eshop.dto.ShopRetireDto;
import com.lj.eshop.emus.AuditStatus;
import com.lj.eshop.emus.RetireStatus;
import com.lj.eshop.emus.ShopExpressStatus;
import com.lj.eshop.dto.FindShopRetirePage;
import com.lj.eshop.service.IShopRetireService;

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
public class ShopRetireServiceImplTest extends SpringTestCase{

	@Resource
	IShopRetireService shopRetireService;



	/**
	 * 
	 *
	 * 方法说明：添加店铺押金退出申请信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addShopRetire() throws TsfaServiceException{
		ShopRetireDto shopRetireDto = new ShopRetireDto();
		//add数据录入
		shopRetireDto.setRetireNo("RetireNo");
		shopRetireDto.setMbrCode("LJ_1eb863856573406c956c0478abf47a72");
		shopRetireDto.setShopCode("LJ_0e0a461585fa493794cc1368b87ec324");
		shopRetireDto.setAuditStatus("0");
//		shopRetireDto.setRetireStatus("RetireStatus");
//		shopRetireDto.setExpressNo("11111111");
//		shopRetireDto.setExpressStatus("ExpressStatus");
		shopRetireDto.setCreateTime(new Date());
		shopRetireDto.setUpdateTime(new Date());
		shopRetireDto.setAuditor("Auditor");
		shopRetireDto.setRemarks("Remarks");
		shopRetireDto.setExpressName("顺丰快递");
		shopRetireService.addShopRetire(shopRetireDto);
		
	}
	
	@Test
	public void applyShopRetire() throws TsfaServiceException{
		ShopRetireDto shopRetireDto = new ShopRetireDto();
		//add数据录入
		shopRetireDto.setRetireNo("RetireNo");
		shopRetireDto.setMbrCode("LJ_1eb863856573406c956c0478abf47a72");
		shopRetireDto.setShopCode("LJ_0e0a461585fa493794cc1368b87ec324");
		shopRetireDto.setAuditStatus(AuditStatus.WAIT.getValue());
		shopRetireDto.setRetireStatus(RetireStatus.SUCCESS.getValue());
		shopRetireDto.setExpressNo("expressNo111");
		shopRetireDto.setExpressStatus(ShopExpressStatus.WAIT.getValue());
		shopRetireDto.setCreateTime(new Date());
		shopRetireDto.setUpdateTime(new Date());
		shopRetireDto.setAuditor("Auditor");
		shopRetireDto.setRemarks("Remarks");
		shopRetireDto.setExpressName("顺丰快递");
		shopRetireService.addShopRetire(shopRetireDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改店铺押金退出申请信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateShopRetire() throws TsfaServiceException{
		ShopRetireDto shopRetireDto = new ShopRetireDto();
		//update数据录入
		shopRetireDto.setCode("Code");
		shopRetireDto.setRetireNo("RetireNo");
		shopRetireDto.setMbrCode("MbrCode");
		shopRetireDto.setShopCode("ShopCode");
		shopRetireDto.setAuditStatus("AuditStatus");
		shopRetireDto.setRetireStatus("RetireStatus");
		shopRetireDto.setExpressNo("ExpressNo");
		shopRetireDto.setExpressStatus("ExpressStatus");
		shopRetireDto.setCreateTime(new Date());
		shopRetireDto.setUpdateTime(new Date());
		shopRetireDto.setAuditor("Auditor");
		shopRetireDto.setRemarks("Remarks");
		shopRetireDto.setExpressName("ExpressName");

		shopRetireService.updateShopRetire(shopRetireDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店铺押金退出申请信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findShopRetire() throws TsfaServiceException{
		ShopRetireDto findShopRetire = new ShopRetireDto();
		findShopRetire.setCode("111");
		shopRetireService.findShopRetire(findShopRetire);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店铺押金退出申请信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findShopRetirePage() throws TsfaServiceException{
		FindShopRetirePage findShopRetirePage = new FindShopRetirePage();
		findShopRetirePage.setSortBy("r.create_time");
		ShopRetireDto retireDto = new ShopRetireDto();
		retireDto.setMbrCode("LJ_1eb863856573406c956c0478abf47a72");
		
		Page<ShopRetireDto> page = shopRetireService.findShopRetirePage(findShopRetirePage);
		Assert.assertNotNull(page);
		System.out.println(page.toString());
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找店铺押金退出申请信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findShopRetires() throws TsfaServiceException{
		FindShopRetirePage findShopRetirePage = new FindShopRetirePage();
		findShopRetirePage.setSortBy("r.create_time");
		ShopRetireDto retireDto = new ShopRetireDto();
		retireDto.setMbrCode("LJ_1eb863856573406c956c0478abf47a72");
		
		List<ShopRetireDto> page = shopRetireService.findShopRetires(findShopRetirePage);
		Assert.assertNotNull(page);
		
	}
	
	
}
