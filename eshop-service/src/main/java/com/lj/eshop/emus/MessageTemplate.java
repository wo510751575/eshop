/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.emus;

/**
 * 
 * 类说明：消息模板
 * 
 * <p>
 * 详细描述：[0][1][...]是占位符，视情况自定义 
 *   
 * @Company: 领居科技有限公司
 * @author 林进权
 * CreateDate: 2017年8月23日
 */
public enum MessageTemplate {
	/** 一. B端业务/系统通知. */
	
	/** b端  
		1.C端购买商品提交订单发送通知给B端
		1.1标题：未付款订单 
		   内容：您的客户xxx(客户昵称)提交了一笔未付款的订单。买家：苏阳，金额：756.00元，商品：HELLO KITTY，订单编号：3232145444。
	 * */
	B_SERVICE_ORDER_BILL_NON_PAYMENT("未付款订单", "您的客户[0]提交了一笔未付款的订单<br/>买家：[1]<br/>金额：[2]元<br/>商品：[3]<br/>订单编号：[4]", "B"),
	/** b端  
		2.C端购买商品提交订单已付款发送通知给B端
		2.1标题：已付款订单 
		   内容：买家：您的客户xxx(客户昵称)已支付了一笔订单。买家：苏阳，金额：756.00元，商品：HELLO KITTY,订单编号：3232145444。
	 * */
	B_SERVICE_ORDER_BILL_PAYMENTED("已付款订单", "您的客户[0]已支付了一笔订单<br/>买家：[1]<br/>金额：[2]元<br/>商品：[3]<br/>订单编号：[4]", "B"),
	
	/** b端  
		3.C端购买商品提交订单已收货发送通知给B端
		3.1 标题：已完成订单 
		    内容：您的客户xxx(客户昵称)确认收货了，买家：苏阳，金额：756.00元，商品：HELLO KITTY,订单编号：3232145444。
	 * */
	B_SERVICE_ORDER_BILL_COMPLETED("已完成订单", "您的客户[0]确认收货了<br/>买家：[1]<br/>金额：[2]元<br/>商品：[3]<br/>订单编号：[4]", "B"),
	/** b端  
		4.C端申请退货发送通知给B端
		4.1 标题：退货订单 
		    内容：您的客户xxx(客户昵称)申请退货，商品：HELLO KITTY,退货单号：3232145445。
	 * */
	B_SERVICE_ORDER_BILL_BACK("退货订单", "您的客户[0]申请退货<br/>商品：[1]<br/>退货单号：[2]", "B"),
	
	/** b端  
		5.定制商品商家提供报价发送通知给B端
			5.1 标题：定制商品订单 
			    内容：您提交的定制商品商家已经反馈，快去查看吧！
	 * */
	B_SERVICE_NOT_PARAM_ORDER_BILL_FEEDBACK("定制商品订单", "您提交的定制商品商家已经反馈，快去查看吧！", "B"),
	/** b端  
		6.提现成功发送通知给B端
		6.1 标题：提现申请
		    内容：您申请的提现已成功，快去查看吧！
	 * */
	B_SERVICE_NOT_PARAM_WITHDRAW("提现申请", "您申请的提现已成功，快去查看吧！", "B"),
	/** b端  
		7.开通特权成功发送通知给B端
		7.1 标题：开通特权成功 
		    内容：您已成功开通特权，快去免费穿戴商品吧！
	 * */
	B_SERVICE_NOT_PARAM_MEMBER_RANK("开通特权成功", "您已成功开通特权，快去免费穿戴商品吧！", "B"),
	/** b端  
		系统消息通知类型：
		1.修改绑定手机号通知
		1.1标题：修改绑定手机号  
		   内容：您的绑定手机号于XX时候进行了修改，请知悉。
	 * */
	B_SYS_CHANGE_PASSWORD("修改绑定手机号", "您的绑定手机号于[0]时候进行了修改，请知悉。", "B"),
	/** b端  
		2.修改提现密码通知
		2.1标题：修改提现密码 
		   内容：您的提现密码于XX时候进行了修改，请知悉。
	 * */
	B_SYS_WITHDRAW("修改提现密码", "您的提现密码于[0]时候进行了修改，请知悉。", "B"),
	
	
	
	/** 二. C端业务/系统通知. */
	/** C端  
		1.退货申请成功发送通知
		1.1标题：退货申请成功 
		   内容：您提交的退货申请已申请成功，商品：HELLO KITTY,退货单号：		3232145445。
	 * */
	C_SERVICE_BACK_SUCCESS("退货申请成功", "您提交的退货申请已申请成功，<br/>商品：[0]<br/>退货单号：[1]", "C"),
	/** C端  
		2.商品已发货发送通知
		1.2标题：商品已经发货
		   内容：您购买的商品已经发货，马上就能以您相遇啦！
	 * */
	C_SYS_NOT_PARAM_COMMODITY_SENDED("商品已经发货", "您购买的商品已经发货，马上就能以您相遇啦！", "C"),
	/** C端  
		1.C端申请开店通知
		1.1 标题：开店申请进度 
		    内容：您的店铺正在审核中，我们会在三个工作日内给予答复

	 * */
	C_SYS_NOT_PARAM_OPEN_STORE("开店申请进度", "您的店铺正在审核中，我们会在三个工作日内给予答复。", "C"),
		
	
	;
	
	
	
	
	MessageTemplate(String title, String chContent, String bizCode) {
		this.title = title;
		this.chContent = chContent;
		this.bizCode = bizCode;
	}
	
	
	
	private String title;// DB 存贮值
	private String chContent;// 值对应的中文描述
	private String bizCode; //业务编码
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getChContent() {
		return chContent;
	}
	
	/**
	 * 方法说明：模板占位符替换
	 * 
	 * @param @param params
	 * @author 林进权
	 *         CreateDate: 2017年9月1日
	 */
	public String getChContent(String... params ) {
		String tmp = chContent;
		for (int i = 0; i < params.length; i++) {
			tmp = tmp.replace("["+i+"]", params[i]);
		}
		return tmp;
	}

	public void setChContent(String chContent) {
		this.chContent = chContent;
	}

	public String getBizCode() {
		return bizCode;
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}
	
}
