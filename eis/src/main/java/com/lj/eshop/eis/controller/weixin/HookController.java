package com.lj.eshop.eis.controller.weixin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lj.base.core.util.StringUtils;
import com.lj.business.common.SystemParamConstant;
import com.lj.business.member.service.IPersonMemberService;
import com.lj.business.weixin.service.IWxChatInfoService;
import com.lj.business.weixin.service.IWxFriendsInfoService;
import com.lj.cc.clientintf.LocalCacheSystemParamsFromCC;
import com.lj.cc.enums.SystemAliasName;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.GeneralResponse;
import com.lj.eshop.eis.dto.ResponseDto;

/**
 * 
 * 
 * 类说明：HookAction勾子服务类
 *  
 * 
 * <p/>
 * 详细描述：
 *   
 * 
 * @author rain
 *   
 * CreateDate: 2017-07-12
 */

@Controller
@RequestMapping(value="/hook/")
public class HookController extends BaseController {
	

	@Autowired
	public IPersonMemberService personMemberService;
	@Autowired
	public LocalCacheSystemParamsFromCC localCacheSystemParams;
	@Autowired
	public IWxChatInfoService wxChatInfoService;
	@Autowired
	public IWxFriendsInfoService wxFriendsInfoService;
	/**
	 * 
	 *
	 * 方法说明：扫码添加客户
	 *
	 * @param paramJson
	 * @return
	 *
	 * @author rain CreateDate: 2017年7月14日
	 *
	 */
	@RequestMapping(value = "addPersonMemberFromHook.do")
	@ResponseBody
	public ResponseDto addPersonMemberFromHook(String paramJson) {
		logger.debug("addPersonMemberFromHook(String paramJson={}) - start", paramJson); //$NON-NLS-1$
		personMemberService.addPersonMemberFromHook(paramJson);
		return  ResponseDto.successResp(null);
	}

	/**
	 * 
	 *
	 * 方法说明：根据导购微信获取最新聊天时间
	 * 钩子解析格式按聚客格式解析
	 * @param wxNo
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月20日
	 *
	 */
	@RequestMapping(value="getMaxChatDateByWxNo.do")
	@ResponseBody
	public GeneralResponse getMaxChatDateByWxNo(String noWxGM){
		logger.debug("getMaxChatDateByWxNo(String noWxGM={}) - start", noWxGM); //$NON-NLS-1$
		Map<String,Long> returnMap = new HashMap<String, Long>();
		returnMap.put("chatTime", wxChatInfoService.getMaxChatDateByWxNo(noWxGM));
		returnMap.put("friendTime", wxFriendsInfoService.getNewDateByWxNo(noWxGM));
		
		String rp =  localCacheSystemParams.getSystemParam(SystemAliasName.cf.toString(),SystemParamConstant.REPORT, SystemParamConstant.REPORTTIME);
		
		logger.info("rp:" + rp);
		
		Long reportTime = 60l;
		if(!StringUtils.isEmpty(rp)){
			reportTime = Long.valueOf(rp);
		}
		returnMap.put("reportTime", reportTime);
		return GeneralResponse.generateSuccessResponse(returnMap);
	}
	
	/**
	 * 
	 *
	 * 方法说明：上传聊天记录
	 *钩子解析格式按聚客格式解析
	 * @param paramJson
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月20日
	 *
	 */
	@RequestMapping(value="uploadWxChatInfo.do")
	@ResponseBody
	public GeneralResponse uploadWxChatInfo(String paramJson){
		logger.debug("uploadWxChatInfo(String paramJson={}) - start", paramJson); //$NON-NLS-1$
		int flag =wxChatInfoService.uploadWxChatInfo(paramJson);
		return  GeneralResponse.generateSuccessResponse(flag);
	}
	
	/**
	 * 
	 *
	 * 方法说明：上传朋友圈信息
	 *钩子解析格式按聚客格式解析
	 * @param paramJson
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年7月20日
	 *
	 */
	@RequestMapping(value="uploadWxFriendsInfo.do")
	@ResponseBody
	public GeneralResponse uploadWxFriendsInfo(String paramJson){
		logger.debug("uploadWxFriendsInfo(String paramJson={}) - start", paramJson); //$NON-NLS-1$
		int flag= wxFriendsInfoService.uploadWxFriendsInfo(paramJson);
		return  GeneralResponse.generateSuccessResponse(flag);
	}
}
