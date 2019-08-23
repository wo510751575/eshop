package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.OrderDetail;
import com.lj.eshop.dto.FindOrderDetailPage;
import com.lj.eshop.dto.OrderDetailDto;

public interface IOrderDetailDao {
    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(OrderDetail record);

    List<OrderDetailDto> findOrderDetailPage(FindOrderDetailPage findOrderDetailPage);

   	int findOrderDetailPageCount(FindOrderDetailPage findOrderDetailPage);
   	
   	List<OrderDetailDto> findOrderDetails(FindOrderDetailPage findOrderDetailPage);
}