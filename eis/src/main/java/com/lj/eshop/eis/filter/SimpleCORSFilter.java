package com.lj.eshop.eis.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * 类说明：cors 过滤器
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月14日
 */
@Component
public class SimpleCORSFilter  implements Filter{
	    @Override
		public void destroy() {
	    }
	    @Override
	    public void doFilter(ServletRequest req, ServletResponse res,
	            FilterChain chain) throws IOException, ServletException {
	        HttpServletResponse response = (HttpServletResponse) res;
	        response.setHeader("Access-Control-Allow-Origin", "*");
	        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	        response.setHeader("Access-Control-Max-Age", "3600");
	        response.setHeader("Access-Control-Allow-Headers"," Origin, X-Requested-With, Content-Type, Accept,token,Authorization");
	        chain.doFilter(req, res);
	    }
	    @Override
	    public void init(FilterConfig arg0) throws ServletException {
	    	
	    }
}
