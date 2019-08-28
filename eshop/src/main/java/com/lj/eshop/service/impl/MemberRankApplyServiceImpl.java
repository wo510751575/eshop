package com.lj.eshop.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
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
import org.springframework.transaction.annotation.Transactional;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.constant.NoUtil;
import com.lj.eshop.dao.IMemberRankApplyDao;
import com.lj.eshop.domain.Member;
import com.lj.eshop.domain.MemberRankApply;
import com.lj.eshop.dto.AccWaterDto;
import com.lj.eshop.dto.AccountDto;
import com.lj.eshop.dto.FindMemberRankApplyPage;
import com.lj.eshop.dto.FindMemberRankPage;
import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.dto.MemberRankApplyDto;
import com.lj.eshop.dto.MemberRankDto;
import com.lj.eshop.dto.MessageDto;
import com.lj.eshop.dto.PaymentDto;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.emus.AccWaterAccType;
import com.lj.eshop.emus.AccWaterBizType;
import com.lj.eshop.emus.AccWaterSource;
import com.lj.eshop.emus.AccWaterStatus;
import com.lj.eshop.emus.AccWaterType;
import com.lj.eshop.emus.MemberRankApplyStatus;
import com.lj.eshop.emus.MemberType;
import com.lj.eshop.emus.MessageTemplate;
import com.lj.eshop.service.IAccWaterService;
import com.lj.eshop.service.IAccountService;
import com.lj.eshop.service.IMemberRankApplyService;
import com.lj.eshop.service.IMemberRankService;
import com.lj.eshop.service.IMemberService;
import com.lj.eshop.service.IMessageService;
import com.lj.eshop.service.IShopService;
/**
 * 类说明：实现类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 林进权
 * 
 * 
 * CreateDate: 2017-08-22
 */
@Service
public class MemberRankApplyServiceImpl implements IMemberRankApplyService { 

	
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(MemberRankApplyServiceImpl.class);
	

	@Resource
	private IMemberRankApplyDao memberRankApplyDao;
	@Resource
	private IShopService shopService;
	@Resource
	private IMemberRankService memberRankService;
	@Resource
	private IAccWaterService accWaterService;
	@Resource
	private IAccountService accountService;
	@Resource
	private IMessageService messageService;
	@Resource
	private IMemberService memberService;
	
	
	
	@Override
	public MemberRankApplyDto addMemberRankApply(
			MemberRankApplyDto memberRankApplyDto) throws TsfaServiceException {
		logger.debug("addMemberRankApply(AddMemberRankApply addMemberRankApply={}) - start", memberRankApplyDto); 

		AssertUtils.notNull(memberRankApplyDto);
		try {
			MemberRankApply memberRankApply = new MemberRankApply();
			//add数据录入
			memberRankApply.setCode(GUID.generateCode());
			memberRankApply.setMemberCode(memberRankApplyDto.getMemberCode());
			memberRankApply.setMemberRankCode(memberRankApplyDto.getMemberRankCode());
			memberRankApply.setApplyTime(memberRankApplyDto.getApplyTime());
			memberRankApply.setApproveTime(memberRankApplyDto.getApproveTime());
			memberRankApply.setStatus(memberRankApplyDto.getStatus());
			memberRankApply.setDelFlag("0");
			memberRankApply.setMemberName(memberRankApplyDto.getMemberName());
			memberRankApply.setMemberRankName(memberRankApplyDto.getMemberRankName());
			memberRankApplyDao.insert(memberRankApply);
			logger.debug("addMemberRankApply(MemberRankApplyDto) - end - return"); 
			
			
			memberRankApplyDto.setCode(memberRankApply.getCode());
			return memberRankApplyDto;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("新增特权申请信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MEMBER_RANK_APPLY_ADD_ERROR,"新增特权申请信息错误！",e);
		}
	}
	
	
 	/**
	 * 
	 *
	 * 方法说明：不分页查询特权申请信息
	 *
	 * @param findMemberRankApplyPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017年07月10日
	 *
	 */
	public List<MemberRankApplyDto>  findMemberRankApplys(FindMemberRankApplyPage findMemberRankApplyPage)throws TsfaServiceException{
		AssertUtils.notNull(findMemberRankApplyPage);
		List<MemberRankApplyDto> returnList=null;
		try {
			returnList = memberRankApplyDao.findMemberRankApplys(findMemberRankApplyPage);
		} catch (Exception e) {
			logger.error("查找特权申请信息信息错误！", e);
			throw new TsfaServiceException(ErrorCode.MEMBER_RANK_APPLY_NOT_EXIST_ERROR,"特权申请信息不存在");
		}
		return returnList;
	}
	

	@Override
	public void updateMemberRankApply(
			MemberRankApplyDto memberRankApplyDto)
			throws TsfaServiceException {
		logger.debug("updateMemberRankApply(MemberRankApplyDto memberRankApplyDto={}) - start", memberRankApplyDto); //$NON-NLS-1$

		AssertUtils.notNull(memberRankApplyDto);
		AssertUtils.notNullAndEmpty(memberRankApplyDto.getCode(),"Code不能为空");
		try {
			MemberRankApply memberRankApply = new MemberRankApply();
			//update数据录入
			memberRankApply.setCode(memberRankApplyDto.getCode());
			memberRankApply.setMemberCode(memberRankApplyDto.getMemberCode());
			memberRankApply.setMemberRankCode(memberRankApplyDto.getMemberRankCode());
			memberRankApply.setApplyTime(memberRankApplyDto.getApplyTime());
			memberRankApply.setApproveTime(memberRankApplyDto.getApproveTime());
			memberRankApply.setStatus(memberRankApplyDto.getStatus());
			memberRankApply.setDelFlag(memberRankApplyDto.getDelFlag());
			memberRankApply.setMemberName(memberRankApplyDto.getMemberName());
			memberRankApply.setMemberRankName(memberRankApplyDto.getMemberRankName());
			AssertUtils.notUpdateMoreThanOne(memberRankApplyDao.updateByPrimaryKeySelective(memberRankApply));
			logger.debug("updateMemberRankApply(MemberRankApplyDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("特权申请信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MEMBER_RANK_APPLY_UPDATE_ERROR,"特权申请信息更新信息错误！",e);
		}
	}

	

	@Override
	public MemberRankApplyDto findMemberRankApply(
			MemberRankApplyDto memberRankApplyDto) throws TsfaServiceException {
		logger.debug("findMemberRankApply(FindMemberRankApply findMemberRankApply={}) - start", memberRankApplyDto); //$NON-NLS-1$

		AssertUtils.notNull(memberRankApplyDto);
		AssertUtils.notAllNull(memberRankApplyDto.getCode(),"Code不能为空");
		try {
			MemberRankApply memberRankApply = memberRankApplyDao.selectByPrimaryKey(memberRankApplyDto.getCode());
			if(memberRankApply == null){
				return null;
				//throw new TsfaServiceException(ErrorCode.MEMBER_RANK_APPLY_NOT_EXIST_ERROR,"特权申请信息不存在");
			}
			MemberRankApplyDto findMemberRankApplyReturn = new MemberRankApplyDto();
			//find数据录入
			findMemberRankApplyReturn.setCode(memberRankApply.getCode());
			findMemberRankApplyReturn.setMemberCode(memberRankApply.getMemberCode());
			findMemberRankApplyReturn.setMemberRankCode(memberRankApply.getMemberRankCode());
			findMemberRankApplyReturn.setApplyTime(memberRankApply.getApplyTime());
			findMemberRankApplyReturn.setApproveTime(memberRankApply.getApproveTime());
			findMemberRankApplyReturn.setStatus(memberRankApply.getStatus());
			findMemberRankApplyReturn.setDelFlag(memberRankApply.getDelFlag());
			
			logger.debug("findMemberRankApply(MemberRankApplyDto) - end - return value={}", findMemberRankApplyReturn); //$NON-NLS-1$
			return findMemberRankApplyReturn;
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("查找特权申请信息信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MEMBER_RANK_APPLY_FIND_ERROR,"查找特权申请信息信息错误！",e);
		}


	}

	
	@Override
	public Page<MemberRankApplyDto> findMemberRankApplyPage(
			FindMemberRankApplyPage findMemberRankApplyPage)
			throws TsfaServiceException {
		logger.debug("findMemberRankApplyPage(FindMemberRankApplyPage findMemberRankApplyPage={}) - start", findMemberRankApplyPage); //$NON-NLS-1$

		AssertUtils.notNull(findMemberRankApplyPage);
		List<MemberRankApplyDto> returnList=null;
		int count = 0;
		try {
			returnList = memberRankApplyDao.findMemberRankApplyPage(findMemberRankApplyPage);
			count = memberRankApplyDao.findMemberRankApplyPageCount(findMemberRankApplyPage);
		}  catch (Exception e) {
			logger.error("特权申请信息不存在错误",e);
			throw new TsfaServiceException(ErrorCode.MEMBER_RANK_APPLY_FIND_PAGE_ERROR,"特权申请信息不存在错误.！",e);
		}
		Page<MemberRankApplyDto> returnPage = new Page<MemberRankApplyDto>(returnList, count, findMemberRankApplyPage);

		logger.debug("findMemberRankApplyPage(FindMemberRankApplyPage) - end - return value={}", returnPage); //$NON-NLS-1$
		return  returnPage;
	}


	@Transactional
	@Override
	public void updateByPkAndStatus(MemberRankApplyDto memberRankApplyDto) throws TsfaServiceException {
		logger.debug("updateMemberRankApplyByApprove(MemberRankApplyDto memberRankApplyDto={}) - start", memberRankApplyDto); //$NON-NLS-1$

		AssertUtils.notNull(memberRankApplyDto);
		AssertUtils.notNullAndEmpty(memberRankApplyDto.getCode(),"Code不能为空");
		
		MemberRankApplyDto paramRankDto = new MemberRankApplyDto();
		paramRankDto.setCode(memberRankApplyDto.getCode());
		MemberRankApplyDto rltRankApplyDto = findMemberRankApply(memberRankApplyDto);
		
		
		
		//新购买特权
		MemberRankDto memberRankDto = new MemberRankDto();
		memberRankDto.setCode(rltRankApplyDto.getMemberRankCode());
		MemberRankDto rltNewMemberRank = memberRankService.findMemberRank(memberRankDto);
		
		
		try {
			MemberRankApply memberRankApply = new MemberRankApply();
			//update数据录入
			memberRankApply.setCode(memberRankApplyDto.getCode());
			memberRankApply.setApproveTime(new Date());
			memberRankApply.setStatus(memberRankApplyDto.getStatus());
			
			memberRankApply.setMemberRankName(memberRankApplyDto.getMemberRankName());
			
			int successCnt = memberRankApplyDao.updateByPkAndStatus(memberRankApply);
			
			//审批通过更新会员的特权过期时间和会员等级
			if(successCnt>0 && memberRankApplyDto.getStatus().equals(MemberRankApplyStatus.SUCCESS.getValue())) {
				
				/*if(StringUtils.isNotEmpty(rltShopDto.getRankCode())) {
					
					//如果已经过期，清除特权信息
					if(null!=rltShopDto.getRankExpireTime() && (rltShopDto.getRankExpireTime().getTime()<new Date().getTime())) {
						ShopDto updShopDto = new ShopDto();
						updShopDto.setCode(rltShopDto.getCode());
						updShopDto.setRankCode(null);
						updShopDto.setRankExpireTime(null);
						this.shopService.updateShop(updShopDto);
					} else {
						//没过期，如果购买特权小于或等于现特权金额，不允许购买
						MemberRankDto shopRankDto = new MemberRankDto();
						shopRankDto.setCode(rltShopDto.getRankCode());
						MemberRankDto rltShopRankDto = memberRankService.findMemberRank(shopRankDto);
						if(rltNewMemberRank.getAmount().compareTo(rltShopRankDto.getAmount())<=0) { 
							throw new TsfaServiceException(ErrorCode.MEMBER_RANK_APPLY_UPDATE_ERROR,"不允许购买低级特权！");
						}
					}
				}*/
				
				//支付
				PaymentDto paymentDto = new PaymentDto();
				paymentDto.setBizNo(rltRankApplyDto.getCode());
				paymentDto.setMbrCode(memberRankApplyDto.getMemberCode());
				paymentDto.setAmount(rltNewMemberRank.getAmount());
				payment(paymentDto);
				
			}
			
			
			logger.debug("updateMemberRankApplyByApprove(MemberRankApplyDto) - end - return"); //$NON-NLS-1$
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			logger.error("特权申请信息更新信息错误！",e);
			throw new TsfaServiceException(ErrorCode.MEMBER_RANK_APPLY_UPDATE_ERROR,"特权申请信息更新信息错误！",e);
		}
	} 


	@Override
	public void payment(PaymentDto paymentDto) {
		logger.debug("payment(PaymentDto paymentDto={}) - start", paymentDto); 
		AssertUtils.notNull(paymentDto);
		AssertUtils.notNullAndEmpty(paymentDto.getBizNo(),"订单号不能为空");
		try {
			
			MemberRankApplyDto pRankApplyDto = new MemberRankApplyDto();
			pRankApplyDto.setCode(paymentDto.getBizNo());
			MemberRankApplyDto  rApplyDto = findMemberRankApply(pRankApplyDto);
			rApplyDto.setStatus(MemberRankApplyStatus.SUCCESS.getValue());
			
			MemberRankDto pmemberRankDto = new MemberRankDto();
			pmemberRankDto.setCode(rApplyDto.getMemberRankCode());
			MemberRankDto rmemberRankDto = memberRankService.findMemberRank(pmemberRankDto);
			
			AccountDto accountDto = accountService.findAccountByMbrCode(paymentDto.getMbrCode());
			if(rmemberRankDto.getAmount().compareTo(paymentDto.getAmount())<=0){
				
				/*记录账户流水*/
				AccWaterDto accWaterDto = new AccWaterDto();
				accWaterDto.setAccWaterNo(NoUtil.generateNo(NoUtil.JY));
				accWaterDto.setAccDate(new Date());
				accWaterDto.setAccSource(AccWaterSource.VIP.getValue());
				accWaterDto.setAccType(AccWaterAccType.AUTO.getValue());
				accWaterDto.setAmt(paymentDto.getAmount());
				accWaterDto.setAccNo(accountDto.getAccNo());
				accWaterDto.setAccCode(accountDto.getCode());
				accWaterDto.setStatus(AccWaterStatus.SUCCESS.getValue());
				accWaterDto.setPayType(paymentDto.getPaymentMethod());
				accWaterDto.setBizType(AccWaterBizType.RECHARGE.getValue());
				accWaterDto.setWaterType(AccWaterType.ADD.getValue());
				accWaterService.addAccWater(accWaterDto);
			} else {
				throw new TsfaServiceException(ErrorCode.ORDER_PAYMENT_ERROR,"付款金额有误："+paymentDto.getAmount());
			}
			
			//更新会员特权
			MemberDto memberDto = new MemberDto();
			memberDto.setCode(paymentDto.getMbrCode());
			MemberDto member = memberService.findMember(memberDto);
			//首次开通
			if(null==member.getMemberRankCode()||StringUtils.isEmpty(member.getMemberRankCode())){
				member.setMemberRankCode(rmemberRankDto.getCode());
				member.setOpenMemberDate(new Date());
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(member.getOpenMemberDate());
				calendar.add(calendar.YEAR, 1);
				member.setCloseMemberDate(calendar.getTime());
				//设置会员类型为卖家
				member.setType(MemberType.SHOP.getValue());
				//更新账户特权可用余额
				accountDto.setRankCashAmt(rmemberRankDto.getAdvancePayment());
				accountDto.setUpdateTime(new Date());
			}else{
				int oldLevel = Integer.parseInt(member.getMemberRankCode());
				int memberLevel = Integer.parseInt(rApplyDto.getMemberRankCode());
				//升级会员
				if(memberLevel>oldLevel){
					member.setMemberRankCode(rmemberRankDto.getCode());
					member.setOpenMemberDate(new Date());
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(member.getOpenMemberDate());
					calendar.add(calendar.YEAR, 1);
					member.setCloseMemberDate(calendar.getTime());
				}else{
					//续费会员
					if(member.getCloseMemberDate().before(new Date())){
						member.setMemberRankCode(rmemberRankDto.getCode());
						member.setOpenMemberDate(new Date());
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(member.getOpenMemberDate());
						calendar.add(calendar.YEAR, 1);
						member.setCloseMemberDate(calendar.getTime());
					}else{
						member.setMemberRankCode(rmemberRankDto.getCode());
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(member.getCloseMemberDate());
						calendar.add(calendar.YEAR, 1);
						member.setCloseMemberDate(calendar.getTime());
					}
				}
				//更新账户特权可用余额
				accountDto.setRankCashAmt(accountDto.getRankCashAmt().add(rmemberRankDto.getAdvancePayment()));
				accountDto.setUpdateTime(new Date());
			}
			
			
			//更新会员等级,过期时间
			memberService.updateMember(member);
			//更新特权帐户可用余额
			accountService.updateAccount(accountDto);
			
			/*消息通知*/
			MessageDto messageDto = new MessageDto();
			messageDto.setRecevier(member.getCode());
			messageService.addMessageByTemplate(messageDto, MessageTemplate.B_SERVICE_NOT_PARAM_MEMBER_RANK);
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("特权申请支付错误！",e);
			throw new TsfaServiceException(ErrorCode.ORDER_PAYMENT_ERROR,"特权申请支付错误！",e);
		}
		
	}


	/**
	 * 
	 * 方法说明：
	 *
	 * @param @param paymentDto	预支付
	 * @param @param rShopDto	商店实体
	 * @param @param rankCode    新的特权code
	 * @return void    返回类型 
	 * @throws Exception
	 *
	 * @author 林进权
	 *         CreateDate: 2017年9月11日
	 */
	private void updAccount4Rank(MemberDto member, String rankCode, AccountDto accountDto) {
		
		
		
		FindMemberRankPage findMemberRankPage = new FindMemberRankPage();
		List<MemberRankDto>  ranksList = memberRankService.findMemberRanks(findMemberRankPage);
		boolean flag = false;
		BigDecimal prevDecimal = new BigDecimal(0);
		for (MemberRankDto memberRankDto : ranksList) {
			if(flag) {
				if(StringUtils.equal(memberRankDto.getCode(), rankCode)) {
					BigDecimal usableDecimal = memberRankDto.getAmount().subtract(prevDecimal);
					accountDto.setRankCashAmt(accountDto.getRankCashAmt().add(usableDecimal));
					accountService.updateAccount(accountDto);
					break;
				}
			}
			
			//如果现有特权为空，直接增加金额
			if(StringUtils.isEmpty(member.getMemberRankCode()) && StringUtils.equal(memberRankDto.getCode(), rankCode)) {
				accountDto.setRankCashAmt(memberRankDto.getAmount());
				accountService.updateAccount(accountDto);
				break;
			}
			
			//如果有小的商店特权，就记录前一次特权，再进行减除特存差异
			if(StringUtils.equals(member.getMemberRankCode(), memberRankDto.getCode())) {
				prevDecimal = memberRankDto.getAdvancePayment();
				flag = true;
				continue;
			}
		}
	}

	@Override
	public BigDecimal queryAmt(String memberApplyCode) {
		logger.debug("queryAmt(String memberApplyCode={}) - start", memberApplyCode); 
		try {
			MemberRankApplyDto pdto = new MemberRankApplyDto();
			pdto.setCode(memberApplyCode);
			MemberRankApplyDto rltRankApplyDto = findMemberRankApply(pdto);
			
			MemberRankDto paramRankDto = new MemberRankDto();
			paramRankDto.setCode(rltRankApplyDto.getMemberRankCode());
			MemberRankDto rltRankDto = this.memberRankService.findMemberRank(paramRankDto);
			
	
			ShopDto paramShopDto = new ShopDto();
			paramShopDto.setCode(rltRankApplyDto.getMemberCode());
			ShopDto rltShopDto = shopService.findShop(paramShopDto);
			
			//如果商店已有权限，进行校验
			if(null!=rltShopDto && StringUtils.isNotEmpty(rltShopDto.getRankCode())) {
				
				MemberRankDto shopRankDto = new MemberRankDto();
				shopRankDto.setCode(rltShopDto.getRankCode());
				MemberRankDto rltShopRankDto = memberRankService.findMemberRank(shopRankDto);
				if(null!=rltShopRankDto) {
					if(rltRankDto.getAmount().compareTo(rltShopRankDto.getAmount())<=0) {
						throw new TsfaServiceException(ErrorCode.ORDER_PAYMENT_ERROR,"不允许购买更低级的特权！");
					}
					return rltRankDto.getAmount().subtract(rltShopRankDto.getAmount());
				}
			}
			
			logger.debug("queryAmt(String memberApplyCode={}) - end"); 
			return rltRankDto.getAmount();
		}catch (TsfaServiceException e) {
			logger.error(e.getMessage(),e);
			throw e;
		}  catch (Exception e) {
			logger.error("特权申请支付错误！",e);
			throw new TsfaServiceException(ErrorCode.ORDER_PAYMENT_ERROR,"特权申请支付错误！",e);
		}
	}

	public static void main(String[] args) {
		BigDecimal bigDecimal = new BigDecimal(10);
		BigDecimal bigDecimal2 = new BigDecimal(30);
		System.out.println(bigDecimal.subtract(bigDecimal2));
	}
}
