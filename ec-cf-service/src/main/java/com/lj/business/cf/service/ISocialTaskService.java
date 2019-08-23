package com.lj.business.cf.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.socialTask.AddSocialTask;
import com.lj.business.cf.dto.socialTask.DelSocialTask;
import com.lj.business.cf.dto.socialTask.FindSocialTask;
import com.lj.business.cf.dto.socialTask.FindSocialTaskPage;
import com.lj.business.cf.dto.socialTask.FindSocialTaskPageReturn;
import com.lj.business.cf.dto.socialTask.FindSocialTaskReturn;
import com.lj.business.cf.dto.socialTask.FindSocialTaskSt;
import com.lj.business.cf.dto.socialTask.FindStIndexPage;
import com.lj.business.cf.dto.socialTask.FindStIndexPageReturn;
import com.lj.business.cf.dto.socialTask.FindStIndexTotal;
import com.lj.business.cf.dto.socialTask.FindStIndexTotalReturn;
import com.lj.business.cf.dto.socialTask.UpdateSocialTask;


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
public interface ISocialTaskService {
	


	/**
	 * 
	 *
	 * 方法说明：查询工作任务首页统计信息_APP社交任务首页
	 *
	 * @param findStIndexTotal
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月19日
	 *
	 */
	public FindStIndexTotalReturn findStIndexTotal(FindStIndexTotal findStIndexTotal) throws TsfaServiceException;

	
	/**
	 * 
	 *
	 * 方法说明：分页查询工作任务首页信息_APP社交任务首页
	 *
	 * @param findSocialTaskPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public Page<FindStIndexPageReturn> findStIndexPage(FindStIndexPage findStIndexPage) throws TsfaServiceException;

	
	
	/**
	 * 
	 *
	 * 方法说明：添加工作任务表（社交）信息
	 *
	 * @param addSocialTask
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void addSocialTask(AddSocialTask addSocialTask) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找工作任务表（社交）信息
	 *
	 * @param findSocialTask
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public FindSocialTaskReturn findSocialTask(FindSocialTask findSocialTask) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：统计工作任务表（社交）信息
	 *
	 * @param date 
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 刘培 CreateDate: 2017年08月15日
	 *
	 */
	public List<FindSocialTaskSt> findSocialTaskStByDay(Date date) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：删除工作任务表（社交）信息
	 *
	 * @param delSocialTask
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void delSocialTask(DelSocialTask delSocialTask) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改工作任务表（社交）信息
	 *
	 * @param updateSocialTask
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void updateSocialTask(UpdateSocialTask updateSocialTask)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询工作任务表（社交）信息
	 *
	 * @param findSocialTaskPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public Page<FindSocialTaskPageReturn> findSocialTaskPage(FindSocialTaskPage findSocialTaskPage) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：根据导购编号查询导购社交任务量
	 * @param merchantNo 导购编号
	 * 		  finish 是否完成        完成：Y    未完成：N
	 * 	      beginTime 开始时间
	 * 		  endTime 结束时间
	 * @return
	 *
	 * @author 梅宏博 CreateDate: 2017年8月19日
	 *
	 */
	public int findCountSocialByGm(Map<String, Object> map);
	

}
