package com.lj.business.weixin.dao;

import java.util.List;
import java.util.Map;

import com.lj.business.weixin.domain.WxLikeInfo;

public interface IWxLikeInfoDao {

    int insertSelective(WxLikeInfo record);

    WxLikeInfo selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(WxLikeInfo record);

    /**
     * 
     *
     * 方法说明：获取列表
     *	1.idWx 朋友圈ID
     * @param map
     * @return
     *
     * @author 段志鹏 CreateDate: 2017年7月24日
     *
     */
    List<Map<String,String>> findWxLikeInfos(Map<String,Object> map);
}