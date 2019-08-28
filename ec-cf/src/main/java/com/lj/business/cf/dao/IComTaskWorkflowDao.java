package com.lj.business.cf.dao;

import java.util.List;
import java.util.Map;

import com.lj.business.cf.domain.ComTaskWorkflow;
import com.lj.business.cf.dto.comTaskWorkflow.FindComTaskWorkflowPage;
import com.lj.business.cf.dto.comTaskWorkflow.FindComTaskWorkflowPageReturn;
import com.lj.business.cf.dto.comTaskWorkflow.FindComTaskWorkflowReturn;
/**
 * 
 * 
 * 类说明：客户沟通任务流程表接口
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
public interface IComTaskWorkflowDao {
	/**
	 * 
	 *
	 * 方法说明：根据主键删除客户沟通任务流程
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
	 * 方法说明：添加客户沟通任务流程
	 *
	 * @param record
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月5日
	 *
	 */
	int insert(ComTaskWorkflow record);
	/**
	 * 
	 *
	 * 方法说明：按条件添加客户沟通任务流程
	 *
	 * @param record
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月5日
	 *
	 */
	int insertSelective(ComTaskWorkflow record);
	/**
	 * 
	 *
	 * 方法说明：根据主键查询客户沟通任务流程
	 *
	 * @param code
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月5日
	 *
	 */
	ComTaskWorkflow selectByPrimaryKey(String code);
	/**
	 * 
	 *
	 * 方法说明：根据主键选择性更新客户沟通任务流程
	 *
	 * @param record
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月5日
	 *
	 */
	int updateByPrimaryKeySelective(ComTaskWorkflow record);
	/**
	 * 
	 *
	 * 方法说明：根据主键更新客户沟通任务流程
	 *
	 * @param record
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月5日
	 *
	 */
	int updateByPrimaryKey(ComTaskWorkflow record);
	/**
	 * 
	 *
	 * 方法说明：分页查询
	 *
	 * @param findComTaskWorkflowPage
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月5日
	 *
	 */
	List<FindComTaskWorkflowPageReturn> findComTaskWorkflowPage(FindComTaskWorkflowPage findComTaskWorkflowPage);
	/**
	 * 
	 *
	 * 方法说明：分页查询条数
	 *
	 * @param findComTaskWorkflowPage
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月5日
	 *
	 */
	int findComTaskWorkflowPageCount(FindComTaskWorkflowPage findComTaskWorkflowPage);
	
	@SuppressWarnings("rawtypes")
	List<FindComTaskWorkflowReturn> comTaskWorkFlowList(Map map);
}