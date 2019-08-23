package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.SumDimension;
import com.lj.eshop.dto.FindSumDimensionPage;
import com.lj.eshop.dto.SumDimensionDto;

public interface ISumDimensionDao {
    int insertSelective(SumDimension record);

    SumDimension selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(SumDimension record);
    
    List<SumDimensionDto> findSumDimensionPage(FindSumDimensionPage findSumDimensionPage);

   	int findSumDimensionPageCount(FindSumDimensionPage findSumDimensionPage);
   	
   	List<SumDimensionDto> findSumDimensions(FindSumDimensionPage findSumDimensionPage);
}