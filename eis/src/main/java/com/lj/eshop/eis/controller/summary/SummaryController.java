/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.summary;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.dto.CatalogSummaryDto;
import com.lj.eshop.dto.FindMyAttentionPage;
import com.lj.eshop.dto.FindOrderPage;
import com.lj.eshop.dto.FindSummaryPage;
import com.lj.eshop.dto.MyAttentionDto;
import com.lj.eshop.dto.OrderDto;
import com.lj.eshop.dto.SummaryDto;
import com.lj.eshop.dto.SummaryShowDto;
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
 * @Company: 深圳扬恩科技有限公司
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
			rank=orderService.findAmtRank(findOrderPage);
			rank=(rank==null?0:rank);
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
		//商品销量统计 销售最优的商品
		CatalogSummaryDto product= orderService.findTopProductCatalog(findOrderPage);
		
		Map<String,Object> data=new HashMap<>();
		data.put("monthAmt", monthAmt);						//销售额
		data.put("rank", rank);								//销售排名
		data.put("attCount", attCount);						//客户量
		data.put("orderCount", orderCount);					//订单数
		data.put("returnsOrderCount", returnsOrderCount);	//退货订单数
		if(product!=null){
			data.put("cataLogName", product.getParentCataLogCode());//销量最好的商品类目
		}
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
		if(summaryDto==null||StringUtils.isEmpty(summaryDto.getDimensionSt())||summaryDto.getDays()==null){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		summaryDto.setShopCode(getLoginShopCode());
		findSummaryPage.setParam(summaryDto);
		SummaryShowDto data=summaryService.findSummaryByType(findSummaryPage);
		logger.debug("SummaryController --> list(={}) - end", data);
		
		return ResponseDto.successResp(data);
	}
	
	/**
	 *
	 * 方法说明：获取指定日期后延的日期。
	 *
	 * @param start 日期源
	 * @param i 加的天数
	 * @return
	 *
	 * @author lhy  2017年9月28日
	 *
	 */
	private  Date getDate(Date start,int i){
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = start;
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) + i);
		Date endDate;
		try {
			endDate = dft.parse(dft.format(date.getTime()));
		} catch (ParseException e) {
			logger.error("日期转换异常",e);
			throw new TsfaServiceException(ErrorCode.SUMMARY_NOT_EXIST_ERROR,"统计信息信息不存在",e);
		}
		return endDate;
	}
	
}
