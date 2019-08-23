package com.lj.eshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lj.eshop.domain.MyColl;
import com.lj.eshop.dto.FindMyCollPage;
import com.lj.eshop.dto.MyCollDto;

public interface IMyCollDao {
    int insertSelective(MyColl record);
    
    int updateByPrimaryKeySelective(MyColl record);
    
    List<MyCollDto> findMyCollPage(FindMyCollPage findMyCollPage);

   	int findMyCollPageCount(FindMyCollPage findMyCollPage);
   	
   	List<MyCollDto> findMyColls(FindMyCollPage findMyCollPage);

	/** 小B商品查询 */
   	List<MyCollDto> findIndexProductPage(FindMyCollPage findMyCollPage);
   	/** 小B商品查询总数 */
   	int findIndexProductPageCount(FindMyCollPage findMyCollPage);
   	/** 根据产品code删除我的收藏 */
	void delMycoll(String[] codes);

	/** 根据产品code和会员code返回是否收藏状态 */
	Integer getCollStatus(@Param("productCode")String code, @Param("mbrCode")String loginMemberCode);

	void delColl(@Param("mbrCode")String loginMemberCode, @Param("productCode")String code);
}