package com.lj.business.cf.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.workTaskGroup.AddWorkTaskGroup;
import com.lj.business.cf.dto.workTaskGroup.AddWorkTaskGroupReturn;
import com.lj.business.cf.dto.workTaskGroup.DelWorkTaskGroup;
import com.lj.business.cf.dto.workTaskGroup.DelWorkTaskGroupReturn;
import com.lj.business.cf.dto.workTaskGroup.FindWorkTaskGroup;
import com.lj.business.cf.dto.workTaskGroup.FindWorkTaskGroupPage;
import com.lj.business.cf.dto.workTaskGroup.FindWorkTaskGroupPageReturn;
import com.lj.business.cf.dto.workTaskGroup.FindWorkTaskGroupReturn;
import com.lj.business.cf.dto.workTaskGroup.UpdateWorkTaskGroup;
import com.lj.business.cf.dto.workTaskGroup.UpdateWorkTaskGroupReturn;


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
public interface IWorkTaskGroupService {
	
	/**
	 * 
	 *
	 * 方法说明：添加工作事项分组表信息
	 *
	 * @param addWorkTaskGroup
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public AddWorkTaskGroupReturn addWorkTaskGroup(AddWorkTaskGroup addWorkTaskGroup) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找工作事项分组表信息
	 *
	 * @param findWorkTaskGroup
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public FindWorkTaskGroupReturn findWorkTaskGroup(FindWorkTaskGroup findWorkTaskGroup) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除工作事项分组表信息
	 *
	 * @param delWorkTaskGroup
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public DelWorkTaskGroupReturn delWorkTaskGroup(DelWorkTaskGroup delWorkTaskGroup) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改工作事项分组表信息
	 *
	 * @param updateWorkTaskGroup
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public UpdateWorkTaskGroupReturn updateWorkTaskGroup(UpdateWorkTaskGroup updateWorkTaskGroup)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：查找工作事项分组表信息
	 *
	 * @param findWorkTaskGroupPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	
	public Page<FindWorkTaskGroupPageReturn> findWorkTaskGroupPage(FindWorkTaskGroupPage findWorkTaskGroupPage) throws TsfaServiceException;

	

}
