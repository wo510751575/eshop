package com.lj.business.cf.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.business.cf.dto.cfErrorInfo.AddCfErrorInfoDto;
import com.lj.business.cf.dto.cfErrorInfo.CfErrorInfoReturnDto;
import com.lj.business.cf.dto.cfErrorInfo.EditCfErrorInfoDto;
import com.lj.business.cf.dto.cfErrorInfo.FindCfErrorInfoPageDto;


/**
 * 类说明：接口类
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
public interface ICfErrorInfoService {
	/**
	 * 
	 *
	 * 方法说明：新增跟进异常情况表
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	public void addCfErrorInfo(AddCfErrorInfoDto addCfErrorInfoDto);
	
	/**
	 * 
	 *
	 * 方法说明：编辑跟进异常情况表
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	public void editCfErrorInfo(EditCfErrorInfoDto editCfErrorInfoDto);
	
	/**
	 * 
	 *
	 * 方法说明：根据主键查询跟进异常情况表
	 *
	 * @param code
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	public CfErrorInfoReturnDto selectByCode(String code);
	
	/**
	 * 
	 *
	 * 方法说明：查找跟进异常情况表(不分页)
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	public List<FindCfErrorInfoPageDto> findCfErrorInfos(FindCfErrorInfoPageDto findCfErrorInfoPageDto);
	
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
	public Page<FindCfErrorInfoPageDto> findCfErrorInfoPage(FindCfErrorInfoPageDto findCfErrorInfoPageDto);
	
}
