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
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.IClientKeepSummaryDao;
import com.lj.business.cf.domain.ClientKeepSummary;
import com.lj.business.cf.dto.clientKeepSummary.AddClientKeepSummary;
import com.lj.business.cf.dto.clientKeepSummary.DelClientKeepSummary;
import com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummary;
import com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummaryPage;
import com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummaryPageReturn;
import com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummaryReturn;
import com.lj.business.cf.dto.clientKeepSummary.UpdateClientKeepSummary;
import com.lj.business.cf.service.IClientKeepSummaryService;

/**
 * 类说明：实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 冯辉
 * 
 * 
 * CreateDate: 2017-06-14
 */
@Service
public class ClientKeepSummaryServiceImpl implements IClientKeepSummaryService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ClientKeepSummaryServiceImpl.class);
	

	/** The client keep summary dao. */
	@Resource
	private IClientKeepSummaryDao clientKeepSummaryDao;
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientKeepSummaryService#addClientKeepSummary(com.lj.business.cf.dto.clientKeepSummary.AddClientKeepSummary)
	 */
	@Override
	public String addClientKeepSummary(
			AddClientKeepSummary addClientKeepSummary) throws TsfaServiceException {
		logger.debug("addClientKeepSummary(AddClientKeepSummary addClientKeepSummary={}) - start", addClientKeepSummary); 

		AssertUtils.notNull(addClientKeepSummary);
		String ret = "";
		try {
			ClientKeepSummary clientKeepSummary = new ClientKeepSummary();
			//add数据录入
			clientKeepSummary.setCode(GUID.getPreUUID());
			clientKeepSummary.setCkNo(GUID.generateByUUID());
			clientKeepSummary.setMerchantNo(addClientKeepSummary.getMerchantNo());
			clientKeepSummary.setMemberNo(addClientKeepSummary.getMemberNo());
			clientKeepSummary.setMemberName(addClientKeepSummary.getMemberName());
			clientKeepSummary.setMemberNoGm(addClientKeepSummary.getMemberNoGm());
			clientKeepSummary.setMemberNameGm(addClientKeepSummary.getMemberNameGm());
			clientKeepSummary.setKeepNum(addClientKeepSummary.getKeepNum());
			clientKeepSummary.setBuy(addClientKeepSummary.getBuy());
			clientKeepSummary.setBomCode(addClientKeepSummary.getBomCode());
			clientKeepSummary.setBomName(addClientKeepSummary.getBomName());
			clientKeepSummary.setStartDate(addClientKeepSummary.getStartDate());
			clientKeepSummary.setEndDate(addClientKeepSummary.getEndDate());
			clientKeepSummary.setRemark(addClientKeepSummary.getRemark());
			clientKeepSummary.setCreateId(addClientKeepSummary.getCreateId());
			clientKeepSummary.setRemark4(addClientKeepSummary.getRemark4());
			clientKeepSummary.setRemark3(addClientKeepSummary.getRemark3());
			clientKeepSummary.setRemark2(addClientKeepSummary.getRemark2());
			
			ret = clientKeepSummary.getCkNo();
			clientKeepSummaryDao.insert(clientKeepSummary);
			logger.debug("addClientKeepSummary(AddClientKeepSummary) - end - return:" + ret); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户维护记录总表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_KEEP_SUMMARY_ADD_ERROR,"新增客户维护记录总表信息错误！",e);
		}
		return ret;
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientKeepSummaryService#delClientKeepSummary(com.lj.business.cf.dto.clientKeepSummary.DelClientKeepSummary)
	 */
	@Override
	public void delClientKeepSummary(
			DelClientKeepSummary delClientKeepSummary) throws TsfaServiceException {
		logger.debug("delClientKeepSummary(DelClientKeepSummary delClientKeepSummary={}) - start", delClientKeepSummary); 

		AssertUtils.notNull(delClientKeepSummary);
		AssertUtils.notNull(delClientKeepSummary.getCode(),"Code不能为空！");
		try {
			clientKeepSummaryDao.deleteByPrimaryKey(delClientKeepSummary.getCode());
			logger.debug("delClientKeepSummary(DelClientKeepSummary) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除客户维护记录总表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_KEEP_SUMMARY_DEL_ERROR,"删除客户维护记录总表信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientKeepSummaryService#updateClientKeepSummary(com.lj.business.cf.dto.clientKeepSummary.UpdateClientKeepSummary)
	 */
	@Override
	public void updateClientKeepSummary(
			UpdateClientKeepSummary updateClientKeepSummary)
			throws TsfaServiceException {
		logger.debug("updateClientKeepSummary(UpdateClientKeepSummary updateClientKeepSummary={}) - start", updateClientKeepSummary); //$NON-NLS-1$

		AssertUtils.notNull(updateClientKeepSummary);
		AssertUtils.notNullAndEmpty(updateClientKeepSummary.getCode(),"Code不能为空");
		try {
			ClientKeepSummary clientKeepSummary = new ClientKeepSummary();
			//update数据录入
			clientKeepSummary.setCode(updateClientKeepSummary.getCode());
			clientKeepSummary.setMerchantNo(updateClientKeepSummary.getMerchantNo());
			clientKeepSummary.setMemberNo(updateClientKeepSummary.getMemberNo());
			clientKeepSummary.setMemberName(updateClientKeepSummary.getMemberName());
			clientKeepSummary.setMemberNoGm(updateClientKeepSummary.getMemberNoGm());
			clientKeepSummary.setMemberNameGm(updateClientKeepSummary.getMemberNameGm());
			clientKeepSummary.setCkNo(updateClientKeepSummary.getCkNo());
			clientKeepSummary.setKeepNum(updateClientKeepSummary.getKeepNum());
			clientKeepSummary.setBuy(updateClientKeepSummary.getBuy());
			clientKeepSummary.setBomCode(updateClientKeepSummary.getBomCode());
			clientKeepSummary.setBomName(updateClientKeepSummary.getBomName());
			clientKeepSummary.setStartDate(updateClientKeepSummary.getStartDate());
			clientKeepSummary.setEndDate(updateClientKeepSummary.getEndDate());
			clientKeepSummary.setRemark(updateClientKeepSummary.getRemark());
			clientKeepSummary.setCreateId(updateClientKeepSummary.getCreateId());
			clientKeepSummary.setCreateDate(updateClientKeepSummary.getCreateDate());
			clientKeepSummary.setRemark4(updateClientKeepSummary.getRemark4());
			clientKeepSummary.setRemark3(updateClientKeepSummary.getRemark3());
			clientKeepSummary.setRemark2(updateClientKeepSummary.getRemark2());
			AssertUtils.notUpdateMoreThanOne(clientKeepSummaryDao.updateByPrimaryKeySelective(clientKeepSummary));
			logger.debug("updateClientKeepSummary(UpdateClientKeepSummary) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户维护记录总表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_KEEP_SUMMARY_UPDATE_ERROR,"客户维护记录总表信息更新错误！",e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientKeepSummaryService#updateByCkNo(com.lj.business.cf.dto.clientKeepSummary.UpdateClientKeepSummary)
	 */
	@Override
	public void updateByCkNo(UpdateClientKeepSummary updateClientKeepSummary) throws TsfaServiceException {
		logger.debug("updateByCkNo(UpdateClientKeepSummary updateClientKeepSummary={}) - start", updateClientKeepSummary); //$NON-NLS-1$

		AssertUtils.notNull(updateClientKeepSummary);
		AssertUtils.notNullAndEmpty(updateClientKeepSummary.getCkNo(),"ckNo不能为空");
		try {
			ClientKeepSummary clientKeepSummary = new ClientKeepSummary();
			//update数据录入
			clientKeepSummary.setCode(updateClientKeepSummary.getCode());
			clientKeepSummary.setMerchantNo(updateClientKeepSummary.getMerchantNo());
			clientKeepSummary.setMemberNo(updateClientKeepSummary.getMemberNo());
			clientKeepSummary.setMemberName(updateClientKeepSummary.getMemberName());
			clientKeepSummary.setMemberNoGm(updateClientKeepSummary.getMemberNoGm());
			clientKeepSummary.setMemberNameGm(updateClientKeepSummary.getMemberNameGm());
			clientKeepSummary.setCkNo(updateClientKeepSummary.getCkNo());
			clientKeepSummary.setKeepNum(updateClientKeepSummary.getKeepNum());
			clientKeepSummary.setBuy(updateClientKeepSummary.getBuy());
			clientKeepSummary.setBomCode(updateClientKeepSummary.getBomCode());
			clientKeepSummary.setBomName(updateClientKeepSummary.getBomName());
			clientKeepSummary.setStartDate(updateClientKeepSummary.getStartDate());
			clientKeepSummary.setEndDate(updateClientKeepSummary.getEndDate());
			clientKeepSummary.setRemark(updateClientKeepSummary.getRemark());
			clientKeepSummary.setCreateId(updateClientKeepSummary.getCreateId());
			clientKeepSummary.setCreateDate(updateClientKeepSummary.getCreateDate());
			clientKeepSummary.setRemark4(updateClientKeepSummary.getRemark4());
			clientKeepSummary.setRemark3(updateClientKeepSummary.getRemark3());
			clientKeepSummary.setRemark2(updateClientKeepSummary.getRemark2());
			AssertUtils.notUpdateMoreThanOne(clientKeepSummaryDao.updateByCkNoSelective(clientKeepSummary));
			logger.debug("updateByCkNo(UpdateClientKeepSummary) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户维护记录总表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_KEEP_SUMMARY_UPDATE_ERROR,"客户维护记录总表信息更新错误！",e);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientKeepSummaryService#findClientKeepSummary(com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummary)
	 */
	@Override
	public FindClientKeepSummaryReturn findClientKeepSummary(
			FindClientKeepSummary findClientKeepSummary) throws TsfaServiceException {
		logger.debug("findClientKeepSummary(FindClientKeepSummary findClientKeepSummary={}) - start", findClientKeepSummary); //$NON-NLS-1$

		AssertUtils.notNull(findClientKeepSummary);
		AssertUtils.notAllNull(findClientKeepSummary.getCode(),"Code不能为空");
		try {
			ClientKeepSummary clientKeepSummary = clientKeepSummaryDao.selectByPrimaryKey(findClientKeepSummary.getCode());
			if(clientKeepSummary == null){
				throw new TsfaServiceException(ErrorCode.CLIENT_KEEP_SUMMARY_NOT_EXIST_ERROR,"反馈信息信息不存在");
			}
			FindClientKeepSummaryReturn findClientKeepSummaryReturn = new FindClientKeepSummaryReturn();
			//find数据录入
			findClientKeepSummaryReturn.setCode(clientKeepSummary.getCode());
			findClientKeepSummaryReturn.setMerchantNo(clientKeepSummary.getMerchantNo());
			findClientKeepSummaryReturn.setMemberNo(clientKeepSummary.getMemberNo());
			findClientKeepSummaryReturn.setMemberName(clientKeepSummary.getMemberName());
			findClientKeepSummaryReturn.setMemberNoGm(clientKeepSummary.getMemberNoGm());
			findClientKeepSummaryReturn.setMemberNameGm(clientKeepSummary.getMemberNameGm());
			findClientKeepSummaryReturn.setCkNo(clientKeepSummary.getCkNo());
			findClientKeepSummaryReturn.setKeepNum(clientKeepSummary.getKeepNum());
			findClientKeepSummaryReturn.setBuy(clientKeepSummary.getBuy());
			findClientKeepSummaryReturn.setBomCode(clientKeepSummary.getBomCode());
			findClientKeepSummaryReturn.setBomName(clientKeepSummary.getBomName());
			findClientKeepSummaryReturn.setStartDate(clientKeepSummary.getStartDate());
			findClientKeepSummaryReturn.setEndDate(clientKeepSummary.getEndDate());
			findClientKeepSummaryReturn.setRemark(clientKeepSummary.getRemark());
			findClientKeepSummaryReturn.setCreateId(clientKeepSummary.getCreateId());
			findClientKeepSummaryReturn.setCreateDate(clientKeepSummary.getCreateDate());
			findClientKeepSummaryReturn.setRemark4(clientKeepSummary.getRemark4());
			findClientKeepSummaryReturn.setRemark3(clientKeepSummary.getRemark3());
			findClientKeepSummaryReturn.setRemark2(clientKeepSummary.getRemark2());
			
			logger.debug("findClientKeepSummary(FindClientKeepSummary) - end - return value={}", findClientKeepSummaryReturn); //$NON-NLS-1$
			return findClientKeepSummaryReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户维护记录总表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_KEEP_SUMMARY_FIND_ERROR,"查找客户维护记录总表信息错误！",e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientKeepSummaryService#findClientKeepSummaryByCkNo(com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummary)
	 */
	@Override
	public FindClientKeepSummaryReturn findClientKeepSummaryByCkNo(FindClientKeepSummary findClientKeepSummary) throws TsfaServiceException {
		logger.debug("findClientKeepSummaryByCkNo(FindClientKeepSummary findClientKeepSummary={}) - start", findClientKeepSummary); //$NON-NLS-1$

		AssertUtils.notNull(findClientKeepSummary);
		AssertUtils.notAllNull(findClientKeepSummary.getCkNo(),"维护编号不能为空");
		try {
			ClientKeepSummary clientKeepSummary = clientKeepSummaryDao.selectByCkNo(findClientKeepSummary.getCkNo());
			if(clientKeepSummary == null){
				return null;
			}
			FindClientKeepSummaryReturn findClientKeepSummaryReturn = new FindClientKeepSummaryReturn();
			//find数据录入
			findClientKeepSummaryReturn.setCode(clientKeepSummary.getCode());
			findClientKeepSummaryReturn.setMerchantNo(clientKeepSummary.getMerchantNo());
			findClientKeepSummaryReturn.setMemberNo(clientKeepSummary.getMemberNo());
			findClientKeepSummaryReturn.setMemberName(clientKeepSummary.getMemberName());
			findClientKeepSummaryReturn.setMemberNoGm(clientKeepSummary.getMemberNoGm());
			findClientKeepSummaryReturn.setMemberNameGm(clientKeepSummary.getMemberNameGm());
			findClientKeepSummaryReturn.setCkNo(clientKeepSummary.getCkNo());
			findClientKeepSummaryReturn.setKeepNum(clientKeepSummary.getKeepNum());
			findClientKeepSummaryReturn.setBuy(clientKeepSummary.getBuy());
			findClientKeepSummaryReturn.setBomCode(clientKeepSummary.getBomCode());
			findClientKeepSummaryReturn.setBomName(clientKeepSummary.getBomName());
			findClientKeepSummaryReturn.setStartDate(clientKeepSummary.getStartDate());
			findClientKeepSummaryReturn.setEndDate(clientKeepSummary.getEndDate());
			findClientKeepSummaryReturn.setRemark(clientKeepSummary.getRemark());
			findClientKeepSummaryReturn.setCreateId(clientKeepSummary.getCreateId());
			findClientKeepSummaryReturn.setCreateDate(clientKeepSummary.getCreateDate());
			findClientKeepSummaryReturn.setRemark4(clientKeepSummary.getRemark4());
			findClientKeepSummaryReturn.setRemark3(clientKeepSummary.getRemark3());
			findClientKeepSummaryReturn.setRemark2(clientKeepSummary.getRemark2());
			
			logger.debug("findClientKeepSummaryByCkNo(FindClientKeepSummary) - end - return value={}", findClientKeepSummaryReturn); //$NON-NLS-1$
			return findClientKeepSummaryReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户维护记录总表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_KEEP_SUMMARY_FIND_ERROR,"查找客户维护记录总表信息错误！",e);
		}
	}

	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientKeepSummaryService#findClientKeepSummaryPage(com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummaryPage)
	 */
	@Override
	public Page<FindClientKeepSummaryPageReturn> findClientKeepSummaryPage(
			FindClientKeepSummaryPage findClientKeepSummaryPage)
			throws TsfaServiceException {
		logger.debug("findClientKeepSummaryPage(FindClientKeepSummaryPage findClientKeepSummaryPage={}) - start", findClientKeepSummaryPage); //$NON-NLS-1$

		AssertUtils.notNull(findClientKeepSummaryPage);
		List<FindClientKeepSummaryPageReturn> returnList;
		int count = 0;
		try {
			returnList = clientKeepSummaryDao.findClientKeepSummaryPage(findClientKeepSummaryPage);
			count = clientKeepSummaryDao.findClientKeepSummaryPageCount(findClientKeepSummaryPage);
		}  catch (Exception e) {
			logger.error("客户维护记录总表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_KEEP_SUMMARY_FIND_PAGE_ERROR,"客户维护记录总表信息分页查询错误.！",e);
		}
		Page<FindClientKeepSummaryPageReturn> returnPage = new Page<FindClientKeepSummaryPageReturn>(returnList, count, findClientKeepSummaryPage);

		logger.debug("findClientKeepSummaryPage(FindClientKeepSummaryPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}

	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientKeepSummaryService#findClientKeepSummaryLast(com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummary)
	 */
	@Override
	public FindClientKeepSummaryReturn findClientKeepSummaryLast(FindClientKeepSummary findClientKeepSummary) throws TsfaServiceException {
		AssertUtils.notNull(findClientKeepSummary);
		AssertUtils.notNullAndEmpty(findClientKeepSummary.getMerchantNo(), "商户编号不能为空");
		AssertUtils.notNullAndEmpty(findClientKeepSummary.getMemberNo(), "客户编号不能为空");
		AssertUtils.notNullAndEmpty(findClientKeepSummary.getMemberNoGm(), "导购编号不能为空");
		try {
			ClientKeepSummary clientKeepSummary = clientKeepSummaryDao.findClientKeepSummaryLast(findClientKeepSummary);
			if(clientKeepSummary == null){
				return null;
			}
			FindClientKeepSummaryReturn findClientKeepSummaryReturn = new FindClientKeepSummaryReturn();
			//find数据录入
			findClientKeepSummaryReturn.setCode(clientKeepSummary.getCode());
			findClientKeepSummaryReturn.setMerchantNo(clientKeepSummary.getMerchantNo());
			findClientKeepSummaryReturn.setMemberNo(clientKeepSummary.getMemberNo());
			findClientKeepSummaryReturn.setMemberName(clientKeepSummary.getMemberName());
			findClientKeepSummaryReturn.setMemberNoGm(clientKeepSummary.getMemberNoGm());
			findClientKeepSummaryReturn.setMemberNameGm(clientKeepSummary.getMemberNameGm());
			findClientKeepSummaryReturn.setCkNo(clientKeepSummary.getCkNo());
			findClientKeepSummaryReturn.setKeepNum(clientKeepSummary.getKeepNum());
			findClientKeepSummaryReturn.setBuy(clientKeepSummary.getBuy());
			findClientKeepSummaryReturn.setBomCode(clientKeepSummary.getBomCode());
			findClientKeepSummaryReturn.setBomName(clientKeepSummary.getBomName());
			findClientKeepSummaryReturn.setStartDate(clientKeepSummary.getStartDate());
			findClientKeepSummaryReturn.setEndDate(clientKeepSummary.getEndDate());
			findClientKeepSummaryReturn.setRemark(clientKeepSummary.getRemark());
			findClientKeepSummaryReturn.setCreateId(clientKeepSummary.getCreateId());
			findClientKeepSummaryReturn.setCreateDate(clientKeepSummary.getCreateDate());
			findClientKeepSummaryReturn.setRemark4(clientKeepSummary.getRemark4());
			findClientKeepSummaryReturn.setRemark3(clientKeepSummary.getRemark3());
			findClientKeepSummaryReturn.setRemark2(clientKeepSummary.getRemark2());
			
			return findClientKeepSummaryReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户维护记录总表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_KEEP_SUMMARY_FIND_ERROR,"查找客户维护记录总表信息错误！",e);
		}
	}


	@Override
	public long findCountPmKeepByGm(String memberNo) {
		logger.debug("findCountPmKeepByGm(String memberNo={}) - start", memberNo);
		AssertUtils.notNullAndEmpty(memberNo, "导购编号不能为空");
		long count= 0;
		try {
			count = clientKeepSummaryDao.findCountPmKeepByGm(memberNo);
		} catch (Exception e) {
			logger.error("查询成维护客户量错误！",e);
			return count;
		}
		return count;
	} 
	

}
