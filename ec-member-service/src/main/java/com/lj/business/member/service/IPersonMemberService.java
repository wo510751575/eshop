package com.lj.business.member.service;

import java.util.Date;
import java.util.List;
import java.util.Map;



/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.dto.AddPersonMember;
import com.lj.business.member.dto.AddPersonMemberAll;
import com.lj.business.member.dto.AddPersonMemberBase;
import com.lj.business.member.dto.AddPersonMemberReturn;
import com.lj.business.member.dto.CountPersonMemberReturn;
import com.lj.business.member.dto.DelPersonMember;
import com.lj.business.member.dto.DelPersonMemberReturn;
import com.lj.business.member.dto.DoRepeatMemberDto;
import com.lj.business.member.dto.EditPersonMember;
import com.lj.business.member.dto.FindCountPersonMember;
import com.lj.business.member.dto.FindMemberInfoReturn;
import com.lj.business.member.dto.FindMemberRecord;
import com.lj.business.member.dto.FindNewPmCountDto;
import com.lj.business.member.dto.FindNewPmPage;
import com.lj.business.member.dto.FindNewPmPageReturn;
import com.lj.business.member.dto.FindPersonMember;
import com.lj.business.member.dto.FindPersonMemberAgeStatisticsReturn;
import com.lj.business.member.dto.FindPersonMemberBaseReturn;
import com.lj.business.member.dto.FindPersonMemberInterestStatisticsReturn;
import com.lj.business.member.dto.FindPersonMemberLineStatisticsReturn;
import com.lj.business.member.dto.FindPersonMemberPage;
import com.lj.business.member.dto.FindPersonMemberPageReturn;
import com.lj.business.member.dto.FindPersonMemberReturn;
import com.lj.business.member.dto.FindPersonMemberReturnList;
import com.lj.business.member.dto.FindPersonMemberSexStatisticsReturn;
import com.lj.business.member.dto.FindPmInfoAll;
import com.lj.business.member.dto.FindPmInfoAllReturn;
import com.lj.business.member.dto.FindPmSeachPage;
import com.lj.business.member.dto.FindPmSeachPageReturn;
import com.lj.business.member.dto.FindPmType;
import com.lj.business.member.dto.FindPmTypeIndexPage;
import com.lj.business.member.dto.FindPmTypeIndexPageReturn;
import com.lj.business.member.dto.FindPmWxBpInfo;
import com.lj.business.member.dto.FindPmWxBpInfoReturn;
import com.lj.business.member.dto.FindPmWxInfo;
import com.lj.business.member.dto.FindPmWxInfoReturn;
import com.lj.business.member.dto.FindTodayManageShop;
import com.lj.business.member.dto.FindTodayManageShopReturn;
import com.lj.business.member.dto.FindUnContactMember;
import com.lj.business.member.dto.FindUnContactMemberReturn;
import com.lj.business.member.dto.FindUrgentMbrPage;
import com.lj.business.member.dto.FindUrgentMbrPageReturn;
import com.lj.business.member.dto.UpdatePersonMember;
import com.lj.business.member.dto.UpdatePersonMemberReturn;

/**
 * 类说明：接口类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 段志鹏
 * 
 * 
 *         CreateDate: 2017-06-14
 */
public interface IPersonMemberService {

	/**
	 * 
	 *
	 * 方法说明：查找客户所有微信信息
	 *
	 * @param findPmWxInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月20日
	 *
	 */
	public List<FindPmWxInfoReturn> findPmWxInfo(FindPmWxInfo findPmWxInfo) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：查找客户所有微信信息及最新动态
	 *
	 * @param findPmWxInfo
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月20日
	 *
	 */
	public List<FindPmWxBpInfoReturn> findPmWxBpInfo(FindPmWxBpInfo findPmWxBpInfo) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：今日工作-当日新增客户查询_APP
	 *
	 * @param findNewPmPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月17日
	 *
	 */
	public Page<FindNewPmPageReturn> findNewPmPage(FindNewPmPage findNewPmPage) throws TsfaServiceException;

	/**
	 * 方法说明：查找客户及其基本信息.
	 *
	 * @param findPmInfoAll
	 *            the find pm info all
	 * @return the find pm info all return
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 段志鹏 CreateDate: 2017年7月3日
	 */
	public FindPmInfoAllReturn findPmInfoAll(FindPmInfoAll findPmInfoAll) throws TsfaServiceException;

	/**
	 * 方法说明：添加客户导购关联表,客户基础表数据.
	 *
	 * @param addPersonMemberAll
	 *            the add person member all
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年7月12日
	 */
	public void addPersonMemberAll(AddPersonMemberAll addPersonMemberAll) throws TsfaServiceException;

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
	 * 方法说明：查找客户表信息.
	 *
	 * @param findPersonMember
	 *            the find person member
	 * @return the find person member return
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 段志鹏 CreateDate: 2017年7月3日
	 */
	public FindPersonMemberReturn findPersonMember(FindPersonMember findPersonMember) throws TsfaServiceException;

	/**
	 * 方法说明：删除客户表信息.
	 *
	 * @param delPersonMember
	 *            the del person member
	 * @return the del person member return
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 段志鹏 CreateDate: 2017年7月3日
	 */
	public DelPersonMemberReturn delPersonMember(DelPersonMember delPersonMember) throws TsfaServiceException;

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
	 * 方法说明：客户信息编辑.
	 *
	 * @param editPersonMember
	 *            the edit person member
	 * @return the update person member return
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 冯辉 CreateDate: 2017年7月13日
	 */
	public UpdatePersonMemberReturn editPersonMember(EditPersonMember editPersonMember) throws TsfaServiceException;

	/**
	 * 方法说明：根据客户号和导购号修改客户表信息.
	 *
	 * @param updatePersonMember
	 *            the update person member
	 * @return the update person member return
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 冯辉 CreateDate: 2017年7月11日
	 */
	public UpdatePersonMemberReturn updatePersonMemberByMGM(UpdatePersonMember updatePersonMember) throws TsfaServiceException;

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

	/**
	 * 方法说明：查找客户表信息.
	 *
	 * @param findPersonMemberPage
	 *            the find person member page
	 * @return the page< find person member page return>
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 段志鹏 CreateDate: 2017年7月3日
	 */
	public Page<FindPersonMemberPageReturn> findPersonMemberPage(FindPersonMemberPage findPersonMemberPage) throws TsfaServiceException;

	/**
	 * 方法说明：客户管理首页：分类信息明细查询.
	 *
	 * @param findPmTypeIndexPage
	 *            the find pm type index page
	 * @return the page< find pm type index page return>
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年7月10日
	 */
	public Page<FindPmTypeIndexPageReturn> findPmTypeIndexPage(FindPmTypeIndexPage findPmTypeIndexPage) throws TsfaServiceException;

	/**
	 * 方法说明：客户管理搜索：分页查询.
	 *
	 * @param findPmSeachPage
	 *            the find pm seach page
	 * @return the page< find pm seach page return>
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年7月10日
	 */
	public Page<FindPmSeachPageReturn> findPmSeachPage(FindPmSeachPage findPmSeachPage) throws TsfaServiceException;

	/**
	 * 方法说明：根据客户标记信息查找客户表信息.
	 *
	 * @param findManagerMember
	 *            the find manager member
	 * @return the list< find person member return>
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author rain CreateDate: 2017年7月3日
	 */
	// public List<FindPersonMemberReturn> queryMbr(FindManagerMember
	// findManagerMember) throws TsfaServiceException;

	/**
	 * 方法说明：查找紧急客户信息.
	 *
	 * @param flag
	 *            the flag
	 * @param memberGMCode
	 *            the member gm code
	 * @return the list< find person member return>
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author rain CreateDate: 2017年7月3日
	 * @deprecated 表结构修改,暂时作废 update by 彭阳 2017-07-10
	 */
	public List<FindPersonMemberReturn> urgentMbr(String flag, String memberGMCode) throws TsfaServiceException;

	/**
	 * 方法说明：分页查询紧急客户信息.
	 *
	 * @param findUrgentMbrPage
	 *            the find urgent mbr page
	 * @return the page< find urgent mbr page return>
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年7月10日
	 */
	public Page<FindUrgentMbrPageReturn> findUrgentMbrPage(FindUrgentMbrPage findUrgentMbrPage) throws TsfaServiceException;

	/**
	 * 方法说明：flag = 1 标记紧急客户,flag=0 标记为0的时候则为非紧急客户.
	 *
	 * @param code
	 *            the code
	 * @param flag
	 *            the flag
	 * @return the int
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author rain CreateDate: 2017年7月3日
	 * @deprecated 表结构修改,暂时作废 update by 彭阳 2017-07-10
	 */
	public int urgentOpMbr(String code, String flag) throws TsfaServiceException;

	/**
	 * 方法说明：查找未分组客户信息.
	 *
	 * @param flag
	 *            the flag
	 * @param memberGMCode
	 *            the member gm code
	 * @return the list< find person member return>
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author rain CreateDate: 2017年7月3日
	 * @deprecated 表结构修改,暂时作废 update by 彭阳 2017-07-10
	 */
	public List<FindPersonMemberReturn> unGroupMbr(String flag, String memberGMCode) throws TsfaServiceException;

	/**
	 * 方法说明：查找意向客户信息.
	 *
	 * @param code
	 *            the code
	 * @param memberGMCode
	 *            the member gm code
	 * @return the list< find person member return>
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author rain CreateDate: 2017年7月3日
	 * @deprecated 表结构修改,暂时作废 update by 彭阳 2017-07-10
	 */
	public List<FindPersonMemberReturn> favorMbr(String code, String memberGMCode) throws TsfaServiceException;

	/**
	 * 方法说明：查找非意向客户信息.
	 *
	 * @param code
	 *            the code
	 * @param memberGMCode
	 *            the member gm code
	 * @return the list< find person member return>
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author rain CreateDate: 2017年7月3日
	 * @deprecated 表结构修改,暂时作废 update by 彭阳 2017-07-10
	 */
	public List<FindPersonMemberReturn> unfavorMbr(String code, String memberGMCode) throws TsfaServiceException;

	/**
	 * 方法说明：查找成单客户信息.
	 *
	 * @param code
	 *            the code
	 * @param memberGMCode
	 *            the member gm code
	 * @return the list< find person member return>
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author rain CreateDate: 2017年7月3日
	 * @deprecated 表结构修改,暂时作废 update by 彭阳 2017-07-10
	 */
	public List<FindPersonMemberReturn> orderMbr(String code, String memberGMCode) throws TsfaServiceException;

	/**
	 * 方法说明：查找放弃客户信息.
	 *
	 * @param code
	 *            the code
	 * @param memberGMCode
	 *            the member gm code
	 * @return the list< find person member return>
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author rain CreateDate: 2017年7月3日
	 * @deprecated 表结构修改,暂时作废 update by 彭阳 2017-07-10
	 */
	public List<FindPersonMemberReturn> abandonMbr(String code, String memberGMCode) throws TsfaServiceException;

	/**
	 * 方法说明：查找交叉客户信息.
	 *
	 * @param flag
	 *            the flag
	 * @param memberGMCode
	 *            the member gm code
	 * @return the list< find person member return>
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author rain CreateDate: 2017年7月3日
	 * @deprecated 表结构修改,暂时作废 update by 彭阳 2017-07-10
	 */
	public List<FindPersonMemberReturn> repeatMbr(String flag, String memberGMCode) throws TsfaServiceException;

	/**
	 * 方法说明：我的客户-新增客户，主要针对没有微信客户.
	 *
	 * @param addPersonMemberBase
	 *            the add person member base
	 * @return the int
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author rain CreateDate: 2017年7月3日
	 */
	public int addMemberForNonWxMember(AddPersonMemberBase addPersonMemberBase) throws TsfaServiceException;

	/**
	 * 方法说明：我的客户-客户资料.
	 *
	 * @param code
	 *            the code
	 * @param memberGMCode
	 *            the member gm code
	 * @return AdddPersonMemberBase
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author rain CreateDate: 2017年7月3日
	 */
	// public AddPersonMemberBase memberInfo(String code,String memberGMCode)
	// throws TsfaServiceException;

	/**
	 * 方法说明：查找客户信息根据参数.
	 *
	 * @param param
	 *            1. code 客户Code 2. pmTypeType 客户分类类型
	 * @return the by cond
	 * @author 段志鹏 CreateDate: 2017年7月12日
	 */
	public FindPersonMemberPageReturn getByCond(Map<String, String> param);

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
	 * 分页查询未联系客户
	 *
	 * @param findUnContactMember
	 *            未联系客户
	 * @return
	 * @throws TsfaServiceException
	 */
	Page<FindUnContactMemberReturn> findUnContactMemberPage(FindUnContactMember findUnContactMember) throws TsfaServiceException;

	/**
	 * 查询导购下所有的客户数
	 * 
	 * @param merchantNo
	 *            商户编号
	 * @param memberNoGm
	 *            导购编号
	 * @return 总数
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月24日
	 */
	int findCountByMemberNoGm(String merchantNo, String memberNoGm);

	/**
	 * 查询导购未联系的客户数
	 * 
	 * @param findUnContactMember
	 *            导购编号
	 * @return 总数
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月24日
	 */
	int findUnContactMemberCount(FindUnContactMember findUnContactMember);

	/**
	 * 
	 *
	 * 方法说明：查询客户总量
	 *
	 * @param findUrgentMbrPage
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月7日
	 *
	 */
	public int findPersonMemberSums(FindUrgentMbrPage findUrgentMbrPage);

	/**
	 * 根据商户编号统计性别
	 * 
	 * @return
	 */
	List<FindPersonMemberSexStatisticsReturn> selectSexStatisticsByShopNo();

	/**
	 * 根据商户编号统计年龄
	 * 
	 * @return
	 */
	List<FindPersonMemberAgeStatisticsReturn> selectAgeStatisticsByShopNo(String beginDate, String endDate);

	/**
	 * 根据商户编号统计职业
	 * 
	 * @return
	 */
	List<FindPersonMemberLineStatisticsReturn> selectLineStatisticsByShopNo();

	/**
	 * 根据商户编号统计兴趣
	 * 
	 * @return
	 */
	List<FindPersonMemberInterestStatisticsReturn> selectInterestStatisticsByShopNo();

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
	 * 
	 *
	 * 方法说明：查询客户列表
	 *
	 * @param findPersonMemberPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月15日
	 *
	 */
	List<FindPersonMemberPageReturn> findPersonMemberList(FindPersonMemberPage findPersonMemberPage) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：是否到店
	 *
	 * @param shopLongitude
	 * @param shopLatitude
	 * @param pmLongitude
	 * @param pmLatitude
	 * @param distance
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年8月15日
	 *
	 */
	boolean isToShop(String shopLongitude, String shopLatitude, String pmLongitude, String pmLatitude, String distance);

	/**
	 * 
	 *
	 * 方法说明：管理工作
	 *
	 * @param findTodayManageShop
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月16日
	 *
	 */
	List<FindTodayManageShopReturn> todayManageShopNew(FindTodayManageShop findTodayManageShop) throws TsfaServiceException;

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
	 * 方法说明：根据导购号和时间查询新增客户
	 *
	 * @param memberNo
	 *            导购号
	 * @param date
	 *            时间
	 * @throws TsfaServiceException
	 *
	 * @author 梅宏博 CreateDate: 2017年8月18日
	 *
	 */
	public long findCountPmAddByGmDay(String memberNo, Date date);

	/**
	 * 
	 *
	 * 方法说明：客户分组数量最大一条
	 *
	 * @param findPersonMember
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月18日
	 *
	 */
	public FindPersonMemberReturnList findPersonMemberTypeNum(FindPersonMember findPersonMember) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：统计客户性别
	 *
	 * @param findPersonMember
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 罗书明 CreateDate: 2017年8月18日
	 *
	 */
	public List<FindUrgentMbrPageReturn> findPersonMemberSexCount(FindPersonMember findPersonMember) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：根据导购查客户
	 *
	 * @param findPersonMemberByGm
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 刘培 CreateDate: 2017年8月19日
	 *
	 */
	public List<FindPersonMemberReturn> findPersonMemberByGm(FindPersonMember personMember);

	/**
	 * 
	 *
	 * 方法说明：查找新增客户数量
	 *
	 * @param findNewPmCountDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月18日
	 *
	 */
	int findNewPmCount(FindNewPmCountDto findNewPmCountDto) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：根据导购号和客户类型查询客户数量
	 *
	 * @param findPmType
	 * @return int
	 * @throws TsfaServiceException
	 *
	 * @author 梅宏博 CreateDate: 2017年8月19日
	 *
	 */
	public int findCountPmByType(FindPmType findPmType);

	/**
	 * 
	 *
	 * 方法说明：查询客户分类类型数量排行()
	 *
	 * @param findPersonMember
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月21日
	 *
	 */
	public List<FindPersonMemberReturnList> findPersonMemberTypeList(FindPersonMember findPersonMember);

	/**
	 * 
	 *
	 * 方法说明：统计客户分类客户总数
	 *
	 * @param findPersonMember
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月21日
	 *
	 */
	public int findPersonMemberTypeCount(FindPersonMember findPersonMember);

	/**
	 * 
	 * 方法说明：根据导购编号和商户号查询客户信息
	 *
	 * @param findMemberRecord
	 * @return
	 *
	 * @author 杨杰 CreateDate: 2017年9月5日
	 *
	 */
	public List<FindMemberInfoReturn> findMemberRecord(FindMemberRecord findMemberRecord);

	/**
	 * 
	 * 方法说明：根据时间分组新增客户
	 *
	 * @param findCountPersonMember
	 * @return
	 *
	 * @author 梅宏博 CreateDate: 2017年9月6日
	 *
	 */
	public List<CountPersonMemberReturn> findGroupCountByDay(FindCountPersonMember findCountPersonMember);
	/**
	 * 
	 *
	 * 方法说明：查询客户数
	 *
	 * @param findPersonMember
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年9月9日
	 *
	 */
    public  int findPersonMemberCont(FindPersonMember findPersonMember)throws TsfaServiceException;
}
