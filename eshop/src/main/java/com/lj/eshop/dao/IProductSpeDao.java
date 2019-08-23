package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.ProductSpe;
import com.lj.eshop.dto.FindProductSpePage;
import com.lj.eshop.dto.ProductSpeDto;

public interface IProductSpeDao {
    int insertSelective(ProductSpe record);

    ProductSpe selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(ProductSpe record);

    List<ProductSpeDto> findProductSpePage(FindProductSpePage findProductSpePage);

   	int findProductSpePageCount(FindProductSpePage findProductSpePage);
   	
   	List<ProductSpeDto> findProductSpes(FindProductSpePage findProductSpePage);
}