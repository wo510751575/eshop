package com.lj.business.member.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.business.member.dto.behaviorPm.AddBehaviorPm;
import com.lj.business.member.dto.behaviorPm.DelBehaviorPm;
import com.lj.business.member.dto.behaviorPm.FindBehaviorPm;
import com.lj.business.member.dto.behaviorPm.FindBehaviorPmPage;
import com.lj.business.member.dto.behaviorPm.FindBehaviorPmPageReturn;
import com.lj.business.member.dto.behaviorPm.FindBehaviorPmReturn;
import com.lj.business.member.dto.behaviorPm.UpdateBehaviorPm;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;


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
public interface IBehaviorPmService {
	
	/**
	 * 方法说明：添加客户最近动态信息.
	 *
	 * @param addBehaviorPm the add behavior pm
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public void addBehaviorPm(AddBehaviorPm addBehaviorPm) throws TsfaServiceException;
	
	/**
	 * 方法说明：查找客户最近动态信息.
	 *
	 * @param findBehaviorPm the find behavior pm
	 * @return the find behavior pm return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public FindBehaviorPmReturn findBehaviorPm(FindBehaviorPm findBehaviorPm) throws TsfaServiceException;
	
	
	/**
	 * 方法说明：删除客户最近动态信息.
	 *
	 * @param delBehaviorPm the del behavior pm
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public void delBehaviorPm(DelBehaviorPm delBehaviorPm) throws TsfaServiceException;

	/**
	 * 方法说明：修改客户最近动态信息.
	 *
	 * @param updateBehaviorPm the update behavior pm
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public void updateBehaviorPm(UpdateBehaviorPm updateBehaviorPm)throws TsfaServiceException;

	/**
	 * 方法说明：分页查询客户最近动态信息.
	 *
	 * @param findBehaviorPmPage the find behavior pm page
	 * @return the page< find behavior pm page return>
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public Page<FindBehaviorPmPageReturn> findBehaviorPmPage(FindBehaviorPmPage findBehaviorPmPage) throws TsfaServiceException;
	

}
