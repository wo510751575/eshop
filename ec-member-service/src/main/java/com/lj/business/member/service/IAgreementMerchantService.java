package com.lj.business.member.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;

import com.lj.base.core.pagination.Page;
import com.lj.business.member.dto.AddAgreementMerchantDto;
import com.lj.business.member.dto.AgreementMerchantReturnDto;
import com.lj.business.member.dto.EditAgreementMerchantDto;
import com.lj.business.member.dto.FindAgreementMerchant;
import com.lj.business.member.dto.FindAgreementMerchantPageDto;
import com.lj.business.member.dto.FindAgreementMerchantReturnDto;



/**
 * 类说明：商户服务协议表接口类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 邹磊
 * 	
 * 
 * CreateDate: 2017年7月1日
 */
public interface IAgreementMerchantService {
	
	/**
	 * 方法说明：新增商户服务协议表.
	 *
	 * @param addAgreementMerchantDto the add agreement merchant dto
	 * @author 邹磊 CreateDate: 2017年7月1日
	 */
	public void addAgreementMerchant(AddAgreementMerchantDto addAgreementMerchantDto);
	
	/**
	 * 方法说明：编辑商户服务协议表.
	 *
	 * @param editAgreementMerchantDto the edit agreement merchant dto
	 * @author 邹磊 CreateDate: 2017年7月1日
	 */
	public void editAgreementMerchant(EditAgreementMerchantDto editAgreementMerchantDto);
	
	/**
	 * 方法说明：根据主键查询商户服务协议表.
	 *
	 * @param code the code
	 * @return the agreement merchant return dto
	 * @author 邹磊 CreateDate: 2017年7月1日
	 */
	public AgreementMerchantReturnDto selectByCode(String code);
	
	/**
	 * 方法说明：查找商户服务协议表(不分页).
	 *
	 * @param findAgreementMerchantPageDto the find agreement merchant page dto
	 * @return the list< find agreement merchant page dto>
	 * @author 邹磊 CreateDate: 2017年7月1日
	 */
	public List<FindAgreementMerchantPageDto> findAgreementMerchants(FindAgreementMerchantPageDto findAgreementMerchantPageDto);
	
	/**
	 * 方法说明：查找商户服务协议表(分页).
	 *
	 * @param findAgreementMerchantPageDto the find agreement merchant page dto
	 * @return the page< find agreement merchant page dto>
	 * @author 邹磊 CreateDate: 2017年7月1日
	 */
	public Page<FindAgreementMerchantPageDto> findAgreementMerchantPage(FindAgreementMerchantPageDto findAgreementMerchantPageDto);
	
	/**
	 * 方法说明：查找商户服务协议.
	 *
	 * @param findAgreementMerchant the find agreement merchant
	 * @return the find agreement merchant return
	 * @author 邹磊 CreateDate: 2017年7月7日
	 */
	public FindAgreementMerchantReturnDto findAgreementMerchant(FindAgreementMerchant findAgreementMerchant);
	
}
