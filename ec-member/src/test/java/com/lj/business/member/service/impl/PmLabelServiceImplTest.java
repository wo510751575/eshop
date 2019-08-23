package com.lj.business.member.service.impl;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市领居科技 License, Version 1.0 (the "License");
 * 
 */
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.business.member.dao.IPmLabelPmDao;
import com.lj.business.member.domain.PmLabelPm;
import com.lj.business.member.dto.AddPmLabel;
import com.lj.business.member.dto.DelPmLabel;
import com.lj.business.member.dto.FindPmLabel;
import com.lj.business.member.dto.FindPmLabelPage;
import com.lj.business.member.dto.FindPmLabelPageReturn;
import com.lj.business.member.dto.FindPmLabelReturnList;
import com.lj.business.member.dto.UpdatePmLabel;
import com.lj.business.member.service.IPmLabelService;


/**
 * 类说明：测试类
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
public class PmLabelServiceImplTest extends SpringTestCase{

	@Resource
	IPmLabelService pmLabelService;
	@Resource
	IPmLabelPmDao pmLabelPmDao;


	/**
	 * 
	 *
	 * 方法说明：添加商户表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void addPmLabel() throws TsfaServiceException{
		
			AddPmLabel addPmLabel = new AddPmLabel();
			//add数据录入
			addPmLabel.setCode(GUID.getPreUUID());
			addPmLabel.setMerchantNo(GUID.generateByIP());
			addPmLabel.setLabelName("运动达人");
			addPmLabel.setCreateId("吴晶晶");
			addPmLabel.setRemark("备注");
			addPmLabel.setCreateDate(new Date());
            System.out.println(addPmLabel);
			Assert.assertNotNull(pmLabelService.addPmLabel(addPmLabel ));
		
	}

	/**
	 * 
	 *
	 * 方法说明：修改商户表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void updatePmLabel() throws TsfaServiceException{
		UpdatePmLabel updatePmLabel = new UpdatePmLabel();
		//update数据录入
		updatePmLabel.setCode(GUID.getPreUUID());
		updatePmLabel.setMerchantNo("MerchantNo");
		updatePmLabel.setLabelName("LabelName");
		updatePmLabel.setCreateId("CreateId");
		updatePmLabel.setRemark("备注一");
		updatePmLabel.setCreateDate(new Date());

		pmLabelService.updatePmLabel(updatePmLabel );

	}

	/**
	 * 
	 *
	 * 方法说明：查找商户表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findPmLabel() throws TsfaServiceException{
		FindPmLabel findPmLabel = new FindPmLabel();
		findPmLabel.setCode("LJ_6aac8cfca6484ff5a1c7c7b486155349");
		pmLabelService.findPmLabel(findPmLabel);
	}

	/**
	 * 
	 *
	 * 方法说明：查找商户表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void findPmLabelPage() throws TsfaServiceException{
		FindPmLabelPage findPmLabelPage = new FindPmLabelPage();
		Page<FindPmLabelPageReturn> page = pmLabelService.findPmLabelPage(findPmLabelPage);
		Assert.assertNotNull(page);

	}

	/**
	 * 
	 *
	 * 方法说明：删除商户表信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author 彭阳 CreateDate: 2017年6月10日
	 *
	 */
	@Test
	public void delPmLabel() throws TsfaServiceException{
		DelPmLabel delPmLabel = new DelPmLabel();
		delPmLabel.setCode(GUID.getPreUUID());
		Assert.assertNotNull(pmLabelService.delPmLabel(delPmLabel));

	}


	@Test
	public void findPmLabelByMemberNo() throws TsfaServiceException{
		Map<String, String> parmap = new HashMap<>();
		parmap.put("memberNo","a");
//		parmap.put("isPublic", "Y");
		List<Map<String,String>> list= pmLabelService.findPmLabelByMemberNo(parmap);
		System.out.println(list.toString());
	}
	
	@Test
	public void addPmLabelPm() throws TsfaServiceException{
		PmLabelPm record = new PmLabelPm();
		record.setCode(GUID.getPreUUID());
		record.setMemberNo("a");
		record.setPmLabelCode("e6e5a5dec35643cd9fbd020fcaa9acf22");
		pmLabelPmDao.insertSelective(record);
	}
	
	@Test
	public void findPmlabelGuidMember() throws TsfaServiceException{
	   List<FindPmLabelReturnList>	list=pmLabelService.findPmlabelGuidMember();
	  System.out.println(list.toString());
	}
	@Test
	public void findPmlabelm() throws TsfaServiceException{
	   List<FindPmLabelReturnList>	list=pmLabelService.findPmlabelMerchantNo();
	 System.out.println(list.toString());
	}
	@Test
	public void findPmlabelcode() throws TsfaServiceException{
	   List<FindPmLabelReturnList>	list=pmLabelService.findPmlabelAreaCode();
	 System.out.println(list.toString());
	}
}
