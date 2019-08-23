package com.lj.business.cf.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;
import java.util.Map;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.FindCForCKLastDateDto;
import com.lj.business.cf.dto.FindCForCKLastDateDtoReturn;
import com.lj.business.cf.dto.clientFollow.FindSaleRecordPage;
import com.lj.business.cf.dto.clientFollow.FindSaleRecordPageReturn;
import com.lj.business.cf.dto.clientFollowSummary.AddClientFollowSummary;
import com.lj.business.cf.dto.clientFollowSummary.AddPmClientFollowFirstDto;
import com.lj.business.cf.dto.clientFollowSummary.DelClientFollowSummary;
import com.lj.business.cf.dto.clientFollowSummary.FindAbandonRecordCountReturn;
import com.lj.business.cf.dto.clientFollowSummary.FindBuyRecordCountReturn;
import com.lj.business.cf.dto.clientFollowSummary.FindBuyRecordPage;
import com.lj.business.cf.dto.clientFollowSummary.FindBuyRecordPageReturn;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummary;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummaryPage;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummaryPageReturn;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummaryReturn;
import com.lj.business.cf.dto.clientFollowSummary.FindSuccessNum;
import com.lj.business.cf.dto.clientFollowSummary.UpdateClientFollowSummary;


/**
 * 类说明：接口类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 冯辉
 * 
 * 
 * CreateDate: 2017-06-14
 */
public interface IClientFollowSummaryService {
	
	
	/**
	 * 
	 *
	 * 方法说明：分页查询购买记录
	 *
	 * @param findBuyRecordPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月11日
	 *
	 */
	public Page<FindSaleRecordPageReturn> findSaleRecordPage(FindSaleRecordPage findSaleRecordPage) throws TsfaServiceException;

	
	/**
	 * 
	 *
	 * 方法说明：添加客户跟踪总表信息
	 *
	 * @param addClientFollowSummary
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public String addClientFollowSummary(AddClientFollowSummary addClientFollowSummary) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找客户跟踪总表信息
	 *
	 * @param findClientFollowSummary
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public FindClientFollowSummaryReturn findClientFollowSummary(FindClientFollowSummary findClientFollowSummary) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：跟进跟进编号查找跟进总表记录
	 *
	 * @param findClientFollowSummary
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月14日
	 *
	 */
	public FindClientFollowSummaryReturn findClientFollowSummaryByCfNo(FindClientFollowSummary findClientFollowSummary) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除客户跟踪总表信息
	 *
	 * @param delClientFollowSummary
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public void delClientFollowSummary(DelClientFollowSummary delClientFollowSummary) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改客户跟踪总表信息
	 *
	 * @param updateClientFollowSummary
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public void updateClientFollowSummary(UpdateClientFollowSummary updateClientFollowSummary)throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：修改跟进总表 根据cfNo
	 *
	 * @param updateClientFollowSummary
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月10日
	 *
	 */
	public void updateClientFollowSummaryByCfNo(UpdateClientFollowSummary updateClientFollowSummary)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询客户跟踪总表信息
	 *
	 * @param findClientFollowSummaryPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public Page<FindClientFollowSummaryPageReturn> findClientFollowSummaryPage(FindClientFollowSummaryPage findClientFollowSummaryPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：分页查询购买记录
	 *
	 * @param findBuyRecordPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月11日
	 *
	 */
	public Page<FindBuyRecordPageReturn> findBuyRecordPage(FindBuyRecordPage findBuyRecordPage) throws TsfaServiceException;

	
	/**
	 * 
	 *
	 * 方法说明：添加跟进总表并添加第一条跟进明细记录
	 *
	 * @param addClientFollowSummary
	 * @param addClientFollow
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月8日
	 *
	 */
	public String addSummaryWithClientFollow(AddPmClientFollowFirstDto addPmClientFollowFirstDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @param findClientFollowSummary
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月11日
	 *
	 */
	public FindClientFollowSummaryReturn findClientFollowSummaryLast(FindClientFollowSummary findClientFollowSummary) throws TsfaServiceException;
    
	/**
	 *    
	 *
	 * 方法说明：查询购买次数
	 *
	 * @param findBuyRecordPage
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年7月17日
	 *
	 */
	public int findBuySuccessNum(FindSuccessNum findSuccessNum );
	
	/**
	 * 
	 *
	 * 方法说明：查询跟进次数排除SYSTEM
	 *
	 * @param findBuyRecordPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月21日
	 *
	 */
	public List<FindBuyRecordCountReturn> findBuyRecordCount(FindBuyRecordPage findBuyRecordPage) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：查询跟进次数排除SYSTEM
	 *
	 * @param findBuyRecordPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月21日
	 *
	 */
	public List<FindAbandonRecordCountReturn> findAbandonRecordCount(FindBuyRecordPage findBuyRecordPage) throws TsfaServiceException;
	
	/**
     * 
     *
     * 方法说明：根据门店所属导购列表统计成单金额
     *
     * @param memberNoGmList
     * @return
     *
     * @author 段志鹏 CreateDate: 2017年7月25日
     *
     */
	long sumAmountByShop(List<String> memberNoGmList);
	
	/**
	 * 
	 *
	 * 方法说明：查询最后时间
	 *
	 * @param findCForCKLastDateDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月27日
	 *
	 */
	FindCForCKLastDateDtoReturn findCForCKLastDate(FindCForCKLastDateDto findCForCKLastDateDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：根据商户统计销售额
	 *	1.merchantNo 商户编号
	 * @param parmMap
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月2日
	 *
	 */
	long sumAmountByMerchantNo(Map<String,Object> parmMap);

	/**
	 * 
	 *
	 * 方法说明：根据导购编号查询导购销售额
	 * @param merchantNo 导购编号
	 * 	      beginTime 开始时间
	 * 		  endTime 结束时间
	 * @return
	 *
	 * @author 梅宏博 CreateDate: 2017年8月19日
	 *
	 */
	public long findNumSaleByGm(Map<String, Object> map);

	/**
	 * 
	 *
	 * 方法说明：根据导购编号查询导购成单数量
	 * @param memberNoGm 导购编号
	 * 	      beginTime 开始时间
	 * 		  endTime 结束时间
	 * @return
	 *
	 * @author 梅宏博 CreateDate: 2017年8月19日
	 *
	 */
	public int findCountOrderByGm(Map<String, Object> map);

	/**
	 * 
	 *
	 * 方法说明：根据导购编号查询跟进客户数量
	 * @param memberNo 导购编号
	 * @return
	 *
	 * @author 梅宏博 CreateDate: 2017年8月19日
	 *
	 */
	public long findCountPmCfByGm(String memberNo);
}
