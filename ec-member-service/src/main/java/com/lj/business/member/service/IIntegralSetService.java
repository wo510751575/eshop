package com.lj.business.member.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.dto.integralSet.AddIntegralSet;
import com.lj.business.member.dto.integralSet.DelIntegralSet;
import com.lj.business.member.dto.integralSet.FindIntegralSet;
import com.lj.business.member.dto.integralSet.FindIntegralSetReturn;
import com.lj.business.member.dto.integralSet.UpdateIntegralSet;


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
public interface IIntegralSetService {
	
	/**
	 * 
	 *
	 * 方法说明：添加积分设置表信息
	 *
	 * @param addIntegralSet
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void addIntegralSet(AddIntegralSet addIntegralSet) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找积分设置表信息
	 *
	 * @param findIntegralSet
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public FindIntegralSetReturn findIntegralSet(FindIntegralSet findIntegralSet) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除积分设置表信息
	 *
	 * @param delIntegralSet
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void delIntegralSet(DelIntegralSet delIntegralSet) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改积分设置表信息
	 *
	 * @param updateIntegralSet
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void updateIntegralSet(UpdateIntegralSet updateIntegralSet)throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：根据积分类型查询积分设置
	 *
	 * @param findIntegralSet
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月3日
	 *
	 */
	public FindIntegralSetReturn findIntegralSetByType(FindIntegralSet findIntegralSet) throws TsfaServiceException;


}
