package com.lj.business.member.dao;

import java.util.List;

import com.lj.business.member.domain.AgreementMerchant;
import com.lj.business.member.dto.FindAgreementMerchant;
import com.lj.business.member.dto.FindAgreementMerchantPageDto;

/**
 * 
 * 
 * 类说明：商户服务协议
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
public interface IAgreementMerchantDao {
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
	int addAgreementMerchant(AgreementMerchant agreementMerchant);
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
	int editAgreementMerchant(AgreementMerchant agreementMerchant);
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
	AgreementMerchant selectByCode(String code);
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
	List<FindAgreementMerchantPageDto> findAgreementMerchants(FindAgreementMerchantPageDto findAgreementMerchantPageDto);
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
	List<FindAgreementMerchantPageDto> findAgreementMerchantPage(FindAgreementMerchantPageDto findAgreementMerchantPageDto);
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
	int findAgreementMerchantPageCount(FindAgreementMerchantPageDto findAgreementMerchantPageDto);
	/**
	 * 
	 *
	 * 方法说明：通过code或merchantNo查询商户协议信息
	 *
	 * @param findAgreementMerchant
	 * @return
	 *
	 * @author 邹磊 CreateDate: 2017年7月7日
	 *
	 */
	AgreementMerchant findAgreementMerchant(FindAgreementMerchant findAgreementMerchant);
}