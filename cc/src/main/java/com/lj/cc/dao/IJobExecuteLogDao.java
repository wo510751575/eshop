package com.lj.cc.dao;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lj.cc.domain.JobExecuteLog;
import com.lj.cc.dto.JobExecuteLogParam;

/**
 * The Interface IJobExecuteLogDao.
 */
public interface IJobExecuteLogDao {
    
    /**
     * Delete by primary key.
     *
     * @param code the job execute id
     * @return the int
     */
    int deleteByPrimaryKey(String code);

    /**
     * Insert.
     *
     * @param record the record
     * @return the int
     */
    int insert(JobExecuteLog record);

    /**
     * Insert selective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(JobExecuteLog record);

    /**
     * Select by primary key.
     *
     * @param code the job execute id
     * @return the job execute log
     */
    JobExecuteLog selectByPrimaryKey(String code);

    /**
     * Update by primary key selective.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(JobExecuteLog record);

    /**
     * Update by primary key.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(JobExecuteLog record);
    
    /**
     * 方法说明：任务日志统计.
     *
     * @param param the param
     * @return the int
     * @author 彭阳
     * 
     * CreateDate: 2017-06-17
     */
    public int queryJobExecuteLogTotal(@Param("param") JobExecuteLogParam param);
    
    /**
     * 方法说明：任务日志分页查询.
     *
     * @param param the param
     * @return the list< job execute log>
     * @author 彭阳
     * 
     * CreateDate: 2017-06-17
     */
    public List<JobExecuteLog> queryJobExecuteLogList(@Param("param") JobExecuteLogParam param);
}