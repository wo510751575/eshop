package com.lj.business.cm.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cm.dto.activity.AddActivity;
import com.lj.business.cm.dto.activity.AddActivityReturn;
import com.lj.business.cm.dto.activity.DelActivity;
import com.lj.business.cm.dto.activity.DelActivityReturn;
import com.lj.business.cm.dto.activity.FindActivity;
import com.lj.business.cm.dto.activity.FindActivityDto;
import com.lj.business.cm.dto.activity.FindActivityPage;
import com.lj.business.cm.dto.activity.FindActivityPageReturn;
import com.lj.business.cm.dto.activity.FindActivityReturn;
import com.lj.business.cm.dto.activity.FindActivityReturnDto;
import com.lj.business.cm.dto.activity.UpdateActivity;
import com.lj.business.cm.dto.activity.UpdateActivityForReadDto;
import com.lj.business.cm.dto.activity.UpdateActivityReturn;


/**
 * 
 * 
 * 类说明：活动表接口
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年7月24日
 */
public interface IActivityService {
	
	/**
	 * 
	 *
	 * 方法说明：添加活动表信息
	 *
	 * @param addActivity
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2016年9月9日
	 *
	 */
	public AddActivityReturn addActivity(AddActivity addActivity) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找活动表信息
	 *
	 * @param findActivity
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2016年9月9日
	 *
	 */
	public FindActivityReturn findActivity(FindActivity findActivity) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除活动表信息
	 *
	 * @param delActivity
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2016年9月9日
	 *
	 */
	public DelActivityReturn delActivity(DelActivity delActivity) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改活动表信息
	 *
	 * @param updateActivity
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2016年9月9日
	 *
	 */
	public UpdateActivityReturn updateActivity(UpdateActivity updateActivity)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：查找活动表信息
	 *
	 * @param findActivityPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2016年9月9日
	 *
	 */
	public Page<FindActivityPageReturn> findActivityPage(FindActivityPage findActivityPage) throws TsfaServiceException;
	/**
	 * 
	 *
	 * 方法说明：查找活动列表
	 *
	 * @param findActivityDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 邹磊 CreateDate: 2017年7月24日
	 *
	 */
	public List<FindActivityPageReturn> findActivitys(FindActivityPage findActivityPage) throws TsfaServiceException;
	/**
	 * 
	 *
	 * 方法说明：点击量
	 *
	 * @param UpdateActivityForReadDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 邹磊 CreateDate: 2017年7月25日
	 *@deprecated
	 */
	public void updateActivityForRead(UpdateActivityForReadDto UpdateActivityForReadDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：增加活动分享量
	 *
	 * @param updateActivity
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月15日
	 *
	 */
	public void addActivityForShare(UpdateActivity updateActivity)throws TsfaServiceException;
}
