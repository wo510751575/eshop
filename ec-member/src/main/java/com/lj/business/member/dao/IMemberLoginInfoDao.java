package com.lj.business.member.dao;

import java.util.List;

import com.lj.business.member.domain.MemberLoginInfo;
import com.lj.business.member.dto.FindMemberLoginInfoPage;
import com.lj.business.member.dto.FindMemberLoginInfoPageReturn;

public interface IMemberLoginInfoDao {
    int deleteByPrimaryKey(String code);

    int insert(MemberLoginInfo record);

    int insertSelective(MemberLoginInfo record);

    MemberLoginInfo selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(MemberLoginInfo record);

    int updateByPrimaryKey(MemberLoginInfo record);

	List<FindMemberLoginInfoPageReturn> findMemberLoginInfoPage(
			FindMemberLoginInfoPage findMemberLoginInfoPage);

	int findMemberLoginInfoPageCount(
			FindMemberLoginInfoPage findMemberLoginInfoPage);
}