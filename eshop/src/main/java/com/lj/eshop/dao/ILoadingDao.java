package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.Loading;
import com.lj.eshop.dto.FindLoadingPage;
import com.lj.eshop.dto.LoadingDto;

public interface ILoadingDao {
    int insertSelective(Loading record);

    Loading selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Loading record);

    List<LoadingDto> findLoadingPage(FindLoadingPage findLoadingPage);

   	int findLoadingPageCount(FindLoadingPage findLoadingPage);
   	
   	List<LoadingDto> findLoadings(FindLoadingPage findLoadingPage);
}