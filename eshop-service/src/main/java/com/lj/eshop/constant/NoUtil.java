package com.lj.eshop.constant;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Date;

import com.lj.base.core.util.DateUtils;

public class NoUtil {
	
	/**默认押金2000*/
	public static BigDecimal DEFAULT_CASH_PLEDGE = new BigDecimal(2000);

	/**
	 * 珠宝前缀
	 */
	public static final String JY = "JY";
	
	private static SecureRandom random = new SecureRandom();
	
	/**
	 * 
	 *
	 * 方法说明：生成NO编号规则：业务前缀+yyyyMMddHHmmss+5位随机数
	 *	TODO 待优化，高并发可能重复
	 * @param preStr
	 * @return
	 *
	 * @author 段志鹏 CreateDate: 2017年8月28日
	 *
	 */
	public static String generateNo(String preStr){
		try {
			String dataStr=	DateUtils.formatDate(new Date(), DateUtils.PATTERN_yyyyMMddHHmmss);
			int randomNum = random.nextInt(99999);
			return preStr+dataStr+randomNum;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static void main(String[] args) {
		System.out.println(NoUtil.generateNo(NoUtil.JY));
	}
}
