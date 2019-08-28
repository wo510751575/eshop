package com.lj.business.cm.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cm.domain.Bom;
import com.lj.business.cm.dto.EditBomDto;
import com.lj.business.cm.dto.FindBomPageDto;
import com.lj.business.cm.service.IBomService;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
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
 * @Company: 深圳扬恩科技有限公司
 * @author 邹磊
 * 
 *         CreateDate: 2017年6月28日
 */
public class BomServiceImplTest extends SpringTestCase {

	@Resource
	private IBomService bomService;

	@Test
	public void addBom() {
		EditBomDto bom = new EditBomDto();
		bom.setCode(GUID.generateByUUID());
		bom.setBomCode(GUID.generateByUUID());
		bom.setBomName("真皮沙发");
		bom.setCreateId("邹磊");
		bom.setCreateDate(new Date());
		bom.setRemark("很好!");
		bom.setRemark2("很好!");
		bom.setRemark3("很好!");
		bom.setRemark4("很好!");
		Assert.assertNotNull(bomService.addBom(bom));
		
	}

	/**
	 * 
	 *
	 * 方法说明：编辑产品
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月28日
	 *
	 */
	@Test
	public void editBom() {
		EditBomDto bom = new EditBomDto();
		bom.setCode(GUID.generateByUUID());
		bom.setBomCode(GUID.generateByUUID());
		bom.setBomName("真皮沙发");
		bom.setCreateId("彭阳");
		bom.setCreateDate(new Date());
		bom.setRemark("很好!");
		bom.setRemark2("很好!");
		bom.setRemark3("很好!");
		bom.setRemark4("很好!");
		Assert.assertNotNull(bomService.editBom(bom));
	}
	
	/**
	 * 
	 *
	 * 方法说明：通过主键查询产品
	 *
	 *
	 * @author 邹磊 CreateDate: 2017年6月30日
	 *
	 */
	@Test
	public void selectBom() {
		EditBomDto editBomDto = bomService.selectByCode("1877a3fdcd6d44bcada3c4ba62e25d1a");
		System.out.println(editBomDto.toString());
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找产品(不分页)
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月28日
	 *
	 */
	@Test
	public void findBoms() {
		FindBomPageDto findBomPageDto = new FindBomPageDto();
		findBomPageDto.setBomName("羊皮沙发");
		List<FindBomPageDto> list = bomService.findBoms(findBomPageDto);
		System.out.println(list.toString());
		
	}
	
	
	/**
	 * 
	 *
	 * 方法说明：查找产品(分页)
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月28日
	 *
	 */
	@Test
	public void findBomPage() {
		FindBomPageDto findBomPageDto = new FindBomPageDto();
		findBomPageDto.setBomName("牛皮沙发");
		Page<FindBomPageDto> page = bomService.findBomPage(findBomPageDto);
		System.out.println(page.getTotal());
		Assert.assertNotNull(page);
	}





}
