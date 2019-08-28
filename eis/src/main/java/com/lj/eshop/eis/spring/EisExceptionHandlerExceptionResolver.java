/**
 * 
 */
package com.lj.eshop.eis.spring;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.lj.eshop.eis.dto.ResponseDto;


/**
 * 
 * 
 * 类说明:统一异常处理。
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy  CreateDate: 2017年8月18日
 */
public class EisExceptionHandlerExceptionResolver extends
		ExceptionHandlerExceptionResolver {
	private static Logger log = Logger.getLogger(EisExceptionHandlerExceptionResolver.class);

	private String defaultErrorView;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.mvc.method.annotation.
	 * ExceptionHandlerExceptionResolver
	 * #doResolveHandlerMethodException(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse,
	 * org.springframework.web.method.HandlerMethod, java.lang.Exception)
	 */
	@Override
	protected ModelAndView doResolveHandlerMethodException(
			HttpServletRequest request, HttpServletResponse response,
			HandlerMethod handlerMethod, Exception exception) {
		log.error("【抛出异常】异常路径为：" + request.getServletPath(), exception);
		if (handlerMethod == null) {
			return null;
		}
		ResponseDto rs= ResponseDto.generateFailureResponse(exception);
		return new ModelAndView(new MappingJackson2JsonView(),getResultMap(rs) );
//		// 获取action方法
//		Method method = handlerMethod.getMethod();
//		if (method == null) {
//			return null;
//		}
//		ResponseBody responseBody = AnnotationUtils.findAnnotation(method,
//				ResponseBody.class);
//		// 如果action方法定义了ResponseBody注解，则发生异常时返回json格式字符串
//		if (responseBody != null) {
//			ResponseDto rs= ResponseDto.generateFailureResponse(exception);
//			return new ModelAndView(new MappingJackson2JsonView(),getResultMap(rs) );
//		}
//		// 否则创建ModleAndView，处理该异常。
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", exception);
//        mav.addObject("url", request.getRequestURL());
//        mav.setViewName(defaultErrorView);
//        return mav;
	}
	
	 @SuppressWarnings("serial")
	    private Map<String, Object> getResultMap(final ResponseDto dto) {
	        return new HashMap<String, Object>() {
	            {
	                put("code", dto.getCode());
	                put("msg", dto.getMsg());
	                put("result", dto.isResult());
	            }
	        };
	    }

	public String getDefaultErrorView() {
		return defaultErrorView;
	}

	public void setDefaultErrorView(String defaultErrorView) {
		this.defaultErrorView = defaultErrorView;
	}

}
