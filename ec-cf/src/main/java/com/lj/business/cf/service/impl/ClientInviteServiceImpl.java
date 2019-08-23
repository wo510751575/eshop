package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.IClientInviteDao;
import com.lj.business.cf.domain.ClientInvite;
import com.lj.business.cf.dto.FindAddInviteRecordDto;
import com.lj.business.cf.dto.clientFollow.AddClientFollow;
import com.lj.business.cf.dto.clientFollow.AddClientFollowReturn;
import com.lj.business.cf.dto.clientInvite.AddClientInvite;
import com.lj.business.cf.dto.clientInvite.DelClientInvite;
import com.lj.business.cf.dto.clientInvite.FindClientInvite;
import com.lj.business.cf.dto.clientInvite.FindClientInviteReturn;
import com.lj.business.cf.dto.clientInvite.UpdateClientInvite;
import com.lj.business.cf.dto.comTask.AddComTask;
import com.lj.business.cf.dto.comTask.GenerateNextDate;
import com.lj.business.cf.dto.comTaskList.FindComTaskList;
import com.lj.business.cf.dto.comTaskList.FindComTaskListReturn;
import com.lj.business.cf.emus.ComTaskType;
import com.lj.business.cf.emus.FollowNoType;
import com.lj.business.cf.service.IClientFollowService;
import com.lj.business.cf.service.IClientInviteService;
import com.lj.business.cf.service.IComTaskListService;
import com.lj.business.cf.service.IComTaskService;
import com.lj.business.common.CommonConstant;
import com.lj.business.member.dto.FindPersonMemberBase;
import com.lj.business.member.dto.FindPersonMemberBaseReturn;
import com.lj.business.member.service.IPersonMemberBaseService;

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
public class ClientInviteServiceImpl implements IClientInviteService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ClientInviteServiceImpl.class);
	

	@Resource
	private IClientInviteDao clientInviteDao;
	
	@Resource
	private IClientFollowService clientFollowService;
	
	@Resource
	private IComTaskListService comTaskListService;
	
	@Resource
	private IComTaskService comTaskService;
	
	@Resource
	private IPersonMemberBaseService personMemberBaseService;
	
	@Override
	public void addClientInvite(
			AddClientInvite addClientInvite) throws TsfaServiceException {
		logger.debug("addClientInvite(AddClientInvite addClientInvite={}) - start", addClientInvite); 

		AssertUtils.notNull(addClientInvite);
		AssertUtils.notNull(addClientInvite.getMerchantNo(),"商户编号不能为空");
		try {
			ClientInvite clientInvite = new ClientInvite();
			//add数据录入
			clientInvite.setCode(GUID.generateCode());
			clientInvite.setMerchantNo(addClientInvite.getMerchantNo());
			clientInvite.setMemberNo(addClientInvite.getMemberNo());
			clientInvite.setMemberName(addClientInvite.getMemberName());
			clientInvite.setMemberNoGm(addClientInvite.getMemberNoGm());
			clientInvite.setMemberNameGm(addClientInvite.getMemberNameGm());
			clientInvite.setShopNo(addClientInvite.getShopNo());
			clientInvite.setShopName(addClientInvite.getShopName());
			clientInvite.setReachTime(addClientInvite.getReachTime());
			clientInvite.setFailReason(addClientInvite.getFailReason());
			clientInvite.setInviteResult(addClientInvite.getInviteResult());
			clientInvite.setCfNo(addClientInvite.getCfNo());
			clientInvite.setCfCode(addClientInvite.getCfCode());
			clientInvite.setCreateId(addClientInvite.getCreateId());
			clientInvite.setCreateDate(new Date());
			clientInvite.setRemark(addClientInvite.getRemark());
			clientInvite.setRemark4(addClientInvite.getRemark4());
			clientInvite.setRemark3(addClientInvite.getRemark3());
			clientInvite.setRemark2(addClientInvite.getRemark2());
			clientInviteDao.insertSelective(clientInvite);
			logger.debug("addClientInvite(AddClientInvite) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户邀约表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_INVITE_ADD_ERROR,"新增客户邀约表信息错误！",e);
		}
	}
	
	
	@Override
	public void delClientInvite(
			DelClientInvite delClientInvite) throws TsfaServiceException {
		logger.debug("delClientInvite(DelClientInvite delClientInvite={}) - start", delClientInvite); 

		AssertUtils.notNull(delClientInvite);
		AssertUtils.notNull(delClientInvite.getCode(),"Code不能为空！");
		try {
			clientInviteDao.deleteByPrimaryKey(delClientInvite.getCode());
			logger.debug("delClientInvite(DelClientInvite) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除客户邀约表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_INVITE_DEL_ERROR,"删除客户邀约表信息错误！",e);

		}
	}

	@Override
	public void updateClientInvite(
			UpdateClientInvite updateClientInvite)
			throws TsfaServiceException {
		logger.debug("updateClientInvite(UpdateClientInvite updateClientInvite={}) - start", updateClientInvite); //$NON-NLS-1$

		AssertUtils.notNull(updateClientInvite);
		AssertUtils.notNullAndEmpty(updateClientInvite.getCode(),"Code不能为空");
		try {
			ClientInvite clientInvite = new ClientInvite();
			//update数据录入
			clientInvite.setCode(updateClientInvite.getCode());
			clientInvite.setMerchantNo(updateClientInvite.getMerchantNo());
			clientInvite.setMemberNo(updateClientInvite.getMemberNo());
			clientInvite.setMemberName(updateClientInvite.getMemberName());
			clientInvite.setMemberNoGm(updateClientInvite.getMemberNoGm());
			clientInvite.setMemberNameGm(updateClientInvite.getMemberNameGm());
			clientInvite.setShopNo(updateClientInvite.getShopNo());
			clientInvite.setShopName(updateClientInvite.getShopName());
			clientInvite.setReachTime(updateClientInvite.getReachTime());
			clientInvite.setFailReason(updateClientInvite.getFailReason());
			clientInvite.setInviteResult(updateClientInvite.getInviteResult());
			clientInvite.setCfNo(updateClientInvite.getCfNo());
			clientInvite.setCfCode(updateClientInvite.getCfCode());
			clientInvite.setCreateId(updateClientInvite.getCreateId());
			clientInvite.setCreateDate(updateClientInvite.getCreateDate());
			clientInvite.setRemark(updateClientInvite.getRemark());
			clientInvite.setRemark4(updateClientInvite.getRemark4());
			clientInvite.setRemark3(updateClientInvite.getRemark3());
			clientInvite.setRemark2(updateClientInvite.getRemark2());
			AssertUtils.notUpdateMoreThanOne(clientInviteDao.updateByPrimaryKeySelective(clientInvite));
			logger.debug("updateClientInvite(UpdateClientInvite) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户邀约表信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_INVITE_UPDATE_ERROR,"客户邀约表信息更新信息错误！",e);
		}
	}

	

	@Override
	public FindClientInviteReturn findClientInvite(
			FindClientInvite findClientInvite) throws TsfaServiceException {
		logger.debug("findClientInvite(FindClientInvite findClientInvite={}) - start", findClientInvite); //$NON-NLS-1$

		AssertUtils.notNull(findClientInvite);
		AssertUtils.notAllNull(findClientInvite.getCode(),"Code不能为空");
		try {
			ClientInvite clientInvite = clientInviteDao.selectByPrimaryKey(findClientInvite.getCode());
			if(clientInvite == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.CLIENT_INVITE_NOT_EXIST_ERROR,"客户邀约表信息不存在");
			}
			FindClientInviteReturn findClientInviteReturn = new FindClientInviteReturn();
			//find数据录入
			findClientInviteReturn.setCode(clientInvite.getCode());
			findClientInviteReturn.setMerchantNo(clientInvite.getMerchantNo());
			findClientInviteReturn.setMemberNo(clientInvite.getMemberNo());
			findClientInviteReturn.setMemberName(clientInvite.getMemberName());
			findClientInviteReturn.setMemberNoGm(clientInvite.getMemberNoGm());
			findClientInviteReturn.setMemberNameGm(clientInvite.getMemberNameGm());
			findClientInviteReturn.setShopNo(clientInvite.getShopNo());
			findClientInviteReturn.setShopName(clientInvite.getShopName());
			findClientInviteReturn.setReachTime(clientInvite.getReachTime());
			findClientInviteReturn.setFailReason(clientInvite.getFailReason());
			findClientInviteReturn.setInviteResult(clientInvite.getInviteResult());
			findClientInviteReturn.setCfNo(clientInvite.getCfNo());
			findClientInviteReturn.setCfCode(clientInvite.getCfCode());
			findClientInviteReturn.setCreateId(clientInvite.getCreateId());
			findClientInviteReturn.setCreateDate(clientInvite.getCreateDate());
			findClientInviteReturn.setRemark(clientInvite.getRemark());
			findClientInviteReturn.setRemark4(clientInvite.getRemark4());
			findClientInviteReturn.setRemark3(clientInvite.getRemark3());
			findClientInviteReturn.setRemark2(clientInvite.getRemark2());
			
			logger.debug("findClientInvite(FindClientInvite) - end - return value={}", findClientInviteReturn); //$NON-NLS-1$
			return findClientInviteReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找客户邀约表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_INVITE_FIND_ERROR,"查找客户邀约表信息信息错误！",e);
		}


	}
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientInviteService#inviteRecordCount(com.lj.business.cf.dto.FindAddInviteRecordDto)
	 */
	@Override
	public int inviteRecordCount(FindAddInviteRecordDto findAddInviteRecordDto)  throws TsfaServiceException {
		int count = 0;
		try {
			count = clientInviteDao.inviteRecordCount(findAddInviteRecordDto);
		} catch (Exception e) {
			logger.error("查找客户邀约表信息信息错误", e);
			throw new TsfaServiceException(ErrorCode.CLIENT_INVITE_FIND_ERROR, "查找客户邀约表信息信息错误！", e);
		}
		return count;
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientInviteService#addInviteRecord(com.lj.business.cf.dto.FindAddInviteRecordDto)
	 */
	@Override
	public void addInviteRecord(FindAddInviteRecordDto findAddInviteRecordDto) throws TsfaServiceException {
		logger.debug("addInviteRecord(FindAddInviteRecordDto findAddInviteRecordDto)={}) - start", findAddInviteRecordDto); //$NON-NLS-1$
		AssertUtils.notNull(findAddInviteRecordDto);
		AssertUtils.notNullAndEmpty(findAddInviteRecordDto.getMerchantNo(), "商户编号不能为空");
		AssertUtils.notNullAndEmpty(findAddInviteRecordDto.getMemberNo(), "客户编号不能为空");
		AssertUtils.notNullAndEmpty(findAddInviteRecordDto.getMemberNoGm(), "导购编号不能为空");
		AssertUtils.notNullAndEmpty(findAddInviteRecordDto.getShopNo(), "分店编号不能为空");
		AssertUtils.notNullAndEmpty(findAddInviteRecordDto.getInviteResult(), "邀约结果不能为空");
		AssertUtils.notNullAndEmpty(findAddInviteRecordDto.getCfNo(), "跟进编号不能为空");
		try{
			Date now = new Date();
			if("Y".equals(findAddInviteRecordDto.getInviteResult())){
				Date reachTime = findAddInviteRecordDto.getReachTime();
				AssertUtils.notNullAndEmpty(reachTime, "到店时间不能为空");
			    //邀约成功产生跟进记录、到店任务
				AddClientFollow addClientFollow = new AddClientFollow();
				addClientFollow.setCfNo(findAddInviteRecordDto.getCfNo());
				addClientFollow.setMemberNo(findAddInviteRecordDto.getMemberNo());
				addClientFollow.setMemberNoGm(findAddInviteRecordDto.getMemberNoGm());
				addClientFollow.setMerchantNo(findAddInviteRecordDto.getMerchantNo());
				addClientFollow.setFollowTime(now);
				
				
				//产生提醒任务,必须放在体验任务前，否则会被关闭
				//查询到店体验的code
				/*FindComTaskList findComTaskList_remind = new FindComTaskList();
				findComTaskList_remind.setComTaskType(ComTaskType.REMIND);
				findComTaskList_remind.setMerchantNo(findAddInviteRecordDto.getMerchantNo());
				FindComTaskListReturn findComTaskListReturn_remind = comTaskListService.findComTaskList(findComTaskList_remind);
				if(findComTaskListReturn_remind != null){
					addClientFollow.setTaskCode(findComTaskListReturn_remind.getCode());
				}
				addClientFollow.setComTaskType(ComTaskType.REMIND.toString());
				addClientFollow.setComTaskTypeCf(ComTaskType.REMIND.toString());
				addClientFollow.setFollowInfo("邀约成功，提醒客户到店");
				//体验任务时间判断，如果体验任务在当天，则产生当天的提醒任务，如果在+1天以后则产生-1天。
				Date nextDateRemind = reachTime;
				if(!DateUtils.isSameDay(reachTime, now)){
					nextDateRemind = DateUtils.addDays(reachTime, -1);
				}
				addClientFollow.setNextDate(nextDateRemind);
				addClientFollow.setDis(false);
				addClientFollow.setRemarkCom(CommonConstant.REPLACE_REMARK_COM +"邀约成功，提醒客户到店" );
				addClientFollow.setLastResultDate(new Date());*/
				
				
				//产生体验任务
				//查询到店体验的code
				FindComTaskList findComTaskList = new FindComTaskList();
				findComTaskList.setComTaskType(ComTaskType.CLIENT_EXP);
				findComTaskList.setMerchantNo(findAddInviteRecordDto.getMerchantNo());
				FindComTaskListReturn findComTaskListReturn = comTaskListService.findComTaskList(findComTaskList);
				if(findComTaskListReturn != null){
					addClientFollow.setTaskCode(findComTaskListReturn.getCode());
				}
				addClientFollow.setComTaskType(ComTaskType.CLIENT_EXP.toString());
				addClientFollow.setComTaskTypeCf(ComTaskType.INVITE.toString());
				addClientFollow.setFollowInfo("邀约成功");
				addClientFollow.setNextDate(reachTime);
				// 邀约次数
				int count = inviteRecordCount(findAddInviteRecordDto);
				
				//彭阳加的三个参数  完善任务处理
				addClientFollow.setDis(findAddInviteRecordDto.getDis());
				addClientFollow.setComTaskCode(findAddInviteRecordDto.getComTaskCode());
				
				addClientFollow.setClientInviteNum(count + 1);
				addClientFollow.setRemarkCom(CommonConstant.REPLACE_REMARK_COM +"邀约成功" );
				addClientFollow.setLastResultDate(new Date());
				AddClientFollowReturn addClientFollowReturn = clientFollowService.addCFOrder(addClientFollow, "0",true,true);
				//添加邀约记录
				AddClientInvite addClientInvite = new AddClientInvite();
				addClientInvite.setInviteResult(findAddInviteRecordDto.getInviteResult());
				addClientInvite.setCfNo(addClientFollowReturn.getCfNo());
				addClientInvite.setCfCode(addClientFollowReturn.getCode());
				addClientInvite.setMerchantNo(addClientFollowReturn.getMerchantNo());
				addClientInvite.setShopNo(addClientFollowReturn.getShopNo());
				addClientInvite.setShopName(addClientFollowReturn.getShopName());
				addClientInvite.setMemberNo(addClientFollowReturn.getMemberNo());
				addClientInvite.setMemberName(addClientFollowReturn.getMemberName());
				addClientInvite.setMemberNoGm(addClientFollowReturn.getMemberNoGm());
				addClientInvite.setMemberNameGm(addClientFollowReturn.getMemberNameGm());
				addClientInvite.setReachTime(reachTime);
				addClientInvite(addClientInvite);
				
				//邀约成功生成提醒任务，不生成跟进记录，提醒发素材后生成跟进记录
				AddComTask addComTask = new AddComTask();
				addComTask.setMerchantNo(findAddInviteRecordDto.getMerchantNo());
				addComTask.setMemberNoGm(findAddInviteRecordDto.getMemberNoGm());
				addComTask.setCfNo(findAddInviteRecordDto.getCfNo());
				addComTask.setNoType(FollowNoType.FOLLOW.toString());
				//体验任务时间判断，如果体验任务在当天，则产生当天的提醒任务，如果在+1天以后则产生-1天。
				Date nextDateRemind = reachTime;
				if(!DateUtils.isSameDay(reachTime, now)){
					nextDateRemind = DateUtils.addDays(reachTime, -1);
				}
				addComTask.setWorkDate(nextDateRemind);
				FindComTaskList findComTaskList_remind = new FindComTaskList();
				findComTaskList_remind.setComTaskType(ComTaskType.REMIND);
				findComTaskList_remind.setMerchantNo(findAddInviteRecordDto.getMerchantNo());
				FindComTaskListReturn findComTaskListReturn_remind = comTaskListService.findComTaskList(findComTaskList_remind);
				if(findComTaskListReturn_remind != null){
					addComTask.setCodeList(findComTaskListReturn_remind.getCode());
					addComTask.setNameList(findComTaskListReturn_remind.getNameList());
				}
				
				//addComTask.setCodeList(addClientFollow.getTaskCode());
				addComTask.setMemberNo(findAddInviteRecordDto.getMemberNo());
				addComTask.setMemberName(addClientFollowReturn.getMemberName());
				addComTask.setComTaskType(ComTaskType.REMIND);
				
				addComTask.setDis(false);//不关闭原任务
				addComTask.setOrgComTaskCode(null);//不关闭原任务
				addComTask.setFinishOrgComTask(false);//不关闭原任务
				addComTask.setRemarkCom(CommonConstant.REPLACE_REMARK_COM +"邀约成功" );//任务备注
				addComTask.setLastResultDate(addClientFollow.getLastResultDate());
				
				comTaskService.addComTaskWithFinish(addComTask,"0");
				
				//clientFollowService.addCFOrder(addClientFollow, "0");
				
				
			}else if("N".equals(findAddInviteRecordDto.getInviteResult())){
			    //邀约失败
				AddClientFollow addClientFollow = new AddClientFollow();
				addClientFollow.setCfNo(findAddInviteRecordDto.getCfNo());
				addClientFollow.setMemberNo(findAddInviteRecordDto.getMemberNo());
				addClientFollow.setMemberNoGm(findAddInviteRecordDto.getMemberNoGm());
				addClientFollow.setMerchantNo(findAddInviteRecordDto.getMerchantNo());
				//查询到店体验的code
				FindComTaskList findComTaskList = new FindComTaskList();
				findComTaskList.setComTaskType(ComTaskType.INVITE);
				findComTaskList.setMerchantNo(findAddInviteRecordDto.getMerchantNo());
				FindComTaskListReturn findComTaskListReturn = comTaskListService.findComTaskList(findComTaskList);
				if(findComTaskListReturn != null){
					addClientFollow.setTaskCode(findComTaskListReturn.getCode());
				}
				addClientFollow.setComTaskType(ComTaskType.INVITE.toString());
				addClientFollow.setComTaskTypeCf(ComTaskType.INVITE.toString());
				addClientFollow.setFollowInfo("客户未应邀，重新邀约");
				addClientFollow.setRemarkCom(CommonConstant.REPLACE_REMARK_COM +"客户未应邀，重新邀约" );
				addClientFollow.setLastResultDate(new Date());
				
				//客户未应邀，产生下周四的邀约任务
				GenerateNextDate generateNextDate = new GenerateNextDate();
				generateNextDate.setNextDate(now);
				generateNextDate.setNextWeek(true);
				Date reachTime = comTaskService.generateNextDate(generateNextDate);
				addClientFollow.setFollowTime(now);
				addClientFollow.setNextDate(reachTime);
				addClientFollow.setFollowInfo(findAddInviteRecordDto.getFailReason());
				AddClientFollowReturn addClientFollowReturn = clientFollowService.addCFOrder(addClientFollow, "0",true,true);
				//添加邀约记录
				AddClientInvite addClientInvite = new AddClientInvite();
				addClientInvite.setInviteResult(findAddInviteRecordDto.getInviteResult());
				addClientInvite.setCfNo(addClientFollowReturn.getCfNo());
				addClientInvite.setCfCode(addClientFollowReturn.getCode());
				addClientInvite.setMerchantNo(addClientFollowReturn.getMerchantNo());
				addClientInvite.setShopNo(addClientFollowReturn.getShopNo());
				addClientInvite.setShopName(addClientFollowReturn.getShopName());
				addClientInvite.setMemberNo(addClientFollowReturn.getMemberNo());
				addClientInvite.setMemberName(addClientFollowReturn.getMemberName());
				addClientInvite.setMemberNoGm(addClientFollowReturn.getMemberNoGm());
				addClientInvite.setMemberNameGm(addClientFollowReturn.getMemberNameGm());
				addClientInvite.setFailReason(findAddInviteRecordDto.getFailReason());
				addClientInvite.setCreateDate(now);
				addClientInvite(addClientInvite);
			}
			
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("新增客户邀约表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_INVITE_ADD_ERROR,"新增客户邀约表信息错误！",e);
		}
		
	}


	@Override
	public List<Map<String, Object>> findInviteResults(
			Map<String, Object> parmMap) {
		logger.debug("findInviteResults(Map<String, Object> parmMap={}) - start", parmMap); //$NON-NLS-1$

		AssertUtils.notNull(parmMap);
		AssertUtils.notAllNull(parmMap.get("merchantNo"),"商户不能为空");
		List<Map<String, Object>> list;
		try {
			list = clientInviteDao.findInviteResults(parmMap);
			logger.debug("findInviteResults(parmMap) - end - return value={}", parmMap); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找客户邀约表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_INVITE_FIND_ERROR,"查找客户邀约表信息信息错误！",e);
		}
		return list;
	}
	
}
