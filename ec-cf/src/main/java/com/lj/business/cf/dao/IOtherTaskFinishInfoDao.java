package com.lj.business.cf.dao;

import java.util.List;

import com.lj.business.cf.domain.OtherTaskFinishInfo;
import com.lj.business.cf.dto.otherTaskFinishInfo.FindOtherTask;
import com.lj.business.cf.dto.otherTaskFinishInfo.FindOtherTaskFinishInfo;
import com.lj.business.cf.dto.otherTaskFinishInfo.FindOtherTaskReturn;

public interface IOtherTaskFinishInfoDao {
	
    int deleteByPrimaryKey(String code);

    int insert(OtherTaskFinishInfo record);

    int insertSelective(OtherTaskFinishInfo record);

    OtherTaskFinishInfo selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(OtherTaskFinishInfo record);

    int updateByPrimaryKey(OtherTaskFinishInfo record);
    
    List<OtherTaskFinishInfo> findWtsOther(FindOtherTaskFinishInfo findOtherTaskFinishInfo);
    
    List<FindOtherTaskReturn> findOtherTask(FindOtherTask findOtherTask);
    
    OtherTaskFinishInfo findOtherTaskByDay(FindOtherTask findOtherTask);
}