package com.lj.business.cf.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.business.cf.dto.workTaskChoose.AddWorkTaskChooseDto;
import com.lj.business.cf.dto.workTaskChoose.EditWorkTaskChooseDto;
import com.lj.business.cf.dto.workTaskChoose.FindWorkTaskChoose;
import com.lj.business.cf.dto.workTaskChoose.FindWorkTaskChoosePageDto;
import com.lj.business.cf.dto.workTaskChoose.WorkTaskChooseReturnDto;


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
public interface IWorkTaskChooseService {
	/**
	 * 
	 *
	 * 方法说明：新增工作事项选择表
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日	
	 *
	 */
	public void addWorkTaskChoose(AddWorkTaskChooseDto addWorkTaskChooseDto);
	
	/**
	 * 
	 *
	 * 方法说明：编辑工作事项选择表
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	public void editWorkTaskChoose(EditWorkTaskChooseDto editWorkTaskChooseDto);
	
	/**
	 * 
	 *
	 * 方法说明：根据主键查询工作事项选择表
	 *
	 * @param code
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	public WorkTaskChooseReturnDto selectByCode(EditWorkTaskChooseDto editWorkTaskChooseDto);
	
	/**
	 * 
	 *
	 * 方法说明：查询 工作事项选择
	 *
	 * @param findWorkTaskChoose
	 * @return
	 *
	 * @author 彭阳 CreateDate: 2017年8月8日
	 *
	 */
	public WorkTaskChooseReturnDto findWorkTaskChoose(FindWorkTaskChoose findWorkTaskChoose);
	
	/**
	 * 
	 *
	 * 方法说明：查找工作事项选择表(不分页)
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	public List<FindWorkTaskChoosePageDto> findWorkTaskChooses(FindWorkTaskChoosePageDto findWorkTaskChoosePageDto);
	
	/**
	 * 
	 *
	 * 方法说明：查找工作事项选择表(分页)
	 *
	 * @param exGuider
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	public Page<FindWorkTaskChoosePageDto> findWorkTaskChoosePage(FindWorkTaskChoosePageDto findWorkTaskChoosePageDto);
	
	/**
	 * 
	 *
	 * 方法说明：删除已选择的工作事项
	 * OMS-绑定工作事项所需
	 *
	 * @param code
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月5日
	 *
	 */
	public int delWorkTaskChooseBymerchantNo(String code);

	/**
	 * 根据商户编号列表查询任务
	 * @param merchantNoList 商户编号列表
	 * @return
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月25日
	 */
	List<FindWorkTaskChoosePageDto> findWorkTaskChooseByMerchantNo(List<String> merchantNoList);
}
