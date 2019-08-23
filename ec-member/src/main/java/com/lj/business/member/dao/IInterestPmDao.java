package com.lj.business.member.dao;

import java.util.List;

import com.lj.business.member.domain.InterestPm;
import com.lj.business.member.dto.FindInterestPmPageDto;
/**
 * 
 * 
 * 类说明：商户服务协议接口
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年7月1日
 */
public interface IInterestPmDao {
	/**
	 * 
	 *
	 * 方法说明：新增商户服务协议
	 *
	 * @param bom
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	int addInterestPm(InterestPm interestPm);
	/**
	 * 
	 *
	 * 方法说明：编辑商户服务协议
	 *
	 * @param bom
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	int editInterestPm(InterestPm interestPm);
	/**
	 * 
	 *
	 * 方法说明：根据主键查询商户服务协议
	 *
	 * @param code
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	InterestPm selectByCode(String code);
	/**
	 * 
	 *
	 * 方法说明：查询商户服务协议(不分页)
	 *
	 * @param FindExGuiderPageDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	List<FindInterestPmPageDto> findInterestPms(FindInterestPmPageDto findInterestPmPageDto);
	/**
	 * 
	 *
	 * 方法说明：查询所有商户服务协议(分页)
	 *
	 * @param findBomPageDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	List<FindInterestPmPageDto> findInterestPmPage(FindInterestPmPageDto findInterestPmPageDto);
	/**
	 * 
	 *
	 * 方法说明：查询商户服务协议条数
	 *
	 * @param findBomPageDto
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月1日
	 *
	 */
	int findInterestPmPageCount(FindInterestPmPageDto findInterestPmPageDto);
}
