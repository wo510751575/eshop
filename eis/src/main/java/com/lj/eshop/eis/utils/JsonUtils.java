package com.lj.eshop.eis.utils;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


/**
 * 
 * 类说明：JSON工具类
 *  
 * 
 * <p>
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月2日
 */
public class JsonUtils {
    private static ObjectMapper objectMapper = null;

    /**
     * 调测日志记录器。
     */
    private static final Logger LOG = LoggerFactory.getLogger(JsonUtils.class);
    
    static {
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

        //objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true) ;
    }


    public static void main(String[] args) {
        Map<String, Object> a = new HashMap<String, Object>();
        a.put("d", null);
        System.out.println(JsonUtils.toJSON(a));
        String a1 = "{\"id\":\"1919,2299,2308,2310,2312,2313,2314,2315,2316,2317,2318,2319,2320,2322,2324,2336,2374\",\"deviceNo\":\"16116121101\",\"key\":\"2e345b610b93e2634ab09df415417a99fad44f6ef512,8fe06583c8bd8acfcc81d5\",\"wifiSN\":\"18V23F22K6\",\"time\":1461569910530,\"ip\":\"0:0:0:0:0:0:0:1\",\"imsi\":\"xx\",\"count\":\"1,2,3,2,1,3,1,2,3,2,1,3,1,2,3,2,1\",\"md5\":\"5f0de905842e580865449500b01a9826,2072118124b85e990d8a3d34414b2461,1ec8453fb7d1701a0dbd0b9c90e34a2d,0000fe5fd515861bcc87c50b32b7234a,1dfa927289e4ad9d67afb463d31e0cc3,331353ad93ae45b91935272945f09f55,b19a826ba1e1bc71931157c1f4d67654\",\"clientType\":2,\"installs\":0,\"shopId\":0,\"empId\":0,\"reqLog\":\"request-url:http://localhost:93/route/store/V1/up/app?wifiSN=18V23F22K6&imei=16116121101&count=1,2,3,2,1,3,1,2,3,2,1,3,1,2,3,2,1&imsi=xx&id=1919,2299,2308,2310,2312,2313,2314,2315,2316,2317,2318,2319,2320,2322,2324,2336,2374&md5=5f0de905842e580865449500b01a9826,2072118124b85e990d8a3d34414b2461,1ec8453fb7d1701a0dbd0b9c90e34a2d,0000fe5fd515861bcc87c50b32b7234a,1dfa927289e4ad9d67afb463d31e0cc3,331353ad93ae45b91935272945f09f55,b19a826ba1e1bc71931157c1f4d67654&key=2e345b610b93e2634ab09df415417a99fad44f6ef512,8fe06583c8bd8acfcc81d5,request-time:2016-04-25 15:38:30.532,request-method:GET,UserAgent:Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.109 Safari/537.36\"}";


    }


    /**
     * 
     * 对象转JSON
     * 
     * @param value
     * @return
     */
    public static String toJSON(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getStr(String json, String v) {

        String error = null;
        JsonNode rootNode = null;
        if (StringUtils.isNotBlank(json)) {
            try {
				rootNode = objectMapper.readValue(json, JsonNode.class);
			} catch (IOException e) {
				LOG.error("JSON解析异常",e);
				 throw new RuntimeException(e);
			}
        }
        if (null != rootNode) {
            if (rootNode.path(v).isArray() || rootNode.path(v).isContainerNode()) {
                error = rootNode.path(v).toString();
            }
            else if (rootNode.path(v).isValueNode()) {
                error = rootNode.path(v).textValue();
            }
        }
        if ("null".equalsIgnoreCase(error)) {
            error = null;
        }
        return error;
    }


    /**
     * 
     * 处理对象输出带换行空格格式的JSON字符串，用于记录日志。
     * 
     * { "code" : "", "desc" : "" }
     * 
     * @param o
     * @return
     */
    public static String stringify(Object o) {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        printer.indentArraysWith(new DefaultIndenter());
        try {
            return objectMapper.writer(printer).writeValueAsString(o);
        }
        catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 
     * JSON转对象
     * 
     * @param json
     * @param type
     * @return
     */
    public static <T> T toObj(String json, Class<T> type) {
        try {
            return objectMapper.readValue(json, type);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T toObj(byte[] bs, Class<T> type) {
        try {
            return objectMapper.readValue(bs, type);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * json字符串转化为list
     * 
     * @param <T>
     * @param content
     * @return
     * @throws IOException
     */
    public static <T> List<T> toJavaBeanList(String content, TypeReference<List<T>> typeReference) {
        try {
            return objectMapper.readValue(content, typeReference);
        }
        catch (JsonParseException e) {
            throw new RuntimeException("json to list error.", e);
        }
        catch (JsonMappingException e) {
            throw new RuntimeException("json to list error.", e);
        }
        catch (IOException e) {
            throw new RuntimeException("json to list error.", e);
        }
    }


    /**
     * 
     * 对象tostring
     * 
     * @param o
     * @return
     */
    public static String toString(Object o) {
        StringBuffer sb = new StringBuffer();
        sb.append("{").append(o.getClass().getSimpleName()).append(":").append(toJSON(o)).append("}");
        return sb.toString();
    }


    
    /**
     * 			集合转String
     * @param o
     * @return
     */
    public static String listToString(Object o) {
        StringBuffer sb = new StringBuffer();
        sb.append(o.getClass().getSimpleName()).append(":").append(toJSON(o));
        return sb.toString();
    }

}
