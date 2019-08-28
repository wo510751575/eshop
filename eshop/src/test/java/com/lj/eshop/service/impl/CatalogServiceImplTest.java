package com.lj.eshop.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import com.lj.base.core.pagination.Page;
import com.lj.base.exception.TsfaServiceException;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.eshop.dto.CatalogDto;
import com.lj.eshop.dto.FindCatalogPage;
import com.lj.eshop.emus.DelFlag;
import com.lj.eshop.service.ICatalogService;

/**
 * 类说明：测试类
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @author lhy
 * 
 * 
 * CreateDate: 2017-08-22
 */
public class CatalogServiceImplTest extends SpringTestCase{

	@Resource
	ICatalogService catalogService;



	/**
	 * 
	 *
	 * 方法说明：批量添加商品类目信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addCatalogBatch() throws TsfaServiceException{
		String[] a={"钟表","时尚饰品",
				"黄金",
				"银饰",
				"木手串把件",
				"翡翠玉石",
				"水晶玛瑙",
				"钻石",
				"珍珠",
				"彩宝",
				"K金饰品",
				"铂金"
		};
		String[] b={"钻石戒指","胸针",
				"珍珠项链",
				"黄金吊坠",
				"银手镯",
				"翡翠玉石戒指",
				"K金项链",
				"彩宝戒指",
				"万金项链" 
		};
		for (int i = 0; i < a.length; i++) {
			CatalogDto catalogDto = new CatalogDto();
			//add数据录入
			catalogDto.setCatalogName(a[i]);
			catalogDto.setOrderNo(i);
			catalogDto.setCreateTime(new Date());
			catalogDto.setParentCatalogCode("1");
			catalogDto.setParentCatalogName("商品分类");
			catalogDto.setDelFlag(DelFlag.N.getValue());
			CatalogDto rt=catalogService.addCatalog(catalogDto);
			for (int j = 0; j < b.length; j++) {
				CatalogDto ccc = new CatalogDto();
				//add数据录入
				ccc.setCatalogName(b[j]);
				ccc.setParentCatalogCode(rt.getCode());
				ccc.setParentCatalogName(catalogDto.getCatalogName());
				ccc.setImageUrl("/eoms/image/catalog/4fd29d0d-1087-4325-95e1-a96e8a788b03.png");
				ccc.setOrderNo(j);
				ccc.setCreateTime(new Date());
				ccc.setDelFlag(DelFlag.N.getValue());
				catalogService.addCatalog(ccc);
			}
		}
	}
	
	

	/**
	 * 
	 *
	 * 方法说明：添加商品类目信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void addCatalog() throws TsfaServiceException{
		CatalogDto catalogDto = new CatalogDto();
		//add数据录入
		catalogDto.setCode("Code");
		catalogDto.setCatalogName("CatalogName");
		catalogDto.setParentCatalogCode("ParentCatalogCode");
		catalogDto.setParentCatalogName("ParentCatalogName");
		catalogDto.setImageUrl("ImageUrl");
		catalogDto.setOrderNo(1);
		catalogDto.setCreater("Creater");
		catalogDto.setCreateTime(new Date());
		catalogDto.setDelFlag("DelFlag");
		
		catalogService.addCatalog(catalogDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改商品类目信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void updateCatalog() throws TsfaServiceException{
		CatalogDto catalogDto = new CatalogDto();
		//update数据录入
		catalogDto.setCode("Code");
		catalogDto.setCatalogName("CatalogName");
		catalogDto.setParentCatalogCode("ParentCatalogCode");
		catalogDto.setParentCatalogName("ParentCatalogName");
		catalogDto.setImageUrl("ImageUrl");
		catalogDto.setOrderNo(1);
		catalogDto.setCreater("Creater");
		catalogDto.setCreateTime(new Date());
		catalogDto.setDelFlag("DelFlag");

		catalogService.updateCatalog(catalogDto);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品类目信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findCatalog() throws TsfaServiceException{
		CatalogDto findCatalog = new CatalogDto();
		findCatalog.setCode("111");
		catalogService.findCatalog(findCatalog);
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品类目信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findCatalogPage() throws TsfaServiceException{
		FindCatalogPage findCatalogPage = new FindCatalogPage();
		Page<CatalogDto> page = catalogService.findCatalogPage(findCatalogPage);
		Assert.assertNotNull(page);
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：查找商品类目信息
	 *
	 * @throws TsfaServiceException
	 *
	 * @author lhy CreateDate: 2017-08-22
	 *
	 */
	@Test
	public void findCatalogs() throws TsfaServiceException{
		FindCatalogPage findCatalogPage = new FindCatalogPage();
		List<CatalogDto> page = catalogService.findCatalogs(findCatalogPage);
		Assert.assertNotNull(page);
		
	}
	

	/**
	 * 通过父分类，查找该分类所有商品
	 * 方法说明：
	 *
	 * @param @throws TsfaServiceException    设定文件 
	 * @return void    返回类型 
	 * @throws Exception
	 *
	 * @author 林进权
	 *         CreateDate: 2017年10月12日
	 */
	@Test
	public void findCatalogByPcode() throws Exception{
		//查找一级商品分类
		FindCatalogPage findCatalogPage = new FindCatalogPage();
		List<CatalogDto> catalogDtos = catalogService.findCatalogs(findCatalogPage);
		List<String> cateLogStrs = new ArrayList<>();
		String pcode= "LJ_6c546a23a0b4421bb2a833670355eb03";
		findCatalogChildByPCode(catalogDtos, cateLogStrs, pcode);
		cateLogStrs.add(pcode);
		System.out.println(cateLogStrs.size() + "\r\n" + cateLogStrs);
	}



	private void findCatalogChildByPCode(List<CatalogDto> catalogDtos, List<String> cateLogStrs, String pcode) {
		for (CatalogDto catalogDto : catalogDtos) {
			if(StringUtils.equals(catalogDto.getParentCatalogCode(), pcode)) {
				cateLogStrs.add(catalogDto.getCode());
				findCatalogChildByPCode(catalogDtos, cateLogStrs, catalogDto.getCode());
			}
		}
	}
	
	
	
	
}
