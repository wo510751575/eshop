package com.lj.eshop.eis.controller.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.DateUtils;
import com.lj.base.core.util.StringUtils;
import com.lj.eoms.entity.sys.Area;
import com.lj.eoms.service.AreaHessianService;
import com.lj.eshop.constant.NoUtil;
import com.lj.eshop.dto.AccWaterDto;
import com.lj.eshop.dto.AccountDto;
import com.lj.eshop.dto.AddrsDto;
import com.lj.eshop.dto.EvlProductDto;
import com.lj.eshop.dto.FindAccWaterPage;
import com.lj.eshop.dto.FindOrderDetailPage;
import com.lj.eshop.dto.FindOrderPage;
import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.dto.MemberRankDto;
import com.lj.eshop.dto.OrderDetailDto;
import com.lj.eshop.dto.OrderDto;
import com.lj.eshop.dto.PaymentDto;
import com.lj.eshop.dto.ProductDto;
import com.lj.eshop.dto.ProductSkuDto;
import com.lj.eshop.dto.ShopCarDto;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.EvlDto;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.emus.AccWaterAccType;
import com.lj.eshop.emus.AccWaterBizType;
import com.lj.eshop.emus.AccWaterPayType;
import com.lj.eshop.emus.AccWaterSource;
import com.lj.eshop.emus.AccWaterStatus;
import com.lj.eshop.emus.AccWaterType;
import com.lj.eshop.emus.DelFlag;
import com.lj.eshop.emus.MemberType;
import com.lj.eshop.emus.OrderStatus;
import com.lj.eshop.emus.PaymentStatus;
import com.lj.eshop.emus.PaymentType;
import com.lj.eshop.service.IAccWaterService;
import com.lj.eshop.service.IAccountService;
import com.lj.eshop.service.IAddrsService;
import com.lj.eshop.service.IEvlProductService;
import com.lj.eshop.service.IMemberRankService;
import com.lj.eshop.service.IMemberService;
import com.lj.eshop.service.IOrderDetailService;
import com.lj.eshop.service.IOrderService;
import com.lj.eshop.service.IPaymentService;
import com.lj.eshop.service.IProductService;
import com.lj.eshop.service.IProductSkuService;
import com.lj.eshop.service.IShopCarService;
import com.lj.eshop.service.IShopService;

/**
 * 
 * 
 * 类说明：订单对外接口集合
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 * 
 *         CreateDate: 2017年9月1日
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

	@Autowired
	private IShopCarService shopCarService;
	@Autowired
	private IShopService shopService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IAddrsService addrsService;
	@Autowired
	private IProductSkuService productSkuService;
	@Autowired
	private IOrderDetailService orderDetailService;
	@Autowired
	private IMemberRankService memberRankService;
	@Autowired
	private IAccWaterService accWaterService;
	@Autowired
	private IAccountService accountService;
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private IProductService productService;
	@Autowired
	private IEvlProductService evlProductService;
	@Autowired
	private AreaHessianService areaHessianService;
	@Autowired
	private IMemberService memberService;

	/**
	 * 
	 *
	 * 方法说明：获取订单详情
	 *
	 * @param code
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月2日
	 *
	 */
	@RequestMapping(value = "/detail")
	public ResponseDto view(String code, String orderNo) {

		if (StringUtils.isEmpty(code) && StringUtils.isEmpty(orderNo)) {
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(),
					null);
		}

		OrderDto orderDto = null;
		if (StringUtils.isNotEmpty(orderNo)) {
			orderDto = orderService.findOrderByOrderNo(orderNo);
		}
		if (StringUtils.isNotEmpty(code)) {
			OrderDto paramDto = new OrderDto();
			paramDto.setCode(code);
			FindOrderPage findOrderPage = new FindOrderPage();
			findOrderPage.setParam(paramDto);
			List<OrderDto> orderDtos = orderService.findOrders(findOrderPage);
			if (orderDtos.size() <= 0) {
				return ResponseDto.createResp(false, ResponseCode.NO_DATA.getCode(), ResponseCode.NO_DATA.getMsg(),
						null);
			}
			orderDto = orderDtos.get(0);
		}
		OrderDetailDto param = new OrderDetailDto();
		param.setOrderNo(orderDto.getOrderNo());
		FindOrderDetailPage findOrderDetailPage = new FindOrderDetailPage();
		findOrderDetailPage.setParam(param);
		orderDto.setDetailDtos(orderDetailService.findOrderDetails(findOrderDetailPage));
		return ResponseDto.successResp(orderDto);
	}

	/**
	 * 
	 *
	 * 方法说明：获取订单明细详情
	 *
	 * @param 订单code code 必填
	 * @return 订单明细code orderDetailCode 必填
	 *
	 * @author 林进权 CreateDate: 2017年9月7日
	 *
	 */
	@RequestMapping(value = "/orderDetail")
	public ResponseDto orderDetail(String code, String orderDetailCode) {
		OrderDto paramDto = new OrderDto();
		paramDto.setCode(code);
		OrderDto orderDto = orderService.findOrder(paramDto);

		OrderDetailDto paramDe = new OrderDetailDto();
		paramDe.setOrderNo(orderDto.getOrderNo());
		paramDe.setCode(orderDetailCode);
		FindOrderDetailPage findOrderDetailPage = new FindOrderDetailPage();
		findOrderDetailPage.setParam(paramDe);
		orderDto.setDetailDtos(orderDetailService.findOrderDetails(findOrderDetailPage));

		return ResponseDto.successResp(orderDto);
	}

	/**
	 * 
	 *
	 * 方法说明：从购物车创建订单
	 *
	 * @param cars
	 * @param addrCode
	 * @param isInvoice
	 * @param invoiceTitle
	 * @param invoiceInfo
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月1日
	 *
	 */
	@RequestMapping(value = { "createByCar" })
	@ResponseBody
	public ResponseDto createByCar(String cars, String addrCode, Boolean isInvoice, String invoiceTitle,
			String invoiceInfo, String remarks) {
		logger.info("createByCar --> - start");
		if (cars == null || StringUtils.isEmpty(cars) || StringUtils.isEmpty(addrCode) || isInvoice == null) {
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(),
					null);
		}

		List<ShopCarDto> shopCarDtos = new ArrayList<ShopCarDto>();

		String[] carss = cars.split(",");
		for (String string : carss) {
			if (StringUtils.isEmpty(string)) {
				continue;
			}
			ShopCarDto paramCar = new ShopCarDto();
			paramCar.setCode(string);
			ShopCarDto shopCarDto = shopCarService.findShopCar(paramCar);
			if (shopCarDto == null) {
				return ResponseDto.createResp(false, ResponseCode.CAR_NOT_EXIST.getCode(),
						ResponseCode.CAR_NOT_EXIST.getMsg(), null);
			}

			/* 不是自己的购物车 */
			if (!shopCarDto.getMbrCode().equals(getLoginMemberCode())) {
				return ResponseDto.createResp(false, ResponseCode.ACCESS_VALID.getCode(),
						ResponseCode.ACCESS_VALID.getMsg(), null);
			}
			shopCarDtos.add(shopCarDto);
		}

		AddrsDto paramAddr = new AddrsDto();
		paramAddr.setCode(addrCode);
		AddrsDto addrsDto = addrsService.findAddrs(paramAddr);
		Area province = areaHessianService.get(addrsDto.getProvinceCode());
		Area city = areaHessianService.get(addrsDto.getCityCode());
		Area area = areaHessianService.get(addrsDto.getAreCode());

		// 获取下单人类型
		String mbrType = getLoginMember().getType();

		List<OrderDto> list = orderService.createByCar(shopCarDtos, addrsDto, isInvoice, invoiceTitle, invoiceInfo,
				remarks, mbrType, province == null ? "" : province.getName(), city == null ? "" : city.getName(),
				area == null ? "" : area.getName());
		return ResponseDto.successResp(list);
	}

	/**
	 * 
	 *
	 * 方法说明：提交订单
	 *
	 * @param skuCode
	 * @param shopCode
	 * @param cnt
	 * @param addrCode
	 * @param isInvoice
	 * @param invoiceTitle
	 * @param invoiceInfo
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月1日
	 *
	 */
	@RequestMapping(value = { "create" })
	@ResponseBody
	public ResponseDto create(String skuCode, String shopCode, Integer cnt, String addrCode, Boolean isInvoice,
			String invoiceTitle, String invoiceInfo, String remarks) {
		logger.info("createByCar --> String skuCode={}- start", skuCode);
//		logger.info("createByCar --> String shopCode={}- start",shopCode);
		logger.info("createByCar --> String cnt={}- start", cnt);
		logger.info("createByCar --> String addrCode={}- start", addrCode);
		logger.info("createByCar --> String isInvoice={}- start", isInvoice);
		logger.info("createByCar --> String invoiceTitle={}- start", invoiceTitle);
		logger.info("createByCar --> String invoiceInfo={}- start", invoiceInfo);
		logger.info("createByCar --> String invoiceInfo={}- start", invoiceInfo);
		if (StringUtils.isEmpty(skuCode) || /* StringUtils.isEmpty(shopCode) || */ StringUtils.isEmpty(addrCode)
				|| isInvoice == null || cnt == null || cnt == 0) {
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(),
					null);
		}

		ProductSkuDto paramDto = new ProductSkuDto();
		paramDto.setCode(skuCode);
		ProductSkuDto productSkuDto = productSkuService.findProductSku(paramDto);

		AddrsDto paramAddr = new AddrsDto();
		paramAddr.setCode(addrCode);
		AddrsDto addrsDto = addrsService.findAddrs(paramAddr);
		Area province = areaHessianService.get(addrsDto.getProvinceCode());
		Area city = areaHessianService.get(addrsDto.getCityCode());
		Area area = areaHessianService.get(addrsDto.getAreCode());

		// 获取下单人类型
		String mbrType = getLoginMember().getType();

		OrderDto orderDto = orderService.createOrder(productSkuDto, shopCode, cnt, addrsDto, isInvoice, invoiceTitle,
				invoiceInfo, remarks, mbrType, province == null ? "" : province.getName(),
				city == null ? "" : city.getName(), area == null ? "" : area.getName());
		return ResponseDto.successResp(orderDto);
	}

	/**
	 * 
	 *
	 * 方法说明：特权提交订单
	 *
	 * @param skuCode
	 * @param shopCode
	 * @param cnt
	 * @param addrCode
	 * @return
	 *
	 * @author 林进权 CreateDate: 2017年9月11日
	 *
	 */
	@RequestMapping(value = { "createByRank" })
	@ResponseBody
	@Deprecated
	public ResponseDto createByRank(String skuCode, String shopCode, Integer cnt, String addrCode, String remarks) {
		logger.info("createByCar --> String skuCode={}- start", skuCode);
		logger.info("createByCar --> String shopCode={}- start", shopCode);
		logger.info("createByCar --> String cnt={}- start", cnt);
		logger.info("createByCar --> String addrCode={}- start", addrCode);

		// 校验不为空
		if (StringUtils.isEmpty(skuCode) || StringUtils.isEmpty(shopCode) || StringUtils.isEmpty(addrCode)
				|| cnt == null || cnt == 0) {
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(),
					null);
		}
		ShopDto paramShopDto = new ShopDto();
		paramShopDto.setCode(getLoginShopCode());
		ShopDto shopDto = shopService.findShop(paramShopDto);
		// 特权未买
		if (null == shopDto || null == shopDto.getRankCode()) {
			return ResponseDto.createResp(false, ResponseCode.MEMBER_RANK_APPLY_NOT_FOUND_BUY.getCode(),
					ResponseCode.MEMBER_RANK_APPLY_NOT_FOUND_BUY.getMsg(), null);
		}

		// 特权过期
		if (shopDto.getRankExpireTime() == null) {
			return ResponseDto.createResp(false, ResponseCode.MEMBER_RANK_APPLY_EXTIRED.getCode(),
					ResponseCode.MEMBER_RANK_APPLY_EXTIRED.getMsg(), null);
		}

		// 特权过期
		long extireTimes = shopDto.getRankExpireTime().getTime() - (new Date().getTime()) / (1000 * 60 * 60 * 24);
		if (extireTimes < 0) {
			return ResponseDto.createResp(false, ResponseCode.MEMBER_RANK_APPLY_EXTIRED.getCode(),
					ResponseCode.MEMBER_RANK_APPLY_EXTIRED.getMsg(), null);
		}

		MemberRankDto param = new MemberRankDto();
		param.setCode(shopDto.getRankCode());
		MemberRankDto memberRankDto = memberRankService.findMemberRank(param);

		// 特权查询不到
		if (null == memberRankDto) {
			return ResponseDto.createResp(false, ResponseCode.MEMBER_RANK_APPLY_NOT_FOUND_BUY.getCode(),
					ResponseCode.MEMBER_RANK_APPLY_NOT_FOUND_BUY.getMsg(), null);
		}

		ProductSkuDto paramDto = new ProductSkuDto();
		paramDto.setCode(skuCode);
		ProductSkuDto productSkuDto = productSkuService.findProductSku(paramDto);

		// 最大金额校验
		BigDecimal totalSalePrice = productSkuDto.getSalePrice().multiply(new BigDecimal(cnt));
		AccountDto accountDto = accountService.findAccountByMbrCode(getLoginMemberCode());
		if (null == accountDto.getRankCashAmt() || totalSalePrice.compareTo(accountDto.getRankCashAmt()) > 0) {
			return ResponseDto.createResp(false, ResponseCode.MEMBER_RANK_APPLY_NOT_YET_AMT.getCode(),
					ResponseCode.MEMBER_RANK_APPLY_NOT_YET_AMT.getMsg() + accountDto.getRankCashAmt() + "元", null);
		}

		// 次数>0，校验次数
		if (memberRankDto.getScale() > 0) {
//			FindAccWaterPage findAccWaterPage = new FindAccWaterPage();
//			AccWaterDto accWaterDto = new AccWaterDto();
//			accWaterDto.setAccDate(new Date());
//			accWaterDto.setAccType(AccWaterAccType.AUTO.getValue());
//			accWaterDto.setAccSource(AccWaterSource.ORDER.getValue());
//			accWaterDto.setStatus(AccWaterStatus.SUCCESS.getValue());
//			accWaterDto.setBizType(AccWaterBizType.PAYMENT.getValue());
//			accWaterDto.setWaterType(AccWaterType.SUBTRACT.getValue());
//			accWaterDto.setPayType(AccWaterPayType.RANK.getValue());
//			accWaterDto.setAccCode(accountDto.getCode());
//			//accWaterDto.setOpCode(getLoginMemberCode());
//			findAccWaterPage.setParam(accWaterDto);
//			List<AccWaterDto> list = accWaterService.findAccWaters(findAccWaterPage);
			List<AccWaterDto> list = findAccwatersByRank();
			if (null != list && list.size() > 0) {
				if (list.size() >= memberRankDto.getScale()) {
					return ResponseDto.createResp(false, ResponseCode.MEMBER_RANK_APPLY_NOT_YET_TIMES.getCode(),
							ResponseCode.MEMBER_RANK_APPLY_NOT_YET_TIMES.getMsg(), null);
				}
			}
		}

		// 校验库存
		if (productSkuDto.getCnt() < cnt) {
			return ResponseDto.createResp(false, ResponseCode.MEMBER_RANK_APPLY_NOT_YET_STORAGE.getCode(),
					ResponseCode.MEMBER_RANK_APPLY_NOT_YET_STORAGE.getMsg(), null);
		}

		AddrsDto paramAddr = new AddrsDto();
		paramAddr.setCode(addrCode);
		AddrsDto addrsDto = addrsService.findAddrs(paramAddr);
		Area province = areaHessianService.get(addrsDto.getProvinceCode());
		Area city = areaHessianService.get(addrsDto.getCityCode());
		Area area = areaHessianService.get(addrsDto.getAreCode());

		// 获取下单人类型
		String mbrType = getLoginUserRole();

		// 创建订单
		OrderDto orderDto = orderService.createOrder(productSkuDto, shopCode, cnt, addrsDto, false, null, null, remarks,
				mbrType, province == null ? "" : province.getName(), city == null ? "" : city.getName(),
				area == null ? "" : area.getName());
		// 流水
		orderService.payment(builPaymentDto(orderDto));
		return ResponseDto.successResp(orderDto);
	}

	/**
	 * 
	 *
	 * 方法说明：B端订单列表
	 *
	 * @param shopCode
	 * @param status
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月2日
	 *
	 */
	@RequestMapping(value = { "list_b" })
	@ResponseBody
	public ResponseDto list_b(String status, Integer pageNo, Integer pageSize) {
		logger.info("list --> String status={}- start", status);

		/*
		 * ShopDto shopDto = getLoginShop(); if (shopDto == null) { return
		 * ResponseDto.createResp(false, ResponseCode.ACCESS_VALID.getCode(),
		 * ResponseCode.ACCESS_VALID.getMsg(), null); }
		 */
		List<String> mbrCodes = memberService.findMemberCodesByInvite(getLoginMemberCode());
		if (mbrCodes == null || mbrCodes.size() == 0) {
			return ResponseDto.successResp();
		}
		OrderDto param = new OrderDto();
//		param.setShopCode(shopDto.getCode());
		param.setMbrCodes(mbrCodes);
		param.setMbrType(MemberType.CLIENT.getValue());
		if (StringUtils.isNotEmpty(status)) {
			param.setStatus(status);
		}
		FindOrderPage findOrderPage = new FindOrderPage();
		findOrderPage.setParam(param);
		if (pageNo != null) {
			findOrderPage.setStart((pageNo - 1) * pageSize);
		}
		if (pageSize != null) {
			findOrderPage.setLimit(pageSize);
		}
		Page<OrderDto> page = orderService.findOrderPage(findOrderPage);
		if (page.getRows().size() == 0) {
			return ResponseDto.createResp(false, ResponseCode.NO_DATA.getCode(), ResponseCode.NO_DATA.getMsg(), null);
		}
		/* 获取订单详情 */
		for (OrderDto orderDto : page.getRows()) {
			OrderDetailDto paramDe = new OrderDetailDto();
			paramDe.setOrderNo(orderDto.getOrderNo());
			FindOrderDetailPage findOrderDetailPage = new FindOrderDetailPage();
			findOrderDetailPage.setParam(paramDe);
			orderDto.setDetailDtos(orderDetailService.findOrderDetails(findOrderDetailPage));
		}
		return ResponseDto.successResp(page);
	}

	/***
	 * 
	 *
	 * 方法说明：C端订单列表
	 *
	 * @param status
	 * @param pageNo
	 * @param pageSize
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月6日
	 *
	 */
	@RequestMapping(value = { "list_c" })
	@ResponseBody
	public ResponseDto list_c(String status, Integer pageNo, Integer pageSize) {
		logger.info("list --> String status={}- start", status);

		MemberDto memberDto = getLoginMember();
		if (memberDto == null) {
			return ResponseDto.createResp(false, ResponseCode.ACCESS_VALID.getCode(),
					ResponseCode.ACCESS_VALID.getMsg(), null);
		}
		OrderDto param = new OrderDto();
		param.setMbrCode(memberDto.getCode());
		if (StringUtils.isNotEmpty(status)) {
			param.setStatus(status);
		}
		FindOrderPage findOrderPage = new FindOrderPage();
		findOrderPage.setParam(param);
		if (pageNo != null) {
			findOrderPage.setStart((pageNo - 1) * pageSize);
		}
		if (pageSize != null) {
			findOrderPage.setLimit(pageSize);
		}
		Page<OrderDto> page = orderService.findOrderPage(findOrderPage);
		if (page.getRows().size() == 0) {
			return ResponseDto.createResp(false, ResponseCode.NO_DATA.getCode(), ResponseCode.NO_DATA.getMsg(), null);
		}
		/* 获取订单详情 */
		for (OrderDto orderDto : page.getRows()) {
			OrderDetailDto paramDe = new OrderDetailDto();
			paramDe.setOrderNo(orderDto.getOrderNo());
			FindOrderDetailPage findOrderDetailPage = new FindOrderDetailPage();
			findOrderDetailPage.setParam(paramDe);
			orderDto.setDetailDtos(orderDetailService.findOrderDetails(findOrderDetailPage));
		}
		return ResponseDto.successResp(page);
	}

	/**
	 * 
	 *
	 * 方法说明：确认收货
	 *
	 * @param code
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月2日
	 *
	 */
	@RequestMapping(value = { "receipt" })
	@ResponseBody
	public ResponseDto receipt(String code) {
		logger.info("receipt --> String code={}- start", code);
		if (StringUtils.isEmpty(code)) {
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(),
					null);
		}

		MemberDto memberDto = getLoginMember();
		if (memberDto == null) {
			return ResponseDto.createResp(false, ResponseCode.ACCESS_VALID.getCode(),
					ResponseCode.ACCESS_VALID.getMsg(), null);
		}

		OrderDto parmDto = new OrderDto();
		parmDto.setCode(code);
		OrderDto orderDto = orderService.findOrder(parmDto);
		if (orderDto.getStatus().equals(OrderStatus.SHIPPED.getValue())) {
			orderService.complete(orderDto);
		}
		return ResponseDto.successResp(null);
	}

	/**
	 * 
	 *
	 * 方法说明：取消订单
	 *
	 * @param code
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月2日
	 *
	 */
	@RequestMapping(value = { "cancel" })
	@ResponseBody
	public ResponseDto cancel(String code) {
		logger.info("cancel --> String code={}- start", code);
		if (StringUtils.isEmpty(code)) {
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(),
					null);
		}
		MemberDto memberDto = getLoginMember();
		if (memberDto == null) {
			return ResponseDto.createResp(false, ResponseCode.ACCESS_VALID.getCode(),
					ResponseCode.ACCESS_VALID.getMsg(), null);
		}
		OrderDto parmDto = new OrderDto();
		parmDto.setCode(code);
		OrderDto orderDto = orderService.findOrder(parmDto);
		orderService.cancel(orderDto);
		return ResponseDto.successResp(null);
	}

	private PaymentDto builPaymentDto(OrderDto orderDto) {
		/* 获取账户 */
		AccountDto accountDto = accountService.findAccountByMbrCode(orderDto.getMbrCode());
		PaymentDto paymentDto = new PaymentDto();
		paymentDto.setAccCode(accountDto.getCode());
		paymentDto.setFee(new BigDecimal(0));
		paymentDto.setOperator(getLoginMemberCode());
		paymentDto.setPayer(orderDto.getMbrCode());
		paymentDto.setPaymentDate(new Date());
		paymentDto.setPaymentMethod(AccWaterPayType.RANK.getValue());
		paymentDto.setSn(NoUtil.generateNo(NoUtil.JY));
		paymentDto.setStatus(PaymentStatus.SUCCESS.getValue());
		paymentDto.setType(PaymentType.OFFLINE.getValue());
		paymentDto.setMbrCode(orderDto.getMbrCode());
		paymentDto.setBizNo(orderDto.getOrderNo());
		paymentDto.setDelFlag(DelFlag.N.getValue());
		paymentDto.setAmount(orderDto.getAmt());
		paymentDto.setAccSource(AccWaterSource.ORDER.getValue());
		paymentService.addPayment(paymentDto);
		return paymentDto;
	}

	/**
	 * 
	 *
	 * 方法说明：订单评论
	 *
	 * @param jsonStr
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月2日
	 *
	 */
	@RequestMapping(value = { "review" })
	@ResponseBody
	public ResponseDto review(String jsonStr) {
		logger.info("review --> String jsonStr=" + jsonStr + "{}- start");

		if (StringUtils.isEmpty(jsonStr)) {
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(),
					null);
		}

		/* 获取评论人 */
		MemberDto parmMemberDto = new MemberDto();
		parmMemberDto.setCode(getLoginMember().getCode());
		MemberDto memberDto = memberService.findMember(parmMemberDto);
		jsonStr = jsonStr.replaceAll("\"", "'");

		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		if (!jsonObject.containsKey("orderCode") && !jsonObject.containsKey("evlDtos")) {
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(),
					null);
		}

		String orderCode = JSONObject.parseObject(jsonStr).getString("orderCode");
		OrderDto parmDto = new OrderDto();
		parmDto.setCode(orderCode);
		OrderDto orderDto = orderService.findOrder(parmDto);
		orderService.review(orderDto);

		JSONArray evlDtos = JSONObject.parseObject(jsonStr).getJSONArray("evlDtos");
		for (int i = 0; i < evlDtos.size(); i++) {
			JSONObject evl = evlDtos.getJSONObject(i);
			String grade = evl.containsKey("grade") ? evl.getString("grade") : "0";
			String info = evl.containsKey("info") ? evl.getString("info") : "";
			String imgs = evl.containsKey("imgs") ? evl.getString("imgs") : "";
			String skuCode = evl.containsKey("skuCode") ? evl.getString("skuCode") : "";

			/* 获取规格商品 */
			ProductSkuDto paramSkuDto = new ProductSkuDto();
			paramSkuDto.setCode(skuCode);
			ProductSkuDto productSkuDto = productSkuService.findProductSku(paramSkuDto);

			/* 获取商品 */
			ProductDto parProductDto = new ProductDto();
			parProductDto.setCode(productSkuDto.getProductCode());
			ProductDto productDto = productService.findProduct(parProductDto);

			EvlProductDto evlProductDto = new EvlProductDto();
			evlProductDto.setEvlGrade(grade);
			evlProductDto.setEvlInfo(info);
			evlProductDto.setEvlMbrCode(memberDto.getCode());
			evlProductDto.setEvlMbrImg(memberDto.getAvotor());
			evlProductDto.setEvlMbrName(memberDto.getName());
			evlProductDto.setGoodCnt(0);
			evlProductDto.setImgs(imgs);
			evlProductDto.setProductCode(productSkuDto.getProductCode());
			evlProductDto.setProductName(productDto.getName());
			evlProductDto.setProductSkuCode(skuCode);
			evlProductDto.setSkuDesc(productSkuDto.getSkuDesc());
			evlProductService.addEvlProduct(evlProductDto);

			/* 修改商品总评分和评论数 */
			productDto.setTotalScore(productDto.getTotalScore() + Integer.valueOf(evlProductDto.getEvlGrade()));
			productDto.setEvlCnt(productDto.getEvlCnt() + 1);
			productService.updateProduct(productDto);

		}
		return ResponseDto.successResp(null);
	}

	/**
	 * 查询一年内的特权购买流水 方法说明：
	 *
	 * @param @return 设定文件
	 * @return List<AccWaterDto> 返回类型
	 * @throws Exception
	 *
	 * @author 林进权 CreateDate: 2017年9月27日
	 */
	private List<AccWaterDto> findAccwatersByRank() {
		AccountDto accountDto = accountService.findAccountByMbrCode(getLoginMemberCode());
		FindAccWaterPage findAccWaterPage = new FindAccWaterPage();
		AccWaterDto accWaterDto = new AccWaterDto();
		accWaterDto.setAccDate(new Date());
		accWaterDto.setAccType(AccWaterAccType.AUTO.getValue());
		accWaterDto.setAccSource(AccWaterSource.ORDER.getValue());
		accWaterDto.setStatus(AccWaterStatus.SUCCESS.getValue());
		accWaterDto.setBizType(AccWaterBizType.PAYMENT.getValue());
		accWaterDto.setWaterType(AccWaterType.SUBTRACT.getValue());
		accWaterDto.setPayType(AccWaterPayType.RANK.getValue());
		accWaterDto.setAccCode(accountDto.getCode());

		// 一年内的购买记录
		Date endDate = new Date();
		Date startDate = DateUtils.addYears(endDate, -1);
		findAccWaterPage.setStartTime(startDate);
		findAccWaterPage.setEndTime(endDate);

		findAccWaterPage.setParam(accWaterDto);
		return accWaterService.findAccWaters(findAccWaterPage);
	}

	public static void main(String[] args) {
		EvlDto evlDto = new EvlDto();
		evlDto.setGrade(1);
		evlDto.setImgs("/eoms/a.jpg,/eomg/b.png");
		evlDto.setSkuCode("aaaaaaaa");
		evlDto.setInfo("评价");
		List<EvlDto> list = new ArrayList<EvlDto>();
		list.add(evlDto);
		evlDto = new EvlDto();
		evlDto.setGrade(1);
		evlDto.setImgs("/eoms/a.jpg,/eomg/b.png");
		evlDto.setSkuCode("aaaaaaaa");
		evlDto.setInfo("评价");
		list.add(evlDto);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderCode", "orderCode");
		map.put("evlDtos", list);
		System.out.println(JSONObject.toJSON(map));

//		String json = "{'evlDtos':[{'grade':1,'imgs':'/eoms/a.jpg,/eomg/b.png','info':'评价','skuCode':'aaaaaaaa'},{'grade':1,'imgs':'/eoms/a.jpg,/eomg/b.png','info':'评价','skuCode':'aaaaaaaa'}],'orderCode':'LJ_06788b89f5924e0aaa8b738b92829698'}";

	}
}
