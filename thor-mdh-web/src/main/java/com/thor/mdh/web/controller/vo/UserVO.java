package com.thor.mdh.web.controller.vo;

import com.thor.mdh.api.bean.UserBean;

public class UserVO extends UserBean{

	private static final long serialVersionUID = -4961092171301868932L;

	/** 回调url */
	private String backurl;

	public String getBackurl() {
		return backurl;
	}

	public void setBackurl(String backurl) {
		this.backurl = backurl;
	}
}
