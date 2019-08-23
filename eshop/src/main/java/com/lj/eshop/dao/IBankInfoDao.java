package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.BankInfo;
import com.lj.eshop.dto.BankInfoDto;
import com.lj.eshop.dto.FindBankInfoPage;

public interface IBankInfoDao {
    int deleteByPrimaryKey(String code);

    int insertSelective(BankInfo record);

    BankInfo selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(BankInfo record);

    List<BankInfoDto> findBankInfoPage(FindBankInfoPage bankInfoPage);

  	int findBankInfoPageCount(FindBankInfoPage bankInfoPage);
  	
  	List<BankInfoDto> findBankInfos(FindBankInfoPage bankInfoPage);
}