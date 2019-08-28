package com.lj.eoms.sys;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ape.common.web.BaseController;
import com.google.common.collect.Lists;
import com.lj.base.core.pagination.Page;
import com.lj.eshop.dto.FindSuggestionPage;
import com.lj.eshop.dto.SuggestionDto;
import com.lj.eshop.service.ISuggestionService;

/**
 * 日志Controller
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/suggestion")
public class SuggestionController extends BaseController {

	public static final String LIST = "modules/sys/suggestionList";
	public static final String SETTING_LIST = "modules/sys/suggestionSetting";
	public static final String FORM = "modules/sys/suggestionForm";
	public static final String EDIT = "modules/sys/suggestionEdit";
	public static final String VIEW = "modules/sys/suggestionView";
	
	@Autowired
	private ISuggestionService suggestionService;

	/** 列表 */
	@RequiresPermissions("sys:suggestion:view")
	@RequestMapping(value = {"list", ""})
	public String list(FindSuggestionPage suggestionPage,Integer pageNo,Integer pageSize, Model model) {
		SuggestionDto suggestion=suggestionPage.getParam();
		if(suggestion==null){
			suggestion=new SuggestionDto();
		}
		suggestionPage.setParam(suggestion);
		if(pageNo!=null){
			suggestionPage.setStart((pageNo-1)*pageSize);
		}
		if(pageSize!=null){
			suggestionPage.setLimit(pageSize);
		}
		Page<SuggestionDto> pageDto = suggestionService.findSuggestionPage(suggestionPage);
		List<SuggestionDto> list = Lists.newArrayList();
		list.addAll(pageDto.getRows());
		 
		com.ape.common.persistence.Page<SuggestionDto> page=new com.ape.common.persistence.Page<SuggestionDto>(pageNo==null?1:pageNo, pageDto.getLimit(), pageDto.getTotal(), list);
		page.initialize();
		
		model.addAttribute("page",page);
		model.addAttribute("suggestionPage",suggestionPage);
		return LIST;
	}
}
