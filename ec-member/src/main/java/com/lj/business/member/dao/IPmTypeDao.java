package com.lj.business.member.dao;

import java.util.List;
import java.util.Map;

import com.lj.business.member.domain.PmType;
import com.lj.business.member.dto.FindPmType;
import com.lj.business.member.dto.FindPmTypeIndex;
import com.lj.business.member.dto.FindPmTypeIndexReturn;
import com.lj.business.member.dto.FindPmTypePage;
import com.lj.business.member.dto.FindPmTypePageReturn;

public interface IPmTypeDao {
    int deleteByPrimaryKey(String code);

    int insert(PmType record);

    int insertSelective(PmType record);
    
    /**
     * 
     *
     * 方法说明：根据 MEMBER_NO MEMBER_NO_GM 查询用户所属客户客户分类关联表CODE（除了紧急，交叉分组）
     *
     * @param map
     * @return
     *
     * @author 彭阳 CreateDate: 2017年7月27日
     *
     */
    String selectPmTypePmCode(Map<String,String> map);

    PmType selectByPrimaryKey(String code);
    
    PmType selectByParamKey(PmType pmType);
    
    PmType selectByMP(FindPmType findPmType);
    
    /**
     * 
     *
     * 方法说明：更改客户所属分类，排除法查找客户所属分类
     *
     * @param pmType
     * @return
     *
     * @author 彭阳 CreateDate: 2017年7月11日
     *
     */
    Map<String,String> selectByParamKey_changePmType(Map<String,String> map);
    
    List<FindPmTypeIndexReturn>  findPmTypeIndex(FindPmTypeIndex findPmTypeIndex);

    int updateByPrimaryKeySelective(PmType record);

    int updateByPrimaryKey(PmType record);
    /**
     * 
     *
     * 方法说明：分页查询
     *
     * @param findPmTypePage
     * @return
     *
     * @author 邹磊 CreateDate: 2017年6月28日
     *
     */
	List<FindPmTypePageReturn> findPmTypePage(FindPmTypePage findPmTypePage);
	/**
	 * 
	 *
	 * 方法说明：分页查询显示条数
	 *
	 * @param findPmTypePage
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年6月28日
	 *
	 */
	int findPmTypePageCount(FindPmTypePage findPmTypePage);
	
	List<PmType> inqueryMemberGroupInfo(String merchantNo);
	
	/**
	 * 
	 *
	 * 方法说明：获取客户分组信息 新增
	 *
	 * @param merchantNo
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年7月14日
	 *
	 */
	List<PmType> inqueryNewMemberOutOffGroupInfo(String merchantNo);
	
	/**
	 * 
	 *
	 * 方法说明：查询客户分类 除去交叉、成单、暂停、紧急
	 *
	 * @param merchantNo
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年7月14日
	 *
	 */
	List<PmType> inqueryModifyMemberOutOffGroupInfo(String merchantNo);
	
	int selectInUnGroupCount(Map<String,Object> map);
	
	int selectIntentionCount(Map<String,Object> map);
	
	/**
	 * 
	 *
	 * 方法说明：条件查询返回
	 *
	 * @param findPmTypePageReturn
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年7月4日
	 *
	 */
	List<FindPmTypePageReturn> findPmTypePages(FindPmTypePageReturn findPmTypePageReturn);
	
	/**
	 * 
	 *
	 * 方法说明：根据导购号查询客户类型
	 *
	 * @param memberNo
	 * @return
	 *
	 * @author 梅宏博 CreateDate: 2017年8月19日
	 *
	 */
	List<String> findPmTypeCodeByPm(String codePm);
	
}