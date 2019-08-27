package com.lj.cc.service.impl;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.IPage;
import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.cc.common.ErrorCode;
import com.lj.cc.dao.IJobCenterDao;
import com.lj.cc.dao.IJobExecuteLogDao;
import com.lj.cc.domain.JobCenter;
import com.lj.cc.domain.JobExecuteLog;
import com.lj.cc.dto.FindJobCenter;
import com.lj.cc.dto.JobExecuteLogParam;
import com.lj.cc.service.IJobMgrService;

/**
 * 
 * 
 * 类说明：JOB服务管理
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 杨恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月15日
 */
@Service
public class JobMgrServiceImpl implements IJobMgrService {
	
	/** The log. */
	private static Logger log = LoggerFactory.getLogger(JobMgrServiceImpl.class);

	/** The job center dao. */
	@Resource
	private IJobCenterDao jobCenterDao;
	
	/** The job execute log dao. */
	@Resource
	private IJobExecuteLogDao jobExecuteLogDao;
	@Autowired
	private JobCenterFactory jobCenterFactory;
	
	/* (non-Javadoc)
	 * @see com.lj.cc.service.IJobMgrService#findAllJobCenter()
	 */
	@Override
	public List<JobCenter> findAllJobCenter() throws TsfaServiceException {
		try {
			return jobCenterDao.selectAllJobs();
		} catch(Exception e) {
			log.error("查询所有调度任务失败：", e);
			throw new TsfaServiceException(ErrorCode.CC_QUERY_ERROR, "查询所有调度任务失败：", e);
		}
	}

	/* (non-Javadoc)
	 * @see com.lj.cc.service.IJobMgrService#findJobExecuteLog(com.lj.cc.dto.JobExecuteLogParam)
	 */
	@Override
	public IPage<JobExecuteLog> findJobExecuteLog(JobExecuteLogParam param) throws TsfaServiceException {
		try {
			int count = jobExecuteLogDao.queryJobExecuteLogTotal(param);
			List<JobExecuteLog> list = null;
			if(count > 0) {
				list = jobExecuteLogDao.queryJobExecuteLogList(param);
			}
			return new Page<JobExecuteLog>(list, count, param, null);
		} catch(Exception e) {
			log.error("查询任务日志[" + param + "]失败: ", e);
			throw new TsfaServiceException(ErrorCode.CC_QUERY_ERROR, "查询任务日志[" + param + "]失败: ", e);
		}
	}

	/**
	 * 
	 *
	 * 方法说明：添加临时性任务
	 * 1、只适合那种只执行一次的任务
	 * 2、任务在执行前会删除任务缓存
	 *
	 * @param jc
	 * @throws TsfaServiceException
	 *
	 * @author 曾垂瑜 CreateDate: 2017年12月22日
	 *
	 */
	@Override
	public void addTempJob(JobCenter jc) throws TsfaServiceException{
		log.info("add Temp Job: {}", jc);
		jobCenterFactory.addTempJob(jc);
	}

	/**
	 * 
	 *
	 * 方法说明：删除临时性任务
	 *
	 * @param jobEnglishName
	 * @throws TsfaServiceException
	 *
	 * @author 曾垂瑜 CreateDate: 2018年3月27日
	 *
	 */
	@Override
	public void delTempJob(String jobEnglishName) throws TsfaServiceException {
		log.info("del Temp Job: {}", jobEnglishName);
		AssertUtils.notNullAndEmpty(jobEnglishName, "任务名称不能为空");
		jobCenterFactory.deleteTempJob(jobEnglishName);
	}

	@Override
	public IPage<JobCenter> queryJobList(FindJobCenter center) {
		List<JobCenter> list =null;
		int count =0 ;
		try {
			 count=jobCenterDao.queryJobExecuteLogCount(center);
			if(count > 0){
			 list=jobCenterDao.queryJobExecuteLogList(center);
			}
		
		} catch (Exception e) {
			log.error("分页查询失败！");
			throw new TsfaServiceException("queryJobExecuteLogList","分页查询失败！",e);
		}
		return new Page<JobCenter>(list, count, center, null);
	}
	
	@Override
	public void addJob(JobCenter jc)throws TsfaServiceException {
		log.debug("addJob(JobCenter jc = {})-start", jc);
		jobCenterDao.insert(jc);
		log.debug("addJob(JobCenter jc = {})-end", jc);
	}
}
