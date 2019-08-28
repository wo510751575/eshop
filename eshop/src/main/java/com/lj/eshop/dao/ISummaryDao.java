package com.lj.eshop.dao;

import java.math.BigDecimal;
import java.util.List;

import com.lj.eshop.domain.Summary;
import com.lj.eshop.dto.FindSummaryPage;
import com.lj.eshop.dto.SummaryDayDto;
import com.lj.eshop.dto.SummaryDto;
import com.lj.eshop.dto.SummaryRadioDto;

public interface ISummaryDao {
    int insertSelective(Summary record);

    Summary selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Summary record);

    List<SummaryDto> findSummaryPage(FindSummaryPage findSummaryPage);

   	int findSummaryPageCount(FindSummaryPage findSummaryPage);
   	
   	List<SummaryDto> findSummarys(FindSummaryPage findSummaryPage);

   	/*查询出昨日订单统计数据*/
	List<Summary> orderCount();
	
	/**
	 * 方法说明：合计时间区域内总量
	 *
	 * @param findSummaryPage
	 * @return
	 *
	 * @author lhy  2017年9月28日
	 *
	 */
	BigDecimal findSummarysCount(FindSummaryPage findSummaryPage);
	/**
	 * 方法说明：统计时间区域内按日总量
	 *
	 * @param findSummaryPage
	 * @return
	 *
	 * @author lhy  2017年9月28日
	 *
	 */
	List<SummaryDayDto> findSummarysGroupByDay(FindSummaryPage findSummaryPage);
	
	/**
	 * 方法说明：统计时间区域内按业务状态分组总量
	 *
	 * @param findSummaryPage
	 * @return
	 *
	 * @author lhy  2017年9月28日
	 *
	 */
	List<SummaryRadioDto> findSummarysGroupByName(FindSummaryPage findSummaryPage);
	
	
}