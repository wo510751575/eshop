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
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.dao.IMyCollDao;
import com.lj.eshop.domain.MyColl;
import com.lj.eshop.dto.FindMyCollPage;
import com.lj.eshop.dto.MyCollDto;
import com.lj.eshop.service.IMyCollService;

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
 *         CreateDate: 2017-08-22
 */
@Service
public class MyCollServiceImpl implements IMyCollService {

	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(MyCollServiceImpl.class);

	@Resource
	private IMyCollDao myCollDao;

	@Override
	public void addMyColl(MyCollDto myCollDto) throws TsfaServiceException {
		logger.debug("addMyColl(AddMyColl addMyColl={}) - start", myCollDto);

		AssertUtils.notNull(myCollDto);
		try {
			MyColl myColl = new MyColl();
			// add数据录入
			myColl.setProductCode(myCollDto.getProductCode());
			myColl.setMbrCode(myCollDto.getMbrCode());
			myColl.setCreateDate(myCollDto.getCreateDate());
			myCollDao.insertSelective(myColl);
			logger.debug("addMyColl(MyCollDto) - end - return");
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("新增我的收藏信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MY_COLL_ADD_ERROR, "新增我的收藏信息错误！", e);
		}
	}

	/**
	 * 
	 *
	 * 方法说明：不分页查询我的收藏信息
	 *
	 * @param findMyCollPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<MyCollDto> findMyColls(FindMyCollPage findMyCollPage) throws TsfaServiceException {
		AssertUtils.notNull(findMyCollPage);
		List<MyCollDto> returnList = null;
		try {
			returnList = myCollDao.findMyColls(findMyCollPage);
		} catch (Exception e) {
			logger.error("查找我的收藏信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MY_COLL_NOT_EXIST_ERROR, "我的收藏信息不存在");
		}
		return returnList;
	}

	@Override
	public void updateMyColl(MyCollDto myCollDto) throws TsfaServiceException {
		logger.debug("updateMyColl(MyCollDto myCollDto={}) - start", myCollDto); //$NON-NLS-1$

		AssertUtils.notNull(myCollDto);
		AssertUtils.notNullAndEmpty(myCollDto.getMbrCode(), "会员编号不能为空");
		AssertUtils.notNullAndEmpty(myCollDto.getProductCode(), "商品编号不能为空");
		try {
			MyColl myColl = new MyColl();
			// update数据录入
			myColl.setProductCode(myCollDto.getProductCode());
			myColl.setMbrCode(myCollDto.getMbrCode());
			myColl.setCreateDate(myCollDto.getCreateDate());
			AssertUtils.notUpdateMoreThanOne(myCollDao.updateByPrimaryKeySelective(myColl));
			logger.debug("updateMyColl(MyCollDto) - end - return"); //$NON-NLS-1$
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("我的收藏信息更新信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MY_COLL_UPDATE_ERROR, "我的收藏信息更新信息错误！", e);
		}
	}

	@Override
	public MyCollDto findMyColl(MyCollDto myCollDto) throws TsfaServiceException {
		logger.debug("findMyColl(FindMyColl findMyColl={}) - start", myCollDto); //$NON-NLS-1$

		AssertUtils.notNull(myCollDto);
		AssertUtils.notAllNull(myCollDto.getMbrCode(), "会员编号不能为空");
		try {
//			MyColl myColl = myCollDao.selectByPrimaryKey(myCollDto.getMbrCode());
//			if(myColl == null){
//				return null;
			// throw new
			// TsfaServiceException(ErrorCode.MY_COLL_NOT_EXIST_ERROR,"我的收藏信息不存在");
//			}
			MyCollDto findMyCollReturn = new MyCollDto();
			// find数据录入
//			findMyCollReturn.setProductCode(myColl.getProductCode());
//			findMyCollReturn.setMbrCode(myColl.getMbrCode());
//			findMyCollReturn.setCreateDate(myColl.getCreateDate());

			logger.debug("findMyColl(MyCollDto) - end - return value={}", findMyCollReturn); //$NON-NLS-1$
			return findMyCollReturn;
		} catch (TsfaServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("查找我的收藏信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MY_COLL_FIND_ERROR, "查找我的收藏信息信息错误！", e);
		}

	}

	@Override
	public Page<MyCollDto> findMyCollPage(FindMyCollPage findMyCollPage) throws TsfaServiceException {
		logger.debug("findMyCollPage(FindMyCollPage findMyCollPage={}) - start", findMyCollPage); //$NON-NLS-1$

		AssertUtils.notNull(findMyCollPage);
		List<MyCollDto> returnList = null;
		int count = 0;
		try {
			returnList = myCollDao.findMyCollPage(findMyCollPage);
			count = myCollDao.findMyCollPageCount(findMyCollPage);
		} catch (Exception e) {
			logger.error("我的收藏信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.MY_COLL_FIND_PAGE_ERROR, "我的收藏信息不存在错误.！", e);
		}
		Page<MyCollDto> returnPage = new Page<MyCollDto>(returnList, count, findMyCollPage);

		logger.debug("findMyCollPage(FindMyCollPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return returnPage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lj.eshop.service.IProductService#findIndexProductPage(com.lj.eshop.dto.
	 * FindProductPage)
	 */
	@Override
	public Page<MyCollDto> findMyCollProductPage(FindMyCollPage findMyCollPage) throws TsfaServiceException {
		logger.debug("findMyCollPage(FindMyCollPage findMyCollPage={}) - start", findMyCollPage); //$NON-NLS-1$

		AssertUtils.notNull(findMyCollPage);
		List<MyCollDto> returnList = null;
		int count = 0;
		try {
			count = myCollDao.findIndexProductPageCount(findMyCollPage);
			if (count > 0) {
				returnList = myCollDao.findIndexProductPage(findMyCollPage);
			}
		} catch (Exception e) {
			logger.error("我的收藏信息不存在错误", e);
			throw new TsfaServiceException(ErrorCode.MY_COLL_FIND_PAGE_ERROR, "我的收藏信息不存在错误", e);
		}
		Page<MyCollDto> returnPage = new Page<MyCollDto>(returnList, count, findMyCollPage);

		logger.debug("findMyCollPage(FindMyCollPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return returnPage;
	}

	@Override
	public void delMycoll(String[] codes) throws TsfaServiceException {
		myCollDao.delMycoll(codes);
	}

	@Override
	public Integer getCollStatus(String code, String loginMemberCode) {
		return myCollDao.getCollStatus(code, loginMemberCode);
	}

	@Override
	public void delColl(String loginMemberCode, String code) {
		myCollDao.delColl(loginMemberCode, code);
	}

}
