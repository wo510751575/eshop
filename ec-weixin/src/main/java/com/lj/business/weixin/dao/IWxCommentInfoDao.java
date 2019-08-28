package com.lj.business.weixin.dao;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.business.weixin.domain.WxCommentInfo;
import com.lj.business.weixin.dto.FindWxCommentInfoPage;
import com.lj.business.weixin.dto.FindWxCommentInfoPageReturn;

/**
 * 
 * 
 * 类说明：朋友圈评论
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年7月21日
 */
public interface IWxCommentInfoDao {
    /**
     * 
     *
     * 方法说明：新增插入
     *
     * @param record
     * @return
     *
     * @author 罗书明 CreateDate: 2017年7月14日
     *
     */
    int insertSelective(WxCommentInfo record);
    /**
     * 
     *
     * 方法说明：主键查询
     *
     * @param code
     * @return
     *
     * @author 罗书明 CreateDate: 2017年7月14日
     *
     */
    WxCommentInfo selectByPrimaryKey(String code);
     /**
      * 
      *
      * 方法说明：更新修改
      *
      * @param record
      * @return
      *
      * @author 罗书明 CreateDate: 2017年7月14日
      *
      */
    int updateByPrimaryKeySelective(WxCommentInfo record);
    /**
     * 
     *
     * 方法说明：分页查询
     *
     * @param findWxCommentInfoPage
     * @return
     *
     * @author 罗书明 CreateDate: 2017年7月14日
     *
     */
	List<FindWxCommentInfoPageReturn> findWxCommentInfoPage(FindWxCommentInfoPage findWxCommentInfoPage);
    /**
     * 
     *
     * 方法说明：查询数量
     *
     * @param findWxCommentInfoPage
     * @return
     *
     * @author 罗书明 CreateDate: 2017年7月14日
     *
     */
	int findWxCommentInfoPageCount(FindWxCommentInfoPage findWxCommentInfoPage);
	/**
	 * 
	 *
	 * 方法说明：获取列表，不分页
	 *
	 * @param findWxCommentInfoPage
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月24日
	 *
	 */
	List<FindWxCommentInfoPageReturn> findWxCommentInfos(FindWxCommentInfoPage findWxCommentInfoPage);
	
}