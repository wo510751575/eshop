/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.account;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.eshop.dto.BankInfoDto;
import com.lj.eshop.dto.FindBankInfoPage;
import com.lj.eshop.dto.FindMbrbankPage;
import com.lj.eshop.dto.MbrbankDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.service.IBankInfoService;
import com.lj.eshop.service.IMbrbankService;

/**
 * 
 * 类说明：银行卡管理。
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年9月4日
 */
@RestController
public class BankCardController extends BaseController {
	private static final Logger log = LoggerFactory .getLogger(BankCardController.class);
	
	@Autowired
	IBankInfoService bankInfoService;
	@Autowired
	IMbrbankService mbrbankService;
	
	/**
	 * 方法说明：银行列表。
	 *
	 * @return
	 *
	 * @author lhy 2017年9月4日
	 *
	 */
	@RequestMapping(value = "/bank/list", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto findBankList() {
		FindBankInfoPage findBankInfoPage=new FindBankInfoPage();
		List<BankInfoDto> bankInfoDtos=bankInfoService.findBankInfos(findBankInfoPage);
		return ResponseDto.successResp(bankInfoDtos);
	}

	/**
	 * 方法说明：当前登录会员银行卡列表。
	 *
	 * @return
	 *
	 * @author lhy 2017年9月4日
	 *
	 */
	@RequestMapping(value = "/bankcard/list", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto list() {
		log.info("mbrbank list ");
		String mbrCode = getLoginMemberCode();
		FindMbrbankPage findParam = new FindMbrbankPage();
		MbrbankDto mbrbankDto=new MbrbankDto();
		mbrbankDto.setMbrCode(mbrCode);
		
		findParam.setParam(mbrbankDto);
		List<MbrbankDto> bankInfoDtos = mbrbankService.findMbrbanks(findParam);
		log.info("mbrbank list end");
		return ResponseDto.successResp(bankInfoDtos);
	}

	/**
	 * 方法说明：存贮银行卡信息。
	 *
	 * @return
	 *
	 * @author lhy 2017年9月4日
	 *
	 */
	@RequestMapping(value = "/bankcard/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto save(MbrbankDto mbrbankDto) {
		log.info("mbrbank save " + mbrbankDto);
		if(StringUtils.isBlank(mbrbankDto.getAccName())
			||StringUtils.isBlank(mbrbankDto.getBankAccNo())
			||StringUtils.isBlank(mbrbankDto.getBankCode())
			||StringUtils.isBlank(mbrbankDto.getBankName())
			||StringUtils.isBlank(mbrbankDto.getPhone())){
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		String mbrCode = getLoginMemberCode();
		mbrbankDto.setMbrCode(mbrCode);
		FindMbrbankPage findMbrbankPage=new FindMbrbankPage();
		MbrbankDto p=new MbrbankDto();
		p.setMbrCode(mbrCode);
		p.setBankAccNo(mbrbankDto.getBankAccNo());
		findMbrbankPage.setParam(p);
		
		List<MbrbankDto> findBanks=mbrbankService.findMbrbanks(findMbrbankPage);
		if (findBanks != null && findBanks.size() > 0) {
			return ResponseDto.getErrorResponse(ResponseCode.BANKCARD_REPEAT);
		}
		mbrbankService.addMbrbank(mbrbankDto);
		log.info("mbrbank save end");
		return ResponseDto.successResp(null);
	}
}
