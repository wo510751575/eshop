package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.IClientFollowSummaryDao;
import com.lj.business.cf.domain.ClientFollow;
import com.lj.business.cf.domain.ClientFollowSummary;
import com.lj.business.cf.domain.ClientKeep;
import com.lj.business.cf.dto.FindCForCKLastDateDto;
import com.lj.business.cf.dto.FindCForCKLastDateDtoReturn;
import com.lj.business.cf.dto.clientFollow.AddClientFollow;
import com.lj.business.cf.dto.clientFollow.FindSaleRecordPage;
import com.lj.business.cf.dto.clientFollow.FindSaleRecordPageReturn;
import com.lj.business.cf.dto.clientFollowSummary.AddClientFollowSummary;
import com.lj.business.cf.dto.clientFollowSummary.AddPmClientFollowFirstDto;
import com.lj.business.cf.dto.clientFollowSummary.DelClientFollowSummary;
import com.lj.business.cf.dto.clientFollowSummary.FindAbandonRecordCountReturn;
import com.lj.business.cf.dto.clientFollowSummary.FindBuyRecordCountReturn;
import com.lj.business.cf.dto.clientFollowSummary.FindBuyRecordPage;
import com.lj.business.cf.dto.clientFollowSummary.FindBuyRecordPageReturn;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummary;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummaryPage;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummaryPageReturn;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummaryReturn;
import com.lj.business.cf.dto.clientFollowSummary.FindSuccessNum;
import com.lj.business.cf.dto.clientFollowSummary.UpdateClientFollowSummary;
import com.lj.business.cf.emus.DealType;
import com.lj.business.cf.emus.Status;
import com.lj.business.cf.service.IClientFollowService;
import com.lj.business.cf.service.IClientFollowSummaryService;
import com.lj.business.cf.service.IClientKeepService;
import com.lj.business.cf.service.IComTaskListService;
import com.lj.business.cf.service.IComTaskService;
import com.lj.business.member.dto.FindGuidMember;
import com.lj.business.member.dto.FindGuidMemberReturn;
import com.lj.business.member.dto.FindPersonMemberBase;
import com.lj.business.member.dto.FindPersonMemberBaseReturn;
import com.lj.business.member.service.IGuidMemberService;
import com.lj.business.member.service.IPersonMemberBaseService;
import com.lj.business.member.service.IPmTypeService;

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
public class ClientFollowSummaryServiceImpl implements IClientFollowSummaryService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ClientFollowSummaryServiceImpl.class);
	

	/** The client follow summary dao. */
	@Resource
	private IClientFollowSummaryDao clientFollowSummaryDao;
	
	/** The client follow service. */
	@Resource
	private IClientFollowService clientFollowService;
	
	/** The guid member service. */
	@Resource
	private IGuidMemberService guidMemberService;
	
	/** The person member base service. */
	@Resource
	private IPersonMemberBaseService personMemberBaseService;
	
	/** The com task service. */
	@Resource
	private IComTaskService comTaskService;
	
	/** The pm type service. */
	@Resource
	private IPmTypeService pmTypeService;
	
	@Resource
	private IComTaskListService comTaskListService;
	
	@Resource
	private IClientKeepService clientKeepService;
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientFollowSummaryService#addClientFollowSummary(com.lj.business.cf.dto.clientFollowSummary.AddClientFollowSummary)
	 */
	@Override
	public String addClientFollowSummary(
			AddClientFollowSummary addClientFollowSummary) throws TsfaServiceException {
		logger.debug("addClientFollowSummary(AddClientFollowSummary addClientFollowSummary={}) - start", addClientFollowSummary); 

		AssertUtils.notNull(addClientFollowSummary);
		String ret = "";
		try {
			ClientFollowSummary clientFollowSummary = new ClientFollowSummary();
			//add数据录入
			clientFollowSummary.setCode(GUID.getPreUUID());
			clientFollowSummary.setMerchantNo(addClientFollowSummary.getMerchantNo());
			clientFollowSummary.setMemberNo(addClientFollowSummary.getMemberNo());
			clientFollowSummary.setMemberName(addClientFollowSummary.getMemberName());
			clientFollowSummary.setMemberNoGm(addClientFollowSummary.getMemberNoGm());
			clientFollowSummary.setMemberNameGm(addClientFollowSummary.getMemberNameGm());
			clientFollowSummary.setCfNo(GUID.generateByUUID());
			clientFollowSummary.setFollowNum(addClientFollowSummary.getFollowNum());
			clientFollowSummary.setStatus(addClientFollowSummary.getStatus());
			clientFollowSummary.setOrderAmount(addClientFollowSummary.getOrderAmount());
			clientFollowSummary.setStartDate(addClientFollowSummary.getStartDate());
			clientFollowSummary.setEndDate(addClientFollowSummary.getEndDate());
			clientFollowSummary.setRemark(addClientFollowSummary.getRemark());
			clientFollowSummary.setRemark4(addClientFollowSummary.getRemark4());
			clientFollowSummary.setRemark3(addClientFollowSummary.getRemark3());
			clientFollowSummary.setRemark2(addClientFollowSummary.getRemark2());
			clientFollowSummaryDao.insert(clientFollowSummary);
			ret = clientFollowSummary.getCfNo();
			logger.debug("addClientFollowSummary(AddClientFollowSummary) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户跟踪表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_SUMMARY_ADD_ERROR,"新增客户跟踪表信息错误！",e);
		}
		return ret;
	}
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientFollowSummaryService#delClientFollowSummary(com.lj.business.cf.dto.clientFollowSummary.DelClientFollowSummary)
	 */
	@Override
	public void delClientFollowSummary(
			DelClientFollowSummary delClientFollowSummary) throws TsfaServiceException {
		logger.debug("delClientFollowSummary(DelClientFollowSummary delClientFollowSummary={}) - start", delClientFollowSummary); 

		AssertUtils.notNull(delClientFollowSummary);
		AssertUtils.notNull(delClientFollowSummary.getCode(),"Code不能为空！");
		try {
			clientFollowSummaryDao.deleteByPrimaryKey(delClientFollowSummary.getCode());
			logger.debug("delClientFollowSummary(DelClientFollowSummary) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除客户跟踪表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_SUMMARY_DEL_ERROR,"删除客户跟踪表信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientFollowSummaryService#updateClientFollowSummary(com.lj.business.cf.dto.clientFollowSummary.UpdateClientFollowSummary)
	 */
	@Override
	public void updateClientFollowSummary(
			UpdateClientFollowSummary updateClientFollowSummary)
			throws TsfaServiceException {
		logger.debug("updateClientFollowSummary(UpdateClientFollowSummary updateClientFollowSummary={}) - start", updateClientFollowSummary); //$NON-NLS-1$

		AssertUtils.notNull(updateClientFollowSummary);
		AssertUtils.notNullAndEmpty(updateClientFollowSummary.getCode(),"Code不能为空");
		try {
			ClientFollowSummary clientFollowSummary = new ClientFollowSummary();
			//update数据录入
			clientFollowSummary.setCode(updateClientFollowSummary.getCode());
			clientFollowSummary.setMerchantNo(updateClientFollowSummary.getMerchantNo());
			clientFollowSummary.setMemberNo(updateClientFollowSummary.getMemberNo());
			clientFollowSummary.setMemberName(updateClientFollowSummary.getMemberName());
			clientFollowSummary.setMemberNoGm(updateClientFollowSummary.getMemberNoGm());
			clientFollowSummary.setMemberNameGm(updateClientFollowSummary.getMemberNameGm());
			clientFollowSummary.setCfNo(updateClientFollowSummary.getCfNo());
			clientFollowSummary.setFollowNum(updateClientFollowSummary.getFollowNum());
			clientFollowSummary.setStatus(updateClientFollowSummary.getStatus());
			clientFollowSummary.setOrderAmount(updateClientFollowSummary.getOrderAmount());
			clientFollowSummary.setStartDate(updateClientFollowSummary.getStartDate());
			clientFollowSummary.setEndDate(updateClientFollowSummary.getEndDate());
			clientFollowSummary.setRemark(updateClientFollowSummary.getRemark());
			clientFollowSummary.setCreateDate(updateClientFollowSummary.getCreateDate());
			clientFollowSummary.setRemark4(updateClientFollowSummary.getRemark4());
			clientFollowSummary.setRemark3(updateClientFollowSummary.getRemark3());
			clientFollowSummary.setRemark2(updateClientFollowSummary.getRemark2());
			AssertUtils.notUpdateMoreThanOne(clientFollowSummaryDao.updateByPrimaryKeySelective(clientFollowSummary));
			logger.debug("updateClientFollowSummary(UpdateClientFollowSummary) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户跟踪表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_SUMMARY_UPDATE_ERROR,"客户跟踪表信息更新错误！",e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientFollowSummaryService#updateClientFollowSummaryByCfNo(com.lj.business.cf.dto.clientFollowSummary.UpdateClientFollowSummary)
	 */
	@Override
	public void updateClientFollowSummaryByCfNo(
			UpdateClientFollowSummary updateClientFollowSummary)
			throws TsfaServiceException {
		logger.debug("updateClientFollowSummary(UpdateClientFollowSummary updateClientFollowSummary={}) - start", updateClientFollowSummary); //$NON-NLS-1$

		AssertUtils.notNull(updateClientFollowSummary);
		AssertUtils.notNullAndEmpty(updateClientFollowSummary.getCfNo(),"cfNo不能为空");
		try {
			ClientFollowSummary clientFollowSummary = new ClientFollowSummary();
			//update数据录入
			clientFollowSummary.setCode(updateClientFollowSummary.getCode());
			clientFollowSummary.setCfNo(updateClientFollowSummary.getCfNo());
			clientFollowSummary.setMerchantNo(updateClientFollowSummary.getMerchantNo());
			clientFollowSummary.setMemberNo(updateClientFollowSummary.getMemberNo());
			clientFollowSummary.setMemberName(updateClientFollowSummary.getMemberName());
			clientFollowSummary.setMemberNoGm(updateClientFollowSummary.getMemberNoGm());
			clientFollowSummary.setMemberNameGm(updateClientFollowSummary.getMemberNameGm());
			clientFollowSummary.setCfNo(updateClientFollowSummary.getCfNo());
			clientFollowSummary.setFollowNum(updateClientFollowSummary.getFollowNum());
			clientFollowSummary.setStatus(updateClientFollowSummary.getStatus());
			clientFollowSummary.setOrderAmount(updateClientFollowSummary.getOrderAmount());
			clientFollowSummary.setStartDate(updateClientFollowSummary.getStartDate());
			clientFollowSummary.setEndDate(updateClientFollowSummary.getEndDate());
			clientFollowSummary.setRemark(updateClientFollowSummary.getRemark());
			clientFollowSummary.setCreateDate(updateClientFollowSummary.getCreateDate());
			clientFollowSummary.setRemark4(updateClientFollowSummary.getRemark4());
			clientFollowSummary.setRemark3(updateClientFollowSummary.getRemark3());
			clientFollowSummary.setRemark2(updateClientFollowSummary.getRemark2());
			AssertUtils.notUpdateMoreThanOne(clientFollowSummaryDao.updateByCfNoSelective(clientFollowSummary));
			logger.debug("updateClientFollowSummary(UpdateClientFollowSummary) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户跟踪表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_SUMMARY_UPDATE_ERROR,"客户跟踪表信息更新错误！",e);
		}
	}
	

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientFollowSummaryService#findClientFollowSummary(com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummary)
	 */
	@Override
	public FindClientFollowSummaryReturn findClientFollowSummary(
			FindClientFollowSummary findClientFollowSummary) throws TsfaServiceException {
		logger.debug("findClientFollowSummary(FindClientFollowSummary findClientFollowSummary={}) - start", findClientFollowSummary); //$NON-NLS-1$

		AssertUtils.notNull(findClientFollowSummary);
		AssertUtils.notAllNull(findClientFollowSummary.getCode(),"Code不能为空");
		try {
			ClientFollowSummary clientFollowSummary = clientFollowSummaryDao.selectByPrimaryKey(findClientFollowSummary.getCode());
			if(clientFollowSummary == null){
				throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_SUMMARY_NOT_EXIST_ERROR,"客户跟踪表信息不存在");
			}
			FindClientFollowSummaryReturn findClientFollowSummaryReturn = new FindClientFollowSummaryReturn();
			//find数据录入
			findClientFollowSummaryReturn.setCode(clientFollowSummary.getCode());
			findClientFollowSummaryReturn.setMerchantNo(clientFollowSummary.getMerchantNo());
			findClientFollowSummaryReturn.setMemberNo(clientFollowSummary.getMemberNo());
			findClientFollowSummaryReturn.setMemberName(clientFollowSummary.getMemberName());
			findClientFollowSummaryReturn.setMemberNoGm(clientFollowSummary.getMemberNoGm());
			findClientFollowSummaryReturn.setMemberNameGm(clientFollowSummary.getMemberNameGm());
			findClientFollowSummaryReturn.setCfNo(clientFollowSummary.getCfNo());
			findClientFollowSummaryReturn.setFollowNum(clientFollowSummary.getFollowNum());
			findClientFollowSummaryReturn.setStatus(clientFollowSummary.getStatus());
			findClientFollowSummaryReturn.setOrderAmount(clientFollowSummary.getOrderAmount());
			findClientFollowSummaryReturn.setStartDate(clientFollowSummary.getStartDate());
			findClientFollowSummaryReturn.setEndDate(clientFollowSummary.getEndDate());
			findClientFollowSummaryReturn.setRemark(clientFollowSummary.getRemark());
			findClientFollowSummaryReturn.setCreateDate(clientFollowSummary.getCreateDate());
			findClientFollowSummaryReturn.setRemark4(clientFollowSummary.getRemark4());
			findClientFollowSummaryReturn.setRemark3(clientFollowSummary.getRemark3());
			findClientFollowSummaryReturn.setRemark2(clientFollowSummary.getRemark2());
			
			logger.debug("findClientFollowSummary(FindClientFollowSummary) - end - return value={}", findClientFollowSummaryReturn); //$NON-NLS-1$
			return findClientFollowSummaryReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户跟踪表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_SUMMARY_FIND_ERROR,"查找客户跟踪表信息错误！",e);
		}


	}
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientFollowSummaryService#findClientFollowSummaryByCfNo(com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummary)
	 */
	@Override
	public FindClientFollowSummaryReturn findClientFollowSummaryByCfNo(FindClientFollowSummary findClientFollowSummary) throws TsfaServiceException {

		AssertUtils.notNull(findClientFollowSummary);
		AssertUtils.notAllNull(findClientFollowSummary.getCfNo(),"跟进编号不能为空");
		try {
			ClientFollowSummary clientFollowSummary = clientFollowSummaryDao.selectByCfNo(findClientFollowSummary.getCfNo());
			if(clientFollowSummary == null){
				return null;
			}
			FindClientFollowSummaryReturn findClientFollowSummaryReturn = new FindClientFollowSummaryReturn();
			//find数据录入
			findClientFollowSummaryReturn.setCode(clientFollowSummary.getCode());
			findClientFollowSummaryReturn.setMerchantNo(clientFollowSummary.getMerchantNo());
			findClientFollowSummaryReturn.setMemberNo(clientFollowSummary.getMemberNo());
			findClientFollowSummaryReturn.setMemberName(clientFollowSummary.getMemberName());
			findClientFollowSummaryReturn.setMemberNoGm(clientFollowSummary.getMemberNoGm());
			findClientFollowSummaryReturn.setMemberNameGm(clientFollowSummary.getMemberNameGm());
			findClientFollowSummaryReturn.setCfNo(clientFollowSummary.getCfNo());
			findClientFollowSummaryReturn.setFollowNum(clientFollowSummary.getFollowNum());
			findClientFollowSummaryReturn.setStatus(clientFollowSummary.getStatus());
			findClientFollowSummaryReturn.setOrderAmount(clientFollowSummary.getOrderAmount());
			findClientFollowSummaryReturn.setStartDate(clientFollowSummary.getStartDate());
			findClientFollowSummaryReturn.setEndDate(clientFollowSummary.getEndDate());
			findClientFollowSummaryReturn.setRemark(clientFollowSummary.getRemark());
			findClientFollowSummaryReturn.setCreateDate(clientFollowSummary.getCreateDate());
			findClientFollowSummaryReturn.setRemark4(clientFollowSummary.getRemark4());
			findClientFollowSummaryReturn.setRemark3(clientFollowSummary.getRemark3());
			findClientFollowSummaryReturn.setRemark2(clientFollowSummary.getRemark2());
			
			return findClientFollowSummaryReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户跟踪表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_SUMMARY_FIND_ERROR,"查找客户跟踪表信息错误！",e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientFollowSummaryService#findClientFollowSummaryPage(com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummaryPage)
	 */
	@Override
	public Page<FindClientFollowSummaryPageReturn> findClientFollowSummaryPage(
			FindClientFollowSummaryPage findClientFollowSummaryPage)
			throws TsfaServiceException {
		logger.debug("findClientFollowSummaryPage(FindClientFollowSummaryPage findClientFollowSummaryPage={}) - start", findClientFollowSummaryPage); //$NON-NLS-1$

		AssertUtils.notNull(findClientFollowSummaryPage);
		List<FindClientFollowSummaryPageReturn> returnList;
		int count = 0;
		try {
			returnList = clientFollowSummaryDao.findClientFollowSummaryPage(findClientFollowSummaryPage);
			count = clientFollowSummaryDao.findClientFollowSummaryPageCount(findClientFollowSummaryPage);
		}  catch (Exception e) {
			logger.error("客户跟踪表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_SUMMARY_FIND_PAGE_ERROR,"客户跟踪表信息分页查询错误.！",e);
		}
		Page<FindClientFollowSummaryPageReturn> returnPage = new Page<FindClientFollowSummaryPageReturn>(returnList, count, findClientFollowSummaryPage);

		logger.debug("findClientFollowSummaryPage(FindClientFollowSummaryPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}

	/**
	 * 产生跟进总表和第一条跟进记录时机
	 * 1 app导购手工新增客户
	 * 2 导入客户
	 * 3 钩子导入客户
	 * 4 维护后购买意向.
	 *
	 * @param addPmClientFollowFirstDto the add pm client follow first dto
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public String addSummaryWithClientFollow(AddPmClientFollowFirstDto addPmClientFollowFirstDto) throws TsfaServiceException {
		logger.debug("addSummaryWithClientFollow(AddPmClientFollowFirstDto addPmClientFollowFirstDto={}) - start", addPmClientFollowFirstDto); //$NON-NLS-1$
		AssertUtils.notNull(addPmClientFollowFirstDto);
		AssertUtils.notNullAndEmpty(addPmClientFollowFirstDto.getMerchantNo(), "商户号不能为空");
		AssertUtils.notNullAndEmpty(addPmClientFollowFirstDto.getMemberNo(), "客户号不能为空");
		AssertUtils.notNullAndEmpty(addPmClientFollowFirstDto.getMemberNoGm(), "导购号不能为空");
		String cfNo = "";
		try{
			//生成跟进总表记录
			AddClientFollowSummary addClientFollowSummary = new AddClientFollowSummary();
			addClientFollowSummary.setMerchantNo(addPmClientFollowFirstDto.getMerchantNo());
			addClientFollowSummary.setMemberNo(addPmClientFollowFirstDto.getMemberNo());
			addClientFollowSummary.setMemberNoGm(addPmClientFollowFirstDto.getMemberNoGm());
			FindGuidMemberReturn findGuidMemberReturn = null;
			FindPersonMemberBaseReturn findPersonMemberBaseReturn = null;
			//会员名称
			String memberName = "";
			if(StringUtils.isEmpty(addPmClientFollowFirstDto.getMemberName())){
				FindPersonMemberBase findPersonMemberBase = new FindPersonMemberBase();
				findPersonMemberBase.setMemberNo(addPmClientFollowFirstDto.getMemberNo());
				findPersonMemberBaseReturn = personMemberBaseService.findPersonMemberBase(findPersonMemberBase);
				if(findPersonMemberBaseReturn != null){
					memberName = findPersonMemberBaseReturn.getMemberName();
				}
			}else{
				memberName = addPmClientFollowFirstDto.getMemberName();
			}
			addClientFollowSummary.setMemberName(memberName);
			//导购名称
			String memberNameGm = "";
			if(StringUtils.isEmpty(addPmClientFollowFirstDto.getMemberNameGm())){
				FindGuidMember findGuidMember = new FindGuidMember();
				findGuidMember.setMemberNo(addPmClientFollowFirstDto.getMemberNoGm());
				findGuidMemberReturn = guidMemberService.findGuidMember(findGuidMember);
				if(findGuidMemberReturn != null){
					memberNameGm = findGuidMemberReturn.getMemberName();
				}
			}else{
				memberNameGm = addPmClientFollowFirstDto.getMemberNameGm();
			}
			addClientFollowSummary.setMemberNameGm(memberNameGm);
			
			addClientFollowSummary.setFollowNum(1);
			addClientFollowSummary.setStatus(Status.NORMAL.toString());
			addClientFollowSummary.setStartDate(new Date());
			cfNo = addClientFollowSummary(addClientFollowSummary);
			
			//生成跟进记录表
			AddClientFollow addClientFollow = new AddClientFollow();
			addClientFollow.setCfNo(cfNo);
			addClientFollow.setMerchantNo(addPmClientFollowFirstDto.getMerchantNo());
			addClientFollow.setMemberNo(addPmClientFollowFirstDto.getMemberNo());
			addClientFollow.setMemberName(memberName);
			addClientFollow.setMemberNoGm(addPmClientFollowFirstDto.getMemberNoGm());
			addClientFollow.setMemberNameGm(memberNameGm);
			addClientFollow.setFollowNum(1);
			addClientFollow.setFollowTime(new Date());
			addClientFollow.setFollowInfo("开始跟进客户");
			addClientFollow.setDeal(DealType.N.toString());
			addClientFollow.setStatus(Status.NORMAL);
			addClientFollow.setComTaskType("SYSTEM");
			addClientFollow.setCreateId(addPmClientFollowFirstDto.getMemberNoGm());
			clientFollowService.addClientFollow(addClientFollow);
			
			logger.debug("addSummaryWithClientFollow() - end - return value={}", cfNo); //$NON-NLS-1$
			return cfNo;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("新增客户维护记录总表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_KEEP_SUMMARY_ADD_ERROR,"新增客户维护记录总表信息错误！",e);
		}
	}

	/**
	 * 根据商户导购客户号查询最后一条跟进总表记录.
	 *
	 * @param findClientFollowSummary the find client follow summary
	 * @return the find client follow summary return
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public FindClientFollowSummaryReturn findClientFollowSummaryLast(FindClientFollowSummary findClientFollowSummary) throws TsfaServiceException {
		logger.debug("findClientFollowSummaryLast(FindClientFollowSummary findClientFollowSummary={}) - start", findClientFollowSummary); //$NON-NLS-1$

		AssertUtils.notNull(findClientFollowSummary);
		AssertUtils.notNullAndEmpty(findClientFollowSummary.getMerchantNo(), "商户编号不能为空");
		AssertUtils.notNullAndEmpty(findClientFollowSummary.getMemberNo(), "客户编号不能为空");
		AssertUtils.notNullAndEmpty(findClientFollowSummary.getMemberNoGm(), "导购编号不能为空");
		try {
			ClientFollowSummary clientFollowSummary = clientFollowSummaryDao.findClientFollowSummaryLast(findClientFollowSummary);
			if(clientFollowSummary == null){
				return null;
			}
			FindClientFollowSummaryReturn findClientFollowSummaryReturn = new FindClientFollowSummaryReturn();
			//find数据录入
			findClientFollowSummaryReturn.setCode(clientFollowSummary.getCode());
			findClientFollowSummaryReturn.setMerchantNo(clientFollowSummary.getMerchantNo());
			findClientFollowSummaryReturn.setMemberNo(clientFollowSummary.getMemberNo());
			findClientFollowSummaryReturn.setMemberName(clientFollowSummary.getMemberName());
			findClientFollowSummaryReturn.setMemberNoGm(clientFollowSummary.getMemberNoGm());
			findClientFollowSummaryReturn.setMemberNameGm(clientFollowSummary.getMemberNameGm());
			findClientFollowSummaryReturn.setCfNo(clientFollowSummary.getCfNo());
			findClientFollowSummaryReturn.setFollowNum(clientFollowSummary.getFollowNum());
			findClientFollowSummaryReturn.setStatus(clientFollowSummary.getStatus());
			findClientFollowSummaryReturn.setOrderAmount(clientFollowSummary.getOrderAmount());
			findClientFollowSummaryReturn.setStartDate(clientFollowSummary.getStartDate());
			findClientFollowSummaryReturn.setEndDate(clientFollowSummary.getEndDate());
			findClientFollowSummaryReturn.setRemark(clientFollowSummary.getRemark());
			findClientFollowSummaryReturn.setCreateDate(clientFollowSummary.getCreateDate());
			findClientFollowSummaryReturn.setRemark4(clientFollowSummary.getRemark4());
			findClientFollowSummaryReturn.setRemark3(clientFollowSummary.getRemark3());
			findClientFollowSummaryReturn.setRemark2(clientFollowSummary.getRemark2());
			
			logger.debug("findClientFollowSummaryLast(FindClientFollowSummary findClientFollowSummary={}) - end", findClientFollowSummary); //$NON-NLS-1$
			return findClientFollowSummaryReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("最后一条跟进总表记录错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_SUMMARY_FIND_ERROR,"最后一条跟进总表记录错误！",e);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientFollowSummaryService#findBuyRecordPage(com.lj.business.cf.dto.clientFollowSummary.FindBuyRecordPage)
	 */
	@Override
	public Page<FindBuyRecordPageReturn> findBuyRecordPage(
			FindBuyRecordPage findBuyRecordPage) throws TsfaServiceException {
		logger.debug("findBuyRecordPage(FindBuyRecordPage findBuyRecordPage={}) - start", findBuyRecordPage); //$NON-NLS-1$

		AssertUtils.notNull(findBuyRecordPage);
		List<FindBuyRecordPageReturn> returnList;
		int count = 0;
		try {
			returnList = clientFollowSummaryDao.findBuyRecordPage(findBuyRecordPage);
			
			List<FindBuyRecordCountReturn> listCount = findBuyRecordCount(findBuyRecordPage);
			Map<String,Integer> map = new HashMap<>();
			if(listCount != null && listCount.size() > 0){
				for(FindBuyRecordCountReturn findBuyRecordCountReturn : listCount){
					map.put(findBuyRecordCountReturn.getCfNo(), findBuyRecordCountReturn.getTotal());
				}
			}
			
			if(returnList != null && returnList.size() > 0){
				for(FindBuyRecordPageReturn findBuyRecordPageReturn : returnList){
					Integer total = map.get(findBuyRecordPageReturn.getCfNo());
					if(total == null){
						findBuyRecordPageReturn.setFollowNum(0);
					}else{
						findBuyRecordPageReturn.setFollowNum(total);
					}
				}
			}
			
			count = clientFollowSummaryDao.findBuyRecordPageCount(findBuyRecordPage);
		}  catch (Exception e) {
			logger.error("客户跟踪表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_SUMMARY_FIND_PAGE_ERROR,"客户跟踪表信息分页查询错误.！",e);
		}
		Page<FindBuyRecordPageReturn> returnPage = new Page<FindBuyRecordPageReturn>(returnList, count, findBuyRecordPage);

		logger.debug("findBuyRecordPage(FindBuyRecordPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	
	}
	

	@Override
	public List<FindBuyRecordCountReturn> findBuyRecordCount(FindBuyRecordPage findBuyRecordPage) throws TsfaServiceException {
		AssertUtils.notNull(findBuyRecordPage);
		try {
			List<FindBuyRecordCountReturn> listCount = clientFollowSummaryDao.findBuyRecordCount(findBuyRecordPage);
			return listCount;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查询跟进次数错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_SUMMARY_FIND_ERROR,"查询跟进次数错误！",e);
		}
	}
	
	@Override
	public List<FindAbandonRecordCountReturn> findAbandonRecordCount(FindBuyRecordPage findBuyRecordPage) throws TsfaServiceException {
		AssertUtils.notNull(findBuyRecordPage);
		try {
			List<FindAbandonRecordCountReturn> listCount = clientFollowSummaryDao.findAbandonRecordCount(findBuyRecordPage);
			return listCount;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查询跟进次数错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_SUMMARY_FIND_ERROR,"查询跟进次数错误！",e);
		}
	}


	@Override
	public int findBuySuccessNum(FindSuccessNum findSuccessNum) {
		logger.debug("findBuySuccessNum(FindBuyRecordPage findBuyRecordPage={}) - start", findSuccessNum); 
		AssertUtils.notNull(findSuccessNum);
		int count=0;
		try {
			count=clientFollowSummaryDao.findBuySuccessNum(findSuccessNum);
		} catch (Exception e) {
			logger.error("查询购买数量错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_SUMMARY_FIND_PAGE_ERROR,"查询购买数量错误！",e);
		}
		return count;
	}


	@Override
	public Page<FindSaleRecordPageReturn> findSaleRecordPage(
			FindSaleRecordPage findSaleRecordPage) throws TsfaServiceException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public long sumAmountByShop(List<String> memberNoGmList) {
		logger.debug("sumAmountByShop(sumAmountByShop memberNoGmList={}) - start", memberNoGmList); 
		long amout=0L;
		if(memberNoGmList==null || memberNoGmList.size()<=0){
			return amout;
		}
		try {
			amout=clientFollowSummaryDao.sumAmountByShop(memberNoGmList);
		} catch (Exception e) {
			return amout;
		}
		return amout;
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientFollowSummaryService#findCForCKLastDate(com.lj.business.cf.dto.FindCForCKLastDateDto)
	 */
	@Override
	public FindCForCKLastDateDtoReturn findCForCKLastDate(FindCForCKLastDateDto findCForCKLastDateDto) throws TsfaServiceException {
		AssertUtils.notNull(findCForCKLastDateDto);
		AssertUtils.notNullAndEmpty(findCForCKLastDateDto.getCfNo(), "跟踪编号不能为空");
		AssertUtils.notNullAndEmpty(findCForCKLastDateDto.getType(), "跟踪类型不能为空");
		FindCForCKLastDateDtoReturn findCForCKLastDateDtoReturn = new FindCForCKLastDateDtoReturn();
		try {
			if("FOLLOW".equals(findCForCKLastDateDto.getType())){
				//查询跟进总表中导购和客户最后一条记录
				ClientFollow clientFollow = clientFollowService.findLastClientFollow(findCForCKLastDateDto);
				if(clientFollow != null){
					findCForCKLastDateDtoReturn.setLastDate(clientFollow.getFollowTime());
				}
			}else if("KEEP".equals(findCForCKLastDateDto.getType())){
				ClientKeep clientFollow = clientKeepService.findLastClientKeep(findCForCKLastDateDto);
				if(clientFollow != null){
					findCForCKLastDateDtoReturn.setLastDate(clientFollow.getKeepTime());
				}
			}
			return findCForCKLastDateDtoReturn;
		} catch (Exception e) {
			logger.error("查询最后一次跟踪时间错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_SUMMARY_FIND_LAST_DATE_ERROR,"查询最后一次跟踪时间错误！",e);
		}
	}


	@Override
	public long sumAmountByMerchantNo(Map<String, Object> parmMap) {
		logger.debug("sumAmountByMerchantNo(Map<String, Object> parmMap={}) - start", parmMap); 
		AssertUtils.notNull(parmMap);
		long amout=0L;
		try {
			amout=clientFollowSummaryDao.sumAmountByMerchantNo(parmMap);
		} catch (Exception e) {
			return amout;
		}
		return amout;
	}


	@Override
	public long findNumSaleByGm(Map<String, Object> map) {
		logger.debug("findNumSaleByGm(Map<String, Object> map={}) - start", map);
		AssertUtils.notNull(map);
		long amout=0L;
		try {
			amout = clientFollowSummaryDao.findNumSaleByGm(map);
		} catch (Exception e) {
			logger.error("查询销售额错误！",e);
			return amout;
		}
		return amout;
	}


	@Override
	public int findCountOrderByGm(Map<String, Object> map) {
		logger.debug("findCountOrderByGm(Map<String, Object> map={}) - start", map);
		AssertUtils.notNull(map);
		int count= 0;
		try {
			count = clientFollowSummaryDao.findCountOrderByGm(map);
		} catch (Exception e) {
			logger.error("查询成单数量错误！",e);
			return count;
		}
		return count;
	}


	@Override
	public long findCountPmCfByGm(String memberNo) {
		logger.debug("findCountPmCfByGm(String memberNo={}) - start", memberNo);
		AssertUtils.notNullAndEmpty(memberNo, "导购编号不能为空");
		long count= 0;
		try {
			count = clientFollowSummaryDao.findCountPmCfByGm(memberNo);
		} catch (Exception e) {
			logger.error("查询成跟进客户量错误！",e);
			return count;
		}
		return count;
	}
}
