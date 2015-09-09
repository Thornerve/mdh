package com.thor.mdh.api.bean;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = -293714187271317286L;
	
	private String userName;
	
	private Integer mobile;

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

}
