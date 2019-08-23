package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.constant.ErrorCode;
import com.lj.business.cf.dao.IClientGuidInfoDao;
import com.lj.business.cf.domain.ClientGuidInfo;
import com.lj.business.cf.dto.FindAddGuidInfoRecordDto;
import com.lj.business.cf.dto.clientFollow.AddClientFollow;
import com.lj.business.cf.dto.clientFollow.AddClientFollowReturn;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummary;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummaryReturn;
import com.lj.business.cf.dto.clientGuidInfo.AddClientGuidInfo;
import com.lj.business.cf.dto.clientGuidInfo.DelClientGuidInfo;
import com.lj.business.cf.dto.clientGuidInfo.FindClientGuidInfo;
import com.lj.business.cf.dto.clientGuidInfo.FindClientGuidInfoReturn;
import com.lj.business.cf.dto.clientGuidInfo.UpdateClientGuidInfo;
import com.lj.business.cf.dto.comTaskList.FindComTaskList;
import com.lj.business.cf.dto.comTaskList.FindComTaskListReturn;
import com.lj.business.cf.emus.ComTaskType;
import com.lj.business.cf.service.IClientFollowService;
import com.lj.business.cf.service.IClientFollowSummaryService;
import com.lj.business.cf.service.IClientGuidInfoService;
import com.lj.business.cf.service.IComTaskListService;
import com.lj.business.common.CommonConstant;
import com.lj.business.member.dto.FindGuidMember;
import com.lj.business.member.dto.FindGuidMemberReturn;
import com.lj.business.member.dto.guidMemberIntegral.GuidMemberIntegralDto;
import com.lj.business.member.emus.IntegralType;
import com.lj.business.member.service.IGuidMemberIntegralService;
import com.lj.business.member.service.IGuidMemberService;

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
public class ClientGuidInfoServiceImpl implements IClientGuidInfoService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ClientGuidInfoServiceImpl.class);
	

	@Resource
	private IClientGuidInfoDao clientGuidInfoDao;
	
	@Resource
	private IClientFollowSummaryService clientFollowSummaryService;
	
	@Resource
	private IComTaskListService comTaskListService;
	
	@Resource
	private IClientFollowService clientFollowService;
	
	@Resource
	public IGuidMemberIntegralService guidMemberIntegralService;
	
	@Resource
	private IGuidMemberService guidMemberService;
	
	@Override
	public void addClientGuidInfo(
			AddClientGuidInfo addClientGuidInfo) throws TsfaServiceException {
		logger.debug("addClientGuidInfo(AddClientGuidInfo addClientGuidInfo={}) - start", addClientGuidInfo); 

		AssertUtils.notNull(addClientGuidInfo);
		try {
			ClientGuidInfo clientGuidInfo = new ClientGuidInfo();
			//add数据录入
			clientGuidInfo.setCode(addClientGuidInfo.getCode());
			clientGuidInfo.setMerchantNo(addClientGuidInfo.getMerchantNo());
			clientGuidInfo.setMemberNo(addClientGuidInfo.getMemberNo());
			clientGuidInfo.setMemberName(addClientGuidInfo.getMemberName());
			clientGuidInfo.setMemberNoGm(addClientGuidInfo.getMemberNoGm());
			clientGuidInfo.setMemberNameGm(addClientGuidInfo.getMemberNameGm());
			clientGuidInfo.setShopNo(addClientGuidInfo.getShopNo());
			clientGuidInfo.setShopName(addClientGuidInfo.getShopName());
			clientGuidInfo.setSendTime(addClientGuidInfo.getSendTime());
			clientGuidInfo.setMaterialCode(addClientGuidInfo.getMaterialCode());
			clientGuidInfo.setMaterialCommenType(addClientGuidInfo.getMaterialCommenType());
			clientGuidInfo.setCfNo(addClientGuidInfo.getCfNo());
			clientGuidInfo.setCfCode(addClientGuidInfo.getCfCode());
			clientGuidInfo.setCreateId(addClientGuidInfo.getCreateId());
			clientGuidInfo.setCreateDate(addClientGuidInfo.getCreateDate());
			clientGuidInfo.setRemark(addClientGuidInfo.getRemark());
			clientGuidInfo.setRemark4(addClientGuidInfo.getRemark4());
			clientGuidInfo.setRemark3(addClientGuidInfo.getRemark3());
			clientGuidInfo.setRemark2(addClientGuidInfo.getRemark2());
			clientGuidInfoDao.insert(clientGuidInfo);
			logger.debug("addClientGuidInfo(AddClientGuidInfo) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户引导记录表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_GUID_INFO_ADD_ERROR,"新增客户引导记录表信息错误！",e);
		}
	}
	
	
	@Override
	public void delClientGuidInfo(
			DelClientGuidInfo delClientGuidInfo) throws TsfaServiceException {
		logger.debug("delClientGuidInfo(DelClientGuidInfo delClientGuidInfo={}) - start", delClientGuidInfo); 

		AssertUtils.notNull(delClientGuidInfo);
		AssertUtils.notNull(delClientGuidInfo.getCode(),"Code不能为空！");
		try {
			clientGuidInfoDao.deleteByPrimaryKey(delClientGuidInfo.getCode());
			logger.debug("delClientGuidInfo(DelClientGuidInfo) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除客户引导记录表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_GUID_INFO_DEL_ERROR,"删除客户引导记录表信息错误！",e);

		}
	}

	@Override
	public void updateClientGuidInfo(
			UpdateClientGuidInfo updateClientGuidInfo)
			throws TsfaServiceException {
		logger.debug("updateClientGuidInfo(UpdateClientGuidInfo updateClientGuidInfo={}) - start", updateClientGuidInfo); //$NON-NLS-1$

		AssertUtils.notNull(updateClientGuidInfo);
		AssertUtils.notNullAndEmpty(updateClientGuidInfo.getCode(),"Code不能为空");
		try {
			ClientGuidInfo clientGuidInfo = new ClientGuidInfo();
			//update数据录入
			clientGuidInfo.setCode(updateClientGuidInfo.getCode());
			clientGuidInfo.setMerchantNo(updateClientGuidInfo.getMerchantNo());
			clientGuidInfo.setMemberNo(updateClientGuidInfo.getMemberNo());
			clientGuidInfo.setMemberName(updateClientGuidInfo.getMemberName());
			clientGuidInfo.setMemberNoGm(updateClientGuidInfo.getMemberNoGm());
			clientGuidInfo.setMemberNameGm(updateClientGuidInfo.getMemberNameGm());
			clientGuidInfo.setShopNo(updateClientGuidInfo.getShopNo());
			clientGuidInfo.setShopName(updateClientGuidInfo.getShopName());
			clientGuidInfo.setSendTime(updateClientGuidInfo.getSendTime());
			clientGuidInfo.setMaterialCode(updateClientGuidInfo.getMaterialCode());
			clientGuidInfo.setMaterialCommenType(updateClientGuidInfo.getMaterialCommenType());
			clientGuidInfo.setCfNo(updateClientGuidInfo.getCfNo());
			clientGuidInfo.setCfCode(updateClientGuidInfo.getCfCode());
			clientGuidInfo.setCreateId(updateClientGuidInfo.getCreateId());
			clientGuidInfo.setCreateDate(updateClientGuidInfo.getCreateDate());
			clientGuidInfo.setRemark(updateClientGuidInfo.getRemark());
			clientGuidInfo.setRemark4(updateClientGuidInfo.getRemark4());
			clientGuidInfo.setRemark3(updateClientGuidInfo.getRemark3());
			clientGuidInfo.setRemark2(updateClientGuidInfo.getRemark2());
			AssertUtils.notUpdateMoreThanOne(clientGuidInfoDao.updateByPrimaryKeySelective(clientGuidInfo));
			logger.debug("updateClientGuidInfo(UpdateClientGuidInfo) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户引导记录表信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_GUID_INFO_UPDATE_ERROR,"客户引导记录表信息更新信息错误！",e);
		}
	}

	

	@Override
	public FindClientGuidInfoReturn findClientGuidInfo(
			FindClientGuidInfo findClientGuidInfo) throws TsfaServiceException {
		logger.debug("findClientGuidInfo(FindClientGuidInfo findClientGuidInfo={}) - start", findClientGuidInfo); //$NON-NLS-1$

		AssertUtils.notNull(findClientGuidInfo);
		AssertUtils.notAllNull(findClientGuidInfo.getCode(),"Code不能为空");
		try {
			ClientGuidInfo clientGuidInfo = clientGuidInfoDao.selectByPrimaryKey(findClientGuidInfo.getCode());
			if(clientGuidInfo == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.CLIENT_GUID_INFO_NOT_EXIST_ERROR,"客户引导记录表信息不存在");
			}
			FindClientGuidInfoReturn findClientGuidInfoReturn = new FindClientGuidInfoReturn();
			//find数据录入
			findClientGuidInfoReturn.setCode(clientGuidInfo.getCode());
			findClientGuidInfoReturn.setMerchantNo(clientGuidInfo.getMerchantNo());
			findClientGuidInfoReturn.setMemberNo(clientGuidInfo.getMemberNo());
			findClientGuidInfoReturn.setMemberName(clientGuidInfo.getMemberName());
			findClientGuidInfoReturn.setMemberNoGm(clientGuidInfo.getMemberNoGm());
			findClientGuidInfoReturn.setMemberNameGm(clientGuidInfo.getMemberNameGm());
			findClientGuidInfoReturn.setShopNo(clientGuidInfo.getShopNo());
			findClientGuidInfoReturn.setShopName(clientGuidInfo.getShopName());
			findClientGuidInfoReturn.setSendTime(clientGuidInfo.getSendTime());
			findClientGuidInfoReturn.setMaterialCode(clientGuidInfo.getMaterialCode());
			findClientGuidInfoReturn.setMaterialCommenType(clientGuidInfo.getMaterialCommenType());
			findClientGuidInfoReturn.setCfNo(clientGuidInfo.getCfNo());
			findClientGuidInfoReturn.setCfCode(clientGuidInfo.getCfCode());
			findClientGuidInfoReturn.setCreateId(clientGuidInfo.getCreateId());
			findClientGuidInfoReturn.setCreateDate(clientGuidInfo.getCreateDate());
			findClientGuidInfoReturn.setRemark(clientGuidInfo.getRemark());
			findClientGuidInfoReturn.setRemark4(clientGuidInfo.getRemark4());
			findClientGuidInfoReturn.setRemark3(clientGuidInfo.getRemark3());
			findClientGuidInfoReturn.setRemark2(clientGuidInfo.getRemark2());
			
			logger.debug("findClientGuidInfo(FindClientGuidInfo) - end - return value={}", findClientGuidInfoReturn); //$NON-NLS-1$
			return findClientGuidInfoReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找客户引导记录表信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_GUID_INFO_FIND_ERROR,"查找客户引导记录表信息信息错误！",e);
		}


	}
	
	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientGuidInfoService#guidInfoRecordCount(com.lj.business.cf.dto.FindAddGuidInfoRecordDto)
	 */
	@Override
	public int guidInfoRecordCount(FindAddGuidInfoRecordDto findAddGuidInfoRecordDto) throws TsfaServiceException {
		int count = 0;
		try {
			count = clientGuidInfoDao.guidInfoRecordCount(findAddGuidInfoRecordDto);
		} catch (Exception e) {
			logger.error("查找客户引导记录表信息信息错误", e);
			throw new TsfaServiceException(ErrorCode.CLIENT_GUID_INFO_FIND_ERROR, "查找客户引导记录表信息信息错误！", e);
		}
		return count;
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IClientGuidInfoService#addGuidInfoRecord(com.lj.business.cf.dto.FindAddGuidInfoRecordDto)
	 */
	@Override
	public void addGuidInfoRecord(FindAddGuidInfoRecordDto findAddGuidInfoRecordDto)throws TsfaServiceException {
		AssertUtils.notNull(findAddGuidInfoRecordDto);
		AssertUtils.notNullAndEmpty(findAddGuidInfoRecordDto.getMerchantNo(), "商户编号不能为空");
		AssertUtils.notNullAndEmpty(findAddGuidInfoRecordDto.getMemberNo(), "客户编号不能为空");
		AssertUtils.notNullAndEmpty(findAddGuidInfoRecordDto.getMemberNoGm(), "导购编号不能为空");
		AssertUtils.notNullAndEmpty(findAddGuidInfoRecordDto.getShopNo(), "分店编号不能为空");
		//AssertUtils.notNullAndEmpty(findAddGuidInfoRecordDto.getSendTime(), "发送时间不能为空");
		AssertUtils.notNullAndEmpty(findAddGuidInfoRecordDto.getMaterialCode(), "素材code不能为空");
		AssertUtils.notNullAndEmpty(findAddGuidInfoRecordDto.getMaterialCommenType(), "素材类型不能为空");
		
		try {
			if(findAddGuidInfoRecordDto.getSendTime() == null)
				findAddGuidInfoRecordDto.setSendTime(new Date());
			 //发送素材成功产生跟进记录、沟通任务
			AddClientFollow addClientFollow = new AddClientFollow();
			addClientFollow.setMerchantNo(findAddGuidInfoRecordDto.getMerchantNo());
			//查询cfNo
			//查询跟进总表中导购和客户最后一条记录
			FindClientFollowSummary findClientFollowSummary = new FindClientFollowSummary();
			findClientFollowSummary.setMerchantNo(findAddGuidInfoRecordDto.getMerchantNo());
			findClientFollowSummary.setMemberNoGm(findAddGuidInfoRecordDto.getMemberNoGm());
			findClientFollowSummary.setMemberNo(findAddGuidInfoRecordDto.getMemberNo());
			FindClientFollowSummaryReturn findClientFollowSummaryReturn = clientFollowSummaryService.findClientFollowSummaryLast(findClientFollowSummary);
			String cfNo = "";
			if(findClientFollowSummaryReturn != null){
				cfNo = findClientFollowSummaryReturn.getCfNo();
			}
			addClientFollow.setCfNo(cfNo);
			addClientFollow.setMemberNo(findAddGuidInfoRecordDto.getMemberNo());
			addClientFollow.setMemberNoGm(findAddGuidInfoRecordDto.getMemberNoGm());
			addClientFollow.setFollowTime(new Date());

			int hour = 0 ;
			Date now = new Date();
			Date reachTime = DateUtils.addHours(now, hour);
			addClientFollow.setNextDate(reachTime);
			//查询沟通任务的code
			FindComTaskList findComTaskList = new FindComTaskList();
			findComTaskList.setComTaskType(ComTaskType.INVITE);
			findComTaskList.setMerchantNo(findAddGuidInfoRecordDto.getMerchantNo());
			FindComTaskListReturn findComTaskListReturn = comTaskListService.findComTaskList(findComTaskList);
			if(findComTaskListReturn != null){
				addClientFollow.setTaskCode(findComTaskListReturn.getCode());
			}
			addClientFollow.setComTaskType(ComTaskType.INVITE.toString());
			addClientFollow.setComTaskTypeCf(ComTaskType.GUID_PM.toString());
			addClientFollow.setFollowInfo("发送素材引导客户购买");
			
			//计算素材引导次数 
			findAddGuidInfoRecordDto.setCfNo(cfNo);
			int count = guidInfoRecordCount(findAddGuidInfoRecordDto);
			
			//彭阳加的三个参数  完善任务处理
			addClientFollow.setDis(findAddGuidInfoRecordDto.getDis());
			addClientFollow.setComTaskCode(findAddGuidInfoRecordDto.getComTaskCode());
			
			addClientFollow.setClientGuidNum(count + 1);
			addClientFollow.setRemarkCom(CommonConstant.REPLACE_REMARK_COM +"素材引导客户" );
			addClientFollow.setLastResultDate(new Date());
			AddClientFollowReturn addClientFollowReturn = clientFollowService.addCFOrder(addClientFollow, "0",true,false);
			//添加客户引导记录
			AddClientGuidInfo addClientGuidInfo = new AddClientGuidInfo();
			addClientGuidInfo.setCode(GUID.generateCode());
			addClientGuidInfo.setCfNo(cfNo);
			addClientGuidInfo.setCfCode(addClientFollowReturn.getCode());
			addClientGuidInfo.setMerchantNo(findAddGuidInfoRecordDto.getMerchantNo());
			addClientGuidInfo.setShopNo(addClientFollowReturn.getShopNo());
			addClientGuidInfo.setShopName(addClientFollowReturn.getShopName());
			addClientGuidInfo.setMemberNo(findAddGuidInfoRecordDto.getMemberNo());
			addClientGuidInfo.setMemberName(addClientFollowReturn.getMemberName());
			addClientGuidInfo.setMemberNoGm(findAddGuidInfoRecordDto.getMemberNoGm());
			addClientGuidInfo.setMemberNameGm(addClientFollowReturn.getMemberNameGm());
			addClientGuidInfo.setSendTime(findAddGuidInfoRecordDto.getSendTime());
			addClientGuidInfo.setMaterialCode(findAddGuidInfoRecordDto.getMaterialCode());
			addClientGuidInfo.setMaterialCommenType(findAddGuidInfoRecordDto.getMaterialCommenType());
			addClientGuidInfo.setCreateDate(new Date());
			addClientGuidInfo(addClientGuidInfo);
			
			//添加积分
			GuidMemberIntegralDto guidMemberIntegralDto = new GuidMemberIntegralDto();
			guidMemberIntegralDto.setMerchantNo(findAddGuidInfoRecordDto.getMerchantNo());
			guidMemberIntegralDto.setMemberNo(findAddGuidInfoRecordDto.getMemberNoGm());
			
			FindGuidMember findGuidMember = new FindGuidMember();
			findGuidMember.setMemberNo(findAddGuidInfoRecordDto.getMemberNoGm());
			FindGuidMemberReturn findGuidMemberReturn = guidMemberService.findGuidMember(findGuidMember);
			
			if(findGuidMemberReturn != null){
				guidMemberIntegralDto.setShopNo(findGuidMemberReturn.getShopNo());
				guidMemberIntegralDto.setAreaCode(findGuidMemberReturn.getAreaCode());
			}
			guidMemberIntegralDto.setIntegralType(IntegralType.SEND_MET.toString());
			guidMemberIntegralService.doIntegral(guidMemberIntegralDto);
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("新增客户引导记录表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.CLIENT_GUID_INFO_ADD_ERROR,"新增客户引导记录表信息错误！",e);
		}
	}
	
}
