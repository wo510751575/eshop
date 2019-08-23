package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.Bill;
import com.lj.eshop.dto.BillDto;
import com.lj.eshop.dto.FindBillPage;

public interface IBillDao {

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Bill record);
    
    List<BillDto> findBillPage(FindBillPage catalogPage);

  	int findBillPageCount(FindBillPage catalogPage);
  	
  	List<BillDto> findBills(FindBillPage catalogPage);
}