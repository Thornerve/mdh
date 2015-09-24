package com.thor.mdh.dao.Impl.account;

import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.thor.mdh.api.bean.LoginInfo;
import com.thor.mdh.api.bean.UserBean;
import com.thor.mdh.api.dao.IAccountDao;

/**
 * 用户账户操作持久层
 * @author morlin
 *
 */
@Repository
public class AccountDaoImpl implements IAccountDao{

	@Resource
	private SqlSessionTemplate template;
	
	@Override
	public UserBean userLogin(Map<String,Object> paramMap) {
		UserBean user = template.selectOne("com.thor.mdh.UserMapper.loginUser", paramMap);
		return user;
	}

	@Override
	public LoginInfo queryLoginTimes(Long userId) {
		LoginInfo info = template.selectOne("com.thor.mdh.AccountMapper.loginUserTimes", userId);
		return info;
	}

	@Override
	public Long insertLoginLog(LoginInfo info) {
		int id = template.insert("com.thor.mdh.AccountMapper.insertLoginLog", info);
		return (long) id;
	}

	@Override
	public String queryEmailById(Long userId) {
		String email = template.selectOne("com.thor.mdh.UserMapper.queryEmailByUserId", userId);
		return email;
	}

	@Override
	public String queryMobileById(Long userId) {
		String mobile = template.selectOne("com.thor.mdh.UserMapper.queryMobileByUserId", userId);
		return mobile;
	}

	@Override
	public Long updateUserPassWord(String password, Long userId) {
		int id = template.update("com.thor.mdh.UserMapper.updatePassWordById", userId);
		return (long) id;
	}
}
