package com.lj.business.cf.service.impl;

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
import com.lj.base.exception.TsfaContextServiceException;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.IComTaskListDao;
import com.lj.business.cf.domain.ComTaskList;
import com.lj.business.cf.dto.comTaskList.AddComTaskListDto;
import com.lj.business.cf.dto.comTaskList.ComTaskListReturnDto;
import com.lj.business.cf.dto.comTaskList.EditComTaskListDto;
import com.lj.business.cf.dto.comTaskList.FindComTaskList;
import com.lj.business.cf.dto.comTaskList.FindComTaskListPageDto;
import com.lj.business.cf.dto.comTaskList.FindComTaskListReturn;
import com.lj.business.cf.service.IComTaskListService;


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
public class ComTaskListServiceImpl implements IComTaskListService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ComTaskListServiceImpl.class);
	

	/** The com task list dao. */
	@Resource
	private IComTaskListDao comTaskListDao;
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskListService#addComTaskList(com.lj.business.cf.dto.AddComTaskListDto)
	 */
	
	@Override
	public void addComTaskList(AddComTaskListDto addComTaskListDto) throws TsfaServiceException {
		AssertUtils.notNull(addComTaskListDto);
		//AssertUtils.notNullAndEmpty(addComTaskListDto.getCode(),"CODE不能为空");
		try {
			
			ComTaskList comTaskList = new ComTaskList();			
			comTaskList.setCode(GUID.getPreUUID());
			comTaskList.setMerchantNo(addComTaskListDto.getMerchantNo());
			comTaskList.setNameList(addComTaskListDto.getNameList());
			comTaskList.setComTaskType(addComTaskListDto.getComTaskType());
			comTaskList.setDesList(addComTaskListDto.getDesList());
			comTaskList.setStatus(addComTaskListDto.getStatus());
			comTaskListDao.addComTaskList(comTaskList);
		} catch (TsfaContextServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户沟通任务事项表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.COMTASKLIST_ADD_ERROR,"新增客户沟通任务事项表信息错误！",e);
		}
		
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskListService#editComTaskList(com.lj.business.cf.dto.EditComTaskListDto)
	 */
	
	@Override
	public void editComTaskList(EditComTaskListDto editComTaskListDto) {
		AssertUtils.notNull(editComTaskListDto);
		AssertUtils.notNullAndEmpty(editComTaskListDto.getCode(),"CODE不能为空");
		try {
			ComTaskList comTaskList = new ComTaskList();
			comTaskList.setCode(editComTaskListDto.getCode());
			comTaskList.setNameList(editComTaskListDto.getNameList());
			comTaskList.setComTaskType(editComTaskListDto.getComTaskType());
			comTaskList.setDesList(editComTaskListDto.getDesList());
			comTaskList.setStatus(editComTaskListDto.getStatus());
			comTaskListDao.editComTaskList(comTaskList);
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("编辑客户沟通任务事项表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.COMTASKLIST_EDIT_ERROR,"编辑客户沟通任务事项表信息错误！",e);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskListService#selectByCode(java.lang.String)
	 */
	
	@Override
	public ComTaskListReturnDto selectByCode(String code) {
		logger.debug("selectByCode(String code={}) - start", code); //$NON-NLS-1$

		try {
			ComTaskList comTaskList  = comTaskListDao.selectByCode(code);
			ComTaskListReturnDto comTaskListReturnDto = new ComTaskListReturnDto();
			comTaskListReturnDto.setCode(comTaskList.getCode());
			comTaskListReturnDto.setMerchantNo(comTaskList.getMerchantNo());
			comTaskListReturnDto.setNameList(comTaskList.getNameList());
			comTaskListReturnDto.setComTaskType(comTaskList.getComTaskType());
			comTaskListReturnDto.setDesList(comTaskList.getDesList());
			comTaskListReturnDto.setStatus(comTaskList.getStatus());
			comTaskListReturnDto.setCreateDate(comTaskList.getCreateDate());

			logger.debug("selectByCode(String) - end - return value={}", comTaskListReturnDto); //$NON-NLS-1$
			return comTaskListReturnDto;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("查找客户沟通任务事项表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.COMTASKLIST_FIND_ERROR,"查找客户沟通任务事项表信息错误！",e);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskListService#findComTaskLists(com.lj.business.cf.dto.FindComTaskListPageDto)
	 */
	
	@Override
	public List<FindComTaskListPageDto> findComTaskLists(FindComTaskListPageDto findComTaskListPageDto){
			AssertUtils.notNull(findComTaskListPageDto);
			List<FindComTaskListPageDto> returnList;
			try {
				returnList = comTaskListDao.findComTaskLists(findComTaskListPageDto);
			}  catch (Exception e) {
				logger.error("查找客户沟通任务事项表信息错误",e);
				throw new TsfaServiceException(ErrorCode.COMTASKLIST_FIND_ERROR,"查找客户沟通任务事项表信息错误.！",e);
			}
			return  returnList;
		}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskListService#findComTaskListPage(com.lj.business.cf.dto.FindComTaskListPageDto)
	 */
	
	@Override
	public Page<FindComTaskListPageDto> findComTaskListPage(FindComTaskListPageDto findComTaskListPageDto){
			logger.debug("findComTaskListPageDto(FindComTaskListPageDto findComTaskListPageDto) ) - start", findComTaskListPageDto); 

			AssertUtils.notNull(findComTaskListPageDto);
			List<FindComTaskListPageDto> returnList;
			int count = 0;
			try {
				returnList = comTaskListDao.findComTaskListPage(findComTaskListPageDto);
				count = comTaskListDao.findComTaskListPageCount(findComTaskListPageDto);
			}  catch (Exception e) {
				logger.error("客户沟通任务事项表信息分页查询错误",e);
				throw new TsfaServiceException(ErrorCode.COMTASKLIST_FIND_PAGE_ERROR,"客户沟通任务事项表信息分页查询错误.！",e);
			}
			Page<FindComTaskListPageDto> returnPage = new Page<FindComTaskListPageDto>(returnList, count, findComTaskListPageDto);

			logger.debug("findComTaskListPageDto(FindComTaskListPageDto) - end - return value={}", returnPage); 
			return  returnPage;
		}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskListService#findComTaskList(com.lj.business.cf.dto.comTaskList.FindComTaskList)
	 */
	@Override
	public FindComTaskListReturn findComTaskList(FindComTaskList findComTaskList) {
		logger.debug("findComTaskList(FindComTaskList findComTaskList={}) - start", findComTaskList); //$NON-NLS-1$
		AssertUtils.notNull(findComTaskList);
		AssertUtils.notNull(findComTaskList.getMerchantNo(),"商户编号不能为空！");
		AssertUtils.notNull(findComTaskList.getComTaskType(),"沟通任务类型不能为空！");
		/*if(ComTaskType.OTHER.equals(findComTaskList.getComTaskType()) ){
			throw new IllegalArgumentException("不支持OTHER类型的查询");
		}*/
		try {
			FindComTaskListReturn returnFindComTaskListReturn = comTaskListDao.findComTaskList(findComTaskList);
			logger.debug("findComTaskList(FindComTaskList) - end - return value={}", returnFindComTaskListReturn); //$NON-NLS-1$
			return returnFindComTaskListReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("查找客户沟通任务事项表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.COMTASKLIST_FIND_ERROR,"查找客户沟通任务事项表信息错误！",e);
		}
	
		
	}


}
