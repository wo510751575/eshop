package com.lj.business.weixin.dao;

import java.util.List;
import java.util.Map;

import com.lj.business.weixin.domain.WxChatInfo;
import com.lj.business.weixin.dto.FindWxChatInfo;
import com.lj.business.weixin.dto.FindWxChatInfoPage;
import com.lj.business.weixin.dto.FindWxChatInfoPageReturn;

public interface IWxChatInfoDao {

    int insertSelective(WxChatInfo record);

    WxChatInfo selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(WxChatInfo record);

    /**
     * 
     *
     * 方法说明：查询微信聊天记录列表
     *
     * @param parmMap
     * @return
     *
     * @author 段志鹏 CreateDate: 2017年7月19日
     *
     */
    List<FindWxChatInfoPageReturn> findWxChatInfoPage(FindWxChatInfoPage findWxChatInfoPage);
    /**
     * 
     *
     * 方法说明：查询微信聊天记录数量
     *
     * @param parmMap
     * @return
     *
     * @author 段志鹏 CreateDate: 2017年7月19日
     *
     */
	int findWxChatInfoPageCount(FindWxChatInfoPage findWxChatInfoPage);
	
	/**
	 * 
	 *
	 * 方法说明：按年月日分组查询OMS所需
	 *1.memberNo 导购编号
	 *2.startTime 开始时间
	 *3.endTime 结束时间
	 *4.talker 客户微信号
	 *5.start 开始行
	 *6.limit 查询条数
	 * @param parmMap
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月20日
	 *
	 */
	List<Map<String,String>> findWxChatInfoPageOMS(Map<String,Object> parmMap);
	
	/**
	 * 
	 *
	 * 方法说明：按年月日分组统计数量OMS所需
	 *1.memberNo 导购编号
	 *2.startTime 开始时间
	 *3.endTime 结束时间
	 *4.talker 客户微信号
	 * @param parmMap
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月20日
	 *
	 */
	List<Map<String,String>> findWxChatInfoPageCountOMS(Map<String,Object> parmMap);
	/**
	 * 
	 *
	 * 方法说明：统计时间段内的咨询量
	 *
	 * @param findWxChatInfo
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月8日
	 *
	 */
    int findWxChantInfoCountTime(FindWxChatInfo findWxChatInfo);

    /**
	 * 
	 *
	 * 方法说明：商户运营日报微信聊天次数
	 *
	 * @param findWxChatInfo
	 * @return
	 *
	 * @author 梅宏博 CreateDate: 2017年9月28日
	 *
	 */
	int findCountWxChat(Map<String, Object> map);
    
}