package com.lj.business.cf.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;
import java.util.Map;

import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.FindAddInviteRecordDto;
import com.lj.business.cf.dto.clientInvite.AddClientInvite;
import com.lj.business.cf.dto.clientInvite.DelClientInvite;
import com.lj.business.cf.dto.clientInvite.FindClientInvite;
import com.lj.business.cf.dto.clientInvite.FindClientInviteReturn;
import com.lj.business.cf.dto.clientInvite.UpdateClientInvite;


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
public interface IClientInviteService {
	
	/**
	 * 
	 *
	 * 方法说明：添加客户邀约表信息
	 *
	 * @param addClientInvite
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void addClientInvite(AddClientInvite addClientInvite) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找客户邀约表信息
	 *
	 * @param findClientInvite
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public FindClientInviteReturn findClientInvite(FindClientInvite findClientInvite) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除客户邀约表信息
	 *
	 * @param delClientInvite
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void delClientInvite(DelClientInvite delClientInvite) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改客户邀约表信息
	 *
	 * @param updateClientInvite
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void updateClientInvite(UpdateClientInvite updateClientInvite)throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：客户邀约
	 *
	 * @param findAddInviteRecordDto
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月8日
	 *
	 */
	public void addInviteRecord(FindAddInviteRecordDto findAddInviteRecordDto) throws TsfaServiceException;

	
	/**
	 * 
	 *
	 * 方法说明：统计邀约到店人数
	 * merchantNo 商户
	 * inviteResult  是否邀约成功 Y/N
	 *	startTime/endTime 起始到店时间	
	 *
	 * @param parmMap
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月9日
	 *
	 */
	public List<Map<String,Object>> findInviteResults(Map<String,Object> parmMap);
	
	/**
	 * 
	 *
	 * 方法说明：邀约成功次数
	 *
	 * @param findAddInviteRecordDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月9日
	 *
	 */
	public int inviteRecordCount(FindAddInviteRecordDto findAddInviteRecordDto)  throws TsfaServiceException;
}
