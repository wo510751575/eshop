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
import com.lj.business.cf.domain.WorkTaskList;
import com.lj.business.cf.dto.workTaskList.AddWorkTaskList;
import com.lj.business.cf.dto.workTaskList.AddWorkTaskListReturn;
import com.lj.business.cf.dto.workTaskList.DelWorkTaskList;
import com.lj.business.cf.dto.workTaskList.DelWorkTaskListReturn;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskList;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskListPage;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskListPageReturn;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskListReturn;
import com.lj.business.cf.dto.workTaskList.UpdateWorkTaskList;
import com.lj.business.cf.dto.workTaskList.UpdateWorkTaskListReturn;


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
public interface IWorkTaskListService {
	
	/**
	 * 
	 *
	 * 方法说明：添加工作事项表信息
	 *
	 * @param addWorkTaskList
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public AddWorkTaskListReturn addWorkTaskList(AddWorkTaskList addWorkTaskList) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找工作事项表信息
	 *
	 * @param findWorkTaskList
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public FindWorkTaskListReturn findWorkTaskList(FindWorkTaskList findWorkTaskList) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：根据类型查找工作事项表信息
	 *
	 * @param findWorkTaskList
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月24日
	 *
	 */
	public FindWorkTaskListReturn findWorkTaskListByTaskType(FindWorkTaskList findWorkTaskList) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找所有工作事项表信息
	 *
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月24日
	 *
	 */
	public List<FindWorkTaskListPageReturn> findWorkTaskListAll() throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：删除工作事项表信息
	 *
	 * @param delWorkTaskList
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public DelWorkTaskListReturn delWorkTaskList(DelWorkTaskList delWorkTaskList) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改工作事项表信息
	 *
	 * @param updateWorkTaskList
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public UpdateWorkTaskListReturn updateWorkTaskList(UpdateWorkTaskList updateWorkTaskList)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：查找工作事项表信息
	 *
	 * @param findWorkTaskListPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public Page<FindWorkTaskListPageReturn> findWorkTaskListPage(FindWorkTaskListPage findWorkTaskListPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @param findWorkTaskListPage
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年7月5日
	 *
	 */
	public  List<FindWorkTaskListPageReturn> findWorkTaskListPages(FindWorkTaskListPage findWorkTaskListPage)throws TsfaServiceException;

	/**
	 * 根据编码列表查找工作事项
	 * @param codeList 编码列表
	 * @return
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月24日
	 */
	List<WorkTaskList> findByCodeList(List<String> codeList);
}
