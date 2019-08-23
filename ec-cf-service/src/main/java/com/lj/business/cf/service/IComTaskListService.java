package com.lj.business.cf.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.business.cf.dto.comTaskList.AddComTaskListDto;
import com.lj.business.cf.dto.comTaskList.ComTaskListReturnDto;
import com.lj.business.cf.dto.comTaskList.EditComTaskListDto;
import com.lj.business.cf.dto.comTaskList.FindComTaskList;
import com.lj.business.cf.dto.comTaskList.FindComTaskListPageDto;
import com.lj.business.cf.dto.comTaskList.FindComTaskListReturn;


/**
 * 类说明：接口类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 邹磊
 * 
 * 
 * CreateDate: 2017-06-14
 */
public interface IComTaskListService {
	
	/**
	 * 
	 *
	 * 方法说明：客户沟通任务事项查询,OTHER类型查询不支持，会因为返回多条记录而报错
	 *
	 * @param findComTaskList
	 * @return
	 *
	 * @author 彭阳 CreateDate: 2017年7月25日
	 *
	 */
	public FindComTaskListReturn findComTaskList(FindComTaskList findComTaskList);
	
	/**
	 * 
	 *
	 * 方法说明：新增客户沟通任务事项
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	public void addComTaskList(AddComTaskListDto addComTaskListDto);
	
	/**
	 * 
	 *
	 * 方法说明：编辑客户沟通任务事项
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	public void editComTaskList(EditComTaskListDto editComTaskListDto);
	
	/**
	 * 
	 *
	 * 方法说明：根据主键查询客户沟通任务事项
	 *
	 * @param code
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	public ComTaskListReturnDto selectByCode(String code);
	
	/**
	 * 
	 *
	 * 方法说明：查找客户沟通任务事项(不分页)
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	public List<FindComTaskListPageDto> findComTaskLists(FindComTaskListPageDto findComTaskListPageDto);
	
	/**
	 * 
	 *
	 * 方法说明：查找客户沟通任务事项(分页)
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	public Page<FindComTaskListPageDto> findComTaskListPage(FindComTaskListPageDto findComTaskListPageDto);
	
}