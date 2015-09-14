package com.thor.mdh.api.service.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thor.mdh.api.bean.LoginInfo;

public interface IAccountService {

	/**
     * 功能描述: 用户登录<br>
     * 〈功能详细描述〉.
     * 
     * @param appCode appId 主站的为1
     * @param aliasName 用户名
     * @param password the password
     * @param autoLogin 是否保存密码
     * @param request the request
     * @param response the response
     * @return request response
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    LoginInfo userLogin(int appCode, String aliasName, String password, boolean autoLogin, HttpServletRequest request,
            HttpServletResponse response);

    /**
     * 功能描述: 用户注销<br>
     * .
     * 
     * @param userId the user id
     * @param request the request
     * @param response the response
     * @return true, if successful
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean userLogout(long userId, HttpServletRequest request, HttpServletResponse response);
}
