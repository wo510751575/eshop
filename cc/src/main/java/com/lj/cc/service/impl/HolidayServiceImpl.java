
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lj.cc.dao.IHolidayDao;
import com.lj.cc.common.ErrorCode;
import com.lj.cc.domain.Holiday;
import com.lj.cc.service.IHolidayService;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.httpclient.HttpClientUtils;


/**
 * 
 * 
 * 类说明：节假日服务
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 杨恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月15日
 */
@Service
public class HolidayServiceImpl implements IHolidayService {
 

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(HolidayServiceImpl.class);

	/** The holiday dao. */
	@Resource
	private IHolidayDao holidayDao;

	/* (non-Javadoc)
	 * @see com.lj.cc.service.IHolidayService#findDayType_str(java.lang.String)
	 */
	@Override
	@Cacheable(value="findDayType_str")
	public String findDayType_str(String dayStr) throws TsfaServiceException {
		logger.debug("findDayType_str(String dayStr={}) - start", dayStr); 

		AssertUtils.notNullAndEmpty(dayStr);
		try {
			String dayType = holidayDao.selectByDayStr(dayStr);
			if(StringUtils.isEmpty(dayType)){
				dayType = initHoliday(DateUtils.parseDate(dayStr, DateUtils.PATTERN_yyyyMMdd));
			}
			
			if(StringUtils.isEmpty(dayType)){
				throw new TsfaServiceException(ErrorCode.HOLIDAY_NOT_EXIST_ERROR,"当日数据不存在");
			}

			logger.debug("findDayType_str(String) - end - return value={}", dayType); 
			return dayType;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("holiday查询失败",e);
			throw new TsfaServiceException(ErrorCode.HOLIDAY_QUERY_ERROR,"holiday查询失败",e);
		}

	}

	/* (non-Javadoc)
	 * @see com.lj.cc.service.IHolidayService#findDayType_date(java.util.Date)
	 */
	@Override
	@Cacheable(value="findDayType_date")
	public String findDayType_date(Date dayDate) throws TsfaServiceException {
		logger.debug("findDayType_date(Date dayDate={}) - start", dayDate); 

		AssertUtils.notNull(dayDate);
		try {
			String dayType = holidayDao.selectByDayDate(dayDate);
			if(StringUtils.isEmpty(dayType)){//除去时分秒
				dayDate = org.apache.commons.lang.time.DateUtils.truncate(dayDate, Calendar.DAY_OF_MONTH);
				dayType = holidayDao.selectByDayDate(dayDate);
			}
			
			if(StringUtils.isEmpty(dayType)){//初始化
				dayType = initHoliday(dayDate);
			}
			
			if(StringUtils.isEmpty(dayType)){
				throw new TsfaServiceException(ErrorCode.HOLIDAY_NOT_EXIST_ERROR,"当日数据不存在");
			}

			logger.debug("findDayType_date(Date) - end - return value={}", dayType); 
			return dayType;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("holiday查询失败",e);
			throw new TsfaServiceException(ErrorCode.HOLIDAY_QUERY_ERROR,"holiday查询失败",e);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.cc.service.IHolidayService#initHoliday(java.util.Date)
	 */
	public String initHoliday(Date dayDate) throws TsfaServiceException {
		try {
			dayDate = org.apache.commons.lang.time.DateUtils.truncate(dayDate, Calendar.DAY_OF_MONTH);
			String d = DateUtils.formatDate(dayDate, DateUtils.PATTERN_yyyyMMdd);
			String httpUrl = "http://www.easybots.cn/api/holiday.php?d="+ d; 
			String jsonResult =HttpClientUtils.getFromWeb(httpUrl);
			if(jsonResult.indexOf(d) != -1)
				jsonResult = jsonResult.substring(13,14);
			logger.debug("【节假日判断】d="+d+" jsonResult:" + jsonResult);
			if(!"0".equals(jsonResult) && !"1".equals(jsonResult) && !"2".equals(jsonResult) ){//返回结果是 0 1 2 只外的结果
				logger.error("---【节假日判断】外网接口返回错误！"+jsonResult);
				throw new TsfaServiceException(ErrorCode.HOLIDAY_NOT_EXIST_ERROR,"当日数据不存在");
			}
			Holiday record = new Holiday();
			record.setDayDate(dayDate);
			record.setDayStr(d);
			record.setDayType(jsonResult);
			holidayDao.replace(record );
			return jsonResult;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("holiday查询失败",e);
			throw new TsfaServiceException(ErrorCode.HOLIDAY_INIT_ERROR,"holiday初始化失败",e);
		}
	}



}
