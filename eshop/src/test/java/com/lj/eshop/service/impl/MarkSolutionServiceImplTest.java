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

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;

import java.util.Date;
import java.util.List;

import com.lj.eshop.dto.MarkSolutionDto;
import com.lj.eshop.dto.FindMarkSolutionPage;
import com.lj.eshop.service.IMarkSolutionService;

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
 * CreateDate: 2017-08-22
 */
public class MarkSolutionServiceImplTest extends SpringTestCase{

	@Resource
	IMarkSolutionService markSolutionService;



	/**
	 * 
	 *
	 * 方法说明：添加以租代购信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addMarkSolution() throws TsfaServiceException{
		MarkSolutionDto markSolutionDto = new MarkSolutionDto();
		//add数据录入
		markSolutionDto.setCode("Code");
		markSolutionDto.setAmt("Amt");
		markSolutionDto.setMyPower("MyPower");
		markSolutionDto.setDetail("Detail");
		markSolutionDto.setStatus("Status");
		markSolutionDto.setCreateTime(new Date());
		
		markSolutionService.addMarkSolution(markSolutionDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改以租代购信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateMarkSolution() throws TsfaServiceException{
		MarkSolutionDto markSolutionDto = new MarkSolutionDto();
		//update数据录入
		markSolutionDto.setCode("Code");
		markSolutionDto.setAmt("Amt");
		markSolutionDto.setMyPower("MyPower");
		markSolutionDto.setDetail("Detail");
		markSolutionDto.setStatus("Status");
		markSolutionDto.setCreateTime(new Date());

		markSolutionService.updateMarkSolution(markSolutionDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找以租代购信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMarkSolution() throws TsfaServiceException{
		MarkSolutionDto findMarkSolution = new MarkSolutionDto();
		findMarkSolution.setCode("111");
		markSolutionService.findMarkSolution(findMarkSolution);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找以租代购信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMarkSolutionPage() throws TsfaServiceException{
		FindMarkSolutionPage findMarkSolutionPage = new FindMarkSolutionPage();
		Page<MarkSolutionDto> page = markSolutionService.findMarkSolutionPage(findMarkSolutionPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找以租代购信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMarkSolutions() throws TsfaServiceException{
		FindMarkSolutionPage findMarkSolutionPage = new FindMarkSolutionPage();
		List<MarkSolutionDto> page = markSolutionService.findMarkSolutions(findMarkSolutionPage);
		Assert.assertNotNull(page);
		
	}
	
}
