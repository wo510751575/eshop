package com.lj.business.cf.dao;

import java.util.List;

import com.lj.business.cf.domain.ComTaskList;
import com.lj.business.cf.dto.comTaskList.FindComTaskList;
import com.lj.business.cf.dto.comTaskList.FindComTaskListPageDto;
import com.lj.business.cf.dto.comTaskList.FindComTaskListReturn;
/**
 * 
 * 
 * 类说明：客户沟通任务事项接口
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
public interface IComTaskListDao {
	
	
	FindComTaskListReturn findComTaskList(FindComTaskList findComTaskList);
	
	/**
	 * 
	 *
	 * 方法说明：新增客户沟通任务事项表
	 *
	 * @param bom
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	int addComTaskList(ComTaskList comTaskList);
	/**
	 * 
	 *
	 * 方法说明：编辑客户沟通任务事项表
	 *
	 * @param bom
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	int editComTaskList(ComTaskList comTaskList);
	/**
	 * 
	 *
	 * 方法说明：根据主键查询客户沟通任务事项表
	 *
	 * @param code
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	ComTaskList selectByCode(String code);
	/**
	 * 
	 *
	 * 方法说明：查询客户沟通任务事项表(不分页)
	 *
	 * @param FindExGuiderPageDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	List<FindComTaskListPageDto> findComTaskLists(FindComTaskListPageDto findComTaskListPageDto);
	/**
	 * 
	 *
	 * 方法说明：查询所有客户沟通任务事项表(分页)
	 *
	 * @param findBomPageDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	List<FindComTaskListPageDto> findComTaskListPage(FindComTaskListPageDto findComTaskListPageDto);
	/**
	 * 
	 *
	 * 方法说明：查询客户沟通任务事项表条数
	 *
	 * @param findBomPageDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	int findComTaskListPageCount(FindComTaskListPageDto findComTaskListPageDto);
}
