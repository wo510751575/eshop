package com.lj.business.member.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.business.member.dto.AddInterestPmDto;
import com.lj.business.member.dto.EditInterestPmDto;
import com.lj.business.member.dto.FindInterestPmPageDto;
import com.lj.business.member.dto.InterestPmReturnDto;



/**
 * 类说明：服务协议接口类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 邹磊
 * 	
 * 
 * CreateDate: 2017年7月1日
 */
public interface IInterestPmService {
	
	/**
	 * 方法说明：新增产品.
	 *
	 * @param addInterestPmDto the add interest pm dto
	 * @author 邹磊 CreateDate: 2017年7月1日
	 */
	public void addInterestPm(AddInterestPmDto addInterestPmDto);
	
	/**
	 * 方法说明：编辑产品.
	 *
	 * @param editInterestPmDto the edit interest pm dto
	 * @author 邹磊 CreateDate: 2017年7月1日
	 */
	public void editInterestPm(EditInterestPmDto editInterestPmDto);
	
	/**
	 * 方法说明：根据主键查询产品.
	 *
	 * @param code the code
	 * @return the interest pm return dto
	 * @author 邹磊 CreateDate: 2017年7月1日
	 */
	public InterestPmReturnDto selectByCode(String code);
	
	/**
	 * 方法说明：查找产品(不分页).
	 *
	 * @param findInterestPmPageDto the find interest pm page dto
	 * @return the list< find interest pm page dto>
	 * @author 邹磊 CreateDate: 2017年7月1日
	 */
	public List<FindInterestPmPageDto> findInterestPms(FindInterestPmPageDto findInterestPmPageDto);
	
	/**
	 * 方法说明：查找优秀员工(分页).
	 *
	 * @param findInterestPmPageDto the find interest pm page dto
	 * @return the page< find interest pm page dto>
	 * @author 邹磊 CreateDate: 2017年7月1日
	 */
	public Page<FindInterestPmPageDto> findInterestPmPage(FindInterestPmPageDto findInterestPmPageDto);
	
}
