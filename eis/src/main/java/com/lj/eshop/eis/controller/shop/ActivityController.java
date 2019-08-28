/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.controller.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lj.base.core.pagination.Page;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cm.constant.ErrorCode;
import com.lj.business.cm.constant.PublicConstants;
import com.lj.business.cm.dto.activity.FindActivity;
import com.lj.business.cm.dto.activity.FindActivityPage;
import com.lj.business.cm.dto.activity.FindActivityPageReturn;
import com.lj.business.cm.dto.activity.FindActivityReturn;
import com.lj.business.cm.dto.activity.UpdateActivity;
import com.lj.business.cm.service.IActivityService;
import com.lj.business.common.SystemParamConstant;
import com.lj.cc.clientintf.LocalCacheSystemParamsFromCC;
import com.lj.cc.enums.SystemAliasName;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseDto;

/**
 * 
 * 
 * 类说明：活动
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 * 
 *         CreateDate: 2017年9月22日
 */
@RestController
@RequestMapping("/activity")
public class ActivityController extends BaseController {

	@Autowired
	private IActivityService activityService;
	@Autowired
	private LocalCacheSystemParamsFromCC localCacheSystemParams;

	@RequestMapping(value = "list")
	@ResponseBody
	public ResponseDto list(Integer pageNo, Integer pageSize) throws TsfaServiceException {
		logger.debug("list(String getLoginMerchantCode={}) - start", getLoginMerchantCode());
		FindActivityPage findActivityPage = new FindActivityPage();
		findActivityPage.setMerchantNo(getLoginMerchantCode());
		if (pageNo != null) {
			findActivityPage.setStart((pageNo - 1) * pageSize);
		}
		if (pageSize != null) {
			findActivityPage.setLimit(pageSize);
		}
		Page<FindActivityPageReturn> page = activityService.findActivityPage(findActivityPage);
		String uploadUrl = localCacheSystemParams.getSystemParam(SystemAliasName.ms.toString(),
				SystemParamConstant.UPLOAD_GROUP, SystemParamConstant.UPLOAD_URL);
		/* 处理活动链接 */
		for (FindActivityPageReturn findActivityReturnDto : page.getRows()) {
			if (StringUtils.isEmpty(findActivityReturnDto.getLinkUrl())) {
				String url = uploadUrl + PublicConstants.ACTIVITY_H5 + "?code=" + findActivityReturnDto.getCode();
				findActivityReturnDto.setLinkUrl(url);
				logger.debug("处理活动链接 ={}", url);
			}
		}
		logger.debug("list() - end - return value={}", page); //$NON-NLS-1$
		return ResponseDto.successResp(page);
	}

	/**
	 * 
	 *
	 * 方法说明：增加活动分享量
	 *
	 * @param updateActivityForReadDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年8月15日
	 *
	 */
	@RequestMapping(value = "addActivityForShare")
	@ResponseBody
	public ResponseDto addActivityForShare(String code) throws TsfaServiceException {
		logger.debug("addActivityForShare(String mercharNo={}, String code={}) - start", getLoginMerchantCode(), code);
		UpdateActivity updateActivity = new UpdateActivity();
		updateActivity.setMerchantNo(getLoginMerchantCode());
		updateActivity.setCode(code);
		activityService.addActivityForShare(updateActivity);
		return ResponseDto.successResp(null);

	}

	/**
	 * 
	 *
	 * 方法说明：增加活动阅读量
	 *
	 * @param updateActivityForReadDto
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017年9月29日
	 *
	 */
	@RequestMapping(value = "addActivityForRead")
	@ResponseBody
	public ResponseDto addActivityForRead(String code) throws TsfaServiceException {
		logger.debug("addActivityForShare(String mercharNo={}, String code={}) - start", getLoginMerchantCode(), code);
		FindActivity findActivity = new FindActivity();
		findActivity.setCode(code);
		FindActivityReturn findActivityReturn = activityService.findActivity(findActivity);

		UpdateActivity updateActivity = new UpdateActivity();
		Long readCnt = findActivityReturn.getReadCount();
		updateActivity.setReadCount(readCnt == null ? 1L : readCnt + 1);
		updateActivity.setCode(code);
		activityService.updateActivity(updateActivity);

		return ResponseDto.successResp(null);

	}
}
