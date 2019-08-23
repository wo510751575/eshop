package com.lj.business.member.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.dto.custKeep.AddCustKeep;
import com.lj.business.member.dto.custKeep.DelCustKeep;
import com.lj.business.member.dto.custKeep.FindCustKeep;
import com.lj.business.member.dto.custKeep.FindCustKeepPage;
import com.lj.business.member.dto.custKeep.FindCustKeepPageReturn;
import com.lj.business.member.dto.custKeep.FindCustKeepReturn;


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
public interface ICustKeepService {
	
	/**
	 * 方法说明：添加客户关注操作信息.
	 *
	 * @param addCustKeep the add cust keep
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public void addCustKeep(AddCustKeep addCustKeep) throws TsfaServiceException;
	
	/**
	 * 方法说明：查找客户关注操作信息.
	 *
	 * @param findCustKeep the find cust keep
	 * @return the find cust keep return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public FindCustKeepReturn findCustKeep(FindCustKeep findCustKeep) throws TsfaServiceException;
	
	
	/**
	 * 方法说明：删除客户关注操作信息.
	 *
	 * @param delCustKeep the del cust keep
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public void delCustKeep(DelCustKeep delCustKeep) throws TsfaServiceException;


	/**
	 * 方法说明：分页查询客户关注操作信息.
	 *
	 * @param findCustKeepPage the find cust keep page
	 * @return the page< find cust keep page return>
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public Page<FindCustKeepPageReturn> findCustKeepPage(FindCustKeepPage findCustKeepPage) throws TsfaServiceException;
	

}
