package com.thor.mdh.api.exception;

public class UserNotFoundException extends Exception{

    private static final long serialVersionUID = 8458544317507845657L;

    private String errorMsg;
    
    public UserNotFoundException(){
    	this.setErrorMsg("用户不存在");
    }

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
