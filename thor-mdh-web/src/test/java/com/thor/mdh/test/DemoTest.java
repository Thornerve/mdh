package com.thor.mdh.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.thor.mdh.api.bean.UserBean;
import com.thor.mdh.api.dao.IUserDao;

public class DemoTest extends JUnitBaseTest{

	@Autowired
	private IUserDao dao;
	
	@Test
	public void testInsert(){
		UserBean user = new UserBean();
		user.setUserName("test1");
		user.setPassword("123456");
		user.setMobile("18521599872");
		user.setStatus(1);
		user.setUserType(1);
		user.setIdentification(1);
		user.setCreateTime(new Date());
		Long userId = dao.createUser(user);
		System.out.println("userId:" + userId);
	}
	
	@Test
	public void test(){
		//查询未认证用户
    	List<UserBean> queryList = dao.queryUnIdentificationUserList();
    	if(null != queryList && queryList.size() > 0){
    		System.out.println(JSONObject.toJSONString(queryList));
    	}else{
    		System.out.println("查不到数据");
    	}
	}
	
}
