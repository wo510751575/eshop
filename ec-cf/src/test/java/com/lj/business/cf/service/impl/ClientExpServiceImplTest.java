package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lj.base.core.pagination.Page;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.clientExp.ClientExpDto;
import com.lj.business.cf.dto.clientExp.FindClientExpPage;
import com.lj.business.cf.emus.ExpResult;
import com.lj.business.cf.service.IClientExpService;
import com.lj.business.cf.util.TestHelp;


/**
 * 类说明：测试类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 邹磊
 * 
 * 
 * CreateDate: 2017-06-14
 */
public class ClientExpServiceImplTest extends SpringTestCase{
	
	
	
	@Autowired
	private ClientExpServiceImpl clientExpServiceImpl;


	/**
	 * 
	 *
	 * 方法说明：查找跟进异常情况表(分页)
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	@Test
	public void findCfErrorInfoPage() {
		FindClientExpPage findClientExpPage = new FindClientExpPage();
		findClientExpPage.setStartTime(null);
		findClientExpPage.setEndTime(null);
	    Page<ClientExpDto> pages=clientExpServiceImpl.findClientExpPage(findClientExpPage);
		System.out.println(pages.getTotal());
	}
	
	/*@Test
	 public void findClientExpOms(){
		FindClientExpPage findClientExpPage=new FindClientExpPage();
	  Page<FindClientExpOmsPage> page=clientExpServiceImpl.findClientExpOms(findClientExpPage);
	  System.out.println(page);
	 }*/
	
	@Test
	public void findClientExps() {
		FindClientExpPage findClientExpPage = new FindClientExpPage();
		findClientExpPage.setMerchantNo(TestHelp.merchantNo_test);
//		findClientExpPage.setStartTime(null);
//		findClientExpPage.setEndTime(null);
		findClientExpPage.setCfCode("LJ_3433ca87f09047048d93baacab6b166c");
	    List<ClientExpDto> list=clientExpServiceImpl.findClientExps(findClientExpPage);
		System.out.println(list.toString());
	}
	@Test
	public void addClientExp() {
		ClientExpDto clientExp = new ClientExpDto();
		clientExp.setExpFb("aaaaaa");
//		clientExp.setExpTime(new Date());
		clientExp.setImgs("aaaaaa");
		clientExp.setResourcesUrl("aaaaa");
		clientExp.setMemberName("1");
		clientExp.setMemberNameGm("1");
		clientExp.setMemberNo("1");
		clientExp.setMemberNoGm("1");
		clientExp.setMerchantNo("1");
		clientExp.setShopName("1");
		clientExp.setShopNo("1");
		clientExpServiceImpl.addClientExp(clientExp);
	}
	
	@Test
	public void findExpResults() {
		Map<String,Object> parmMap = new HashMap<String, Object>();
		parmMap.put("merchantNo", TestHelp.merchantNo_test);
		parmMap.put("expResult", ExpResult.Y.toString());
		List<Map<String,Object>> list =clientExpServiceImpl.findExpResults(parmMap);
		System.out.println(list.toString());
	}
	@Test
	public void findClientExpByCfCode() {
		String cfCode = "LJ_3433ca87f09047048d93baacab6b166c";
		ClientExpDto list =clientExpServiceImpl.findClientExpByCfCode(cfCode);
		System.out.println(list.toString());
	}
	
	@Test
	public void findExpCountForMemberType() {
		String nowDate = "2017-09-05";
		String merchantNo = "e79d975846ee41ba8c3c55738fda66a9";
		String shopNo = "";
		String memberNoGm = "d7b963349b8f4bcbbed9a36fe41ae626";
		String memberType = "GUID";
		String searchNoGm = "";
		Map<String,Object> map =clientExpServiceImpl.findExpCountForMemberType(merchantNo, memberType, shopNo, memberNoGm, searchNoGm, nowDate);
		System.out.println(map.toString());
	}
	
	@Test
	public void findCountVisitByGm() throws Exception {
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
		map.put("expResult", "Y");
		System.out.println(clientExpServiceImpl.findCountVisitByGm(map));
	}
	
}
