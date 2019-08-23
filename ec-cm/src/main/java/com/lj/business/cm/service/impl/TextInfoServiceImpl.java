package com.lj.business.cm.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cm.constant.ErrorCode;
import com.lj.business.cm.dao.ITextInfoDao;
import com.lj.business.cm.domain.TextInfo;
import com.lj.business.cm.dto.textInfo.AddTextInfo;
import com.lj.business.cm.dto.textInfo.DelTextInfo;
import com.lj.business.cm.dto.textInfo.FindTextInfo;
import com.lj.business.cm.dto.textInfo.FindTextInfoPage;
import com.lj.business.cm.dto.textInfo.FindTextInfoPageReturn;
import com.lj.business.cm.dto.textInfo.FindTextInfoReturn;
import com.lj.business.cm.dto.textInfo.UpdateTextInfo;
import com.lj.business.cm.service.ITextInfoService;

/**
 * 类说明：实现类
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
@Service
public class TextInfoServiceImpl implements ITextInfoService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(TextInfoServiceImpl.class);
	

	/** The text info dao. */
	@Resource
	private ITextInfoDao textInfoDao;
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cm.service.ITextInfoService#addTextInfo(com.lj.business.cm.dto.textInfo.AddTextInfo)
	 */
	@Override
	public void addTextInfo(
			AddTextInfo addTextInfo) throws TsfaServiceException {
		logger.debug("addTextInfo(AddTextInfo addTextInfo={}) - start", addTextInfo); 

		AssertUtils.notNull(addTextInfo);
		try {
			TextInfo textInfo = new TextInfo();
			//add数据录入
			textInfo.setCode(GUID.generateCode());
			textInfo.setMerchantNo(addTextInfo.getMerchantNo());
			textInfo.setMerchantName(addTextInfo.getMerchantName());
			textInfo.setTextType(addTextInfo.getTextType());
			textInfo.setContent(addTextInfo.getContent());
			textInfo.setDimStart(addTextInfo.getDimStart());
			textInfo.setDimEnd(addTextInfo.getDimEnd());
			textInfo.setDimKeyWord(addTextInfo.getDimKeyWord());
			textInfoDao.insert(textInfo);
			logger.debug("addTextInfo(AddTextInfo) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增话术信息表错误！",e);
			throw new TsfaServiceException(ErrorCode.TEXT_INFO_ADD_ERROR,"新增话术信息表错误！",e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cm.service.ITextInfoService#delTextInfo(com.lj.business.cm.dto.textInfo.DelTextInfo)
	 */
	@Override
	public void delTextInfo(
			DelTextInfo delTextInfo) throws TsfaServiceException {
		logger.debug("delTextInfo(DelTextInfo delTextInfo={}) - start", delTextInfo); 

		AssertUtils.notNull(delTextInfo);
		AssertUtils.notNull(delTextInfo.getCode(),"Code不能为空！");
		try {
			textInfoDao.deleteByPrimaryKey(delTextInfo.getCode());
			logger.debug("delTextInfo(DelTextInfo) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除话术信息表错误！",e);
			throw new TsfaServiceException(ErrorCode.TEXT_INFO_DEL_ERROR,"删除话术信息表错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cm.service.ITextInfoService#updateTextInfo(com.lj.business.cm.dto.textInfo.UpdateTextInfo)
	 */
	@Override
	public void updateTextInfo(
			UpdateTextInfo updateTextInfo)
			throws TsfaServiceException {
		logger.debug("updateTextInfo(UpdateTextInfo updateTextInfo={}) - start", updateTextInfo); //$NON-NLS-1$

		AssertUtils.notNull(updateTextInfo);
		AssertUtils.notNullAndEmpty(updateTextInfo.getCode(),"Code不能为空");
		try {
			TextInfo textInfo = new TextInfo();
			//update数据录入
			textInfo.setCode(updateTextInfo.getCode());
			textInfo.setMerchantNo(updateTextInfo.getMerchantNo());
			textInfo.setMerchantName(updateTextInfo.getMerchantName());
			textInfo.setTextType(updateTextInfo.getTextType());
			textInfo.setContent(updateTextInfo.getContent());
			textInfo.setDimStart(updateTextInfo.getDimStart());
			textInfo.setDimEnd(updateTextInfo.getDimEnd());
			textInfo.setDimKeyWord(updateTextInfo.getDimKeyWord());
			AssertUtils.notUpdateMoreThanOne(textInfoDao.updateByPrimaryKeySelective(textInfo));
			logger.debug("updateTextInfo(UpdateTextInfo) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("话术信息表更新错误！",e);
			throw new TsfaServiceException(ErrorCode.TEXT_INFO_UPDATE_ERROR,"话术信息表更新错误！",e);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.lj.business.cm.service.ITextInfoService#findTextInfo(com.lj.business.cm.dto.textInfo.FindTextInfo)
	 */
	@Override
	public FindTextInfoReturn findTextInfo(
			FindTextInfo findTextInfo) throws TsfaServiceException {
		logger.debug("findTextInfo(FindTextInfo findTextInfo={}) - start", findTextInfo); //$NON-NLS-1$

		AssertUtils.notNull(findTextInfo);
		AssertUtils.notAllNull(findTextInfo.getCode(),"Code不能为空");
		try {
			TextInfo textInfo = textInfoDao.selectByPrimaryKey(findTextInfo.getCode());
			if(textInfo == null){
				throw new TsfaServiceException(ErrorCode.TEXT_INFO_NOT_EXIST_ERROR,"话术信息表不存在");
			}
			FindTextInfoReturn findTextInfoReturn = new FindTextInfoReturn();
			//find数据录入
			findTextInfoReturn.setCode(textInfo.getCode());
			findTextInfoReturn.setMerchantNo(textInfo.getMerchantNo());
			findTextInfoReturn.setMerchantName(textInfo.getMerchantName());
			findTextInfoReturn.setTextType(textInfo.getTextType());
			findTextInfoReturn.setContent(textInfo.getContent());
			findTextInfoReturn.setDimStart(textInfo.getDimStart());
			findTextInfoReturn.setDimEnd(textInfo.getDimEnd());
			findTextInfoReturn.setDimKeyWord(textInfo.getDimKeyWord());
			findTextInfoReturn.setCreateDate(textInfo.getCreateDate());
			
			logger.debug("findTextInfo(FindTextInfo) - end - return value={}", findTextInfoReturn); //$NON-NLS-1$
			return findTextInfoReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找话术信息表错误！",e);
			throw new TsfaServiceException(ErrorCode.TEXT_INFO_FIND_ERROR,"查找话术信息表错误！",e);
		}


	}

	
	/* (non-Javadoc)
	 * @see com.lj.business.cm.service.ITextInfoService#findTextInfoPage(com.lj.business.cm.dto.textInfo.FindTextInfoPage)
	 */
	@Override
	public Page<FindTextInfoPageReturn> findTextInfoPage(
			FindTextInfoPage findTextInfoPage)
			throws TsfaServiceException {
		logger.debug("findTextInfoPage(FindTextInfoPage findTextInfoPage={}) - start", findTextInfoPage); //$NON-NLS-1$

		AssertUtils.notNull(findTextInfoPage);
		List<FindTextInfoPageReturn> returnList;
		int count = 0;
		try {
			returnList = textInfoDao.findTextInfoPage(findTextInfoPage);
			count = textInfoDao.findTextInfoPageCount(findTextInfoPage);
		}  catch (Exception e) {
			logger.error("话术信息表分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.TEXT_INFO_FIND_PAGE_ERROR,"话术信息表分页查询错误.！",e);
		}
		Page<FindTextInfoPageReturn> returnPage = new Page<FindTextInfoPageReturn>(returnList, count, findTextInfoPage);

		logger.debug("findTextInfoPage(FindTextInfoPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	@Override
	public FindTextInfoPageReturn findTextInfoReturnContent(
			FindTextInfo findTextInfo) {
		AssertUtils.notNull(findTextInfo);
		AssertUtils.notNullAndEmpty(findTextInfo.getMerchantNo(),"商户号不能为空");
		AssertUtils.notNullAndEmpty(findTextInfo.getTextType(),"类型不能为空");
		FindTextInfoPageReturn findTextInfoPageReturn=null;
		try {
			findTextInfoPageReturn=textInfoDao.findTextInfoReturnContent(findTextInfo);
		} catch (Exception e) {
			logger.error("话术信息表分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.TEXT_INFO_FIND_PAGE_ERROR,"话术信息表分页查询错误.！",e);
		}
		return findTextInfoPageReturn;
	} 


}
