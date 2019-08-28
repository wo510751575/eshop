package com.lj.eshop.service.impl;

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
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.dao.IMarkSolutionDao;
import com.lj.eshop.domain.MarkSolution;
import com.lj.eshop.dto.FindMarkSolutionPage;
import com.lj.eshop.dto.MarkSolutionDto;
import com.lj.eshop.service.IMarkSolutionService;
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
public class MarkSolutionServiceImpl implements IMarkSolutionService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(MarkSolutionServiceImpl.class);
	

	@Resource
	private IMarkSolutionDao markSolutionDao;
	
	
	@Override
	public void addMarkSolution(
			MarkSolutionDto markSolutionDto) throws TsfaServiceException {
		logger.debug("addMarkSolution(AddMarkSolution addMarkSolution={}) - start", markSolutionDto); 

		AssertUtils.notNull(markSolutionDto);
		try {
			MarkSolution markSolution = new MarkSolution();
			//add数据录入
			markSolution.setCode(GUID.generateCode());
			markSolution.setAmt(markSolutionDto.getAmt());
			markSolution.setMyPower(markSolutionDto.getMyPower());
			markSolution.setDetail(markSolutionDto.getDetail());
			markSolution.setStatus(markSolutionDto.getStatus());
			markSolution.setCreateTime(markSolutionDto.getCreateTime());
			markSolutionDao.insertSelective(markSolution);
			logger.debug("addMarkSolution(MarkSolutionDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增以租代购信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MARK_SOLUTION_ADD_ERROR,"新增以租代购信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询以租代购信息
	 *
	 * @param findMarkSolutionPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<MarkSolutionDto>  findMarkSolutions(FindMarkSolutionPage findMarkSolutionPage)throws TsfaServiceException{
		AssertUtils.notNull(findMarkSolutionPage);
		List<MarkSolutionDto> returnList=null;
		try {
			returnList = markSolutionDao.findMarkSolutions(findMarkSolutionPage);
		} catch (Exception e) {
			logger.error("查找以租代购信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MARK_SOLUTION_NOT_EXIST_ERROR,"以租代购信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateMarkSolution(
			MarkSolutionDto markSolutionDto)
			throws TsfaServiceException {
		logger.debug("updateMarkSolution(MarkSolutionDto markSolutionDto={}) - start", markSolutionDto); //$NON-NLS-1$

		AssertUtils.notNull(markSolutionDto);
		AssertUtils.notNullAndEmpty(markSolutionDto.getCode(),"Code不能为空");
		try {
			MarkSolution markSolution = new MarkSolution();
			//update数据录入
			markSolution.setCode(markSolutionDto.getCode());
			markSolution.setAmt(markSolutionDto.getAmt());
			markSolution.setMyPower(markSolutionDto.getMyPower());
			markSolution.setDetail(markSolutionDto.getDetail());
			markSolution.setStatus(markSolutionDto.getStatus());
			markSolution.setCreateTime(markSolutionDto.getCreateTime());
			AssertUtils.notUpdateMoreThanOne(markSolutionDao.updateByPrimaryKeySelective(markSolution));
			logger.debug("updateMarkSolution(MarkSolutionDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("以租代购信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MARK_SOLUTION_UPDATE_ERROR,"以租代购信息更新信息错误！",e);
		}
	}

	

	@Override
	public MarkSolutionDto findMarkSolution(
			MarkSolutionDto markSolutionDto) throws TsfaServiceException {
		logger.debug("findMarkSolution(FindMarkSolution findMarkSolution={}) - start", markSolutionDto); //$NON-NLS-1$

		AssertUtils.notNull(markSolutionDto);
		AssertUtils.notAllNull(markSolutionDto.getCode(),"Code不能为空");
		try {
			MarkSolution markSolution = markSolutionDao.selectByPrimaryKey(markSolutionDto.getCode());
			if(markSolution == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.MARK_SOLUTION_NOT_EXIST_ERROR,"以租代购信息不存在");
			}
			MarkSolutionDto findMarkSolutionReturn = new MarkSolutionDto();
			//find数据录入
			findMarkSolutionReturn.setCode(markSolution.getCode());
			findMarkSolutionReturn.setAmt(markSolution.getAmt());
			findMarkSolutionReturn.setMyPower(markSolution.getMyPower());
			findMarkSolutionReturn.setDetail(markSolution.getDetail());
			findMarkSolutionReturn.setStatus(markSolution.getStatus());
			findMarkSolutionReturn.setCreateTime(markSolution.getCreateTime());
			
			logger.debug("findMarkSolution(MarkSolutionDto) - end - return value={}", findMarkSolutionReturn); //$NON-NLS-1$
			return findMarkSolutionReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找以租代购信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MARK_SOLUTION_FIND_ERROR,"查找以租代购信息信息错误！",e);
		}


	}

	
	@Override
	public Page<MarkSolutionDto> findMarkSolutionPage(
			FindMarkSolutionPage findMarkSolutionPage)
			throws TsfaServiceException {
		logger.debug("findMarkSolutionPage(FindMarkSolutionPage findMarkSolutionPage={}) - start", findMarkSolutionPage); //$NON-NLS-1$

		AssertUtils.notNull(findMarkSolutionPage);
		List<MarkSolutionDto> returnList=null;
		int count = 0;
		try {
			returnList = markSolutionDao.findMarkSolutionPage(findMarkSolutionPage);
			count = markSolutionDao.findMarkSolutionPageCount(findMarkSolutionPage);
		}  catch (Exception e) {
			logger.error("以租代购信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.MARK_SOLUTION_FIND_PAGE_ERROR,"以租代购信息不存在错误.！",e);
		}
		Page<MarkSolutionDto> returnPage = new Page<MarkSolutionDto>(returnList, count, findMarkSolutionPage);

		logger.debug("findMarkSolutionPage(FindMarkSolutionPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
