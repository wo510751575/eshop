package com.lj.eshop.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.dao.IShopRetireDao;
import com.lj.eshop.domain.ShopRetire;
import com.lj.eshop.dto.AccWaterDto;
import com.lj.eshop.dto.AccountDto;
import com.lj.eshop.dto.FindShopRetirePage;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.dto.ShopRetireDto;
import com.lj.eshop.emus.AccWaterAccType;
import com.lj.eshop.emus.AccWaterBizType;
import com.lj.eshop.emus.AccWaterPayType;
import com.lj.eshop.emus.AccWaterSource;
import com.lj.eshop.emus.AccWaterStatus;
import com.lj.eshop.emus.AccWaterType;
import com.lj.eshop.emus.AuditStatus;
import com.lj.eshop.emus.ExpressStatus;
import com.lj.eshop.emus.RetireStatus;
import com.lj.eshop.service.IAccWaterService;
import com.lj.eshop.service.IAccountService;
import com.lj.eshop.service.IShopRetireService;
import com.lj.eshop.service.IShopService;
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
public class ShopRetireServiceImpl implements IShopRetireService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(ShopRetireServiceImpl.class);
	

	@Autowired
	private IShopRetireDao shopRetireDao;
	@Autowired
	private IShopService shopService;
	@Autowired
	private IAccountService accountService;
	@Autowired
	private IAccWaterService accWaterService;
	
	@Override
	public void addShopRetire(
			ShopRetireDto shopRetireDto) throws TsfaServiceException {
		logger.debug("addShopRetire(AddShopRetire addShopRetire={}) - start", shopRetireDto); 

		AssertUtils.notNull(shopRetireDto);
		try {
			ShopRetire shopRetire = new ShopRetire();
			//add数据录入
			shopRetire.setCode(GUID.generateCode());
			shopRetire.setRetireNo(shopRetireDto.getRetireNo());
			shopRetire.setMbrCode(shopRetireDto.getMbrCode());
			shopRetire.setShopCode(shopRetireDto.getShopCode());
			shopRetire.setAuditStatus(shopRetireDto.getAuditStatus());
			shopRetire.setRetireStatus(shopRetireDto.getRetireStatus());
			shopRetire.setExpressNo(shopRetireDto.getExpressNo());
			shopRetire.setExpressStatus(shopRetireDto.getExpressStatus());
			shopRetire.setCreateTime(new Date());
			shopRetire.setUpdateTime(shopRetireDto.getUpdateTime());
			shopRetire.setAuditor(shopRetireDto.getAuditor());
			shopRetire.setRemarks(shopRetireDto.getRemarks());
			shopRetire.setExpressName(shopRetireDto.getExpressName());
			shopRetireDao.insertSelective(shopRetire);
			logger.debug("addShopRetire(ShopRetireDto) - end - return"); 
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增店铺押金退出申请信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_RETIRE_ADD_ERROR,"新增店铺押金退出申请信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询店铺押金退出申请信息
	 *
	 * @param findShopRetirePage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017年07月10日
	 *
	 */
	public List<ShopRetireDto>  findShopRetires(FindShopRetirePage findShopRetirePage)throws TsfaServiceException{
		AssertUtils.notNull(findShopRetirePage);
		List<ShopRetireDto> returnList=null;
		try {
			returnList = shopRetireDao.findShopRetires(findShopRetirePage);
		} catch (Exception e) {
			logger.error("查找店铺押金退出申请信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.SHOP_RETIRE_NOT_EXIST_ERROR,"店铺押金退出申请信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateShopRetire(
			ShopRetireDto shopRetireDto)
			throws TsfaServiceException {
		logger.debug("updateShopRetire(ShopRetireDto shopRetireDto={}) - start", shopRetireDto); //$NON-NLS-1$

		AssertUtils.notNull(shopRetireDto);
		AssertUtils.notNullAndEmpty(shopRetireDto.getCode(),"Code不能为空");
		try {
			ShopRetire shopRetire = new ShopRetire();
			//update数据录入
			shopRetire.setCode(shopRetireDto.getCode());
			shopRetire.setRetireNo(shopRetireDto.getRetireNo());
			shopRetire.setMbrCode(shopRetireDto.getMbrCode());
			shopRetire.setShopCode(shopRetireDto.getShopCode());
			shopRetire.setAuditStatus(shopRetireDto.getAuditStatus());
			shopRetire.setRetireStatus(shopRetireDto.getRetireStatus());
			shopRetire.setExpressNo(shopRetireDto.getExpressNo());
			shopRetire.setExpressStatus(shopRetireDto.getExpressStatus());
			shopRetire.setUpdateTime(new Date());
			shopRetire.setAuditor(shopRetireDto.getAuditor());
			shopRetire.setRemarks(shopRetireDto.getRemarks());
			shopRetire.setExpressName(shopRetireDto.getExpressName());
			AssertUtils.notUpdateMoreThanOne(shopRetireDao.updateByPrimaryKeySelective(shopRetire));
			logger.debug("updateShopRetire(ShopRetireDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("店铺押金退出申请信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_RETIRE_UPDATE_ERROR,"店铺押金退出申请信息更新信息错误！",e);
		}
	}

	

	@Override
	public ShopRetireDto findShopRetire(
			ShopRetireDto shopRetireDto) throws TsfaServiceException {
		logger.debug("findShopRetire(FindShopRetire findShopRetire={}) - start", shopRetireDto); //$NON-NLS-1$

		AssertUtils.notNull(shopRetireDto);
		AssertUtils.notAllNull(shopRetireDto.getCode(),"Code不能为空");
		try {
			ShopRetire shopRetire = shopRetireDao.selectByPrimaryKey(shopRetireDto.getCode());
			if(shopRetire == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.SHOP_RETIRE_NOT_EXIST_ERROR,"店铺押金退出申请信息不存在");
			}
			ShopRetireDto findShopRetireReturn = new ShopRetireDto();
			//find数据录入
			findShopRetireReturn.setCode(shopRetire.getCode());
			findShopRetireReturn.setRetireNo(shopRetire.getRetireNo());
			findShopRetireReturn.setMbrCode(shopRetire.getMbrCode());
			findShopRetireReturn.setShopCode(shopRetire.getShopCode());
			findShopRetireReturn.setAuditStatus(shopRetire.getAuditStatus());
			findShopRetireReturn.setRetireStatus(shopRetire.getRetireStatus());
			findShopRetireReturn.setExpressNo(shopRetire.getExpressNo());
			findShopRetireReturn.setExpressStatus(shopRetire.getExpressStatus());
			findShopRetireReturn.setCreateTime(shopRetire.getCreateTime());
			findShopRetireReturn.setUpdateTime(shopRetire.getUpdateTime());
			findShopRetireReturn.setAuditor(shopRetire.getAuditor());
			findShopRetireReturn.setRemarks(shopRetire.getRemarks());
			findShopRetireReturn.setExpressName(shopRetire.getExpressName());
			
			logger.debug("findShopRetire(ShopRetireDto) - end - return value={}", findShopRetireReturn); //$NON-NLS-1$
			return findShopRetireReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找店铺押金退出申请信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_RETIRE_FIND_ERROR,"查找店铺押金退出申请信息信息错误！",e);
		}


	}

	
	@Override
	public Page<ShopRetireDto> findShopRetirePage(
			FindShopRetirePage findShopRetirePage)
			throws TsfaServiceException {
		logger.debug("findShopRetirePage(FindShopRetirePage findShopRetirePage={}) - start", findShopRetirePage); //$NON-NLS-1$

		AssertUtils.notNull(findShopRetirePage);
		List<ShopRetireDto> returnList=null;
		int count = 0;
		try {
			returnList = shopRetireDao.findShopRetirePage(findShopRetirePage);
			count = shopRetireDao.findShopRetirePageCount(findShopRetirePage);
		}  catch (Exception e) {
			logger.error("店铺押金退出申请信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.SHOP_RETIRE_FIND_PAGE_ERROR,"店铺押金退出申请信息不存在错误.！",e);
		}
		Page<ShopRetireDto> returnPage = new Page<ShopRetireDto>(returnList, count, findShopRetirePage);

		logger.debug("findShopRetirePage(FindShopRetirePage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	@Override
	public void audit(ShopRetireDto shopRetireDto,BigDecimal amount) {
		logger.debug("audit(ShopRetireDto shopRetireDto)={}) - start", shopRetireDto); 
		AssertUtils.notNull(shopRetireDto);
		AssertUtils.notNullAndEmpty(shopRetireDto.getCode(),"申请编号不能为空");
		try {
			
			ShopRetireDto rtShopRetireDto = findShopRetire(shopRetireDto);
			ShopDto paramShopDto = new ShopDto();
			paramShopDto.setCode(rtShopRetireDto.getShopCode());
			ShopDto rtShopDto = shopService.findShop(paramShopDto);
			
			
			/*审核成功，状态流转至待收货*/
			if(StringUtils.isNotEmpty(shopRetireDto.getAuditStatus())&& shopRetireDto.getAuditStatus().equals(AuditStatus.SUCCESS.getValue())){
				shopRetireDto.setExpressStatus(ExpressStatus.WAIT.getValue());
			}else if(StringUtils.isNotEmpty(shopRetireDto.getRetireStatus()) && shopRetireDto.getRetireStatus().equals(RetireStatus.SUCCESS.getValue())){	
				/*获取会员编号*/
				ShopRetireDto dto= this.findShopRetire(shopRetireDto);
				String memberCode = dto.getMbrCode();
				
				/*打款成功会员账户中增加金额*/
				AccountDto accountDto=  accountService.findAccountByMbrCode(memberCode);
				BigDecimal afterAmt = accountDto.getCashAmt().add(amount).setScale(2, BigDecimal.ROUND_HALF_UP);
				/*新增流水记录*/
				AccWaterDto accWaterDto = new AccWaterDto();
				accWaterDto.setStatus(AccWaterStatus.SUCCESS.getValue());
				accWaterDto.setAccDate(new Date());
				accWaterDto.setAccSource(AccWaterSource.DEPOSIT.getValue());
				accWaterDto.setAccType(AccWaterAccType.MANUAL.getValue());//系统自动记账
				accWaterDto.setAmt(amount);
				accWaterDto.setAccNo(accountDto.getAccNo());
				accWaterDto.setAccCode(accountDto.getCode());
				accWaterDto.setBeforeAmt(accountDto.getCashAmt());//补充退前的金额
				accWaterDto.setAfterAmt(afterAmt);//补充退后的金额
				accWaterDto.setBizType(AccWaterBizType.REFUND.getValue());
				accWaterDto.setPayType(AccWaterPayType.VIRTUAL.getValue());//平台虚户的出入账单
				accWaterDto.setOpCode(rtShopDto.getMbrCode());
				accWaterDto.setWaterType(AccWaterType.ADD.getValue());
				accWaterDto.setUpdateTime(new Date());
				accWaterDto.setTranOrderNo(rtShopRetireDto.getRetireNo());//申请编号
				accWaterService.addAccWater(accWaterDto);
				
				//3.扣可用余额,增提现总额
				AccountDto updateAcc=new AccountDto();
				updateAcc.setCode(accountDto.getCode());
				updateAcc.setCashAmt(afterAmt);
				accountService.updateAccount(updateAcc);
			}
			shopRetireDto.setUpdateTime(new Date());
			this.updateShopRetire(shopRetireDto);
			logger.debug("audit(ShopRetireDto shopRetireDto)={}) - end", shopRetireDto); 
		}  catch (Exception e) {
			logger.error("店铺押金退出申请信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.SHOP_RETIRE_UPDATE_ERROR,"店铺押金退出申请信息更新信息错误！",e);
		}
	} 


}
