package com.lj.eshop.eis.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.net.ssl.HttpsURLConnection;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * 
 * 类说明：公众平台通用接口工具类
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年9月5日
 */
public class WeixinUtil {
	private static Logger logger = LoggerFactory.getLogger(WeixinUtil.class);

	/**
	 * 第三方用户唯一凭证
	 */
	public static String APPID = "wxafe8bf68a2da23ab";
	/**
	 * 第三方用户唯一凭证密钥
	 */
	public static String APPSECRET = "b9a418f9fa03aa775e672c1ec48fd286";
	/**
	 * 商户ID
	 */
	public static String MCH_ID="";
	/**
	 * 获取openId
	 */
	public static String OAUTH_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	/**
	 * 获取access-token
	 */
	public static String ACCESS_TOKEN="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=SECRET";
	/**
	 * 获取ticket
	 */
	public static String TICKET=" https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESSTOKEN&type=jsapi";
	/**
	 * 
	 * @param requestUrl 请求地址
	 * @param requestMethod 请求方式（GET、POST）
	 * @param outputStr 提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		try {
			StringBuffer buffer = httpsRequests(requestUrl, requestMethod, outputStr);
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			logger.error("连接超时："+ce.getMessage());
		} catch (Exception e) {
			logger.error("https请求异常："+e.getMessage());
		}
		return jsonObject;
	}

	public static StringBuffer httpsRequests(String requestUrl, String requestMethod, String output)
			throws NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException, MalformedURLException,
			IOException, ProtocolException, UnsupportedEncodingException {
		URL url = new URL(requestUrl);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setUseCaches(false);
		connection.setRequestMethod(requestMethod);
		if (null != output) {
			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(output.getBytes("UTF-8"));
			outputStream.close();
		}
		// 从输入流读取返回内容
		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String str = null;
		StringBuffer buffer = new StringBuffer();
		while ((str = bufferedReader.readLine()) != null) {
			buffer.append(str);
		}
		bufferedReader.close();
		inputStreamReader.close();
		inputStream.close();
		inputStream = null;
		connection.disconnect();
		return buffer;
	} 


	/**
	 * 获取用户的openId
	 * @param code 微信返回的code
	 */
	public static String getOpenId(String code) {
		String oauth_url = OAUTH_URL.replace("APPID", APPID).replace("SECRET", APPSECRET).replace("CODE", code);
		logger.info("oauth_url:"+oauth_url);
		JSONObject jsonObject = WeixinUtil.httpRequest(oauth_url, "POST", null);
		logger.info("jsonObject:"+jsonObject);
		Object errorCode = jsonObject.get("errcode");
		if(errorCode != null) {
			logger.info("code不合法");
			return null;
		}else{
			String openId = jsonObject.getString("openid");
			logger.info("openId:"+openId);
			return openId;
		}
	}
}
