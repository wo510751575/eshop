package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.dao.ISummaryDao;
import com.lj.eshop.domain.Summary;
import com.lj.eshop.dto.CatalogDto;
import com.lj.eshop.dto.CatalogSummaryDto;
import com.lj.eshop.dto.FindCatalogPage;
import com.lj.eshop.dto.FindMerchantPage;
import com.lj.eshop.dto.FindMyAttentionPage;
import com.lj.eshop.dto.FindOrderPage;
import com.lj.eshop.dto.FindShopPage;
import com.lj.eshop.dto.FindSummaryPage;
import com.lj.eshop.dto.MerchantDto;
import com.lj.eshop.dto.MyAttentionDto;
import com.lj.eshop.dto.OrderDto;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.dto.SummaryDayDto;
import com.lj.eshop.dto.SummaryDto;
import com.lj.eshop.dto.SummaryRadioDto;
import com.lj.eshop.dto.SummaryShowDto;
import com.lj.eshop.emus.DimensionSt;
import com.lj.eshop.emus.OrderStatus;
import com.lj.eshop.emus.SummaryDimensionSt;
import com.lj.eshop.service.ICatalogService;
import com.lj.eshop.service.IMerchantService;
import com.lj.eshop.service.IMyAttentionService;
import com.lj.eshop.service.IOrderService;
import com.lj.eshop.service.IShopService;
import com.lj.eshop.service.ISummaryService;
/**
 * 类说明：实现类
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
@Service
//@Lazy(false)
public class SummaryServiceImpl implements ISummaryService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(SummaryServiceImpl.class);
	

	@Resource
	private ISummaryDao summaryDao;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IMyAttentionService myAttentionService;
	@Autowired
	private IMerchantService merchantService;
	@Autowired
	private IShopService shopService;
	@Autowired
	private ICatalogService catalogService;
	
	
	
	@Override
	public void addSummary(
			SummaryDto summaryDto) throws TsfaServiceException {
		logger.debug("addSummary(AddSummary addSummary={}) - start", summaryDto); 

		AssertUtils.notNull(summaryDto);
		try {
			Summary summary = new Summary();
			//add数据录入
			summary.setCode(GUID.generateCode());
			summary.setCount(summaryDto.getCount());
			summary.setDaySt(summaryDto.getDaySt());
			summary.setDimensionSt(summaryDto.getDimensionSt());
			summary.setRatio(summaryDto.getRatio());
			summary.setMerchantCode(summaryDto.getMerchantCode());
			summary.setMerchantName(summaryDto.getMerchantName());
			summary.setShopCode(summaryDto.getShopCode());
			summary.setShopName(summaryDto.getShopName());
			summary.setOrderStatus(summaryDto.getOrderStatus());
			summary.setCatalogCode(summaryDto.getCatalogCode());
			summaryDao.insertSelective(summary);
			logger.debug("addSummary(SummaryDto) - end - return");
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增统计信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SUMMARY_ADD_ERROR,"新增统计信息信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询统计信息信息
	 *
	 * @param findSummaryPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<SummaryDto>  findSummarys(FindSummaryPage findSummaryPage)throws TsfaServiceException{
		AssertUtils.notNull(findSummaryPage);
		List<SummaryDto> returnList=null;
		try {
			returnList = summaryDao.findSummarys(findSummaryPage);
		} catch (Exception e) {
			logger.error("查找统计信息信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.SUMMARY_NOT_EXIST_ERROR,"统计信息信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateSummary(
			SummaryDto summaryDto)
			throws TsfaServiceException {
		logger.debug("updateSummary(SummaryDto summaryDto={}) - start", summaryDto); //$NON-NLS-1$

		AssertUtils.notNull(summaryDto);
		AssertUtils.notNullAndEmpty(summaryDto.getCode(),"Code不能为空");
		try {
			Summary summary = new Summary();
			//update数据录入
			summary.setCode(summaryDto.getCode());
			summary.setCount(summaryDto.getCount());
			summary.setDaySt(summaryDto.getDaySt());
			summary.setDimensionSt(summaryDto.getDimensionSt());
			summary.setRatio(summaryDto.getRatio());
			summary.setMerchantCode(summaryDto.getMerchantCode());
			summary.setMerchantName(summaryDto.getMerchantName());
			summary.setShopCode(summaryDto.getShopCode());
			summary.setShopName(summaryDto.getShopName());
			summary.setOrderStatus(summaryDto.getOrderStatus());
			summary.setCatalogCode(summaryDto.getCatalogCode());
			AssertUtils.notUpdateMoreThanOne(summaryDao.updateByPrimaryKeySelective(summary));
			logger.debug("updateSummary(SummaryDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("统计信息信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SUMMARY_UPDATE_ERROR,"统计信息信息更新信息错误！",e);
		}
	}

	

	@Override
	public SummaryDto findSummary(
			SummaryDto summaryDto) throws TsfaServiceException {
		logger.debug("findSummary(FindSummary findSummary={}) - start", summaryDto); //$NON-NLS-1$

		AssertUtils.notNull(summaryDto);
		AssertUtils.notAllNull(summaryDto.getCode(),"Code不能为空");
		try {
			Summary summary = summaryDao.selectByPrimaryKey(summaryDto.getCode());
			if(summary == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.SUMMARY_NOT_EXIST_ERROR,"统计信息信息不存在");
			}
			SummaryDto findSummaryReturn = new SummaryDto();
			//find数据录入
			findSummaryReturn.setCode(summary.getCode());
			findSummaryReturn.setCount(summary.getCount());
			findSummaryReturn.setDaySt(summary.getDaySt());
			findSummaryReturn.setDimensionSt(summary.getDimensionSt());
			findSummaryReturn.setRatio(summary.getRatio());
			findSummaryReturn.setMerchantCode(summary.getMerchantCode());
			findSummaryReturn.setMerchantName(summary.getMerchantName());
			findSummaryReturn.setShopCode(summary.getShopCode());
			findSummaryReturn.setShopName(summary.getShopName());
			findSummaryReturn.setOrderStatus(summary.getOrderStatus());
			findSummaryReturn.setCatalogCode(summary.getCatalogCode());
			
			logger.debug("findSummary(SummaryDto) - end - return value={}", findSummaryReturn); //$NON-NLS-1$
			return findSummaryReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找统计信息信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SUMMARY_FIND_ERROR,"查找统计信息信息信息错误！",e);
		}


	}

	
	@Override
	public Page<SummaryDto> findSummaryPage(
			FindSummaryPage findSummaryPage)
			throws TsfaServiceException {
		logger.debug("findSummaryPage(FindSummaryPage findSummaryPage={}) - start", findSummaryPage); //$NON-NLS-1$

		AssertUtils.notNull(findSummaryPage);
		List<SummaryDto> returnList=null;
		int count = 0;
		try {
			returnList = summaryDao.findSummaryPage(findSummaryPage);
			count = summaryDao.findSummaryPageCount(findSummaryPage);
		}  catch (Exception e) {
			logger.error("统计信息信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.SUMMARY_FIND_PAGE_ERROR,"统计信息信息不存在错误.！",e);
		}
		Page<SummaryDto> returnPage = new Page<SummaryDto>(returnList, count, findSummaryPage);

		logger.debug("findSummaryPage(FindSummaryPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 

	@Override
	public void orderCount() throws TsfaServiceException {
		logger.debug("orderCount() - start");
		try {
			//add数据录入
			List<Summary> summarys= summaryDao.orderCount();//查询出昨日订单统计数据
			for (Summary s : summarys) {
				Summary summary=new Summary();
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
		} catch (Exception e) {
			logger.error("新增统计信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SUMMARY_ADD_ERROR,"新增统计信息错误！",e);
		}
		logger.debug("orderCount() - end");
	}

	@Override
	public void memberSummary() throws TsfaServiceException {
		logger.debug("memberSummary() - start");
		try {
			
			Date now = DateUtils.getPreday(new Date());
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
			
			
			/*按商户统计*/
			List<MerchantDto> merchantDtos= merchantService.findMerchants(new FindMerchantPage());
			for (MerchantDto merchantDto : merchantDtos) {
				/*商户下所有店铺*/
				FindShopPage findShopPage = new FindShopPage();
				ShopDto paramShopDto = new ShopDto();
				paramShopDto.setMerchantCode(merchantDto.getCode());
				findShopPage.setParam(paramShopDto);
				List<ShopDto> shopDtos= shopService.findShops(findShopPage);
				for (ShopDto shopDto : shopDtos) {
					
					/*获取店铺当天粉丝量*/
					FindMyAttentionPage findMyAttentionPage = new FindMyAttentionPage();
					MyAttentionDto paramMy = new MyAttentionDto();
					paramMy.setShopCode(shopDto.getCode());
					paramMy.setStartTime(DateUtils.formatDate(startTime, DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
					paramMy.setEndTime(DateUtils.formatDate(endTime, DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
					findMyAttentionPage.setParam(paramMy);
					Integer attCount = myAttentionService.findMyAttentionPageCount(findMyAttentionPage);
					
					/*插入统计表*/
					SummaryDto summaryDto = new SummaryDto();
					summaryDto.setCount(attCount.toString());
					summaryDto.setDaySt(now);
					summaryDto.setDimensionSt(DimensionSt.MEMBER.getValue());
					summaryDto.setMerchantCode(merchantDto.getCode());
					summaryDto.setMerchantName(merchantDto.getMerchantName());
					summaryDto.setShopCode(shopDto.getCode());
					summaryDto.setShopName(shopDto.getShopName());
					this.addSummary(summaryDto);
				}
			}
			logger.debug("memberSummary() - end");
		} catch (Exception e) {
			logger.error("新增统计信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SUMMARY_ADD_ERROR,"新增统计信息错误！",e);
		}
	}


	@Override
	public void amtSummary() throws TsfaServiceException {
		logger.debug("amtSummary() - start");
		try {
			
			Date now = DateUtils.getPreday(new Date());
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
			
			
			/*按商户统计*/
			List<MerchantDto> merchantDtos= merchantService.findMerchants(new FindMerchantPage());
			for (MerchantDto merchantDto : merchantDtos) {
				/*商户下所有店铺*/
				FindShopPage findShopPage = new FindShopPage();
				ShopDto paramShopDto = new ShopDto();
				paramShopDto.setMerchantCode(merchantDto.getCode());
				findShopPage.setParam(paramShopDto);
				List<ShopDto> shopDtos= shopService.findShops(findShopPage);
				for (ShopDto shopDto : shopDtos) {
					
					/*获取店铺当天销售额*/
					FindOrderPage findOrderPage = new FindOrderPage();
					OrderDto paramOrderDto = new OrderDto();
					paramOrderDto.setShopCode(shopDto.getCode());
					paramOrderDto.setStartTime(DateUtils.formatDate(startTime, DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
					paramOrderDto.setEndTime(DateUtils.formatDate(endTime, DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
					findOrderPage.setParam(paramOrderDto);
					
					BigDecimal monthAmt;
					try {
						monthAmt= orderService.findAmtSum(findOrderPage);
					} catch (Exception e) {
						logger.error("my_b 当天收益>>", e);
						monthAmt = new BigDecimal(0);
					}
					
					/*插入统计表*/
					SummaryDto summaryDto = new SummaryDto();
					summaryDto.setCount(monthAmt.toString());
					summaryDto.setDaySt(now);
					summaryDto.setDimensionSt(DimensionSt.AMT.getValue());
					summaryDto.setMerchantCode(merchantDto.getCode());
					summaryDto.setMerchantName(merchantDto.getMerchantName());
					summaryDto.setShopCode(shopDto.getCode());
					summaryDto.setShopName(shopDto.getShopName());
					this.addSummary(summaryDto);
				}
			}
			logger.debug("amtSummary() - end");
		} catch (Exception e) {
			logger.error("新增统计信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SUMMARY_ADD_ERROR,"新增统计信息错误！",e);
		}
	}


	@Override
	public void productCatalogSummary() throws TsfaServiceException {
		logger.debug("productSummary() - start");
		try {
			
			Date now = DateUtils.getPreday(new Date());
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
			
			
			/*按商户统计*/
			List<MerchantDto> merchantDtos= merchantService.findMerchants(new FindMerchantPage());
			Map<String, CatalogDto> catalogMap=null;
			for (MerchantDto merchantDto : merchantDtos) {
				/*商户下所有店铺*/
				FindShopPage findShopPage = new FindShopPage();
				ShopDto paramShopDto = new ShopDto();
				paramShopDto.setMerchantCode(merchantDto.getCode());
				findShopPage.setParam(paramShopDto);
				List<ShopDto> shopDtos= shopService.findShops(findShopPage);
				for (ShopDto shopDto : shopDtos) {
					
					/*获取店铺当天销售额*/
					FindOrderPage findOrderPage = new FindOrderPage();
					OrderDto paramOrderDto = new OrderDto();
					paramOrderDto.setShopCode(shopDto.getCode());
					paramOrderDto.setStartTime(DateUtils.formatDate(startTime, DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
					paramOrderDto.setEndTime(DateUtils.formatDate(endTime, DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
//					paramOrderDto.setStartTime("2017-09-11 00:00:00");
//					paramOrderDto.setEndTime("2017-09-12 00:00:00");
					findOrderPage.setParam(paramOrderDto);
					
					try {
						List<CatalogSummaryDto> list = orderService.findProductCatalog(findOrderPage);
						if(null!=list && list.size()>0) {
							
							Map<String, Integer> catalogSumarryMap = new HashMap<String, Integer>();
							for (CatalogSummaryDto catalogSummaryDto : list) {
								if(null==catalogMap || catalogMap.size()==0 ) {
									catalogMap = FindCatalogList();
								}
								
								//如果不是一级分类
								rebuildFirstCatalog(catalogMap, catalogSummaryDto);
								
								//统计同一分类
								if(catalogSumarryMap.containsKey(catalogSummaryDto.getCataLogCode())) {
									catalogSumarryMap.put(catalogSummaryDto.getCataLogCode(), catalogSumarryMap.get(catalogSummaryDto.getCataLogCode())+catalogSummaryDto.getCnt());
								} else {
									catalogSumarryMap.put(catalogSummaryDto.getCataLogCode(), catalogSummaryDto.getCnt());
								}
							}
							logger.debug(" 分类统计>>" +  list);
							
							
							Iterator<String> it = catalogSumarryMap.keySet().iterator();
							while (it.hasNext()) {
								String key = it.next();
								Integer cnt = catalogSumarryMap.get(key);
								if(null==cnt){
									cnt=0;
								}
								/*插入统计表，每个分类一条数据*/
								SummaryDto summaryDto = new SummaryDto();
								summaryDto.setCount(cnt.toString());
								summaryDto.setDaySt(now);
								summaryDto.setDimensionSt(DimensionSt.CATALOG.getValue());
								summaryDto.setMerchantCode(merchantDto.getCode());
								summaryDto.setMerchantName(merchantDto.getMerchantName());
								summaryDto.setShopCode(shopDto.getCode());
								summaryDto.setShopName(shopDto.getShopName());
								summaryDto.setCatalogCode(key);
								this.addSummary(summaryDto);
								
							}
						}
						
						
					} catch (Exception e) {
						logger.error(" 分类统计>>", e);
					}
					

				}
			}
			logger.debug("productSummary() - end");
		} catch (Exception e) {
			logger.error("新增统计信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SUMMARY_ADD_ERROR,"新增统计信息错误！",e);
		}
		
	}


	private void rebuildFirstCatalog(Map<String, CatalogDto> catalogMap, CatalogSummaryDto catalogSummaryDto){
		if(!StringUtils.equal(catalogSummaryDto.getParentCataLogCode(), "0") 
				&& !StringUtils.equal(catalogSummaryDto.getParentCataLogCode(), "1")
				) {
			if(null!=catalogMap.get(catalogSummaryDto.getCataLogCode())) {
				catalogSummaryDto.setCataLogCode(catalogMap.get(catalogSummaryDto.getCataLogCode()).getCode());
			}
		}
	}

	
	/*查询所有分类, map<code, catelogdto>*/
	public Map<String, CatalogDto> FindCatalogList() {
		
		FindCatalogPage findCatalogPage = new FindCatalogPage();
		List<CatalogDto> catalogs = catalogService.findCatalogs(findCatalogPage);
		Map<String, CatalogDto> maps = new HashMap<String, CatalogDto>();
		for (CatalogDto catalogDto : catalogs) {
			maps.put(catalogDto.getCode(), catalogDto);
			CatalogDto parentCata = getFirstLevelCatalog(catalogDto);
			if(!catalogDto.getCode().equals(parentCata.getCode())) {
				maps.put(catalogDto.getCode(), parentCata);
			}
		}
		return maps;
	}

	/*果不是一级分类，需要查询到一级分类*/
	private CatalogDto getFirstLevelCatalog(CatalogDto catalogDto) {
		if(null!=catalogDto && StringUtils.isNotEmpty(catalogDto.getParentCatalogCode()) 
				&& !StringUtils.equal(catalogDto.getParentCatalogCode(), "0") 
				&& !StringUtils.equal(catalogDto.getParentCatalogCode(), "1")) {
			CatalogDto paramParentCata = new CatalogDto();
			paramParentCata.setCode(catalogDto.getParentCatalogCode());
			try {
				CatalogDto parentCatalogDto = catalogService.findCatalog(paramParentCata);
				catalogDto = getFirstLevelCatalog(parentCatalogDto);
			} catch (Exception e) {
				logger.error("getFirstLevelCatalog() - error", e);
			}
		}
		return catalogDto;
	}

	
	
	@Override
	public void orderSummary() throws TsfaServiceException {
		logger.debug("memberSummary() - start");
		try {
			
			Date now = DateUtils.getPreday(new Date());
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
			
			
			/*按商户统计*/
			List<MerchantDto> merchantDtos= merchantService.findMerchants(new FindMerchantPage());
			for (MerchantDto merchantDto : merchantDtos) {
				/*商户下所有店铺*/
				FindShopPage findShopPage = new FindShopPage();
				ShopDto paramShopDto = new ShopDto();
				paramShopDto.setMerchantCode(merchantDto.getCode());
				findShopPage.setParam(paramShopDto);
				List<ShopDto> shopDtos= shopService.findShops(findShopPage);
				for (ShopDto shopDto : shopDtos) {
					
					/*获店铺订单当天总量*/
					FindOrderPage findOrderPage = new FindOrderPage();
					OrderDto paramOrderDto = new OrderDto();
					paramOrderDto.setStatus(OrderStatus.UNSHIPPED.getValue());
					paramOrderDto.setShopCode(shopDto.getCode());
					paramOrderDto.setStartTime(DateUtils.formatDate(startTime, DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
					paramOrderDto.setEndTime(DateUtils.formatDate(endTime, DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
					findOrderPage.setParam(paramOrderDto);
					/*待发货*/
					int unshipped= orderService.findOrderPageCount(findOrderPage);
					/*待付款*/
					paramOrderDto.setStatus(OrderStatus.UNPAID.getValue());
					findOrderPage.setParam(paramOrderDto);
					int unpaid= orderService.findOrderPageCount(findOrderPage);
					/*待收货*/
					paramOrderDto.setStatus(OrderStatus.SHIPPED.getValue());
					findOrderPage.setParam(paramOrderDto);
					int shipped= orderService.findOrderPageCount(findOrderPage);
					/*已收货*/
					paramOrderDto.setStatus(OrderStatus.UNEVL.getValue());
					findOrderPage.setParam(paramOrderDto);
					int unevl= orderService.findOrderPageCount(findOrderPage);
					/*已结算*/
					paramOrderDto.setStatus(OrderStatus.COMPLETED.getValue());
					findOrderPage.setParam(paramOrderDto);
					int completed= orderService.findOrderPageCount(findOrderPage);
					/*总数*/
					int totle = unshipped+unpaid+shipped+unevl+completed;
					
					insertSummary(merchantDto, shopDto, now, unshipped, totle, OrderStatus.UNSHIPPED.getValue());
					insertSummary(merchantDto, shopDto, now, unpaid, totle, OrderStatus.UNPAID.getValue());
					insertSummary(merchantDto, shopDto, now, shipped, totle, OrderStatus.SHIPPED.getValue());
					insertSummary(merchantDto, shopDto, now, unevl, totle, OrderStatus.UNEVL.getValue());
					insertSummary(merchantDto, shopDto, now, completed, totle, OrderStatus.COMPLETED.getValue());
				}
			}
			logger.debug("memberSummary() - end");
		} catch (Exception e) {
			logger.error("新增统计信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SUMMARY_ADD_ERROR,"新增统计信息错误！",e);
		}
	}

	private void insertSummary(MerchantDto merchantDto,ShopDto shopDto,Date now,Integer count,Integer totle,String orderStatus){
		/*插入统计表*/
		SummaryDto summaryDto = new SummaryDto();
		summaryDto.setDaySt(now);
		summaryDto.setDimensionSt(DimensionSt.ORDER.getValue());
		summaryDto.setMerchantCode(merchantDto.getCode());
		summaryDto.setMerchantName(merchantDto.getMerchantName());
		summaryDto.setShopCode(shopDto.getCode());
		summaryDto.setShopName(shopDto.getShopName());
		summaryDto.setCount(count.toString());
		if(totle!=null&&totle!=0){
			BigDecimal ratio = new BigDecimal(count).divide(new BigDecimal(totle),4, BigDecimal.ROUND_HALF_UP);
			summaryDto.setRatio(ratio);
		}
		
		summaryDto.setOrderStatus(orderStatus);
		this.addSummary(summaryDto);
	}


	/* (non-Javadoc)
	 * @see com.lj.eshop.service.ISummaryService#findSummaryByType(com.lj.eshop.dto.FindSummaryPage)
	 */
	@Override
	public SummaryShowDto findSummaryByType(FindSummaryPage findSummaryPage)
			throws TsfaServiceException {
		AssertUtils.notNull(findSummaryPage);
		SummaryShowDto rt = new SummaryShowDto();
		try {
			SummaryDto summaryDto=findSummaryPage.getParam();
			summaryDto.setStartTime(DateUtils.formatDate(getDate(new Date(), summaryDto.getDays()*(-1)), DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
			summaryDto.setEndTime(DateUtils.formatDate(getDate(new Date(), 0), DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
			//按类型统计总量
			BigDecimal sumCnt=summaryDao.findSummarysCount(findSummaryPage);
			//按日统计该类型
			List<SummaryDayDto> daySums=summaryDao.findSummarysGroupByDay(findSummaryPage);
			//按纬度统计占比 仅仅商品和订单按类型进行统计
			String type=findSummaryPage.getParam().getDimensionSt();
			List<SummaryRadioDto> nameSums= null;
			if(SummaryDimensionSt.ORDER.getValue().equals(type)||
					SummaryDimensionSt.PRODUCT.getValue().equals(type)
					){
				nameSums=summaryDao.findSummarysGroupByName(findSummaryPage);
			}
			
			//数据处理 
			List<SummaryDayDto> rtDaySums=new ArrayList<SummaryDayDto>();
			Date startDate=DateUtils.parseDate(findSummaryPage.getParam().getStartTime(),DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss);
			Date endDate=DateUtils.parseDate(findSummaryPage.getParam().getEndTime(),DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss);
			Long days=(endDate.getTime()-startDate.getTime())/86400000;
			for (int i = 0; i < days; i++) {
				Date date=getDate(startDate, i);
				SummaryDayDto sumDay=getSummaryDayByDate(daySums, date);
				if(sumDay==null){
					sumDay=new SummaryDayDto();
					sumDay.setDaySt(date);
					sumDay.setCount(BigDecimal.ZERO);
				}
				rtDaySums.add(sumDay);
			}
			//占比处理
			List<SummaryRadioDto> rtNameSums=getSummaryRadioDto(nameSums,type, sumCnt);
			//set处理结果
			rt=new SummaryShowDto();
			if(sumCnt==null){
				rt.setSumCnt(BigDecimal.ZERO);
			}else if(SummaryDimensionSt.SALE_CNT.getValue().equals(type) ){
				rt.setSumCnt(sumCnt.setScale(2, BigDecimal.ROUND_HALF_UP));
			}else{
				rt.setSumCnt(sumCnt);
			}
			rt.setDaySum(rtDaySums);
			rt.setRadios(rtNameSums);
		} catch (Exception e) {
			logger.error("查找统计信息信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.SUMMARY_NOT_EXIST_ERROR,"统计信息信息不存在",e);
		}
		return rt;
	}
	
	/**
	 * 方法说明：计算比例
	 *
	 * @param radios 源数据
	 * @param sumCnt 总量
	 * @return
	 *
	 * @author lhy  2017年9月28日
	 *
	 */
	private static List<SummaryRadioDto> getSummaryRadioDto(List<SummaryRadioDto> radios,String type,BigDecimal sumCnt){
		List<SummaryRadioDto> rt=null;
		if(radios!=null){
			rt=new ArrayList<SummaryRadioDto>();
			for (Iterator<SummaryRadioDto> el = radios.iterator(); el.hasNext();) {
				SummaryRadioDto summaryRadioDto = (SummaryRadioDto) el.next();
				BigDecimal rd=BigDecimal.ZERO;
				if(sumCnt!=null&&rd.compareTo(BigDecimal.ZERO)>0){
					rd=summaryRadioDto.getCount().divide(sumCnt,2, BigDecimal.ROUND_HALF_UP);
				}
				if(SummaryDimensionSt.ORDER.getValue().equals(type)){
					summaryRadioDto.setName(orderStatusName(summaryRadioDto.getCode()));
				}
				summaryRadioDto.setRadio(rd);
				rt.add(summaryRadioDto);
			}
		}
		return rt;
	}
	/***
	 * 方法说明：根据code获取订单状态名
	 *
	 * @param status
	 * @return
	 *
	 * @author lhy  2017年9月28日
	 *
	 */
	private static String orderStatusName(String status){
		OrderStatus[] all=OrderStatus.values();
		for (int i = 0; i < all.length; i++) {
			if(all[i].getValue().equals(status)){
				return all[i].getChName();
			}
		}
		return status;
	}
	
	/**
	 * 方法说明：查找指定日期的数据。
	 *
	 * @param daySums 检索源
	 * @param date 检索日
	 * @return
	 *
	 * @author lhy  2017年9月28日
	 *
	 */
	private static SummaryDayDto getSummaryDayByDate(List<SummaryDayDto> daySums,Date date){
		String dayStr=(DateUtils.formatDate(date, DateUtils.PATTERN_yyyy_MM_dd));
		if(daySums!=null){
			for (Iterator<SummaryDayDto> el = daySums.iterator(); el.hasNext();) {
				SummaryDayDto summaryDayDto = (SummaryDayDto) el.next();
				String elDayStr=(DateUtils.formatDate(summaryDayDto.getDaySt(), DateUtils.PATTERN_yyyy_MM_dd));
				if(dayStr.equals(elDayStr)){
					return summaryDayDto;
				}
			}
		}
		return null;
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
	private static Date getDate(Date start,int i){
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
	
	public static void main(String[] args) {
		System.out.println(getDate(new Date(),0));
	}
	
}
