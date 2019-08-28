package com.lj.business.cf.dao;

import java.util.List;
import java.util.Map;

import com.lj.business.cf.domain.ClientFollow;
import com.lj.business.cf.dto.FindCForCKLastDateDto;
import com.lj.business.cf.dto.clientFollow.FindClientFollow;
import com.lj.business.cf.dto.clientFollow.FindClientFollowMap;
import com.lj.business.cf.dto.clientFollow.FindClientFollowPage;
import com.lj.business.cf.dto.clientFollow.FindClientFollowPageReturn;
import com.lj.business.cf.dto.clientFollow.FindClientFollowReturn;
import com.lj.business.cf.dto.clientFollow.UpdateClientFollow;
import com.lj.business.cf.dto.taskSetShop.FindTaskSetAndOrder;
/**
 * 
 * 
 * 类说明：客户跟踪接口
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年7月5日
 */
public interface IClientFollowDao {
	/**
	 * 
	 *
	 * 方法说明：根据主键删除客户跟踪
	 *
	 * @param code
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月5日
	 *
	 */
    int deleteByPrimaryKey(String code);
    /**
     * 
     *
     * 方法说明：添加客户跟踪
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    int insert(ClientFollow record);
    /**
     * 
     *
     * 方法说明：按条件添加客户跟踪
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    int insertSelective(ClientFollow record);
    /**
     * 
     *
     * 方法说明：根据主键查询客户跟踪
     *
     * @param code
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    ClientFollow selectByPrimaryKey(String code);
    /**
     * 
     *
     * 方法说明：根据主键选择性更新客户跟踪
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    int updateByPrimaryKeySelective(ClientFollow record);
    /**
     * 
     *
     * 方法说明：根据主键更新客户跟踪
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    int updateByPrimaryKey(ClientFollow record);
    /**
     * 
     *
     * 方法说明：分页查询
     *
     * @param findClientFollowPage
     * @return
     *
     * @author 邹磊 CreateDate: 2017年6月26日
     *
     */
	List<FindClientFollowPageReturn> findClientFollowPage(
			FindClientFollowPage findClientFollowPage);
	/**
	 * 
	 *
	 * 方法说明：分页查询条数
	 *
	 * @param findClientFollowPage
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月26日
	 *
	 */
	int findClientFollowPageCount(FindClientFollowPage findClientFollowPage);
	
	
	@SuppressWarnings("rawtypes")
	List<FindClientFollowReturn> cfHistory(Map map);
	
	@SuppressWarnings("rawtypes")
	List<FindClientFollowReturn> orderHistory(Map map);
	
	
	/**
	 * 
	 *
	 * 方法说明：查询导购今天的订单
	 *
	 * @param findTaskSetAndOrder
	 * @return
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月21日
	 *
	 */
	List<ClientFollow> findTodayOrder(FindTaskSetAndOrder findTaskSetAndOrder);
	
	/**
	 * 
	 *
	 * 方法说明：查询订单月销售
	 *
	 * @param findTaskSetAndOrder
	 * @return
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月21日
	 *
	 */
	Long findMonthOrderMoney(FindTaskSetAndOrder findTaskSetAndOrder);
	
	/**
	 * 
	 *
	 * 方法说明：查找最后一条跟进
	 *
	 * @param findCForCKLastDateDto
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年7月27日
	 *
	 */
	ClientFollow findLastClientFollow(FindCForCKLastDateDto findCForCKLastDateDto);
	
	
	/**
	 * 
	 *
	 * 方法说明：统计跟踪次数
	 *
	 * @param findClientFollowMap
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月3日
	 *
	 */
    int findClientFollowCount(FindClientFollowMap findClientFollowMap);
    
    /**
     * 
     *
     * 方法说明：统计跟踪总数
     *
     * @param findClientFollowMap
     * @return
     *
     * @author 罗书明 CreateDate: 2017年8月3日
     *
     */
    int findClientFollowSum(FindClientFollowMap findClientFollowMap);
    
    /**
     * 
     *
     * 方法说明：修改跟进放弃code
     *
     * @param updateClientFollow
     *
     * @author 冯辉 CreateDate: 2017年8月5日
     *
     */
    void updateByCfNo(UpdateClientFollow updateClientFollow);
    
    /**
     * 
     *
     * 方法说明：跟进次数
     *
     * @return
     *
     * @author 冯辉 CreateDate: 2017年8月10日
     *
     */
    int cfCount(FindClientFollow findClientFollow);
    /**
     * 
     *
     * 方法说明：统计每天的客户数
     *
     * @param findClientFollowMap
     * @return
     *
     * @author 罗书明 CreateDate: 2017年8月19日
     *
     */
    int findLClientFollowCountMemberNo(FindClientFollowMap findClientFollowMap);
    
    /**
     * 
     *
     * 方法说明：统计每天的成单数
     *
     * @param findClientFollowMap
     * @return
     *
     * @author 罗书明 CreateDate: 2017年8月19日
     *
     */
    int findLClientFollowCountDeal(FindClientFollowMap findClientFollowMap);
    /**
     * 
     *
     * 方法说明：统计客户总数
     *
     * @param findClientFollowMap
     * @return
     *
     * @author 罗书明 CreateDate: 2017年8月19日
     *
     */
    int findClientFollowSumMemberNo(FindClientFollowMap findClientFollowMap);
    
    /**
     * 
     *
     * 方法说明：统计最后一次跟进时间
     *
     * @param findClientFollow
     * @return
     *
     * @author 刘培CreateDate: 2017年8月21日
     *
     */
	FindClientFollowReturn findClientFollowByGmAndMember( FindClientFollow findClientFollow);
    

}