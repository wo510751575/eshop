package com.lj.eshop.eis.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * 
 * 类说明：
 * 
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年9月26日
 */
public class PropertiesUtil {
    private String properiesName = "";

    private PropertiesUtil() { }
    
    public PropertiesUtil(String fileName) {
        this.properiesName = fileName;
    }
    public String getProperty(String key) {
        String value = "";
        InputStream is = null;
        try {
            is = PropertiesUtil.class.getClassLoader().getResourceAsStream(
                    properiesName);
            Properties p = new Properties();
            p.load(is);
            value = p.getProperty(key);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return value;
    }

    public static void main(String[] args) {
    	PropertiesUtil util = new PropertiesUtil("properties/common.properties");
    	System.out.println(util.getProperty("eoms_url"));
	}



}