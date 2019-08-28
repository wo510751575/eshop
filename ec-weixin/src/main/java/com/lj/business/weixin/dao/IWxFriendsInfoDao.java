package com.lj.business.weixin.dao;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.business.weixin.domain.WxFriendsInfo;
import com.lj.business.weixin.dto.FindWxFriendsInfoPage;
import com.lj.business.weixin.dto.FindWxFriendsInfoPageReturn;
/**
 * 
 * @ClassName: IWxFriendsInfoDao
 * @Company: 深圳扬恩科技有限公司
 * @Description: 微信朋友圈信息表dao层接口
 * @author 罗书明
 * @date 2017年6月15日 上午9:33:10
 */
public interface IWxFriendsInfoDao {

	/**
     * 
     *
     * 方法说明：新增插入方法
     *
     * @param record
     * @return
     *
     * @author 罗书明 CreateDate: 2017年7月14日
     *
     */
    int insertSelective(WxFriendsInfo record);
    /**
     * 
     *
     * 方法说明：
     *
     * @param id
     * @return
     *
     * @author 罗书明 CreateDate: 2017年7月14日
     *
     */
    WxFriendsInfo selectByPrimaryKey(String code);
    /**
     * 
     *
     * 方法说明：更新修改方法
     *
     * @param record
     * @return
     *
     * @author 罗书明 CreateDate: 2017年7月14日
     *
     */
    int updateByPrimaryKeySelective(WxFriendsInfo record);
    /**
     * 
     *
     * 方法说明：分页查询
     *
     * @param findWxFriendsInfoPage
     * @return
     *
     * @author 罗书明 CreateDate: 2017年7月14日
     *
     */
    List<FindWxFriendsInfoPageReturn> findWxFriendsInfoPage(FindWxFriendsInfoPage findWxFriendsInfoPage);
     /**
      * 
      *
      * 方法说明：查询数量
      *
      * @param findWxFriendsInfoPage
      * @return
      *
      * @author 罗书明 CreateDate: 2017年7月14日
      *
      */
   	int findWxFriendsInfoPageCount(FindWxFriendsInfoPage findWxFriendsInfoPage);
    
}