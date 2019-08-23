package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.ProductRule;
import com.lj.eshop.dto.FindProductRulePage;
import com.lj.eshop.dto.ProductRuleDto;

public interface IProductRuleDao {
    int insertSelective(ProductRule record);

    ProductRule selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(ProductRule record);

    List<ProductRuleDto> findProductRulePage(FindProductRulePage findProductRulePage);

   	int findProductRulePageCount(FindProductRulePage findProductRulePage);
   	
   	List<ProductRuleDto> findProductRules(FindProductRulePage findProductRulePage);
    
}