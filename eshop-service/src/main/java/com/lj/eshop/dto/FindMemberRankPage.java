package com.lj.eshop.dto;

import com.lj.base.core.pagination.PageParamEntity; 

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
public class FindMemberRankPage extends PageParamEntity { 
	private static final long serialVersionUID = 1L;
	// 查询条件
	private MemberRankDto param;
	public MemberRankDto getParam() {
		return param;
	}
	public void setParam(MemberRankDto param) {
		this.param = param;
	}

	// 动态排序条件 根据需要可自行补充
	// private .... sort;
	

}
