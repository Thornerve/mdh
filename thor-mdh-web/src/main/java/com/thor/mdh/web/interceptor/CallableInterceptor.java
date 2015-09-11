package com.thor.mdh.web.interceptor;

import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;

public class CallableInterceptor implements CallableProcessingInterceptor {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	/* (non-Javadoc)
	 * @see org.springframework.web.context.request.async.CallableProcessingInterceptor#beforeConcurrentHandling(org.springframework.web.context.request.NativeWebRequest, java.util.concurrent.Callable)
	 */
	@Override
	public <T> void beforeConcurrentHandling(NativeWebRequest request,
			Callable<T> task) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.springframework.web.context.request.async.CallableProcessingInterceptor#preProcess(org.springframework.web.context.request.NativeWebRequest, java.util.concurrent.Callable)
	 */
	@Override
	public <T> void preProcess(NativeWebRequest request, Callable<T> task)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.springframework.web.context.request.async.CallableProcessingInterceptor#postProcess(org.springframework.web.context.request.NativeWebRequest, java.util.concurrent.Callable, java.lang.Object)
	 */
	@Override
	public <T> void postProcess(NativeWebRequest request, Callable<T> task,
			Object concurrentResult) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.springframework.web.context.request.async.CallableProcessingInterceptor#handleTimeout(org.springframework.web.context.request.NativeWebRequest, java.util.concurrent.Callable)
	 */
	@Override
	public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task)
			throws Exception {
		logger.error(task.toString() + "请求超时");
		HttpServletResponse response = request.getNativeResponse(HttpServletResponse.class);
		//请求未提交，即未返回客户端
		if(!response.isCommitted()){
			response.setStatus(HttpServletResponse.SC_REQUEST_TIMEOUT);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.context.request.async.CallableProcessingInterceptor#afterCompletion(org.springframework.web.context.request.NativeWebRequest, java.util.concurrent.Callable)
	 */
	@Override
	public <T> void afterCompletion(NativeWebRequest request, Callable<T> task)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
