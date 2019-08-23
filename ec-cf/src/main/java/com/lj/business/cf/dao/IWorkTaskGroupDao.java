package com.lj.business.cf.dao;

import java.util.List;

import com.lj.business.cf.domain.WorkTaskGroup;
import com.lj.business.cf.dto.workTaskGroup.FindWorkTaskGroupPage;
import com.lj.business.cf.dto.workTaskGroup.FindWorkTaskGroupPageReturn;
/**
 * 
 * 
 * 类说明：工作事项分组接口
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年7月5日
 */
public interface IWorkTaskGroupDao {
	/**
	 * 
	 *
	 * 方法说明：根据主键删除工作事项分组
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
     * 方法说明：添加工作事项分组
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    int insert(WorkTaskGroup record);
    /**
     * 
     *
     * 方法说明：按条件添加工作事项分组
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    int insertSelective(WorkTaskGroup record);
    /**
     * 
     *
     * 方法说明：根据主键查询工作事项分组
     *
     * @param code
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    WorkTaskGroup selectByPrimaryKey(String code);
    /**
     * 
     *
     * 方法说明：根据主键选择性更新工作事项分组
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    int updateByPrimaryKeySelective(WorkTaskGroup record);
    /**
     * 
     *
     * 方法说明：根据主键更新工作事项分组
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    int updateByPrimaryKey(WorkTaskGroup record);
    /**
     * 
     *
     * 方法说明：分页查询
     *
     * @param findWorkTaskGroupPage
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
	List<FindWorkTaskGroupPageReturn> findWorkTaskGroupPage(FindWorkTaskGroupPage findWorkTaskGroupPage);
	/**
	 * 
	 *
	 * 方法说明：分页查询条数
	 *
	 * @param findWorkTaskGroupPage
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月5日
	 *
	 */
	int findWorkTaskGroupPageCount(FindWorkTaskGroupPage findWorkTaskGroupPage);
}