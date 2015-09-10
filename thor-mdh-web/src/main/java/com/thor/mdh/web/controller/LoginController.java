package com.thor.mdh.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/mdh")
public class LoginController {

	private static final String LOGIN_VIEW = "/index/login.ftl";
	
	/**
	 * 跳转到登录界面
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView toLoginView(){
		ModelAndView mv = new ModelAndView(LOGIN_VIEW);
		
		return mv;
	}
	
}
