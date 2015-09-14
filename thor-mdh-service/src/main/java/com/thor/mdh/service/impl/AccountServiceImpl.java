package com.thor.mdh.service.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thor.mdh.api.bean.LoginInfo;
import com.thor.mdh.api.bean.SessionUser;
import com.thor.mdh.api.dao.IAccountDao;
import com.thor.mdh.api.exception.TryNumLimitedException;
import com.thor.mdh.api.exception.UserNotFoundException;

/**
 * 账户服务
 * @author liu_yong
 *
 */
@Service
public class AccountServiceImpl {
	
	@Autowired
	private IAccountDao accountDao;

	/** 日志 */
	private static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	public static final String USER_NOTFOUND_ERROR = "用户不存在";
	public static final String LIMITED_FAILLOGIN_ERROR = "登陆失败次数超过限制";
	
	/**
	 * 登陆
	 * @param appCode 渠道（1：后台，2：用户）
	 * @param aliasName
	 * @param password
	 * @param autoLogin
	 * @param request
	 * @param response
	 * @return
	 */
	public LoginInfo login(int appCode, String aliasName, String password, boolean autoLogin,
	            HttpServletRequest request, HttpServletResponse response) {
		LoginInfo loginInfo = new LoginInfo();
		
        long userId = 0L;
        LoginInfo login = null;
        try {
        	login = accountDao.login(appCode, aliasName, password);
        } catch (UserNotFoundException e) {
            loginInfo.setErrMsg(USER_NOTFOUND_ERROR);
            loginInfo.setUserId(userId);
            logger.error("用户存在：{}",e.getErrorMsg());
        } catch (TryNumLimitedException e) {
            loginInfo.setErrMsg(LIMITED_FAILLOGIN_ERROR);
            loginInfo.setUserId(userId);
            logger.error("登陆失败次数超过限制：{}",e.getErrorMsg());
        }

        if(null != login){
        	userId = login.getUserId();
            loginInfo.setRtnCode(login.getRtnCode());
            loginInfo.setErrMsg(login.getErrMsg());
            loginInfo.setUserId(userId);
            loginInfo.setIsModify(login.getIsModify());
            loginInfo.setTryNum(login.getTryNum());
        }
        
        if (userId != 0) { 
            String token = loginInfo.getTokenValue();
            logger.debug("加密的用户id："+token);
            Cookie cookie = new Cookie(SessionUser.SSOCOOKIE, token);
            cookie.setPath("/");
            if (autoLogin) {
                // 自动登陆,30天有效
                cookie.setMaxAge(SessionUser.AVAIL_TIME);
            } else {
                // 不自动登陆,浏览器关闭cookie无效
                cookie.setMaxAge(-1);
            }
            
            response.addCookie(cookie);
            HttpSession session = request.getSession();
            session.setAttribute(SessionUser.SESSION_USERID, String.valueOf(userId));
            
        }
        
        return loginInfo;
    }
	
}
