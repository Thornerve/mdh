package com.thor.mdh.api.dao;

import com.thor.mdh.api.bean.LoginInfo;
import com.thor.mdh.api.exception.TryNumLimitedException;
import com.thor.mdh.api.exception.UserNotFoundException;

public interface IAccountDao {

	public LoginInfo login(int appCode, String aliasName, String password) throws UserNotFoundException, TryNumLimitedException;

}
