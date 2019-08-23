package com.lj.business.cf.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.cf.dto.FindClientFollowClientKeep;
import com.lj.business.cf.dto.FindClientFollowClientKeepReturn;
import com.lj.business.cf.dto.clientFollow.AddClientFollow;
import com.lj.business.cf.dto.clientFollow.DelClientFollow;
import com.lj.business.cf.dto.clientFollow.FindClientFollow;
import com.lj.business.cf.dto.clientFollow.FindClientFollowMap;
import com.lj.business.cf.dto.clientFollow.FindClientFollowPage;
import com.lj.business.cf.dto.clientFollow.FindClientFollowPageReturn;
import com.lj.business.cf.dto.clientFollow.FindClientFollowReturn;
import com.lj.business.cf.dto.clientFollow.UpdateClientFollow;
import com.lj.business.cf.dto.clientKeep.AddClientKeep;
import com.lj.business.cf.dto.pmAbandon.AbandonCheckDto;
import com.lj.business.cf.service.IClientFollowService;
import com.lj.business.cf.service.IClientKeepService;


/**
 * 类说明：测试类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 彭阳
 * 
 * 
 * CreateDate: 2017-06-14
 */
public class ClientFollowServiceImplTest extends SpringTestCase{

	@Resource
	private IClientFollowService clientFollowService;
	
	@Resource
	public IClientKeepService clientKeepService;



	/**
	 * 
	 *
	 * 方法说明：添加客户跟踪表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addClientFollow() throws TsfaServiceException{
		AddClientFollow addClientFollow = new AddClientFollow();
		//add数据录入
		addClientFollow.setMerchantNo(GUID.generateByUUID());
		addClientFollow.setMemberNo("MemberNo");
		addClientFollow.setMemberName("MemberName");
		addClientFollow.setMemberNoGm("MemberNoGm");
		addClientFollow.setMemberNameGm("MemberNameGm");
		addClientFollow.setFollowNum(1);
		addClientFollow.setFollowType("FollowType");
		addClientFollow.setFollowInfo("FollowInfo");
		addClientFollow.setDeal("1");
		//StringUtils报错
		addClientFollow.setStatus(addClientFollow.getStatus());
		addClientFollow.setOrderAmount(100L);
		addClientFollow.setNextDate(new Date());
		addClientFollow.setRemark("Remark");
		addClientFollow.setCreateId("CreateId");
		
		Assert.assertNotNull(clientFollowService.addClientFollow(addClientFollow ));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改客户跟踪表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updateClientFollow() throws TsfaServiceException{
		UpdateClientFollow updateClientFollow = new UpdateClientFollow();
		//update数据录入
		updateClientFollow.setCode(GUID.getPreUUID());
		updateClientFollow.setMemberNo("MemberNo");
		updateClientFollow.setMemberName("MemberName");
		updateClientFollow.setMemberNoGm("MemberNoGm");
		updateClientFollow.setMemberNameGm("MemberNameGm");
		updateClientFollow.setFollowNum(1);
		updateClientFollow.setFollowType("FollowType");
		updateClientFollow.setFollowInfo("FollowInfo");
		updateClientFollow.setDeal("1");
		//StringUtils报错
		updateClientFollow.setStatus(updateClientFollow.getStatus());
		updateClientFollow.setOrderAmount(100L);
		updateClientFollow.setNextDate(new Date());
		updateClientFollow.setRemark("Remark");

		clientFollowService.updateClientFollow(updateClientFollow );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找客户跟踪表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findClientFollow() throws TsfaServiceException{
		FindClientFollow findClientFollow = new FindClientFollow();
		findClientFollow.setCode("LJ_33908081e6b14f118d90fbfdee4f1d5f");
		clientFollowService.findClientFollow(findClientFollow);
	}
	
/*	@Test
	public void selectByCond() throws TsfaServiceException{
		FindClientFollow findClientFollow = new FindClientFollow();
		findClientFollow.setMemberNo("");
		findClientFollow.setMerchantNo("");
		findClientFollow.setMemberNoGm("");
		int result=clientFollowService.selectByCond(findClientFollow);
		System.out.println(result);
	}
	*/
	
	@Test    
	public void findClientFollowss() throws TsfaServiceException{
		FindClientFollowClientKeep findClientFollow = new FindClientFollowClientKeep();
		findClientFollow.setMemberNo("3ab7afe7aadf4425ad0b4ba63a4430aa");
		findClientFollow.setMemberNoGm("d7b963349b8f4bcbbed9a36fe41ae626");
		findClientFollow.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		FindClientFollowClientKeepReturn findClientFollowClientKeepReturn=clientFollowService.cfOrCkHistory(findClientFollow);
		System.out.println(findClientFollowClientKeepReturn.getCfList().toString());
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找客户跟踪表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findClientFollowPage() throws TsfaServiceException{
		FindClientFollowPage findClientFollowPage = new FindClientFollowPage();
		Page<FindClientFollowPageReturn> page = clientFollowService.findClientFollowPage(findClientFollowPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除客户跟踪表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delClientFollow() throws TsfaServiceException{
		DelClientFollow delClientFollow = new DelClientFollow();
		delClientFollow.setCode("");
		Assert.assertNotNull(clientFollowService.delClientFollow(delClientFollow));
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：跟进新增
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月13日
	 *
	 */
	@Test
	public void addCFRecord() throws TsfaServiceException{
		AddClientFollow addClientFollow = new AddClientFollow();
		addClientFollow.setCfNo("58a885411682446d855b4037cb7c5e1e");
		addClientFollow.setMemberNo("LJ_8c3868e93edd4f25bc47eeb5f37e713a");
		addClientFollow.setMemberNoGm("d7b963349b8f4bcbbed9a36fe41ae626");
		addClientFollow.setCreateId("e79d975846ee41ba8c3c55738fda66a9");
		addClientFollow.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		Date date = new Date();
		addClientFollow.setFollowTime(date);
		addClientFollow.setNextDate(DateUtils.addDays(date, 2));
		
		clientFollowService.addCFOrder(addClientFollow, "0");
	}
	
	/**
	 * 
	 *
	 * 方法说明：成单
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月13日
	 *
	 */
	@Test
	public void addCFOrder() throws TsfaServiceException{
		AddClientFollow addClientFollow = new AddClientFollow();
		addClientFollow.setCfNo("58a885411682446d855b4037cb7c5e1e");
		addClientFollow.setMemberNo("LJ_8c3868e93edd4f25bc47eeb5f37e713a");
		addClientFollow.setMemberNoGm("d7b963349b8f4bcbbed9a36fe41ae626");
		addClientFollow.setCreateId("e79d975846ee41ba8c3c55738fda66a9");
		addClientFollow.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		addClientFollow.setFollowTime(new Date());
		addClientFollow.setOrderAmount(1000l);
		clientFollowService.addCFOrder(addClientFollow, "1");
	}
	
	/**
	 * 
	 *
	 * 方法说明：放弃
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月13日
	 *
	 */
	@Test
	public void addCFOrder2() throws TsfaServiceException{
		AddClientFollow addClientFollow = new AddClientFollow();
		addClientFollow.setCfNo("578d69d2a6f247c196c4e56a4047e4a2");
		addClientFollow.setMemberNo("90ab22975e7448e8bbfdd61e829d0c4b");
		addClientFollow.setMemberNoGm("d7b963349b8f4bcbbed9a36fe41ae626");
		addClientFollow.setCreateId("d7b963349b8f4bcbbed9a36fe41ae626");
		addClientFollow.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		addClientFollow.setNotDealReason("客户已买");
		clientFollowService.addCFOrder(addClientFollow, "2");
	}
	
	/**
	 * 
	 *
	 * 方法说明：放弃审批
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月13日
	 *
	 */
	@Test
	public void abandonCheck() throws TsfaServiceException{
		AbandonCheckDto abandonCheckDto = new AbandonCheckDto();
//		abandonCheckDto.setCfNo("bcd85dae01d24ff2b1b79cb5a60e1877");
//		abandonCheckDto.setMemberNo("LJ_78fe9e7511c54cd5b75b6036bcd88b41");
//		abandonCheckDto.setMemberNoGm("d7b963349b8f4bcbbed9a36fe41ae626");
//		abandonCheckDto.setCreateId("e79d975846ee41ba8c3c55738fda66a9");
//		abandonCheckDto.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
//		abandonCheckDto.setNotDealReason("其他");
		clientFollowService.abandonCheck(abandonCheckDto);
	}
	
	
	/**
	 * 
	 *
	 * 方法说明：新增维护
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月13日
	 *
	 */
	@Test
	public void addClientKeep() throws TsfaServiceException{
		AddClientKeep addClientKeep = new AddClientKeep();
		addClientKeep.setBuy("N");
		addClientKeep.setBomName("发财树1");
		addClientKeep.setCkNo("3e4b423ef21d4dc1a1d5a3aab9a9f064");
		addClientKeep.setMemberNo("LJ_78fe9e7511c54cd5b75b6036bcd88b41");
		addClientKeep.setMemberNoGm("d7b963349b8f4bcbbed9a36fe41ae626");
		addClientKeep.setCreateId("e79d975846ee41ba8c3c55738fda66a9");
		addClientKeep.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		Date date = new Date();
		addClientKeep.setKeepTime(date);
		addClientKeep.setNextDate(DateUtils.addDays(date, 5));
		clientKeepService.newClientKeepInfo(addClientKeep);
	}
	
	@Test
	public void findClientFollowClientKeep() throws TsfaServiceException{
		FindClientFollowClientKeep findClientFollowClientKeep = new FindClientFollowClientKeep();
		findClientFollowClientKeep.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		findClientFollowClientKeep.setMemberNo("fa3ddab1be6e433887daffb0d3229fdf");
		findClientFollowClientKeep.setMemberNoGm("d7b963349b8f4bcbbed9a36fe41ae626");
		
		clientFollowService.cfOrCkHistory(findClientFollowClientKeep);
	}
	
	@Test
	public void findClientFollCount(){
		FindClientFollowMap findClientFollowMap=new FindClientFollowMap();
		findClientFollowMap.setFollowNumFrom(1);
		findClientFollowMap.setFollowNumTo(5);
		int count=clientFollowService.findClientFollowCount(findClientFollowMap);
		System.out.println(count);
	}
	
	@Test
	public void findClientFollSum(){
		FindClientFollowMap findClientFollowMap=new FindClientFollowMap();
		findClientFollowMap.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		int count=clientFollowService.findClientFollowSum(findClientFollowMap);
		System.out.println(count);
	}
	@Test
	public void findClientFolls(){
		FindClientFollowMap findClientFollowMap=new FindClientFollowMap();
		findClientFollowMap.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		int count=clientFollowService.findLClientFollowCountDeal(findClientFollowMap);
		System.out.println(count);
	}
	@Test
	public void findClientFollss(){
		FindClientFollowMap findClientFollowMap=new FindClientFollowMap();
		findClientFollowMap.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		int count=clientFollowService.findLClientFollowCountMemberNo(findClientFollowMap);
		System.out.println(count);
	}
	@Test
	public void findClientFollsss(){
		FindClientFollowMap findClientFollowMap=new FindClientFollowMap();
		findClientFollowMap.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		int count=clientFollowService.findClientFollowSumMemberNo(findClientFollowMap);
		System.out.println(count);
	}
	
	@Test
	public void findClientFollowByGmAndMember() throws Exception {
		FindClientFollow findClientFollow = new FindClientFollow();
		findClientFollow.setMemberNoGm("3f59ef3cd6514dd7887b93c88b08c2fb");
		findClientFollow.setMemberNo("2b2910a44d4146c0997d82f93fd8e53c");
		FindClientFollowReturn member = clientFollowService.findClientFollowByGmAndMember(findClientFollow);
		System.out.println(member);
	}
}
