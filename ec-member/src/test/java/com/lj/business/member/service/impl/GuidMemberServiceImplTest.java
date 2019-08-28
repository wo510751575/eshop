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
import com.lj.business.member.dao.IGuidMemberDao;
import com.lj.business.member.domain.GuidMember;
import com.lj.business.member.dto.AddGuidMember;
import com.lj.business.member.dto.AddGuidMemberDto;
import com.lj.business.member.dto.DelGuidMember;
import com.lj.business.member.dto.FindGuidMember;
import com.lj.business.member.dto.FindGuidMemberDto;
import com.lj.business.member.dto.FindGuidMemberPage;
import com.lj.business.member.dto.FindGuidMemberPageReturn;
import com.lj.business.member.dto.FindGuidMemberReturn;
import com.lj.business.member.dto.GuidInfoShop;
import com.lj.business.member.dto.GuidMemberReturnDto;
import com.lj.business.member.dto.UpdateGuidMember;
import com.lj.business.member.service.IGuidMemberService;
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
public class GuidMemberServiceImplTest extends SpringTestCase{

	@Resource
	IGuidMemberService guidMemberService;
	@Resource
	IGuidMemberDao guidMemberDao;


	/**
	 * 
	 *
	 * 方法说明：添加导购信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addGuidMember() throws TsfaServiceException{
		AddGuidMember addGuidMember = new AddGuidMember();
		//add数据录入
		addGuidMember.setMemberNo("G0001");
		addGuidMember.setMemberName("段志鹏");
		addGuidMember.setShopNo("S0001");
		addGuidMember.setShopName("分店1");
		addGuidMember.setMerchantNo("086c40e17ed44e89a0482366841c63f2");
		addGuidMember.setMerchantName("安家");
		addGuidMember.setStatus("NORMAL");
		addGuidMember.setJobNum("J0001");
		addGuidMember.setMobile("18670275128");
		addGuidMember.setEmail("Email");
		addGuidMember.setAreaCode("d");
		addGuidMember.setAreaName("d");
		addGuidMember.setNickName("NickName");
		addGuidMember.setAddress("Address");
		addGuidMember.setAge(26);
		addGuidMember.setGender("Gender");
		addGuidMember.setPwd(MD5.encryptByMD5("668905"));
		addGuidMember.setEncryptionCode("3");
		addGuidMember.setHeadAddress("HeadAddress");
		addGuidMember.setCreateId("CreateId");
		
		Assert.assertNotNull(guidMemberService.addGuidMember(addGuidMember ));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改导购信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateGuidMember() throws TsfaServiceException{
		UpdateGuidMember updateGuidMember = new UpdateGuidMember();
		//update数据录入
		updateGuidMember.setCode(GUID.getPreUUID());
		updateGuidMember.setMemberNo("MemberNo");
		updateGuidMember.setMemberName("MemberName");
		updateGuidMember.setShopNo("ShopNo");
		updateGuidMember.setShopName("ShopName");
		updateGuidMember.setMerchantNo("MerchantNo");
		updateGuidMember.setMerchantName("MerchantName");
		updateGuidMember.setStatus("Status");
		updateGuidMember.setJobNum("JobNum");
		updateGuidMember.setMobile("Mobile");
		updateGuidMember.setEmail("Email");
		updateGuidMember.setNickName("NickName");
		updateGuidMember.setAddress("Address");
		updateGuidMember.setAge(1);
		updateGuidMember.setGender("Gender");
		updateGuidMember.setPwd("Pwd");
		updateGuidMember.setEncryptionCode("EncryptionCode");
		updateGuidMember.setHeadAddress("HeadAddress");
		updateGuidMember.setCreateId("CreateId");
		updateGuidMember.setCreateDate(new Date());
		updateGuidMember.setUpdateId("UpdateId");
		updateGuidMember.setUpdateDate(new Date());

		guidMemberService.updateGuidMember(updateGuidMember );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找导购信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findGuidMember() throws TsfaServiceException{
		GuidMember recordGuidMember = new GuidMember();
		recordGuidMember.setMobile("18665435143");
		recordGuidMember.setMerchantNo(TestHelp.merchantNo_test);
		GuidMember guidMember = guidMemberDao.findGuidMember(recordGuidMember);
		System.out.println(guidMember.toString());
	}
	
	@Test
	public void findGuidMemberss() throws TsfaServiceException{
		UpdateGuidMember updateGuidMember = new UpdateGuidMember();
		updateGuidMember.setCode("LJ_0e6ed6cebc00424198e7b292d3af2487");
		GuidMemberReturnDto guidMemberReturnDto=guidMemberService.findGuidMemberByCode(updateGuidMember);
		System.out.println(guidMemberReturnDto);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找导购信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findGuidMemberPage() throws TsfaServiceException{
		FindGuidMemberPage findGuidMemberPage = new FindGuidMemberPage();
		findGuidMemberPage.setShopName("南山分店");
		Page<FindGuidMemberPageReturn> page = guidMemberService.findGuidMemberPage(findGuidMemberPage);
		System.out.println(page.getRows());
		Assert.assertNotNull(page);
		
	}
	
	@Test
	public void findGuidMemberExport() throws TsfaServiceException{
		FindGuidMemberPage findGuidMemberPage = new FindGuidMemberPage();
		findGuidMemberPage.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		List<FindGuidMemberPageReturn> list = guidMemberService.findGuidMemberExport(findGuidMemberPage);
		System.out.println(list.size());
		Assert.assertNotNull(list);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除导购信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delGuidMember() throws TsfaServiceException{
		DelGuidMember delGuidMember = new DelGuidMember();
		delGuidMember.setCode(GUID.getPreUUID());
		Assert.assertNotNull(guidMemberService.delGuidMember(delGuidMember));
		
	}
	
	@Test
	public void findGuidMembers() throws TsfaServiceException{
		FindGuidMemberPage findGuidMemberPage = new FindGuidMemberPage();
		findGuidMemberPage.setMerchantNo("LJ_1ee46680f96c4b3fbb8680ca7199579a");
		findGuidMemberPage.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
//		findGuidMemberPage.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
//		findGuidMemberPage.setStatus(MemberStatus.NORMAL.toString());
//		findGuidMemberPage.setStartTime(new Date());
//		findGuidMemberPage.setEndTime(new Date());
		findGuidMemberPage.setNoWx("laoerjiu123");
		findGuidMemberPage.setImei("0");
		List<FindGuidMemberPageReturn> page = guidMemberService.findGuidMembers(findGuidMemberPage);
		System.out.println(page.toString());
	}
	
	@Test
	public void findGuidMemberByCond() throws TsfaServiceException{
		FindGuidMember findGuidMemberPage = new FindGuidMember();
		FindGuidMemberReturn page = guidMemberService.findGuidMember(findGuidMemberPage);
		System.out.println(page.toString());
		Assert.assertNotNull(page);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找导购信息(个人中心).
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年8月11日
	 *
	 */
	@Test
	public void findGuid() throws TsfaServiceException{
		FindGuidMemberDto findGuidMemberDto = new FindGuidMemberDto();
		findGuidMemberDto.setMemberNo(TestHelp.memberNoGm_test);
		guidMemberService.findGuid(findGuidMemberDto);
	}
	
	/**
	 * 
	 *
	 * 方法说明：添加导购信息(个人中心)
	 *
	 *
	 * @author 邹磊 CreateDate: 2017年7月13日
	 *
	 */
	@Test
	public void insertGuidMember(){
		AddGuidMemberDto addGuidMemberDto = new AddGuidMemberDto();
		addGuidMemberDto.setCode(GUID.getPreUUID());
		addGuidMemberDto.setMemberNo(GUID.getPreUUID());
		addGuidMemberDto.setMemberName("邹磊");
		addGuidMemberDto.setShopNo(GUID.getPreUUID());
		addGuidMemberDto.setShopName("南山分店");
		addGuidMemberDto.setMerchantNo(GUID.getPreUUID());
		addGuidMemberDto.setMerchantName("敏华集团");
		addGuidMemberDto.setMobile("110");
		addGuidMemberDto.setEmail("110@qq.com");
		addGuidMemberDto.setAreaCode(GUID.getPreUUID());
		addGuidMemberDto.setProvinceCode(GUID.getPreUUID());
		addGuidMemberDto.setCityCode(GUID.getPreUUID());
		addGuidMemberDto.setCityAreaCode(GUID.getPreUUID());
		addGuidMemberDto.setAddress("西丽");
		addGuidMemberDto.setHeadAddress("http://");
		guidMemberService.addGuidMember(addGuidMemberDto);
	}
	/**
	 * 
	 *
	 * 方法说明：查找导购信息
	 *
	 *
	 * @author 邹磊 CreateDate: 2017年7月13日
	 *
	 */
	@Test
	public void findGuidMemberByCodeOrMemberNo(){
		FindGuidMemberDto findGuidMemberDto = new FindGuidMemberDto();
		findGuidMemberDto.setMemberNo("LJ_de4938eacb2e49b78d2d0c883da35862");
		guidMemberService.findGuid(findGuidMemberDto);;
	}
	
	@Test
	public void findGuidMemberCount(){
		FindGuidMemberPage findGuidMemberPage = new FindGuidMemberPage();
		findGuidMemberPage.setMerchantNo(TestHelp.merchantNo_test);
		findGuidMemberPage.setAgeFrom(20);
		findGuidMemberPage.setAgeTo(29);
		int count =guidMemberService.findGuidMemberCount(findGuidMemberPage);
		System.out.println(count);
	}
	@Test		
	public void findGuidInfoShop(){
	  FindGuidMemberDto findGuidMemberDto=new FindGuidMemberDto();
	  findGuidMemberDto.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
	  List<GuidInfoShop>  list=guidMemberService.findGuidInfoShop(findGuidMemberDto);
	  System.out.println(list.toString());
	}
	
	@Test
	public void testName() throws Exception {
		UpdateGuidMember member = new UpdateGuidMember();
		member.setCode("LJ_8fc11e26f0ae4cc49df95b72c831f9f5");
		member.setQcord("/headImg/660502888956675062.jpg");
		guidMemberService.updateGuidMember(member);
	}
	
	@Test
	public void myInfo(){
		FindGuidMember find = new FindGuidMember();
		find.setMemberNo("LJ_8ea04cc85fdd416eae675503d80d0ae0");
		FindGuidMemberReturn mbrRt = guidMemberService.findGuidMember(find);
		mbrRt.setPwd(null);//密码不返回到前端
		System.out.println("会员信息："+mbrRt);
	}
}
