package com.lj.cc.dao;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lj.cc.domain.SystemParams;
import com.lj.cc.domain.SystemParamsKey;
import com.lj.cc.dto.FindSystemParam;


/**
 * 类说明：
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 彭阳
 * 
 * 
 * CreateDate: 2017-07-10
 */
public interface ISystemParamsDao {
	
	
	/**
	 * 方法说明：根据条件动态查询 .
	 *
	 * @param key the key
	 * @return the List
	 */
	List<SystemParams> selectByParameters(SystemParams key); 
    
    /**
     * 方法说明：deleteByPrimaryKey.
     *
     * @param key the key
     * @return the int
     */
    int deleteByPrimaryKey(SystemParamsKey key);

    /**
     * 方法说明：insert.
     *
     * @param record the record
     * @return the int
     */
    int insert(SystemParams record);

    /**
     * 方法说明：insertSelective.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(SystemParams record);

    /**
     * 方法说明：selectByPrimaryKey.
     *
     * @param key the key
     * @return the SystemParams
     */
    SystemParams selectByPrimaryKey(SystemParamsKey key);

    /**
     * 方法说明：updateByPrimaryKeySelective.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(SystemParams record);

    /**
     * 方法说明：updateByPrimaryKey.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(SystemParams record);
    
    /**
     * 方法说明：查询系统参数记录数.
     *
     * @param param the param
     * @return the long
     * @author 彭阳
     * 
     * CreateDate: 2017-06-10
     */
	public long querySystemParamsCount(@Param("param") FindSystemParam param);
	
	/**
	 * 方法说明：查询系统参数明细.
	 *
	 * @param param the param
	 * @return the list< system params>
	 * @author 彭阳
	 * 
	 * CreateDate: 2017-06-10
	 */
	public List<SystemParams> querySystemParamsList(@Param("param") FindSystemParam param);
	
	/**
	 * 方法说明：修改系统参数.
	 *
	 * @param systemParams the system params
	 * @return the int
	 * @author 彭阳
	 * 
	 * CreateDate: 2017-06-11
	 */
	public int updateSystemParam(SystemParams systemParams);
}