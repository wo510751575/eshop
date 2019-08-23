package com.lj.business.cm.dao;

import java.util.List;

import com.lj.business.cm.domain.Activity;
import com.lj.business.cm.dto.FindGreetClientForDayDto;
import com.lj.business.cm.dto.FindGreetClientReturnDto;
import com.lj.business.cm.dto.activity.FindActivityDto;
import com.lj.business.cm.dto.activity.FindActivityPage;
import com.lj.business.cm.dto.activity.FindActivityPageReturn;
import com.lj.business.cm.dto.activity.FindActivityReturnDto;
import com.lj.business.cm.dto.activity.UpdateActivityForReadDto;
/**
 * 
 * 
 * 类说明：活动表接口
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年7月24日
 */
public interface IActivityDao {
	/**
	 * 
	 *
	 * 方法说明：通过主键删除活动信息
	 *
	 * @param code
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月24日
	 *
	 */
    int deleteByPrimaryKey(String code);
    /**
     * 
     *
     * 方法说明：添加活动信息
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月24日
     *
     */
    int insertSelective(Activity record);
    /**
     * 
     *
     * 方法说明：根据主键查询活动信息
     *
     * @param code
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月24日
     *
     */
    Activity selectByPrimaryKey(String code);
    /**
     * 
     *
     * 方法说明：根据主键按条件更新信息
     *
     * @param record
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月24日
     *
     */
    int updateByPrimaryKeySelective(Activity record);
    /**
     * 
     *
     * 方法说明：分页查询
     *
     * @param findActivityPage
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月24日
     *
     */
    List<FindActivityPageReturn> findActivityPage(FindActivityPage findActivityPage);
    /**
     * 
     *
     * 方法说明：分页查询条数
     *
     * @param findActivityPage
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月24日
     *
     */
    int findActivityPageCount(FindActivityPage findActivityPage);
    /**
     * 
     *
     * 方法说明：查找活动列表
     *
     * @param findActivityDto
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月24日
     *
     */
	List<FindActivityPageReturn> findActivitys(FindActivityPage findActivityPage);
	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @param findGreetClientForDayDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月24日
	 *
	 */
	int updateActivityForRead(UpdateActivityForReadDto UpdateActivityForReadDto);
}