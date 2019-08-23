package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.RetireMime;
import com.lj.eshop.dto.FindRetireMimePage;
import com.lj.eshop.dto.RetireMimeDto;

public interface IRetireMimeDao {
    int insertSelective(RetireMime record);

    RetireMime selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(RetireMime record);
    
    List<RetireMimeDto> findRetireMimePage(FindRetireMimePage findRetireMimePage);

   	int findRetireMimePageCount(FindRetireMimePage findRetireMimePage);
   	
   	List<RetireMimeDto> findRetireMimes(FindRetireMimePage findRetireMimePage);
}