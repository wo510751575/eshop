package com.lj.eshop.cf.dao;

import com.lj.eshop.cf.domain.Account;

public interface IAccountDao {

    int insertSelective(Account record);

    Account selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Account record);
}