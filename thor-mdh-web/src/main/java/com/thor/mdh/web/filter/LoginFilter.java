package com.thor.mdh.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thor.mdh.web.util.RequestUtil;

/**
 * 登陆拦截 ，未登陆阻止 访问
 * @author morlin
 *
 */
public class LoginFilter implements Filter {

	/** 日志 */
	private static Logger logger = LoggerFactory.getLogger(LoginFilter.class);
	
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
        String url = request.getRequestURL().toString();
        logger.info("访问的url:{}", url);
        
        Long userId = RequestUtil.getLoginUserId(request);
        if (null != userId && userId > 0){
        	chain.doFilter(request, response);
        }else{
        	request.getRequestDispatcher("/mdh/index.htm").forward(request, response);
        }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}
}
