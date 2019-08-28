package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.common.SystemParamConstant;
import com.lj.business.member.dto.AddShop;
import com.lj.business.member.dto.DelShop;
import com.lj.business.member.dto.FindShop;
import com.lj.business.member.dto.FindShopDetail;
import com.lj.business.member.dto.FindShopDto;
import com.lj.business.member.dto.FindShopPage;
import com.lj.business.member.dto.FindShopPageReturn;
import com.lj.business.member.dto.FindShopReturn;
import com.lj.business.member.dto.FindShopReturnAreaCode;
import com.lj.business.member.dto.MemLineDto;
import com.lj.business.member.dto.UpdateShop;
import com.lj.business.member.service.IMemLineService;
import com.lj.business.member.service.IShopService;
import com.lj.business.member.util.TestHelp;
import com.lj.cc.clientintf.LocalCacheSystemParamsFromCC;
import com.lj.cc.enums.SystemAliasName;


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
public class ShopServiceImplTest extends SpringTestCase{

	@Resource
	IShopService shopService;


	@Resource
	private LocalCacheSystemParamsFromCC localCacheSystemParams;
	@Resource
	private IMemLineService memLineService;

   @Test
   public void test(){
	   MemLineDto memLineDto=new MemLineDto();
	   memLineDto.setName("df");
	  MemLineDto dto=memLineService.selectByName(memLineDto);
	  System.out.println(dto);
	   
   }
   
	@Test
	public void findShopByShopNo() throws Exception {
		FindShop findShop = new FindShop();
		findShop.setShopNoMerchant("TZJY001");
		FindShopPageReturn findShopByShopNo = shopService.findShopNoByCode(findShop);
		System.out.println(findShopByShopNo.getShopNo());
	}
	 
	@Test
	public void getSystemParam() throws TsfaServiceException{
		String uploadUrl =  localCacheSystemParams.getSystemParam(SystemAliasName.ms.toString(),SystemParamConstant.UPLOAD_GROUP, SystemParamConstant.UPLOAD_URL);
		System.out.println("uploadUrl:"+uploadUrl);
	}
	/**
	 * 
	 *
	 * 方法说明：添加分店信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addShop() throws TsfaServiceException{
		AddShop addShop = new AddShop();
		//add数据录入
		addShop.setAreaCode("AreaCode");
		addShop.setCityAreaCode("CityAreaCode");
		addShop.setAddrInfo("AddrInfo");
		addShop.setLogoAddr("LogoAddr");
		addShop.setLongitude("Longitude");
		addShop.setLatitude("Latitude");
		addShop.setBizScope("BizScope");
		addShop.setQcord("Qcord");
		addShop.setCreateId("CreateId");
		addShop.setRemark4("Remark4");
		addShop.setRemark3("Remark3");
		addShop.setRemark("Remark");
		addShop.setRemark2("Remark2");
		addShop.setShopType("时尚店");
		addShop.setShopName("湖南分店");
		addShop.setMemberNoMerchant("086c40e17ed44e89a0482366841c63f2");
		addShop.setMemberNameMerchant("敏华集团");
		addShop.setStatus("NORMAL");
		addShop.setTelephone("0755-2532110");
		addShop.setMobile("18733562651");
		addShop.setEmail("18733562651@139.com");
		addShop.setAddress("深圳市龙华区宝安大道780号");
		addShop.setAreaCode("1");
		addShop.setProvinceCode("2");
		addShop.setCityCode("3");
		addShop.setAddrInfo("深圳市龙华区宝安大道780号");
		addShop.setCreateId("安家管理员");
		
		/*addShop.setShopName("深圳市体验馆");
		addShop.setMemberNoMerchant("086c40e17ed44e89a0482366841c63f2");
		addShop.setMemberNameMerchant("安家");
		addShop.setStatus("NORMAL");
		addShop.setTelephone("400-1238666");
		addShop.setMobile("18733562651");
		addShop.setEmail("SZTYG@AJEmail.com");
		addShop.setAddress("深圳市龙华区宝安大道780号");
		addShop.setAreaCode("AreaCode");
		addShop.setProvinceCode("ProvinceCode");
		addShop.setCityCode("CityCode");
		addShop.setAddrInfo("深圳市龙华区宝安大道780号");
		addShop.setCreateId("安家管理员");*/
		
		Assert.assertNotNull(shopService.addShop(addShop ));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改分店信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateShop() throws TsfaServiceException{
		UpdateShop updateShop = new UpdateShop();
		//update数据录入
		updateShop.setCode("LJ_20adc034e1834f259300d267af958981");
		updateShop.setShopName("ShopName");
		updateShop.setMemberNoMerchant("MemberNoMerchant");
		updateShop.setMemberNameMerchant("MemberNameMerchant");
		updateShop.setStatus("Status");
		updateShop.setTelephone("Telephone");
		updateShop.setMobile("Mobile");
		updateShop.setEmail("Email");
		updateShop.setShopType("奢华");
		updateShop.setAddress("Address");
		updateShop.setAreaCode("AreaCode");
		updateShop.setProvinceCode("ProvinceCode");
		updateShop.setCityCode("CityCode");
		updateShop.setCityAreaCode("CityAreaCode");
		updateShop.setAddrInfo("AddrInfo");
		updateShop.setLogoAddr("LogoAddr");
		updateShop.setLongitude("Longitude");
		updateShop.setLatitude("Latitude");
		updateShop.setBizScope("BizScope");
		updateShop.setQcord("Qcord");
		updateShop.setUpdateId("UpdateId");
		updateShop.setRemark4("Remark4");
		updateShop.setRemark3("Remark3");
		updateShop.setRemark("Remark");
		updateShop.setRemark2("Remark2");

		shopService.updateShop(updateShop );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找分店信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findShop() throws TsfaServiceException{
		FindShop findShop = new FindShop(); 
		findShop.setMemberNoMerchant("1f169ad6143d46f5832535642ce2d331");
		List<FindShopPageReturn> returnList	=shopService.findShopType(findShop);
		System.out.println(returnList.toString());
	}
	
	
	
	/**
	 * 
	 *
	 * 方法说明：查找分店信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findShopPage() throws TsfaServiceException{
		FindShopPage findShopPage = new FindShopPage();
		findShopPage.setMemberNoMerchant("e79d975846ee41ba8c3c55738fda66a9");
//		findShopPage.setStatus("OPENED");
		findShopPage.setProvinceCode("104");
		Page<FindShopPageReturn> page = shopService.findShopPage(findShopPage);
		System.out.println(page.toString());
		
	}
	
	@Test
	public void findShopExport() throws TsfaServiceException{
		FindShopPage findShopPage = new FindShopPage();
		findShopPage.setMemberNoMerchant("e79d975846ee41ba8c3c55738fda66a9");
//		findShopPage.setStatus("OPENED");
//		findShopPage.setProvinceCode("104");
		List<FindShopPageReturn> list = shopService.findShopsExport(findShopPage);
		System.out.println(list.size());
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除分店信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delShop() throws TsfaServiceException{
		DelShop delShop = new DelShop();
		delShop.setCode(GUID.getPreUUID());
		Assert.assertNotNull(shopService.delShop(delShop));
		
	}
	
	@Test
	public void findShops() throws TsfaServiceException{
		FindShop findShop = new FindShop();
		findShop.setShopNo("LJ_c269478af52646b692fcc48deb10a7ad");
		List<FindShopPageReturn> page = shopService.findShops(findShop);
		System.out.println(page.toString());
		
	}
	
	@Test
	public void countByCondition() throws TsfaServiceException{
		Map<String,Object> parmMap = new HashMap<String, Object>();
		parmMap.put("memberNoMerchant", "e79d975846ee41ba8c3c55738fda66a9");
		Map<String,Object> returnMap = shopService.countByCondition(parmMap);
		System.out.println(returnMap.toString());
		
	}
	
	@Test
	public void findMonthOpen() throws TsfaServiceException{
		FindShop findShop = new FindShop();
		findShop.setMemberNoMerchant("e79d975846ee41ba8c3c55738fda66a9");
		List<FindShopPageReturn> list = shopService.findMonthOpen(findShop);
		System.out.println(list.toString());
		
	}
	
	@Test
	public void findMonthOpenss() throws TsfaServiceException{
		FindShopDto findShopDto=new FindShopDto();
		findShopDto.setMemberNoMerchant("e79d975846ee41ba8c3c55738fda66a9");
		List<FindShopReturnAreaCode> areaCode=shopService.selectByProvinceCode(findShopDto);
		System.out.println(areaCode.toString());
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：门店详情_H5
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年8月1日
	 *
	 */
	@Test
	public void findShopDetail() throws TsfaServiceException{
		FindShopDetail findShopDetail = new FindShopDetail();
		findShopDetail.setMerchantNo(TestHelp.merchantNo_test);
		findShopDetail.setShopNo(TestHelp.shopNo_test);
		shopService.findShopDetail(findShopDetail);
		
	}
	@Test
	public void findShopDetails() throws TsfaServiceException{
		FindShopDto findShopDto=new FindShopDto();
		findShopDto.setMemberNoMerchant("e79d975846ee41ba8c3c55738fda66a9");
		List<FindShopReturnAreaCode> list=shopService.selectByAreaCode(findShopDto);
		System.out.println(list.toString());
		
	}
	@Test
	public void findShopDetailss() throws TsfaServiceException{
		FindShopDto findShopDto=new FindShopDto();
		findShopDto.setAreaCode("1");
		int count=shopService.findShopCounts(findShopDto);
		
		System.out.println(count);
	}
	
	@Test
	public void findGroupByCity() throws TsfaServiceException{
		Map<String,Object> parmMap = new HashMap<String, Object>();
		parmMap.put("merchantNo", "e79d975846ee41ba8c3c55738fda66a9");
		List<Map<String,Object>> list = shopService.findGroupByCity(parmMap);
		System.out.println(list);
	}
	@Test
	public void findGroupBySize() throws TsfaServiceException{
		Map<String,Object>parmMap = new HashMap<String, Object>();
		parmMap.put("merchantNo", "e79d975846ee41ba8c3c55738fda66a9");
		List<Map<String,Object>> list = shopService.findCountBySize(parmMap);
		System.out.println(list.size());
	}
	
}
