package com.lj.eoms.marketing;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ape.common.web.BaseController;
import com.google.common.collect.Lists;
import com.lj.base.core.pagination.Page;
import com.lj.base.core.pagination.PageSortType;
import com.lj.business.cm.dto.activity.AddActivity;
import com.lj.business.cm.dto.activity.FindActivity;
import com.lj.business.cm.dto.activity.FindActivityPage;
import com.lj.business.cm.dto.activity.FindActivityPageReturn;
import com.lj.business.cm.dto.activity.FindActivityReturn;
import com.lj.business.cm.dto.activity.UpdateActivity;
import com.lj.business.cm.service.IActivityService;
import com.lj.eoms.utils.UserUtils;
import com.lj.eshop.dto.MerchantDto;
import com.lj.eshop.service.IMerchantService;

/**
 * 
 * 
 * 类说明：活动@Controller
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月1日
 */
@Controller
@RequestMapping(value = "${adminPath}/cm/activity")
public class ActivityController extends BaseController {

	@Autowired
	private IActivityService activityService;			//活动服务
	@Autowired
	private IMerchantService merchantService;			
	/**
	 * 
	 *
	 * 方法说明：活动列表
	 *
	 * @param findActivityPage
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月1日
	 *
	 */
	@RequiresPermissions("cm:activity:view")
	@RequestMapping(value = {"list", ""})
	public String list(FindActivityPage findActivityPage,Integer pageNo,Integer pageSize, Model model) {
		try {
			findActivityPage.setMerchantNo(UserUtils.getUser().getMerchant().getCode());
			findActivityPage.setSortDir(PageSortType.desc);
			if(pageNo!=null){
				findActivityPage.setStart((pageNo-1)*pageSize);
			}
			if(pageSize!=null){
				findActivityPage.setLimit(pageSize);
			}
			Page<FindActivityPageReturn> pageDto = activityService.findActivityPage(findActivityPage);
			List<FindActivityPageReturn> list = Lists.newArrayList();
			list.addAll(pageDto.getRows());
			 
			com.ape.common.persistence.Page<FindActivityPageReturn> page=new com.ape.common.persistence.Page<FindActivityPageReturn>(pageNo==null?1:pageNo, pageDto.getLimit(), pageDto.getTotal(), list);
			page.initialize();
			model.addAttribute("page",page);
			model.addAttribute("findActivityPage",findActivityPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "modules/marketing/activity/activityList";
		
	}
	
	/**
	 * 
	 *
	 * 方法说明：活动表单
	 *
	 * @param findActivity
	 * @param model
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月1日
	 *
	 */
	@RequiresPermissions("cm:activity:view")
	@RequestMapping(value = "form")
	public String form(FindActivity findActivity, Model model) {
		try {
			if(findActivity!=null && findActivity.getCode()!=null){
				FindActivityReturn findActivityReturn= activityService.findActivity(findActivity);
				model.addAttribute("data",findActivityReturn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "modules/marketing/activity/activityForm";
	}
	
	/**
	 * 
	 *
	 * 方法说明：保存活动
	 *
	 * @param addActivity
	 * @param model
	 * @param redirectAttributes
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月14日
	 *
	 */
	@RequiresPermissions("cm:activity:edit")
	@RequestMapping(value = "save")
	public String save(AddActivity addActivity, Model model, RedirectAttributes redirectAttributes) {
		try {
			addActivity.setMerchantNo(UserUtils.getUser().getMerchant().getCode());
			addActivity.setMerchantName(UserUtils.getUser().getMerchant().getMerchantName());
			addActivity.setCreateId(UserUtils.getUser().getName());
			activityService.addActivity(addActivity);
			addMessage(redirectAttributes, "保存活动'" + addActivity.getTitle() + "'成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/cm/activity/";
	}
	
	/**
	 * 
	 *
	 * 方法说明：编辑活动
	 *
	 * @param updateActivity
	 * @param model
	 * @param redirectAttributes
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月14日
	 *
	 */
	@RequiresPermissions("cm:activity:edit")
	@RequestMapping(value = "edit")
	public String edit(UpdateActivity updateActivity, Model model, RedirectAttributes redirectAttributes) {
		try {
			activityService.updateActivity(updateActivity);
			addMessage(redirectAttributes, "保存活动'" + updateActivity.getTitle() + "'成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:" + adminPath + "/cm/activity/";
	}
	
	@RequiresPermissions("cm:activity:view")
	@RequestMapping(value = "view")
	public String view(FindActivity findActivity, Model model) {
		try {
			if(findActivity!=null && findActivity.getCode()!=null){
				FindActivityReturn findActivityReturn= activityService.findActivity(findActivity);
				model.addAttribute("data",findActivityReturn);
				if(!findActivityReturn.getMerchantNo().isEmpty()){
					MerchantDto parm = new MerchantDto();
					parm.setCode(findActivityReturn.getMerchantNo());
					MerchantDto merchantDto= merchantService.findMerchant(parm);
					//公司名
					model.addAttribute("companyName",merchantDto.getMerchantName());
				}
			}
		} catch (Exception e) {
		  e.printStackTrace();
		}
		return "modules/marketing/activity/activityView";
	}
	
	
	@RequestMapping(value = "viewH5")
	public String viewH5(FindActivity findActivity, Model model) {
		try {
			if(findActivity!=null && findActivity.getCode()!=null){
				FindActivityReturn findActivityReturn= activityService.findActivity(findActivity);
				model.addAttribute("data",findActivityReturn);
				
				if(!findActivityReturn.getMerchantNo().isEmpty()){
					MerchantDto parm = new MerchantDto();
					parm.setCode(findActivityReturn.getMerchantNo());
					MerchantDto merchantDto= merchantService.findMerchant(parm);
					//公司名
					model.addAttribute("companyName",merchantDto.getMerchantName());
				}
				
				/*增加阅读量*/
				Long readCount = findActivityReturn.getReadCount();
				UpdateActivity updateActivity = new UpdateActivity();
				updateActivity.setCode(findActivityReturn.getCode());
				updateActivity.setReadCount(readCount==null?0L:readCount+1); 
				activityService.updateActivity(updateActivity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return "modules/marketing/activity/activityH5";
	}
}
