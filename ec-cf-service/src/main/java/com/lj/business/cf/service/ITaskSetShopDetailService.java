package com.lj.business.cf.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;
import java.util.List;

import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.domain.TaskSetShopDetail;
import com.lj.business.cf.dto.FindTaskSetShopDetailByTypeMGMDay;
import com.lj.business.cf.dto.taskSetShop.FindNoSetShopCount;
import com.lj.business.cf.dto.taskSetShop.ToShopTaskSet;
import com.lj.business.cf.dto.taskSetShopDetail.AddTaskSetShopDetail;
import com.lj.business.cf.dto.taskSetShopDetail.DelTaskSetShopDetail;
import com.lj.business.cf.dto.taskSetShopDetail.FindTaskSetShopDetail;
import com.lj.business.cf.dto.taskSetShopDetail.FindTaskSetShopDetailReturn;
import com.lj.business.cf.dto.taskSetShopDetail.UpdateTaskSetShopDetail;


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
public interface ITaskSetShopDetailService {
	
	/**
	 * 
	 *
	 * 方法说明：添加店长任务设置明细表信息
	 *
	 * @param addTaskSetShopDetail
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年07月10日
	 *
	 */
	public void addTaskSetShopDetail(AddTaskSetShopDetail addTaskSetShopDetail) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找店长任务设置明细表信息
	 *
	 * @param findTaskSetShopDetail
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年07月10日
	 *
	 */
	public FindTaskSetShopDetailReturn findTaskSetShopDetail(FindTaskSetShopDetail findTaskSetShopDetail) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除店长任务设置明细表信息
	 *
	 * @param delTaskSetShopDetail
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年07月10日
	 *
	 */
	public void delTaskSetShopDetail(DelTaskSetShopDetail delTaskSetShopDetail) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改店长任务设置明细表信息
	 *
	 * @param updateTaskSetShopDetail
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年07月10日
	 *
	 */
	public void updateTaskSetShopDetail(UpdateTaskSetShopDetail updateTaskSetShopDetail)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询店长任务设置明细表信息
	 *
	 * @param findTaskSetShopDetailPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年07月10日
	 *
	 */
	//public Page<FindTaskSetShopDetailPageReturn> findTaskSetShopDetailPage(FindTaskSetShopDetailPage findTaskSetShopDetailPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查询任务设置明细列表
	 *
	 * @param toShopTaskSet
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月20日
	 *
	 */
	public List<TaskSetShopDetail> findTaskSetShopDetailList(ToShopTaskSet toShopTaskSet) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：根据当前日期查询任务设置明细
	 *
	 * @param now
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月24日
	 *
	 */
	public List<TaskSetShopDetail> findTaskSetShopDetailListByDay(Date now) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查询当天的导购任务目标 销售目标
	 *
	 * @param findTaskSetShopDetail
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月1日
	 *
	 */
	public FindTaskSetShopDetailReturn findTaskSetShopDetailByMGMDay(FindTaskSetShopDetail findTaskSetShopDetail)throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查询当天的导购任务目标  新增客户
	 *
	 * @param findTaskSetShopDetail
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月4日
	 *
	 */
	public FindTaskSetShopDetailReturn findTaskSetShopDetailNewByMGMDay(FindTaskSetShopDetail findTaskSetShopDetail) throws TsfaServiceException;
	
	
	public FindTaskSetShopDetailReturn findTaskSetShopDetailByTypeMGMDay(FindTaskSetShopDetailByTypeMGMDay findTaskSetShopDetailByTypeMGMDay)throws TsfaServiceException;

	public int findCountDetail(FindNoSetShopCount findNoSetShopCount);
	

}
