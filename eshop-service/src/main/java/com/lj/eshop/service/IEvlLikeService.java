package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.dto.EvlLikeDto;
import com.lj.eshop.dto.FindEvlLikePage;
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
public interface IEvlLikeService {
	
	/**
	 * 
	 *
	 * 方法说明：添加商品评价点赞记录信息
	 *
	 * @param evlLikeDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addEvlLike(EvlLikeDto evlLikeDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找商品评价点赞记录信息
	 *
	 * @param findEvlLike
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public EvlLikeDto findEvlLike(EvlLikeDto evlLikeDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询商品评价点赞记录信息
	 *
	 * @param findEvlLikePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<EvlLikeDto>  findEvlLikes(FindEvlLikePage findEvlLikePage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改商品评价点赞记录信息
	 *
	 * @param updateEvlLike
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateEvlLike(EvlLikeDto evlLikeDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询商品评价点赞记录信息
	 *
	 * @param findEvlLikePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<EvlLikeDto> findEvlLikePage(FindEvlLikePage findEvlLikePage) throws TsfaServiceException;
	
}
