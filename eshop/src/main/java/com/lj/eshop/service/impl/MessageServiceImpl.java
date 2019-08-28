package com.lj.eshop.service.impl;

import java.util.Date;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.dao.IMessageDao;
import com.lj.eshop.domain.Message;
import com.lj.eshop.dto.FindMessagePage;
import com.lj.eshop.dto.MessageDto;
import com.lj.eshop.emus.IsRead;
import com.lj.eshop.emus.MessageTemplate;
import com.lj.eshop.emus.MessageType;
import com.lj.eshop.service.IMessageService;

/**
 * 类说明：实现类
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
@Service
public class MessageServiceImpl implements IMessageService {

	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

	@Resource
	private IMessageDao messageDao;

	@Override
	public void addMessage(MessageDto messageDto) throws TsfaServiceException {
		logger.debug("addMessage(AddMessage addMessage={}) - start", messageDto);

		AssertUtils.notNull(messageDto);
		try {
			Message message = new Message();
			// add数据录入
			message.setCode(GUID.generateCode());
			message.setType(messageDto.getType());
			message.setTitle(messageDto.getTitle());
			message.setSender(messageDto.getSender());
			message.setRecevier(messageDto.getRecevier());
			message.setIsRead(messageDto.getIsRead());
			message.setUpdateTime(messageDto.getUpdateTime());
			message.setCreateTime(messageDto.getCreateTime());
			message.setSenderDel(messageDto.getSenderDel());
			message.setRecevierDel(messageDto.getRecevierDel());
			message.setBizType(messageDto.getBizType());
			message.setBizCode(messageDto.getBizCode());
			message.setShopCode(messageDto.getShopCode());
			message.setContent(messageDto.getContent());
			messageDao.insertSelective(message);
			logger.debug("addMessage(MessageDto) - end - return");
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增私信消息表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MESSAGE_ADD_ERROR, "新增私信消息表信息错误！", e);
		}
	}

	/**
	 * 
	 *
	 * 方法说明：不分页查询私信消息表信息
	 *
	 * @param findMessagePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<MessageDto> findMessages(FindMessagePage findMessagePage) throws TsfaServiceException {
		AssertUtils.notNull(findMessagePage);
		List<MessageDto> returnList = null;
		try {
			returnList = messageDao.findMessages(findMessagePage);
		} catch (Exception e) {
			logger.error("查找私信消息表信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MESSAGE_NOT_EXIST_ERROR, "私信消息表信息不存在");
		}
		return returnList;
	}

	@Override
	public void updateMessage(MessageDto messageDto) throws TsfaServiceException {
		logger.debug("updateMessage(MessageDto messageDto={}) - start", messageDto); //$NON-NLS-1$

		AssertUtils.notNull(messageDto);
		AssertUtils.notNullAndEmpty(messageDto.getCode(), "Code不能为空");
		try {
			Message message = new Message();
			// update数据录入
			message.setCode(messageDto.getCode());
			message.setType(messageDto.getType());
			message.setTitle(messageDto.getTitle());
			message.setSender(messageDto.getSender());
			message.setRecevier(messageDto.getRecevier());
			message.setIsRead(messageDto.getIsRead());
			message.setUpdateTime(messageDto.getUpdateTime());
			message.setCreateTime(messageDto.getCreateTime());
			message.setSenderDel(messageDto.getSenderDel());
			message.setRecevierDel(messageDto.getRecevierDel());
			message.setBizType(messageDto.getBizType());
			message.setBizCode(messageDto.getBizCode());
			message.setShopCode(messageDto.getShopCode());
			message.setContent(messageDto.getContent());
			AssertUtils.notUpdateMoreThanOne(messageDao.updateByPrimaryKeySelective(message));
			logger.debug("updateMessage(MessageDto) - end - return"); //$NON-NLS-1$
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("私信消息表信息更新信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MESSAGE_UPDATE_ERROR, "私信消息表信息更新信息错误！", e);
		}
	}

	@Override
	public MessageDto findMessage(MessageDto messageDto) throws TsfaServiceException {
		logger.debug("findMessage(FindMessage findMessage={}) - start", messageDto); //$NON-NLS-1$

		AssertUtils.notNull(messageDto);
		AssertUtils.notAllNull(messageDto.getCode(), "Code不能为空");
		try {
			Message message = messageDao.selectByPrimaryKey(messageDto.getCode());
			if (message == null) {
				return null;
				// throw new
				// TsfaServiceException(ErrorCode.MESSAGE_NOT_EXIST_ERROR,"私信消息表信息不存在");
			}
			MessageDto findMessageReturn = new MessageDto();
			// find数据录入
			findMessageReturn.setCode(message.getCode());
			findMessageReturn.setType(message.getType());
			findMessageReturn.setTitle(message.getTitle());
			findMessageReturn.setSender(message.getSender());
			findMessageReturn.setRecevier(message.getRecevier());
			findMessageReturn.setIsRead(message.getIsRead());
			findMessageReturn.setUpdateTime(message.getUpdateTime());
			findMessageReturn.setCreateTime(message.getCreateTime());
			findMessageReturn.setSenderDel(message.getSenderDel());
			findMessageReturn.setRecevierDel(message.getRecevierDel());
			findMessageReturn.setBizType(message.getBizType());
			findMessageReturn.setBizCode(message.getBizCode());
			findMessageReturn.setShopCode(message.getShopCode());
			findMessageReturn.setContent(message.getContent());

			logger.debug("findMessage(MessageDto) - end - return value={}", findMessageReturn); //$NON-NLS-1$
			return findMessageReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("查找私信消息表信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MESSAGE_FIND_ERROR, "查找私信消息表信息信息错误！", e);
		}

	}

	@Override
	public Page<MessageDto> findMessagePage(FindMessagePage findMessagePage) throws TsfaServiceException {
		logger.debug("findMessagePage(FindMessagePage findMessagePage={}) - start", findMessagePage); //$NON-NLS-1$

		AssertUtils.notNull(findMessagePage);
		List<MessageDto> returnList = null;
		int count = 0;
		try {
			count = messageDao.findMessagePageCount(findMessagePage);
			if (count > 0) {
				returnList = messageDao.findMessagePage(findMessagePage);
			}
		} catch (Exception e) {
			logger.error("私信消息表信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.MESSAGE_FIND_PAGE_ERROR, "私信消息表信息不存在错误.！", e);
		}
		Page<MessageDto> returnPage = new Page<MessageDto>(returnList, count, findMessagePage);

		logger.debug("findMessagePage(FindMessagePage) - end - return value={}", returnPage); //$NON-NLS-1$
		return returnPage;
	}

	@Override
	public void addMessageByTemplate(MessageDto messageDto, MessageTemplate messageTemplate)
			throws TsfaServiceException {
		logger.debug("addMessageByTemplate() - start - return={}", messageDto + "===" + messageTemplate.getTitle());
		// 如果是业务通知，设置为业务通知
		if (messageTemplate.toString().indexOf("SERVICE") != -1) {
			messageDto.setType(MessageType.NOTIFY.getValue());
		} else {
			messageDto.setType(MessageType.SYSTEM.getValue());
		}

		buildDtoParam(messageDto, messageTemplate);

		messageDto.setIsRead("0");
		messageDto.setCreateTime(new Date());
		messageDto.setSenderDel("0");
		messageDto.setRecevierDel("0");
		messageDto.setCreateTime(new Date());

		addMessage(messageDto);

		logger.debug("addMessageByTemplate() - end", messageDto);
	}

	/**
	 * 构建消息内容通过业务类型 方法说明：
	 *
	 * @param @param messageDto
	 * @param @param messageTemplate 设定文件
	 * @return void 返回类型
	 * @throws Exception
	 *
	 * @author 林进权 CreateDate: 2017年9月1日
	 */
	public void buildDtoParam(MessageDto messageDto, MessageTemplate messageTemplate) {
		messageDto.setTitle(messageTemplate.getTitle());
		messageDto.setBizCode(messageTemplate.getBizCode());

		switch (messageTemplate) {
		case B_SERVICE_ORDER_BILL_NON_PAYMENT:
		case B_SERVICE_ORDER_BILL_PAYMENTED:
		case B_SERVICE_ORDER_BILL_COMPLETED:
			messageDto.setContent(messageTemplate.getChContent(messageDto.getcClientName(),
					messageDto.getcClientReceiveName(), messageDto.getcClientMoney(), messageDto.getcClientCommodity(),
					messageDto.getcClientOrderNo()));
			break;

		case B_SERVICE_ORDER_BILL_BACK:
			messageDto.setContent(messageTemplate.getChContent(messageDto.getcClientName(),
					messageDto.getcClientCommodity(), messageDto.getcClientOrderNo()));
			break;
		case C_SYS_COMMODITY_SENDED:
			messageDto.setContent(
					messageTemplate.getChContent(messageDto.getcClientCommodity(), messageDto.getcClientOrderNo()));
			break;

		case B_SYS_WITHDRAW:
		case B_APP_SYS_PASSWORD:
		case B_SYS_CHANGE_PASSWORD:
			messageDto
					.setContent(messageTemplate.getChContent(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss")));
			break;

		case C_SERVICE_BACK_SUCCESS:
			messageDto.setContent(
					messageTemplate.getChContent(messageDto.getcClientCommodity(), messageDto.getcClientOrderNo()));
			break;
		case C_SERVICE_ORDER_BILL_NON_PAYMENT:
		case C_SERVICE_ORDER_BILL_PAYMENTED:
		case C_SERVICE_ORDER_BILL_COMPLETED:
			messageDto.setContent(messageTemplate.getChContent(messageDto.getcClientMoney(),
					messageDto.getcClientCommodity(), messageDto.getcClientOrderNo()));
			break;
		default:
			messageDto.setContent(messageTemplate.getChContent());
		}

	}

	@Override
	public int findMessagePageCount(FindMessagePage findMessagePage) throws TsfaServiceException {
		logger.debug("findMessagePage(FindMessagePage findMessagePage={}) - start", findMessagePage); //$NON-NLS-1$

		AssertUtils.notNull(findMessagePage);
		int count = 0;
		try {
			count = messageDao.findMessagePageCount(findMessagePage);
		} catch (Exception e) {
			logger.error("私信消息表信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.MESSAGE_FIND_PAGE_ERROR, "私信消息表信息不存在错误.！", e);
		}
		logger.debug("findMessagePage(FindMessagePage) - end - return value={}", count); //$NON-NLS-1$
		return count;
	}

	@Override
	public void updateByRecevier(MessageDto messageDto) throws TsfaServiceException {
		logger.debug("updateMessage(MessageDto messageDto={}) - start", messageDto); //$NON-NLS-1$

		AssertUtils.notNull(messageDto);
		AssertUtils.notNullAndEmpty(messageDto.getRecevier(), "Recevier不能为空");
		try {
			Message message = new Message();
			// update数据录入
			message.setRecevier(messageDto.getRecevier());
			message.setIsRead(IsRead.Y.getValue());
			message.setUpdateTime(new Date());
			messageDao.updateByRecevier(message);
			logger.debug("updateMessage(MessageDto) - end - return"); //$NON-NLS-1$
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("私信消息表信息更新信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MESSAGE_UPDATE_ERROR, "私信消息表信息更新信息错误！", e);
		}
	}

}
