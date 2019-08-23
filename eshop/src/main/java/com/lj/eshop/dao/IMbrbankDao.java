package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.Mbrbank;
import com.lj.eshop.dto.FindMbrbankPage;
import com.lj.eshop.dto.MbrbankDto;

public interface IMbrbankDao {
    int insertSelective(Mbrbank record);

    Mbrbank selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Mbrbank record);

    List<MbrbankDto> findMbrbankPage(FindMbrbankPage findMbrbankPage);

   	int findMbrbankPageCount(FindMbrbankPage findMbrbankPage);
   	
   	List<MbrbankDto> findMbrbanks(FindMbrbankPage findMbrbankPage);
}