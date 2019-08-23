package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.MemberRankDto;
import com.lj.eshop.dto.FindMemberRankPage;


import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;

import java.util.List;
/**
 * 类说明：会员特权
 * 
 * <p>
 * 
 * @Company: 领居科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年8月30日 
 */
public interface IMemberRankService {
	
	/**
	 * 
	 *
	 * 方法说明：添加商品规格信息
	 *
	 * @param memberRankDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addMemberRank(MemberRankDto memberRankDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找商品规格信息
	 *
	 * @param findMemberRank
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public MemberRankDto findMemberRank(MemberRankDto memberRankDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询商品规格信息
	 *
	 * @param findMemberRankPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<MemberRankDto>  findMemberRanks(FindMemberRankPage findMemberRankPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改商品规格信息
	 *
	 * @param updateMemberRank
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateMemberRank(MemberRankDto memberRankDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询商品规格信息
	 *
	 * @param findMemberRankPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<MemberRankDto> findMemberRankPage(FindMemberRankPage findMemberRankPage) throws TsfaServiceException;
	

}
