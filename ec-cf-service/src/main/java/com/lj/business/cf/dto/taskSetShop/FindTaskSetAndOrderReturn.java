package com.lj.business.cf.dto.taskSetShop;

import java.io.Serializable;
import java.util.List;

import com.lj.business.cf.dto.clientFollow.FindClientFollowOrder;

/**
 * 
 * 
 * 类说明：查询销售目标和订单
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 领居科技有限公司
 * @author 武鹏飞
 * 
 *         CreateDate: 2017年7月21日
 */
public class FindTaskSetAndOrderReturn implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5278547443592756621L;

	/**
	 * 本月销售额
	 */
	private Long monthSale;

	/**
	 * 今日需完成
	 */
	private Long todayNeedSale;

	/**
	 * 本月已完成
	 */
	private Long monthComplete;

	/**
	 * 今日未完成
	 */
	private Long todayUncomplete;

	/**
	 * 会员订单
	 */
	private List<FindClientFollowOrder> orderList;

	/**
	 * 任务单位
	 */
	private String taskUnit;

	public Long getMonthSale() {
		return monthSale;
	}

	public void setMonthSale(Long monthSale) {
		this.monthSale = monthSale;
	}

	public Long getTodayNeedSale() {
		return todayNeedSale;
	}

	public void setTodayNeedSale(Long todayNeedSale) {
		this.todayNeedSale = todayNeedSale;
	}

	public Long getMonthComplete() {
		return monthComplete;
	}

	public void setMonthComplete(Long monthComplete) {
		this.monthComplete = monthComplete;
	}

	public Long getTodayUncomplete() {
		return todayUncomplete;
	}

	public void setTodayUncomplete(Long todayUncomplete) {
		this.todayUncomplete = todayUncomplete;
	}

	public List<FindClientFollowOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<FindClientFollowOrder> orderList) {
		this.orderList = orderList;
	}

	public String getTaskUnit() {
		return taskUnit;
	}

	public void setTaskUnit(String taskUnit) {
		this.taskUnit = taskUnit;
	}
}
