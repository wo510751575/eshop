package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.encryption.MD5;
import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.member.dto.AddPersonMemberBase;
import com.lj.business.member.dto.DelPersonMemberBase;
import com.lj.business.member.dto.FindPersonMemberBase;
import com.lj.business.member.dto.FindPersonMemberBaseList;
import com.lj.business.member.dto.FindPersonMemberBasePage;
import com.lj.business.member.dto.FindPersonMemberBasePageReturn;
import com.lj.business.member.dto.FindPersonMemberBaseReturn;
import com.lj.business.member.dto.FindPersonMemberBaseReturnList;
import com.lj.business.member.dto.UpdatePersonMemberBase;
import com.lj.business.member.emus.MemberStatus;
import com.lj.business.member.emus.NameAuthFlag;
import com.lj.business.member.service.IPersonMemberBaseService;


/**
 * 类说明：测试类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 段志鹏
 * 
 * 
 * CreateDate: 2017-06-14
 */
public class PersonMemberBaseServiceImplTest extends SpringTestCase{

	@Resource
	IPersonMemberBaseService personMemberBaseService;



	/**
	 * 
	 *
	 * 方法说明：添加客户会员信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addPersonMemberBase() throws TsfaServiceException{
		AddPersonMemberBase addPersonMemberBase = new AddPersonMemberBase();
		//add数据录入
		addPersonMemberBase.setCode(GUID.getPreUUID());
		addPersonMemberBase.setMemberNo(GUID.getPreUUID());
		addPersonMemberBase.setMemberName("邹磊");
		addPersonMemberBase.setStatus(MemberStatus.NORMAL);
		addPersonMemberBase.setCertTypeCode("身份证");
		addPersonMemberBase.setCertNo("362228199105053419");
		addPersonMemberBase.setMobile("18888668905");
		addPersonMemberBase.setEmail("18888668905@139.com");
		addPersonMemberBase.setJob("IT");
		addPersonMemberBase.setAddress("西丽");
		addPersonMemberBase.setAge(26);
		addPersonMemberBase.setSex("男");
		addPersonMemberBase.setNameAuthFlag(NameAuthFlag.N);
		addPersonMemberBase.setPwd(MD5.encryptByMD5("123456"));
		addPersonMemberBase.setEncryptionCode("3");
		addPersonMemberBase.setMemberSrc("微信扫码");
		addPersonMemberBase.setOpenIdGzhWx("");
		addPersonMemberBase.setOpenIdXcxWx("");
		addPersonMemberBase.setNickNameWx("阳光");
		addPersonMemberBase.setCityWx("广东");
		addPersonMemberBase.setCountryWx("中国");
		addPersonMemberBase.setProvinceWx("深圳");
		addPersonMemberBase.setHeadAddress("http://");
		addPersonMemberBase.setSubsribeTime(new Date());
		addPersonMemberBase.setCreateId("导购");
		addPersonMemberBase.setCreateDate(new Date());
		addPersonMemberBase.setUpdateId("店长");
		addPersonMemberBase.setUpdateDate(new Date());
		
		Assert.assertNotNull(personMemberBaseService.addPersonMemberBase(addPersonMemberBase ));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改客户会员信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updatePersonMemberBase() throws TsfaServiceException{
		UpdatePersonMemberBase updatePersonMemberBase = new UpdatePersonMemberBase();
		//update数据录入
		updatePersonMemberBase.setCode(GUID.getPreUUID());
		updatePersonMemberBase.setMemberNo("MemberNo");
		updatePersonMemberBase.setMemberName("MemberName");
		updatePersonMemberBase.setStatus("Status");
		updatePersonMemberBase.setCertTypeCode("CertTypeCode");
		updatePersonMemberBase.setCertNo("CertNo");
		updatePersonMemberBase.setMobile("Mobile");
		updatePersonMemberBase.setEmail("Email");
		updatePersonMemberBase.setJob("Job");
		updatePersonMemberBase.setAddress("Address");
		updatePersonMemberBase.setAge(1);
		updatePersonMemberBase.setSex("Sex");
		updatePersonMemberBase.setNameAuthFlag("NameAuthFlag");
		updatePersonMemberBase.setPwd("Pwd");
		updatePersonMemberBase.setEncryptionCode("EncryptionCode");
		updatePersonMemberBase.setMemberSrc("MemberSrc");
		updatePersonMemberBase.setOpenIdGzhWx("OpenIdGzhWx");
		updatePersonMemberBase.setOpenIdXcxWx("OpenIdXcxWx");
		updatePersonMemberBase.setNickNameWx("NickNameWx");
		updatePersonMemberBase.setCityWx("CityWx");
		updatePersonMemberBase.setCountryWx("CountryWx");
		updatePersonMemberBase.setProvinceWx("ProvinceWx");
		updatePersonMemberBase.setHeadAddress("HeadAddress");
		updatePersonMemberBase.setSubsribeTime(new Date());
		updatePersonMemberBase.setCreateId("CreateId");
		updatePersonMemberBase.setCreateDate(new Date());
		updatePersonMemberBase.setUpdateId("UpdateId");
		updatePersonMemberBase.setUpdateDate(new Date());

		personMemberBaseService.updatePersonMemberBase(updatePersonMemberBase );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找客户会员信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findPersonMemberBase() throws TsfaServiceException{
		FindPersonMemberBase findPersonMemberBase = new FindPersonMemberBase();
		findPersonMemberBase.setCode("LJ_6c4a9461-c6c0-42da-810e-a7e114933676");
		personMemberBaseService.findPersonMemberBase(findPersonMemberBase);
	}
	@Test
	public void findPersonMemberBases() throws TsfaServiceException{
		FindPersonMemberBase findPersonMemberBase = new FindPersonMemberBase();
		findPersonMemberBase.setMemberNoGm("d7b963349b8f4bcbbed9a36fe41ae626");
		findPersonMemberBase.setMemberNo("7d245b39bdd94445983883ba58f9bb82");
		personMemberBaseService.findPersonMemberBaseParams(findPersonMemberBase);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找客户会员信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年6月10日
	 * @throws ParseException 
	 *
	 */
	@Test
	public void findPersonMemberBasePage() throws TsfaServiceException, ParseException{
		FindPersonMemberBasePage findPersonMemberBasePage = new FindPersonMemberBasePage();
//		findPersonMemberBasePage.setMemberNo("a");
//		findPersonMemberBasePage.setMemberName("Ka");
//		findPersonMemberBasePage.setMemberNoGm("322c391c09e44a1ea79bea495324f7cd");
//		findPersonMemberBasePage.setShopNo("ShopNo");
//		findPersonMemberBasePage.setMerchantNo("MerchantNo");
//		findPersonMemberBasePage.setMemberSrc("微信扫码");
//		findPersonMemberBasePage.setStartTime(DateUtils.parseDate("2017-06-29 18:27:57",DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
//		findPersonMemberBasePage.setEndTime(DateUtils.parseDate("2017-06-29 18:27:59",DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
//		findPersonMemberBasePage.setPmTypeCode("1");
		Page<FindPersonMemberBasePageReturn> page = personMemberBaseService.findPersonMemberBasePage(findPersonMemberBasePage);
		System.out.println(page.toString());
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除客户会员信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delPersonMemberBase() throws TsfaServiceException{
		DelPersonMemberBase delPersonMemberBase = new DelPersonMemberBase();
		delPersonMemberBase.setCode(GUID.getPreUUID());
		Assert.assertNotNull(personMemberBaseService.delPersonMemberBase(delPersonMemberBase));
		
	}
	
	@Test
	public void findPersonMemberBaseLists() throws TsfaServiceException{
		FindPersonMemberBaseList findPersonMemberBaseList=new FindPersonMemberBaseList();
		findPersonMemberBaseList.setMemberNo("8d9d67a2de514ce0b531470ba51ba20c");
	    FindPersonMemberBaseReturnList list=personMemberBaseService.findPersonMemberBaseList(findPersonMemberBaseList);
	    System.out.println(list);
		
		
	}
	
	@Test
	public void findByMobile() throws TsfaServiceException{
		FindPersonMemberBase  findPersonMemberBase=new FindPersonMemberBase();
		findPersonMemberBase.setMobile("13434774585");
		FindPersonMemberBaseReturn baseReturn =personMemberBaseService.findByMobile(findPersonMemberBase);
		System.out.println(baseReturn.toString());
	}
	@Test
	public void findPersonMemberBaseCounts() throws TsfaServiceException{
		FindPersonMemberBaseList findPersonMemberBaseList=new FindPersonMemberBaseList();
		findPersonMemberBaseList.setAreaCode("1");
		FindPersonMemberBaseReturnList findPersonMemberBaseReturnList=personMemberBaseService.findPersonMemberBaseCounts(findPersonMemberBaseList);
		System.out.println(findPersonMemberBaseReturnList);
	}
	@Test
	public void findPersonMemberMax(){
		FindPersonMemberBaseReturnList findPersonMemberBaseReturnList=personMemberBaseService.findPersonMemberMax();
		System.out.println(findPersonMemberBaseReturnList);
	}
	  
	@Test
	public void findPersonMemberReturnCount(){
		FindPersonMemberBase findPersonMemberBase=new FindPersonMemberBase();
		findPersonMemberBase.setMerchantNo("0");
		List<FindPersonMemberBaseList> findPersonMemberBaseReturnList=personMemberBaseService.findPersonMemberBaseMemberCount(findPersonMemberBase);
		System.out.println(findPersonMemberBaseReturnList.toString());
	}
	@Test
    public void findPersonMemberNumAdd() throws ParseException{
		FindPersonMemberBaseList findPersonMemberBaseList=new FindPersonMemberBaseList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s = sdf.format(new Date());
		findPersonMemberBaseList.setCreateDate(s);
		findPersonMemberBaseList.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		int count=personMemberBaseService.findPersonMemberBaseNumAdd(findPersonMemberBaseList);
		System.out.println(count);
		
    }

}
