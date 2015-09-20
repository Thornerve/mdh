package com.thor.mdh.api.dao;

import com.thor.mdh.api.bean.LoginInfo;
import com.thor.mdh.api.bean.UserBean;
import com.thor.mdh.api.exception.TryNumLimitedException;
import com.thor.mdh.api.exception.UserNotFoundException;

public interface IAccountDao {

	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 * @return
	 * @throws UserNotFoundException
	 * @throws TryNumLimitedException
	 */
	public LoginInfo userLogin(String userName, String password) throws UserNotFoundException, TryNumLimitedException;


}
