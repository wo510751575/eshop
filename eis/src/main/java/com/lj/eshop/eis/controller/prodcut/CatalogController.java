package com.lj.eshop.eis.controller.prodcut;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.util.StringUtils;
import com.lj.eshop.dto.CatalogDto;
import com.lj.eshop.dto.FindCatalogPage;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.emus.DelFlag;
import com.lj.eshop.emus.Recommend;
import com.lj.eshop.service.ICatalogService;

/**
 * 
 * 
 * 类说明：商品分类
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年9月2日
 */
@RestController
@RequestMapping("/product/catalog")
public class CatalogController extends BaseController{
	
	@Autowired
	private ICatalogService catalogService;

	/**
	 * 
	 *
	 * 方法说明：获取商品一级分类列表
	 *
	 * @param catalogDto
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月24日
	 *
	 */
	@RequestMapping(value = {"catalogList"})
	@ResponseBody
	public ResponseDto catalogList() {
		logger.debug("product --> catalogList(={}) - start");
		try {
			List<CatalogDto> list = new ArrayList<CatalogDto>();
			CatalogDto catalogDto = new CatalogDto();
			catalogDto.setDelFlag(DelFlag.N.getValue());
			catalogDto.setParentCatalogCode(CatalogDto.getRootId());
			FindCatalogPage findCatalogPage =new FindCatalogPage();
			findCatalogPage.setParam(catalogDto);
			List<CatalogDto> sourcelist = catalogService.findCatalogs(findCatalogPage);
			
			CatalogDto.sortList(list, sourcelist, CatalogDto.getRootId(), true);
			CatalogDto tjDto = new CatalogDto();
			tjDto.setCatalogName("推荐");
			list.add(0, tjDto);
			logger.debug("product --> catalogList( return={}) - end",list);
			return ResponseDto.successResp(list);
		} catch (Exception e) {
			return ResponseDto.generateFailureResponse(e);
		}
	}
	
	/**
	 * 
	 *
	 * 方法说明：根据父级Code获取子级列表
	 *
	 * @param isRecommend	是否推荐分类
	 * @param parentCode	父级Code
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月24日
	 *
	 */
	@RequestMapping(value = {"getCatalogByParent"})
	@ResponseBody
	public ResponseDto getCatalogByParent(Boolean isRecommend,String parentCode) {
		logger.debug("product --> getCatalogByParent(Boolean isRecommend ={},String parentCode={}) - start",isRecommend,parentCode);
		try {
			if(isRecommend ==null && StringUtils.isEmpty(parentCode)){
				return ResponseDto .createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
			}
			CatalogDto catalogDto = new CatalogDto();
			catalogDto.setDelFlag(DelFlag.N.getValue());
			/*获取推荐分类*/
			if(isRecommend){
				catalogDto.setRecommend(Recommend.Y.getValue());
			}else{
				catalogDto.setParentCatalogCode(parentCode);
			}
			FindCatalogPage findCatalogPage =new FindCatalogPage();
			findCatalogPage.setParam(catalogDto);
			List<CatalogDto> sourcelist = catalogService.findCatalogs(findCatalogPage);
			logger.debug("product --> getCatalogByParent( return={}) - end",sourcelist);
			return ResponseDto.successResp(sourcelist);
		} catch (Exception e) {
			return ResponseDto.generateFailureResponse(e);
		}
	}
}
