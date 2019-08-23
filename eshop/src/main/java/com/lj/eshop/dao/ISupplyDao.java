package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.Supply;
import com.lj.eshop.dto.FindSupplyPage;
import com.lj.eshop.dto.SupplyDto;

public interface ISupplyDao {
    int insertSelective(Supply record);

    Supply selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Supply record);
    
    List<SupplyDto> findSupplyPage(FindSupplyPage findSupplyPage);

   	int findSupplyPageCount(FindSupplyPage findSupplyPage);
   	
   	List<SupplyDto> findSupplys(FindSupplyPage findSupplyPage);
}