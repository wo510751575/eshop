package com.lj.eshop.dao;

import java.util.List;

import com.lj.eshop.domain.MemberRankApply;
import com.lj.eshop.dto.FindMemberRankApplyPage;
import com.lj.eshop.dto.MemberRankApplyDto;

public interface IMemberRankApplyDao {
    int deleteByPrimaryKey(String code);

    int insert(MemberRankApply record);

    int insertSelective(MemberRankApply record);

    MemberRankApply selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(MemberRankApply record);

    int updateByPrimaryKey(MemberRankApply record);

	List<MemberRankApplyDto> findMemberRankApplys(FindMemberRankApplyPage findMemberRankApplyPage);

	List<MemberRankApplyDto> findMemberRankApplyPage(FindMemberRankApplyPage findMemberRankApplyPage);

	int findMemberRankApplyPageCount(FindMemberRankApplyPage findMemberRankApplyPage);

	int updateByPkAndStatus(MemberRankApply memberRankApply);
}