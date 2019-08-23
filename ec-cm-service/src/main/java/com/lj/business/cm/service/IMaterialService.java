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
import com.lj.business.cm.domain.Material;
import com.lj.business.cm.dto.AddMaterial;
import com.lj.business.cm.dto.AddMaterialReturn;
import com.lj.business.cm.dto.CountMaterialDto;
import com.lj.business.cm.dto.DelMaterial;
import com.lj.business.cm.dto.DelMaterialReturn;
import com.lj.business.cm.dto.FindMaterial;
import com.lj.business.cm.dto.FindMaterialAppPage;
import com.lj.business.cm.dto.FindMaterialAppPageReturn;
import com.lj.business.cm.dto.FindMaterialPage;
import com.lj.business.cm.dto.FindMaterialPageReturn;
import com.lj.business.cm.dto.FindMaterialReturn;
import com.lj.business.cm.dto.GeneratorMaterialTotalReturn;
import com.lj.business.cm.dto.UpdateMaterial;
import com.lj.business.cm.dto.UpdateMaterialReturn;


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
 * CreateDate: 2017-06-14
 */
public interface IMaterialService {
	
	/**
	 * 
	 *
	 * 方法说明：添加素材中心表信息
	 *
	 * @param addMaterial
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	public AddMaterialReturn addMaterial(AddMaterial addMaterial) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找素材中心表信息
	 *
	 * @param findMaterial
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	public FindMaterialReturn findMaterial(FindMaterial findMaterial) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除素材中心表信息
	 *
	 * @param delMaterial
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	public DelMaterialReturn delMaterial(DelMaterial delMaterial) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改素材中心表信息
	 *
	 * @param updateMaterial
	 * @return
	 * @throws TsfaServiceException
	 *
	 *  @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	public UpdateMaterialReturn updateMaterial(UpdateMaterial updateMaterial)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：查找素材中心表信息
	 *
	 * @param findMaterialPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	public Page<FindMaterialPageReturn> findMaterialPage(FindMaterialPage findMaterialPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查询数量
	 *
	 * @param findMaterialPage
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年6月22日
	 *
	 */
	public int findMaterialPageCount(FindMaterialPage findMaterialPage);
	
	
	/**
	 * 
	 *
	 * 方法说明：
	 *  按类型查询标题
	 * @param materialTypeName
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年6月22日
	 *
	 */
	public Material selectByTypeName(String materialTypeName);
	
	
	/**
	 * 
	 *
	 * 方法说明：素材类型明细列表_APP用
	 *
	 * @param findMaterialAppPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月15日
	 *
	 */
	public Page<FindMaterialAppPageReturn> findMaterialAppPage(FindMaterialAppPage findMaterialAppPage) throws TsfaServiceException;

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
	public FindMaterialPageReturn findMaterialByCode(String code);

	/**
	 * 
	 * 方法说明：统计素材条数
	 *
	 * @param countMaterialDto
	 * @return
	 *
	 * @author 梅宏博 CreateDate: 2017年8月17日
	 */
	public int countMaterialSelective(CountMaterialDto countMaterialDto);

	/**
	 * 
	 * 方法说明：统计素材中心报表
	 *
	 * @param
	 * @return 统计集合
	 *
	 * @author 梅宏博 CreateDate: 2017年8月17日
	 */
	public List<GeneratorMaterialTotalReturn> generatorMaterialTotal(String merchantNo);

	/**
	 * 
	 * 方法说明：获取素材中心回应总数量
	 *
	 * @param
	 * @return 回应总数
	 *
	 * @author 梅宏博 CreateDate: 2017年8月17日
	 */
	public long getMaterialResponseTotal(String merchantNo);
	
	/**
	 * 
	 * 方法说明：
	 * 电商专用-增加素材
	 * @param @param addMaterial
	 * @param @return
	 * @param @throws TsfaServiceException    设定文件 
	 * @return AddMaterialReturn    返回类型 
	 * @throws Exception
	 *
	 * @author 林进权
	 *         CreateDate: 2017年9月18日
	 */
	public AddMaterialReturn addMaterialEc(AddMaterial addMaterial) throws TsfaServiceException;

}
