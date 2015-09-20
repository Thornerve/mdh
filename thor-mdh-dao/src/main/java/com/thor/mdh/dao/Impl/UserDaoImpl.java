package com.thor.mdh.dao.Impl;

import java.util.List;

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

}
