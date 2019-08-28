package com.lj.business.cf.dao;

import java.util.List;
import java.util.Map;

import com.lj.business.cf.domain.PmAbandon;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandonList;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandonListReturn;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandonPage;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandonPageReturn;
import com.lj.business.cf.dto.pmAbandon.FindPmAbandonReturn;
/**
 * 
 * 
 * 类说明：客户放弃接口
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年6月21日
 */
public interface IPmAbandonDao {
	/**
	 * 
	 *
	 * 方法说明：根据主键进行删除
	 *
	 * @param code
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月21日
	 *
	 */
    int deleteByPrimaryKey(String code);
    /**
     * 
     *
     * 方法说明：添加方法
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年6月21日
     *
     */
    int insert(PmAbandon record);
    /**
     * 
     *
     * 方法说明：选择性的增加
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年6月21日
     *
     */
    int insertSelective(PmAbandon record);
    /**
     * 
     *
     * 方法说明：根据主键进行查询
     *
     * @param code
     * @return
     *
     * @author 邹磊 CreateDate: 2017年6月21日
     *
     */
    PmAbandon selectByPrimaryKey(String code);
    /**
     * 
     *
     * 方法说明：根据主键选择性的进行更新
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年6月21日
     *
     */
    int updateByPrimaryKeySelective(PmAbandon record);
    /**
     * 
     *
     * 方法说明：根据主键进行更新
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年6月21日
     *
     */
    int updateByPrimaryKey(PmAbandon record);
    /**
     * 
     *
     * 方法说明：根据主键删除的方法
     *
     * @param id
     *
     * @author 邹磊 CreateDate: 2017年6月21日
     *
     */
	void deleteByPrimaryKey(Long id);
	/**
	 * 
	 *
	 * 方法说明：根据主键进行查询
	 *
	 * @param id
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月21日
	 *
	 */
	PmAbandon selectByPrimaryKey(long id);
	/**
	 * 
	 *
	 * 方法说明：分页查询
	 *
	 * @param FindPmAbandonPage
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月21日
	 *
	 */
	List<FindPmAbandonPageReturn> findPmAbandonPage(FindPmAbandonPage findPmAbandonPage);
	/**
	 * 
	 *
	 * 方法说明：分页查询条数
	 *
	 * @param FindPmAbandonPage
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月21日
	 *
	 */
	int findPmAbandonPageCount(FindPmAbandonPage findPmAbandonPage);
	
	/**
	 * 
	 *
	 * 方法说明：放弃历史
	 *
	 * @param map
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年7月11日
	 *
	 */
	List<FindPmAbandonReturn> abandonHistory(@SuppressWarnings("rawtypes") Map map);

	/**
	 * 
	 *
	 * 方法说明：放弃记录
	 *
	 * @param  memberNoGm,merchantNo,memberNo
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年7月13日
	 *
	 */
	List<FindPmAbandonListReturn> findPmAbandonList(FindPmAbandonList findPmAbandonList);
	
	/**
	 * 
	 *
	 * 方法说明：修改未审批的放弃记录为拒绝
	 *
	 * @param map
	 *
	 * @author 冯辉 CreateDate: 2017年7月14日
	 *
	 */
	public void updateNoCheckByCfNo(Map<String,Object> map);
	
	/**
	 * 
	 *
	 * 方法说明：查找未审批的放弃记录
	 *
	 * @param map
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年7月14日
	 *
	 */
	public List<FindPmAbandonListReturn> findNoCheckByCfNo(Map<String,Object> map);
	
}