package com.lj.business.cm.dao;

import java.util.List;

import com.lj.business.cm.domain.MaterialCommen;
import com.lj.business.cm.dto.CountMaterialCommenDto;
import com.lj.business.cm.dto.FindMaterialCommenPage;
import com.lj.business.cm.dto.FindMaterialCommenPageReturn;
import com.lj.business.cm.dto.GeneratorMaterialTotalReturn;
/**
 * 
 * 
 * 类说明：公用素材中心表
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
public interface IMaterialCommenDao {
	/**
	 * 
	 *
	 * 方法说明：
	 * 删除方法
	 * @param code
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年6月21日
	 *
	 */
    int deleteByPrimaryKey(String code);
    /**
     * 
     *
     * 方法说明：
     * 新增所有方法
     * @param record
     * @return
     *
     * @author 罗书明 CreateDate: 2017年6月21日
     *
     */
    int insert(MaterialCommen record);
    /**
     * 
     *
     * 方法说明：
     * 新增所选参数
     * @param record
     * @return
     *
     * @author 罗书明 CreateDate: 2017年6月21日
     *
     */
    int insertSelective(MaterialCommen record);
     /**
      * 
      *
      * 方法说明：
      * 根据主键查询
      * @param code
      * @return
      *
      * @author 罗书明 CreateDate: 2017年6月21日
      *
      */
    MaterialCommen selectByPrimaryKey(String code);
    /**
     * 
     *
     * 方法说明：
     * 更新所选参数
     * @param record
     * @return
     *
     * @author 罗书明 CreateDate: 2017年6月21日
     *
     */
    int updateByPrimaryKeySelective(MaterialCommen record);
     /**
      * 
      *
      * 方法说明：
      * 根据主键更新
      * @param record
      * @return
      *
      * @author 罗书明 CreateDate: 2017年6月21日
      *
      */
    int updateByPrimaryKey(MaterialCommen record);
    /**
     * 
     *
     * 方法说明：
     * 分页查询
     * @param findMaterialCommenPage
     * @return
     *
     * @author 罗书明 CreateDate: 2017年6月21日
     *
     */
	List<FindMaterialCommenPageReturn> findMaterialCommenPage(
			FindMaterialCommenPage findMaterialCommenPage);
    /**
     * 
     *
     * 方法说明：
     * 查询条目数
     * @param findMaterialCommenPage
     * @return
     *
     * @author 罗书明 CreateDate: 2017年6月21日
     *
     */
	int findMaterialCommenPageCount(FindMaterialCommenPage findMaterialCommenPage);
	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @param MerchantNo商户编号
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年7月12日
	 *
	 */
    List<FindMaterialCommenPageReturn>findMaterialCommenList(FindMaterialCommenPage findMaterialCommenPage);
    
	/**
	 * 
	 *
	 * 方法说明：根据素材编码查询素材
	 *
	 * @param code 素材编码
	 * @return
	 *
	 * @author 武鹏飞 CreateDate: 2017年7月20日
	 *
	 */
    FindMaterialCommenPageReturn findMaterialCommenByCode(String code);
    
    /**
	 * 
	 *
	 * 方法说明：根据素材编码和素材响应数量跟新响应数量
	 *
	 * @param code 素材编码
	 * @return
	 *
	 * @author 梅宏博 CreateDate: 2017年7月20日
	 *
	 */
	int updateRespondNumByPrimaryKeyAndRespondNum(MaterialCommen record);
	
	/**
	 * 
	 *
	 * 方法说明：统计公共素材条数
	 *
	 * @param countMaterialCommenDto
	 * @return
	 *
	 * @author 梅宏博 CreateDate: 2017年8月17日
	 * 
	 */
	int countMaterialCommenSelective(
			CountMaterialCommenDto countMaterialCommenDto);
	
	/**
	 * 
	 * 方法说明：获取公共素材中心回应总数量
	 *
	 * @param
	 * @return 回应总数
	 *
	 * @author 梅宏博 CreateDate: 2017年8月17日
	 */
	long getMaterialCommentResponseTotal(String merchantNo);
	
	/**
	 * 
	 * 方法说明：获取公共素材中心报表统计
	 *
	 * @param
	 * @return 报表数据
	 *
	 * @author 梅宏博 CreateDate: 2017年8月17日
	 */
	List<GeneratorMaterialTotalReturn> generatorMaterialCommenTotal(String merchantNo);
}