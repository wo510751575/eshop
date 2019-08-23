package com.lj.business.member.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;
import java.util.Map;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.dto.AddShop;
import com.lj.business.member.dto.AddShopReturn;
import com.lj.business.member.dto.DelShop;
import com.lj.business.member.dto.DelShopReturn;
import com.lj.business.member.dto.FindShop;
import com.lj.business.member.dto.FindShopDetail;
import com.lj.business.member.dto.FindShopDetailReturn;
import com.lj.business.member.dto.FindShopDto;
import com.lj.business.member.dto.FindShopPage;
import com.lj.business.member.dto.FindShopPageReturn;
import com.lj.business.member.dto.FindShopReturn;
import com.lj.business.member.dto.FindShopReturnAreaCode;
import com.lj.business.member.dto.UpdateShop;
import com.lj.business.member.dto.UpdateShopReturn;


/**
 * 类说明：接口类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 彭阳
 * 
 * 
 * CreateDate: 2017-06-14
 */
public interface IShopService {
	
	
	
	/**
	 * 
	 *
	 * 方法说明：门店详情_H5
	 *
	 * @param findShopDetail
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年8月1日
	 *
	 */
	public FindShopDetailReturn findShopDetail(FindShopDetail findShopDetail) throws TsfaServiceException;
	
	
	/**
	 * 方法说明：添加门店信息.
	 *
	 * @param addShop the add shop
	 * @return the adds the shop return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public AddShopReturn addShop(AddShop addShop) throws TsfaServiceException;
	
	/**
	 * 方法说明：查找门店信息.
	 *
	 * @param findShop the find shop
	 * @return the find shop return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public FindShopReturn findShop(FindShop findShop) throws TsfaServiceException;
	
	
	/**
	 * 方法说明：删除门店信息.
	 *
	 * @param delShop the del shop
	 * @return the del shop return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public DelShopReturn delShop(DelShop delShop) throws TsfaServiceException;

	/**
	 * 方法说明：修改门店信息.
	 *
	 * @param updateShop the update shop
	 * @return the update shop return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public UpdateShopReturn updateShop(UpdateShop updateShop)throws TsfaServiceException;

	/**
	 * 方法说明：查找门店信息.
	 *
	 * @param findShopPage the find shop page
	 * @return the page< find shop page return>
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public Page<FindShopPageReturn> findShopPage(FindShopPage findShopPage) throws TsfaServiceException;
	
	/**
	 * 方法说明：查询门店列表.
	 *
	 * @param findShop the find shop
	 * @return the list< find shop return>
	 * @author 段志鹏 CreateDate: 2017年7月11日
	 */
	public List<FindShopPageReturn> findShops(FindShop findShop);

	/**
	 * 
	 *
	 * 方法说明：统计数量
	 *
	 * @param findShopPage
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月26日
	 *
	 */
	int findShopCount(FindShopPage findShopPage);
	
	/**
	 * 
	 *
	 * 方法说明：统计根据条件
	 *
	 * @param parmMap
	 * 	memberNoMerchant：商户编号
	 * @return
	 *	shopTotle：门店总数
	 *	guidTotle：导购总数
	 *	maleGuid：男性导购
	 *	femaleGuid：女性导购
	 *	unknownGuid：未知性别导购
	 *	managerTotle：管理人员总数
	 *	maleManager：男性管理人员
	 *	femaleManager：女性管理人员
	 *	unknownManager：未知性别管理人员
	 * @author 段志鹏 CreateDate: 2017年7月26日
	 *
	 */
	Map<String,Object> countByCondition(Map<String,Object> parmMap);
	
	/**
	 * 
	 *
	 * 方法说明：月度新开门店
	 *
	 * @param findShop
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月1日
	 *
	 */
	public List<FindShopPageReturn> findMonthOpen(FindShop findShop);
	
	/**
	 *
	 *
	 * 方法说明：门店列表导出
	 *
	 * @param findShopPage
	 * @return
	 *
	 * @author 刘培 CreateDate: 2017年8月10日
	 *
	 */
	public List<FindShopPageReturn> findShopsExport(FindShopPage findShopPage);

	/**
	 * 
	 *
	 * 方法说明：根据分店编号查询分店
	 *
	 * @param findShop
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月3日
	 *
	 */
	public FindShopReturn findShopByShopNo(FindShop findShop) throws TsfaServiceException ;
	/**
	 * 
	 *
	 * 方法说明：根据商户编号查询
	 *
	 * @param findShopDetail
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月4日
	 *
	 */
	public List<FindShopReturnAreaCode>selectByAreaCode(FindShopDto findShopDto)throws TsfaServiceException;
	/**
	 * 
	 *
	 * 方法说明：根据商户下区域或省统计门店数量
	 *
	 * @param findShopDto
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月7日
	 *
	 */
	public  int findShopCounts(FindShopDto findShopDto);
	
	/**
	 * 
	 *
	 * 方法说明：H5获取只有门店的城市接口
	 *	merchantNo：商户编号
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月9日
	 *
	 */
	public List<Map<String,Object>> findGroupByCity(Map<String,Object> parmMap);



	/**
	 * 根据商户编号列表查询商户
	 * @param shopNoList
	 * @return
	 */
	List<FindShopPageReturn> selectByShopNoList(List<String> shopNoList);
	/**
	 * 
	 *
	 * 方法说明：查询所有省份code(唯一)
	 *
	 * @param findShopDto
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月19日
	 *
	 */
	public  List<FindShopReturnAreaCode>  selectByProvinceCode(FindShopDto findShopDto);
	/**
	 * 
	 *
	 * 方法说明：查询所有区域(唯一)
	 *
	 * @param findShopDto
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月19日
	 *
	 */
	public  List<FindShopReturnAreaCode>  findAreaCode(FindShopDto findShopDto);

	/**
	 * 
	 *
	 * 方法说明：根据区域查询门店
	 *
	 * @param findShopDto
	 * @return
	 *
	 * @author 梅宏博 CreateDate: 2017年8月31日
	 *
	 */
	public List<FindShopReturnAreaCode> findShopByAreaCode(FindShopDto findShopDto);
	
     /**
      * 
      *
      * 方法说明：查询所有员工数量，去除重复
      *
      * @param map
      * @return
      *
      * @author 罗书明 CreateDate: 2017年9月1日
      *
      */
	public List<Map<String,Object>> findCountBySize(Map<String,Object> map);
	
   /**
    * 
    *
    * 方法说明：查询门店类型
    *
    * @param findShop
    * @return
    *
    * @author 罗书明 CreateDate: 2017年9月9日
    *
    */
   public  List<FindShopPageReturn> findShopType(FindShop findShop);
   /**
    * 
    *
    * 方法说明：查询门店编号
    *
    * @param findShop
    * @return
    *
    * @author 罗书明 CreateDate: 2017年9月11日
    *
    */
   public FindShopPageReturn findShopNoByCode(FindShop findShop);
   
   /**
    * 方法说明：通过商户号找店。
    *
    * @param findShop.memberNoMerchant 必填
    * @return
    * @throws TsfaServiceException
    *
    * @author lhy  2017年9月20日
    *
    */
   public FindShopPageReturn findShopByMerchantNo_ec(FindShop findShop)  throws TsfaServiceException ;
  
}
