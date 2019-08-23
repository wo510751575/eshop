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
import com.lj.business.cf.domain.OtherTaskFinishInfo;
import com.lj.business.cf.dto.DoOtherFinishWork;
import com.lj.business.cf.dto.OtherTaskList;
import com.lj.business.cf.dto.otherTaskFinishInfo.AddOtherTaskFinishInfo;
import com.lj.business.cf.dto.otherTaskFinishInfo.DelOtherTaskFinishInfo;
import com.lj.business.cf.dto.otherTaskFinishInfo.FindOtherTask;
import com.lj.business.cf.dto.otherTaskFinishInfo.FindOtherTaskFinishInfo;
import com.lj.business.cf.dto.otherTaskFinishInfo.FindOtherTaskFinishInfoReturn;
import com.lj.business.cf.dto.otherTaskFinishInfo.FindOtherTaskReturn;
import com.lj.business.cf.dto.otherTaskFinishInfo.UpdateOtherTaskFinishInfo;
import com.lj.business.cf.dto.taskSetShop.ToShopTaskSet;


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
public interface IOtherTaskFinishInfoService {
	

	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @param findOtherTask
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年8月19日
	 *
	 */
	OtherTaskFinishInfo findOtherTaskByDay(FindOtherTask findOtherTask) throws TsfaServiceException;
	/**
	 * 
	 *
	 * 方法说明：查询其他工作_APP首页用
	 *
	 * @param findOtherTask
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月24日
	 *
	 */
	public List<FindOtherTaskReturn> findOtherTask(FindOtherTask findOtherTask)throws TsfaServiceException;
	
	
	
	/**
	 * 
	 *
	 * 方法说明：添加其他任务完成情况表信息
	 *
	 * @param addOtherTaskFinishInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void addOtherTaskFinishInfo(AddOtherTaskFinishInfo addOtherTaskFinishInfo) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找其他任务完成情况表信息
	 *
	 * @param findOtherTaskFinishInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public FindOtherTaskFinishInfoReturn findOtherTaskFinishInfo(FindOtherTaskFinishInfo findOtherTaskFinishInfo) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除其他任务完成情况表信息
	 *
	 * @param delOtherTaskFinishInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void delOtherTaskFinishInfo(DelOtherTaskFinishInfo delOtherTaskFinishInfo) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改其他任务完成情况表信息
	 *
	 * @param updateOtherTaskFinishInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void updateOtherTaskFinishInfo(UpdateOtherTaskFinishInfo updateOtherTaskFinishInfo)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询其他任务完成情况表信息
	 *
	 * @param findOtherTaskFinishInfoPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	//public Page<FindOtherTaskFinishInfoPageReturn> findOtherTaskFinishInfoPage(FindOtherTaskFinishInfoPage findOtherTaskFinishInfoPage) throws TsfaServiceException;
	

	/**
	 * 
	 *
	 * 方法说明：查询其他工作
	 *
	 * @param findOtherTaskFinishInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月21日
	 *
	 */
	public List<OtherTaskList> findWtsOther(FindOtherTaskFinishInfo findOtherTaskFinishInfo)throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：编辑其他完成任务情况完成数量
	 *
	 * @param doOtherFinishWorkList
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月22日
	 *
	 */
	public void doOtherFinishWork(DoOtherFinishWork[] doOtherFinishWorkList) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：其他任务完成情况表  每日初始化
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月24日
	 *
	 */
	//public void doDayOtherTaskFinishInfo() throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：其他任务完成情况表  每日执行
	 *
	 * @param date
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月24日
	 *
	 */
	//public void doOtherTaskFinishInfo(Date date) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：其他任务完成情况表导购
	 *
	 * @param date
	 * @param memberNoGm
	 * @param codeTss
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月24日
	 *
	 */
	public void doGmOtherTaskFinishInfo(Date date,ToShopTaskSet toShopTaskSet) throws TsfaServiceException;
	
}
