package com.thor.mdh.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController("/mdh")
public class UserController {
	
	private static final String ERROR_VIEW = "/pc/deal/404.ftl";
	
	@RequestMapping("/error")
	public ModelAndView toErrorView(){
		return new ModelAndView(ERROR_VIEW);
	}

}
