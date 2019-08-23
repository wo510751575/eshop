package com.lj.business.member.dao;

import java.util.List;
import java.util.Map;

import com.lj.business.member.domain.Shop;
import com.lj.business.member.dto.FindShop;
import com.lj.business.member.dto.FindShopDto;
import com.lj.business.member.dto.FindShopPage;
import com.lj.business.member.dto.FindShopPageReturn;
import com.lj.business.member.dto.FindShopReturn;
import com.lj.business.member.dto.FindShopReturnAreaCode;

import org.apache.ibatis.annotations.Param;

public interface IShopDao {
    int deleteByPrimaryKey(String code);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(String code);
    
    Shop selectByShopNo(String shopNo);

    int updateByPrimaryKeySelective(Shop record);

	List<FindShopPageReturn> findShopPage(FindShopPage findShopPage);

	int findShopPageCount(FindShopPage findShopPage);
	
	List<FindShopPageReturn> findShops(FindShop findShop);
	
	Map<String,Object> countByCondition(Map<String,Object> parmMap);
	
	 List<FindShopReturnAreaCode>selectByAreaCode(FindShopDto findShopDto );
	 
	 int findShopCounts(FindShopDto findShopDto);
	 
	 List<Map<String,Object>> findGroupByCity(Map<String,Object> parmMap);

	List<FindShopPageReturn> findShopsExport(FindShopPage findShopPage);

	List<FindShopPageReturn> selectByShopNoList(@Param("shopNoList") List<String> shopNoList);
	
	 List<FindShopReturnAreaCode>  selectByProvinceCode(FindShopDto findShopDto);
	
	 List<FindShopReturnAreaCode>  findAreaCode(FindShopDto findShopDto);

	List<FindShopReturnAreaCode> findShopByAreaCode(FindShopDto findShopDto);
	 
	 List<Map<String,Object>> findCountBySize(Map<String,Object> map);
	 
	List<FindShopPageReturn> findShopType(FindShop findShop);
	
	
	List<FindShopPageReturn> findShopNoByCode(FindShop findShop);
	 
	 
}