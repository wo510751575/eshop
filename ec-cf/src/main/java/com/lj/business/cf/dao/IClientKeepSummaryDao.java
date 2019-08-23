package com.lj.business.cf.dao;

import java.util.List;

import com.lj.business.cf.domain.ClientKeepSummary;
import com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummary;
import com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummaryPage;
import com.lj.business.cf.dto.clientKeepSummary.FindClientKeepSummaryPageReturn;

public interface IClientKeepSummaryDao {
	
    int deleteByPrimaryKey(String code);

    int insert(ClientKeepSummary record);

    int insertSelective(ClientKeepSummary record);

    ClientKeepSummary selectByPrimaryKey(String code);
    
    ClientKeepSummary selectByCkNo(String ckNo);

    int updateByPrimaryKeySelective(ClientKeepSummary record);
    
    int updateByCkNoSelective(ClientKeepSummary record);

    int updateByPrimaryKey(ClientKeepSummary record);
    
    List<FindClientKeepSummaryPageReturn> findClientKeepSummaryPage(FindClientKeepSummaryPage findClientKeepSummaryPage);
    
    int findClientKeepSummaryPageCount(FindClientKeepSummaryPage findClientKeepSummaryPage);
    
    ClientKeepSummary findClientKeepSummaryLast(FindClientKeepSummary findClientKeepSummary);

	long findCountPmKeepByGm(String memberNo);
    
}