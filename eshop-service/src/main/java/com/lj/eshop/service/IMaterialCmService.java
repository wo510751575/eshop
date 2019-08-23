package com.lj.eshop.service;

import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.dto.FindMaterialCmPage;
import com.lj.eshop.dto.FindMaterialEcmPage;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.MaterialCmDto;
import com.lj.eshop.dto.MateriaEcmDto;
import com.lj.eshop.dto.ShopDto;
/**
 * 类说明：接口类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author lhy
 * 
 * 
 * CreateDate: 2017-08-22
 */
public interface IMaterialCmService {
	
	/**
	 * 
	 *
	 * 方法说明：添加CM素材关联信息信息
	 *
	 * @param materialCmDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-09-18
	 *
	 */
	public void addMaterialCm(MaterialCmDto materialCmDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找CM素材关联信息信息
	 *
	 * @param findMaterialCm
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-09-18
	 *
	 */
	public MaterialCmDto findMaterialCm(MaterialCmDto materialCmDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询CM素材关联信息信息
	 *
	 * @param findMaterialCmPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-09-18
	 *
	 */
	public List<MaterialCmDto>  findMaterialCms(FindMaterialCmPage findMaterialCmPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改CM素材关联信息信息
	 *
	 * @param updateMaterialCm
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-09-18
	 *
	 */
	public void updateMaterialCm(MaterialCmDto materialCmDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询CM素材关联信息信息
	 *
	 * @param findMaterialCmPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-09-18
	 *
	 */
	public Page<MaterialCmDto> findMaterialCmPage(FindMaterialCmPage findMaterialCmPage) throws TsfaServiceException;
	
	
	
	/**
	 * 方法说明：分页查找cm的素材
	 *
	 * @param findMaterialCmPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-09-18
	 *
	 */
	public Page<MateriaEcmDto> findCmMaterialPgae(FindMaterialEcmPage findMaterialEcmPage) throws TsfaServiceException;
	/**
	 * 方法说明：分页查找cm的公共素材
	 *
	 * @param findMaterialCmPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-09-18
	 *
	 */
	public Page<MateriaEcmDto> findCmCommonMaterialPgae(FindMaterialEcmPage findMaterialEcmPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：删除
	 *
	 * @param updateMaterialCm
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-09-18
	 *
	 */
	public void delMaterial(MaterialCmDto materialCmDto)throws TsfaServiceException;

	/**
	 * 增加卖家素材
	 * 方法说明：
	 *
	 * @param @param materialDto    设定文件 
	 * @return void    返回类型 
	 * @throws Exception
	 *
	 * @author 林进权
	 *         CreateDate: 2017年9月18日
	 */
	public void addMaterialSale(MateriaEcmDto materiaEcmDto);
	/**
	 * 引用为精选
	 * 方法说明：
	 *
	 * @param @param materialDto    设定文件 
	 * @return void    返回类型 
	 * @throws Exception
	 *
	 * @author 林进权
	 *         CreateDate: 2017年9月18日
	 */
	public void updBiztypeForPub(MateriaEcmDto materiaEcmDto,ShopDto shopDto);
	/**
	 * 增加公共素材
	 * 方法说明：
	 *
	 * @param @param materialDto    设定文件 
	 * @return void    返回类型 
	 * @throws Exception
	 *
	 * @author 林进权
	 *         CreateDate: 2017年9月18日
	 */
	public void addMaterialPub(MateriaEcmDto materiaEcmDto);
	/**
	 * 更新公共素材
	 * 方法说明：
	 *
	 * @param @param materialDto    设定文件 
	 * @return void    返回类型 
	 * @throws Exception
	 *
	 * @author 林进权
	 *         CreateDate: 2017年9月18日
	 */
	public void updMaterialPub(MateriaEcmDto materiaEcmDto);
	/**
	 * 公共素材查询
	 * 方法说明：
	 *
	 * @param @param materialDto    设定文件 
	 * @return void    返回类型 
	 * @throws Exception
	 *
	 * @author 林进权
	 *         CreateDate: 2017年9月18日
	 */
	public MateriaEcmDto findMaterialCommen(FindMaterialEcmPage findMaterialEcmPage);
	/**
	 * 卖家素材查询
	 * 方法说明：
	 *
	 * @param @param materialDto    设定文件 
	 * @return void    返回类型 
	 * @throws Exception
	 *
	 * @author 林进权
	 *         CreateDate: 2017年9月18日
	 */
	public MateriaEcmDto findMaterialSale(FindMaterialEcmPage findMaterialEcmPage);
	
}
