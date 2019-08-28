/*package com.lj.eshop.service.impl;

*//**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 *//*
import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.lj.eshop.dto.MemberRankApplyDto;
import com.lj.eshop.dto.PaymentDto;
import com.lj.eshop.emus.MemberRankApplyStatus;
import com.lj.eshop.dto.FindMemberRankApplyPage;
import com.lj.eshop.service.IMemberRankApplyService;

*//**
 * 类说明：测试类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 林进权
 * 
 * 
 * CreateDate: 2017-08-31
 *//*
public class MemberRankApplyServiceImplTest extends SpringTestCase{

	@Resource
	IMemberRankApplyService memberRankApplyService;



	*//**
	 * 
	 *
	 * 方法说明：添加特权申请信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-08-31
	 *
	 *//*
	@Test
	public void addMemberRankApply() throws TsfaServiceException{
		MemberRankApplyDto memberRankApplyDto = new MemberRankApplyDto();
		//add数据录入
		memberRankApplyDto.setCode("Code");
		memberRankApplyDto.setShopCode("ShopCode");
		memberRankApplyDto.setMemberRankCode("MemberRankCode");
		memberRankApplyDto.setApplyTime(new Date());
		memberRankApplyDto.setApproveTime(new Date());
		memberRankApplyDto.setStatus(MemberRankApplyStatus.FAIL.getValue());
		memberRankApplyDto.setShopName("商店名称");
		memberRankApplyDto.setMemberRankName("特权名称");
		
		memberRankApplyService.addMemberRankApply(memberRankApplyDto);
		
	}
	
	*//**
	 * 
	 *
	 * 方法说明：修改特权申请信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-08-31
	 *
	 *//*
	@Test
	public void updateMemberRankApply() throws TsfaServiceException{
		MemberRankApplyDto memberRankApplyDto = new MemberRankApplyDto();
		//update数据录入
		memberRankApplyDto.setCode("Code");
		memberRankApplyDto.setShopCode("ShopCode2");
		memberRankApplyDto.setMemberRankCode("MemberRankCode2");
		memberRankApplyDto.setApplyTime(new Date());
		memberRankApplyDto.setApproveTime(new Date());
		memberRankApplyDto.setStatus(MemberRankApplyStatus.SUCCESS.getValue());
		memberRankApplyDto.setDelFlag("1");
		memberRankApplyDto.setShopName("商店名称2");
		memberRankApplyDto.setMemberRankName("特权名称2");

		memberRankApplyService.updateMemberRankApply(memberRankApplyDto);
		
	}
	
	*//**
	 * 
	 *
	 * 方法说明：查找特权申请信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-08-31
	 *
	 *//*
	@Test
	public void findMemberRankApply() throws TsfaServiceException{
		MemberRankApplyDto findMemberRankApply = new MemberRankApplyDto();
		findMemberRankApply.setCode("code");
		MemberRankApplyDto rDto = memberRankApplyService.findMemberRankApply(findMemberRankApply);
		System.out.println(rDto);
	}
	
	*//**
	 * 
	 *
	 * 方法说明：查找特权申请信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-08-31
	 *
	 *//*
	@Test
	public void findMemberRankApplyPage() throws TsfaServiceException{
		FindMemberRankApplyPage findMemberRankApplyPage = new FindMemberRankApplyPage();
		Page<MemberRankApplyDto> page = memberRankApplyService.findMemberRankApplyPage(findMemberRankApplyPage);
		Assert.assertNotNull(page);
		System.out.println(page);
	}
	
	*//**
	 * 
	 *
	 * 方法说明：查找特权申请信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-08-31
	 *
	 *//*
	@Test
	public void findMemberRankApplys() throws TsfaServiceException{
		FindMemberRankApplyPage findMemberRankApplyPage = new FindMemberRankApplyPage();
		MemberRankApplyDto dto = new MemberRankApplyDto();
//		dto.setStatus("1");
		dto.setShopCode("ShopCode");
		findMemberRankApplyPage.setParam(dto);
		findMemberRankApplyPage.setApproveTimeDesc("0");
		findMemberRankApplyPage.setNeStatus(MemberRankApplyStatus.FAIL.getValue());
		List<MemberRankApplyDto> page = memberRankApplyService.findMemberRankApplys(findMemberRankApplyPage);
		Assert.assertNotNull(page);
		System.out.println(page);
	}
	
	*//**
	 * 
	 *
	 * 方法说明：审核状态变更，更新商店特权code,商店特权到期时间
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-08-31
	 *
	 *//*
	@Test
	public void updateByPkAndStatus() throws TsfaServiceException{
		MemberRankApplyDto dto = new MemberRankApplyDto();
//		dto.setStatus(MemberRankApplyStatus.FAIL.getValue());
		dto.setStatus(MemberRankApplyStatus.SUCCESS.getValue());
		dto.setCode("LJ_c4fa362ff17046a6aae190628bf835f5");
		memberRankApplyService.updateByPkAndStatus(dto);
	}
	
	*//**
	 * 申请特权
	 * 方法说明：
	 *
	 * @param @throws TsfaServiceException    设定文件 
	 * @return void    返回类型 
	 * @throws Exception
	 *
	 * @author 林进权
	 *         CreateDate: 2017年9月5日
	 *//*
	@Test
	public void apply() throws TsfaServiceException{
		MemberRankApplyDto dto = new MemberRankApplyDto();
		dto.setShopCode("shopCode");
		dto.setShopName("shopName");
		dto.setMemberRankCode("memberRankCode");
		dto.setMemberRankName("memberRankName");
		dto.setApplyTime(new Date());
		dto.setStatus(MemberRankApplyStatus.WAIT.getValue());
		dto.setDelFlag("0");
		memberRankApplyService.addMemberRankApply(dto);
	}
	
	@Test
	public void payment() {
		PaymentDto paymentDto = new PaymentDto();
		paymentDto.setAmount(new BigDecimal(100000));
		paymentDto.setBizNo("Code"); //已有的memberRankApply号
		paymentDto.setMbrCode("LJ_1eb863856573406c956c0478abf47a72");
		memberRankApplyService.payment(paymentDto);
		
		
	}
	
	@Test
	public void queryAmt() {
		
		//特权号code
		memberRankApplyService.queryAmt("LJ_0867b4b1e6a34f28b926fc50c3526864");
		
		
	}
	
	
}
*/