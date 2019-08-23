/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.constant.NoUtil;
import com.lj.eshop.dto.AccountDto;
import com.lj.eshop.dto.FindPaymentPage;
import com.lj.eshop.dto.OrderDto;
import com.lj.eshop.dto.PaymentDto;
import com.lj.eshop.eis.constant.DevConfig;
import com.lj.eshop.eis.constant.PayAccSourceConstant;
import com.lj.eshop.eis.controller.weixin.dto.WxPayReqDto;
import com.lj.eshop.eis.controller.weixin.dto.WxPayRespDto;
import com.lj.eshop.eis.controller.weixin.service.WeixinPayService;
import com.lj.eshop.eis.dto.PayReqDto;
import com.lj.eshop.eis.dto.PayRespDto;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.emus.AccWaterPayType;
import com.lj.eshop.emus.AccWaterSource;
import com.lj.eshop.emus.DelFlag;
import com.lj.eshop.emus.PaymentStatus;
import com.lj.eshop.emus.PaymentType;
import com.lj.eshop.service.IAccountService;
import com.lj.eshop.service.IMemberRankApplyService;
import com.lj.eshop.service.IOrderService;
import com.lj.eshop.service.IPaymentService;
import com.lj.eshop.service.IShopService;

/**
 * 类说明：支付业务处理。
 * <p>
 * @Company: 领居科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月8日
 */
@Service 
public class PayService {
	private static final Logger LOG = LoggerFactory .getLogger(PayService.class);
	@Autowired
	private WeixinPayService weixinPayService;
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IAccountService accountService;
	@Autowired
	private IShopService shopService;
	@Autowired 
	private IMemberRankApplyService memberRankApplyService;
	@Autowired 
	private MbrGuidMemberService mbrGuidMemberService;
	/***
	 * 方法说明：订单支付。
	 * @param dto 订单信息。
	 * @return
	 *
	 * @author lhy  2017年9月8日
	 *
	 */
	public PayRespDto payment(PayReqDto dto){
		if(StringUtils.isBlank(dto.getAccSource())
			||	StringUtils.isBlank(dto.getMbrCode())
			||	StringUtils.isBlank(dto.getOrderNo())
			||	StringUtils.isBlank(dto.getPayType())){
			throw new TsfaServiceException(ResponseCode.PARAM_ERROR.getCode(),ResponseCode.PARAM_ERROR.getMsg());
		}
		PayRespDto resp=new PayRespDto();
		resp.setPayType(dto.getPayType());
		//1.生成支付流水
		PaymentDto payment = createPayment(dto);
		//2.根据支付方式走支付
		if(AccWaterPayType.WX.getValue().equals(dto.getPayType())){//微信支付
			if(StringUtils.isBlank(dto.getUrl())){
				throw new TsfaServiceException(ResponseCode.PARAM_ERROR.getCode(),ResponseCode.PARAM_ERROR.getMsg());
			}
			WxPayReqDto wxPayReqDto=new WxPayReqDto();
			wxPayReqDto.setMbrCode(dto.getMbrCode());
			wxPayReqDto.setBody(payment.getMemo());
			wxPayReqDto.setSpbillCreateIp(dto.getSpbillCreateIp());
			wxPayReqDto.setTotalFee(payment.getAmount().multiply(new BigDecimal(100)).setScale(0, BigDecimal.ROUND_HALF_UP));
			wxPayReqDto.setUrl(dto.getUrl());
			wxPayReqDto.setOutTradeNo(payment.getThirdpartyTradeNo());//生成的预付单号
			WxPayRespDto wxPayRespDto = weixinPayService.prePay(wxPayReqDto);
			resp.setData(wxPayRespDto);
		}else{
			throw new TsfaServiceException(ResponseCode.PAY_TYPE_NOT_EXIST.getCode(),ResponseCode.PAY_TYPE_NOT_EXIST.getMsg());
		}
		//3.0 模拟支付成功
		if(DevConfig.isDevTest()){
			paySuccess(payment);
		}
		//3.1非第三方支付，支付成功立即回写支付状态及回调通知订单结果
		//3.2第三方支付，等待支付成功后回调再回写支付状态和通知支付结果
		return resp;
	}

	/**
    *
    * 方法说明：支付成功。
    * todo
    * @param payment
    *
    * @author lhy  2017年9月8日
    *
    */
   private void paySuccess(PaymentDto payment){
	   PaymentDto s = getPaymentByTradeNo(payment.getThirdpartyTradeNo());
       PaymentDto u = new PaymentDto();
       u.setCode(s.getCode());
       /* 支付成功后修改支付流水状态  */
       u.setStatus(PaymentStatus.SUCCESS.getValue());
       u.setPaymentDate(new Date());
       s.setPaymentDate(u.getPaymentDate());
       s.setStatus(PaymentStatus.SUCCESS.getValue());
       paymentService.updatePayment(u);
       notifyBizPayRusult(s);
   }

	/**
	*
	* 方法说明：通知支付业务支付成功。
	* @param payment
	*
	* @author lhy  2017年9月8日
	*
	*/
	private void notifyBizPayRusult(PaymentDto payment){
		try{
			// 对业务逻辑进行处理 修改数据库
			if (AccWaterSource.ORDER.getValue().equals(payment.getAccSource())) {
				orderService.payment(payment);// 通知订单支付成功
			} else if (AccWaterSource.DEPOSIT.getValue().equals(payment.getAccSource())) {
				shopService.payment(payment);
				// mbrGuidMemberService.addGuidMember(payment.getBizNo()); todo
			} else if (AccWaterSource.VIP.getValue().equals(payment.getAccSource())) {
				memberRankApplyService.payment(payment);
			}
		} catch (Exception e) {//异常不外抛
			LOG.error("支付成功，通知业务异常。", e);
		}
	}
	
   /**
    * 方法说明：获取支付流水。
    *
    * @param thirdpartyTradeNo
    * @return
    *
    * @author lhy  2017年9月8日
    *
    */
   private PaymentDto getPaymentByTradeNo(String thirdpartyTradeNo ){
		FindPaymentPage findPaymentPage=new FindPaymentPage();
		PaymentDto param=new PaymentDto();
		param.setThirdpartyTradeNo(thirdpartyTradeNo);
		findPaymentPage.setParam(param);
		List<PaymentDto> water=paymentService.findPayments(findPaymentPage);
		if (water == null || water.isEmpty()) {
			return null;
		} 
		return water.get(0);
	}
	/***
	 *
	 * 方法说明：根据订单号找订单。
	 *
	 * @param orderNo 商品订单号
	 * @return
	 *
	 * @author lhy  2017年9月8日
	 *
	 */
	private OrderDto getOrderDtoByNo(String orderNo){
    	OrderDto orderDto=orderService.findOrderByOrderNo(orderNo);
    	return orderDto;
	}
	
	/**
	 * 方法说明：找出订单的支付金额。
	 * @param dto
	 * @return
	 *
	 * @author lhy  2017年9月8日
	 *
	 */
	private BigDecimal getAmtByNo(PayReqDto dto){
		if (AccWaterSource.ORDER.getValue().equals(dto.getAccSource())) {
			OrderDto order=getOrderDtoByNo(dto.getOrderNo());
			return order.getAmt();
		}
		if (AccWaterSource.DEPOSIT.getValue().equals(dto.getAccSource())) {
			return shopService.queryCashPledge(dto.getOrderNo());
		}
		if (AccWaterSource.VIP.getValue().equals(dto.getAccSource())) {
			return memberRankApplyService.queryAmt(dto.getOrderNo());
		}
		throw new TsfaServiceException(ResponseCode.PAY_BIZ_NOT_EXIST.getCode(),ResponseCode.PAY_BIZ_NOT_EXIST.getMsg());
	}
	
	/**
	 * 方法说明：创建支付流水。
	 * @param dto
	 * @return
	 *
	 * @author lhy  2017年9月8日
	 *
	 */
	private PaymentDto createPayment(PayReqDto dto){
		//0.检测订单是否已支付
		checkPaymentByBizNo(dto.getOrderNo(), dto.getAccSource()); 
		//1.根据业务查询订单支付金额
		BigDecimal amt=getAmtByNo(dto);
		//2.生成预付流水
		PaymentDto rt=addPayment(dto, amt);
		return rt;
	}
	/**
	 * 方法说明：创建微信支付订单。
	 * @param dto
	 * @param amt
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author lhy  2017年9月8日
	 *
	 */
	private PaymentDto addPayment(PayReqDto dto,BigDecimal amt) throws TsfaServiceException{
		PaymentDto paymentDto = new PaymentDto();
		String body=PayAccSourceConstant.bizSources.get(dto.getAccSource());
		body = (body == null) ? "购买商品" : body;
		AccountDto account=accountService.findAccountByMbrCode(dto.getMbrCode());
		//add数据录入
		paymentDto.setAccCode(account.getCode());
		paymentDto.setBank(null);
		paymentDto.setExpire(null);
		paymentDto.setFee(BigDecimal.ZERO);
		paymentDto.setMemo(body);
		paymentDto.setOperator(dto.getMbrCode());
		paymentDto.setPayer(dto.getMbrCode());
		paymentDto.setPaymentDate(new Date());
		paymentDto.setPaymentMethod(dto.getPayType());
		paymentDto.setSn(NoUtil.generateNo(NoUtil.JY));
		paymentDto.setStatus(PaymentStatus.WAIT.getValue());
		paymentDto.setType(PaymentType.ONLINE.getValue());
		paymentDto.setMbrCode(dto.getMbrCode());
		paymentDto.setBizNo(dto.getOrderNo());
		paymentDto.setDelFlag(DelFlag.N.getValue());
		paymentDto.setThirdpartyTradeNo(NoUtil.generateNo(NoUtil.JY));
		paymentDto.setAmount(amt);
		paymentDto.setFailReason(null);
		paymentDto.setAccSource(dto.getAccSource());
		paymentService.addPayment(paymentDto);
		return paymentDto;
	}
	

	/**
	 * 方法说明：检测是否已支付成功。
	 * @param bizNo 业务单号
	 * @return
	 *
	 * @author lhy  2017年9月8日
	 *
	 */
	private void checkPaymentByBizNo(String bizNo,String bizSource){
		FindPaymentPage findPaymentPage=new FindPaymentPage();
		PaymentDto param=new PaymentDto();
		param.setBizNo(bizNo);
		param.setAccSource(bizSource);
		param.setStatus(PaymentStatus.SUCCESS.getValue());
		findPaymentPage.setParam(param);
		List<PaymentDto> water=paymentService.findPayments(findPaymentPage);
		if (water != null && !water.isEmpty()) {
			throw new TsfaServiceException(ResponseCode.PAY_REPEAT.getCode(),ResponseCode.PAY_REPEAT.getMsg());
		} 
	}
	
 
}
