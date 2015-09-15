package com.thor.mdh.web.controller.account;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thor.mdh.web.util.RandomValidateCode;

@RestController
@RequestMapping("/account")
public class ValidateCodeController {

	 /** 日志 */
    private final static Logger logger = LoggerFactory.getLogger(ValidateCodeController.class);
	
	/**
	 * 获取验证码
	 * @param request
	 * @param response
	 */
    @RequestMapping("/validateCode")
    public void validateCode(HttpServletRequest request, HttpServletResponse response) {
        System.setProperty("java.awt.headless", "true");
        response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        RandomValidateCode validateCode = new RandomValidateCode();
        BufferedImage image = validateCode.getValidateImage();
        HttpSession session = request.getSession();
        session.setAttribute(RandomValidateCode.RANDOMCODEKEY, validateCode.getCodeString());
        try {
            ImageIO.write(image, "JPEG", response.getOutputStream());
            System.setProperty("java.awt.headless", "true");
        } catch (IOException e) {
            logger.error("验证码图片出错：{}", e.getMessage());
        }
    }
}
