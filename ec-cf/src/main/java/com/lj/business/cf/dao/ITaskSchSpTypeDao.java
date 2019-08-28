package com.lj.business.cf.dao;

import java.util.List;

import com.lj.business.cf.domain.TaskSchSpType;
import com.lj.business.cf.dto.FindTaskSchSpTypePage;
import com.lj.business.cf.dto.FindTaskSchSpTypePageReturn;
/**
 * 
 * 
 * 类说明：店长待办事项列表接口
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
public interface ITaskSchSpTypeDao {
	/**
	 * 
	 *
	 * 方法说明：根据主键删除店长待办事项列表
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
     * 方法说明：添加店长待办事项列表
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    int insert(TaskSchSpType record);
    /**
     * 
     *
     * 方法说明：按条件添加店长待办事项列表
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    int insertSelective(TaskSchSpType record);
    /**
     * 
     *
     * 方法说明：根据主键查询店长待办事项列表
     *
     * @param code
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    TaskSchSpType selectByPrimaryKey(String code);
    /**
     * 
     *
     * 方法说明：根据主键选择性更新店长待办事项列表
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    int updateByPrimaryKeySelective(TaskSchSpType record);
    /**
     * 
     *
     * 方法说明：根据主键更新店长待办事项列表
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    int updateByPrimaryKey(TaskSchSpType record);
    /**
     * 
     *
     * 方法说明：分页查询
     *
     * @param findTaskSchSpTypePage
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    List<FindTaskSchSpTypePageReturn> findTaskSchSpTypePage(FindTaskSchSpTypePage findTaskSchSpTypePage);
    /**
     * 
     *
     * 方法说明：分页查询条数
     *
     * @param findTaskSchSpTypePage
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
   	int findTaskSchSpTypePageCount(FindTaskSchSpTypePage findTaskSchSpTypePage);
}