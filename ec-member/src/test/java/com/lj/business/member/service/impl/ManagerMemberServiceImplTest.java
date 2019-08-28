package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
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
import com.lj.business.member.common.MemberConstants;
import com.lj.business.member.dao.IManagerMemberDao;
import com.lj.business.member.dto.AddManagerMember;
import com.lj.business.member.dto.AddManagerMemberDto;
import com.lj.business.member.dto.DelManagerMember;
import com.lj.business.member.dto.FindManagerMember;
import com.lj.business.member.dto.FindManagerMemberPage;
import com.lj.business.member.dto.FindManagerMemberPageReturn;
import com.lj.business.member.dto.FindManagerMemberReturn;
import com.lj.business.member.dto.FindManagersDto;
import com.lj.business.member.dto.FindManagersReturnDto;
import com.lj.business.member.dto.ManagerMemberDto;
import com.lj.business.member.dto.UpdateManagerMember;
import com.lj.business.member.dto.UpdateManagerMemberDto;
import com.lj.business.member.dto.UpdateManagerOrGuidPwdDto;
import com.lj.business.member.dto.UpdatePwdDto;
import com.lj.business.member.emus.MemberType;
import com.lj.business.member.service.IManagerMemberService;
import com.lj.business.member.util.TestHelp;


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
public class ManagerMemberServiceImplTest extends SpringTestCase{

	@Resource
	IManagerMemberService managerMemberService;

	@Resource
	private IManagerMemberDao managerMemberDao;
	
	/**
	 * 
	 *
	 * 方法说明：添加商户表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addManagerMember() throws TsfaServiceException{
		AddManagerMember addManagerMember = new AddManagerMember();
		//add数据录入
		addManagerMember.setCode(GUID.getPreUUID());
		addManagerMember.setMemberType(MemberType.SHOP);
		addManagerMember.setMemberNo("M0001");
		addManagerMember.setMemberName("段志鹏");
		addManagerMember.setMemberNoShop("S0001");
		addManagerMember.setMemberNameShop("分店1");
		addManagerMember.setMemberNoMerchant("086c40e17ed44e89a0482366841c63f2");
		addManagerMember.setMemberNameMerchant("安家");
		addManagerMember.setStatus("NORMAL");
		addManagerMember.setJobNum("J001");
		addManagerMember.setTelephone("Telephone");
		addManagerMember.setMobile("18670275128");
		addManagerMember.setEmail("18670275128@139.com");
		addManagerMember.setNickName("小段");
		addManagerMember.setAddress("西丽");
		addManagerMember.setAge(26);
		addManagerMember.setPwd(MD5.encryptByMD5("123456"));
		addManagerMember.setEncryptionCode("3");
		addManagerMember.setHeadAddress("http://");
		addManagerMember.setOpenIdGzhWx("OpenIdGzhWx");
		addManagerMember.setOpenIdXcxWx("OpenIdXcxWx");
		addManagerMember.setNickNameWx("NickNameWx");
		addManagerMember.setAreaCode("d");
		addManagerMember.setSex("男");
		addManagerMember.setCityWx("深圳");
		addManagerMember.setCountryWx("中国");
		addManagerMember.setProvinceWx("广东");
		addManagerMember.setSubsribeTime(new Date());
		addManagerMember.setCreateId("导购");
		addManagerMember.setCreateDate(new Date());
		addManagerMember.setUpdateId("店长");
		addManagerMember.setUpdateDate(new Date());
		
		Assert.assertNotNull(managerMemberService.addManagerMember(addManagerMember ));
		
	}
	/**
	 * 
	 *
	 * 方法说明：修改商户表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateManagerMember() throws TsfaServiceException{
		UpdateManagerMember updateManagerMember = new UpdateManagerMember();
		//update数据录入
		updateManagerMember.setCode(GUID.getPreUUID());
		updateManagerMember.setMemberType(MemberType.SHOP);
		updateManagerMember.setMemberNo("MemberNo");
		updateManagerMember.setMemberName("MemberName");
		updateManagerMember.setMemberNoShop("MemberNoShop");
		updateManagerMember.setMemberNameShop("MemberNameShop");
		updateManagerMember.setMemberNoMerchant("MemberNoMerchant");
		updateManagerMember.setMemberNameMerchant("MemberNameMerchant");
		updateManagerMember.setStatus("Status");
		updateManagerMember.setJobNum("JobNum");
		updateManagerMember.setTelephone("Telephone");
		updateManagerMember.setMobile("Mobile");
		updateManagerMember.setEmail("Email");
		updateManagerMember.setNickName("NickName");
		updateManagerMember.setAddress("Address");
		updateManagerMember.setAge(1);
		updateManagerMember.setPwd("Pwd");
		updateManagerMember.setEncryptionCode("EncryptionCode");
		updateManagerMember.setHeadAddress("HeadAddress");
		updateManagerMember.setOpenIdGzhWx("OpenIdGzhWx");
		updateManagerMember.setOpenIdXcxWx("OpenIdXcxWx");
		updateManagerMember.setNickNameWx("NickNameWx");
		updateManagerMember.setSex("Sex");
		updateManagerMember.setCityWx("CityWx");
		updateManagerMember.setCountryWx("CountryWx");
		updateManagerMember.setProvinceWx("ProvinceWx");
		updateManagerMember.setSubsribeTime(new Date());
		updateManagerMember.setCreateId("CreateId");
		updateManagerMember.setCreateDate(new Date());
		updateManagerMember.setUpdateId("UpdateId");
		updateManagerMember.setUpdateDate(new Date());

		managerMemberService.updateManagerMember(updateManagerMember );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商户表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findManagerMember() throws TsfaServiceException{
		//获取管理人员信息
		FindManagerMember findManagerMember = new FindManagerMember();
//		record.setMobile("18665435143");
//		record.setMemberNoMerchant(TestHelp.merchantNo_test);
		findManagerMember.setCode("LJ_b39ad84680ed426b97209351a88e62c5");
		FindManagerMemberReturn managerMember = managerMemberService.findManagerMember(findManagerMember);
		System.out.println(managerMember.toString());
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商户表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findManagerMemberPage() throws TsfaServiceException{
		FindManagerMemberPage findManagerMemberPage = new FindManagerMemberPage();
		findManagerMemberPage.setEndTime(new Date());
		Page<FindManagerMemberPageReturn> page = managerMemberService.findManagerMemberPage(findManagerMemberPage);
		Assert.assertNotNull(page);
		
	}
	
	@Test
	public void findManagerMemberExport() throws TsfaServiceException{
		FindManagerMemberPage findManagerMemberPage = new FindManagerMemberPage();
		findManagerMemberPage.setEndTime(new Date());
		List<FindManagerMemberPageReturn> list = managerMemberService.findManagerMemberExport(findManagerMemberPage);
		System.out.println(list.size());
		Assert.assertNotNull(list);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除商户表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delManagerMember() throws TsfaServiceException{
		DelManagerMember delManagerMember = new DelManagerMember();
		delManagerMember.setCode(GUID.getPreUUID());
		Assert.assertNotNull(managerMemberService.delManagerMember(delManagerMember));
		
	}
	
	@Test
	public void findManagerMembers() throws TsfaServiceException{
		FindManagerMemberPage findManagerMemberPage = new FindManagerMemberPage();
//		findManagerMemberPage.setMobile("18670275128");
/*		findManagerMemberPage.setMemberNoMerchant("e79d975846ee41ba8c3c55738fda66a9");
		findManagerMemberPage.setMemberType(MemberType.SHOP.toString());*/
		findManagerMemberPage.setImei("0");
		List<FindManagerMemberPageReturn> page = managerMemberService.findManagerMembers(findManagerMemberPage);
		Assert.assertNotNull(page);
		System.out.println(page.toString());
	}
	
	/**
	 * 
	 *
	 * 方法说明：添加店长信息(个人中心)
	 *
	 *
	 * @author 邹磊 CreateDate: 2017年7月11日
	 *
	 */
	@Test
	public void insertManagerMember(){
		AddManagerMemberDto addManagerMemberDto = new AddManagerMemberDto();
		addManagerMemberDto.setCode(GUID.getPreUUID());
		addManagerMemberDto.setMemberNo(GUID.getPreUUID());
		addManagerMemberDto.setMemberName("邹磊");
		addManagerMemberDto.setMemberNoShop(GUID.getPreUUID());
		addManagerMemberDto.setMemberNameShop("南山分店");
		addManagerMemberDto.setMemberNoMerchant(GUID.getPreUUID());
		addManagerMemberDto.setMemberNameMerchant("敏华集团");
		addManagerMemberDto.setMobile("110");
		addManagerMemberDto.setEmail("110@qq.com");
		addManagerMemberDto.setAreaCode(GUID.getPreUUID());
		addManagerMemberDto.setProvinceCode(GUID.getPreUUID());
		addManagerMemberDto.setCityCode(GUID.getPreUUID());
		addManagerMemberDto.setCityAreaCode(GUID.getPreUUID());
		addManagerMemberDto.setAddress("西丽");
		addManagerMemberDto.setHeadAddress("http://");
		managerMemberService.addManager(addManagerMemberDto);
	}
	@Test
	public void findManagerMemberByCodeOrMemberNo(){
		ManagerMemberDto managerMemberDto = new ManagerMemberDto();
		managerMemberDto.setMemberNo("d7b963349b8f4bcbbed9a36fe41ae626");
		managerMemberService.findManager(managerMemberDto);
	}
	@Test
	public void updateByCodeOrMemberNo(){
		UpdateManagerMemberDto updateManagerMemberDto = new UpdateManagerMemberDto();
		updateManagerMemberDto.setMemberType("SHOP");
		updateManagerMemberDto.setMemberNo(GUID.getPreUUID());
		updateManagerMemberDto.setMemberName("罗书明");
		updateManagerMemberDto.setEmail("110@qq.com");
		updateManagerMemberDto.setAreaCode(GUID.getPreUUID());
		updateManagerMemberDto.setProvinceCode(GUID.getPreUUID());
		updateManagerMemberDto.setCityCode(GUID.getPreUUID());
		updateManagerMemberDto.setCityAreaCode(GUID.getPreUUID());
		updateManagerMemberDto.setAddress("西丽");
		managerMemberService.updateManager(updateManagerMemberDto);
	}
	/**
	 * 
	 *
	 * 方法说明：通过分店编号查询店长/导购信息列表
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 邹磊 CreateDate: 2017年7月13日
	 *
	 */
	@Test
	public void findManagers() throws TsfaServiceException{
		FindManagersDto findManagersDto = new FindManagersDto();
		findManagersDto.setMemberNoShop("LJ_c269478af52646b692fcc48deb10a7ad");
		findManagersDto.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		List<FindManagersReturnDto> findManagers = managerMemberService.findManagers(findManagersDto);
		Assert.assertNotNull(findManagers);
		System.out.println(findManagers.toString());
	}
	@Test
	public void updateManagerForPwd() throws TsfaServiceException{
		UpdateManagerOrGuidPwdDto updateManagerOrGuidPwdDto = new UpdateManagerOrGuidPwdDto();
		updateManagerOrGuidPwdDto.setMobile("18665435142");
		updateManagerOrGuidPwdDto.setMemberType("BOSS");
		updateManagerOrGuidPwdDto.setPwd("211571f3e14099fd9a6c172426982ca5");
		managerMemberService.updateManagerForPwd(updateManagerOrGuidPwdDto);
	}
	
	@Test
	public void updateManagerAndGuidForPwd() throws TsfaServiceException{
		UpdateManagerOrGuidPwdDto updateManagerOrGuidPwdDto = new UpdateManagerOrGuidPwdDto();
		updateManagerOrGuidPwdDto.setPwd("1");
		managerMemberService.updateManagerForPwd(updateManagerOrGuidPwdDto);
	}
	
	@Test
	public void findManagerMemberCount() throws TsfaServiceException{
		FindManagerMemberPage findManagerMemberPage= new FindManagerMemberPage();
		findManagerMemberPage.setMemberNoShop("LJ_82039188265241e0bd8f87651db6ab3c");
		List<FindManagerMemberPageReturn> count =managerMemberService.findMemberNoShop(findManagerMemberPage);
		System.out.println(count.toString());
	}
	
	@Test
	public void updatePwd() throws TsfaServiceException{
		UpdatePwdDto updatePwdDto = new UpdatePwdDto();
		updatePwdDto.setCode("LJ_c0a381d2e833445ba27421bd8093fa82");
		updatePwdDto.setPwd(MD5.encryptByMD5("898746"));
		managerMemberService.updatePwd(updatePwdDto);
	}
	
}
