package com.thor.mdh.api.service;

import java.util.List;

import com.thor.mdh.api.bean.UserBean;

public interface IUserService {
	
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
	 * 查询手机号是否存在
	 * @param mobile
	 * @return
	 */
	public Boolean queryMobileExist(String mobile);
	
	/**
	 * 查询邮箱是否存在
	 * @param mobile
	 * @return
	 */
	public Boolean queryEmailExist(String email);
	
	/**
	 * 更新用户邮箱
	 * @param paramMap
	 * @return
	 */
	public Long updateUserEmail(String email, Long userId);
	
	/**
	 * 更新用户手机
	 * @param paramMap
	 * @return
	 */
	public Long updateUserMobile(String mobile, Long userId);
	
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
