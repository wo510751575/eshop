package com.lj.business.member.dao;

import java.util.List;

import com.lj.business.member.domain.PhoneInfo;
import com.lj.business.member.dto.phoneInfo.FindPhoneInfoPage;
import com.lj.business.member.dto.phoneInfo.FindPhoneInfoPageReturn;

public interface IPhoneInfoDao {
    int deleteByPrimaryKey(String code);

    int insert(PhoneInfo record);

    int insertSelective(PhoneInfo record);

    PhoneInfo selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(PhoneInfo record);

    int updateByPrimaryKey(PhoneInfo record);
    
    List<FindPhoneInfoPageReturn> findPhoneInfoPage(FindPhoneInfoPage findPhoneInfoPage);

   	int findPhoneInfoPageCount(FindPhoneInfoPage findPhoneInfoPage);
}