package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.CodeCheckDto;
import com.lj.eshop.dto.FindCodeCheckPage;


import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;

import java.util.List;
/**
 * 类说明：接口类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author lhy
 * 
 * 
 * CreateDate: 2017-08-22
 */
public interface ICodeCheckService {
	
	/**
	 * 
	 *
	 * 方法说明：添加验证码信息
	 *
	 * @param codeCheckDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addCodeCheck(CodeCheckDto codeCheckDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找验证码信息
	 *
	 * @param findCodeCheck
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public CodeCheckDto findCodeCheck(CodeCheckDto codeCheckDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询验证码信息
	 *
	 * @param findCodeCheckPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<CodeCheckDto>  findCodeChecks(FindCodeCheckPage findCodeCheckPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改验证码信息
	 *
	 * @param updateCodeCheck
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateCodeCheck(CodeCheckDto codeCheckDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询验证码信息
	 *
	 * @param findCodeCheckPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<CodeCheckDto> findCodeCheckPage(FindCodeCheckPage findCodeCheckPage) throws TsfaServiceException;
	

}
