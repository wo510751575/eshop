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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.lj.eshop.dto.AccWaterDto;
import com.lj.eshop.dto.FindAccWaterPage;
import com.lj.eshop.emus.AccWaterAccType;
import com.lj.eshop.emus.AccWaterBizType;
import com.lj.eshop.emus.AccWaterPayType;
import com.lj.eshop.emus.AccWaterSource;
import com.lj.eshop.emus.AccWaterStatus;
import com.lj.eshop.emus.AccWaterType;
import com.lj.eshop.service.IAccWaterService;

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
public class AccWaterServiceImplTest extends SpringTestCase{

	@Resource
	IAccWaterService accWaterService;



	/**
	 * 
	 *
	 * 方法说明：添加账户流水信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addAccWater() throws TsfaServiceException{
		AccWaterDto accWaterDto = new AccWaterDto();
		//add数据录入
		accWaterDto.setCode("Code");
		accWaterDto.setAccWaterNo("AccWaterNo"+System.currentTimeMillis());
		accWaterDto.setAccDate(new Date());
		accWaterDto.setAccSource(AccWaterSource.DEPOSIT.getValue());
		accWaterDto.setAccType(AccWaterAccType.MANUAL.getValue());
		accWaterDto.setTranOrderNo("orderNo"+System.currentTimeMillis());
		accWaterDto.setAmt(new BigDecimal(1));
		accWaterDto.setAccNo("AccNo"+((System.currentTimeMillis()+"").substring(0, 10)));
		accWaterDto.setStatus("1");
		accWaterDto.setPayType(AccWaterPayType.ALI.getValue());
		accWaterDto.setBeforeAmt(new BigDecimal(1));
		accWaterDto.setAfterAmt(new BigDecimal(2));
		accWaterDto.setBizType(AccWaterBizType.REFUND.getValue());
		accWaterDto.setUpdateTime(new Date());
		accWaterDto.setOpCode("OpCode");
		accWaterDto.setWaterType(AccWaterType.ADD.getValue());
		
		accWaterService.addAccWater(accWaterDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改账户流水信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateAccWater() throws TsfaServiceException{
		AccWaterDto accWaterDto = new AccWaterDto();
		//update数据录入
		accWaterDto.setCode("Code");
		accWaterDto.setAccWaterNo("AccWaterNo");
		accWaterDto.setAccDate(new Date());
		accWaterDto.setAccSource("AccSource");
		accWaterDto.setAccType("AccType");
		accWaterDto.setTranOrderNo("TranOrderNo");
		accWaterDto.setAmt(new BigDecimal(1));
		accWaterDto.setAccNo("AccNo");
		accWaterDto.setStatus("Status");
		accWaterDto.setPayType("PayType");
		accWaterDto.setBeforeAmt(new BigDecimal(1));
		accWaterDto.setAfterAmt(new BigDecimal(2));
		accWaterDto.setBizType("BizType");
		accWaterDto.setUpdateTime(new Date());
		accWaterDto.setOpCode("OpCode");

		accWaterService.updateAccWater(accWaterDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找账户流水信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findAccWater() throws TsfaServiceException{
		AccWaterDto findAccWater = new AccWaterDto();
		findAccWater.setCode("111");
		accWaterService.findAccWater(findAccWater);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找账户流水信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findAccWaterPage() throws TsfaServiceException{
		FindAccWaterPage findAccWaterPage = new FindAccWaterPage();
		findAccWaterPage.setEndTime(new Date());
		Page<AccWaterDto> page = accWaterService.findAccWaterPage(findAccWaterPage);
		Assert.assertNotNull(page);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找账户流水信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findAccWaters() throws TsfaServiceException{
		FindAccWaterPage findAccWaterPage = new FindAccWaterPage();
//		AccWaterDto accWaterDto = new AccWaterDto();
//		accWaterDto.setAccSource(AccWaterSource.DEPOSIT.getValue());
//		accWaterDto.setAccType(AccWaterAccType.MANUAL.getValue());
//		accWaterDto.setStatus(AccWaterStatus.IN_PROGRESS.getValue());
//		accWaterDto.setPayType(AccWaterPayType.WX.getValue());
//		accWaterDto.setBizType(AccWaterBizType.REFUND.getValue());
//		accWaterDto.setWaterType(AccWaterType.SUBTRACT.getValue());
//		findAccWaterPage.setParam(accWaterDto);
		List<AccWaterDto> page = accWaterService.findAccWaters(findAccWaterPage);
		Assert.assertNotNull(page);
		System.out.println(page.size());
		
	}
	
	@Test
	public void findIncomeAmt() throws TsfaServiceException{
		/*当天收益*/
		Date now =new Date();
		Calendar calendar =  org.apache.commons.lang.time.DateUtils.toCalendar(now);
		//将小时至0  
		calendar.set(Calendar.HOUR_OF_DAY, 0);  
		//将分钟至0  
		calendar.set(Calendar.MINUTE, 0);  
		//将秒至0  
		calendar.set(Calendar.SECOND,0);  
		Date startTime= calendar.getTime();
		
		//将小时至23  
		calendar.set(Calendar.HOUR_OF_DAY, 23);  
		//将分钟至59  
		calendar.set(Calendar.MINUTE, 59);  
		//将秒至59  
		calendar.set(Calendar.SECOND,59);  
		Date endTime= calendar.getTime();
		
		/*统计流水收益*/
		AccWaterDto paramWaterDto = new AccWaterDto();
		paramWaterDto.setAccCode("LJ_1eb863856573406c956c0478abf47111");
		paramWaterDto.setWaterType(AccWaterType.ADD.getValue());
		paramWaterDto.setBizType(AccWaterBizType.COMMISSION.getValue());
		paramWaterDto.setStatus(AccWaterStatus.SUCCESS.getValue());
		FindAccWaterPage findAccWaterPage = new FindAccWaterPage();
		findAccWaterPage.setParam(paramWaterDto);
		findAccWaterPage.setStartTime(startTime);
		findAccWaterPage.setEndTime(endTime);
		BigDecimal decimal= accWaterService.findIncomeAmt(findAccWaterPage);
		System.out.println(decimal);
	}
}
