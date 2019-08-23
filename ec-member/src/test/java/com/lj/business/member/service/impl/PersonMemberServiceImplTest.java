package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.member.dto.AddPersonMember;
import com.lj.business.member.dto.CountPersonMemberReturn;
import com.lj.business.member.dto.DelPersonMember;
import com.lj.business.member.dto.EditPersonMember;
import com.lj.business.member.dto.FindCountPersonMember;
import com.lj.business.member.dto.FindMemberInfoReturn;
import com.lj.business.member.dto.FindMemberRecord;
import com.lj.business.member.dto.FindNewPmPage;
import com.lj.business.member.dto.FindPersonMember;
import com.lj.business.member.dto.FindPersonMemberPage;
import com.lj.business.member.dto.FindPersonMemberPageReturn;
import com.lj.business.member.dto.FindPersonMemberReturnList;
import com.lj.business.member.dto.FindPmInfoAll;
import com.lj.business.member.dto.FindPmSeachPage;
import com.lj.business.member.dto.FindPmSeachPageReturn;
import com.lj.business.member.dto.FindPmType;
import com.lj.business.member.dto.FindPmTypeIndexPage;
import com.lj.business.member.dto.FindPmTypeIndexPageReturn;
import com.lj.business.member.dto.FindPmWxBpInfo;
import com.lj.business.member.dto.FindPmWxInfo;
import com.lj.business.member.dto.FindUrgentMbrPage;
import com.lj.business.member.dto.FindUrgentMbrPageReturn;
import com.lj.business.member.dto.UpdatePersonMember;
import com.lj.business.member.emus.PmTypeType;
import com.lj.business.member.emus.UrgentFlagType;
import com.lj.business.member.service.IPersonMemberService;
import com.lj.business.member.util.TestHelp;


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
public class PersonMemberServiceImplTest extends SpringTestCase{

	@Resource
	IPersonMemberService personMemberService;



	/**
	 * 
	 *
	 * 方法说明：添加会员表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addPersonMember() throws TsfaServiceException{
		AddPersonMember addPersonMember = new AddPersonMember();
		//add数据录入
		addPersonMember.setMemberName("MemberName");
		addPersonMember.setMemberNoGm("MemberNoGm");
		addPersonMember.setMemberNameGm("MemberNameGm");
		addPersonMember.setShopNo("ShopNo");
		addPersonMember.setShopName("ShopName");
		addPersonMember.setMerchantNo("MerchantNo");
		addPersonMember.setMerchantName("MerchantName");
		addPersonMember.setSpruceUp("SpruceUp");
		addPersonMember.setHouses("Houses");
		addPersonMember.setKeepEye("1");
		addPersonMember.setUrgencyPm("1");
		addPersonMember.setBomCode("BomCode");
		addPersonMember.setBomName("BomName");
		addPersonMember.setCreateId("CreateId");
		addPersonMember.setRemark4("Remark4");
		addPersonMember.setRemark3("Remark3");
		addPersonMember.setRemark2("Remark2");
		addPersonMember.setRemark("Remark");
//		addPersonMember.set
		
		personMemberService.addPersonMember(addPersonMember );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改会员表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updatePersonMember() throws TsfaServiceException{
		UpdatePersonMember updatePersonMember = new UpdatePersonMember();
		//update数据录入
		updatePersonMember.setCode("Code");
		updatePersonMember.setMemberNo("MemberNo");
		updatePersonMember.setMemberName("MemberName");
		updatePersonMember.setMemberNoGm("MemberNoGm");
		updatePersonMember.setMemberNameGm("MemberNameGm");
		updatePersonMember.setShopNo("ShopNo");
		updatePersonMember.setShopName("ShopName");
		updatePersonMember.setMerchantNo("MerchantNo");
		updatePersonMember.setMerchantName("MerchantName");
		updatePersonMember.setSpruceUp("SpruceUp");
		updatePersonMember.setHouses("Houses");
		updatePersonMember.setKeepEye("KeepEye");
		updatePersonMember.setUrgencyPm("UrgencyPm");
		updatePersonMember.setBomCode("BomCode");
		updatePersonMember.setBomName("BomName");
		updatePersonMember.setUpdateId("UpdateId");
		updatePersonMember.setRemark4("Remark4");
		updatePersonMember.setRemark3("Remark3");
		updatePersonMember.setRemark2("Remark2");
		updatePersonMember.setRemark("Remark");

		personMemberService.updatePersonMember(updatePersonMember );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找会员表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findPersonMember() throws TsfaServiceException{
		FindPersonMember findPersonMember = new FindPersonMember();
		findPersonMember.setCode("11");
		personMemberService.findPersonMember(findPersonMember);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找会员表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findPersonMemberPage() throws TsfaServiceException{
		FindPersonMemberPage findPersonMemberPage = new FindPersonMemberPage();
		findPersonMemberPage.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		findPersonMemberPage.setLimit(500);
//		findPersonMemberPage.setImei(2);
		Page<FindPersonMemberPageReturn> page = personMemberService.findPersonMemberPage(findPersonMemberPage);
		System.out.println(page.toString());
	}
	
	/**
	 * 
	 *
	 * 方法说明：删除会员表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delPersonMember() throws TsfaServiceException{
		DelPersonMember delPersonMember = new DelPersonMember();
		delPersonMember.setCode(GUID.getPreUUID());
		Assert.assertNotNull(personMemberService.delPersonMember(delPersonMember));
		
	}
	
	@Test
	public void getByCode() throws TsfaServiceException{
		Map<String,String> map = new HashMap<>();
		map.put("code", "LJ_8b0d65797b944a5fa486825e24d4aff6");
		map.put("pmTypeType", PmTypeType.URGENCY.toString());
		FindPersonMemberPageReturn personMemberPageReturn= personMemberService.getByCond(map);
		System.out.println(personMemberPageReturn.toString());
	}
	
	
	/**
	 * 
	 *
	 * 方法说明：客户管理首页：分类信息明细查询
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findPmTypeIndexPage() throws TsfaServiceException{
		FindPmTypeIndexPage findPmTypeIndexPage = new FindPmTypeIndexPage();
		findPmTypeIndexPage.setMemberNoGm(TestHelp.memberNoGm_test);
		findPmTypeIndexPage.setMerchantNo(TestHelp.merchantNo_test);
		findPmTypeIndexPage.setPmTypeCode(TestHelp.typeCode_test);
		Page<FindPmTypeIndexPageReturn> page = personMemberService.findPmTypeIndexPage(findPmTypeIndexPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：客户管理首页：分类信息明细查询
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findPmSeachPage() throws TsfaServiceException{
		FindPmSeachPage findPmSeachPage = new FindPmSeachPage();
		findPmSeachPage.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		findPmSeachPage.setShopNo("LJ_c269478af52646b692fcc48deb10a7ad");
		findPmSeachPage.setSearchKey("i");
		Page<FindPmSeachPageReturn> page = personMemberService.findPmSeachPage(findPmSeachPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：分页查询紧急客户信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findUrgentMbrPage() throws TsfaServiceException{
		FindUrgentMbrPage findUrgentMbrPage = new FindUrgentMbrPage();
		findUrgentMbrPage.setMemberNoGm(TestHelp.memberNoGm_test);
		findUrgentMbrPage.setMerchantNo(TestHelp.merchantNo_test);
		Page<FindUrgentMbrPageReturn> page = personMemberService.findUrgentMbrPage(findUrgentMbrPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：分页查询
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年7月11日
	 *
	 */
	@Test
	public void findPMPage() throws TsfaServiceException{
		FindPersonMemberPage findPersonMember = new FindPersonMemberPage();
//		findPersonMember.setMerchantNo(TestHelp.merchantNo_test);
//		findPersonMember.setPmTypeType(PmTypeType.SUCCESS.toString());
//		findPersonMember.setMemberNameGm("李四");
//		findPersonMember.setShopName("祥");
		findPersonMember.setArea("省");
		Page<FindPersonMemberPageReturn> page = personMemberService.findPersonMemberPage(findPersonMember);
		
		System.out.println(JSONObject.fromObject(page).toString());
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改客户资料
	 *
	 * @param editPersonMember
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月13日
	 *
	 */
	@Test
	public void editPersonMember() throws TsfaServiceException{
		EditPersonMember editPersonMember = new EditPersonMember();
		editPersonMember.setMemberName("号了");
		editPersonMember.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		editPersonMember.setCode("LJ_1451189a68ea4f19adefb5b2a2676e5f");
		editPersonMember.setCodePm("LJ_78725bb73393449dba17cb9c189ebd5b");
		
		editPersonMember.setMemberNo("3ee88436a85940f89b9772a79fca402b");
		editPersonMember.setMemberNoGm("d7b963349b8f4bcbbed9a36fe41ae626");
		
		editPersonMember.setUrgencyPm(UrgentFlagType.Y.toString());
		editPersonMember.setPmTypeCode("LJ_810e4134082b4e8ba66bc918c127f47a");
		editPersonMember.setPmTypePmCode("LJ_155e51b55555488cb480eda4c3471030");
		
		editPersonMember.setBomName("电视机");
		personMemberService.editPersonMember(editPersonMember );
		
	}
	
	

	/**
	 * 
	 *
	 * 方法说明：查找客户及其基本信息
	 *
	 * @param editPersonMember
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月13日
	 *
	 */
	@Test
	public void findPmInfoAll() throws TsfaServiceException{
		FindPmInfoAll findPmInfoAll = new FindPmInfoAll();
		findPmInfoAll.setMemberNo("6543b645e14047d2b541ff82ee09ea2b");
		findPmInfoAll.setMemberNoGm("d7b963349b8f4bcbbed9a36fe41ae626");
		personMemberService.findPmInfoAll(findPmInfoAll);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：从勾子添加客户表信息
	 *
	 * @param editPersonMember
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月13日
	 *
	 */
	@Test
	public void addPersonMemberFromHook() throws TsfaServiceException{
		String info = "{'noWxGM':'lingju20160523','data':[{'noWx':'lnxzbcp_2','nickNameWx':'包春平','nickNameRemarkWx':'昵称备注','longitude':'113.96102','latitude':'22.541582','scanAddress':'深圳市,南山区,750号','sex':'','cityWx':'','countryWx':'','headAddress':'http://wx.qlogo.cn/mmhead/ver_1/ICicnUMnTvHj2fvK5qHTciaXe0BM8KT959AibPSqHUibNxXBiaZRdpGXbrJrAlZa2jPosmA2zPkcWGvc6w11LYUGyxzyQAiaFsVicAOpBcXt0hglqE/0','subsribeTime':'2017-07-17 19:49:32'}"
				+ "]}";
		personMemberService.addPersonMemberFromHook(info);
//		for (int i = 10; i < 20; i++) {
//			String info = "{'noWxGM':'wxid_asobyw0oiu9022','data':[{'noWx':'lovejing577','nickNameWx':'柚子喝个毛的茶','sex':'','cityWx':'','countryWx':'','headAddress':'http://wx.qlogo.cn/mmhead/ver_1/ICicnUMnTvHj2fvK5qHTciaXe0BM8KT959AibPSqHUibNxXBiaZRdpGXbrJrAlZa2jPosmA2zPkcWGvc6w11LYUGyxzyQAiaFsVicAOpBcXt0hglqE/0','subsribeTime':'2017-07-17 19:49:32'},"
//					+ "{'noWx':'K-ShiFu-"+ i +"','nickNameWx':'我shi康师傅-"+ i +"','sex':'','cityWx':'','countryWx':'','headAddress':'http://wx.qlogo.cn/mmhead/ver_1/mcF07WR66wS1vDUu9hWCrwuicMr8ibfLEryKuUwIDzX3ic4picc2Wp9c9EVvzACs4dmNs8oicn3M1g2s5QFpEu7ibJ3Q/0','subsribeTime':'2017-07-17 19:49:32'}]}";
//			personMemberService.addPersonMemberFromHook(info);
//		}
	}
	
	
	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月21日
	 *
	 */
	@Test
	public void findPmWxBpInfo() throws TsfaServiceException{
		FindPmWxBpInfo findPmWxBpInfo = new FindPmWxBpInfo();
		List<String> list = new ArrayList<String>();
		list.add(TestHelp.memberNo_test);
		list.add(TestHelp.memberNo_test);
		findPmWxBpInfo.setMemberNoAr(list);
		findPmWxBpInfo.setMemberNoGm(TestHelp.memberNoGm_test);
		findPmWxBpInfo.setMerchantNo(TestHelp.merchantNo_test);
		personMemberService.findPmWxBpInfo(findPmWxBpInfo );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月21日
	 *
	 */
	@Test
	public void findPmWxInfo() throws TsfaServiceException{
		FindPmWxInfo findPmWxInfo = new FindPmWxInfo();
		List<String> list = new ArrayList<String>();
		list.add(TestHelp.memberNo_test);
		list.add(TestHelp.memberNo_test);
		findPmWxInfo.setMemberNoAr(list);
		findPmWxInfo.setMemberNoGm(TestHelp.memberNoGm_test);
		findPmWxInfo.setMerchantNo(TestHelp.merchantNo_test);
		personMemberService.findPmWxInfo(findPmWxInfo );
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：日工作-当日新增客户查询_APP
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月21日
	 *
	 */
	@Test
	public void findNewPmPage() throws TsfaServiceException{
		FindNewPmPage findNewPmPage = new FindNewPmPage();
		findNewPmPage.setMemberNoGm(TestHelp.memberNoGm_test);
		findNewPmPage.setMerchantNo(TestHelp.merchantNo_test);
		personMemberService.findNewPmPage(findNewPmPage);
		
	}
	@Test
	public void findNewPmPagess() throws TsfaServiceException{
		FindUrgentMbrPage findUrgentMbrPage=new FindUrgentMbrPage();
		findUrgentMbrPage.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		int count=personMemberService.findPersonMemberSums(findUrgentMbrPage);
		System.out.println(count);
		
	}
	@Test
	public void findPersonMemberTypes(){
		FindPersonMember findPersonMember=new FindPersonMember();
		findPersonMember.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		findPersonMember.setAreaCode("1");
		FindPersonMemberReturnList findPersonMemberReturnList=personMemberService.findPersonMemberTypeNum(findPersonMember);
		System.out.println(findPersonMemberReturnList);
	}
	
	@Test
	public void findPersonMemberSexCount(){
		FindPersonMember findPersonMember=new FindPersonMember();
		findPersonMember.setMerchantNo("0");
		findPersonMember.setAreaCode("1");
		List<FindUrgentMbrPageReturn> findUrgentMbrPageReturn=personMemberService.findPersonMemberSexCount(findPersonMember);
		System.out.println(findUrgentMbrPageReturn.toString());
	}
	
	@Test
	public void isToShop() throws TsfaServiceException{
		
		boolean count=personMemberService.isToShop("113.960583","22.541341","113.960582","22.541354","1000");
		
	}
	
	@Test
	public void findCountPmAddByGmDay() throws Exception {
		System.out.println(personMemberService.findCountPmAddByGmDay("e2d3693a9df14a2c9acc891c32b3d895", new Date()));
	}
	
	@Test
	public void findCountPmByType() throws Exception {
		FindPmType findPmType = new FindPmType();
		findPmType.setMemberNo("e2d3693a9df14a2c9acc891c32b3d895");
		findPmType.setPmTypeType("INTENTION");
		System.out.println(personMemberService.findCountPmByType(findPmType));
	}
	
	@Test
	public void findPersonMembeRerurnList()throws TsfaServiceException{
		FindPersonMember findPersonMember=new FindPersonMember();
		findPersonMember.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		/*List<FindPersonMemberReturnList> list=personMemberService.findPersonMemberTypeList(findPersonMember);
		System.out.println(list.toString());*/
		int count=personMemberService.findPersonMemberTypeCount(findPersonMember);
		System.out.println(count);
	}
	
	@Test
	public void findMemberRecord() {
		FindMemberRecord findMemberRecord = new FindMemberRecord();
		findMemberRecord.setMemberNoGm("d7b963349b8f4bcbbed9a36fe41ae626");
		findMemberRecord.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		List<FindMemberInfoReturn> list = personMemberService.findMemberRecord(findMemberRecord);
		System.out.println(list.size());
	}
	
	@Test
	public void findGroupCountByDay() throws Exception {
		FindCountPersonMember findCountPersonMember = new FindCountPersonMember();
		findCountPersonMember.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		findCountPersonMember.setStartTime("2017-08-07 00:00:00");
		findCountPersonMember.setEndTime("2017-09-05 23:59:59");
		List<CountPersonMemberReturn> list = personMemberService.findGroupCountByDay(findCountPersonMember);
		System.out.println(list);
	}
	
	@Test
	public void findPersonMemberCont()throws TsfaServiceException{
		FindPersonMember findPersonMember=new FindPersonMember();
		findPersonMember.setMerchantNo("e79d975846ee41ba8c3c55738fda66a9");
		findPersonMember.setProvinceCode("104");
		findPersonMember.setAreaCode("2");
		int count=personMemberService.findPersonMemberCont(findPersonMember);
		System.out.println(count);
		
	}
	
}
