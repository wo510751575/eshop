package com.lj.business.cm.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cm.dto.AddMaterialType;
import com.lj.business.cm.dto.DelMaterialType;
import com.lj.business.cm.dto.FindMaterialType;
import com.lj.business.cm.dto.FindMaterialTypePage;
import com.lj.business.cm.dto.FindMaterialTypePageReturn;
import com.lj.business.cm.dto.FindMaterialTypesApp;
import com.lj.business.cm.dto.UpdateMaterialType;
import com.lj.business.cm.service.IMaterialTypeService;


/**
 * 类说明：测试类
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
public class MaterialTypeServiceImplTest extends SpringTestCase{

	@Resource
	IMaterialTypeService materialTypeService;



	/**
	 * 
	 *
	 * 方法说明：添加素材类型表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addMaterialType() throws TsfaServiceException{
		AddMaterialType addMaterialType = new AddMaterialType();
		//add数据录入
		addMaterialType.setCode(GUID.getPreUUID());
		addMaterialType.setMerchantNo("ml0001");
		addMaterialType.setMemberNoGm("9257");
		addMaterialType.setMemberNameGm("小三");
		addMaterialType.setTypeName("动作工学");
		addMaterialType.setRemark("备注");
		addMaterialType.setCreateId("小明");
		addMaterialType.setCreateDate(new Date());
		addMaterialType.setTypeCount(1);
		addMaterialType.setCustomerAttentionRate(0.985);
		addMaterialType.setImgAddr("1111.jpg");
		
		Assert.assertNotNull(materialTypeService.addMaterialType(addMaterialType ));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改素材类型表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateMaterialType() throws TsfaServiceException{
		UpdateMaterialType updateMaterialType = new UpdateMaterialType();
		//update数据录入
		updateMaterialType.setCode("LJ_c262857904e34750a53dc25ffa436ce8");
		updateMaterialType.setMerchantNo("MerchantNod");
		updateMaterialType.setMemberNoGm("MemberNoGmd");
		updateMaterialType.setMemberNameGm("MemberNameGmd");
		updateMaterialType.setTypeName("TypeNamed");
		updateMaterialType.setRemark("备注");
		updateMaterialType.setCreateId("CreateIdd");
		updateMaterialType.setCreateDate(new Date());

		materialTypeService.updateMaterialType(updateMaterialType);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找素材类型表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findMaterialType() throws TsfaServiceException{
		FindMaterialType findMaterialType = new FindMaterialType();
		findMaterialType.setCode("Codesd");
		materialTypeService.findMaterialType(findMaterialType);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找素材类型表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findMaterialTypePage() throws TsfaServiceException{
		
		FindMaterialTypePage findMaterialTypePage = new FindMaterialTypePage();
		findMaterialTypePage.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		findMaterialTypePage.setMemberNoGm("d7b963349b8f4bcbbed9a36fe41ae626");
		Page<FindMaterialTypePageReturn> page = materialTypeService.findMaterialTypePage(findMaterialTypePage);
		System.out.println(page);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除素材类型表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delMaterialType() throws TsfaServiceException{
		DelMaterialType delMaterialType = new DelMaterialType();
		delMaterialType.setId("1");
		Assert.assertNotNull(materialTypeService.delMaterialType(delMaterialType));
		
	}
	
	@Test
	public void findMaterialTypes() throws TsfaServiceException{
		FindMaterialTypePage findMaterialTypePage = new FindMaterialTypePage();
		findMaterialTypePage.setLimit(100);
		findMaterialTypePage.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		List<FindMaterialTypePageReturn>list=materialTypeService.findMaterialTypes(findMaterialTypePage);
		System.out.println(list.size());
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：素材类型列表_APP用
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月15日
	 *
	 */
	@Test
	public void findMaterialTypesApp() throws TsfaServiceException{
		FindMaterialTypesApp findMaterialTypesApp = new FindMaterialTypesApp();
		findMaterialTypesApp.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		findMaterialTypesApp.setMemberNoGm("d7b963349b8f4bcbbed9a36fe41ae626");
		Assert.assertNotNull(materialTypeService.findMaterialTypesApp(findMaterialTypesApp));
		
	}
	
	@Test
	public void findMaterialTypeForMemberPage() throws Exception {
		FindMaterialTypePage findMaterialTypePage = new FindMaterialTypePage();
		findMaterialTypePage.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		findMaterialTypePage.setMemberNoGm("efbc3bb7be534d24b9cb6d72ac21f666");
		Page<FindMaterialTypePageReturn> findMaterialTypeForMemberPage = materialTypeService.findMaterialTypeForMemberPage(findMaterialTypePage);
		for (FindMaterialTypePageReturn pageReturn : findMaterialTypeForMemberPage.getRows()) {
			System.out.println(pageReturn);
		}
	}
	
}
