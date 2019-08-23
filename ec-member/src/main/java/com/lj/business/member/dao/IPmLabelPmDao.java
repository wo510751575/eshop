package com.lj.business.member.dao;

import java.util.List;
import java.util.Map;

import com.lj.business.member.domain.PmLabelPm;

public interface IPmLabelPmDao {
    int deleteByPrimaryKey(String code);

    int insert(PmLabelPm record);

    int insertSelective(PmLabelPm record);

    PmLabelPm selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(PmLabelPm record);

    int updateByPrimaryKey(PmLabelPm record);
    
    
    List<Map<String,String>> findPmLabelByMemberNo(Map<String,String> parmap);
}