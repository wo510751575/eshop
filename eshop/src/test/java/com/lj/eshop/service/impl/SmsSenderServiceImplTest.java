package com.lj.eshop.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.eshop.emus.SmsBizType;
import com.lj.eshop.service.ISmsSenderService;

public class SmsSenderServiceImplTest extends SpringTestCase{
	
	
	@Resource
	ISmsSenderService smsSenderService;



	/**
	 * 
	 *
	 * 方法说明：添加账户信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void sendTemplateSms() throws TsfaServiceException{
		Map<String,String> contentMap = new HashMap<String,String>();
		contentMap.put("validationCode", "test");
		contentMap.put("senderName", "深圳扬恩科技");
		smsSenderService.sendTemplateSms("18670275128", "test", contentMap, SmsBizType.LOGIN.getValue());
	}
}
