package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.workTaskChoose.AddWorkTaskChooseDto;
import com.lj.business.cf.dto.workTaskChoose.EditWorkTaskChooseDto;
import com.lj.business.cf.dto.workTaskChoose.FindWorkTaskChoosePageDto;
import com.lj.business.cf.dto.workTaskChoose.WorkTaskChooseReturnDto;
import com.lj.business.cf.service.IWorkTaskChooseService;


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
public class WorkTaskChooseServiceImplTest extends SpringTestCase{
	@Resource
	private IWorkTaskChooseService workTaskChooseService;

	@Test
	public void addWorkTaskChoose() {
		AddWorkTaskChooseDto workTaskChoose = new AddWorkTaskChooseDto();
		workTaskChoose.setMerchantNo(GUID.getPreUUID());
		workTaskChoose.setShopNo(GUID.getPreUUID());
		workTaskChoose.setShopName("龙华分店");
		workTaskChoose.setMemberNoGm(GUID.getPreUUID());
		workTaskChoose.setMemberNameGm("邹磊");
		workTaskChoose.setCodeList(GUID.getPreUUID());
		workTaskChoose.setNameList("打电话");
		workTaskChoose.setStatus("Y");
		workTaskChoose.setFreValue("一天");
		workTaskChoose.setSeq(1);
		workTaskChoose.setRemark("很好");
		workTaskChoose.setRemark2("很好");
		workTaskChoose.setRemark3("很好");
		workTaskChoose.setRemark4("很好");
		//workTaskChooseService.addWorkTaskChoose(workTaskChoose);
		workTaskChooseService.addWorkTaskChoose(workTaskChoose);
		
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
	public void editWorkTaskChoose() {
		EditWorkTaskChooseDto workTaskChoose = new EditWorkTaskChooseDto();
		workTaskChoose.setCode("LJ_979608ae005645ff908182e51d33fc81");
		workTaskChoose.setMerchantNo(GUID.getPreUUID());
		workTaskChoose.setShopNo(GUID.generateByUUID());
		workTaskChoose.setShopName("龙华分店");
		workTaskChoose.setMemberNoGm(GUID.generateByUUID());
		workTaskChoose.setMemberNameGm("段志鹏");
		workTaskChoose.setCodeList(GUID.generateByUUID());
		workTaskChoose.setNameList("打电话");
		workTaskChoose.setStatus("Y");
		workTaskChoose.setFreValue("一天");
		workTaskChoose.setSeq(1);
		workTaskChoose.setRemark("很好");
		workTaskChoose.setRemark2("很好");
		workTaskChoose.setRemark3("很好");
		workTaskChoose.setRemark4("很好");
		workTaskChooseService.editWorkTaskChoose(workTaskChoose);
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
		EditWorkTaskChooseDto editWorkTaskChooseDto=new  EditWorkTaskChooseDto();
		editWorkTaskChooseDto.setCode("LJ_d17f17c5f1bd4f09ace331608af6f451");
		WorkTaskChooseReturnDto workTaskChooseReturnDto = workTaskChooseService.selectByCode(editWorkTaskChooseDto);
		System.out.println(workTaskChooseReturnDto.toString());
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
	public void findWorkTaskChooses() {
		FindWorkTaskChoosePageDto findWorkTaskChoosePageDto = new FindWorkTaskChoosePageDto();
		findWorkTaskChoosePageDto.setMerchantNo("LJ_a264cf3b8a6e48d9acbc62dffa9e0bd9");
		List<FindWorkTaskChoosePageDto> list = workTaskChooseService.findWorkTaskChooses(findWorkTaskChoosePageDto);
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
	public void findWorkTaskChoosePage() {
		FindWorkTaskChoosePageDto findWorkTaskChoosePageDto = new FindWorkTaskChoosePageDto();
		findWorkTaskChoosePageDto.setMerchantNo("LJ_a264cf3b8a6e48d9acbc62dffa9e0bd9");
		Page<FindWorkTaskChoosePageDto> page = workTaskChooseService.findWorkTaskChoosePage(findWorkTaskChoosePageDto);
		System.out.println(page.getTotal());
		Assert.assertNotNull(page);
	}
	
	@Test
	public void delWorkTaskChoose() {
		String merchantNo ="086c40e17ed44e89a0482366841c63f2";
		int flag =workTaskChooseService.delWorkTaskChooseBymerchantNo(merchantNo);
		System.out.println(flag);
	}
	
}
