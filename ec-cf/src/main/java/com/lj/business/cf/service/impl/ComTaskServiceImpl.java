package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.lj.business.cf.dao.IComTaskDao;
import com.lj.business.cf.domain.ComTask;
import com.lj.business.cf.dto.TodayBeforeClientExpTaskDto;
import com.lj.business.cf.dto.TodayBeforeClientExpTaskReturn;
import com.lj.business.cf.dto.UpdateWorkTaskFinishNum;
import com.lj.business.cf.dto.comTask.AddComTask;
import com.lj.business.cf.dto.comTask.DelComTask;
import com.lj.business.cf.dto.comTask.FindComTask;
import com.lj.business.cf.dto.comTask.FindComTaskIndexPage;
import com.lj.business.cf.dto.comTask.FindComTaskIndexPageReturn;
import com.lj.business.cf.dto.comTask.FindComTaskPage;
import com.lj.business.cf.dto.comTask.FindComTaskPageReturn;
import com.lj.business.cf.dto.comTask.FindComTaskReturn;
import com.lj.business.cf.dto.comTask.GenerateNextDate;
import com.lj.business.cf.dto.comTask.UpdateComTask;
import com.lj.business.cf.dto.comTask.UpdateComTaskFi;
import com.lj.business.cf.dto.comTask.UpdateComTaskGroup;
import com.lj.business.cf.dto.comTaskList.ComTaskListReturnDto;
import com.lj.business.cf.emus.ComTaskFinish;
import com.lj.business.cf.emus.ComTaskType;
import com.lj.business.cf.emus.TaskType;
import com.lj.business.cf.service.IComTaskListService;
import com.lj.business.cf.service.IComTaskService;
import com.lj.business.cf.service.IWorkTaskService;
import com.lj.business.common.SystemParamConstant;
import com.lj.business.member.dto.FindGuidMember;
import com.lj.business.member.dto.FindGuidMemberReturn;
import com.lj.business.member.dto.FindPersonMember;
import com.lj.business.member.dto.FindPersonMemberReturn;
import com.lj.business.member.dto.FindPmWxInfo;
import com.lj.business.member.dto.FindPmWxInfoReturn;
import com.lj.business.member.service.IGuidMemberService;
import com.lj.business.member.service.IPersonMemberService;
import com.lj.cc.clientintf.LocalCacheSystemParamsFromCC;


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
public class ComTaskServiceImpl implements IComTaskService { 


	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ComTaskServiceImpl.class);

	/** The com task dao. */
	@Resource
	private IComTaskDao comTaskDao;

	/** The guid member service. */
	@Resource
	private IGuidMemberService guidMemberService;

	/** The com task list service. */
	@Resource
	private IComTaskListService comTaskListService;

	/** The person member service. */
	@Resource
	private IPersonMemberService personMemberService;

	/** The work task service. */
	@Resource
	private IWorkTaskService workTaskService;

	@Resource
	private LocalCacheSystemParamsFromCC localCacheSystemParams;



	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskService#generateNextDate(com.lj.business.cf.dto.comTask.GenerateNextDate)
	 */
	@Override
	public Date generateNextDate(GenerateNextDate generateNextDate)
			throws TsfaServiceException {
		logger.debug("generateNextDate(GenerateNextDate generateNextDate={}) - start", generateNextDate); //$NON-NLS-1$

		AssertUtils.notNull(generateNextDate);
		Date nextDate = generateNextDate.getNextDate();
		AssertUtils.notNull(nextDate,"下次任务时间不能为空！");
		try {
			int INVITE_DAY =  Integer.valueOf(localCacheSystemParams.getSystemParam(SystemParamConstant.CF_PARAM, SystemParamConstant.INVITE_DAY)); 
			Calendar c = Calendar.getInstance();
			c.setTime(nextDate);
			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
			if(dayOfWeek < INVITE_DAY){
				c.set(Calendar.DAY_OF_WEEK, INVITE_DAY);
			}
			//任务时间是否计算到下周
			if(generateNextDate.getNextWeek()){
				c.add(Calendar.DAY_OF_MONTH, 7);
			}
			Date returnDate = c.getTime();
			logger.debug("generateNextDate(GenerateNextDate) - end - return value={}", returnDate); //$NON-NLS-1$
			return returnDate;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("业务任务时间计算错误",e);
			throw new TsfaServiceException(ErrorCode.COM_TASK_NEXT_DATE_ERROR,"业务任务时间计算错误",e);
		}


	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskService#addComTask(com.lj.business.cf.dto.comTask.AddComTask)
	 */

	@Override
	public void addComTask(
			AddComTask addComTask) throws TsfaServiceException {
		logger.debug("addComTask(AddComTask addComTask={}) - start", addComTask); 

		AssertUtils.notNull(addComTask);
		//AssertUtils.notNullAndEmpty(addComTask.getMerchantNo(),"商户编号不能为空！");
		AssertUtils.notNullAndEmpty(addComTask.getMemberNoGm(),"导购编号不能为空！");
		AssertUtils.notNullAndEmpty(addComTask.getMerchantNo(),"项目CODE不能为空！");
		AssertUtils.notNull(addComTask.getWorkDate(),"工作日期不能为空！");
		//AssertUtils.notNullAndEmpty(addComTask.getCfNo(),"跟踪总表或维护总表code不能为空！");
		//AssertUtils.notNullAndEmpty(addComTask.getNoType(),"编号类型不能为空！");
		AssertUtils.notNullAndEmpty(addComTask.getCodeList(),"项目CODE不能为空！");
		AssertUtils.notNullAndEmpty(addComTask.getMemberNo(),"客户编号不能为空！");
		AssertUtils.notNullAndEmpty(addComTask.getComTaskType(),"沟通任务类型不能为空！");
		try {
			if(addComTask.getFinish() == null)
				addComTask.setFinish(ComTaskFinish.NORMAL);//默认正常
			//导购数据数据补全
			if(StringUtils.isEmpty(addComTask.getMerchantNo())  ||StringUtils.isEmpty(addComTask.getShopNo()) || StringUtils.isEmpty(addComTask.getShopName())
					|| StringUtils.isEmpty(addComTask.getMemberNameGm()) ){
				FindGuidMember findGuidMember = new FindGuidMember();
				findGuidMember.setMemberNo(addComTask.getMemberNoGm());
				FindGuidMemberReturn findGuidMemberReturn = guidMemberService.findGuidMember(findGuidMember );
				addComTask.setMerchantNo(findGuidMemberReturn.getMerchantNo());
				addComTask.setShopNo(findGuidMemberReturn.getShopNo());
				addComTask.setShopName(findGuidMemberReturn.getShopName());
				addComTask.setMemberNameGm(findGuidMemberReturn.getMemberName());
			}
			//项目名称补全
			if(StringUtils.isEmpty(addComTask.getNameList()) ){
				ComTaskListReturnDto comTaskListReturnDto = comTaskListService.selectByCode(addComTask.getCodeList());
				addComTask.setNameList(comTaskListReturnDto.getNameList());
			}
			if(StringUtils.isEmpty(addComTask.getMemberName())){
				FindPersonMember findPersonMember = new FindPersonMember();
				findPersonMember.setMemberNo(addComTask.getMemberNo());
				FindPersonMemberReturn findPersonMemberReturn = personMemberService.findPersonMember(findPersonMember );
				addComTask.setMemberName(findPersonMemberReturn.getMemberName());
			}

			ComTask comTask = new ComTask();
			//add数据录入
			comTask.setCode(GUID.generateCode());
			comTask.setMerchantNo(addComTask.getMerchantNo());
			comTask.setShopNo(addComTask.getShopNo());
			comTask.setShopName(addComTask.getShopName());
			comTask.setMemberNoGm(addComTask.getMemberNoGm());
			comTask.setMemberNameGm(addComTask.getMemberNameGm());
			comTask.setCodeList(addComTask.getCodeList());
			comTask.setNameList(addComTask.getNameList());
			comTask.setMemberNo(addComTask.getMemberNo());
			comTask.setMemberName(addComTask.getMemberName());
			comTask.setWorkDate(addComTask.getWorkDate());
			comTask.setRemarkCom(addComTask.getRemarkCom());
			comTask.setFinish(StringUtils.toStringNull(addComTask.getFinish()));
			comTask.setReason(addComTask.getReason());
			comTask.setCfNo(addComTask.getCfNo());
			comTask.setNoType(addComTask.getNoType());
			comTask.setComTaskType(StringUtils.toStringNull(addComTask.getComTaskType()) );
			comTask.setLastResultDate(addComTask.getLastResultDate());
			comTask.setCreateId(addComTask.getCreateId());
			comTask.setRemark4(addComTask.getRemark4());
			comTask.setRemark3(addComTask.getRemark3());
			comTask.setRemark2(addComTask.getRemark2());
			comTask.setRemark(addComTask.getRemark());
			comTaskDao.insert(comTask);

			// 增加沟通的数量
			addRequiredNum(addComTask, 0L,1L);
			logger.debug("addComTask(AddComTask) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户沟通任务表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.COM_TASK_ADD_ERROR,"新增客户沟通任务表信息错误！",e);
		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskService#addComTaskWithFinish(com.lj.business.cf.dto.comTask.AddComTask)
	 */
	public void addComTaskWithFinish(AddComTask addComTask,String flag) throws TsfaServiceException {
		logger.debug("addComTaskWithFinish(AddComTask addComTask={}, String flag={}) - start", addComTask, flag); //$NON-NLS-1$

		AssertUtils.notNull(addComTask);
		//AssertUtils.notNullAndEmpty(addComTask.getMerchantNo(),"商户编号不能为空！");
		AssertUtils.notNullAndEmpty(addComTask.getMemberNoGm(),"导购编号不能为空！");
		AssertUtils.notNullAndEmpty(addComTask.getMerchantNo(),"项目CODE不能为空！");
		Date workDate = addComTask.getWorkDate();
		AssertUtils.notNull(workDate,"工作日期不能为空！");
		AssertUtils.notNullAndEmpty(addComTask.getCfNo(),"跟踪总表或维护总表code不能为空！");
		AssertUtils.notNullAndEmpty(addComTask.getNoType(),"编号类型不能为空！");
		AssertUtils.notNullAndEmpty(addComTask.getCodeList(),"项目CODE不能为空！");
		AssertUtils.notNullAndEmpty(addComTask.getMemberNo(),"客户编号不能为空！");
		AssertUtils.notNullAndEmpty(addComTask.getComTaskType(),"沟通任务类型不能为空！");
	/*	if(addComTask.getDis()){
			AssertUtils.notNullAndEmpty(addComTask.getOrgComTaskCode(),"累计任务，原客户沟通任务Code不能为空！");
		}*/
		try {
			UpdateComTask updateComTask = new UpdateComTask();
			updateComTask.setMemberNo(addComTask.getMemberNo());
			updateComTask.setMemberNoGm(addComTask.getMemberNoGm());
			updateComTask.setFinish(ComTaskFinish.FINISH.toString());
			Date workDateStart = org.apache.commons.lang.time.DateUtils.truncate(workDate, Calendar.DAY_OF_MONTH);
			Date workDateEnd =  DateUtils.addDays(workDateStart, 1);
			updateComTask.setWorkDateStart(workDateStart);
			updateComTask.setWorkDateEnd(workDateEnd);
			/**
			 * 1、关闭任务时间当天的其他沟通任务,除了 分组任务、初次介绍任务
			 * 2、如果不是累计任务关闭当天的其他沟通任务,除了 分组任务、初次介绍任务
			 * 3、关闭所有其他任务，除了 分组任务、初次介绍任务 -- 适用于移动到非意向客户
			 */
			if("0".equals(flag)){
				//关闭任务时间当天的其他业务任务,除了 分组任务、初次介绍任务、提醒任务
				//分组任务、初次介绍任务、提醒任务 不关闭其他任务
				if(!ComTaskType.GROUP.equals(addComTask.getComTaskType()) && !ComTaskType.FIRST_INTR.equals(addComTask.getComTaskType()) 
						&& !ComTaskType.REMIND.equals(addComTask.getComTaskType())){
					updateComTaskByMemberNo(updateComTask);
				}
				//如果FINISH原业务任务，关闭当天的其他业务任务,除了 分组任务、初次介绍任务、提醒任务
				if(addComTask.getFinishOrgComTask()){
					logger.debug("是否FINISH原业务任务");
					if(!StringUtils.isEmpty(addComTask.getOrgComTaskCode())){
						ComTask record = new ComTask();
						record.setCode(addComTask.getOrgComTaskCode());
						record.setFinish(ComTaskFinish.FINISH.toString());
						comTaskDao.updateByPrimaryKeySelective(record );
					}else{
						logger.debug("手工新增跟进记录页面，关闭当天的其他业务任务");
						Date workDateStart_temp = org.apache.commons.lang.time.DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
						Date workDateEnd_temp =  DateUtils.addDays(workDateStart_temp, 1);
						updateComTask.setWorkDateStart(workDateStart_temp);
						updateComTask.setWorkDateEnd(workDateEnd_temp);
						updateComTaskByMemberNo(updateComTask);
					}
				}
			}else if("1".equals(flag)){//关闭所有的业务任务
				updateAllComTaskByMemberNo(updateComTask);
			}else if("2".equals(flag)){//关闭所有的业务任务
				updateAllComTaskByMemberNo(updateComTask);
			}

			// 查找状态为完成的记录数
			FindComTaskPage findComTaskPage = new FindComTaskPage();
			findComTaskPage.setMemberNoGm(addComTask.getMemberNoGm());
			findComTaskPage.setMerchantNo(addComTask.getMerchantNo());
			int finishCount = comTaskDao.findFinishCount(findComTaskPage);

			// 增加沟通的数量 //XXX LEOPENG 如果任务在当天，任务数+1，完成数重新算
			addRequiredNum(addComTask, (long) finishCount,1L);

			if(addComTask.getFinish() == null)
				addComTask.setFinish(ComTaskFinish.NORMAL);//默认正常
			//导购数据数据补全
			if(StringUtils.isEmpty(addComTask.getMerchantNo())  ||StringUtils.isEmpty(addComTask.getShopNo()) || StringUtils.isEmpty(addComTask.getShopName())
					|| StringUtils.isEmpty(addComTask.getMemberNameGm()) ){
				FindGuidMember findGuidMember = new FindGuidMember();
				findGuidMember.setMemberNo(addComTask.getMemberNoGm());
				FindGuidMemberReturn findGuidMemberReturn = guidMemberService.findGuidMember(findGuidMember );
				addComTask.setMerchantNo(findGuidMemberReturn.getMerchantNo());
				addComTask.setShopNo(findGuidMemberReturn.getShopNo());
				addComTask.setShopName(findGuidMemberReturn.getShopName());
				addComTask.setMemberNameGm(findGuidMemberReturn.getMemberName());
			}
			//项目名称补全
			if(StringUtils.isEmpty(addComTask.getNameList()) ){
				ComTaskListReturnDto comTaskListReturnDto = comTaskListService.selectByCode(addComTask.getCodeList());
				addComTask.setNameList(comTaskListReturnDto.getNameList());
			}

			ComTask comTask = new ComTask();
			//add数据录入
			comTask.setCode(GUID.generateCode());
			comTask.setMerchantNo(addComTask.getMerchantNo());
			comTask.setShopNo(addComTask.getShopNo());
			comTask.setShopName(addComTask.getShopName());
			comTask.setMemberNoGm(addComTask.getMemberNoGm());
			comTask.setMemberNameGm(addComTask.getMemberNameGm());
			comTask.setCodeList(addComTask.getCodeList());
			comTask.setNameList(addComTask.getNameList());
			comTask.setMemberNo(addComTask.getMemberNo());
			comTask.setMemberName(addComTask.getMemberName());
			comTask.setWorkDate(workDate);
			comTask.setRemarkCom(addComTask.getRemarkCom());
			comTask.setFinish(StringUtils.toStringNull(addComTask.getFinish()));
			comTask.setReason(addComTask.getReason());
			comTask.setCfNo(addComTask.getCfNo());
			comTask.setNoType(addComTask.getNoType());
			comTask.setLastResultDate(addComTask.getLastResultDate());
			comTask.setCreateId(addComTask.getCreateId());
			comTask.setRemark4(addComTask.getRemark4());
			comTask.setRemark3(addComTask.getRemark3());
			comTask.setRemark2(addComTask.getRemark2());
			comTask.setRemark(addComTask.getRemark());
			comTask.setComTaskType(StringUtils.toStringNull(addComTask.getComTaskType()) );
			comTaskDao.insert(comTask);

			logger.debug("addComTask(AddComTask) - end - return");
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增客户沟通任务表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.COM_TASK_ADD_ERROR,"新增客户沟通任务表信息错误！",e);
		}

		logger.debug("addComTaskWithFinish(AddComTask, String) - end"); //$NON-NLS-1$
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskService#delComTask(com.lj.business.cf.dto.comTask.DelComTask)
	 */

	@Override
	public void delComTask(
			DelComTask delComTask) throws TsfaServiceException {
		logger.debug("delComTask(DelComTask delComTask={}) - start", delComTask); 

		AssertUtils.notNull(delComTask);
		AssertUtils.notNull(delComTask.getCode(),"Code不能为空！");
		try {
			comTaskDao.deleteByPrimaryKey(delComTask.getCode());
			logger.debug("delComTask(DelComTask) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除客户沟通任务表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.COM_TASK_DEL_ERROR,"删除客户沟通任务表信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskService#updateComTask(com.lj.business.cf.dto.comTask.UpdateComTask)
	 */

	@Override
	public void updateComTask(
			UpdateComTask updateComTask)
					throws TsfaServiceException {
		logger.debug("updateComTask(UpdateComTask updateComTask={}) - start", updateComTask); //$NON-NLS-1$

		AssertUtils.notNull(updateComTask);
		AssertUtils.notNullAndEmpty(updateComTask.getCode(),"Code不能为空");
		try {
			ComTask comTask = new ComTask();
			//update数据录入
			comTask.setCode(updateComTask.getCode());
			comTask.setMerchantNo(updateComTask.getMerchantNo());
			comTask.setShopNo(updateComTask.getShopNo());
			comTask.setShopName(updateComTask.getShopName());
			comTask.setMemberNoGm(updateComTask.getMemberNoGm());
			comTask.setMemberNameGm(updateComTask.getMemberNameGm());
			comTask.setCodeList(updateComTask.getCodeList());
			comTask.setNameList(updateComTask.getNameList());
			comTask.setWorkDate(updateComTask.getWorkDate());
			comTask.setRemarkCom(updateComTask.getRemarkCom());
			comTask.setFinish(updateComTask.getFinish());
			comTask.setReason(updateComTask.getReason());
			comTask.setCfNo(updateComTask.getCfNo());
			comTask.setNoType(updateComTask.getNoType());
			comTask.setFinishDate(updateComTask.getFinishDate());
			comTask.setLastResultDate(updateComTask.getLastResultDate());
			comTask.setRemark4(updateComTask.getRemark4());
			comTask.setRemark3(updateComTask.getRemark3());
			comTask.setRemark2(updateComTask.getRemark2());
			comTask.setRemark(updateComTask.getRemark());
			AssertUtils.notUpdateMoreThanOne(comTaskDao.updateByPrimaryKeySelective(comTask));
			logger.debug("updateComTask(UpdateComTask) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户沟通任务表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.COM_TASK_UPDATE_ERROR,"客户沟通任务表信息更新错误！",e);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskService#updateComTaskFi(com.lj.business.cf.dto.comTask.UpdateComTaskFi)
	 */
	@Override
	public void updateComTaskFi(UpdateComTaskFi updateComTaskFi)
			throws TsfaServiceException {
		logger.debug("updateFirstIntroduce(UpdateComTaskFi updateFirstIntroduce={}) - start", updateComTaskFi); //$NON-NLS-1$

		AssertUtils.notNull(updateComTaskFi);
		AssertUtils.notNullAndEmpty(updateComTaskFi.getMemberNo(),"客户会员号不能为空");
		AssertUtils.notNullAndEmpty(updateComTaskFi.getMemberNoGm(),"导购编号不能为空");
		AssertUtils.notNullAndEmpty(updateComTaskFi.getFinish(),"任务完成情况不能为空");
		try {
			ComTask comTask = new ComTask();
			comTask.setMemberNo(updateComTaskFi.getMemberNo());
			comTask.setMemberNoGm(updateComTaskFi.getMemberNoGm());
			comTask.setFinish(updateComTaskFi.getFinish().toString());
			comTask.setFinishDate(updateComTaskFi.getFinishDate());
			comTaskDao.updateComTaskFi(comTask);
			logger.debug("updateComTask(UpdateComTask) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户沟通任务表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.COM_TASK_UPDATE_ERROR,"客户沟通任务表信息更新错误！",e);
		}


		logger.debug("updateFirstIntroduce(UpdateComTaskFi) - end"); //$NON-NLS-1$
	}



	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskService#updateComTaskGroup(com.lj.business.cf.dto.comTask.UpdateComTaskGroup)
	 */
	@Override
	public void updateComTaskGroup(UpdateComTaskGroup updateComTaskGroup)
			throws TsfaServiceException {
		logger.debug("updateFirstIntroduce(UpdateComTaskGroup updateFirstIntroduce={}) - start", updateComTaskGroup); //$NON-NLS-1$

		AssertUtils.notNull(updateComTaskGroup);
		AssertUtils.notNullAndEmpty(updateComTaskGroup.getMemberNo(),"客户会员号不能为空");
		AssertUtils.notNullAndEmpty(updateComTaskGroup.getMemberNoGm(),"导购编号不能为空");
		AssertUtils.notNullAndEmpty(updateComTaskGroup.getFinish(),"任务完成情况不能为空");
		try {
			ComTask comTask = new ComTask();
			comTask.setMemberNo(updateComTaskGroup.getMemberNo());
			comTask.setMemberNoGm(updateComTaskGroup.getMemberNoGm());
			comTask.setFinish(updateComTaskGroup.getFinish().toString());
			comTaskDao.updateComTaskGroup(comTask);
			logger.debug("updateComTask(UpdateComTask) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户沟通任务表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.COM_TASK_UPDATE_ERROR,"客户沟通任务表信息更新错误！",e);
		}


		logger.debug("updateFirstIntroduce(UpdateComTaskGroup) - end"); //$NON-NLS-1$
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskService#updateComTaskByMGM(com.lj.business.cf.dto.comTask.UpdateComTask)
	 */
	@Override
	public void updateComTaskByMemberNo(UpdateComTask updateComTask)throws TsfaServiceException {

		AssertUtils.notNull(updateComTask);
		AssertUtils.notNullAndEmpty(updateComTask.getMemberNo(),"客户编号不能为空");
		try {
			ComTask comTask = new ComTask();
			//update数据录入
			comTask.setMemberNo(updateComTask.getMemberNo());
			comTask.setCode(updateComTask.getCode());
			comTask.setMerchantNo(updateComTask.getMerchantNo());
			comTask.setShopNo(updateComTask.getShopNo());
			comTask.setShopName(updateComTask.getShopName());
			comTask.setMemberNoGm(updateComTask.getMemberNoGm());
			comTask.setMemberNameGm(updateComTask.getMemberNameGm());
			comTask.setCodeList(updateComTask.getCodeList());
			comTask.setNameList(updateComTask.getNameList());
			comTask.setWorkDate(updateComTask.getWorkDate());
			comTask.setWorkDateEnd(updateComTask.getWorkDateEnd());
			comTask.setWorkDateStart(updateComTask.getWorkDateStart());
			comTask.setRemarkCom(updateComTask.getRemarkCom());
			comTask.setFinish(updateComTask.getFinish());
			comTask.setReason(updateComTask.getReason());
			comTask.setCfNo(updateComTask.getCfNo());
			comTask.setNoType(updateComTask.getNoType());
			comTask.setLastResultDate(updateComTask.getLastResultDate());
			comTask.setRemark4(updateComTask.getRemark4());
			comTask.setRemark3(updateComTask.getRemark3());
			comTask.setRemark2(updateComTask.getRemark2());
			comTask.setRemark(updateComTask.getRemark());
			comTaskDao.updateComTaskByMemberNo(comTask);
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户沟通任务表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.COM_TASK_UPDATE_ERROR,"客户沟通任务表信息更新错误！",e);
		}

		logger.debug("updateComTaskByMGM() - end"); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskService#updateAllComTaskByMemberNo(com.lj.business.cf.dto.comTask.UpdateComTask)
	 */
	@Override
	public void updateAllComTaskByMemberNo(UpdateComTask updateComTask)throws TsfaServiceException {

		AssertUtils.notNull(updateComTask);
		AssertUtils.notNullAndEmpty(updateComTask.getMemberNo(),"客户编号不能为空");
		try {
			ComTask comTask = new ComTask();
			//update数据录入
			comTask.setMemberNo(updateComTask.getMemberNo());
			comTask.setCode(updateComTask.getCode());
			comTask.setMerchantNo(updateComTask.getMerchantNo());
			comTask.setShopNo(updateComTask.getShopNo());
			comTask.setShopName(updateComTask.getShopName());
			comTask.setMemberNoGm(updateComTask.getMemberNoGm());
			comTask.setMemberNameGm(updateComTask.getMemberNameGm());
			comTask.setCodeList(updateComTask.getCodeList());
			comTask.setNameList(updateComTask.getNameList());
			comTask.setWorkDate(updateComTask.getWorkDate());
			//comTask.setWorkDateEnd(updateComTask.getWorkDateEnd());
			//comTask.setWorkDateStart(updateComTask.getWorkDateStart());
			comTask.setRemarkCom(updateComTask.getRemarkCom());
			comTask.setFinish(updateComTask.getFinish());
			comTask.setReason(updateComTask.getReason());
			comTask.setCfNo(updateComTask.getCfNo());
			comTask.setNoType(updateComTask.getNoType());
			comTask.setLastResultDate(updateComTask.getLastResultDate());
			comTask.setRemark4(updateComTask.getRemark4());
			comTask.setRemark3(updateComTask.getRemark3());
			comTask.setRemark2(updateComTask.getRemark2());
			comTask.setRemark(updateComTask.getRemark());
			comTaskDao.updateAllComTaskByMemberNo(comTask);
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("客户沟通任务表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.COM_TASK_UPDATE_ERROR,"客户沟通任务表信息更新错误！",e);
		}

		logger.debug("updateComTaskByMGM() - end"); //$NON-NLS-1$
	}



	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskService#findComTask(com.lj.business.cf.dto.comTask.FindComTask)
	 */

	@Override
	public FindComTaskReturn findComTask(
			FindComTask findComTask) throws TsfaServiceException {
		logger.debug("findComTask(FindComTask findComTask={}) - start", findComTask); //$NON-NLS-1$

		AssertUtils.notNull(findComTask);
		AssertUtils.notAllNull(findComTask.getCode(),"Code不能为空");
		try {
			ComTask comTask = comTaskDao.selectByPrimaryKey(findComTask.getCode());
			if(comTask == null){
				throw new TsfaServiceException(ErrorCode.COM_TASK_NOT_EXIST_ERROR,"客户沟通任务表信息不存在");
			}
			FindComTaskReturn findComTaskReturn = new FindComTaskReturn();
			//find数据录入
			findComTaskReturn.setCode(comTask.getCode());
			findComTaskReturn.setMerchantNo(comTask.getMerchantNo());
			findComTaskReturn.setShopNo(comTask.getShopNo());
			findComTaskReturn.setShopName(comTask.getShopName());
			findComTaskReturn.setMemberNoGm(comTask.getMemberNoGm());
			findComTaskReturn.setMemberNameGm(comTask.getMemberNameGm());
			findComTaskReturn.setCodeList(comTask.getCodeList());
			findComTaskReturn.setNameList(comTask.getNameList());
			findComTaskReturn.setMemberNo(comTask.getMemberNo());
			findComTaskReturn.setMemberName(comTask.getMemberName());
			findComTaskReturn.setWorkDate(comTask.getWorkDate());
			findComTaskReturn.setRemarkCom(comTask.getRemarkCom());
			findComTaskReturn.setFinish(comTask.getFinish());
			findComTaskReturn.setReason(comTask.getReason());
			findComTaskReturn.setCfNo(comTask.getCfNo());
			findComTaskReturn.setNoType(comTask.getNoType());
			findComTaskReturn.setLastResultDate(comTask.getLastResultDate());
			findComTaskReturn.setCreateId(comTask.getCreateId());
			findComTaskReturn.setCreateDate(comTask.getCreateDate());
			findComTaskReturn.setRemark4(comTask.getRemark4());
			findComTaskReturn.setRemark3(comTask.getRemark3());
			findComTaskReturn.setRemark2(comTask.getRemark2());
			findComTaskReturn.setRemark(comTask.getRemark());

			logger.debug("findComTask(FindComTask) - end - return value={}", findComTaskReturn); //$NON-NLS-1$
			return findComTaskReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户沟通任务表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.COM_TASK_FIND_ERROR,"查找客户沟通任务表信息错误！",e);
		}


	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskService#findComTaskPage(com.lj.business.cf.dto.comTask.FindComTaskPage)
	 */

	@Override
	public Page<FindComTaskPageReturn> findComTaskPage(
			FindComTaskPage findComTaskPage)
					throws TsfaServiceException {
		logger.debug("findComTaskPage(FindComTaskPage findComTaskPage={}) - start", findComTaskPage); //$NON-NLS-1$

		AssertUtils.notNull(findComTaskPage);
		List<FindComTaskPageReturn> returnList;
		int count = 0;
		try {
			returnList = comTaskDao.findComTaskPage(findComTaskPage);
			count = comTaskDao.findComTaskPageCount(findComTaskPage);
		}  catch (Exception e) {
			logger.error("客户沟通任务表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.COM_TASK_FIND_PAGE_ERROR,"客户沟通任务表信息分页查询错误.！",e);
		}
		Page<FindComTaskPageReturn> returnPage = new Page<FindComTaskPageReturn>(returnList, count, findComTaskPage);

		logger.debug("findComTaskPage(FindComTaskPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskService#findComTashTopOne(com.lj.business.cf.dto.comTask.FindComTask)
	 */

	@Override
	public List<FindComTaskReturn> findComTashTopOne(FindComTask findComTask) throws TsfaServiceException {
		logger.debug("findcomTashTopOne(FindComTask findComTask={}) - start", findComTask); //$NON-NLS-1$

		List<FindComTaskReturn> returnList;
		try {
			returnList = comTaskDao.findComTashTopOne(findComTask);
		}  catch (Exception e) {
			logger.error("客户沟通任务表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.COM_TASK_FIND_PAGE_ERROR,"客户沟通任务表信息分页查询错误.！",e);
		}

		logger.debug("findcomTashTopOne(FindComTask) - end - return value={}", returnList); //$NON-NLS-1$
		return  returnList;
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskService#findComTaskIndexPage(com.lj.business.cf.dto.comTask.FindComTaskIndexPage)
	 */
	@Override
	public Page<FindComTaskIndexPageReturn> findComTaskIndexPage(
			FindComTaskIndexPage findComTaskIndexPage)
					throws TsfaServiceException {
		logger.debug("findComTaskIndexPage(FindComTaskIndexPage findComTaskIndexPage={}) - start", findComTaskIndexPage); //$NON-NLS-1$

		AssertUtils.notNull(findComTaskIndexPage);
		AssertUtils.notNull(findComTaskIndexPage.getMemberNoGm(),"导购编号不能为空！");
		AssertUtils.notNull(findComTaskIndexPage.getMerchantNo(),"商户编号不能为空！");
		AssertUtils.notNull(findComTaskIndexPage.getCodeList(),"项目CODE不能为空！");
		List<FindComTaskIndexPageReturn> returnList;
		int count = 0;
		try {
			Date now = new Date();
			now = org.apache.commons.lang.time.DateUtils.truncate(now, Calendar.DAY_OF_MONTH);
			findComTaskIndexPage.setWorkDateStart(now);
			Date workDateEnd = DateUtils.getNextday(now) ;
			findComTaskIndexPage.setWorkDateEnd(workDateEnd);

			returnList = comTaskDao.findComTaskIndexPage(findComTaskIndexPage);
			if(returnList.size() != 0){
				List<String> memberNoAr = new ArrayList<String>();
				for (FindComTaskIndexPageReturn findComTaskIndexPageReturn : returnList) {
					memberNoAr.add(findComTaskIndexPageReturn.getMemberNo());
				}
				FindPmWxInfo findPmWxInfo = new FindPmWxInfo();
				findPmWxInfo.setMemberNoAr(memberNoAr);
				findPmWxInfo.setMemberNoGm(findComTaskIndexPage.getMemberNoGm());
				findPmWxInfo.setMerchantNo(findComTaskIndexPage.getMerchantNo());
				List<FindPmWxInfoReturn>  list = personMemberService.findPmWxInfo(findPmWxInfo);
				for (FindComTaskIndexPageReturn findComTaskIndexPageReturn : returnList) {//XXX LEOPENG 待完善，排序获取，而不是循环遍历
					for (FindPmWxInfoReturn findPmWxInfoReturn : list) {
						if(findComTaskIndexPageReturn.getMemberNo().equals(findPmWxInfoReturn.getMemberNo())){
							findComTaskIndexPageReturn.setHeadAddress(findPmWxInfoReturn.getHeadAddress());
							findComTaskIndexPageReturn.setNickNameRemarkWx(findPmWxInfoReturn.getNickNameWx());
							findComTaskIndexPageReturn.setNickNameRemarkLocal(findPmWxInfoReturn.getNickNameRemarkLocal());
							findComTaskIndexPageReturn.setNickNameWx(findPmWxInfoReturn.getNickNameWx());
							findComTaskIndexPageReturn.setNoWx(findPmWxInfoReturn.getNoWx());
							findComTaskIndexPageReturn.setMobile(findPmWxInfoReturn.getMobile());
						}
					}
				}
			}
			count = comTaskDao.findComTaskIndexPageCount(findComTaskIndexPage);
		}  catch (Exception e) {
			logger.error("客户沟通任务表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.COM_TASK_FIND_PAGE_ERROR,"客户沟通任务表信息分页查询错误.！",e);
		}
		Page<FindComTaskIndexPageReturn> returnPage = new Page<FindComTaskIndexPageReturn>(returnList, count, findComTaskIndexPage);

		logger.debug("findComTaskIndexPage(FindComTaskIndexPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;

	} 

	/**
	 * Adds the required num.
	 *
	 * @param addComTask the add com task
	 * @param finishNum the finish num
	 */
	private void addRequiredNum(AddComTask addComTask, Long finishNum, Long requireNum) {
		// 增加沟通的数量
		UpdateWorkTaskFinishNum updateWorkTaskFinishNum = new UpdateWorkTaskFinishNum();
		updateWorkTaskFinishNum.setMemberNoGm(addComTask.getMemberNoGm());
		updateWorkTaskFinishNum.setMerchantNo(addComTask.getMerchantNo());
		updateWorkTaskFinishNum.setTaskType(TaskType.GOU_TONG);
		updateWorkTaskFinishNum.setFinishNum(finishNum);
		updateWorkTaskFinishNum.setRequireNum(requireNum);
		workTaskService.updateFinishNum(updateWorkTaskFinishNum);
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.IComTaskService#todayBeforeClientExpTask(com.lj.business.cf.dto.TodayBeforeClientExpTaskDto)
	 */
	@Override
	public TodayBeforeClientExpTaskReturn todayBeforeClientExpTask(TodayBeforeClientExpTaskDto todayBeforeClientExpTaskDto)throws TsfaServiceException {
		AssertUtils.notNull(todayBeforeClientExpTaskDto);
		AssertUtils.notNullAndEmpty(todayBeforeClientExpTaskDto.getMerchantNo(), "商户编号不能为空");
		AssertUtils.notNullAndEmpty(todayBeforeClientExpTaskDto.getMemberNoGm(), "导购编号不能为空");
		AssertUtils.notNullAndEmpty(todayBeforeClientExpTaskDto.getShopNo(), "分店不能为空");
		try{
			TodayBeforeClientExpTaskReturn todayBeforeClientExpTaskReturn = new TodayBeforeClientExpTaskReturn();
			Date stDate = org.apache.commons.lang.time.DateUtils.truncate(DateUtils.addDays(new Date(), 1),Calendar.DAY_OF_MONTH);
			todayBeforeClientExpTaskDto.setStDate(stDate);
			int count = comTaskDao.todayBeforeClientExpTask(todayBeforeClientExpTaskDto);
			todayBeforeClientExpTaskReturn.setCount(count);
			return todayBeforeClientExpTaskReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找客户沟通任务表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.COM_TASK_FIND_ERROR,"查找客户沟通任务表信息错误！",e);
		}
		
	}

	@Override
	public List<Map<String, Object>> findExpResults(Map<String, Object> parmMap)
			throws TsfaServiceException {
		logger.debug("findExpResults(Map<String, Object> parmMap)={}) - start", parmMap); //$NON-NLS-1$
		List<Map<String, Object>> returnList;
		try {
			returnList = comTaskDao.findExpResults(parmMap);
		}  catch (Exception e) {
			logger.error("客户沟通任务表信息查询错误",e);
			throw new TsfaServiceException(ErrorCode.COM_TASK_FIND_PAGE_ERROR,"客户沟通任务表信息查询错误.！",e);
		}

		logger.debug("findcomTashTopOne(FindComTask) - end - return value={}", returnList); //$NON-NLS-1$
		return  returnList;
	}


	@Override
	public int findCountFinishByDay(FindComTask findComTask) throws TsfaServiceException {
		AssertUtils.notNull(findComTask);
		AssertUtils.notNullAndEmpty(findComTask.getMerchantNo(), "商户编号不能为空");
		AssertUtils.notNullAndEmpty(findComTask.getMemberNoGm(), "导购编号不能为空");
		return comTaskDao.findCountFinishByDay(findComTask);
	}

}