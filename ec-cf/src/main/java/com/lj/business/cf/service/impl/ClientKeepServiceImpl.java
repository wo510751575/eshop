package com.lj.business.cf.service.impl;

import java.util.Date;
import java.util.HashMap;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
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
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.IClientKeepDao;
import com.lj.business.cf.domain.ClientKeep;
import com.lj.business.cf.dto.FindCForCKLastDateDto;
import com.lj.business.cf.dto.clientFollowSummary.AddPmClientFollowFirstDto;
import com.lj.business.cf.dto.clientKeep.AddClientKeep;
import com.lj.business.cf.dto.clientKeep.AddClientKeepReturn;
import com.lj.business.cf.dto.clientKeep.DelClientKeep;
import com.lj.business.cf.dto.clientKeep.DelClientKeepReturn;
import com.lj.business.cf.dto.clientKeep.FindClientKeep;
import com.lj.business.cf.dto.clientKeep.FindClientKeepPage;
import com.lj.business.cf.dto.clientKeep.FindClientKeepPageReturn;
import com.lj.business.cf.dto.clientKeep.FindClientKeepReturn;
import com.lj.business.cf.dto.clientKeep.UpdateClientKeep;
import com.lj.business.cf.dto.clientKeep.UpdateClientKeepReturn;
import com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummary;
import com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummaryReturn;
import com.lj.business.cf.dto.clientKeepSummary.UpdateClientKeepSummary;
import com.lj.business.cf.dto.comTask.AddComTask;
import com.lj.business.cf.dto.comTask.GenerateNextDate;
import com.lj.business.cf.dto.comTaskList.FindComTaskList;
import com.lj.business.cf.dto.comTaskList.FindComTaskListReturn;
import com.lj.business.cf.emus.BuyType;
import com.lj.business.cf.emus.ComTaskType;
import com.lj.business.cf.emus.FollowNoType;
import com.lj.business.cf.service.IClientFollowSummaryService;
import com.lj.business.cf.service.IClientKeepService;
import com.lj.business.cf.service.IClientKeepSummaryService;
import com.lj.business.cf.service.IComTaskListService;
import com.lj.business.cf.service.IComTaskService;
import com.lj.business.common.CommonConstant;
import com.lj.business.common.SystemParamConstant;
import com.lj.business.member.dto.ChangePmType;
import com.lj.business.member.dto.FindGuidMember;
import com.lj.business.member.dto.FindGuidMemberReturn;
import com.lj.business.member.dto.FindPersonMember;
import com.lj.business.member.dto.FindPersonMemberReturn;
import com.lj.business.member.dto.UpdatePersonMember;
import com.lj.business.member.emus.PmTypeType;
import com.lj.business.member.service.IGuidMemberService;
import com.lj.business.member.service.IPersonMemberBaseService;
import com.lj.business.member.service.IPersonMemberService;
import com.lj.business.member.service.IPmTypeService;
import com.lj.cc.clientintf.LocalCacheSystemParamsFromCC;
import com.lj.cc.enums.SystemAliasName;


/**
 * 类说明：实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 邹磊
 * 
 * 
 * CreateDate: 2017-06-14
 */
@Service
public class ClientKeepServiceImpl implements IClientKeepService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ClientKeepServiceImpl.class);
	

	/** The clent keep dao. */
	@Resource
	private IClientKeepDao clientKeepDao;
	
	/** The com task service. */
	@Resource
	private IComTaskService comTaskService;
	
	/** The person member base service. */
	@Resource
	private IPersonMemberBaseService personMemberBaseService;
	
	/** The guid member service. */
	@Resource
	private IGuidMemberService guidMemberService;
	
	/** The client follow summary service. */
	@Resource
	private IClientFollowSummaryService clientFollowSummaryService;
	
	/** The client keep summary service. */
	@Resource
	private IClientKeepSummaryService clientKeepSummaryService;
	
	/** The pm type service. */
	@Resource
	private IPmTypeService pmTypeService;
	
	/** The person member service. */
	@Resource
	private IPersonMemberService personMemberService;
	
	@Resource
	private IComTaskListService comTaskListService;
	
	@Resource
	private LocalCacheSystemParamsFromCC localCacheSystemParams;
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientKeepService#addClentKeep(com.lj.business.cf.dto.AddClientKeep)
	 */
	@Override
	public AddClientKeepReturn addClientKeep(
			AddClientKeep addClientKeep) throws TsfaServiceException {
		logger.debug("addClentKeep(AddClientKeep addClentKeep={}) - start", addClientKeep); 

		AssertUtils.notNull(addClientKeep);
		try {
			ClientKeep clientKeep = new ClientKeep();
			//add数据录入
			clientKeep.setCode(GUID.generateCode());
			clientKeep.setMerchantNo(addClientKeep.getMerchantNo());
			clientKeep.setMemberNo(addClientKeep.getMemberNo());
			clientKeep.setMemberName(addClientKeep.getMemberName());
			clientKeep.setMemberNoGm(addClientKeep.getMemberNoGm());
			clientKeep.setMemberNameGm(addClientKeep.getMemberNameGm());
			clientKeep.setCkNo(addClientKeep.getCkNo());
			clientKeep.setKeepNum(addClientKeep.getKeepNum());
			clientKeep.setKeepTime(addClientKeep.getKeepTime());
			clientKeep.setKeepType(addClientKeep.getKeepType());
			clientKeep.setKeepContent(addClientKeep.getKeepContent());
			clientKeep.setNextDate(addClientKeep.getNextDate());
			clientKeep.setBuy(addClientKeep.getBuy());
			clientKeep.setBomCode(addClientKeep.getBomCode());
			clientKeep.setBomName(addClientKeep.getBomName());
			clientKeep.setRemark(addClientKeep.getRemark());
			clientKeep.setCreateId(addClientKeep.getCreateId());
			clientKeep.setRemark4(addClientKeep.getRemark4());
			clientKeep.setRemark3(addClientKeep.getRemark3());
			clientKeep.setRemark2(addClientKeep.getRemark2());
			clientKeepDao.insert(clientKeep);
			AddClientKeepReturn addClientKeepReturn = new AddClientKeepReturn();
			
			logger.debug("addClentKeep(AddClientKeep) - end - return value={}", addClientKeepReturn); 
			return addClientKeepReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户维护记录表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLENT_KEEP_ADD_ERROR,"新增客户维护记录表信息错误！",e);
		}
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientKeepService#delClentKeep(com.lj.business.cf.dto.DelClientKeep)
	 */
	@Override
	public DelClientKeepReturn delClientKeep(
			DelClientKeep delClientKeep) throws TsfaServiceException {
		logger.debug("delClentKeep(DelClientKeep delClentKeep={}) - start", delClientKeep); 

		AssertUtils.notNull(delClientKeep);
		AssertUtils.notNull(delClientKeep.getCode(),"Code不能为空！");
		try {
			clientKeepDao.deleteByPrimaryKey(delClientKeep.getCode());
			DelClientKeepReturn delClientKeepReturn  = new DelClientKeepReturn();

			logger.debug("delClentKeep(DelClientKeep) - end - return value={}", delClientKeepReturn); //$NON-NLS-1$
			return delClientKeepReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除客户维护记录表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLENT_KEEP_DEL_ERROR,"删除客户维护记录表信息错误！",e);

		}
	}

	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientKeepService#updateClentKeep(com.lj.business.cf.dto.UpdateClientKeep)
	 */
	@Override
	public UpdateClientKeepReturn updateClientKeep(
			UpdateClientKeep updateClientKeep)
			throws TsfaServiceException {
		logger.debug("updateClentKeep(UpdateClientKeep updateClentKeep={}) - start", updateClientKeep); //$NON-NLS-1$

		AssertUtils.notNull(updateClientKeep);
		AssertUtils.notNullAndEmpty(updateClientKeep.getCode(),"Code不能为空");
		try {
			ClientKeep clientKeep = new ClientKeep();
			//update数据录入
			clientKeep.setCode(updateClientKeep.getCode());
			clientKeep.setCkNo(updateClientKeep.getCkNo());
			clientKeep.setMerchantNo(updateClientKeep.getMerchantNo());
			clientKeep.setMemberNo(updateClientKeep.getMemberNo());
			clientKeep.setMemberName(updateClientKeep.getMemberName());
			clientKeep.setMemberNoGm(updateClientKeep.getMemberNoGm());
			clientKeep.setMemberNameGm(updateClientKeep.getMemberNameGm());
			clientKeep.setCkNo(updateClientKeep.getCkNo());
			clientKeep.setKeepNum(updateClientKeep.getKeepNum());
			clientKeep.setKeepTime(updateClientKeep.getKeepTime());
			clientKeep.setKeepType(updateClientKeep.getKeepType());
			clientKeep.setKeepContent(updateClientKeep.getKeepContent());
			clientKeep.setNextDate(updateClientKeep.getNextDate());
			clientKeep.setBuy(updateClientKeep.getBuy());
			clientKeep.setBomCode(updateClientKeep.getBomCode());
			clientKeep.setBomName(updateClientKeep.getBomName());
			clientKeep.setRemark(updateClientKeep.getRemark());
			clientKeep.setRemark4(updateClientKeep.getRemark4());
			clientKeep.setRemark3(updateClientKeep.getRemark3());
			clientKeep.setRemark2(updateClientKeep.getRemark2());
			AssertUtils.notUpdateMoreThanOne(clientKeepDao.updateByPrimaryKeySelective(clientKeep));
			UpdateClientKeepReturn updateClientKeepReturn = new UpdateClientKeepReturn();

			logger.debug("updateClentKeep(UpdateClientKeep) - end - return value={}", updateClientKeepReturn); //$NON-NLS-1$
			return updateClientKeepReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户维护记录表信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLENT_KEEP_UPDATE_ERROR,"客户维护记录表信息更新信息错误！",e);
		}
	}

	

	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientKeepService#findClentKeep(com.lj.business.cf.dto.FindClientKeep)
	 */
	@Override
	public FindClientKeepReturn findClientKeep(
			FindClientKeep findClientKeep) throws TsfaServiceException {
		logger.debug("findClentKeep(FindClientKeep findClentKeep={}) - start", findClientKeep); //$NON-NLS-1$

		AssertUtils.notNull(findClientKeep);
		AssertUtils.notAllNull(findClientKeep.getCode(),"Code不能为空");
		try {
			ClientKeep clientKeep = clientKeepDao.selectByPrimaryKey(findClientKeep.getCode());
			if(clientKeep == null){
				throw new TsfaServiceException(ErrorCode.CLENT_KEEP_NOT_EXIST_ERROR,"客户维护记录表信息不存在");
			}
			FindClientKeepReturn findClientKeepReturn = new FindClientKeepReturn();
			//find数据录入
			findClientKeepReturn.setCode(clientKeep.getCode());
			findClientKeepReturn.setMerchantNo(clientKeep.getMerchantNo());
			findClientKeepReturn.setMemberNo(clientKeep.getMemberNo());
			findClientKeepReturn.setMemberName(clientKeep.getMemberName());
			findClientKeepReturn.setMemberNoGm(clientKeep.getMemberNoGm());
			findClientKeepReturn.setMemberNameGm(clientKeep.getMemberNameGm());
			findClientKeepReturn.setCkNo(clientKeep.getCkNo());
			findClientKeepReturn.setKeepNum(clientKeep.getKeepNum());
			findClientKeepReturn.setKeepTime(clientKeep.getKeepTime());
			findClientKeepReturn.setKeepType(clientKeep.getKeepType());
			findClientKeepReturn.setKeepContent(clientKeep.getKeepContent());
			findClientKeepReturn.setNextDate(clientKeep.getNextDate());
			findClientKeepReturn.setBuy(clientKeep.getBuy());
			findClientKeepReturn.setBomCode(clientKeep.getBomCode());
			findClientKeepReturn.setBomName(clientKeep.getBomName());
			findClientKeepReturn.setRemark(clientKeep.getRemark());
			findClientKeepReturn.setCreateId(clientKeep.getCreateId());
			findClientKeepReturn.setCreateDate(clientKeep.getCreateDate());
			findClientKeepReturn.setRemark4(clientKeep.getRemark4());
			findClientKeepReturn.setRemark3(clientKeep.getRemark3());
			findClientKeepReturn.setRemark2(clientKeep.getRemark2());
			
			logger.debug("findClentKeep(FindClientKeep) - end - return value={}", findClientKeepReturn); //$NON-NLS-1$
			return findClientKeepReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户维护记录表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLENT_KEEP_FIND_ERROR,"查找客户维护记录表信息信息错误！",e);
		}


	}

	
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientKeepService#findClentKeepPage(com.lj.business.cf.dto.FindClientKeepPage)
	 */
	@Override
	public Page<FindClientKeepPageReturn> findClientKeepPage(
			FindClientKeepPage findClientKeepPage)
			throws TsfaServiceException {
		logger.debug("findClentKeepPage(FindClientKeepPage findClentKeepPage={}) - start", findClientKeepPage); //$NON-NLS-1$

		AssertUtils.notNull(findClientKeepPage);
		List<FindClientKeepPageReturn> returnList;
		int count = 0;
		try {
			returnList = clientKeepDao.findClientKeepPage(findClientKeepPage);
			count = clientKeepDao.findClientKeepPageCount(findClientKeepPage);
		}  catch (Exception e) {
			logger.error("客户维护记录表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.CLENT_KEEP_FIND_PAGE_ERROR,"客户维护记录表信息分页查询错误.！",e);
		}
		Page<FindClientKeepPageReturn> returnPage = new Page<FindClientKeepPageReturn>(returnList, count, findClientKeepPage);

		logger.debug("findClentKeepPage(FindClientKeepPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}



	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientKeepService#clientKeepHistory(com.lj.business.cf.dto.FindClientKeep)
	 */
	
	@Override
	public List<FindClientKeepReturn> clientKeepHistory(FindClientKeep findClientKeep) throws TsfaServiceException {
		logger.debug("clientKeepHistory(FindClientKeep clientKeepHistory={}) - start", findClientKeep); //$NON-NLS-1$

		List<FindClientKeepReturn> returnList;
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("memberNo", findClientKeep.getMemberNo());
			map.put("memberGMCode", findClientKeep.getMemberGMCode());
			map.put("ckNo", findClientKeep.getCkNo());
			returnList = clientKeepDao.clientKeepHistory(map);
		}  catch (Exception e) {
			logger.error("查找客户跟踪表信息错误",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_FIND_ERROR,"查找客户跟踪表信息错误.！",e);
		}

		logger.debug("clientKeepHistory(clientKeepHistory) - end - return value={}", returnList); //$NON-NLS-1$
		return  returnList;
	}



	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientKeepService#addClientKeepInfo(com.lj.business.cf.dto.AddClientKeep)
	 */
	
	@Override
	public AddClientKeepReturn addClientKeepInfo(AddClientKeep addClientKeep) throws TsfaServiceException {
		logger.debug("addClentKeep(AddClientKeep addClentKeep={}) - start", addClientKeep); 

		AssertUtils.notNull(addClientKeep);
		try {
			ClientKeep clientKeep = new ClientKeep();
			//add数据录入
			clientKeep.setCode(GUID.generateCode());
			clientKeep.setCkNo(addClientKeep.getCkNo());
			clientKeep.setMerchantNo(addClientKeep.getMerchantNo());
			clientKeep.setMemberNo(addClientKeep.getMemberNo());
			
			//会员名称
			FindGuidMemberReturn findGuidMemberReturn = null;
			FindPersonMemberReturn findPersonMemberReturntemp = null;
			String memberName = "";
			if(StringUtils.isEmpty(addClientKeep.getMemberName())){
				
				FindPersonMember findPersonMember = new FindPersonMember();
				findPersonMember.setMemberNo(addClientKeep.getMemberNo());
				findPersonMember.setMemberNoGm(addClientKeep.getMemberNoGm());
				findPersonMemberReturntemp = personMemberService.findPersonMemberByMGM(findPersonMember);
				if(findPersonMemberReturntemp != null){
					memberName = findPersonMemberReturntemp.getMemberName();
				}
			}else{
				memberName = addClientKeep.getMemberName();
			}
			
			//导购名称
			String memberNameGm = "";
			if(StringUtils.isEmpty(addClientKeep.getMemberNameGm())){
				FindGuidMember findGuidMember = new FindGuidMember();
				findGuidMember.setMemberNo(addClientKeep.getMemberNoGm());
				findGuidMemberReturn = guidMemberService.findGuidMember(findGuidMember);
				if(findGuidMemberReturn != null){
					memberNameGm = findGuidMemberReturn.getMemberName();
				}
			}else{
				memberNameGm = addClientKeep.getMemberNameGm();
			}
			
			clientKeep.setMemberName(memberName);
			clientKeep.setMemberNameGm(memberNameGm);
			clientKeep.setMemberNoGm(addClientKeep.getMemberNoGm());
			
			//通过客户CODE,导购CODE,维护总表no获取维护记录列表
			Map<String, String> map = new HashMap<String, String>();
			map.put("memberNo", addClientKeep.getMemberNo());
			map.put("memberGMCode", addClientKeep.getMemberNoGm());
			map.put("ckNo", addClientKeep.getCkNo());
			List<FindClientKeepReturn> list = clientKeepDao.clientKeepHistory(map);
			FindClientKeepReturn ckR = null;
			if(list != null && list.size() >0){
				ckR = list.get(0);
				clientKeep.setKeepNum(ckR.getKeepNum()+1);
			}else{
				clientKeep.setKeepNum(1);
			}
			
			clientKeep.setKeepTime(addClientKeep.getKeepTime());
			clientKeep.setKeepType(addClientKeep.getKeepType());
			clientKeep.setKeepContent(addClientKeep.getKeepContent());
			clientKeep.setNextDate(addClientKeep.getNextDate());
			clientKeep.setBuy(addClientKeep.getBuy());
			clientKeep.setBomCode(addClientKeep.getBomCode());
			clientKeep.setBomName(addClientKeep.getBomName());
			clientKeep.setRemark(addClientKeep.getRemark());
			clientKeep.setCreateId(addClientKeep.getCreateId());
			clientKeep.setRemark4(addClientKeep.getRemark4());
			clientKeep.setRemark3(addClientKeep.getRemark3());
			clientKeep.setRemark2(addClientKeep.getRemark2());
			clientKeepDao.insert(clientKeep);
			
			AddClientKeepReturn addClientKeepReturn = new AddClientKeepReturn();
			addClientKeepReturn.setCode(clientKeep.getCode());
			addClientKeepReturn.setKeepNum(clientKeep.getKeepNum());
			logger.debug("addClentKeep(AddClientKeep) - end - return value={}", addClientKeepReturn); 
			return addClientKeepReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户维护记录表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLENT_KEEP_ADD_ERROR,"新增客户维护记录表信息错误！",e);
		}
	}


	/**
	 * 新增客户维护表信息.
	 *
	 * @param addClientKeep the add client keep
	 * @return the adds the client keep return
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public AddClientKeepReturn newClientKeepInfo(AddClientKeep addClientKeep) throws TsfaServiceException {
		AssertUtils.notNull(addClientKeep);
		AssertUtils.notNullAndEmpty(addClientKeep.getBuy(), "是否购买不能为空");
		AssertUtils.notNullAndEmpty(addClientKeep.getCkNo(), "维护总表号不能为空");
		AssertUtils.notNullAndEmpty(addClientKeep.getMemberNo(), "客户编号不能为空");
		AssertUtils.notNullAndEmpty(addClientKeep.getMemberName(), "客户名称不能为空");
		AssertUtils.notNullAndEmpty(addClientKeep.getMemberNoGm(), "导购编号不能为空");
		
		try {
			//如果维护已经结束不能再次维护
			FindClientKeepSummary findClientKeepSummary = new FindClientKeepSummary();
			findClientKeepSummary.setCkNo(addClientKeep.getCkNo());
			FindClientKeepSummaryReturn findClientKeepSummaryReturn = clientKeepSummaryService.findClientKeepSummaryByCkNo(findClientKeepSummary);
			if(findClientKeepSummaryReturn == null || findClientKeepSummaryReturn.getEndDate() != null){
				throw new TsfaServiceException(ErrorCode.CLIENT_KEEP_DATA_ERROR,"维护数据异常！");
			}
			
			AddClientKeepReturn addClientKeepReturn = new AddClientKeepReturn();
			//非购买
			if(BuyType.N.toString().equals(addClientKeep.getBuy())){
				AssertUtils.notNullAndEmpty(addClientKeep.getKeepTime(), "维护时间不能为空");
				
				//产生沟通任务
				AddComTask addComTask = new AddComTask();
				addComTask.setMerchantNo(addClientKeep.getMerchantNo());
				addComTask.setMemberNoGm(addClientKeep.getMemberNoGm());
				addComTask.setCfNo(addClientKeep.getCkNo());
				addComTask.setNoType(FollowNoType.KEEP.toString());
				addComTask.setComTaskType(ComTaskType.COM_TASK);
				addComTask.setRemarkCom(CommonConstant.REPLACE_REMARK_COM +"维护客户");
				addComTask.setLastResultDate(new Date());
				
				// 任务频率设置
				if(addClientKeep.getNextDate() != null){
				   addComTask.setWorkDate(addClientKeep.getNextDate());
				}else{
					String freValue =  localCacheSystemParams.getSystemParam(SystemAliasName.cf.toString(),SystemParamConstant.TASK, SystemParamConstant.KEEP_TO_INVITE);
					int hour = 0;
					if(!StringUtils.isEmpty(freValue)){
						hour = Integer.valueOf(freValue);
					}
					
				//	GenerateNextDate generateNextDate = new GenerateNextDate ();
					//generateNextDate.setNextDate(DateUtils.addHours(new Date(), hour));
					Date nDate = DateUtils.addHours(new Date(), hour);
					
					addComTask.setWorkDate(nDate);
					addClientKeep.setNextDate(nDate);
				}
				
				//产生维护记录
				addClientKeep.setBuy(BuyType.N.toString());
				addClientKeepReturn = addClientKeepInfo(addClientKeep);
				//更新维护总表数量
				UpdateClientKeepSummary updateClientKeepSummary = new UpdateClientKeepSummary();
				updateClientKeepSummary.setCkNo(addClientKeep.getCkNo());
				updateClientKeepSummary.setBuy(BuyType.N.toString());
				updateClientKeepSummary.setKeepNum(addClientKeepReturn.getKeepNum());
				clientKeepSummaryService.updateByCkNo(updateClientKeepSummary);
				
				//产生沟通任务
				FindComTaskList findComTaskList = new FindComTaskList();
				findComTaskList.setMerchantNo(addClientKeep.getMerchantNo());
				findComTaskList.setComTaskType(ComTaskType.COM_TASK);
				FindComTaskListReturn findComTaskListReturn = comTaskListService.findComTaskList(findComTaskList);
				if(findComTaskListReturn != null){
					addComTask.setCodeList(findComTaskListReturn.getCode());
					addComTask.setMemberNo(addClientKeep.getMemberNo());
					addComTask.setMemberName(addClientKeep.getMemberName());
					comTaskService.addComTaskWithFinish(addComTask,"0");
				}
			}
			//购买 
			if(BuyType.Y.toString().equals(addClientKeep.getBuy())){
				AssertUtils.notNullAndEmpty(addClientKeep.getBomName(), "产品不能为空");
				if(addClientKeep.getKeepTime() != null && addClientKeep.getNextDate() != null){
					if(addClientKeep.getKeepTime().compareTo(addClientKeep.getNextDate()) > 0){
						throw new TsfaServiceException(ErrorCode.CLIENT_KEEP_DATE_ERROR,"维护时间大于下次跟进时间！");
					}
				}
				
				//产生跟进总表和第一条跟进明细记录
				AddPmClientFollowFirstDto addPmClientFollowFirstDto = new AddPmClientFollowFirstDto();
				addPmClientFollowFirstDto.setMerchantNo(addClientKeep.getMerchantNo());
				addPmClientFollowFirstDto.setMemberNo(addClientKeep.getMemberNo());
				addPmClientFollowFirstDto.setMemberName(addClientKeep.getMemberName());
				addPmClientFollowFirstDto.setMemberNoGm(addClientKeep.getMemberNoGm());
				addPmClientFollowFirstDto.setMemberNameGm(addClientKeep.getMemberNameGm());
				String cfNo = clientFollowSummaryService.addSummaryWithClientFollow(addPmClientFollowFirstDto);
				
				//产生邀约任务
				AddComTask addComTask = new AddComTask();
				addComTask.setMerchantNo(addClientKeep.getMerchantNo());
				addComTask.setMemberNoGm(addClientKeep.getMemberNoGm());
				addComTask.setCfNo(cfNo);
				addComTask.setNoType(FollowNoType.FOLLOW.toString());
				addComTask.setRemarkCom(CommonConstant.REPLACE_REMARK_COM + "维护客户，有新购买需求");
				addComTask.setLastResultDate(new Date());
				
				//产生维护记录
			    // 任务频率设置
				if(addClientKeep.getNextDate() != null){
				   addComTask.setWorkDate(addClientKeep.getNextDate());
				}else{
					String freValue =  localCacheSystemParams.getSystemParam(SystemAliasName.cf.toString(),SystemParamConstant.TASK, SystemParamConstant.KEEP_TO_INVITE);
					int hour = 0;
					if(!StringUtils.isEmpty(freValue)){
						hour = Integer.valueOf(freValue);
					}
					
					GenerateNextDate generateNextDate = new GenerateNextDate ();
					generateNextDate.setNextDate(DateUtils.addHours(new Date(), hour));
					Date nDate = comTaskService.generateNextDate(generateNextDate);
					
					addComTask.setWorkDate(nDate);
					addClientKeep.setNextDate(nDate);
				}
				
				addClientKeep.setBuy(BuyType.Y.toString());
				addClientKeepReturn = addClientKeepInfo(addClientKeep);
				
				//维护总表结束
				UpdateClientKeepSummary updateClientKeepSummary = new UpdateClientKeepSummary();
				updateClientKeepSummary.setCkNo(addClientKeep.getCkNo());
				updateClientKeepSummary.setBuy(BuyType.Y.toString());
				updateClientKeepSummary.setBomName(addClientKeep.getBomName());
				updateClientKeepSummary.setKeepNum(addClientKeepReturn.getKeepNum());
				updateClientKeepSummary.setEndDate(new Date());
				clientKeepSummaryService.updateByCkNo(updateClientKeepSummary);
				
				//产生邀约任务
				FindComTaskList findComTaskList = new FindComTaskList();
				findComTaskList.setMerchantNo(addClientKeep.getMerchantNo());
				findComTaskList.setComTaskType(ComTaskType.INVITE);
				FindComTaskListReturn findComTaskListReturn = comTaskListService.findComTaskList(findComTaskList);
				if(findComTaskListReturn != null){
					addComTask.setCodeList(findComTaskListReturn.getCode());
					addComTask.setMemberNo(addClientKeep.getMemberNo());
					addComTask.setMemberName(addClientKeep.getMemberName());
					addComTask.setComTaskType(ComTaskType.INVITE);
					comTaskService.addComTaskWithFinish(addComTask,"1");
				}
				
				//客户分类变动
				/*ChangePmType changePmType = new ChangePmType();
				changePmType.setMemberNo(addClientKeep.getMemberNo());
				changePmType.setMerchantNo(addClientKeep.getMerchantNo());
				changePmType.setMemberNoGm(addClientKeep.getMemberNoGm());
				changePmType.setPmTypeType(PmTypeType.INTENTION_N);
				pmTypeService.changePmType(changePmType);*/
				
				//更新客户关联表的产品名称
				UpdatePersonMember updatePersonMember = new UpdatePersonMember();
				updatePersonMember.setBomName(addClientKeep.getBomName());
				updatePersonMember.setMemberNo(addClientKeep.getMemberNo());
				updatePersonMember.setMemberNoGm(addClientKeep.getMemberNoGm());
				personMemberService.updatePersonMemberByMGM(updatePersonMember);
				
			}
			
			// 修改客户最新联系时间
			UpdatePersonMember updatePersonMember = new UpdatePersonMember();
			updatePersonMember.setContactDateLast(new Date());
			updatePersonMember.setMemberNo(addClientKeep.getMemberNo());
			updatePersonMember.setMemberNoGm(addClientKeep.getMemberNoGm());
			personMemberService.updatePersonMemberByMGM(updatePersonMember);
			
			logger.debug("addClentKeep(AddClientKeep) - end - return value={}", addClientKeepReturn); 
			return addClientKeepReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户维护记录表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLENT_KEEP_ADD_ERROR,"新增客户维护记录表信息错误！",e);
		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientKeepService#findLastClientKeep(com.lj.business.cf.dto.FindCForCKLastDateDto)
	 */
	@Override
	public ClientKeep findLastClientKeep(FindCForCKLastDateDto findCForCKLastDateDto) throws TsfaServiceException {
		AssertUtils.notNull(findCForCKLastDateDto);
		AssertUtils.notNullAndEmpty(findCForCKLastDateDto.getCfNo(), "跟踪编号不能为空");
		AssertUtils.notNullAndEmpty(findCForCKLastDateDto.getType(), "跟踪类型不能为空");
		try {
			return clientKeepDao.findLastClientKeep(findCForCKLastDateDto);
		} catch (Exception e) {
			logger.error("查找最后一条维护记录错误", e);
			throw new TsfaServiceException(ErrorCode.CLIENT_KEEP_LAST_ERROR, "查找最后一条维护记录错误", e);
		}
	} 
	
	@Override
	public FindClientKeepReturn findLastClientKeepByGmAndMember(AddClientKeep clientKeep) throws TsfaServiceException {
		AssertUtils.notNull(clientKeep);
		AssertUtils.notNullAndEmpty(clientKeep.getMemberNo(), "客户编号不能为空");
		AssertUtils.notNullAndEmpty(clientKeep.getMemberNoGm(), "导购编号不能为空");
		try {
			return clientKeepDao.findLastClientKeepByGmAndMember(clientKeep);
		} catch (Exception e) {
			logger.error("查找最后一条维护记录错误", e);
			throw new TsfaServiceException(ErrorCode.CLIENT_KEEP_LAST_ERROR, "查找最后一条维护记录错误", e);
		}
	} 
}
