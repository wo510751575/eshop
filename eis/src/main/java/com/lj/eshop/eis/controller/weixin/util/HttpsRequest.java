package com.lj.eshop.eis.controller.weixin.util;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * 类说明：http请求封装。
 * <p>
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月8日
 */
public class HttpsRequest {

    private static Logger log = LoggerFactory.getLogger(HttpsRequest.class);
    //表示请求器是否已经做了初始化工作
    private static boolean hasInit = false;
    //连接超时时间，默认10秒
    private static int socketTimeout = 10000;
    //传输超时时间，默认30秒
    private static int connectTimeout = 30000;
    //请求器的配置
    private static RequestConfig requestConfig;

    public HttpsRequest() throws UnrecoverableKeyException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        init();
    }

    //HTTP请求器
//    private static CloseableHttpClient httpClient;

    private static void init() throws IOException, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {

        //根据默认超时限制初始化requestConfig
        requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();

        hasInit = true;
    }

    /**
     * 通过Https往API post xml数据
     *
     * @param url    API地址
     * @param xmlObj 要提交的XML数据对象
     * @return API回包的实际数据
     * @throws IOException
     * @throws KeyStoreException
     * @throws UnrecoverableKeyException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */

    public static String sendPost(String url, Object xmlObj) throws IOException, KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {

//        if (!hasInit) {
//            init();
//        }

        String result = null;
        HttpPost httpPost = new HttpPost(url);
        //解决XStream对出现双下划线的bug
        XStream xStreamForRequestPostData = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));

        //将要提交给API的数据对象转换成XML格式数据Post给API
        String postDataXML = xStreamForRequestPostData.toXML(xmlObj);
        //得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
        StringEntity postEntity = new StringEntity(postDataXML, "UTF-8");
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.setEntity(postEntity);
        //设置请求器的配置
//        httpPost.setConfig(requestConfig);
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
			log.info("url:"+url+",result" + result);
        } catch (Exception e) {
            log.error("错误", e);
            throw new RuntimeException("post网络请求异常。url："+url,e);
        } finally {
            httpPost.abort();
        }

        return result;
    }

    public static String httpPostWithJson(String url, String json) {
        String result = "";
        HttpPost httpPost = new HttpPost(url);
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();

            StringEntity postEntity = new StringEntity(json);
            httpPost.addHeader("Content-Type", "application/json");
            postEntity.setContentType("text/json");
            postEntity.setContentEncoding(new BasicHeader("Content-Type", "application/json"));
            httpPost.setEntity(postEntity);
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            result = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            log.error("post请求失败");
        } finally {
            httpPost.abort();
        }
        return result;
    }

    /**
     * 模拟浏览器post请求
     *
     * @param url 请求地址
     * @param map 请求参数
     * @return 返回请求结果
     */
    public static String httpPostWithHtml(String url, Map<String, Object> map) {
        String result = "";
        HttpPost httpPost = new HttpPost(url);
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();

            List<NameValuePair> list = new ArrayList<NameValuePair>();

            for (Map.Entry<String, Object> entry : map.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");
            httpPost.setEntity(urlEncodedFormEntity);

            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            result = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            log.error("post请求失败{}", e);
        } finally {
            httpPost.abort();
        }
        return result;
    }

    /**
     * 设置连接超时时间
     *
     * @param socketTimeout 连接时长，默认10秒
     */
    public void setSocketTimeout(int socketTimeout) {
        resetRequestConfig();
    }

    /**
     * 设置传输超时时间
     *
     * @param connectTimeout 传输时长，默认30秒
     */
    public void setConnectTimeout(int connectTimeout) {
        resetRequestConfig();
    }

    private void resetRequestConfig() {
        requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
    }

    /**
     * 允许商户自己做更高级更复杂的请求器配置
     *
     * @param requestConfig 设置HttpsRequest的请求器配置
     */
    public void setRequestConfig(RequestConfig requestConfig) {
    }

    public interface ResultListener {
        void onConnectionPoolTimeoutError();

    }
}
