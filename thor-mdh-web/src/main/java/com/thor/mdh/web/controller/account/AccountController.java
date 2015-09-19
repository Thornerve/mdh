package com.thor.mdh.web.controller.account;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.thor.mdh.api.bean.LoginInfo;
import com.thor.mdh.api.bean.UserBean;
import com.thor.mdh.api.service.IUserService;
import com.thor.mdh.api.service.account.IAccountService;
import com.thor.mdh.web.controller.vo.UserVO;
import com.thor.mdh.web.util.RandomValidateCode;

/**
 * 用户登录注册
 * @author morlin
 *
 */
@RestController
@RequestMapping("/account")
public class AccountController {

	/** 日志 */
	private static Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IAccountService accountService;
	
	/** view */
	private static final String LOGIN_VIEW = "/index/login.ftl";
	private static final String REGISTER_VIEW = "/index/register.ftl";
	
    /** 密码次数超过限制 返回代码 */
    private final static int loginRtnCodeError = 101;
    /** 登陆次数超过限制 返回代码 */
    private final static int loginRtnCodeLimit = 102;
    
	/**
	 * 跳转到登录界面
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView toLoginView(HttpServletRequest request){
		ModelAndView mv = new ModelAndView(LOGIN_VIEW);
	 	String backUrl = request.getParameter("backUrl");
        if(backUrl != null){
            backUrl = backUrl.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("/'", "&quot;");
        }
		return mv.addObject("backUrl", backUrl);
	}
	
	/**
	 * 登录
	 * @param request
	 * @param user
	 * @param response
	 * @return
	 */
	@RequestMapping("/tologin")
	public ModelAndView toLogin(HttpServletRequest request, @RequestParam UserVO user, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView(LOGIN_VIEW);
		/** 判断验证码是否正确 */
        String validCode = (String) request.getSession().getAttribute(RandomValidateCode.RANDOMCODEKEY);
        request.getSession().removeAttribute(RandomValidateCode.RANDOMCODEKEY);

        if (!user.getCheckCode().equalsIgnoreCase(validCode)) {
            return new ModelAndView(LOGIN_VIEW).addObject("message", "验证码输入有误！");
        }
        
        /** 调用接口 验证用户登陆 */
        LoginInfo loginInfo = accountService.userLogin(user.getUserName(), user.getPassword(), true, request, response);

        if (loginInfo.getRtnCode() == loginRtnCodeError) {
            return new ModelAndView(LOGIN_VIEW).addObject("message", "您输入的用户名或密码不正确！");
        } else if (loginInfo.getRtnCode() == loginRtnCodeLimit) {
            return new ModelAndView(LOGIN_VIEW).addObject("message", "该账户登录出错次数已达上限，请24小时后重试！");
        }
        
        /** 用户回调用url */
        if (null == user.getBackurl() || "".equals(user.getBackurl())) {
            return new ModelAndView("redirect:/index.htm");
        } else {
            try {
				URLDecoder.decode(user.getBackurl(), "UTF-8");
				response.sendRedirect(user.getBackurl());
			} catch (UnsupportedEncodingException e) {
				logger.error("url解码异常：{}", e.getMessage());
			} catch (IOException e) {
				logger.error("io异常：{}", e.getMessage());
			}
            return mv;
        }
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
	 * 跳转到注册页面
	 * @return
	 */
	@RequestMapping("/register")
	public ModelAndView toRegisterView(){
		ModelAndView mv = new ModelAndView(REGISTER_VIEW);
		
		return mv;
	}
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	@RequestMapping("toregister")
	public Boolean toRegister(@RequestParam UserBean userBean){
		userBean.setCreateTime(new Date());
		Long userId = accountService.userRegister(userBean);
		return userId > 0;
	}
	
    /**
     * 前端验证手机号码是否存在
     * @param request
     * @return
     */
    @RequestMapping("/checkMobile")
    public Boolean checkMobile(@RequestParam(value = "mobile" , required = true)Integer mobile) {
    	return accountService.checkMobile(mobile);
    }
    
    /**
     * 前端验证邮箱是否存在
     * @param request
     * @return
     */
    @RequestMapping("/checkEmail")
    public Boolean checkEmail(@RequestParam(value = "email" , required = true) String email) {
    	return accountService.checkEmail(email);
    }
    
    
}
