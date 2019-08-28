package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;
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
import com.lj.eshop.dao.IEvlLikeDao;
import com.lj.eshop.dao.IEvlProductDao;
import com.lj.eshop.domain.EvlLike;
import com.lj.eshop.domain.EvlProduct;
import com.lj.eshop.dto.EvlLikeDto;
import com.lj.eshop.dto.FindEvlLikePage;
import com.lj.eshop.dto.UpdateProductCntDto;
import com.lj.eshop.service.IEvlLikeService;
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
public class EvlLikeServiceImpl implements IEvlLikeService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(EvlLikeServiceImpl.class);
	

	@Resource
	private IEvlLikeDao evlLikeDao;
	@Resource
	private IEvlProductDao evlProductDao;
	
	@Override
	public void addEvlLike(
			EvlLikeDto evlLikeDto) throws TsfaServiceException {
		logger.debug("addEvlLike(AddEvlLike addEvlLike={}) - start", evlLikeDto); 

		AssertUtils.notNull(evlLikeDto);
		try {
			EvlLike evlLike = new EvlLike();
			//add数据录入
			evlLike.setCode(GUID.generateCode());
			evlLike.setMbrCode(evlLikeDto.getMbrCode());
			evlLike.setEvlCode(evlLikeDto.getEvlCode());
			evlLike.setCreateTime(new Date());
			evlLikeDao.insertSelective(evlLike);
			
			//二： 给评论点赞数累加一
			EvlProduct evl=evlProductDao.selectByPrimaryKey(evlLikeDto.getEvlCode());
			//查出来加一
			EvlProduct updateEvl=new EvlProduct();
			updateEvl.setGoodCnt(evl.getGoodCnt()+1);
			updateEvl.setCode(evlLikeDto.getEvlCode());
			evlProductDao.updateByPrimaryKeySelective(updateEvl);
			logger.debug("addEvlLike(EvlLikeDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增商品评价点赞记录信息错误！",e);
			throw new TsfaServiceException(ErrorCode.EVL_LIKE_ADD_ERROR,"新增商品评价点赞记录信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询商品评价点赞记录信息
	 *
	 * @param findEvlLikePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<EvlLikeDto>  findEvlLikes(FindEvlLikePage findEvlLikePage)throws TsfaServiceException{
		AssertUtils.notNull(findEvlLikePage);
		List<EvlLikeDto> returnList=null;
		try {
			returnList = evlLikeDao.findEvlLikes(findEvlLikePage);
		} catch (Exception e) {
			logger.error("查找商品评价点赞记录信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.EVL_LIKE_NOT_EXIST_ERROR,"商品评价点赞记录信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateEvlLike(
			EvlLikeDto evlLikeDto)
			throws TsfaServiceException {
		logger.debug("updateEvlLike(EvlLikeDto evlLikeDto={}) - start", evlLikeDto); //$NON-NLS-1$

		AssertUtils.notNull(evlLikeDto);
		AssertUtils.notNullAndEmpty(evlLikeDto.getCode(),"Code不能为空");
		try {
			EvlLike evlLike = new EvlLike();
			//update数据录入
			evlLike.setCode(evlLikeDto.getCode());
			evlLike.setMbrCode(evlLikeDto.getMbrCode());
			evlLike.setEvlCode(evlLikeDto.getEvlCode());
			evlLike.setCreateTime(evlLikeDto.getCreateTime());
			AssertUtils.notUpdateMoreThanOne(evlLikeDao.updateByPrimaryKeySelective(evlLike));
			logger.debug("updateEvlLike(EvlLikeDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("商品评价点赞记录信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.EVL_LIKE_UPDATE_ERROR,"商品评价点赞记录信息更新信息错误！",e);
		}
	}

	

	@Override
	public EvlLikeDto findEvlLike(
			EvlLikeDto evlLikeDto) throws TsfaServiceException {
		logger.debug("findEvlLike(FindEvlLike findEvlLike={}) - start", evlLikeDto); //$NON-NLS-1$

		AssertUtils.notNull(evlLikeDto);
		AssertUtils.notAllNull(evlLikeDto.getCode(),"Code不能为空");
		try {
			EvlLike evlLike = evlLikeDao.selectByPrimaryKey(evlLikeDto.getCode());
			if(evlLike == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.EVL_LIKE_NOT_EXIST_ERROR,"商品评价点赞记录信息不存在");
			}
			EvlLikeDto findEvlLikeReturn = new EvlLikeDto();
			//find数据录入
			findEvlLikeReturn.setCode(evlLike.getCode());
			findEvlLikeReturn.setMbrCode(evlLike.getMbrCode());
			findEvlLikeReturn.setEvlCode(evlLike.getEvlCode());
			findEvlLikeReturn.setCreateTime(evlLike.getCreateTime());
			
			logger.debug("findEvlLike(EvlLikeDto) - end - return value={}", findEvlLikeReturn); //$NON-NLS-1$
			return findEvlLikeReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找商品评价点赞记录信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.EVL_LIKE_FIND_ERROR,"查找商品评价点赞记录信息信息错误！",e);
		}


	}

	
	@Override
	public Page<EvlLikeDto> findEvlLikePage(
			FindEvlLikePage findEvlLikePage)
			throws TsfaServiceException {
		logger.debug("findEvlLikePage(FindEvlLikePage findEvlLikePage={}) - start", findEvlLikePage); //$NON-NLS-1$

		AssertUtils.notNull(findEvlLikePage);
		List<EvlLikeDto> returnList=null;
		int count = 0;
		try {
			returnList = evlLikeDao.findEvlLikePage(findEvlLikePage);
			count = evlLikeDao.findEvlLikePageCount(findEvlLikePage);
		}  catch (Exception e) {
			logger.error("商品评价点赞记录信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.EVL_LIKE_FIND_PAGE_ERROR,"商品评价点赞记录信息不存在错误.！",e);
		}
		Page<EvlLikeDto> returnPage = new Page<EvlLikeDto>(returnList, count, findEvlLikePage);

		logger.debug("findEvlLikePage(FindEvlLikePage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 
	
}
