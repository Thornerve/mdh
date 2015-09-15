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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.thor.mdh.api.service.account.IFindPassWordService;

/**
 * 找回密码
 * @author morlin
 *
 */
@RestController
@RequestMapping("/account")
public class FindPassWordController {

    /** 日志 */
    private final static Logger logger = LoggerFactory.getLogger(FindPassWordController.class);
	
    /** 找回密码服务 */
    @Autowired
    private IFindPassWordService findPassWordService;

    /** view */
    private static final String FIND_PASSWORD_VIEW = "/account/findPassWord.ftl";

    /**
     * 进入验证用户页
     */
    public ModelAndView toFindPassWordView(){
    	ModelAndView mv = new ModelAndView(FIND_PASSWORD_VIEW);
    	
    	return mv;
    }

    /**
     * 通过手机找回密码
     */
    

    /**
     * 通过邮箱找回密码
     */


}
