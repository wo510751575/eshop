package com.lj.eoms.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lj.eshop.service.IOrderService;

@Component("orderJob")
@Lazy(false)
public class OrderJob {
	@Autowired
	private IOrderService orderService;

	/**
	 * 
	 *
	 * 方法说明：7天自动好评
	 *
	 *
	 * @author 段志鹏 CreateDate: 2017年9月15日
	 *
	 */
	@Scheduled(cron = "${job.member_order_review.cron}")
	public void autoReview() {
		this.orderService.autoReview();
	}

	/**
	 * 
	 *
	 * 方法说明：7天自动收确认收货
	 *
	 *
	 * @author 段志鹏 CreateDate: 2017年9月15日
	 *
	 */
	@Scheduled(cron = "${job.member_order_receipt.cron}")
	public void autoReceipt() {
		this.orderService.autoReceipt();
	}

}
