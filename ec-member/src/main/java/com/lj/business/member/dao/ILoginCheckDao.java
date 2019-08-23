package com.lj.business.member.dao;

import java.util.List;

import com.lj.business.member.domain.LoginCheck;
import com.lj.business.member.dto.FindLoginCheckPage;
import com.lj.business.member.dto.FindLoginCheckPageReturn;

public interface ILoginCheckDao {
    int deleteByPrimaryKey(String code);

    int insert(LoginCheck record);

    int insertSelective(LoginCheck record);

    LoginCheck selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(LoginCheck record);

    int updateByPrimaryKey(LoginCheck record);

	List<FindLoginCheckPageReturn> findLoginCheckPage(
			FindLoginCheckPage findLoginCheckPage);

	int findLoginCheckPageCount(FindLoginCheckPage findLoginCheckPage);
	
	LoginCheck findLoginCheck(LoginCheck record);
}