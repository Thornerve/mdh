package com.thor.mdh.api.bean;

import java.io.Serializable;
import java.util.Date;

public class LoginInfo implements Serializable{

	private static final long serialVersionUID = 6907602066738224986L;

	private Long id;
	
	/** 返回代码,1 成功,2用户名或密码错误,3 当日失败次数限制 */
    private int rtnCode;

    /** 登陆失败错误信息 */
    private String errMsg;

    /** 登陆成功后返回帐号id */
    private long userId;
    
	/** 登陆失败次数 */
    private int tryNum;
    
    /** 登录时间 */
    private Date loginTime;
    
    public int getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(int rtnCode) {
		this.rtnCode = rtnCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getTryNum() {
		return tryNum;
	}

	public void setTryNum(int tryNum) {
		this.tryNum = tryNum;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
