/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.utils;

import com.lj.eshop.eis.utils.encryption.MD5Utils;

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
 *         CreateDate: 2017年9月2日
 */
public class TokenUtils {
	/** token 有效期 2周 （单位 秒） */
	public final static int VALID_TIME=1209600;

	/**
	 * 方法说明：创建TOKEN。
	 * @param mbrCode 会员CODE 
	 * @param shopCode 店铺CODE 无店可传null
	 * @return
	 *
	 * @author lhy  2017年9月2日
	 *
	 */
	public static String createToken(String mbrCode, String shopCode) {
		long now = System.currentTimeMillis();
		if (shopCode == null) {
			shopCode = "";
		}

		String source =  mbrCode + ":" + shopCode + ":" + now;
		String token = MD5Utils.getMD5Code(source);
				//EncryptionUtils.aesEncode(source);
		return token;
	}
}
