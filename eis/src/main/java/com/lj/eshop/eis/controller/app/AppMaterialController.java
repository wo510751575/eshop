package com.lj.eshop.eis.controller.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.StringUtils;
import com.lj.business.cm.dto.AddMaterial;
import com.lj.business.cm.dto.AddMaterialType;
import com.lj.business.cm.dto.FindMaterialTypePage;
import com.lj.business.cm.dto.FindMaterialTypesApp;
import com.lj.business.cm.service.IMaterialTypeService;
import com.lj.eshop.dto.FindMaterialEcmPage;
import com.lj.eshop.dto.MateriaEcmDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.EisMaterialDto;
import com.lj.eshop.eis.dto.GuidMbrDto;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.eis.utils.FileUtils;
import com.lj.eshop.emus.MaterialBizType;
import com.lj.eshop.emus.MaterialCmType;
import com.lj.eshop.service.IMaterialCmService;


/**
 * 素材类型
 * 类说明：
 * 
 * <p>
 * 
 * @Company: 领居科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年9月20日
 */
@Controller
@RequestMapping("/app/material/")
public class AppMaterialController extends BaseController {
	
	@Autowired
	private IMaterialTypeService materialTypeService;
	@Autowired
	private IMaterialCmService materialCmService;
	
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
	public  ResponseDto findMaterialTypesApp(FindMaterialTypesApp findMaterialTypesApp) {
		logger.debug("findMaterialTypesApp(FindMaterialTypesApp findMaterialTypesApp={}) - start", findMaterialTypesApp); //$NON-NLS-1$
		findMaterialTypesApp.setMemberNoGm(getGuidMember().getMemberNo());
		findMaterialTypesApp.setMerchantNo(getGuidMember().getMerchantNo());
		return ResponseDto.successResp(materialTypeService.findMaterialTypesApp(findMaterialTypesApp));
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
		findMaterialTypePage.setMemberNoGm(getGuidMember().getMemberNo());
		findMaterialTypePage.setMerchantNo(getGuidMember().getMerchantNo());
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
		if(StringUtils.isEmpty(addMaterialType.getTypeName())) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		addMaterialType.setMemberNoGm(getGuidMember().getMemberNo());
		addMaterialType.setMerchantNo(getGuidMember().getMerchantNo());
		materialTypeService.addMaterialType(addMaterialType);
		return ResponseDto.successResp(null);
	}
	
	
	/**
	 * 
	 *
	 * 方法说明： 添加素材
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

		if(StringUtils.isEmpty(addMaterial.getContent()) || StringUtils.isEmpty(addMaterial.getTitle())
				|| StringUtils.isEmpty(addMaterial.getMaterialTypeCode())
				|| imgAddrs==null || imgAddrs.size()==0
				){
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		
		StringBuilder imgs =new StringBuilder("");
		String ROOT ="/www/temp/output/eoms/";
		String IMG_PATH ="/eoms/image/material/";
		if(!CollectionUtils.isEmpty(imgAddrs)){
			for (MultipartFile each : imgAddrs) {
				String imageFolder =  ROOT + IMG_PATH;
				String fileInputName= FileUtils.saveFile(imageFolder, each);
				imgs.append(IMG_PATH).append(fileInputName).append(",");
			}
			imgs.deleteCharAt(imgs.length() - 1);
		}
		MateriaEcmDto materiaEcmDto = new MateriaEcmDto();
		materiaEcmDto.setImgAddr(imgs.toString());
		materiaEcmDto.setTitle(addMaterial.getTitle());
		materiaEcmDto.setContent(addMaterial.getContent());
		materiaEcmDto.setType(MaterialCmType.PRIVATE.getValue());
		
		//素材添加
		GuidMbrDto guidMbrDto = getGuidMember();
		if(null!=guidMbrDto) {
			materiaEcmDto.setEcGuildNo(guidMbrDto.getMemberNo());
			materiaEcmDto.setEcMerchantNo(guidMbrDto.getMerchantNo());
			materiaEcmDto.setMerchantName(guidMbrDto.getMerchantName());
			materiaEcmDto.setEcShopNo(guidMbrDto.getShopNo());
			materiaEcmDto.setShopName(guidMbrDto.getShopName());
		}
		
		materiaEcmDto.setMemberNameGm(getLoginMember().getName());
		materiaEcmDto.setMemberNoGm(getLoginMemberCode());
		materiaEcmDto.setMerchantNo(getLoginMerchantCode());
		materiaEcmDto.setShopNo(getLoginShopCode());
		materialCmService.addMaterialSale(materiaEcmDto);
		logger.debug("addMaterial(List<MultipartFile>, AddMaterial) - end"); //$NON-NLS-1$
		return ResponseDto.successResp(null);
	}
	

	/**
	 * 
	 *
	 * 方法说明： 素材列表
	 * 
	 * @param addMaterial
	 * @return
	 *
	 * @author 林进权 CreateDate: 2017年9月22日
	 *
	 */
	@RequestMapping(value = {"materialList"})
	@ResponseBody
	public ResponseDto list(Integer pageNo, Integer pageSize, String productCode, String bizType) {
		logger.debug("MaterialController list() - start"); 
		if(StringUtils.isEmpty(bizType) ){
			bizType = MaterialBizType.MALE.getValue();
		}
		
		pageNo = pageNo==null?1:pageNo;
		pageSize = pageSize==null || pageSize>500?10:pageSize;
		FindMaterialEcmPage findMaterialReturnPage = new FindMaterialEcmPage();
		findMaterialReturnPage.setStart((pageNo - 1) * pageSize);
		findMaterialReturnPage.setLimit(pageSize);
		
		findMaterialReturnPage.setMerchantCode(getLoginMerchantCode());

		Page<MateriaEcmDto> page = null;
		if(StringUtils.isEmpty(bizType) || StringUtils.equal(MaterialBizType.MALE.getValue(), bizType)) {
			findMaterialReturnPage.setMemberNo(getLoginMemberCode());
			findMaterialReturnPage.setShopCode(getLoginShopCode());
			
			page = materialCmService.findCmMaterialPgae(findMaterialReturnPage);
		} else {
			
			page = materialCmService.findCmCommonMaterialPgae(findMaterialReturnPage);
		}
		
		List<MateriaEcmDto> list = new ArrayList<MateriaEcmDto>();
		list.addAll(page.getRows());
		List<EisMaterialDto> eisMaterialDtos = reBuildEis(list);
		Page<EisMaterialDto> eisPage = new Page<EisMaterialDto>(eisMaterialDtos, page.getTotal(), page.getStart(), page.getLimit());
		return ResponseDto.successResp(eisPage);
	}
	
	
	private List<EisMaterialDto> reBuildEis(List<MateriaEcmDto> list) {
		List<EisMaterialDto> eisMaterialDtos = new ArrayList<EisMaterialDto>();
		if(list.size()>0) {
			for (MateriaEcmDto materiaEcmDto : list) {
				EisMaterialDto eisMaterialDto = new EisMaterialDto();
				eisMaterialDto.setImgs(materiaEcmDto.getImgAddr());
				eisMaterialDto.setCode(materiaEcmDto.getCode());
				eisMaterialDto.setRemarks(materiaEcmDto.getContent());
				eisMaterialDto.setProductCode(materiaEcmDto.getProductCode());
				eisMaterialDto.setMaterialCmCode(materiaEcmDto.getMaterialCmCode());
				eisMaterialDto.setBizType(materiaEcmDto.getType());
				eisMaterialDto.setCreateTime(materiaEcmDto.getCreateDate());
				eisMaterialDto.setTitle(materiaEcmDto.getTitle());
				eisMaterialDtos.add(eisMaterialDto);
			}
		}
		return eisMaterialDtos;
	}
	
	
}
