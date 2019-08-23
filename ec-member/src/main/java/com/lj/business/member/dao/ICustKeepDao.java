package com.lj.business.member.dao;

import java.util.List;

import com.lj.business.member.domain.CustKeep;
import com.lj.business.member.dto.custKeep.FindCustKeepPage;
import com.lj.business.member.dto.custKeep.FindCustKeepPageReturn;

public interface ICustKeepDao {
    int deleteByPrimaryKey(String code);

    int insert(CustKeep record);

    int insertSelective(CustKeep record);

    CustKeep selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(CustKeep record);

    int updateByPrimaryKey(CustKeep record);
    
    
    List<FindCustKeepPageReturn> findCustKeepPage(FindCustKeepPage findCustKeepPage);

   	int findCustKeepPageCount(FindCustKeepPage findCustKeepPage);
}