package com.lj.business.cf.dao;

import java.util.List;
import java.util.Map;

import com.lj.business.cf.domain.ClientFollowSummary;
import com.lj.business.cf.dto.clientFollowSummary.FindAbandonRecordCountReturn;
import com.lj.business.cf.dto.clientFollowSummary.FindBuyRecordCountReturn;
import com.lj.business.cf.dto.clientFollowSummary.FindBuyRecordPage;
import com.lj.business.cf.dto.clientFollowSummary.FindBuyRecordPageReturn;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummary;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummaryPage;
import com.lj.business.cf.dto.clientFollowSummary.FindClientFollowSummaryPageReturn;
import com.lj.business.cf.dto.clientFollowSummary.FindSuccessNum;

public interface IClientFollowSummaryDao {
    int deleteByPrimaryKey(String code);

    int insert(ClientFollowSummary record);

    int insertSelective(ClientFollowSummary record);

    ClientFollowSummary selectByPrimaryKey(String code);
    
    ClientFollowSummary selectByCfNo(String cfNo);

    int updateByPrimaryKeySelective(ClientFollowSummary record);
    
    int updateByCfNoSelective(ClientFollowSummary record);

    int updateByPrimaryKey(ClientFollowSummary record);
    
    List<FindClientFollowSummaryPageReturn> findClientFollowSummaryPage(FindClientFollowSummaryPage findClientFollowSummaryPage);

    int findClientFollowSummaryPageCount(FindClientFollowSummaryPage findClientFollowSummaryPage);
    
    ClientFollowSummary findClientFollowSummaryLast(FindClientFollowSummary findClientFollowSummary);
    
    List<FindBuyRecordPageReturn> findBuyRecordPage(FindBuyRecordPage findBuyRecordPage);
    
    List<FindBuyRecordCountReturn> findBuyRecordCount(FindBuyRecordPage findBuyRecordPage);
    
    List<FindAbandonRecordCountReturn> findAbandonRecordCount(FindBuyRecordPage findBuyRecordPage);

    int findBuyRecordPageCount(FindBuyRecordPage findBuyRecordPage);
     
    int findBuySuccessNum(FindSuccessNum findSuccessNum);
    
    long sumAmountByShop(List<String> memberNoGmList);
    
    long sumAmountByMerchantNo(Map<String,Object> parmMap);

	long findNumSaleByGm(Map<String, Object> map);

	int findCountOrderByGm(Map<String, Object> map);

	long findCountPmCfByGm(String memberNo);
}