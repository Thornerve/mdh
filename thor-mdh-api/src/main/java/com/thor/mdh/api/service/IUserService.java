package com.thor.mdh.api.service;

import com.thor.mdh.api.bean.UserBean;

public interface IUserService {

	/** 根据用户Id查询用户 */
	public UserBean finfUserById(Long userId);

}
