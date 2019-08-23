package com.lj.eshop;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lj.base.core.pagination.Page;
import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.eshop.dto.FindWshopInfoPage;
import com.lj.eshop.dto.WshopInfoDto;
import com.lj.eshop.service.IWshopInfoService;

public class WshopInfoServiceImplTest extends SpringTestCase{

	
	private static final Logger logger = LoggerFactory.getLogger(WshopInfoServiceImplTest.class);
	
	@Autowired
	private IWshopInfoService wshopInfoService;

	
	@Test
	public void addWshopInfo() {
		WshopInfoDto wshopInfoDto = new WshopInfoDto();
		wshopInfoDto.setCreater("Creater");
		wshopInfoDto.setDetail("Detail");
		wshopInfoDto.setFlagInfo("FlagInfo");
		wshopInfoDto.setImg1("Img1");
		wshopInfoDto.setImg2("Img2");
		wshopInfoDto.setImg3("Img3");
		wshopInfoDto.setImg4("Img4");
		wshopInfoDto.setImg5("Img5");
		wshopInfoDto.setReadCnt("ReadCnt");
		wshopInfoDto.setShareCnt("100");
		wshopInfoDto.setStatus("0");
		wshopInfoDto.setTitle("Title");
		wshopInfoService.addWshopInfo(wshopInfoDto);
	}
	
	@Test
	public void updateWshopInfo() {
		WshopInfoDto wshopInfoDto = new WshopInfoDto();
		wshopInfoDto.setCode("LJ_c6b4bae9d5924fc6aa7bda3ba96b8954");
		wshopInfoDto.setCreater("Creater");
		wshopInfoDto.setDetail("Detail");
		wshopInfoDto.setFlagInfo("FlagInfo");
		wshopInfoDto.setImg1("Img1");
		wshopInfoDto.setImg2("Img2");
		wshopInfoDto.setImg3("Img3");
		wshopInfoDto.setImg4("Img4");
		wshopInfoDto.setImg5("Img5");
		wshopInfoDto.setReadCnt("ReadCnt");
		wshopInfoDto.setStatus("0");
		wshopInfoDto.setTitle("Title");
		wshopInfoService.updateWshopInfo(wshopInfoDto);
	}
	
	@Test
	public void findWshopInfos() {
		FindWshopInfoPage findWshopInfoPage=  new FindWshopInfoPage();
		findWshopInfoPage.setTitle("Title");
		List<FindWshopInfoPage> list =wshopInfoService.findWshopInfos(findWshopInfoPage);
		System.out.println(list.toString());
	}
	
	@Test
	public void findWshopInfoPage() {
		FindWshopInfoPage findWshopInfoPage=  new FindWshopInfoPage();
		findWshopInfoPage.setTitle("Title");
		Page<FindWshopInfoPage> list =wshopInfoService.findWshopInfoPage(findWshopInfoPage);
		System.out.println(list.toString());
	}
}
