package com.lj.business.cf.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.AddTaskSchSpType;
import com.lj.business.cf.dto.AddTaskSchSpTypeReturn;
import com.lj.business.cf.dto.DelTaskSchSpType;
import com.lj.business.cf.dto.DelTaskSchSpTypeReturn;
import com.lj.business.cf.dto.FindTaskSchSpType;
import com.lj.business.cf.dto.FindTaskSchSpTypePage;
import com.lj.business.cf.dto.FindTaskSchSpTypePageReturn;
import com.lj.business.cf.dto.FindTaskSchSpTypeReturn;
import com.lj.business.cf.dto.UpdateTaskSchSpType;
import com.lj.business.cf.dto.UpdateTaskSchSpTypeReturn;


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
public interface ITaskSchSpTypeService {
	
	/**
	 * 
	 *
	 * 方法说明：添加店长待办事项类型信息
	 *
	 * @param addTaskSchSpType
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public AddTaskSchSpTypeReturn addTaskSchSpType(AddTaskSchSpType addTaskSchSpType) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找店长待办事项类型信息
	 *
	 * @param findTaskSchSpType
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public FindTaskSchSpTypeReturn findTaskSchSpType(FindTaskSchSpType findTaskSchSpType) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除店长待办事项类型信息
	 *
	 * @param delTaskSchSpType
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public DelTaskSchSpTypeReturn delTaskSchSpType(DelTaskSchSpType delTaskSchSpType) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改店长待办事项类型信息
	 *
	 * @param updateTaskSchSpType
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public UpdateTaskSchSpTypeReturn updateTaskSchSpType(UpdateTaskSchSpType updateTaskSchSpType)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询店长待办事项类型信息
	 *
	 * @param findTaskSchSpTypePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public Page<FindTaskSchSpTypePageReturn> findTaskSchSpTypePage(FindTaskSchSpTypePage findTaskSchSpTypePage) throws TsfaServiceException;
	

}
