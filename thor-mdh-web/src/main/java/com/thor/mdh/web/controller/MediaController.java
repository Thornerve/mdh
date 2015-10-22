package com.thor.mdh.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/media")
public class MediaController {

	private static final String midea_view = "/pc/index/media.ftl";
	
	@RequestMapping("/video")
	public ModelAndView getVideoData(){
		ModelAndView mv = new ModelAndView(midea_view);
		
		return mv;
	}
}
