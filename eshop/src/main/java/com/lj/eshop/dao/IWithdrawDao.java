package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.Withdraw;
import com.lj.eshop.dto.FindWithdrawPage;
import com.lj.eshop.dto.WithdrawDto;

public interface IWithdrawDao {
    int insertSelective(Withdraw record);

    Withdraw selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Withdraw record);
    
    List<WithdrawDto> findWithdrawPage(FindWithdrawPage findWithdrawPage);

   	int findWithdrawPageCount(FindWithdrawPage findWithdrawPage);
   	
   	List<WithdrawDto> findWithdraws(FindWithdrawPage findWithdrawPage);

}