package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.ShopBgImg;
import com.lj.eshop.dto.FindShopBgImgPage;
import com.lj.eshop.dto.ShopBgImgDto;

public interface IShopBgImgDao {
    int insertSelective(ShopBgImg record);

    ShopBgImg selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(ShopBgImg record);
    
    List<ShopBgImgDto> findShopBgImgPage(FindShopBgImgPage findShopBgImgPage);

   	int findShopBgImgPageCount(FindShopBgImgPage findShopBgImgPage);
   	
   	List<ShopBgImgDto> findShopBgImgs(FindShopBgImgPage findShopBgImgPage);
}