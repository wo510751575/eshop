package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.Flag;
import com.lj.eshop.dto.FindFlagPage;
import com.lj.eshop.dto.FlagDto;

public interface IFlagDao {
    int insertSelective(Flag record);

    Flag selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Flag record);
    
    List<FlagDto> findFlagPage(FindFlagPage findFlagPage);

   	int findFlagPageCount(FindFlagPage findFlagPage);
   	
   	List<FlagDto> findFlags(FindFlagPage findFlagPage);
}