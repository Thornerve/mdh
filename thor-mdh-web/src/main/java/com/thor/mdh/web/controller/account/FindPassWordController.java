/*
 * Copyright (C), 2013-2013, 上海汽车集团股份有限公司
 * FileName: FindPassWordController.java
 * Author:   v_xieyuwen
 * Date:     2013年11月27日 下午5:07:39
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.thor.mdh.web.controller.account;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.thor.mdh.api.bean.SecretSecurityBean;
import com.thor.mdh.api.bean.User;
import com.thor.mdh.api.service.account.IFindPassWordService;
import com.thor.mdh.api.service.account.IUpdatePassWordService;
import com.thor.mdh.web.util.RandomValidateCode;

/**
 * 找回密码<br>
 * .
 * 
 * @author v_xieyuwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/account/findPassWord")
public class FindPassWordController {

    /** 日志 */
    private final static Logger logger = LoggerFactory.getLogger(FindPassWordController.class);
	
    /** 找回密码服务 */
    @Autowired
    private IFindPassWordService findPassWordService;

    /** 更新密码服务 */
    @Autowired
    private IUpdatePassWordService updatePassWordService;
    
    /** 用户名session标示. */
    private static final String SESSION_USER_NAME = "SESSION_USER_NAME";
    
    /** 找回密码步骤session标示. */
    private static final String FIND_PASSWORD_STEP = "FIND_PASSWORD_STEP";
    
    /** 找回密码步骤1session标示-- 进入录入用户名和验证码页面. */
    private static final String FIND_PASSWORD_STEP_1 = "FIND_PASSWORD_STEP_1";
    
    /** 找回密码步骤2session标示--输入用户名和验证码. */
    private static final String FIND_PASSWORD_STEP_2 = "FIND_PASSWORD_STEP_2";
    
    /** 找回密码步骤3session标示--输入手机、邮箱、密宝操作. */
    private static final String FIND_PASSWORD_STEP_3 = "FIND_PASSWORD_STEP_3";
    
    /** 找回密码步骤3session标示--修改保存密码. */
    private static final String FIND_PASSWORD_STEP_4 = "FIND_PASSWORD_STEP_4";
    
    /** view */
    private static final String REDIRECT_FIND_PASSWORD_URL = "redirect:/account/findPassWord/passWordUserName.htm";

    /**
     * 进入验证用户页
     * @param user
     * @param secretSecurity
     * @param request
     * @return
     */
    @RequestMapping("/passWordUserName")
    public ModelAndView passWordUserName(@ModelAttribute("userBean") User user,
            							 @ModelAttribute("secretSecurity") SecretSecurityBean secretSecurity, 
            							 HttpServletRequest request) {
    	ModelAndView mv = new ModelAndView("");
        removeFindPasswordSession(request);
        // 设置验证页面为第一步
        request.getSession().setAttribute(FIND_PASSWORD_STEP, FIND_PASSWORD_STEP_1);
        return new ModelAndView("/member/findPassWord.ftl");
    }

    /**
     * 功能描述: 验证用户名找回密码<br>
     * .
     * 
     * @param userBean the user bean
     * @param result the result
     * @param secretSecurity the secret security
     * @param request the request
     * @param model the model
     * @return the model and view
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/findPassWord")
    public ModelAndView findPassWord(@ModelAttribute("userBean") User user,
            						 @ModelAttribute("secretSecurity") SecretSecurityBean secretSecurity, 
            						 HttpServletRequest request, Model model) {
        // 验证是否是通过第一步进入
        HttpSession session = request.getSession();
        String findPasswordStep = (String)session.getAttribute(FIND_PASSWORD_STEP);
        if (findPasswordStep == null || !FIND_PASSWORD_STEP_1.equals(findPasswordStep)) {
            return new ModelAndView(REDIRECT_FIND_PASSWORD_URL);
        }
        model.addAttribute("wenxinmessage", null);
        // 获取登陆参数并验证

        String sessionCode = (String) session.getAttribute(RandomValidateCode.RANDOMCODEKEY);
        if (null == user.getUserName() || "".equals(user.getUserName())) {
            result.rejectValue("userName", null, "用户名不能为空!");
            model.addAttribute("message", 1);
        } else if (user.getUserName().length() < 6) {
            result.rejectValue("userName", null, "用户名请输入6-20位!");
            model.addAttribute("message", 1);
        } else if (user.getUserName().length() > 20) {
            result.rejectValue("userName", null, "用户名请输入6-20位!");
            model.addAttribute("message", 1);
        } else if (null == user.getCheckCode() || "".equals(user.getCheckCode())) {
            result.rejectValue("checkCode", null, "验证码不为空!");
            model.addAttribute("message", 2);
        } else if (!user.getCheckCode().equalsIgnoreCase(sessionCode)) {
            result.rejectValue("checkCode", null, "验证码错误！");
            model.addAttribute("message", 2);
        }

        if (null != user.getUserName() && !"".equals(user.getUserName()) && null != user.getCheckCode()
                && !"".equals(user.getCheckCode()) && user.getCheckCode().equalsIgnoreCase(sessionCode)) {
            // 根据用户名确认名称是否存在
            ResponseVO rvo = findPassWordService
                    .aliasNameIsUsed(user.getUserName(), 1, 1, secretSecurity, user);
            findPassWordService.setUserBeanInfo(user);
            
            model.addAttribute("findmessage", rvo.getRtnCode());
            if (rvo.getRtnCode() == 1) {
                return new ModelAndView("/member/findPassWord.ftl")
                        .addObject("usermessage",
                                "您未绑定邮箱和电话，未设置密保，请重新<a href=\"/account/register.htm\">注册</a>。")
                        .addObject("wenxinmessage", "wenxinmessage");
            } else if (rvo.getRtnCode() > 1 && rvo.getRtnCode() < 9) {
                // 设置找回密码第二步
                session.setAttribute(SESSION_USER_NAME, user.getUserName());
                session.setAttribute(FIND_PASSWORD_STEP, user.getUserName() + "_" + FIND_PASSWORD_STEP_2);
                return new ModelAndView("/member/findPassWordPhone.ftl").addObject("usermessage", rvo.getErrMsg())
                        .addObject("wenxinmessage", null)
                        .addObject("secretSecurity", secretSecurity);
            } else if (rvo.getRtnCode() == 9) {
                model.addAttribute("message", 1);
                model.addAttribute("wenxinmessage", null);
                model.addAttribute("userName", user.getUserName());
                result.rejectValue("userName", null, "用户名不存在!");
                return new ModelAndView("/member/findPassWord.ftl");
            } else {
                return new ModelAndView("/member/findPassWord.ftl");
            }
        } else {
            return new ModelAndView("/member/findPassWord.ftl");
        }
    }

    /**
     * 功能描述: 通过手机找回密码<br>
     * .
     * 
     * @param userBean the user bean
     * @param result the result
     * @param secretSecurity the secret security
     * @param request the request
     * @param model the model
     * @return 1.验证码有误!
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/findPassWordMobile")
    public @ResponseBody
    ModelAndView findPassWordMobile(@ModelAttribute("userBean") @Valid User userBean, BindingResult result,
            @ModelAttribute("secretSecurity") @Valid SecretSecurityBean secretSecurity, HttpServletRequest request,
            Model model) {
        // 验证是否是通过第二步进入
        HttpSession session = request.getSession();
        String findPasswordStep = (String)session.getAttribute(FIND_PASSWORD_STEP);
        String userName = (String)session.getAttribute(SESSION_USER_NAME);
        if (findPasswordStep == null || !(userName + "_" + FIND_PASSWORD_STEP_2 ).equals(findPasswordStep)) {
            return new ModelAndView(REDIRECT_FIND_PASSWORD_URL);
        }
        if (null == userBean.getCheckCode() || "".equals(userBean.getCheckCode())) {
            result.rejectValue("checkCode", null, "验证码不为空!");
            model.addAttribute("tag", 1);
        }
        session.setAttribute(FIND_PASSWORD_STEP, userName + "_" + FIND_PASSWORD_STEP_3);
        return new ModelAndView("/member/reSetPassWord.ftl").addObject("userBean", userBean);

    }

    /**
     * 功能描述: 通过邮箱找回密码<br>
     * .
     * 
     * @param userBean the user bean
     * @param result the result
     * @param secretSecurity the secret security
     * @param request the request
     * @param model the model
     * @return the model and view
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/findPassWordEmail")
    public @ResponseBody
    ModelAndView findPassWordEmail(@ModelAttribute("userBean") @Valid UserBean userBean, BindingResult result,
            @ModelAttribute("secretSecurity") @Valid SecretSecurityBean secretSecurity, HttpServletRequest request,
            Model model) {
        // 验证是否是通过第二步进入
        HttpSession session = request.getSession();
        String findPasswordStep = (String)session.getAttribute(FIND_PASSWORD_STEP);
        String userName = (String)session.getAttribute(SESSION_USER_NAME);
        if (findPasswordStep == null || !(userName + "_" + FIND_PASSWORD_STEP_2 ).equals(findPasswordStep)) {
            return new ModelAndView(REDIRECT_FIND_PASSWORD_URL);
        }
        if (null == userBean.getCheckCode() || "".equals(userBean.getCheckCode())) {
            result.rejectValue("checkCode", null, "验证码不为空!");
            model.addAttribute("tag", 2);
        }
        session.setAttribute(FIND_PASSWORD_STEP, userName + "_" + FIND_PASSWORD_STEP_3);
        return new ModelAndView("/member/reSetPassWord.ftl").addObject("userBean", userBean);
    }

    /**
     * 功能描述: 找回密码(修改密码)<br>
     * .
     * 
     * @param userBean the user bean
     * @param result the result
     * @param secretSecurity the secret security
     * @param model the model
     * @param request the request
     * @return the model and view
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/findPassWordUpdate")
    public @ResponseBody
    ModelAndView findPassWordUpdate(@ModelAttribute("userBean") @Valid UserBean userBean, BindingResult result,
            @ModelAttribute("secretSecurity") @Valid SecretSecurityBean secretSecurity, Model model, HttpServletRequest request) {
        // 验证是否是通过第三步进入
        HttpSession session = request.getSession();
        String findPasswordStep = (String)session.getAttribute(FIND_PASSWORD_STEP);
        String userName = (String)session.getAttribute(SESSION_USER_NAME);
        if (findPasswordStep == null || !(userName + "_" + FIND_PASSWORD_STEP_3 ).equals(findPasswordStep)) {
            return new ModelAndView(REDIRECT_FIND_PASSWORD_URL);
        }
        ResponseVO responseVO = findPassWordService.aliasNameIsUsed(userName, 1, 1, secretSecurity, userBean);
        if (null != userBean.getPassword() && !"".equals(userBean.getPassword())) {
            // 正则表达式 弱、中、强
            int sumStr = updatePassWordService.countWeakMediumStrong(userBean.getPassword());
            if (sumStr < 49) {
                model.addAttribute("pwdline", "pwdline1");
            } else if (50 <= sumStr && sumStr < 60) {
                model.addAttribute("pwdline", "pwdline2");
            } else if (sumStr >= 60) {
                // model.addAttribute("messageCount", "密码强度高等!");
                model.addAttribute("pwdline", "pwdline3");
            }
        }
        if (null == userBean.getPassword() || "".equals(userBean.getPassword())) {
            result.rejectValue("password", null, "新密码不为空!");
            model.addAttribute("pwdline", "");
            model.addAttribute("message", 1);
        } else if (userBean.getPassword().length() < 6) {
            result.rejectValue("password", null, "新密码不能少于六位!");
            model.addAttribute("pwdline", "");
            model.addAttribute("message", 1);
        } else if (null == userBean.getNewPassword() || "".equals(userBean.getNewPassword())) {
            result.rejectValue("newPassword", null, "确认密码不为空!");
            model.addAttribute("message", 2);
        } else if (!userBean.getPassword().equals(userBean.getNewPassword())) {
            result.rejectValue("newPassword", null, "确认密码与新密码不一致!");
            model.addAttribute("message", 2);
        }

        int securityType = -1;
        if (userBean.getPwdstrong() == 0) {
            securityType = 3;
        } else if (userBean.getPwdstrong() == 1) {
            securityType = 2;
        } else if (userBean.getPwdstrong() == 2) {
            securityType = 1;
        } else {
            logger.error(">>>>没有找到对应的securityType");
        }
        
        if (null != userBean.getPassword() && !"".equals(userBean.getPassword()) && null != userBean.getNewPassword()
                && !"".equals(userBean.getNewPassword()) && userBean.getPassword().equals(userBean.getNewPassword())) {
            ResponseVO rvo = findPassWordService.updatePasswd((long) responseVO.getUserId(), userBean.getPassword(),securityType);
            if (rvo.getRtnCode() == 100) {
                session.setAttribute(FIND_PASSWORD_STEP, userBean.getUserName() + "_" + FIND_PASSWORD_STEP_4);
                model.addAttribute("password", userBean.getPassword());
            } else {
                model.addAttribute("pwMessage", "pwMessage");
                result.rejectValue("newPassword", null, rvo.getErrMsg());
            }
        }
        if (result.hasErrors()) {
            return new ModelAndView("/member/reSetPassWord.ftl").addObject("userBean", userBean);
        }
        removeFindPasswordSession(request);
        return new ModelAndView("/member/findPassWordSuc.ftl").addObject("userBean", userBean);

    }

    /**
     * 功能描述: 通过密保找回密码<br>
     * .
     * 
     * @param userBean the user bean
     * @param secretSecurity the secret security
     * @param result the result
     * @param model the model
     * @param request the request
     * @param response the response
     * @return the model and view
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/findPassWordSecretSecurity")
    public @ResponseBody
    ModelAndView findPassWordSecretSecurity(@ModelAttribute("userBean") @Valid UserBean userBean, @ModelAttribute("secretSecurity") @Valid SecretSecurityBean secretSecurity,
            BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) {
        SecretSecurityBean ssb = new SecretSecurityBean();
        // 验证是否是通过第二步进入
        HttpSession session = request.getSession();
        String findPasswordStep = (String)session.getAttribute(FIND_PASSWORD_STEP);
        String userName = (String)session.getAttribute(SESSION_USER_NAME);
        if (findPasswordStep == null || !(userName  + "_" +  FIND_PASSWORD_STEP_2).equals(findPasswordStep)) {
            return new ModelAndView("/member/findPassWord.ftl");
        }
        ResponseVO responseVO = findPassWordService.aliasNameIsUsed(userName, 1, 1, ssb, userBean);
        ResponseVO vo = findPassWordService.verifySecurityInfo((long) responseVO.getUserId(), secretSecurity, 1, null);
        // 100:校验结果正确,101：校验结果失败
        if (vo.getRtnCode() != 100) {
            result.rejectValue("questionThreeValue", null, "答案错误,请输入正确的密保答案！");
            model.addAttribute("secretSecurityMessage", "secretSecurity7");
        }
        if (result.hasErrors()) {
            model.addAttribute("findmessage", request.getParameter("findmessage"));
            return new ModelAndView("/member/findPassWordPhone.ftl").addObject("pageType", "s")
                    .addObject("wenxinmessage", null).addObject("userBean", userBean)
                    .addObject("secretSecurity", secretSecurity);
        }
        session.setAttribute(FIND_PASSWORD_STEP, userName + "_" + FIND_PASSWORD_STEP_3);
        return new ModelAndView("/member/reSetPassWord.ftl").addObject("secretSecurity", secretSecurity);
    }

    /**
     * 清空找回密码流程的临时session.
     * 
     * @param request reques
     */
    private void removeFindPasswordSession(HttpServletRequest request) {
        // 清空找回密码的session
        request.getSession().removeAttribute(SESSION_USER_NAME);
        request.getSession().removeAttribute(FIND_PASSWORD_STEP);
    }
}
