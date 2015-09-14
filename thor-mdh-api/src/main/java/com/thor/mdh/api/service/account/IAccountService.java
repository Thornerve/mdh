package com.thor.mdh.api.service.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thor.mdh.api.bean.LoginInfo;
import com.thor.mdh.api.bean.UserBean;

public interface IAccountService {

	/**
     * 用户登录
     * @param aliasName 用户名
     * @param password 密码
     * @param autoLogin 是否保存密码
     * @param request the request
     * @param response the response
     * @return 登录信息
     */
    public LoginInfo userLogin(String aliasName, String password, boolean autoLogin, HttpServletRequest request,
            HttpServletResponse response);

    /**
     * 删除用户
     * @param userId 用户id
     * @return true, if successful
     */
    public boolean userInvalidate(Long userId);
    
    /**
     * 用户注册
     * @param userBean
     * @return userid
     */
    public Long userRegister(UserBean userBean);

    /**
     * 校验手机号是否存在
     * @param mobile
     * @return
     */
	public Boolean checkMobile(Integer mobile);

	/**
	 * 校验邮箱是否存在
	 * @param email
	 * @return
	 */
	public Boolean checkEmail(String email);
}
