package com.lj.eshop.dao;

import java.math.BigDecimal;
import java.util.List;

import com.lj.eshop.domain.AccWater;
import com.lj.eshop.dto.AccWaterDto;
import com.lj.eshop.dto.FindAccWaterPage;

public interface IAccWaterDao {
    int insertSelective(AccWater record);

    AccWater selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(AccWater record);
    
    List<AccWaterDto> findAccWaterPage(FindAccWaterPage findAccWaterPage);

 	int findAccWaterPageCount(FindAccWaterPage findAccWaterPage);
 	
 	List<AccWaterDto> findAccWaters(FindAccWaterPage findAccWaterPage);
 	
	BigDecimal findIncomeAmt(FindAccWaterPage findAccWaterPage);
	
	List<AccWaterDto> findAcctWaterDetailPage(FindAccWaterPage findAccWaterPage);
	
	int findAcctWaterDetailPageCount(FindAccWaterPage findAccWaterPage);
	
	List<AccWaterDto> findAllAcctWaterDetailPage(FindAccWaterPage findAccWaterPage);
	
	int findAllAcctWaterDetailPageCount(FindAccWaterPage findAccWaterPage);
	
}