package com.lj.eshop.eis.controller.member;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.DateUtils;
import com.lj.business.member.dto.ChangePmTypeUngroup;
import com.lj.business.member.dto.EditPersonMember;
import com.lj.business.member.dto.FindPmInfoAll;
import com.lj.business.member.dto.FindPmInfoAllReturn;
import com.lj.business.member.dto.FindPmSeachPage;
import com.lj.business.member.dto.FindPmSeachPageReturn;
import com.lj.business.member.dto.FindPmTypeIndex;
import com.lj.business.member.dto.FindPmTypeIndexPage;
import com.lj.business.member.dto.FindPmTypeIndexPageReturn;
import com.lj.business.member.dto.FindPmTypeIndexReturn;
import com.lj.business.member.service.IPersonMemberService;
import com.lj.business.member.service.IPmTypeService;
import com.lj.eshop.dto.AccWaterDto;
import com.lj.eshop.dto.AccountDto;
import com.lj.eshop.dto.FindAccWaterPage;
import com.lj.eshop.dto.FindMyAttentionPage;
import com.lj.eshop.dto.FindOrderPage;
import com.lj.eshop.dto.FindShopPage;
import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.dto.MyAttentionDto;
import com.lj.eshop.dto.OrderDto;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.eis.constant.Constans;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.FindPmTypeIndexAllReturn;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.emus.AccWaterBizType;
import com.lj.eshop.emus.AccWaterStatus;
import com.lj.eshop.emus.AccWaterType;
import com.lj.eshop.emus.OrderStatus;
import com.lj.eshop.service.IAccWaterService;
import com.lj.eshop.service.IAccountService;
import com.lj.eshop.service.IMemberService;
import com.lj.eshop.service.IMyAttentionService;
import com.lj.eshop.service.IOrderService;
import com.lj.eshop.service.IShopService;

/*
 * 会员对外接口集合.
 * 
 * add by rain at 2017-08-22
 */
@RestController
@RequestMapping("/member")
public class MemberController extends BaseController{

	@Autowired
	private IMemberService memberService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IMyAttentionService myAttentionService;
	@Autowired
	private IShopService shopService;
	@Autowired
	private IAccWaterService accWaterService;
	@Autowired
	private IAccountService accountService;
	
	@Resource
	public IPmTypeService pmTypeService;
	
	@Resource
	public IPersonMemberService personMemberService;
	


	/**
	 * 
	 *
	 * 方法说明：客户管理搜索：分页查询
	 *
	 * @param findPmSeachPage
	 * @return
	 *
	 * @author 彭阳 CreateDate: 2017年7月11日
	 *
	 */
	@RequestMapping(value = "findPmSeachPage")
	@ResponseBody
	public ResponseDto findPmSeachPage(String searchKey,Integer pageNo, Integer pageSize) {
		FindPmSeachPage findPmSeachPage = new FindPmSeachPage();
		findPmSeachPage.setMerchantNo(getGuidMember().getMerchantNo());
		findPmSeachPage.setMemberNoGm(getGuidMemberNo());
		findPmSeachPage.setSearchKey(searchKey);
		if(pageNo!=null){
			findPmSeachPage.setStart((pageNo-1)*pageSize);
		}
		if(pageSize!=null){
			findPmSeachPage.setLimit(pageSize);
		}
		Page<FindPmSeachPageReturn> page= personMemberService.findPmSeachPage(findPmSeachPage);
		return ResponseDto.successResp(page);
	}
	/**
	 * 
	 *
	 * 方法说明：客户管理首页：分类信息查询
	 *
	 * @param findPmTypeIndex
	 * @return
	 *
	 * @author 彭阳 CreateDate: 2017年7月11日
	 *
	 */
	@Deprecated
	@RequestMapping(value = "/findPmTypeIndex")
	@ResponseBody
	public ResponseDto findPmTypeIndex() {
		FindPmTypeIndex findPmTypeIndex = new FindPmTypeIndex();
		findPmTypeIndex.setMemberNoGm(getGuidMemberNo());
		findPmTypeIndex.setMerchantNo(getGuidMember().getMerchantNo());
		List<FindPmTypeIndexReturn> list=pmTypeService.findPmTypeIndex(findPmTypeIndex);
		return ResponseDto.successResp(list);
	}

	/**
	 * 
	 *
	 * 方法说明：社交客户列表
	 *
	 * @param pmTypeCode
	 * @param pageNo
	 * @param pageSize
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月22日
	 *
	 */
	@RequestMapping(value = "/findStIndexPage")
	@ResponseBody
	public ResponseDto findStIndexPage() {
		FindPmTypeIndexPage findPmTypeIndexPage = new FindPmTypeIndexPage();
		findPmTypeIndexPage.setMemberNoGm(getGuidMemberNo());
		findPmTypeIndexPage.setMerchantNo(getGuidMember().getMerchantNo());
		findPmTypeIndexPage.setLimit(Constans.LIMIT);
		Page<FindPmTypeIndexPageReturn> page= personMemberService.findPmTypeIndexPage(findPmTypeIndexPage);
		return ResponseDto.successResp(page);
	}

	/**
	 * 
	 *
	 * 方法说明：客户管理首页：分类信息及其明细查询
	 *
	 * @param findPmTypeIndex
	 * @return
	 *
	 * @author 彭阳 CreateDate: 2017年7月11日	
	 *
	 */
	@RequestMapping(value = "/findPmTypeIndexAll")
	@ResponseBody
	public ResponseDto findPmTypeIndexAll() {
		
		FindPmTypeIndex findPmTypeIndex = new FindPmTypeIndex();
		findPmTypeIndex.setMemberNoGm(getGuidMemberNo());
		findPmTypeIndex.setMerchantNo(getGuidMember().getMerchantNo());
		
		List<FindPmTypeIndexAllReturn> resultList = new ArrayList<FindPmTypeIndexAllReturn>();
		List<FindPmTypeIndexReturn> list = pmTypeService.findPmTypeIndex(findPmTypeIndex);
		for (FindPmTypeIndexReturn findPmTypeIndexReturn : list) {
			FindPmTypeIndexAllReturn findPmTypeIndexAllReturn = new FindPmTypeIndexAllReturn();
			findPmTypeIndexAllReturn.setPmTye(findPmTypeIndexReturn);
			FindPmTypeIndexPage findPmTypeIndexPage = new FindPmTypeIndexPage();
			findPmTypeIndexPage.setLimit(Constans.LIMIT);
			findPmTypeIndexPage.setMemberNoGm(findPmTypeIndex.getMemberNoGm());
			findPmTypeIndexPage.setMerchantNo(findPmTypeIndex.getMerchantNo());
			findPmTypeIndexPage.setPmTypeCode(findPmTypeIndexReturn.getCode());
			findPmTypeIndexPage.setShopNo(findPmTypeIndex.getShopNo());
			Page<FindPmTypeIndexPageReturn> page = personMemberService.findPmTypeIndexPage(findPmTypeIndexPage);
			findPmTypeIndexAllReturn.setDetail(page.getRows());
			resultList.add(findPmTypeIndexAllReturn);
		}
		return ResponseDto.successResp(resultList);
	}
	
	/**
	 * 
	 *
	 * 方法说明：C端个人中心
	 *
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月5日
	 *
	 */
	@RequestMapping(value = {"my_c"})
	@ResponseBody
	public ResponseDto my_c() {
		Map<String,Object> returnMap = new HashMap<String,Object>();
		
		/*会员信息*/	
		MemberDto parmMemberDto = new MemberDto();
		parmMemberDto.setCode(getLoginMemberCode());
		MemberDto memberDto=memberService.findMember(parmMemberDto);
		returnMap.put("member", memberDto);
		/*总消费金额*/
		FindOrderPage findOrderPage = new FindOrderPage();
		OrderDto param = new OrderDto();
		param.setMbrCode(memberDto.getCode());
		findOrderPage.setParam(param);
		BigDecimal totalAmt;
		try {
			totalAmt= orderService.findAmtSum(findOrderPage);
		} catch (Exception e) {
			logger.error("my_c 总消费金额>>", e);
			totalAmt = new BigDecimal("0");
		}
		returnMap.put("totalAmt", totalAmt);		
		
		/*总待付款量*/
		param.setStatus(OrderStatus.UNPAID.getValue());
		findOrderPage.setParam(param);
		int unPaid= orderService.findOrderPageCount(findOrderPage);
		returnMap.put("unPaidCount",unPaid);
		
		/*总待收货量*/
		param.setStatus(OrderStatus.SHIPPED.getValue());
		findOrderPage.setParam(param);
		int shippedCount= orderService.findOrderPageCount(findOrderPage);
		returnMap.put("shippedCount",shippedCount);
		
		/*总待评论*/
		param.setStatus(OrderStatus.UNEVL.getValue());
		findOrderPage.setParam(param);
		int evlCount= orderService.findOrderPageCount(findOrderPage);
		returnMap.put("evlCount",evlCount);
		
		/*本月消费金额*/
		param.setStatus(null);
		param.setStartTime(DateUtils.formatDate(DateUtils.getMonthFirstDay(), DateUtils.PATTERN_yyyy_MM_dd));
		param.setEndTime(DateUtils.formatDate(DateUtils.getMonthLastDay(), DateUtils.PATTERN_yyyy_MM_dd));
		findOrderPage.setParam(param);
		BigDecimal monthAmt;
		try {
			monthAmt = orderService.findAmtSum(findOrderPage);
		} catch (Exception e) {
			logger.error("my_c 本月消费金额>>", e);
			monthAmt = new BigDecimal(0);
		}
		returnMap.put("monthAmt", monthAmt);
		
		return ResponseDto.successResp(returnMap);
	}
	
	/**
	 * 
	 *
	 * 方法说明：B端个人中心
	 *
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月5日
	 *
	 */
	@RequestMapping(value = {"my_b"})
	@ResponseBody
	public ResponseDto my_b() {
		Map<String,Object> returnMap = new HashMap<>();

		FindShopPage findShopPage = new FindShopPage();
		ShopDto paramShop = new ShopDto();
		paramShop.setCode(getLoginShopCode());
		findShopPage.setParam(paramShop);
		List<ShopDto> shopList = shopService.findShops(findShopPage);
		ShopDto shopDto =shopList.get(0);
		returnMap.put("shop", shopDto);
		
		FindOrderPage findOrderPage = new FindOrderPage();
		OrderDto param = new OrderDto();
		param.setShopCode(shopDto.getCode());
		
		
		/*总待付款量*/
		param.setStatus(OrderStatus.UNPAID.getValue());
		findOrderPage.setParam(param);
		int unPaid= orderService.findOrderPageCount(findOrderPage);
		returnMap.put("unPaidCount",unPaid);
		
		/*总待收货量*/
		param.setStatus(OrderStatus.SHIPPED.getValue());
		findOrderPage.setParam(param);
		int shippedCount= orderService.findOrderPageCount(findOrderPage);
		returnMap.put("shippedCount",shippedCount);
		
		/*总待评论*/
		param.setStatus(OrderStatus.UNEVL.getValue());
		findOrderPage.setParam(param);
		int evlCount= orderService.findOrderPageCount(findOrderPage);
		returnMap.put("evlCount",evlCount);
		
		/*当天收益*/
		Date now =new Date();
		Calendar calendar =  com.ape.common.utils.DateUtils.toCalendar(now);
		//将小时至0  
		calendar.set(Calendar.HOUR_OF_DAY, 0);  
		//将分钟至0  
		calendar.set(Calendar.MINUTE, 0);  
		//将秒至0  
		calendar.set(Calendar.SECOND,0);  
		Date startTime= calendar.getTime();
		
		//将小时至23  
		calendar.set(Calendar.HOUR_OF_DAY, 23);  
		//将分钟至59  
		calendar.set(Calendar.MINUTE, 59);  
		//将秒至59  
		calendar.set(Calendar.SECOND,59);  
		Date endTime= calendar.getTime();
		
		/*统计流水收益*/
		BigDecimal monthAmt = new BigDecimal("0");
		try {
			AccountDto accountDto=  accountService.findAccountByMbrCode(getLoginMemberCode());
			AccWaterDto paramWaterDto = new AccWaterDto();
			paramWaterDto.setAccCode(accountDto.getCode());
			paramWaterDto.setWaterType(AccWaterType.ADD.getValue());
			paramWaterDto.setBizType(AccWaterBizType.COMMISSION.getValue());
			paramWaterDto.setStatus(AccWaterStatus.SUCCESS.getValue());
			FindAccWaterPage findAccWaterPage = new FindAccWaterPage();
			findAccWaterPage.setParam(paramWaterDto);
			findAccWaterPage.setStartTime(startTime);
			findAccWaterPage.setEndTime(endTime);
			monthAmt= accWaterService.findIncomeAmt(findAccWaterPage);
		} catch (Exception e) {
			logger.error("my_b 当天收益>>", e);
			monthAmt = new BigDecimal("0");
		}
		returnMap.put("dayAmt", monthAmt==null?new BigDecimal(0):monthAmt);
		
		
		
		/*今日订单*/
		param.setStatus(null);
		param.setStartTime(DateUtils.formatDate(startTime, DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
		param.setEndTime(DateUtils.formatDate(endTime, DateUtils.PATTERN_yyyy_MM_dd_HH_mm_ss));
		findOrderPage.setParam(param);
		int dayCount = orderService.findOrderPageCount(findOrderPage);
		returnMap.put("dayCount", dayCount);
		
		/*粉丝人数*/
		FindMyAttentionPage findMyAttentionPage = new FindMyAttentionPage();
		MyAttentionDto paramMy = new MyAttentionDto();
		paramMy.setShopCode(shopDto.getCode());
		findMyAttentionPage.setParam(paramMy);
		int attCount = myAttentionService.findMyAttentionPageCount(findMyAttentionPage);
		returnMap.put("attCount", attCount);
		
		return ResponseDto.successResp(returnMap);
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改客户分组
	 *
	 * @param pmTypeCode
	 * @param memberNo
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月22日
	 *
	 */
	@RequestMapping(value = "changePmType")
	@ResponseBody
	public ResponseDto changePmType(String pmTypeCode,String memberNo ) {
		
		ChangePmTypeUngroup changePmTypeUngroup = new ChangePmTypeUngroup();
		changePmTypeUngroup.setMemberNo(memberNo);
		changePmTypeUngroup.setMemberNoGm(getGuidMemberNo());
		changePmTypeUngroup.setMerchantNo(getGuidMember().getMerchantNo());
		changePmTypeUngroup.setPmTypeCode(pmTypeCode);
		
		pmTypeService.changePmType_app_ungroup(changePmTypeUngroup);
		return ResponseDto.successResp(null);
	}
	
	/**
	 * 
	 *
	 * 方法说明：修改客户资料
	 *
	 * @param editPersonMember
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月22日
	 *
	 */
	@RequestMapping(value = "modifyMemberInfo")
	@ResponseBody
	public ResponseDto modifyMemberInfo(EditPersonMember editPersonMember) {
		logger.debug("modifyMemberInfo(EditPersonMember editPersonMember={}) - start", editPersonMember);
		personMemberService.editPersonMember(editPersonMember);
		return ResponseDto.successResp(null);
	}
	
	
	/**
	 * 
	 *
	 * 方法说明：查询客户详情
	 *
	 * @param memberNo
	 * @param memberNoGm
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月22日
	 *
	 */
	@RequestMapping(value = "findPmInfo")
	@ResponseBody
	public ResponseDto findPmInfo(String memberNo) {
		FindPmInfoAll findPmInfoAll = new FindPmInfoAll();
		findPmInfoAll.setMemberNo(memberNo);
		findPmInfoAll.setMemberNoGm(getGuidMemberNo());
		FindPmInfoAllReturn findPmInfoAllReturn= personMemberService.findPmInfoAll(findPmInfoAll);
		return ResponseDto.successResp(findPmInfoAllReturn);
	}
}
