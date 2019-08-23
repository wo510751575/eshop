package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.CustOrder;
import com.lj.eshop.dto.CustOrderDto;
import com.lj.eshop.dto.FindCustOrderPage;

public interface ICustOrderDao {
    int insertSelective(CustOrder record);

    CustOrder selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(CustOrder record);

    List<CustOrderDto> findCustOrderPage(FindCustOrderPage findCustOrderPage);

   	int findCustOrderPageCount(FindCustOrderPage findCustOrderPage);
   	
   	List<CustOrderDto> findCustOrders(FindCustOrderPage findCustOrderPage);
}