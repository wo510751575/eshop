package com.lj.business.cf.dao;

import java.util.List;
import java.util.Map;

import com.lj.business.cf.domain.ClientExp;
import com.lj.business.cf.dto.clientExp.ClientExpDto;
import com.lj.business.cf.dto.clientExp.FindClientExpPage;
/**
 * 
 * 
 * 类说明：到店体验接口
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author rain
 *   
 * CreateDate: 2017年7月5日
 */
public interface IClientExpDao {
	/**
	 * 
	 *
	 * 方法说明：新增到店体验
	 *
	 * @param bom
	 * @return
	 *
	 * @author rain CreateDate: 2017年7月1日
	 *
	 */
	int addClientExp(ClientExp clientExp);
	/**
	 * 
	 *
	 * 方法说明：根据主键查询到店体验
	 *
	 * @param code
	 * @return
	 *
	 * @author rain CreateDate: 2017年7月1日
	 *
	 */
	ClientExp selectByCode(String code);
	/**
	 * 
	 *
	 * 方法说明：查询所有到店体验(分页)
	 *
	 * @param findBomPageDto
	 * @return
	 *
	 * @author rain CreateDate: 2017年7月1日
	 *
	 */
	List<ClientExpDto> findClientExpPage(FindClientExpPage findClientExpPage);
	/**
	 * 
	 *
	 * 方法说明：查询到店体验条数
	 *
	 * @param findBomPageDto
	 * @return
	 *
	 * @author rain CreateDate: 2017年7月1日
	 *
	 */
	int findClientExpPageCount(FindClientExpPage findClientExpPage);
	
	@SuppressWarnings("rawtypes")
	List<ClientExpDto> clientExpHistory(Map map);
	
	/**
	 * 
	 *
	 * 方法说明：查询列表
	 *
	 * @param findClientExpPage
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月2日
	 *
	 */
	List<ClientExpDto> findClientExps(FindClientExpPage findClientExpPage);
	
	/**
	 * 
	 *
	 * 方法说明：到店体验次数
	 *
	 * @param clientExpDto
	 * @return
	 *
	 * @author 冯辉 CreateDate: 2017年8月9日
	 *
	 */
	int clientExpCount(ClientExpDto clientExpDto);
	
	List<Map<String,Object>> findExpResults(Map<String,Object> parmMap);
	
	int updateByPrimaryKeySelective(ClientExp clientExp);
	
	/**
	 * 
	 *
	 * 方法说明：根据导购编号查询客户到店体验量
	 * @param merchantNo 导购编号
	 * 		  expResult 是否到店        完成：Y    未完成：N
	 * 	      beginTime 开始时间
	 * 		  endTime 结束时间
	 * @return
	 *
	 * @author 梅宏博 CreateDate: 2017年8月19日
	 *
	 */
	int findCountVisitByGm(Map<String, Object> map);
}
