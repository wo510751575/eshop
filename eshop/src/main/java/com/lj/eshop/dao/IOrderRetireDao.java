package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.OrderRetire;
import com.lj.eshop.dto.FindOrderRetirePage;
import com.lj.eshop.dto.OrderRetireDto;

public interface IOrderRetireDao {
    int insertSelective(OrderRetire record);

    OrderRetire selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(OrderRetire record);

    List<OrderRetireDto> findOrderRetirePage(FindOrderRetirePage findOrderRetirePage);

   	int findOrderRetirePageCount(FindOrderRetirePage findOrderRetirePage);
   	
   	List<OrderRetireDto> findOrderRetires(FindOrderRetirePage findOrderRetirePage);

   	/**
   	 * 
   	 * 方法说明：bc端分页
   	 *
   	 * @param @param findOrderRetirePage
   	 * @param @return    设定文件 
   	 * @return List<OrderRetireDto>    返回类型 
   	 * @throws Exception
   	 *
   	 * @author 林进权
   	 *         CreateDate: 2017年9月5日
   	 */
	List<OrderRetireDto> findOrderRetirePage4BC(FindOrderRetirePage findOrderRetirePage);

	/**
	 * 方法说明：bc端分页
	 * 方法说明：
	 *
	 * @param @param findOrderRetirePage
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws Exception
	 *
	 * @author 林进权
	 *         CreateDate: 2017年9月5日
	 */
	int findOrderRetirePageCount4BC(FindOrderRetirePage findOrderRetirePage);
}