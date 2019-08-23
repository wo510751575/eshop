package com.lj.business.cm.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cm.dto.AddMaterialCommen;
import com.lj.business.cm.dto.AddMaterialCommenReturn;
import com.lj.business.cm.dto.CountMaterialCommenDto;
import com.lj.business.cm.dto.DelMaterialCommen;
import com.lj.business.cm.dto.DelMaterialCommenReturn;
import com.lj.business.cm.dto.FindMaterialCommen;
import com.lj.business.cm.dto.FindMaterialCommenPage;
import com.lj.business.cm.dto.FindMaterialCommenPageReturn;
import com.lj.business.cm.dto.FindMaterialCommenReturn;
import com.lj.business.cm.dto.GeneratorMaterialTotalReturn;
import com.lj.business.cm.dto.UpdateMaterialCommen;
import com.lj.business.cm.dto.UpdateMaterialCommenReturn;


/**
 * 类说明：接口类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 罗书明
 * 
 * 
 * CreateDate: 2017-06-21
 */
public interface IMaterialCommenService {
	
	/**
	 * 
	 *
	 * 方法说明：添加公用素材中心表信息
	 *
	 * @param addMaterialCommen
	 * @return
	 * @throws TsfaServiceException
	 *
	 *  @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	public AddMaterialCommenReturn addMaterialCommen(AddMaterialCommen addMaterialCommen) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找公用素材中心表信息
	 *
	 * @param findMaterialCommen
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	public FindMaterialCommenReturn findMaterialCommen(FindMaterialCommen findMaterialCommen) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除公用素材中心表信息
	 *
	 * @param delMaterialCommen
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	public DelMaterialCommenReturn delMaterialCommen(DelMaterialCommen delMaterialCommen) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改公用素材中心表信息
	 *
	 * @param updateMaterialCommen
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	public UpdateMaterialCommenReturn updateMaterialCommen(UpdateMaterialCommen updateMaterialCommen)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：查找公用素材中心表信息
	 *
	 * @param findMaterialCommenPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	public Page<FindMaterialCommenPageReturn> findMaterialCommenPage(FindMaterialCommenPage findMaterialCommenPage) throws TsfaServiceException;
    
	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @param MerchantNo商户编号
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年7月12日
	 *
	 */
	public List<FindMaterialCommenPageReturn>findMaterialCommenList(FindMaterialCommenPage findMaterialCommenPage)throws TsfaServiceException ;

	/**
	 * 
	 *
	 * 方法说明：根据素材编码查询素材
	 *
	 * @param code 素材编码
	 * @return
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月20日
	 *
	 */
	public FindMaterialCommenPageReturn findMaterialCommenByCode(String code);
	
	/**
	 * 
	 *
	 * 方法说明：回调添加公共素材回应数量
	 *
	 * @param code 素材编码
	 * @return
	 *
	 * @author 梅宏博 CreateDate: 2017年8月15日
	 * 
	 */
	public void addMaterialCommentRespondNum(String code);

	/**
	 * 
	 *
	 * 方法说明：统计公共素材条数
	 *
	 * @param countMaterialCommenDto
	 * @return
	 *
	 * @author 梅宏博 CreateDate: 2017年8月17日
	 * 
	 */
	public int countMaterialCommenSelective(
			CountMaterialCommenDto countMaterialCommenDto);

	/**
	 * 
	 * 方法说明：获取公共素材中心回应总数量
	 *
	 * @param
	 * @return 回应总数
	 *
	 * @author 梅宏博 CreateDate: 2017年8月17日
	 */
	public long getMaterialCommentResponseTotal(String merchantNo);

	/**
	 * 
	 * 方法说明：获取公共素材中心报表统计
	 *
	 * @param
	 * @return 统计数据
	 *
	 * @author 梅宏博 CreateDate: 2017年8月17日
	 */
	public List<GeneratorMaterialTotalReturn> generatorMaterialCommenTotal(String merchantNo);
}
