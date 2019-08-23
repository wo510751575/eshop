package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.ShopStyle;
import com.lj.eshop.dto.FindShopStylePage;
import com.lj.eshop.dto.ShopStyleDto;

public interface IShopStyleDao {
    int insertSelective(ShopStyle record);

    ShopStyle selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(ShopStyle record);
    
    List<ShopStyleDto> findShopStylePage(FindShopStylePage findShopStylePage);

   	int findShopStylePageCount(FindShopStylePage findShopStylePage);
   	
   	List<ShopStyleDto> findShopStyles(FindShopStylePage findShopStylePage);
}