package com.thor.mdh.api.service.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thor.mdh.api.bean.UserBean;
import com.thor.mdh.api.exception.TryNumLimitedException;
import com.thor.mdh.api.exception.UserNotFoundException;

public interface IAccountService {

    /**
	 * 用户登录
	 * @param userName
	 * @param password
	 * @return
	 * @throws UserNotFoundException
	 * @throws TryNumLimitedException
	 */
	public UserBean userLogin(String userName, String password, boolean autoLogin, HttpServletRequest request, HttpServletResponse response) throws UserNotFoundException, TryNumLimitedException;
}
