package com.lj.eshop.eis.dto;

import com.lj.eshop.eis.dto.LoginUserDto;

/**
 * 类说明：当前登录用户缓存.
 *  
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月2日
 */
public class UserTokenThreadLocal {

	private static ThreadLocal<LoginUserDto> userCache = new ThreadLocal<LoginUserDto>();

	public static void set(LoginUserDto v) {
		userCache.set(v);
	}

	/**
	 * 
	 * 清除缓存
	 *
	 */
	public static void clean() {
		if (userCache == null || userCache.get() == null) {
			return;
		}
		userCache.set(null);
	}

	/**
	 * 
	 * 获取用户token信息
	 * 
	 * @return
	 */
	public static LoginUserDto get() {
		return userCache.get();
	}

}
