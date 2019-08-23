package com.lj.business.member.service;

import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.domain.MemLine;
import com.lj.business.member.dto.MemLineDto;


/**
 * 类说明：接口类
 * 导购
 * 
 * <p>
 * 详细描述：.
 *
 * @author XX
 * 
 * 
 * CreateDate: 2017-06-14
 */
public interface IMemLineService {
	
	/**
	 * 方法说明：添加行业表信息.
	 *
	 * @param memLine the mem line
	 * @return the int
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年9月9日
	 */
	public int addMemLine(MemLineDto memLine) throws TsfaServiceException;
	
	/**
	 * 方法说明：查找行业表信息.
	 *
	 * @param memLine the mem line
	 * @return the mem line dto
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public MemLineDto findMemLine(MemLineDto memLine) throws TsfaServiceException;
	
	
    
	/**
	 * 方法说明：修改行业表信息.
	 *
	 * @param memLine the mem line
	 * @return the int
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public int updateMemLine(MemLineDto memLine)throws TsfaServiceException;

	/**
	 * 方法说明：查找行业表信息.
	 *
	 * @param memLine the mem line
	 * @return the page< mem line dto>
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public Page<MemLineDto> findMemLinePage(MemLineDto memLineDto) throws TsfaServiceException;
	
	

	/**
	 * 方法说明：查找客户所有行业表信息.
	 *
	 * @param merchantNo the merchant no
	 * @return List
	 * @throws TsfaServiceException the tsfa service exception
	 * @author rain CreateDate: 2017年7月3日
	 */
	public List<MemLine> inqueryMemberJobInfo(String merchantNo)throws TsfaServiceException;
	
	public  MemLineDto selectByName(MemLineDto memLineDto)throws TsfaServiceException;
}
