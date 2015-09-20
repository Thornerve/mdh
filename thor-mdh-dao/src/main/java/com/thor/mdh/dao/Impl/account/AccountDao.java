package com.thor.mdh.dao.Impl.account;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import com.thor.mdh.api.bean.LoginInfo;
import com.thor.mdh.api.bean.UserBean;
import com.thor.mdh.api.dao.IAccountDao;
import com.thor.mdh.api.exception.TryNumLimitedException;
import com.thor.mdh.api.exception.UserNotFoundException;

@Component
public class AccountDao extends SqlSessionTemplate implements IAccountDao{

	public AccountDao(SqlSessionFactory sqlSessionFactory) {
		super(sqlSessionFactory);
	}

	@Override
	public LoginInfo userLogin(String userName, String password) throws UserNotFoundException, TryNumLimitedException {
		
		int i = 1;
		if(1 == i){
			/** 数据库查询是否存在该用户 */
			throw new UserNotFoundException();
		}else{
			/** 登录错误次数是否达到上限 */
			throw new TryNumLimitedException();
		}
		
	}

	@Override
	public Boolean userInvalidate(Long userId) {
		/** 讲数据状态置为2 */
		return null;
	}

	@Override
	public Long userRegister(UserBean userBean) {
		/** 插入数据 */
		return null;
	}

	@Override
	public Boolean checkMobile(Integer mobile) {
		
		return null;
	}

	@Override
	public Boolean checkEmail(String email) {
		
		return null;
	}
	
}
