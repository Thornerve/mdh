package com.thor.mdh.api.dao;

import com.thor.mdh.api.bean.LoginInfo;
import com.thor.mdh.api.bean.UserBean;
import com.thor.mdh.api.exception.TryNumLimitedException;
import com.thor.mdh.api.exception.UserNotFoundException;

public interface IAccountDao {

	/**
	 * 用户登录
	 * @param aliasName
	 * @param password
	 * @return
	 * @throws UserNotFoundException
	 * @throws TryNumLimitedException
	 */
	public LoginInfo userLogin(String aliasName, String password) throws UserNotFoundException, TryNumLimitedException;

	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
	public Boolean userInvalidate(Long userId);

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
