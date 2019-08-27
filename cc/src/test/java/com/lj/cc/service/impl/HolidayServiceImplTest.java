

package com.lj.cc.service.impl;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

import com.lj.cc.service.IHolidayService;
import com.lj.base.mvc.web.test.SpringTestCase;



/**
 * 类说明：
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author LeoPeng
 * 
 * 
 * CreateDate: 2017-5-13
 */
public class HolidayServiceImplTest extends SpringTestCase{
	
	
	@Resource
	private IHolidayService holidayService;
	
	/**
	 * 
	 *
	 * 方法说明：
	 *
	 *
	 * @author 彭阳 CreateDate: 2017年6月31日
	 *
	 */
	@Test
	public void findDayType(){
		Date dayDate = new Date();
		dayDate = DateUtils.truncate(dayDate, Calendar.DAY_OF_MONTH);
		holidayService.findDayType_date(dayDate);
		holidayService.findDayType_date(dayDate);
		String dayStr = "20160917";
		holidayService.findDayType_str(dayStr);
		holidayService.findDayType_str(dayStr);
	}
	
	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @throws Exception
	 *
	 * @author 彭阳 CreateDate: 2017年6月31日
	 *
	 */
	@Test
	public void initHoliday() throws Exception{
		Date dayDate = new Date();
		dayDate = DateUtils.truncate(dayDate, Calendar.DAY_OF_MONTH);
		holidayService.initHoliday(dayDate);
	}
}
