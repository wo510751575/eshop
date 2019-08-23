package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.encryption.MD5;
import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.EnumUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.comTaskChoose.AddComTaskChooseDto;
import com.lj.business.cf.dto.comTaskList.AddComTaskListDto;
import com.lj.business.cf.dto.comTaskList.FindComTaskList;
import com.lj.business.cf.dto.comTaskList.FindComTaskListPageDto;
import com.lj.business.cf.dto.comTaskList.FindComTaskListReturn;
import com.lj.business.cf.dto.taskSetShop.AddTaskSetShop;
import com.lj.business.cf.dto.workTaskChoose.AddWorkTaskChooseDto;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskList;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskListPageReturn;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskListReturn;
import com.lj.business.cf.emus.ComTaskType;
import com.lj.business.cf.emus.ShopTaskType;
import com.lj.business.cf.emus.UnitType;
import com.lj.business.cf.service.IComTaskChooseService;
import com.lj.business.cf.service.IComTaskListService;
import com.lj.business.cf.service.ITaskSetShopService;
import com.lj.business.cf.service.IWorkTaskChooseService;
import com.lj.business.cf.service.IWorkTaskListService;
import com.lj.business.member.constant.ErrorCode;
import com.lj.business.member.dao.IManagerMemberDao;
import com.lj.business.member.dao.IMerchantDao;
import com.lj.business.member.dao.IShopDao;
import com.lj.business.member.domain.ManagerMember;
import com.lj.business.member.domain.Merchant;
import com.lj.business.member.domain.Shop;
import com.lj.business.member.dto.AddMerchant;
import com.lj.business.member.dto.AddMerchantReturn;
import com.lj.business.member.dto.AddPmType;
import com.lj.business.member.dto.DelMerchant;
import com.lj.business.member.dto.DelMerchantReturn;
import com.lj.business.member.dto.FindMerchant;
import com.lj.business.member.dto.FindMerchantDto;
import com.lj.business.member.dto.FindMerchantPage;
import com.lj.business.member.dto.FindMerchantPageReturn;
import com.lj.business.member.dto.FindMerchantReturn;
import com.lj.business.member.dto.FindMerchantReturnDto;
import com.lj.business.member.dto.UpdateMerchant;
import com.lj.business.member.dto.UpdateMerchantReturn;
import com.lj.business.member.dto.integralSet.AddIntegralSet;
import com.lj.business.member.emus.DimensionStType;
import com.lj.business.member.emus.IntegralType;
import com.lj.business.member.emus.MemberStatus;
import com.lj.business.member.emus.MemberType;
import com.lj.business.member.emus.PmTypeType;
import com.lj.business.member.emus.ShopStatus;
import com.lj.business.member.service.IIntegralSetService;
import com.lj.business.member.service.IMerchantService;
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
 *         CreateDate: 2017-06-14
 */
@Service
public class MerchantServiceImpl implements IMerchantService {

	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(MerchantServiceImpl.class);

	/** The merchant dao. */
	@Resource
	private IMerchantDao merchantDao;

	@Resource
	private ITaskSetShopService taskSetShopService;

	@Resource
	private IWorkTaskListService workTaskListService;
	
	@Resource
	private IWorkTaskChooseService workTaskChooseService;

	@Resource
	private IComTaskListService comTaskListService;

	@Resource
	private IComTaskChooseService comTaskChooseService;


	@Resource
	private IPmTypeService pmTypeService;

	@Resource
	private IIntegralSetService integralSetService;
	/** The shop dao. */
	@Resource
	private IShopDao shopDao;
	@Resource
	private IManagerMemberDao managerMemberDao;

	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IMerchantService#addMerchant(com.lj.business
	 * .member.dto.AddMerchant)
	 */
	@Override
	public AddMerchantReturn addMerchant(AddMerchant addMerchant)
			throws TsfaServiceException {
		logger.debug("addMerchant(AddMerchant addMerchant={}) - start",addMerchant);
			AssertUtils.notNull(addMerchant);
			try {
				Merchant merchant = new Merchant();
				// add数据录入
				merchant.setCode(GUID.generateCode());
				if(StringUtils.isEmpty(addMerchant.getMerchantNo()))//兼容OMS同步数据
					merchant.setMerchantNo(GUID.generateByUUID());
				else
					merchant.setMerchantNo(addMerchant.getMerchantNo());//兼容OMS同步数据
				merchant.setMerchantName(addMerchant.getMerchantName());
				merchant.setStatus(addMerchant.getStatus());
				merchant.setAddress(addMerchant.getAddress());
				merchant.setEmail(addMerchant.getEmail());
				merchant.setBusinessType(addMerchant.getBusinessType());
				merchant.setLogoAddr(addMerchant.getLogoAddr());
				merchant.setWebsiteUrl(addMerchant.getWebsiteUrl());
				merchant.setTelephone(addMerchant.getTelephone());
				merchant.setCreateId(addMerchant.getCreateId());
				merchant.setRemark(addMerchant.getRemark());
				merchantDao.insert(merchant);

				logger.debug("店长任务设置表添加主要任务 销售目标：XIAO_SHOU 新增客户：XIN_ZENG 两条记录");
				initTaskSetShop(merchant);

				logger.debug("沟通任务");
				ComTaskType [] comTaskTypeAr = ComTaskType.values();
				initComTaskList(merchant, comTaskTypeAr);

				logger.debug("客户沟通任务选择表（基础）");
				initComTaskChoose(merchant, comTaskTypeAr);

				logger.debug("话术");
				initTextInfo(merchant);

				logger.debug("客户分类表（基础表）");
				initPmType(merchant);
				
				logger.debug("积分设置");
				initIntegralSet(merchant);
				
				logger.debug("工作事项选择表");
				 /*List<FindWorkTaskListPageReturn> list = workTaskListService.findWorkTaskListAll();
				 for (FindWorkTaskListPageReturn findWorkTaskListPageReturn : list) {
					
					AddWorkTaskChooseDto addWorkTaskChooseDto = new AddWorkTaskChooseDto();
					workTaskChooseService.addWorkTaskChoose(addWorkTaskChooseDto );
					 
				}*/
				
				logger.debug("统计中心"); //XXX LEOPENG 统计中心初始化
				
				
				AddMerchantReturn addMerchantReturn = new AddMerchantReturn();
				logger.debug("addMerchant(AddMerchant) - end - return value={}",addMerchantReturn);
				return addMerchantReturn;
			} catch (TsfaServiceException e) {
				logger.error(e.getMessage(), e);
				throw e;
			} catch (Exception e) {
				logger.error("新增商户表信息错误！", e);
				throw new TsfaServiceException(ErrorCode.MERCHANT_ADD_ERROR,
						"新增商户表信息错误！", e);
			}
	}

	/**
	 * 
	 *
	 * 方法说明：积分设置
	 *
	 * @param merchant
	 *
	 * @author 彭阳 CreateDate: 2017年9月7日
	 *
	 */
	private void initIntegralSet(Merchant merchant) {
		try {
			IntegralType integralTypeAr [] = IntegralType.values();
			for (IntegralType integralType : integralTypeAr) {
				AddIntegralSet addIntegralSet = new AddIntegralSet();
				//add数据录入
				addIntegralSet.setMerchantNo(merchant.getMerchantNo());
				addIntegralSet.setMerchantName(merchant.getMerchantName());
				addIntegralSet.setShopNo(null);
				addIntegralSet.setShopName(null);
				addIntegralSet.setAreaCode(null);
				addIntegralSet.setAreaName(null);
				addIntegralSet.setIntegralType(integralType.toString());
				addIntegralSet.setIntegralName(integralType.getName());
				if(integralType.equals(IntegralType.COM_TASK)){
					addIntegralSet.setIntegralScore(1.0);
					addIntegralSet.setIntegralUp(25.0);
					addIntegralSet.setIntegralDown(null);
				}else if(integralType.equals(IntegralType.NEW)){
					addIntegralSet.setIntegralScore(null);
					addIntegralSet.setIntegralUp(40.0);
					addIntegralSet.setIntegralDown(null);
				}else if(integralType.equals(IntegralType.XIAO_SHOU)){
					addIntegralSet.setIntegralScore(null);
					addIntegralSet.setIntegralUp(60.0);
					addIntegralSet.setIntegralDown(null);
				}else if(integralType.equals(IntegralType.NOTICE)){
					addIntegralSet.setIntegralScore(1.0);
					addIntegralSet.setIntegralUp(40.0);
					addIntegralSet.setIntegralDown(null);
				}else if(integralType.equals(IntegralType.SOCIAL)){
					addIntegralSet.setIntegralScore(1.0);
					addIntegralSet.setIntegralUp(10.0);
					addIntegralSet.setIntegralDown(null);
				}else if(integralType.equals(IntegralType.ACTIVE)){
					addIntegralSet.setIntegralScore(1.0);
					addIntegralSet.setIntegralUp(1.0);
					addIntegralSet.setIntegralDown(null);
				}else if(integralType.equals(IntegralType.ASK)){
					addIntegralSet.setIntegralScore(1.0);
					addIntegralSet.setIntegralUp(1.0);
					addIntegralSet.setIntegralDown(null);
				}else if(integralType.equals(IntegralType.NEW_MET)){
					addIntegralSet.setIntegralScore(1.0);
					addIntegralSet.setIntegralUp(4.0);
					addIntegralSet.setIntegralDown(null);
				}else if(integralType.equals(IntegralType.SEND_MET)){
					addIntegralSet.setIntegralScore(1.0);
					addIntegralSet.setIntegralUp(5.0);
					addIntegralSet.setIntegralDown(null);
				}
				addIntegralSet.setStatus("Y");
				addIntegralSet.setUpdateId(null);
				addIntegralSet.setUpdateDate(null);
				addIntegralSet.setCreateId("system");
				integralSetService.addIntegralSet(addIntegralSet );
			}
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
		}
	}

	private void initPmType(Merchant merchant) {
		try {
			PmTypeType pmTypeAr [] = PmTypeType.values();
			for (PmTypeType pmTypeType : pmTypeAr) {
				AddPmType addPmType = new AddPmType();
				//add数据录入
				addPmType.setMerchantNo(merchant.getMerchantNo());
				addPmType.setMemberNo(null);
				addPmType.setMemberName(null);
				addPmType.setTypeName(pmTypeType.getName());
				addPmType.setPmTypeType(pmTypeType.toString());

				if(pmTypeType.equals(PmTypeType.URGENCY)){
					addPmType.setFreValue("0");
					addPmType.setSeq(10);
				}else if(pmTypeType.equals(PmTypeType.REPEAT)){
					addPmType.setFreValue("0");
					addPmType.setSeq(20);
				}else if(pmTypeType.equals(PmTypeType.UNGROUP)){
					addPmType.setFreValue("0");
					addPmType.setSeq(30);
				}else if(pmTypeType.equals(PmTypeType.INTENTION)){
					addPmType.setFreValue("0");
					addPmType.setSeq(40);
				}else if(pmTypeType.equals(PmTypeType.INTENTION_N)){
					addPmType.setFreValue("0");
					addPmType.setSeq(50);
				}else if(pmTypeType.equals(PmTypeType.OTHER)){
					addPmType.setFreValue("0");
					addPmType.setSeq(60);
				}else if(pmTypeType.equals(PmTypeType.SUCCESS)){
					addPmType.setFreValue("0");
					addPmType.setSeq(70);
				}else if(pmTypeType.equals(PmTypeType.GIVE_UP)){
					addPmType.setFreValue("0");
					addPmType.setSeq(80);
				}
				addPmType.setStatus("Y");
				addPmType.setCreateId(null);
				addPmType.setRemark(null);
				addPmType.setRemark2(null);
				addPmType.setRemark3(null);
				addPmType.setRemark4(null);
				pmTypeService.addPmType(addPmType);
			}
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
		}
	}

	private void initTextInfo(Merchant merchant) {
		try {
			
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
		}
	}

	/**
	 * 
	 *
	 * 方法说明：店长任务设置表添加主要任务 销售目标：XIAO_SHOU 新增客户：XIN_ZENG 两条记录
	 *
	 * @param merchant
	 *
	 * @author 彭阳 CreateDate: 2017年9月7日
	 *
	 */
	private void initTaskSetShop(Merchant merchant) {
		try {
			Date startDate = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
			Date endDate = DateUtils.truncate(DateUtils.addYears(startDate, 50), Calendar.DAY_OF_MONTH);

			AddTaskSetShop addTaskSetShop = new AddTaskSetShop();
			addTaskSetShop.setMerchantNo(merchant.getMerchantNo());
			addTaskSetShop.setStartDate(startDate);
			addTaskSetShop.setEndDate(endDate);
			addTaskSetShop.setDimension(DimensionStType.MERCHANT.toString());
			addTaskSetShop.setNumMonth(0L);
			addTaskSetShop.setTaskType(ShopTaskType.XIAO_SHOU.toString());
			addTaskSetShop.setTaskName(EnumUtils.getValue(ShopTaskType.class, ShopTaskType.XIAO_SHOU.toString()));
			addTaskSetShop.setTaskUnit(UnitType.YUAN.toString());

			FindWorkTaskList findWorkTaskList = new FindWorkTaskList();
			findWorkTaskList.setTaskType(ShopTaskType.XIAO_SHOU.toString());
			FindWorkTaskListReturn findWorkTaskListReturn = workTaskListService.findWorkTaskListByTaskType(findWorkTaskList);
			if(findWorkTaskListReturn != null){
				addTaskSetShop.setCodeList(findWorkTaskListReturn.getCode());
			}
			taskSetShopService.addTaskSetShopMain(addTaskSetShop);

			AddTaskSetShop addTaskSetShop2 = new AddTaskSetShop();
			addTaskSetShop2.setMerchantNo(merchant.getMerchantNo());
			addTaskSetShop2.setStartDate(startDate);
			addTaskSetShop2.setEndDate(endDate);
			addTaskSetShop2.setDimension(DimensionStType.MERCHANT.toString());
			addTaskSetShop2.setNumMonth(0L);
			addTaskSetShop2.setTaskType(ShopTaskType.XIN_ZENG.toString());
			addTaskSetShop2.setTaskName(EnumUtils.getValue(ShopTaskType.class, ShopTaskType.XIN_ZENG.toString()));
			addTaskSetShop2.setTaskUnit(UnitType.GE.toString());

			FindWorkTaskList findWorkTaskList2 = new FindWorkTaskList();
			findWorkTaskList2.setTaskType(ShopTaskType.XIN_ZENG.toString());
			FindWorkTaskListReturn findWorkTaskListReturn2 = workTaskListService.findWorkTaskListByTaskType(findWorkTaskList2);
			if(findWorkTaskListReturn2 != null){
				addTaskSetShop2.setCodeList(findWorkTaskListReturn2.getCode());
			}
			taskSetShopService.addTaskSetShopMain(addTaskSetShop2);
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
		}
	}


	/**
	 * 
	 *
	 * 方法说明：沟通任务
	 *
	 * @param merchant
	 * @param comTaskTypeAr
	 *
	 * @author 彭阳 CreateDate: 2017年9月7日
	 *
	 */
	private void initComTaskList(Merchant merchant, ComTaskType[] comTaskTypeAr) {
		try {
			for (ComTaskType comTaskType : comTaskTypeAr) {
				if(comTaskType.equals(ComTaskType.SYSTEM))
					continue;
				AddComTaskListDto comTaskList = new AddComTaskListDto();
				comTaskList.setCode(GUID.getPreUUID());
				comTaskList.setMerchantNo(merchant.getMerchantNo());
				comTaskList.setNameList(comTaskType.getName());
				comTaskList.setDesList(comTaskType.getName());
				comTaskList.setStatus("Y");
				comTaskList.setComTaskType(comTaskType.toString());
				comTaskListService.addComTaskList(comTaskList);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}

	/**
	 * 
	 *
	 * 方法说明：客户沟通任务选择表（基础）
	 *
	 * @param merchant
	 * @param comTaskTypeAr
	 *
	 * @author 彭阳 CreateDate: 2017年9月7日
	 *
	 */
	private void initComTaskChoose(Merchant merchant,
			ComTaskType[] comTaskTypeAr) {
		try {
			for (ComTaskType comTaskType : comTaskTypeAr) {
				if(comTaskType.equals(ComTaskType.SYSTEM))
					continue;
				AddComTaskChooseDto comTaskChoose = new AddComTaskChooseDto();
				comTaskChoose.setMerchantNo(merchant.getMerchantNo());
				comTaskChoose.setShopNo("");
				comTaskChoose.setShopName("");
				comTaskChoose.setMemberNoGm("");
				comTaskChoose.setMemberNameGm("");
				FindComTaskList findComTaskList = new FindComTaskList();
				findComTaskList.setComTaskType(comTaskType);
				findComTaskList.setMerchantNo(merchant.getMerchantNo());
				FindComTaskListReturn findComTaskListReturn = comTaskListService.findComTaskList(findComTaskList );
				comTaskChoose.setCodeList(findComTaskListReturn.getCode());
				comTaskChoose.setNameList(findComTaskListReturn.getNameList());

				comTaskChoose.setComTaskType(comTaskType);
				comTaskChoose.setStatus("Y");

				if(comTaskType.equals(ComTaskType.GROUP)){
					comTaskChoose.setFreValue("1");
					comTaskChoose.setSeq(10);
				}else if(comTaskType.equals(ComTaskType.FIRST_INTR)){
					comTaskChoose.setFreValue("1");
					comTaskChoose.setSeq(20);
				}else if(comTaskType.equals(ComTaskType.INVITE)){
					comTaskChoose.setFreValue("1");
					comTaskChoose.setSeq(30);
				}else if(comTaskType.equals(ComTaskType.REMIND)){
					comTaskChoose.setFreValue("1");
					comTaskChoose.setSeq(40);
				}else if(comTaskType.equals(ComTaskType.CLIENT_EXP)){
					comTaskChoose.setFreValue("1");
					comTaskChoose.setSeq(50);
				}else if(comTaskType.equals(ComTaskType.GUID_PM)){
					comTaskChoose.setFreValue("1");
					comTaskChoose.setSeq(60);
				}else if(comTaskType.equals(ComTaskType.COM_TASK)){
					comTaskChoose.setFreValue("1");
					comTaskChoose.setSeq(70);
				}
				comTaskChoose.setRemark("");
				comTaskChoose.setRemark2("");
				comTaskChoose.setRemark3("");
				comTaskChoose.setRemark4("");
				comTaskChooseService.addComTaskChoose(comTaskChoose);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IMerchantService#delMerchant(com.lj.business
	 * .member.dto.DelMerchant)
	 */
	@Override
	public DelMerchantReturn delMerchant(DelMerchant delMerchant)throws TsfaServiceException {logger.debug("delMerchant(DelMerchant delMerchant={}) - start",delMerchant);
	AssertUtils.notNull(delMerchant);
	AssertUtils.notNull(delMerchant.getCode(), "ID不能为空！");
	try {
		merchantDao.deleteByPrimaryKey(delMerchant.getCode());
		DelMerchantReturn delMerchantReturn = new DelMerchantReturn();
		logger.debug("delMerchant(DelMerchant) - end - return value={}", delMerchantReturn); //$NON-NLS-1$
		return delMerchantReturn;
	} catch (TsfaServiceException e) {
		logger.error(e.getMessage(), e);
		throw e;
	} catch (Exception e) {
		logger.error("删除商户表信息错误！", e);
		throw new TsfaServiceException(ErrorCode.MERCHANT_DEL_ERROR,
				"删除商户表信息错误！", e);

	}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IMerchantService#updateMerchant(com.lj
	 * .business.member.dto.UpdateMerchant)
	 */
	@Override
	public UpdateMerchantReturn updateMerchant(UpdateMerchant updateMerchant)throws TsfaServiceException {
		logger.debug("updateMerchant(UpdateMerchant updateMerchant={}) - start", updateMerchant); //$NON-NLS-1$
		AssertUtils.notNull(updateMerchant);
		AssertUtils.notNullAndEmpty(updateMerchant.getCode(), "ID不能为空");
		try {
			Merchant merchant = new Merchant();
			// update数据录入
			merchant.setCode(updateMerchant.getCode());
			merchant.setMerchantNo(updateMerchant.getMerchantNo());
			merchant.setMerchantName(updateMerchant.getMerchantName());
			merchant.setStatus(updateMerchant.getStatus());
			merchant.setAddress(updateMerchant.getAddress());
			merchant.setEmail(updateMerchant.getEmail());
			merchant.setBusinessType(updateMerchant.getBusinessType());
			merchant.setLogoAddr(updateMerchant.getLogoAddr());
			merchant.setWebsiteUrl(updateMerchant.getWebsiteUrl());
			merchant.setTelephone(updateMerchant.getTelephone());
			merchant.setUpdateId(updateMerchant.getUpdateId());
			merchant.setRemark(updateMerchant.getRemark());
			merchant.setRemark2(updateMerchant.getRemark2());
			merchant.setRemark3(updateMerchant.getRemark3());
			merchant.setRemark4(updateMerchant.getRemark4());
			AssertUtils.notUpdateMoreThanOne(merchantDao.updateByPrimaryKeySelective(merchant));
			UpdateMerchantReturn updateMerchantReturn = new UpdateMerchantReturn();
			logger.debug("updateMerchant(UpdateMerchant) - end - return value={}", updateMerchantReturn); //$NON-NLS-1$
			return updateMerchantReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("商户表信息更新错误！", e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_UPDATE_ERROR,
					"商户表信息更新错误！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IMerchantService#findMerchant(com.lj.business
	 * .member.dto.FindMerchant)
	 */
	@Override
	public FindMerchantReturn findMerchant(FindMerchant findMerchant)throws TsfaServiceException {
		logger.debug("findMerchant(FindMerchant findMerchant={}) - start", findMerchant); //$NON-NLS-1$
		AssertUtils.notNull(findMerchant);
		AssertUtils.notAllNull(findMerchant.getCode(), "ID不能为空");
		try {
			Merchant merchant = merchantDao.selectByPrimaryKey(findMerchant.getCode());
			if (merchant == null) {
				throw new TsfaServiceException(ErrorCode.MERCHANT_NOT_EXIST_ERROR, "商户表信息不存在");
			}
			FindMerchantReturn findMerchantReturn = new FindMerchantReturn();
			// find数据录入
			findMerchantReturn.setCode(merchant.getCode());
			findMerchantReturn.setMerchantNo(merchant.getMerchantNo());
			findMerchantReturn.setMerchantName(merchant.getMerchantName());
			findMerchantReturn.setStatus(merchant.getStatus());
			findMerchantReturn.setAddress(merchant.getAddress());
			findMerchantReturn.setEmail(merchant.getEmail());
			findMerchantReturn.setBusinessType(merchant.getBusinessType());
			findMerchantReturn.setLogoAddr(merchant.getLogoAddr());
			findMerchantReturn.setWebsiteUrl(merchant.getWebsiteUrl());
			findMerchantReturn.setTelephone(merchant.getTelephone());
			findMerchantReturn.setCreateId(merchant.getCreateId());
			findMerchantReturn.setCreateDate(merchant.getCreateDate());
			findMerchantReturn.setUpdateId(merchant.getUpdateId());
			findMerchantReturn.setUpdateDate(merchant.getUpdateDate());
			findMerchantReturn.setRemark(merchant.getRemark());
			findMerchantReturn.setRemark2(merchant.getRemark2());
			findMerchantReturn.setRemark3(merchant.getRemark3());
			findMerchantReturn.setRemark4(merchant.getRemark4());
			logger.debug("findMerchant(FindMerchant) - end - return value={}", findMerchantReturn); //$NON-NLS-1$
			return findMerchantReturn;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找商户表信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_FIND_ERROR,
					"查找商户表信息错误！", e);
		}

	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IMerchantService#findMerchantByCodeOrMerchantNo(com.lj.business.member.dto.FindMerchantDto)
	 */
	/**
	 * 查找商户信息(个人中心)
	 */
	@Override
	public FindMerchantReturnDto selectMerchant(FindMerchantDto findMerchantDto) throws TsfaServiceException {
		logger.debug("findMerchant(FindMerchant findMerchant={}) - start", findMerchantDto); //$NON-NLS-1$
		AssertUtils.notNull(findMerchantDto);
		AssertUtils.notNull(findMerchantDto.getMerchantNo(), "MerchantNo不能为空");
		try {
			Merchant merchant = merchantDao.selectMerchant(findMerchantDto);
			if (merchant == null) {
				throw new TsfaServiceException(ErrorCode.MERCHANT_NOT_EXIST_ERROR, "商户表信息不存在");
			} 
			FindMerchantReturnDto findMerchantReturnDto = new FindMerchantReturnDto();
			// find数据录入
			findMerchantReturnDto.setMerchantNo(merchant.getMerchantNo());
			findMerchantReturnDto.setMerchantName(merchant.getMerchantName());
			findMerchantReturnDto.setLogoAddr(merchant.getLogoAddr());
			findMerchantReturnDto.setWebsiteUrl(merchant.getWebsiteUrl());
			findMerchantReturnDto.setTelephone(merchant.getTelephone());
			logger.debug("findMerchant(FindMerchant) - end - return value={}", findMerchantReturnDto); //$NON-NLS-1$
			return findMerchantReturnDto;
		} catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找商户表信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_FIND_ERROR,
					"查找商户表信息错误！", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.business.member.service.IMerchantService#findMerchantPage(com.
	 * lj.business.member.dto.FindMerchantPage)
	 */
	@Override
	public Page<FindMerchantPageReturn> findMerchantPage(
			FindMerchantPage findMerchantPage) throws TsfaServiceException {
		logger.debug(
				"findMerchantPage(FindMerchantPage findMerchantPage={}) - start", findMerchantPage); //$NON-NLS-1$

		AssertUtils.notNull(findMerchantPage);
		List<FindMerchantPageReturn> returnList = null;
		int count = 0;
		try {
			returnList = merchantDao.findMerchantPage(findMerchantPage);
			count = merchantDao.findMerchantPageCount(findMerchantPage);
		} catch (Exception e) {
			logger.error("商户表信息分页查询错误", e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_FIND_PAGE_ERROR,
					"商户表信息分页查询错误.！", e);
		}
		Page<FindMerchantPageReturn> returnPage = new Page<FindMerchantPageReturn>(
				returnList, count, findMerchantPage);

		logger.debug(
				"findMerchantPage(FindMerchantPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return returnPage;
	}

	@Override
	public List<FindMerchantPageReturn> findMerchants(
			FindMerchantPage findMerchantPage) throws TsfaServiceException {
		logger.debug("findMerchants(FindMerchantPage findMerchantPage={}) - start", findMerchantPage); //$NON-NLS-1$

		AssertUtils.notNull(findMerchantPage);
		List<FindMerchantPageReturn> returnList = null;
		try {
			returnList = merchantDao.findMerchants(findMerchantPage);
		} catch (Exception e) {
			logger.error("商户表信息查询错误", e);
			throw new TsfaServiceException(ErrorCode.MERCHANT_FIND_ERROR,"商户表信息查询错误.！", e);
		}
		logger.debug("findMerchants(FindMerchantPage) - end - return value={}", returnList); //$NON-NLS-1$
		return returnList;
	}

	/* (non-Javadoc)
	 * @see com.lj.business.member.service.IMerchantService#addMerchant_ec(com.lj.business.member.dto.AddMerchant)
	 */
	@Override
	public void addMerchant_ec(AddMerchant addMerchant)
			throws TsfaServiceException {

		//1.新增商户
		addMerchant(addMerchant);
		//2.新增分店
		Date now=new Date();
		Shop addShop = new Shop();
		addShop.setCode(GUID.generateCode());
		addShop.setShopNo(GUID.getPreUUID());
		addShop.setAddrInfo(addMerchant.getAddress());
		addShop.setLogoAddr(addMerchant.getLogoAddr());
//		addShop.setLongitude("Longitude");经度
//		addShop.setLatitude("Latitude");纬度
		addShop.setBizScope("珠宝");
//		addShop.setQcord();
//		addShop.setRemark4("Remark4");
//		addShop.setRemark3("Remark3");
//		addShop.setRemark("Remark");
//		addShop.setRemark2("Remark2");
		addShop.setShopType("电商");
		addShop.setShopName(addMerchant.getMerchantName());
		addShop.setMemberNoMerchant(addMerchant.getMerchantNo());
		addShop.setMemberNameMerchant(addMerchant.getMerchantName());
		addShop.setStatus(ShopStatus.OPENED.toString());
		addShop.setTelephone(addMerchant.getTelephone());
		addShop.setMobile(addMerchant.getTelephone());
		addShop.setEmail(addMerchant.getEmail());
		addShop.setAddress(addMerchant.getAddress());
//		addShop.setAreaCode("1");
//		addShop.setProvinceCode("2");
//		addShop.setCityCode("3");
		addShop.setAddrInfo(addMerchant.getAddress());
		addShop.setCreateId(addMerchant.getCreateId());
		addShop.setCreateDate(now);
		shopDao.insertSelective(addShop);
		//3.新增店长
		String pwd="123456";
		if (StringUtils.isNotEmpty(addMerchant.getTelephone())
				&& addMerchant.getTelephone().length() > 5) {
			pwd = addMerchant.getTelephone().substring(addMerchant.getTelephone().length()-6);
		}
		ManagerMember addManagerMember = new ManagerMember();
		//add数据录入
		addManagerMember.setCode(GUID.generateCode());
		addManagerMember.setMemberType(MemberType.SHOP.toString());
		addManagerMember.setMemberNo(GUID.getPreUUID());
		addManagerMember.setMemberName("店长");
		addManagerMember.setMemberNoShop(addShop.getShopNo());
		addManagerMember.setMemberNameShop(addShop.getShopName());
		
		addManagerMember.setMemberNoMerchant(addMerchant.getMerchantNo());
		addManagerMember.setMemberNameMerchant(addMerchant.getMerchantName());
		addManagerMember.setStatus(MemberStatus.NORMAL.toString());
//		addManagerMember.setJobNum("J001");
		addManagerMember.setTelephone(addMerchant.getTelephone());
		addManagerMember.setMobile(addMerchant.getTelephone());
		addManagerMember.setEmail(addMerchant.getEmail());
		addManagerMember.setNickName(addMerchant.getMerchantName());
		addManagerMember.setAddress(addMerchant.getAddress());
//		addManagerMember.setAge(26);
		addManagerMember.setPwd(MD5.encryptByMD5(MD5.encryptByMD5(pwd)));
//		addManagerMember.setEncryptionCode("3");
		addManagerMember.setHeadAddress(addMerchant.getLogoAddr());
//		addManagerMember.setOpenIdGzhWx("OpenIdGzhWx");
//		addManagerMember.setOpenIdXcxWx("OpenIdXcxWx");
//		addManagerMember.setNickNameWx("NickNameWx");
//		addManagerMember.setAreaCode("d");
//		addManagerMember.setSex("男");
//		addManagerMember.setCityWx("深圳");
//		addManagerMember.setCountryWx("中国");
//		addManagerMember.setProvinceWx("广东");
		addManagerMember.setSubsribeTime(now);
		addManagerMember.setCreateId(addMerchant.getCreateId());
		addManagerMember.setCreateDate(now);
		addManagerMember.setUpdateId(addMerchant.getCreateId());
		addManagerMember.setUpdateDate(now);
		
		managerMemberDao.insertSelective(addManagerMember);
	
		
	}
	
	

}
