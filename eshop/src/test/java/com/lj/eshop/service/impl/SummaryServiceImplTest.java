package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.alibaba.druid.support.json.JSONUtils;
import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.base.json.JsonUtils;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.eshop.dao.ISummaryDao;
import com.lj.eshop.domain.Summary;
import com.lj.eshop.dto.FindSummaryPage;
import com.lj.eshop.dto.SummaryDto;
import com.lj.eshop.dto.SummaryShowDto;
import com.lj.eshop.emus.DimensionSt;
import com.lj.eshop.service.ISummaryService;

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
 *         CreateDate: 2017-08-22
 */
public class SummaryServiceImplTest extends SpringTestCase {

	@Resource
	ISummaryService summaryService;
	@Resource
	ISummaryDao summaryDao;

	/**
	 * 
	 *
	 * 方法说明：添加统计信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addSummary() throws TsfaServiceException {
		// add数据录入
		List<Summary> summarys = summaryDao.orderCount();
		for (Summary s : summarys) {
			Summary summary = new Summary();
			summary.setCode(GUID.generateCode());
			summary.setCount(s.getCount());
			summary.setDaySt(new Date());
			summary.setDimensionSt(DimensionSt.ORDER.getValue());
			summary.setRatio(s.getRatio());
			summary.setOrderStatus(s.getOrderStatus());
			summary.setCatalogCode(s.getCatalogCode());
			summary.setMerchantCode(s.getMerchantCode());
			summary.setMerchantName(s.getMerchantName());
			summary.setShopCode(s.getShopCode());
			summary.setShopName(s.getShopName());
			summaryDao.insertSelective(summary);
		}
	}

	/**
	 * 
	 *
	 * 方法说明：修改统计信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateSummary() throws TsfaServiceException {
		SummaryDto summaryDto = new SummaryDto();
		// update数据录入
		summaryDto.setCode("Code");
		// summaryDto.setTypeCode("TypeCode");
		// summaryDto.setTypeName("TypeName");
		// summaryDto.setCnt("Cnt");
		// summaryDto.setSumDate(new Date());

		summaryService.updateSummary(summaryDto);

	}

	/**
	 * 
	 *
	 * 方法说明：查找统计信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findSummary() throws TsfaServiceException {
		SummaryDto findSummary = new SummaryDto();
		findSummary.setCode("111");
		summaryService.findSummary(findSummary);
	}

	/**
	 * 
	 *
	 * 方法说明：查找统计信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findSummaryPage() throws TsfaServiceException {
		FindSummaryPage findSummaryPage = new FindSummaryPage();
		Page<SummaryDto> page = summaryService.findSummaryPage(findSummaryPage);
		Assert.assertNotNull(page);

	}

	/**
	 * 
	 *
	 * 方法说明：查找统计信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findSummarys() throws TsfaServiceException {
		FindSummaryPage findSummaryPage = new FindSummaryPage();
		List<SummaryDto> page = summaryService.findSummarys(findSummaryPage);
		Assert.assertNotNull(page);

	}

	@Test
	public void memberSummary() throws TsfaServiceException {
		summaryService.memberSummary();
	}

	@Test
	public void amtSummary() throws TsfaServiceException {
		summaryService.amtSummary();
	}
	
	@Test
	public void productCatalogSummary() throws TsfaServiceException{
		summaryService.productCatalogSummary();
	}
	

	@Test
	public void job() throws TsfaServiceException {

		/* 会员统计 */
		summaryService.memberSummary();
		/* 销售额统计 */
		summaryService.amtSummary();
		/* 订单统计 */
		summaryService.orderSummary();
		/* 商品类别统计 */
		summaryService.productCatalogSummary();
	}
	@Test
	public void findSummaryByType() throws TsfaServiceException {
		FindSummaryPage findSummaryPage = new FindSummaryPage();
		SummaryDto d = new SummaryDto();
		findSummaryPage.setParam(d);
		d.setDays(7);
		d.setDimensionSt("0");
		d.setShopCode("LJ_71011bdb03d149659061d03606488f81");
		SummaryShowDto data = summaryService.findSummaryByType(findSummaryPage);
		System.out.println(JsonUtils.jsonFromObject(data));
	}
	
	
}
