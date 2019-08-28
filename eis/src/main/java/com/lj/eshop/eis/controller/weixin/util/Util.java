package com.lj.eshop.eis.controller.weixin.util;

import com.lj.eshop.eis.controller.weixin.dto.WxPayResDataDto;
import com.thoughtworks.xstream.XStream;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Map;

 /**
  * 公用
  * <p>
  *   
  * @Company: 深圳扬恩科技有限公司
  * @author lhy
  *   
  * CreateDate: 2017年9月8日
  */
public class Util {

    //打log用
    private static Logger logger = LoggerFactory.getLogger(Util.class);

    /**
     * 通过反射的方式遍历对象的属性和属性值，方便调试
     *
     * @param o 要遍历的对象
     * @throws Exception
     */
    public static void reflect(Object o) throws Exception {
        Class cls = o.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            Field f = fields[i];
            f.setAccessible(true);
//            Util.log(f.getName() + " -> " + f.get(o));
        }
    }

    public static byte[] readInput(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int len;
        byte[] buffer = new byte[1024];
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        out.close();
        in.close();
        return out.toByteArray();
    }

    public static String inputStreamToString(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i;
        while ((i = is.read()) != -1) {
            baos.write(i);
        }
        return baos.toString();
    }


    public static InputStream getStringStream(String sInputString) throws UnsupportedEncodingException {
        ByteArrayInputStream tInputStringStream = null;
        if (sInputString != null && !sInputString.trim().equals("")) {
            tInputStringStream = new ByteArrayInputStream(sInputString.getBytes("UTF-8"));
        }
        return tInputStringStream;
    }

    public static Object getObjectFromXML(String xml, Class tClass) {
        //将从API返回的XML数据映射到Java对象
        XStream xStreamForResponseData = new XStream();
        xStreamForResponseData.alias("xml", tClass);
        xStreamForResponseData.ignoreUnknownElements();//暂时忽略掉一些新增的字段
        return xStreamForResponseData.fromXML(xml);
    }

    public static String getStringFromMap(Map<String, Object> map, String key, String defaultValue) {
        if (StringUtils.isBlank(key)) {
            return defaultValue;
        }
        String result = (String) map.get(key);
        if (result == null) {
            return defaultValue;
        } else {
            return result;
        }
    }

    public static int getIntFromMap(Map<String, Object> map, String key) {
        if (StringUtils.isBlank(key)) {
            return 0;
        }
        if (map.get(key) == null) {
            return 0;
        }
        return Integer.parseInt((String) map.get(key));
    }

    /**
     * 打log接口
     *
     * @param log 要打印的log字符串
     * @return 返回log
     */
    public static String log(Object log) {
        return log.toString();
    }

    /**
     * 读取本地的xml数据，一般用来自测用
     *
     * @param localPath 本地xml文件路径
     * @return 读到的xml字符串
     */
    public static String getLocalXMLString(String localPath) throws IOException {
        return Util.inputStreamToString(Util.class.getResourceAsStream(localPath));
    }

    public static void main(String[] args) {
		String xml="<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[mch_id参数格式错误]]></return_msg></xml>";
		// 转换返回数据
		WxPayResDataDto payResData = (WxPayResDataDto) Util
				.getObjectFromXML(xml, WxPayResDataDto.class);
		System.out.println("getErr_code:"+payResData.getErr_code());
		System.out.println("getErr_code_des:"+payResData.getErr_code_des());
		System.out.println("return_msg:"+payResData.getReturn_msg());
	}
}

