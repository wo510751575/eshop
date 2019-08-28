package com.lj.eshop.service.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
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
	public void findCmMaterialPgae() throws TsfaServiceException{
		FindMaterialEcmPage findMaterialCmPage = new FindMaterialEcmPage();
		MaterialCmDto param = new MaterialCmDto();
		findMaterialCmPage.setParam(param);
		List<String> inTypes = new ArrayList<String>();
		inTypes.add(MaterialCmType.SALE.getValue());
		inTypes.add(MaterialCmType.PRIVATE.getValue());
		inTypes.add(MaterialCmType.PUBLIC.getValue());
		param.setInTypes(inTypes);
//		param.setType(MaterialCmType.SALE.getValue());
		param.setMerchantCode("LJ_d0e8edca19bc445bbca254ddca6703d9");
//		param.setShopCode("LJ_71011bdb03d149659061d03606488f81");
//		param.setMaterialTypeCode("LJ_6cb6a4f74b3f465a81ff29250ef87427");
		
		Page<MateriaEcmDto> page = materialCmService.findCmMaterialPgae(findMaterialCmPage);
		System.out.println(page);
		Assert.assertNotNull(page);
	}
	
	@Test
	public void findCmCommonMaterialPgae() throws TsfaServiceException{
		FindMaterialEcmPage findMaterialCmPage = new FindMaterialEcmPage();
		MaterialCmDto param = new MaterialCmDto();
		findMaterialCmPage.setParam(param);
//		param.setProductName("女首");
		param.setType(MaterialCmType.PUBLIC.getValue());
		param.setMerchantCode("LJ_d0e8edca19bc445bbca254ddca6703d9");
		param.setMaterialTypeCode("LJ_2889c51e5270479dae154a2d37a9d1c1");
		
		
		Page<MateriaEcmDto> page = materialCmService.findCmCommonMaterialPgae(findMaterialCmPage);
		System.out.println(page);
		Assert.assertNotNull(page);
	}
	
	
	@Test
	public void addMaterialSale() {
		MateriaEcmDto materialReturnDto = new MateriaEcmDto();
		materialReturnDto.setContent("materialDto.getRemarks()");
		materialReturnDto.setImgAddr("materialDto.getImgs()");
		materialReturnDto.setProductCode("materialDto.getProductCode()");
		materialReturnDto.setProductName("productName");
		materialReturnDto.setTitle("materialDto.getTitle()");
//		materialReturnDto.setMaterialTypeCode("LJ_41293c4444214d49b076464c88928af2");
		materialReturnDto.setType(MaterialCmType.PRIVATE.getValue());
//		materialReturnDto.seteShopCode("eshopcode");
//		materialReturnDto.seteMerchantCode("");
		
		ProductDto paramProductDto = new ProductDto();
		paramProductDto.setCode("materialDto.getProductCode()");
		materialReturnDto.setProductName("productDto.getName()");
		
		//素材添加
		materialReturnDto.setMemberNameGm("setMemberNameGm");
		materialReturnDto.setMemberNoGm("guild.setMemberNoGm()");
		materialReturnDto.setMerchantNo("d2f71eb681d24f35899a43c8a021fc2a");
		materialReturnDto.setMerchantName("guidMbrDto.getMerchantName()");
		materialReturnDto.setShopNo("guidMbrDto.getShopNo()");
		materialReturnDto.setShopName("guidMbrDto.getShopName()");
		materialCmService.addMaterialSale(materialReturnDto);
	}
	
	
	
	@Test
	public void findMateriaEcmDto() {
		MateriaEcmDto findMateriaEcmDto = new MateriaEcmDto();
		findMateriaEcmDto.setCode("LJ_8a6294c1eee94524ae93a431014e339b");
		MateriaEcmDto materiaEcmDto = materialCmService.findMaterialEcm(findMateriaEcmDto);
		System.out.println(materiaEcmDto);
	}

	@Test
	public void delCommonMaterial() {
		MaterialCmDto findMateriaEcmDto = new MaterialCmDto();
		findMateriaEcmDto.setCode("LJ_51ac610fb64944e6b8a642cdec98b785");
		materialCmService.delCommonMaterial(findMateriaEcmDto);
	}
	
	@Test
	public void delCmMaterial() {
		MaterialCmDto findMateriaEcmDto = new MaterialCmDto();
		findMateriaEcmDto.setCode("LJ_ff8040242791470183c52d0af69a8eb8");
		materialCmService.delCmMaterial(findMateriaEcmDto);
	}
	
	
	
}
