package com.lj.eshop.eis.controller.prodcut;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.pagination.PageSortType;
import com.lj.base.core.util.StringUtils;
import com.lj.eshop.constant.UpdateProductCntType;
import com.lj.eshop.dto.FindFlagPage;
import com.lj.eshop.dto.FindProductImgPage;
import com.lj.eshop.dto.FindProductPage;
import com.lj.eshop.dto.FindProductRulePage;
import com.lj.eshop.dto.FindProductSkuPage;
import com.lj.eshop.dto.FindProductSpePage;
import com.lj.eshop.dto.FlagDto;
import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.dto.ProductDto;
import com.lj.eshop.dto.ProductImgDto;
import com.lj.eshop.dto.ProductRuleDto;
import com.lj.eshop.dto.ProductSkuDto;
import com.lj.eshop.dto.ProductSpeDto;
import com.lj.eshop.dto.UpdateProductCntDto;
import com.lj.eshop.eis.constant.ProductConstant;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.emus.DelFlag;
import com.lj.eshop.emus.ProductFlagType;
import com.lj.eshop.emus.ProductStatus;
import com.lj.eshop.emus.Status;
import com.lj.eshop.service.IFlagService;
import com.lj.eshop.service.IProductImgService;
import com.lj.eshop.service.IProductRuleService;
import com.lj.eshop.service.IProductService;
import com.lj.eshop.service.IProductSkuService;
import com.lj.eshop.service.IProductSpeService;

/**
 * 类说明：终端商品查询接口.
 *  
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年8月30日
 */
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController{

	@Autowired
	private IProductService productService;
	@Autowired
	private IFlagService flagService;
	@Autowired
	private IProductImgService productImgService;
	@Autowired
	private IProductRuleService productRuleService;//商品规格
	
	@Autowired
	private IProductSpeService productSpeService;//商品规格值
	
	@Autowired
	private IProductSkuService productSkuService;//商品SKU
	
	/***
	 * 方法说明：抢首页。
	 * @param findProductPage
	 * @return ResponseDto
	 *
	 * @author lhy  2017年8月30日
	 *
	 */
	@RequestMapping(value = { "/index", "" })
	@ResponseBody
	public ResponseDto index(){
		//1.查专题
		FindFlagPage findFlagPage=new FindFlagPage();
		FlagDto flagDto=new FlagDto();
		flagDto.setStatus(Status.USE.getValue());
		flagDto.setFlagType(ProductFlagType.SUBJECT.getValue());
		findFlagPage.setParam(flagDto);
		findFlagPage.setSortBy("product_seq");
		findFlagPage.setSortDir(PageSortType.asc);
		List<FlagDto> flags= flagService.findFlags(findFlagPage);
		//2.查专题下的商品
		for (Iterator<FlagDto> iterator = flags.iterator(); iterator.hasNext();) {
			FlagDto p = (FlagDto) iterator.next();
			FindProductPage findProductPage=new FindProductPage();
			ProductDto productDto=new ProductDto();
			productDto.setMerchantCode(getLoginMerchantCode());//商户编码 
			productDto.setStatus(ProductStatus.USE.getValue());
			List<FlagDto> queryFlags=new ArrayList<FlagDto>();
			queryFlags.add(p);//仅查该专题下的
			productDto.setFlags(queryFlags);
			
			findProductPage.setParam(productDto);
			findProductPage.setLimit(p.getShowCnt());
			findProductPage.setStart(0);
			findProductPage.setShopCode(getLoginShopCode());
			Page<ProductDto> products=productService.findIndexProductPage(findProductPage);
			p.setProducts(products);
		}
	
		return ResponseDto.successResp(flags);
	}
	
	/***
	 * 商品搜索。
	 * @param findProductPage
	 * @return ResponseDto
	 *
	 * @author lhy  2017年8月30日
	 *
	 */
	@RequestMapping(value = { "/list"}, method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto list(FindProductPage findProductPage,Integer pageNo,Integer pageSize){
		ProductDto productDto= findProductPage.getParam();
		if(productDto==null){
			productDto = new ProductDto();
			findProductPage.setParam(productDto);
		}
		if(pageNo!=null){
			findProductPage.setStart((pageNo-1)*pageSize);
		}
		if(pageSize!=null){
			findProductPage.setLimit(pageSize);
		}
		productDto.setMerchantCode(getLoginMerchantCode());//商户编码 
		productDto.setStatus(ProductStatus.USE.getValue());
		if(ProductConstant.SORT_TYPE_TJ.equals(findProductPage.getSortBy())){
			findProductPage.setSortDir(null);//推荐无需指定排序
		}else if(findProductPage.getSortDir()==null){
			findProductPage.setSortDir(PageSortType.desc);//默认降序
		}
		findProductPage.setShopCode(getLoginShopCode());
		findProductPage.setSortBy(ProductConstant.getSort(findProductPage.getSortBy()));
		Page<ProductDto> products=productService.findIndexProductPage(findProductPage);
		return ResponseDto.successResp(products);
	}
	
	
	/***
	 * 商品详情推荐。<p>
	 * （和搜索单独开，因为搜索需要拿登录的门店的商户号，推荐不需要登录只拿详情里商品的商户号）
	 * @param findProductPage
	 * @return ResponseDto
	 *
	 * @author lhy  2017年8月30日
	 *
	 */
	@RequestMapping(value = { "/detail/tj"}, method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto detailTj(FindProductPage findProductPage,Integer pageNo,Integer pageSize){
		ProductDto productDto= findProductPage.getParam();
		if(productDto==null || StringUtils.isEmpty(productDto.getMerchantCode())){
				return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR, null);
		}
		if(pageNo!=null){
			findProductPage.setStart((pageNo-1)*pageSize);
		}
		if(pageSize!=null){
			findProductPage.setLimit(pageSize);
		}
		productDto.setMerchantCode(productDto.getMerchantCode());//商户编码 
		productDto.setStatus(ProductStatus.USE.getValue());
		if(ProductConstant.SORT_TYPE_TJ.equals(findProductPage.getSortBy())){
			findProductPage.setSortDir(null);//推荐无需指定排序
		}else if(findProductPage.getSortDir()==null){
			findProductPage.setSortDir(PageSortType.desc);//默认降序
		}
		findProductPage.setSortBy(ProductConstant.getSort(findProductPage.getSortBy()));
		Page<ProductDto> products=productService.findIndexProductPage(findProductPage);
		return ResponseDto.successResp(products);
	}
	 
	/***
	 * 方法说明：商品详情
	 * @param code
	 * @return
	 *
	 * @author lhy  2017年8月30日
	 *
	 */
	@RequestMapping(value = { "/detail" }, method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto findProduct(String code){
		if(StringUtils.isEmpty(code)){
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR, null);
		}
		ProductDto param=new ProductDto();
		param.setCode(code);
		ProductDto productDto= productService.findProduct(param);
		if (productDto == null) {
			return ResponseDto.getErrorResponse(ResponseCode.NO_DATA, null);
		} else if (ProductStatus.STOP.getValue().equals(productDto.getStatus())) {
			return ResponseDto.getErrorResponse(ResponseCode.PRODCUT_SOLD_OUT,null);
		}
		productDto.setShopCode(getLoginShopCode());//B端已登录则返回店code
		//商品图片
		FindProductImgPage findProductImgPage=new FindProductImgPage();
		ProductImgDto imgParam=new ProductImgDto();
		imgParam.setProductCode(code);
		imgParam.setStatus(Status.USE.getValue());
		findProductImgPage.setParam(imgParam);
		List<ProductImgDto > imgs=productImgService.findProductImgs(findProductImgPage);
		productDto.setImgs(imgs);//商品图片END 
		return ResponseDto.successResp(productDto);
	}
	
	
	/***
	 * 方法说明：商品规格及规格值及商品SKU
	 * @param code
	 * @return
	 * @author lhy  2017年8月30日
	 *
	 */
	@RequestMapping(value = { "/sku"}, method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto findSku(String code,String from){
		if(StringUtils.isEmpty(code)){
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR, null);
		}
		ProductDto productDto =new ProductDto();
		productDto.setCode(code);
		//一：商品规格及属性
		FindProductRulePage rule=new FindProductRulePage();
		ProductRuleDto pl=new ProductRuleDto();
		pl.setProductCode(productDto.getCode()); 
		rule.setParam(pl);
		List<ProductRuleDto> productRules=productRuleService.findProductRules(rule);
		if(productRules!=null){//商品规格属性值
			int size=productRules.size();
			for (int i = 0; i < size; i++) {
				ProductRuleDto ruleE= productRules.get(i);
				ProductSpeDto spe= new ProductSpeDto();
				spe.setRuleCode(ruleE.getCode());
				spe.setProductCode(productDto.getCode());
				FindProductSpePage findProductSpePage=new FindProductSpePage();
				findProductSpePage.setParam(spe);
				List<ProductSpeDto> spes=productSpeService.findProductSpes(findProductSpePage);
				ruleE.setSpes(spes);
			}
		}//商品规格及规格属性值END
		
		//二：商品SKU
		FindProductSkuPage sku=new FindProductSkuPage();
		ProductSkuDto psku=new ProductSkuDto();
		psku.setProductCode(productDto.getCode()); 
		psku.setDelFlag(DelFlag.N.getValue());
		sku.setFrom(from);
		//sku.setFrom(from);//ProductServiceConst.PRODUCT_QUERY_FROM_B; 如果来自B端则查差价 由前端传
		
		sku.setParam(psku);
		List<ProductSkuDto> productSkus=productSkuService.findMinProductSkus(sku);
		//商品SKU end
	 
		productDto.setRules(productRules);//商品规格及规格属性值
		productDto.setSkus(productSkus);//商品SKU
		return ResponseDto.successResp(productDto);
	}
	
	/**
	 * 方法说明：商品浏览次数累加。
	 *
	 * @param code 商品code
	 *
	 * @author lhy 2017年8月31日
	 *
	 */
	@RequestMapping(value = { "/view" }, method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto addProductView(String code) {
		if(StringUtils.isEmpty(code)){
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR, null);
		}
		MemberDto meb = getLoginMember();
		logger.info("商品浏览记录：mbr.code:"+(meb==null?"游客":meb.getCode())+",productCode"+code);
		
		UpdateProductCntDto u=new UpdateProductCntDto();
		u.setType(UpdateProductCntType.VIEW_CNT);
		u.setCode(code);
		u.setCnt(1);
		productService.updateProductCntByType(u);
		return ResponseDto.successResp(null);
	}
	
}
