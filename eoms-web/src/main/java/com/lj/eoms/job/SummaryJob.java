package com.lj.eoms.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lj.eshop.service.ISummaryService;

@Component("summaryJob")
@Lazy(false)
public class SummaryJob {
	/** Logger for this class. */
	private static final Logger logger = LoggerFactory.getLogger(SummaryJob.class);
	@Autowired
	private ISummaryService summaryService;
	@Autowired
	private TaskExecutor taskExecutor;

	/**
	 * 
	 *
	 * 方法说明：统计
	 *
	 *
	 * @author 段志鹏 CreateDate: 2017年9月18日
	 *
	 */
	@Scheduled(cron = "${job.summary.cron}")
	public void summary() {
		try {

			/*会员统计*/
			taskExecutor.execute(new Runnable() {
				public void run() {
					summaryService.memberSummary();
				}
			});
			/*销售额统计*/
			taskExecutor.execute(new Runnable() {
				public void run() {
					summaryService.amtSummary();
				}
			});
			/*订单统计*/
			taskExecutor.execute(new Runnable() {
				public void run() {
					summaryService.orderSummary();
				}
			});
			/*商品类别统计*/
			taskExecutor.execute(new Runnable() {
				public void run() {
					summaryService.productCatalogSummary();
				}
			});
		} catch (Exception localException) {
			logger.error("统计异常",localException);
			localException.printStackTrace();
		}
	}

}
