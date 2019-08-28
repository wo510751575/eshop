package com.lj.business.weixin.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.pagination.PageSortType;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.dto.FindGuidMember;
import com.lj.business.member.dto.FindGuidMemberDto;
import com.lj.business.member.dto.FindGuidMemberPage;
import com.lj.business.member.dto.FindGuidMemberPageReturn;
import com.lj.business.member.dto.FindGuidMemberReturn;
import com.lj.business.member.dto.FindShop;
import com.lj.business.member.dto.FindShopPageReturn;
import com.lj.business.member.dto.GuidMemberReturnDto;
import com.lj.business.member.service.IGuidMemberService;
import com.lj.business.member.service.IShopService;
import com.lj.business.weixin.constant.ErrorCode;
import com.lj.business.weixin.dao.IWxChatInfoDao;
import com.lj.business.weixin.domain.WxChatInfo;
import com.lj.business.weixin.dto.AddWxChatInfo;
import com.lj.business.weixin.dto.AddWxChatInfoReturn;
import com.lj.business.weixin.dto.FindWxChatInfo;
import com.lj.business.weixin.dto.FindWxChatInfoPage;
import com.lj.business.weixin.dto.FindWxChatInfoPageReturn;
import com.lj.business.weixin.dto.FindWxChatInfoReturn;
import com.lj.business.weixin.dto.UpdateWxChatInfo;
import com.lj.business.weixin.dto.UpdateWxChatInfoReturn;
import com.lj.business.weixin.service.IWxChatInfoService;

/**
 * 类说明：实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 罗书明
 * 
 * 
 * CreateDate: 2017-06-14
 */
@Service
public class WxChatInfoServiceImpl implements IWxChatInfoService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(WxChatInfoServiceImpl.class);
	

	@Resource
	private IWxChatInfoDao wxChatInfoDao;
	@Resource
	private IGuidMemberService guidMemberService;
	
	@Resource
	private IShopService shopService;
	
	
	
	@Override
	public AddWxChatInfoReturn addWxChatInfo(
			AddWxChatInfo addWxChatInfo) throws TsfaServiceException {
		logger.debug("addWxChatInfo(AddWxChatInfo addWxChatInfo={}) - start", addWxChatInfo); 

		AssertUtils.notNull(addWxChatInfo);
		try {
			WxChatInfo wxChatInfo = new WxChatInfo();
			//add数据录入
			wxChatInfo.setCode(GUID.generateByUUID());
			
			
			//根据微信号获取导购信息
			FindGuidMember findGuidMember = new FindGuidMember();
			if(!StringUtils.isEmpty(addWxChatInfo.getNoWx()))//预防NO_WX为空，造成全表扫描
				findGuidMember.setNoWx(addWxChatInfo.getNoWx());
			else if(!StringUtils.isEmpty(addWxChatInfo.getMemberNo()))
				findGuidMember.setMemberNo(addWxChatInfo.getMemberNo());
			else{
				logger.error("【聊天记录信息上传】微信号，导购会员编号全部为空！");
				return new AddWxChatInfoReturn();
			}
			FindGuidMemberReturn findGuidMemberReturn = guidMemberService.findGuidMember(findGuidMember);

			/*FindGuidMemberPage findGuidMemberPage = new FindGuidMemberPage();
			List<FindGuidMemberPageReturn> guidMemberPageReturns= guidMemberService.findGuidMembers(findGuidMemberPage);
			if(guidMemberPageReturns==null|| guidMemberPageReturns.size()<=0){
				logger.error("导购为空！");
				throw new TsfaServiceException(ErrorCode.WX_CHAT_INFO_ADD_ERROR,"导购为空！");
			}
			FindGuidMemberPageReturn findGuidMemberPageReturn= guidMemberPageReturns.get(0);*/
			
			
			wxChatInfo.setMemberNo(findGuidMemberReturn.getMemberNo());
			wxChatInfo.setMemberName(findGuidMemberReturn.getMemberName());
			wxChatInfo.setMsgsvrid(addWxChatInfo.getMsgsvrid());
			wxChatInfo.setType(addWxChatInfo.getType());
			wxChatInfo.setIssend(addWxChatInfo.getIssend());
			wxChatInfo.setTalker(addWxChatInfo.getTalker());
			wxChatInfo.setContent(addWxChatInfo.getContent());
			wxChatInfo.setChatDate(addWxChatInfo.getChatDate());
			wxChatInfo.setResourcesPath(addWxChatInfo.getResourcesPath());
			wxChatInfo.setShareTitle(addWxChatInfo.getShareTitle());
			wxChatInfo.setShareDes(addWxChatInfo.getShareDes());
			wxChatInfo.setShareUrl(addWxChatInfo.getShareUrl());
			wxChatInfo.setStatus(addWxChatInfo.getStatus());
			wxChatInfo.setCreateDate(new Date());
			wxChatInfo.setTimestamp(addWxChatInfo.getTimestamp());
			wxChatInfoDao.insertSelective(wxChatInfo);
			
			AddWxChatInfoReturn addWxChatInfoReturn = new AddWxChatInfoReturn();
			
			logger.debug("addWxChatInfo(AddWxChatInfo) - end - return value={}", addWxChatInfoReturn); 
			return addWxChatInfoReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增聊天记录信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WX_CHAT_INFO_ADD_ERROR,"新增聊天记录信息错误！",e);
		}
	}
	
	
	@Override
	public UpdateWxChatInfoReturn updateWxChatInfo(
			UpdateWxChatInfo updateWxChatInfo)
			throws TsfaServiceException {
		logger.debug("updateWxChatInfo(UpdateWxChatInfo updateWxChatInfo={}) - start", updateWxChatInfo); //$NON-NLS-1$

		AssertUtils.notNull(updateWxChatInfo);
		try {
			WxChatInfo wxChatInfo = new WxChatInfo();
			//update数据录入

			wxChatInfo.setMsgsvrid(updateWxChatInfo.getMsgsvrid());
			wxChatInfo.setType(updateWxChatInfo.getType());
			wxChatInfo.setIssend(updateWxChatInfo.getIssend());
			wxChatInfo.setTalker(updateWxChatInfo.getTalker());
			wxChatInfo.setContent(updateWxChatInfo.getContent());
			wxChatInfo.setChatDate(updateWxChatInfo.getChatDate());
			wxChatInfo.setResourcesPath(updateWxChatInfo.getResourcesPath());
			wxChatInfo.setShareTitle(updateWxChatInfo.getShareTitle());
			wxChatInfo.setShareDes(updateWxChatInfo.getShareDes());
			wxChatInfo.setShareUrl(updateWxChatInfo.getShareUrl());
			wxChatInfo.setStatus(updateWxChatInfo.getStatus());
			wxChatInfo.setCreateDate(new Date());
			wxChatInfo.setTimestamp(updateWxChatInfo.getTimestamp());
			wxChatInfoDao.insertSelective(wxChatInfo);
			AssertUtils.notUpdateMoreThanOne(wxChatInfoDao.updateByPrimaryKeySelective(wxChatInfo));
			UpdateWxChatInfoReturn updateWxChatInfoReturn = new UpdateWxChatInfoReturn();

			logger.debug("updateWxChatInfo(UpdateWxChatInfo) - end - return value={}", updateWxChatInfoReturn); //$NON-NLS-1$
			return updateWxChatInfoReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("聊天记录信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WX_CHAT_INFO_UPDATE_ERROR,"聊天记录信息更新信息错误！",e);
		}
	}

	

	@Override
	public FindWxChatInfoReturn findWxChatInfo(
			FindWxChatInfo findWxChatInfo) throws TsfaServiceException {
		logger.debug("findWxChatInfo(FindWxChatInfo findWxChatInfo={}) - start", findWxChatInfo); //$NON-NLS-1$

		AssertUtils.notNull(findWxChatInfo);
		AssertUtils.notAllNull(findWxChatInfo.getCode(),"Code不能为空");
		try {
			WxChatInfo wxChatInfo = wxChatInfoDao.selectByPrimaryKey(findWxChatInfo.getCode());
			if(wxChatInfo == null){
				throw new TsfaServiceException(ErrorCode.WX_CHAT_INFO_NOT_EXIST_ERROR,"聊天记录信息不存在");
			}
			FindWxChatInfoReturn findWxChatInfoReturn = new FindWxChatInfoReturn();
			//find数据录入
			findWxChatInfoReturn.setCode(wxChatInfo.getCode());
			findWxChatInfoReturn.setMemberNo(wxChatInfo.getMemberNo());
			findWxChatInfoReturn.setMemberName(wxChatInfo.getMemberName());
			findWxChatInfoReturn.setMsgsvrid(wxChatInfo.getMsgsvrid());
			findWxChatInfoReturn.setIssend(wxChatInfo.getIssend());
			findWxChatInfoReturn.setTalker(wxChatInfo.getTalker());
			findWxChatInfoReturn.setContent(wxChatInfo.getContent());
			findWxChatInfoReturn.setResourcesPath(wxChatInfo.getResourcesPath());
			findWxChatInfoReturn.setChatDate(wxChatInfo.getChatDate());
			findWxChatInfoReturn.setCreateDate(wxChatInfo.getCreateDate());
			findWxChatInfoReturn.setType(wxChatInfo.getType());
			findWxChatInfoReturn.setShareTitle(wxChatInfo.getShareTitle());
			findWxChatInfoReturn.setShareDes(wxChatInfo.getShareDes());
			findWxChatInfoReturn.setShareUrl(wxChatInfo.getShareUrl());
			findWxChatInfoReturn.setStatus(wxChatInfo.getStatus());
			
			
			logger.debug("findWxChatInfo(FindWxChatInfo) - end - return value={}", findWxChatInfoReturn); //$NON-NLS-1$
			return findWxChatInfoReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找聊天记录信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WX_CHAT_INFO_FIND_ERROR,"查找聊天记录信息信息错误！",e);
		}


	}

	
	@Override
	public Page<FindWxChatInfoPageReturn> findWxChatInfoPage(
			FindWxChatInfoPage findWxChatInfoPage)
			throws TsfaServiceException {
		logger.debug("findWxChatInfoPage(FindWxChatInfoPage findWxChatInfoPage={}) - start", findWxChatInfoPage); //$NON-NLS-1$

		AssertUtils.notNull(findWxChatInfoPage);
		List<FindWxChatInfoPageReturn> returnList=null;
		int count = 0;
		try {
			returnList = wxChatInfoDao.findWxChatInfoPage(findWxChatInfoPage);
			//内容转码，因emoji表情无法存库，使用base64转码
			/*if(returnList!=null && returnList.size()>0){
				for (FindWxChatInfoPageReturn item : returnList) {
					item.setContent(new String(Base64.decode2(item.getContent())));
				}
			}*/
			count = wxChatInfoDao.findWxChatInfoPageCount(findWxChatInfoPage);
		}  catch (Exception e) {
			logger.error("聊天记录信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.WX_CHAT_INFO_FIND_PAGE_ERROR,"聊天记录信息不存在错误.！",e);
		}
		Page<FindWxChatInfoPageReturn> returnPage = new Page<FindWxChatInfoPageReturn>(returnList, count, findWxChatInfoPage);

		logger.debug("findWxChatInfoPage(FindWxChatInfoPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	@Override
	public long getMaxChatDateByWxNo(String wxNo) {
		AssertUtils.notNull(wxNo);
		
		//根据微信号获取导购信息
		FindGuidMemberPage findGuidMemberPage = new FindGuidMemberPage();
		findGuidMemberPage.setNoWx(wxNo);
		List<FindGuidMemberPageReturn> guidMemberPageReturns= guidMemberService.findGuidMembers(findGuidMemberPage);
		if(guidMemberPageReturns==null|| guidMemberPageReturns.size()<=0){
			logger.error("导购为空！");
			throw new TsfaServiceException(ErrorCode.WX_CHAT_INFO_ADD_ERROR,"导购为空！");
		}
		FindGuidMemberPageReturn findGuidMemberPageReturn= guidMemberPageReturns.get(0);
		try {
			FindWxChatInfoPage findWxChatInfoPage =new FindWxChatInfoPage();
			findWxChatInfoPage.setMemberNo(findGuidMemberPageReturn.getMemberNo());
			findWxChatInfoPage.setSortDir(PageSortType.desc);
			List<FindWxChatInfoPageReturn> returnList = wxChatInfoDao.findWxChatInfoPage(findWxChatInfoPage);
			if(returnList!=null && returnList.size()>0){
				return Long.parseLong(returnList.get(0).getTimestamp());
			}
		}  catch (Exception e) {
			logger.error("聊天记录信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.WX_CHAT_INFO_FIND_PAGE_ERROR,"聊天记录信息不存在错误.！",e);
		}
		return  0L;
	}


	@Override
	public int uploadWxChatInfo(String paramJson) {
		AssertUtils.notNull(paramJson);
		
		try {
			JSONObject jsonObject = JSONObject.fromObject(paramJson);
			
			String noWxGM = jsonObject.getString("noWxGM");
			String memberNoGuid = null;
			if(jsonObject.containsKey("memberNoGuid"))
				 memberNoGuid = jsonObject.getString("memberNoGuid");//导购编号
			JSONArray data = jsonObject.getJSONArray("data");
			
			for (int i = 0; i < data.size(); i++) {
				JSONObject info = null;
				try {
					info = data.getJSONObject(i);
					AddWxChatInfo addWxChatInfo= new AddWxChatInfo();
					addWxChatInfo.setMemberNo(memberNoGuid);
					addWxChatInfo.setNoWx(noWxGM);
					addWxChatInfo.setMsgsvrid(info.getString("msgSvrId"));
					addWxChatInfo.setType(info.getString("type"));
					addWxChatInfo.setIssend(info.getString("isSend"));
					addWxChatInfo.setChatDate(new Date(info.getLong("createTime")));
					addWxChatInfo.setTalker(info.getString("talker"));
					
					String content = info.containsKey("content")?info.getString("content"):"";
					/*String base64Str = Base64.encodeBase64String(content.getBytes());
					addWxChatInfo.setContent(base64Str);*/
					addWxChatInfo.setContent(content);
					
					addWxChatInfo.setTimestamp(info.getString("createTime"));
//				addWxChatInfo.setResourcesPath(info.getString("content"));
					addWxChatInfo.setStatus(info.containsKey("status")?info.getString("status"):null);
					//分享
					if(info.getString("type").equals("49")){
						addWxChatInfo.setShareTitle(info.getString("shareTitle"));
						addWxChatInfo.setShareDes(info.getString("shareDes"));
						addWxChatInfo.setShareUrl(info.getString("shareUrl"));
					}
					this.addWxChatInfo(addWxChatInfo);
				} catch (Exception e) {
					if(info != null)
						logger.error("【聊天记录上传】info:"+info.toString());
					logger.error("【聊天记录上传】聊天记录上传错误",e);
				}
			}
		} catch (Exception e) {
			logger.error("【聊天记录上传】聊天记录上传错误",e);
			throw new TsfaServiceException(ErrorCode.WX_COMMENT_INFO_ADD_ERROR,"聊天记录上传错误！",e);
		}
		return 0;
	}


	@Override
	public Page<Map<String, String>> findWxChatInfoPageOMS(
			Map<String, Object> parmMap) {
		
		logger.debug("findWxChatInfoPageOMS(parmMap={}) - start", parmMap); //$NON-NLS-1$

		AssertUtils.notNull(parmMap);
		AssertUtils.notNull(parmMap.get("start"));
		AssertUtils.notNull(parmMap.get("limit"));
		List<Map<String, String>> returnList=null;
		int count = 0;
		try {
			returnList = wxChatInfoDao.findWxChatInfoPageOMS(parmMap);
			//内容转码，因emoji表情无法存库，使用base64转码
			/*if(returnList!=null && returnList.size()>0){
				for (Map<String, String> item : returnList) {
					item.put("CONTENT", new String(Base64.decode2(item.get("CONTENT"))));
				}
			}*/
			count = wxChatInfoDao.findWxChatInfoPageCountOMS(parmMap).size();
		}  catch (Exception e) {
			logger.error("聊天记录信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.WX_CHAT_INFO_FIND_PAGE_ERROR,"聊天记录信息不存在错误.！",e);
		}
		Page<Map<String, String>> returnPage = new Page<Map<String, String>>(returnList, count,Integer.parseInt(parmMap.get("start").toString()) , Integer.parseInt(parmMap.get("limit").toString()));
		logger.debug("findWxChatInfoPageOMS(parmMap) - end - return value={}", returnList); //$NON-NLS-1$
		return  returnPage;
	}


	@Override
	public int findWxChantInfoCountTime(FindWxChatInfo findWxChatInfo) {
		AssertUtils.notNull(findWxChatInfo);
		AssertUtils.notAllNull(findWxChatInfo.getMemberNo(),"导购编号不能为空！");
		int count=0;
		try {
			count=wxChatInfoDao.findWxChantInfoCountTime(findWxChatInfo);
		} catch (Exception e) {
			logger.error("统计聊天记录信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.WX_CHAT_INFO_FIND_PAGE_ERROR,"统计聊天记录信息错误.！",e);
		}
		return count;
	}


	@Override
	public List<Map<String, Object>> findCountWxChat(
			Map<String, Object> map) {
		logger.debug("findCountWxChat(Map<String, Object> map={}) - start", map); //$NON-NLS-1$
		FindShop findShop = new FindShop();
		findShop.setMemberNoMerchant(map.get("merchantNo").toString());
		List<FindShopPageReturn> shops = shopService.findShops(findShop);
		
		List<Map<String, Object>> returnData = new ArrayList<>();
		
		for (FindShopPageReturn findShopPageReturn : shops) {
			
			FindGuidMemberDto findGuidMemberDto = new FindGuidMemberDto();
			findGuidMemberDto.setMerchantNo(findShopPageReturn.getMemberNoMerchant());
			findGuidMemberDto.setShopNo(findShopPageReturn.getShopNo());
			List<GuidMemberReturnDto> guidMemberList = guidMemberService.findGuidMemberList(findGuidMemberDto);
			List<String> memberNoGms = new ArrayList<>();
			for (GuidMemberReturnDto guidMember : guidMemberList) {
				memberNoGms.add(guidMember.getMemberNo());
			}
			map.put("memberNoGms", memberNoGms);
			int numWeChat = wxChatInfoDao.findCountWxChat(map);
			
			Map<String, Object> shopData = new HashMap<>();
			shopData.put("shopNo", findShopPageReturn.getShopNo());
			shopData.put("shopName", findShopPageReturn.getShopName());
			shopData.put("numWeChat", numWeChat);
			
			returnData.add(shopData);
		}
		return returnData;
	}



}
