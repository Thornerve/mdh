package com.thor.mdh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thor.mdh.api.bean.UserBean;
import com.thor.mdh.api.dao.IUserDao;
import com.thor.mdh.api.service.IUserService;

/**
 * 用户服务
 * @author morlin
 *
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService{

	@Resource
	private IUserDao userDao;
	
	@Override
	public UserBean finfUserById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
