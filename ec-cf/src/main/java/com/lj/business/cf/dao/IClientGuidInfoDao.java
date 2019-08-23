package com.lj.business.cf.dao;

import com.lj.business.cf.domain.ClientGuidInfo;
import com.lj.business.cf.dto.FindAddGuidInfoRecordDto;

public interface IClientGuidInfoDao {
    int deleteByPrimaryKey(String code);

    int insert(ClientGuidInfo record);

    int insertSelective(ClientGuidInfo record);

    ClientGuidInfo selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(ClientGuidInfo record);

    int updateByPrimaryKey(ClientGuidInfo record);
    
    int guidInfoRecordCount(FindAddGuidInfoRecordDto findAddGuidInfoRecordDto);
}