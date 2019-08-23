package com.lj.eshop.member.service.impl;

import org.springframework.stereotype.Service;

import com.lj.eshop.member.service.ITestMemberService;

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
 * CreateDate: 2017年9月14日
 */
@Service
public class TestMemberServiceImpl implements ITestMemberService {

	/* (non-Javadoc)
	 * @see com.lj.eshop.cf.serivce.ITestCfService#test(java.lang.String)
	 */
	@Override
	public String test(String who) {
		// TODO Auto-generated method stub
		return "hello,"+who;
	}

}
