package com.lj.cc.dao;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lj.cc.domain.JobCenter;
import com.lj.cc.dto.FindJobCenter;

/**
 * 类说明：
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 彭阳
 * 
 * CreateDate: 2017-7-10
 */
public interface IJobCenterDao {
	
	/**
	 * 方法说明：.
	 *
	 * @param jobEnglishName the job english name
	 * @return the int
	 * @author 彭阳
	 */
    int deleteByPrimaryKey(String jobEnglishName);
    
    /**
     * Insert.
     *
     * @param record the record
     * @return the int
     */
    int insert(JobCenter record);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(JobCenter record);

    /**
     * Select by primary key.
     *
     * @param jobEnglishName the job english name
     * @return the job center
     */
    JobCenter selectByPrimaryKey(String jobEnglishName);

    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(JobCenter record);

    /**
     * Update by primary key.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(JobCenter record);
    
    /**
     * Select all jobs.
     *
     * @return the list< job center>
     */
    List<JobCenter> selectAllJobs();
    
    /**
     * 
     *
     * 方法说明：分页数
     *
     * @param jobCenter
     * @return
     *
     * @author 罗书明 CreateDate: 2017年10月19日
     *
     */
    int queryJobExecuteLogCount(@Param("param")FindJobCenter center );
    
    /**
     * 
     *
     * 方法说明：分页列表
     *
     * @param center
     * @return
     *
     * @author 罗书明 CreateDate: 2017年10月19日
     *
     */
    List<JobCenter> queryJobExecuteLogList(@Param("param") FindJobCenter center);
}