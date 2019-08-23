package com.lj.eshop.eis.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lj.base.exception.TsfaServiceException;
import com.lj.eshop.eis.constant.LoginRoleConstant;
import com.lj.eshop.eis.dto.LoginUserDto;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.UserTokenThreadLocal;
import com.lj.eshop.eis.service.IUserLoginService;


/**
 * 
 * 类说明：鉴权拦截器。
 *  
 * 
 * <p>
 *   
 * @Company: 领居科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月2日
 */
public class TokenHandlerInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory
			.getLogger(TokenHandlerInterceptor.class);
	
	@Autowired
	private IUserLoginService userLoginService;
		
	/** key =访问地址  ,value= 权限类型 */
	private Map<String , String> permissions;
	/**  1:仅B端登录访问 */
	private static final String B_LOGIN="1";
	/**  2:仅C端登录访问 */
	private static final String C_LOGIN="2";
	/**  3:仅APP登录 */
	private static final String B_APP_LOGIN="3";
	/**
	 * 前置拦截处理逻辑，验证用户是否登录
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info(new StringBuilder("URL:")
					.append(request.getRequestURL()).append(",servletURI:")
					.append(request.getServletPath()).append(",method:")
					.append(request.getMethod().toUpperCase()).toString());
		}
		String method=request.getMethod().toUpperCase();
		if("OPTIONS".equals(method)){//OPTIONS 不校验
			return true;
		}
		String url =request.getServletPath();
		String token = request.getHeader("token");//从消息头里获取token
		logger.info("登录token:"+token);
		// 鉴权及获取登录用户信息
		checkUser(token,url);
		return true;
	}
	
	/**
	 * 方法说明：检测权限 
	 * @param url 访问的链接
	 * @param permissionTypes 接口访问权
	 * @param role 当前用户登录角色
	 *
	 * @author lhy  2017年9月20日
	 *
	 */
	private static void checkPermission(String url,String permissionTypes,String role){
		String rolePermission = null;
		if (LoginRoleConstant.IS_B.equals(role)) {
			rolePermission = B_LOGIN;
		} else if (LoginRoleConstant.IS_C.equals(role)) {
			rolePermission = C_LOGIN;
		} else if (LoginRoleConstant.IS_B_APP.equals(role)) {
			rolePermission = B_APP_LOGIN;
		}
		String pers = ("," + permissionTypes + ",");
		rolePermission = ("," + rolePermission + ",");
		if (pers.indexOf(rolePermission) == -1) {
			String msg = "角色[" + role + "]无权限操作接口:" + url;
			throw new TsfaServiceException(ResponseCode.NO_PERMISSION.getCode(), msg);
		}
	}
	
	private void checkUser(String token,String url){
		LoginUserDto user=userLoginService.getCurrLoginUser(token);
		String permissionType=permissions.get(url);
		if(StringUtils.isNotBlank(permissionType)){
			if(user==null){//需要登录未登录则提示(包含所有（B C 都需要登录的接口）)
				throw new TsfaServiceException(ResponseCode.UN_LOGIN.getCode(), ResponseCode.UN_LOGIN.getMsg());
			}
			//检测权限
			checkPermission(url, permissionType, user.getRole());
		}else{
			//不需要登录验证的权限，则不作处理。
		}
		UserTokenThreadLocal.set(user);
		if (user != null) {
			logger.info("已登录,用户登录信息:"+user.getMember().getCode());
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 请求线程完成之后，清空token本地线程变量
		UserTokenThreadLocal.clean();
	}


	/**
	 * @param permissions the permissions to set
	 */
	public void setPermissions(Map<String, String> permissions) {
		this.permissions = permissions;
	}

}
