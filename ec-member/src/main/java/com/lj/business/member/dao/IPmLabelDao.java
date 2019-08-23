package com.lj.business.member.dao;

import java.util.List;

import com.lj.business.member.domain.PmLabel;
import com.lj.business.member.dto.FindPmLabel;
import com.lj.business.member.dto.FindPmLabelPage;
import com.lj.business.member.dto.FindPmLabelPageReturn;
import com.lj.business.member.dto.FindPmLabelReturnList;

public interface IPmLabelDao {
    int deleteByPrimaryKey(String code);

    int insert(PmLabel record);

    int insertSelective(PmLabel record);

    PmLabel selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(PmLabel record);

    int updateByPrimaryKey(PmLabel record);

	List<FindPmLabelPageReturn> findPmLabelPage(FindPmLabelPage findPmLabelPage);

	int findPmLabelPageCount(FindPmLabelPage findPmLabelPage);
	
	/**
	 * 
	 *
	 * 方法说明：导购维度统计
	 *
	 * @param findPmLabel
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月4日
	 *
	 */
	List<FindPmLabelReturnList> findPmlabelGuidMember();
	/**
	 * 
	 *
	 * 方法说明：商户维度统计
	 *
	 * @param findPmLabel
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月4日
	 *
	 */
	List<FindPmLabelReturnList> findPmlabelMerchantNo();
	/**
	 * 
	 *
	 * 方法说明：门店维度统计
	 *
	 * @param findPmLabel
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月4日
	 *
	 */
	List<FindPmLabelReturnList> findPmlabelShop();
	/**
	 * 
	 *
	 * 方法说明：区域维度统计
	 *
	 * @param findPmLabel
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月4日
	 *
	 */
	List<FindPmLabelReturnList> findPmlabelAreaCode();
	
   
}