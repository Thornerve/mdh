package com.thor.mdh.api.bean;

import java.io.Serializable;

public class UserBean implements Serializable{

	private static final long serialVersionUID = -293714187271317286L;
	
	private String userName;
	
	private String password;
	
	private Integer mobile;
	
	/** 验证码 */
	private String checkCode;
	
	/** 回调url */
	private String backurl;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBackurl() {
		return backurl;
	}

	public void setBackurl(String backurl) {
		this.backurl = backurl;
	}

}
