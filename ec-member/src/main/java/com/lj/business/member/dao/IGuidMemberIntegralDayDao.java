package com.lj.business.member.dao;

import java.util.List;

import com.lj.business.member.domain.GuidMemberIntegralDay;
import com.lj.business.member.dto.guidMemberIntegralDay.FindGuidMemberIntegralDay;
import com.lj.business.member.dto.guidMemberIntegralDay.FindGuidMemberIntegralDayReturn;

public interface IGuidMemberIntegralDayDao {
    int deleteByPrimaryKey(String code);

    int insert(GuidMemberIntegralDay record);

    int insertSelective(GuidMemberIntegralDay record);

    GuidMemberIntegralDay selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(GuidMemberIntegralDay record);
    
    int updateByPrimaryKey(GuidMemberIntegralDay record);
    
    FindGuidMemberIntegralDayReturn findByDaySt(FindGuidMemberIntegralDay findGuidMemberIntegralDay);
    
    List<FindGuidMemberIntegralDayReturn> findByDayStList(FindGuidMemberIntegralDay findGuidMemberIntegralDay);

	double findMemberScoreSum(FindGuidMemberIntegralDay findGuidMemberIntegralDay);
}