package com.lj.cc.dao;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;

import com.lj.cc.domain.Holiday;
/**
 * 
 * @ClassName: IHolidayDao
 * @Company: 杨恩科技有限公司
 * @Description: 
 * @author 罗书明
 * @date 2017年6月16日 上午8:59:32
 */
public interface IHolidayDao {
    int deleteByPrimaryKey(Long id);

    int insert(Holiday record);
    
    int replace(Holiday record);

    int insertSelective(Holiday record);

    Holiday selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Holiday record);

    int updateByPrimaryKey(Holiday record);
    
    String selectByDayStr(String dayStr);
    
    String selectByDayDate(Date dayDate);
}