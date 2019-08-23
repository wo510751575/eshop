package com.lj.business.cm.dao;

import java.util.List;

import com.lj.business.cm.domain.MerchantParams;
import com.lj.business.cm.dto.merchantParams.FindMerchantParamsPage;
import com.lj.business.cm.dto.merchantParams.FindMerchantParamsPageReturn;

public interface IMerchantParamsDao {
    int deleteByPrimaryKey(String code);

    int insert(MerchantParams record);

    int insertSelective(MerchantParams record);

    MerchantParams selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(MerchantParams record);

    int updateByPrimaryKey(MerchantParams record);
    
    List<FindMerchantParamsPageReturn> findMerchantParamsPage(FindMerchantParamsPage findMerchantParamsPage);

   	int findMerchantParamsPageCount(FindMerchantParamsPage findMerchantParamsPage);
    
    
}