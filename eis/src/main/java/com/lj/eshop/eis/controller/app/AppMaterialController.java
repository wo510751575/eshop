package com.lj.eshop.eis.controller.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.StringUtils;
import com.lj.business.cm.dto.AddMaterial;
import com.lj.business.cm.dto.AddMaterialType;
import com.lj.business.cm.dto.FindMaterialCommenPageReturn;
import com.lj.business.cm.dto.FindMaterialPageReturn;
import com.lj.business.cm.dto.FindMaterialType;
import com.lj.business.cm.dto.FindMaterialTypePage;
import com.lj.business.cm.dto.FindMaterialTypeReturn;
import com.lj.business.cm.dto.FindMaterialTypesApp;
import com.lj.business.cm.dto.FindMaterialTypesAppReturn;
import com.lj.business.cm.emus.MaterialDimensionStatus;
import com.lj.business.cm.service.IMaterialCommenService;
import com.lj.business.cm.service.IMaterialTypeService;
import com.lj.cc.clientintf.LocalCacheSystemParamsFromCC;
import com.lj.eshop.dto.CatalogDto;
import com.lj.eshop.dto.FindCatalogPage;
import com.lj.eshop.dto.FindMaterialEcmPage;
import com.lj.eshop.dto.FindProductPage;
import com.lj.eshop.dto.MateriaEcmDto;
import com.lj.eshop.dto.MaterialCmDto;
import com.lj.eshop.dto.ProductDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.EisMaterialDto;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.eis.utils.FileUtils;
import com.lj.eshop.emus.MaterialBizType;
import com.lj.eshop.emus.MaterialCmType;
import com.lj.eshop.service.ICatalogService;
import com.lj.eshop.service.IMaterialCmService;
import com.lj.eshop.service.IProductService;

/**
 * 素材类型 类说明：
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年9月20日
 */
@RestController
@RequestMapping("/appmaterial/")
public class AppMaterialController extends BaseController {

	// 个人素材目录
	private static final String MATERIAL_PRIVATE = "/image/materialPrivate/";
	// 商品素材目录
	private static final String MATERIAL_PRODUCT = "/image/productXc/";

	@Autowired
	private IMaterialTypeService materialTypeService;
	@Autowired
	private IMaterialCmService materialCmService;
	@Autowired
	private IMaterialCommenService materialCommenService;
	@Autowired
	private LocalCacheSystemParamsFromCC localCacheSystemParams;
	@Autowired
	private IProductService productService;
	@Autowired
	private ICatalogService catalogService;

	/**
	 * 
	 *
	 * 方法说明：素材类型列表
	 *
	 * @param findMaterialTypesApp
	 * @return
	 *
	 * @author 林进权 CreateDate: 2017年9月20日
	 *
	 */
	@RequestMapping(value = "findMaterialTypesApp")
	@ResponseBody
	public ResponseDto findMaterialTypesApp(FindMaterialTypesApp findMaterialTypesApp) {
		logger.debug("findMaterialTypesApp(FindMaterialTypesApp findMaterialTypesApp={}) - start", //$NON-NLS-1$
				findMaterialTypesApp);

		// 查找一级商品分类
		FindCatalogPage findCatalogPage = new FindCatalogPage();
		CatalogDto param = new CatalogDto();
		param.setParentCatalogCode("1");
		findCatalogPage.setParam(param);
		List<CatalogDto> catalogDtos = catalogService.findCatalogs(findCatalogPage);
		List<FindMaterialTypesAppReturn> list = rebuildMaterialTypeAppReturn(catalogDtos);

		// 自定义类型
		findMaterialTypesApp.setMemberNoGm(getLoginMemberCode());
		findMaterialTypesApp.setMerchantNo(getLoginMerchantCode());
		list.addAll(materialTypeService.findMaterialTypesAppEc(findMaterialTypesApp));

		return ResponseDto.successResp(list);
	}

	private List<FindMaterialTypesAppReturn> rebuildMaterialTypeAppReturn(List<CatalogDto> catalogDtos) {
		// 查找所有分类
		FindCatalogPage findCatalogPage = new FindCatalogPage();
		List<CatalogDto> catalogDtoList = catalogService.findCatalogs(findCatalogPage);

		List<FindMaterialTypesAppReturn> list = new ArrayList<FindMaterialTypesAppReturn>();
		List<String> catalogTypeCodes = null;
		for (CatalogDto catalogDto : catalogDtos) {

			catalogTypeCodes = new ArrayList<String>();
			findCatalogChildByPCode(catalogDtoList, catalogTypeCodes, catalogDto.getCode());
			catalogTypeCodes.add(catalogDto.getCode());

			FindMaterialTypesAppReturn app = new FindMaterialTypesAppReturn();
			app.setMaterialDimension("CATALOG"); // 商品分类
			app.setCode(catalogDto.getCode());
			app.setTypeName(catalogDto.getCatalogName());
			FindProductPage findProductPage = new FindProductPage();
			ProductDto dto = new ProductDto();
//			dto.setCatalogTypeCode(catalogDto.getCode());
			dto.setMerchantCode(getLoginMerchantCode());
			findProductPage.setParam(dto);
			findProductPage.setCatalogTypeCodes(catalogTypeCodes);
			long cnt = productService.findProductPageCount(findProductPage);
			app.setNumMaterial(cnt);

			list.add(app);
		}
		return list;
	}

	/**
	 * 
	 *
	 * 方法说明：分页查询素材类型列表
	 *
	 * @param findMaterialTypePage
	 * @return
	 *
	 * @author 林进权 CreateDate: 2017年9月20日
	 *
	 */
	@RequestMapping(value = "findMaterialTypePage")
	@ResponseBody
	public ResponseDto findMaterialTypes(FindMaterialTypePage findMaterialTypePage) {
		logger.debug("findMaterialTypes(FindMaterialTypePage findMaterialTypePage={}) - start", findMaterialTypePage); //$NON-NLS-1$
		findMaterialTypePage.setMemberNoGm(getLoginMemberCode());
		findMaterialTypePage.setMerchantNo(getLoginMerchantCode());
		return ResponseDto.successResp(materialTypeService.findMaterialTypePage(findMaterialTypePage));
	}

	/**
	 * 
	 *
	 * 方法说明：新增素材类型
	 *
	 * @param addMaterialType
	 * @return
	 *
	 * @author 林进权 CreateDate: 2017年9月20日
	 *
	 */
	@RequestMapping(value = "addMaterialType")
	@ResponseBody
	public ResponseDto addMaterialType(AddMaterialType addMaterialType) {
		logger.debug("addMaterialType(AddMaterialType addMaterialType={}) - start", addMaterialType); //$NON-NLS-1$
		if (StringUtils.isEmpty(addMaterialType.getTypeName())) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		addMaterialType.setMaterialDimension(MaterialDimensionStatus.PRIVATE.getValue());
		addMaterialType.setMemberNoGm(getLoginMemberCode());
		addMaterialType.setMemberNameGm(getLoginMember().getName());
		addMaterialType.setMerchantNo(getLoginMerchantCode());
		materialTypeService.addMaterialType(addMaterialType);
		return ResponseDto.successResp(null);
	}

	/**
	 * 
	 *
	 * 方法说明： 添加个人素材
	 * 
	 * @param addMaterial
	 * @return
	 *
	 * @author 林进权 CreateDate: 2017年9月22日
	 *
	 */
	@RequestMapping(value = "addMaterial")
	@ResponseBody
	public ResponseDto addMaterial(List<MultipartFile> imgAddrs, AddMaterial addMaterial) throws Exception {
		logger.debug("addMaterial(List<MultipartFile> imgAddrs={}, AddMaterial addMaterial={}) - start", imgAddrs); //$NON-NLS-1$

		if (StringUtils.isEmpty(addMaterial.getContent()) || StringUtils.isEmpty(addMaterial.getTitle())
				|| StringUtils.isEmpty(addMaterial.getMaterialTypeCode()) || imgAddrs == null || imgAddrs.size() == 0) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}

		addMaterial(imgAddrs, addMaterial, MaterialCmType.PRIVATE.getValue(), null, null, MATERIAL_PRIVATE);

		logger.debug("addMaterial(List<MultipartFile>, AddMaterial) - end"); //$NON-NLS-1$
		return ResponseDto.successResp(null);
	}

	/**
	 * 
	 * 方法说明：
	 *
	 * @param @param imgAddrs
	 * @param @param addMaterial
	 * @param @param type 2卖家素材， 6个人素材
	 * @param @param prodcutCode
	 * @param @throws IOException 设定文件
	 * @return void 返回类型
	 * @throws Exception
	 *
	 * @author 林进权 CreateDate: 2017年9月27日
	 */
	public void addMaterial(List<MultipartFile> imgAddrs, AddMaterial addMaterial, String type, String productCode,
			String productName, String imgPath) throws IOException {
		StringBuilder imgs = new StringBuilder("");
		ResourceBundle upload = ResourceBundle.getBundle("properties/upload");
		String ROOT = upload.getString("rootPath");
		String eomsPath = upload.getString("eomsPath");
		String IMG_PATH = imgPath;
		if (IMG_PATH.startsWith("/")) {
			IMG_PATH = imgPath.substring(1);
		}
		if (!CollectionUtils.isEmpty(imgAddrs)) {
			for (MultipartFile each : imgAddrs) {
				String imageFolder = ROOT + IMG_PATH;
				String fileInputName = FileUtils.saveFile(imageFolder, each);
				imgs.append(eomsPath + IMG_PATH).append(fileInputName).append(",");
			}
			imgs.deleteCharAt(imgs.length() - 1);
		}

		MateriaEcmDto materiaEcmDto = new MateriaEcmDto();
		materiaEcmDto.setImgAddr(imgs.toString());
		materiaEcmDto.setTitle(addMaterial.getTitle());
		materiaEcmDto.setContent(addMaterial.getContent());
		materiaEcmDto.setMaterialTypeCode(addMaterial.getMaterialTypeCode());
		materiaEcmDto.setType(type);
		materiaEcmDto.setProductCode(productCode);
		materiaEcmDto.setProductName(productName);

		// 素材添加
		/*
		 * GuidMbrDto guidMbrDto = getGuidMember(); // if(null!=guidMbrDto) {
		 * materiaEcmDto.setMemberNameGm(getLoginMember().getName());
		 * materiaEcmDto.setMemberNoGm(getLoginMemberCode());
		 * materiaEcmDto.setMerchantNo(guidMbrDto.getMerchantNo());
		 * materiaEcmDto.setMerchantName(guidMbrDto.getMerchantName());
		 * materiaEcmDto.setEcShopNo(guidMbrDto.getShopNo());
		 * materiaEcmDto.setShopName(guidMbrDto.getShopName());
		 */
//		}

		materiaEcmDto.setMerchantCode(getLoginMerchantCode());
		materiaEcmDto.setShopCode(getLoginShopCode());
		materialCmService.addMaterialSale(materiaEcmDto);
	}

	/**
	 * 
	 *
	 * 方法说明： 素材列表-个人素材
	 * 
	 * @param addMaterial
	 * @return
	 *
	 * @author 林进权 CreateDate: 2017年9月22日
	 *
	 */
	@RequestMapping(value = { "materialList" })
	@ResponseBody
	public ResponseDto materialList(Integer pageNo, Integer pageSize, String materialTypeCode) {
		logger.debug("AppMaterialController materialList()={} - start", materialTypeCode);
		if (StringUtils.isEmpty(materialTypeCode)) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}

		FindMaterialType findMaterialType = new FindMaterialType();
		findMaterialType.setCode(materialTypeCode);
		FindMaterialTypeReturn findMaterialTypeReturn = null;
		try {
			findMaterialTypeReturn = materialTypeService.findMaterialType(findMaterialType);
			if (null == findMaterialTypeReturn) {
				return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
			}
		} catch (Exception e) {
			logger.error("error material={}", e);
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}

		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null || pageSize > 500 ? 10 : pageSize;
		FindMaterialEcmPage findMaterialEcmPage = new FindMaterialEcmPage();
		findMaterialEcmPage.setStart((pageNo - 1) * pageSize);
		findMaterialEcmPage.setLimit(pageSize);
		MaterialCmDto findMaterialEcmPageParam = new MaterialCmDto();
		findMaterialEcmPage.setParam(findMaterialEcmPageParam);
		findMaterialEcmPageParam.setMerchantCode(getLoginMerchantCode());
		findMaterialEcmPageParam.setMaterialTypeCode(materialTypeCode);

		Page<MateriaEcmDto> page = null;
		// 如果是官方的分类
		if (StringUtils.equal(findMaterialTypeReturn.getMaterialDimension(),
				MaterialDimensionStatus.MERCHANT.getValue())) {

			page = materialCmService.findCmCommonMaterialPgae(findMaterialEcmPage);
		} else {

			findMaterialEcmPageParam.setShopCode(getLoginShopCode()); // 卖家的素材的需要传shopcode, 公共的不需要
			findMaterialEcmPageParam.setType(MaterialCmType.PRIVATE.getValue());
			page = materialCmService.findCmMaterialPgae(findMaterialEcmPage);
		}

		List<MateriaEcmDto> list = new ArrayList<MateriaEcmDto>();
		list.addAll(page.getRows());
		List<EisMaterialDto> eisMaterialDtos = reBuildEis(list);
		Page<EisMaterialDto> eisPage = new Page<EisMaterialDto>(eisMaterialDtos, page.getTotal(), page.getStart(),
				page.getLimit());
		logger.debug("AppMaterialController materialList() - end");
		return ResponseDto.successResp(eisPage);
	}

	/**
	 * 素材预览 方法说明：
	 *
	 * @param @param code
	 * @param @return 设定文件
	 * @return ResponseDto 返回类型
	 * @throws Exception
	 *
	 * @author 林进权 CreateDate: 2017年9月26日
	 */
	@RequestMapping(value = { "view" })
	@ResponseBody
	public ResponseDto view(String code) {
		logger.debug("AppMaterialController view() - start");
		if (StringUtils.isEmpty(code)) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}

		MateriaEcmDto findMateriaEcmDto = new MateriaEcmDto();
		findMateriaEcmDto.setCode(code);
		MateriaEcmDto rltMateriaEcmDto = materialCmService.findMaterialEcm(findMateriaEcmDto);
		logger.debug("AppMaterialController view() - end");
		return ResponseDto.successResp(reBuildEis(rltMateriaEcmDto));
	}

	/**
	 * 查找官方素材 方法说明：
	 *
	 * @param @param title
	 * @param @return 设定文件
	 * @return ResponseDto 返回类型
	 * @throws Exception
	 *
	 * @author 林进权 CreateDate: 2017年9月30日
	 */
	@RequestMapping(value = { "search" })
	@ResponseBody
	public ResponseDto search(String title) {
		logger.debug("AppMaterialController search() - start");
		if (StringUtils.isEmpty(title)) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}

		/*
		 * GuidMbrDto guidMbrDto = getGuidMember(); FindMaterialPage findMaterialPage =
		 * new FindMaterialPage(); findMaterialPage.setLimit(10);
		 * findMaterialPage.setMerchantNo(guidMbrDto.getMerchantNo());
		 * findMaterialPage.setTitle(title);
		 * findMaterialPage.setMemberNoGm(guidMbrDto.getMemberNo());
		 * 
		 * FindMaterialCommenPage findMaterialCommenPage = new FindMaterialCommenPage();
		 * findMaterialCommenPage.setLimit(10);
		 * findMaterialCommenPage.setMerchantNo(guidMbrDto.getMerchantNo());
		 * findMaterialCommenPage.setTitle(title); Page<FindMaterialCommenPageReturn>
		 * pageMaterialCommon = materialCommenService
		 * .findMaterialCommenPage(findMaterialCommenPage);
		 */

		/*
		 * List<FindMaterialPageReturn> materialList = new
		 * ArrayList<FindMaterialPageReturn>(); List<EisMaterialDto> eisMaterialDtos =
		 * reBuildMaterials(materialList);
		 * 
		 * List<FindMaterialCommenPageReturn> commonList = new
		 * ArrayList<FindMaterialCommenPageReturn>();
		 * commonList.addAll(pageMaterialCommon.getRows()); List<EisMaterialDto> common
		 * = reBuildCommonMaterials(commonList);
		 * 
		 * eisMaterialDtos.addAll(common);
		 */
		logger.debug("AppMaterialController search() - end");
//		return ResponseDto.successResp(eisMaterialDtos);
		return ResponseDto.successResp();
	}

	private List<EisMaterialDto> reBuildMaterials(List<FindMaterialPageReturn> commonList) {
		List<EisMaterialDto> eisMaterialDtos = new ArrayList<EisMaterialDto>();
		if (commonList.size() > 0) {
			for (FindMaterialPageReturn source : commonList) {
				EisMaterialDto eisMaterialDto = new EisMaterialDto();
				eisMaterialDto.setImgs(source.getImgAddr());
				eisMaterialDto.setCode(source.getCode());
				eisMaterialDto.setRemarks(source.getContent());
				eisMaterialDto.setMaterialCmCode(source.getCode());
				// eisMaterialDto.setBizType(MaterialCmType.PRIVATE.getValue());
				eisMaterialDto.setCreateTime(source.getCreateDate());
				eisMaterialDto.setTitle(source.getTitle());
				eisMaterialDto.setMerchantCode(getLoginMerchantCode());
				eisMaterialDtos.add(eisMaterialDto);
			}
		}
		return eisMaterialDtos;
	}

	private List<EisMaterialDto> reBuildCommonMaterials(List<FindMaterialCommenPageReturn> commonList) {
		List<EisMaterialDto> eisMaterialDtos = new ArrayList<EisMaterialDto>();
		if (commonList.size() > 0) {
			for (FindMaterialCommenPageReturn source : commonList) {
				EisMaterialDto eisMaterialDto = new EisMaterialDto();
				eisMaterialDto.setImgs(source.getImgAddr());
				eisMaterialDto.setCode(source.getCode());
				eisMaterialDto.setRemarks(source.getContent());
				eisMaterialDto.setMaterialCmCode(source.getCode());
				eisMaterialDto.setBizType(MaterialCmType.PUBLIC.getValue());
				eisMaterialDto.setCreateTime(source.getCreateDate());
				eisMaterialDto.setTitle(source.getTitle());
				eisMaterialDto.setMerchantCode(getLoginMerchantCode());
				eisMaterialDtos.add(eisMaterialDto);
			}
		}
		return eisMaterialDtos;
	}

	private List<EisMaterialDto> reBuildEis(List<MateriaEcmDto> list) {
		List<EisMaterialDto> eisMaterialDtos = new ArrayList<EisMaterialDto>();
		if (list.size() > 0) {
			for (MateriaEcmDto materiaEcmDto : list) {
				eisMaterialDtos.add(reBuildEis(materiaEcmDto));
			}
		}
		return eisMaterialDtos;
	}

	private EisMaterialDto reBuildEis(MateriaEcmDto materiaEcmDto) {
		EisMaterialDto eisMaterialDto = new EisMaterialDto();
		eisMaterialDto.setImgs(materiaEcmDto.getImgAddr());
		eisMaterialDto.setCode(materiaEcmDto.getCode());
		eisMaterialDto.setRemarks(materiaEcmDto.getContent());
		eisMaterialDto.setProductCode(materiaEcmDto.getProductCode());
		eisMaterialDto.setMaterialCmCode(materiaEcmDto.getMaterialCmCode());
		eisMaterialDto.setBizType(materiaEcmDto.getType());
		eisMaterialDto.setCreateTime(materiaEcmDto.getCreateDate());
		eisMaterialDto.setTitle(materiaEcmDto.getTitle());
		eisMaterialDto.setMerchantCode(getLoginMerchantCode());

		if (StringUtils.equal(materiaEcmDto.getType(), MaterialCmType.PUBLIC.getValue())) {
			eisMaterialDto.setMaterialdimension(MaterialDimensionStatus.MERCHANT.getValue());

		} else if (StringUtils.equal(materiaEcmDto.getType(), MaterialCmType.SALE.getValue())) {
			eisMaterialDto.setMaterialdimension(MaterialDimensionStatus.SHOP.getValue());

		} else if (StringUtils.equal(materiaEcmDto.getType(), MaterialCmType.PRIVATE.getValue())) {
			eisMaterialDto.setMaterialdimension(MaterialDimensionStatus.PRIVATE.getValue());

		}

		String url = localCacheSystemParams.getSystemParam("eis", "material_viewh5", "cp_material_viewh5")
				+ materiaEcmDto.getCode();
		logger.debug("app material url={}", url);
		// TODO 素材返回h5预览
		eisMaterialDto.setUrl(url);
		return eisMaterialDto;
	}

	/**
	 * 营销-我的素材列表 方法说明：
	 * 
	 * @param pageNo      页码
	 * @param pageSize    每页数量
	 * @param productCode 商品编码/不传查全部
	 * @param bizType     0私人、1官方/不传时不默认查个人
	 * @author 林进权 CreateDate: 2017年9月4日
	 */
	@RequestMapping(value = "materiaProductlList")
	@ResponseBody
	public ResponseDto materiaProductlList(Integer pageNo, Integer pageSize, String productCode, String bizType) {
		logger.debug("MaterialController list() - start");
		if (StringUtils.isEmpty(bizType)) {
			bizType = MaterialBizType.MALE.getValue();
		}
		if (StringUtils.isEmpty(productCode)) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}

		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null || pageSize > 500 ? 10 : pageSize;
		FindMaterialEcmPage findMaterialEcmPage = new FindMaterialEcmPage();
		findMaterialEcmPage.setStart((pageNo - 1) * pageSize);
		findMaterialEcmPage.setLimit(pageSize);
		MaterialCmDto findMaterialEcmPageParam = new MaterialCmDto();
		findMaterialEcmPage.setParam(findMaterialEcmPageParam);

		findMaterialEcmPageParam.setMerchantCode(getLoginMerchantCode());
		findMaterialEcmPageParam.setType(bizType);
		findMaterialEcmPageParam.setProductCode(productCode);

		Page<MateriaEcmDto> page = null;
		if (StringUtils.isEmpty(bizType) || StringUtils.equal(MaterialBizType.MALE.getValue(), bizType)) {
			findMaterialEcmPageParam.setShopCode(getLoginShopCode()); // 卖家的素材的需要传shopcode, 公共的不需要
			page = materialCmService.findCmMaterialPgae(findMaterialEcmPage);
		} else {

			page = materialCmService.findCmCommonMaterialPgae(findMaterialEcmPage);
		}

		List<MateriaEcmDto> list = new ArrayList<MateriaEcmDto>();
		list.addAll(page.getRows());
		List<EisMaterialDto> eisMaterialDtos = reBuildEis(list);
		Page<EisMaterialDto> eisPage = new Page<EisMaterialDto>(eisMaterialDtos, page.getTotal(), page.getStart(),
				page.getLimit());

		return ResponseDto.successResp(eisPage);
	}

	/**
	 * 添加商品素材 方法说明：
	 * 
	 * @author 林进权 CreateDate: 2017年9月27日
	 */
	@RequestMapping(value = "addMaterialProduct")
	@ResponseBody
	public ResponseDto addMaterialProduct(List<MultipartFile> imgAddrs, AddMaterial addMaterial, String productCode)
			throws Exception {
		logger.debug("addMaterial(List<MultipartFile> imgAddrs={}, AddMaterial addMaterial={}) - start", imgAddrs); //$NON-NLS-1$

		if (StringUtils.isEmpty(addMaterial.getContent()) || StringUtils.isEmpty(productCode) || imgAddrs == null
				|| imgAddrs.size() == 0) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}

		ProductDto paramProductDto = new ProductDto();
		paramProductDto.setCode(productCode);
		ProductDto productDto = productService.findProduct(paramProductDto);
		if (null == productDto) {
			logger.debug("MaterialController add fauil for product is null");
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}

		addMaterial.setTitle(productDto.getName());
		addMaterial(imgAddrs, addMaterial, MaterialCmType.SALE.getValue(), productCode, productDto.getName(),
				MATERIAL_PRODUCT);
		logger.debug("addMaterial(List<MultipartFile>, AddMaterial) - end"); //$NON-NLS-1$
		return ResponseDto.successResp(null);
	}

	/**
	 * 删除素材
	 */
	@RequestMapping(value = "materiaProductldel")
	@ResponseBody
	public ResponseDto materiaProductldel(String code) {
		logger.debug("MaterialController del() - start", code);

		if (StringUtils.isEmpty(code)) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}

		try {
			MaterialCmDto materialCmDto = new MaterialCmDto();
			materialCmDto.setCode(code);
			materialCmService.delCmMaterial(materialCmDto);

			logger.debug("MaterialController --> del(={}) - end");
			return ResponseDto.successResp(null);
		} catch (Exception e) {
			return ResponseDto.generateFailureResponse(e);
		}
	}

	/**
	 * 
	 * 方法说明： 商品列表
	 * 
	 * @param addMaterial
	 * @return
	 *
	 * @author 林进权 CreateDate: 2017年9月22日
	 *
	 */
	@RequestMapping(value = { "productList" })
	@ResponseBody
	public ResponseDto productList(String catalogCode) {
		logger.debug("AppMaterialController productList()={} - start", catalogCode);
		if (StringUtils.isEmpty(catalogCode)) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}

		// 查找所有分类
		FindCatalogPage findCatalogPage = new FindCatalogPage();
		List<CatalogDto> catalogDtos = catalogService.findCatalogs(findCatalogPage);
		List<String> catalogTypeCodes = new ArrayList<>();
		findCatalogChildByPCode(catalogDtos, catalogTypeCodes, catalogCode);
		catalogTypeCodes.add(catalogCode);

		FindProductPage findProductPage = new FindProductPage();
		ProductDto dto = new ProductDto();
		// dto.setCatalogTypeCode(catalogCode);
		dto.setMerchantCode(getLoginMerchantCode());
		findProductPage.setParam(dto);
		findProductPage.setCatalogTypeCodes(catalogTypeCodes);
		List<ProductDto> list = productService.findProducts(findProductPage);
		List<Map<String, String>> maps = new LinkedList<Map<String, String>>();
		for (ProductDto productDto : list) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", productDto.getName());
			map.put("code", productDto.getCode());
			maps.add(map);
		}
		logger.debug("AppMaterialController productList() - end");
		return ResponseDto.successResp(maps);
	}

	/**
	 * 查找商品 方法说明：
	 *
	 * @param @param title
	 * @param @return 设定文件
	 * @return ResponseDto 返回类型
	 * @throws Exception
	 *
	 * @author 林进权 CreateDate: 2017年9月30日
	 */
	@RequestMapping(value = { "searchProduct" })
	@ResponseBody
	public ResponseDto searchProduct(String title, String catalogCode) {
		logger.debug("AppMaterialController search() - start");
		if (StringUtils.isEmpty(title) || StringUtils.isEmpty(catalogCode)) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}

		FindProductPage findProductPage = new FindProductPage();
		ProductDto dto = new ProductDto();
		dto.setCatalogTypeCode(catalogCode);
		dto.setName(title);
		findProductPage.setParam(dto);
		List<ProductDto> list = productService.findProducts(findProductPage);
		List<Map<String, String>> maps = new LinkedList<Map<String, String>>();
		for (ProductDto productDto : list) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", productDto.getName());
			map.put("code", productDto.getCode());
			maps.add(map);
		}
		logger.debug("AppMaterialController search() - end");
		return ResponseDto.successResp(maps);
	}

	/**
	 * 查找所有子分类通过父代码 方法说明：
	 *
	 * @author 林进权 CreateDate: 2017年10月12日
	 */
	private void findCatalogChildByPCode(List<CatalogDto> catalogDtos, List<String> catalogTypeCodes, String pcode) {
		for (CatalogDto catalogDto : catalogDtos) {
			if (StringUtils.equals(catalogDto.getParentCatalogCode(), pcode)) {
				catalogTypeCodes.add(catalogDto.getCode());
				findCatalogChildByPCode(catalogDtos, catalogTypeCodes, catalogDto.getCode());
			}
		}
	}
}
