package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;

import com.lj.eshop.dto.MemberRankDto;
import com.lj.eshop.dto.AccWaterDto;
import com.lj.eshop.dto.FindAccWaterPage;
import com.lj.eshop.dto.FindMemberRankPage;
import com.lj.eshop.service.IAccWaterService;
import com.lj.eshop.service.IMemberRankService;
import com.lj.eshop.service.IWshopInfoService;

/**
 * 类说明：测试类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 林进权
 * 
 * 
 * CreateDate: 2017-08-22
 */
public class MemberRankServiceImplTest extends SpringTestCase{

	@Resource
	IMemberRankService memberRankService;



	/**
	 * 
	 *
	 * 方法说明：添加会员特权
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addMemberRank() throws TsfaServiceException{
		MemberRankDto memberRankDto = new MemberRankDto();
		//add数据录入
		memberRankDto.setCode("Code2");
		memberRankDto.setCreateDate(new Date());
		memberRankDto.setModifyDate(new Date());
		memberRankDto.setAmount(new BigDecimal("1000"));
		memberRankDto.setRemark("Remark");
		memberRankDto.setName("Name");
		memberRankDto.setScale(1d);
		memberRankDto.setDelFlag("0");
		memberRankDto.setSeq(1000);
		memberRankDto.setImgSrc("/img/1.png");
		memberRankService.addMemberRank(memberRankDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改会员特权
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateMemberRank() throws TsfaServiceException{
		MemberRankDto memberRankDto = new MemberRankDto();
		//update数据录入
		memberRankDto.setCode("LJ_cf657f43ba104b4a81e267576e4a0cca");
		memberRankDto.setCreateDate(new Date());
		memberRankDto.setModifyDate(new Date());
		memberRankDto.setAmount(new BigDecimal("2000"));
		memberRankDto.setRemark("Remark");
		memberRankDto.setName("Name");
		memberRankDto.setScale(1d);
		memberRankDto.setDelFlag("1");
		memberRankDto.setSeq(2000);
		memberRankDto.setImgSrc("/img/2.png");
		memberRankService.updateMemberRank(memberRankDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找会员特权
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMemberRank() throws TsfaServiceException{
		MemberRankDto findMemberRank = new MemberRankDto();
		findMemberRank.setCode("LJ_cf657f43ba104b4a81e267576e4a0cca");
		MemberRankDto rDto = memberRankService.findMemberRank(findMemberRank);
		System.out.println(rDto);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找会员特权
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMemberRankPage() throws TsfaServiceException{
		FindMemberRankPage findMemberRankPage = new FindMemberRankPage();
		Page<MemberRankDto> page = memberRankService.findMemberRankPage(findMemberRankPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找会员特权
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMemberRanks() throws TsfaServiceException{
		FindMemberRankPage findMemberRankPage = new FindMemberRankPage();
		MemberRankDto param = new MemberRankDto();
		param.setName("黄金");
		findMemberRankPage.setParam(param);
		List<MemberRankDto>  ranksList = memberRankService.findMemberRanks(findMemberRankPage);
		for (MemberRankDto memberRankDto : ranksList) {
			System.out.println(memberRankDto.getSeq());
		}
		
		
	}
	
	public static void main(String[] args) throws MalformedURLException {
//		String url = "http://localhost:8081/eshop/hessian/memberRankService";
		String url = "http://192.168.6.60:8080/eshop/hessian/memberRankService";
		HessianProxyFactory factory = new HessianProxyFactory();
		IMemberRankService memberRankService = (IMemberRankService) factory.create(IMemberRankService.class, url);
		
		FindMemberRankPage findMemberRankPage = new FindMemberRankPage();
		List<MemberRankDto> page = memberRankService.findMemberRanks(findMemberRankPage);
		System.out.println(page.size());
	}
	
}
