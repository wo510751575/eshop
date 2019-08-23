package com.lj.business.cf.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.FindAddGuidInfoRecordDto;
import com.lj.business.cf.dto.clientGuidInfo.AddClientGuidInfo;
import com.lj.business.cf.dto.clientGuidInfo.DelClientGuidInfo;
import com.lj.business.cf.dto.clientGuidInfo.FindClientGuidInfo;
import com.lj.business.cf.dto.clientGuidInfo.FindClientGuidInfoReturn;
import com.lj.business.cf.dto.clientGuidInfo.UpdateClientGuidInfo;


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
public interface IClientGuidInfoService {
	
	/**
	 * 
	 *
	 * 方法说明：添加客户引导记录表信息
	 *
	 * @param addClientGuidInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void addClientGuidInfo(AddClientGuidInfo addClientGuidInfo) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找客户引导记录表信息
	 *
	 * @param findClientGuidInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public FindClientGuidInfoReturn findClientGuidInfo(FindClientGuidInfo findClientGuidInfo) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除客户引导记录表信息
	 *
	 * @param delClientGuidInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void delClientGuidInfo(DelClientGuidInfo delClientGuidInfo) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改客户引导记录表信息
	 *
	 * @param updateClientGuidInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void updateClientGuidInfo(UpdateClientGuidInfo updateClientGuidInfo)throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：素材引导
	 *
	 * @param findAddGuidInfoRecordDto
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月9日
	 *
	 */
	public void addGuidInfoRecord(FindAddGuidInfoRecordDto findAddGuidInfoRecordDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查询引导次数
	 *
	 * @param findAddGuidInfoRecordDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月9日
	 *
	 */
	public int guidInfoRecordCount(FindAddGuidInfoRecordDto findAddGuidInfoRecordDto) throws TsfaServiceException;

}
