package com.lj.business.cf.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.TodayBeforeClientExpTaskDto;
import com.lj.business.cf.dto.TodayBeforeClientExpTaskReturn;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.business.cf.dto.comTask.AddComTask;
import com.lj.business.cf.dto.comTask.DelComTask;
import com.lj.business.cf.dto.comTask.FindComTask;
import com.lj.business.cf.dto.comTask.FindComTaskIndexPage;
import com.lj.business.cf.dto.comTask.FindComTaskIndexPageReturn;
import com.lj.business.cf.dto.comTask.FindComTaskPage;
import com.lj.business.cf.dto.comTask.FindComTaskPageReturn;
import com.lj.business.cf.dto.comTask.FindComTaskReturn;
import com.lj.business.cf.dto.comTask.GenerateNextDate;
import com.lj.business.cf.dto.comTask.UpdateComTask;
import com.lj.business.cf.dto.comTask.UpdateComTaskFi;
import com.lj.business.cf.dto.comTask.UpdateComTaskGroup;


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
public interface IComTaskService {
	

	/**
	 * 
	 *
	 * 方法说明：计算邀约任务的任务时间：如果是周四以前的任务，移动至周四，周四可配置
	 * 				
	 * 
	 *
	 * @param generateNextDate
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年8月15日
	 *
	 */
	public Date generateNextDate(GenerateNextDate generateNextDate) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：沟通任务首页：当天沟通任务明细查询
	 *
	 * @param findComTaskIndexPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月17日
	 *
	 */
	public Page<FindComTaskIndexPageReturn> findComTaskIndexPage(FindComTaskIndexPage findComTaskIndexPage) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：单纯添加客户沟通任务信息
	 *
	 * @param addComTask
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public void addComTask(AddComTask addComTask) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：添加客户业务任务信息 先修改为finsh，并且关闭所有其他业务任务<br/>
	 *			flag: 0 跟进记录--》关闭任务时间当天的其他沟通任务,除了 分组任务、初次介绍任务 <br/>
	 *				  1 成单 --》关闭所有除了 分组任务、初次介绍任务以外的业务任务<br/>
	 *				  2 暂停跟进 --》关闭所有除了 分组任务、初次介绍任务以外的业务任务<br/>
	 *			
	 * @param addComTaskWithFinish
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月24日
	 *
	 */
	public void addComTaskWithFinish(AddComTask addComTask,String flag) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找客户沟通任务信息
	 *
	 * @param findComTask
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public FindComTaskReturn findComTask(FindComTask findComTask) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除客户沟通任务信息
	 *
	 * @param delComTask
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public void delComTask(DelComTask delComTask) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改客户沟通任务信息
	 *
	 * @param updateComTask
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public void updateComTask(UpdateComTask updateComTask)throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：更新初次介绍任务,完成初次介绍任务用。
	 *
	 * @param updateComTaskFi
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年8月10日
	 *
	 */
	public void updateComTaskFi(UpdateComTaskFi updateComTaskFi)throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：更新分组任务,完成分组任务用。
	 *
	 * @param updateComTaskGroup
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年8月10日
	 *
	 */
	public void updateComTaskGroup(UpdateComTaskGroup updateComTaskGroup)throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：根据客户编号、导购编号更新沟通任务信息。
	 * 				新增沟通任务专用！！只关闭规定时间内沟通任务
	 *
	 * @param updateComTask
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月24日
	 *
	 */
	public void updateComTaskByMemberNo(UpdateComTask updateComTask)throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：根据客户编号、导购编号更新所有沟通任务信息
	 * 				修改为关闭所有除了 分组任务、初次介绍任务以外的沟通任务
	 *
	 * @param updateComTask
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月25日
	 *
	 */
	public void updateAllComTaskByMemberNo(UpdateComTask updateComTask)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询客户沟通任务信息
	 *
	 * @param findComTaskPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public Page<FindComTaskPageReturn> findComTaskPage(FindComTaskPage findComTaskPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找客户沟通任务信息
	 *
	 * @param findComTask
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author rain CreateDate: 2017年7月3日
	 *
	 */
	public List<FindComTaskReturn> findComTashTopOne(FindComTask findComTask) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：今天之前到店体验任务数量
	 *
	 * @param todayBeforeClientExpTaskDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月19日
	 *
	 */
	public TodayBeforeClientExpTaskReturn todayBeforeClientExpTask(TodayBeforeClientExpTaskDto todayBeforeClientExpTaskDto) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：应到店客户体验统计列表
	 *
	 * @param parmMap
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月22日
	 *
	 */
	List<Map<String,Object>> findExpResults(Map<String,Object> parmMap) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：统计沟通任务完成个数
	 *
	 * @param findComTask
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 梅宏博  CreateDate: 2017年8月22日
	 *
	 */
	public int findCountFinishByDay(FindComTask findComTask) throws TsfaServiceException;
}
