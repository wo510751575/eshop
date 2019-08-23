package com.lj.eshop.service;

import java.math.BigDecimal;
import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.dto.FindMemberRankApplyPage;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.MemberRankApplyDto;
import com.lj.eshop.dto.PaymentDto;
/**
 * 类说明：接口类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 林进权
 * 
 * 
 * CreateDate: 2017-08-31
 */
public interface IMemberRankApplyService {
	
	/**
	 * 
	 *
	 * 方法说明：添加特权申请信息
	 *
	 * @param memberRankApplyDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-08-31
	 *
	 */
	public MemberRankApplyDto addMemberRankApply(MemberRankApplyDto memberRankApplyDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找特权申请信息
	 *
	 * @param findMemberRankApply
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-08-31
	 *
	 */
	public MemberRankApplyDto findMemberRankApply(MemberRankApplyDto memberRankApplyDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询特权申请信息
	 *
	 * @param findMemberRankApplyPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-08-31
	 *
	 */
	public List<MemberRankApplyDto>  findMemberRankApplys(FindMemberRankApplyPage findMemberRankApplyPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改特权申请信息
	 *
	 * @param updateMemberRankApply
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-08-31
	 *
	 */
	public void updateMemberRankApply(MemberRankApplyDto memberRankApplyDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询特权申请信息
	 *
	 * @param findMemberRankApplyPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-08-31
	 *
	 */
	public Page<MemberRankApplyDto> findMemberRankApplyPage(FindMemberRankApplyPage findMemberRankApplyPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：特权申请审核状态变更
	 *
	 * @param findMemberRankApplyPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017-08-31
	 *
	 */
	public void updateByPkAndStatus (MemberRankApplyDto memberRankApplyDto)throws TsfaServiceException;
	
	/**
	 * 支付成功后 回调 特权申请 处理
	 * 方法说明：
	 * @author 林进权 CreateDate: 2017年9月9日
	 *
	 */
	public void payment(PaymentDto paymentDto);
	
	/**
	 * 根据特权申请code查询金额 
	 * @param memberApplyCode 申请code
	 * 方法说明：
	 * @author 林进权 CreateDate: 2017年9月9日
	 *
	 */
	public BigDecimal queryAmt(String memberApplyCode);

}
