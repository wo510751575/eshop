package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.ProductRankPrice;
import com.lj.eshop.dto.FindProductRankPricePage;
import com.lj.eshop.dto.ProductRankPriceDto;

public interface IProductRankPriceDao {
	int deleteByPrimaryKey(String code);

	int insertSelective(ProductRankPrice record);

	ProductRankPrice selectByPrimaryKey(String code);

	int updateByPrimaryKeySelective(ProductRankPrice record);

	List<ProductRankPriceDto> findProductRankPrices(FindProductRankPricePage findProductRankPricePage);

	int findProductRankPricePageCount(FindProductRankPricePage findProductRankPricePage);

	List<ProductRankPriceDto> findProductRankPricePage(FindProductRankPricePage findProductRankPricePage);
}