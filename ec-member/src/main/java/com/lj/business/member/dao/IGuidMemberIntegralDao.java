package com.lj.business.member.dao;

import java.util.List;

import com.lj.business.member.domain.GuidMemberIntegral;
import com.lj.business.member.dto.guidMemberIntegral.FindGuidMemberIntegral;
import com.lj.business.member.dto.guidMemberIntegral.FindGuidMemberIntegralReturn;

public interface IGuidMemberIntegralDao {
    int deleteByPrimaryKey(String code);

    int insert(GuidMemberIntegral record);

    int insertSelective(GuidMemberIntegral record);

    GuidMemberIntegral selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(GuidMemberIntegral record);

    int updateByPrimaryKey(GuidMemberIntegral record);
    
    List<FindGuidMemberIntegralReturn> findByIntegralType(FindGuidMemberIntegral findGuidMemberIntegral);
}