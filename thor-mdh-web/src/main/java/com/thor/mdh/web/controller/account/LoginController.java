package com.thor.mdh.web.controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.thor.mdh.api.bean.User;
import com.thor.mdh.api.service.IUserService;
import com.thor.mdh.web.util.RequestUtil;

@RestController
@RequestMapping("/mdh")
public class LoginController {

	/** 日志 */
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private IUserService userService;
	
	/** view */
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
	
	@RequestMapping("/tologin")
	public ModelAndView toLogin(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView(LOGIN_VIEW);
		// 判断验证码是否正确
		String key = (String) request.getSession().getAttribute("key");
		request.getSession().removeAttribute("key"); // 一次性验证码
		
		String checkcode = request.getParameter("checkcode");

		if (key == null || !key.equals(checkcode)) {
			// 验证码错误
			
		}
		return mv;
	}

	/**
	 * 退出登陆
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView(LOGIN_VIEW);
		request.getSession().invalidate();
		return mv;
	}

	/**
	 * 修改密码
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/updatePassword")
	public String updatePassword(HttpServletRequest request) {
		// 从Session获取当前登录用户
		Long userId = RequestUtil.getLoginUserId(request);
		
		
		return "updatePasswordSUCCESS";
	}
	
}
