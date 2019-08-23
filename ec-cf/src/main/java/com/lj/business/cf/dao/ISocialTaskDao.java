package com.lj.business.cf.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lj.business.cf.domain.SocialTask;
import com.lj.business.cf.dto.socialTask.FindSocialTaskPage;
import com.lj.business.cf.dto.socialTask.FindSocialTaskPageReturn;
import com.lj.business.cf.dto.socialTask.FindSocialTaskSt;
import com.lj.business.cf.dto.socialTask.FindStIndexPage;
import com.lj.business.cf.dto.socialTask.FindStIndexPageReturn;
/**
 * 
 * 
 * 类说明：社交任务接口
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
public interface ISocialTaskDao {
	
	int selectCountByParams(SocialTask socialTask);
	
    int deleteByPrimaryKey(String code);

    int insert(SocialTask record);

    int insertSelective(SocialTask record);

    SocialTask selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(SocialTask record);

    int updateByPrimaryKey(SocialTask record);
    
    List<FindStIndexPageReturn> findStIndexPage(FindStIndexPage findStIndexPage);
    
	int findStIndexPageCount(FindStIndexPage findStIndexPage);


	/**
	 * 
	 *
	 * 方法说明：查询所有社交任务表(分页)
	 *
	 * @param findBomPageDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	List<FindSocialTaskPageReturn> findSocialTaskPage(FindSocialTaskPage findSocialTaskPage);
	
	/**
	 * 
	 *
	 * 方法说明：查询每个导购社交数量
	 *
	 * @param date 
	 * @return
	 *
	 * @author 刘培 CreateDate: 2017年8月15日
	 *
	 */
	List<FindSocialTaskSt> findSocialTaskStByDay(Date date); 
	
	
	/**
	 * 
	 *
	 * 方法说明：查询社交任务表条数
	 *
	 * @param findBomPageDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	int findSocialTaskPageCount(FindSocialTaskPage findSocialTaskPage);

	/**
	 * 
	 *
	 * 方法说明：根据导购编号查询导购社交任务量
	 * @param merchantNo 导购编号
	 * 		  finish 是否完成        完成：Y    未完成：N
	 * 	      beginTime 开始时间
	 * 		  endTime 结束时间
	 * @return
	 *
	 * @author 梅宏博 CreateDate: 2017年8月19日
	 *
	 */
	int findCountSocialByGm(Map<String, Object> map);
}