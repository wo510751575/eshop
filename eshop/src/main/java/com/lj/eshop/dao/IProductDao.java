package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.Product;
import com.lj.eshop.dto.FindProductPage;
import com.lj.eshop.dto.ProductDto;
import com.lj.eshop.dto.UpdateProductCntDto;

public interface IProductDao {
    int insertSelective(Product record);

    Product selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Product record);
    
    List<ProductDto> findProductPage(FindProductPage findProductPage);

   	int findProductPageCount(FindProductPage findProductPage);
   	
   	List<ProductDto> findProducts(FindProductPage findProductPage);
   	
   	/** 重新计算产品的库存总数*/
   	int updateProdcutCnt(Product recode);
   	
   	/** 小B商品查询 */
   	List<ProductDto> findIndexProductPage(FindProductPage findProductPage);
   	/** 小B商品查询总数 */
   	int findIndexProductPageCount(FindProductPage findProductPage);
   	/** 根据商品统计类型累加统计次数。 */
   	int updateProductCntByType(UpdateProductCntDto updateProductCntDto);
}