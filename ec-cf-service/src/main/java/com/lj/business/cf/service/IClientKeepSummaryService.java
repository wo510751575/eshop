package com.lj.business.cf.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.business.cf.dto.clientKeepSummary.AddClientKeepSummary;
import com.lj.business.cf.dto.clientKeepSummary.DelClientKeepSummary;
import com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummary;
import com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummaryPage;
import com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummaryPageReturn;
import com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummaryReturn;
import com.lj.business.cf.dto.clientKeepSummary.UpdateClientKeepSummary;
import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;


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
public interface IClientKeepSummaryService {
	
	/**
	 * 
	 *
	 * 方法说明：添加维护总表信息
	 *
	 * @param addClientKeepSummary
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public String addClientKeepSummary(AddClientKeepSummary addClientKeepSummary) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找维护总表信息
	 *
	 * @param findClientKeepSummary
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public FindClientKeepSummaryReturn findClientKeepSummary(FindClientKeepSummary findClientKeepSummary) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：跟进ckNo查询维护总表记录
	 *
	 * @param findClientKeepSummary
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月14日
	 *
	 */
	public FindClientKeepSummaryReturn findClientKeepSummaryByCkNo(FindClientKeepSummary findClientKeepSummary) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除维护总表信息
	 *
	 * @param delClientKeepSummary
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public void delClientKeepSummary(DelClientKeepSummary delClientKeepSummary) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改维护总表信息
	 *
	 * @param updateClientKeepSummary
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public void updateClientKeepSummary(UpdateClientKeepSummary updateClientKeepSummary)throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：跟进ckNo修改维护总表
	 *
	 * @param updateClientKeepSummary
	 *
	 * @author 冯辉 CreateDate: 2017年7月11日
	 *
	 */
	public void updateByCkNo(UpdateClientKeepSummary updateClientKeepSummary);

	/**
	 * 
	 *
	 * 方法说明：分页查询维护总表信息
	 *
	 * @param findClientKeepSummaryPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public Page<FindClientKeepSummaryPageReturn> findClientKeepSummaryPage(FindClientKeepSummaryPage findClientKeepSummaryPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查询最后一条维护总表记录
	 *
	 * @param findClientKeepSummary
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月11日
	 *
	 */
	public FindClientKeepSummaryReturn findClientKeepSummaryLast(FindClientKeepSummary findClientKeepSummary) throws TsfaServiceException ;

	/**
	 * 
	 *
	 * 方法说明：根据导购编号查询维护客户数量
	 * @param memberNo 导购编号
	 * @return
	 *
	 * @author 梅宏博 CreateDate: 2017年8月19日
	 *
	 */
	public long findCountPmKeepByGm(String memberNo);
	

}
