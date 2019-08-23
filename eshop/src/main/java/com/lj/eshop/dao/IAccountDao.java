package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.Account;
import com.lj.eshop.dto.AccountDto;
import com.lj.eshop.dto.FindAccountPage;

public interface IAccountDao {

    int insertSelective(Account record);

    Account selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Account record);

    List<AccountDto> findAccountPage(FindAccountPage findAccountPage);

 	int findAccountPageCount(FindAccountPage findAccountPage);
 	
 	List<AccountDto> findAccounts(FindAccountPage findAccountPage);
    
}