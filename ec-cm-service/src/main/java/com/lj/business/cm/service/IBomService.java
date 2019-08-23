package com.lj.business.cm.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.business.cm.dto.EditBomDto;
import com.lj.business.cm.dto.FindBomPageDto;



/**
 * 类说明：产品接口类
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
public interface IBomService {
	/**
	 * 
	 *
	 * 方法说明：新增产品
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月28日
	 *
	 */
	public EditBomDto addBom(EditBomDto bom);
	
	/**
	 * 
	 *
	 * 方法说明：编辑产品
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月28日
	 *
	 */
	public EditBomDto editBom(EditBomDto bom);
	
	/**
	 * 
	 *
	 * 方法说明：根据主键查询产品
	 *
	 * @param code
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月29日
	 *
	 */
	public EditBomDto selectByCode(String code);
	
	/**
	 * 
	 *
	 * 方法说明：查找产品(不分页)
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月28日
	 *
	 */
	public List<FindBomPageDto> findBoms(FindBomPageDto findBomPageDto);
	
	/**
	 * 
	 *
	 * 方法说明：查找优秀员工(分页)
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月28日
	 *
	 */
	public Page<FindBomPageDto> findBomPage(FindBomPageDto findBomPageDto);
	
}
