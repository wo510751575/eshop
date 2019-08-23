package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.Catalog;
import com.lj.eshop.dto.CatalogDto;
import com.lj.eshop.dto.FindCatalogPage;

public interface ICatalogDao {
    int insertSelective(Catalog record);

    Catalog selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Catalog record);
    
    List<CatalogDto> findCatalogPage(FindCatalogPage catalogPage);

  	int findCatalogPageCount(FindCatalogPage catalogPage);
  	
  	List<CatalogDto> findCatalogs(FindCatalogPage catalogPage);
}