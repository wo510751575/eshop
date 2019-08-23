package com.lj.eshop.cf.service.impl;

import org.springframework.stereotype.Service;

import com.lj.eshop.cf.service.ITestCfService;

/**
 * 
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
public class TestCfServiceImpl implements ITestCfService {

	/* (non-Javadoc)
	 * @see com.lj.eshop.cf.serivce.ITestCfService#test(java.lang.String)
	 */
	@Override
	public String test(String who) {
		// TODO Auto-generated method stub
		return "hello,"+who;
	}

}
