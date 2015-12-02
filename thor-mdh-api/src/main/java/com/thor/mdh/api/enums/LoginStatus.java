package com.thor.mdh.api.enums;

/**
 * 登录状态枚举
 * @author morlin
 *
 */
public enum LoginStatus {

	/** 登录成功 */
	SUCCESS(1, "登录成功"),
	
	/** 用户名或密码错误 */
	FAILUSERPW(2, "用户名或密码错误"),
	
	/** 当日失败次数限制 */
	TRYLIMIT(3, "当日失败次数限制");
	
	private Integer code;
	
	private String msg;
	
	private LoginStatus(Integer code, String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
