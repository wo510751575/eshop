package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.EvlProduct;
import com.lj.eshop.dto.EvlProductDto;
import com.lj.eshop.dto.FindEvlProductPage;

public interface IEvlProductDao {

    int insertSelective(EvlProduct record);

    EvlProduct selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(EvlProduct record);
    
    List<EvlProductDto> findEvlProductPage(FindEvlProductPage findEvlProductPage);

   	int findEvlProductPageCount(FindEvlProductPage findEvlProductPage);
   	
   	List<EvlProductDto> findEvlProducts(FindEvlProductPage findEvlProductPage);
}