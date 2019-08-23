package com.lj.business.cf.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.AddWorkTaskUnfinish;
import com.lj.business.cf.dto.AddWorkTaskUnfinishReturn;
import com.lj.business.cf.dto.DelWorkTaskUnfinish;
import com.lj.business.cf.dto.DelWorkTaskUnfinishReturn;
import com.lj.business.cf.dto.FindWorkTaskUnfinish;
import com.lj.business.cf.dto.FindWorkTaskUnfinishPage;
import com.lj.business.cf.dto.FindWorkTaskUnfinishPageReturn;
import com.lj.business.cf.dto.FindWorkTaskUnfinishReturn;
import com.lj.business.cf.dto.UpdateWorkTaskUnfinish;
import com.lj.business.cf.dto.UpdateWorkTaskUnfinishReturn;


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
public interface IWorkTaskUnfinishService {
	
	/**
	 * 
	 *
	 * 方法说明：添加未完成工作任务表信息
	 *
	 * @param addWorkTaskUnfinish
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public AddWorkTaskUnfinishReturn addWorkTaskUnfinish(AddWorkTaskUnfinish addWorkTaskUnfinish) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找未完成工作任务表信息
	 *
	 * @param findWorkTaskUnfinish
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public FindWorkTaskUnfinishReturn findWorkTaskUnfinish(FindWorkTaskUnfinish findWorkTaskUnfinish) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除未完成工作任务表信息
	 *
	 * @param delWorkTaskUnfinish
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public DelWorkTaskUnfinishReturn delWorkTaskUnfinish(DelWorkTaskUnfinish delWorkTaskUnfinish) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改未完成工作任务表信息
	 *
	 * @param updateWorkTaskUnfinish
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public UpdateWorkTaskUnfinishReturn updateWorkTaskUnfinish(UpdateWorkTaskUnfinish updateWorkTaskUnfinish)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：查找未完成工作任务表信息
	 *
	 * @param findWorkTaskUnfinishPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public Page<FindWorkTaskUnfinishPageReturn> findWorkTaskUnfinishPage(FindWorkTaskUnfinishPage findWorkTaskUnfinishPage) throws TsfaServiceException;
	

}
