package com.lj.business.cf.dao;

import java.util.List;
import java.util.Map;

import com.lj.business.cf.domain.ClientKeep;
import com.lj.business.cf.dto.FindCForCKLastDateDto;
import com.lj.business.cf.dto.clientKeep.AddClientKeep;
import com.lj.business.cf.dto.clientKeep.FindClientKeepPage;
import com.lj.business.cf.dto.clientKeep.FindClientKeepPageReturn;
import com.lj.business.cf.dto.clientKeep.FindClientKeepReturn;
/**
 * 
 * 
 * 类说明：客户维护记录接口
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
public interface IClientKeepDao {
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
    int insert(ClientKeep record);
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
    int insertSelective(ClientKeep record);
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
    ClientKeep selectByPrimaryKey(String code);
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
    int updateByPrimaryKeySelective(ClientKeep record);
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
    int updateByPrimaryKey(ClientKeep record);
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
	 * 方法说明：分页查询
	 *
	 * @param findClientKeepPage
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月21日
	 *
	 */
	List<FindClientKeepPageReturn> findClientKeepPage(FindClientKeepPage findClientKeepPage);
	/**
	 * 
	 *
	 * 方法说明：分页查询条数
	 *
	 * @param findClientKeepPage
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月21日
	 *
	 */
	int findClientKeepPageCount(FindClientKeepPage findClientKeepPage);
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
	ClientKeep selectByPrimaryKey(Long id);
	
	/**
	 * 
	 *
	 * 方法说明：查询维护列表
	 *
	 * @param map
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年7月11日
	 *
	 */
	List<FindClientKeepReturn> clientKeepHistory(@SuppressWarnings("rawtypes") Map map);
	
	/**
	 * 
	 *
	 * 方法说明：查找最后一条维护记录
	 *
	 * @param findCForCKLastDateDto
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年7月27日
	 *
	 */
	ClientKeep findLastClientKeep(FindCForCKLastDateDto findCForCKLastDateDto);
	
	/**
	 * 
	 *
	 * 方法说明：根据导购编号和客户编号查找最后一条维护记录
	 *
	 * @param clientKeep
	 * @return
	 *
	 * @author 刘培 CreateDate: 2017年8月21日
	 *
	 */
	FindClientKeepReturn findLastClientKeepByGmAndMember(AddClientKeep clientKeep);
	
}