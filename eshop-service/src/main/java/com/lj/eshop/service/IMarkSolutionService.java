package com.lj.eshop.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.eshop.dto.MarkSolutionDto;
import com.lj.eshop.dto.FindMarkSolutionPage;


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
public interface IMarkSolutionService {
	
	/**
	 * 
	 *
	 * 方法说明：添加以租代购信息
	 *
	 * @param markSolutionDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void addMarkSolution(MarkSolutionDto markSolutionDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找以租代购信息
	 *
	 * @param findMarkSolution
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public MarkSolutionDto findMarkSolution(MarkSolutionDto markSolutionDto) throws TsfaServiceException;
	
	
	/**
	 * 
	 *
	 * 方法说明：不分页查询以租代购信息
	 *
	 * @param findMarkSolutionPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public List<MarkSolutionDto>  findMarkSolutions(FindMarkSolutionPage findMarkSolutionPage)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：修改以租代购信息
	 *
	 * @param updateMarkSolution
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public void updateMarkSolution(MarkSolutionDto markSolutionDto)throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：分页查询以租代购信息
	 *
	 * @param findMarkSolutionPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	public Page<MarkSolutionDto> findMarkSolutionPage(FindMarkSolutionPage findMarkSolutionPage) throws TsfaServiceException;
	

}
