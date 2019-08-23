package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.Shop;
import com.lj.eshop.dto.FindShopPage;
import com.lj.eshop.dto.ShopDto;

public interface IShopDao {
    int insertSelective(Shop record);

    Shop selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Shop record);

    List<ShopDto> findShopPage(FindShopPage findShopPage);

   	int findShopPageCount(FindShopPage findShopPage);
   	
   	List<ShopDto> findShops(FindShopPage findShopPage);
}