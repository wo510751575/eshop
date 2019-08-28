package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.dao.IAddrsDao;
import com.lj.eshop.domain.Addrs;
import com.lj.eshop.dto.AddrsDto;
import com.lj.eshop.dto.FindAddrsPage;
import com.lj.eshop.service.IAddrsService;
/**
 * 类说明：实现类
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
@Service
public class AddrsServiceImpl implements IAddrsService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(AddrsServiceImpl.class);
	

	@Resource
	private IAddrsDao addrsDao;
	
	
	@Override
	public void addAddrs(
			AddrsDto addrsDto) throws TsfaServiceException {
		logger.debug("addAddrs(AddAddrs addAddrs={}) - start", addrsDto); 

		AssertUtils.notNull(addrsDto);
		try {
			Addrs addrs = new Addrs();
			//add数据录入
			addrs.setCode(GUID.generateCode());
			addrs.setReciverName(addrsDto.getReciverName());
			addrs.setReciverPhone(addrsDto.getReciverPhone());
			addrs.setReciverZip(addrsDto.getReciverZip());
			addrs.setMbrCode(addrsDto.getMbrCode());
			addrs.setAddrInfo(addrsDto.getAddrInfo());
			addrs.setIsDefault(addrsDto.getIsDefault());
			addrs.setProvinceCode(addrsDto.getProvinceCode());
			addrs.setCityCode(addrsDto.getCityCode());
			addrs.setAreCode(addrsDto.getAreCode());
			addrs.setAddrDetail(addrsDto.getAddrDetail());
			addrs.setCreateTime(addrsDto.getCreateTime());
			addrs.setDelFlag(addrsDto.getDelFlag());
			addrsDao.insertSelective(addrs);
			logger.debug("addAddrs(AddrsDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增收货地址信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ADDRS_ADD_ERROR,"新增收货地址信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询收货地址信息
	 *
	 * @param findAddrsPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<AddrsDto>  findAddrss(FindAddrsPage findAddrsPage)throws TsfaServiceException{
		AssertUtils.notNull(findAddrsPage);
		List<AddrsDto> returnList=null;
		try {
			returnList = addrsDao.findAddrss(findAddrsPage);
		} catch (Exception e) {
			logger.error("查找收货地址信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.ADDRS_NOT_EXIST_ERROR,"收货地址信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateAddrs(
			AddrsDto addrsDto)
			throws TsfaServiceException {
		logger.debug("updateAddrs(AddrsDto addrsDto={}) - start", addrsDto); //$NON-NLS-1$

		AssertUtils.notNull(addrsDto);
		AssertUtils.notNullAndEmpty(addrsDto.getCode(),"Code不能为空");
		try {
			Addrs addrs = new Addrs();
			//update数据录入
			addrs.setCode(addrsDto.getCode());
			addrs.setReciverName(addrsDto.getReciverName());
			addrs.setReciverPhone(addrsDto.getReciverPhone());
			addrs.setReciverZip(addrsDto.getReciverZip());
			addrs.setMbrCode(addrsDto.getMbrCode());
			addrs.setAddrInfo(addrsDto.getAddrInfo());
			addrs.setIsDefault(addrsDto.getIsDefault());
			addrs.setProvinceCode(addrsDto.getProvinceCode());
			addrs.setCityCode(addrsDto.getCityCode());
			addrs.setAreCode(addrsDto.getAreCode());
			addrs.setAddrDetail(addrsDto.getAddrDetail());
			addrs.setCreateTime(addrsDto.getCreateTime());
			addrs.setDelFlag(addrsDto.getDelFlag());
			AssertUtils.notUpdateMoreThanOne(addrsDao.updateByPrimaryKeySelective(addrs));
			logger.debug("updateAddrs(AddrsDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("收货地址信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ADDRS_UPDATE_ERROR,"收货地址信息更新信息错误！",e);
		}
	}

	

	@Override
	public AddrsDto findAddrs(
			AddrsDto addrsDto) throws TsfaServiceException {
		logger.debug("findAddrs(FindAddrs findAddrs={}) - start", addrsDto); //$NON-NLS-1$

		AssertUtils.notNull(addrsDto);
		AssertUtils.notAllNull(addrsDto.getCode(),"Code不能为空");
		try {
			Addrs addrs = addrsDao.selectByPrimaryKey(addrsDto.getCode());
			if(addrs == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.ADDRS_NOT_EXIST_ERROR,"收货地址信息不存在");
			}
			AddrsDto findAddrsReturn = new AddrsDto();
			//find数据录入
			findAddrsReturn.setCode(addrs.getCode());
			findAddrsReturn.setReciverName(addrs.getReciverName());
			findAddrsReturn.setReciverPhone(addrs.getReciverPhone());
			findAddrsReturn.setReciverZip(addrs.getReciverZip());
			findAddrsReturn.setMbrCode(addrs.getMbrCode());
			findAddrsReturn.setAddrInfo(addrs.getAddrInfo());
			findAddrsReturn.setIsDefault(addrs.getIsDefault());
			findAddrsReturn.setProvinceCode(addrs.getProvinceCode());
			findAddrsReturn.setCityCode(addrs.getCityCode());
			findAddrsReturn.setAreCode(addrs.getAreCode());
			findAddrsReturn.setAddrDetail(addrs.getAddrDetail());
			findAddrsReturn.setCreateTime(addrs.getCreateTime());
			
			logger.debug("findAddrs(AddrsDto) - end - return value={}", findAddrsReturn); //$NON-NLS-1$
			return findAddrsReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找收货地址信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ADDRS_FIND_ERROR,"查找收货地址信息信息错误！",e);
		}


	}

	
	@Override
	public Page<AddrsDto> findAddrsPage(
			FindAddrsPage findAddrsPage)
			throws TsfaServiceException {
		logger.debug("findAddrsPage(FindAddrsPage findAddrsPage={}) - start", findAddrsPage); //$NON-NLS-1$

		AssertUtils.notNull(findAddrsPage);
		List<AddrsDto> returnList=null;
		int count = 0;
		try {
			returnList = addrsDao.findAddrsPage(findAddrsPage);
			count = addrsDao.findAddrsPageCount(findAddrsPage);
		}  catch (Exception e) {
			logger.error("收货地址信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.ADDRS_FIND_PAGE_ERROR,"收货地址信息不存在错误.！",e);
		}
		Page<AddrsDto> returnPage = new Page<AddrsDto>(returnList, count, findAddrsPage);

		logger.debug("findAddrsPage(FindAddrsPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	@Override
	public void updateAddrsByMbr(AddrsDto addrsDto) throws TsfaServiceException {
		logger.debug("updateAddrsByMbr(AddrsDto addrsDto={}) - start", addrsDto); //$NON-NLS-1$

		AssertUtils.notNull(addrsDto);
		AssertUtils.notNullAndEmpty(addrsDto.getMbrCode(),"Code不能为空");
		try {
			Addrs addrs = new Addrs();
			//update数据录入
			addrs.setMbrCode(addrsDto.getMbrCode());
			addrs.setIsDefault(addrsDto.getIsDefault());
			addrsDao.updateByMbrcode(addrs);
			logger.debug("updateAddrsByMbr(AddrsDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("默认收货地址信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.ADDRS_UPDATE_ERROR,"默认收货地址信息更新信息错误！",e);
		}
		
	} 


}
