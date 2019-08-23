package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.SysSpe;
import com.lj.eshop.dto.FindSysSpePage;
import com.lj.eshop.dto.SysSpeDto;

public interface ISysSpeDao {
    int insertSelective(SysSpe record);

    SysSpe selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(SysSpe record);
    
    List<SysSpeDto> findSysSpePage(FindSysSpePage findSysSpePage);

 	int findSysSpePageCount(FindSysSpePage findSysSpePage);
 	
 	List<SysSpeDto> findSysSpes(FindSysSpePage findSysSpePage);
}