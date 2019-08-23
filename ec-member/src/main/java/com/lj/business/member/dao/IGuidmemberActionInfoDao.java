package com.lj.business.member.dao;

import java.util.List;

import com.lj.business.member.domain.GuidmemberActionInfo;
import com.lj.business.member.dto.FindGuidmemberActionInfoListDto;
import com.lj.business.member.dto.guidmemberActionInfo.FindGuidmemberActionInfoReturn;

public interface IGuidmemberActionInfoDao {
    int deleteByPrimaryKey(String code);

    int insert(GuidmemberActionInfo record);

    int insertSelective(GuidmemberActionInfo record);

    GuidmemberActionInfo selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(GuidmemberActionInfo record);

    int updateByPrimaryKey(GuidmemberActionInfo record);
    
    List<FindGuidmemberActionInfoReturn> findGuidmemberActionInfoList(FindGuidmemberActionInfoListDto findGuidmemberActionInfoListDto);
}