package com.lj.business.cf.service.impl;

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
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaContextServiceException;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.IWorkTaskChooseDao;
import com.lj.business.cf.domain.WorkTaskChoose;
import com.lj.business.cf.dto.workTaskChoose.AddWorkTaskChooseDto;
import com.lj.business.cf.dto.workTaskChoose.EditWorkTaskChooseDto;
import com.lj.business.cf.dto.workTaskChoose.FindWorkTaskChoose;
import com.lj.business.cf.dto.workTaskChoose.FindWorkTaskChoosePageDto;
import com.lj.business.cf.dto.workTaskChoose.WorkTaskChooseReturnDto;
import com.lj.business.cf.service.IWorkTaskChooseService;


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
public class WorkTaskChooseServiceImpl implements IWorkTaskChooseService { 
	
	/** The Work task choose dao. */
	@Resource
	private IWorkTaskChooseDao WorkTaskChooseDao;
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(WorkTaskChooseServiceImpl.class);
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskChooseService#addWorkTaskChoose(com.lj.business.cf.dto.EditWorkTaskChooseDto)
	 */
	
	@Override
	public void addWorkTaskChoose(AddWorkTaskChooseDto addWorkTaskChooseDto) {
		AssertUtils.notNull(addWorkTaskChooseDto);
		AssertUtils.notNullAndEmpty(addWorkTaskChooseDto.getMerchantNo(),"商户编号不能为空");
		try {
			
			WorkTaskChoose workTaskChoose = new WorkTaskChoose();
			workTaskChoose.setCode(GUID.getPreUUID());
			workTaskChoose.setMerchantNo(addWorkTaskChooseDto.getMerchantNo());
			workTaskChoose.setShopNo(addWorkTaskChooseDto.getShopNo());
			workTaskChoose.setShopName(addWorkTaskChooseDto.getShopName());
			workTaskChoose.setMemberNoGm(addWorkTaskChooseDto.getMemberNoGm());
			workTaskChoose.setMemberNameGm(addWorkTaskChooseDto.getMemberNameGm());
			workTaskChoose.setCodeList(addWorkTaskChooseDto.getCodeList());
			workTaskChoose.setNameList(addWorkTaskChooseDto.getNameList());
			workTaskChoose.setStatus(addWorkTaskChooseDto.getStatus());
			workTaskChoose.setFreValue(addWorkTaskChooseDto.getFreValue());
			workTaskChoose.setSeq(addWorkTaskChooseDto.getSeq());
			workTaskChoose.setTaskType(addWorkTaskChooseDto.getTaskType());
			workTaskChoose.setRemark(addWorkTaskChooseDto.getRemark());
			workTaskChoose.setRemark2(addWorkTaskChooseDto.getRemark2());
			workTaskChoose.setRemark3(addWorkTaskChooseDto.getRemark3());
			workTaskChoose.setRemark4(addWorkTaskChooseDto.getRemark4());
			WorkTaskChooseDao.addWorkTaskChoose(workTaskChoose);
		} catch (TsfaContextServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增工作事项选择表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WORKTASKCHOOSE_ADD_ERROR,"新增工作事项选择表信息错误！",e);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskChooseService#editWorkTaskChoose(com.lj.business.cf.dto.EditWorkTaskChooseDto)
	 */
	
	@Override
	public void editWorkTaskChoose(EditWorkTaskChooseDto editWorkTaskChooseDto) {
		AssertUtils.notNull(editWorkTaskChooseDto);
		AssertUtils.notNullAndEmpty(editWorkTaskChooseDto.getCode(),"CODE不能为空");
		try {
			WorkTaskChoose workTaskChoose = new WorkTaskChoose();
			workTaskChoose.setCode(GUID.getPreUUID());
			workTaskChoose.setMerchantNo(editWorkTaskChooseDto.getMerchantNo());
			workTaskChoose.setShopNo(editWorkTaskChooseDto.getShopNo());
			workTaskChoose.setShopName(editWorkTaskChooseDto.getShopName());
			workTaskChoose.setMemberNoGm(editWorkTaskChooseDto.getMemberNoGm());
			workTaskChoose.setMemberNameGm(editWorkTaskChooseDto.getMemberNameGm());
			workTaskChoose.setCodeList(editWorkTaskChooseDto.getCodeList());
			workTaskChoose.setNameList(editWorkTaskChooseDto.getNameList());
			workTaskChoose.setStatus(editWorkTaskChooseDto.getStatus());
			workTaskChoose.setFreValue(editWorkTaskChooseDto.getFreValue());
			workTaskChoose.setSeq(editWorkTaskChooseDto.getSeq());
			workTaskChoose.setRemark(editWorkTaskChooseDto.getRemark());
			workTaskChoose.setRemark2(editWorkTaskChooseDto.getRemark2());
			workTaskChoose.setRemark3(editWorkTaskChooseDto.getRemark3());
			workTaskChoose.setRemark4(editWorkTaskChooseDto.getRemark4());
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("编辑工作事项选择表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.WORKTASKCHOOSE_EDIT_ERROR,"编辑工作事项选择表信息错误！",e);
		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskChooseService#selectByCode(java.lang.String)
	 */
	
	@Override
	public WorkTaskChooseReturnDto selectByCode(EditWorkTaskChooseDto editWorkTaskChooseDto) {
		AssertUtils.notNullAndEmpty(editWorkTaskChooseDto.getCode(),"CODE不能为空");
		try {
			WorkTaskChoose workTaskChoose  = WorkTaskChooseDao.selectByCode(editWorkTaskChooseDto.getCode());
			WorkTaskChooseReturnDto workTaskChooseReturnDto = new WorkTaskChooseReturnDto();
			workTaskChooseReturnDto.setCode(workTaskChoose.getCode());
			workTaskChooseReturnDto.setMerchantNo(workTaskChoose.getMerchantNo());
			workTaskChooseReturnDto.setShopNo(workTaskChoose.getShopNo());
			workTaskChooseReturnDto.setShopName(workTaskChoose.getShopName());
			workTaskChooseReturnDto.setMemberNoGm(workTaskChoose.getMemberNoGm());
			workTaskChooseReturnDto.setMemberNameGm(workTaskChoose.getMemberNameGm());
			workTaskChooseReturnDto.setCodeList(workTaskChoose.getCodeList());
			workTaskChooseReturnDto.setNameList(workTaskChoose.getNameList());
			workTaskChooseReturnDto.setStatus(workTaskChoose.getStatus());
			workTaskChooseReturnDto.setFreValue(workTaskChoose.getFreValue());
			workTaskChooseReturnDto.setSeq(workTaskChoose.getSeq());
			workTaskChooseReturnDto.setRemark(workTaskChoose.getRemark());
			workTaskChooseReturnDto.setRemark2(workTaskChoose.getRemark2());
			workTaskChooseReturnDto.setRemark3(workTaskChoose.getRemark3());
			workTaskChooseReturnDto.setRemark4(workTaskChoose.getRemark4());
			workTaskChooseReturnDto.setCreateDate(workTaskChoose.getCreateDate());
			return workTaskChooseReturnDto;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("查找工作事项选择表信息错误",e);
			throw new TsfaServiceException(ErrorCode.WORKTASKCHOOSE_FIND_ERROR,"查找工作事项选择表信息错误！",e);
		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskChooseService#findWorkTaskChooses(com.lj.business.cf.dto.FindWorkTaskChoosePageDto)
	 */
	
	@Override
	public List<FindWorkTaskChoosePageDto> findWorkTaskChooses(FindWorkTaskChoosePageDto findWorkTaskChoosePageDto) {
		AssertUtils.notNull(findWorkTaskChoosePageDto);
		List<FindWorkTaskChoosePageDto> returnList;
		try {
			returnList = WorkTaskChooseDao.findWorkTaskChooses(findWorkTaskChoosePageDto);
		}  catch (Exception e) {
			logger.error("查找工作事项选择表信息错误",e);
			throw new TsfaServiceException(ErrorCode.WORKTASKCHOOSE_FIND_ERROR,"查找工作事项选择表信息错误.！",e);
		}
		return  returnList;
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskChooseService#findWorkTaskChoosePage(com.lj.business.cf.dto.FindWorkTaskChoosePageDto)
	 */
	
	@Override
	public Page<FindWorkTaskChoosePageDto> findWorkTaskChoosePage(FindWorkTaskChoosePageDto findWorkTaskChoosePageDto) {
		logger.debug("findWorkTaskChoosePageDto(FindWorkTaskChoosePageDto findWorkTaskChoosePageDto) ) - start", findWorkTaskChoosePageDto); 

		AssertUtils.notNull(findWorkTaskChoosePageDto);
		List<FindWorkTaskChoosePageDto> returnList;
		int count = 0;
		try {
			returnList = WorkTaskChooseDao.findWorkTaskChoosePage(findWorkTaskChoosePageDto);
			count = WorkTaskChooseDao.findWorkTaskChoosePageCount(findWorkTaskChoosePageDto);
		}  catch (Exception e) {
			logger.error("删除工作事项选择表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.WORKTASKCHOOSE_FIND_PAGE_ERROR,"删除工作事项选择表信息分页查询错误.！",e);
		}
		Page<FindWorkTaskChoosePageDto> returnPage = new Page<FindWorkTaskChoosePageDto>(returnList, count, findWorkTaskChoosePageDto);

		logger.debug("findWorkTaskChoosePageDto(FindWorkTaskChoosePageDto) - end - return value={}", returnPage); 
		return  returnPage;
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IWorkTaskChooseService#delWorkTaskChooseBymerchantNo(java.lang.String)
	 */
	
	@Override
	public int delWorkTaskChooseBymerchantNo(String merchantNo) {
		AssertUtils.notNull(merchantNo);
		int flag=0;
		try {
			flag= WorkTaskChooseDao.delWorkTaskChooseBymerchantNo(merchantNo);
		} catch (Exception e) {
			logger.error("删除工作事项选择表信息错误",e);
			throw new TsfaServiceException(ErrorCode.WORKTASKCHOOSE_DEL_ERROR,"删除工作事项选择表信息错误.！",e);
		}
		return flag;
	}

	@Override
	public List<FindWorkTaskChoosePageDto> findWorkTaskChooseByMerchantNo(List<String> merchantNoList) {
		AssertUtils.notNull(merchantNoList);
		return WorkTaskChooseDao.findWorkTaskChooseByMerchantNo(merchantNoList);
	}

	@Override
	public WorkTaskChooseReturnDto findWorkTaskChoose(
			FindWorkTaskChoose findWorkTaskChoose) {
		if(StringUtils.isEmpty(findWorkTaskChoose.getCode()) && (StringUtils.isEmpty(findWorkTaskChoose.getMerchantNo()) || StringUtils.isEmpty(findWorkTaskChoose.getTaskType())) ){
			throw new IllegalArgumentException("参数不能全部为空!");
		} 
		try {
			WorkTaskChoose workTaskChooseQuery = new WorkTaskChoose();
			workTaskChooseQuery.setCode(findWorkTaskChoose.getCode());
			workTaskChooseQuery.setMerchantNo(findWorkTaskChoose.getMerchantNo());
			workTaskChooseQuery.setTaskType(findWorkTaskChoose.getTaskType());
			WorkTaskChoose workTaskChoose  = WorkTaskChooseDao.selectParamkey(workTaskChooseQuery );
			WorkTaskChooseReturnDto workTaskChooseReturnDto = new WorkTaskChooseReturnDto();
			workTaskChooseReturnDto.setCode(workTaskChoose.getCode());
			workTaskChooseReturnDto.setMerchantNo(workTaskChoose.getMerchantNo());
			workTaskChooseReturnDto.setShopNo(workTaskChoose.getShopNo());
			workTaskChooseReturnDto.setShopName(workTaskChoose.getShopName());
			workTaskChooseReturnDto.setMemberNoGm(workTaskChoose.getMemberNoGm());
			workTaskChooseReturnDto.setMemberNameGm(workTaskChoose.getMemberNameGm());
			workTaskChooseReturnDto.setCodeList(workTaskChoose.getCodeList());
			workTaskChooseReturnDto.setNameList(workTaskChoose.getNameList());
			workTaskChooseReturnDto.setStatus(workTaskChoose.getStatus());
			workTaskChooseReturnDto.setFreValue(workTaskChoose.getFreValue());
			workTaskChooseReturnDto.setSeq(workTaskChoose.getSeq());
			workTaskChooseReturnDto.setRemark(workTaskChoose.getRemark());
			workTaskChooseReturnDto.setRemark2(workTaskChoose.getRemark2());
			workTaskChooseReturnDto.setRemark3(workTaskChoose.getRemark3());
			workTaskChooseReturnDto.setRemark4(workTaskChoose.getRemark4());
			workTaskChooseReturnDto.setCreateDate(workTaskChoose.getCreateDate());
			return workTaskChooseReturnDto;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("查找工作事项选择表信息错误",e);
			throw new TsfaServiceException(ErrorCode.WORKTASKCHOOSE_FIND_ERROR,"查找工作事项选择表信息错误！",e);
		}
	
	}

}
