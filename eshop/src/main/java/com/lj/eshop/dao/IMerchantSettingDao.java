package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.MerchantSetting;
import com.lj.eshop.dto.FindMerchantSettingPage;
import com.lj.eshop.dto.MerchantSettingDto;

public interface IMerchantSettingDao {
    int insertSelective(MerchantSetting record);

    MerchantSetting selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(MerchantSetting record);

    List<MerchantSettingDto> findMerchantSettingPage(FindMerchantSettingPage findMerchantSettingPage);

   	int findMerchantSettingPageCount(FindMerchantSettingPage findMerchantSettingPage);
   	
   	List<MerchantSettingDto> findMerchantSettings(FindMerchantSettingPage findMerchantSettingPage);
}