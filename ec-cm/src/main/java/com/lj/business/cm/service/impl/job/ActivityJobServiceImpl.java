package com.lj.business.cm.service.impl.job;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummary;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummaryReturn;
import com.lj.business.cf.dto.comTask.AddComTask;
import com.lj.business.cf.dto.comTaskList.FindComTaskList;
import com.lj.business.cf.dto.comTaskList.FindComTaskListReturn;
import com.lj.business.cf.emus.ComTaskType;
import com.lj.business.cf.emus.FollowNoType;
import com.lj.business.cf.service.IClientFollowSummaryService;
import com.lj.business.cf.service.IComTaskListService;
import com.lj.business.cf.service.IComTaskService;
import com.lj.business.cm.service.IActivityJobService;
import com.lj.business.cm.service.IActivityService;
import com.lj.business.common.CommonConstant;
import com.lj.business.member.dto.FindPersonMemberPageReturn;
import com.lj.business.member.service.IGuidMemberService;
import com.lj.business.member.service.IPersonMemberService;
import com.lj.cc.clientintf.IJob;
import com.lj.cc.clientintf.LocalCacheSystemParamsFromCC;

/**
 * 
 * 
 * 类说明：活动调度任务实现类
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月15日
 */
@Service
public class ActivityJobServiceImpl implements IActivityJobService,IJob { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ActivityJobServiceImpl.class);
	
	@Autowired
	private IComTaskService comTaskService;
	@Autowired
	private IActivityService activityService;
	@Autowired
	private LocalCacheSystemParamsFromCC localCacheSystemParams;
	@Autowired
	private IGuidMemberService guidMemberService;
	@Autowired
	private IPersonMemberService personMemberService;
	@Autowired
	private IClientFollowSummaryService clientFollowSummaryService;
	@Autowired
	private IComTaskListService comTaskListService;
	
	@Override
	public void runJob() {
		this.activityComTask();
	}
	
	/**
	 * 活动7天前产生邀约任务
	 * 所有意向客户（到店和未到店）
	 */
	@Override
	public void activityComTask() throws TsfaServiceException {
		logger.debug("OMS活动调度任务------------------start");
    	long beginTime = System.currentTimeMillis();//1、开始时间  
        logger.debug("开始计时: {}", new SimpleDateFormat("hh:mm:ss.SSS").format(beginTime));
        
    	/*String day =  localCacheSystemParams.getSystemParam(SystemAliasName.cm.toString(),SystemParamConstant.JOB_GROUP, SystemParamConstant.ACTIVITY_JOB);
    	int dataInt= 7;	//默认7天
    	if(StringUtils.isNotEmpty(day)){
    		dataInt = Integer.valueOf(day);
    	}
    	获取所有开始时间7天前的活动
    	FindActivityPage findActivityPage = new FindActivityPage();
    	Date now = new Date();
    	findActivityPage.setStartDate(DateUtils.formatDate(DateUtils.addDays(now, dataInt), DateUtils.PATTERN_yyyy_MM_dd));
    	List<FindActivityPageReturn> list= activityService.findActivitys(findActivityPage);
    	for (FindActivityPageReturn findActivityPageReturn : list) {
    		获取商户下所有导购
    		String merchantNo=findActivityPageReturn.getMerchantNo();
    		FindGuidMemberPage findGuidMemberPage = new FindGuidMemberPage();
    		findGuidMemberPage.setMerchantNo(merchantNo);
    		List<FindGuidMemberPageReturn> findGuidMemberPageReturns= guidMemberService.findGuidMembers(findGuidMemberPage);
    		获取导购下所有意向（到店/未到店）客户
    		for (FindGuidMemberPageReturn findGuidMemberPageReturn : findGuidMemberPageReturns) {
    			List<FindPersonMemberPageReturn> pmList = new ArrayList<>();
    			String memberNoGm = findGuidMemberPageReturn.getMemberNo();
    			到店客户
    			FindPersonMemberPage findPersonMemberPage = new FindPersonMemberPage();
    			findPersonMemberPage.setMerchantNo(merchantNo);
    			findPersonMemberPage.setMemberNoGm(memberNoGm);
    			findPersonMemberPage.setPmTypeType(PmTypeType.INTENTION.toString());
    			List<FindPersonMemberPageReturn> intentionList= personMemberService.findPersonMemberList(findPersonMemberPage);
    			pmList.addAll(intentionList);
    			
    			未到店客户
    			findPersonMemberPage.setPmTypeType(PmTypeType.INTENTION_N.toString());
    			List<FindPersonMemberPageReturn> intentionNList= personMemberService.findPersonMemberList(findPersonMemberPage);
    			pmList.addAll(intentionNList);
    			
    			生成邀约任务		TODO   多线程	 
//    			taskExecutor.execute(new Runnable() {
//					@Override
//					public void run() {
						addTask(pmList,now);
//					}
//				});
			}
		}
		long endTime = System.currentTimeMillis(); 	//2、结束时间  
        logger.debug("计时结束：{}  耗时：{} 最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
        		new SimpleDateFormat("hh:mm:ss.SSS").format(endTime), (endTime - beginTime)+"",
				Runtime.getRuntime().maxMemory()/1024/1024, Runtime.getRuntime().totalMemory()/1024/1024, Runtime.getRuntime().freeMemory()/1024/1024, 
				(Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory())/1024/1024); 
    	logger.debug("OMS活动调度任务------------------end");*/
	}

	
	private void addTask(List<FindPersonMemberPageReturn> pmList,Date now){
    	for (FindPersonMemberPageReturn findPersonMemberPageReturn : pmList) {
    		AddComTask addComTask = new AddComTask();
    		String merchantNo = findPersonMemberPageReturn.getMerchantNo();
    		String memberNoGm = findPersonMemberPageReturn.getMemberNoGm();
    		String memberNo = findPersonMemberPageReturn.getMemberNo();
    		addComTask.setMemberNoGm(findPersonMemberPageReturn.getMemberNoGm());
    		addComTask.setMerchantNo(merchantNo);
    		addComTask.setMemberNo(memberNo);
    		addComTask.setMemberName(findPersonMemberPageReturn.getMemberName());
    		addComTask.setWorkDate(now);
    		String cfNo ="";
    		
    		/*获取跟进编号*/
    		FindClientFollowSummary findClientFollowSummary = new FindClientFollowSummary();
			findClientFollowSummary.setMerchantNo(merchantNo);
			findClientFollowSummary.setMemberNoGm(memberNoGm);
			findClientFollowSummary.setMemberNo(memberNo);
			FindClientFollowSummaryReturn findClientFollowSummaryReturn = clientFollowSummaryService.findClientFollowSummaryLast(findClientFollowSummary);
			if(findClientFollowSummaryReturn != null){
				logger.debug("查询跟进总表中导购和客户最后一条记录: "+ findClientFollowSummaryReturn);
				cfNo = findClientFollowSummaryReturn.getCfNo();
				if(findClientFollowSummaryReturn.getEndDate() != null){
					throw new TsfaServiceException(com.lj.business.cf.constant.ErrorCode.CLIENT_FOLLOW_DATA_COMMON_ERROR,"跟进数据错误！");
				}
			}
    		addComTask.setCfNo(cfNo);
    		addComTask.setNoType(FollowNoType.FOLLOW.toString());
    		
    		/*获取项目Code*/
    		FindComTaskList findComTaskList = new FindComTaskList();
			findComTaskList.setMerchantNo(merchantNo);
			findComTaskList.setComTaskType(ComTaskType.INVITE);
			FindComTaskListReturn findComTaskListReturn = comTaskListService.findComTaskList(findComTaskList);
			if(findComTaskListReturn != null){
				addComTask.setCodeList(findComTaskListReturn.getCode());
			}
			addComTask.setComTaskType(ComTaskType.INVITE);
			addComTask.setRemarkCom(CommonConstant.REPLACE_REMARK_COM + "活动邀约");//任务备注
			addComTask.setLastResultDate(new Date());
    		comTaskService.addComTaskWithFinish(addComTask, "0");
		}
    }


	
	
}
