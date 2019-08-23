package com.lj.business.member.dao;

import java.util.List;
import java.util.Map;

import com.lj.business.member.domain.PmTypePm;
import com.lj.business.member.dto.AddPmTypePmDto;
import com.lj.business.member.dto.FindPmTypePmListByMGMDto;
import com.lj.business.member.dto.FindPmTypePmListByMGMReturn;
import com.lj.business.member.dto.FindPmTypePmReturn;

public interface IPmTypePmDao {
	
    int deleteByPrimaryKey(String code);
    
    int deleteByParamKey(PmTypePm record);

    int insert(PmTypePm record);

    int insertSelective(PmTypePm record);

    PmTypePm selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(PmTypePm record);

    int updateByPrimaryKey(PmTypePm record);
    
    List<PmTypePm> selectByMemberNo(Map maps);
    
    FindPmTypePmReturn findByPmCodeAndPmTypeCode(AddPmTypePmDto addPmTypePmDto);
    
    List<FindPmTypePmListByMGMReturn> findPmTypePmListByMGM(FindPmTypePmListByMGMDto findPmTypePmListByMGMDto);
    
}