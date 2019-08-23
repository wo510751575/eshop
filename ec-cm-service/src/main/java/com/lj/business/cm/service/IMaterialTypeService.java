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
import com.lj.business.cm.dto.AddMaterialType;
import com.lj.business.cm.dto.AddMaterialTypeReturn;
import com.lj.business.cm.dto.DelMaterialType;
import com.lj.business.cm.dto.DelMaterialTypeReturn;
import com.lj.business.cm.dto.FindMaterialType;
import com.lj.business.cm.dto.FindMaterialTypePage;
import com.lj.business.cm.dto.FindMaterialTypePageReturn;
import com.lj.business.cm.dto.FindMaterialTypeReturn;
import com.lj.business.cm.dto.FindMaterialTypesApp;
import com.lj.business.cm.dto.FindMaterialTypesAppReturn;
import com.lj.business.cm.dto.UpdateMaterialType;
import com.lj.business.cm.dto.UpdateMaterialTypeReturn;



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
public interface IMaterialTypeService {
	
	/**
	 * 
	 *
	 * 方法说明：添加素材类型表信息
	 *
	 * @param addMaterialType
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	public AddMaterialTypeReturn addMaterialType(AddMaterialType addMaterialType) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找素材类型表信息
	 *
	 * @param findMaterialType
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	public FindMaterialTypeReturn findMaterialType(FindMaterialType findMaterialType) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除素材类型表信息
	 *
	 * @param delMaterialType
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	public DelMaterialTypeReturn delMaterialType(DelMaterialType delMaterialType) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改素材类型表信息
	 *
	 * @param updateMaterialType
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 */
	public UpdateMaterialTypeReturn updateMaterialType(UpdateMaterialType updateMaterialType)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：查找素材类型表信息
	 *
	 * @param findMaterialTypePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	public Page<FindMaterialTypePageReturn> findMaterialTypePage(FindMaterialTypePage findMaterialTypePage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找素材类型列表
	 *
	 * @param findMaterialType
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年6月23日
	 *
	 */
	public List<FindMaterialTypePageReturn> findMaterialTypes(FindMaterialTypePage findMaterialTypePage);
	
	/**
	 * 
	 *
	 * 方法说明：素材类型列表_APP用
	 *
	 * @param findMaterialTypesApp
	 * @return
	 *
	 * @author 彭阳 CreateDate: 2017年7月15日
	 *
	 */
	public List<FindMaterialTypesAppReturn> findMaterialTypesApp(FindMaterialTypesApp findMaterialTypesApp);
	
	/**
	 * 
	 *
	 * 方法说明：增加类型总数
	 *
	 * @param code 		类型编码
	 * @param decrement 增加数量
	 * @return
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月20日
	 *
	 */
	public int incrementTypeCountByPrimaryKey(String code, Integer increment);
	
	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @param code 		类型编码
	 * @param decrement 减少数量
	 * @return
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月20日
	 *
	 */
	public int decrementTypeCountByPrimaryKey(String code, Integer decrement);

	/**
	 *
	 *
	 * 方法说明：查找公共和个人素材类型表信息
	 *
	 * @param findMaterialTypePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	Page<FindMaterialTypePageReturn> findMaterialTypeForMemberPage(FindMaterialTypePage findMaterialTypePage) throws TsfaServiceException;

}
