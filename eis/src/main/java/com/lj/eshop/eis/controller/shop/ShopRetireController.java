/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.shop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.pagination.PageSortType;
import com.lj.base.core.util.StringUtils;
import com.lj.eshop.constant.NoUtil;
import com.lj.eshop.dto.AccWaterDto;
import com.lj.eshop.dto.FindAccWaterPage;
import com.lj.eshop.dto.FindShopRetirePage;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.dto.ShopRetireDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.emus.AccWaterAccType;
import com.lj.eshop.emus.AccWaterBizType;
import com.lj.eshop.emus.AccWaterSource;
import com.lj.eshop.emus.AccWaterStatus;
import com.lj.eshop.emus.AccWaterType;
import com.lj.eshop.emus.AuditStatus;
import com.lj.eshop.emus.ShopExpressStatus;
import com.lj.eshop.emus.ShopRetireViewStatus;
import com.lj.eshop.emus.ShopStatus;
import com.lj.eshop.service.IAccWaterService;
import com.lj.eshop.service.IShopRetireService;
import com.lj.eshop.service.IShopService;

/**
 * 
 * 类说明：押金退出申请
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年9月6日
 */
@RestController
@RequestMapping("/shop/retire")
public class ShopRetireController extends BaseController {


	@Autowired
	private IShopRetireService shopRetireService;
	@Autowired
	private IShopService shopService;
	@Autowired
	private IAccWaterService accWaterService;


	/**
	 * 我的押金-查询
	 * 方法说明：
	 * @author 林进权
	 *         CreateDate: 2017年9月1日
	 */
	@RequestMapping(value = {"view"})
	@ResponseBody
	public ResponseDto view() {
		logger.debug("ShopRetireController --> view() - start");
		
		ShopDto paramShopDto = new ShopDto();
		paramShopDto.setCode(getLoginShopCode());
		ShopDto shopDto = shopService.findShop(paramShopDto);
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("status",  shopDto.getStatus());//0:申请中 1:正常  2:关闭  3:申请失败, 11审核中,13审核成功,15审核失败, 17退款成功
		
		
		
		if(StringUtils.equal(ShopStatus.NORMAL.getValue(), shopDto.getStatus())) {
			FindShopRetirePage findShopRetirePage = new FindShopRetirePage();
			ShopRetireDto sRetireDto = new ShopRetireDto();
			sRetireDto.setMbrCode(getLoginMemberCode());
			findShopRetirePage.setParam(sRetireDto);
			findShopRetirePage.setSortDir(PageSortType.desc);
			findShopRetirePage.setSortBy("create_time");
			List<ShopRetireDto> list = this.shopRetireService.findShopRetires(findShopRetirePage);
			/*for (ShopRetireDto tmp : list) {
				if(StringUtils.equal(tmp.getAuditStatus(), AuditStatus.WAIT.getValue())) {
					map.put("status",  "11");//审核中
					break;
				}else if(StringUtils.equal(tmp.getAuditStatus(), AuditStatus.SUCCESS.getValue())) {
					map.put("status",  "13");//审核成功
					break;
				}else if(StringUtils.equal(tmp.getAuditStatus(), AuditStatus.FAIL.getValue())) {
					map.put("status",  "15");//审核失败
					break;
				}
			}*/
			
			if(null!=list && list.size()>0) {
				ShopRetireDto shopRetire = list.get(0);
				if(StringUtils.equal(shopRetire.getAuditStatus(), AuditStatus.WAIT.getValue())) {
					map.put("status",  ShopRetireViewStatus.RETIRE_APPLY.getValue());//审核中
				}else if(StringUtils.equal(shopRetire.getAuditStatus(), AuditStatus.SUCCESS.getValue())) {
					map.put("status",  ShopRetireViewStatus.RETIRE_SUCCESS.getValue());//审核成功
					
					
					//审核成功，查询流水
					FindAccWaterPage findAccWaterPage = new FindAccWaterPage();
					AccWaterDto param = new AccWaterDto();
					param.setStatus(AccWaterStatus.SUCCESS.getValue());
					param.setAccSource(AccWaterSource.DEPOSIT.getValue());
					param.setAccType(AccWaterAccType.MANUAL.getValue());
					param.setBizType(AccWaterBizType.REFUND.getValue());
					param.setOpCode(shopDto.getMbrCode());
					param.setWaterType(AccWaterType.ADD.getValue());
					findAccWaterPage.setParam(param);
					findAccWaterPage.setSortBy("create_time");
					findAccWaterPage.setSortDir(PageSortType.desc);
					List<AccWaterDto> acclist =  accWaterService.findAccWaters(findAccWaterPage);
					if(null!=acclist && acclist.size()>0) {
						
						if(StringUtils.isNotEmpty(shopRetire.getRetireStatus())) {
							map.put("remarks", shopRetire.getRemarks()); //扣除原因
							map.put("arriveAmt", acclist.get(0).getAmt()); //到帐金额
							if(null!=acclist.get(0).getAmt() && acclist.get(0).getAmt().compareTo(NoUtil.DEFAULT_CASH_PLEDGE)!=0 ) {
								map.put("status",  ShopRetireViewStatus.RETIRE_BACK.getValue());//退款成功
								map.put("deductAmt", NoUtil.DEFAULT_CASH_PLEDGE.subtract(acclist.get(0).getAmt())); //扣除金额
							}
							if(null!=shopRetire.getUpdateTime() && StringUtils.equal(shopRetire.getRetireStatus(), "1")) {
								map.put("closeTime", shopRetire.getUpdateTime());
							}
						}
					}
					
					
				}else if(StringUtils.equal(shopRetire.getAuditStatus(), AuditStatus.FAIL.getValue())) {
					map.put("status",  ShopRetireViewStatus.RETIRE_FAIL.getValue());//审核失败
					map.put("remarks", shopRetire.getRemarks()); //审核失败原因
					map.put("closeTime", shopRetire.getUpdateTime());
				}
			}
			
			
		}
		
		map.put("mimeCode",  shopDto.getMimeCode());//设备
		map.put("openTime",  shopDto.getOpenTime());//开店时间
		map.put("cashPledge", NoUtil.DEFAULT_CASH_PLEDGE);
		
		
		logger.debug("ShopRetireController --> view() - end");
		return ResponseDto.successResp(map);
	}

	
	/**
	 * 我的押金-退出
	 * 方法说明：
	 *
	 * @param 快递公司：expressName	必填
	 * @param 快递单号：expressNo	必填
	 * 
	 * @author 林进权
	 *         CreateDate: 2017年9月6日
	 */
	@RequestMapping(value = {"add"})
	@ResponseBody
	public ResponseDto add(ShopRetireDto shopRetireDto) {
		logger.debug("ShopRetireController --> add() - start", shopRetireDto); 
		
		if(shopRetireDto==null || StringUtils.isEmpty(shopRetireDto.getExpressName())
				|| StringUtils.isEmpty(shopRetireDto.getExpressNo())){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		
		FindShopRetirePage findShopRetirePage = new FindShopRetirePage();
		ShopRetireDto sRetireDto = new ShopRetireDto();
		sRetireDto.setMbrCode(getLoginMemberCode());
		findShopRetirePage.setParam(sRetireDto);
		List<ShopRetireDto> list = this.shopRetireService.findShopRetires(findShopRetirePage);
		//首要条件必须是完成的
		if(null!=list && list.size()>0
				) {
			for (ShopRetireDto tmp : list) {
				if(StringUtils.equal(tmp.getAuditStatus(), AuditStatus.WAIT.getValue())) {
					return ResponseDto.createResp(false, ResponseCode.SHOP_RETIRE_APPLY_FAIL.getCode(), ResponseCode.SHOP_RETIRE_APPLY_FAIL.getMsg(), null);
				} else if(StringUtils.equal(tmp.getAuditStatus(), AuditStatus.SUCCESS.getValue())) {
					return ResponseDto.createResp(false, ResponseCode.SHOP_RETIRE_APPLY_FAIL_SUCCESS.getCode(), ResponseCode.SHOP_RETIRE_APPLY_FAIL_SUCCESS.getMsg(), null);
				}
			}
		}
		
		//add数据录入
		shopRetireDto.setRetireNo(NoUtil.generateNo(NoUtil.JY));
		shopRetireDto.setMbrCode(getLoginMemberCode());
		shopRetireDto.setShopCode(getLoginShopCode());
		shopRetireDto.setShopName(getLoginShop().getShopName());
		shopRetireDto.setAuditStatus(AuditStatus.WAIT.getValue());
		shopRetireDto.setExpressStatus(ShopExpressStatus.WAIT.getValue());
		shopRetireDto.setCreateTime(new Date());
		shopRetireService.addShopRetire(shopRetireDto);
		
		logger.debug("ShopRetireController --> add(={}) - end");
		return ResponseDto.successResp(null);
	}
	
	
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date bDate = simpleDateFormat.parse("2017-09-05 00:00:00");
		Date dDate = simpleDateFormat.parse("2017-09-04 00:00:00");
		
		
		System.out.println((bDate.getTime()-dDate.getTime())/(1000*60));
	}
	
	
}
