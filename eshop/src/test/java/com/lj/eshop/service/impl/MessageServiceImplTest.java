package com.lj.eshop.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

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
import com.lj.eshop.dto.FindMessagePage;
import com.lj.eshop.dto.MessageDto;
import com.lj.eshop.emus.MessageTemplate;
import com.lj.eshop.service.IMessageService;

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
public class MessageServiceImplTest extends SpringTestCase{

	@Resource
	IMessageService messageService;


	/**
	 * 
	 *
	 * 方法说明：添加私信消息表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addMessage() throws TsfaServiceException{
		for(int i=0; i<100; i++) {
			MessageDto messageDto = new MessageDto();
			//add数据录入
			messageDto.setCode("Code");
			messageDto.setType(new Random().nextInt(2)+"");
			messageDto.setTitle("Title"+System.currentTimeMillis());
			messageDto.setSender("Sender");
			messageDto.setRecevier("Recevier");
			messageDto.setIsRead("0");
			messageDto.setUpdateTime(new Date());
			messageDto.setCreateTime(new Date());
			messageDto.setSenderDel("1");
			messageDto.setRecevierDel("1");
			messageDto.setBizType("0");
			messageDto.setBizCode("BizCode");
			messageDto.setShopCode("ShopCode");
			messageDto.setContent("Content"+System.currentTimeMillis());
			
			messageService.addMessage(messageDto);
		}
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改私信消息表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateMessage() throws TsfaServiceException{
		MessageDto messageDto = new MessageDto();
		//update数据录入
		messageDto.setCode("Code");
		messageDto.setType("Type");
		messageDto.setTitle("Title");
		messageDto.setSender("Sender");
		messageDto.setRecevier("Recevier");
		messageDto.setIsRead("IsRead");
		messageDto.setUpdateTime(new Date());
		messageDto.setCreateTime(new Date());
		messageDto.setSenderDel("SenderDel");
		messageDto.setRecevierDel("RecevierDel");
		messageDto.setBizType("BizType");
		messageDto.setBizCode("BizCode");
		messageDto.setShopCode("ShopCode");
		messageDto.setContent("Content");

		messageService.updateMessage(messageDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找私信消息表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMessage() throws TsfaServiceException{
		MessageDto findMessage = new MessageDto();
		findMessage.setCode("111");
		messageService.findMessage(findMessage);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找私信消息表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMessagePage() throws TsfaServiceException{
		FindMessagePage findMessagePage = new FindMessagePage();
		int pageNo = 1;
		int pageSize=10;
		findMessagePage.setStart((pageNo-1)*pageSize);
		findMessagePage.setLimit(pageSize);
		MessageDto param = new MessageDto();
		param.setType("1");
		param.setRecevier("Recevier1");
		findMessagePage.setParam(param);
		
		Page<MessageDto> page = messageService.findMessagePage(findMessagePage);
		Assert.assertNotNull(page);
		System.out.println(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找私信消息表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findMessages() throws TsfaServiceException{
		FindMessagePage findMessagePage = new FindMessagePage();
		MessageDto dto = new MessageDto();
//		dto.setRecevier("LJ_16f944aeb8b84d7c89f82de1b2c1857c");
		dto.setBizCode("B");
		findMessagePage.setParam(dto);
		List<MessageDto> page = messageService.findMessages(findMessagePage);
		System.out.println(page);
		Assert.assertNotNull(page);
		
	}
	
	public static void main(String[] args) {
		
		MessageDto messageDto = new MessageDto();
		messageDto.setcClientOrderNo("cClientBillCode");
		messageDto.setcClientCommodity("cClientCommodity");
		messageDto.setcClientMoney("1000");
		messageDto.setcClientName("cClientName");
		messageDto.setcClientReceiveName("cClientReceiveName");
		
		MessageServiceImpl service = new MessageServiceImpl();
		MessageTemplate[] templates = MessageTemplate.values();
		System.out.println("total==>>>" + templates.length);
		for(int i=0;i<templates.length; i++) {
			service.buildDtoParam(messageDto, templates[i]);
			System.out.println(templates[i]+"\ttitle-->" + messageDto.getTitle() +"\tcontent-->" + messageDto.getContent());
		}
		
	}
	
}
