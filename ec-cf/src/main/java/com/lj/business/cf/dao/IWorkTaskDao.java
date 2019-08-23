package com.lj.business.cf.dao;

import java.util.List;

import com.lj.business.cf.domain.WorkTask;
import com.lj.business.cf.dto.*;

/**
 * 
 * 
 * 类说明：工作任务统计接口
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年6月21日
 */
public interface IWorkTaskDao {
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
    int insert(WorkTask record);
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
    int insertSelective(WorkTask record);
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
    WorkTask selectByPrimaryKey(String code);
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
    int updateByPrimaryKeySelective(WorkTask record);
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
    int updateByPrimaryKey(WorkTask record);
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
	WorkTask selectByPrimaryKey(Long id);
	/**
	 * 
	 *
	 * 方法说明：分页查询
	 *
	 * @param FindWorkTaskPage
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月21日
	 *
	 */
	List<FindWorkTaskPageReturn> findWorkTaskPage(FindWorkTaskPage findWorkTaskPage);
	/**
	 * 
	 *
	 * 方法说明：分页查询条数
	 *
	 * @param FindWorkTaskPage
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月21日
	 *
	 */
	int findWorkTaskPageCount(FindWorkTaskPage findWorkTaskPage);
	
	/**
	 * 
	 *
	 * 方法说明：查找主要/其他工作任务表信息_APP
	 *
	 * @param findWorkTaskMainList
	 * @return
	 *
	 * @author 彭阳 CreateDate: 2017年6月26日
	 *
	 */
	List<FindWorkTaskMainListReturn> findWorkTaskMainList(FindWorkTaskMainList findWorkTaskMainList);
	
	/**
	 * 
	 *
	 * 方法说明：查找主要工作
	 *
	 * @param findWorkTask
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年7月21日
	 *
	 */
	List<WorkTask> findWtsMain(FindWorkTask findWorkTask);

	/**
	 * 查询用户当天的数据是否存在
	 * @param findWorkTask
	 * @return
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月25日
	 */
	int findExistByMember(FindWorkTask findWorkTask);

	/**
	 * 更新用户的完成数据
	 * @param updateWorkTaskFinishNum
	 * @return 更新的数量
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月25日
	 */
	int updateFinishNum(UpdateWorkTaskFinishNum updateWorkTaskFinishNum);
	
	/**
	 * 要求社交任务量加一
	 * @param updateWorkTask
	 * @return 更新的数量
	 *
	 * @author 梅宏博 CreateDate: 2017年8月23日
	 */
	int updateRequireNumByGmTypeDay(UpdateWorkTask updateWorkTask);


}