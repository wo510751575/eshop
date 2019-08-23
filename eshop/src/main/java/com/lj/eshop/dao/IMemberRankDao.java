package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.MemberRank;
import com.lj.eshop.dto.FindMemberRankPage;
import com.lj.eshop.dto.MemberRankDto;

public interface IMemberRankDao {
    int deleteByPrimaryKey(String code);

    int insert(MemberRank record);

    int insertSelective(MemberRank record);

    MemberRank selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(MemberRank record);

    int updateByPrimaryKey(MemberRank record);

	List<MemberRankDto> findMemberRankPage(FindMemberRankPage findMemberRankPage);

	int findMemberRankPageCount(FindMemberRankPage findMemberRankPage);

	List<MemberRankDto> findMemberRanks(FindMemberRankPage findMemberRankPage);
}