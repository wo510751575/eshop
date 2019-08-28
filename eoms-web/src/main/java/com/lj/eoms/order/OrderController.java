package com.lj.eoms.order;

import java.math.BigDecimal;
import java.util.Date;
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
import com.lj.eshop.constant.NoUtil;
import com.lj.eshop.dto.AccountDto;
import com.lj.eshop.dto.FindOrderPage;
import com.lj.eshop.dto.OrderDto;
import com.lj.eshop.dto.PaymentDto;
import com.lj.eshop.emus.AccWaterPayType;
import com.lj.eshop.emus.AccWaterSource;
import com.lj.eshop.emus.DelFlag;
import com.lj.eshop.emus.OrderInvoice;
import com.lj.eshop.emus.OrderStatus;
import com.lj.eshop.emus.PaymentStatus;
import com.lj.eshop.emus.PaymentType;
import com.lj.eshop.service.IAccountService;
import com.lj.eshop.service.IOrderService;
import com.lj.eshop.service.IPaymentService;

/**
 * 
 * 
 * 类说明：订单
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年7月22日
 */
@Controller
@RequestMapping("${adminPath}/order/order")
public class OrderController  extends BaseController {
	
	public static final String LIST = "modules/order/list";
	public static final String FORM = "modules/order/form";
	public static final String EDIT = "modules/order/edit";
	public static final String VIEW = "modules/order/view";
	
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private IAccountService accountService;
	
	/** 列表 */
	@RequiresPermissions("order:order:view")
	@RequestMapping(value = {"list",""}, method ={RequestMethod.GET,RequestMethod.POST})
	public String list(OrderDto param,Integer pageNo,Integer pageSize, Model model) {
		try {
			param.setMerchantCode(UserUtils.getUser().getMerchant().getCode());
			FindOrderPage findOrderPage = new FindOrderPage();
			findOrderPage.setSortBy("create_time");
			findOrderPage.setSortDir(PageSortType.desc);
			findOrderPage.setParam(param);
			if(pageNo!=null){
				findOrderPage.setStart((pageNo-1)*pageSize);
			}
			if(pageSize!=null){
				findOrderPage.setLimit(pageSize);
			}
			Page<OrderDto> pageDto = orderService.findOrderPage(findOrderPage);
			List<OrderDto> list = Lists.newArrayList();
			list.addAll(pageDto.getRows());
			 
			com.ape.common.persistence.Page<OrderDto> page=new com.ape.common.persistence.Page<OrderDto>(pageNo==null?1:pageNo, pageDto.getLimit(), pageDto.getTotal(), list);
			page.initialize();
			model.addAttribute("page",page);
			model.addAttribute("orderStatus", OrderStatus.values());
			model.addAttribute("payTypes", AccWaterPayType.values());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return LIST;
	}

	/** 视图 */
	@RequiresPermissions("order:order:view")
	@RequestMapping(value = {"form", "view"}, method = {RequestMethod.GET,RequestMethod.POST})
	public String form(String code, Model model) {
		try {
			OrderDto param = new OrderDto();
			param.setCode(code);
			OrderDto dto = orderService.findOrder(param);
			model.addAttribute("data", dto);
			model.addAttribute("orderStatus", OrderStatus.values());
			model.addAttribute("payTypes", AccWaterPayType.values());
			model.addAttribute("invoices", OrderInvoice.values());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return VIEW;
	}

	/** 发货 */
	@RequiresPermissions("order:order:edit")
	@RequestMapping(value = "shipping")
	public String shipping(OrderDto paramDto,String expressNo,String expressName, RedirectAttributes redirectAttributes) {
		OrderDto orderDto = orderService.findOrder(paramDto);
		orderService.shipping(orderDto, expressNo, expressName);
		addMessage(redirectAttributes, "订单："+orderDto.getOrderNo()+"发货成功");
		return "redirect:" + adminPath + "/order/order/";
	}
	
	/** 支付*/
	@RequiresPermissions("order:order:edit")
	@RequestMapping(value = "payment")
	public String payment(String code,String orderNo,BigDecimal amt, RedirectAttributes redirectAttributes) {
		
		OrderDto parmOrderDto = new OrderDto();
		parmOrderDto.setCode(code);
		OrderDto orderDto= orderService.findOrder(parmOrderDto);
		
		orderService.payment(builPaymentDto(orderDto));
		addMessage(redirectAttributes, "订单："+orderNo+"付款成功");
		return "redirect:" + adminPath + "/order/order/";
	}
	
	/**
	 * 
	 *
	 * 方法说明：生成预付单
	 *
	 * @param orderDto
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月9日
	 *
	 */
	private PaymentDto builPaymentDto(OrderDto orderDto){
		/*获取账户*/
		AccountDto accountDto= accountService.findAccountByMbrCode(orderDto.getMbrCode());
		PaymentDto paymentDto =new PaymentDto();
		paymentDto.setAccCode(accountDto.getCode());
		paymentDto.setFee(new BigDecimal(0));
		paymentDto.setOperator(UserUtils.getUser().getName());
		paymentDto.setPayer(orderDto.getMbrCode());
		paymentDto.setPaymentDate(new Date());
		paymentDto.setPaymentMethod(AccWaterPayType.CASH.getValue());
		paymentDto.setSn(NoUtil.generateNo(NoUtil.JY));
		paymentDto.setStatus(PaymentStatus.SUCCESS.getValue());
		paymentDto.setType(PaymentType.OFFLINE.getValue());
		paymentDto.setMbrCode(orderDto.getMbrCode());
		paymentDto.setBizNo(orderDto.getOrderNo());
		paymentDto.setDelFlag(DelFlag.N.getValue());
		paymentDto.setAmount(orderDto.getAmt());
		paymentDto.setAccSource(AccWaterSource.ORDER.getValue());
		paymentService.addPayment(paymentDto);
		return paymentDto;
	}
	
	/** 取消 */
	@RequiresPermissions("order:order:edit")
	@RequestMapping(value = "cancel")
	public String cancel(OrderDto paramDto, RedirectAttributes redirectAttributes) {
		OrderDto orderDto = orderService.findOrder(paramDto);
		orderService.cancel(orderDto);
		addMessage(redirectAttributes, "订单："+orderDto.getOrderNo()+"取消成功");
		return "redirect:" + adminPath + "/order/order/";
	}
}
