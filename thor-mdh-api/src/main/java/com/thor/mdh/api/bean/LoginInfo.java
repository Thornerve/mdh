package com.thor.mdh.api.bean;

import java.io.Serializable;

public class LoginInfo implements Serializable{

	private static final long serialVersionUID = 6907602066738224986L;

	/** 返回代码,100 成功,101 用户名或密码错误, 102 当日失败次数限制,105 用户帐户未激活 */
    private int rtnCode;

    /** 登陆失败错误信息 */
    private String errMsg;

    /** 登陆成功后返回帐号id */
    private long userId;
    
    /** 用户名是否可以修改,1:能修改,0:不能修改 */
    private int isModify;
    
    /** 加密的用户id，用在session中传递 */
    private String tokenValue;
    
	/** 登陆失败次数 */
    private int tryNum;
    
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

	public int getIsModify() {
		return isModify;
	}

	public void setIsModify(int isModify) {
		this.isModify = isModify;
	}

	public String getTokenValue() {
		return tokenValue;
	}

	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}

	public int getTryNum() {
		return tryNum;
	}

	public void setTryNum(int tryNum) {
		this.tryNum = tryNum;
	}

}
