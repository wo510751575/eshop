package com.lj.eshop.eis.controller.shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.pagination.PageSortType;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.eshop.constant.NoUtil;
import com.lj.eshop.dto.AccWaterDto;
import com.lj.eshop.dto.AddrsDto;
import com.lj.eshop.dto.FindAccWaterPage;
import com.lj.eshop.dto.FindMemberPage;
import com.lj.eshop.dto.FindMerchantSettingPage;
import com.lj.eshop.dto.FindMyAttentionPage;
import com.lj.eshop.dto.FindPaymentPage;
import com.lj.eshop.dto.FindShopBgImgPage;
import com.lj.eshop.dto.FindShopPage;
import com.lj.eshop.dto.FindShopProductPage;
import com.lj.eshop.dto.FindShopStylePage;
import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.dto.MerchantSettingDto;
import com.lj.eshop.dto.MessageDto;
import com.lj.eshop.dto.MyAttentionDto;
import com.lj.eshop.dto.PaymentDto;
import com.lj.eshop.dto.ProductDto;
import com.lj.eshop.dto.ShopBgImgDto;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.dto.ShopProductDto;
import com.lj.eshop.dto.ShopStyleDto;
import com.lj.eshop.eis.constant.ProductConstant;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.eis.service.IUserLoginService;
import com.lj.eshop.eis.utils.AuthCodeUtils;
import com.lj.eshop.emus.AccWaterAccType;
import com.lj.eshop.emus.AccWaterSource;
import com.lj.eshop.emus.AccWaterStatus;
import com.lj.eshop.emus.AccWaterType;
import com.lj.eshop.emus.CodeCheckBizType;
import com.lj.eshop.emus.DelFlag;
import com.lj.eshop.emus.MerchantSettingStatus;
import com.lj.eshop.emus.MessageTemplate;
import com.lj.eshop.emus.MyAttentionStatus;
import com.lj.eshop.emus.MyCollStatus;
import com.lj.eshop.emus.PaymentStatus;
import com.lj.eshop.emus.PaymentType;
import com.lj.eshop.emus.ProductStatus;
import com.lj.eshop.emus.ProductYN;
import com.lj.eshop.emus.ShopGrade;
import com.lj.eshop.emus.ShopStatus;
import com.lj.eshop.emus.Status;
import com.lj.eshop.service.IAccWaterService;
import com.lj.eshop.service.IAddrsService;
import com.lj.eshop.service.IMemberService;
import com.lj.eshop.service.IMerchantSettingService;
import com.lj.eshop.service.IMessageService;
import com.lj.eshop.service.IMyAttentionService;
import com.lj.eshop.service.IMyCollService;
import com.lj.eshop.service.IPaymentService;
import com.lj.eshop.service.IProductService;
import com.lj.eshop.service.IShopBgImgService;
import com.lj.eshop.service.IShopProductService;
import com.lj.eshop.service.IShopService;
import com.lj.eshop.service.IShopStyleService;
/**
 * 
 * 
 * 类说明：店铺对外接口集合
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月31日
 */
@RestController
@RequestMapping("/shop")
public class ShopController extends BaseController{
	
	@Autowired
	private IShopBgImgService bgImgService;
	@Autowired
	private IShopStyleService shopStyleService;
	@Autowired
	private IShopService shopService;
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private IShopProductService shopProductService;
	@Autowired
	private IMyAttentionService myAttentionService;
	@Autowired
	private IUserLoginService userLoginService;
	@Autowired
	private IAccWaterService iAccWaterService;
	@Autowired
	private IMemberService memberService;
	@Autowired
	private IAddrsService addrsService;
	@Autowired
	private IMessageService messageService;
	@Autowired
	private IMerchantSettingService merchantSettingService;
	@Autowired
	private IMyCollService myCollService;
	@Autowired
	private IProductService productService;
	@Autowired
	private IShopBgImgService shopBgImgService;
	
	
	/**
	 * 
	 *
	 * 方法说明：获取门店信息
	 *
	 * @param code
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月2日
	 *
	 */
	@RequestMapping(value = "/detail")
	public ResponseDto  detail(String code) {
		ShopDto parmShopDto = new ShopDto();
		parmShopDto.setCode(code);
		ShopDto shopDto= shopService.findShop(parmShopDto);
		return ResponseDto.successResp(shopDto);
	}
	
	/**
	 * myShop
	 * @我的店铺-B端
	 * @param 
	 */
	@RequestMapping(value = {"myShop"})
	@ResponseBody
	public ResponseDto myShop(Integer pageNo,Integer pageSize) {
			
			ShopDto param = new ShopDto();
			param.setCode(getLoginShopCode());
			FindShopPage findShopPage =new FindShopPage();
			findShopPage.setParam(param);
			List<ShopDto> list = shopService.findShops(findShopPage);
			if(list.size()<=0){
				return ResponseDto.createResp(false, ResponseCode.NO_DATA.getCode(), ResponseCode.NO_DATA.getMsg(), null);
			}
			
			ShopDto shopDto = list.get(0);
			
			/*店铺商品*/
			FindShopProductPage findShopProductPage = new FindShopProductPage();
			if(pageNo!=null){
				findShopProductPage.setStart((pageNo-1)*pageSize);
			}
			if(pageSize!=null){
				findShopProductPage.setLimit(pageSize);
			}
			ShopProductDto proParam = new ShopProductDto();
			proParam.setShopCode(shopDto.getCode());
			proParam.setStatus(ProductStatus.USE.getValue());
			findShopProductPage.setParam(proParam);
			Page<ShopProductDto> page= shopProductService.findIndexShopProductPage(findShopProductPage);
			Map<String,Object> returnMap = new HashMap<String,Object>();
			returnMap.put("shop", shopDto);
			returnMap.put("productList",page);
			
			logger.debug("myShop --> returnMap(={}) - end",returnMap);
			return ResponseDto.successResp(returnMap);
	}
	
	/**
	 * editShop
	 * @编辑店铺
	 * @param 
	 */
	@RequestMapping(value = {"editShop"})
	@ResponseBody
	public ResponseDto editShop(ShopDto param) {
		logger.debug("editShop --> String param(={}) - start",param);
		if(StringUtils.isEmpty(param.getCode())){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		shopService.updateShop(param);
		return ResponseDto.successResp(null);
	}
	/**
	 * 
	 *
	 * 方法说明：门店背景图列表
	 *
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月26日
	 *
	 */
	@RequestMapping(value = {"bgimgList"})
	@ResponseBody
	public ResponseDto bgimgList() {
		logger.debug("bgimgList --> - start");
		ShopBgImgDto param = new ShopBgImgDto();
		param.setStatus(Status.USE.getValue());
		FindShopBgImgPage findShopBgImgPage =new FindShopBgImgPage();
		findShopBgImgPage.setParam(param);
		List<ShopBgImgDto> list = bgImgService.findShopBgImgs(findShopBgImgPage);
		logger.debug("bgimgList --> - end",list);
		return ResponseDto.successResp(list);
	}
	
	/**
	 * 
	 *
	 * 方法说明：门店背景图列表
	 *
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月26日
	 *
	 */
	@RequestMapping(value = {"styleList"})
	@ResponseBody
	public ResponseDto styleList() {
		logger.debug("styleList --> styleList(={}) - start");
		ShopStyleDto param = new ShopStyleDto();
		param.setStatus(Status.USE.getValue());
		FindShopStylePage findShopStylePage =new FindShopStylePage();
		findShopStylePage.setParam(param);
		List<ShopStyleDto> list = shopStyleService.findShopStyles(findShopStylePage);
		logger.debug("styleList --> styleList(={}) - end",list);
		return ResponseDto.successResp(list);
	}
	
	/**
	 * 
	 *
	 * 方法说明：店铺商品上下架
	 *
	 * @param param
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月31日
	 *
	 */
	@RequestMapping(value = {"productStatus"})
	@ResponseBody
	public ResponseDto productStatus(ShopProductDto param) {
		logger.debug("productStatus -->(ShopProductDto param={}) - start",param);
		if(StringUtils.isEmpty(param.getProductCode()) || StringUtils.isEmpty(param.getStatus())){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		
		ShopDto shopDto = getLoginShop();
		param.setShopCode(shopDto.getCode());
		ShopProductDto shopProductDto= shopProductService.findByShopCodeAndProCode(param);
		if(shopProductDto!=null){
			shopProductDto.setStatus(param.getStatus());
			shopProductService.updateShopProduct(shopProductDto);
		}else{
			shopProductService.addShopProduct(param);
		}
		
		/*上架，商品在售人数+1*/
		ProductDto parmProductDto = new ProductDto();
		parmProductDto.setCode(param.getProductCode());
		ProductDto productDto= productService.findProduct(parmProductDto);
		if(param.getStatus().equals(ProductYN.Y.getValue())){
			productDto.setSaleShopCnt(productDto.getSaleShopCnt()+1);
			productService.updateProduct(productDto);
		}else{
			if(productDto.getSaleShopCnt()>0){
				productDto.setSaleShopCnt(productDto.getSaleShopCnt()-1);
				productService.updateProduct(productDto);
			}
		}
		return ResponseDto.successResp(null);
	}
	
	
	/**
	 * 
	 *
	 * 方法说明：C端，我关注的店铺列表
	 *
	 * @param mbrCode
	 * @param limit
	 * @param start
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月2日
	 *
	 */
	@RequestMapping(value = {"myAttentionList"})
	@ResponseBody
	public ResponseDto myAttentionList() {
			
		MyAttentionDto param = new MyAttentionDto();
		param.setMbrCode(getLoginMemberCode());
		FindMyAttentionPage findMyAttentionPage = new FindMyAttentionPage();
		findMyAttentionPage.setParam(param);
		List<MyAttentionDto> list= myAttentionService.findMyAttentions(findMyAttentionPage);
		
		/*获取店铺商品两件*/
		for (MyAttentionDto myAttentionDto : list) {
			/*获取店铺*/
			ShopDto parmShopDto = new ShopDto();
			parmShopDto.setCode(myAttentionDto.getShopCode());
			ShopDto shopDto=shopService.findShop(parmShopDto);
			myAttentionDto.setShopImg(shopDto.getImg());
			myAttentionDto.setShopName(shopDto.getShopName());
			
			FindShopProductPage findShopProductPage = new FindShopProductPage();
			findShopProductPage.setLimit(2);
			ShopProductDto proParam = new ShopProductDto();
			proParam.setShopCode(myAttentionDto.getShopCode());
			proParam.setStatus(ProductStatus.USE.getValue());
			findShopProductPage.setParam(proParam);
			Page<ShopProductDto> page= shopProductService.findIndexShopProductPage(findShopProductPage);
			List<ShopProductDto> proList = new ArrayList<ShopProductDto>();
			proList.addAll(page.getRows());
			myAttentionDto.setShopProductDtos(proList);
		}
		logger.debug("myAttentionList --> returnMap(={}) - end",list);
		return ResponseDto.successResp(list);
	}
	
	
	/**
	 * 
	 *
	 * 方法说明：C端-店铺商品列表
	 *
	 *@param code 微信code 获取会员信息
	 * @param shopCode
	 * @param limit
	 * @param start
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月2日
	 *
	 */
	@RequestMapping(value = {"shopProduct"})
	@ResponseBody
	public ResponseDto shopProduct(String shopCode,Integer limit,Integer start,String sortBy) {
			logger.info("shopProduct --> String shopCode(={}) - start",shopCode);
			if(StringUtils.isEmpty(shopCode)){
				return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
			}
			
			ShopDto param = new ShopDto();
			param.setCode(shopCode);
			FindShopPage findShopPage =new FindShopPage();
			findShopPage.setParam(param);
			List<ShopDto> list = shopService.findShops(findShopPage);
			if(list.size()<=0){
				return ResponseDto.createResp(false, ResponseCode.NO_DATA.getCode(), ResponseCode.NO_DATA.getMsg(), null);
			}
			ShopDto shopDto =list.get(0);
			/*店铺商品*/
			FindShopProductPage findShopProductPage = new FindShopProductPage();
			if(ProductConstant.SORT_TYPE_TJ.equals(sortBy)){
				findShopProductPage.setSortDir(null);//推荐无需指定排序
			}else if(findShopProductPage.getSortDir()==null){
				findShopProductPage.setSortDir(PageSortType.desc);//默认降序
			}
			if(limit!=null){
				findShopProductPage.setLimit(limit);
			}
			if(start!=null){
				findShopProductPage.setStart(start);
			}
			ShopProductDto proParam = new ShopProductDto();
			proParam.setShopCode(shopCode);
			proParam.setStatus(ProductStatus.USE.getValue());
			findShopProductPage.setParam(proParam);
			Page<ShopProductDto> page= shopProductService.findIndexShopProductPage(findShopProductPage);
			Map<String,Object> returnMap = new HashMap<String,Object>();
			returnMap.put("shop",shopDto);
			returnMap.put("productList",page);
			
			if(!StringUtils.isEmpty(getLoginMemberCode())){
				MemberDto parmMemberDto = new MemberDto();
				parmMemberDto.setCode(getLoginMemberCode());
				MemberDto memberDto= memberService.findMember(parmMemberDto);
				/*如果不是店主自己打开*/
				if(!shopDto.getMbrCode().equals(memberDto.getCode())){
					/*访问量+1*/
					shopDto.setReadNum(shopDto.getReadNum()+1);
					shopService.updateShop(shopDto);
					/*关注店铺*/
					attention(memberDto, shopCode);
				}
			}
			
			logger.debug("shop --> returnMap(={}) - end",returnMap);
			return ResponseDto.successResp(returnMap);
	}
	
	/**
	 * 方法说明：查询商品是否上架到店铺,是否收藏。
	 *
	 * @param code 商品code
	 * @return
	 *
	 * @author lhy  2017年9月5日
	 *
	 */
	@RequestMapping(value = {"/product/status/find"},method=RequestMethod.POST)
	@ResponseBody
	public ResponseDto findProductStatus(String code) {
		logger.debug("productStatus -->(ShopProductDto param={}) - start",code);
		if(StringUtils.isEmpty(code)){
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		ShopProductDto param =new ShopProductDto();
		param.setProductCode(code);
		param.setShopCode(getLoginShopCode());
		ShopProductDto shopProductDto= shopProductService.findByShopCodeAndProCode(param);
		String status=ProductStatus.STOP.getValue();
		if(shopProductDto!=null  && ProductStatus.USE.getValue().equals(shopProductDto.getStatus())){
			status=ProductStatus.USE.getValue();
		}else{
			status=ProductStatus.STOP.getValue();
		}
		Map<String , Object> data=new HashMap<>();
		data.put("status", status);
		String collStatus=MyCollStatus.STOP_COLL.getValue();//是否收藏状态: 0:未收藏 ; 1:已收藏
		Integer hasColl = myCollService.getCollStatus(code,getLoginMemberCode());
		if(hasColl>0){
			collStatus=MyCollStatus.USE_COLL.getValue();//已收藏
		}else{
			collStatus=MyCollStatus.STOP_COLL.getValue();//未收藏
		}
		data.put("collStatus", collStatus);
		logger.debug("shop --> status(={}) - end",data);
		return ResponseDto.successResp(data);
	}
	
	
	private void attention(MemberDto memberDto,String shopCode){
		/*获取关注信息*/
		MyAttentionDto param = new MyAttentionDto();
		param.setMbrCode(memberDto.getCode());
		param.setShopCode(shopCode);
		FindMyAttentionPage findMyAttentionPage = new FindMyAttentionPage();
		findMyAttentionPage.setParam(param);
		List<MyAttentionDto> list= myAttentionService.findMyAttentions(findMyAttentionPage);
		/*存在*/
		if(list.size()>0){
			MyAttentionDto myAttentionDto = list.get(0);
			/*如果已经关注了，不处理*/
			if(myAttentionDto.getStatus().equals(MyAttentionStatus.Y.getValue())){
				return ;
			}
			myAttentionDto.setStatus(MyAttentionStatus.Y.getValue());
			myAttentionService.updateMyAttention(myAttentionDto);
		}else{
			
			/*获取店铺信息*/
			ShopDto parmShop = new ShopDto();
			parmShop.setCode(shopCode);
			ShopDto shopDto= shopService.findShop(parmShop);
			
			MyAttentionDto myAttentionDto = new MyAttentionDto();	
			myAttentionDto.setMbrCode(memberDto.getCode());
			myAttentionDto.setMbrName(memberDto.getName());
			myAttentionDto.setShopCode(shopCode);
			myAttentionDto.setShopName(shopDto.getShopName());
			myAttentionDto.setShopImg(shopDto.getImg());
			myAttentionDto.setStatus(MyAttentionStatus.Y.getValue());
			myAttentionService.addMyAttention(myAttentionDto);
		}
	}
	
	/**
	 * 开始发送验证码：调用接口/sms/send  入参bizType=4, revicerPhone手机号
	 * 开店第一步,校验验证码
	 * 方法说明：
	 * @param mobilePhone    手机号 
	 * @param mobilePhone    手机号 
	 * @param authCode    验证码
	 * @return 校验通过后，返回商店支付编号： 支付时需要用到shopNo
	 * @author 林进权
	 *         CreateDate: 2017年9月7日
	 */
	@RequestMapping(value = {"openShopOne"})
	@ResponseBody
	public ResponseDto openShopOne(String mobilePhone, String authCode) {
		logger.debug("openStoreOne --> openStoreOne(={}) - start");
		
		if(StringUtils.isEmpty(getLoginMember().getMerchantCode()) || StringUtils.isEmpty(mobilePhone) || StringUtils.isEmpty(authCode) ) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		
		//校验验证码
		AuthCodeUtils.validAuthCode(mobilePhone,
				CodeCheckBizType.OPEN_SHOP.getValue(),
				authCode, AuthCodeUtils.AUTH_CODE_VALID_TIME);
		
		//更新手机信息
		MemberDto findM = new MemberDto();
		findM.setPhone(mobilePhone);
		FindMemberPage findMemberPage = new FindMemberPage();
		findMemberPage.setParam(findM);
		logger.debug("openStoreOne --> openStoreOne param(={}) - start", findMemberPage);
		List<MemberDto> ms = memberService.findMembers(findMemberPage);
		if(null!=ms) {
			//如果>1，电话已被其它人使用
			if(ms.size()>1) {
				return ResponseDto.getErrorResponse(ResponseCode.OPEN_SHOP_VALID_PHONE_SHOP_ERROR);
			}
			
			if(ms.size()==1) {
				//如果会员code和自己不一致，电话已被其它人使用
				if(!StringUtils.equal(ms.get(0).getCode(), getLoginMemberCode())) {
					return ResponseDto.getErrorResponse(ResponseCode.OPEN_SHOP_VALID_PHONE_SHOP_ERROR);
				}
			}
		}
		
		
		boolean phoneChangeFlag = false;
		List<ShopDto> list = findShopList();
		ShopDto shopDto = new ShopDto();
		if(null==list || list.size()==0) { 
			//开店申请
			MemberDto logonMember = getLoginMember();
			shopDto.setStatus(ShopStatus.IN_APPLY.getValue());
			shopDto.setCreateTime(new Date());
			shopDto.setMbrCode(logonMember.getCode());
			shopDto.setShopGarde(ShopGrade.FIVE.getValue());
			shopDto.setReadNum(0);
			shopDto.setMerchantCode(getLoginMember().getMerchantCode());
			shopDto.setShopNo(GUID.generateCode());
			shopDto.setShopName(logonMember.getName());
			shopDto.setImg(logonMember.getAvotor());
			
			FindShopBgImgPage findShopBgImgPage = new FindShopBgImgPage();
			List<ShopBgImgDto> bgimgs = shopBgImgService.findShopBgImgs(findShopBgImgPage);
			shopDto.setBgUrl(bgimgs.get(0).getSpe());
			shopDto.setShopBgImgCode(bgimgs.get(0).getCode());
			
			FindShopStylePage findShopStylePage = new FindShopStylePage();
			List<ShopStyleDto> shopStyleDtos = shopStyleService.findShopStyles(findShopStylePage);
			shopDto.setStyleColor(shopStyleDtos.get(0).getSpe());
			shopDto.setStyleName(shopStyleDtos.get(0).getName());
			shopDto.setShopStyleCode(shopStyleDtos.get(0).getCode());
			shopService.addShop(shopDto);
			phoneChangeFlag = true;
		} else {
			shopDto = list.get(0);
			
			//如果是正常或者关闭，禁止重新申请
			if(StringUtils.equal(shopDto.getStatus(), ShopStatus.NORMAL.getValue()) || StringUtils.equal(shopDto.getStatus(), ShopStatus.STOP.getValue())) {
				return ResponseDto.getErrorResponse(ResponseCode.OPEN_SHOP_HAVEN_SHOP_ERROR);
			}

			//如果是关闭，禁止重新申请
			if(StringUtils.equal(shopDto.getStatus(), ShopStatus.STOP.getValue())) {
				return ResponseDto.getErrorResponse(ResponseCode.OPEN_SHOP_HAVEN_SHOP_STOP_ERROR);
			}
			
			//如果是申请失败，重置重新申请
			if(StringUtils.equal(shopDto.getStatus(), ShopStatus.FAIL.getValue())
					) {
				shopDto.setStatus(ShopStatus.IN_APPLY.getValue());
				shopDto.setCreateTime(new Date());
				shopDto.setOpenTime(null);
				shopService.updateShop(shopDto);
			}
			phoneChangeFlag = true;
		}

		//如果是首次申请或者还是申请中，才可以修改手机号
		if(phoneChangeFlag) {
			
			MemberDto memberDto = new MemberDto();
			memberDto.setCode(getLoginMemberCode());
			memberDto.setPhone(mobilePhone);
			memberService.updateMember(memberDto);
		}
		

		logger.debug("openStoreOne --> openStoreOne(={}) - end");
		return ResponseDto.successResp(shopDto.getShopNo());
	}
	
	/**
	 * 开店第二步，填写基本资料
	 * 方法说明：
	 * @param shopProvide   省份
	 * @return shopCity    市
	 * @throws shopArea		区
	 * @throws shopAddinfo		街道
	 * @throws receiveName		收货人
	 * @throws receivePhone		收货人电话
	 *
	 * @author 林进权
	 *         CreateDate: 2017年9月7日
	 */
	@RequestMapping(value = {"openShopTwo"})
	@ResponseBody
	public ResponseDto openShopTwo(ShopDto shopDto, String receiveName, String receivePhone) {
		logger.debug("openShopTwo --> openShopTwo(={}) - start");
		//校验必填
		if(null==shopDto  || StringUtils.isEmpty(shopDto.getShopProvide())
				 || StringUtils.isEmpty(shopDto.getShopCity())  
				 //|| StringUtils.isEmpty(shopDto.getShopArea())
				 || StringUtils.isEmpty(shopDto.getShopAddinfo())  || StringUtils.isEmpty(receiveName)   || StringUtils.isEmpty(receivePhone) 
				) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		
		
		//校验付款流水
		FindAccWaterPage findAccWaterPage = new FindAccWaterPage();
		AccWaterDto accWaterDto = new AccWaterDto(); 
		accWaterDto.setAccSource(AccWaterSource.DEPOSIT.getValue());
		accWaterDto.setAccType(AccWaterAccType.AUTO.getValue());
		accWaterDto.setStatus(AccWaterStatus.SUCCESS.getValue());
		//accWaterDto.setBizType(AccWaterBizType.RECHARGE.getValue()); //冲值
		accWaterDto.setWaterType(AccWaterType.ADD.getValue());
		accWaterDto.setOpCode(getLoginMemberCode());
		List<AccWaterDto> accList = iAccWaterService.findAccWaters(findAccWaterPage);
		if(null==accList || accList.size()==0) {
			return ResponseDto.getErrorResponse(ResponseCode.OPEN_SHOP_NON_PAYMENT);
		}
		
		//地址
		AddrsDto addrsDto = new AddrsDto();
		addrsDto.setMbrCode(getLoginMemberCode());
		addrsDto.setReciverName(receiveName);
		addrsDto.setReciverPhone(getLoginMember().getPhone());
		addrsDto.setProvinceCode(shopDto.getShopProvide());
		addrsDto.setCityCode(shopDto.getShopCity());
		addrsDto.setAreCode(shopDto.getShopArea());
		addrsDto.setAddrDetail(shopDto.getShopAddinfo());
		addrsDto.setReciverPhone(receivePhone);
		addrsDto.setCreateTime(new Date());		
		addrsDto.setDelFlag("0");
		addrsDto.setIsDefault("0");
		addrsService.addAddrs(addrsDto);
		
		List<ShopDto> shopList = findShopList();
		if(null!=shopList && shopList.size()>0) {
			shopDto.setCode(shopList.get(0).getCode());
			shopService.updateShop(shopDto);
		}
		
		
		/*消息通知*/
		MessageDto messageDto = new MessageDto();
		messageDto.setRecevier(getLoginShopCode());
		messageService.addMessageByTemplate(messageDto, MessageTemplate.C_SYS_NOT_PARAM_OPEN_STORE);
		
		logger.debug("openShopTwo --> openShopTwo(={}) - end");
		return ResponseDto.successResp(null);
	}
	
	private List<ShopDto> findShopList() {
		FindShopPage findShopPage = new FindShopPage();
		ShopDto param = new ShopDto();
		param.setMbrCode(getLoginMemberCode());
		findShopPage.setParam(param);
		return shopService.findShops(findShopPage);
	}

	/**
	 * 开店状态查询
	 * 方法说明：
	 * @return
     * "reason": null,  #失败原因
        "status": "1"   #店铺状态 -1:未申请  0:申请中 1:正常  2:关闭  3:申请失败,
		"receivePhone": null,   #电话
        "receiveName": null,   #姓名
        "payStatus": "1"  #0未支付， 1已支付,
		"shopNo"："shopno112312312",  #支付时需要使用，如果还没手机号验证，可能会没有这个字段。
		"receiveStatus"："1", # 1地址已经完善  0未完善

	 * @author 林进权
	 *         CreateDate: 2017年9月7日
	 */
	@RequestMapping(value = "/status")
	@ResponseBody
	public ResponseDto status() {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("status", "-1");
		map.put("receiveStatus", "0");
		map.put("amt", shopService.queryCashPledge(null).toString());
		List<ShopDto> list = findShopList();
		if(null!=list && list.size()>0) {
			ShopDto shopDto = list.get(0);
			map.put("reason", shopDto.getCloseReason());
			shopPayStatus(shopDto, map);
			if(StringUtils.isNotEmpty(shopDto.getShopNo())) {
				map.put("shopNo", shopDto.getShopNo());
			}
			if(StringUtils.isNotEmpty(shopDto.getStatus())) {
				map.put("status", shopDto.getStatus());
			}
			if(StringUtils.isNotEmpty(shopDto.getShopProvide())
					&& StringUtils.isNotEmpty(shopDto.getShopCity())
					//|| StringUtils.isEmpty(shopDto.getShopArea())
					&& StringUtils.isNotEmpty(shopDto.getShopAddinfo())
					) {
				map.put("receiveStatus", "1");
			}
		}
		return ResponseDto.successResp(map);
	}
	
	/**
	 * 好友邀请首页-静态
	 * 方法说明：
	 *	code： 商店code
	 * @author 林进权
	 *         CreateDate: 2017年9月7日
	 */
	@RequestMapping(value = "/merchantIndex")
	@ResponseBody
	public ResponseDto merchantIndex(ShopDto paramShopDto) {
		
		ShopDto shopDto = shopService.findShop(paramShopDto);
		if(null==shopDto ||  StringUtils.isEmpty(shopDto.getMbrCode())) {
			return ResponseDto.getErrorResponse(ResponseCode.NO_DATA);
		}
		
		if(StringUtils.isEmpty(getLoginMemberCode())) {
			return ResponseDto.getErrorResponse(ResponseCode.USER_NOT_FIND);
		}
		
		MemberDto memberDto = new MemberDto();
		memberDto.setCode(getLoginMemberCode());
		memberDto.setMyInvite(shopDto.getMbrCode());
		memberService.updateMember(memberDto);
		
		FindMerchantSettingPage findMerchantSettingPage = new FindMerchantSettingPage();
		MerchantSettingDto param = new MerchantSettingDto();
		param.setMerchantCode(getLoginMerchantCode());
//		findMerchantSettingPage.setLeftLikeValue("/eoms/image");
		param.setName("offline.bgm");
		param.setStatus(MerchantSettingStatus.USE.getValue());
		findMerchantSettingPage.setParam(param);
		List<MerchantSettingDto> list = merchantSettingService.findMerchantSettings(findMerchantSettingPage);
		if(null==list || list.size()==0) {
			return ResponseDto.getErrorResponse(ResponseCode.NO_DATA);
		}
		return ResponseDto.successResp(list.get(0));
	}
	
	
	private void shopPayStatus(ShopDto shopDto, Map<String,String> map) {
		
		FindPaymentPage findPaymentPage = new FindPaymentPage();
		PaymentDto paymentDto = new PaymentDto();
		paymentDto.setBizNo(shopDto.getShopNo());
		paymentDto.setDelFlag(DelFlag.N.getValue());
		findPaymentPage.setParam(paymentDto);
		List<PaymentDto> payList = paymentService.findPayments(findPaymentPage);
		
		map.put("payStatus", "0"); //失败
		
		if(null!=payList && payList.size()>0)  {
			for (PaymentDto paymentDto2 : payList) {
				if(StringUtils.equal(paymentDto2.getStatus(), PaymentStatus.SUCCESS.getValue())) {
					map.put("payStatus", "1");
					if(null!=getLoginMember()) {
						map.put("receivePhone", getLoginMember().getPhone());
						map.put("receiveName", getLoginMember().getName());
					}
					break;
				}
			}
		}
	}
	
	
	/**
	 * 线下支付
	 * 方法说明：
	 *	code： 商店code
	 * @author 林进权
	 *         CreateDate: 2017年9月7日
	 */
	@RequestMapping(value = "/offline")
	@ResponseBody
	public ResponseDto offline(ShopDto shopDto) {
		logger.debug("offline(={}) - start", shopDto);
		//校验必填
		if(null==shopDto  || StringUtils.isEmpty(shopDto.getShopNo())
				) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		
		//校验支付号是否一致
		FindShopPage findShopPage = new FindShopPage();
		ShopDto param = new ShopDto();
		param.setMbrCode(getLoginMemberCode());
		findShopPage.setParam(param);
		List<ShopDto> shopList = shopService.findShops(findShopPage);
		if(shopList.size()==0 || !StringUtils.equal(shopList.get(0).getShopNo(),shopDto.getShopNo())) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		
		//生成预支付单
		FindPaymentPage findPaymentPage = new FindPaymentPage();
		PaymentDto findPaymentPageParam = new PaymentDto();
		findPaymentPageParam.setBizNo(shopDto.getShopNo());
		findPaymentPageParam.setDelFlag(DelFlag.N.getValue());
		findPaymentPage.setParam(findPaymentPageParam);
		List<PaymentDto> payList = paymentService.findPayments(findPaymentPage);
		if(payList.size()==0) {
			PaymentDto paymentDto = new PaymentDto();
			paymentDto.setBizNo(shopDto.getShopNo());
			paymentDto.setStatus(PaymentStatus.SUCCESS.getValue());
			paymentDto.setFee(new BigDecimal(0));
			paymentDto.setAmount(NoUtil.DEFAULT_CASH_PLEDGE);
			paymentDto.setSn(shopDto.getShopNo());
			paymentDto.setType(PaymentType.OFFLINE.getValue());
			paymentDto.setDelFlag(DelFlag.N.getValue());
			paymentDto.setMemo("线下支付用户，默认为支付成功");
			paymentService.addPayment(paymentDto);
		}
		logger.debug("offline(={}) - end");
		return ResponseDto.successResp(null);
	}
	
	
}
