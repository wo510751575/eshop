package com.lj.business.cf.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.UnfinishTaskList;
import com.lj.business.cf.dto.unfinishTaskSummary.AddUnfinishTaskSummary;
import com.lj.business.cf.dto.unfinishTaskSummary.DelUnfinishTaskSummary;
import com.lj.business.cf.dto.unfinishTaskSummary.FindUnfinishTaskSummary;
import com.lj.business.cf.dto.unfinishTaskSummary.FindUnfinishTaskSummaryReturn;
import com.lj.business.cf.dto.unfinishTaskSummary.UpdateUnfinishTaskSummary;


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
public interface IUnfinishTaskSummaryService {
	
	/**
	 * 
	 *
	 * 方法说明：添加其他任务完成情况表信息
	 *
	 * @param addUnfinishTaskSummary
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void addUnfinishTaskSummary(AddUnfinishTaskSummary addUnfinishTaskSummary) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找其他任务完成情况表信息
	 *
	 * @param findUnfinishTaskSummary
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public FindUnfinishTaskSummaryReturn findUnfinishTaskSummary(FindUnfinishTaskSummary findUnfinishTaskSummary) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除其他任务完成情况表信息
	 *
	 * @param delUnfinishTaskSummary
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void delUnfinishTaskSummary(DelUnfinishTaskSummary delUnfinishTaskSummary) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改其他任务完成情况表信息
	 *
	 * @param updateUnfinishTaskSummary
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void updateUnfinishTaskSummary(UpdateUnfinishTaskSummary updateUnfinishTaskSummary) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询其他任务完成情况表信息
	 *
	 * @param findUnfinishTaskSummaryPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
//	public Page<FindUnfinishTaskSummaryPageReturn> findUnfinishTaskSummaryPage(FindUnfinishTaskSummaryPage findUnfinishTaskSummaryPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查询累计异常跟进客户次数
	 *
	 * @param findUnfinishTaskSummary
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月21日
	 *
	 */
	public int findUtsCountGm(FindUnfinishTaskSummary findUnfinishTaskSummary) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查询异常跟进列表
	 *
	 * @param findUnfinishTaskSummary
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月21日
	 *
	 */
	public List<UnfinishTaskList> findWtsUnfinish(FindUnfinishTaskSummary findUnfinishTaskSummary) throws TsfaServiceException;
	

}
