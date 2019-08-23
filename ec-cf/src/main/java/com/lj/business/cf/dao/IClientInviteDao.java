package com.lj.business.cf.dao;

import java.util.List;
import java.util.Map;

import com.lj.business.cf.domain.ClientInvite;
import com.lj.business.cf.dto.FindAddInviteRecordDto;

public interface IClientInviteDao {
    int deleteByPrimaryKey(String code);

    int insertSelective(ClientInvite record);

    ClientInvite selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(ClientInvite record);
    
    List<Map<String,Object>> findInviteResults(Map<String,Object> parmMap);
    
    int inviteRecordCount(FindAddInviteRecordDto findAddInviteRecordDto);
    
}