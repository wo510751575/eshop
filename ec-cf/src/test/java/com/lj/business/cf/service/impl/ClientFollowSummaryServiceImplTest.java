package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.DateUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.clientFollowSummary.AddClientFollowSummary;
import com.lj.business.cf.dto.clientFollowSummary.DelClientFollowSummary;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummary;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummaryPage;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummaryPageReturn;
import com.lj.business.cf.dto.clientFollowSummary.FindSuccessNum;
import com.lj.business.cf.dto.clientFollowSummary.UpdateClientFollowSummary;
import com.lj.business.cf.service.IClientFollowSummaryService;


/**
 * 类说明：测试类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 冯辉
 * 
 * 
 * CreateDate: 2017-06-14
 */
public class ClientFollowSummaryServiceImplTest extends SpringTestCase{

	@Resource
	IClientFollowSummaryService clientFollowSummaryService;



	/**
	 * 
	 *
	 * 方法说明：添加反馈信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addClientFollowSummary() throws TsfaServiceException{
		AddClientFollowSummary addClientFollowSummary = new AddClientFollowSummary();
		//add数据录入
		addClientFollowSummary.setCode("Code");
		addClientFollowSummary.setMerchantNo("MerchantNo");
		addClientFollowSummary.setMemberNo("MemberNo");
		addClientFollowSummary.setMemberName("MemberName");
		addClientFollowSummary.setMemberNoGm("MemberNoGm");
		addClientFollowSummary.setMemberNameGm("MemberNameGm");
		addClientFollowSummary.setCfNo("CfNo");
		addClientFollowSummary.setFollowNum(1);
		addClientFollowSummary.setStatus("Status");
		addClientFollowSummary.setOrderAmount(1L);
		addClientFollowSummary.setStartDate(new Date());
		addClientFollowSummary.setEndDate(new Date());
		addClientFollowSummary.setRemark("Remark");
		addClientFollowSummary.setCreateDate(new Date());
		addClientFollowSummary.setRemark4("Remark4");
		addClientFollowSummary.setRemark3("Remark3");
		addClientFollowSummary.setRemark2("Remark2");
		
		clientFollowSummaryService.addClientFollowSummary(addClientFollowSummary );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改反馈信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateClientFollowSummary() throws TsfaServiceException{
		UpdateClientFollowSummary updateClientFollowSummary = new UpdateClientFollowSummary();
		//update数据录入
		updateClientFollowSummary.setCode("Code");
		updateClientFollowSummary.setMerchantNo("MerchantNo");
		updateClientFollowSummary.setMemberNo("MemberNo");
		updateClientFollowSummary.setMemberName("MemberName");
		updateClientFollowSummary.setMemberNoGm("MemberNoGm");
		updateClientFollowSummary.setMemberNameGm("MemberNameGm");
		updateClientFollowSummary.setCfNo("CfNo");
		updateClientFollowSummary.setFollowNum(1);
		updateClientFollowSummary.setStatus("Status");
		updateClientFollowSummary.setOrderAmount(1L);
		updateClientFollowSummary.setStartDate(new Date());
		updateClientFollowSummary.setEndDate(new Date());
		updateClientFollowSummary.setRemark("Remark");
		updateClientFollowSummary.setCreateDate(new Date());
		updateClientFollowSummary.setRemark4("Remark4");
		updateClientFollowSummary.setRemark3("Remark3");
		updateClientFollowSummary.setRemark2("Remark2");

		clientFollowSummaryService.updateClientFollowSummary(updateClientFollowSummary );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找反馈信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findClientFollowSummary() throws TsfaServiceException{
		FindClientFollowSummary findClientFollowSummary = new FindClientFollowSummary();
		findClientFollowSummary.setCode("111");
		clientFollowSummaryService.findClientFollowSummary(findClientFollowSummary);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查询购买数量
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年7月17日
	 *
	 */
	@Test
	public void findBuySuccessNum() throws TsfaServiceException{
		FindSuccessNum findSuccessNum=new FindSuccessNum();
		findSuccessNum.setStatus("DEAL");
		findSuccessNum.setMemberName("本地人");
		int cont=clientFollowSummaryService.findBuySuccessNum(findSuccessNum);
		System.out.println(cont);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找反馈信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findClientFollowSummaryPage() throws TsfaServiceException{
		FindClientFollowSummaryPage findClientFollowSummaryPage = new FindClientFollowSummaryPage();
		Page<FindClientFollowSummaryPageReturn> page = clientFollowSummaryService.findClientFollowSummaryPage(findClientFollowSummaryPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除反馈信息信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delClientFollowSummary() throws TsfaServiceException{
		DelClientFollowSummary delClientFollowSummary = new DelClientFollowSummary();
		delClientFollowSummary.setCode("111");
		clientFollowSummaryService.delClientFollowSummary(delClientFollowSummary);
		
	}
	
	@Test
	public void sumAmountByShop() throws TsfaServiceException{
		List<String> list = new ArrayList<>();
		list.add("efbc3bb7be534d24b9cb6d72ac21f666");
		long aoumt = clientFollowSummaryService.sumAmountByShop(list);
		System.out.println(aoumt);
	}
	
	@Test
	public void sumAmountByMerchantNo() throws TsfaServiceException{
		Map<String,Object> parmMap = new HashMap<>();
		parmMap.put("merchantNo", "e79d975846ee41ba8c3c55738fda66a9");
		long aoumt = clientFollowSummaryService.sumAmountByMerchantNo(parmMap);
		System.out.println(aoumt);
	}
	
	
	@Test
	public void findNumSaleByGm() throws Exception {
		Map<String, Object> map = new HashMap<>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		map.put("beginTime", calendar.getTime());
		calendar.set(Calendar.HOUR, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		map.put("endTime", calendar.getTime());
		map.put("memberNoGm", "38df1c34ff2b430599fdbbe6aab1aaac");
		System.out.println(clientFollowSummaryService.findNumSaleByGm(map));
	}
	
	@Test
	public void findCountOrderByGm() throws Exception {
		Map<String, Object> map = new HashMap<>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		map.put("beginTime", calendar.getTime());
		calendar.set(Calendar.HOUR, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		map.put("endTime", calendar.getTime());
		map.put("memberNoGm", "c795e08cadac4867bb7fad496216efaf");
		System.out.println(clientFollowSummaryService.findCountOrderByGm(map));
	}
}
