package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.comTaskChoose.AddComTaskChooseDto;
import com.lj.business.cf.dto.comTaskChoose.ComTaskChooseReturnDto;
import com.lj.business.cf.dto.comTaskChoose.EditComTaskChooseDto;
import com.lj.business.cf.dto.comTaskChoose.FindComTaskChoose;
import com.lj.business.cf.dto.comTaskChoose.FindComTaskChooseIndex;
import com.lj.business.cf.dto.comTaskChoose.FindComTaskChooseIndexReturn;
import com.lj.business.cf.dto.comTaskChoose.FindComTaskChoosePageDto;
import com.lj.business.cf.dto.comTaskList.FindComTaskList;
import com.lj.business.cf.dto.comTaskList.FindComTaskListReturn;
import com.lj.business.cf.emus.ComTaskType;
import com.lj.business.cf.service.IComTaskChooseService;
import com.lj.business.cf.service.IComTaskListService;
import com.lj.business.cf.util.TestHelp;


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
public class ComTaskChooseServiceImplTest extends SpringTestCase{
	@Resource
	private IComTaskChooseService comTaskChooseService;

	@Resource
	private IComTaskListService comTaskListService;

	/**
	 * 
	 *
	 * 方法说明：添加客户沟通任务选择表
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月28日
	 *
	 */
	@Test
	public void addComTaskChoose() {
		String merchantNo = "1f2a6d3e3022448382734bc70c9384af";
		ComTaskType [] comTaskTypeAr = ComTaskType.values();
		for (ComTaskType comTaskType : comTaskTypeAr) {
			if(comTaskType.equals(ComTaskType.SYSTEM))
				continue;
			AddComTaskChooseDto comTaskChoose = new AddComTaskChooseDto();
			comTaskChoose.setMerchantNo(merchantNo);
			comTaskChoose.setShopNo("");
			comTaskChoose.setShopName("");
			comTaskChoose.setMemberNoGm("");
			comTaskChoose.setMemberNameGm("");
			FindComTaskList findComTaskList = new FindComTaskList();
			findComTaskList.setComTaskType(comTaskType);
			findComTaskList.setMerchantNo(merchantNo);
			FindComTaskListReturn findComTaskListReturn = comTaskListService.findComTaskList(findComTaskList );
			comTaskChoose.setCodeList(findComTaskListReturn.getCode());
			comTaskChoose.setNameList(findComTaskListReturn.getNameList());

			comTaskChoose.setComTaskType(comTaskType);
			comTaskChoose.setStatus("Y");

			if(comTaskType.equals(ComTaskType.GROUP)){
				comTaskChoose.setFreValue("1");
				comTaskChoose.setSeq(10);
			}else if(comTaskType.equals(ComTaskType.FIRST_INTR)){
				comTaskChoose.setFreValue("1");
				comTaskChoose.setSeq(20);
			}else if(comTaskType.equals(ComTaskType.INVITE)){
				comTaskChoose.setFreValue("1");
				comTaskChoose.setSeq(30);
			}else if(comTaskType.equals(ComTaskType.REMIND)){
				comTaskChoose.setFreValue("1");
				comTaskChoose.setSeq(40);
			}else if(comTaskType.equals(ComTaskType.CLIENT_EXP)){
				comTaskChoose.setFreValue("1");
				comTaskChoose.setSeq(50);
			}else if(comTaskType.equals(ComTaskType.GUID_PM)){
				comTaskChoose.setFreValue("1");
				comTaskChoose.setSeq(60);
			}else if(comTaskType.equals(ComTaskType.COM_TASK)){
				comTaskChoose.setFreValue("1");
				comTaskChoose.setSeq(70);
			}

			comTaskChoose.setRemark("");
			comTaskChoose.setRemark2("");
			comTaskChoose.setRemark3("");
			comTaskChoose.setRemark4("");
			comTaskChooseService.addComTaskChoose(comTaskChoose);
		}
	}

	/**
	 * 
	 *
	 * 方法说明：编辑客户沟通任务选择表
	 *
	 * @param 
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月28日
	 *
	 */
	@Test
	public void editComTaskChoose() {
		EditComTaskChooseDto comTaskChoose = new EditComTaskChooseDto();
		comTaskChoose.setCode(GUID.getPreUUID());
		comTaskChoose.setMerchantNo(GUID.getPreUUID());
		comTaskChoose.setShopNo(GUID.getPreUUID());
		comTaskChoose.setShopName("福田分店");
		comTaskChoose.setMemberNoGm(GUID.getPreUUID());
		comTaskChoose.setMemberNameGm("邹磊");
		comTaskChoose.setCodeList(GUID.getPreUUID());
		comTaskChoose.setNameList("打电话");
		comTaskChoose.setStatus("Y");
		comTaskChoose.setFreValue("两天");
		comTaskChoose.setSeq(1);
		comTaskChoose.setRemark("很好");
		comTaskChoose.setRemark2("很好");
		comTaskChoose.setRemark3("很好");
		comTaskChoose.setRemark4("很好");
		comTaskChooseService.editComTaskChoose(comTaskChoose);
	}

	/**
	 * 
	 *
	 * 方法说明：通过主键查询客户沟通任务选择表
	 *
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	@Test
	public void selectByCode() {
		ComTaskChooseReturnDto comTaskChooseReturnDto = comTaskChooseService.selectByCode("LJ_e5a0b948ae5a4cf982b6bfb8ba1903bc");
		System.out.println(comTaskChooseReturnDto.toString());
	}

	/**
	 * 
	 *
	 * 方法说明：查找客户沟通任务选择表(不分页)
	 *
	 * @param 
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	@Test
	public void findComTaskChooses() {
		FindComTaskChoosePageDto findComTaskChoosePageDto = new FindComTaskChoosePageDto();
		findComTaskChoosePageDto.setMerchantNo("LJ_2ee510250d5d4c3e87e3d273a4fbf219");
		List<FindComTaskChoosePageDto> list = comTaskChooseService.findComTaskChooses(findComTaskChoosePageDto);
		System.out.println(list.toString());

	}

	@Test
	public void findComTaskChoose() {
		FindComTaskChoose findComTaskChoose = new FindComTaskChoose();
		findComTaskChoose.setMerchantNo(TestHelp.merchantNo_test);
		findComTaskChoose.setComTaskType(ComTaskType.COM_TASK.toString());
		comTaskChooseService.findComTaskChoose(findComTaskChoose );

	}

	/**
	 * 
	 *
	 * 方法说明：查找客户沟通任务选择表(分页)
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	@Test
	public void findComTaskChoosePage() {
		FindComTaskChoosePageDto findComTaskChoosePageDto = new FindComTaskChoosePageDto();
		findComTaskChoosePageDto.setMerchantNo("LJ_2ee510250d5d4c3e87e3d273a4fbf219");
		Page<FindComTaskChoosePageDto> page = comTaskChooseService.findComTaskChoosePage(findComTaskChoosePageDto);
		Assert.assertNotNull(page);
	}



	/**
	 * 
	 *
	 * 方法说明：沟通任务首页：沟通任务分类信息查询_APP
	 *
	 *
	 * @author 彭阳 CreateDate: 2017年7月22日
	 *
	 */
	@Test
	public void findComTaskChooseIndex() {
		FindComTaskChooseIndex findComTaskChooseIndex = new FindComTaskChooseIndex();
		findComTaskChooseIndex.setFlag("DIS");
		findComTaskChooseIndex.setMerchantNo(TestHelp.merchantNo_test);
		findComTaskChooseIndex.setMemberNoGm(TestHelp.memberNo_test);
		/*Date date = new Date();
		date = DateUtils.truncate(date, Calendar.DAY_OF_MONTH);
		findComTaskChooseIndex.setWorkDateEnd(date);
		Date nextDay = com.lj.base.core.util.DateUtils.getNextday(date);
		findComTaskChooseIndex.setWorkDateStart(nextDay);*/
		List<FindComTaskChooseIndexReturn> page = comTaskChooseService.findComTaskChooseIndex(findComTaskChooseIndex);
		Assert.assertNotNull(page);
	}


}
