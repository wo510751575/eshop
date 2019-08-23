package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.dto.FindMemberPage;


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
public interface IMemberService {
	
	/**
	 * 
	 *
	 * 方法说明：添加会员信息
	 *
	 * @param memberDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public MemberDto addMember(MemberDto memberDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找会员信息
	 *
	 * @param findMember
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public MemberDto findMember(MemberDto memberDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询会员信息
	 *
	 * @param findMemberPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<MemberDto>  findMembers(FindMemberPage findMemberPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改会员信息
	 *
	 * @param updateMember
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateMember(MemberDto memberDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询会员信息
	 *
	 * @param findMemberPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<MemberDto> findMemberPage(FindMemberPage findMemberPage) throws TsfaServiceException;
	

}
