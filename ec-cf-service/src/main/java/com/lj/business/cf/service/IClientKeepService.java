package com.lj.business.cf.service;

import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.domain.ClientKeep;
import com.lj.business.cf.dto.FindCForCKLastDateDto;
import com.lj.business.cf.dto.clientKeep.AddClientKeep;
import com.lj.business.cf.dto.clientKeep.AddClientKeepReturn;
import com.lj.business.cf.dto.clientKeep.DelClientKeep;
import com.lj.business.cf.dto.clientKeep.DelClientKeepReturn;
import com.lj.business.cf.dto.clientKeep.FindClientKeep;
import com.lj.business.cf.dto.clientKeep.FindClientKeepPage;
import com.lj.business.cf.dto.clientKeep.FindClientKeepPageReturn;
import com.lj.business.cf.dto.clientKeep.FindClientKeepReturn;
import com.lj.business.cf.dto.clientKeep.UpdateClientKeep;
import com.lj.business.cf.dto.clientKeep.UpdateClientKeepReturn;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */


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
public interface IClientKeepService {
	
	/**
	 * 
	 *
	 * 方法说明：添加客户维护记录表信息
	 *
	 * @param addClientKeep
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public AddClientKeepReturn addClientKeep(AddClientKeep addClientKeep) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找客户维护记录表信息
	 *
	 * @param findClientKeep
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public FindClientKeepReturn findClientKeep(FindClientKeep findClientKeep) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除客户维护记录表信息
	 *
	 * @param delClientKeep
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public DelClientKeepReturn delClientKeep(DelClientKeep delClientKeep) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改客户维护记录表信息
	 *
	 * @param updateClientKeep
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public UpdateClientKeepReturn updateClientKeep(UpdateClientKeep updateClientKeep)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：查找客户维护记录表信息
	 *
	 * @param findClientKeepPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public Page<FindClientKeepPageReturn> findClientKeepPage(FindClientKeepPage findClientKeepPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找客户维护表信息-APP
	 *
	 * @param FindClientKeep
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author rain CreateDate: 2017年7月4日
	 *
	 */
	public List<FindClientKeepReturn> clientKeepHistory(FindClientKeep findClientKeep) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：添加客户维护表信息-成单信息
	 *
	 * @param AddClientKeep
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author rain CreateDate: 2017年7月4日
	 *
	 */
	public AddClientKeepReturn addClientKeepInfo(AddClientKeep addClientKeep) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：新增客户维护表信息
	 *
	 * @param addClientKeep
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月11日
	 *
	 */
	public AddClientKeepReturn newClientKeepInfo(AddClientKeep addClientKeep)throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找最后一条维护记录
	 *
	 * @param findCForCKLastDateDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月27日
	 *
	 */
	public ClientKeep findLastClientKeep(FindCForCKLastDateDto findCForCKLastDateDto) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：根据导购编号和客户编号查找最后一条维护记录
	 *
	 * @param clientKeep
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 刘培 CreateDate: 2017年8月21日
	 *
	 */
	FindClientKeepReturn findLastClientKeepByGmAndMember(AddClientKeep clientKeep) throws TsfaServiceException;

}
