/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.member.service;

import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.dto.AddPersonMemberBase;
import com.lj.business.member.dto.AddPersonMemberBaseReturn;
import com.lj.business.member.dto.DelPersonMemberBase;
import com.lj.business.member.dto.DelPersonMemberBaseReturn;
import com.lj.business.member.dto.FindPersonMemberBase;
import com.lj.business.member.dto.FindPersonMemberBaseList;
import com.lj.business.member.dto.FindPersonMemberBasePage;
import com.lj.business.member.dto.FindPersonMemberBasePageReturn;
import com.lj.business.member.dto.FindPersonMemberBaseReturn;
import com.lj.business.member.dto.FindPersonMemberBaseReturnList;
import com.lj.business.member.dto.FindPersonMemberName;
import com.lj.business.member.dto.UpdatePersonMemberBase;
import com.lj.business.member.dto.UpdatePersonMemberBaseRatioClientInfoDto;
import com.lj.business.member.dto.UpdatePersonMemberBaseReturn;

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
 * CreateDate: 2017年9月18日
 */
public interface IEcPersonMemberBaseService {

	
	/**
	 * 方法说明：添加客户基础信息.
	 *
	 * @param addPersonMemberBase the add person member base
	 * @return the adds the person member base return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public AddPersonMemberBaseReturn addPersonMemberBase(AddPersonMemberBase addPersonMemberBase) throws TsfaServiceException;
	
	/**
	 * 方法说明：查找客户基础信息.
	 *
	 * @param findPersonMemberBase the find person member base
	 * @return the find person member base return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public FindPersonMemberBaseReturn findPersonMemberBase(FindPersonMemberBase findPersonMemberBase) throws TsfaServiceException;
	
	
	/**
	 * 方法说明：删除客户基础信息.
	 *
	 * @param delPersonMemberBase the del person member base
	 * @return the del person member base return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public DelPersonMemberBaseReturn delPersonMemberBase(DelPersonMemberBase delPersonMemberBase) throws TsfaServiceException;

	/**
	 * 方法说明：修改客户基础信息.
	 *
	 * @param updatePersonMemberBase the update person member base
	 * @return the update person member base return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public UpdatePersonMemberBaseReturn updatePersonMemberBase(UpdatePersonMemberBase updatePersonMemberBase)throws TsfaServiceException;

	/**
	 * 方法说明：查找客户基础信息.
	 *
	 * @param findPersonMemberBasePage the find person member base page
	 * @return the page< find person member base page return>
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public Page<FindPersonMemberBasePageReturn> findPersonMemberBasePage(FindPersonMemberBasePage findPersonMemberBasePage) throws TsfaServiceException;
	
	/**
	 * 方法说明：根据手机号查找客户基础信息.
	 *
	 * @param mobile the mobile
	 * @return the find person member base return
	 * @author 段志鹏 CreateDate: 2017年7月13日
	 */
	FindPersonMemberBaseReturn findByMobile(FindPersonMemberBase findPersonMemberBase);
	
    /**
     * 
     *
     * 方法说明：根据编码获取客户姓名
     *
     * @param codeList
     * @return
     *
     * @author 武鹏飞 CreateDate: 2017年7月21日
     *
     */
    List<FindPersonMemberName> findByCodeList(List<String> codeList);
    /**
     * 
     *
     * 方法说明：OMS根据客户编号查询
     *
     * @param findPersonMemberBaseList
     * @return
     *
     * @author 罗书明 CreateDate: 2017年7月22日
     *
     */
    public  FindPersonMemberBaseReturnList findPersonMemberBaseList(FindPersonMemberBaseList findPersonMemberBaseList)throws TsfaServiceException;
    /***
     * 
     *
     * 方法说明：根据省/区域查询客户数量
     *
     * @param findPersonMemberBaseList
     * @return
     * @throws TsfaServiceException
     *
     * @author 罗书明 CreateDate: 2017年8月7日
     *
     */
    public  FindPersonMemberBaseReturnList findPersonMemberBaseCounts(FindPersonMemberBaseList findPersonMemberBaseList)throws TsfaServiceException;
    
    /**
     * 
     *
     * 方法说明：修改完成度
     *
     * @param dto
     * @throws TsfaServiceException
     *
     * @author 冯辉 CreateDate: 2017年8月17日
     *
     */
    public void updatePersonMemberBaseRatioClientInfo(UpdatePersonMemberBaseRatioClientInfoDto dto) throws TsfaServiceException;
    
    /**
     * 
     *
     * 方法说明：查询性别分组客户数最多的客户的性别
     *
     * @return
     * @throws TsfaServiceException
     *
     * @author 罗书明 CreateDate: 2017年8月18日
     *
     */
    public FindPersonMemberBaseReturnList findPersonMemberMax()throws TsfaServiceException;
    /**
     * 
     *
     * 方法说明：查询区域客户数
     *
     * @return
     * @throws TsfaServiceException
     *
     * @author 罗书明 CreateDate: 2017年8月18日
     *
     */
    public  List<FindPersonMemberBaseList> findPersonMemberBaseMemberCount(FindPersonMemberBase findPersonMemberBase)throws TsfaServiceException;
    /**
     * 
     *
     * 方法说明：新增客户数查询
     *
     * @param findPersonMemberBaseList
     * @return
     * @throws TsfaServiceException
     *
     * @author 罗书明 CreateDate: 2017年8月28日
     *
     */
    public int findPersonMemberBaseNumAdd(FindPersonMemberBaseList findPersonMemberBaseList)throws TsfaServiceException;
     /**
      * 
      *
      * 方法说明：昵称备注_本地
      *
      * @param findPersonMemberBase
      * @return
      *
      * @author 罗书明 CreateDate: 2017年9月5日
      *
      */
    public FindPersonMemberBaseReturn findPersonMemberBaseParams(FindPersonMemberBase findPersonMemberBase) throws TsfaServiceException ;
    
}
