package com.lj.business.cm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lj.business.cm.domain.MaterialType;
import com.lj.business.cm.dto.FindMaterialTypePage;
import com.lj.business.cm.dto.FindMaterialTypePageReturn;
import com.lj.business.cm.dto.FindMaterialTypesApp;
import com.lj.business.cm.dto.FindMaterialTypesAppReturn;
/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 罗书明
 *   
 * CreateDate: 2017年6月21日
 */
public interface IMaterialTypeDao {
	
	
	/**
	 * 
	 *
	 * 方法说明：素材类型列表_APP用
	 *
	 * @param findMaterialTypesApp
	 * @return
	 *
	 * @author 彭阳 CreateDate: 2017年7月15日
	 *
	 */
	List<FindMaterialTypesAppReturn> findMaterialTypesApp(FindMaterialTypesApp findMaterialTypesApp) ;
	/**
	 * 
	 *
	 * 方法说明：
	 *  按主键删除
	 * @param code
	 * @return null
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
    int deleteByPrimaryKey(String code);
    
    /**
     * 
     *
     * 方法说明：
     *  新增数据方法
     * @param record
     * @return
     *
     * @author 罗书明 CreateDate: 2017年6月21日
     *
     */
    int insert(MaterialType record);
    /**
     * 
     *
     * 方法说明：
     *  根据需要的参数新增
     * @param record
     * @return
     *
     * @author 罗书明 CreateDate: 2017年6月21日
     *
     */
    int insertSelective(MaterialType record);
    /**
     * 
     *
     * 方法说明：
     * 查询方法
     * @param record
     * @return
     *
     * @author 罗书明 CreateDate: 2017年6月21日
     *
     */
    MaterialType selectByPrimaryKey(String code);
    /**
     * 
     *
     * 方法说明：
     * 更新修改方法
     * @param record
     * @return
     *
     * @author 罗书明 CreateDate: 2017年6月21日
     *
     */
    int updateByPrimaryKeySelective(MaterialType record);
    /**
     * 
     *
     * 方法说明：
     * 更新所需字段方法
     * @param record
     * @return
     *
     * @author 罗书明 CreateDate: 2017年6月21日
     *
     */
    int updateByPrimaryKey(MaterialType record);
    /**
     * 
     *
     * 方法说明：
     * 分页查询
     * @param record
     * @return
     *
     * @author 罗书明 CreateDate: 2017年6月21日
     *
     */
	List<FindMaterialTypePageReturn> findMaterialTypePage(
			FindMaterialTypePage findMaterialTypePage);
	   /**
     * 
     *
     * 方法说明：
     * 查询条目数
     * @param record
     * @return
     *
     * @author 罗书明 CreateDate: 2017年6月21日
     *
     */
	int findMaterialTypePageCount(FindMaterialTypePage findMaterialTypePage);
	
	/**
	 * 
	 *
	 * 方法说明：增加类型总数
	 *
	 * @param code      类型编码
	 * @param decrement 增加数量
	 * @return
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月20日
	 *
	 */
	int incrementTypeCountByPrimaryKey(@Param("code") String code, @Param("increment") Integer increment);
	
	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @param code 		类型编码
	 * @param decrement 减少数量
	 * @return
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月20日
	 *
	 */
	int decrementTypeCountByPrimaryKey(@Param("code") String code, @Param("decrement") Integer decrement);

	/**
	 *
	 *
	 * 方法说明：
	 * 分页查询
	 * @param record
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	List<FindMaterialTypePageReturn> findMaterialTypeForMemberPage(FindMaterialTypePage findMaterialTypePage);
	/**
	 *
	 *
	 * 方法说明：
	 * 查询条目数
	 * @param record
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
	int findMaterialTypeForMemberPageCount(FindMaterialTypePage findMaterialTypePage);
	/**
	 * 
	 *
	 * 方法说明：素材类型列表_电商用
	 *
	 * @param findMaterialTypesApp
	 * @return
	 *
	 * @author 林进权 CreateDate: 2017年9月23日
	 *
	 */
	List<FindMaterialTypesAppReturn> findMaterialTypesAppEc(FindMaterialTypesApp findMaterialTypesApp) ;

}