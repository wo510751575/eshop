package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.ProductImg;
import com.lj.eshop.dto.FindProductImgPage;
import com.lj.eshop.dto.ProductImgDto;

public interface IProductImgDao {
    int insertSelective(ProductImg record);

    ProductImg selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(ProductImg record);

    List<ProductImgDto> findProductImgPage(FindProductImgPage findProductImgPage);

   	int findProductImgPageCount(FindProductImgPage findProductImgPage);
   	
   	List<ProductImgDto> findProductImgs(FindProductImgPage findProductImgPage);
   	
   	int updateProductImgByProductCode(ProductImg record);

}