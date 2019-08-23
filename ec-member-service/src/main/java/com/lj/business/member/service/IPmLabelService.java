package com.lj.business.member.service;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.List;
import java.util.Map;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.member.dto.AddPmLabel;
import com.lj.business.member.dto.AddPmLabelReturn;
import com.lj.business.member.dto.DelPmLabel;
import com.lj.business.member.dto.DelPmLabelReturn;
import com.lj.business.member.dto.FindPmLabel;
import com.lj.business.member.dto.FindPmLabelPage;
import com.lj.business.member.dto.FindPmLabelPageReturn;
import com.lj.business.member.dto.FindPmLabelReturn;
import com.lj.business.member.dto.FindPmLabelReturnList;
import com.lj.business.member.dto.UpdatePmLabel;
import com.lj.business.member.dto.UpdatePmLabelReturn;


/**
 * 类说明：接口类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author 彭阳
 * 
 * 
 * CreateDate: 2017-06-14
 */
public interface IPmLabelService {
	
	/**
	 * 方法说明：添加客户标签信息.
	 *
	 * @param addPmLabel the add pm label
	 * @return the adds the pm label return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public AddPmLabelReturn addPmLabel(AddPmLabel addPmLabel) throws TsfaServiceException;
	
	/**
	 * 方法说明：查找客户标签信息.
	 *
	 * @param findPmLabel the find pm label
	 * @return the find pm label return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public FindPmLabelReturn findPmLabel(FindPmLabel findPmLabel) throws TsfaServiceException;
	
	
	/**
	 * 方法说明：删除客户标签信息.
	 *
	 * @param delPmLabel the del pm label
	 * @return the del pm label return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public DelPmLabelReturn delPmLabel(DelPmLabel delPmLabel) throws TsfaServiceException;

	/**
	 * 方法说明：修改客户标签信息.
	 *
	 * @param updatePmLabel the update pm label
	 * @return the update pm label return
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public UpdatePmLabelReturn updatePmLabel(UpdatePmLabel updatePmLabel)throws TsfaServiceException;

	/**
	 * 方法说明：查找客户标签信息.
	 *
	 * @param findPmLabelPage the find pm label page
	 * @return the page< find pm label page return>
	 * @throws TsfaServiceException the tsfa service exception
	 * @author 彭阳 CreateDate: 2017年6月9日
	 */
	public Page<FindPmLabelPageReturn> findPmLabelPage(FindPmLabelPage findPmLabelPage) throws TsfaServiceException;
	
	/**
	 * 方法说明：根据客户编号查询关联的标签.
	 *
	 * @param parmap 1.memberNo 客户编号
	 * 2.isPublic 是否系统公用
	 *  	标签集合
	 *
	 * @return 标签集合
	 * @author 段志鹏 CreateDate: 2017年7月11日
	 */
	public List<Map<String,String>> findPmLabelByMemberNo(Map<String,String> parmap);
	
	/**
	 * 
	 *
	 * 方法说明：根据商户编号统计商户下所有导购客户标签(导购维度)
	 *
	 * @param findPmLabel
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月4日
	 *
	 */
	public  List<FindPmLabelReturnList> findPmlabelGuidMember()throws TsfaServiceException;
	/**
	 * 
	 *
	 * 方法说明：根据商户编号统计商户下所有导购客户标签(商户维度)
	 *
	 * @param findPmLabel
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月4日
	 *
	 */
	public  List<FindPmLabelReturnList> findPmlabelMerchantNo()throws TsfaServiceException;
	/**
	 * 
	 *
	 * 方法说明：根据商户编号统计商户下所有导购客户标签(门店维度)
	 *
	 * @param findPmLabel
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月4日
	 *
	 */
	public  List<FindPmLabelReturnList> findPmlabelShop()throws TsfaServiceException;
	/**
	 * 
	 *
	 * 方法说明：根据商户编号统计商户下所有导购客户标签(区域维度)
	 *
	 * @param findPmLabel
	 * @return
	 *
	 * @author 罗书明 CreateDate: 2017年8月4日
	 *
	 */
	public  List<FindPmLabelReturnList> findPmlabelAreaCode()throws TsfaServiceException;
}
