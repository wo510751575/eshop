package com.lj.eshop.service.impl;

import java.util.Date;
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
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.eshop.dto.FindMemberPage;
import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.emus.MemberGrade;
import com.lj.eshop.emus.MemberSex;
import com.lj.eshop.emus.MemberSourceFrom;
import com.lj.eshop.emus.MemberStatus;
import com.lj.eshop.emus.MemberType;
import com.lj.eshop.service.IMemberService;

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
 *         CreateDate: 2017-08-22
 */
public class MemberServiceImplTest extends SpringTestCase {

	@Resource
	IMemberService memberService;

	/**
	 * 
	 *
	 * 方法说明：添加会员信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addMember() throws TsfaServiceException {
		MemberDto memberDto = new MemberDto();
		// add数据录入
		// memberDto.setCode(UUID);
		memberDto.setName("Name");
		memberDto.setPhone("15361668962");
		memberDto.setWxNo("WxNo");
		memberDto.setStatus(MemberStatus.NORMAL.getValue());
		memberDto.setType(MemberType.SHOP.getValue());
		memberDto.setAvotor("Avotor");
		memberDto.setProvince("Province");
		memberDto.setCity("City");
		memberDto.setArea("Area");
		memberDto.setMyInvite("MyInvite");
		memberDto.setGrade(MemberGrade.ONE.getValue());
		memberDto.setCreateTime(new Date());
		memberDto.setCreater("Creater");
		memberDto.setOpenId("OpenId");
		memberDto.setSex(MemberSex.MALE.getValue());
		memberDto.setSourceFrom(MemberSourceFrom.SCAN.getValue());
		memberDto.setMerchantCode("merchant1");
		memberService.addMember(memberDto);
	}

	/**
	 * 
	 *
	 * 方法说明：修改会员信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateMember() throws TsfaServiceException {
		MemberDto memberDto = new MemberDto();
		// update数据录入
		memberDto.setCode("LJ_d7c076c4b7234820b9c4e42d755aac39");
		memberDto.setName("Name");
		memberDto.setPhone("Phone");
		memberDto.setWxNo("WxNo");
		memberDto.setStatus(MemberStatus.NORMAL.getValue());
		memberDto.setType(MemberType.CLIENT.getValue());
		memberDto.setAvotor("Avotor");
		memberDto.setProvince("Province");
		memberDto.setCity("City");
		memberDto.setArea("Area");
		memberDto.setMyInvite("MyInvite");
		memberDto.setGrade(MemberGrade.TWO.getValue());
		memberDto.setCreateTime(new Date());
		memberDto.setCreater("Creater");
		memberDto.setOpenId("OpenId");
		memberDto.setSex(MemberSex.MALE.getValue());
		memberDto.setSourceFrom(MemberSourceFrom.SCAN.getValue());

		memberService.updateMember(memberDto);

	}

	/**
	 * 
	 *
	 * 方法说明：查找会员信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMember() throws TsfaServiceException {
		MemberDto findMember = new MemberDto();
		findMember.setCode("LJ_d7c076c4b7234820b9c4e42d755aac39");
		memberService.findMember(findMember);
	}

	/**
	 * 
	 *
	 * 方法说明：查找会员信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMemberPage() throws TsfaServiceException {
		FindMemberPage findMemberPage = new FindMemberPage();
		MemberDto param = new MemberDto();
		param.setCode("LJ_d7c076c4b7234820b9c4e42d755aac39");
		findMemberPage.setParam(param);
		Page<MemberDto> page = memberService.findMemberPage(findMemberPage);
		Assert.assertNotNull(page);

	}

	/**
	 * 
	 *
	 * 方法说明：查找会员信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMembers() throws TsfaServiceException {

		FindMemberPage findMemberPage = new FindMemberPage();
		MemberDto findM = new MemberDto();
		findM.setPhone("13888888101");
		findMemberPage.setParam(findM);
		List<MemberDto> page = memberService.findMembers(findMemberPage);
		// 如果code不一致，电话已被其它人使用
		if (!StringUtils.equal(page.get(0).getCode(), "LJ_9b8190c131e045ecbe9a8a5fbb595425")) {
			System.out.println(111);
		}
		Assert.assertNotNull(page);

	}

	@Test
	public void findMemberCodesByInvite() throws TsfaServiceException {

		List<String> list = memberService.findMemberCodesByInvite("YE_c0fddb358e8f4ef08792ee7c2675ec54");
		Assert.assertNotNull(list);
		System.out.println(list);
	}
}
