package com.lj.business.cm.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.base.exception.TsfaServiceException;


/**
 * 
 * 
 * 类说明：活动调度任务
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月15日
 */
public interface IActivityJobService {
	
	/**
	 * 
	 *
	 * 方法说明：活动产生任务
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月15日
	 *
	 */
	public void activityComTask() throws TsfaServiceException;
}
