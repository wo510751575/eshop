package com.lj.business.member.dao;

import java.util.List;

import com.lj.business.member.domain.BehaviorPm;
import com.lj.business.member.dto.behaviorPm.FindBehaviorPmPage;
import com.lj.business.member.dto.behaviorPm.FindBehaviorPmPageReturn;

public interface IBehaviorPmDao {
    int deleteByPrimaryKey(String code);

    int insert(BehaviorPm record);

    int insertSelective(BehaviorPm record);

    BehaviorPm selectByPrimaryKey(String code);
    
    BehaviorPm selectByParamKey(BehaviorPm behaviorPm);

    int updateByPrimaryKeySelective(BehaviorPm record);

    int updateByPrimaryKey(BehaviorPm record);
    
    List<FindBehaviorPmPageReturn> findBehaviorPmPage(FindBehaviorPmPage findBehaviorPmPage);

   	int findBehaviorPmPageCount(FindBehaviorPmPage findBehaviorPmPage);
}