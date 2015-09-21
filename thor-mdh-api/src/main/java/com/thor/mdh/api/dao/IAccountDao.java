package com.thor.mdh.api.dao;

import java.util.Map;

import com.thor.mdh.api.bean.LoginInfo;
import com.thor.mdh.api.bean.UserBean;

public interface IAccountDao {

	/**
	 * 用户登录
	 * @param paramMap
	 * @return
	 */
	public UserBean userLogin(Map<String,Object> paramMap);
	
	/**
	 * 查询登陆失败次数
	 * @param userId
	 * @return
	 */
	public LoginInfo queryLoginTimes(Long userId);
	
	/**
	 * 记录登录信息
	 * @param info
	 * @return
	 */
	public Long insertLoginLog(LoginInfo info);

}
