package com.lj.business.cm.dao;

import java.util.List;

import com.lj.business.cm.domain.Material;
import com.lj.business.cm.dto.CountMaterialDto;
import com.lj.business.cm.dto.FindMaterialAppPage;
import com.lj.business.cm.dto.FindMaterialAppPageReturn;
import com.lj.business.cm.dto.FindMaterialPage;
import com.lj.business.cm.dto.FindMaterialPageReturn;
import com.lj.business.cm.dto.GeneratorMaterialTotalReturn;
/**
 * 
 * 
 * 类说明：素材中心表接口类
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
public interface IMaterialDao {
	/**
	 * 
	 *
	 * 方法说明：
	 * 根据主键删除
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
     * 新增方法
     * @param record
     * @return
     *
     * @author 罗书明 CreateDate: 2017年6月21日
     *
     */
    int insert(Material record);
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
    int insertSelective(Material record);
     /**
      * 
      *
      * 方法说明：
      * 根据导购编号查询
      * @param code
      * @return
      *
      * @author 罗书明 CreateDate: 2017年6月21日
      *
      */
    Material selectByPrimaryKey(String memberNoGm);
     /**
      * 
      *
      *  方法说明：
      *  更新修改所选参数
      * @param record
      * @return
      *
      * @author 罗书明 CreateDate: 2017年6月21日
      *
      */
    int updateByPrimaryKeySelective(Material record);
     /**
      * 
      *
      * 方法说明：
      * 修改更新参数
      * @param record
      * @return
      *
      * @author 罗书明 CreateDate: 2017年6月21日
      *
      */
    int updateByPrimaryKey(Material record);
    /**
     * 
     *
     * 方法说明：
     *  分页查询
     * @param findMaterialPage
     * @return
     *
     * @author 罗书明 CreateDate: 2017年6月21日
     *
     */
	List<FindMaterialPageReturn> findMaterialPage(
			FindMaterialPage findMaterialPage);
     /**
      * 
      *
      * 方法说明：
      * 查询条目数
      * @param findMaterialPage
      * @return
      *
      * @author 罗书明 CreateDate: 2017年6月21日
      *
      */
	int findMaterialPageCount(FindMaterialPage findMaterialPage);
	
	/**
	 * 
	 *
	 * 方法说明：
	 *  根据类型查询标题
	 * @param materialTypeName
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年6月22日
	 *
	 */
    Material selectByTypeName(String materialTypeName);
    
    /**
     * 
     *
     * 方法说明：素材类型明细列表_APP用
     *
     * @param findMaterialAppPage
     * @return
     *
     * @author 冯辉 CreateDate: 2017年7月18日
     *
     */
	List<FindMaterialAppPageReturn> findMaterialAppPage(FindMaterialAppPage findMaterialAppPage);
	
	/**
	 * 
	 *
	 * 方法说明：素材类型明细列表数量_APP用
	 *
	 * @param findMaterialAppPage
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年7月18日
	 *
	 */
	int findMaterialAppPageCount(FindMaterialAppPage findMaterialAppPage);
	
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
	FindMaterialPageReturn findMaterialByCode(String code);
	
	/**
	 * 
	 * 方法说明：统计素材条数
	 *
	 * @param countMaterialDto
	 * @return
	 *
	 * @author 梅宏博 CreateDate: 2017年8月17日
	 */
	int countMaterialSelective(CountMaterialDto countMaterialDto);
	
	/**
	 * 
	 * 方法说明：统计素材中心报表
	 *
	 * @param
	 * @return 统计集合
	 *
	 * @author 梅宏博 CreateDate: 2017年8月18日
	 */
	List<GeneratorMaterialTotalReturn> generatorMaterialTotal(String merchantNo);

	/**
	 * 
	 * 方法说明：获取素材中心回应总数量
	 *
	 * @param
	 * @return 回应总数
	 *
	 * @author 梅宏博 CreateDate: 2017年8月17日
	 */
	long getMaterialResponseTotal(String merchantNo);
	
	/**
	 * 返回素材列表
	 * 方法说明：
	 *
	 * @param @param findMaterialPage
	 * @param @return    设定文件 
	 * @return List<FindMaterialPageReturn>    返回类型 
	 * @throws Exception
	 *
	 * @author 林进权
	 *         CreateDate: 2017年9月25日
	 */
	List<FindMaterialPageReturn> findMaterials(FindMaterialPage findMaterialPage);
}