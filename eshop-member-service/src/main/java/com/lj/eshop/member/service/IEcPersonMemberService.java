/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.member.service;

import java.util.List;

import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.dto.AddPersonMember;
import com.lj.business.member.dto.AddPersonMemberReturn;
import com.lj.business.member.dto.DoRepeatMemberDto;
import com.lj.business.member.dto.FindPersonMember;
import com.lj.business.member.dto.FindPersonMemberBaseReturn;
import com.lj.business.member.dto.FindPersonMemberReturn;
import com.lj.business.member.dto.UpdatePersonMember;
import com.lj.business.member.dto.UpdatePersonMemberReturn;

/**
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月18日
 */
public interface IEcPersonMemberService {
	/**
	 * 方法说明：添加客户表信息.
	 *
	 * @param addPersonMember
	 *            the add person member
	 * @return the adds the person member return
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 段志鹏 CreateDate: 2017年7月3日
	 */
	public AddPersonMemberReturn addPersonMember(AddPersonMember addPersonMember) throws TsfaServiceException;

	/**
	 * 方法说明：从勾子添加客户表信息.
	 *
	 * @param info
	 *            the info
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author rain CreateDate: 2017年7月12日
	 */
	public void addPersonMemberFromHook(String info) throws TsfaServiceException;
	

	/**
	 * 方法说明：修改客户表信息.
	 *
	 * @param updatePersonMember
	 *            the update person member
	 * @return the update person member return
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 段志鹏 CreateDate: 2017年7月3日
	 */
	public UpdatePersonMemberReturn updatePersonMember(UpdatePersonMember updatePersonMember) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：资料完成度
	 *
	 * @param findPersonMemberBaseReturn
	 * @param findPersonMemberReturn
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月17日
	 *
	 */
	void computeRate(FindPersonMemberBaseReturn findPersonMemberBaseReturn, FindPersonMemberReturn findPersonMemberReturn) throws TsfaServiceException;
	/**
	 * 
	 *
	 * 方法说明：处理交叉客户
	 *
	 * @param doRepeatMemberDto
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月14日
	 *
	 */
	void doRepeatMember(DoRepeatMemberDto doRepeatMemberDto) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：查找该客户是和导购关联过
	 *
	 * @param findPersonMember
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月17日
	 *
	 */
	public int findCountByMemberNo(FindPersonMember findPersonMember) throws TsfaServiceException;
	/**
	 * 
	 *
	 * 方法说明：查找客户list
	 *
	 * @param doRepeatMemberDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月14日
	 *
	 */
	List<FindPersonMemberReturn> findList(DoRepeatMemberDto doRepeatMemberDto) throws TsfaServiceException;

	/**
	 * 方法说明：根据客户号和导购号查询客户.
	 *
	 * @param findPersonMember
	 *            the find person member
	 * @return the find person member return
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 冯辉 CreateDate: 2017年7月11日
	 */
	public FindPersonMemberReturn findPersonMemberByMGM(FindPersonMember findPersonMember) throws TsfaServiceException;

}

