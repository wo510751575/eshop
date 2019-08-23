package com.lj.business.member.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.domain.GuidMember;
import com.lj.business.member.dto.AddGuidMember;
import com.lj.business.member.dto.AddGuidMemberDto;
import com.lj.business.member.dto.AddGuidMemberReturn;
import com.lj.business.member.dto.DelGuidMember;
import com.lj.business.member.dto.DelGuidMemberReturn;
import com.lj.business.member.dto.FindGuidMember;
import com.lj.business.member.dto.FindGuidMemberDto;
import com.lj.business.member.dto.FindGuidMemberPage;
import com.lj.business.member.dto.FindGuidMemberPageReturn;
import com.lj.business.member.dto.FindGuidMemberReturn;
import com.lj.business.member.dto.FindShopGmDto;
import com.lj.business.member.dto.FindShopGmReturn;
import com.lj.business.member.dto.GuidInfoShop;
import com.lj.business.member.dto.GuidMemberReturnDto;
import com.lj.business.member.dto.UpdateGuidMember;
import com.lj.business.member.dto.UpdateGuidMemberReturn;
import com.lj.business.member.dto.UpdatePwdDto;

/**
 * 类说明：接口类 导购
 * 
 * <p>
 * 详细描述：.
 *
 * @author 彭阳
 * 
 * 
 *         CreateDate: 2017-06-14
 */
public interface IGuidMemberService {

	/**
	 * 方法说明：添加导购表信息.
	 *
	 * @param addGuidMember
	 *            the add guid member
	 * @return the adds the guid member return
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public AddGuidMemberReturn addGuidMember(AddGuidMember addGuidMember) throws TsfaServiceException;

	public List<FindShopGmReturn> findShopGmPy(FindShopGmDto findShopGmDto) throws TsfaServiceException;
	
	/**
	 * 方法说明：查找导购表信息.
	 *
	 * @param findGuidMember
	 *            the find guid member
	 * @return the find guid member return
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public FindGuidMemberReturn findGuidMember(FindGuidMember findGuidMember) throws TsfaServiceException;

	/**
	 * 方法说明：删除导购表信息.
	 *
	 * @param delGuidMember
	 *            the del guid member
	 * @return the del guid member return
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public DelGuidMemberReturn delGuidMember(DelGuidMember delGuidMember) throws TsfaServiceException;

	/**
	 * 方法说明：修改导购表信息.
	 *
	 * @param updateGuidMember
	 *            the update guid member
	 * @return the update guid member return
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public UpdateGuidMemberReturn updateGuidMember(UpdateGuidMember updateGuidMember) throws TsfaServiceException;

	/**
	 * 方法说明：查找导购表信息.
	 *
	 * @param findGuidMemberPage
	 *            the find guid member page
	 * @return the page< find guid member page return>
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public Page<FindGuidMemberPageReturn> findGuidMemberPage(FindGuidMemberPage findGuidMemberPage) throws TsfaServiceException;

	/**
	 * 方法说明：导出店员Excel.
	 *
	 * @param findGuidMemberPage
	 *            the find guid member page
	 * @return the page< find guid member page return>
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 刘培 CreateDate: 2017年08月10日
	 */
	public List<FindGuidMemberPageReturn> findGuidMemberExport(FindGuidMemberPage findGuidMemberPage) throws TsfaServiceException;

	/**
	 * 方法说明：查询导购列表.
	 *
	 * @param findGuidMemberPage
	 *            the find guid member page
	 * @return the list< find guid member page return>
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 段志鹏 CreateDate: 2017年6月23日
	 */
	public List<FindGuidMemberPageReturn> findGuidMembers(FindGuidMemberPage findGuidMemberPage) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：查询导购列表.
	 *
	 * @param findGuidMemberPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月22日
	 *
	 */
	public List<FindGuidMemberPageReturn> findGuidMembersNoSelf(FindGuidMemberPage findGuidMemberPage) throws TsfaServiceException;

	/**
	 * 方法说明：查找导购信息(个人中心).
	 *
	 * @param findGuidMemberDto
	 *            the find guid member dto
	 * @return the guid member return dto
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 邹磊 CreateDate: 2017年7月11日
	 */
	public GuidMemberReturnDto findGuid(FindGuidMemberDto findGuidMemberDto) throws TsfaServiceException;

	/**
	 * 方法说明：添加个人中心导购信息.
	 *
	 * @param addGuidMemberDto
	 *            the add guid member dto
	 * @throws TsfaServiceException
	 *             the tsfa service exception
	 * @author 邹磊 CreateDate: 2017年7月11日
	 */
	public void addGuidMember(AddGuidMemberDto addGuidMemberDto) throws TsfaServiceException;

	/***
	 * 
	 *
	 * 方法说明：按主键查询信息
	 *
	 * @param updateGuidMember
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年7月18日
	 *
	 */
	public GuidMemberReturnDto findGuidMemberByCode(UpdateGuidMember updateGuidMember);

	/**
	 * 
	 *
	 * 方法说明：根据商户号和分店编号查找导购列表
	 *
	 * @param findGuidMember
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年7月20日
	 *
	 */
	public List<GuidMemberReturnDto> findGuidMemberList(FindGuidMemberDto findGuidMemberDto) throws TsfaServiceException;

	/**
	 * 方法说明：分页获取有效的导购
	 *
	 * @param currentPage
	 *            当前页
	 * @param limit
	 *            显示条数
	 * @return
	 * @throws TsfaServiceException
	 * @author 武鹏飞 CreateDate: 2017年7月25日
	 */
	Page<FindGuidMemberPageReturn> findGuidMemberPage(int currentPage, int limit);

	/**
	 * 
	 *
	 * 方法说明：统计导购数量
	 *
	 * @param findGuidMemberPage
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月26日
	 *
	 */
	int findGuidMemberCount(FindGuidMemberPage findGuidMemberPage);

	/**
	 * 
	 *
	 * 方法说明：统计导购数量根据商户号
	 *
	 * @param findGuidMemberPage
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年8月2日
	 *
	 */
	int findGuidMemberByMerchantNo(FindGuidMemberPage findGuidMemberPage);

	/**
	 * 
	 *
	 * 方法说明：查找导购与门店信息
	 *
	 * @param findGuidMemberDto
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月4日
	 *
	 */
	public List<GuidInfoShop> findGuidInfoShop(FindGuidMemberDto findGuidMemberDto);

	/**
	 * 
	 *
	 * 方法说明：查找分店下的导购排除自己
	 *
	 * @param findShopGmDto
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年8月8日
	 *
	 */
	public List<FindShopGmReturn> findShopGm(FindShopGmDto findShopGmDto) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改导购密码
	 *
	 * @param updatePwdDto.pwd 一次md5加密
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月9日
	 *
	 */
	public void updatePwd(UpdatePwdDto updatePwdDto) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：查询所有的导购
	 *
	 * @param guidMember
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 杨杰 CreateDate: 2017年9月7日
	 *
	 */
	public List<GuidMember> findGuidMember(GuidMember guidMember) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：获取每个顾问未分组的客户数量
	 *
	 * @param guidMember
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 杨杰 CreateDate: 2017年9月7日
	 *
	 */
	public int findPersonUngroupCount(GuidMember guidMember) throws TsfaServiceException;

	/**
	 * 方法说明：根据手机号查找 导购信息.
	 *
	 * @param moblie 手机号
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy  2017年9月19日
	 *
	 */
	public FindGuidMemberReturn findGuidMemberByMoblie_ec(String moblie) throws TsfaServiceException;
	
	/**
	 * 方法说明：电商新增导购。
	 * @param addGuidMember 
	 * @throws TsfaServiceException
	 *
	 * @author lhy  2017年9月20日
	 *
	 */
	public AddGuidMemberReturn addGuidMember_ec(AddGuidMember addGuidMember) throws TsfaServiceException;
}
