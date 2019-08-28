package com.lj.eshop.service.impl;

import java.util.Date;
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

import com.lj.eshop.dto.MemberRankDto;
import com.lj.eshop.dto.FindMemberRankPage;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.dao.IMemberRankDao;
import com.lj.eshop.domain.MemberRank;
import com.lj.eshop.service.IMemberRankService;
/**
 * 类说明：实现类
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年8月30日 
 */
@Service
public class MemberRankServiceImpl implements IMemberRankService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(MemberRankServiceImpl.class);
	

	@Resource
	private IMemberRankDao memberRankDao;
	
	
	@Override
	public void addMemberRank(
			MemberRankDto memberRankDto) throws TsfaServiceException {
		logger.debug("addMemberRank(AddMemberRank addMemberRank={}) - start", memberRankDto); 

		AssertUtils.notNull(memberRankDto);
		try {
			MemberRank memberRank = new MemberRank();
			//add数据录入
			memberRank.setCode(GUID.generateCode());
			memberRank.setCreateDate(memberRankDto.getCreateDate());
			memberRank.setModifyDate(memberRankDto.getModifyDate());
			memberRank.setAmount(memberRankDto.getAmount());
			memberRank.setRemark(memberRankDto.getRemark());
			memberRank.setName(memberRankDto.getName());
			memberRank.setScale(memberRankDto.getScale());
			memberRank.setDelFlag("0");
			memberRank.setSeq(memberRankDto.getSeq());
			memberRank.setImgSrc(memberRankDto.getImgSrc());
			memberRankDao.insert(memberRank);
			logger.debug("addMemberRank(MemberRankDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增会员特权错误！",e);
			throw new TsfaServiceException(ErrorCode.MEMBER_RANK_ADD_ERROR,"新增会员特权错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询会员特权
	 *
	 * @param findMemberRankPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<MemberRankDto>  findMemberRanks(FindMemberRankPage findMemberRankPage)throws TsfaServiceException{
		AssertUtils.notNull(findMemberRankPage);
		List<MemberRankDto> returnList=null;
		try {
			returnList = memberRankDao.findMemberRanks(findMemberRankPage);
		} catch (Exception e) {
			logger.error("查找会员特权信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MEMBER_RANK_NOT_EXIST_ERROR,"会员特权不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateMemberRank(
			MemberRankDto memberRankDto)
			throws TsfaServiceException {
		logger.debug("updateMemberRank(MemberRankDto memberRankDto={}) - start", memberRankDto); //$NON-NLS-1$

		AssertUtils.notNull(memberRankDto);
		AssertUtils.notNullAndEmpty(memberRankDto.getCode(),"Code不能为空");
		try {
			MemberRank memberRank = new MemberRank();
			//update数据录入
			memberRank.setCode(memberRankDto.getCode());
			memberRank.setCreateDate(memberRankDto.getCreateDate());
			memberRank.setModifyDate(new Date());
			memberRank.setAmount(memberRankDto.getAmount());
			memberRank.setRemark(memberRankDto.getRemark());
			memberRank.setName(memberRankDto.getName());
			memberRank.setScale(memberRankDto.getScale());
			memberRank.setDelFlag(memberRankDto.getDelFlag());
			memberRank.setSeq(memberRankDto.getSeq());
			memberRank.setImgSrc(memberRankDto.getImgSrc());
			AssertUtils.notUpdateMoreThanOne(memberRankDao.updateByPrimaryKeySelective(memberRank));
			logger.debug("updateMemberRank(MemberRankDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("会员特权更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MEMBER_RANK_UPDATE_ERROR,"会员特权更新信息错误！",e);
		}
	}

	

	@Override
	public MemberRankDto findMemberRank(
			MemberRankDto memberRankDto) throws TsfaServiceException {
		logger.debug("findMemberRank(FindMemberRank findMemberRank={}) - start", memberRankDto); //$NON-NLS-1$

		AssertUtils.notNull(memberRankDto);
		AssertUtils.notAllNull(memberRankDto.getCode(),"Code不能为空");
		try {
			MemberRank memberRank = memberRankDao.selectByPrimaryKey(memberRankDto.getCode());
			if(memberRank == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.MEMBER_RANK_NOT_EXIST_ERROR,"会员特权不存在");
			}
			MemberRankDto findMemberRankReturn = new MemberRankDto();
			//find数据录入
			findMemberRankReturn.setCode(memberRank.getCode());
			findMemberRankReturn.setCreateDate(memberRank.getCreateDate());
			findMemberRankReturn.setModifyDate(memberRank.getModifyDate());
			findMemberRankReturn.setAmount(memberRank.getAmount());
			findMemberRankReturn.setRemark(memberRank.getRemark());
			findMemberRankReturn.setName(memberRank.getName());
			findMemberRankReturn.setScale(memberRank.getScale());
			findMemberRankReturn.setDelFlag(memberRank.getDelFlag());
			findMemberRankReturn.setSeq(memberRank.getSeq());
			findMemberRankReturn.setImgSrc(memberRank.getImgSrc());
			findMemberRankReturn.setAdvancePayment(memberRank.getAdvancePayment());
			memberRank.setSeq(memberRankDto.getSeq());
			logger.debug("findMemberRank(MemberRankDto) - end - return value={}", findMemberRankReturn); //$NON-NLS-1$
			return findMemberRankReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找会员特权信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MEMBER_RANK_FIND_ERROR,"查找会员特权信息错误！",e);
		}


	}

	
	@Override
	public Page<MemberRankDto> findMemberRankPage(
			FindMemberRankPage findMemberRankPage)
			throws TsfaServiceException {
		logger.debug("findMemberRankPage(FindMemberRankPage findMemberRankPage={}) - start", findMemberRankPage); //$NON-NLS-1$

		AssertUtils.notNull(findMemberRankPage);
		List<MemberRankDto> returnList=null;
		int count = 0;
		try {
			returnList = memberRankDao.findMemberRankPage(findMemberRankPage);
			count = memberRankDao.findMemberRankPageCount(findMemberRankPage);
		}  catch (Exception e) {
			logger.error("会员特权不存在错误",e);
			throw new TsfaServiceException(ErrorCode.MEMBER_RANK_FIND_PAGE_ERROR,"会员特权不存在错误.！",e);
		}
		Page<MemberRankDto> returnPage = new Page<MemberRankDto>(returnList, count, findMemberRankPage);

		logger.debug("findMemberRankPage(FindMemberRankPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	} 


}
