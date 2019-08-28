package com.lj.eshop.dao;

import java.util.List;
import java.util.Map;

import com.lj.eshop.domain.Order;
import com.lj.eshop.dto.CatalogSummaryDto;
import com.lj.eshop.dto.FindOrderPage;
import com.lj.eshop.dto.OrderDto;

public interface IOrderDao {
    int insertSelective(Order record);

    Order selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Order record);

    List<OrderDto> findOrderPage(FindOrderPage findOrderPage);

   	int findOrderPageCount(FindOrderPage findOrderPage);
   	
   	List<OrderDto> findOrders(FindOrderPage findOrderPage);
   	
   	List<OrderDto> findOrderEisPage(FindOrderPage findOrderPage);
   	
   	int findOrderEisPageCount(FindOrderPage findOrderPage);
   	
   	double findAmtSum(FindOrderPage findOrderPage);

   	List<CatalogSummaryDto> findProductCatalog(FindOrderPage findOrderPage);
   	
   	/**获取店铺销售排名**/
	Integer findAmtRank(FindOrderPage findOrderPage);

	List<Map<String,Object>> findOrderGroupStatus(FindOrderPage findOrderPage);
 	
	CatalogSummaryDto findTopProductCatalog(FindOrderPage findOrderPage);
	
}