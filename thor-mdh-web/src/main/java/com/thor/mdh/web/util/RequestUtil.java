package com.thor.mdh.web.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * request工具类
 * @author morlin
 *
 */
public class RequestUtil {
	
	/** 日志 */
	private static Logger logger = LoggerFactory.getLogger(RequestUtil.class);
	
	/**
	 * 获取session中userid
	 * @param request
	 * @return
	 */
	public static Long getLoginUserId(HttpServletRequest request){
		Long userId = null;
		try {
			userId = (Long) request.getSession().getAttribute("userId");
		} catch (Exception e) {
			logger.error("获取userId出错：{}", e.getMessage());
		}
		return userId;
	}
}
