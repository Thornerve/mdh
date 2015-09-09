package com.morlin.thor.menu.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.morlin.thor.menu.bean.Desk;
import com.morlin.thor.menu.dao.IDeskDao;

public class DemoTest extends JUnitBaseTest{

	@Autowired
	private IDeskDao dao;
	
	@Test
	public void test(){
    	List<Desk> queryList = dao.queryList();
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
