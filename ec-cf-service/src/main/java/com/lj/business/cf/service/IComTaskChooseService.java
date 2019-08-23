package com.lj.business.cf.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.FindComTaskChooseByCode;
import com.lj.business.cf.dto.FindComTaskChooseByCodeReturnDto;
import com.lj.business.cf.dto.comTaskChoose.AddComTaskChooseDto;
import com.lj.business.cf.dto.comTaskChoose.ComTaskChooseReturnDto;
import com.lj.business.cf.dto.comTaskChoose.EditComTaskChooseDto;
import com.lj.business.cf.dto.comTaskChoose.FindComTaskChoose;
import com.lj.business.cf.dto.comTaskChoose.FindComTaskChooseIndex;
import com.lj.business.cf.dto.comTaskChoose.FindComTaskChooseIndexReturn;
import com.lj.business.cf.dto.comTaskChoose.FindComTaskChoosePageDto;


/**
 * 类说明：客户沟通任务选择表接口类
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
public interface IComTaskChooseService {
	

	/**
	 * 
	 *
	 * 方法说明：沟通任务首页：沟通任务分类信息查询_APP
	 *
	 * @param findComTaskChooseIndex
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年7月17日
	 *
	 */
	public List<FindComTaskChooseIndexReturn> findComTaskChooseIndex(FindComTaskChooseIndex findComTaskChooseIndex)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：新增客户沟通任务选择表
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	public void addComTaskChoose(AddComTaskChooseDto addComTaskChooseDto);
	
		
	
	/**
	 * 
	 *
	 * 方法说明：编辑客户沟通任务选择表
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	public void editComTaskChoose(EditComTaskChooseDto editComTaskChooseDto);
	
	/**
	 * 
	 *
	 * 方法说明：根据主键查询客户沟通任务选择表
	 *
	 * @param code
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	public ComTaskChooseReturnDto selectByCode(String code);

	/**
	 * 
	 *
	 * 方法说明：查找客户沟通任务选择
	 *
	 * @param findComTaskChoose
	 * @return
	 *
	 * @author 彭阳 CreateDate: 2017年8月9日
	 *
	 */
	public ComTaskChooseReturnDto findComTaskChoose(FindComTaskChoose findComTaskChoose);
	
	
	/**
	 * 
	 *
	 * 方法说明：根据code查询任务选择表
	 *
	 * @param findComTaskChooseByCode
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年8月15日
	 *
	 */
	public FindComTaskChooseByCodeReturnDto findComTaskChooseByCode(FindComTaskChooseByCode findComTaskChooseByCode);

	
	/**
	 * 
	 *
	 * 方法说明：查找客户沟通任务选择表(不分页)
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	public List<FindComTaskChoosePageDto> findComTaskChooses(FindComTaskChoosePageDto findComTaskChoosePageDto);
	
	/**
	 * 
	 *
	 * 方法说明：查找客户沟通任务选择表(分页)
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	public Page<FindComTaskChoosePageDto> findComTaskChoosePage(FindComTaskChoosePageDto findComTaskChoosePageDto);
	
	/**
	 * 
	 *
	 * 方法说明：删除已选择项，根据商户
	 *
	 * @param merchantNo
	 *
	 * @author 段志鹏 CreateDate: 2017年7月6日
	 *
	 */
	public void delComTaskChooseByMerchantNo(String merchantNo);
	
	/**
	 * 
	 *
	 * 方法说明：app用选取任务类型  排除分组和初次介绍任务
	 *
	 * @param findComTaskChoosePageDto
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年8月9日
	 *
	 */
	public List<FindComTaskChoosePageDto> findComTaskChoosesApp(FindComTaskChoosePageDto findComTaskChoosePageDto);
	
	/**
	 * 
	 *
	 * 方法说明：app用选取任务类型
	 *
	 * @param findComTaskChoosePageDto
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年8月15日
	 *
	 */
	public List<FindComTaskChoosePageDto> findComTaskChoosesNewApp(FindComTaskChoosePageDto findComTaskChoosePageDto);
	
}
