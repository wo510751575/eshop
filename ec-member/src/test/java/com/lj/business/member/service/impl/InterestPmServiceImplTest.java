package com.lj.business.member.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.member.domain.InterestPm;
import com.lj.business.member.dto.AddInterestPmDto;
import com.lj.business.member.dto.EditInterestPmDto;
import com.lj.business.member.dto.FindInterestPmPageDto;
import com.lj.business.member.dto.InterestPmReturnDto;
import com.lj.business.member.service.IInterestPmService;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */

/**
 * 
 * 
 * 类说明：
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 领居科技有限公司
 * @author 邹磊
 * 
 *         CreateDate: 2017年7月1日
 */
public class InterestPmServiceImplTest extends SpringTestCase {

	@Resource
	private IInterestPmService interestPmService;

	@Test
	public void addInterestPm() {
		AddInterestPmDto interestPm = new AddInterestPmDto();
		interestPm.setCode(GUID.getPreUUID());
		interestPm.setMerchantNo(GUID.getPreUUID());
		interestPm.setName("运动达人");
		interestPm.setRemark("很爱运动!");
		interestPm.setCreateDate(new Date());
		interestPmService.addInterestPm(interestPm);
		
	}

	/**
	 * 
	 *
	 * 方法说明：编辑商户服务协议
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月28日
	 *
	 */
	@Test
	public void editinterestPm() {
		EditInterestPmDto interestPm = new EditInterestPmDto();
		interestPm.setCode(GUID.getPreUUID());
		interestPm.setMerchantNo(GUID.getPreUUID());
		interestPm.setName("运动达人");
		interestPm.setRemark("很爱运动!");
		interestPm.setCreateDate(new Date());
		interestPmService.editInterestPm(interestPm);
	}
	
	/**
	 * 
	 *
	 * 方法说明：通过主键查询商户服务协议
	 *
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	@Test
	public void selectByCode() {
		InterestPmReturnDto interestPmReturnDto = interestPmService.selectByCode("LJ_55a27fcfc96c496f88c16f72fb274581");
		System.out.println(interestPmReturnDto.toString());
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商户服务协议(不分页)
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	@Test
	public void findinterestPms() {
		FindInterestPmPageDto findInterestPmPageDto = new FindInterestPmPageDto();
		findInterestPmPageDto.setMerchantNo("b7a3c6f50d7d4116b5329ebcf46d0bed");
		List<FindInterestPmPageDto> list = interestPmService.findInterestPms(findInterestPmPageDto);
		System.out.println(list.toString());
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商户服务协议(分页)
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	@Test
	public void findinterestPmPage() {
		FindInterestPmPageDto findInterestPmPageDto = new FindInterestPmPageDto();
		findInterestPmPageDto.setMerchantNo("b7a3c6f50d7d4116b5329ebcf46d0bed");
		Page<FindInterestPmPageDto> page = interestPmService.findInterestPmPage(findInterestPmPageDto);
		System.out.println(page.getTotal());
		Assert.assertNotNull(page);
	}
}
