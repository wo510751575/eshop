package com.lj.business.cf.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.FindMangerWork;
import com.lj.business.cf.dto.MangerWorkReturn;
import com.lj.business.cf.dto.taskSetShop.*;


/**
 * 类说明：店长任务设置服务接口类
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
public interface ITaskSetShopService {
	
	/**
	 * 
	 *
	 * 方法说明：添加店长任务设置表信息
	 *
	 * @param addTaskSetShop
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月19日
	 *
	 */
	public void addTaskSetShop(AddTaskSetShop addTaskSetShop) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：添加店长任务主要工作设置表信息
	 *
	 * @param addTaskSetShop
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月24日
	 *
	 */
	public void addTaskSetShopMain(AddTaskSetShop addTaskSetShop) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：查找店长任务设置表信息信息
	 *
	 * @param findTaskSetShop
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月19日
	 *
	 */
	public FindTaskSetShopReturn findTaskSetShop(FindTaskSetShop findTaskSetShop) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除店长任务设置表信息信息
	 *
	 * @param delTaskSetShop
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月19日
	 *
	 */
	public void delTaskSetShop(DelTaskSetShop delTaskSetShop) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改店长任务设置表信息信息
	 *
	 * @param updateTaskSetShop
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月19日
	 *
	 */
	public void updateTaskSetShop(UpdateTaskSetShop updateTaskSetShop)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询店长任务设置表信息信息
	 *
	 * @param findTaskSetShopPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月19日
	 *
	 */
	//public Page<FindTaskSetShopPageReturn> findTaskSetShopPage(FindTaskSetShopPage findTaskSetShopPage) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：店长设置任务列表
	 *
	 * @param findShopTaskSetList
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月20日
	 *
	 */
	public List<FindShopTaskSetListReturn> findShopTaskSetList(FindShopTaskSetList findShopTaskSetList) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：to店长任务设置
	 *
	 * @param toShopTaskSet
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月20日
	 *
	 */
	public List<TaskSetShopDetailReturn> toShopTaskSet(ToShopTaskSet toShopTaskSet) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：店长任务明细设置
	 *
	 * @param shopTaskSet
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月20日
	 *
	 */
	public void shopTaskSet(ShopTaskSet shopTaskSet) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查询销售目标和订单
	 *
	 * @param findNumDay
	 * @return
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月21日
	 *
	 */
	public FindTaskSetAndOrderReturn findTaskSetAndOrder(FindTaskSetAndOrder findTaskSetAndOrder);

	/**
	 * 
	 *
	 * 方法说明：管理工作
	 *
	 * @param findMangerWork
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月21日
	 *
	 */
	public MangerWorkReturn findMangerWork(FindMangerWork findMangerWork) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查询未设置任务数量
	 *
	 * @param findNoSetShopCount
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月22日
	 *
	 */
	public int findShopNoSetCount(FindNoSetShopCount findNoSetShopCount) throws TsfaServiceException;

	/**
	 * 查询每天的销量和单位
	 * @param findTaskSetAndOrder
	 * @return
	 */
	NumDayAndTaskUnit findNumDayAndTaskUnit(FindTaskSetAndOrder findTaskSetAndOrder);
}
