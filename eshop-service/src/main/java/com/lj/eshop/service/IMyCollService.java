package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.MyCollDto;
import com.lj.eshop.dto.FindMyCollPage;
import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;

import java.util.List;
/**
 * 类说明：接口类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author lhy
 * 
 * 
 * CreateDate: 2017-08-22
 */
public interface IMyCollService {
	
	/**
	 * 
	 *
	 * 方法说明：添加我的收藏信息
	 *
	 * @param myCollDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addMyColl(MyCollDto myCollDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找我的收藏信息
	 *
	 * @param findMyColl
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public MyCollDto findMyColl(MyCollDto myCollDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询我的收藏信息
	 *
	 * @param findMyCollPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<MyCollDto>  findMyColls(FindMyCollPage findMyCollPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改我的收藏信息
	 *
	 * @param updateMyColl
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateMyColl(MyCollDto myCollDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询我的收藏信息
	 *
	 * @param findMyCollPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<MyCollDto> findMyCollPage(FindMyCollPage findMyCollPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：分页查询我的收藏信息(关联多表信息)
	 *
	 * @param findMyCollProductPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭俊霖 CreateDate: 2017-09-06
	 *
	 */
	public Page<MyCollDto> findMyCollProductPage(FindMyCollPage findMyCollPage);

	/**
	 * 
	 *
	 * 方法说明：根据产品code删除我的收藏
	 *
	 * @param delMycoll
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭俊霖 CreateDate: 2017-09-06
	 *
	 */
	public void delMycoll(String[] codes);

	/**
	 * 
	 *
	 * 方法说明：根据产品code和会员code返回是否收藏状态
	 *
	 * @param 
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭俊霖 CreateDate: 2017-09-09
	 *
	 */
	public Integer getCollStatus(String code, String loginMemberCode);

	/**
	 * 
	 *
	 * 方法说明：根据产品code和会员code删除我的收藏
	 *
	 * @param 
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭俊霖 CreateDate: 2017-09-14
	 *
	 */
	public void delColl(String loginMemberCode, String code);
	

}
