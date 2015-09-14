package com.thor.mdh.dao.Impl.account;

import org.springframework.stereotype.Component;

import com.thor.mdh.api.bean.LoginInfo;
import com.thor.mdh.api.dao.IAccountDao;
import com.thor.mdh.api.exception.TryNumLimitedException;
import com.thor.mdh.api.exception.UserNotFoundException;

@Component
public class AccountDao implements IAccountDao{

	@Override
	public LoginInfo login(int appCode, String aliasName, String password) throws UserNotFoundException, TryNumLimitedException {
		
		int i = 1;
		if(1 == i){
			throw new UserNotFoundException();
		}else{
			throw new TryNumLimitedException();
		}
		
	}
	
}
