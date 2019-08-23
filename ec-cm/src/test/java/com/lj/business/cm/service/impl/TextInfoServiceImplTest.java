package com.lj.business.cm.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cm.dto.textInfo.AddTextInfo;
import com.lj.business.cm.dto.textInfo.DelTextInfo;
import com.lj.business.cm.dto.textInfo.FindTextInfo;
import com.lj.business.cm.dto.textInfo.FindTextInfoPage;
import com.lj.business.cm.dto.textInfo.FindTextInfoPageReturn;
import com.lj.business.cm.dto.textInfo.UpdateTextInfo;
import com.lj.business.cm.service.ITextInfoService;


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
public class TextInfoServiceImplTest extends SpringTestCase{

	@Resource
	ITextInfoService textInfoService;



	/**
	 *
	 * 方法说明：添加话术信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addTextInfo() throws TsfaServiceException{
	for(int i=0;i<=1;i++){
		AddTextInfo addTextInfo = new AddTextInfo();
		//add数据录入
		addTextInfo.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		addTextInfo.setMerchantName("MerchantName");
		addTextInfo.setTextType("GM_WORK_ANALYZE");
		addTextInfo.setContent("你要加油了！");
		addTextInfo.setDimStart("0");
		addTextInfo.setDimEnd("20");
		addTextInfo.setDimKeyWord("TODO");
		System.out.println(addTextInfo);
		textInfoService.addTextInfo(addTextInfo );
	}
	}
	/*
	*//**
	 * 
	 *
	 * 方法说明：修改话术信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 *//*
	@Test
	public void updateTextInfo() throws TsfaServiceException{
		UpdateTextInfo updateTextInfo = new UpdateTextInfo();
		//update数据录入
		updateTextInfo.setCode("Code");
		updateTextInfo.setMerchantNo("MerchantNo");
		updateTextInfo.setMerchantName("MerchantName");
		updateTextInfo.setTextType("TextType");
		updateTextInfo.setContent("Content");
		updateTextInfo.setDimStart("DimStart");
		updateTextInfo.setDimEnd("DimEnd");
		updateTextInfo.setDimKeyWord("DimKeyWord");

		textInfoService.updateTextInfo(updateTextInfo );
		
	}
	
	*//**
	 * 
	 *
	 * 方法说明：查找话术信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 *//*
	@Test
	public void findTextInfo() throws TsfaServiceException{
		FindTextInfo findTextInfo = new FindTextInfo();
		findTextInfo.setCode("111");
		textInfoService.findTextInfo(findTextInfo);
	}
	
	*//**
	 * 
	 *
	 * 方法说明：查找话术信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 *//*
	@Test
	public void findTextInfoPage() throws TsfaServiceException{
		FindTextInfoPage findTextInfoPage = new FindTextInfoPage();
		Page<FindTextInfoPageReturn> page = textInfoService.findTextInfoPage(findTextInfoPage);
		Assert.assertNotNull(page);
		
	}
	
	*//**
	 * 
	 *
	 * 方法说明：删除话术信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 *//*
	@Test
	public void delTextInfo() throws TsfaServiceException{
		DelTextInfo delTextInfo = new DelTextInfo();
		delTextInfo.setCode("111");
		textInfoService.delTextInfo(delTextInfo);
		
	}*/
/*	@Test
	public void findTextInfoReturnContent() throws TsfaServiceException{
		FindTextInfo findTextInfo=new FindTextInfo();
		findTextInfo.setCount(15);
		findTextInfo.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		findTextInfo.setTextType("客户分析");
		FindTextInfoPageReturn list= textInfoService.findTextInfoReturnContent(findTextInfo);
		System.out.println(list);
		
		
	}*/
	
	
	
}
