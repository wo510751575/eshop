package com.lj.business.member.dao;

import com.lj.business.member.domain.IntegralSet;
import com.lj.business.member.dto.integralSet.FindIntegralSet;
import com.lj.business.member.dto.integralSet.FindIntegralSetReturn;

public interface IIntegralSetDao {
    int deleteByPrimaryKey(String code);

    int insert(IntegralSet record);

    int insertSelective(IntegralSet record);

    IntegralSet selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(IntegralSet record);

    int updateByPrimaryKey(IntegralSet record);
    
    FindIntegralSetReturn findIntegralSetByType(FindIntegralSet findIntegralSet);
    
}