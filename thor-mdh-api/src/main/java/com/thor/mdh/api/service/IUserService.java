package com.thor.mdh.api.service;

import com.thor.mdh.api.bean.User;

public interface IUserService {

	/** 根据用户Id查询用户 */
	public User finfUserById(Long userId);

}
