/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lj.base.core.pagination.Page;
import com.lj.base.core.pagination.PageSortType;
import com.lj.base.core.util.StringUtils;
import com.lj.eshop.dto.FindMessagePage;
import com.lj.eshop.dto.MessageDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.emus.IsRead;
import com.lj.eshop.emus.MessageBizCode;
import com.lj.eshop.emus.MessageType;
import com.lj.eshop.service.IMessageService;

/**
 * 
 * 类说明：我的消息
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年8月28日
 */
@RestController
@RequestMapping("/message")
public class MessageController extends BaseController {

	@Autowired
	private IMessageService messageService;

	@RequestMapping(value = { "test" })
	@ResponseBody
	public ResponseDto test() {
		logger.debug("test() - start");

		try {
			return ResponseDto.successResp(null);
		} catch (Exception e) {
			return ResponseDto.generateFailureResponse(e);
		}
	}

	/**
	 * 消息列表 方法说明：
	 *
	 * @param @param pageNo 页码
	 * @param @param pageSize 每页数量
	 * @param @param type 0、系统消息 1、通知
	 * @param @param clientType B、b端 C、c端
	 *
	 * @author 林进权 CreateDate: 2017年9月1日
	 */
	@RequestMapping(value = { "list" })
	@ResponseBody
	public ResponseDto list(Integer pageNo, Integer pageSize, String type, String clientType) {
		logger.debug("MessageController --> list() - start", "type>" + type + "--clientType>" + clientType);

		if (StringUtils.isEmpty(type) /* || StringUtils.isEmpty(clientType) */) {
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(),
					null);
		}

		FindMessagePage findMessagePage = new FindMessagePage();
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null || pageSize > 500 ? 10 : pageSize;
		findMessagePage.setStart((pageNo - 1) * pageSize);
		findMessagePage.setLimit(pageSize);
		findMessagePage.setSortBy("create_time");
		findMessagePage.setSortDir(PageSortType.desc);

		MessageDto param = new MessageDto();
		param.setRecevier(getLoginMemberCode());
		param.setType(type);
//			param.setBizCode(clientType);
		findMessagePage.setParam(param);

		Page<MessageDto> pageDto = messageService.findMessagePage(findMessagePage);
		List<MessageDto> list = new ArrayList<MessageDto>();
		list.addAll(pageDto.getRows());

//			if(pageDto.getRows()==null || list.size()<=0){
//				return ResponseDto.createResp(false, ResponseCode.NO_DATA.getCode(), ResponseCode.NO_DATA.getMsg(), null);
//			}
		logger.debug("MessageController --> return(={}) - end", list);

		/* 标记为已读 */
		messageService.updateByRecevier(param);

		return ResponseDto.successResp(pageDto);
	}

	@RequestMapping(value = { "list_app" })
	@ResponseBody
	public ResponseDto list_app(Integer pageNo, Integer pageSize, String type) {
		logger.debug("MessageController --> list() - start", "type>" + type);
		return list(pageNo, pageSize, type, MessageBizCode.BAPP.getValue());
	}

	/**
	 * 
	 *
	 * 方法说明：未读消息总数量
	 *
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月22日
	 *
	 */
	@RequestMapping(value = "unRead")
	@ResponseBody
	public ResponseDto unRead() {
		logger.debug("unRead --->> getLoginMemberCode={}", getLoginMemberCode());
		MessageDto param = new MessageDto();
		param.setRecevier(getLoginMemberCode());
		param.setIsRead(IsRead.N.getValue());
		// param.setBizCode(MessageBizCode.BAPP.getValue());
		FindMessagePage findMessagePage = new FindMessagePage();
		findMessagePage.setParam(param);
		int count = messageService.findMessagePageCount(findMessagePage);
		logger.debug("unRead --->> return={}", count);
		return ResponseDto.successResp(count);
	}

	/**
	 * 
	 *
	 * 方法说明：消息-首页
	 *
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月22日
	 *
	 */
	@RequestMapping(value = "newMsg")
	@ResponseBody
	public ResponseDto newMsg() {
		logger.debug("newMsg --->> getLoginMemberCode={}", getLoginMemberCode());

		List<Map<String, Object>> returnList = Lists.newArrayList();
		Map<String, Object> returnMap = Maps.newHashMap();

		/* 系统消息 */
		MessageDto param = new MessageDto();
		param.setRecevier(getLoginMemberCode());
		param.setType(MessageType.SYSTEM.getValue());
		param.setBizCode(MessageBizCode.BAPP.getValue());
		FindMessagePage findMessagePage = new FindMessagePage();
		findMessagePage.setParam(param);
		findMessagePage.setLimit(1);
		Page<MessageDto> pageDto = messageService.findMessagePage(findMessagePage);
		returnMap.put("type", MessageType.SYSTEM.getValue());
		for (MessageDto item : pageDto.getRows()) {
			returnMap.put("title", item.getTitle());
			returnMap.put("content", StringUtils.isEmpty(item.getContent()) ? "暂时没有系统消息！" : item.getContent());
		}
		param.setIsRead(IsRead.N.getValue());
		findMessagePage.setParam(param);
		int count = messageService.findMessagePageCount(findMessagePage);
		returnMap.put("unRead", count);
		returnList.add(returnMap);

		/* 通知消息 */
//		param = new MessageDto();
//		param.setRecevier(getLoginMemberCode());
//		param.setType(MessageType.NOTIFY.getValue());
//		param.setBizCode(MessageBizCode.BAPP.getValue());
//		findMessagePage = new FindMessagePage();
//		findMessagePage.setParam(param);
//		findMessagePage.setLimit(1);
//		pageDto = messageService.findMessagePage(findMessagePage);
//		
//		returnMap = Maps.newHashMap();
//		returnMap.put("type",MessageType.NOTIFY.getValue());
//		for (MessageDto item : pageDto.getRows()) {
//			returnMap.put("title",item.getTitle());
//			returnMap.put("content",StringUtils.isEmpty(item.getContent())?"暂时没有通知消息！":item.getContent());
//		}
//		param.setIsRead(IsRead.N.getValue());
//		findMessagePage.setParam(param);
//		count =messageService.findMessagePageCount(findMessagePage);
//		returnMap.put("unRead", count);
//		returnList.add(returnMap);

		logger.debug("newMsg --->> return={}", returnList);
		return ResponseDto.successResp(returnList);
	}
}
