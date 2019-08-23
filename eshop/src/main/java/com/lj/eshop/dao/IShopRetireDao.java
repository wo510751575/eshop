package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.ShopRetire;
import com.lj.eshop.dto.FindShopRetirePage;
import com.lj.eshop.dto.ShopRetireDto;

public interface IShopRetireDao {

    int insertSelective(ShopRetire record);
    
    int updateByPrimaryKeySelective(ShopRetire shopRetire);
    
    ShopRetire selectByPrimaryKey(String code);
    
    List<ShopRetireDto> findShopRetirePage(FindShopRetirePage findShopRetirePage);

   	int findShopRetirePageCount(FindShopRetirePage findShopRetirePage);
   	
   	List<ShopRetireDto> findShopRetires(FindShopRetirePage findShopRetirePage);
}