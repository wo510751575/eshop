package com.lj.eshop.eis.controller.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.StringUtils;
import com.lj.eshop.constant.NoUtil;
import com.lj.eshop.dto.CustOrderDto;
import com.lj.eshop.dto.FindCustOrderPage;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.emus.OrderStatus;
import com.lj.eshop.service.ICustOrderService;


/**
 * 
 * 
 * 类说明：定制订单
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 彭俊霖
 *   
 * CreateDate: 2017年9月6日
 */
@RestController
@RequestMapping("/custOrder")
public class CustOrderController extends BaseController{
	
	@Autowired
	private ICustOrderService custOrderService;
	
	/**
	 * 
	 *
	 * 方法说明：获取订制订单历史
	 *
	 * @param shopCode 店铺code
	 * @return
	 *
	 * @author 彭俊霖 CreateDate: 2017年9月7日
	 *
	 */
	@RequestMapping(value = "/history")
	public ResponseDto view(CustOrderDto custOrderDto,Integer pageNo,Integer pageSize) { 
		
		FindCustOrderPage findCustOrderPage = new FindCustOrderPage();
		logger.debug("CustOrderController --> list() - start", findCustOrderPage); 
		
		if(custOrderDto==null){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		if(pageNo!=null){
			findCustOrderPage.setStart((pageNo-1)*pageSize);
		}
		if(pageSize!=null){
			findCustOrderPage.setLimit(pageSize);
		}
		//根据当前店铺code查询
		custOrderDto.setShopCode(getLoginShopCode());
		findCustOrderPage.setParam(custOrderDto);
		Page<CustOrderDto> custOrders=custOrderService.findCustOrderPage(findCustOrderPage);
		List<CustOrderDto> list = new ArrayList<CustOrderDto>();
		list.addAll(custOrders.getRows());
		
		if(custOrders.getRows()==null || list.size()<=0){
			return ResponseDto.createResp(false, ResponseCode.NO_DATA.getCode(), ResponseCode.NO_DATA.getMsg(), null);
		}
		logger.debug("CustOrderController --> list(={}) - end", list);
		return ResponseDto.successResp(custOrders);
	}
	
	/**
	 * 
	 *
	 * 方法说明：获取订制订单详情
	 *
	 * @param code 定制订单code
	 * @return
	 *
	 * @author 彭俊霖 CreateDate: 2017年9月12日
	 *
	 */
	@RequestMapping(value = "/detail")
	public ResponseDto detail(CustOrderDto custOrderDto) { 
		
		FindCustOrderPage findCustOrderPage = new FindCustOrderPage();
		logger.debug("CustOrderController --> detail() - start", findCustOrderPage); 
		
		if(custOrderDto==null||StringUtils.isEmpty(custOrderDto.getCode())){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		//根据当前code查询
		findCustOrderPage.setParam(custOrderDto);
		Page<CustOrderDto> custOrders=custOrderService.findCustOrderPage(findCustOrderPage);
		List<CustOrderDto> list = new ArrayList<CustOrderDto>();
		list.addAll(custOrders.getRows());
		
		if(custOrders.getRows()==null || list.size()<=0){
			return ResponseDto.createResp(false, ResponseCode.NO_DATA.getCode(), ResponseCode.NO_DATA.getMsg(), null);
		}
		logger.debug("CustOrderController --> detail(={}) - end", list);
		return ResponseDto.successResp(custOrders);
	}
	
	/**
	 * 方法说明： 订制订单添加
	 * 
	 * @author 彭俊霖
	 *         CreateDate: 2017年9月7日
	 */
	@RequestMapping(value = {"add"})
	@ResponseBody
	public ResponseDto add(CustOrderDto custOrderDto) {
		logger.debug("CustOrderController --> add() - start", custOrderDto); 
		if(custOrderDto==null){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		//设置属性
		List<String> imgs=new ArrayList<>();
		if(StringUtils.isNotEmpty(custOrderDto.getImg1())){
			imgs.add(custOrderDto.getImg1());
		}
		if(StringUtils.isNotEmpty(custOrderDto.getImg2())){
			imgs.add(custOrderDto.getImg2());
		}
		if(StringUtils.isNotEmpty(custOrderDto.getImg3())){
			imgs.add(custOrderDto.getImg3());
		}
		if(StringUtils.isNotEmpty(custOrderDto.getImg4())){
			imgs.add(custOrderDto.getImg4());
		}
		if(StringUtils.isNotEmpty(custOrderDto.getImg5())){
			imgs.add(custOrderDto.getImg5());
		}
		if(StringUtils.isNotEmpty(custOrderDto.getImg6())){
			imgs.add(custOrderDto.getImg6());
		}
		String join = org.apache.commons.lang.StringUtils.join(imgs, ",");
		custOrderDto.setImg1(join);
		custOrderDto.setCreateTime(new Date());
		custOrderDto.setOrderNo(NoUtil.generateNo(NoUtil.JY));
		custOrderDto.setMerchantCode(getLoginMerchantCode());
		custOrderDto.setStatus(OrderStatus.UNPAID.getValue());
		custOrderDto.setMbrCode(getLoginMemberCode());
		custOrderDto.setShopCode(getLoginShopCode());
		if(getLoginShop()!=null){
			custOrderDto.setShopName(getLoginShop().getShopName());
		}
		custOrderService.addCustOrder(custOrderDto);
		logger.debug("CustOrderController --> add(={}) - end");
		return ResponseDto.createResp(Boolean.TRUE, "", "新增成功", null);
	}
	
	/**
	 * 方法说明： 订制订单更新
	 * @author 彭俊霖
	 *         CreateDate: 2017年9月7日
	 */
	@RequestMapping(value = {"update"})
	@ResponseBody
	public ResponseDto update(CustOrderDto custOrderDto) {
		logger.debug("CustOrderController --> update() - start", custOrderDto); 
		if(custOrderDto==null || StringUtils.isEmpty(custOrderDto.getCode())
				|| custOrderDto.getOrgPrice()==null){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		//设置属性
		custOrderDto.setUpdateTime(new Date());
		custOrderService.updateCustOrder(custOrderDto);
		logger.debug("CustOrderController --> update() - end", custOrderDto); 
		return ResponseDto.successResp(custOrderDto);
	}
	
}
