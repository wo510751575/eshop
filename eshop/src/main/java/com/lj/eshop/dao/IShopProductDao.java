package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.ShopProduct;
import com.lj.eshop.dto.FindShopProductPage;
import com.lj.eshop.dto.ShopProductDto;

public interface IShopProductDao {
    int insertSelective(ShopProduct record);

    ShopProduct selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(ShopProduct record);
    
    List<ShopProductDto> findShopProductPage(FindShopProductPage findShopProductPage);

   	int findShopProductPageCount(FindShopProductPage findShopProductPage);
   	
   	List<ShopProductDto> findShopProducts(FindShopProductPage findShopProductPage);
   	
   	List<ShopProductDto> findIndexProductPage(FindShopProductPage findShopProductPage);
   	
   	int findIndexProductPageCount(FindShopProductPage findShopProductPage);
}