package com.thor.mdh.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.thor.mdh.api.bean.User;
import com.thor.mdh.api.dao.IUserDao;

public class DemoTest extends JUnitBaseTest{

	@Autowired
	private IUserDao dao;
	
	@Test
	public void test(){
    	List<User> queryList = dao.queryList();
    	if(null != queryList && queryList.size() > 0){
    		System.out.println(JSONObject.toJSONString(queryList));
    	}else{
    		System.out.println("查不到数据");
    	}
	}
	
	@Test
	public void test1(){
		
	}
}
