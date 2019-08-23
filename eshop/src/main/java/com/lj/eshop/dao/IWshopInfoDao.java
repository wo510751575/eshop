package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.WshopInfo;
import com.lj.eshop.dto.FindWshopInfoPage;

public interface IWshopInfoDao {
    int insertSelective(WshopInfo record);

    WshopInfo selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(WshopInfo record);
    
    List<FindWshopInfoPage> findWshopInfoPage(FindWshopInfoPage findWshopInfoPage);

	int findWshopInfoPageCount(FindWshopInfoPage findWshopInfoPage);
	
	List<FindWshopInfoPage> findWshopInfos(FindWshopInfoPage findWshopInfoPage);
	
}