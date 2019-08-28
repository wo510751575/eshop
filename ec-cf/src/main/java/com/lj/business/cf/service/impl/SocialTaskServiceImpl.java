package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
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
import com.lj.business.cf.dao.ISocialTaskDao;
import com.lj.business.cf.domain.SocialTask;
import com.lj.business.cf.dto.UpdateWorkTask;
import com.lj.business.cf.dto.UpdateWorkTaskFinishNum;
import com.lj.business.cf.dto.socialTask.AddSocialTask;
import com.lj.business.cf.dto.socialTask.DelSocialTask;
import com.lj.business.cf.dto.socialTask.FindSocialTask;
import com.lj.business.cf.dto.socialTask.FindSocialTaskPage;
import com.lj.business.cf.dto.socialTask.FindSocialTaskPageReturn;
import com.lj.business.cf.dto.socialTask.FindSocialTaskReturn;
import com.lj.business.cf.dto.socialTask.FindSocialTaskSt;
import com.lj.business.cf.dto.socialTask.FindStIndexPage;
import com.lj.business.cf.dto.socialTask.FindStIndexPageReturn;
import com.lj.business.cf.dto.socialTask.FindStIndexTotal;
import com.lj.business.cf.dto.socialTask.FindStIndexTotalReturn;
import com.lj.business.cf.dto.socialTask.UpdateSocialTask;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskList;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskListReturn;
import com.lj.business.cf.emus.ActionTask;
import com.lj.business.cf.emus.FinishSocial;
import com.lj.business.cf.emus.TaskType;
import com.lj.business.cf.service.ISocialTaskService;
import com.lj.business.cf.service.IWorkTaskListService;
import com.lj.business.cf.service.IWorkTaskService;
import com.lj.business.member.dto.FindGuidMember;
import com.lj.business.member.dto.FindGuidMemberReturn;
import com.lj.business.member.dto.FindPersonMemberBase;
import com.lj.business.member.dto.FindPersonMemberBaseReturn;
import com.lj.business.member.dto.FindPmWxBpInfo;
import com.lj.business.member.dto.FindPmWxBpInfoReturn;
import com.lj.business.member.dto.behaviorPm.UpdateBehaviorPm;
import com.lj.business.member.dto.guidMemberIntegral.GuidMemberIntegralDto;
import com.lj.business.member.emus.IntegralType;
import com.lj.business.member.service.IBehaviorPmService;
import com.lj.business.member.service.IGuidMemberIntegralService;
import com.lj.business.member.service.IGuidMemberService;
import com.lj.business.member.service.IPersonMemberBaseService;
import com.lj.business.member.service.IPersonMemberService;

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
public class SocialTaskServiceImpl implements ISocialTaskService { 


	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(SocialTaskServiceImpl.class);


	/** The social task dao. */
	@Resource
	private ISocialTaskDao socialTaskDao;

	@Resource
	private IPersonMemberBaseService personMemberBaseService;

	@Resource
	private IPersonMemberService personMemberService;

	@Resource
	private IGuidMemberService guidMemberService;

	@Resource
	private IBehaviorPmService behaviorPmService;

	@Resource
	private IGuidMemberIntegralService guidMemberIntegralService;
	
	@Resource
	private IWorkTaskListService workTaskListService;
	
	@Resource
	private IWorkTaskService workTaskService;


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ISocialTaskService#addSocialTask(com.lj.business.cf.dto.socialTask.AddSocialTask)
	 */
	@Override
	public void addSocialTask(
			AddSocialTask addSocialTask) throws TsfaServiceException {
		logger.debug("addSocialTask(AddSocialTask addSocialTask={}) - start", addSocialTask); 

		AssertUtils.notNull(addSocialTask);
		AssertUtils.notNull(addSocialTask.getWorkDate(),"工作日期不能为空");
		AssertUtils.notNullAndEmpty(addSocialTask.getMemberNoGm(),"导购编号不能为空");
		AssertUtils.notNull(addSocialTask.getFriendUpdateDate(),"朋友圈更新时间不能为空");
		try {
			// CODE_LIST 社交任务获取填入
			FindWorkTaskList findWorkTaskList = new FindWorkTaskList();
			findWorkTaskList.setTaskType(TaskType.SHE_JIAO.toString());
			FindWorkTaskListReturn findWorkTaskListReturn = workTaskListService.findWorkTaskListByTaskType(findWorkTaskList);
			if(findWorkTaskListReturn != null){
				addSocialTask.setCodeList(findWorkTaskListReturn.getCode());
			}
			
			//默认值处理
			if(StringUtils.isEmpty(addSocialTask.getActionTask())){
				addSocialTask.setActionTask(ActionTask.COMMENTING.toString());
			}
			if(StringUtils.isEmpty(addSocialTask.getCreateId())){
				addSocialTask.setCreateId(addSocialTask.getMemberNoGm());
			}
			if(StringUtils.isEmpty(addSocialTask.getFinish())){
				addSocialTask.setFinish("N");
			}

			// 根据微信号查询客户编号
			FindPersonMemberBase findPersonMemberBase = new FindPersonMemberBase();
			findPersonMemberBase.setNoWx(addSocialTask.getNoWx());
			FindPersonMemberBaseReturn member = personMemberBaseService.findPersonMemberBase(findPersonMemberBase);
			if (member != null) {
				addSocialTask.setMemberNo(member.getMemberNo());
				addSocialTask.setMemberName(member.getMemberName());
				addSocialTask.setShopNo(member.getShopNo());
				addSocialTask.setShopName(member.getShopName());
			}

			// 根据导购编号查询商户编号
			FindGuidMember findGuidMember = new FindGuidMember();
			findGuidMember.setMemberNo(addSocialTask.getMemberNoGm());
			FindGuidMemberReturn guidMember = guidMemberService.findGuidMember(findGuidMember);
			if (guidMember != null) {
				addSocialTask.setMerchantNo(guidMember.getMerchantNo());
			}

			//XXX LEOPENG 社交任务待完善
			//查询当天是否已经有社交任务产生
			SocialTask socialTaskQuery = new SocialTask();
			socialTaskQuery.setWorkDate(org.apache.commons.lang.time.DateUtils.truncate(addSocialTask.getWorkDate(), Calendar.DAY_OF_MONTH) );
			socialTaskQuery.setMemberNo(addSocialTask.getMemberNo());
			socialTaskQuery.setMemberNoGm(addSocialTask.getMemberNoGm());
			int count = socialTaskDao.selectCountByParams(socialTaskQuery);
			logger.debug("社交任务存在的数量:" + count);
			if(count == 0){
				logger.debug("录入社交任务");
				SocialTask socialTask = new SocialTask();
				//add数据录入
				socialTask.setCode(GUID.generateCode());
				socialTask.setMerchantNo(addSocialTask.getMerchantNo());
				socialTask.setShopNo(guidMember.getShopNo());
				socialTask.setShopName(guidMember.getShopName());
				socialTask.setMemberNoGm(addSocialTask.getMemberNoGm());
				socialTask.setMemberNameGm(addSocialTask.getMemberNameGm());
				socialTask.setCodeList(addSocialTask.getCodeList());
				socialTask.setNameList(addSocialTask.getNameList());
				socialTask.setMemberNo(addSocialTask.getMemberNo());
				socialTask.setMemberName(addSocialTask.getMemberName());
				socialTask.setWorkDate(addSocialTask.getWorkDate());
				socialTask.setWorkFinishDate(addSocialTask.getWorkFinishDate());
				socialTask.setFriendUpdateDate(addSocialTask.getFriendUpdateDate());
				socialTask.setFinish(addSocialTask.getFinish());
				socialTask.setActionTask(addSocialTask.getActionTask());
				socialTask.setReason(addSocialTask.getReason());
				socialTask.setIdWx(addSocialTask.getIdWx());
				socialTask.setCreateId(addSocialTask.getCreateId());
				socialTask.setRemark4(addSocialTask.getRemark4());
				socialTask.setRemark3(addSocialTask.getRemark3());
				socialTask.setRemark2(addSocialTask.getRemark2());
				socialTask.setRemark(addSocialTask.getRemark());
				socialTaskDao.insert(socialTask);
				
				//在社交任务中加一
				UpdateWorkTask updateWorkTask = new UpdateWorkTask();
				updateWorkTask.setMemberNoGm(addSocialTask.getMemberNoGm());
				updateWorkTask.setTaskType(TaskType.SHE_JIAO.toString());
				updateWorkTask.setWorkDate(new Date());
				workTaskService.updateRequireNumByGmTypeDay(updateWorkTask);
			}
			
			//更新最近动态
			UpdateBehaviorPm updateBehaviorPm = new UpdateBehaviorPm();
			updateBehaviorPm.setBehaviorDate(addSocialTask.getFriendUpdateDate());
			updateBehaviorPm.setBehaviorDesc("更新了朋友圈");
			updateBehaviorPm.setMemberNo(addSocialTask.getMemberNo());
			behaviorPmService.updateBehaviorPm(updateBehaviorPm);
			logger.debug("addSocialTask(AddSocialTask) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增工作任务表（社交）信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SOCIAL_TASK_ADD_ERROR,"新增工作任务表（社交）信息错误！",e);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ISocialTaskService#delSocialTask(com.lj.business.cf.dto.socialTask.DelSocialTask)
	 */
	@Override
	public void delSocialTask(
			DelSocialTask delSocialTask) throws TsfaServiceException {
		logger.debug("delSocialTask(DelSocialTask delSocialTask={}) - start", delSocialTask); 

		AssertUtils.notNull(delSocialTask);
		AssertUtils.notNull(delSocialTask.getCode(),"Code不能为空！");
		try {
			socialTaskDao.deleteByPrimaryKey(delSocialTask.getCode());
			logger.debug("delSocialTask(DelSocialTask) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除工作任务表（社交）信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SOCIAL_TASK_DEL_ERROR,"删除工作任务表（社交）信息错误！",e);

		}
	}

	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ISocialTaskService#updateSocialTask(com.lj.business.cf.dto.socialTask.UpdateSocialTask)
	 */
	@Override
	public void updateSocialTask(
			UpdateSocialTask updateSocialTask)
					throws TsfaServiceException {
		logger.debug("updateSocialTask(UpdateSocialTask updateSocialTask={}) - start", updateSocialTask); //$NON-NLS-1$

		AssertUtils.notNull(updateSocialTask);
		AssertUtils.notNullAndEmpty(updateSocialTask.getCode(),"Code不能为空");
		try {

			SocialTask socialTask = new SocialTask();
			//update数据录入
			socialTask.setCode(updateSocialTask.getCode());
			socialTask.setMerchantNo(updateSocialTask.getMerchantNo());
			socialTask.setShopNo(updateSocialTask.getShopNo());
			socialTask.setShopName(updateSocialTask.getShopName());
			socialTask.setMemberNoGm(updateSocialTask.getMemberNoGm());
			socialTask.setMemberNameGm(updateSocialTask.getMemberNameGm());
			socialTask.setCodeList(updateSocialTask.getCodeList());
			socialTask.setNameList(updateSocialTask.getNameList());
			socialTask.setMemberNo(updateSocialTask.getMemberNo());
			socialTask.setMemberName(updateSocialTask.getMemberName());
			socialTask.setWorkDate(updateSocialTask.getWorkDate());
			socialTask.setWorkFinishDate(updateSocialTask.getWorkFinishDate());
			socialTask.setFriendUpdateDate(updateSocialTask.getFriendUpdateDate());
			socialTask.setFinish(updateSocialTask.getFinish());
			socialTask.setActionTask(updateSocialTask.getActionTask());
			socialTask.setReason(updateSocialTask.getReason());
			socialTask.setIdWx(updateSocialTask.getIdWx());
			socialTask.setRemark4(updateSocialTask.getRemark4());
			socialTask.setRemark3(updateSocialTask.getRemark3());
			socialTask.setRemark2(updateSocialTask.getRemark2());
			socialTask.setRemark(updateSocialTask.getRemark());
			AssertUtils.notUpdateMoreThanOne(socialTaskDao.updateByPrimaryKeySelective(socialTask));
			
			if(FinishSocial.Y.toString().equals(updateSocialTask.getFinish()) ){
				logger.debug("工作积分计算");
				//获取社交信息
				SocialTask socialTaskTemp = socialTaskDao.selectByPrimaryKey(updateSocialTask.getCode());
				
				logger.debug("获取导购信息");
				FindGuidMember findGuidMember = new FindGuidMember();
				findGuidMember.setMemberNo(socialTaskTemp.getMemberNoGm());
				FindGuidMemberReturn findGuidMemberReturn = guidMemberService.findGuidMember(findGuidMember );
				
				logger.debug("积分计算");
				GuidMemberIntegralDto guidMemberIntegralDto = new GuidMemberIntegralDto();
				guidMemberIntegralDto.setMemberNo(socialTaskTemp.getMemberNoGm());
				guidMemberIntegralDto.setMemberName(socialTaskTemp.getMemberNameGm());
				guidMemberIntegralDto.setMerchantNo(socialTaskTemp.getMerchantNo());
				guidMemberIntegralDto.setShopNo(socialTaskTemp.getShopNo());
				guidMemberIntegralDto.setShopName(socialTaskTemp.getShopName());
				guidMemberIntegralDto.setAreaCode(findGuidMemberReturn.getAreaCode());
				guidMemberIntegralDto.setAreaName(findGuidMemberReturn.getAreaName());
				guidMemberIntegralDto.setIntegralType(IntegralType.SOCIAL.toString());
				guidMemberIntegralService.doIntegral(guidMemberIntegralDto);
				
				UpdateWorkTaskFinishNum updateWorkTaskFinishNum = new UpdateWorkTaskFinishNum();
				updateWorkTaskFinishNum.setFinishNum(1L);
				updateWorkTaskFinishNum.setMemberNoGm(socialTaskTemp.getMemberNoGm());
				updateWorkTaskFinishNum.setMerchantNo(socialTaskTemp.getMerchantNo());
				updateWorkTaskFinishNum.setTaskType(TaskType.SHE_JIAO);
				workTaskService.updateFinishNum(updateWorkTaskFinishNum);
			}
			
			logger.debug("updateSocialTask(UpdateSocialTask) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("工作任务表（社交）信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SOCIAL_TASK_UPDATE_ERROR,"工作任务表（社交）信息更新信息错误！",e);
		}
	}



	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ISocialTaskService#findSocialTask(com.lj.business.cf.dto.socialTask.FindSocialTask)
	 */
	@Override
	public FindSocialTaskReturn findSocialTask(
			FindSocialTask findSocialTask) throws TsfaServiceException {
		logger.debug("findSocialTask(FindSocialTask findSocialTask={}) - start", findSocialTask); //$NON-NLS-1$

		AssertUtils.notNull(findSocialTask);
		AssertUtils.notAllNull(findSocialTask.getCode(),"Code不能为空");
		try {
			SocialTask socialTask = socialTaskDao.selectByPrimaryKey(findSocialTask.getCode());
			if(socialTask == null){
				throw new TsfaServiceException(ErrorCode.SOCIAL_TASK_NOT_EXIST_ERROR,"工作任务表（社交）信息不存在");
			}
			FindSocialTaskReturn findSocialTaskReturn = new FindSocialTaskReturn();
			//find数据录入
			findSocialTaskReturn.setCode(socialTask.getCode());
			findSocialTaskReturn.setMerchantNo(socialTask.getMerchantNo());
			findSocialTaskReturn.setShopNo(socialTask.getShopNo());
			findSocialTaskReturn.setShopName(socialTask.getShopName());
			findSocialTaskReturn.setMemberNoGm(socialTask.getMemberNoGm());
			findSocialTaskReturn.setMemberNameGm(socialTask.getMemberNameGm());
			findSocialTaskReturn.setCodeList(socialTask.getCodeList());
			findSocialTaskReturn.setNameList(socialTask.getNameList());
			findSocialTaskReturn.setMemberNo(socialTask.getMemberNo());
			findSocialTaskReturn.setMemberName(socialTask.getMemberName());
			findSocialTaskReturn.setWorkDate(socialTask.getWorkDate());
			findSocialTaskReturn.setFriendUpdateDate(socialTask.getFriendUpdateDate());
			findSocialTaskReturn.setFinish(socialTask.getFinish());
			findSocialTaskReturn.setActionTask(socialTask.getActionTask());
			findSocialTaskReturn.setReason(socialTask.getReason());
			findSocialTaskReturn.setIdWx(socialTask.getIdWx());
			findSocialTaskReturn.setCreateId(socialTask.getCreateId());
			findSocialTaskReturn.setCreateDate(socialTask.getCreateDate());
			findSocialTaskReturn.setRemark4(socialTask.getRemark4());
			findSocialTaskReturn.setRemark3(socialTask.getRemark3());
			findSocialTaskReturn.setRemark2(socialTask.getRemark2());
			findSocialTaskReturn.setRemark(socialTask.getRemark());

			logger.debug("findSocialTask(FindSocialTask) - end - return value={}", findSocialTaskReturn); //$NON-NLS-1$
			return findSocialTaskReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找工作任务表（社交）信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SOCIAL_TASK_FIND_ERROR,"查找工作任务表（社交）信息信息错误！",e);
		}


	}

	@Override
	public List<FindSocialTaskSt> findSocialTaskStByDay(Date date)
			throws TsfaServiceException {
		logger.debug("findSocialTaskStByDay() - start");
		try {
			List<FindSocialTaskSt> list = socialTaskDao.findSocialTaskStByDay(date);
			logger.debug("findSocialTaskStByDay() - end");
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new TsfaServiceException(ErrorCode.SOCIAL_TASK_FIND_ST_ERROR,"统计工作任务表（社交）信息信息错误！",e);
		}
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ISocialTaskService#findSocialTaskPage(com.lj.business.cf.dto.socialTask.FindSocialTaskPage)
	 */
	@Override
	public Page<FindSocialTaskPageReturn> findSocialTaskPage(
			FindSocialTaskPage findSocialTaskPage)
					throws TsfaServiceException {
		logger.debug("findSocialTaskPage(FindSocialTaskPage findSocialTaskPage={}) - start", findSocialTaskPage); //$NON-NLS-1$

		AssertUtils.notNull(findSocialTaskPage);
		List<FindSocialTaskPageReturn> returnList;
		int count = 0;
		try {
			returnList = socialTaskDao.findSocialTaskPage(findSocialTaskPage);
			count = socialTaskDao.findSocialTaskPageCount(findSocialTaskPage);
		}  catch (Exception e) {
			logger.error("工作任务表（社交）信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.SOCIAL_TASK_FIND_PAGE_ERROR,"工作任务表（社交）信息不存在错误.！",e);
		}
		Page<FindSocialTaskPageReturn> returnPage = new Page<FindSocialTaskPageReturn>(returnList, count, findSocialTaskPage);

		logger.debug("findSocialTaskPage(FindSocialTaskPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ISocialTaskService#findStIndexPage(com.lj.business.cf.dto.socialTask.FindStIndexPage)
	 */
	@Override
	public Page<FindStIndexPageReturn> findStIndexPage(
			FindStIndexPage findStIndexPage) throws TsfaServiceException {
		logger.debug("findStIndexPage(FindStIndexPage findStIndexPage={}) - start", findStIndexPage); //$NON-NLS-1$

		AssertUtils.notNull(findStIndexPage);
		AssertUtils.notNull(findStIndexPage.getMemberNoGm(),"导购编号不能为空！");
		AssertUtils.notNull(findStIndexPage.getMerchantNo(),"商户编号不能为空！");
		List<FindStIndexPageReturn> returnList;
		int count = 0;
		try {
			Date now = new Date();
			now = org.apache.commons.lang.time.DateUtils.truncate(now, Calendar.DAY_OF_MONTH);
			findStIndexPage.setWorkDateStart(now);
			Date workDateEnd = DateUtils.getNextday(now) ;
			findStIndexPage.setWorkDateEnd(workDateEnd);
			returnList = socialTaskDao.findStIndexPage(findStIndexPage);
			if(returnList.size() != 0){
				List<String> memberNoAr = new ArrayList<String>();
				for (FindStIndexPageReturn findStIndexPageReturn : returnList) {
					memberNoAr.add(findStIndexPageReturn.getMemberNo());
				}
				FindPmWxBpInfo findPmWxBpInfo = new FindPmWxBpInfo();
				findPmWxBpInfo.setMemberNoAr(memberNoAr);
				findPmWxBpInfo.setMemberNoGm(findStIndexPage.getMemberNoGm());
				findPmWxBpInfo.setMerchantNo(findStIndexPage.getMerchantNo());
				List<FindPmWxBpInfoReturn>  list = personMemberService.findPmWxBpInfo(findPmWxBpInfo);
				for (FindStIndexPageReturn findStIndexPageReturn : returnList) {//XXX LEOPENG 待完善，排序获取，而不是循环遍历
					for (FindPmWxBpInfoReturn findPmWxBpInfoReturn : list) {
						if(findStIndexPageReturn.getMemberNo().equals(findPmWxBpInfoReturn.getMemberNo())){
							findStIndexPageReturn.setHeadAddress(findPmWxBpInfoReturn.getHeadAddress());
							findStIndexPageReturn.setNickNameRemarkWx(findPmWxBpInfoReturn.getNickNameWx());
							findStIndexPageReturn.setNickNameRemarkLocal(findPmWxBpInfoReturn.getNickNameRemarkLocal());
							findStIndexPageReturn.setBehaviorDate(findPmWxBpInfoReturn.getBehaviorDate());
							findStIndexPageReturn.setBehaviorDesc(findPmWxBpInfoReturn.getBehaviorDesc());
							findStIndexPageReturn.setNickNameWx(findPmWxBpInfoReturn.getNickNameWx());
							findStIndexPageReturn.setNoWx(findPmWxBpInfoReturn.getNoWx());
						}
					}
				}
			}
			count = socialTaskDao.findStIndexPageCount(findStIndexPage);
		}  catch (Exception e) {
			logger.error("工作任务表（社交）信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.SOCIAL_TASK_FIND_PAGE_ERROR,"工作任务表（社交）信息不存在错误.！",e);
		}
		Page<FindStIndexPageReturn> returnPage = new Page<FindStIndexPageReturn>(returnList, count, findStIndexPage);

		logger.debug("findStIndexPage(FindStIndexPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;

	}


	/* (non-Javadoc)
	 * @see com.lj.business.cf.service.ISocialTaskService#findStIndexTotal(com.lj.business.cf.dto.socialTask.FindStIndexTotal)
	 */
	@Override
	public FindStIndexTotalReturn findStIndexTotal(
			FindStIndexTotal findStIndexTotal) throws TsfaServiceException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int findCountSocialByGm(Map<String, Object> map) {
		logger.debug("findCountSocialBerDayByGm(Map<String, Object> map={}) - start", map); //$NON-NLS-1$

		AssertUtils.notNull(map);
		int count = 0;
		try {
			count = socialTaskDao.findCountSocialByGm(map);
		}  catch (Exception e) {
			logger.error("统计社交任务量错误",e);
			throw new TsfaServiceException(ErrorCode.SOCIAL_TASK_FIND_PAGE_ERROR,"统计社交任务量错误！",e);
		}
		logger.debug("findCountSocialBerDayByGm(count) - end - return value={}", count); //$NON-NLS-1$
		return  count;
	} 


}
