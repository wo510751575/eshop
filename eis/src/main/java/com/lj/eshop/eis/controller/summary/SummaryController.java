/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.summary;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.StringUtils;
import com.lj.eshop.dto.FindMyAttentionPage;
import com.lj.eshop.dto.FindOrderPage;
import com.lj.eshop.dto.FindSummaryPage;
import com.lj.eshop.dto.MyAttentionDto;
import com.lj.eshop.dto.OrderDto;
import com.lj.eshop.dto.SummaryDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.emus.OrderStatus;
import com.lj.eshop.service.IMyAttentionService;
import com.lj.eshop.service.IOrderService;
import com.lj.eshop.service.ISummaryService;

/**
 * 
 * 类说明：数据统计-首页
 * 
 * <p>
 * 
 * @Company: 领居科技有限公司
 * @author 彭俊霖
 * 
 *         CreateDate: 2017年9月11日
 */
@RestController
@RequestMapping("/summary")
public class SummaryController extends BaseController {

	@Autowired
	private ISummaryService summaryService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IMyAttentionService myAttentionService;

	/**
	 * 方法说明： 数据统计-首页
	 * 
	 * @author 彭俊霖
	 *         CreateDate: 2017年9月11日
	 */
	@RequestMapping(value = {"index"})
	@ResponseBody
	public ResponseDto index() {
		logger.debug("SummaryController --> index() - start"); 
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		//时间推至一周前
		calendar.add(Calendar.WEEK_OF_YEAR, -1);
		//将小时至0  
		calendar.set(Calendar.HOUR_OF_DAY, 0);  
		//将分钟至0  
		calendar.set(Calendar.MINUTE, 0);  
		//将秒至0  
		calendar.set(Calendar.SECOND,0);  
		Date startTime= calendar.getTime();
		/*获取店铺销售额*/
		FindOrderPage findOrderPage = new FindOrderPage();
		OrderDto paramOrderDto = new OrderDto();
		paramOrderDto.setShopCode(getLoginShopCode());
		paramOrderDto.setStartTime(DateUtils.formatDate(startTime, DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
		paramOrderDto.setEndTime(DateUtils.formatDate(now, DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
		findOrderPage.setParam(paramOrderDto);
		BigDecimal monthAmt;
		try {
			monthAmt= orderService.findAmtSum(findOrderPage);
		} catch (Exception e) {
			logger.error("my_b 当天收益>>", e);
			monthAmt = new BigDecimal(0);
		}
		/*获取店铺销售排名*/
		Integer rank;
		try {
			rank=orderService.findAmtRank(getLoginShopCode())==null?0:orderService.findAmtRank(getLoginShopCode());
		} catch (Exception e) {
			logger.error("my_b 当日排名>>", e);
			rank = 0;
		}
		/*获取店铺客户量*/
		FindMyAttentionPage findMyAttentionPage = new FindMyAttentionPage();
		MyAttentionDto paramMy = new MyAttentionDto();
		paramMy.setShopCode(getLoginShopCode());
		paramMy.setStartTime(DateUtils.formatDate(startTime, DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
		paramMy.setEndTime(DateUtils.formatDate(now, DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
		findMyAttentionPage.setParam(paramMy);
		Integer attCount;
		try {
			attCount=myAttentionService.findMyAttentionPageCount(findMyAttentionPage);
		} catch (Exception e) {
			logger.error("my_attention 当日客户量>>", e);
			attCount = 0;
		}
		/*获取店铺订单量,退货订单量*/
		int orderCount;
		int returnsOrderCount;
		try {
			orderCount=orderService.findOrderPageCount(findOrderPage);
			paramOrderDto.setStatus(OrderStatus.RETURNS.getValue());
			findOrderPage.setParam(paramOrderDto);
			returnsOrderCount=orderService.findOrderPageCount(findOrderPage);
		} catch (Exception e) {
			logger.error("my_b 当日订单量>>", e);
			orderCount = 0;
			returnsOrderCount = 0;
		}
		
		Map<String,Object> data=new HashMap<>();
		data.put("monthAmt", monthAmt);						//销售额
		data.put("rank", rank);								//销售排名
		data.put("attCount", attCount);						//客户量
		data.put("orderCount", orderCount);					//订单数
		data.put("returnsOrderCount", returnsOrderCount);	//退货订单数
		
		logger.debug("SummaryController --> index(={}) - end");
		return ResponseDto.successResp(data);
	}
	
	/**
	 * 方法说明： 数据统计-详情列表
	 * 
	 * @author 彭俊霖
	 *         CreateDate: 2017年9月11日
	 */
	@RequestMapping(value = {"list"})
	@ResponseBody
	public ResponseDto list(SummaryDto summaryDto,Integer pageNo,Integer pageSize) {
		FindSummaryPage findSummaryPage = new FindSummaryPage();
		findSummaryPage.setParam(summaryDto);
		logger.debug("SummaryController --> list() - start", findSummaryPage); 
		
		if(summaryDto==null||StringUtils.isEmpty(summaryDto.getDimensionSt())){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		if(pageNo!=null){
			findSummaryPage.setStart((pageNo-1)*pageSize);
		}
		if(pageSize!=null){
			findSummaryPage.setLimit(pageSize);
		}
		
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		//时间推至一周前
		calendar.add(Calendar.WEEK_OF_YEAR, -1);
		//将小时至0  
		calendar.set(Calendar.HOUR_OF_DAY, 0);  
		//将分钟至0  
		calendar.set(Calendar.MINUTE, 0);  
		//将秒至0  
		calendar.set(Calendar.SECOND,0);
		Date startTime=calendar.getTime();
		if (StringUtils.isEmpty(summaryDto.getStartTime())) {
			summaryDto.setStartTime(DateUtils.formatDate(startTime, DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
		}
		
		calendar.setTime(now);
		//将小时至23  
		calendar.set(Calendar.HOUR_OF_DAY, 23);  
		//将分钟至59  
		calendar.set(Calendar.MINUTE, 59);  
		//将秒至59  
		calendar.set(Calendar.SECOND,59);  
		Date endTime= calendar.getTime();
		if (StringUtils.isEmpty(summaryDto.getEndTime())) {
			summaryDto.setEndTime(DateUtils.formatDate(endTime, DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
		}
		
		findSummaryPage.setParam(summaryDto);
		Page<SummaryDto> summarys=summaryService.findSummaryPage(findSummaryPage);
		List<SummaryDto> list = new ArrayList<SummaryDto>();
		list.addAll(summarys.getRows());
		
		if(summarys.getRows()==null || list.size()<=0){
			return ResponseDto.createResp(false, ResponseCode.NO_DATA.getCode(), ResponseCode.NO_DATA.getMsg(), null);
		}
		
		logger.debug("SummaryController --> list(={}) - end", list);
		return ResponseDto.successResp(summarys);
	}
	
}
