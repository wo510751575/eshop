package com.lj.business.member.dao;

import java.util.List;

import com.lj.business.member.domain.Merchant;
import com.lj.business.member.dto.FindMerchantDto;
import com.lj.business.member.dto.FindMerchantPage;
import com.lj.business.member.dto.FindMerchantPageReturn;

public interface IMerchantDao {
    int deleteByPrimaryKey(String code);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);
    /**
     * 
     *
     * 方法说明：查找商户信息(个人中心)
     *
     * @param findMerchantDto
     * @return
     *
     * @author 邹磊 CreateDate: 2017年7月18日
     *
     */
    Merchant selectMerchant(FindMerchantDto findMerchantDto);
    
	List<FindMerchantPageReturn> findMerchantPage(FindMerchantPage findMerchantPage);

	int findMerchantPageCount(FindMerchantPage findMerchantPage);
	
	List<FindMerchantPageReturn> findMerchants(FindMerchantPage findMerchantPage);
}