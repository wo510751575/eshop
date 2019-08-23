package com.lj.business.member.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.business.member.dto.behaviorInfoPm.AddBehaviorInfoPm;
import com.lj.business.member.dto.behaviorInfoPm.DelBehaviorInfoPm;
import com.lj.business.member.dto.behaviorInfoPm.FindBehaviorInfoPm;
import com.lj.business.member.dto.behaviorInfoPm.FindBehaviorInfoPmPage;
import com.lj.business.member.dto.behaviorInfoPm.FindBehaviorInfoPmPageReturn;
import com.lj.business.member.dto.behaviorInfoPm.FindBehaviorInfoPmReturn;
import com.lj.business.member.dto.behaviorInfoPm.UpdateBehaviorInfoPm;

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
public interface IBehaviorInfoPmService {
	
	/**
	 * 方法说明：添加客户动态详情信息.
	 *
	 * @param addBehaviorInfoPm the add behavior info pm
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public void addBehaviorInfoPm(AddBehaviorInfoPm addBehaviorInfoPm) throws TsfaServiceException;
	
	/**
	 * 方法说明：查找客户动态详情信息.
	 *
	 * @param findBehaviorInfoPm the find behavior info pm
	 * @return the find behavior info pm return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public FindBehaviorInfoPmReturn findBehaviorInfoPm(FindBehaviorInfoPm findBehaviorInfoPm) throws TsfaServiceException;
	
	
	/**
	 * 方法说明：删除客户动态详情信息.
	 *
	 * @param delBehaviorInfoPm the del behavior info pm
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public void delBehaviorInfoPm(DelBehaviorInfoPm delBehaviorInfoPm) throws TsfaServiceException;

	/**
	 * 方法说明：修改客户动态详情信息.
	 *
	 * @param updateBehaviorInfoPm the update behavior info pm
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public void updateBehaviorInfoPm(UpdateBehaviorInfoPm updateBehaviorInfoPm)throws TsfaServiceException;

	/**
	 * 方法说明：分页查询客户动态详情信息.
	 *
	 * @param findBehaviorInfoPmPage the find behavior info pm page
	 * @return the page< find behavior info pm page return>
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public Page<FindBehaviorInfoPmPageReturn> findBehaviorInfoPmPage(FindBehaviorInfoPmPage findBehaviorInfoPmPage) throws TsfaServiceException;
	

}
