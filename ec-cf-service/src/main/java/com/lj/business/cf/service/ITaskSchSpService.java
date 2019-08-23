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
import com.lj.business.cf.dto.AddTaskSchSp;
import com.lj.business.cf.dto.AddTaskSchSpReturn;
import com.lj.business.cf.dto.DelTaskSchSp;
import com.lj.business.cf.dto.DelTaskSchSpReturn;
import com.lj.business.cf.dto.FindTaskSchSp;
import com.lj.business.cf.dto.FindTaskSchSpList;
import com.lj.business.cf.dto.FindTaskSchSpListReturn;
import com.lj.business.cf.dto.FindTaskSchSpPage;
import com.lj.business.cf.dto.FindTaskSchSpPageReturn;
import com.lj.business.cf.dto.FindTaskSchSpReturn;
import com.lj.business.cf.dto.UpdateTaskSchSp;
import com.lj.business.cf.dto.UpdateTaskSchSpReturn;


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
public interface ITaskSchSpService {
	
	/**
	 * 
	 *
	 * 方法说明：添加店长待办事项表信息
	 *
	 * @param addTaskSchSp
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public AddTaskSchSpReturn addTaskSchSp(AddTaskSchSp addTaskSchSp) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找店长待办事项表信息
	 *
	 * @param findTaskSchSp
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public FindTaskSchSpReturn findTaskSchSp(FindTaskSchSp findTaskSchSp) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除店长待办事项表信息
	 *
	 * @param delTaskSchSp
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public DelTaskSchSpReturn delTaskSchSp(DelTaskSchSp delTaskSchSp) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改店长待办事项表信息
	 *
	 * @param updateTaskSchSp
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public UpdateTaskSchSpReturn updateTaskSchSp(UpdateTaskSchSp updateTaskSchSp)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：查找店长待办事项表信息
	 *
	 * @param findTaskSchSpPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public Page<FindTaskSchSpPageReturn> findTaskSchSpPage(FindTaskSchSpPage findTaskSchSpPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找店长待办事项表信息LIST
	 *
	 * @param findTaskSchSpPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public List<FindTaskSchSpListReturn> findTaskSchSpList(FindTaskSchSpList findTaskSchSpList) throws TsfaServiceException;

}
