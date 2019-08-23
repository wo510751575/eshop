package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.Summary;
import com.lj.eshop.dto.FindSummaryPage;
import com.lj.eshop.dto.SummaryDto;

public interface ISummaryDao {
    int insertSelective(Summary record);

    Summary selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Summary record);

    List<SummaryDto> findSummaryPage(FindSummaryPage findSummaryPage);

   	int findSummaryPageCount(FindSummaryPage findSummaryPage);
   	
   	List<SummaryDto> findSummarys(FindSummaryPage findSummaryPage);

   	/*查询出昨日订单统计数据*/
	List<Summary> orderCount();
}