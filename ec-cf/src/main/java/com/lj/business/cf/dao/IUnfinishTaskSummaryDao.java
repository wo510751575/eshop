package com.lj.business.cf.dao;

import java.util.List;

import com.lj.business.cf.domain.UnfinishTaskSummary;
import com.lj.business.cf.dto.unfinishTaskSummary.FindUnfinishTaskSummary;

public interface IUnfinishTaskSummaryDao {
	
    int deleteByPrimaryKey(String code);

    int insert(UnfinishTaskSummary record);

    int insertSelective(UnfinishTaskSummary record);

    UnfinishTaskSummary selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(UnfinishTaskSummary record);

    int updateByPrimaryKey(UnfinishTaskSummary record);
    
    int findUtsCountGm(FindUnfinishTaskSummary findUnfinishTaskSummary);
    
    List<UnfinishTaskSummary> findWtsUnfinish(FindUnfinishTaskSummary findUnfinishTaskSummary);
}