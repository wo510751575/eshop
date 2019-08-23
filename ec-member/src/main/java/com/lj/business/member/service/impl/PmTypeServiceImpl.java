package com.lj.business.member.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.clientFollow.AddClientFollow;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummary;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummaryReturn;
import com.lj.business.cf.dto.comTask.AddComTask;
import com.lj.business.cf.dto.comTask.UpdateComTaskGroup;
import com.lj.business.cf.dto.comTaskList.FindComTaskList;
import com.lj.business.cf.dto.comTaskList.FindComTaskListReturn;
import com.lj.business.cf.emus.ComTaskFinish;
import com.lj.business.cf.emus.ComTaskType;
import com.lj.business.cf.emus.FollowNoType;
import com.lj.business.cf.emus.FollowType;
import com.lj.business.cf.service.IClientFollowService;
import com.lj.business.cf.service.IClientFollowSummaryService;
import com.lj.business.cf.service.IComTaskListService;
import com.lj.business.cf.service.IComTaskService;
import com.lj.business.common.CommonConstant;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IPersonMemberDao;
import com.lj.business.member.dao.IPmTypeDao;
import com.lj.business.member.dao.IPmTypePmDao;
import com.lj.business.member.domain.PersonMember;
import com.lj.business.member.domain.PmType;
import com.lj.business.member.domain.PmTypePm;
import com.lj.business.member.dto.AddPmType;
import com.lj.business.member.dto.AddPmTypePmDto;
import com.lj.business.member.dto.AddPmTypeReturn;
import com.lj.business.member.dto.ChangePmType;
import com.lj.business.member.dto.ChangePmTypeApp;
import com.lj.business.member.dto.ChangePmTypeUngroup;
import com.lj.business.member.dto.ChangeUrgency;
import com.lj.business.member.dto.CheckPmTypeDto;
import com.lj.business.member.dto.CheckPmTypeReturn;
import com.lj.business.member.dto.DelPmType;
import com.lj.business.member.dto.DelPmTypeReturn;
import com.lj.business.member.dto.FindPersonMember;
import com.lj.business.member.dto.FindPersonMemberReturn;
import com.lj.business.member.dto.FindPmType;
import com.lj.business.member.dto.FindPmTypeIndex;
import com.lj.business.member.dto.FindPmTypeIndexReturn;
import com.lj.business.member.dto.FindPmTypePage;
import com.lj.business.member.dto.FindPmTypePageReturn;
import com.lj.business.member.dto.FindPmTypePmListByMGMDto;
import com.lj.business.member.dto.FindPmTypePmListByMGMReturn;
import com.lj.business.member.dto.FindPmTypePmReturn;
import com.lj.business.member.dto.FindPmTypeReturn;
import com.lj.business.member.dto.UpdatePersonMember;
import com.lj.business.member.dto.UpdatePmType;
import com.lj.business.member.dto.UpdatePmTypeReturn;
import com.lj.business.member.emus.FirstIntroduce;
import com.lj.business.member.emus.PmTypeType;
import com.lj.business.member.emus.UrgentFlagType;
import com.lj.business.member.service.IGuidMemberIntegralService;
import com.lj.business.member.service.IGuidMemberService;
import com.lj.business.member.service.IPersonMemberService;
import com.lj.business.member.service.IPmTypeService;

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
public class PmTypeServiceImpl implements IPmTypeService { 


	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(PmTypeServiceImpl.class);


	/** The pm type dao. */
	@Resource
	private IPmTypeDao pmTypeDao;

	/** The pm type pm dao. */
	@Resource
	private IPmTypePmDao pmTypePmDao;

	/** The person member dao. */
	@Resource
	private IPersonMemberDao personMemberDao;

	/** The com task service. */
	@Resource
	private IComTaskService comTaskService;

	/** The client follow summary service. */
	@Resource
	private IClientFollowSummaryService clientFollowSummaryService;

	/** The person member service. */
	@Resource
	private IPersonMemberService personMemberService;

	/** The client follow service. */
	@Resource
	private IClientFollowService clientFollowService;

	@Resource
	private IComTaskListService comTaskListService;

	@Resource
	private IGuidMemberIntegralService guidMemberIntegralService;

	@Resource
	private IGuidMemberService guidMemberService;


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmTypeService#addPmType(com.lj.business.member.dto.AddPmType)
	 */
	@Override
	public AddPmTypeReturn addPmType(
			AddPmType addPmType) throws TsfaServiceException {
		logger.debug("addPmType(AddPmType addPmType={}) - start", addPmType); 

		AssertUtils.notNull(addPmType);
		try {
			PmType pmType = new PmType();
			//add数据录入
			pmType.setCode(GUID.generateCode());
			pmType.setMerchantNo(addPmType.getMerchantNo());
			pmType.setMemberNo(addPmType.getMemberNo());
			pmType.setMemberName(addPmType.getMemberName());
			pmType.setTypeName(addPmType.getTypeName());
			pmType.setPmTypeType(addPmType.getPmTypeType());
			pmType.setPmTypeDim(addPmType.getPmTypeDim());
			pmType.setStatus(addPmType.getStatus());
			pmType.setSeq(addPmType.getSeq());
			pmType.setCreateId(addPmType.getCreateId());
			pmType.setRemark(addPmType.getRemark());
			pmType.setRemark2(addPmType.getRemark2());
			pmType.setRemark3(addPmType.getRemark3());
			pmType.setRemark4(addPmType.getRemark4());
			pmType.setFreValue(addPmType.getFreValue());
			pmTypeDao.insert(pmType);
			AddPmTypeReturn addPmTypeReturn = new AddPmTypeReturn();

			logger.debug("addPmType(AddPmType) - end - return value={}", addPmTypeReturn); 
			return addPmTypeReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户分类表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_TYPE_ADD_ERROR,"新增客户分类表信息错误！",e);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmTypeService#delPmType(com.lj.business.member.dto.DelPmType)
	 */
	@Override
	public DelPmTypeReturn delPmType(
			DelPmType delPmType) throws TsfaServiceException {
		logger.debug("delPmType(DelPmType delPmType={}) - start", delPmType); 

		AssertUtils.notNull(delPmType);
		AssertUtils.notNull(delPmType.getCode(),"ID不能为空！");
		try {
			pmTypeDao.deleteByPrimaryKey(delPmType.getCode());
			DelPmTypeReturn delPmTypeReturn  = new DelPmTypeReturn();

			logger.debug("delPmType(DelPmType) - end - return value={}", delPmTypeReturn); //$NON-NLS-1$
			return delPmTypeReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除客户分类表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_TYPE_DEL_ERROR,"删除客户分类表信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmTypeService#updatePmType(com.lj.business.member.dto.UpdatePmType)
	 */
	@Override
	public UpdatePmTypeReturn updatePmType(UpdatePmType updatePmType)throws TsfaServiceException {
		logger.debug("updatePmType(UpdatePmType updatePmType={}) - start", updatePmType); //$NON-NLS-1$

		AssertUtils.notNull(updatePmType);
		AssertUtils.notNullAndEmpty(updatePmType.getCode(),"Code不能为空");
		try {
			PmType pmType = new PmType();
			//update数据录入
			pmType.setCode(updatePmType.getCode());
			pmType.setMerchantNo(updatePmType.getMerchantNo());
			pmType.setMemberNo(updatePmType.getMemberNo());
			pmType.setMemberName(updatePmType.getMemberName());
			pmType.setTypeName(updatePmType.getTypeName());
			pmType.setPmTypeType(updatePmType.getPmTypeType());
			pmType.setPmTypeDim(updatePmType.getPmTypeDim());
			pmType.setSeq(updatePmType.getSeq());
			pmType.setStatus(updatePmType.getStatus());
			pmType.setRemark(updatePmType.getRemark());
			pmType.setRemark2(updatePmType.getRemark2());
			pmType.setRemark3(updatePmType.getRemark3());
			pmType.setRemark4(updatePmType.getRemark4());
			pmType.setFreValue(updatePmType.getFreValue());
			AssertUtils.notUpdateMoreThanOne(pmTypeDao.updateByPrimaryKeySelective(pmType));
			UpdatePmTypeReturn updatePmTypeReturn = new UpdatePmTypeReturn();

			logger.debug("updatePmType(UpdatePmType) - end - return value={}", updatePmTypeReturn); //$NON-NLS-1$
			return updatePmTypeReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error(" 客户分类表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_TYPE_UPDATE_ERROR," 客户分类表信息更新错误！",e);
		}
	}



	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmTypeService#findPmType(com.lj.business.member.dto.FindPmType)
	 */
	@Override
	public FindPmTypeReturn findPmType(
			FindPmType findPmType) throws TsfaServiceException {
		logger.debug("findPmType(FindPmType findPmType={}) - start", findPmType); //$NON-NLS-1$

		AssertUtils.notNull(findPmType);
		AssertUtils.notAllNull(findPmType.getCode(),"ID不能为空");
		try {
			PmType pmType = pmTypeDao.selectByPrimaryKey(findPmType.getCode());
			if(pmType == null){
				return null;
			}
			FindPmTypeReturn findPmTypeReturn = new FindPmTypeReturn();
			//find数据录入
			findPmTypeReturn.setCode(pmType.getCode());
			findPmTypeReturn.setMerchantNo(pmType.getMerchantNo());
			findPmTypeReturn.setMemberNo(pmType.getMemberNo());
			findPmTypeReturn.setMemberName(pmType.getMemberName());
			findPmTypeReturn.setTypeName(pmType.getTypeName());
			findPmTypeReturn.setPmTypeType(pmType.getPmTypeType());
			findPmTypeReturn.setPmTypeDim(pmType.getPmTypeDim());
			findPmTypeReturn.setSeq(pmType.getSeq());
			findPmTypeReturn.setStatus(pmType.getStatus());
			findPmTypeReturn.setCreateId(pmType.getCreateId());
			findPmTypeReturn.setCreateDate(pmType.getCreateDate());
			findPmTypeReturn.setRemark(pmType.getRemark());
			findPmTypeReturn.setRemark2(pmType.getRemark2());
			findPmTypeReturn.setRemark3(pmType.getRemark3());
			findPmTypeReturn.setRemark4(pmType.getRemark4());
			findPmTypeReturn.setFreValue(pmType.getFreValue());
			logger.debug("findPmType(FindPmType) - end - return value={}", findPmTypeReturn); //$NON-NLS-1$
			return findPmTypeReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户分类表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_TYPE_FIND_ERROR,"查找客户分类表信息错误！",e);
		}


	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmTypeService#findPmTypeByMP(com.lj.business.member.dto.FindPmType)
	 */
	@Override
	public FindPmTypeReturn findPmTypeByMP(FindPmType findPmType) throws TsfaServiceException {
		logger.debug("findPmTypeByMP(FindPmType findPmType={}) - start", findPmType); //$NON-NLS-1$

		AssertUtils.notNull(findPmType);
		AssertUtils.notAllNull(findPmType.getMerchantNo(),"商户号不能为空");
		AssertUtils.notAllNull(findPmType.getPmTypeType(),"客户分类不能为空");
		try {
			PmType pmType = pmTypeDao.selectByMP(findPmType);
			if(pmType == null){
				//throw new TsfaServiceException(ErrorCode.PM_TYPE_NOT_EXIST_ERROR,"客户分类表信息不存在");
				return null;
			}
			FindPmTypeReturn findPmTypeReturn = new FindPmTypeReturn();
			//find数据录入
			findPmTypeReturn.setCode(pmType.getCode());
			findPmTypeReturn.setMerchantNo(pmType.getMerchantNo());
			findPmTypeReturn.setMemberNo(pmType.getMemberNo());
			findPmTypeReturn.setMemberName(pmType.getMemberName());
			findPmTypeReturn.setTypeName(pmType.getTypeName());
			findPmTypeReturn.setPmTypeType(pmType.getPmTypeType());
			findPmTypeReturn.setPmTypeDim(pmType.getPmTypeDim());
			findPmTypeReturn.setStatus(pmType.getStatus());
			findPmTypeReturn.setCreateId(pmType.getCreateId());
			findPmTypeReturn.setCreateDate(pmType.getCreateDate());
			findPmTypeReturn.setRemark(pmType.getRemark());
			findPmTypeReturn.setRemark2(pmType.getRemark2());
			findPmTypeReturn.setRemark3(pmType.getRemark3());
			findPmTypeReturn.setRemark4(pmType.getRemark4());
			findPmTypeReturn.setFreValue(pmType.getFreValue());
			logger.debug("findPmTypeByMP(FindPmType) - end - return value={}", findPmTypeReturn); //$NON-NLS-1$
			return findPmTypeReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户分类表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_TYPE_FIND_ERROR,"查找客户分类表信息错误！",e);
		}


	}



	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmTypeService#findPmTypePage(com.lj.business.member.dto.FindPmTypePage)
	 */
	@Override
	public Page<FindPmTypePageReturn> findPmTypePage(
			FindPmTypePage findPmTypePage)
					throws TsfaServiceException {
		logger.debug("findPmTypePage(FindPmTypePage findPmTypePage={}) - start", findPmTypePage); //$NON-NLS-1$

		AssertUtils.notNull(findPmTypePage);
		List<FindPmTypePageReturn> returnList =null;
		int count = 0;
		try {
			returnList = pmTypeDao.findPmTypePage(findPmTypePage);
			count = pmTypeDao.findPmTypePageCount(findPmTypePage);
		}  catch (Exception e) {
			logger.error("客户分类表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.PM_TYPE_FIND_PAGE_ERROR,"客户分类表信息分页查询错误.！",e);
		}
		Page<FindPmTypePageReturn> returnPage = new Page<FindPmTypePageReturn>(returnList, count, findPmTypePage);

		logger.debug("findPmTypePage(FindPmTypePage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmTypeService#inqueryMemberGroupInfo(java.lang.String)
	 */
	@Override
	public List<FindPmType> inqueryMemberGroupInfo(String merchantNo) throws TsfaServiceException {
		List<FindPmType> list = new ArrayList<FindPmType>();
		List<PmType> li = pmTypeDao.inqueryMemberGroupInfo(merchantNo);
		for(PmType pt:li){
			FindPmType dto = new FindPmType();
			dto.setCode(pt.getCode());
			dto.setPmTypeType(pt.getPmTypeType());
			dto.setTypeName(pt.getTypeName());
			list.add(dto);
		}
		return list;
	} 


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmTypeService#findPmTypePages(com.lj.business.member.dto.FindPmTypePageReturn)
	 */
	public List<FindPmTypePageReturn> findPmTypePages(
			FindPmTypePageReturn findPmTypePageReturn) {
		logger.debug("findPmTypePages(FindPmTypePageReturn findPmTypePageReturn={}) - start", findPmTypePageReturn); 
		AssertUtils.notNull(findPmTypePageReturn);
		List<FindPmTypePageReturn> list;
		try {
			list=pmTypeDao.findPmTypePages(findPmTypePageReturn);
		} catch (Exception e) {
			logger.error("客户分类表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.PM_TYPE_FIND_PAGE_ERROR,"客户分类表信息分页查询错误.！",e);
		}
		return list;
	}


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmTypeService#findPmTypeIndex(com.lj.business.member.dto.FindPmTypeIndex)
	 */
	@Override
	public List<FindPmTypeIndexReturn> findPmTypeIndex(FindPmTypeIndex findPmTypeIndex) throws TsfaServiceException{
		logger.debug("findPmTypeIndex(FindPmTypeIndex findPmTypeIndex={}) - start", findPmTypeIndex); //$NON-NLS-1$

		AssertUtils.notNull(findPmTypeIndex);
		AssertUtils.notNullAndEmpty(findPmTypeIndex.getMerchantNo(),"商户编号不能为空");
		AssertUtils.notAllNullAndEmpty(findPmTypeIndex.getShopNo(),findPmTypeIndex.getMemberNoGm());
		try {
			List<FindPmTypeIndexReturn> returnList = pmTypeDao.findPmTypeIndex(findPmTypeIndex);
			logger.debug("findPmTypeIndex(FindPmTypeIndex) - end - return value={}", returnList); //$NON-NLS-1$
			return returnList;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户分类表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_TYPE_FIND_ERROR,"查找客户分类表信息错误！",e);
		}

	}


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmTypeService#changePmType(com.lj.business.member.dto.ChangePmType)
	 */
	@Override
	public void changePmType(ChangePmType changePmType)
			throws TsfaServiceException {
		logger.debug("changePmType(ChangePmType changePmType={}) - start", changePmType); //$NON-NLS-1$

		AssertUtils.notNull(changePmType);
		AssertUtils.notNullAndEmpty(changePmType.getMerchantNo(),"商户编号不能为空");
		if(StringUtils.isEmpty(changePmType.getCodePm()) && 
				(StringUtils.isEmpty(changePmType.getMemberNoGm()) || StringUtils.isEmpty(changePmType.getMemberNo()))){
			throw new IllegalArgumentException("（导购编号 && 客户编号）,客户表CODE 不能全部为空！");
		}
		if(StringUtils.isEmpty(changePmType.getPmTypeCode()) && 
				(changePmType.getPmTypeType() == null || StringUtils.isEmpty(changePmType.getMerchantNo()))){
			throw new IllegalArgumentException("（客户分类类型 && 商户编号）,客户分类CODE 不能全部为空！");
		}
		try {
			if(StringUtils.isEmpty(changePmType.getCodePm())){//客户表CODE
				PersonMember personMemberQuery = new PersonMember();
				personMemberQuery.setMemberNo(changePmType.getMemberNo());
				personMemberQuery.setMemberNoGm(changePmType.getMemberNoGm());
				PersonMember personMember = personMemberDao.selectByParamKey(personMemberQuery );
				changePmType.setCodePm(personMember.getCode());
			}
			if(StringUtils.isEmpty(changePmType.getPmTypeCode())){//客户分类CODE
				PmType pmTypeQuery = new PmType();
				pmTypeQuery.setMerchantNo(changePmType.getMerchantNo());
				pmTypeQuery.setPmTypeType(changePmType.getPmTypeType().toString());
				PmType pmType = pmTypeDao.selectByParamKey(pmTypeQuery);
				changePmType.setPmTypeCode(pmType.getCode());
			}

			//查找客户原来所属分类关联CODE
			Map<String, String> map = new HashMap<String,String>();
			map.put("merchantNo", changePmType.getMerchantNo());
			map.put("codePm", changePmType.getCodePm());
			Map<String, String> mapResult =  pmTypeDao.selectByParamKey_changePmType(map);

			PmTypePm record  = new PmTypePm();
			record.setCode(mapResult.get("CODE"));
			record.setPmTypeCode(changePmType.getPmTypeCode());
			pmTypePmDao.updateByPrimaryKeySelective(record);
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户分类表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_TYPE_UPDATE_ERROR,"客户分类表信息更新错误！",e);
		}

		logger.debug("changePmType(ChangePmType) - end"); //$NON-NLS-1$
	}


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmTypeService#changePmType_app(com.lj.business.member.dto.ChangePmTypeApp)
	 */
	@Override
	public void changePmType_app(ChangePmTypeApp changePmTypeApp)
			throws TsfaServiceException {
		logger.debug("changePmType_app(ChangePmTypeApp changePmTypeApp={}) - start", changePmTypeApp); //$NON-NLS-1$

		AssertUtils.notNull(changePmTypeApp);
		String code = changePmTypeApp.getCode();
		AssertUtils.notNullAndEmpty(code,"CODE不能为空");
		String pmTypeCode = changePmTypeApp.getPmTypeCode();
		AssertUtils.notNullAndEmpty(pmTypeCode,"客户分类CODE 不能为空");
		String merchantNo = changePmTypeApp.getMerchantNo();
		String memberNoGm = changePmTypeApp.getMemberNoGm();
		String memberNo = changePmTypeApp.getMemberNo();
		AssertUtils.notNullAndEmpty(merchantNo,"商户编号不能为空");
		AssertUtils.notNullAndEmpty(memberNoGm,"导购编号不能为空");
		AssertUtils.notNullAndEmpty(memberNo,"客户编号不能为空");
		try {
			PmType pmType = pmTypeDao.selectByPrimaryKey(pmTypeCode);
			PmTypePm pmTypePm = pmTypePmDao.selectByPrimaryKey(code);
			if(pmTypePm.getPmTypeCode().equals(pmTypeCode)){//如果客户分类没有修改直接返回
				logger.debug("客户分类没有修改，直接返回");
				return;
			}
			PmType pmTypeOrg = pmTypeDao.selectByPrimaryKey(pmTypePm.getPmTypeCode());//原来的客户分类

			if(PmTypeType.URGENCY.toString().equals(pmType.getPmTypeType()) ){
				logger.debug("录入紧急分类关联");
				FindPersonMember findPersonMember = new FindPersonMember();
				findPersonMember.setMemberNo(memberNo);
				findPersonMember.setMemberNoGm(memberNoGm);
				findPersonMember.setMerchantNo(merchantNo);
				FindPersonMemberReturn findPersonMemberReturn = personMemberService.findPersonMemberByMGM(findPersonMember );
				PmTypePm record  = new PmTypePm();
				record.setCode(GUID.generateCode());
				record.setPmTypeCode(pmTypeCode);
				record.setCodePm(findPersonMemberReturn.getCode());
				pmTypePmDao.insert(record);
			}else{
				logger.debug("更新分类");
				PmTypePm record  = new PmTypePm();
				record.setCode(code);
				record.setPmTypeCode(pmTypeCode);
				pmTypePmDao.updateByPrimaryKeySelective(record);
			}

			logger.debug(" 产生沟通任务");
			AddComTask addComTask = new AddComTask();
			addComTask.setMerchantNo(merchantNo);
			addComTask.setMemberNoGm(memberNoGm);

			logger.debug("查询跟进总表中导购和客户最后一条记录");
			FindClientFollowSummary findClientFollowSummary = new FindClientFollowSummary();
			findClientFollowSummary.setMerchantNo(merchantNo);
			findClientFollowSummary.setMemberNoGm(memberNoGm);
			findClientFollowSummary.setMemberNo(memberNo);
			FindClientFollowSummaryReturn findClientFollowSummaryReturn = clientFollowSummaryService.findClientFollowSummaryLast(findClientFollowSummary);
			if(findClientFollowSummaryReturn != null){
				logger.debug("查询跟进总表中导购和客户最后一条记录: "+ findClientFollowSummaryReturn);
				addComTask.setCfNo(findClientFollowSummaryReturn.getCfNo());
				addComTask.setNoType(FollowNoType.FOLLOW.toString());
			}

			//紧急处理
			if(PmTypeType.URGENCY.toString().equals(pmType.getPmTypeType()) ){
				logger.debug("紧急处理");
				UpdatePersonMember updatePersonMember = new UpdatePersonMember();
				updatePersonMember.setMemberNo(memberNo);
				updatePersonMember.setMemberNoGm(memberNoGm);
				updatePersonMember.setUrgencyPm(UrgentFlagType.Y.toString());
				personMemberService.updatePersonMemberByMGM(updatePersonMember);
			}

			//未分组挪到其他分组产生跟进记录 初次介绍任务,并且不是挪到紧急
			if(PmTypeType.UNGROUP.toString().equals(pmTypeOrg.getPmTypeType()) && !PmTypeType.URGENCY.toString().equals(pmType.getPmTypeType()) ){
				logger.debug("未分组挪到其他分组产生跟进记录");
				addCfOrder(merchantNo, memberNoGm, memberNo, pmType, addComTask,false,true);//产生跟进记录

				if(PmTypeType.INTENTION_N.toString().equals(pmType.getPmTypeType()) || PmTypeType.INTENTION.toString().equals(pmType.getPmTypeType()) 
						|| PmTypeType.OTHER.toString().equals(pmType.getPmTypeType())){
					logger.debug("未分组挪到其他分组（意向到店客户/意向未到店客户/非意向(OTHER)） 产生 初次介绍");
					UpdatePersonMember updatePersonMember = new UpdatePersonMember();
					updatePersonMember.setMemberNo(memberNo);
					updatePersonMember.setMemberNoGm(memberNoGm);
					updatePersonMember.setFirstIntroduce(FirstIntroduce.Y.toString());
					personMemberService.updatePersonMemberByMGM(updatePersonMember);

					//产生初次介绍任务
					if(StringUtils.isEmpty(pmType.getFreValue())){
						pmType.setFreValue("0");
					}

					addComTask.setWorkDate(DateUtils.addHours(new Date(), Integer.valueOf(pmType.getFreValue())));
					addComTask.setComTaskType(ComTaskType.FIRST_INTR);
					addComTask.setRemarkCom(CommonConstant.REPLACE_REMARK_COM +"分组客户" );
					addComTask.setLastResultDate(new Date());

					FindComTaskList findComTaskList_temp = new FindComTaskList();
					findComTaskList_temp.setMerchantNo(merchantNo);
					findComTaskList_temp.setComTaskType(ComTaskType.FIRST_INTR);
					FindComTaskListReturn findComTaskListReturn_temp = comTaskListService.findComTaskList(findComTaskList_temp);
					if(findComTaskListReturn_temp != null){
						addComTask.setCodeList(findComTaskListReturn_temp.getCode());
						addComTask.setMemberNo(memberNo);
						if(findClientFollowSummaryReturn != null)
							addComTask.setMemberName(findClientFollowSummaryReturn.getMemberName());
						comTaskService.addComTask(addComTask);
					}else{
						logger.error("初次介绍任务类型不存在！");
					}

					//关闭分组任务
					UpdateComTaskGroup updateComTaskGroup = new UpdateComTaskGroup();
					updateComTaskGroup.setMemberNo(memberNo);
					updateComTaskGroup.setMemberNoGm(memberNoGm);
					updateComTaskGroup.setFinish(ComTaskFinish.FINISH);
					comTaskService.updateComTaskGroup(updateComTaskGroup);

					//分组任务完成，添加积分
					//					FindGuidMember findGuidMember = new FindGuidMember();
					//					findGuidMember.setMemberNo(memberNoGm);
					//					FindGuidMemberReturn findGuidMemberReturn = guidMemberService.findGuidMember(findGuidMember);
					//					GuidMemberIntegralDto guidMemberIntegralDto = new GuidMemberIntegralDto();
					//					guidMemberIntegralDto.setMerchantNo(merchantNo);
					//					guidMemberIntegralDto.setShopNo(findGuidMemberReturn.getShopNo());
					//					guidMemberIntegralDto.setMemberNo(memberNoGm);
					//					guidMemberIntegralDto.setAreaCode(findGuidMemberReturn.getAreaCode());
					//					guidMemberIntegralDto.setIntegralType(IntegralType.COM_TASK.toString());
					//					guidMemberIntegralDto.setAreaName(findGuidMemberReturn.getAreaName());
					//					guidMemberIntegralDto.setMemberName(findGuidMemberReturn.getMemberName());
					//					guidMemberIntegralDto.setMerchantName(findGuidMemberReturn.getMerchantName());
					//					guidMemberIntegralDto.setShopName(findGuidMemberReturn.getShopName());
					//					guidMemberIntegralService.doIntegral(guidMemberIntegralDto);


				}
			}else if(!PmTypeType.UNGROUP.toString().equals(pmTypeOrg.getPmTypeType()) && !PmTypeType.URGENCY.toString().equals(pmType.getPmTypeType()) ){
				logger.debug("意向，非意向之间挪动产生跟进记录,并且不是挪到紧急");
				addCfOrder(merchantNo, memberNoGm, memberNo, pmType, addComTask,true,false);//产生跟进记录
			}

			//不是挪到紧急才产生沟通任务
			/*if(!PmTypeType.URGENCY.toString().equals(pmType.getPmTypeType()) ){
				addComTask.setWorkDate(DateUtils.addHours(new Date(), Integer.valueOf(pmType.getFreValue())));
				FindComTaskList findComTaskList = new FindComTaskList();
				findComTaskList.setMerchantNo(merchantNo);
				findComTaskList.setComTaskType(ComTaskType.COM_TASK);
				FindComTaskListReturn findComTaskListReturn = comTaskListService.findComTaskList(findComTaskList);
				if(findComTaskListReturn != null){
					addComTask.setCodeList(findComTaskListReturn.getCode());
					addComTask.setMemberNo(memberNo);
					if(findClientFollowSummaryReturn != null)
						addComTask.setMemberName(findClientFollowSummaryReturn.getMemberName());
					comTaskService.addComTask(addComTask);
				}
			}*/

		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户分类表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_TYPE_UPDATE_ERROR,"客户分类表信息更新错误！",e);
		}



		logger.debug("changePmType_app(ChangePmTypeApp) - end"); //$NON-NLS-1$
	}


	/**
	 * 
	 *
	 * 方法说明：产生跟进记录
	 *
	 * @param merchantNo
	 * @param memberNoGm
	 * @param memberNo
	 * @param pmType
	 * @param addComTask
	 *
	 * @author 彭阳 CreateDate: 2017年8月8日
	 *
	 */
	private void addCfOrder(String merchantNo, String memberNoGm,
			String memberNo, PmType pmType, AddComTask addComTask,boolean isCreateCf,boolean isAddIntegal) {
		AddClientFollow addClientFollow = new AddClientFollow();
		addClientFollow.setMerchantNo(merchantNo);
		addClientFollow.setCfNo(addComTask.getCfNo());
		addClientFollow.setMemberNo(memberNo);
		addClientFollow.setMemberNoGm(memberNoGm);
		addClientFollow.setFollowType(FollowType.SYSTEM.toString());
		addClientFollow.setFollowInfo("加入" + pmType.getTypeName() + "分组");
		//邀约任务的任务时间做特殊处理，需要靠近周四
		Date now = new Date();
		if(StringUtils.isEmpty(pmType.getFreValue())){
			pmType.setFreValue("0");
		}

		Date followTime = DateUtils.addHours(now, Integer.valueOf(pmType.getFreValue()) );
		addClientFollow.setFollowTime(now);
		addClientFollow.setNextDate(followTime);
		FindComTaskList findComTaskList = new FindComTaskList();
		findComTaskList.setMerchantNo(merchantNo);
		//非意向产生沟通任务，意向产生邀约任务
		if(PmTypeType.OTHER.toString().equals(pmType.getPmTypeType())){
			findComTaskList.setComTaskType(ComTaskType.COM_TASK);
			addClientFollow.setComTaskType(ComTaskType.COM_TASK.toString());
			addClientFollow.setFinishAllComTask(true);//关闭所有任务
		}else{
			findComTaskList.setComTaskType(ComTaskType.INVITE);
			addClientFollow.setComTaskType(ComTaskType.INVITE.toString());
		}
		FindComTaskListReturn findComTaskListReturn = comTaskListService.findComTaskList(findComTaskList);
		if(findComTaskListReturn != null){
			addClientFollow.setTaskCode(findComTaskListReturn.getCode());

		}
		addClientFollow.setComTaskTypeCf(ComTaskType.GROUP.toString());
		clientFollowService.addCFOrder(addClientFollow , "0",isCreateCf,isAddIntegal);
	}


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmTypeService#changeUrgency(com.lj.business.member.dto.ChangeUrgency)
	 */
	@Override
	public void changeUrgency(ChangeUrgency changeUrgency)throws TsfaServiceException {
		logger.debug("changeUrgency(ChangeUrgency changeUrgency={}) - start", changeUrgency); //$NON-NLS-1$

		AssertUtils.notNull(changeUrgency);
		if(StringUtils.isEmpty(changeUrgency.getPmTypePmCode()) && 
				(StringUtils.isEmpty(changeUrgency.getMemberNoGm()) || StringUtils.isEmpty(changeUrgency.getMemberNo()))){
			throw new IllegalArgumentException("（导购编号 && 客户编号） 客户客户分类关联表CODE  不能全部为空！");
		}
		try {
			if(UrgentFlagType.N.equals(changeUrgency.getUrgentFlagType())){
				logger.debug("取消紧急");
				if(StringUtils.isEmpty(changeUrgency.getPmTypePmCode())){//客户表CODE
					PersonMember personMemberQuery = new PersonMember();
					personMemberQuery.setMemberNo(changeUrgency.getMemberNo());
					personMemberQuery.setMemberNoGm(changeUrgency.getMemberNoGm());
					PersonMember personMember = personMemberDao.selectByParamKey(personMemberQuery );

					PmType pmTypeQuery = new PmType();
					pmTypeQuery.setMerchantNo(personMember.getMerchantNo());
					pmTypeQuery.setPmTypeType(PmTypeType.URGENCY.toString());
					PmType pmType = pmTypeDao.selectByParamKey(pmTypeQuery);

					PmTypePm record = new PmTypePm();
					record.setPmTypeCode(pmType.getCode());
					record.setCodePm(personMember.getCode());
					pmTypePmDao.deleteByParamKey(record );

					//紧急处理
					UpdatePersonMember updatePersonMember = new UpdatePersonMember();
					updatePersonMember.setMemberNo(personMember.getMemberNo());
					updatePersonMember.setMemberNoGm(personMember.getMemberNoGm());
					updatePersonMember.setUrgencyPm(UrgentFlagType.N.toString());
					personMemberService.updatePersonMemberByMGM(updatePersonMember);
				}else{
					PmTypePm pmTypePm = pmTypePmDao.selectByPrimaryKey(changeUrgency.getPmTypePmCode());
					pmTypePmDao.deleteByPrimaryKey(changeUrgency.getPmTypePmCode());

					//紧急处理
					UpdatePersonMember updatePersonMember = new UpdatePersonMember();
					updatePersonMember.setCode(pmTypePm.getCodePm());
					updatePersonMember.setUrgencyPm(UrgentFlagType.N.toString());
					personMemberService.updatePersonMember(updatePersonMember);
				}
			}else if(UrgentFlagType.Y.equals(changeUrgency.getUrgentFlagType())){
				logger.debug("新增紧急");
				AssertUtils.notAllNullAndEmpty(changeUrgency.getMemberNoGm(), changeUrgency.getMemberNo());
				
				PersonMember personMemberQuery = new PersonMember();
				personMemberQuery.setMemberNo(changeUrgency.getMemberNo());
				personMemberQuery.setMemberNoGm(changeUrgency.getMemberNoGm());
				PersonMember personMember = personMemberDao.selectByParamKey(personMemberQuery );

				PmType pmTypeQuery = new PmType();
				pmTypeQuery.setMerchantNo(personMember.getMerchantNo());
				pmTypeQuery.setPmTypeType(PmTypeType.URGENCY.toString());
				PmType pmType = pmTypeDao.selectByParamKey(pmTypeQuery);

				PmTypePm record = new PmTypePm();
				record.setCode(GUID.generateCode());
				record.setPmTypeCode(pmType.getCode());
				record.setCodePm(personMember.getCode());
				pmTypePmDao.insert(record);

				//紧急处理
				UpdatePersonMember updatePersonMember = new UpdatePersonMember();
				updatePersonMember.setMemberNo(personMember.getMemberNo());
				updatePersonMember.setMemberNoGm(personMember.getMemberNoGm());
				updatePersonMember.setUrgencyPm(UrgentFlagType.Y.toString());
				personMemberService.updatePersonMemberByMGM(updatePersonMember);
				
			}

		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户分类表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_TYPE_UPDATE_ERROR,"客户分类表信息更新错误！",e);
		}

		logger.debug("changeUrgency(ChangeUrgency) - end"); //$NON-NLS-1$
	}

	@Override
	public List<FindPmType> inqueryMemberOutOffGroupInfo(String merchantNo,String memberNo,String memberNoGm,String flag) throws TsfaServiceException {
		List<PmType> list = new ArrayList<>();
		List<FindPmType> retlist = new ArrayList<FindPmType>();
		if(!StringUtils.isEmpty(flag)){
			if("1".equals(flag)){
				//新增
				list = pmTypeDao.inqueryNewMemberOutOffGroupInfo(merchantNo);
			}else if("2".equals(flag)){
				//修改
				//查询客户分类 除去交叉、成单、暂停、紧急、未分组
				list = pmTypeDao.inqueryModifyMemberOutOffGroupInfo(merchantNo);
				//判断客户分类是否包含未分组
				FindPersonMember findPersonMember = new FindPersonMember();
				findPersonMember.setMemberNo(memberNo);	
				findPersonMember.setMemberNoGm(memberNoGm);
				FindPersonMemberReturn findPersonMemberReturn = personMemberService.findPersonMemberByMGM(findPersonMember);
				if(findPersonMemberReturn != null){
					Map<String,Object> map = new HashMap<>();
					map.put("merchantNo", merchantNo);
					map.put("codePm", findPersonMemberReturn.getCode());
					/*int count = pmTypeDao.selectInUnGroupCount(map);
					if(count <= 0){
						//不包含未分组则去除未分组，意向（到店）不能移动到意向（未到店）
						List<PmType> listtemp = new ArrayList<>();
						for(PmType pt:list){
							if(!pt.getPmTypeType().equals(PmTypeType.UNGROUP.toString())){
								listtemp.add(pt);
							}

						}
						list = listtemp;
					}*/
					int countIntention = pmTypeDao.selectIntentionCount(map);
					if(countIntention > 0){
						//意向（到店）不能移动到意向（未到店）,去除意向（未到店）
						List<PmType> listtemp = new ArrayList<>();
						for(PmType pt:list){
							if(!pt.getPmTypeType().equals(PmTypeType.INTENTION_N.toString())){
								listtemp.add(pt);
							}

						}
						list = listtemp;
					}
				}
			}
		}
		if(list != null && list.size() > 0){
			for(PmType pt:list){
				FindPmType dto = new FindPmType();
				dto.setCode(pt.getCode());
				dto.setPmTypeType(pt.getPmTypeType());
				dto.setTypeName(pt.getTypeName());
				retlist.add(dto);
			}
		}
		return retlist;
	}



	@Override
	public void changePmType_app_ungroup(ChangePmTypeUngroup changePmTypeUngroup)
			throws TsfaServiceException {
		logger.debug("changePmType_app_ungroup(ChangePmTypeUngroup changePmTypeUngroup={}) - start", changePmTypeUngroup); //$NON-NLS-1$

		AssertUtils.notNull(changePmTypeUngroup);
		String pmTypeCode = changePmTypeUngroup.getPmTypeCode();
		AssertUtils.notNullAndEmpty(pmTypeCode,"客户分类CODE 不能为空");
		String merchantNo = changePmTypeUngroup.getMerchantNo();
		String memberNoGm = changePmTypeUngroup.getMemberNoGm();
		String memberNo = changePmTypeUngroup.getMemberNo();
		AssertUtils.notNullAndEmpty(merchantNo,"商户编号不能为空");
		AssertUtils.notNullAndEmpty(memberNoGm,"导购编号不能为空");
		AssertUtils.notNullAndEmpty(memberNo,"客户编号不能为空");
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("memberNo", memberNo);
			map.put("memberNoGm", memberNoGm);
			String pmTypePmCode =  pmTypeDao.selectPmTypePmCode(map );

			ChangePmTypeApp changePmTypeApp = new ChangePmTypeApp();
			changePmTypeApp.setCode(pmTypePmCode);
			changePmTypeApp.setMemberNo(memberNo);
			changePmTypeApp.setMemberNoGm(memberNoGm);
			changePmTypeApp.setMerchantNo(merchantNo);
			changePmTypeApp.setPmTypeCode(changePmTypeUngroup.getPmTypeCode());
			this.changePmType_app(changePmTypeApp );


		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户分类表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_TYPE_UPDATE_ERROR,"客户分类表信息更新错误！",e);
		}


		logger.debug("changePmType_app_ungroup(ChangePmTypeUngroup) - end"); //$NON-NLS-1$
	}


	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmTypeService#addPmTypePmRepeat(com.lj.business.member.dto.AddPmTypePmDto)
	 */
	@Override
	public void addPmTypePmRepeat(AddPmTypePmDto addPmTypePmDto) throws TsfaServiceException{
		logger.debug("addPmTypePmRepeat(AddPmTypePmDto addPmTypePmDto={}) - start", addPmTypePmDto); //$NON-NLS-1$

		AssertUtils.notNull(addPmTypePmDto);
		AssertUtils.notNullAndEmpty(addPmTypePmDto.getCodePm(), "会员code不能为空");
		AssertUtils.notNullAndEmpty(addPmTypePmDto.getPmTypeCode(), "分组code不能为空");
		try{
			FindPmTypePmReturn findPmTypePmReturn = pmTypePmDao.findByPmCodeAndPmTypeCode(addPmTypePmDto);
			if(findPmTypePmReturn == null){
				PmTypePm p1 = new PmTypePm();
				p1.setCode(GUID.getPreUUID());
				p1.setCodePm(addPmTypePmDto.getCodePm());
				p1.setPmTypeCode(addPmTypePmDto.getPmTypeCode());
				p1.setCreateDate(new Date());
				pmTypePmDao.insert(p1);
			}
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户分类表信息添加错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_TYPE_ADD_ERROR,"客户分类表信息添加错误！",e);
		}

		logger.debug("addPmTypePmRepeat() - end"); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IPmTypeService#addPmTypePm(com.lj.business.member.dto.AddPmTypePmDto)
	 */
	@Override
	public void addPmTypePm(AddPmTypePmDto addPmTypePmDto) throws TsfaServiceException {
		logger.debug("addPmTypePm(AddPmTypePmDto addPmTypePmDto={}) - start", addPmTypePmDto); //$NON-NLS-1$

		AssertUtils.notNull(addPmTypePmDto);
		AssertUtils.notNullAndEmpty(addPmTypePmDto.getCodePm(), "会员code不能为空");
		AssertUtils.notNullAndEmpty(addPmTypePmDto.getPmTypeCode(), "分组code不能为空");
		try{
			PmTypePm p1 = new PmTypePm();
			p1.setCode(GUID.getPreUUID());
			p1.setCodePm(addPmTypePmDto.getCodePm());
			p1.setPmTypeCode(addPmTypePmDto.getPmTypeCode());
			p1.setCreateDate(new Date());
			pmTypePmDao.insert(p1);
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户分类表信息添加错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_TYPE_ADD_ERROR,"客户分类表信息添加错误！",e);
		}

		logger.debug("addPmTypePm() - end"); //$NON-NLS-1$
	} 

	@Override
	public CheckPmTypeReturn checkPmType(CheckPmTypeDto checkPmTypeDto) throws TsfaServiceException {
		AssertUtils.notNull(checkPmTypeDto);
		AssertUtils.notNullAndEmpty(checkPmTypeDto.getMemberNo(), "会员编号不能为空");
		AssertUtils.notNullAndEmpty(checkPmTypeDto.getMemberNoGm(), "导购编号不能为空");
		AssertUtils.notNullAndEmpty(checkPmTypeDto.getMerchantNo(), "商户编号不能为空");
		try{
			CheckPmTypeReturn checkPmTypeReturn = new CheckPmTypeReturn();
			FindPersonMember findPersonMember = new FindPersonMember();
			findPersonMember.setMemberNo(checkPmTypeDto.getMemberNo());
			findPersonMember.setMemberNoGm(checkPmTypeDto.getMemberNoGm());
			findPersonMember.setMerchantNo(checkPmTypeDto.getMerchantNo());
			FindPersonMemberReturn findPersonMemberReturn = personMemberService.findPersonMemberByMGM(findPersonMember);
			if(findPersonMemberReturn != null){
				FindPmTypePmListByMGMDto findPmTypePmListByMGMDto = new FindPmTypePmListByMGMDto();
				findPmTypePmListByMGMDto.setCodePm(findPersonMemberReturn.getCode());
				List<FindPmTypePmListByMGMReturn> list = pmTypePmDao.findPmTypePmListByMGM(findPmTypePmListByMGMDto);
				if(list != null && list.size() > 0){
					//客户是否意向(到店)或者意向(非到店)
					//客户是否非意向
					//客户是否未分组
					for(FindPmTypePmListByMGMReturn findPmTypePmListByMGMReturn : list){
						if(PmTypeType.INTENTION.toString().equals( findPmTypePmListByMGMReturn.getPmTypeType())){
							checkPmTypeReturn.setIntention(true);
						}
						if(PmTypeType.INTENTION_N.toString().equals( findPmTypePmListByMGMReturn.getPmTypeType())){
							checkPmTypeReturn.setIntention(true);
						}

						if(PmTypeType.UNGROUP.toString().equals( findPmTypePmListByMGMReturn.getPmTypeType())){
							checkPmTypeReturn.setUngroup(true);
						}

						if(PmTypeType.OTHER.toString().equals( findPmTypePmListByMGMReturn.getPmTypeType())){
							checkPmTypeReturn.setOther(true);
						}
					}
				}
			}
			return checkPmTypeReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户分类表信息查询错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_TYPE_FIND_ERROR,"客户分类表信息查询错误！",e);
		}

	}


	@Override
	public String findPmTypeTypeByPm(String codePm)
			throws TsfaServiceException {
		logger.debug("findPmTypeCodeByPm(String codePm={}) - start", codePm);
		AssertUtils.notNullAndEmpty(codePm, "客户编号不能为空");
		String typeType = pmTypeDao.findPmTypeCodeByPm(codePm).get(0);
		logger.debug("addPmTypePm() - end typeType={}", typeType);
		return typeType;
	}

}
