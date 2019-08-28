package com.lj.business.cm.dao;

import java.util.List;

import com.lj.business.cm.domain.MerchantBom;
import com.lj.business.cm.dto.FindMerchantBomPage;
import com.lj.business.cm.dto.FindMerchantBomPageReturn;
/**
 * 
 * 
 * 类说明：商户产品表接口类
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
public interface IMerchantBomDao {
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
    int insert(MerchantBom record);
    /**
     * 
     *
     * 方法说明：
     * 根据所需字段新增
     * @param record
     * @return
     *
     * @author 罗书明 CreateDate: 2017年6月21日
     *
     */
    int insertSelective(MerchantBom record);
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
    MerchantBom selectByPrimaryKey(String code);
    /**
     * 
     *
     * 方法说明：
     * 更新个别字段
     * @param record
     * @return
     *
     * @author 罗书明 CreateDate: 2017年6月21日
     *
     */
    int updateByPrimaryKeySelective(MerchantBom record);
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
    int updateByPrimaryKey(MerchantBom record);
    /**
     * 
     *
     * 方法说明：
     * 分页查询
     * @param findMerchantBomPage
     * @return
     *
     * @author 罗书明 CreateDate: 2017年6月21日
     *
     */
	List<FindMerchantBomPageReturn> findMerchantBomPage(
			FindMerchantBomPage findMerchantBomPage);
    /**
     * 
     *
     * 方法说明：
     *  查询条目数
     * @param findMerchantBomPage
     * @return
     *
     * @author 罗书明 CreateDate: 2017年6月21日
     *
     */
	int findMerchantBomPageCount(FindMerchantBomPage findMerchantBomPage);
}