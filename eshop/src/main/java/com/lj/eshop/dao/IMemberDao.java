package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.Member;
import com.lj.eshop.dto.FindMemberPage;
import com.lj.eshop.dto.MemberDto;

public interface IMemberDao {
	int insertSelective(Member record);

	Member selectByPrimaryKey(String code);

	int updateByPrimaryKeySelective(Member record);

	List<MemberDto> findMemberPage(FindMemberPage findMemberPage);

	int findMemberPageCount(FindMemberPage findMemberPage);

	List<MemberDto> findMembers(FindMemberPage findMemberPage);

	List<String> findMemberCodesByInvite(String myInvite);
}