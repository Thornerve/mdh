package com.thor.mdh.dao.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.thor.mdh.api.bean.UserBean;
import com.thor.mdh.api.dao.IUserDao;

/**
 * 用户持久层
 * @author morlin
 *
 */
@Repository
public class UserDaoImpl implements IUserDao{

	@Resource
	private SqlSessionTemplate template;
	
	@Override
	public Long createUser(UserBean user) {
		int userId = template.insert("com.thor.mdh.UserMapper.insertUser", user);
		return (long) userId;
	}

	@Override
	public UserBean queryUserById(Long userId) {
		UserBean user = template.selectOne("com.thor.mdh.UserMapper.queryUserByID", userId);
		return user;
	}

	@Override
	public List<UserBean> queryUnIdentificationUserList() {
		List<UserBean> userList = template.selectList("com.thor.mdh.UserMapper.queryUnIdentificationUserList");
		return userList;
	}

	@Override
	public Long updateUserIdentification(Long userId) {
		template.update("com.thor.mdh.UserMapper.updateUserIdentificationById", userId);
		return null;
	}

	@Override
	public Long deleteUserById(Long userId) {
		int id = template.update("com.thor.mdh.UserMapper.deleteUserById", userId);
		return (long) id;
	}

	@Override
	public UserBean queryMobileExist(String mobile) {
		UserBean user = template.selectOne("com.thor.mdh.UserMapper.queryMobileExist", mobile);
		return user;
	}

	@Override
	public UserBean queryEmailExist(String email) {
		UserBean user = template.selectOne("com.thor.mdh.UserMapper.queryEmailExist", email);
		return user;
	}

	@Override
	public Long updateUserEmail(Map<String, Object> paramMap) {
		int userId = template.update("com.thor.mdh.UserMapper.updateUserEmailById", paramMap);
		return (long) userId;
	}

	@Override
	public Long updateUserMobile(Map<String, Object> paramMap) {
		int userId = template.update("com.thor.mdh.UserMapper.updateUserMobileById", paramMap);
		return (long) userId;
	}

}
