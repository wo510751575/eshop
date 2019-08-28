package com.lj.eshop.eis.controller.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.util.StringUtils;
import com.lj.eshop.dto.FindMyAttentionPage;
import com.lj.eshop.dto.MemberDto;
import com.lj.eshop.dto.MyAttentionDto;
import com.lj.eshop.dto.ShopDto;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.emus.MyAttentionStatus;
import com.lj.eshop.service.IMemberService;
import com.lj.eshop.service.IMyAttentionService;
import com.lj.eshop.service.IShopService;
/**
 * 
 * 
 * 类说明：我的关注店铺对外接口集合
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月31日
 */
@RestController
@RequestMapping("/myAttention")
public class MyAttentionController extends BaseController{
	
	@Autowired
	private IMyAttentionService myAttentionService;
	@Autowired
	private IMemberService memberService;
	@Autowired
	private IShopService shopService;
	
	/**
	 * 
	 *
	 * 方法说明：店铺关注
	 *
	 * @param mbrCode
	 * @param shopCode
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月2日
	 *
	 */
	@RequestMapping(value = {"attention"})
	@ResponseBody
	public ResponseDto attention(String shopCode,boolean flag) {
		logger.debug("addAttention -->(String shopCode={}) - start",shopCode);
		if(StringUtils.isEmpty(shopCode)){
			return ResponseDto.createResp(false, ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg(), null);
		}
		/*获取会员信息*/
		MemberDto memberDto = getLoginMember();
		MyAttentionDto param = new MyAttentionDto();
		param.setMbrCode(memberDto.getCode());
		param.setShopCode(shopCode);
		FindMyAttentionPage findMyAttentionPage = new FindMyAttentionPage();
		findMyAttentionPage.setParam(param);
		List<MyAttentionDto> list= myAttentionService.findMyAttentions(findMyAttentionPage);
		/*存在*/
		if(list.size()>0){
			MyAttentionDto myAttentionDto = list.get(0);
			if(flag){/*关注*/
				myAttentionDto.setStatus(MyAttentionStatus.Y.getValue());
				myAttentionService.updateMyAttention(myAttentionDto);
			}else{/*取消关注*/
				myAttentionDto.setStatus(MyAttentionStatus.N.getValue());
				myAttentionService.updateMyAttention(myAttentionDto);
			}
		}else{
			
			/*获取店铺信息*/
			ShopDto parmShop = new ShopDto();
			parmShop.setCode(shopCode);
			ShopDto shopDto= shopService.findShop(parmShop);
			
			MyAttentionDto myAttentionDto = new MyAttentionDto();	
			myAttentionDto.setMbrCode(memberDto.getCode());
			myAttentionDto.setMbrName(memberDto.getName());
			myAttentionDto.setShopCode(shopCode);
			myAttentionDto.setShopName(shopDto.getShopName());
			myAttentionDto.setShopImg(shopDto.getImg());
			if(flag){/*关注*/
				myAttentionDto.setStatus(MyAttentionStatus.Y.getValue());
			}else{/*取消关注*/
				myAttentionDto.setStatus(MyAttentionStatus.N.getValue());
			}
			myAttentionService.addMyAttention(myAttentionDto);
		}
		return ResponseDto.successResp(null);
	}
	
}
