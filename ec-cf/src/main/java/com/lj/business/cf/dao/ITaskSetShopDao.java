package com.lj.business.cf.dao;

import java.util.List;

import com.lj.business.cf.domain.TaskSetShop;
import com.lj.business.cf.dto.taskSetShop.FindNoSetShopCount;
import com.lj.business.cf.dto.taskSetShop.FindShopTaskSetList;
import com.lj.business.cf.dto.taskSetShop.FindTaskSetAndOrder;
import com.lj.business.cf.dto.taskSetShop.NumDayAndTaskUnit;

public interface ITaskSetShopDao {
    int deleteByPrimaryKey(String code);

    int insert(TaskSetShop record);

    int insertSelective(TaskSetShop record);

    TaskSetShop selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(TaskSetShop record);

    int updateByPrimaryKey(TaskSetShop record);
    
    List<TaskSetShop> findShopTaskSetList(FindShopTaskSetList findShopTaskSetList);
    
    List<TaskSetShop> findShopTaskSetListMerchant(FindShopTaskSetList findShopTaskSetList);

    NumDayAndTaskUnit findNumDayAndTaskUnit(FindTaskSetAndOrder findTaskSetAndOrder);
    
    int findShopNoSetCount(FindNoSetShopCount findNoSetShopCount);
}