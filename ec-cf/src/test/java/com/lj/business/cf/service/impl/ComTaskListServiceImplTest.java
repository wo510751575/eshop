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
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.comTaskList.AddComTaskListDto;
import com.lj.business.cf.dto.comTaskList.ComTaskListReturnDto;
import com.lj.business.cf.dto.comTaskList.EditComTaskListDto;
import com.lj.business.cf.dto.comTaskList.FindComTaskListPageDto;
import com.lj.business.cf.emus.ComTaskType;
import com.lj.business.cf.service.IComTaskListService;


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
public class ComTaskListServiceImplTest extends SpringTestCase{
	@Resource
	private IComTaskListService comTaskListService;

	@Test
	public void addComTaskList() throws TsfaServiceException{
		ComTaskType [] comTaskTypeAr = ComTaskType.values();
		for (ComTaskType comTaskType : comTaskTypeAr) {
			if(comTaskType.equals(ComTaskType.SYSTEM))
				continue;
			AddComTaskListDto comTaskList = new AddComTaskListDto();
			comTaskList.setCode(GUID.getPreUUID());
			comTaskList.setMerchantNo("82c68f3715844c31b8243495a7edcf02");
			comTaskList.setNameList(comTaskType.getName());
			comTaskList.setDesList(comTaskType.getName());
			comTaskList.setStatus("Y");
			comTaskList.setComTaskType(comTaskType.toString());
			comTaskListService.addComTaskList(comTaskList);
		}
	}

	/**
	 * 
	 *
	 * 方法说明：编辑客户沟通任务事项表
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月28日
	 *
	 */
	@Test
	public void editComTaskList() {
		EditComTaskListDto comTaskList = new EditComTaskListDto();
		comTaskList.setCode(GUID.getPreUUID());
		comTaskList.setNameList("给客户打电话");
		comTaskList.setDesList("打电话");
		comTaskList.setStatus("y");
		comTaskListService.editComTaskList(comTaskList);
	}
	
	/**
	 * 
	 *
	 * 方法说明：通过主键查询客户沟通任务事项表
	 *
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	@Test
	public void selectByCode() {
		ComTaskListReturnDto comTaskListReturnDto = comTaskListService.selectByCode("LJ_504f8408434144c2a56c6fe9e216e5fc");
		System.out.println(comTaskListReturnDto.toString());
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找客户沟通任务事项表(不分页)
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	@Test
	public void findComTaskLists() {
		FindComTaskListPageDto findComTaskListPageDto = new FindComTaskListPageDto();
//		findComTaskListPageDto.setCode("b7a3c6f50d7d4116b5329ebcf46d0bed");
		List<FindComTaskListPageDto> list = comTaskListService.findComTaskLists(findComTaskListPageDto);
		System.out.println(list.toString());
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找客户沟通任务事项表(分页)
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	@Test
	public void findComTaskListPage() {
		FindComTaskListPageDto findComTaskListPageDto = new FindComTaskListPageDto();
		findComTaskListPageDto.setCode("LJ_67f6c571c71e405897c2a4bbb41ecedb");
		Page<FindComTaskListPageDto> page = comTaskListService.findComTaskListPage(findComTaskListPageDto);
		System.out.println(page.getTotal());
		Assert.assertNotNull(page);
	}
	
	
}
