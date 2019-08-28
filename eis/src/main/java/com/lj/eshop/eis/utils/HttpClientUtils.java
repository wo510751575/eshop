package com.lj.eshop.eis.utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;

/**
 * 类说明：httpclient.
 *  
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月6日
 */
public class HttpClientUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    /**
     * httpPost
     *
     * @param url       路径
     * @param jsonParam 参数
     * @param token     header里面Authorization的值
     * @return
     */
    public static JSONObject httpPost(String url, JSONObject jsonParam, String token) {
        return httpPost(url, jsonParam, false, token);
    }

    /**
     * post请求
     *
     * @param url            url地址
     * @param jsonParam      参数
     * @param noNeedResponse 不需要返回结果
     * @param token          header里面Authorization的值
     * @return
     */
    public static JSONObject httpPost(String url, JSONObject jsonParam, boolean noNeedResponse, String token) {
        //post请求返回结果
        JSONObject jsonResult = null;
        CloseableHttpClient client = getHttpClient();
        HttpPost method = new HttpPost(url);
        try {
            if (null != jsonParam) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }
            if (null != token) {
                method.setHeader("Authorization", "Bearer " + token);
            }

            CloseableHttpResponse result = client.execute(method);
            url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";
                try {
                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity());
                    if (noNeedResponse) {
                        return null;
                    }
                    /**把json字符串转换成json对象**/
                    jsonResult = JSONObject.parseObject(str);
                } catch (Exception e) {
                    logger.error("post请求提交失败:" + url);
                    logger.error("");
                } finally {
                    result.close();
                }
            }
        } catch (IOException e) {
            logger.error("post请求提交失败:" + url, e);
        } finally {
            try {
                closeHttpClient(client);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jsonResult;
    }

    /**
     * 发送get请求
     *
     * @param url 路径
     * @return
     */
    public static String httpGet(String url) {
        //get请求返回结果
//        JSONObject jsonResult = null;
        String strResult = null;
        CloseableHttpClient client = getHttpClient();
        try {
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                InputStream instreams = entity.getContent();
                strResult = convertStreamToString(instreams);
                logger.info("get strResult:" + strResult);
                /**把json字符串转换成json对象**/
//                jsonResult = JSONObject.parseObject(strResult);
//                url = URLDecoder.decode(url, "UTF-8");
            } else {
                logger.error("get请求提交失败:" + url);
            }
        } catch (IOException e) {
            logger.error("get请求提交失败:" + url, e);
            throw new RuntimeException("get网络请求异常。url："+url,e);
        } finally {
            try {
                closeHttpClient(client);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return strResult;
    }

    public static void main(String[] args) {
    	
    	 JSONObject jsonResult = JSONObject.parseObject("{\"privilege\":[ \"PRIVILEGE1\" ,\"PRIVILEGE2\" ],   \"errcode\":40029,\"errmsg\":\"invalid code\"} ");
    	 System.out.println(jsonResult.getString("privilege"));
    	 String ps=jsonResult.getString("privilege");
    	 JSONArray p=JSONObject.parseArray(ps);
    	 System.out.println(p.get(0).toString());
    }
    public static String convertStreamToString(InputStream is) {
        StringBuilder sb1 = new StringBuilder();
        byte[] bytes = new byte[4096];
        int size = 0;

        try {
            while ((size = is.read(bytes)) > 0) {
                String str = new String(bytes, 0, size, "UTF-8");
                sb1.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb1.toString();
    }

    private static CloseableHttpClient getHttpClient() {
        return HttpClients.createDefault();
    }

    private static void closeHttpClient(CloseableHttpClient client) throws IOException {
        if (client != null) {
            client.close();
        }
    }
}
