package com.thor.mdh.api.exception;

public class TryNumLimitedException extends Exception{
	
	private static final long serialVersionUID = -4646022419215662135L;
	
    private String errorMsg;
    
    public TryNumLimitedException(){
    	this.setErrorMsg("登陆失败次数超过限制");
    }

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
