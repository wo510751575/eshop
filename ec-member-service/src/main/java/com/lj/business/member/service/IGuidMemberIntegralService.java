package com.lj.business.member.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.dto.guidMemberIntegral.AddGuidMemberIntegral;
import com.lj.business.member.dto.guidMemberIntegral.DelGuidMemberIntegral;
import com.lj.business.member.dto.guidMemberIntegral.FindGuidMemberIntegral;
import com.lj.business.member.dto.guidMemberIntegral.FindGuidMemberIntegralReturn;
import com.lj.business.member.dto.guidMemberIntegral.GuidMemberIntegralDto;
import com.lj.business.member.dto.guidMemberIntegral.UpdateGuidMemberIntegral;


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
public interface IGuidMemberIntegralService {
	
	/**
	 * 
	 *
	 * 方法说明：添加导购积分明细表信息
	 *
	 * @param addGuidMemberIntegral
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void addGuidMemberIntegral(AddGuidMemberIntegral addGuidMemberIntegral) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找导购积分明细表信息
	 *
	 * @param findGuidMemberIntegral
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public FindGuidMemberIntegralReturn findGuidMemberIntegral(FindGuidMemberIntegral findGuidMemberIntegral) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除导购积分明细表信息
	 *
	 * @param delGuidMemberIntegral
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void delGuidMemberIntegral(DelGuidMemberIntegral delGuidMemberIntegral) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改导购积分明细表信息
	 *
	 * @param updateGuidMemberIntegral
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void updateGuidMemberIntegral(UpdateGuidMemberIntegral updateGuidMemberIntegral)throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：积分
	 *
	 * @param guidMemberIntegralDto
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月3日
	 *
	 */
	public void doIntegral(GuidMemberIntegralDto guidMemberIntegralDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：根据类型查询明细列表
	 *
	 * @param findGuidMemberIntegral
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月3日
	 *
	 */
	public List<FindGuidMemberIntegralReturn>  findByIntegralType(FindGuidMemberIntegral findGuidMemberIntegral) throws TsfaServiceException;


}
