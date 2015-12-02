package com.thor.mdh.api.service.account;

/**
 * 找回密码服务
 * @author morlin
 *
 */
public interface IPassWordService {

	/**
	 * 通过手机号找回密码（重置密码）
	 * @param mobile
	 * @param userId
	 * @param newPassWord
	 * @return true:用户对应的手机号正确 成功修改密码  false:用户对应的手机号错误
	 */
	public Boolean findPassWordByMobile(String mobile, Long userId, String newPassWord);
	
	/**
	 * 通过邮箱找回密码（重置密码）
	 * @param email
	 * @param userId
	 * @param newPassWord
	 * @return true:用户对应的邮箱正确 成功修改密码  false:用户对应的邮箱错误
	 */
	public Boolean findPassWordByEmail(String email, Long userId, String newPassWord);
	
	/**
	 * 修改用户密码
	 * @param password
	 * @param userId
	 * @return true:修改成功  false:修改失败
	 */
	public Boolean updatePassWordById(String password, Long userId);

	public Boolean checkMobile(String mobile, Long userId);

	public Boolean checkEmail(String mobile, Long userId);

}
