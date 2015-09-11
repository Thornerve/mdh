package com.thor.mdh.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class ExceptionHandle extends SimpleMappingExceptionResolver{

	 private static Logger logger = LoggerFactory.getLogger("EXCEPTION-LOG");
	    
    /* (non-Javadoc)
     * @see com.ibm.framework.web.exception.ErrorCodeMappingExceptionResolver#doResolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
     */
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex) {
        logger.error("请求--" + request.getRequestURL().toString() + "--发生异常 : ", ex);
        return super.doResolveException(request, response, handler, ex);
    }
}
