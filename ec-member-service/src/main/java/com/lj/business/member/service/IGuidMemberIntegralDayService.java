package com.lj.business.member.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.dto.guidMemberIntegralDay.AddGuidMemberIntegralDay;
import com.lj.business.member.dto.guidMemberIntegralDay.DelGuidMemberIntegralDay;
import com.lj.business.member.dto.guidMemberIntegralDay.FindGuidMemberIntegralDay;
import com.lj.business.member.dto.guidMemberIntegralDay.FindGuidMemberIntegralDayReturn;
import com.lj.business.member.dto.guidMemberIntegralDay.UpdateGuidMemberIntegralDay;


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
public interface IGuidMemberIntegralDayService {
	
	/**
	 * 
	 *
	 * 方法说明：添加导购积分日总表信息
	 *
	 * @param addGuidMemberIntegralDay
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void addGuidMemberIntegralDay(AddGuidMemberIntegralDay addGuidMemberIntegralDay) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找导购积分日总表信息
	 *
	 * @param findGuidMemberIntegralDay
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public FindGuidMemberIntegralDayReturn findGuidMemberIntegralDay(FindGuidMemberIntegralDay findGuidMemberIntegralDay) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除导购积分日总表信息
	 *
	 * @param delGuidMemberIntegralDay
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void delGuidMemberIntegralDay(DelGuidMemberIntegralDay delGuidMemberIntegralDay) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改导购积分日总表信息
	 *
	 * @param updateGuidMemberIntegralDay
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void updateGuidMemberIntegralDay(UpdateGuidMemberIntegralDay updateGuidMemberIntegralDay)throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：添加或修改日积分
	 *
	 * @param AddGuidMemberIntegralDay
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月3日
	 *
	 */
	public void addOrUpdateGuidMemberIntegralDay(AddGuidMemberIntegralDay addGuidMemberIntegralDay) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找导购的积分
	 *
	 * @param findGuidMemberIntegralDay
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月10日
	 *
	 */
	public FindGuidMemberIntegralDayReturn findByGMDay(FindGuidMemberIntegralDay findGuidMemberIntegralDay) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找导购的积分
	 *
	 * @param findGuidMemberIntegralDay
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月11日
	 *
	 */
	public List<FindGuidMemberIntegralDayReturn> findByGMDayList(FindGuidMemberIntegralDay findGuidMemberIntegralDay) throws TsfaServiceException;

}
