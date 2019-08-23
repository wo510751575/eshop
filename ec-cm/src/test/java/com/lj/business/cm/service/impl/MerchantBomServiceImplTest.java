package com.lj.business.cm.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cm.dto.AddMerchantBom;
import com.lj.business.cm.dto.DelMerchantBom;
import com.lj.business.cm.dto.FindMerchantBom;
import com.lj.business.cm.dto.FindMerchantBomPage;
import com.lj.business.cm.dto.FindMerchantBomPageReturn;
import com.lj.business.cm.dto.UpdateMerchantBom;
import com.lj.business.cm.service.IMerchantBomService;


/**
 * 类说明：测试类
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
public class MerchantBomServiceImplTest extends SpringTestCase{

	@Resource
	IMerchantBomService merchantBomService;



	/**
	 * 
	 *
	 * 方法说明：添加商户产品表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	@Test
	public void addMerchantBom() throws TsfaServiceException{
		AddMerchantBom addMerchantBom = new AddMerchantBom();
		//add数据录入
		addMerchantBom.setCode("Code");
		addMerchantBom.setMerchantNo("MerchantNo");
		addMerchantBom.setMerchantName("MerchantName");
		addMerchantBom.setBomCode("BomCode");
		addMerchantBom.setBomName("BomName");
		addMerchantBom.setImgAddr("ImgAddr");
		addMerchantBom.setCreateId("CreateId");
		addMerchantBom.setCreateDate(new Date());
		
		Assert.assertNotNull(merchantBomService.addMerchantBom(addMerchantBom ));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改商户产品表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	@Test
	public void updateMerchantBom() throws TsfaServiceException{
		UpdateMerchantBom updateMerchantBom = new UpdateMerchantBom();
		//update数据录入
		updateMerchantBom.setCode("Code");
		updateMerchantBom.setMerchantNo("MerchantNo");
		updateMerchantBom.setMerchantName("MerchantName");
		updateMerchantBom.setBomCode("BomCode");
		updateMerchantBom.setBomName("BomName");
		updateMerchantBom.setImgAddr("ImgAddr");
		updateMerchantBom.setCreateId("CreateId");
		updateMerchantBom.setCreateDate(new Date());

		merchantBomService.updateMerchantBom(updateMerchantBom );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商户产品表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	@Test
	public void findMerchantBom() throws TsfaServiceException{
		FindMerchantBom findMerchantBom = new FindMerchantBom();
		findMerchantBom.setCode("Code");
		merchantBomService.findMerchantBom(findMerchantBom);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商户产品表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	@Test
	public void findMerchantBomPage() throws TsfaServiceException{
		FindMerchantBomPage findMerchantBomPage = new FindMerchantBomPage();
		Page<FindMerchantBomPageReturn> page = merchantBomService.findMerchantBomPage(findMerchantBomPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除商户产品表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	@Test
	public void delMerchantBom() throws TsfaServiceException{
		DelMerchantBom delMerchantBom = new DelMerchantBom();
		delMerchantBom.setCode("Code");
		Assert.assertNotNull(merchantBomService.delMerchantBom(delMerchantBom));
		
	}
	
	
}
