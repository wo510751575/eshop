package com.lj.eoms.product;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ape.common.web.BaseController;
import com.google.common.collect.Lists;
import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.GUID;
import com.lj.base.core.util.StringUtils;
import com.lj.base.mvc.base.json.JsonUtils;
import com.lj.base.mvc.web.httpclient.HttpClientUtils;
import com.lj.cc.clientintf.LocalCacheSystemParamsFromCC;
import com.lj.eoms.dto.ResponseDto;
import com.lj.eoms.utils.UserUtils;
import com.lj.eshop.dto.CatalogDto;
import com.lj.eshop.dto.FindFlagPage;
import com.lj.eshop.dto.FindMemberRankPage;
import com.lj.eshop.dto.FindProductFlagPage;
import com.lj.eshop.dto.FindProductImgPage;
import com.lj.eshop.dto.FindProductMaterialPage;
import com.lj.eshop.dto.FindProductPage;
import com.lj.eshop.dto.FindProductRulePage;
import com.lj.eshop.dto.FindProductSkuPage;
import com.lj.eshop.dto.FindProductSpePage;
import com.lj.eshop.dto.FindSupplyPage;
import com.lj.eshop.dto.FindSysSpePage;
import com.lj.eshop.dto.FlagDto;
import com.lj.eshop.dto.MemberRankDto;
import com.lj.eshop.dto.ProductDto;
import com.lj.eshop.dto.ProductFlagDto;
import com.lj.eshop.dto.ProductImgDto;
import com.lj.eshop.dto.ProductMaterialDto;
import com.lj.eshop.dto.ProductRankPriceDto;
import com.lj.eshop.dto.ProductRuleDto;
import com.lj.eshop.dto.ProductSkuDto;
import com.lj.eshop.dto.ProductSpeDto;
import com.lj.eshop.dto.SupplyDto;
import com.lj.eshop.dto.SysSpeDto;
import com.lj.eshop.emus.DelFlag;
import com.lj.eshop.emus.ProductFlagType;
import com.lj.eshop.emus.ProductStatus;
import com.lj.eshop.emus.ProductYN;
import com.lj.eshop.emus.Status;
import com.lj.eshop.service.ICatalogService;
import com.lj.eshop.service.IFlagService;
import com.lj.eshop.service.IMemberRankService;
import com.lj.eshop.service.IProductFlagService;
import com.lj.eshop.service.IProductImgService;
import com.lj.eshop.service.IProductMaterialService;
import com.lj.eshop.service.IProductRankPriceService;
import com.lj.eshop.service.IProductRuleService;
import com.lj.eshop.service.IProductService;
import com.lj.eshop.service.IProductSkuService;
import com.lj.eshop.service.IProductSpeService;
import com.lj.eshop.service.ISupplyService;
import com.lj.eshop.service.ISysSpeService;

/**
 * 
 * 
 * 类说明：商品@Controller
 * 
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017.08.28
 */
@Controller
@RequestMapping("${adminPath}/product/product")
public class ProductController extends BaseController {

	public static final String LIST = "modules/product/product/list";
	public static final String FORM = "modules/product/product/form";
	public static final String EDIT = "modules/product/product/edit";
	public static final String VIEW = "modules/product/product/view";
	@Autowired
	private IProductService productService;

	@Autowired
	private ISupplyService supplyService;
	@Autowired
	private IProductImgService productImgService;

	@Autowired
	private ICatalogService catalogService;

	@Autowired
	private IFlagService flagService;// 商品系统标签
	@Autowired
	private IProductFlagService productFlagService;// 商品标签

	@Autowired
	private ISysSpeService sysSpeService;

	@Autowired
	private IProductRuleService productRuleService;// 商品规格

	@Autowired
	private IProductSpeService productSpeService;// 商品规格值

	@Autowired
	private IProductSkuService productSkuService;// 商品SKU
	@Autowired
	private IProductRankPriceService productRankPriceService;// 商品特权价
	@Autowired
	private IMemberRankService memberRankService;// 会员特权
	@Autowired
	private IProductMaterialService productMaterialService;// 产品素材
	@Autowired
	private LocalCacheSystemParamsFromCC localCacheSystemParams;// 会员特权

	/** 列表 */
	@RequiresPermissions("product:product:view")
	@RequestMapping(value = { "list", "" })
	public String list(FindProductPage productPage, Integer pageNo, Integer pageSize, Model model) {
		ProductDto productDto = productPage.getParam();
		if (productDto == null) {
			productDto = new ProductDto();
		}

		if (null != UserUtils.getUser().getMerchant()) {

			productDto.setMerchantCode(UserUtils.getUser().getMerchant().getCode());// 这里设置用户所属商户
			productPage.setParam(productDto);
			if (pageNo != null) {
				productPage.setStart((pageNo - 1) * pageSize);
			}
			if (pageSize != null) {
				productPage.setLimit(pageSize);
			}
			Page<ProductDto> pageDto = productService.findProductPage(productPage);
			List<ProductDto> list = Lists.newArrayList();
			list.addAll(pageDto.getRows());

			com.ape.common.persistence.Page<ProductDto> page = new com.ape.common.persistence.Page<ProductDto>(
					pageNo == null ? 1 : pageNo, pageDto.getLimit(), pageDto.getTotal(), list);
			page.initialize();

			if (!StringUtils.isEmpty(productDto.getCatalogTypeCode())) {
				CatalogDto cp = new CatalogDto();
				cp.setCode(productDto.getCatalogTypeCode());
				CatalogDto productCatalog = catalogService.findCatalog(cp);
				model.addAttribute("productCatalog", productCatalog);// 查询的类型
			}
			// 供应商
			SupplyDto supplyDto = new SupplyDto();
			supplyDto.setStatus(Status.USE.getValue());
			supplyDto.setMerchantCode(UserUtils.getUser().getMerchant().getCode());// 这里设置用户所属商户
			FindSupplyPage supplyPage = new FindSupplyPage();
			supplyPage.setParam(supplyDto);
			List<SupplyDto> supplys = supplyService.findSupplys(supplyPage);// 供应商END

			model.addAttribute("supplys", supplys);
			model.addAttribute("page", page);
			model.addAttribute("prodcutStatuss", ProductStatus.values());
			model.addAttribute("productYNs", ProductYN.values());
			model.addAttribute("reqParam", productPage);
		}
		return LIST;
	}

	/** 新增 */
	@RequiresPermissions("product:product:edit")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(ProductDto productDto, String imgAddr, RedirectAttributes redirectAttributes) {

		productDto.setCreateTime(new Date());
		productDto.setMerchantCode(UserUtils.getUser().getMerchant().getCode());// 这里设置用户所属商户
		ProductDto rt = productService.addProduct(productDto);

		// 商品图片
		if (!StringUtils.isEmpty(imgAddr)) {
			String imgs[] = imgAddr.split(",");
			int size = imgs.length;
			for (int i = 0; i < size; i++) {
				ProductImgDto img = new ProductImgDto();
				img.setImg(imgs[i]);
				img.setProductCode(rt.getCode());
				img.setStatus(Status.USE.getValue());
				img.setOrderNo(i);
				productImgService.addProductImg(img);
			}
		} // 商品图片END

		// 商品标签
		Integer productOrder = null;
		StringBuffer productKey = new StringBuffer("");
		if (productDto.getFlags() != null) {
			productKey.append(",");
			int size = productDto.getFlags().size();
			for (int i = 0; i < size; i++) {
				FlagDto flag = productDto.getFlags().get(i);
				ProductFlagDto pflag = new ProductFlagDto();
				pflag.setFlagCode(flag.getCode());
				pflag.setProductCode(rt.getCode());
				productFlagService.addProductFlag(pflag);
				if (ProductFlagType.LABEL.getValue().equals(flag.getFlagType())) {
					Integer seq = Integer.valueOf(flag.getProductSeq());
					if (productOrder == null) {
						productOrder = seq;
					}
					if (productOrder.compareTo(seq) > 0) {
						productOrder = seq;
					}
				}
				productKey.append(flag.getProductFlag());
				productKey.append(",");
			}
		} // 商品标签END

		// 商品规格及规格属性值
		Map<String, String> sepMap = new HashMap<String, String>();// key=中文,value=code.
		if (productDto.getRules() != null) {
			int size = productDto.getRules().size();
			for (int i = 0; i < size; i++) {
				ProductRuleDto rule = productDto.getRules().get(i);
				rule.setOrderNo(i);
				rule.setProductCode(rt.getCode());
				int speSize = 0;
				ProductRuleDto rtRule = null;
				if (rule.getSpes() != null) {// 有属性才保存规格
					rtRule = productRuleService.addProductRule(rule);// 商品规格
					speSize = rule.getSpes().size();
				}
				for (int j = 0; j < speSize; j++) {
					ProductSpeDto spe = rule.getSpes().get(j);
					spe.setOrderNo(j);
					spe.setRuleCode(rtRule.getCode());
					spe.setProductCode(rt.getCode());
					ProductSpeDto rtSpe = productSpeService.addProductSpe(spe);// 规格属性
					sepMap.put(rtSpe.getRuleDetail(), rtSpe.getCode());
				}
			}
		} // 商品规格及规格属性值END

		// 商品价格
		int cnt = 0;
		if (productDto.getSkus() != null) {
			int size = productDto.getSkus().size();
			for (int i = 0; i < size; i++) {
				ProductSkuDto sku = productDto.getSkus().get(i);
				sku.setProductCode(rt.getCode());
				sku.setSkuNo(GUID.generateCode());// 没有从前端拿，系统生成
				sku.setDelFlag(DelFlag.N.getValue());
				sku.setOrderNo(i);
				cnt += sku.getCnt();
				if (StringUtils.isEmpty(sku.getProductSpes())) {
					sku.setProductSpes(getSpesCode(sku.getSkuDesc(), sepMap));
				}
				ProductSkuDto returnDto = productSkuService.addProductSku(sku);

				for (ProductRankPriceDto rankp : sku.getRankPriceDtos()) {
					rankp.setProductCode(rt.getCode());
					rankp.setSkuCode(returnDto.getCode());
					productRankPriceService.addProductRankPrice(rankp);
				}
			}
		}
		// 商品价格END

		ProductDto update = new ProductDto();
		update.setCnt(cnt);
		update.setCode(rt.getCode());
		update.setProductOrder(productOrder);// 修改排列顺序
		update.setProductKey(productKey.toString());// 修改搜索关键字
		productService.updateProduct(update);
		
		//商品素材图片
		if(StringUtils.isNotEmpty(productDto.getProductMaterial())){
			String memberNoGuid = UserUtils.getUser().getId();
			String url = localCacheSystemParams.getSystemParam("cc","rw", "rwAdvUrl");
			String uploadUrl = localCacheSystemParams.getSystemParam("ms","upload", "uploadUrl");
			String[] productMaterials = productDto.getProductMaterial().split(",");
			String str = "";
			for (int i = 0; i < productMaterials.length; i++) {
				if(i!=productMaterials.length-1){
					str = uploadUrl+productMaterials[i] + ",";
				}else{
					str = uploadUrl+productMaterials[i];
				}
				str = uploadUrl + productMaterials[i];
			}
			Map map = new HashMap<>();
			map.put("memberNoGuid", memberNoGuid);
			map.put("links", str);
			map.put("productCode", rt.getCode());
			String result = HttpClientUtils.postToWeb(url, map);
			
			if(StringUtils.isNotEmpty(result)){
				JSONObject obj = (JSONObject) JSON.parse(result);
				JSONObject object = (JSONObject) obj.get("returnObject");
				Set<String> keySet = object.keySet();
				for (String keys : keySet) {
					int orderNo = 1;
					ProductMaterialDto productMaterialDto = new ProductMaterialDto();
					productMaterialDto.setCode(GUID.generateByUUID());
					productMaterialDto.setAdvCode(object.getString(keys));
					productMaterialDto.setImg(keys);
					productMaterialDto.setOrderNo(orderNo);
					productMaterialDto.setProductCode(rt.getCode());
					productMaterialDto.setStatus("0");
					productMaterialService.addProductMaterial(productMaterialDto );
					orderNo++;
					
				}
			}
			
		}

		addMessage(redirectAttributes, "保存商品'" + productDto.getName() + "'成功");
		return "redirect:" + adminPath + "/product/product/";
	}

	/** 获取规格对于的规格code组合 */
	private String getSpesCode(String name, Map<String, String> sepMap) {
		StringBuilder rt = new StringBuilder("");
		String names[] = name.split(",");
		for (int i = 0; i < names.length; i++) {
			String s = names[i];
			String code = sepMap.get(s);
			if (code != null) {
				rt.append(code);
			}
			if (i != names.length - 1) {
				rt.append(",");
			}
		}
		if (StringUtils.isEmpty(rt.toString())) {
			return "";
		}
		return rt.toString();
	}

	/** 新增/修改表单 */
	@RequiresPermissions("product:product:view")
	@RequestMapping(value = "/form")
	public String form(String code, Boolean isView, Model model, RedirectAttributes redirectAttributes) {

		if (null != UserUtils.getUser().getMerchant()) {

			if (StringUtils.isNotEmpty(code)) {
				ProductDto param = new ProductDto();
				param.setCode(code);
				ProductDto rtDto = productService.findProduct(param);
				// 商品图片
				FindProductImgPage findProductImgPage = new FindProductImgPage();
				ProductImgDto imgParam = new ProductImgDto();
				imgParam.setProductCode(code);
				imgParam.setStatus(Status.USE.getValue());
				findProductImgPage.setParam(imgParam);
				List<ProductImgDto> imgs = productImgService.findProductImgs(findProductImgPage);
				rtDto.setImgs(imgs);// 商品图片END
				StringBuilder imgAddr = new StringBuilder();
				if (imgs != null) {// 商品图片处理成字符串
					int size = imgs.size();
					for (int i = 0; i < size; i++) {
						if (i != (size - 1)) {
							imgAddr.append(imgs.get(i).getImg());
							imgAddr.append(",");
						} else {
							imgAddr.append(imgs.get(i).getImg());
						}
					}
				} // 商品图片END

				// 商品类目
				CatalogDto cp = new CatalogDto();
				cp.setCode(rtDto.getCatalogTypeCode());
				CatalogDto productCatalog = catalogService.findCatalog(cp);

				// 商品标签
				FindProductFlagPage find = new FindProductFlagPage();
				ProductFlagDto pf = new ProductFlagDto();
				pf.setProductCode(rtDto.getCode());
				find.setParam(pf);
				List<ProductFlagDto> productFlags = productFlagService.findProductFlags(find);

				// 商品规格及属性
				FindProductRulePage rule = new FindProductRulePage();
				ProductRuleDto pl = new ProductRuleDto();
				pl.setProductCode(rtDto.getCode());
				rule.setParam(pl);
				List<ProductRuleDto> productRules = productRuleService.findProductRules(rule);
				if (productRules != null) {// 商品规格属性值
					int size = productRules.size();
					for (int i = 0; i < size; i++) {
						ProductRuleDto ruleE = productRules.get(i);
						ProductSpeDto spe = new ProductSpeDto();
						spe.setRuleCode(ruleE.getCode());
						spe.setProductCode(rtDto.getCode());
						FindProductSpePage findProductSpePage = new FindProductSpePage();
						findProductSpePage.setParam(spe);
						List<ProductSpeDto> spes = productSpeService.findProductSpes(findProductSpePage);
						ruleE.setSpes(spes);
					}
				} // 商品规格及规格属性值END

				// 商品SKU
				FindProductSkuPage sku = new FindProductSkuPage();
				ProductSkuDto psku = new ProductSkuDto();
				psku.setProductCode(rtDto.getCode());
				psku.setDelFlag(DelFlag.N.getValue());
				sku.setParam(psku);
				List<ProductSkuDto> productSkus = productSkuService.findProductSkus(sku);
				// 商品SKU end

				
				model.addAttribute("imgAddr", imgAddr);// 商品图片
				model.addAttribute("productCatalog", productCatalog);// 商品类目
				model.addAttribute("productFlags", productFlags);// 商品已勾选的标签
				model.addAttribute("productRules", productRules);// 商品规格及规格属性值
				model.addAttribute("productSkus", productSkus);// 商品SKU
				
				//商品素材图片
				FindProductMaterialPage findProductMaterialPage = new FindProductMaterialPage();
				ProductMaterialDto productMaterialDto = new ProductMaterialDto();
				productMaterialDto.setProductCode(rtDto.getCode());
				productMaterialDto.setStatus("0");
				findProductMaterialPage.setParam(productMaterialDto);
				List<ProductMaterialDto> findProductMaterials = productMaterialService.findProductMaterials(findProductMaterialPage);
				StringBuilder materialImgaddr = new StringBuilder();
				int n = findProductMaterials.size();
				for (int i=0;i<n;i++) {
					if(i!=n-1){
						materialImgaddr.append(findProductMaterials.get(i).getImg());
						materialImgaddr.append(",");
					}else{
						materialImgaddr.append(findProductMaterials.get(i).getImg());
					}
				}
				rtDto.setProductMaterial(materialImgaddr.toString());
				model.addAttribute("data", rtDto);// 商品
			}

			// 供应商
			SupplyDto supplyDto = new SupplyDto();
			supplyDto.setStatus(Status.USE.getValue());
			supplyDto.setMerchantCode(UserUtils.getUser().getMerchant().getCode());// 这里设置用户所属商户
			FindSupplyPage supplyPage = new FindSupplyPage();
			supplyPage.setParam(supplyDto);
			List<SupplyDto> supplys = supplyService.findSupplys(supplyPage);

			// 标签
			FindFlagPage flagPage = new FindFlagPage();
			FlagDto flag = new FlagDto();
			flagPage.setParam(flag);
			flag.setStatus(Status.USE.getValue());
			List<FlagDto> flags = flagService.findFlags(flagPage);

			// 规格
			FindSysSpePage sysSpe = new FindSysSpePage();
			SysSpeDto speDto = new SysSpeDto();
			sysSpe.setParam(speDto);
			speDto.setStatus(Status.USE.getValue());
			List<SysSpeDto> sysSpes = sysSpeService.findSysSpes(sysSpe);

			// 特权
			FindMemberRankPage findMemberRankPage = new FindMemberRankPage();
			MemberRankDto memberRankDto = new MemberRankDto();
			memberRankDto.setDelFlag(DelFlag.N.getValue());
			findMemberRankPage.setParam(memberRankDto);
			List<MemberRankDto> memberRankDtos = memberRankService.findMemberRanks(findMemberRankPage);

			// 设置值
			model.addAttribute("prodcutStatuss", ProductStatus.values());
			model.addAttribute("productYNs", ProductYN.values());
			model.addAttribute("supplys", supplys);
			model.addAttribute("flags", flags);
			model.addAttribute("sysSpes", sysSpes);
			model.addAttribute("memberRankDtos", JsonUtils.jsonFromList(memberRankDtos));// 新增JS使用
			model.addAttribute("memberRankDtosNotJson", memberRankDtos);// 编辑修改使用
			
			
			

		}

		if (isView != null && isView) {
			return VIEW;
		}
		return FORM;
	}

	/** 修改 */
	@RequiresPermissions("product:product:edit")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(ProductDto productDto, String imgAddr, RedirectAttributes redirectAttributes) {
		productService.updateProduct(productDto);

		// 商品图片
		ProductImgDto updataImg = new ProductImgDto();
		updataImg.setProductCode(productDto.getCode());
		updataImg.setStatus(Status.STOP.getValue());// 先把该商品图全部禁用
		productImgService.updateProductImgByProductCode(updataImg);
		if (!StringUtils.isEmpty(imgAddr)) {
			String imgs[] = imgAddr.split(",");
			int size = imgs.length;
			for (int i = 0; i < size; i++) {

				ProductImgDto img = new ProductImgDto();
				img.setImg(imgs[i]);
				img.setProductCode(productDto.getCode());
				FindProductImgPage p = new FindProductImgPage();
				p.setParam(img);
				List<ProductImgDto> find = productImgService.findProductImgs(p);
				if (find != null && find.size() > 0) {
					// 图片已存在不用保存，直接启用
					ProductImgDto u = find.get(0);
					u.setStatus(Status.USE.getValue());
					u.setOrderNo(i);
					productImgService.updateProductImg(u);
				} else {// 否则保存图片
					img.setStatus(Status.USE.getValue());
					img.setOrderNo(i);
					productImgService.addProductImg(img);
				}
			}
		} // 商品图片END

		// 商品标签
		Integer productOrder = null;// 商品排序
		StringBuffer productKey = new StringBuffer("");// 商品搜索关键字
		ProductFlagDto delFlag = new ProductFlagDto();
		delFlag.setProductCode(productDto.getCode());
		productFlagService.deleteByProductCode(delFlag);// 先把标签全删了
		if (productDto.getFlags() != null) {
			productKey.append(",");
			int size = productDto.getFlags().size();
			for (int i = 0; i < size; i++) {
				FlagDto flag = productDto.getFlags().get(i);
				ProductFlagDto pflag = new ProductFlagDto();
				pflag.setFlagCode(flag.getCode());
				pflag.setProductCode(productDto.getCode());
				productFlagService.addProductFlag(pflag);
				if (ProductFlagType.LABEL.getValue().equals(flag.getFlagType())) {
					Integer seq = Integer.valueOf(flag.getProductSeq());
					if (productOrder == null) {
						productOrder = seq;
					}
					if (productOrder.compareTo(seq) > 0) {
						productOrder = seq;
					}
				}
				productKey.append(flag.getProductFlag());
				productKey.append(",");
			}
		} else {// 去掉所有标签则不优先排序，不设置标签关键字搜索
			productOrder = 9999999;
			productKey.append(", ,");
		}
		// 商品标签END

		// 商品规格及规格属性值
		Map<String, String> sepMap = new HashMap<String, String>();// key=中文,value=code.
		if (productDto.getRules() != null) {
			int size = productDto.getRules().size();
			for (int i = 0; i < size; i++) {
				ProductRuleDto rule = productDto.getRules().get(i);
				rule.setOrderNo(i);
				rule.setProductCode(productDto.getCode());
				int speSize = 0;
				ProductRuleDto rtRule = null;
				if (rule.getSpes() != null) {// 有属性才保存规格
					rtRule = productRuleService.addProductRule(rule);// 商品规格
					speSize = rule.getSpes().size();
				}
				for (int j = 0; j < speSize; j++) {
					ProductSpeDto spe = rule.getSpes().get(j);
					spe.setOrderNo(j);
					spe.setRuleCode(rtRule.getCode());
					spe.setProductCode(productDto.getCode());
					ProductSpeDto rtSpe = productSpeService.addProductSpe(spe);// 规格属性
					sepMap.put(rtSpe.getRuleDetail(), rtSpe.getCode());
				}
			}
		} else {
			// 商品已有规格及规格属性值 则不可随意修改 ，因为SKU 决定了商品的价格和库存，会导致无法找到商品的异常现象，如果出现规格输入错误，建议新增商品
		} // 商品规格及规格属性值END

		// 商品价格
		Integer cnt = null;
		if (productDto.getSkus() != null) {
			int size = productDto.getSkus().size();
			cnt = new Integer(0);
			for (int i = 0; i < size; i++) {

				ProductSkuDto sku = productDto.getSkus().get(i);
				sku.setProductCode(productDto.getCode());
				sku.setSkuNo(GUID.generateCode());// 没有从前台拿
				if (StringUtils.isEmpty(sku.getProductSpes())) {// 前端生成的规则
					sku.setProductSpes(getSpesCode(sku.getSkuDesc(), sepMap));
				}
				sku.setDelFlag(DelFlag.N.getValue());
				sku.setOrderNo(i);
				cnt += sku.getCnt();
				productSkuService.addProductSku(sku);
			}
		}
		// 商品价格END
		
		//商品素材图
		if(StringUtils.isNotEmpty(productDto.getProductMaterial())){
			String url = localCacheSystemParams.getSystemParam("cc","rw", "rwAdvUrl");
			String uploadUrl = localCacheSystemParams.getSystemParam("ms","upload", "uploadUrl");
			
			//先禁用所有产品素材图片
			productMaterialService.updateByProductCode(productDto.getCode());
			
			String[] productMaterials = productDto.getProductMaterial().split(",");
			String str = "";
			for (int i = 0; i < productMaterials.length; i++) {
				
				ProductMaterialDto productMaterial = new ProductMaterialDto();
				productMaterial.setImg(uploadUrl+productMaterials[i]);
				ProductMaterialDto productMaterialReturn = productMaterialService.findProductMaterial(productMaterial );
				//如果已存在就启用,否则新增
				if(null != productMaterialReturn){
					productMaterialService.updateStatusOpon(productMaterialReturn.getProductCode());
				}else{
					
					if(i!=productMaterials.length-1){
						str = uploadUrl+productMaterials[i] + ",";
					}else{
						str = uploadUrl+productMaterials[i];
					}
					str = uploadUrl + productMaterials[i];
					
					Map map = new HashMap<>();
					map.put("memberNoGuid", UserUtils.getUser().getId());
					map.put("links", str);
					map.put("productCode", productDto.getCode());
					String result = HttpClientUtils.postToWeb(url, map);
					
					if(StringUtils.isNotEmpty(result)){
						logger.debug("获取广告code返回结果:"+result);
						JSONObject obj = (JSONObject) JSON.parse(result);
						JSONObject object = (JSONObject) obj.get("returnObject");
						Set<String> keySet = object.keySet();
						for (String keys : keySet) {
							int orderNo = 1;
							ProductMaterialDto productMaterialDto = new ProductMaterialDto();
							productMaterialDto.setCode(GUID.generateByUUID());
							productMaterialDto.setAdvCode(object.getString(keys));
							productMaterialDto.setImg(keys);
							productMaterialDto.setOrderNo(orderNo);
							productMaterialDto.setProductCode(productDto.getCode());
							productMaterialDto.setStatus("0");
							productMaterialService.addProductMaterial(productMaterialDto);
							orderNo++;
						}
					}
				}
			}
		}
		
		
		

		ProductDto update = new ProductDto();
		update.setCode(productDto.getCode());
		update.setProductOrder(productOrder);// 修改排列顺序
		update.setProductKey(productKey.toString());// 修改搜索关键字
		update.setCnt(cnt);
		productService.updateProduct(update);

		addMessage(redirectAttributes, "修改商品'" + productDto.getName() + "'成功");
		return "redirect:" + adminPath + "/product/product/";
	}

	/** 启用/停用 */
	@RequiresPermissions("product:product:edit")
	@RequestMapping(value = "/status")
	public String status(ProductDto productDto, RedirectAttributes redirectAttributes) {
		if (ProductStatus.USE.getValue().equals(productDto.getStatus())) {
			productService.updateProduct(productDto);
			addMessage(redirectAttributes, "上架商品成功");
		} else if (ProductStatus.STOP.getValue().equals(productDto.getStatus())) {
			productService.updateProduct(productDto);
			addMessage(redirectAttributes, "下架商品成功");
		}
		return "redirect:" + adminPath + "/product/product/";
	}

	/***
	 * 修改sku 库存及价格。
	 *
	 * @param sku
	 * @return
	 * @author lhy 2017年8月30日
	 *
	 */

	@RequiresPermissions("product:product:edit")
	@RequestMapping(value = "/sku/edit")
	@ResponseBody
	public ResponseDto editSku(ProductSkuDto sku) {
		productSkuService.updateProductSku(sku);
		return ResponseDto.successResp(null);
	}
}
