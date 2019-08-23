package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.ProductFlag;
import com.lj.eshop.dto.FindProductFlagPage;
import com.lj.eshop.dto.ProductFlagDto;

public interface IProductFlagDao {
    int insertSelective(ProductFlag record);

    ProductFlag selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(ProductFlag record);
    
    List<ProductFlagDto> findProductFlagPage(FindProductFlagPage findProductFlagPage);

   	int findProductFlagPageCount(FindProductFlagPage findProductFlagPage);
   	
   	List<ProductFlagDto> findProductFlags(FindProductFlagPage findProductFlagPage);
    
	int  deleteByProductCode(ProductFlag record);
}