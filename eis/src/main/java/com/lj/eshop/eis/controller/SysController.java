/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.utils.PaymentVersionUtils;
import com.lj.cc.clientintf.LocalCacheSystemParamsFromCC;
import com.lj.eshop.eis.constant.Constans;
import com.lj.eshop.eis.dto.MobileVersionDto;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.eis.utils.JsonUtils;

/**
 * 类说明：系统公用
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月22日
 */
@Controller
public class SysController extends BaseController{
	@Autowired 
	private LocalCacheSystemParamsFromCC localCacheSystemParams;
	
	/**
	 * 
	 *
	 * 方法说明：检查客户端版本
	 *
	 * @author 彭阳
	 *   
	 * CreateDate: 2017-7-1
	 * 
	 * @param clientVersion
	 * @param clientOS
	 * @return
	 */
	@RequestMapping(value="/checkVersion", produces="application/json;charset=UTF-8")
	@ResponseBody
	public ResponseDto checkVersion(String clientVersion, String clientOS) {
		logger.info("checkVersion(String paramJson={},clientOS={}) - start", clientVersion,clientOS); //$NON-NLS-1$
		if(StringUtils.isEmpty(clientVersion)
				|| StringUtils.isEmpty(clientOS))
		{
			throw new TsfaServiceException(ResponseCode.PARAM_ERROR.getCode(), ResponseCode.PARAM_ERROR.getMsg());
		}
		Map<String, String> versionMap = localCacheSystemParams.getSystemParamGroup(Constans.CC_EIS_SYSTEMALIASNAME,Constans.CC_EC_APP_VERSION);
		logger.info("version:"+JsonUtils.toJSON(versionMap));
		String serverVersion = versionMap.get(clientOS);						// 客户端最新上线版本
		String mobileDownloadUrl = versionMap.get(clientOS + "DownloadUrl");	// APP下载地址
		String usableLimit = versionMap.get(clientOS + "LimitUsable");			// 最低支持版本
		String fileSize = versionMap.get(clientOS + "FileSize");			//更新文件大小
		String updateRemark = versionMap.get(clientOS + "UpdateRemark");	//版本更新说明
		String mobileWxDownloadUrl = versionMap.get(clientOS + "WxDownloadUrl");	//版本更新说明
		// 组装返回结果
		MobileVersionDto mv = new MobileVersionDto();
		mv.setServerVersion(serverVersion);
		mv.setUpdateUrl(mobileDownloadUrl);
		mv.setWxUpdateUrl(mobileWxDownloadUrl);
		mv.setFileSize(fileSize);
		mv.setUpdateRemark(updateRemark);
		mv.setNeedUpdate(PaymentVersionUtils.isUpdatedVersion(clientVersion, serverVersion));	// 是否需要更新
		mv.setForceUpdate(PaymentVersionUtils.isUpdatedVersion(clientVersion, usableLimit));	// 是否必须更新，即服务端不支持客户端当前版本

		return ResponseDto.successResp(mv);
	}
	
	/**
	 * 方法说明：关于我们
	 * @return
	 *
	 * @author lhy  2017年9月22日
	 *
	 */
	@RequestMapping(value="/about")
	@ResponseBody
	public ResponseDto about(){
		Map<String, String> aboutUs = localCacheSystemParams.getSystemParamGroup(Constans.CC_EIS_SYSTEMALIASNAME,Constans.CC_EC_ABOUT_US_GROUP);
		logger.debug("aboutUs:"+aboutUs);
		return ResponseDto.successResp(aboutUs);
	}
}
