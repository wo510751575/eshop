package com.lj.business.cf.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.pmAbandon.AbandonCheckDto;
import com.lj.business.cf.dto.pmAbandon.AddPmAbandon;
import com.lj.business.cf.dto.pmAbandon.AddPmAbandonReturn;
import com.lj.business.cf.dto.pmAbandon.DelPmAbandon;
import com.lj.business.cf.dto.pmAbandon.DelPmAbandonReturn;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandon;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandonList;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandonListReturn;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandonPage;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandonPageReturn;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandonReturn;
import com.lj.business.cf.dto.pmAbandon.UpdatePmAbandon;
import com.lj.business.cf.dto.pmAbandon.UpdatePmAbandonReturn;


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
public interface IPmAbandonService {
	
	/**
	 * 
	 *
	 * 方法说明：添加客户放弃表信息
	 *
	 * @param addPmAbandon
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public AddPmAbandonReturn addPmAbandon(AddPmAbandon addPmAbandon) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找客户放弃表信息
	 *
	 * @param findPmAbandon
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public FindPmAbandonReturn findPmAbandon(FindPmAbandon findPmAbandon) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除客户放弃表信息
	 *
	 * @param delPmAbandon
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public DelPmAbandonReturn delPmAbandon(DelPmAbandon delPmAbandon) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改客户放弃表信息
	 *
	 * @param updatePmAbandon
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public UpdatePmAbandonReturn updatePmAbandon(UpdatePmAbandon updatePmAbandon)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：查找客户放弃表信息
	 *
	 * @param findPmAbandonPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public Page<FindPmAbandonPageReturn> findPmAbandonPage(FindPmAbandonPage findPmAbandonPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：添加客户放弃表信息
	 *
	 * @param abandonMember
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author rain CreateDate: 2017年7月4日
	 *
	 */
	public AddPmAbandonReturn abandonMember(AddPmAbandon addPmAbandon) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：客户放弃表信息
	 *
	 * @param findPmAbandon
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author rain CreateDate: 2017年7月4日
	 *
	 */
	public List<FindPmAbandonReturn> abandonHistory(FindPmAbandon findPmAbandon) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：跟踪放弃审批
	 *
	 * @param abandonCheckDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月11日
	 *
	 */
	public int abandonCheck(AbandonCheckDto abandonCheckDto) throws TsfaServiceException; 
	/**
	 * 
	 *
	 * 方法说明：客户放弃记录
	 *
	 * @param findPmAbandonList（memberNoGm导购编号,merchantNo商户编号,memberNo客户编号）
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年7月13日
	 *
	 */
	public List<FindPmAbandonListReturn> findPmAbandonList(FindPmAbandonList findPmAbandonList)throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：修改未审批的放弃记录为拒绝
	 *
	 * @param cfNo
	 * @param memberNoGm
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月14日
	 *
	 */
	public void updateNoCheckByCfNo(String cfNo,String memberNo,String memberNoGm) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找未审批的放弃记录
	 *
	 * @param cfNo
	 * @param memberNo
	 * @param memberNoGm
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月14日
	 *
	 */
	public List<FindPmAbandonListReturn> findNoCheckByCfNo(String cfNo,String memberNo,String memberNoGm) throws TsfaServiceException;
}
