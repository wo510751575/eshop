package com.lj.business.cm.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cm.dto.textInfo.AddTextInfo;
import com.lj.business.cm.dto.textInfo.DelTextInfo;
import com.lj.business.cm.dto.textInfo.FindTextInfo;
import com.lj.business.cm.dto.textInfo.FindTextInfoPage;
import com.lj.business.cm.dto.textInfo.FindTextInfoPageReturn;
import com.lj.business.cm.dto.textInfo.FindTextInfoReturn;
import com.lj.business.cm.dto.textInfo.UpdateTextInfo;


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
public interface ITextInfoService {
	
	/**
	 * 
	 *
	 * 方法说明：添加话术信息
	 *
	 * @param addTextInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public void addTextInfo(AddTextInfo addTextInfo) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找话术信息
	 *
	 * @param findTextInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public FindTextInfoReturn findTextInfo(FindTextInfo findTextInfo) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除话术信息
	 *
	 * @param delTextInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public void delTextInfo(DelTextInfo delTextInfo) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改话术信息
	 *
	 * @param updateTextInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public void updateTextInfo(UpdateTextInfo updateTextInfo)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询话术信息
	 *
	 * @param findTextInfoPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月9日
	 *
	 */
	public Page<FindTextInfoPageReturn> findTextInfoPage(FindTextInfoPage findTextInfoPage) throws TsfaServiceException;
	
    /**
     * 
     *
     * 方法说明：返回话术内容
     *
     * @param findTextInfo
     * @return
     *
     * @author 罗书明 CreateDate: 2017年8月3日
     *
     */
	public  FindTextInfoPageReturn findTextInfoReturnContent(FindTextInfo findTextInfo);
}
