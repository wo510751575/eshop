package com.lj.eshop.service.impl;

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

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.dao.ICodeCheckDao;
import com.lj.eshop.domain.CodeCheck;
import com.lj.eshop.dto.CodeCheckDto;
import com.lj.eshop.dto.FindCodeCheckPage;
import com.lj.eshop.service.ICodeCheckService;
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
 * CreateDate: 2017-08-22
 */
@Service
public class CodeCheckServiceImpl implements ICodeCheckService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(CodeCheckServiceImpl.class);
	

	@Resource
	private ICodeCheckDao codeCheckDao;
	
	
	@Override
	public void addCodeCheck(
			CodeCheckDto codeCheckDto) throws TsfaServiceException {
		logger.debug("addCodeCheck(AddCodeCheck addCodeCheck={}) - start", codeCheckDto); 

		AssertUtils.notNull(codeCheckDto);
		try {
			CodeCheck codeCheck = new CodeCheck();
			//add数据录入
			codeCheck.setCode(GUID.generateCode());
			codeCheck.setSendCode(codeCheckDto.getSendCode());
			codeCheck.setBizType(codeCheckDto.getBizType());
			codeCheck.setSendTime(new Date());
			codeCheck.setRevicerPhone(codeCheckDto.getRevicerPhone());
			codeCheckDao.insertSelective(codeCheck);
			logger.debug("addCodeCheck(CodeCheckDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增验证码信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CODE_CHECK_ADD_ERROR,"新增验证码信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询验证码信息
	 *
	 * @param findCodeCheckPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<CodeCheckDto>  findCodeChecks(FindCodeCheckPage findCodeCheckPage)throws TsfaServiceException{
		AssertUtils.notNull(findCodeCheckPage);
		List<CodeCheckDto> returnList=null;
		try {
			returnList = codeCheckDao.findCodeChecks(findCodeCheckPage);
		} catch (Exception e) {
			logger.error("查找验证码信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.CODE_CHECK_NOT_EXIST_ERROR,"验证码信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateCodeCheck(
			CodeCheckDto codeCheckDto)
			throws TsfaServiceException {
		logger.debug("updateCodeCheck(CodeCheckDto codeCheckDto={}) - start", codeCheckDto); //$NON-NLS-1$

		AssertUtils.notNull(codeCheckDto);
		AssertUtils.notNullAndEmpty(codeCheckDto.getCode(),"Code不能为空");
		try {
			CodeCheck codeCheck = new CodeCheck();
			//update数据录入
			codeCheck.setCode(codeCheckDto.getCode());
			codeCheck.setSendCode(codeCheckDto.getSendCode());
			codeCheck.setBizType(codeCheckDto.getBizType());
			codeCheck.setSendTime(codeCheckDto.getSendTime());
			codeCheck.setRevicerPhone(codeCheckDto.getRevicerPhone());
			AssertUtils.notUpdateMoreThanOne(codeCheckDao.updateByPrimaryKeySelective(codeCheck));
			logger.debug("updateCodeCheck(CodeCheckDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("验证码信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CODE_CHECK_UPDATE_ERROR,"验证码信息更新信息错误！",e);
		}
	}

	

	@Override
	public CodeCheckDto findCodeCheck(
			CodeCheckDto codeCheckDto) throws TsfaServiceException {
		logger.debug("findCodeCheck(FindCodeCheck findCodeCheck={}) - start", codeCheckDto); //$NON-NLS-1$

		AssertUtils.notNull(codeCheckDto);
		AssertUtils.notAllNull(codeCheckDto.getCode(),"Code不能为空");
		try {
			CodeCheck codeCheck = codeCheckDao.selectByPrimaryKey(codeCheckDto.getCode());
			if(codeCheck == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.CODE_CHECK_NOT_EXIST_ERROR,"验证码信息不存在");
			}
			CodeCheckDto findCodeCheckReturn = new CodeCheckDto();
			//find数据录入
			findCodeCheckReturn.setCode(codeCheck.getCode());
			findCodeCheckReturn.setSendCode(codeCheck.getSendCode());
			findCodeCheckReturn.setBizType(codeCheck.getBizType());
			findCodeCheckReturn.setSendTime(codeCheck.getSendTime());
			findCodeCheckReturn.setRevicerPhone(codeCheck.getRevicerPhone());
			
			logger.debug("findCodeCheck(CodeCheckDto) - end - return value={}", findCodeCheckReturn); //$NON-NLS-1$
			return findCodeCheckReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找验证码信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CODE_CHECK_FIND_ERROR,"查找验证码信息信息错误！",e);
		}


	}

	
	@Override
	public Page<CodeCheckDto> findCodeCheckPage(
			FindCodeCheckPage findCodeCheckPage)
			throws TsfaServiceException {
		logger.debug("findCodeCheckPage(FindCodeCheckPage findCodeCheckPage={}) - start", findCodeCheckPage); //$NON-NLS-1$

		AssertUtils.notNull(findCodeCheckPage);
		List<CodeCheckDto> returnList=null;
		int count = 0;
		try {
			returnList = codeCheckDao.findCodeCheckPage(findCodeCheckPage);
			count = codeCheckDao.findCodeCheckPageCount(findCodeCheckPage);
		}  catch (Exception e) {
			logger.error("验证码信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.CODE_CHECK_FIND_PAGE_ERROR,"验证码信息不存在错误.！",e);
		}
		Page<CodeCheckDto> returnPage = new Page<CodeCheckDto>(returnList, count, findCodeCheckPage);

		logger.debug("findCodeCheckPage(FindCodeCheckPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
