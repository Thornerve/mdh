package com.thor.mdh.api.dao;

import java.util.List;

import com.thor.mdh.api.bean.UserBean;

public interface IUserDao {

	/**
	 * 创建用户
	 * @param user
	 * @return
	 */
	public Long createUser(UserBean user);
	
	/**
	 * 根据id查询用户
	 * @param userId
	 * @return
	 */
	public UserBean queryUserById(Long userId);

	/**
	 * 查询未认证用户
	 * @return
	 */
	public List<UserBean> queryUnIdentificationUserList();
	
	/**
	 * 认证用户
	 * @param userId
	 * @return
	 */
	public Long updateUserIdentification(Long userId);
	
	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
	public Long deleteUserById(Long userId);
}
