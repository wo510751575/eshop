package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.ShopCar;
import com.lj.eshop.dto.FindShopCarPage;
import com.lj.eshop.dto.ShopCarDto;

public interface IShopCarDao {
    int insertSelective(ShopCar record);

    ShopCar selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(ShopCar record);
    
    List<ShopCarDto> findShopCarPage(FindShopCarPage findShopCarPage);

   	int findShopCarPageCount(FindShopCarPage findShopCarPage);
   	
   	List<ShopCarDto> findShopCars(FindShopCarPage findShopCarPage);
   	
   	int deleteByPrimaryKey(String code);
}