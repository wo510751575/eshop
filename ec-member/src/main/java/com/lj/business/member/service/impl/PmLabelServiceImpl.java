package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IPmLabelDao;
import com.lj.business.member.dao.IPmLabelPmDao;
import com.lj.business.member.domain.PmLabel;
import com.lj.business.member.dto.AddPmLabel;
import com.lj.business.member.dto.AddPmLabelReturn;
import com.lj.business.member.dto.DelPmLabel;
import com.lj.business.member.dto.DelPmLabelReturn;
import com.lj.business.member.dto.FindPmLabel;
import com.lj.business.member.dto.FindPmLabelPage;
import com.lj.business.member.dto.FindPmLabelPageReturn;
import com.lj.business.member.dto.FindPmLabelReturn;
import com.lj.business.member.dto.FindPmLabelReturnList;
import com.lj.business.member.dto.UpdatePmLabel;
import com.lj.business.member.dto.UpdatePmLabelReturn;
import com.lj.business.member.service.IPmLabelService;

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
public class PmLabelServiceImpl implements IPmLabelService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(PmLabelServiceImpl.class);
	

	/** The pm label dao. */
	@Resource
	private IPmLabelDao pmLabelDao;
	
	/** The pm label pm dao. */
	@Resource
	private IPmLabelPmDao pmLabelPmDao;
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmLabelService#addPmLabel(com.lj.business.member.dto.AddPmLabel)
	 */
	@Override
	public AddPmLabelReturn addPmLabel(
			AddPmLabel addPmLabel) throws TsfaServiceException {
		logger.debug("addPmLabel(AddPmLabel addPmLabel={}) - start", addPmLabel); 

		AssertUtils.notNull(addPmLabel);
		try {
			PmLabel pmLabel = new PmLabel();
			//add数据录入
			pmLabel.setCode(addPmLabel.getCode());
			pmLabel.setMerchantNo(addPmLabel.getMerchantNo());
			pmLabel.setLabelName(addPmLabel.getLabelName());
			pmLabel.setCreateId(addPmLabel.getCreateId());
			pmLabel.setRemark(addPmLabel.getRemark());
			pmLabel.setCreateDate(addPmLabel.getCreateDate());
			pmLabelDao.insert(pmLabel);
			AddPmLabelReturn addPmLabelReturn = new AddPmLabelReturn();
			
			logger.debug("addPmLabel(AddPmLabel) - end - return value={}", addPmLabelReturn); 
			return addPmLabelReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户标签表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_LABEL_ADD_ERROR,"新增客户标签表信息错误！",e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmLabelService#delPmLabel(com.lj.business.member.dto.DelPmLabel)
	 */
	@Override
	public DelPmLabelReturn delPmLabel(
			DelPmLabel delPmLabel) throws TsfaServiceException {
		logger.debug("delPmLabel(DelPmLabel delPmLabel={}) - start", delPmLabel); 

		AssertUtils.notNull(delPmLabel);
		AssertUtils.notNull(delPmLabel.getCode(),"ID不能为空！");
		try {
			pmLabelDao.deleteByPrimaryKey(delPmLabel.getCode());
			DelPmLabelReturn delPmLabelReturn  = new DelPmLabelReturn();

			logger.debug("delPmLabel(DelPmLabel) - end - return value={}", delPmLabelReturn); //$NON-NLS-1$
			return delPmLabelReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除客户标签表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_LABEL_DEL_ERROR,"删除客户标签表信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmLabelService#updatePmLabel(com.lj.business.member.dto.UpdatePmLabel)
	 */
	@Override
	public UpdatePmLabelReturn updatePmLabel(
			UpdatePmLabel updatePmLabel)
			throws TsfaServiceException {
		logger.debug("updatePmLabel(UpdatePmLabel updatePmLabel={}) - start", updatePmLabel); //$NON-NLS-1$

		AssertUtils.notNull(updatePmLabel);
		AssertUtils.notNullAndEmpty(updatePmLabel.getCode(),"ID不能为空");
		try {
			PmLabel pmLabel = new PmLabel();
			//update数据录入
			pmLabel.setCode(updatePmLabel.getCode());
			pmLabel.setMerchantNo(updatePmLabel.getMerchantNo());
			pmLabel.setLabelName(updatePmLabel.getLabelName());
			pmLabel.setCreateId(updatePmLabel.getCreateId());
			pmLabel.setRemark(updatePmLabel.getRemark());
			pmLabel.setCreateDate(updatePmLabel.getCreateDate());
			AssertUtils.notUpdateMoreThanOne(pmLabelDao.updateByPrimaryKeySelective(pmLabel));
			UpdatePmLabelReturn updatePmLabelReturn = new UpdatePmLabelReturn();

			logger.debug("updatePmLabel(UpdatePmLabel) - end - return value={}", updatePmLabelReturn); //$NON-NLS-1$
			return updatePmLabelReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户标签表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_LABEL_UPDATE_ERROR,"客户标签表信息更新错误！",e);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmLabelService#findPmLabel(com.lj.business.member.dto.FindPmLabel)
	 */
	@Override
	public FindPmLabelReturn findPmLabel(
			FindPmLabel findPmLabel) throws TsfaServiceException {
		logger.debug("findPmLabel(FindPmLabel findPmLabel={}) - start", findPmLabel); //$NON-NLS-1$

		AssertUtils.notNull(findPmLabel);
		AssertUtils.notAllNull(findPmLabel.getCode(),"ID不能为空");
		try {
			PmLabel pmLabel = pmLabelDao.selectByPrimaryKey(findPmLabel.getCode());
			if(pmLabel == null){
				throw new TsfaServiceException(ErrorCode.PM_LABEL_NOT_EXIST_ERROR,"客户标签表信息不存在");
			}
			FindPmLabelReturn findPmLabelReturn = new FindPmLabelReturn();
			//find数据录入
			findPmLabelReturn.setCode(pmLabel.getCode());
			findPmLabelReturn.setMerchantNo(pmLabel.getMerchantNo());
			findPmLabelReturn.setLabelName(pmLabel.getLabelName());
			findPmLabelReturn.setCreateId(pmLabel.getCreateId());
			findPmLabelReturn.setRemark(pmLabel.getRemark());
			findPmLabelReturn.setCreateDate(pmLabel.getCreateDate());
			
			logger.debug("findPmLabel(FindPmLabel) - end - return value={}", findPmLabelReturn); //$NON-NLS-1$
			return findPmLabelReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户标签表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_LABEL_FIND_ERROR,"查找客户标签表信息错误！",e);
		}


	}

	
	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmLabelService#findPmLabelPage(com.lj.business.member.dto.FindPmLabelPage)
	 */
	@Override
	public Page<FindPmLabelPageReturn> findPmLabelPage(
			FindPmLabelPage findPmLabelPage)
			throws TsfaServiceException {
		logger.debug("findPmLabelPage(FindPmLabelPage findPmLabelPage={}) - start", findPmLabelPage); //$NON-NLS-1$

		AssertUtils.notNull(findPmLabelPage);
		List<FindPmLabelPageReturn> returnList;
		int count = 0;
		try {
			returnList = pmLabelDao.findPmLabelPage(findPmLabelPage);
			count = pmLabelDao.findPmLabelPageCount(findPmLabelPage);
		}  catch (Exception e) {
			logger.error("客户标签表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.PM_LABEL_FIND_PAGE_ERROR,"客户标签表信息分页查询错误.！",e);
		}
		Page<FindPmLabelPageReturn> returnPage = new Page<FindPmLabelPageReturn>(returnList, count, findPmLabelPage);

		logger.debug("findPmLabelPage(FindPmLabelPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmLabelService#findPmLabelByMemberNo(java.util.Map)
	 */
	@Override
	public List<Map<String, String>> findPmLabelByMemberNo(Map<String, String> parmap) {

		AssertUtils.notNull(parmap);
		List<Map<String,String>> returnList=null;
		try {
			returnList = pmLabelPmDao.findPmLabelByMemberNo(parmap);
		}  catch (Exception e) {
			logger.error("客户标签表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.PM_LABEL_FIND_PAGE_ERROR,"客户标签表信息分页查询错误.！",e);
		}

		return  returnList;
	}


	@Override 
	public List<FindPmLabelReturnList> findPmlabelGuidMember( )throws TsfaServiceException{
		logger.debug("findPmLabelPage() - start" );
		List<FindPmLabelReturnList> list=null;
		try {
			list=pmLabelDao.findPmlabelGuidMember();
		} catch (Exception e) {
			logger.error("客户标签表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.PM_LABEL_FIND_PAGE_ERROR,"客户标签表信息分页查询错误.！",e);
		}
		return list;
	}

	@Override 
	public List<FindPmLabelReturnList> findPmlabelMerchantNo()throws TsfaServiceException{
		logger.debug("findPmLabelPage() - start");
		List<FindPmLabelReturnList> list=null;
		try {
			list=pmLabelDao.findPmlabelMerchantNo();
		} catch (Exception e) {
			logger.error("客户标签表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.PM_LABEL_FIND_PAGE_ERROR,"客户标签表信息分页查询错误.！",e);
		}
		return list;
	}


	@Override 
	public List<FindPmLabelReturnList> findPmlabelShop()throws TsfaServiceException{
		logger.debug("findPmLabelPage() - start");
		List<FindPmLabelReturnList> list=null;
		try {
			list=pmLabelDao.findPmlabelShop();
		} catch (Exception e) {
			logger.error("客户标签表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.PM_LABEL_FIND_PAGE_ERROR,"客户标签表信息分页查询错误.！",e);
		}
		return list;
	}


	@Override 
	public List<FindPmLabelReturnList> findPmlabelAreaCode()throws TsfaServiceException{
		logger.debug("findPmLabelPage(FindPmLabelPage findPmLabelPage={}) - start");
		List<FindPmLabelReturnList> list=null;
		try {
			list=pmLabelDao.findPmlabelAreaCode();
		} catch (Exception e) {
			logger.error("客户标签表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.PM_LABEL_FIND_PAGE_ERROR,"客户标签表信息分页查询错误.！",e);
		}
		return list;
	}

	
}
