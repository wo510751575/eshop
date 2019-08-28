package com.lj.eoms.product;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ape.common.utils.StringUtils;
import com.ape.common.web.BaseController;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lj.eoms.utils.UserUtils;
import com.lj.eshop.dto.CatalogDto;
import com.lj.eshop.dto.FindCatalogPage;
import com.lj.eshop.emus.DelFlag;
import com.lj.eshop.service.ICatalogService;

/**
 * 
 * 
 * 类说明：商品分类@Controller
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月23日
 */
@Controller
@RequestMapping("${adminPath}/product/catalog")
public class CatalogController extends BaseController{

	@Autowired
	private ICatalogService catalogService;

	@RequiresPermissions("product:catalog:view")
	@RequestMapping(value = {"list", ""})
	public String list(CatalogDto catalogDto,Integer pageNo,Integer pageSize, Model model) {
		try {
			List<CatalogDto> list = Lists.newArrayList();
			catalogDto.setDelFlag(DelFlag.N.getValue());
			FindCatalogPage findCatalogPage =new FindCatalogPage();
			findCatalogPage.setParam(catalogDto);
			List<CatalogDto> sourcelist = catalogService.findCatalogs(findCatalogPage);
			
			CatalogDto.sortList(list, sourcelist, CatalogDto.getRootId(), true);
			model.addAttribute("list",list);
			model.addAttribute("findCatalogPage",findCatalogPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "modules/product/catalog/list";
	}
	
	@RequiresPermissions("product:catalog:view")
	@RequestMapping(value = "form")
	public String form(String code,String parentCatalogCode, Model model) {
		try {
			if (StringUtils.isNotBlank(parentCatalogCode)){
				CatalogDto catalogDto = new CatalogDto();
				catalogDto.setCode(parentCatalogCode);
				CatalogDto dto= catalogService.findCatalog(catalogDto);
				
				CatalogDto returnDto = new CatalogDto();
				returnDto.setParentCatalogCode(parentCatalogCode);
				returnDto.setParentCatalogName(dto.getCatalogName());
				model.addAttribute("data", returnDto);
			}
			if (StringUtils.isNotBlank(code)){
				CatalogDto catalogDto = new CatalogDto();
				catalogDto.setCode(code);
				CatalogDto dto= catalogService.findCatalog(catalogDto);
				model.addAttribute("data", dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "modules/product/catalog/form";
	}
	
	@RequiresPermissions("product:catalog:edit")
	@RequestMapping(value = "save")
	public String save(CatalogDto catalogDto, Model model, RedirectAttributes redirectAttributes) {
		try {
			catalogDto.setCreater(UserUtils.getUser().getName());
			catalogService.addCatalog(catalogDto);
			addMessage(redirectAttributes, "保存商品分类'" + catalogDto.getCatalogName() + "'成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/product/catalog/";
	}
	
	@RequiresPermissions("product:catalog:edit")
	@RequestMapping(value = "edit")
	public String edit(CatalogDto catalogDto, Model model, RedirectAttributes redirectAttributes) {
		try {
			if(catalogDto.getRecommend()==null){
				catalogDto.setRecommend("0");
			}
			catalogService.updateCatalog(catalogDto);
			addMessage(redirectAttributes, "保存商品分类'" + catalogDto.getCatalogName() + "'成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/product/catalog/";
	}
	
	@RequiresPermissions("product:catalog:edit")
	@RequestMapping(value = "delete")
	public String delete(CatalogDto catalogDto, RedirectAttributes redirectAttributes) {
		catalogDto.setDelFlag(DelFlag.Y.getValue());
		catalogService.updateCatalog(catalogDto);
		addMessage(redirectAttributes, "删除菜单成功");
		return "redirect:" + adminPath + "/product/catalog/";
	}
	
	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId,@RequestParam(required=false) String isShowHide, HttpServletResponse response) {
		CatalogDto catalogDto = new CatalogDto();
		catalogDto.setDelFlag(DelFlag.N.getValue());
		FindCatalogPage findCatalogPage =new FindCatalogPage();
		findCatalogPage.setParam(catalogDto);
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<CatalogDto> list = catalogService.findCatalogs(findCatalogPage);
		for (int i=0; i<list.size(); i++){
			CatalogDto e = list.get(i);
			if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getCode()))){
				if(isShowHide != null && isShowHide.equals("0")){
					continue;
				}
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getCode());
				map.put("pId", e.getParentCatalogCode());
				map.put("name", e.getCatalogName());
				mapList.add(map);
			}
		}
		return mapList;
	}
}
