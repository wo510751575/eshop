package com.lj.business.member.dao;

import java.util.List;

import com.lj.business.member.domain.BehaviorInfoPm;
import com.lj.business.member.dto.behaviorInfoPm.FindBehaviorInfoPmPage;
import com.lj.business.member.dto.behaviorInfoPm.FindBehaviorInfoPmPageReturn;

public interface IBehaviorInfoPmDao {
    int deleteByPrimaryKey(String code);

    int insert(BehaviorInfoPm record);

    int insertSelective(BehaviorInfoPm record);

    BehaviorInfoPm selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(BehaviorInfoPm record);

    int updateByPrimaryKey(BehaviorInfoPm record);
    
    List<FindBehaviorInfoPmPageReturn> findBehaviorInfoPmPage(FindBehaviorInfoPmPage findBehaviorInfoPmPage);

	int findBehaviorInfoPmPageCount(FindBehaviorInfoPmPage findBehaviorInfoPmPage);
}