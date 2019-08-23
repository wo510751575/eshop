package com.lj.business.cf.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.*;


/**
 * 类说明：接口类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 彭阳
 * 
 * 
 * CreateDate: 2017-06-14
 */
public interface IWorkTaskService {
	
	/**
	 * 
	 *
	 * 方法说明：添加工作任务表信息
	 *
	 * @param addWorkTask
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public AddWorkTaskReturn addWorkTask(AddWorkTask addWorkTask) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找工作任务表信息
	 *
	 * @param findWorkTask
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public FindWorkTaskReturn findWorkTask(FindWorkTask findWorkTask) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除工作任务表信息
	 *
	 * @param delWorkTask
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public DelWorkTaskReturn delWorkTask(DelWorkTask delWorkTask) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改工作任务表信息
	 *
	 * @param updateWorkTask
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public UpdateWorkTaskReturn updateWorkTask(UpdateWorkTask updateWorkTask)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：查找工作任务表信息
	 *
	 * @param findWorkTaskPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public Page<FindWorkTaskPageReturn> findWorkTaskPage(FindWorkTaskPage findWorkTaskPage) throws TsfaServiceException;
	

	
	/**
	 * 
	 *
	 * 方法说明：查找主要/其他工作任务表信息_APP
	 *
	 * @param findWorkTaskMainList
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月26日
	 *
	 */
	public List<FindWorkTaskMainListReturn> findWorkTaskMainList(FindWorkTaskMainList findWorkTaskMainList) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @param findWorkTask
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月21日
	 *
	 */
	public List<MainWorkTaskList> findWtsMain(FindWorkTask findWorkTask) throws TsfaServiceException;

	/**
	 * 增加工作任务统计
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月24日
	 */
	//AddWorkTaskReturn addWorkTask() throws TsfaServiceException;

	/**
	 * 更新用户的完成数据
	 * @param updateWorkTaskFinishNum
	 * @param taskType
	 * @return 更新的数量
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月25日
	 */
	int updateFinishNum(UpdateWorkTaskFinishNum updateWorkTaskFinishNum);

	/**
	 * 要求社交任务量加一
	 * @param updateWorkTask
	 * @return 更新的数量
	 *
	 * @author 梅宏博 CreateDate: 2017年8月23日
	 */
	public int updateRequireNumByGmTypeDay(UpdateWorkTask updateWorkTask);


}
