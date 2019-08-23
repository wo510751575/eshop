package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.Merchant;
import com.lj.eshop.dto.FindMerchantPage;
import com.lj.eshop.dto.MerchantDto;

public interface IMerchantDao {
    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Merchant record);

    List<MerchantDto> findMerchantPage(FindMerchantPage findMerchantPage);

   	int findMerchantPageCount(FindMerchantPage findMerchantPage);
   	
   	List<MerchantDto> findMerchants(FindMerchantPage findMerchantPage);
}