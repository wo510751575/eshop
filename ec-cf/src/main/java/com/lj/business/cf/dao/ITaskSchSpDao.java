package com.lj.business.cf.dao;

import java.util.List;

import com.lj.business.cf.domain.TaskSchSp;
import com.lj.business.cf.dto.FindTaskSchSpList;
import com.lj.business.cf.dto.FindTaskSchSpListReturn;
import com.lj.business.cf.dto.FindTaskSchSpPage;
import com.lj.business.cf.dto.FindTaskSchSpPageReturn;
/**
 * 
 * 
 * 类说明：店长待办事项接口
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
public interface ITaskSchSpDao {
	/**
	 * 
	 *
	 * 方法说明：根据主键删除店长待办事项
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
     * 方法说明：添加店长待办事项
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    int insert(TaskSchSp record);
    /**
     * 
     *
     * 方法说明：按条件添加店长待办事项
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    int insertSelective(TaskSchSp record);
    /**
     * 
     *
     * 方法说明：根据主键查询店长待办事项
     *
     * @param code
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    TaskSchSp selectByPrimaryKey(String code);
    /**
     * 
     *
     * 方法说明：根据主键选择性更新店长待办事项
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    int updateByPrimaryKeySelective(TaskSchSp record);
    /**
     * 
     *
     * 方法说明：根据主键更新店长待办事项
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月5日
     *
     */
    int updateByPrimaryKey(TaskSchSp record);
    /**
     * 
     *
     * 方法说明：分页查询
     *
     * @param findTaskSchSpPage
     * @return
     *
     * @author 邹磊 CreateDate: 2017年6月26日
     *
     */
	List<FindTaskSchSpPageReturn> findTaskSchSpPage(FindTaskSchSpPage findTaskSchSpPage);
	/**
	 * 
	 *
	 * 方法说明：分页查询条数
	 *
	 * @param findTaskSchSpPage
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月5日
	 *
	 */
	int findTaskSchSpPageCount(FindTaskSchSpPage findTaskSchSpPage);
	
	
	List<FindTaskSchSpListReturn> findTaskSchSpList(FindTaskSchSpList findTaskSchSpList);
}