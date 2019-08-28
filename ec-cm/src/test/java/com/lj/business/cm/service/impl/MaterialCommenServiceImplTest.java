package com.lj.business.cm.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cm.dto.AddMaterialCommen;
import com.lj.business.cm.dto.DelMaterialCommen;
import com.lj.business.cm.dto.FindMaterialCommen;
import com.lj.business.cm.dto.FindMaterialCommenPage;
import com.lj.business.cm.dto.FindMaterialCommenPageReturn;
import com.lj.business.cm.dto.FindMaterialCommenReturn;
import com.lj.business.cm.dto.UpdateMaterialCommen;
import com.lj.business.cm.service.IMaterialCommenService;


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
public class MaterialCommenServiceImplTest extends SpringTestCase{

	@Resource
	IMaterialCommenService materialCommenService;



	/**
	 * 
	 *
	 * 方法说明：添加公用素材中心表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addMaterialCommen() throws TsfaServiceException {
			AddMaterialCommen addMaterialCommen = new AddMaterialCommen();
			// add数据录入
			addMaterialCommen.setCode(GUID.generateByUUID());
			addMaterialCommen.setMaterialTypeCode("LJ_1c279c8b1b594c0eb1dd09205ecc9ead");
			addMaterialCommen.setMaterialTypeName("动作工学");
			addMaterialCommen.setTitle("Titled");
			addMaterialCommen.setContent("Contentd");
			addMaterialCommen.setShopName("name");
			addMaterialCommen.setShopNo("no");
			addMaterialCommen.setDimensionSt("d");
			addMaterialCommen.setImgAddr("ImgAddrd");
			addMaterialCommen.setRespondNum(1);
			addMaterialCommen.setCreateId("CreateId");
			addMaterialCommen.setCreateDate(new Date());
			addMaterialCommen.setMerchantNo("111");
			addMaterialCommen.setMerchantName("222");
			addMaterialCommen.setLinkUrl("k");
			addMaterialCommen.setShopType("类型");
			Assert.assertNotNull(materialCommenService.addMaterialCommen(addMaterialCommen));
	}

	/**
	 * 
	 *
	 * 方法说明：修改公用素材中心表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateMaterialCommen() throws TsfaServiceException{
		UpdateMaterialCommen updateMaterialCommen = new UpdateMaterialCommen();
		//update数据录入
		updateMaterialCommen.setCode("LJ_8bc7011ae415414a976a9757d21802e9");
		updateMaterialCommen.setMaterialTypeCode("MaterialTypeCode");
		updateMaterialCommen.setMaterialTypeName("MaterialTypeName");
		updateMaterialCommen.setTitle("Title");
		updateMaterialCommen.setContent("Content");
		updateMaterialCommen.setImgAddr("ImgAddr");
		updateMaterialCommen.setRespondNum(2);
		updateMaterialCommen.setCreateId("CreateId");
		updateMaterialCommen.setCreateDate(new Date());

		materialCommenService.updateMaterialCommen(updateMaterialCommen );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找公用素材中心表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findMaterialCommen() throws TsfaServiceException{
		FindMaterialCommen findMaterialCommen = new FindMaterialCommen();
		findMaterialCommen.setCode("LJ_6d430a7e6e98474ca97adab7132054c5");
		FindMaterialCommenReturn findMaterialCommenReturn =	materialCommenService.findMaterialCommen(findMaterialCommen);
		System.out.println(findMaterialCommenReturn.toString());
	}
	
	/**
	 * 
	 *
	 * 方法说明：测试findMaterialCommenList()
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年7月12日
	 *
	 */
	@Test
	public void findMaterialCommenList() throws TsfaServiceException{
		FindMaterialCommenPage findMaterialCommenPage=new FindMaterialCommenPage();
		materialCommenService.findMaterialCommenList(findMaterialCommenPage);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找公用素材中心表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findMaterialCommenPage() throws TsfaServiceException{
		FindMaterialCommenPage findMaterialCommenPage = new FindMaterialCommenPage();
		findMaterialCommenPage.setMerchantNo("086c40e17ed44e89a0482366841c63f2");
		findMaterialCommenPage.setMaterialTypeCode("Code0051");
		findMaterialCommenPage.setTitle("啊");
		Page<FindMaterialCommenPageReturn> page = materialCommenService.findMaterialCommenPage(findMaterialCommenPage);
		System.out.println(page.getRows().size());
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除公用素材中心表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delMaterialCommen() throws TsfaServiceException{
		DelMaterialCommen delMaterialCommen = new DelMaterialCommen();
		delMaterialCommen.setCode("2");
		Assert.assertNotNull(materialCommenService.delMaterialCommen(delMaterialCommen));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：根据素材编码查询公共素材
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月20日
	 *
	 */
	@Test
	public void findMaterialCommenByCode() {
		FindMaterialCommenPageReturn result = materialCommenService.findMaterialCommenByCode("0c49011407684abe96662d9764524802");
		Assert.assertNotNull(result);
		System.out.println(result);
	}
	
	
	@Test
	public void addMaterialCommentRespondNum() throws Exception {
		materialCommenService.addMaterialCommentRespondNum("LJ_8bc7011ae415414a976a9757d21802e9");
	}
	
	@Test
	public void getMaterialCommentResponseTotal() throws Exception {
		System.out.println(materialCommenService.getMaterialCommentResponseTotal("LJ_1c279c8b1b594c0eb1dd09205ecc9ead"));
	}
}
