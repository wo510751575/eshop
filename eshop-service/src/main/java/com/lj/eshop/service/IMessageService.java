package com.lj.eshop.service;

import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.dto.FindMessagePage;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.MessageDto;
import com.lj.eshop.emus.MessageTemplate;
/**
 * 类说明：接口类
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
public interface IMessageService {
	
	/**
	 * 
	 *
	 * 方法说明：添加私信消息表信息
	 *
	 * @param messageDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addMessage(MessageDto messageDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找私信消息表信息
	 *
	 * @param findMessage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public MessageDto findMessage(MessageDto messageDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询私信消息表信息
	 *
	 * @param findMessagePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<MessageDto>  findMessages(FindMessagePage findMessagePage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改私信消息表信息
	 *
	 * @param updateMessage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateMessage(MessageDto messageDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询私信消息表信息
	 *
	 * @param findMessagePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<MessageDto> findMessagePage(FindMessagePage findMessagePage) throws TsfaServiceException;
	
	/**
	 * @param messageDto
	 * 			receive 必须
	 * 			其它参数 根据messageTemplate增减
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-09-02
	 *
	 */
	public void addMessageByTemplate(MessageDto messageDto, MessageTemplate messageServiceType) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：统计数量
	 *
	 * @param findMessagePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年9月22日
	 *
	 */
	int findMessagePageCount(FindMessagePage findMessagePage) throws TsfaServiceException;
}
