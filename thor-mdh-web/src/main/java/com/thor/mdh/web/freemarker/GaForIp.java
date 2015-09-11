package com.thor.mdh.web.freemarker;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.thor.mdh.api.util.AccessClientIpUtil;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

public class GaForIp implements TemplateMethodModel {
	@Autowired
	private HttpServletRequest request;

	/** 默认IP. */
    private final static String IP_DEFAULT = "0.0.0.0" ;

    @SuppressWarnings("rawtypes")
	@Override
	public Object exec(List arguments) throws TemplateModelException {
		String ip = StringUtils.EMPTY;

        ip = AccessClientIpUtil.getClientIp(request);
        
        if (null == ip || "".equals(ip)) {
        	ip = IP_DEFAULT;
        }
        System.out.println("ip:" +ip);
        return ip;
	}

}
