package com.lj.eshop.eis.controller.shop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.StringUtils;
import com.lj.eshop.dto.FindShopCarPage;
import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.dto.ProductDto;
import com.lj.eshop.dto.ProductSkuDto;
import com.lj.eshop.dto.ShopCarDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.service.IMemberService;
import com.lj.eshop.service.IProductService;
import com.lj.eshop.service.IProductSkuService;
import com.lj.eshop.service.IShopCarService;
import com.lj.eshop.service.IShopService;

/**
 * 
 * 
 * 类说明：购物车对外接口集合
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 * 
 *         CreateDate: 2017年8月31日
 */
@RestController
@RequestMapping("/shopCar")
public class ShopCarController extends BaseController {

	@Autowired
	private IMemberService memberService;
	@Autowired
	private IShopCarService shopCarService;
	@Autowired
	private IProductSkuService productSkuService;
	@Autowired
	private IProductService productService;
	@Autowired
	private IShopService shopService;

	/**
	 * myShop
	 * 
	 * @我的购物车
	 * @param
	 */
	@RequestMapping(value = { "myShopCar" })
	@ResponseBody
	public ResponseDto myShopCar(Integer pageNo, Integer pageSize) {

		MemberDto memberDto = getLoginMember();
		ShopCarDto param = new ShopCarDto();
		param.setMbrCode(memberDto.getCode());
		FindShopCarPage findShopCarPage = new FindShopCarPage();
		findShopCarPage.setParam(param);
		if (pageNo != null) {
			findShopCarPage.setStart((pageNo - 1) * pageSize);
		}
		if (pageSize != null) {
			findShopCarPage.setLimit(pageSize);
		}
		Page<ShopCarDto> page = shopCarService.findShopCarPage(findShopCarPage);

		if (page.getRows().size() <= 0) {
			return ResponseDto.createResp(false, ResponseCode.NO_DATA.getCode(), ResponseCode.NO_DATA.getMsg(), null);
		}
		logger.info("shop --> returnMap(={}) - end", page);
		return ResponseDto.successResp(page);
	}

	/**
	 * 
	 *
	 * 方法说明：加入购物车
	 *
	 * @param param
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月1日
	 *
	 */
	@RequestMapping(value = { "add" })
	@ResponseBody
	public ResponseDto add(String shopCode, String productSkuCode, Integer cnt) {
		logger.info("add -->  - start");
		if (/* StringUtils.isEmpty(shopCode)|| */StringUtils.isEmpty(productSkuCode) || cnt == null || cnt == 0) {
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(),
					null);
		}

		/*
		 * ShopDto parmShopDto = new ShopDto(); parmShopDto.setCode(shopCode); ShopDto
		 * shopDto = shopService.findShop(parmShopDto); if
		 * (shopDto.getStatus().equals(ShopStatus.STOP.getValue())) { return
		 * ResponseDto.createResp(false, ResponseCode.SHOP_UNNORMAL.getCode(),
		 * ResponseCode.SHOP_UNNORMAL.getMsg(), null); }
		 */

		MemberDto memberDto = getLoginMember();
		ShopCarDto shopCarDto = new ShopCarDto();
		shopCarDto.setMbrCode(memberDto.getCode());
		shopCarDto.setCnt(cnt);
		shopCarDto.setProductSkuCode(productSkuCode);
//		shopCarDto.setShopCode(shopCode);

		/* 获取规格库存 */
		ProductSkuDto paramSkuDto = new ProductSkuDto();
		paramSkuDto.setCode(productSkuCode);
		ProductSkuDto productSkuDto = productSkuService.findProductSku(paramSkuDto);

		/* 已存在数量加库存/不存在增加购物车记录 */
		FindShopCarPage findShopCarPage = new FindShopCarPage();
		findShopCarPage.setParam(shopCarDto);
		List<ShopCarDto> carList = shopCarService.findShopCars(findShopCarPage);
		if (carList.size() > 0) {
			ShopCarDto tem = carList.get(0);
			if ((tem.getCnt() + cnt) > productSkuDto.getCnt()) {
				return ResponseDto.createResp(false, ResponseCode.BE_CNT.getCode(), ResponseCode.BE_CNT.getMsg(), null);
			} else {
				tem.setCnt(tem.getCnt() + cnt);
				shopCarService.updateShopCar(tem);
			}
		} else {
			/* 库存不足 */
			if (cnt > productSkuDto.getCnt()) {
				return ResponseDto.createResp(false, ResponseCode.BE_CNT.getCode(), ResponseCode.BE_CNT.getMsg(), null);
			}

			ProductDto paramDto = new ProductDto();
			paramDto.setCode(productSkuDto.getProductCode());
			ProductDto productDto = productService.findProduct(paramDto);

			shopCarDto.setProductCode(productDto.getCode());
			shopCarDto.setProductName(productDto.getName());
			shopCarDto.setImg(productDto.getProductIcon());
			shopCarService.addShopCar(shopCarDto);
		}
		return ResponseDto.successResp(null);
	}

	/**
	 * 
	 *
	 * 方法说明：修改数量
	 *
	 * @param param
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月1日
	 *
	 */
	@RequestMapping(value = { "editCnt" })
	@ResponseBody
	public ResponseDto editCnt(String code, Integer cnt) {
		logger.info("editCnt --> - start");
		if (StringUtils.isEmpty(code) || cnt == null || cnt <= 0) {
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(),
					null);
		}

		ShopCarDto parmDto = new ShopCarDto();
		parmDto.setCode(code);
		ShopCarDto shopCarDto = shopCarService.findShopCar(parmDto);

		ProductSkuDto paramSkuDto = new ProductSkuDto();
		paramSkuDto.setCode(shopCarDto.getProductSkuCode());
		ProductSkuDto productSkuDto = productSkuService.findProductSku(paramSkuDto);

		/* 库存不足 */
		if (cnt > productSkuDto.getCnt()) {
			return ResponseDto.createResp(false, ResponseCode.BE_CNT.getCode(), ResponseCode.BE_CNT.getMsg(), null);
		}

		if (cnt >= 0) {
			shopCarDto.setCnt(cnt);
			shopCarService.updateShopCar(shopCarDto);
		}
		return ResponseDto.successResp(null);
	}

	/**
	 * 
	 *
	 * 方法说明：删除购物车
	 *
	 * @param code
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月1日
	 *
	 */
	@RequestMapping(value = { "del" })
	@ResponseBody
	public ResponseDto del(String code) {
		logger.info("del --> - start");
		if (StringUtils.isEmpty(code)) {
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(),
					null);
		}
		shopCarService.deleteShopCar(code);
		return ResponseDto.successResp(null);
	}

	/**
	 * 
	 *
	 * 方法说明：确认订单页面，从购物车选中获取购物车信息
	 *
	 * @param codes
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月2日
	 *
	 */
	@RequestMapping(value = { "getByIds" })
	@ResponseBody
	public ResponseDto getByIds(String[] codes) {
		logger.info("getByIds --> List<String> codes=" + codes.length + ") - start");
		if (codes == null || codes.length <= 0) {
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(),
					null);
		}
		List<ShopCarDto> returnList = new ArrayList<ShopCarDto>();
		for (String string : codes) {
			ShopCarDto param = new ShopCarDto();
			param.setCode(string);
			FindShopCarPage findShopCarPage = new FindShopCarPage();
			findShopCarPage.setParam(param);
			List<ShopCarDto> list = shopCarService.findShopCars(findShopCarPage);
			if (list != null && list.size() > 0) {
				returnList.add(list.get(0));
			}
		}
		logger.info("shop --> returnMap(={}) - end", returnList);
		return ResponseDto.successResp(returnList);
	}
}
