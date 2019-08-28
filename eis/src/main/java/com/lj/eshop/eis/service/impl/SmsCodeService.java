package com.lj.eshop.eis.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lj.base.core.util.AssertUtils;
import com.lj.base.core.util.RandomUtils;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.distributecache.RedisCache;
import com.lj.eshop.constant.ErrorCode;
import com.lj.eshop.domain.TemplateSmsMessage;
import com.lj.eshop.eis.constant.DevConfig;
import com.lj.eshop.eis.dto.SmsCodeSenderRequest;
import com.lj.eshop.eis.dto.SmsCodeVerifyRequest;
import com.lj.eshop.service.ISmsSenderService;

/**
 * 
 * 
 * 类说明：短信验证码服务接口
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 * 
 *         CreateDate: 2017年9月4日
 */
@Service
public class SmsCodeService {

	private static Logger logger = Logger.getLogger(SmsCodeService.class);

	@Autowired
	private RedisCache redisCache;

	@Resource
	private ISmsSenderService smsSenderService;

	public static final String VALIDATION_CODE_KEY_PREFIX = "eis_smsValidationCode";
	public static final String PROCESS_CODE_KEY_PREFIX = "eis_smsProcessCode";

	/**
	 * 
	 *
	 * 方法说明：发送短信校验码
	 *
	 * @param request
	 *
	 * @author 段志鹏 CreateDate: 2017年9月4日
	 *
	 */
	public void send(SmsCodeSenderRequest request) {
		logger.info("send(SmsCodeSenderRequest request=" + request + ") - start"); //$NON-NLS-1$

		AssertUtils.state(request.getExpireSeconds() > 59); // 必须超过1分钟过期时间
		String key = VALIDATION_CODE_KEY_PREFIX + request.getBizType() + request.getMobile(); // 分布式缓存存放smsCode
		logger.info("key:" + key);
		String validateCode = redisCache.get(key);
//		if(StringUtils.isNotEmpty(validateCode)){ 不检测可以再次发送
//			logger.error("频繁发送短信验证码");
//			throw new TsfaServiceException(ErrorCode.SMS_CODE_EXIST, "亲，短信费用好贵哦，请不要频繁发送！");
//		}
		if (DevConfig.isDevTest()) {// 测试联调则模拟发送8888验证码
//			redisClient.setex(key, request.getExpireSeconds(),"8888");
			redisCache.set(key, "8888", request.getExpireSeconds());
		} else {
			// 随机生成四位验证码
			Random rnd = new Random(System.currentTimeMillis());
			if (StringUtils.isEmpty(validateCode)) {// 有效期内有验证码再次触发发送验证码则发相同的验证码
				validateCode = StringUtils.padLeft(String.valueOf(Math.abs(rnd.nextInt() % 10000)), 4, '0');
			}
			// // 插入缓存区
//			redisClient.setex(key, request.getExpireSeconds(), validateCode);
			redisCache.set(key, validateCode, request.getExpireSeconds());
			TemplateSmsMessage tsm = new TemplateSmsMessage(); // 发送短信验证码
			tsm.setTelphoneNo(request.getMobile());
			tsm.setTemplateId("sms_validation_code");
			Map<String, String> contentMap = new HashMap<String, String>();
			contentMap.put("validationCode", validateCode);
			contentMap.put("senderName", request.getSenderName());
			tsm.setContentMap(contentMap);
			smsSenderService.sendTemplateSms(request.getMobile(), validateCode, contentMap, request.getBizType());
		}
		logger.info("send(SmsCodeSenderRequest) - end"); //$NON-NLS-1$
	}

	/**
	 * 
	 *
	 * 方法说明：校验短信验证码
	 *
	 * @param request
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年9月4日
	 *
	 */
	public String verify(SmsCodeVerifyRequest request) {
		AssertUtils.notNullAndEmpty(request.getSmsCode());
		String key = VALIDATION_CODE_KEY_PREFIX + request.getBizType() + request.getMobile();
		String value = redisCache.get(key);

		if (request.getSmsCode().equals(value)) {
			String processCode = "";
			if (request.isProcessFlag()) {
				// 验证码正确，再返回一个随机校验码，用于校验有可能绕过短信校验码的非法请求(暂时只用于注册和找回登录密码两个未登录的功能)
				processCode = RandomUtils.getRandom(16);
				// 将随机校验码存入缓存，并设置过期时间
//				redisClient.setex(PROCESS_CODE_KEY_PREFIX + request.getMobile() + request.getSmsCode(),
//						request.getProcessExpired(), processCode);
				redisCache.set(PROCESS_CODE_KEY_PREFIX + request.getMobile() + request.getSmsCode(), processCode,
						request.getProcessExpired());
			}
			redisCache.del(key); // 验证通过，删除key，以便可以接受后续的验证码
			return processCode;
		} else {
			logger.error("短信验证码错误");
			throw new TsfaServiceException(ErrorCode.SMS_CODE_ERROR, "对不起，您输入的验证码有误");
		}
	}

	/**
	 * 
	 *
	 * 方法说明：判断验证码是否匹配
	 *
	 * @param mobile
	 * @param bizType
	 * @param smsCode
	 *
	 * @author 段志鹏 CreateDate: 2017年9月4日
	 *
	 */
	public void verify(String mobile, String bizType, String smsCode) {
		String key = VALIDATION_CODE_KEY_PREFIX + bizType + mobile;
		String value = redisCache.get(key);
		if (smsCode.equals(value)) {
			redisCache.del(key); // 验证通过，删除key，以便可以接受后续的验证码
		} else {
			logger.error("短信验证码错误");
			throw new TsfaServiceException(ErrorCode.SMS_CODE_ERROR, "对不起，您输入的验证码有误");
		}
	}

}
