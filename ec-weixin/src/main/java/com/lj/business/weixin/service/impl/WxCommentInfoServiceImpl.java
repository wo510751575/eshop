package com.lj.business.weixin.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.encryption.Base64;
import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.weixin.constant.ErrorCode;
import com.lj.business.weixin.dao.IWxCommentInfoDao;
import com.lj.business.weixin.domain.WxCommentInfo;
import com.lj.business.weixin.dto.AddWxCommentInfo;
import com.lj.business.weixin.dto.AddWxCommentInfoReturn;
import com.lj.business.weixin.dto.FindWxCommentInfo;
import com.lj.business.weixin.dto.FindWxCommentInfoPage;
import com.lj.business.weixin.dto.FindWxCommentInfoPageReturn;
import com.lj.business.weixin.dto.FindWxCommentInfoReturn;
import com.lj.business.weixin.dto.UpdateWxCommentInfo;
import com.lj.business.weixin.dto.UpdateWxCommentInfoReturn;
import com.lj.business.weixin.service.IWxCommentInfoService;

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
public class WxCommentInfoServiceImpl implements IWxCommentInfoService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(WxCommentInfoServiceImpl.class);
	

	@Resource
	private IWxCommentInfoDao wxCommentInfoDao;
	
	/**
	 *新增朋友圈评论
	 *return addWxCommentInfoReturn
	 *@param AddWxCommentInfo
	 */
	@Override
	public AddWxCommentInfoReturn addWxCommentInfo(
			AddWxCommentInfo addWxCommentInfo) throws TsfaServiceException {
		logger.debug("addWxCommentInfo(AddWxCommentInfo addWxCommentInfo={}) - start", addWxCommentInfo); 

		AssertUtils.notNull(addWxCommentInfo);
		try {
			WxCommentInfo wxCommentInfo = new WxCommentInfo();
			//add数据录入
			wxCommentInfo.setCode(GUID.generateByUUID());
			wxCommentInfo.setCodeWfi(addWxCommentInfo.getCodeWfi());
			wxCommentInfo.setMemberNo(addWxCommentInfo.getMemberNo());
			wxCommentInfo.setMemberName(addWxCommentInfo.getMemberName());
			wxCommentInfo.setIdWx(addWxCommentInfo.getIdWx());
			wxCommentInfo.setUsername(addWxCommentInfo.getUsername());
			wxCommentInfo.setNickname(addWxCommentInfo.getNickname());
			wxCommentInfo.setTousername(addWxCommentInfo.getTousername());
			wxCommentInfo.setTonickname(addWxCommentInfo.getTonickname());
			wxCommentInfo.setContent(addWxCommentInfo.getContent());
			wxCommentInfo.setCreateDate(new Date());
			wxCommentInfoDao.insertSelective(wxCommentInfo);
			AddWxCommentInfoReturn addWxCommentInfoReturn = new AddWxCommentInfoReturn();
			
			logger.debug("addWxCommentInfo(AddWxCommentInfo) - end - return value={}", addWxCommentInfoReturn); 
			return addWxCommentInfoReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增微信朋友圈评论表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WX_COMMENT_INFO_ADD_ERROR,"新增微信朋友圈评论表信息错误！",e);
		}
	}
	
	

	@Override
	public UpdateWxCommentInfoReturn updateWxCommentInfo(
			UpdateWxCommentInfo updateWxCommentInfo)
			throws TsfaServiceException {
		logger.debug("updateWxCommentInfo(UpdateWxCommentInfo updateWxCommentInfo={}) - start", updateWxCommentInfo); //$NON-NLS-1$

		AssertUtils.notNull(updateWxCommentInfo);
		AssertUtils.notNullAndEmpty(updateWxCommentInfo.getCode(),"ID不能为空");
		try {
			WxCommentInfo wxCommentInfo = new WxCommentInfo();
			//update数据录入
			
			wxCommentInfo.setCode(updateWxCommentInfo.getCode());
			wxCommentInfo.setCodeWfi(updateWxCommentInfo.getCodeWfi());
			wxCommentInfo.setMemberNo(updateWxCommentInfo.getMemberNo());
			wxCommentInfo.setMemberName(updateWxCommentInfo.getMemberName());
			wxCommentInfo.setIdWx(updateWxCommentInfo.getIdWx());
			wxCommentInfo.setUsername(updateWxCommentInfo.getUsername());
			wxCommentInfo.setNickname(updateWxCommentInfo.getNickname());
			wxCommentInfo.setTousername(updateWxCommentInfo.getTousername());
			wxCommentInfo.setTonickname(updateWxCommentInfo.getTonickname());
			wxCommentInfo.setContent(updateWxCommentInfo.getContent());
			wxCommentInfo.setCreateDate(updateWxCommentInfo.getCreateDate());
			AssertUtils.notUpdateMoreThanOne(wxCommentInfoDao.updateByPrimaryKeySelective(wxCommentInfo));
			UpdateWxCommentInfoReturn updateWxCommentInfoReturn = new UpdateWxCommentInfoReturn();

			logger.debug("updateWxCommentInfo(UpdateWxCommentInfo) - end - return value={}", updateWxCommentInfoReturn); //$NON-NLS-1$
			return updateWxCommentInfoReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("微信朋友圈评论表信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WX_COMMENT_INFO_UPDATE_ERROR,"微信朋友圈评论表信息更新信息错误！",e);
		}
	}

	

	@Override
	public FindWxCommentInfoReturn findWxCommentInfo(
			FindWxCommentInfo findWxCommentInfo) throws TsfaServiceException {
		logger.debug("findWxCommentInfo(FindWxCommentInfo findWxCommentInfo={}) - start", findWxCommentInfo); //$NON-NLS-1$

		AssertUtils.notNull(findWxCommentInfo);
		AssertUtils.notAllNull(findWxCommentInfo.getCode(),"ID不能为空");
		try {
			WxCommentInfo wxCommentInfo = wxCommentInfoDao.selectByPrimaryKey(findWxCommentInfo.getCode());
			if(wxCommentInfo == null){
				throw new TsfaServiceException(ErrorCode.WX_COMMENT_INFO_NOT_EXIST_ERROR,"微信朋友圈评论表信息不存在");
			}
			FindWxCommentInfoReturn findWxCommentInfoReturn = new FindWxCommentInfoReturn();
			//find数据录入
			findWxCommentInfoReturn.setCode(wxCommentInfo.getCode());
			findWxCommentInfoReturn.setCodeWfi(wxCommentInfo.getCodeWfi());
			findWxCommentInfoReturn.setMemberNo(wxCommentInfo.getMemberNo());
			findWxCommentInfoReturn.setMemberName(wxCommentInfo.getMemberName());
			findWxCommentInfoReturn.setIdWx(wxCommentInfo.getIdWx());
			wxCommentInfo.setUsername(wxCommentInfo.getUsername());
			wxCommentInfo.setNickname(wxCommentInfo.getNickname());
			wxCommentInfo.setTousername(wxCommentInfo.getTousername());
			wxCommentInfo.setTonickname(wxCommentInfo.getTonickname());
			findWxCommentInfoReturn.setContent(wxCommentInfo.getContent());
			findWxCommentInfoReturn.setCreateDate(wxCommentInfo.getCreateDate());
			
			logger.debug("findWxCommentInfo(FindWxCommentInfo) - end - return value={}", findWxCommentInfoReturn); //$NON-NLS-1$
			return findWxCommentInfoReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找微信朋友圈评论表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WX_COMMENT_INFO_FIND_ERROR,"查找微信朋友圈评论表信息信息错误！",e);
		}


	}

	
	@Override
	public Page<FindWxCommentInfoPageReturn> findWxCommentInfoPage(
			FindWxCommentInfoPage findWxCommentInfoPage)
			throws TsfaServiceException {
		logger.debug("findWxCommentInfoPage(FindWxCommentInfoPage findWxCommentInfoPage={}) - start", findWxCommentInfoPage); //$NON-NLS-1$

		AssertUtils.notNull(findWxCommentInfoPage);
		List<FindWxCommentInfoPageReturn> returnList;
		int count = 0;
		try {
			returnList = wxCommentInfoDao.findWxCommentInfoPage(findWxCommentInfoPage);
			count = wxCommentInfoDao.findWxCommentInfoPageCount(findWxCommentInfoPage);
		}  catch (Exception e) {
			logger.error("微信朋友圈评论表信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.WX_COMMENT_INFO_FIND_PAGE_ERROR,"微信朋友圈评论表信息不存在错误.！",e);
		}
		Page<FindWxCommentInfoPageReturn> returnPage = new Page<FindWxCommentInfoPageReturn>(returnList, count, findWxCommentInfoPage);

		logger.debug("findWxCommentInfoPage(FindWxCommentInfoPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}



	@Override
	public List<FindWxCommentInfoPageReturn> findWxCommentInfos(
			FindWxCommentInfoPage findWxCommentInfoPage)
			throws TsfaServiceException {
		logger.debug("findWxCommentInfos(findWxCommentInfos findWxCommentInfoPage={}) - start", findWxCommentInfoPage); //$NON-NLS-1$

		AssertUtils.notNull(findWxCommentInfoPage);
		List<FindWxCommentInfoPageReturn> returnList=null;
		try {
			returnList = wxCommentInfoDao.findWxCommentInfos(findWxCommentInfoPage);
			//内容转码，因emoji表情无法存库，使用base64转码
			/*if(returnList!=null && returnList.size()>0){
				for (FindWxCommentInfoPageReturn item : returnList) {
					item.setContent(new String(Base64.decode2(item.getContent())));
					item.setNickname(new String(Base64.decode2(item.getNickname())));
					item.setTonickname(new String(Base64.decode2(item.getTonickname())));
				}
			}*/
		}  catch (Exception e) {
			logger.error("微信朋友圈评论表信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.WX_COMMENT_INFO_FIND_PAGE_ERROR,"微信朋友圈评论表信息不存在错误.！",e);
		}
		logger.debug("findWxCommentInfos(FindWxCommentInfoPage) - end - return value={}", returnList); //$NON-NLS-1$
		return  returnList;
	} 


}
