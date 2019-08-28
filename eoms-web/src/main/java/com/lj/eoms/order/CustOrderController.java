package com.lj.eoms.order;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ape.common.web.BaseController;
import com.google.common.collect.Lists;
import com.lj.base.core.pagination.Page;
import com.lj.base.core.pagination.PageSortType;
import com.lj.eoms.utils.UserUtils;
import com.lj.eshop.dto.CustOrderDto;
import com.lj.eshop.dto.FindCustOrderPage;
import com.lj.eshop.emus.CustOrderPayType;
import com.lj.eshop.emus.CustOrderStatus;
import com.lj.eshop.service.ICustOrderService;

/**
 * 
 * 
 * 类说明：定制订单
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月29日
 */
@Controller
@RequestMapping("${adminPath}/order/cust")
public class CustOrderController  extends BaseController {
	
	public static final String LIST = "modules/order/cust/list";
	public static final String FORM = "modules/order/cust/form";
	public static final String EDIT = "modules/order/cust/edit";
	public static final String VIEW = "modules/order/cust/view";
	
	@Autowired
	private ICustOrderService custOrderService;
	
	
	/** 列表 */
	@RequiresPermissions("order:cust:view")
	@RequestMapping(value = {"list",""}, method ={RequestMethod.GET,RequestMethod.POST})
	public String list(CustOrderDto param,Integer pageNo,Integer pageSize, Model model) {
		try {
			param.setMerchantCode(UserUtils.getUser().getMerchant().getCode());
			FindCustOrderPage findCustOrderPage = new FindCustOrderPage();
			findCustOrderPage.setSortBy("create_time");
			findCustOrderPage.setSortDir(PageSortType.desc);
			findCustOrderPage.setParam(param);
			if(pageNo!=null){
				findCustOrderPage.setStart((pageNo-1)*pageSize);
			}
			if(pageSize!=null){
				findCustOrderPage.setLimit(pageSize);
			}
			Page<CustOrderDto> pageDto = custOrderService.findCustOrderPage(findCustOrderPage);
			List<CustOrderDto> list = Lists.newArrayList();
			list.addAll(pageDto.getRows());
			 
			com.ape.common.persistence.Page<CustOrderDto> page=new com.ape.common.persistence.Page<CustOrderDto>(pageNo==null?1:pageNo, pageDto.getLimit(), pageDto.getTotal(), list);
			page.initialize();
			model.addAttribute("page",page);
			model.addAttribute("status", CustOrderStatus.values());
			model.addAttribute("payTypes", CustOrderPayType.values());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return LIST;
	}

	/** 视图 */
	@RequiresPermissions("order:cust:view")
	@RequestMapping(value = {"form", "view"}, method = {RequestMethod.GET,RequestMethod.POST})
	public String form(String code, Model model) {
		try {
			CustOrderDto param = new CustOrderDto();
			param.setCode(code);
			CustOrderDto dto = custOrderService.findCustOrder(param);
			model.addAttribute("data", dto);
			model.addAttribute("status", CustOrderStatus.values());
			model.addAttribute("payTypes", CustOrderPayType.values());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return VIEW;
	}

	/** 发货 */
	@RequiresPermissions("order:cust:edit")
	@RequestMapping(value = "shipping")
	public String shipping(CustOrderDto orderDto, RedirectAttributes redirectAttributes) {
		custOrderService.shipping(orderDto, orderDto.getExpressNo(), orderDto.getExpressName());
		addMessage(redirectAttributes, "订单："+orderDto.getOrderNo()+"发货成功");
		return "redirect:" + adminPath + "/order/cust/";
	}
	
	
	/** 报价 */
	@RequiresPermissions("order:cust:edit")
	@RequestMapping(value = "offer")
	public String offer(CustOrderDto orderDto, RedirectAttributes redirectAttributes) {
		custOrderService.shipping(orderDto, orderDto.getExpressNo(), orderDto.getExpressName());
		addMessage(redirectAttributes, "订单："+orderDto.getOrderNo()+"发货成功");
		return "redirect:" + adminPath + "/order/cust/";
	}
}
