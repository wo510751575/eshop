package com.lj.eshop.eis.controller.app;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.business.cm.dto.AddGreetClient;
import com.lj.business.cm.dto.FindGreetClientForDayDto;
import com.lj.business.cm.dto.FindGreetClientReturnDto;
import com.lj.business.cm.emus.SendType;
import com.lj.business.cm.service.IGreetClientService;
import com.lj.eshop.eis.controller.BaseController;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;

/**
 * 
 * 
 * 类说明：今日工作action
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 彭阳
 * 
 *         CreateDate: 2017年9月22日
 */
@Controller
@RequestMapping(value = "/appwork/")
public class WorkTodayController extends BaseController {

	@Resource
	private IGreetClientService greetClientService;

	/**
	 * 
	 *
	 * 方法说明：查找当日问候信息(个人中心)
	 *
	 * @param findGreetClientDto
	 * @return
	 *
	 * @author 林进权 CreateDate: 2017年9月22日
	 *
	 */
	@RequestMapping(value = "findGreetClientForDay")
	@ResponseBody
	public ResponseDto findGreetClientForDay(FindGreetClientForDayDto findGreetClientForDayDto) {
		logger.debug("findGreetClientDto(findGreetClientDto findGreetClientDto={}) - start", findGreetClientForDayDto);
		findGreetClientForDayDto.setMemberNoGm(getLoginMemberCode());
		if (StringUtils.isEmpty(findGreetClientForDayDto.getCreateDate())) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}
		FindGreetClientReturnDto findGreetClientForDay = greetClientService
				.findGreetClientForDay(findGreetClientForDayDto);
		logger.debug("findGreetClientDto() - end - return value={}", findGreetClientForDay); //$NON-NLS-1$
		return ResponseDto.successResp(findGreetClientForDay);
	}

	/**
	 * 
	 *
	 * 方法说明：添加客户问候消息
	 *
	 * @param addGreetClient
	 * @return
	 * @throws TsfaServiceException
	 *
	 * @author 林进权 CreateDate: 2017年9月22日
	 *
	 */
	@RequestMapping(value = "addGreetClient")
	@ResponseBody
	public ResponseDto addGreetClient(AddGreetClient addGreetClient) throws TsfaServiceException {
		logger.debug("addGreetClient(AddGreetClient addGreetClient={}) - start", addGreetClient);

		if (StringUtils.isEmpty(addGreetClient.getTitle()) || StringUtils.isEmpty(addGreetClient.getContent())) {
			return ResponseDto.getErrorResponse(ResponseCode.PARAM_ERROR);
		}

		addGreetClient.setMemberNoGm(getLoginMemberCode());
		addGreetClient.setMemberNameGm(getLoginMember().getName());
		addGreetClient.setMerchantNo(getLoginMerchantCode());
		addGreetClient.setSendType(SendType.ALL);
		addGreetClient.setCreateDate(new Date());
		greetClientService.addGreetClientEc(addGreetClient);
		logger.debug("addGreetClient() - end - return value={}", addGreetClient); //$NON-NLS-1$
		return ResponseDto.successResp(null);
	}

}
