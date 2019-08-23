package com.lj.business.cf.dao;

import java.util.List;

import com.lj.business.cf.domain.WorkTaskUnfinish;
import com.lj.business.cf.dto.FindWorkTaskUnfinishPage;
import com.lj.business.cf.dto.FindWorkTaskUnfinishPageReturn;
/**
 * 
 * 
 * 类说明：未完成工作任务表
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
public interface IWorkTaskUnfinishDao {
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
    int insert(WorkTaskUnfinish record);
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
    int insertSelective(WorkTaskUnfinish record);
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
    WorkTaskUnfinish selectByPrimaryKey(String code);
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
    int updateByPrimaryKeySelective(WorkTaskUnfinish record);
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
    int updateByPrimaryKey(WorkTaskUnfinish record);
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
	WorkTaskUnfinish selectByPrimaryKey(Long code);
	/**
	 * 
	 *
	 * 方法说明：分页查询
	 *
	 * @param FindWorkTaskUnfinishPage
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月21日
	 *
	 */
	List<FindWorkTaskUnfinishPageReturn> findWorkTaskUnfinishPage(FindWorkTaskUnfinishPage findWorkTaskUnfinishPage);
	/**
	 * 
	 *
	 * 方法说明：分页查询条数
	 *
	 * @param FindWorkTaskUnfinishPage
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月21日
	 *
	 */
	int findWorkTaskUnfinishPageCount(FindWorkTaskUnfinishPage findWorkTaskUnfinishPage);
}