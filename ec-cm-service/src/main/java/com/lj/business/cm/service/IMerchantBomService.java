package com.lj.business.cm.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.business.cm.dto.AddMerchantBom;
import com.lj.business.cm.dto.AddMerchantBomReturn;
import com.lj.business.cm.dto.DelMerchantBom;
import com.lj.business.cm.dto.DelMerchantBomReturn;
import com.lj.business.cm.dto.FindMerchantBom;
import com.lj.business.cm.dto.FindMerchantBomPage;
import com.lj.business.cm.dto.FindMerchantBomPageReturn;
import com.lj.business.cm.dto.FindMerchantBomReturn;
import com.lj.business.cm.dto.UpdateMerchantBom;
import com.lj.business.cm.dto.UpdateMerchantBomReturn;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;


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
public interface IMerchantBomService {
	
	/**
	 * 
	 *
	 * 方法说明：添加商户产品表信息
	 *
	 * @param addMerchantBom
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明  CreateDate: 2017年6月21日
	 *
	 */
	public AddMerchantBomReturn addMerchantBom(AddMerchantBom addMerchantBom) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找商户产品表信息
	 *
	 * @param findMerchantBom
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明  CreateDate: 2017年6月21日
	 *
	 */
	public FindMerchantBomReturn findMerchantBom(FindMerchantBom findMerchantBom) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：删除商户产品表信息
	 *
	 * @param delMerchantBom
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明  CreateDate: 2017年6月21日
	 *
	 */
	public DelMerchantBomReturn delMerchantBom(DelMerchantBom delMerchantBom) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改商户产品表信息
	 *
	 * @param updateMerchantBom
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明  CreateDate: 2017年6月21日
	 *
	 */
	public UpdateMerchantBomReturn updateMerchantBom(UpdateMerchantBom updateMerchantBom)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：查找商户产品表信息
	 *
	 * @param findMerchantBomPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明  CreateDate: 2017年6月21日
	 *
	 */
	public Page<FindMerchantBomPageReturn> findMerchantBomPage(FindMerchantBomPage findMerchantBomPage) throws TsfaServiceException;
	

}
