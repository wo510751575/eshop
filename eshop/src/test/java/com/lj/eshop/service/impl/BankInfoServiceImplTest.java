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

import com.lj.eshop.dto.BankInfoDto;
import com.lj.eshop.dto.FindBankInfoPage;
import com.lj.eshop.service.IBankInfoService;

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
public class BankInfoServiceImplTest extends SpringTestCase {

	@Resource
	IBankInfoService bankInfoService;

	/**
	 * 
	 *
	 * 方法说明：添加银行卡信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addBankInfo() throws TsfaServiceException {
		int i = 1;
		String imgHost = "http://192.168.6.60/eoms/image/bank/";
		BankInfoDto bankInfoDto = new BankInfoDto();
		// add数据录入
		bankInfoDto.setBankName("中国银行");
		bankInfoDto.setBankIcon(imgHost + "zhongugo.png");
		bankInfoDto.setBgIcon(imgHost + "bg_zhongugo.png");
		bankInfoDto.setOrderNo(i++);
		bankInfoDto.setCreateTime(new Date());
		bankInfoService.addBankInfo(bankInfoDto);

		// add数据录入
		bankInfoDto.setBankName("中国工商银行");
		bankInfoDto.setBankIcon(imgHost + "gongshang.png");
		bankInfoDto.setBgIcon(imgHost + "bg_gongshang.png");
		bankInfoDto.setOrderNo(i++);
		bankInfoDto.setCreateTime(new Date());
		bankInfoService.addBankInfo(bankInfoDto);

		// add数据录入
		bankInfoDto.setBankName("中国建设银行");
		bankInfoDto.setBankIcon(imgHost + "jianshe.png");
		bankInfoDto.setBgIcon(imgHost + "bg_jianshe.png");
		bankInfoDto.setOrderNo(i++);
		bankInfoDto.setCreateTime(new Date());
		bankInfoService.addBankInfo(bankInfoDto);

		// add数据录入
		bankInfoDto.setBankName("中国农业银行");
		bankInfoDto.setBankIcon(imgHost + "nongye.png");
		bankInfoDto.setBgIcon(imgHost + "bg_nongye.png");
		bankInfoDto.setOrderNo(i++);
		bankInfoDto.setCreateTime(new Date());
		bankInfoService.addBankInfo(bankInfoDto);

		// add数据录入
		bankInfoDto.setBankName("招商银行");
		bankInfoDto.setBankIcon(imgHost + "zhaoshang.png");
		bankInfoDto.setBgIcon(imgHost + "bg_zhaoshang.png");
		bankInfoDto.setOrderNo(i++);
		bankInfoDto.setCreateTime(new Date());
		bankInfoService.addBankInfo(bankInfoDto);

		// add数据录入
		bankInfoDto.setBankName("交通银行");
		bankInfoDto.setBankIcon(imgHost + "jiaotong.png");
		bankInfoDto.setBgIcon(imgHost + "bg_jiaotong.png");
		bankInfoDto.setOrderNo(i++);
		bankInfoDto.setCreateTime(new Date());
		bankInfoService.addBankInfo(bankInfoDto);

		// add数据录入
		bankInfoDto.setBankName("浦发银行");
		bankInfoDto.setBankIcon(imgHost + "pufa.png");
		bankInfoDto.setBgIcon(imgHost + "bg_pufa.png");
		bankInfoDto.setOrderNo(i++);
		bankInfoDto.setCreateTime(new Date());
		bankInfoService.addBankInfo(bankInfoDto);

		// add数据录入
		bankInfoDto.setBankName("平安银行");
		bankInfoDto.setBankIcon(imgHost + "pingan.png");
		bankInfoDto.setBgIcon(imgHost + "bg_pingan.png");
		bankInfoDto.setOrderNo(i++);
		bankInfoDto.setCreateTime(new Date());
		bankInfoService.addBankInfo(bankInfoDto);

		// add数据录入
		bankInfoDto.setBankName("广发银行");
		bankInfoDto.setBankIcon(imgHost + "guangfa.png");
		bankInfoDto.setBgIcon(imgHost + "bg_guangfa.png");
		bankInfoDto.setOrderNo(i++);
		bankInfoDto.setCreateTime(new Date());
		bankInfoService.addBankInfo(bankInfoDto);

		// add数据录入
		bankInfoDto.setBankName("渣打银行");
		bankInfoDto.setBankIcon(imgHost + "zhada.png");
		bankInfoDto.setBgIcon(imgHost + "bg_zhada.png");
		bankInfoDto.setOrderNo(i++);
		bankInfoDto.setCreateTime(new Date());
		bankInfoService.addBankInfo(bankInfoDto);
	}

	// LJ_0d223ae559bb4eaba8b080c59a962780
	/**
	 * 
	 *
	 * 方法说明：修改银行卡信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateBankInfo() throws TsfaServiceException {
		BankInfoDto bankInfoDto = new BankInfoDto();
		// update数据录入
		bankInfoDto.setCode("Code");
		bankInfoDto.setBankName("BankName");
		bankInfoDto.setBankIcon("BankIcon");
		bankInfoDto.setOrderNo(1);

		bankInfoService.updateBankInfo(bankInfoDto);

	}

	/**
	 * 
	 *
	 * 方法说明：查找银行卡信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findBankInfo() throws TsfaServiceException {
		BankInfoDto findBankInfo = new BankInfoDto();
		findBankInfo.setCode("111");
		bankInfoService.findBankInfo(findBankInfo);
	}

	/**
	 * 
	 *
	 * 方法说明：查找银行卡信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findBankInfoPage() throws TsfaServiceException {
		FindBankInfoPage findBankInfoPage = new FindBankInfoPage();
		Page<BankInfoDto> page = bankInfoService
				.findBankInfoPage(findBankInfoPage);
		Assert.assertNotNull(page);

	}

	/**
	 * 
	 *
	 * 方法说明：查找银行卡信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findBankInfos() throws TsfaServiceException {
		FindBankInfoPage findBankInfoPage = new FindBankInfoPage();
		List<BankInfoDto> page = bankInfoService
				.findBankInfos(findBankInfoPage);
		Assert.assertNotNull(page);

	}

}
