package com.lj.business.cf.service.impl;

import java.util.Calendar;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.IClientFollowDao;
import com.lj.business.cf.domain.ClientFollow;
import com.lj.business.cf.dto.FindCForCKLastDateDto;
import com.lj.business.cf.dto.FindClientFollowClientKeep;
import com.lj.business.cf.dto.FindClientFollowClientKeepReturn;
import com.lj.business.cf.dto.FindComTaskChooseByCode;
import com.lj.business.cf.dto.FindComTaskChooseByCodeReturnDto;
import com.lj.business.cf.dto.NoticeSendMetGenClientFollowDto;
import com.lj.business.cf.dto.UpdateWorkTaskFinishNum;
import com.lj.business.cf.dto.clientFollow.AddClientFollow;
import com.lj.business.cf.dto.clientFollow.AddClientFollowReturn;
import com.lj.business.cf.dto.clientFollow.DelClientFollow;
import com.lj.business.cf.dto.clientFollow.DelClientFollowReturn;
import com.lj.business.cf.dto.clientFollow.FindClientFollow;
import com.lj.business.cf.dto.clientFollow.FindClientFollowMap;
import com.lj.business.cf.dto.clientFollow.FindClientFollowPage;
import com.lj.business.cf.dto.clientFollow.FindClientFollowPageReturn;
import com.lj.business.cf.dto.clientFollow.FindClientFollowReturn;
import com.lj.business.cf.dto.clientFollow.UpdateClientFollow;
import com.lj.business.cf.dto.clientFollow.UpdateClientFollowReturn;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummary;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummaryReturn;
import com.lj.business.cf.dto.clientFollowSummary.UpdateClientFollowSummary;
import com.lj.business.cf.dto.clientKeep.AddClientKeep;
import com.lj.business.cf.dto.clientKeep.FindClientKeep;
import com.lj.business.cf.dto.clientKeep.FindClientKeepReturn;
import com.lj.business.cf.dto.clientKeepSummary.AddClientKeepSummary;
import com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummary;
import com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummaryReturn;
import com.lj.business.cf.dto.comTask.AddComTask;
import com.lj.business.cf.dto.comTask.GenerateNextDate;
import com.lj.business.cf.dto.comTaskList.FindComTaskList;
import com.lj.business.cf.dto.comTaskList.FindComTaskListReturn;
import com.lj.business.cf.dto.pmAbandon.AbandonCheckDto;
import com.lj.business.cf.dto.pmAbandon.AbandonCheckReturn;
import com.lj.business.cf.dto.pmAbandon.AddPmAbandon;
import com.lj.business.cf.dto.pmAbandon.AddPmAbandonReturn;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandon;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandonListReturn;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandonReturn;
import com.lj.business.cf.dto.taskSetShop.FindTaskSetAndOrder;
import com.lj.business.cf.dto.taskSetShopDetail.FindTaskSetShopDetail;
import com.lj.business.cf.dto.taskSetShopDetail.FindTaskSetShopDetailReturn;
import com.lj.business.cf.emus.CheckResult;
import com.lj.business.cf.emus.ComTaskType;
import com.lj.business.cf.emus.DealType;
import com.lj.business.cf.emus.FollowNoType;
import com.lj.business.cf.emus.FollowType;
import com.lj.business.cf.emus.KeepType;
import com.lj.business.cf.emus.MemerType;
import com.lj.business.cf.emus.Status;
import com.lj.business.cf.emus.TaskType;
import com.lj.business.cf.service.IClientFollowService;
import com.lj.business.cf.service.IClientFollowSummaryService;
import com.lj.business.cf.service.IClientKeepService;
import com.lj.business.cf.service.IClientKeepSummaryService;
import com.lj.business.cf.service.IComTaskChooseService;
import com.lj.business.cf.service.IComTaskListService;
import com.lj.business.cf.service.IComTaskService;
import com.lj.business.cf.service.IPmAbandonService;
import com.lj.business.cf.service.ITaskSetShopDetailService;
import com.lj.business.cf.service.IWorkTaskService;
import com.lj.business.common.CommonConstant;
import com.lj.business.common.SystemParamConstant;
import com.lj.business.member.dto.ChangePmType;
import com.lj.business.member.dto.FindGuidMember;
import com.lj.business.member.dto.FindGuidMemberDto;
import com.lj.business.member.dto.FindGuidMemberReturn;
import com.lj.business.member.dto.FindManagerMemberPage;
import com.lj.business.member.dto.FindManagerMemberPageReturn;
import com.lj.business.member.dto.FindPersonMember;
import com.lj.business.member.dto.FindPersonMemberReturn;
import com.lj.business.member.dto.FindPmType;
import com.lj.business.member.dto.FindPmTypeReturn;
import com.lj.business.member.dto.GuidMemberReturnDto;
import com.lj.business.member.dto.UpdatePersonMember;
import com.lj.business.member.dto.guidMemberIntegral.GuidMemberIntegralDto;
import com.lj.business.member.dto.guidmemberActionInfo.AddGuidmemberActionInfo;
import com.lj.business.member.emus.GuidmemberActionType;
import com.lj.business.member.emus.IntegralType;
import com.lj.business.member.emus.MemberType;
import com.lj.business.member.emus.PmTypeType;
import com.lj.business.member.service.IGuidMemberIntegralService;
import com.lj.business.member.service.IGuidMemberService;
import com.lj.business.member.service.IGuidmemberActionInfoService;
import com.lj.business.member.service.IManagerMemberService;
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
 * @author 彭阳
 * 
 * 
 * CreateDate: 2017-06-14
 */
@Service
public class ClientFollowServiceImpl implements IClientFollowService { 


	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ClientFollowServiceImpl.class);


	/** The client follow dao. */
	@Resource
	private IClientFollowDao clientFollowDao;

	/** The client follow summary service. */
	@Resource
	private IClientFollowSummaryService clientFollowSummaryService;

	/** The person member base service. */
	@Resource
	private IPersonMemberBaseService personMemberBaseService;

	/** The guid member service. */
	@Resource
	private IGuidMemberService guidMemberService;

	/** The com task service. */
	@Resource
	private IComTaskService comTaskService;

	/** The client keep service. */
	@Resource
	private IClientKeepService clientKeepService;

	/** The client keep summary service. */
	@Resource
	private IClientKeepSummaryService clientKeepSummaryService;

	/** The pm abandon service. */
	@Resource
	private IPmAbandonService pmAbandonService;

	/** The pm type service. */
	@Resource
	private IPmTypeService pmTypeService;

	/** The person member service. */
	@Resource
	private IPersonMemberService personMemberService;

	@Resource
	private IComTaskListService comTaskListService;

	@Resource
	private IWorkTaskService workTaskService;
	
	
	@Resource
	private ITaskSetShopDetailService taskSetShopDetailService;
	
	@Autowired
	private IManagerMemberService managerMemberService;
	
	@Resource
	private IGuidMemberIntegralService guidMemberIntegralService;
	
	@Resource
	private IGuidmemberActionInfoService guidmemberActionInfoService;
	
	@Resource
	public IComTaskChooseService comTaskChooseService;
	
	@Resource
	private LocalCacheSystemParamsFromCC localCacheSystemParams;
	

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientFollowService#addClientFollow(com.lj.business.cf.dto.AddClientFollow)
	 */

	@Override
	public AddClientFollowReturn addClientFollow(
			AddClientFollow addClientFollow) throws TsfaServiceException {
		logger.debug("addClientFollow(AddClientFollow addClientFollow={}) - start", addClientFollow); 

		AssertUtils.notNull(addClientFollow);
		try {
			ClientFollow clientFollow = new ClientFollow();
			//add数据录入
			clientFollow.setCode(GUID.generateCode());
			clientFollow.setCfNo(addClientFollow.getCfNo());
			clientFollow.setMerchantNo(addClientFollow.getMerchantNo());
			clientFollow.setMemberNo(addClientFollow.getMemberNo());
			clientFollow.setMemberName(addClientFollow.getMemberName());
			clientFollow.setMemberNoGm(addClientFollow.getMemberNoGm());
			clientFollow.setMemberNameGm(addClientFollow.getMemberNameGm());
			clientFollow.setFollowTime(addClientFollow.getFollowTime());
			clientFollow.setFollowNum(addClientFollow.getFollowNum());
			clientFollow.setFollowType(addClientFollow.getFollowType());
			clientFollow.setFollowInfo(addClientFollow.getFollowInfo());
			clientFollow.setDeal(addClientFollow.getDeal());
			clientFollow.setStatus(StringUtils.toStringNull(addClientFollow.getStatus()));
			clientFollow.setStatus(StringUtils.toStringNull(addClientFollow.getStatus()) );
			clientFollow.setOrderAmount(addClientFollow.getOrderAmount());
			clientFollow.setNextDate(addClientFollow.getNextDate());
			clientFollow.setTaskCode(addClientFollow.getTaskCode());
			clientFollow.setTaskName(addClientFollow.getTaskName());
			clientFollow.setNotDealReason(addClientFollow.getNotDealReason());
			clientFollow.setComTaskType(addClientFollow.getComTaskType());
			clientFollow.setClientExpNum(addClientFollow.getClientExpNum());
			clientFollow.setClientGuidNum(addClientFollow.getClientGuidNum());
			clientFollow.setClientInviteNum(addClientFollow.getClientInviteNum());
			clientFollow.setRemark(addClientFollow.getRemark());
			clientFollow.setCreateId(addClientFollow.getCreateId());
			clientFollow.setRemark4(addClientFollow.getRemark4());
			clientFollow.setRemark3(addClientFollow.getRemark3());
			clientFollow.setRemark2(addClientFollow.getRemark2());
			clientFollowDao.insert(clientFollow);
			AddClientFollowReturn addClientFollowReturn = new AddClientFollowReturn();

			logger.debug("addClientFollow(AddClientFollow) - end - return value={}", addClientFollowReturn); 
			return addClientFollowReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户跟踪表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_ADD_ERROR,"新增客户跟踪表信息错误！",e);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientFollowService#delClientFollow(com.lj.business.cf.dto.DelClientFollow)
	 */

	@Override
	public DelClientFollowReturn delClientFollow(
			DelClientFollow delClientFollow) throws TsfaServiceException {
		logger.debug("delClientFollow(DelClientFollow delClientFollow={}) - start", delClientFollow); 

		AssertUtils.notNull(delClientFollow);
		AssertUtils.notNull(delClientFollow.getCode(),"Code不能为空！");
		try {
			clientFollowDao.deleteByPrimaryKey(delClientFollow.getCode());
			DelClientFollowReturn delClientFollowReturn  = new DelClientFollowReturn();

			logger.debug("delClientFollow(DelClientFollow) - end - return value={}", delClientFollowReturn); //$NON-NLS-1$
			return delClientFollowReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除客户跟踪表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_DEL_ERROR,"删除客户跟踪表信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientFollowService#updateClientFollow(com.lj.business.cf.dto.UpdateClientFollow)
	 */

	@Override
	public UpdateClientFollowReturn updateClientFollow(
			UpdateClientFollow updateClientFollow)
					throws TsfaServiceException {
		logger.debug("updateClientFollow(UpdateClientFollow updateClientFollow={}) - start", updateClientFollow); //$NON-NLS-1$

		AssertUtils.notNull(updateClientFollow);
		AssertUtils.notNullAndEmpty(updateClientFollow.getCode(),"Code不能为空");
		try {
			ClientFollow clientFollow = new ClientFollow();
			//update数据录入
			clientFollow.setCode(updateClientFollow.getCode());
			clientFollow.setCfNo(updateClientFollow.getCfNo());
			clientFollow.setMemberNo(updateClientFollow.getMemberNo());
			clientFollow.setMemberName(updateClientFollow.getMemberName());
			clientFollow.setMemberNoGm(updateClientFollow.getMemberNoGm());
			clientFollow.setMemberNameGm(updateClientFollow.getMemberNameGm());
			clientFollow.setFollowTime(updateClientFollow.getFollowTime());
			clientFollow.setFollowNum(updateClientFollow.getFollowNum());
			clientFollow.setFollowType(updateClientFollow.getFollowType());
			clientFollow.setFollowInfo(updateClientFollow.getFollowInfo());
			clientFollow.setDeal(updateClientFollow.getDeal());
			clientFollow.setStatus(StringUtils.toStringNull(updateClientFollow.getStatus()) );
			clientFollow.setOrderAmount(updateClientFollow.getOrderAmount());
			clientFollow.setNextDate(updateClientFollow.getNextDate());
			clientFollow.setTaskCode(updateClientFollow.getTaskCode());
			clientFollow.setTaskName(updateClientFollow.getTaskName());
			clientFollow.setNotDealReason(updateClientFollow.getNotDealReason());
			clientFollow.setComTaskType(updateClientFollow.getComTaskType());
			clientFollow.setClientExpNum(updateClientFollow.getClientExpNum());
			clientFollow.setClientGuidNum(updateClientFollow.getClientGuidNum());
			clientFollow.setClientInviteNum(updateClientFollow.getClientInviteNum());
			clientFollow.setRemark(updateClientFollow.getRemark());
			clientFollow.setRemark4(updateClientFollow.getRemark4());
			clientFollow.setRemark3(updateClientFollow.getRemark3());
			clientFollow.setRemark2(updateClientFollow.getRemark2());
			AssertUtils.notUpdateMoreThanOne(clientFollowDao.updateByPrimaryKeySelective(clientFollow));
			UpdateClientFollowReturn updateClientFollowReturn = new UpdateClientFollowReturn();

			logger.debug("updateClientFollow(UpdateClientFollow) - end - return value={}", updateClientFollowReturn); //$NON-NLS-1$
			return updateClientFollowReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户跟踪表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_UPDATE_ERROR,"客户跟踪表信息更新错误！",e);
		}
	}



	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientFollowService#findClientFollow(com.lj.business.cf.dto.FindClientFollow)
	 */

	@Override
	public FindClientFollowReturn findClientFollow(
			FindClientFollow findClientFollow) throws TsfaServiceException {
		logger.debug("findClientFollow(FindClientFollow findClientFollow={}) - start", findClientFollow); //$NON-NLS-1$

		AssertUtils.notNull(findClientFollow);
		AssertUtils.notAllNull(findClientFollow.getCode(),"Code不能为空");
		try {
			ClientFollow clientFollow = clientFollowDao.selectByPrimaryKey(findClientFollow.getCode());
			if(clientFollow == null){
				throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_NOT_EXIST_ERROR,"客户跟踪表信息不存在");
			}
			FindClientFollowReturn findClientFollowReturn = new FindClientFollowReturn();
			//find数据录入
			findClientFollowReturn.setCode(clientFollow.getCode());
			findClientFollowReturn.setCfNo(clientFollow.getCfNo());
			findClientFollowReturn.setMerchantNo(clientFollow.getMerchantNo());
			findClientFollowReturn.setMemberNo(clientFollow.getMemberNo());
			findClientFollowReturn.setMemberName(clientFollow.getMemberName());
			findClientFollowReturn.setMemberNoGm(clientFollow.getMemberNoGm());
			findClientFollowReturn.setMemberNameGm(clientFollow.getMemberNameGm());
			findClientFollowReturn.setFollowTime(clientFollow.getFollowTime());
			findClientFollowReturn.setFollowNum(clientFollow.getFollowNum());
			findClientFollowReturn.setFollowType(clientFollow.getFollowType());
			findClientFollowReturn.setFollowInfo(clientFollow.getFollowInfo());
			findClientFollowReturn.setDeal(clientFollow.getDeal());
			if(findClientFollowReturn.getStatus() != null)
				findClientFollowReturn.setStatus(Status.valueOf(clientFollow.getStatus()));

			findClientFollowReturn.setOrderAmount(clientFollow.getOrderAmount());
			findClientFollowReturn.setNextDate(clientFollow.getNextDate());
			findClientFollowReturn.setTaskCode(clientFollow.getTaskCode());
			findClientFollowReturn.setTaskName(clientFollow.getTaskName());
			findClientFollowReturn.setNotDealReason(clientFollow.getNotDealReason());
			findClientFollowReturn.setComTaskType(clientFollow.getComTaskType());
			findClientFollowReturn.setClientExpNum(clientFollow.getClientExpNum());
			findClientFollowReturn.setClientGuidNum(clientFollow.getClientGuidNum());
			findClientFollowReturn.setClientInviteNum(clientFollow.getClientInviteNum());
			findClientFollowReturn.setRemark(clientFollow.getRemark());
			findClientFollowReturn.setCreateId(clientFollow.getCreateId());
			findClientFollowReturn.setCreateDate(clientFollow.getCreateDate());
			findClientFollowReturn.setRemark4(clientFollow.getRemark4());
			findClientFollowReturn.setRemark3(clientFollow.getRemark3());
			findClientFollowReturn.setRemark2(clientFollow.getRemark2());

			logger.debug("findClientFollow(FindClientFollow) - end - return value={}", findClientFollowReturn); //$NON-NLS-1$
			return findClientFollowReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户跟踪表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_FIND_ERROR,"查找客户跟踪表信息错误！",e);
		}


	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientFollowService#findClientFollowPage(com.lj.business.cf.dto.FindClientFollowPage)
	 */

	@Override
	public Page<FindClientFollowPageReturn> findClientFollowPage(
			FindClientFollowPage findClientFollowPage)
					throws TsfaServiceException {
		logger.debug("findClientFollowPage(FindClientFollowPage findClientFollowPage={}) - start", findClientFollowPage); //$NON-NLS-1$

		AssertUtils.notNull(findClientFollowPage);
		List<FindClientFollowPageReturn> returnList;
		int count = 0;
		try {
			returnList = clientFollowDao.findClientFollowPage(findClientFollowPage);
			count = clientFollowDao.findClientFollowPageCount(findClientFollowPage);
		}  catch (Exception e) {
			logger.error("客户跟踪表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_FIND_PAGE_ERROR,"客户跟踪表信息分页查询错误.！",e);
		}
		Page<FindClientFollowPageReturn> returnPage = new Page<FindClientFollowPageReturn>(returnList, count, findClientFollowPage);

		logger.debug("findClientFollowPage(FindClientFollowPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientFollowService#cfHistory(com.lj.business.cf.dto.FindClientFollow)
	 */

	@Override
	public List<FindClientFollowReturn> cfHistory(FindClientFollow findClientFollow) throws TsfaServiceException {
		logger.debug("cfHistory(FindClientFollow cfHistory={}) - start", findClientFollow); //$NON-NLS-1$

		List<FindClientFollowReturn> returnList;
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("memberNo", findClientFollow.getMemberNo());
			map.put("memberGMCode", findClientFollow.getMemberNoGm());
			map.put("cfNo", findClientFollow.getCfNo());
			returnList = clientFollowDao.cfHistory(map);
		}  catch (Exception e) {
			logger.error("客户跟踪表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_FIND_PAGE_ERROR,"客户跟踪表信息分页查询错误.！",e);
		}

		logger.debug("cfHistory(cfHistory) - end - return value={}", returnList); //$NON-NLS-1$
		return  returnList;
	}

	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @param addClientFollow
	 * @param flag
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月8日
	 *
	 */
	public AddClientFollowReturn addCFOrder(AddClientFollow addClientFollow,String flag) throws TsfaServiceException {
		return addCFOrder( addClientFollow,flag,true,false);
	}
	
	/**
	 * 方法说明：我的客户-跟进记录-新增.
	 *
	 * @param addClientFollow the add client follow
	 * @param flag the flag
	 * @param  isCreateCf 是否创建沟通任务
	 * @return the adds the client follow return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 冯辉 CreateDate: 2017年7月4日
	 */
	@Override
	public AddClientFollowReturn addCFOrder(AddClientFollow addClientFollow,String flag,boolean isCreateCf,boolean isAddIntegal) throws TsfaServiceException {
		logger.debug("addCFOrder(AddClientFollow addClientFollow={}, String flag={}, boolean isCreateCf={}) - start", addClientFollow, flag); //$NON-NLS-1$

		AssertUtils.notNull(addClientFollow);
		String merchantNo = addClientFollow.getMerchantNo();
		AssertUtils.notNullAndEmpty(merchantNo, "商家编号不能为空");
		String memberNo = addClientFollow.getMemberNo();
		AssertUtils.notNullAndEmpty(memberNo, "客户编号不能为空");
		String memberNoGm = addClientFollow.getMemberNoGm();
		AssertUtils.notNullAndEmpty(memberNoGm, "导购编号不能为空");
		String cfNo = addClientFollow.getCfNo();
		// 新增跟进记录  跟进时间需要小于下次跟进时间
		if("0" == flag || "0".equals(flag)){
			if(addClientFollow.getFollowTime() != null && addClientFollow.getNextDate() != null){
				if(addClientFollow.getFollowTime().compareTo(addClientFollow.getNextDate()) > 0){
					throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_DATA_TIME_LOW_ERROR,"跟进时间需要小于下次跟进时间！");
				}
			}
		}

		try {
			cfNo = validClientFollow(merchantNo, memberNo, memberNoGm, cfNo);

			ClientFollow clientFollow = new ClientFollow();
			clientFollow.setCode(GUID.getPreUUID());
			clientFollow.setCfNo(cfNo);
			clientFollow.setMerchantNo(merchantNo);
			clientFollow.setFollowTime(addClientFollow.getFollowTime());
			//通过客户CODE,导购CODE,跟踪总表no获取客户跟踪信息
			Map<String, String> map = new HashMap<String, String>();
			map.put("memberNo", memberNo);
			map.put("memberGMCode", memberNoGm);
			map.put("cfNo", cfNo);
			List<FindClientFollowReturn> list = clientFollowDao.cfHistory(map);

			FindClientFollowReturn cfR = null;
			if(list != null && list.size() >0){
				cfR = list.get(0);
				clientFollow.setFollowNum(cfR.getFollowNum()+1);
			}else{
				clientFollow.setFollowNum(1);
			}
			//如果是非成单客户，则需要录入下次跟进的时间与任务
			if("0" == flag || "0".equals(flag)){
				AssertUtils.notNullAndEmpty(addClientFollow.getFollowTime(), "跟进时间不能为空");
				cfSetProcess(addClientFollow, clientFollow);
			}else if("1" == flag || "1".equals(flag)){//成单
				clientFollow.setComTaskType(ComTaskType.SYSTEM.toString());
				AssertUtils.notNullAndEmpty(addClientFollow.getOrderAmount(), "成单金额不能为空");
				addClientFollow.setFollowType(FollowType.SYSTEM.toString());
				addClientFollow.setFollowInfo("成单结束跟进");
				clientFollow.setStatus(Status.DEAL.toString());
				clientFollow.setOrderAmount(addClientFollow.getOrderAmount());
				clientFollow.setDeal(DealType.Y.toString());
			}else if("2" == flag || "2".equals(flag)){//放弃
				clientFollow.setComTaskType(ComTaskType.SYSTEM.toString());
				addClientFollow.setFollowType(FollowType.SYSTEM.toString());
				addClientFollow.setFollowInfo("申请暂停跟进");
				clientFollow.setFollowTime(new Date());
				clientFollow.setStatus(Status.ABANDON.toString());
				clientFollow.setDeal(DealType.N.toString());
				if(!StringUtils.isEmpty(addClientFollow.getResean()) && addClientFollow.getResean().length() > 200){
					throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_DATA_ERROR,"原因长度超过200！");
				}
				
				String abandonCount =  localCacheSystemParams.getSystemParam(SystemAliasName.cf.toString(),SystemParamConstant.ABANDON, SystemParamConstant.ABANDON_COUNT);
				int ac = 3;
				if(!StringUtils.isEmpty(abandonCount)){
					ac = Integer.valueOf(ac);
				}
				
				FindClientFollow findClientFollow11 = new FindClientFollow();
				findClientFollow11.setCfNo(cfNo);
				int cfCount = cfCount(findClientFollow11);
				if(cfCount < ac){
					AddClientFollowReturn addClientFollowReturn = new AddClientFollowReturn();
					addClientFollowReturn.setRemark(cfCount + "");
					return addClientFollowReturn;
				}
			}

			clientFollow.setMemberNo(memberNo);
			clientFollow.setMemberNoGm(memberNoGm);
			//会员名称
			FindGuidMemberReturn findGuidMemberReturn = null;
			FindPersonMemberReturn findPersonMemberReturntemp = null;
			String memberName = "";
			if(StringUtils.isEmpty(addClientFollow.getMemberName())){
				FindPersonMember findPersonMember = new FindPersonMember();
				findPersonMember.setMemberNo(memberNo);
				findPersonMember.setMemberNoGm(memberNoGm);
				findPersonMemberReturntemp = personMemberService.findPersonMemberByMGM(findPersonMember);
				if(findPersonMemberReturntemp != null){
					memberName = findPersonMemberReturntemp.getMemberName();
				}
			}else{
				memberName = addClientFollow.getMemberName();
			}

			//导购名称
			String memberNameGm = "";
			String shopNo = "";		//门店编号
			FindGuidMember findGuidMember = new FindGuidMember();
			findGuidMember.setMemberNo(memberNoGm);
			findGuidMemberReturn = guidMemberService.findGuidMember(findGuidMember);
			if(findGuidMemberReturn != null){
				shopNo = findGuidMemberReturn.getShopNo();
			}
			if(StringUtils.isEmpty(addClientFollow.getMemberNameGm())){
				if(findGuidMemberReturn != null){
					memberNameGm = findGuidMemberReturn.getMemberName();
				}
			}else{
				memberNameGm = addClientFollow.getMemberNameGm();
			}

			clientFollow.setMemberName(memberName);
			clientFollow.setMemberNameGm(memberNameGm);
			clientFollow.setRemark(addClientFollow.getRemark());
			clientFollow.setNotDealReason(addClientFollow.getNotDealReason());
			clientFollow.setFollowType(addClientFollow.getFollowType());
			clientFollow.setFollowInfo(addClientFollow.getFollowInfo());
			clientFollow.setCreateId(addClientFollow.getCreateId());
			clientFollow.setCreateDate(new Date());
			clientFollowDao.insert(clientFollow);

			//更新跟踪总表数量
			UpdateClientFollowSummary updateClientFollowSummary = new UpdateClientFollowSummary();
			updateClientFollowSummary.setCfNo(cfNo);
			updateClientFollowSummary.setFollowNum(clientFollow.getFollowNum());
			clientFollowSummaryService.updateClientFollowSummaryByCfNo(updateClientFollowSummary);

			//如果是非成单客户,生成邀约任务
			if("0" == flag || "0".equals(flag)){
				if(isCreateCf && (!StringUtils.isEmpty(addClientFollow.getTaskCode()))){
					cfProcess(addClientFollow, isAddIntegal, merchantNo,memberNo,memberNoGm, cfNo, findGuidMemberReturn,memberName, shopNo);
				}
			}

			//成单生成维护记录
			if("1" == flag || "1".equals(flag)){
				cfSuccess(addClientFollow, merchantNo, memberNo, memberNoGm,cfNo, memberName, memberNameGm, shopNo);
			}
			//放弃审批后才能生成维护总表和维护记录
			if("2" == flag || "2".equals(flag)){
				// 如果已经存在未审批的的放弃记录，则不能执行放弃操作
				cfAbandonProcess(addClientFollow, merchantNo, memberNo,memberNoGm, cfNo, memberName, memberNameGm, shopNo);
			}
			
			// 修改客户最新联系时间
			UpdatePersonMember updatePersonMember = new UpdatePersonMember();
			updatePersonMember.setContactDateLast(new Date());
			updatePersonMember.setMemberNo(addClientFollow.getMemberNo());
			updatePersonMember.setMemberNoGm(addClientFollow.getMemberNoGm());
			personMemberService.updatePersonMemberByMGM(updatePersonMember);
			
			AddClientFollowReturn addClientFollowReturn = new AddClientFollowReturn();
			addClientFollowReturn.setCfNo(cfNo);
			addClientFollowReturn.setCode(clientFollow.getCode());
			addClientFollowReturn.setMemberNo(memberNo);
			addClientFollowReturn.setMemberName(memberName);
			addClientFollowReturn.setMemberNoGm(memberNoGm);
			addClientFollowReturn.setMemberNameGm(memberNameGm);
			addClientFollowReturn.setShopNo(findGuidMemberReturn.getShopNo());
			addClientFollowReturn.setShopName(findGuidMemberReturn.getShopName());
			addClientFollowReturn.setMerchantNo(merchantNo);
			logger.debug("addCFOrder(AddClientFollow) - end - return value={}", addClientFollowReturn); 
			
			return addClientFollowReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户跟踪表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_ADD_ERROR,"新增客户跟踪表信息错误！",e);
		}
	}


	private void cfAbandonProcess(AddClientFollow addClientFollow,
			String merchantNo, String memberNo, String memberNoGm, String cfNo,
			String memberName, String memberNameGm, String shopNo) {
		List<FindPmAbandonListReturn> frList = pmAbandonService.findNoCheckByCfNo(cfNo, memberNo, memberNoGm);
		if(frList != null && frList.size() > 0){
			throw new TsfaServiceException(ErrorCode.PM_ABANDON_NOCHECK_DATA_ERROR,"存在未审批的放弃记录,不能放弃！");
		}

		logger.info("start  =============");
		
		//生成放弃表记录
		AddPmAbandon addPmAbandon = new AddPmAbandon();
		addPmAbandon.setCfNo(cfNo);
		addPmAbandon.setMerchantNo(merchantNo);
		addPmAbandon.setMemberNo(memberNo);
		addPmAbandon.setMemberName(memberName);
		addPmAbandon.setMemberNoGm(memberNoGm);
		addPmAbandon.setMemberNameGm(memberNameGm);				
		addPmAbandon.setCheckResult(CheckResult.WAIT.toString());
		addPmAbandon.setCreateId(addClientFollow.getCreateId());
		addPmAbandon.setCreateDate(new Date());
		addPmAbandon.setResean(addClientFollow.getResean());//放弃原因
		//产品名称
		FindPersonMember findPersonMember = new FindPersonMember();
		findPersonMember.setMemberNo(memberNo);
		findPersonMember.setMemberNoGm(memberNoGm);
		FindPersonMemberReturn findPersonMemberReturn = personMemberService.findPersonMemberByMGM(findPersonMember);
		if(findPersonMemberReturn != null){
			addPmAbandon.setBomName(findPersonMemberReturn.getBomName());
		}
		AddPmAbandonReturn addPmAbandonReturn = pmAbandonService.addPmAbandon(addPmAbandon);
		
		
		logger.info("===addPmAbandonReturn:" + addPmAbandonReturn);
		
		//更新跟进总表结束时间
		UpdateClientFollowSummary us = new UpdateClientFollowSummary();
		us.setCfNo(cfNo);
		us.setStatus(Status.CHECKING.toString());
		clientFollowSummaryService.updateClientFollowSummaryByCfNo(us);
		
		//修改跟进记录的放弃code
		UpdateClientFollow updateClientFollow = new UpdateClientFollow();
		updateClientFollow.setCfNo(cfNo);
		updateClientFollow.setPaCode(addPmAbandonReturn.getCode());
		updateClientFollow.setMemberNoGm(memberNoGm);
		updateClientFollow.setMemberNo(memberNo);
		clientFollowDao.updateByCfNo(updateClientFollow);
		
		//获取导购所属店长
		FindManagerMemberPage findManagerMemberPage = new FindManagerMemberPage();
		findManagerMemberPage.setMemberNoShop(shopNo);
		List<FindManagerMemberPageReturn> managerMemberPageReturns= managerMemberService.findManagerMembers(findManagerMemberPage);
		FindManagerMemberPageReturn findManagerMemberPageReturn =null;
		if(managerMemberPageReturns.size()>0){
			findManagerMemberPageReturn =managerMemberPageReturns.get(0);
		}
		
		logger.info("=========findManagerMemberPageReturn:" + findManagerMemberPageReturn);
		
		
		logger.info(" end =====");
	}


	private void cfSetProcess(AddClientFollow addClientFollow,
			ClientFollow clientFollow) {
		clientFollow.setTaskCode(addClientFollow.getTaskCode());
		clientFollow.setTaskName(addClientFollow.getTaskName());
		clientFollow.setNextDate(addClientFollow.getNextDate());
		clientFollow.setStatus(Status.NORMAL.toString());
		clientFollow.setDeal(DealType.N.toString());
		if(StringUtils.isEmpty(addClientFollow.getComTaskType())){
			clientFollow.setComTaskType(ComTaskType.INVITE.toString());
		}else{
			clientFollow.setComTaskType(addClientFollow.getComTaskTypeCf());
		}
		clientFollow.setClientExpNum(addClientFollow.getClientExpNum());
		clientFollow.setClientGuidNum(addClientFollow.getClientGuidNum());
		clientFollow.setClientInviteNum(addClientFollow.getClientInviteNum());
		
		if(!StringUtils.isEmpty(addClientFollow.getTaskCode())){
			//如果下次任务时间为空则按分组频率产生时间
			if(addClientFollow.getNextDate() == null){
				// 获取任务频率
				FindComTaskChooseByCode findComTaskChooseByCode = new FindComTaskChooseByCode();
				findComTaskChooseByCode.setMerchantNo(addClientFollow.getMerchantNo());
				findComTaskChooseByCode.setCode(addClientFollow.getTaskCode());
				FindComTaskChooseByCodeReturnDto findComTaskChooseByCodeReturnDto = comTaskChooseService.findComTaskChooseByCode(findComTaskChooseByCode);
				if(findComTaskChooseByCodeReturnDto != null){
					if(ComTaskType.INVITE.toString().equals(findComTaskChooseByCodeReturnDto.getComTaskType())){
						GenerateNextDate generateNextDate = new GenerateNextDate();
						generateNextDate.setNextDate(DateUtils.addHours(new Date(), Integer.valueOf(findComTaskChooseByCodeReturnDto.getFreValue())));
						addClientFollow.setNextDate(comTaskService.generateNextDate(generateNextDate));
					}else{
						addClientFollow.setNextDate(DateUtils.addHours(new Date(), Integer.valueOf(findComTaskChooseByCodeReturnDto.getFreValue())));
					}
				}
				clientFollow.setNextDate(addClientFollow.getNextDate());
			}
		}else{
			addClientFollow.setNextDate(null);
			clientFollow.setNextDate(addClientFollow.getNextDate());
		}
	}


	private void cfProcess(AddClientFollow addClientFollow,
			boolean isAddIntegal, String merchantNo, String memberNo,
			String memberNoGm, String cfNo,
			FindGuidMemberReturn findGuidMemberReturn, String memberName,
			String shopNo) {
		AddComTask addComTask = new AddComTask();
		addComTask.setMerchantNo(merchantNo);
		addComTask.setMemberNoGm(memberNoGm);
		addComTask.setCfNo(cfNo);
		addComTask.setNoType(FollowNoType.FOLLOW.toString());
		addComTask.setWorkDate(addClientFollow.getNextDate());
		addComTask.setCodeList(addClientFollow.getTaskCode());
		addComTask.setMemberNo(memberNo);
		addComTask.setMemberName(memberName);
		//UPDATE BY LEOPENG
		if(!StringUtils.isEmpty(addClientFollow.getComTaskType()))
			addComTask.setComTaskType(ComTaskType.valueOf(addClientFollow.getComTaskType()));
		else
			addComTask.setComTaskType(ComTaskType.COM_TASK);
		
		addComTask.setOrgComTaskCode(addClientFollow.getComTaskCode());
		addComTask.setDis(addClientFollow.getDis());
		addComTask.setFinishOrgComTask(addClientFollow.getFinishOrgComTask());
		addComTask.setRemarkCom(addClientFollow.getRemarkCom());//任务备注
		addComTask.setLastResultDate(addClientFollow.getLastResultDate());
		
		//是否关闭所有任务
		if(addClientFollow.getFinishAllComTask())
			comTaskService.addComTaskWithFinish(addComTask,"1");
		else
			comTaskService.addComTaskWithFinish(addComTask,"0");
		
		//添加积分
		if(isAddIntegal){
			GuidMemberIntegralDto guidMemberIntegralDto = new GuidMemberIntegralDto();
			guidMemberIntegralDto.setMerchantNo(merchantNo);
			guidMemberIntegralDto.setShopNo(shopNo);
			guidMemberIntegralDto.setMemberNo(memberNoGm);
			guidMemberIntegralDto.setAreaCode(findGuidMemberReturn.getAreaCode());
			guidMemberIntegralDto.setIntegralType(IntegralType.COM_TASK.toString());
			guidMemberIntegralService.doIntegral(guidMemberIntegralDto);
		}
	}


	private void cfSuccess(AddClientFollow addClientFollow, String merchantNo,
			String memberNo, String memberNoGm, String cfNo, String memberName,
			String memberNameGm, String shopNo) {
		//需要把该cfNo的放弃记录的为未审批的状态设置为拒绝
		pmAbandonService.updateNoCheckByCfNo(cfNo, memberNo, memberNoGm);
		
		// 增加销售的数量
		UpdateWorkTaskFinishNum updateWorkTaskFinishNum = new UpdateWorkTaskFinishNum();
		updateWorkTaskFinishNum.setMemberNoGm(memberNoGm);
		updateWorkTaskFinishNum.setMerchantNo(merchantNo);
		updateWorkTaskFinishNum.setTaskType(TaskType.XIAO_SHOU);
		updateWorkTaskFinishNum.setFinishNum(addClientFollow.getOrderAmount());
		workTaskService.updateFinishNum(updateWorkTaskFinishNum);
		
		

		//生成维护总表记录
		AddClientKeepSummary addClientKeepSummary = new AddClientKeepSummary();
		addClientKeepSummary.setMerchantNo(merchantNo);
		addClientKeepSummary.setMemberNo(memberNo);
		addClientKeepSummary.setMemberName(memberName);
		addClientKeepSummary.setMemberNoGm(memberNoGm);
		addClientKeepSummary.setMemberNameGm(memberNameGm);
		addClientKeepSummary.setKeepNum(1);
		addClientKeepSummary.setStartDate(new Date());
		addClientKeepSummary.setCreateId(memberNoGm);
		String ckNo = clientKeepSummaryService.addClientKeepSummary(addClientKeepSummary);

		//生成维护明细记录
		AddClientKeep addClientKeep = new AddClientKeep();
		addClientKeep.setCkNo(ckNo);
		addClientKeep.setBuy("N");
		addClientKeep.setCreateId(addClientFollow.getCreateId());
		addClientKeep.setKeepContent("开始维护客户");
		addClientKeep.setKeepTime(new Date());
		addClientKeep.setKeepType(KeepType.SYSTEM.toString());
		addClientKeep.setKeepNum(1);
		addClientKeep.setMemberName(memberName);
		addClientKeep.setMemberNameGm(memberNameGm);
		addClientKeep.setMemberNo(memberNo);
		addClientKeep.setMemberNoGm(memberNoGm);
		addClientKeep.setMerchantNo(merchantNo);
		clientKeepService.addClientKeepInfo(addClientKeep);

		//更新跟进总表结束时间
		UpdateClientFollowSummary updateClientFollowSummary2 = new UpdateClientFollowSummary();
		updateClientFollowSummary2.setCfNo(cfNo);
		updateClientFollowSummary2.setOrderAmount(addClientFollow.getOrderAmount());
		updateClientFollowSummary2.setEndDate(new Date());
		updateClientFollowSummary2.setStatus(Status.DEAL.toString());
		clientFollowSummaryService.updateClientFollowSummaryByCfNo(updateClientFollowSummary2);

		//分类变动
		/*ChangePmType changePmType = new ChangePmType();
		changePmType.setMemberNo(memberNo);
		changePmType.setMerchantNo(merchantNo);
		changePmType.setMemberNoGm(memberNoGm);
		changePmType.setPmTypeType(PmTypeType.SUCCESS);
		pmTypeService.changePmType(changePmType);*/

		//生成沟通任务
		/*FindPmType findPmType = new FindPmType();
		findPmType.setMerchantNo(merchantNo);
		findPmType.setPmTypeType(PmTypeType.SUCCESS.toString());
		FindPmTypeReturn findPmTypeReturn = pmTypeService.findPmTypeByMP(findPmType);
		int hour = 0;
		if(findPmTypeReturn == null || StringUtils.isEmpty(findPmTypeReturn.getFreValue())){
			hour = 0;
		}else{
			hour = Integer.valueOf(findPmTypeReturn.getFreValue());
		}*/
		AddComTask addComTask = new AddComTask();
		addComTask.setMerchantNo(merchantNo);
		addComTask.setMemberNoGm(memberNoGm);
		addComTask.setMemberNo(memberNo);
		addComTask.setMemberName(memberName);
		addComTask.setCfNo(ckNo);
		addComTask.setNoType(FollowNoType.KEEP.toString());
//		addComTask.setWorkDate(DateUtils.addHours(new Date(), hour));
		addComTask.setWorkDate(new Date());
		addComTask.setComTaskType(ComTaskType.COM_TASK);
		addComTask.setRemarkCom(CommonConstant.REPLACE_REMARK_COM + "成单");
		addComTask.setLastResultDate(new Date());
		
		FindComTaskList findComTaskList = new FindComTaskList();
		findComTaskList.setMerchantNo(merchantNo);
		findComTaskList.setComTaskType(ComTaskType.COM_TASK);
		FindComTaskListReturn findComTaskListReturn = comTaskListService.findComTaskList(findComTaskList);
		if(findComTaskListReturn != null){
			addComTask.setCodeList(findComTaskListReturn.getCode());
			comTaskService.addComTaskWithFinish(addComTask,"1");
			
			//添加积分
			GuidMemberIntegralDto guidMemberIntegralDto = new GuidMemberIntegralDto();
			guidMemberIntegralDto.setMerchantNo(merchantNo);
			guidMemberIntegralDto.setShopNo(shopNo);
			guidMemberIntegralDto.setMemberNo(memberNoGm);
			guidMemberIntegralDto.setAreaCode(addClientFollow.getAreaCode());
			guidMemberIntegralDto.setIntegralType(IntegralType.XIAO_SHOU.toString());
			guidMemberIntegralDto.setAmount(addClientFollow.getOrderAmount().doubleValue());
			guidMemberIntegralService.doIntegral(guidMemberIntegralDto);
		}
		
		//添加到导购行为统计表
		AddGuidmemberActionInfo addGuidmemberActionInfo = new AddGuidmemberActionInfo();
		addGuidmemberActionInfo.setCode(GUID.generateCode());
		addGuidmemberActionInfo.setActionType(GuidmemberActionType.BUY.toString());
		addGuidmemberActionInfo.setActionTime(new Date());
		addGuidmemberActionInfo.setCreateDate(new Date());
		addGuidmemberActionInfo.setMerchantNo(merchantNo);
		addGuidmemberActionInfo.setMemberNoGm(memberNoGm);
		addGuidmemberActionInfo.setMemberNameGm(memberNameGm);
		addGuidmemberActionInfo.setShopNo(shopNo);
		addGuidmemberActionInfo.setShopName(addClientFollow.getShopName());
		addGuidmemberActionInfo.setActionDetail(memberNameGm + "新增一笔成单！");
		guidmemberActionInfoService.addGuidmemberActionInfo(addGuidmemberActionInfo);
	}


	private String validClientFollow(String merchantNo, String memberNo,
			String memberNoGm, String cfNo) {
		//兼容 前端没有CFNO的情况 update by leopeng
		if(StringUtils.isEmpty(cfNo) ){
			logger.debug("查询跟进总表中导购和客户最后一条记录");
			FindClientFollowSummary findClientFollowSummary = new FindClientFollowSummary();
			findClientFollowSummary.setMerchantNo(merchantNo);
			findClientFollowSummary.setMemberNoGm(memberNoGm);
			findClientFollowSummary.setMemberNo(memberNo);
			FindClientFollowSummaryReturn findClientFollowSummaryReturn = clientFollowSummaryService.findClientFollowSummaryLast(findClientFollowSummary);
			if(findClientFollowSummaryReturn != null){
				logger.debug("查询跟进总表中导购和客户最后一条记录: "+ findClientFollowSummaryReturn);
				cfNo = findClientFollowSummaryReturn.getCfNo();
				if(findClientFollowSummaryReturn.getEndDate() != null){
					throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_DATA_COMMON_ERROR,"跟进数据错误！");
				}
			}
		}else{
			//如果这次跟进已经结束则不能再次有跟进操作 update by leopeng
			FindClientFollowSummary findClientFollowSummary = new FindClientFollowSummary();
			findClientFollowSummary.setCfNo(cfNo);
			FindClientFollowSummaryReturn findClientFollowSummaryReturn = clientFollowSummaryService.findClientFollowSummaryByCfNo(findClientFollowSummary);
			if(findClientFollowSummaryReturn == null 
					|| findClientFollowSummaryReturn.getEndDate() != null){
				throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_DATA_COMMON_ERROR,"跟进已经结束则不能再次有跟进操作！");
			}
		}
		return cfNo;
	}

	/**
	 * 方法说明 ： 店长审批放弃跟进记录.
	 *
	 * @param abandonCheckDto the abandon check dto
	 * @return the abandon check return
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public AbandonCheckReturn abandonCheck(AbandonCheckDto abandonCheckDto) throws TsfaServiceException {
		logger.debug("abandonCheck(AbandonCheckDto abandonCheckDto={}) - start", abandonCheckDto); //$NON-NLS-1$

		AssertUtils.notNull(abandonCheckDto);
		AssertUtils.notNullAndEmpty(abandonCheckDto.getCode(), "放弃编号不能为空");
		AssertUtils.notNullAndEmpty(abandonCheckDto.getMemberType(), "用户类型不能为空");
		AssertUtils.isEqual(abandonCheckDto.getMemberType(), MemerType.SHOP.toString(), "用户类型不是店长");
		AssertUtils.notNullAndEmpty(abandonCheckDto.getChecker(), "审批人姓名不能为空");
		AssertUtils.notNullAndEmpty(abandonCheckDto.getMemberNoCheck(), "审批人编号不能为空");
		AssertUtils.notNullAndEmpty(abandonCheckDto.getCfNo(), "跟进编号不能为空");
		try {
			//如果这次跟进已经结束则不能再次有跟进操作
			FindClientFollowSummary findClientFollowSummary = new FindClientFollowSummary();
			findClientFollowSummary.setCfNo(abandonCheckDto.getCfNo());
			FindClientFollowSummaryReturn findClientFollowSummaryReturn = clientFollowSummaryService.findClientFollowSummaryByCfNo(findClientFollowSummary);
			if(findClientFollowSummaryReturn == null 
					|| findClientFollowSummaryReturn.getEndDate() != null){
				throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_DATA_ERROR,"跟进数据错误！");
			}

			//查询放弃记录
			FindPmAbandon findPmAbandon = new FindPmAbandon();
			findPmAbandon.setCode(abandonCheckDto.getCode());
			FindPmAbandonReturn findPmAbandonReturn = pmAbandonService.findPmAbandon(findPmAbandon);
			AssertUtils.notNull(findPmAbandonReturn);

			//保存放弃审批记录
			int ret = pmAbandonService.abandonCheck(abandonCheckDto);

			if(ret > 0){
				//审批通过
				if(CheckResult.AGREE.toString().equals(abandonCheckDto.getCheckResult())){
					//生成维护总表记录
					AddClientKeepSummary addClientKeepSummary = new AddClientKeepSummary();
					addClientKeepSummary.setMerchantNo(findPmAbandonReturn.getMerchantNo());
					addClientKeepSummary.setMemberNo(findPmAbandonReturn.getMemberNo());
					addClientKeepSummary.setMemberName(findPmAbandonReturn.getMemberName());
					addClientKeepSummary.setMemberNoGm(findPmAbandonReturn.getMemberNoGm());
					addClientKeepSummary.setMemberNameGm(findPmAbandonReturn.getMemberNameGm());
					addClientKeepSummary.setKeepNum(1);
					addClientKeepSummary.setStartDate(new Date());
					String ckNo = clientKeepSummaryService.addClientKeepSummary(addClientKeepSummary);

					//生成维护明细记录
					AddClientKeep addClientKeep = new AddClientKeep();
					addClientKeep.setCkNo(ckNo);
					addClientKeep.setBuy("N");
					addClientKeep.setCreateId(abandonCheckDto.getMemberNoCheck());
					addClientKeep.setKeepContent("开始维护客户");
					addClientKeep.setKeepTime(new Date());
					addClientKeep.setKeepType(KeepType.SYSTEM.toString());
					addClientKeep.setKeepNum(1);
					addClientKeep.setMemberName(findPmAbandonReturn.getMemberName());
					addClientKeep.setMemberNameGm(findPmAbandonReturn.getMemberNameGm());
					addClientKeep.setMemberNo(findPmAbandonReturn.getMemberNo());
					addClientKeep.setMemberNoGm(findPmAbandonReturn.getMemberNoGm());
					addClientKeep.setMerchantNo(findPmAbandonReturn.getMerchantNo());
					clientKeepService.addClientKeepInfo(addClientKeep);

					//更新跟进总表结束时间
					UpdateClientFollowSummary updateClientFollowSummary = new UpdateClientFollowSummary();
					updateClientFollowSummary.setCfNo(findPmAbandonReturn.getCfNo());
					updateClientFollowSummary.setStatus(Status.ABANDON.toString());
					updateClientFollowSummary.setEndDate(new Date());
					clientFollowSummaryService.updateClientFollowSummaryByCfNo(updateClientFollowSummary);

					//分类变动
					/*ChangePmType changePmType = new ChangePmType();
					changePmType.setMemberNo(findPmAbandonReturn.getMemberNo());
					changePmType.setMerchantNo(findPmAbandonReturn.getMerchantNo());
					changePmType.setMemberNoGm(findPmAbandonReturn.getMemberNoGm());
					changePmType.setPmTypeType(PmTypeType.GIVE_UP);
					pmTypeService.changePmType(changePmType);*/

					//生成沟通任务
					/*FindPmType findPmType = new FindPmType();
					findPmType.setMerchantNo(findPmAbandonReturn.getMerchantNo());
					findPmType.setCode(PmTypeType.GIVE_UP.toString());
					FindPmTypeReturn findPmTypeReturn = pmTypeService.findPmType(findPmType);
					int hour = 0;
					if(findPmTypeReturn == null || StringUtils.isEmpty(findPmTypeReturn.getFreValue())){
						hour = 0;
					}else{
						hour = Integer.valueOf(findPmTypeReturn.getFreValue());
					}*/
					AddComTask addComTask = new AddComTask();
					addComTask.setMerchantNo(findPmAbandonReturn.getMerchantNo());
					addComTask.setMemberNoGm(findPmAbandonReturn.getMemberNoGm());
					addComTask.setCfNo(ckNo);
					addComTask.setNoType(FollowNoType.KEEP.toString());
//					addComTask.setWorkDate(DateUtils.addHours(new Date(), hour));
					addComTask.setWorkDate(new Date());
					addComTask.setComTaskType(ComTaskType.COM_TASK);
					addComTask.setRemarkCom(CommonConstant.REPLACE_REMARK_COM + "审批通过，暂停跟进客户");
					addComTask.setLastResultDate(new Date());
					FindComTaskList findComTaskList = new FindComTaskList();
					findComTaskList.setMerchantNo(findPmAbandonReturn.getMerchantNo());
					findComTaskList.setComTaskType(ComTaskType.COM_TASK);
					FindComTaskListReturn findComTaskListReturn = comTaskListService.findComTaskList(findComTaskList);
					if(findComTaskListReturn != null){
						addComTask.setCodeList(findComTaskListReturn.getCode());
						addComTask.setMemberNo(findPmAbandonReturn.getMemberNo());
						addComTask.setMemberName(findPmAbandonReturn.getMemberName());
						comTaskService.addComTaskWithFinish(addComTask,"2");
						
						//添加积分
						GuidMemberIntegralDto guidMemberIntegralDto = new GuidMemberIntegralDto();
						guidMemberIntegralDto.setMerchantNo(findPmAbandonReturn.getMerchantNo());
						guidMemberIntegralDto.setMemberNo(findPmAbandonReturn.getMemberNoGm());
						FindGuidMemberDto findGuidMemberDto = new FindGuidMemberDto();
						findGuidMemberDto.setMemberNo(findPmAbandonReturn.getMemberNoGm());
						GuidMemberReturnDto guidMemberReturnDto = guidMemberService.findGuid(findGuidMemberDto);
						if(guidMemberReturnDto != null){
							guidMemberIntegralDto.setShopNo(guidMemberReturnDto.getShopNo());
							guidMemberIntegralDto.setAreaCode(guidMemberReturnDto.getAreaCode());
						}
						guidMemberIntegralDto.setIntegralType(IntegralType.COM_TASK.toString());
						guidMemberIntegralService.doIntegral(guidMemberIntegralDto);
					}
				}
			}

			AbandonCheckReturn abandonCheckReturn  = new AbandonCheckReturn();
			logger.debug("abandonCheck(AbandonCheckDto abandonCheckDto={}) - end", abandonCheckDto); //$NON-NLS-1$
			return abandonCheckReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("审批错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_ABANDON_CHECK_ERROR,"审批错误！",e);
		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientFollowService#orderHistory(com.lj.business.cf.dto.FindClientFollow)
	 */
	@Override
	public List<FindClientFollowReturn> orderHistory(FindClientFollow findClientFollow) throws TsfaServiceException {
		logger.debug("orderHistory(FindClientFollow orderHistory={}) - start", findClientFollow); //$NON-NLS-1$

		List<FindClientFollowReturn> returnList;
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("memberNo", findClientFollow.getMemberNo());
			map.put("memberGMCode", findClientFollow.getMemberNoGm());
			map.put("cfNo", findClientFollow.getCfNo());
			returnList = clientFollowDao.orderHistory(map);
		}  catch (Exception e) {
			logger.error("客户跟踪表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_FIND_PAGE_ERROR,"客户跟踪表信息分页查询错误.！",e);
		}

		logger.debug("orderHistory(orderHistory) - end - return value={}", returnList); //$NON-NLS-1$
		return  returnList;
	}

	@Override
	public int cfCount(FindClientFollow findClientFollow) throws TsfaServiceException {
		AssertUtils.notNull(findClientFollow);
		AssertUtils.notNullAndEmpty(findClientFollow.getCfNo(), "跟进编号不能为空");
		try{
			int count = 0;
			count = clientFollowDao.cfCount(findClientFollow);
			return count;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("客户跟踪表信息分页查询错误！",e);
			throw new TsfaServiceException(ErrorCode.PM_ABANDON_CHECK_TIME_ERROR,"客户跟踪表信息分页查询错误！",e);
		}
		
	}
	

	/**
	 * 跟进或者维护列表.
	 *
	 * @param findClientFollowClientKeep the find client follow client keep
	 * @return the find client follow client keep return
	 * @throws TsfaServiceException the tsfa service exception
	 */
	@Override
	public FindClientFollowClientKeepReturn cfOrCkHistory(FindClientFollowClientKeep findClientFollowClientKeep) throws TsfaServiceException {
		logger.debug("cfOrCkHistory(FindClientFollowClientKeep findClientFollowClientKeep={}) - start", findClientFollowClientKeep); //$NON-NLS-1$

		AssertUtils.notNull(findClientFollowClientKeep);
		AssertUtils.notNullAndEmpty(findClientFollowClientKeep.getMerchantNo(), "商户编号不能为空");
		AssertUtils.notNullAndEmpty(findClientFollowClientKeep.getMemberNo(), "客户编号不能为空");
		AssertUtils.notNullAndEmpty(findClientFollowClientKeep.getMemberNoGm(), "导购编号不能为空");
		FindClientFollowClientKeepReturn findClientFollowClientKeepReturn = new FindClientFollowClientKeepReturn();
		findClientFollowClientKeepReturn.setType("0");
		try{
			//查询跟进总表中导购和客户最后一条记录
			FindClientFollowSummary findClientFollowSummary = new FindClientFollowSummary();
			findClientFollowSummary.setMerchantNo(findClientFollowClientKeep.getMerchantNo());
			findClientFollowSummary.setMemberNoGm(findClientFollowClientKeep.getMemberNoGm());
			findClientFollowSummary.setMemberNo(findClientFollowClientKeep.getMemberNo());
			FindClientFollowSummaryReturn findClientFollowSummaryReturn = clientFollowSummaryService.findClientFollowSummaryLast(findClientFollowSummary);
			if(findClientFollowSummaryReturn != null){
				//存在记录则为跟踪
				findClientFollowClientKeepReturn.setType("1");
				FindClientFollow findClientFollow = new FindClientFollow();
				findClientFollow.setCfNo(findClientFollowSummaryReturn.getCfNo());
				List<FindClientFollowReturn> cfList = cfHistory(findClientFollow);
				findClientFollowClientKeepReturn.setCfList(cfList);
			}else{
				FindClientKeepSummary findClientKeepSummary =new FindClientKeepSummary();
				findClientKeepSummary.setMerchantNo(findClientFollowClientKeep.getMerchantNo());
				findClientKeepSummary.setMemberNoGm(findClientFollowClientKeep.getMemberNoGm());
				findClientKeepSummary.setMemberNo(findClientFollowClientKeep.getMemberNo());
				FindClientKeepSummaryReturn  findClientKeepSummaryReturn  = clientKeepSummaryService.findClientKeepSummaryLast(findClientKeepSummary);
				if(findClientKeepSummaryReturn != null){
					//存在记录则为维护
					findClientFollowClientKeepReturn.setType("2");
					FindClientKeep findClientKeep = new FindClientKeep();
					findClientKeep.setCkNo(findClientKeepSummaryReturn.getCkNo());
					List<FindClientKeepReturn> ckList = clientKeepService.clientKeepHistory(findClientKeep);
					findClientFollowClientKeepReturn.setCkList(ckList);
				}
			}

		}catch (Exception e) {
			logger.error("跟进或者维护列表查询错误",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_KEEP_FIND_ERROR,"跟进或者维护列表查询错误.！",e);
		}

		logger.debug("cfOrCkHistory(FindClientFollowClientKeep findClientFollowClientKeep={}) - end", findClientFollowClientKeep); //$NON-NLS-1$
		return findClientFollowClientKeepReturn;
	}


	@Override
	public List<ClientFollow> findTodayOrder(FindTaskSetAndOrder findTaskSetAndOrder) {
		AssertUtils.notNull(findTaskSetAndOrder);

		try {
			String today = DateUtils.formatDate(new Date(), DateUtils.PATTERN_yyyy_MM_dd);
			findTaskSetAndOrder.setStartDate(today + " 00:00:00");
			findTaskSetAndOrder.setEndDate(today + " 23:59:59");
			return clientFollowDao.findTodayOrder(findTaskSetAndOrder);
		} catch (Exception e) {
			logger.error("查询今天的订单有误", e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_FIND_ORDER, "查询今天订单错误", e);
		}
	}

	@Override
	public Long findMonthOrderMoney(FindTaskSetAndOrder findTaskSetAndOrder) {
		AssertUtils.notNull(findTaskSetAndOrder);
		
		try {
			String month = DateUtils.formatDate(new Date(), "yyyy-MM");
			findTaskSetAndOrder.setStartDate(month + "-01 00:00:00");
			findTaskSetAndOrder.setEndDate(month + "-31 23:59:59");
			return clientFollowDao.findMonthOrderMoney(findTaskSetAndOrder);
		} catch (Exception e) {
			logger.error("查询月订单有误", e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_FIND_ORDER, "查询月订单错误", e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientFollowService#findLastClientFollow(com.lj.business.cf.dto.FindCForCKLastDateDto)
	 */
	@Override
	public ClientFollow findLastClientFollow(FindCForCKLastDateDto findCForCKLastDateDto) throws TsfaServiceException{
		AssertUtils.notNull(findCForCKLastDateDto);
		AssertUtils.notNullAndEmpty(findCForCKLastDateDto.getCfNo(), "跟踪编号不能为空");
		AssertUtils.notNullAndEmpty(findCForCKLastDateDto.getType(), "跟踪类型不能为空");
		try {
			return clientFollowDao.findLastClientFollow(findCForCKLastDateDto);
		} catch (Exception e) {
			logger.error("查找最后一条跟进记录", e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_LAST_ERROR, "查找最后一条跟进记录", e);
		}
		
	}


	@Override
	public int findClientFollowCount(FindClientFollowMap findClientFollowMap)throws TsfaServiceException {
		logger.debug("findClientFollowCount(FindClientFollowMap findClientFollowMap={}) - start", findClientFollowMap);
		int count=0;
		try {
			count=clientFollowDao.findClientFollowCount(findClientFollowMap);
		} catch (Exception e) {
			logger.error("查找跟进次数错误！", e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_LAST_ERROR, "查找跟进次数错误！", e);
		}
		return count;
	}


	@Override
	public int findClientFollowSum(FindClientFollowMap findClientFollowMap) {
		logger.debug("findClientFollowCount(FindClientFollowMap findClientFollowMap={}) - start", findClientFollowMap);
		int sum=0;
		try {
			sum=clientFollowDao.findClientFollowSum(findClientFollowMap);
		} catch (Exception e) {
			logger.error("查找跟进次数错误！", e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_LAST_ERROR, "查找跟进次数错误！", e);
		}
		return sum;
	}


	@Override
	public int findLClientFollowCountMemberNo(
			FindClientFollowMap findClientFollowMap) {
		logger.debug("findLClientFollowCountMemberNo(FindClientFollowMap findClientFollowMap={}) - start", findClientFollowMap);
		int memberNoNum=0;
		try {
			memberNoNum=clientFollowDao.findLClientFollowCountMemberNo(findClientFollowMap);
		} catch (Exception e) {
			logger.error("统计客户数错误！", e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_LAST_ERROR, "统计客户数错误！", e);
		}
		return memberNoNum;
	}


	@Override
	public int findLClientFollowCountDeal(
			FindClientFollowMap findClientFollowMap) {
		logger.debug("findLClientFollowCountMemberNo(FindClientFollowMap findClientFollowMap={}) - start", findClientFollowMap);
		int dealNum=0;
		try {
			dealNum=clientFollowDao.findLClientFollowCountDeal(findClientFollowMap);
		} catch (Exception e) {
			logger.error("统计成单数错误！", e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_LAST_ERROR, "统计成单数错误！", e);
		}
		return dealNum;
	}


	@Override
	public int findClientFollowSumMemberNo(
			FindClientFollowMap findClientFollowMap) {
		logger.debug("findLClientFollowCountMemberNo(FindClientFollowMap findClientFollowMap={}) - start", findClientFollowMap);
		int sumMemberNo=0;
		try {
			sumMemberNo=clientFollowDao.findClientFollowSumMemberNo(findClientFollowMap);
		} catch (Exception e) {
			logger.error("统计成单数错误！", e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_LAST_ERROR, "统计成单数错误！", e);
		}
		return sumMemberNo;
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientFollowService#noticeSendMetGenClientFollow(com.lj.business.cf.dto.NoticeSendMetGenClientFollowDto)
	 */
	@Override
	public void noticeSendMetGenClientFollow(NoticeSendMetGenClientFollowDto noticeSendMetGenClientFollowDto) throws TsfaServiceException {
		AssertUtils.notNull(noticeSendMetGenClientFollowDto);
		AssertUtils.notNullAndEmpty(noticeSendMetGenClientFollowDto.getCfNo(), "跟踪编号不能为空");
		AssertUtils.notNullAndEmpty(noticeSendMetGenClientFollowDto.getMaterialTypeName(), "素材类型名称不能为空");
		AssertUtils.notNullAndEmpty(noticeSendMetGenClientFollowDto.getMemberNo(), "会员编号不能为空");
		AssertUtils.notNullAndEmpty(noticeSendMetGenClientFollowDto.getMemberNoGm(), "导购编号不能为空");
		AssertUtils.notNullAndEmpty(noticeSendMetGenClientFollowDto.getMerchantNo(), "商户编号不能为空");
		try {
			AddClientFollow addClientFollow = new AddClientFollow();
			addClientFollow.setCfNo(noticeSendMetGenClientFollowDto.getCfNo());
			addClientFollow.setMemberNo(noticeSendMetGenClientFollowDto.getMemberNo());
			addClientFollow.setMemberNoGm(noticeSendMetGenClientFollowDto.getMemberNoGm());
			addClientFollow.setMerchantNo(noticeSendMetGenClientFollowDto.getMerchantNo());
			addClientFollow.setFollowTime(new Date());
			addClientFollow.setComTaskType(ComTaskType.REMIND.toString());
			addClientFollow.setComTaskTypeCf(ComTaskType.REMIND.toString());
			addClientFollow.setFollowInfo("发送" + noticeSendMetGenClientFollowDto.getMaterialTypeName() + "素材");
			addCFOrder(addClientFollow, "0",false,false);
		} catch (Exception e) {
			logger.error("提醒发送素材生成跟进记录错误", e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_NOTICE_SENT_MET_ERROR, "提醒发送素材生成跟进记录错误", e);
		}
	}


	@Override
	public FindClientFollowReturn findClientFollowByGmAndMember(FindClientFollow findClientFollow) {
		AssertUtils.notNullAndEmpty(findClientFollow.getMemberNo(), "会员编号不能为空");
		AssertUtils.notNullAndEmpty(findClientFollow.getMemberNoGm(), "导购编号不能为空");
		try {
		return clientFollowDao.findClientFollowByGmAndMember(findClientFollow);
		} catch (Exception e) {
			logger.error("查找最后一条跟进记录错误", e);
			throw new TsfaServiceException(ErrorCode.CLIENT_FOLLOW_LAST_ERROR, "查找最后一条跟进记录错误", e);
		}
	}
	
	
	
}
