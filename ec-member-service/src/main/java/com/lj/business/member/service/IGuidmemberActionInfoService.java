package com.lj.business.member.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.dto.FindGuidmemberActionInfoListDto;
import com.lj.business.member.dto.guidmemberActionInfo.AddGuidmemberActionInfo;
import com.lj.business.member.dto.guidmemberActionInfo.DelGuidmemberActionInfo;
import com.lj.business.member.dto.guidmemberActionInfo.FindGuidmemberActionInfo;
import com.lj.business.member.dto.guidmemberActionInfo.FindGuidmemberActionInfoReturn;
import com.lj.business.member.dto.guidmemberActionInfo.UpdateGuidmemberActionInfo;


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
public interface IGuidmemberActionInfoService {
	
	/**
	 * 
	 *
	 * 方法说明：添加导购行为信息记录表信息
	 *
	 * @param addGuidmemberActionInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void addGuidmemberActionInfo(AddGuidmemberActionInfo addGuidmemberActionInfo) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找导购行为信息记录表信息
	 *
	 * @param findGuidmemberActionInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public FindGuidmemberActionInfoReturn findGuidmemberActionInfo(FindGuidmemberActionInfo findGuidmemberActionInfo) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除导购行为信息记录表信息
	 *
	 * @param delGuidmemberActionInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void delGuidmemberActionInfo(DelGuidmemberActionInfo delGuidmemberActionInfo) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改导购行为信息记录表信息
	 *
	 * @param updateGuidmemberActionInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年07月10日
	 *
	 */
	public void updateGuidmemberActionInfo(UpdateGuidmemberActionInfo updateGuidmemberActionInfo)throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查询导购行为统计
	 *
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月10日
	 *
	 */
	public List<FindGuidmemberActionInfoReturn> findGuidmemberActionInfoList(FindGuidmemberActionInfoListDto findGuidmemberActionInfoListDto) throws TsfaServiceException;


}
