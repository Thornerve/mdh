package com.thor.mdh.api.dao;

import java.util.List;

import com.thor.mdh.api.bean.UserBean;

public interface IUserDao {
	
	public List<UserBean> queryList();

}
