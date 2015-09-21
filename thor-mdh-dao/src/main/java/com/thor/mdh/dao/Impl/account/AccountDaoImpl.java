package com.thor.mdh.dao.Impl.account;

import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.thor.mdh.api.bean.LoginInfo;
import com.thor.mdh.api.bean.UserBean;
import com.thor.mdh.api.dao.IAccountDao;

@Repository
public class AccountDaoImpl implements IAccountDao{

	@Resource
	private SqlSessionTemplate template;
	
	@Override
	public UserBean userLogin(Map<String,Object> paramMap) {
		UserBean user = template.selectOne("", paramMap);
		return user;
	}

	@Override
	public LoginInfo queryLoginTimes(Long userId) {
		LoginInfo info = template.selectOne("", userId);
		return info;
	}
}
