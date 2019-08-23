/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.account;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.pagination.PageSortType;
import com.lj.eshop.dto.AccWaterDto;
import com.lj.eshop.dto.AccountDto;
import com.lj.eshop.dto.FindAccWaterPage;
import com.lj.eshop.dto.FindWithdrawPage;
import com.lj.eshop.dto.MbrbankDto;
import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.dto.WithdrawDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.eis.dto.WithdrawApplyDto;
import com.lj.eshop.eis.utils.encryption.EncryptionUtils;
import com.lj.eshop.emus.AccWaterBizType;
import com.lj.eshop.emus.AccWaterPayType;
import com.lj.eshop.emus.AccWaterStatus;
import com.lj.eshop.emus.AccWaterType;
import com.lj.eshop.service.IAccWaterService;
import com.lj.eshop.service.IAccountService;
import com.lj.eshop.service.IMbrbankService;
import com.lj.eshop.service.IMessageService;
import com.lj.eshop.service.IWithdrawService;

/**
 * 
 * 类说明：虚拟账户管理。
 * <p>
 * 详细描述：
 * 
 * @Company: 领居科技有限公司
 * @author lhy  CreateDate: 2017年9月4日
 */
@RestController
@RequestMapping("/acct")
public class AccountController extends BaseController {
	private static final Logger log = LoggerFactory .getLogger(AccountController.class);
	/** 提现密码锁定时长 （毫秒） 1小时 */
	private static final int PAY_PWD_LOCK_TIME_MILLISECOND = 3600000;
	/** 提现密码连续错误 最多次数 **/
	private static final int PAY_PWD_WRONG_MAX_CNT = 5;
	
	@Autowired
	IAccountService accountService;
	@Autowired
	IAccWaterService accWaterService;
	@Autowired
	IWithdrawService withdrawService;
	@Autowired
	IMbrbankService mbrbankService;
	@Autowired
	IMessageService messageService;
	/***
	 * 方法说明：虚拟账户首页查询。
	 *
	 * @return
	 *
	 * @author lhy  2017年9月4日
	 *
	 */
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto index() {
		log.info("AccountController.index ");
		String mbrCode = getLoginMemberCode();
		AccountDto accountDto=accountService.findAccountByMbrCode(mbrCode);
		
		//返回的数据，没必要的敏感数据不返回
		AccountDto resAcct=new AccountDto();
		resAcct.setCashAmt(accountDto.getCashAmt());//可用金额
		resAcct.setTotalWithdrawAmt(accountDto.getTotalWithdrawAmt());//已提现金额
		//累计收益 
		FindAccWaterPage findAccWaterPage=new FindAccWaterPage();
		AccWaterDto param=new AccWaterDto();
		param.setWaterType(AccWaterType.ADD.getValue());
		param.setStatus(AccWaterStatus.SUCCESS.getValue());
		param.setAccCode(accountDto.getCode());
		param.setBizType(AccWaterBizType.COMMISSION.getValue());
		findAccWaterPage.setParam(param);
		BigDecimal incomeAmt= accWaterService.findIncomeAmt(findAccWaterPage);
		
		resAcct.setIncomeAmt(incomeAmt);//累计收益
		log.info("AccountController.index end ");
		return ResponseDto.successResp(resAcct);
	}
	
	/**
	 * 方法说明：提现申请。
	 *
	 * @return
	 *
	 * @author lhy  2017年9月5日
	 *
	 */
	@RequestMapping(value = "/withdraw/apply", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto withdrawApply(WithdrawApplyDto withdrawDto) {
		log.debug("AccountController.index [withdrawDto:]"+withdrawDto);
		if(StringUtils.isBlank(withdrawDto.getBankCardCode())){
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		if(BigDecimal.ZERO.compareTo(withdrawDto.getAmt())>=0){//提现金额必须大于0
			return ResponseDto.getErrorResponse(ResponseCode.ACC_AMT_MUST_MORE_THAN_ZERO);
		}
		MemberDto member=getLoginMember();
//		//校验密码 屏蔽 2017.09.20  冯总提出的需求
//		ResponseDto checkResult=checkPaypwd(withdrawDto.getPayPwd());
//		if (checkResult != null) {
//			return checkResult;
//		}
		MbrbankDto findBank=new MbrbankDto();
		findBank.setCode(withdrawDto.getBankCardCode());
		MbrbankDto mbrbank=mbrbankService.findMbrbank(findBank);//先找到提现的银行卡
		
		WithdrawDto apply=new WithdrawDto();
		apply.setAmt(withdrawDto.getAmt());//申请金额
		apply.setMbrCode(member.getCode());//申请提现人
		apply.setBankAccNo(mbrbank.getBankAccNo());//提现银行信息
		apply.setMbrName(mbrbank.getAccName());
		apply.setBankName(mbrbank.getBankName());
		apply.setBranchBank(mbrbank.getBranchBank());
		apply.setPhone(mbrbank.getPhone());
		withdrawService.addWithdraw(apply);
		
		//5.发送通知信息 成功才发
//		MessageDto messageDto = new MessageDto();
//		messageDto.setRecevier(member.getCode());
//		messageService.addMessageByTemplate(messageDto, MessageTemplate.B_SERVICE_NOT_PARAM_WITHDRAW);
		
		return ResponseDto.successResp(null);
	}

	/**
	 * 方法说明：校验提现密码是否异常。
	 * @param inputPayPwd
	 * @return ResponseDto（异常则返回结果，没有异常则返回null）
	 *
	 * @author lhy  2017年9月9日
	 *
	 */
	private ResponseDto checkPaypwd(String inputPayPwd) {
		String mbrCode = getLoginMemberCode();
		AccountDto accountDto=accountService.findAccountByMbrCode(mbrCode);
		if(StringUtils.isBlank(accountDto.getPayPwd())){
			return ResponseDto.getErrorResponse(ResponseCode.PAY_PWD_UNSET);
		}
		// 密码错误次数校验
		Long now = System.currentTimeMillis();
		// 1.检验次数和是否在锁定期，是则提示密码连续错误N次，已被锁定
		if (accountDto.getWrongCnt() >= PAY_PWD_WRONG_MAX_CNT
				&& (now - accountDto.getWrongTime().getTime()) < PAY_PWD_LOCK_TIME_MILLISECOND) {
			String msg = "提现密码锁定中！锁定期限"
					+ (PAY_PWD_LOCK_TIME_MILLISECOND / 3600000) + "小时。";
			return ResponseDto.getErrorResponse(
					ResponseCode.PAY_PWD_LOCK.getCode(), msg);
		}
		// 2.过了锁定时间周期错误则重置错误错误次数为1 ，并记录当前错误时间
		if (!accountDto.getPayPwd().equals(EncryptionUtils.md5SavePwd(inputPayPwd))) {
			AccountDto updAcc = new AccountDto();
			updAcc.setCode(accountDto.getCode());
			updAcc.setWrongTime(new Date());
			if (accountDto.getWrongTime() == null) {
				updAcc.setWrongCnt(1);
			} else if ((now - accountDto.getWrongTime().getTime()) > PAY_PWD_LOCK_TIME_MILLISECOND) {
				updAcc.setWrongCnt(1);
			} else {
				updAcc.setWrongCnt(accountDto.getWrongCnt() + 1);
			}
			accountService.updateAccount(updAcc);// 记录密码输入错误次数
			String msg = "提现密码错误，您已连续输错" + updAcc.getWrongCnt() + "次，最多"
					+ PAY_PWD_WRONG_MAX_CNT + "次机会。";
			return ResponseDto.getErrorResponse(
					ResponseCode.PAY_PWD_ERROR.getCode(), msg);
		} else {// 密码输入正确，重置错误次数
			AccountDto updAcc = new AccountDto();
			updAcc.setCode(accountDto.getCode());
			updAcc.setWrongCnt(0);
			accountService.updateAccount(updAcc);// 记录密码输入错误次数为0
		}
		return null;
	}
	/**
	 * 方法说明：累计收益明细列表。
	 * @return
	 *
	 * @author lhy  2017年9月5日
	 *
	 */
	@RequestMapping(value = "/water/income/list", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto findIncomeWaterList(FindAccWaterPage findAccWaterPage,Integer pageNo,Integer pageSize) {
		String mbrCode = getLoginMemberCode();
		AccWaterDto param = findAccWaterPage.getParam();
		AccountDto accountDto=accountService.findAccountByMbrCode(mbrCode);
		if (param == null) {
			param = new AccWaterDto();
			findAccWaterPage.setParam(param);
		}
		param.setAccCode(accountDto.getCode());
		param.setWaterType(AccWaterType.ADD.getValue());
		param.setBizType(AccWaterBizType.COMMISSION.getValue());//提成的收入
		param.setStatus(AccWaterStatus.SUCCESS.getValue());
		if(pageNo!=null){
			findAccWaterPage.setStart((pageNo-1)*pageSize);
		}
		if(pageSize!=null){
			findAccWaterPage.setLimit(pageSize);
		}
		findAccWaterPage.setSortBy("create_time");
		findAccWaterPage.setSortDir(PageSortType.desc);
		
		Page<AccWaterDto> page=accWaterService.findAcctWaterDetailPage(findAccWaterPage);
		return ResponseDto.successResp(page);
	}
	
	/**
	 * 方法说明：收支明细列表。
	 * @return
	 *
	 * @author lhy  2017年9月5日
	 *
	 */
	@RequestMapping(value = "/water/all/list", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto findWaterList(FindAccWaterPage findAccWaterPage,Integer pageNo,Integer pageSize) {
		String mbrCode = getLoginMemberCode();
		AccWaterDto param = findAccWaterPage.getParam();
		AccountDto accountDto=accountService.findAccountByMbrCode(mbrCode);
		if (param == null) {
			param = new AccWaterDto();
			findAccWaterPage.setParam(param);
		}
		param.setAccCode(accountDto.getCode());
		param.setPayType(AccWaterPayType.VIRTUAL.getValue());//平台虚户的出入账单
		param.setStatus(AccWaterStatus.SUCCESS.getValue());
		if(pageNo!=null){
			findAccWaterPage.setStart((pageNo-1)*pageSize);
		}
		if(pageSize!=null){
			findAccWaterPage.setLimit(pageSize);
		}
		findAccWaterPage.setSortBy("create_time");
		findAccWaterPage.setSortDir(PageSortType.desc);
		
		Page<AccWaterDto> page=accWaterService.findAllAcctWaterDetailPage(findAccWaterPage);
		return ResponseDto.successResp(page);
	}
	
	/**
	 * 方法说明：提现列表。
	 * @return
	 *
	 * @author lhy  2017年9月5日
	 *
	 */
	@RequestMapping(value = "/withdraw/list", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto findWithdrawList(FindWithdrawPage findWithdrawPage,Integer pageNo,Integer pageSize) {
		String mbrCode = getLoginMemberCode();
		WithdrawDto param = findWithdrawPage.getParam();
		if (param == null) {
			param = new WithdrawDto();
			findWithdrawPage.setParam(param);
		}
		param.setMbrCode(mbrCode);
		findWithdrawPage.setSortBy("create_time");
		findWithdrawPage.setSortDir(PageSortType.desc);
		if(pageNo!=null){
			findWithdrawPage.setStart((pageNo-1)*pageSize);
		}
		if(pageSize!=null){
			findWithdrawPage.setLimit(pageSize);
		}
		Page<WithdrawDto> page=withdrawService.findWithdrawPage(findWithdrawPage);
		return ResponseDto.successResp(page);
	}
	
	/**
	 * 方法说明：提现详情。
	 * @return
	 * @author lhy  2017年9月5日
	 *
	 */
	@RequestMapping(value = "/withdraw/detail", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto findWithdrawDetail(String code) {
		if (StringUtils.isBlank(code)) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		WithdrawDto param = new WithdrawDto();
		param.setCode(code);
		WithdrawDto rtDate = withdrawService.findWithdraw(param);
		return ResponseDto.successResp(rtDate);
	}
	
}
