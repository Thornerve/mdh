package com.thor.mdh.api.dao;

import java.util.List;

import com.thor.mdh.api.bean.User;

public interface IUserDao {
	
	public List<User> queryList();

}
