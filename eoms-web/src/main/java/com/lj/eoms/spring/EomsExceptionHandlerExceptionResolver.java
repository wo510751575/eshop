/**
 * 
 */
package com.lj.eoms.spring;

import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.lj.eoms.dto.ResponseDto;

/**
 * 
 * 
 * 类说明：系统异常处理类。
 * 
 * 
 * <p>
 * 详细描述：
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年8月18日
 */
public class EomsExceptionHandlerExceptionResolver extends
		ExceptionHandlerExceptionResolver {
	private static Logger log = Logger
			.getLogger(EomsExceptionHandlerExceptionResolver.class);

	private String defaultErrorView;

	private Properties exceptionMappings;

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
		// 获取action方法
		Method method = handlerMethod.getMethod();
		if (method == null) {
			return null;
		}
		ResponseBody responseBody = AnnotationUtils.findAnnotation(method,
				ResponseBody.class);
		// 如果action方法定义了ResponseBody注解，则发生异常时返回json格式字符串
		if (responseBody != null) {
			ResponseDto rs = ResponseDto.generateFailureResponse(exception);
			return new ModelAndView(new MappingJackson2JsonView(),
					getResultMap(rs));
		}
		String viewName = determineViewName(exception, request);
		return getModelAndView(viewName, exception);
	}

	protected String determineViewName(Exception ex, HttpServletRequest request) {
		String viewName = null;
		// Check for specific exception mappings.
		if (this.exceptionMappings != null) {
			viewName = findMatchingViewName(this.exceptionMappings, ex);
		}
		// Return default error view else, if defined.
		if (viewName == null && this.defaultErrorView != null) {
			if (logger.isDebugEnabled()) {
				logger.debug("Resolving to default view '"
						+ this.defaultErrorView + "' for exception of type ["
						+ ex.getClass().getName() + "]");
			}
			viewName = this.defaultErrorView;
		}
		return viewName;
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

	protected String findMatchingViewName(Properties exceptionMappings,
			Exception ex) {
		String viewName = null;
		String dominantMapping = null;
		int deepest = Integer.MAX_VALUE;
		for (Enumeration<?> names = exceptionMappings.propertyNames(); names
				.hasMoreElements();) {
			String exceptionMapping = (String) names.nextElement();
			int depth = getDepth(exceptionMapping, ex);
			if (depth >= 0
					&& (depth < deepest || (depth == deepest
							&& dominantMapping != null && exceptionMapping
							.length() > dominantMapping.length()))) {
				deepest = depth;
				dominantMapping = exceptionMapping;
				viewName = exceptionMappings.getProperty(exceptionMapping);
			}
		}
		if (viewName != null && logger.isDebugEnabled()) {
			logger.debug("Resolving to view '" + viewName
					+ "' for exception of type [" + ex.getClass().getName()
					+ "], based on exception mapping [" + dominantMapping + "]");
		}
		return viewName;
	}

	protected int getDepth(String exceptionMapping, Exception ex) {
		return getDepth(exceptionMapping, ex.getClass(), 0);
	}

	private int getDepth(String exceptionMapping, Class<?> exceptionClass,
			int depth) {
		if (exceptionClass.getName().contains(exceptionMapping)) {
			// Found it!
			return depth;
		}
		// If we've gone as far as we can go and haven't found it...
		if (exceptionClass == Throwable.class) {
			return -1;
		}
		return getDepth(exceptionMapping, exceptionClass.getSuperclass(),
				depth + 1);
	}

	public String getDefaultErrorView() {
		return defaultErrorView;
	}

	public void setDefaultErrorView(String defaultErrorView) {
		this.defaultErrorView = defaultErrorView;
	}

	protected ModelAndView getModelAndView(String viewName, Exception ex,
			HttpServletRequest request) {
		return getModelAndView(viewName, ex);
	}

	protected ModelAndView getModelAndView(String viewName, Exception ex) {
		ModelAndView mv = new ModelAndView(viewName);
		return mv;
	}

	/**
	 * @return the exceptionMappings
	 */
	public Properties getExceptionMappings() {
		return exceptionMappings;
	}

	/**
	 * @param exceptionMappings the exceptionMappings to set
	 */
	public void setExceptionMappings(Properties exceptionMappings) {
		this.exceptionMappings = exceptionMappings;
	}

}
