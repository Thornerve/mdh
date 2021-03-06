package com.thor.mdh.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thor.mdh.api.bean.LoginInfo;
import com.thor.mdh.api.bean.SessionUser;
import com.thor.mdh.api.bean.UserBean;
import com.thor.mdh.api.dao.IAccountDao;
import com.thor.mdh.api.enums.LoginStatus;
import com.thor.mdh.api.exception.TryNumLimitedException;
import com.thor.mdh.api.exception.UserNotFoundException;
import com.thor.mdh.api.service.account.IAccountService;
import com.thor.mdh.api.util.MD5Util;

/**
 * 账户服务
 * @author liu_yong
 *
 */
@Service
public class AccountServiceImpl implements IAccountService{
	
	@Autowired
	private IAccountDao accountDao;

	/** 日志 */
	private static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	public static final Integer LIMITED_FAILLOGIN_TIMES = 5;
	
	/**
	 * 登陆
	 * @param aliasName
	 * @param password
	 * @param autoLogin
	 * @param request
	 * @param response
	 * @return
	 * @throws TryNumLimitedException 
	 * @throws UserNotFoundException 
	 */
	@Override
	public UserBean userLogin(String userName, String password, boolean autoLogin, HttpServletRequest request, HttpServletResponse response) throws TryNumLimitedException, UserNotFoundException {
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
			return null;
		}
		
		LoginInfo loginInfo = new LoginInfo();
		Long userId = -1l;
		
		/** 查询参数 */
    	Map<String,Object> paramMap = new HashMap<String,Object>();
    	paramMap.put("userName", userName);
    	paramMap.put("password", MD5Util.encodeByMD5(password));
    	/** 登陆查询 */
    	UserBean user = accountDao.userLogin(paramMap);
        if(null == user){
        	logger.error("用户名或密码错误");
        	loginInfo.setRtnCode(LoginStatus.FAILUSERPW.getCode());
        	loginInfo.setErrMsg(LoginStatus.FAILUSERPW.getMsg());
        	throw new UserNotFoundException();
        }else{
        	/** 判断登陆次数是否超过限制 */
        	LoginInfo info = accountDao.queryLoginTimes(user.getUserId());
        	if(null != info){
        		if(info.getTryNum() > LIMITED_FAILLOGIN_TIMES){
        			logger.error("登陆失败次数超过限制");
        			loginInfo.setRtnCode(LoginStatus.TRYLIMIT.getCode());
        			loginInfo.setErrMsg(LoginStatus.TRYLIMIT.getMsg());
        			throw new TryNumLimitedException();
        		}else{
        			/** 登陆成功 */
        			userId = user.getUserId();
        			loginInfo.setRtnCode(LoginStatus.SUCCESS.getCode());
        			loginInfo.setErrMsg(LoginStatus.SUCCESS.getMsg());
        			logger.error("登陆成功 userId：{}", userId);
        		}
        	}
        }
        
        /** 登录记录表中记录登录信息 */
        Long logId = accountDao.insertLoginLog(loginInfo);
        logger.info("记录登录信息,logId:{}", logId);
        
        if (!userId.equals(-1l)) { 
            Cookie cookie = new Cookie(SessionUser.SSOCOOKIE, String.valueOf(userId));
            cookie.setPath("/");
            if (autoLogin) {
                /** 自动登陆,30天有效 */
                cookie.setMaxAge(SessionUser.AVAIL_TIME);
            } else {
                /** 不自动登陆,浏览器关闭cookie无效 */
                cookie.setMaxAge(-1);
            }
            response.addCookie(cookie);
            HttpSession session = request.getSession();
            session.setAttribute(SessionUser.SESSION_USERID, String.valueOf(userId));
        }
        return user;
    }
}
