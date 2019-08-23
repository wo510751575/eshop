package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.OrderRetireDetail;
import com.lj.eshop.dto.FindOrderRetireDetailPage;
import com.lj.eshop.dto.OrderRetireDetailDto;

public interface IOrderRetireDetailDao {
    int insertSelective(OrderRetireDetail record);

    OrderRetireDetail selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(OrderRetireDetail record);

    List<OrderRetireDetailDto> findOrderRetireDetailPage(FindOrderRetireDetailPage findOrderRetireDetailPage);

   	int findOrderRetireDetailPageCount(FindOrderRetireDetailPage findOrderRetireDetailPage);
   	
   	List<OrderRetireDetailDto> findOrderRetireDetails(FindOrderRetireDetailPage findOrderRetireDetailPage);
}

