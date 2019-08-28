package com.lj.eshop.eis.utils.encryption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lj.base.core.encryption.MD5;

 
/**
 * 
 * 类说明：数据加解密工具类。
 *  
 * 
 * <p>
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月4日
 */
public class EncryptionUtils {
    /** 明文密码最大长度 */
    private static final int PWD_PLAINTEXT_MAX_LENGTH = 16;

    /** 密码加密次数 */
    private static final int PWD_ENCRYPT_TIME = 2;

    /**
     * 调测日志记录器。
     */
    private static final Logger LOG = LoggerFactory.getLogger(EncryptionUtils.class);


    private static String md5(String source) {
        StringBuffer buf = new StringBuffer("");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source.getBytes());
            byte[] b = md.digest();
            int i;
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }

        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return buf.toString();
    }


    /**
     * 32位MD5加密大写
     * 
     * @param source
     * @return
     */
    public static String md5Upper(String source) {
        return md5(source).toUpperCase();
    }


    /**
     * 32位MD5加密小写
     * 
     * @param source
     * @return
     */
    public static String md5Lower(String source) {
        return md5(source).toLowerCase();
    }


    /***
     * 
     * APP端传输加密密码。
     * 
     * @param data
     *            明文
     * @return 密文
     */
    public static String md5TransferPwd(String data) {
        return md5OneTime(data);
    }


    /**
     * 
     * APP端注册用户密码加密方式。
     * 
     * @param data
     *            传输的密文
     * @return 加密后的入库密文
     */
    public static String md5SavePwd(String data) {
        return md5OneTime(data);
    }


    /**
     * 
     * 商户网站密码加密，区分大小写。
     * 
     * @param data
     *            明文
     * @return 密文
     */
    public static String encryptionPwd(String data) {
        String cryptograph = data;
        for (int i = 0; i < PWD_ENCRYPT_TIME; i++) {
            cryptograph = md5OneTime(cryptograph);
        }
        return cryptograph;
    }


    private static String md5OneTime(String data) {

        if (StringUtils.isEmpty(data)) {
            return null;
        }
        String cryptograph = data;
//        if (data.length() > PWD_PLAINTEXT_MAX_LENGTH) {
//            cryptograph = data.substring(0, PWD_PLAINTEXT_MAX_LENGTH);
//        }
        cryptograph = md5Upper(cryptograph);
        return cryptograph;

    }


    /**
     * 
     * AES加密。
     * 
     * @param source
     *            明文字符串
     * @return 加密后的16进制字符串
     */
    public static String aesEncode(String source) {
        return AESUtils.aesEncode(source);
    }


    /**
     * 
     * 解密。
     * 
     * @param encryptData
     *            加密后的16进制字符串
     * @return 明文字符串
     */
    public static String aesDecode(String encryptData) {
        try{
            return AESUtils.aesDecode(encryptData);
        }catch(Exception e){
        	LOG.error("解密错误。",e);
            throw new RuntimeException(e);
        }
	}
	  
 
    /**
     * 和前端MD5加密后保存到数据库
     * 
     * @return
     */
    public static String MD5Swap(String source) {
    	String target = null;
    	
    	if(StringUtils.isNotEmpty(source)){
    		if(source.length() == 32){
    			int indx = source.length()/2;
        		target = source.substring(indx) + source.substring(0, indx);
        		target = target.toUpperCase();
        		
        		target = EncryptionUtils.md5OneTime(target);
    		}else{
    			target = EncryptionUtils.encryptionPwd(source);
    		}
    	}
        return target;
    }
    
    public static void main(String[] args) {
    	String pwd="12345678901234561295Ff";
    	String ljmd5=  MD5.encryptByMD5(MD5.encryptByMD5(pwd));//小写
    	String eismd5= md5TransferPwd(md5TransferPwd(pwd));//大写
    	String eismd52= MD5Utils.getMD5Code(MD5Utils.getMD5Code(pwd));//大写
		System.out.println(ljmd5);
		System.out.println(eismd5);
		System.out.println(eismd52);
	}
}
