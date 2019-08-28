package com.lj.business.cf.dao;

import java.util.List;

import com.lj.business.cf.domain.WorkTaskList;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskList;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskListPage;
import com.lj.business.cf.dto.workTaskList.FindWorkTaskListPageReturn;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * 类说明：工作事项表
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
public interface IWorkTaskListDao {
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
    int insert(WorkTaskList record);
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
    int insertSelective(WorkTaskList record);
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
    WorkTaskList selectByPrimaryKey(String code);
    
    /**
     * 
     *
     * 方法说明：根据类型进行查询
     *
     * @param findWorkTaskList
     * @return
     *
     * @author 冯辉 CreateDate: 2017年7月24日
     *
     */
    WorkTaskList findWorkTaskListByTaskType(FindWorkTaskList findWorkTaskList);
    
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
    int updateByPrimaryKeySelective(WorkTaskList record);
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
    int updateByPrimaryKey(WorkTaskList record);
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
	WorkTaskList selectByPrimaryKey(Long id);
	
	/**
	 * 
	 *
	 * 方法说明：查找所有工作事项表信息
	 *
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年7月24日
	 *
	 */
	public List<FindWorkTaskListPageReturn> findWorkTaskListAll();
	
	
	/**
	 * 
	 *
	 * 方法说明：分页查询
	 *
	 * @param FindWorkTaskListPage
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月21日
	 *
	 */
	List<FindWorkTaskListPageReturn> findWorkTaskListPage(FindWorkTaskListPage findWorkTaskListPage);
	/**
	 * 
	 *
	 * 方法说明：分页查询条数
	 *
	 * @param FindWorkTaskListPage
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月21日
	 *
	 */
	int findWorkTaskListPageCount(FindWorkTaskListPage findWorkTaskListPage);
	
	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @param findWorkTaskListPage
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年7月5日
	 *
	 */
	List<FindWorkTaskListPageReturn> findWorkTaskListPages(FindWorkTaskListPage findWorkTaskListPage);

	/**
	 * 根据编码列表查找工作事项
	 * @param codeList 编码列表
	 * @return
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月24日
	 */
	List<WorkTaskList> findByCodeList(@Param("codeList") List<String> codeList);
}