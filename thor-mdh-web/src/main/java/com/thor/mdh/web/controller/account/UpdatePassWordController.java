/*
 * Copyright (C), 2013-2013, 上海汽车集团股份有限公司
 * FileName: UpdatePassWordController.java
 * Author:   v_xieyuwen
 * Date:     2013年11月29日 下午3:39:40
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.thor.mdh.web.controller.account;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.thor.mdh.api.bean.UserBean;
import com.thor.mdh.api.service.account.IFindPassWordService;
import com.thor.mdh.api.service.account.IUpdatePassWordService;

/**
 * 修改密码
 * @author morlin
 *
 */
@Controller
@RequestMapping("/account")
public class UpdatePassWordController {

    /** 修改密码服务 */
    @Autowired
    IUpdatePassWordService updatePassWordService;

    /** 找回密码服务 */
    @Autowired
    IFindPassWordService findPassWordService;

    /** view */
    private static final String UPDATE_PASSWORD_VIEW = "/account/updatePassWord.ftl";
    private static final String UPDATE_MODIFYPHONE_VIEW = "/account/updateModifyPhone.ftl";
    private static final String UPDATE_MODIFYEMAIL_VIEW = "/account/updateModifyEmail.ftl";
    
   /**
    * 进入密码验证页
    * @param user
    * @return
    */
    @RequestMapping("/passWordLogin")
    public ModelAndView passWordLogin(@ModelAttribute("userBean") UserBean user) {
    	ModelAndView mv = new ModelAndView(UPDATE_PASSWORD_VIEW);
    	
        return mv;
    }

    /**
     * 进入手机验证页
     * @param userBean
     * @return
     */
    @RequestMapping("/passWordMobile")
    public ModelAndView passWordMobile(@ModelAttribute("userBean") UserBean userBean) {
    	ModelAndView mv = new ModelAndView(UPDATE_MODIFYPHONE_VIEW);
    	
        return mv;
    }

   /**
    * 进入邮箱验证页
    * @param userBean
    * @return
    */
    @RequestMapping("/passWordEmail")
    public ModelAndView passWordEmail(@ModelAttribute("userBean") UserBean userBean) {
    	ModelAndView mv = new ModelAndView(UPDATE_MODIFYEMAIL_VIEW);
        return mv;
    }

    /**
     * 功能描述: 登录密码<br>
     * .
     * 
     * @param userBean the user bean
     * @param result the result
     * @param model the model
     * @return the model and view
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/validationcUpdatePassWordUp")
    public @ResponseBody
    ModelAndView validationcUpdatePassWordUp(@ModelAttribute("userBean") @Valid UserBean userBean,
            BindingResult result, Model model) {
        if (null == userBean.getPassword() || "".equals(userBean.getPassword())) {
            result.rejectValue("password", null, "请输入您的密码！");
            model.addAttribute("message", 0);
        } else if (userBean.getPassword().length() < 6) {
            result.rejectValue("password", null, "密码不能少于六位!");
            model.addAttribute("message", 0);
        }
        if (null != userBean.getPassword() && !"".equals(userBean.getPassword())
                && userBean.getPassword().length() >= 6) {
            ResponseVO rvo = updatePassWordService.validatePassword(1L, 1, userBean.getUserName(),
                    userBean.getPassword());
            if (rvo.getRtnCode() != 100) {
                result.rejectValue("password", null, rvo.getErrMsg());
                model.addAttribute("message", 0);
            }
        }
        if (result.hasErrors()) {
            return new ModelAndView("/member/updatePassWordUp.ftl");
        }
        return new ModelAndView("/member/updatePassWord.ftl").addObject("userBean", userBean);
    }

    /**
     * 功能描述: 跳入修改密码页<br>
     * .
     * 
     * @param userBean the user bean
     * @param result the result
     * @param request the request
     * @return the model and view
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/updatePassWord")
    public String updatePassWord(@ModelAttribute("userBean") UserBean userBean, BindingResult result, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute(AccountSecurityController.UPDATE_PASSWORD_2) == null || 
                !AccountSecurityController.UPDATE_PASSWORD_2.equals(session.getAttribute(AccountSecurityController.UPDATE_PASSWORD_2))){
            return "redirect:/member/accountSecurity/accountSecurityJudge.htm?pg=MODPWD";
        }else{
            session.setAttribute(AccountSecurityController.UPDATE_PASSWORD_3, AccountSecurityController.UPDATE_PASSWORD_3);
            return "/member/updatePassWord.ftl";
        }
    }

    /**
     * 功能描述: 用户修改密码<br>
     * .
     * 
     * @param userBean the user bean
     * @param request the request
     * @param response the response
     * @param result the result
     * @param model the model
     * @return the model and view
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/validationcPassWord")
    public @ResponseBody
    ModelAndView validationcPassWord(@ModelAttribute("userBean") UserBean userBean, HttpServletRequest request,
            HttpServletResponse response, BindingResult result, Model model) {

        if (null != userBean.getOldPassword() && !"".equals(userBean.getOldPassword())) {
            // 正则表达式 弱、中、强
            int sumStr = updatePassWordService.countWeakMediumStrong(userBean.getOldPassword());
            if (sumStr < 49) {
                // model.addAttribute("messageCount", "密码强度弱!");
                model.addAttribute("pwdline", "pwdline1");
            } else if (50 <= sumStr && sumStr < 60) {
                // model.addAttribute("messageCount", "密码强度中等!");
                model.addAttribute("pwdline", "pwdline2");
            } else if (sumStr >= 60) {
                // model.addAttribute("messageCount", "密码强度高等!");
                model.addAttribute("pwdline", "pwdline3");
            }
        }

        if (null == userBean.getOldPassword() || "".equals(userBean.getOldPassword())) {
            result.rejectValue("oldPassword", null, "新密码不为空!");
            model.addAttribute("message", 1);
        } else if (userBean.getOldPassword().length() < 6) {
            result.rejectValue("oldPassword", null, "新密码不能少于六位!");
            model.addAttribute("message", 1);
        } else if (userBean.getOldPassword().length() > 16) {
            result.rejectValue("oldPassword", null, "新密码已经超过16位!");
            model.addAttribute("message", 1);
        } else if (null == userBean.getNewPassword() || "".equals(userBean.getNewPassword())) {
            result.rejectValue("newPassword", null, "确认密码不为空!");
            model.addAttribute("message", 2);
        } else if (!userBean.getOldPassword().equals(userBean.getNewPassword())) {
            result.rejectValue("newPassword", null, "确认密码与新密码不一致!");
            model.addAttribute("message", 2);
        }
        //判断新密码是否和原密码相同
        String userid = (String) request.getSession().getAttribute("userid");
        String userName = "";
        ResponseVO responseVo = updatePassWordService.validatePassword(Long.parseLong(userid),1,userName, userBean.getOldPassword());
        if(responseVo.getRtnCode() == 100){
        	result.rejectValue("oldPassword", null, "密码不得与原密码相同！");
            model.addAttribute("message", 1);
        }      
        // 如果没有按照步骤操作
        HttpSession session = request.getSession();
        if(session.getAttribute(AccountSecurityController.UPDATE_PASSWORD_3) == null || 
                !AccountSecurityController.UPDATE_PASSWORD_3.equals(session.getAttribute(AccountSecurityController.UPDATE_PASSWORD_3))){
            return new ModelAndView("redirect:/member/accountSecurity/accountSecurityJudge.htm?pg=MODPWD");
        }
        
        int securityType = -1;
        if (userBean.getPwdstrong() == 0) {
            securityType = 3;
        } else if (userBean.getPwdstrong() == 1) {
            securityType = 2;
        } else if (userBean.getPwdstrong() == 2) {
            securityType = 1;
        } 
        
        if (!userBean.getPassword().equals(userBean.getNewPassword())
                && !userBean.getPassword().equals(userBean.getOldPassword())) {
            ResponseVO rvo = updatePassWordService.verifyOldPasswdAndUpdatePasswd(Long.parseLong(userid),1, userBean.getOldPassword(),
                    userBean.getPassword(),securityType);
            if (rvo.getRtnCode() != 100) {
                result.rejectValue("password", null, rvo.getErrMsg());
                model.addAttribute("message", 0);
            }
        } 
        if (result.hasErrors()) {
            return new ModelAndView("/member/updatePassWord.ftl").addObject("originalPassword", userBean.getPassword());
        }

        session.removeAttribute(AccountSecurityController.UPDATE_PASSWORD_1);
        session.removeAttribute(AccountSecurityController.UPDATE_PASSWORD_2);
        session.removeAttribute(AccountSecurityController.UPDATE_PASSWORD_3);
        return new ModelAndView("/member/updatePassWordSuc.ftl").addObject("userBean", userBean);
    }

    /**
     * 功能描述: 通过手机获取验证码<br>
     * .
     * 
     * @param basicInfo the basic info
     * @param result the result
     * @param model the model
     * @param request the request
     * @param response the response
     * @return the string
     * @throws IOException Signals that an I/O exception has occurred.
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/validationcPassWordGetMobile")
    public String validationcPassWordGetMobile(@ModelAttribute("basicInfo") @Valid BasicPersonalInfoBean basicInfo,
            BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter outPrintWriter = response.getWriter();
        outPrintWriter.write(1);

        return "";
    }

    /**
     * 功能描述: 通过邮箱获取验证码<br>
     * .
     * 
     * @param basicInfo the basic info
     * @param result the result
     * @param model the model
     * @return the model and view
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/validationcPassWordGetEmail")
    public @ResponseBody
    ModelAndView updatePassWordGetEmail(@ModelAttribute("basicInfo") @Valid BasicPersonalInfoBean basicInfo,
            BindingResult result, Model model) {
        //TODO 此方法没有页面请求调用
        ResponseVO rvo = updatePassWordService.reqCheckCode(new Long(basicInfo.getUserId() + ""), 2, "");
        if (rvo.getRtnCode() == 100) {
            model.addAttribute("countdown", 1000 * 60);
        } else {
            result.rejectValue("countdown", null, "获取验证码失败!");
        }

        if (result.hasErrors()) {
            return new ModelAndView("/member/updatePassWord.ftl");
        }
        return new ModelAndView("/member/updatePassWordSuc.ftl").addObject("basicInfo", basicInfo);
    }


}
