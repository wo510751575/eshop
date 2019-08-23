package com.lj.business.cf.dao;

import java.util.Date;
import java.util.List;

import com.lj.business.cf.domain.TaskSetShopDetail;
import com.lj.business.cf.dto.FindTaskSetShopDetailByTypeMGMDay;
import com.lj.business.cf.dto.taskSetShop.FindNoSetShopCount;
import com.lj.business.cf.dto.taskSetShop.ToShopTaskSet;
import com.lj.business.cf.dto.taskSetShopDetail.FindTaskSetShopDetail;
import com.lj.business.cf.dto.taskSetShopDetail.FindTaskSetShopDetailReturn;

public interface ITaskSetShopDetailDao {
    int deleteByPrimaryKey(String code);

    int insert(TaskSetShopDetail record);

    int insertSelective(TaskSetShopDetail record);

    TaskSetShopDetail selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(TaskSetShopDetail record);

    int updateByPrimaryKey(TaskSetShopDetail record);
    
    List<TaskSetShopDetail> findTaskSetShopDetailList(ToShopTaskSet toShopTaskSet);
    
    List<TaskSetShopDetail> findTaskSetShopDetailListByDay(Date now);
    
    FindTaskSetShopDetailReturn findTaskSetShopDetailByMGMDay(FindTaskSetShopDetail findTaskSetShopDetail);
    
    FindTaskSetShopDetailReturn findTaskSetShopDetailNewByMGMDay(FindTaskSetShopDetail findTaskSetShopDetail);
    
    FindTaskSetShopDetailReturn findTaskSetShopDetailByTypeMGMDay(FindTaskSetShopDetailByTypeMGMDay findTaskSetShopDetailByTypeMGMDay);

	int findCountDetail(FindNoSetShopCount findNoSetShopCount);
    
}