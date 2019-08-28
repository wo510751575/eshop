package com.lj.business.cm.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cm.domain.Material;
import com.lj.business.cm.dto.AddMaterial;
import com.lj.business.cm.dto.DelMaterial;
import com.lj.business.cm.dto.FindMaterial;
import com.lj.business.cm.dto.FindMaterialAppPage;
import com.lj.business.cm.dto.FindMaterialAppPageReturn;
import com.lj.business.cm.dto.FindMaterialPage;
import com.lj.business.cm.dto.FindMaterialPageReturn;
import com.lj.business.cm.dto.GeneratorMaterialTotalReturn;
import com.lj.business.cm.dto.UpdateMaterial;
import com.lj.business.cm.service.IMaterialCommenService;
import com.lj.business.cm.service.IMaterialService;


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
public class MaterialServiceImplTest extends SpringTestCase{

	@Resource
	IMaterialService materialService;

	@Resource
	IMaterialCommenService materialCommenService;

	/**
	 * 
	 *
	 * 方法说明：添加素材中心表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addMaterial() throws TsfaServiceException {
			AddMaterial addMaterial = new AddMaterial();
			// add数据录入
			addMaterial.setCode(GUID.getPreUUID());
			addMaterial.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
			addMaterial.setMemberNoGm("efbc3bb7be534d24b9cb6d72ac21f666");
			addMaterial.setMemberNameGm("深圳安家店-小李");
			addMaterial.setMaterialTypeCode("LJ_e4b5436cd9384063a64a40bba1cc8a66");
			addMaterial.setMaterialTypeName("初次介绍");
			addMaterial.setTitle("测试");
			addMaterial.setContent("最近比较烦");
			addMaterial.setCreateDate(new Date());

			Assert.assertNotNull(materialService.addMaterial(addMaterial));
	}

	/**
	 * 
	 *
	 * 方法说明：修改素材中心表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateMaterial() throws TsfaServiceException{
		UpdateMaterial updateMaterial = new UpdateMaterial();
		//update数据录入
		updateMaterial.setCode("Code");
		updateMaterial.setMerchantNo("MerchantNo");
		updateMaterial.setMemberNoGm("MemberNoGm");
		updateMaterial.setMemberNameGm("MemberNameGm");
		updateMaterial.setMaterialTypeCode("MaterialTypeCode");
		updateMaterial.setMaterialTypeName("MaterialTypeName");
		updateMaterial.setTitle("Title");
		updateMaterial.setContent("Content");
		updateMaterial.setImgAddr("ImgAddr");
		updateMaterial.setCreateId("CreateId");
		updateMaterial.setCreateDate(new Date());

		materialService.updateMaterial(updateMaterial );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找素材中心表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findMaterial() throws TsfaServiceException{
		FindMaterial findMaterial = new FindMaterial();
		findMaterial.setMemberNoGm("809bca1878df413a9072399cabcae4c4");
		materialService.findMaterial(findMaterial);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找素材中心表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findMaterialPage() throws TsfaServiceException{
		FindMaterialPage findMaterialPage = new FindMaterialPage();
		Page<FindMaterialPageReturn> page = materialService.findMaterialPage(findMaterialPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除素材中心表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delMaterial() throws TsfaServiceException{
		DelMaterial delMaterial = new DelMaterial();
		delMaterial.setCode("");
		Assert.assertNotNull(materialService.delMaterial(delMaterial));
		
	}
	
	/**
	 * 方法说明：.
	 *
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 罗书明 CreateDate: 2017年6月22日
	 */
	@Test
	public void delMateria() throws TsfaServiceException{
		Material delMaterial = new Material();
		delMaterial.setMaterialTypeName("MaterialTypeName");
	    materialService.selectByTypeName("delMaterial") ;
		
	}
	
	
	/**
	 * 
	 *
	 * 方法说明：素材类型明细列表_APP用
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月15日
	 *
	 */
	@Test
	public void findMaterialAppPage() throws TsfaServiceException{
		FindMaterialAppPage findMaterialAppPage = new FindMaterialAppPage();
		findMaterialAppPage.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		findMaterialAppPage.setMemberNoGm("fa49303dfaf34be2be9c8add34b630f8");
		findMaterialAppPage.setMaterialTypeCode("LJ_b5d45e7dd2c540499f128037312fc273");
		Page<FindMaterialAppPageReturn> page = materialService.findMaterialAppPage(findMaterialAppPage);
		System.out.println(page);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：根据素材编码查询个人素材
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月20日
	 *
	 */
	@Test
	public void findMaterialByCode() {
		FindMaterialPageReturn result = materialService.findMaterialByCode("485e3af155e6420cbcaa122417749f85");
		Assert.assertNotNull(result);
		System.out.println(result);
	}
	
	@Test
	public void total() throws Exception {
		//统计回应总量
		BigDecimal responseTotal = BigDecimal.valueOf(materialService.getMaterialResponseTotal("1f169ad6143d46f5832535642ce2d331") + materialCommenService.getMaterialCommentResponseTotal("1f169ad6143d46f5832535642ce2d331"));
		
		System.out.println(responseTotal);
		responseTotal = responseTotal.compareTo(new BigDecimal(0)) > 0 ? responseTotal : new BigDecimal(1);//防止空指针
		
		List<GeneratorMaterialTotalReturn> totalReturn = materialService.generatorMaterialTotal("1f169ad6143d46f5832535642ce2d331");//统计导购素材总量
		List<GeneratorMaterialTotalReturn> commenTotalReturn = materialCommenService.generatorMaterialCommenTotal("1f169ad6143d46f5832535642ce2d331");//统计公共素材总量
		System.out.println(responseTotal);
		for (GeneratorMaterialTotalReturn generatorMaterialTotalReturn : totalReturn) {
			System.out.println(generatorMaterialTotalReturn);
		}
		System.out.println("------------");
		for (GeneratorMaterialTotalReturn generatorMaterialTotalReturn : commenTotalReturn) {
			System.out.println(generatorMaterialTotalReturn);
		}
	}
	
	@Test
	public void getMaterialResponseTotal() throws Exception {
		long i = materialService.getMaterialResponseTotal("LJ_1c279c8b1b594c0eb1dd09205ecc9ead");
		System.out.println(i);
	}
	
	
	@Test
	public void findMaterials() throws Exception {
		FindMaterialPage findMaterialPage = new FindMaterialPage(); 
		List<String> codes = new ArrayList<String>();
		codes.add("LJ_797272b478fe4d838f1ca54e67622387");
		findMaterialPage.setCodes(codes);
		List<FindMaterialPageReturn> list = materialService.findMaterials(findMaterialPage);
		System.out.println(list.size() + "\r\n" + list);
	}
	
}
