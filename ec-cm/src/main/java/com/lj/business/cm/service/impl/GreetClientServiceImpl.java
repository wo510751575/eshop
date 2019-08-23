package com.lj.business.cm.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
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
import com.lj.business.cm.constant.ErrorCode;
import com.lj.business.cm.dao.IGreetClientDao;
import com.lj.business.cm.domain.GreetClient;
import com.lj.business.cm.dto.AddGreetClient;
import com.lj.business.cm.dto.AddGreetClientReturn;
import com.lj.business.cm.dto.DelGreetClient;
import com.lj.business.cm.dto.DelGreetClientReturn;
import com.lj.business.cm.dto.FindGreetClient;
import com.lj.business.cm.dto.FindGreetClientForDayDto;
import com.lj.business.cm.dto.FindGreetClientPage;
import com.lj.business.cm.dto.FindGreetClientPageReturn;
import com.lj.business.cm.dto.FindGreetClientReturn;
import com.lj.business.cm.dto.FindGreetClientReturnDto;
import com.lj.business.cm.dto.UpdateGreetClient;
import com.lj.business.cm.dto.UpdateGreetClientReturn;
import com.lj.business.cm.service.IGreetClientService;
import com.lj.business.member.dto.FindGuidMember;
import com.lj.business.member.dto.FindGuidMemberReturn;
import com.lj.business.member.dto.guidMemberIntegral.GuidMemberIntegralDto;
import com.lj.business.member.emus.IntegralType;
import com.lj.business.member.service.IGuidMemberIntegralService;
import com.lj.business.member.service.IGuidMemberService;

/**
 * 类说明：实现类
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
@Service
public class GreetClientServiceImpl implements IGreetClientService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(GreetClientServiceImpl.class);
	

	/** The greet client dao. */
	@Resource
	private IGreetClientDao greetClientDao;
	
	/** The guid member service. */
	@Resource
	private  IGuidMemberService guidMemberService;
	
	@Resource
	private IGuidMemberIntegralService guidMemberIntegralService;
	 
	/**
	 * 方法说明：添加问候客户表信息.
	 *
	 * @param addGreetClient the add greet client
	 * @return the adds the greet client return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 邹磊 CreateDate: 2017年6月21日
	 */
	@Override
	public AddGreetClientReturn addGreetClient(AddGreetClient addGreetClient) throws TsfaServiceException {
		logger.debug("addGreetClient(AddGreetClient addGreetClient={}) - start", addGreetClient); 
		AssertUtils.notNull(addGreetClient);
		AssertUtils.notNull(addGreetClient.getMemberNoGm(),"导购编号不能为空");
		try {
			GreetClient greetClient = new GreetClient();
			//add数据录入
			greetClient.setCode(GUID.generateCode());
			greetClient.setMerchantNo(addGreetClient.getMerchantNo());
			greetClient.setMemberNo(addGreetClient.getMemberNo());
			greetClient.setMemberNoGm(addGreetClient.getMemberNoGm());
			greetClient.setMemberNameGm(addGreetClient.getMemberNameGm());
			greetClient.setTitle(addGreetClient.getTitle());
			greetClient.setContent(addGreetClient.getContent());
			greetClient.setSendType(addGreetClient.getSendType());
			greetClient.setCreateId(addGreetClient.getCreateId());
			greetClient.setCreateDate(new Date());
			greetClient.setRemark(addGreetClient.getRemark());
			greetClient.setRemark2(addGreetClient.getRemark2());
			greetClient.setRemark3(addGreetClient.getRemark3());
			greetClient.setRemark4(addGreetClient.getRemark4());
			greetClientDao.insertSelective(greetClient);
			
			//添加积分
			GuidMemberIntegralDto guidMemberIntegralDto = new GuidMemberIntegralDto();
			guidMemberIntegralDto.setMerchantNo(greetClient.getMerchantNo());
			
			FindGuidMember findGuidMember =  new FindGuidMember();
			findGuidMember.setMemberNo(addGreetClient.getMemberNoGm());
			FindGuidMemberReturn member = guidMemberService.findGuidMember(findGuidMember);
			if(member != null){
				guidMemberIntegralDto.setShopNo(member.getShopNo());
				guidMemberIntegralDto.setAreaCode(member.getAreaCode());
			}
			guidMemberIntegralDto.setMemberNo(addGreetClient.getMemberNoGm());
			guidMemberIntegralDto.setIntegralType(IntegralType.ASK.toString());
			guidMemberIntegralService.doIntegral(guidMemberIntegralDto);
			
			AddGreetClientReturn addGreetClientReturn = new AddGreetClientReturn();
			
			logger.debug("addGreetClient(AddGreetClient) - end - return value={}", addGreetClientReturn); 
			return addGreetClientReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增问候客户表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GREET_CLIENT_ADD_ERROR,"新增问候客户表信息错误！",e);
		}
	}
	

	/**
	 * 方法说明：删除问候客户表信息.
	 *
	 * @param delGreetClient the del greet client
	 * @return the del greet client return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 罗书明 CreateDate: 2017年6月21日
	 */
	
	@Override
	public DelGreetClientReturn delGreetClient(
			DelGreetClient delGreetClient) throws TsfaServiceException {
		logger.debug("delGreetClient(DelGreetClient delGreetClient={}) - start", delGreetClient); 

		AssertUtils.notNull(delGreetClient);
		AssertUtils.notNull(delGreetClient.getCode(),"ID不能为空！");
		try {
			greetClientDao.deleteByPrimaryKey(delGreetClient.getCode());
			DelGreetClientReturn delGreetClientReturn  = new DelGreetClientReturn();

			logger.debug("delGreetClient(DelGreetClient) - end - return value={}", delGreetClientReturn); //$NON-NLS-1$
			return delGreetClientReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("删除问候客户表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GREET_CLIENT_DEL_ERROR,"删除问候客户表信息错误！",e);

		}
	}
    
	/**
	 * 方法说明：修改问候客户表信息.
	 *
	 * @param updateGreetClient the update greet client
	 * @return the update greet client return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 罗书明 CreateDate: 2017年6月21日
	 */
	@Override
	public UpdateGreetClientReturn updateGreetClient(
			UpdateGreetClient updateGreetClient)
			throws TsfaServiceException {
		logger.debug("updateGreetClient(UpdateGreetClient updateGreetClient={}) - start", updateGreetClient); //$NON-NLS-1$

		AssertUtils.notNull(updateGreetClient);
		AssertUtils.notNullAndEmpty(updateGreetClient.getCode(),"ID不能为空");
		try {
			GreetClient greetClient = new GreetClient();
			//update数据录入
			greetClient.setCode(updateGreetClient.getCode());
			greetClient.setMerchantNo(updateGreetClient.getMerchantNo());
			greetClient.setMemberNoGm(updateGreetClient.getMemberNoGm());
			greetClient.setMemberNameGm(updateGreetClient.getMemberNameGm());
			greetClient.setTitle(updateGreetClient.getTitle());
			greetClient.setContent(updateGreetClient.getContent());
			greetClient.setSendType(updateGreetClient.getSendType());
			greetClient.setMemberNo(updateGreetClient.getMemberNo());
			greetClient.setCreateId(updateGreetClient.getCreateId());
			greetClient.setCreateDate(updateGreetClient.getCreateDate());
			AssertUtils.notUpdateMoreThanOne(greetClientDao.updateByPrimaryKeySelective(greetClient));
			UpdateGreetClientReturn updateGreetClientReturn = new UpdateGreetClientReturn();

			logger.debug("updateGreetClient(UpdateGreetClient) - end - return value={}", updateGreetClientReturn); //$NON-NLS-1$
			return updateGreetClientReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("问候客户表信息更新错误！",e);
			throw new TsfaServiceException(ErrorCode.GREET_CLIENT_UPDATE_ERROR,"问候客户表信息更新错误！",e);
		}
	}

	/**
	 * 方法说明：查找问候客户表信息.
	 *
	 * @param findGreetClient the find greet client
	 * @return the find greet client return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 罗书明 CreateDate: 2017年6月21日
	 */

	@Override
	public FindGreetClientReturn findGreetClient(
			FindGreetClient findGreetClient) throws TsfaServiceException {
		logger.debug("findGreetClient(FindGreetClient findGreetClient={}) - start", findGreetClient); //$NON-NLS-1$

		AssertUtils.notNull(findGreetClient);
		AssertUtils.notAllNull(findGreetClient.getCode(),"ID不能为空");
		try {
			GreetClient greetClient = greetClientDao.selectByPrimaryKey(findGreetClient.getCode());
			if(greetClient == null){
				throw new TsfaServiceException(ErrorCode.GREET_CLIENT_NOT_EXIST_ERROR,"问候客户表信息不存在");
			}
			FindGreetClientReturn findGreetClientReturn = new FindGreetClientReturn();
			//find数据录入
			findGreetClientReturn.setCode(greetClient.getCode());
			findGreetClientReturn.setMerchantNo(greetClient.getMerchantNo());
			findGreetClientReturn.setMemberNoGm(greetClient.getMemberNoGm());
			findGreetClientReturn.setMemberNameGm(greetClient.getMemberNameGm());
			findGreetClientReturn.setTitle(greetClient.getTitle());
			findGreetClientReturn.setContent(greetClient.getContent());
			findGreetClientReturn.setSendType(greetClient.getSendType());
			findGreetClientReturn.setMemberNo(greetClient.getMemberNo());
			findGreetClientReturn.setCreateId(greetClient.getCreateId());
			findGreetClientReturn.setCreateDate(greetClient.getCreateDate());
			
			logger.debug("findGreetClient(FindGreetClient) - end - return value={}", findGreetClientReturn); //$NON-NLS-1$
			return findGreetClientReturn;
		}catch (TsfaServiceException e) {
			throw e;
		} catch (Exception e) {
			logger.error("查找问候客户表信息错误！",e);
			throw new TsfaServiceException(ErrorCode.GREET_CLIENT_FIND_ERROR,"查找问候客户表信息错误！",e);
		}


	}

	/**
	 * 方法说明：分页查找问候客户表信息.
	 *
	 * @param findGreetClientPage the find greet client page
	 * @return the page< find greet client page return>
	 * @throws TsfaServiceException the tsfa service exception
	 * @author  罗书明 CreateDate: 2017年6月21日
	 */
	@Override
	public Page<FindGreetClientPageReturn> findGreetClientPage(
			FindGreetClientPage findGreetClientPage)
			throws TsfaServiceException {
		logger.debug("findGreetClientPage(FindGreetClientPage findGreetClientPage={}) - start", findGreetClientPage); //$NON-NLS-1$

		AssertUtils.notNull(findGreetClientPage);
		List<FindGreetClientPageReturn> returnList;
		int count = 0;
		try {
			returnList = greetClientDao.findGreetClientPage(findGreetClientPage);
			count = greetClientDao.findGreetClientPageCount(findGreetClientPage);
		}  catch (Exception e) {
			logger.error("问候客户表信息分页查询错误",e);
			throw new TsfaServiceException(ErrorCode.GREET_CLIENT_FIND_PAGE_ERROR,"问候客户表信息分页查询错误.！",e);
		}
		Page<FindGreetClientPageReturn> returnPage = new Page<FindGreetClientPageReturn>(returnList, count, findGreetClientPage);

		logger.debug("findGreetClientPage(FindGreetClientPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}

	/**
	 * 查询当日的问候(今日工作)
	 */
	@Override
	public FindGreetClientReturnDto findGreetClientForDay(FindGreetClientForDayDto findGreetClientForDayDto) throws TsfaServiceException {
		logger.debug("findGreetClientForDayDto(findGreetClientForDayDto findGreetClientForDayDto={}) - start", findGreetClientForDayDto); //$NON-NLS-1$
		AssertUtils.notNull(findGreetClientForDayDto);
		AssertUtils.notAllNull(findGreetClientForDayDto.getMemberNoGm(), findGreetClientForDayDto.getCreateDate(), "导购编号和创建时间不能全部为空!");
		try {
			String createDate = findGreetClientForDayDto.getCreateDate();
			findGreetClientForDayDto.setCreateDate(createDate + " 00:00:00");
			findGreetClientForDayDto.setCreateDateEnd(createDate + " 23:59:59");
			FindGreetClientReturnDto findGreetClientForDay = greetClientDao.findGreetClientForDay(findGreetClientForDayDto);
			return findGreetClientForDay;
		}  catch (Exception e) {
			logger.error("问候客户表信息查询错误",e);
			throw new TsfaServiceException(ErrorCode.GREET_CLIENT_FIND_ERROR,"问候客户表信息查询错误.！",e);
		}

	}
}
