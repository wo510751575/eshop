package com.lj.business.member.service;

import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.business.member.dto.AddPmType;
import com.lj.business.member.dto.AddPmTypePmDto;
import com.lj.business.member.dto.AddPmTypeReturn;
import com.lj.business.member.dto.ChangePmType;
import com.lj.business.member.dto.ChangePmTypeApp;
import com.lj.business.member.dto.ChangePmTypeUngroup;
import com.lj.business.member.dto.ChangeUrgency;
import com.lj.business.member.dto.CheckPmTypeDto;
import com.lj.business.member.dto.CheckPmTypeReturn;
import com.lj.business.member.dto.DelPmType;
import com.lj.business.member.dto.DelPmTypeReturn;
import com.lj.business.member.dto.FindPmType;
import com.lj.business.member.dto.FindPmTypeIndex;
import com.lj.business.member.dto.FindPmTypeIndexReturn;
import com.lj.business.member.dto.FindPmTypePage;
import com.lj.business.member.dto.FindPmTypePageReturn;
import com.lj.business.member.dto.FindPmTypeReturn;
import com.lj.business.member.dto.UpdatePmType;
import com.lj.business.member.dto.UpdatePmTypeReturn;


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
public interface IPmTypeService {
	

	/**
	 * 方法说明：改变紧急（默认为取消紧急）.
	 *
	 * @param changeUrgency the change urgency
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年7月12日
	 */
	public void changeUrgency(ChangeUrgency changeUrgency)throws TsfaServiceException;

	/**
	 * 方法说明：更改客户所属分类_APP，有业务逻辑，触发沟通任务。且有是否真正修改分类判断。
	 * 未分组--》意向，非意向*N
	 * 意向--》非意向*N.
	 * 适用于客户管理首页
	 *
	 * @param changePmTypeApp the change pm type app
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年7月12日
	 */
	public void changePmType_app(ChangePmTypeApp changePmTypeApp)throws TsfaServiceException;
	

	/**
	 * 方法说明：更改客户所属分类_APP，有业务逻辑，触发沟通任务。且有是否真正修改分类判断。
	 * 未分组--》意向，非意向*N
	 * 适用于APP，新增客户列表中直接分组功能。
	 *
	 * @param changePmTypeApp the change pm type app
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年7月12日
	 */
	public void changePmType_app_ungroup(ChangePmTypeUngroup changePmTypeUngroup)throws TsfaServiceException;
	
	/**
	 * 方法说明：更改客户所属分类,单纯修改分类，没有其他业务逻辑，不触发沟通任务。也不触发初次介绍的修改.
	 *
	 * @param changePmType the change pm type
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年7月11日
	 */
	public void changePmType(ChangePmType changePmType)throws TsfaServiceException;

	/**
	 * 方法说明：客户管理首页：分类信息查询.
	 *
	 * @param findPmTypeIndex the find pm type index
	 * @return the list< find pm type index return>
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年7月10日
	 */
	public List<FindPmTypeIndexReturn> findPmTypeIndex(FindPmTypeIndex findPmTypeIndex)throws TsfaServiceException;

	
	/**
	 * 方法说明：条件查询返回.
	 *
	 * @param findPmTypePageReturn the find pm type page return
	 * @return the list< find pm type page return>
	 * @author 罗书明 CreateDate: 2017年7月4日
	 */
	public List<FindPmTypePageReturn> findPmTypePages(FindPmTypePageReturn findPmTypePageReturn)throws TsfaServiceException;
	
	/**
	 * 方法说明：添加客户分类表信息.
	 *
	 * @param addPmType the add pm type
	 * @return the adds the pm type return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public AddPmTypeReturn addPmType(AddPmType addPmType) throws TsfaServiceException;
	
	/**
	 * 方法说明：查找客户分类表信息.
	 *
	 *
	 * @param findPmType the find pm type
	 * @return the find pm type return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public FindPmTypeReturn findPmType(FindPmType findPmType) throws TsfaServiceException;
	
	
	/**
	 * 方法说明：根据商户号和客户分类查询.
	 *
	 * @param findPmType the find pm type
	 * @return the find pm type return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 冯辉 CreateDate: 2017年7月12日
	 */
	public FindPmTypeReturn findPmTypeByMP(FindPmType findPmType) throws TsfaServiceException ;
	
	
	/**
	 * 方法说明：删除客户分类表信息.
	 *
	 * @param delPmType the del pm type
	 * @return the del pm type return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public DelPmTypeReturn delPmType(DelPmType delPmType) throws TsfaServiceException;

	/**
	 * 方法说明：修改客户分类表信息.
	 *
	 * @param updatePmType the update pm type
	 * @return the update pm type return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public UpdatePmTypeReturn updatePmType(UpdatePmType updatePmType)throws TsfaServiceException;

	/**
	 * 方法说明：查找客户分类表信息.
	 *
	 * @param findPmTypePage the find pm type page
	 * @return the page< find pm type page return>
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public Page<FindPmTypePageReturn> findPmTypePage(FindPmTypePage findPmTypePage) throws TsfaServiceException;
	

	/**
	 * 方法说明：查找客户所有分类表信息.
	 *
	 * @param merchantNo the merchant no
	 * @return List
	 * @throws TsfaServiceException the tsfa service exception
	 * @author rain CreateDate: 2017年7月3日
	 */
	public List<FindPmType> inqueryMemberGroupInfo(String merchantNo)throws TsfaServiceException;
	
	/**
	 * 方法说明：我的客户-新增客户，提供客户分组基本信息查询  排除.
	 *
	 * @param merchantNo the merchant no
	 * @param memberNo the member no
	 * @param memberNoGm the member no gm
	 * @param flag the flag
	 * @return List
	 * @throws TsfaServiceException the tsfa service exception
	 * @author rain CreateDate: 2017年7月3日
	 */
	public List<FindPmType> inqueryMemberOutOffGroupInfo(String merchantNo,String memberNo,String memberNoGm,String flag)throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：添加或修改客户分组交叉
	 *
	 * @param addPmTypePmDto
	 *
	 * @author 冯辉 CreateDate: 2017年8月14日
	 *
	 */
	public void addPmTypePmRepeat(AddPmTypePmDto addPmTypePmDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：添加或修改客户分组
	 *
	 * @param addPmTypePmDto
	 *
	 * @author 冯辉 CreateDate: 2017年8月15日
	 *
	 */
	public void addPmTypePm(AddPmTypePmDto addPmTypePmDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：客户分类查询判断
	 *
	 * @param checkPmTypeDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月15日
	 *
	 */
	public CheckPmTypeReturn checkPmType(CheckPmTypeDto checkPmTypeDto) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：根据客户号查询客户分类code
	 *
	 * @param memberNo 客户号
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 梅宏博 CreateDate: 2017年8月19日
	 *
	 */
	public String findPmTypeTypeByPm(String codePm) throws TsfaServiceException;
	
}
