package com.thor.mdh.web.controller.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.thor.mdh.api.bean.UserBean;
import com.thor.mdh.api.service.account.IUpdatePassWordService;

/**
 * 修改密码
 * @author morlin
 *
 */
@RestController
@RequestMapping("/account")
public class UpdatePassWordController {
	
    /** 日志 */
    private final static Logger logger = LoggerFactory.getLogger(FindPassWordController.class);

    /** 修改密码服务 */
    @Autowired
    IUpdatePassWordService updatePassWordService;

    /** view */
    private static final String UPDATE_PASSWORD_VIEW = "/account/updatePassWord.ftl";
    private static final String UPDATE_MODIFYPHONE_VIEW = "/account/updateModifyPhone.ftl";
    private static final String UPDATE_MODIFYEMAIL_VIEW = "/account/updateModifyEmail.ftl";
    
   /**
    * 进入修改密码页
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

    @RequestMapping("/updatePasssWord")
    public Boolean updatePassWord(@RequestParam(value = "oldPassWord", required = true)String oldPassWord, 
    							  @RequestParam(value = "password", required = true)String password){
    	
    	return true;
    }

}
