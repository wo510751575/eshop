package com.lj.business.cf.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lj.business.cf.domain.ComTask;
import com.lj.business.cf.dto.TodayBeforeClientExpTaskDto;
import com.lj.business.cf.dto.comTask.FindComTask;
import com.lj.business.cf.dto.comTask.FindComTaskIndexPage;
import com.lj.business.cf.dto.comTask.FindComTaskIndexPageReturn;
import com.lj.business.cf.dto.comTask.FindComTaskPage;
import com.lj.business.cf.dto.comTask.FindComTaskPageReturn;
import com.lj.business.cf.dto.comTask.FindComTaskReturn;
/**
 * 
 * 
 * 类说明：客户沟通任务表接口
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
public interface IComTaskDao {
	/**
	 * 
	 *
	 * 方法说明：根据主键删除客户沟通任务
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
	 * 方法说明：添加客户沟通任务
	 *
	 * @param record
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月5日
	 *
	 */
	int insert(ComTask record);
	/**
	 * 
	 *
	 * 方法说明：按条件添加客户沟通任务
	 *
	 * @param record
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月5日
	 *
	 */
	int insertSelective(ComTask record);
	/**
	 * 
	 *
	 * 方法说明：根据主键查询客户沟通任务
	 *
	 * @param code
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月5日
	 *
	 */
	ComTask selectByPrimaryKey(String code);
	
	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @param comTask
	 * @return
	 *
	 * @author 彭阳 CreateDate: 2017年8月21日
	 *
	 */
	List<ComTask> selectRemindList(Map<String,String> map);
	
	/**
	 * 
	 *
	 * 方法说明：根据主键选择性更新客户沟通任务表
	 *
	 * @param record
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月5日
	 *
	 */
	int updateByPrimaryKeySelective(ComTask record);
	
	/**
	 * 
	 *
	 * 方法说明：更新初次介绍任务,完成初次介绍任务用
	 *
	 * @param record
	 * @return
	 *
	 * @author 彭阳 CreateDate: 2017年8月10日
	 *
	 */
	int updateComTaskFi(ComTask record);
	
	
	/**
	 * 
	 *
	 * 方法说明：更新分组任务,完成分组任务用
	 *
	 * @param record
	 * @return
	 *
	 * @author 彭阳 CreateDate: 2017年8月10日
	 *
	 */
	int updateComTaskGroup(ComTask record);
	
	
	
	/**
	 * 
	 *
	 * 方法说明：根据主键更新客户沟通任务
	 *
	 * @param record
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月5日
	 *
	 */
	int updateByPrimaryKey(ComTask record);
	
	
	
	
	/**
	 * 
	 *
	 * 方法说明：根据客户编号更新沟通任务信息
	 *
	 * @param record
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年7月24日
	 *
	 */
	int updateComTaskByMemberNo(ComTask record);
	
	
	/**
	 * 
	 *
	 * 方法说明：根据客户编号更新沟通任务信息
	 *
	 * @param record
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年7月25日
	 *
	 */
	int updateAllComTaskByMemberNo(ComTask record);
	
	
	/**
	 * 
	 *
	 * 方法说明：分页查询
	 *
	 * @param findComTaskPage
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月5日
	 *
	 */
	List<FindComTaskPageReturn> findComTaskPage(FindComTaskPage findComTaskPage);
	/**
	 * 
	 *
	 * 方法说明：分页查询条数
	 *
	 * @param findComTaskPage
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月5日
	 *
	 */
	int findComTaskPageCount(FindComTaskPage findComTaskPage);

	List<FindComTaskReturn> findComTashTopOne(FindComTask findComTask);
	
	
	List<FindComTaskIndexPageReturn> findComTaskIndexPage(FindComTaskIndexPage findComTaskIndexPage);
	
	int findComTaskIndexPageCount(FindComTaskIndexPage findComTaskIndexPage);

	int findFinishCount(FindComTaskPage findComTaskPage);
	
	/**
	 * 
	 *
	 * 方法说明：统计应到店客户体验列表
	 *
	 * @param parmMap
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月22日
	 *
	 */
	List<Map<String,Object>> findExpResults(Map<String,Object> parmMap);
	
	int todayBeforeClientExpTask(TodayBeforeClientExpTaskDto todayBeforeClientExpTaskDto);
	
	int findCountFinishByDay(FindComTask findComTask);
	
}