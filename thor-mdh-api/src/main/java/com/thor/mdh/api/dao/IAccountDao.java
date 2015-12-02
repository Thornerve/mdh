package com.thor.mdh.api.dao;

import java.util.Map;

import com.thor.mdh.api.bean.UserBean;
import com.thor.mdh.api.vo.LoginInfo;

/**
 * 用户账户持久层
 * @author morlin
 *
 */
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
	
	/**
	 * 根据用户id查找邮箱
	 * @param userId
	 * @return
	 */
	public String queryEmailById(Long userId);
	
	/**
	 * 根据用户id查找手机
	 * @param userId
	 * @return
	 */
	public String queryMobileById(Long userId);
	
	/**
	 * 更新用户密码
	 * @param password
	 * @return
	 */
	public Long updateUserPassWord(String password, Long userId);

}
