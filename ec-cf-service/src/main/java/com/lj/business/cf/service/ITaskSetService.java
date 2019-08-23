package com.lj.business.cf.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.AddTaskSet;
import com.lj.business.cf.dto.AddTaskSetReturn;
import com.lj.business.cf.dto.DelTaskSet;
import com.lj.business.cf.dto.DelTaskSetReturn;
import com.lj.business.cf.dto.FindTaskSet;
import com.lj.business.cf.dto.FindTaskSetPage;
import com.lj.business.cf.dto.FindTaskSetPageReturn;
import com.lj.business.cf.dto.FindTaskSetReturn;
import com.lj.business.cf.dto.UpdateTaskSet;
import com.lj.business.cf.dto.UpdateTaskSetReturn;


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
public interface ITaskSetService {
	
	/**
	 * 
	 *
	 * 方法说明：添加店长任务设置表信息
	 *
	 * @param addTaskSet
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public AddTaskSetReturn addTaskSet(AddTaskSet addTaskSet) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找店长任务设置表信息
	 *
	 * @param findTaskSet
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public FindTaskSetReturn findTaskSet(FindTaskSet findTaskSet) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除店长任务设置表信息
	 *
	 * @param delTaskSet
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public DelTaskSetReturn delTaskSet(DelTaskSet delTaskSet) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改店长任务设置表信息
	 *
	 * @param updateTaskSet
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public UpdateTaskSetReturn updateTaskSet(UpdateTaskSet updateTaskSet)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：查找店长任务设置表信息
	 *
	 * @param findTaskSetPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public Page<FindTaskSetPageReturn> findTaskSetPage(FindTaskSetPage findTaskSetPage) throws TsfaServiceException;
	

}
