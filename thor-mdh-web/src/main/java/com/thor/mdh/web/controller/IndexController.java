package com.thor.mdh.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping
public class IndexController {
	
	/** 日志 */
	private static Logger logger = LoggerFactory.getLogger(IndexController.class);

	/** view */
	private static final String INDEX_VIEW = "/index/index.ftl";
	
	@RequestMapping("/index")
	public ModelAndView toIndex(){
		ModelAndView mv = new ModelAndView(INDEX_VIEW);
		
		return mv;
	}
}
