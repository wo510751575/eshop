package com.lj.business.member.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.member.dto.AddAgreementMerchantDto;
import com.lj.business.member.dto.AgreementMerchantReturnDto;
import com.lj.business.member.dto.EditAgreementMerchantDto;
import com.lj.business.member.dto.FindAgreementMerchant;
import com.lj.business.member.dto.FindAgreementMerchantPageDto;
import com.lj.business.member.dto.FindMerchant;
import com.lj.business.member.emus.AgreementType;
import com.lj.business.member.service.IAgreementMerchantService;

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
public class AgreementMerchantServiceImplTest extends SpringTestCase {

	@Resource
	private IAgreementMerchantService agreementMerchantService;
	/**
	 * 
	 *
	 * 方法说明：添加商户服务协议
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月28日
	 *
	 */
	@Test
	public void addAgreementMerchant() {
		AddAgreementMerchantDto agreementMerchant = new AddAgreementMerchantDto();
		agreementMerchant.setCode(GUID.getPreUUID());
		agreementMerchant.setMerchantNo(GUID.generateByUUID());
		agreementMerchant.setAgreement("领居科技有限公司服务合同");
		agreementMerchant.setAgreementType(AgreementType.APP_SERVICE.toString());
		agreementMerchant.setCreateId("领居科技有限公司");
		agreementMerchant.setCreateDate(new Date());
		agreementMerchant.setUpdateId("领居科技有限公司");
		agreementMerchant.setUpdateDate(new Date());
		agreementMerchantService.addAgreementMerchant(agreementMerchant);
		
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
	public void editAgreementMerchant() {
		EditAgreementMerchantDto agreementMerchant = new EditAgreementMerchantDto();
		agreementMerchant.setCode(GUID.getPreUUID());
		agreementMerchant.setMerchantNo(GUID.getPreUUID());
		agreementMerchant.setAgreement("深圳领居科技有限公司服务合同 ");
		agreementMerchant.setCreateId("深圳领居科技有限公司");
		agreementMerchant.setCreateDate(new Date());
		agreementMerchant.setUpdateId("深圳领居科技有限公司");
		agreementMerchant.setUpdateDate(new Date());
		agreementMerchantService.editAgreementMerchant(agreementMerchant);
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
		AgreementMerchantReturnDto agreementMerchantReturnDto = agreementMerchantService.selectByCode("LJ_d0b7a1953b71404da485894552d034fa");
		System.out.println(agreementMerchantReturnDto.toString());
	
	}
	/**
	 * 
	 *
	 * 方法说明：查询商户服务协议(个人中心)
	 *
	 *
	 * @author 邹磊 CreateDate: 2017年7月7日
	 *
	 */
	@Test
	public void findAgreementMerchant(){
		FindAgreementMerchant findAgreementMerchant = new FindAgreementMerchant();
		findAgreementMerchant.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		agreementMerchantService.findAgreementMerchant(findAgreementMerchant);
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
	public void findAgreementMerchants() {
		FindAgreementMerchantPageDto findAgreementMerchantPageDto = new FindAgreementMerchantPageDto();
		findAgreementMerchantPageDto.setMerchantNo("50994934436442caaf2bfb945c1b9f17");
		List<FindAgreementMerchantPageDto> list = agreementMerchantService.findAgreementMerchants(findAgreementMerchantPageDto);
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
	public void findAgreementMerchantPage() {
		FindAgreementMerchantPageDto findAgreementMerchantPageDto = new FindAgreementMerchantPageDto();
		findAgreementMerchantPageDto.setMerchantNo("50994934436442caaf2bfb945c1b9f17");
		Page<FindAgreementMerchantPageDto> page = agreementMerchantService.findAgreementMerchantPage(findAgreementMerchantPageDto);
		System.out.println(page.getTotal());
		Assert.assertNotNull(page);
	}
}
