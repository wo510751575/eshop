package com.lj.business.cf.service;

import java.util.List;
import java.util.Map;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cf.dto.clientExp.ClientExpDto;
import com.lj.business.cf.dto.clientExp.FindClientExpPage;


/**
 * 类说明：接口类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author rain
 * 
 * 
 * CreateDate: 2017-06-14
 */
public interface IClientExpService {
	
	/**
	 * 
	 *
	 * 方法说明：添加客户体验表信息
	 *
	 * @param ClientExpDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author rain CreateDate: 2017年7月9日
	 *
	 */
	public ClientExpDto addClientExp(ClientExpDto clientExpDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找客户体验表信息
	 *
	 * @param ClientExpDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author rain CreateDate: 2017年7月9日
	 *
	 */
	public ClientExpDto findClientExp(ClientExpDto clientExpDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查找客户体验表信息
	 *
	 * @param findClientExpPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author rain CreateDate: 2017年7月9日
	 *
	 */
	public Page<ClientExpDto> findClientExpPage(FindClientExpPage findClientExpPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：客户购买信息-APP
	 *
	 * @param ClientExpDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author rain CreateDate: 2017年7月4日
	 *
	 */
	public List<ClientExpDto> clientExpHistory(ClientExpDto clientExpDto) throws TsfaServiceException;

	/**
	 * 
	 *
	 * 方法说明：查找客户体验列表
	 *
	 * @param findClientExpPage
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月2日
	 *
	 */
	public List<ClientExpDto> findClientExps(FindClientExpPage findClientExpPage) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：统计到店体验条数
	 *
	 * @param findClientExpPage
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月2日
	 *
	 */
	int findClientExpPageCount(FindClientExpPage findClientExpPage);
	
	/**
	 * 
	 *
	 * 方法说明：新增体验信息
	 *
	 * @param clientExpDto
	 * @param imgFiles
	 * @param voiceFiles
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月8日
	 *
	 */
	ClientExpDto addClientExpRecord(ClientExpDto clientExpDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查询到店次数
	 *
	 * @param clientExpDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 冯辉 CreateDate: 2017年8月9日
	 *
	 */
	int clientExpCount(ClientExpDto clientExpDto) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：到店体验人数
	 * 	merchantNo 商户
	 *	expResult  是否到店 Y/N
	 *	startTime/endTime 起始到店时间	
	 * @param parmMap
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月9日
	 *
	 */
	List<Map<String,Object>> findExpResults(Map<String,Object> parmMap) throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：查看到店体验
	 *
	 * @param cfCode	跟进code
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月10日
	 *
	 */
	ClientExpDto findClientExpByCfCode(String cfCode) throws TsfaServiceException;
	
	ClientExpDto updateClientExp(ClientExpDto clientExpDto)throws TsfaServiceException;
	
	/**
	 * 
	 *
	 * 方法说明：到店统计APP接口服务
	 *	merchantNo 商户
	 *	expResult  是否到店 Y/N
	 *	startTime/endTime 起始到店时间
	 *	memberNoGm 导购编号
	 *	shopNo 门店编号
	 *	isShopMemberNoGm 店长导购编号
	 *	memberType 会员类型
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月16日
	 *
	 */
	Map<String,Object> findExpCountForMemberType(String merchantNo,String memberType,String shopNo,String memberNoGm,String searchNoGm,String nowDate) throws TsfaServiceException;

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
	public int findCountVisitByGm(Map<String, Object> map);
}
