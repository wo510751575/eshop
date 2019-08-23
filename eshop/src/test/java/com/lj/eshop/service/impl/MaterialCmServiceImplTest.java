package com.lj.eshop.service.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.eshop.dto.FindMaterialCmPage;
import com.lj.eshop.dto.FindMaterialEcmPage;
import com.lj.eshop.dto.MateriaEcmDto;
import com.lj.eshop.dto.MaterialCmDto;
import com.lj.eshop.dto.ProductDto;
import com.lj.eshop.emus.MaterialCmType;
import com.lj.eshop.service.IMaterialCmService;

/**
 * 类说明：测试类
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
public class MaterialCmServiceImplTest extends SpringTestCase{

	@Resource
	IMaterialCmService materialCmService;



	/**
	 * 
	 *
	 * 方法说明：添加CM素材关联信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addMaterialCm() throws TsfaServiceException{
		MaterialCmDto materialCmDto = new MaterialCmDto();
		//add数据录入
		materialCmDto.setCode("Code");
		materialCmDto.setCmMaterialCode("CmMaterialCode");
		materialCmDto.setProductCode("ProductCode");
		materialCmDto.setType(MaterialCmType.SALE.getValue());
		materialCmDto.setChoicenessCode("ChoicenessCode");
		materialCmDto.setShopCode("ShopCode");
		materialCmDto.setMerchantCode("111");
		materialCmDto.setProductName("proname");
//		materialCmDto.setEcGuildNo("materialCmDto.getEcGuildNo()");
//		materialCmDto.setEcShopNo("materialCmDto.getEcShopNo()");
//		materialCmDto.setEcMerchantNo("materialCmDto.getEcMerchantNo()");
		materialCmService.addMaterialCm(materialCmDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改CM素材关联信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateMaterialCm() throws TsfaServiceException{
		MaterialCmDto materialCmDto = new MaterialCmDto();
		//update数据录入
		materialCmDto.setCode("LJ_4e09d906a90740b3aed20d8b13b3aa7d");
		materialCmDto.setCmMaterialCode("CmMaterialCode");
		materialCmDto.setProductCode("ProductCode2");
		materialCmDto.setType(MaterialCmType.SALE.getValue());
		materialCmDto.setChoicenessCode("ChoicenessCode2");
		materialCmDto.setShopCode("ShopCode2");
		materialCmDto.setMerchantCode("1112");
		materialCmDto.setProductName("proname2");
//		materialCmDto.setEcGuildNo("materialCmDto.getEcGuildNo()");
//		materialCmDto.setEcShopNo("materialCmDto.getEcShopNo()");
//		materialCmDto.setEcMerchantNo("materialCmDto.getEcMerchantNo()");
		materialCmService.updateMaterialCm(materialCmDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找CM素材关联信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMaterialCm() throws TsfaServiceException{
		MaterialCmDto findMaterialCm = new MaterialCmDto();
		findMaterialCm.setCode("LJ_4e09d906a90740b3aed20d8b13b3aa7d");
		materialCmService.findMaterialCm(findMaterialCm);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找CM素材关联信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMaterialCmPage() throws TsfaServiceException{
		FindMaterialCmPage findMaterialCmPage = new FindMaterialCmPage();
		MaterialCmDto param = new MaterialCmDto();
		param.setType(MaterialCmType.PUBLIC.getValue());
		findMaterialCmPage.setParam(param);
		Page<MaterialCmDto> page = materialCmService.findMaterialCmPage(findMaterialCmPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找CM素材关联信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMaterialCms() throws TsfaServiceException{
		FindMaterialCmPage findMaterialCmPage = new FindMaterialCmPage();
		MaterialCmDto param = new MaterialCmDto();
		param.setMerchantCode("111");
		param.setType("0");
		param.setShopCode("shop");
		findMaterialCmPage.setParam(param);
		List<String> list = new ArrayList<String>();
		list.add("111");
		list.add("222");
		findMaterialCmPage.setInCmMaterialCodes(list);
		List<MaterialCmDto> page = materialCmService.findMaterialCms(findMaterialCmPage);
		Assert.assertNotNull(page);
		
	}
	
	
	
	
	
	@Test
	public void findMaterialSale() throws TsfaServiceException{
		FindMaterialEcmPage findMaterialEcmPage = new FindMaterialEcmPage();
		findMaterialEcmPage.setMaterialCmCode("LJ_00b8f18bfcdb48d4a9730c806d02f6f4");
		findMaterialEcmPage.setCmMaterialCode("LJ_c1eaead54925497cafa6b14f08a9e809");
		
		MateriaEcmDto materiaEcmDto = materialCmService.findMaterialSale(findMaterialEcmPage);
		System.out.println(materiaEcmDto);
	}
	
	
	@Test
	public void findCmMaterialPgae() throws TsfaServiceException{
		FindMaterialEcmPage findMaterialCmPage = new FindMaterialEcmPage();
		MaterialCmDto param = new MaterialCmDto();
		param.setProductName("戒指");
//		findMaterialCmPage.setParam(param);
		Page<MateriaEcmDto> page = materialCmService.findCmMaterialPgae(findMaterialCmPage);
		System.out.println(page);
		Assert.assertNotNull(page);
	}
	
	@Test
	public void findMaterialCommen() throws TsfaServiceException{
		FindMaterialEcmPage findMaterialCmPage = new FindMaterialEcmPage();
		MaterialCmDto param = new MaterialCmDto();
		param.setProductName("戒指");
		findMaterialCmPage.setParam(param);
		Page<MateriaEcmDto> page = materialCmService.findCmCommonMaterialPgae(findMaterialCmPage);
		System.out.println(page);
		Assert.assertNotNull(page);
	}
	
	
	@Test
	public void testAddCmMaterialSale() {
		MateriaEcmDto materialReturnDto = new MateriaEcmDto();
		materialReturnDto.setContent("materialDto.getRemarks()");
		materialReturnDto.setImgAddr("materialDto.getImgs()");
		materialReturnDto.setProductCode("materialDto.getProductCode()");
		materialReturnDto.setProductName("productName");
		materialReturnDto.setTitle("materialDto.getTitle()");
//		materialReturnDto.seteShopCode("eshopcode");
//		materialReturnDto.seteMerchantCode("");
		
		ProductDto paramProductDto = new ProductDto();
		paramProductDto.setCode("materialDto.getProductCode()");
		materialReturnDto.setProductName("productDto.getName()");
		
		//素材添加
		materialReturnDto.setMemberNameGm("setMemberNameGm");
		materialReturnDto.setMemberNoGm("guild.setMemberNoGm()");
		materialReturnDto.setMerchantNo("guild.getMerchantNo()");
		materialReturnDto.setMerchantName("guidMbrDto.getMerchantName()");
		materialReturnDto.setShopNo("guidMbrDto.getShopNo()");
		materialReturnDto.setShopName("guidMbrDto.getShopName()");
		materialCmService.addMaterialSale(materialReturnDto);
	}
	
	
}
