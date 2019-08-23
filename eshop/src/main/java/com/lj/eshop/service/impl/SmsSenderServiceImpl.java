package com.lj.eshop.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.dto.CodeCheckDto;
import com.lj.eshop.service.ICodeCheckService;
import com.lj.eshop.service.ISmsSenderService;


/***
 * 短信发送服务
 * XXX ${timessharing.autoresend.enable} properties配置，如果多台服务器只允许一台
 * @author 彭阳
 *
 */
@Service
public class SmsSenderServiceImpl implements ISmsSenderService {

	/*阿里大鱼*/
//	private static final String ALIDAYU = "alidayu";

	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(SmsSenderServiceImpl.class);

	ExecutorService pool = Executors. newSingleThreadExecutor();
	@Autowired
	private ICodeCheckService codeCheckService;
	
	//产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";
    
	@Override
	public void sendTemplateSms(String mobile,String content,Map<String, String>  map,String bizType)throws TsfaServiceException { 
		logger.debug("请求发送短信："+content);
		//-----插入数据库-------
		CodeCheckDto codeCheckDto = new CodeCheckDto();
		codeCheckDto.setBizType(bizType);
		codeCheckDto.setRevicerPhone(mobile);
		codeCheckDto.setSendCode(content);
		codeCheckService.addCodeCheck(codeCheckDto);
		logger.debug("请求发送短信插入数据库保存并异步发送");
		//-----异步发送---------
		sendSmsByAsynchronous(mobile,content,map);
	}

	/**
	 * 方法说明：异步发送SMS.
	 *
	 * @param ssb the ssb
	 */
	public void sendSmsByAsynchronous(final String mobile,final String content, final Map<String, String>  map) {
		pool.execute(new Runnable() { 
			@Override
			public void run() {
				sendSms(mobile,content,map);
			}
		});
	}

	/**
	 * Send sms.
	 *
	 * @param ssb the ssb
	 */
	private void sendSms(String mobile,String content, Map<String, String>  map) {
		//----发送-------
		try { 
			logger.debug("通过短信网关alidayu发送短信："+content);
			sendSMSAlidayu(mobile, map, content);
			logger.debug("通过短信网关发送短信成功");
		} catch (Throwable e) {
			logger.error("-----sms resend error--------- "+content,e);
		}
	}

	/**
	 * 
	 *
	 * 方法说明：阿里大鱼发送短信.
	 *
	 * @param phone
	 * @param content
	 *
	 * @author 彭阳 CreateDate: 2017年06月23日
	 * @throws ClientException 
	 * @throws ApiException 
	 *
	 */
	public  void sendSMSAlidayu(String phone, Map<String, String>  map,String content) throws ClientException {
		logger.debug("sendSMSAlidayu(String phone={}, Map<String,String> map={"+ (map == null ? null: map.toString()) +"}, String content={}) - start", phone, content); //$NON-NLS-1$

		//第一次发送错误，进入循环发送机制时
		if(map == null){
			if(!StringUtils.isEmpty(content)){
				String validationCode = content.substring(content.indexOf("：") + 1, content.indexOf("["));
				String senderName = content.substring(content.indexOf("[") + 1, content.indexOf("]"));
				map = new HashMap<String, String>();
				map.put("validationCode",validationCode);
				map.put("senderName",senderName);
			}
		}
		//从配置读取参数
		ResourceBundle config = ResourceBundle.getBundle("properties/config");
		String APP_KEY = config.getString("APP_KEY");
		String APP_SECRET =  config.getString("APP_SECRET");
		String TEMPLATE_CODE =  config.getString("TEMPLATE_CODE");
		String SIGNNAME =  config.getString("SIGNNAME");
		logger.debug("APP_KEY={},APP_SECRET={},TEMPLATE_CODE={},SIGNNAME={}",APP_KEY,APP_SECRET,TEMPLATE_CODE,SIGNNAME);
		String validationCode = map.get("validationCode");

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "15000");
        System.setProperty("sun.net.client.defaultReadTimeout", "15000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", APP_KEY, APP_SECRET);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(SIGNNAME);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(TEMPLATE_CODE);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
       // request.setTemplateParam("{\"name\":\"Tom\", \"code\":\"123\"}");
        request.setTemplateParam("{\"validationCode\":\""+ validationCode +"\"}");

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
       // request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse response = acsClient.getAcsResponse(request);
        logger.debug("短信接口返回的数据----------------");
        logger.debug("Code=" + response.getCode());
        logger.debug("Message=" + response.getMessage());
        logger.debug("RequestId=" + response.getRequestId());
        logger.debug("BizId=" + response.getBizId());
	} 


}
