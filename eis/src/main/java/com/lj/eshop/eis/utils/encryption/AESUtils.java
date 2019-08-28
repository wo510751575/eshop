package com.lj.eshop.eis.utils.encryption;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月4日
 */
public class AESUtils {

    /**
     * 调测日志记录器。
     */
    private static final Logger LOG = LoggerFactory.getLogger(AESUtils.class);

    /**
     * 密钥算法
     */
    private static final String KEY_ALGORITHM = "AES";

    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    /** 系统ASE密钥，常量不可变动, 发布后切勿随意修改 */
    private static final String AES_KEY_CHAR = "dddddd";

    private static final String GGG_KEY_CHAR = "zhongguo";

    /** 系统ASE密钥，常量不可变动 */
    private static final Key DEFAULT_AES_KEY = AESUtils.getAESKey(AES_KEY_CHAR);

    private static final Key LOTTERY_AES_KEY = AESUtils.getAESKey(GGG_KEY_CHAR);
    /** 系统DES传输签名密钥，常量不可变动 */
    private static final String USER_SIGN_KEY = "YAMPLMKA";
    /** 系统DES存贮签名密钥，常量不可变动 */
    private static final String USER_SIGN_KEY_TO_DB = "YAMZXASD";
    
    /**
     * 
     * AES加密。
     * 
     * @param source
     *            明文字符串
     * @return 加密后的16进制字符串
     */
    public static String aesEncode(String source) {
        Key k = DEFAULT_AES_KEY;
        byte[] encryptData = null;
        try {
            encryptData = AESUtils.encrypt(source.getBytes(), k);
        }
        catch (Exception e) {
            LOG.error("aesEncode faild!", e);
            throw new RuntimeException(e);
        }
        return AESUtils.bytes2Hex(encryptData);
    }


    /**
     * 
     * 彩票AES加密。
     * 
     * @param source
     *            明文字符串
     * @return 加密后的16进制字符串
     */
    public static String lotteryEncode(String source) {
        Key k = LOTTERY_AES_KEY;
        byte[] encryptData = null;
        try {
            encryptData = AESUtils.encrypt(source.getBytes(), k);
        }
        catch (Exception e) {
            LOG.error("aesEncode faild!", e);
            throw new RuntimeException(e);
        }
        return AESUtils.bytes2Hex(encryptData);
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
        Key k = DEFAULT_AES_KEY;
        byte[] decryptData = null;
        try {
            byte[] encryptByte = AESUtils.hex2Bytes(encryptData);
            decryptData = AESUtils.decrypt(encryptByte, k);
        }
        catch (Exception e) {
            e.printStackTrace();
            LOG.error("aesDecode faild!", e);
            throw new RuntimeException(e);
        }
        return new String(decryptData);
    }


    /**
     * 
     * 添加方法注释。
     * 
     * @param password
     * @return
     */
    public static Key getAESKey(String password) {
        byte[] key = initSecretKey(password);
        Key k = toKey(key);
        return k;
    }


    /**
     * 
     * AES加密
     * 
     * @param source
     * @param k
     * @return
     */
    public static byte[] aesEncode(String source, Key k) {

        try {
            byte[] e = encrypt(source.getBytes(), k);
            return e;
        }
        catch (Exception e) {
            LOG.error("aesEncode faild!", e);
            throw new RuntimeException(e);
        }
    }


    /**
     * 初始化密钥
     *
     * @return byte[] 密钥
     * @throws Exception
     */
    public static byte[] initSecretKey(String password) {
        // 返回生成指定算法的秘密密钥的 KeyGenerator 对象
        KeyGenerator kg = null;
        SecureRandom secureRandom;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new byte[0];
        }
        secureRandom.setSeed(password.getBytes());
        // 初始化此密钥生成器，使其具有确定的密钥大小
        // AES 要求密钥长度为 128
        // kg.init(128, new SecureRandom(password.getBytes()));
        kg.init(128, secureRandom);
        // 生成一个密钥
        SecretKey secretKey = kg.generateKey();
        return secretKey.getEncoded();
    }


    /**
     * 转换密钥
     *
     * @param key
     *            二进制密钥
     * @return 密钥
     */
    private static Key toKey(byte[] key) {
        // 生成密钥
        return new SecretKeySpec(key, KEY_ALGORITHM);
    }


    /**
     * 加密
     *
     * @param data
     *            待加密数据
     * @param key
     *            密钥
     * @return byte[] 加密数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, Key key) throws Exception {
        return encrypt(data, key, DEFAULT_CIPHER_ALGORITHM);
    }


    /**
     * 加密
     *
     * @param data
     *            待加密数据
     * @param key
     *            二进制密钥
     * @return byte[] 加密数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        return encrypt(data, key, DEFAULT_CIPHER_ALGORITHM);
    }


    /**
     * 加密
     *
     * @param data
     *            待加密数据
     * @param key
     *            二进制密钥
     * @param cipherAlgorithm
     *            加密算法/工作模式/填充方式
     * @return byte[] 加密数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, byte[] key, String cipherAlgorithm) throws Exception {
        // 还原密钥
        Key k = toKey(key);
        return encrypt(data, k, cipherAlgorithm);
    }


    /**
     * 加密
     *
     * @param data
     *            待加密数据
     * @param key
     *            密钥
     * @param cipherAlgorithm
     *            加密算法/工作模式/填充方式
     * @return byte[] 加密数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, Key key, String cipherAlgorithm) throws Exception {
        // 实例化
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        // 使用密钥初始化，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // 执行操作
        return cipher.doFinal(data);
    }


    /**
     * 解密
     *
     * @param data
     *            待解密数据
     * @param key
     *            二进制密钥
     * @return byte[] 解密数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        return decrypt(data, key, DEFAULT_CIPHER_ALGORITHM);
    }


    /**
     * 解密
     *
     * @param data
     *            待解密数据
     * @param key
     *            密钥
     * @return byte[] 解密数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, Key key) throws Exception {
        return decrypt(data, key, DEFAULT_CIPHER_ALGORITHM);
    }


    /**
     * 解密
     *
     * @param data
     *            待解密数据
     * @param key
     *            二进制密钥
     * @param cipherAlgorithm
     *            加密算法/工作模式/填充方式
     * @return byte[] 解密数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, byte[] key, String cipherAlgorithm) throws Exception {
        // 还原密钥
        Key k = toKey(key);
        return decrypt(data, k, cipherAlgorithm);
    }


    /**
     * 解密
     *
     * @param data
     *            待解密数据
     * @param key
     *            密钥
     * @param cipherAlgorithm
     *            加密算法/工作模式/填充方式
     * @return byte[] 解密数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, Key key, String cipherAlgorithm) throws Exception {
        // 实例化
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        // 使用密钥初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, key);
        // 执行操作
        return cipher.doFinal(data);
    }


    /**
     * 
     * AES解密
     * 
     * @param encrypt
     * @param k
     * @return
     */
    public static String aesDecode(byte[] encrypt, Key k) {
        byte[] decryptData = null;
        try {
            decryptData = decrypt(encrypt, k);
        }
        catch (Exception e) {
            LOG.error("aesDecode faild!", e);
            throw new RuntimeException(e);
        }
        return new String(decryptData);
    }


    /**
     * 字节数组转hex字符串
     */
    public static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = Integer.toHexString(bts[i] & 0xFF);
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des.toUpperCase();
    }


    private static byte toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }


    /**
     * hex字符串转字节数组
     */
    public static byte[] hex2Bytes(String hex) {
        int len = hex.length() / 2;
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    // public static void main(String[] args) {
    // String e = AESUtils.aesEncode("zhangsan");
    // }
    
    /**
     * 用户密钥加密存贮。
     * @param source
     *            明文字符串
     * @return 加密后的16进制字符串
     */
    public static String encodeUserSignKeyToDB(String source) {
        try {
            return DESUtils.encrypt(source, USER_SIGN_KEY_TO_DB);
        }
        catch (Exception e) {
            LOG.error("Failed to encodeUserSignKey", e);
            throw new RuntimeException(e);
        }
    }
    
    /**
     * 用户密钥加密传输。
     * @param source 数据库存贮的加密密钥
     * @return 加密后的16进制字符串
     */
    public static String encodeUserSignKey(String source) {
        try {
            String blockKey=decryptUserSignKey(source);//先解密
            return DESUtils.encrypt(blockKey, USER_SIGN_KEY);//再用传输密钥加密
        }
        catch (Exception e) {
            LOG.error("Failed to encodeUserSignKey", e);
            throw new RuntimeException(e);
        }
    }
    /**
     * 解密用户密钥。
     * @param encryptData
     *            加密后的16进制字符串
     * @return 明文字符串
     */
    public static String decryptUserSignKey(String encryptData) { 
        try {
            return DESUtils.decrypt(encryptData,USER_SIGN_KEY_TO_DB);
        }
        catch (Exception e) {
                LOG.error("Failed to decryptUserSignKey", e);
                throw new RuntimeException(e);
        }
    }
}
