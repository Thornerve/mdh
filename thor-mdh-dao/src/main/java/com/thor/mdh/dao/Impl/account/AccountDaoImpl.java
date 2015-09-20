package com.thor.mdh.dao.Impl.account;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.thor.mdh.api.bean.LoginInfo;
import com.thor.mdh.api.bean.UserBean;
import com.thor.mdh.api.dao.IAccountDao;
import com.thor.mdh.api.exception.TryNumLimitedException;
import com.thor.mdh.api.exception.UserNotFoundException;

@Repository
public class AccountDaoImpl implements IAccountDao{

	@Resource
	private SqlSessionTemplate template;
	
	@Override
	public LoginInfo userLogin(String userName, String password) throws UserNotFoundException, TryNumLimitedException {
		
		Object selectOne = template.selectOne("", "");
		int i = 1;
		if(1 == i){
			/** 数据库查询是否存在该用户 */
			throw new UserNotFoundException();
		}else{
			/** 登录错误次数是否达到上限 */
			throw new TryNumLimitedException();
		}
		
	}
}
