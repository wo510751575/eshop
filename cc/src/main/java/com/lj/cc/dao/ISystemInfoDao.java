package com.lj.cc.dao;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.cc.domain.SystemInfo;


/**
 * 类说明：
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author LeoPeng
 * 
 * 
 * CreateDate: 2017-07-10
 */
public interface ISystemInfoDao {
    
    /**
     * 方法说明：deleteByPrimaryKey.
     *
     * @param systemAliasName the system alias name
     * @return the int
     */
    int deleteByPrimaryKey(String systemAliasName);

    /**
     * 方法说明：insert.
     *
     * @param record the record
     * @return the int
     */
    int insert(SystemInfo record);

    /**
     * 方法说明：insertSelective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(SystemInfo record);

    /**
     * 方法说明：selectByPrimaryKey.
     *
     * @param systemAliasName the system alias name
     * @return the SystemInfo
     */
    SystemInfo selectByPrimaryKey(String systemAliasName);

    /**
     * 方法说明：updateByPrimaryKeySelective.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(SystemInfo record);

    /**
     * 方法说明：updateByPrimaryKey.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(SystemInfo record);
    
    /**
     * 方法说明：查询所有系统信息.
     *
     * @return the list< system info>
     * @author 彭阳
     * 
     * CreateDate: 2017-06-10
     */
    List<SystemInfo> queryAllSystemInfo();
}